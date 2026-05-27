# Ninja School 1 — Save layout (FROZEN)

**Status:** Documentation-only freeze of the format as implemented in `a.a()` / `a.b()` (May 2026).  
**Do not change** field order, counts, encoding, or RMS record name without a versioned migration plan.

**Code names:** `a.java` field identifiers use the **Review name** column below (save slot order unchanged).  
Exceptions: `io` → `mapObjAnim`, `in` → `mapObjFacing` (avoid `java.io` / string `in` clashes); private `hp` (non-save combat) → `scriptHitGauge`.

| Property | Value |
|----------|--------|
| RMS record store | `ninjasave` (record #1) |
| Exists flag | `saved` — 1 byte, `1` = has save (`Midlet.a(boolean)` / `Midlet.b()`) |
| Write entrypoint | `a.a()` |
| Full load | `a.b()` (when `Midlet.e` after Continue) |
| Partial load | Menu Continue — indices **0–14** only (`a.java` ~10545–10562) |
| In-memory buffer | `int[500]` on save |
| **On-disk size** | **Always `500 × 4 = 2000` bytes** (entire buffer serialized; unused slots are `0`) |
| Int encoding | Big-endian 32-bit per element (`a(byte[])` / tail of `a()`) |

---

## 1. Save anatomy (blocks)

```
┌─────────────────────────────────────────────────────────────────┐
│ FIXED BLOCK — indices 0..158 (159 slots) — always present       │
├─────────────────────────────────────────────────────────────────┤
│ VARIABLE BLOCK A — map objects — only if saved ij > 0         │
│   6 × ij ints (see §4)                                          │
├─────────────────────────────────────────────────────────────────┤
│ VARIABLE BLOCK B header — 1 int: ir (NPC bundle count)        │
│   always written (even when ir == 0)                            │
├─────────────────────────────────────────────────────────────────┤
│ VARIABLE BLOCK B body — only if ir > 0                          │
│   1 + 7×ir ints (is + seven NPC arrays)                         │
├─────────────────────────────────────────────────────────────────┤
│ TAIL BLOCK — up to 4 ints — optional on old files               │
│   khinhCongCap3, dashLearned, amSatLearned, dashLevel           │
│   (load guarded by var0.length > cursor)                        │
├─────────────────────────────────────────────────────────────────┤
│ PADDING — indices (last logical + 1) .. 499 = 0                 │
└─────────────────────────────────────────────────────────────────┘
```

**Logical cursor after minimal save** (`ij=0`, `ir=0`): tail at indices **160–163**, then zeros through **499**.

---

## 2. Review names (code field → human alias)

| Review name (Java in `a.java`) | Was (obfuscated) |
|--------------------------------|------------------|
| `playTimeSeconds` | `gM` |
| `mapId` | `v` |
| `mapSubIdLegacy` | `w` |
| `hasSaveGame` | `eF` |
| `gold` | `de` |
| `activationTrialFlag` | `dx` |
| `unlockedMap97` | `eG` |
| `unlockedMap96` | `eH` |
| `unlockedMap95` | `eI` |
| `escortActive` | `gl` |
| `escortReservedLegacy` | `gm` |
| `escortMapId` | `gn` |
| `mapObjectMountIndex` | `ik` |
| `equippedWeaponIndex` | `x` |
| `shurikenLevel2Learned` | `eX` |
| `mapUnlockFlags[]` | `W[]` |
| `inventoryCounts[]` | `V[]` |
| `skillWallJumpLearned` | `khinhCong` |
| `skillLegacyFlagEK` | `eK` |
| `skillShurikenLearned` | `eL` |
| `skillBurrowLearned` | `eM` |
| `skillMotorcycleLearned` | `eN` |
| `skillAttackDoubledQuest` | `eO` |
| `skillSwimLearned` | `eP` |
| `skillWaterRunLearned` | `eQ` |
| `skillTransformLearned` | `eR` |
| `questBatReward5000Done` | `eS` |
| `questTonikuBranchDone` | `eT` |
| `questMeetGirlUnlocked` | `eU` |
| `skillGateBeforeKC2` | `eV` |
| `skillWallJumpL2Learned` | `khinhCongCap2` |
| `skillSpeedBoostLearned` | `eY` |
| `skillStandOnWaterLearned` | `eZ` |
| `skillStealthLegacyFlag` | `fa` |
| `questGeninFlagFB` | `fb` |
| `questGeninGraduated` | `fc` |
| `playerX`, `playerY` | `ff`, `fg` |
| `atk`, `shurikenDmg`, `hp`, `hpMax`, `mp`, `mpMax` | `E`, `F`, `G`, `H`, `I`, `J` |
| `level`, `expInLevel` | `characterLevel`, `N` |
| `activeQuestId` | `currentQuestIndex` |
| `questParam`, `questTarget`, `questBool`, `questProgress` | `fz`, `fA`, `fB`, `fD` |
| `genderSpriteFlag` | `fy` |
| `scriptRunnerActive`, `scriptTableId`, `scriptStep` | `ifFlag`, `ie`, `ig` |
| `companionX` … `companionK` | `go` … `gK` |
| `hpCurrentAlt`, `hpMaxBaseline` | `ha`, `hb` |
| `mapObjectBundleCount` | `ij` |
| `mapObjTileX/Y`, `mapObjFacing`, `mapObjAnim`, … | `il`, `im`, `in`, `io`, `ip`, `iq` |
| `mapNpcBundleCount` | `ir` |
| `mapNpcFocusIndex` | `is` |
| `mapNpcTileX`, `mapNpcTileY`, `mapNpcDir`, … | `it`, `iu`, `iv`, … |
| `skillWallJumpL3Learned` | `khinhCongCap3` |
| `skillDashLearned` | `dashLearned` |
| `skillAmbushLearned` | `amSatLearned` |
| `skillDashLevel` | `dashLevel` |
| `playTimeSessionStartMs` | `gN` *(runtime)* |

---

## 3. FIXED BLOCK (indices 0–158)

| Idx | Code | Review name | Type | Default (new/static) | Description |
|-----|------|-------------|------|----------------------|-------------|
| 0 | `gM` | `playTimeSeconds` | int | `0` | Total play time (sec); on save adds `(now - gN)/1000` |
| 1 | `v` | `mapId` | int | gameplay | Current map; load via **`fixMapId()`** (§8) |
| 2 | `w` | `mapSubIdLegacy` | int | `0` | Written/read; **no runtime assigns** — treat as reserved |
| 3 | `eF` | `hasSaveGame` | 0/1 | `0` | Save exists / intro done |
| 4 | `de` | `gold` | int | `0` | In-game money |
| 5 | `dx` | `activationTrialFlag` | 0/1 | `0` | Activation / trial |
| 6 | `eG` | `unlockedMap97` | 0/1 | `0` | Special map 97 unlocked |
| 7 | `eH` | `unlockedMap96` | 0/1 | `0` | Special map 96 unlocked |
| 8 | `eI` | `unlockedMap95` | 0/1 | `0` | Special map 95 unlocked |
| 9 | `gl` | `escortActive` | 0/1 | `0` | Escort NPC (Sakura) active |
| 10 | `gm` | `escortReservedLegacy` | int | `0` | Written/read only — reserved |
| 11 | `gn` | `escortMapId` | int | `-1` | Map id for escort AI |
| 12 | `ik` | `mapObjectMountIndex` | int | `-1` | Index into map object arrays |
| 13 | `x` | `equippedWeaponIndex` | int | `0` | Weapon slot 0–3 |
| 14 | `eX` | `shurikenLevel2Learned` | 0/1 | `0` | Shuriken L2 (sprites + NPC lines) |
| 15–33 | `W[0..18]` | `mapUnlockFlags` | 0/1×**19** | all `false`, then `W[0]=true` | World map unlock; **length frozen at 19** |
| 34–39 | `V[0..5]` | `inventoryCounts` | int×**6** | `{5,2,1,5,2,1}` | Potions HP/MP counts; **length frozen at 6** |
| 40 | `khinhCong` | `skillWallJumpLearned` | 0/1 | `false` | Wall jump / KC base |
| 41 | `eK` | `skillLegacyFlagEK` | 0/1 | `false` | **Saved but no `if (eK)` in code** — legacy duplicate |
| 42 | `eL` | `skillShurikenLearned` | 0/1 | `false` | Throwing knife mode |
| 43 | `eM` | `skillBurrowLearned` | 0/1 | `false` | Burrow / độn thổ |
| 44 | `eN` | `skillMotorcycleLearned` | 0/1 | `false` | Motorcycle / training dummy mount |
| 45 | `eO` | `skillAttackDoubledQuest` | 0/1 | `false` | Quest “double attack” gate before swim |
| 46 | `eP` | `skillSwimLearned` | 0/1 | `false` | Swim / deep water |
| 47 | `eQ` | `skillWaterRunLearned` | 0/1 | `false` | Run on water (MP) |
| 48 | `eR` | `skillTransformLearned` | 0/1 | `false` | Transform (key 7) |
| 49 | `eS` | `questBatReward5000Done` | 0/1 | `false` | Bat quest gold reward done |
| 50 | `eT` | `questTonikuBranchDone` | 0/1 | `false` | Toniku branch complete |
| 51 | `eU` | `questMeetGirlUnlocked` | 0/1 | `false` | Meet-girl quest branch |
| 52 | `eV` | `skillGateBeforeKC2` | 0/1 | `false` | Early dialog gate before KC2 |
| 53 | `khinhCongCap2` | `skillWallJumpL2Learned` | 0/1 | `false` | Wall jump L2 |
| 54 | `eY` | `skillSpeedBoostLearned` | 0/1 | `false` | Speed potion / run fast |
| 55 | `eZ` | `skillStandOnWaterLearned` | 0/1 | `false` | Stand on water |
| 56 | `fa` | `skillStealthLegacyFlag` | 0/1 | `false` | Stealth in **fixed** block — see §7 |
| 57 | `fb` | `questGeninFlagFB` | 0/1 | `false` | Late Genin quest flag |
| 58 | `fc` | `questGeninGraduated` | 0/1 | `false` | Genin graduation / NPC branch |
| 59–73 | `fd`..`fn` | player physics | int | varies | Position, facing, timers, hitbox |
| 74–75 | `C`,`D` | airComboTier, burrowSubstate | int | `0` | KC air tier; burrow |
| 76 | `fo` | moveCounter | int | `0` | Movement helper |
| 77–84 | `E`..`L` | combat stats | int | ~20–200 | ATK, shuriken, HP/MP pools, extras |
| 85–89 | `fp`..`fu` | cameraTimers | int | `0` | Scroll / timers |
| 90 | `characterLevel` | `level` | int | `1` | Character level |
| 91 | `N` | `expInLevel` | int | `0` | EXP toward `ai[level-1]` |
| 92–95 | `fv`..`fy` | modeFlags | 0/1 | `fv=true`, rest `false` | Game mode; **`fy`** swaps sprite set on load |
| 96 | `currentQuestIndex` | `activeQuestId` | int | `-1` | Active quest (`-1` none) |
| 97–100 | `fz`,`fA`,`fB`,`fD` | quest fields | mixed | `0` | Quest param / target / bool / progress |
| 101–117 | `fE`..`fS` | cutsceneActors | int | `0` | Scripted positions / camera |
| 118–120 | `ifFlag`,`ie`,`ig` | script runner | mixed | `ifFlag=false`, `ie=10`, `ig=0` | Activation script state |
| 121–129 | `gc`..`gk` | script extras | int | `gc=-1` | Script-related ints |
| 130–152 | `go`..`gK` | `companionState` | int | `0` | Escort/companion AI (when `gl`) |
| 153 | `ha` | `hpCurrentAlt` | int | `1200`/`hb` | HP used in combat; load: if `<=0` → `ha=hb` |
| 154–157 | `hh`,`hn`,`hN`,`hs` | timers/script | int | varies | Regen / boss / script step |
| 158 | `ij` | `mapObjectBundleCount` | int | `0` | Count for variable block A (see §4) |

---

## 4. VARIABLE BLOCK A — map objects (`ij`)

**Save (`a.a()`):** After index 158, if `ij > 0`, write **in this order** (each array length = `ij`):

1. `ip[]`  
2. `in[]`  
3. `io[]`  
4. `iq[]`  
5. `il[]` (tile X)  
6. `im[]` (tile Y)  

**Size:** `6 × ij` integers.

**Load (`a.b()`):** Reads value at index 158 into a temp flag. If `> 0`, advances cursor by `6 × ip.length` (etc.) **without assigning** into `il`..`iq` and **without** `ij = savedValue`.

**Runtime source of truth:** Map init `c(mapId)` / `d(...)` sets `ij` and arrays when entering a map.

| Risk | Detail |
|------|--------|
| **One-way / skip load** | Saved object coordinates may not restore; depends on map re-init |
| **`ij` not restored** | Field `ij` not assigned from save slot 158 |
| **Array length** | Skip uses **current** `ip.length`; mismatch → wrong cursor or caught exception |

---

## 5. VARIABLE BLOCK B — map NPCs (`ir`)

**Header:** Always **1 int** `ir` (`mapNpcBundleCount`) immediately after block A (or after index 158 if `ij==0`).

**Body (if `ir > 0`):**

1. `is` — focused NPC index (`-1` none)  
2. `iv[]`  
3. `iz[]`  
4. `iy[]`  
5. `iw[]`  
6. `ix[]`  
7. `it[]` (tile X)  
8. `iu[]` (tile Y)  

**Size:** `1 + 7 × ir` integers.

**Load:** Sets `ir`, `is`, hydrates arrays if `ensureIrNpcArraysSized()` matches; wrapped in try/catch.

**Typical `ir` from `d(mapId)`:** `0` most maps; `2` for maps `1`,`11`,`5`; `4` for map `97`.

| Risk | Detail |
|------|--------|
| **Order vs map init** | Load can run before `E()` sizes arrays — `ensureIrNpcArraysSized()` mitigates |
| **`ir` without init** | Invalid `ir` + wrong map → NPC positions garbage until re-enter map |

---

## 6. TAIL BLOCK (append-only skills)

Loaded only if `var0.length > cursor` after block B.

| Order | Code | Review name | Type | Missing default |
|-------|------|-------------|------|-----------------|
| +0 | `khinhCongCap3` | `skillWallJumpL3Learned` | 0/1 | `false` |
| +1 | `dashLearned` | `skillDashLearned` | 0/1 | `false` → `skillSetDashLearned` |
| +2 | `amSatLearned` | `skillAmbushLearned` | 0/1 | `false` → `skillSetAmSatLearned` |
| +3 | `dashLevel` | `skillDashLevel` | int | `1` + `syncDashDurationToLevel()` |

Then **`syncSkillsFromLegacyFlags()`** syncs `DashSkill` / `AmbushSkill` from `dashLearned` / `amSatLearned` only (not from `fa`).

**Index formula (minimal save `ij=0`, `ir=0`):** tail at **160–163**.

New skills: follow `SkillIds` — **append only after `dashLevel`**, bump `SkillIds.COUNT`, guard with `length > cursor`.

---

## 7. Dangerous duplicate flags

### `fa` (fixed index 56) vs `amSatLearned` (tail)

| | `fa` / `skillStealthLegacyFlag` | `amSatLearned` / `skillAmbushLearned` |
|---|--------------------------------|----------------------------------------|
| **Block** | FIXED | TAIL |
| **Set by quests** | e.g. case 21 “ẩn thân” | Not always same time as `fa` |
| **Runtime stealth** | NPC checks `fa`, `fa && !fb` | `AmbushSkill` uses **`amSatLearned`** via `skillSetAmSatLearned` |
| **On load** | Restored from index 56 | Restored from tail; **`syncSkillsFromLegacyFlags()` ignores `fa`** |

**Freeze rule:** Treat as **two persisted fields**; do not merge or drop either without migration. Editors must set **both** for consistency with old saves.

### Other duplicates / legacy

| Fields | Note |
|--------|------|
| `eK` vs `khinhCong` | `eK` saved; never read in gameplay branches |
| `G`/`H` vs `ha`/`hb` | Two HP representations; combat favors `ha`/`hb` |
| `w`, `gm` | Persisted; unused in logic — do not repurpose |

---

## 8. `fixMapId()` behavior

```text
mapIdValid(id):
  true if 0 <= id <= 18
  OR id in { 94, 95, 96, 97, 99, 101 }

fixMapId(id):
  if mapIdValid(id) → return id
  else → log "[MAP] invalid map id … -> 0", return 0
```

**Used on:** full load `a.b()`, Continue partial load (`var9[1]`).

**Risk:** Any invalid/corrupt map id **teleports to map 0** silently (aside from stderr).

---

## 9. Continue menu — partial load (indices 0–14)

**Trigger:** Main menu `aY == 1` (“Chơi tiếp”), `Midlet.b()` true.

**Fields loaded before `x(v)`:**

| Idx | Code | Review name |
|-----|------|-------------|
| 0 | `gM` | `playTimeSeconds` |
| 1 | `v` | `mapId` (+ `fixMapId`) |
| 2 | `w` | `mapSubIdLegacy` |
| 3 | `eF` | `hasSaveGame` |
| 4 | `de` | `gold` |
| 5 | `dx` | `activationTrialFlag` |
| 6–8 | `eG`–`eI` | special map unlocks |
| 9–11 | `gl`,`gm`,`gn` | escort |
| 12–14 | `ik`,`x`,`eX` | mount, weapon, shuriken L2 |

**Not loaded until `a.b()`:** skills, `W[]`, `V[]`, stats, quest, companion, NPC blocks, tail.

**Flow:** Sets `Midlet.e = true`, `gN = now`, `x(v)` → thread → `a.b()` completes load.

**Risk:** Brief window with stale skills/stats if code path assumed full save after Continue.

---

## 10. Runtime-only state (NOT in `ninjasave`)

Do not persist; not part of frozen layout:

- `gN` — session timestamp for play time flush  
- Dash runtime: `dashLastTapMillisLeft/Right`, `dashPixelsRemaining`, `dashStartMillis`, `dashDurationMs` (derived from `dashLevel` on load)  
- Input: `aT[]`, `aS[]`, `d`, `bw`, UI selection `kX`, `aY`  
- Entities: mobs `di[]`, projectiles, `bV`/`bW`, particles  
- All `Image[]` / tile caches  
- **`kBagExt[6]`** — comment in source: extra bag row **not saved**  
- Static quest tables: `lF[]`, `questRequiredAmounts[]` (not in blob)  
- Shop catalog: `ShopCatalog`, `kH[]` (static)  

---

## 11. Field dependency notes

| Dependent | Depends on |
|-----------|------------|
| `x` (weapon) | `ko[x]` level gates, `E`/`F` damage |
| `currentQuestIndex` | `fD`,`fA`,`fz`,`fB`; NPC dialog trees |
| `W[kX]` | World map travel; cheat `1981` sets all `W` true |
| `V[]` | Shop buy caps (`V[0]+V[1]+V[2] > 99` etc.) |
| `gl`,`gn`,`go`..`gK` | Escort quest 10 / Sakura AI |
| `ik` | `il`/`im`/`in` when `ij>0` |
| `ir` | `it`/`iu`/… array lengths; map `d(mapId)` |
| `v` | `c(v)`, `d(v)`, `g(v)`, `fixMapId` |
| `fy` | `ep`/`eq` sprite swap on **full** load |
| `dashLearned`,`dashLevel` | `DashSkill` after `syncSkillsFromLegacyFlags` |
| `amSatLearned` | `AmbushSkill` (not `fa`) |
| `eR` | NPC dialog variants on maps 0–2 |
| `ha` | `hb`; clamp if `ha <= 0` on load |

---

## 12. Migration-sensitive list

**NEVER (breaks old saves):**

- Insert/remove/reorder indices **0–158**  
- Change `W.length` (19) or `V.length` (6)  
- Change variable block A order or multiplier (6×`ij`)  
- Change variable block B order or multiplier (7×`ir`)  
- Change tail order or remove tail fields  
- Change RMS name `ninjasave` or int endianness  
- Shrink on-disk `500`-int wire size without version id  

**SAFE (existing pattern):**

- Append new ints **after tail** with `if (var0.length > cursor)` on load  
- Append new skill after `dashLevel` per `SkillIds` comment  
- Add new map ids only with updated `mapIdValid` / `fixMapId` (conscious choice)  

**HIGH RISK (document any change):**

- `fixMapId` whitelist  
- `fa` / `amSatLearned` semantics  
- `ij` / `ir` load skip vs save write  
- Continue partial 0–14 only  
- `fy` sprite swap on load  
- Padding: tools that trim trailing zeros break tail detection  

---

## 13. Append-only rules

1. **Fixed block (0–158):** frozen forever unless `SAVE_VERSION` + converter (not present today).  
2. **Variable A:** only `ij` count; arrays always 6×`ij` in documented order.  
3. **Variable B:** always `ir` int; body `1+7×ir` when `ir>0`.  
4. **Tail:** exactly 4 fields today; new fields **after** `dashLevel` only.  
5. **Wire file:** keep `int[500]` → 2000 bytes or introduce explicit version int at 0 (would break — not allowed in freeze).  
6. **SkillIds.COUNT:** tail skills align with `SkillIds` append order.  
7. **Do not “clean up”** `eK`, `w`, `gm`, or merge `fa`/`amSatLearned` in persistence.  

---

## 14. Dangerous fields summary

| Priority | Topic | Action |
|----------|--------|--------|
| P0 | Fixed block size 0–158 | Never reorder |
| P0 | `W[19]`, `V[6]` | Never resize |
| P0 | Tail append-only | New fields only after index 163 pattern |
| P0 | 2000-byte wire padding | External editors must preserve length |
| P1 | `fa` vs `amSatLearned` | Edit both for stealth |
| P1 | `ij` block load skip | Do not assume objects restore from save |
| P1 | `ir` NPC block | Must match map init / `ir` count |
| P1 | Continue load 0–14 | Full state needs `a.b()` |
| P1 | `fixMapId` | Invalid id → map 0 |
| P2 | `eK`, `w`, `gm` | Legacy slots — keep in save |
| P2 | `gM` + `gN` | Play time accuracy |
| P2 | `fy` | Gender sprites |

---

## 15. Auxiliary RMS (not `ninjasave`)

| Store | Size | Purpose |
|-------|------|---------|
| `saved` | 1 byte | Save-exists flag |
| `bg` | 1 byte | Background index |
| `g`, `r`, `np`, `xxx` | varies | Activation / SMS helpers |

---

## 16. Source anchors

| Topic | Location |
|-------|----------|
| Save | `a.a()` ~847–1101 |
| Load | `a.b()` ~1121–1399 |
| `fixMapId` | `a.java` ~1104–1118 |
| Continue partial | `a.java` ~10537–10562 |
| Full load after Continue | `Midlet.java` ~537–538 (`a.b()`) |
| Skill tail contract | `SkillIds.java` |
| Map object init | `c(int)`, `D()`, `d(int,int,int)` ~2789+ |
| Map NPC init | `d(int)`, `E()`, `ensureIrNpcArraysSized()` ~2892+ |

---

*End of frozen layout document.*
