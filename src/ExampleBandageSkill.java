import javax.microedition.lcdui.Graphics;

/**
 * Sample skill: demonstrates full {@link SkillTemplate} lifecycle hooks without wiring to RMS or keys.
 * <p>
 * To persist charges: bump save tail per {@link SkillIds}, then call {@link #applyLoadPayload}
 * after {@link #loadSaveFlag} on load.
 * </p>
 */
public final class ExampleBandageSkill extends SkillTemplate {

   private static final int START_CHARGES = 3;
   private static final ExampleBandageSkill INSTANCE = new ExampleBandageSkill();

   private int charges;
   /** Visual-only countdown for {@link #onRender} demo. */
   private int blinkTicks;

   private ExampleBandageSkill() {
      setBaseManaCost(0);
   }

   public static ExampleBandageSkill getInstance() {
      return INSTANCE;
   }

   protected void onLearn(SkillContext ctx) {
      charges = START_CHARGES;
      blinkTicks = 0;
      super.onLearn(ctx);
   }

   protected boolean canUse(SkillContext ctx) {
      return ctx.isGameplay() && charges > 0 && ctx.getPlayerState() == 1;
   }

   protected boolean onActivate(SkillContext ctx) {
      --charges;
      blinkTicks = 8;
      ctx.showMessage("(demo) Bandage OK, con lai: " + charges);
      ctx.requestRepaint();
      return true;
   }

   protected void onUpdate(SkillContext ctx, int deltaMs) {
      if (blinkTicks > 0) {
         --blinkTicks;
         ctx.requestRepaint();
      }
   }

   protected void onRender(SkillContext ctx, Graphics g) {
      if (g == null || blinkTicks <= 0) {
         return;
      }
      g.setColor(blinkTicks % 2 == 0 ? 0xFFFFFF : 0x00FF00);
      g.drawRect(ctx.getPlayerX() - 10, ctx.getPlayerY() - 40, 20, 6);
   }

   protected void onExpire(SkillContext ctx) {
      blinkTicks = 0;
   }

   protected int[] onSave() {
      return new int[] { charges };
   }

   protected void onLoad(int[] payload) {
      if (payload != null && payload.length > 0) {
         charges = payload[0];
      }
   }
}
