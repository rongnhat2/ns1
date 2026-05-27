#!/usr/bin/env python3
"""Apply SaveLayout.md review names to Java sources."""
import re
from pathlib import Path

RENAMES = [
    ("characterLevel", "level"),
    ("currentQuestIndex", "activeQuestId"),
    ("khinhCongCap3", "skillWallJumpL3Learned"),
    ("khinhCongCap2", "skillWallJumpL2Learned"),
    ("khinhCong", "skillWallJumpLearned"),
    ("dashLearned", "skillDashLearned"),
    ("amSatLearned", "skillAmbushLearned"),
    ("dashLevel", "skillDashLevel"),
    ("ifFlag", "scriptRunnerActive"),
    ("ik", "mapObjectMountIndex"),
    ("ij", "mapObjectBundleCount"),
    ("ir", "mapNpcBundleCount"),
    ("is", "mapNpcFocusIndex"),
    ("gN", "playTimeSessionStartMs"),
    ("gM", "playTimeSeconds"),
    ("dx", "activationTrialFlag"),
    ("w", "mapSubIdLegacy"),
    ("x", "equippedWeaponIndex"),
    ("eK", "skillLegacyFlagEK"),
    ("fa", "skillStealthLegacyFlag"),
    ("eO", "skillAttackDoubledQuest"),
    ("eV", "skillGateBeforeKC2"),
    ("eN", "skillMotorcycleLearned"),
    ("eL", "skillShurikenLearned"),
    ("eM", "skillBurrowLearned"),
    ("eP", "skillSwimLearned"),
    ("eQ", "skillWaterRunLearned"),
    ("eR", "skillTransformLearned"),
    ("eY", "skillSpeedBoostLearned"),
    ("eZ", "skillStandOnWaterLearned"),
    ("eS", "questBatReward5000Done"),
    ("eT", "questTonikuBranchDone"),
    ("eU", "questMeetGirlUnlocked"),
    ("fc", "questGeninGraduated"),
    ("fb", "questGeninFlagFB"),
    ("gm", "escortReservedLegacy"),
    ("eX", "shurikenLevel2Learned"),
    ("eG", "unlockedMap97"),
    ("eH", "unlockedMap96"),
    ("eI", "unlockedMap95"),
    ("gl", "escortActive"),
    ("gn", "escortMapId"),
    ("eF", "hasSaveGame"),
    ("fy", "genderSpriteFlag"),
    ("fD", "questProgress"),
    ("fA", "questTarget"),
    ("fz", "questParam"),
    ("fB", "questBool"),
    ("hb", "hpMaxBaseline"),
    ("ha", "hpCurrentAlt"),
    ("ie", "scriptTableId"),
    ("ig", "scriptStep"),
    ("fE", "interactTargetId"),
    ("fF", "interactSubId"),
    ("ih", "npcInteractIndex"),
    ("ii", "npcInteractSub"),
    ("fv", "gameModeFv"),
    ("fw", "gameModeFw"),
    ("fx", "gameModeFx"),
    ("fn", "playerFacing"),
    ("fd", "mountFacing"),
    ("fe", "mountSubstate"),
    ("fi", "spriteHeight"),
    ("fj", "halfWidth"),
    ("fk", "halfHeight"),
    ("fh", "playerTimer0"),
    ("fl", "playerTimer1"),
    ("fm", "playerTimer2"),
    ("fo", "moveCounter"),
    ("fp", "cameraScrollX"),
    ("fq", "cameraScrollY"),
    ("fr", "cameraBound"),
    ("ft", "timerFt"),
    ("fu", "timerFu"),
    ("hh", "regenTimer"),
    ("hn", "idleTimerLong"),
    ("hN", "bossThreshold"),
    ("hs", "scriptHsStep"),
    ("ip", "mapObjType"),
    ("in", "mapObjFacing"),
    ("io", "mapObjAnim"),
    ("iq", "mapObjExtra"),
    ("il", "mapObjTileX"),
    ("im", "mapObjTileY"),
    ("it", "mapNpcTileX"),
    ("iu", "mapNpcTileY"),
    ("iv", "mapNpcDir"),
    ("iw", "mapNpcIw"),
    ("ix", "mapNpcIx"),
    ("iy", "mapNpcIy"),
    ("iz", "mapNpcIz"),
    ("gA", "companionFaceDir"),
    ("gr", "companionAccel"),
    ("gs", "companionMode"),
    ("gq", "companionVel"),
    ("go", "companionX"),
    ("gp", "companionY"),
    ("gt", "companionT0"),
    ("gu", "companionT1"),
    ("gv", "companionT2"),
    ("gw", "companionT3"),
    ("gx", "companionT4"),
    ("gy", "companionT5"),
    ("gz", "companionT6"),
    ("gB", "companionB"),
    ("gC", "companionC"),
    ("gD", "companionD"),
    ("gE", "companionE"),
    ("gF", "companionF"),
    ("gG", "companionG"),
    ("gH", "companionH"),
    ("gI", "companionI"),
    ("gJ", "companionJ"),
    ("gK", "companionK"),
    ("gc", "scriptMapId"),
    ("gd", "scriptExtraD"),
    ("ge", "scriptExtraE"),
    ("gf", "scriptExtraF"),
    ("gg", "scriptExtraG"),
    ("gh", "scriptExtraH"),
    ("gi", "scriptExtraI"),
    ("gj", "scriptExtraJ"),
    ("gk", "scriptExtraK"),
    ("fG", "cutsceneG"),
    ("fH", "cutsceneH"),
    ("fI", "cutsceneI"),
    ("fJ", "cutsceneJ"),
    ("fK", "cutsceneK"),
    ("fL", "cutsceneL"),
    ("fM", "cutsceneM"),
    ("fN", "cutsceneN"),
    ("fO", "cutsceneO"),
    ("fP", "cutsceneP"),
    ("fQ", "cutsceneQ"),
    ("fR", "cutsceneR"),
    ("fS", "cutsceneS"),
    ("W", "mapUnlockFlags"),
    ("V", "inventoryCounts"),
    ("N", "expInLevel"),
    ("F", "shurikenDmg"),
    ("A", "playerState"),
    ("D", "burrowSubstate"),
    ("C", "airComboTier"),
    ("ff", "playerX"),
    ("fg", "playerY"),
    ("v", "mapId"),
    ("de", "gold"),
    ("H", "hpMax"),
    ("G", "hp"),
    ("J", "mpMax"),
    ("I", "mp"),
    ("E", "atk"),
]


def _rename_outside_strings(chunk: str) -> str:
    for old, new in RENAMES:
        pat = re.compile(r"\b" + re.escape(old) + r"\b(?!\s*\()")
        chunk = pat.sub(new, chunk)
    return chunk


def apply_renames(text: str) -> str:
    out: list[str] = []
    i = 0
    n = len(text)
    while i < n:
        ch = text[i]
        if ch == '"':
            j = i + 1
            while j < n:
                if text[j] == "\\":
                    j += 2
                    continue
                if text[j] == '"':
                    j += 1
                    break
                j += 1
            out.append(text[i:j])
            i = j
        elif ch == "'":
            j = i + 1
            while j < n:
                if text[j] == "\\":
                    j += 2
                    continue
                if text[j] == "'":
                    j += 1
                    break
                j += 1
            out.append(text[i:j])
            i = j
        else:
            j = i
            while j < n and text[j] not in "\"'":
                j += 1
            out.append(_rename_outside_strings(text[i:j]))
            i = j
    return "".join(out)


def main() -> None:
    root = Path(__file__).resolve().parents[1] / "src"
    for fname in ("a.java", "Midlet.java", "b.java"):
        path = root / fname
        if path.exists():
            path.write_text(apply_renames(path.read_text(encoding="utf-8")), encoding="utf-8", newline="\n")
            print("updated", fname)


if __name__ == "__main__":
    main()
