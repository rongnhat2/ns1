import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import javax.bluetooth.LocalDevice;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.TextBox;
import javax.microedition.rms.RecordStore;

public final class a extends Canvas implements Runnable, CommandListener {
   public static boolean a = true;
   private static int Z = 40;
   private static int[] aa = new int[]{150, 180, 180, 300, 350, 380, 500};
   private static int[] ab = new int[]{20, 30, 40, 100, 80, 120, 200};
   private static int[] ac = new int[]{150, 140, 120, 240, 280, 290, 300};
   private static int[] ad = new int[]{800, 1000, 1200, 3000, 3500, 4000, 6000};
   private static int[][] ae = new int[][]{{-5, -2}, {-2, -4}, {0, -5}, {-6, -6}, {-5, -2}, {-2, -4}, {0, -5}};
   private static int[][] af = new int[][]{{5, 8}, {3, 3}, new int[2], {4, 4}, {5, 8}, {3, 3}, new int[2]};
   private static int[] ag = new int[]{1, -2, 1, 1, 1, -2, 1};
   private static int[] ah = new int[]{3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
   private static int[] ai = new int[]{50, 150, 240, 400, 600, 800, 1000, 1500, 2000, 3000, 5000, 7000, 9000, 12000, 15000, 19000, 26000, 32000, 40000, 50000, 60000, 70000, 80000, 90000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000};
   private static int[] aj = new int[]{20, 20, 20, 20, 30, 30, 30, 40, 40, 50, 60, 70, 80, 80, 90, 90, 100, 120, 130, 150, 160, 170, 180, 190, 200, 210, 220, 250, 300, 300, 300, 300, 300, 300, 300, 300, 300, 300, 300, 300, 300, 300};
   private static int[][][] ap = new int[][][]{{{0, -13, 31}, {0, -7, 8}, {0, -11, 14}}, {{0, -13, 32}, {0, -7, 8}, {0, -11, 15}}, {{1, -11, 31}, {1, -9, 16}, {6, -1000, 0}}, {{2, -11, 32}, {2, -10, 16}, {6, -1000, 0}}, {{1, -11, 31}, {3, -8, 16}, {6, -1000, 0}}, {{2, -10, 32}, {7, -9, 17}, {6, -1000, 0}}, {{1, -10, 31}, {8, -8, 16}, {6, -1000, 0}}, {{0, -8, 35}, {4, -5, 15}, {2, -10, 21}}, {{0, -8, 34}, {5, -6, 13}, {3, -11, 22}}, {{0, -8, 31}, {6, -13, 9}, {4, -10, 18}}, {{1, -8, 30}, {6, -13, 9}, {5, -8, 17}}, {{2, -10, 30}, {6, -13, 9}, {6, -8, 16}}, {{2, -10, 29}, {6, -13, 9}, {7, -11, 17}}, {{3, -11, 33}, {8, -4, 13}, {8, -15, 25}}};
   private static int[][][] aq = new int[][][]{{{0, -10, 32}, {1, -7, 7}, {1, -11, 15}}, {{0, -10, 33}, {1, -7, 7}, {1, -11, 16}}, {{1, -10, 33}, {2, -10, 11}, {2, -9, 16}}, {{1, -10, 32}, {3, -11, 9}, {3, -11, 16}}, {{1, -10, 34}, {4, -9, 9}, {4, -8, 16}}, {{1, -10, 34}, {5, -11, 11}, {5, -10, 17}}, {{1, -10, 33}, {6, -9, 9}, {6, -8, 16}}, {{0, -9, 36}, {7, -5, 15}, {7, -10, 21}}, {{4, -13, 26}, new int[3], new int[3]}, {{5, -13, 25}, new int[3], new int[3]}, {{6, -12, 26}, new int[3], new int[3]}, {{7, -13, 25}, new int[3], new int[3]}, {{0, -9, 35}, {8, -4, 13}, {8, -14, 27}}, {{0, -9, 32}, {9, -11, 9}, {10, -10, 18}}, {{2, -7, 34}, {9, -11, 9}, {11, -8, 16}}, {{2, -8, 33}, {9, -11, 9}, {12, -8, 15}}, {{2, -7, 33}, {9, -11, 9}, {13, -12, 16}}, {{0, -11, 32}, {9, -11, 9}, {14, -15, 19}}, {{2, -9, 33}, {9, -11, 9}, {15, -13, 20}}, {{2, -9, 32}, {9, -11, 9}, {16, -7, 23}}, {{2, -9, 33}, {9, -11, 9}, {17, -11, 19}}, {{3, -12, 34}, {8, -4, 13}, {8, -15, 25}}, {{0, -10, 28}, new int[3], {19, -8, 12}}, {{0, -9, 35}, {8, -4, 13}, {9, -9, 22}}, {{0, -10, 33}, new int[3], new int[3]}, {{9, -4, 24}, new int[3], new int[3]}, {{10, -4, 22}, new int[3], new int[3]}, {{0, -9, 32}, {8, -4, 9}, {10, -10, 18}}, {{2, -7, 34}, {8, -4, 9}, {11, -8, 16}}, {{2, -8, 33}, {8, -4, 9}, {12, -8, 15}}, {{2, -7, 33}, {8, -4, 9}, {13, -12, 16}}, {{0, -11, 32}, {7, -5, 9}, {14, -15, 19}}, {{2, -9, 33}, {7, -5, 9}, {15, -13, 20}}, {{2, -9, 32}, {7, -5, 9}, {16, -7, 23}}, {{2, -9, 33}, {7, -5, 9}, {17, -11, 19}}, {{0, -9, 32}, {2, -10, 11}, {10, -10, 18}}, {{2, -7, 34}, {3, -11, 9}, {11, -8, 16}}, {{2, -8, 33}, {4, -9, 9}, {12, -8, 15}}, {{2, -7, 33}, {5, -11, 11}, {13, -12, 16}}, {{0, -11, 32}, {2, -10, 11}, {14, -15, 19}}, {{2, -9, 33}, {3, -11, 9}, {15, -13, 20}}, {{2, -9, 32}, {4, -9, 9}, {16, -7, 23}}, {{2, -9, 33}, {5, -11, 11}, {17, -11, 19}}, {{1, -8, 38}, new int[3], {18, -8, 21}}, {{1, -8, 39}, new int[3], {18, -8, 22}}, {{1, -10, 43}, new int[3], {18, -11, 26}}};
   private static int[] ar = new int[]{-2, -6, 22, 21, 19, 22, 10, -2, -2, 5, 19};
   private static int[] as = new int[]{9, 22, 25, 17, 26, 37, 36, 49, 50, 52, 36};
   private static int[][] at = new int[][]{{2, 1, 1, 5, 3}, {2, 4, 3}, {2, 3}, {2, 1, 3}, {6, 3}, {2, 7, 3}, {2, 8, 3}, {2, 9, 3}, {2, 3}, {1, 3}, {2, 3}};
   private static int[][] au = new int[][]{{0, 1, 2, 5, 0}, {3, 4, 0}, {6, 0}, {7, 8, 0}, {9, 0}, {10, 11, 0}, {12, 13, 0}, {14, 15, 0}, {16, 0}, {17, 0}, {18, 0}};
   private static int[][] av = new int[][]{{0, 360, 1128, 0, 0}, new int[3], new int[2], {0, 2784, 0}, {1248, 0}, new int[3], new int[3], new int[3], new int[2], new int[2], new int[2]};
   private static int[][] aw = new int[][]{new int[5], new int[3], new int[2], new int[3], {408, 0}, new int[3], new int[3], new int[3], new int[2], new int[2], new int[2]};
   private static int[][] ax = new int[][]{{15, 1, 1, 2, 2, 1, 2, 4, 5, 3}, {6, 15, 1, 2, 1, 2, 1, 2, 1, 2, 4, 5, 3}, {6, 1, 2, 8, 11, 4, 7, 1, 2, 1, 2, 3}, {8, 9, 15, 12, 14, 10, 4, 16, 5, 1, 2, 3}, {7, 17}, {4, 1, 2, 17}, {8, 9, 15, 12, 14, 10, 4, 18, 4, 7, 3}, {1, 2, 4, 5, 3}, {6, 4, 19, 3}, {4, 20, 21, 3}, {4, 3}, {4, 22, 3}, {23, 4, 7, 4, 3}, {23, 25, 4, 7, 24, 26, 3}, {27, 4, 7, 4, 28, 3}, {4, 31, 32, 7, 4, 31, 4, 7, 4, 8, 17, 3}, {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 29, 3}, {4, 30, 3}, {15, 31, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 33, 17, 3}};
   private static int[][] ay = new int[][]{{1, -4, -1, -1, -4, -4, -4, 0, 20000, 0}, {0, 2, -4, -4, -5, -5, -5, -5, -5, -5, 1, 20000, 0}, {0, -5, -5, 0, 0, 2, 0, 55, 55, -4, -4, 0}, {0, 1, 0, 2, 3, 4, 3, 432, 20000, -4, -4, 0}, {0, 4}, {4, 55, 55, 0}, {0, 5, 3, 6, 7, 8, 5, 2, 6, 0, 0}, {-4, -4, 7, 20000, 0}, {0, 8, 0, 0}, {9, 0, 0, 0}, {10, 0}, {11, 0, 0}, {0, 12, 0, 13, 0}, {0, 0, 14, 0, 600, 0, 0}, {0, 15, 0, 16, 0, 0}, {17, 0, 0, 0, 55, 0, 56, 0, 57, 0, 94, 0}, {18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 0, 0}, {54, 0, 0}, {4, 0, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 0, 0, 0}};
   private static int[][] az = new int[][]{{5, 26, 30, 33, 41, 48, 53, 57, 58, 60}, {5, 6, 8, 9, 18, 20, 30, 32, 39, 40, 60, 63, 67}, {5, 6, 7, 13, 14, 19, 21, 34, 35, 60, 79, 80}, {1, 2, 3, 20, 50, 80, 85, 90, 92, 93, 95, 0}, {5, 6}, {10, 12, 13, 50}, {1, 2, 3, 4, 5, 6, 17, 18, 19, 20, 21}, {5, 10, 20, 30, 32}, {5, 10, 15, 20}, {10, 15, 20, 25}, {20, 25}, {10, 12, 14}, {15, 30, 35, 45, 55}, {10, 12, 30, 40, 45, 50, 75}, {15, 30, 35, 45, 53, 55}, {10, 12, 13, 40, 50, 60, 70, 80, 90, 95, 100, 105}, {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47}, {10, 12, 14}, {10, 11, 60, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74}};
   private static int[][] aA = new int[][]{{1344, 288}, {816, 48}, {816, 192}, {744, 192}, {144, 264}, {1440, 96}, {1368, 288}, {1128, 288}, {840, 312}};
   private static int[] aB = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 0, 4, 0, 3, 0, 6, 0, 2, 0, 5, 0, 4, 0, 1, 0, 3, 0, 0, 0, 5, 0, 4, 0, 3, 0, 2, 0, 2, 0, 1, 0, 0, 0, 0, 0, 3, 0, 3, 0, 0, 2, 1, 3, 2, 2};
   private static int[] aC = new int[]{0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 2, 0, 2, 3, 0, 0, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 4, 0, 4, 0, 1, 2, 1, 2, 0, 1, 2, 1, 2, 1, 2};
   private static int[][][] aH;
   private static int[] aI;
   private static int[] aJ;
   private static int aK;
   private static a aL;
   private static boolean aM;
   private static boolean aN;
   private static int aO;
   private static int aP;
   private static boolean aQ;
   private static boolean aR;
   private static boolean[] aS;
   private static boolean[] aT;
   private static int aU;
   private static int aV;
   private static int aW;
   private static int aX;
   private static int aY;
   public static boolean b;
   public static boolean c;
   private static int aZ;
   private static int ba;
   private static int bb;
   private static int bc;
   private static int bd;
   private static int be;
   public static int d;
   private static boolean bf;
   public static int[] e;
   public static int[] f;
   public static int g;
   public static int h;
   public static int i;
   public static int j;
   public static int k;
   public static int l;
   public static int m;
   public static String n;
   public static String o;
   private static int bg;
   private static int bh;
   private static int bi;
   private static int bj;
   private static int bk;
   private static int bl;
   private static int bm;
   private static int bn;
   private static int bo;
   private static int bp;
   private static int bq;
   private static int br;
   private static int bs;
   private static int bt;
   private static int bu;
   private static int bv;
   private static String bw;
   private static int bx;
   private static int by;
   private static int bz;
   private static int bA;
   private static int bB;
   private static int bC;
   public static int p;
   public static int q;
   public static int r;
   private static int bD;
   private static int bE;
   private static int bF;
   private static int bG;
   private static int bH;
   private static int bI;
   private static int bJ;
   private static int bK;
   private static int bL;
   private static int bM;
   private static int bN;
   private static int[] bO;
   private static int[] bP;
   private static int[] bQ;
   private static int[] bR;
   private static int[] bS;
   private static int[] bT;
   private static int bU;
   private static int[] bV;
   private static int[] bW;
   private static int[] bX;
   private static int[] bY;
   private static int[] bZ;
   private static int[] ca;
   private static int[] cb;
   private static int[] cc;
   private static int[] cd;
   private static int[] ce;
   private static int[] cf;
   private static int[] cg;
   private static int[] ch;
   private static int[] ci;
   private static int[] cj;
   private static int[] ck;
   private static int[] cl;
   private static int[] cm;
   private static boolean cn;
   private static int co;
   private static String cp;
   private static int cq;
   private static int[] cr;
   private static int[] cs;
   private static int[] ct;
   private static int[] cu;
   private static int[] cv;
   private static int[] cw;
   private static int[] cx;
   private static int[] cy;
   private static int[] cz;
   private static int[] cA;
   private static int[] cB;
   private static int[] cC;
   private static int[] cD;
   private static int[] cE;
   private static int[] cF;
   private static int[] cG;
   private static int[] cH;
   private static int[] cI;
   private static int[] cJ;
   private static int[] cK;
   private static int[] cL;
   private static int[] cM;
   private static int cN;
   private static int[] cO;
   private static int[] cP;
   private static int[] cQ;
   private static int[] cR;
   private static int[] cS;
   private static int[] cT;
   private static int[] cU;
   private static int[] cV;
   private static int cW;
   private static int[] cX;
   private static int[] cY;
   private static int[] cZ;
   private static int[] da;
   private static int[] db;
   private static int[] dc;
   private static boolean[] dd;
   private static int gold;
   private static int df;
   private static int[] dg;
   private static int[] dh;
   private static int[] di;
   private static int[] dj;
   private static int[] dk;
   private static int[] dl;
   private static int[] dm;
   private static int[] dn;
   private static boolean doFlag;
   private static int dp;
   private static int dq;
   private static int dr;
   private static int ds;
   private static int dt;
   private static boolean[] du;
   private static int dv;
   private static String[][] dw;
   private static boolean activationTrialFlag;
   private static boolean dy;
   private static int dz;
   private static int[] dA;
   private static int[] dB;
   private static int[] dC;
   private static int[] dD;
   private static int[] dE;
   private static int[] dF;
   private static int[] dG;
   private static int[] dH;
   private static int[] dI;
   private static int[] dJ;
   private static int[] dK;
   private static int[] dL;
   private static int[] dM;
   private static int[] dN;
   private static int[] dO;
   private static String[] dP;
   private static int[] dQ;
   private static int[] dR;
   private static int[] dS;
   private static int[] dT;
   private static int[] dU;
   private static int[] dV;
   private static int dW;
   private static int dX;
   private static int dY;
   private static Image[][] dZ;
   private static Image[] ea;
   private static Image eb;
   public static Image[] s;
   private static Image[] ec;
   private static Image ed;
   private static Image[] ee;
   private static Image ef;
   public static Image t;
   public static Image u;
   private static Image[] eg;
   private static Image[] eh;
   private static Image ei;
   private static Image[] ej;
   private static Image[][] ek;
   private static Image[] el;
   private static Image[] em;
   private static Image[] en;
   private static Image[] eo;
   private static Image[] ep;
   private static Image[] eq;
   private static Image[] er;
   private static Image[] es;
   private static Image[][] et;
   private static Image[][] eu;
   private static Image[] ev;
   private static Image[] ew;
   private static Image[] ex;
   private static Image[] ey;
   private static Image[] ez;
   private static Image[] eA;
   private static Image eB;
   private static Image[] eC;
   private static Image[] eD;
   private static Image[] eE;
   public static int mapId;
   public static int mapSubIdLegacy;
   private static boolean hasSaveGame;
   private static boolean unlockedMap97;
   private static boolean unlockedMap96;
   private static boolean unlockedMap95;
   private static boolean skillLegacyFlagEK;
   private static boolean skillShurikenLearned;
   private static boolean skillBurrowLearned;
   private static boolean skillMotorcycleLearned;
   private static boolean skillAttackDoubledQuest;
   private static boolean skillSwimLearned;
   private static boolean skillWaterRunLearned;
   private static boolean skillTransformLearned;
   private static boolean questBatReward5000Done;
   private static boolean questTonikuBranchDone;
   private static boolean questMeetGirlUnlocked;
   private static boolean skillGateBeforeKC2;
   private static boolean shurikenLevel2Learned;
   private static boolean skillSpeedBoostLearned;
   private static boolean skillStandOnWaterLearned;
   private static boolean skillStealthLegacyFlag;
   private static boolean questGeninFlagFB;
   private static boolean questGeninGraduated;
   private static int mountFacing;
   private static int mountSubstate;
   public static int equippedWeaponIndex;
   private static int playerX;
   private static int playerY;
   public static int y;
   public static int z;
   public static int playerState;
   public static int B;
   private static int playerTimer0;
   private static int spriteHeight;
   private static int halfWidth;
   private static int halfHeight;
   private static int playerTimer1;
   private static int playerTimer2;
   private static int playerFacing;
   public static int airComboTier;
   public static int burrowSubstate;
   private static int moveCounter;
   public static int atk;
   public static int shurikenDmg;
   public static int hp;
   public static int hpMax;
   public static int mp;
   public static int mpMax;
   public static int K;
   public static int L;
   private static int cameraScrollX;
   private static int cameraScrollY;
   private static int cameraBound;
   /** Mirror {@link DashSkill#getDurationMs()} — debug / tương thích doc. */
   public static int dashDurationMs = 200;
   /** Đã học kỹ năng dash (RMS tail +1). */
   public static boolean skillDashLearned;
   /** Cấp dash (RMS tail +3); logic trong {@link DashSkill}. */
   public static int skillDashLevel = 1;
   /** MP dash cố định; 0 = theo cấp trong {@link DashSkill}. */
   public static int dashManaCost = 0;
   /** Đã học kỹ năng ám sát (phím 9). */
   public static boolean skillAmbushLearned;
   /** MP tiêu hao mỗi lần ám sát. */
   public static int amSatManaCost = 40;
   /** @deprecated → hằng trong {@link AmbushSkill}. */
   private static final int AMSAT_RANGE = 500;
   private static final int AMSAT_BEHIND_OFFSET = 22;
   private static final int AMSAT_GROUND_Y_TOLERANCE = 48;
   private static boolean fs;
   private static int timerFt;
   private static int timerFu;
   /** Cấp độ nhân vật (level). */
   public static int level;
   public static int expInLevel;
   private static boolean gameModeFv;
   private static boolean gameModeFw;
   private static boolean gameModeFx;
   private static boolean genderSpriteFlag;
   /** Chỉ số nhiệm vụ đang làm (-1 = không có nhiệm vụ active). */
   public static int activeQuestId;
   private static int questParam;
   private static int questTarget;
   private static boolean questBool;
   private static boolean fC;
   private static int questProgress;
   private static int interactTargetId;
   private static int interactSubId;
   private static int cutsceneG;
   private static int cutsceneH;
   private static int cutsceneI;
   private static int cutsceneJ;
   private static int cutsceneK;
   private static int cutsceneL;
   private static int cutsceneM;
   private static int cutsceneN;
   private static int cutsceneO;
   private static int cutsceneP;
   private static int cutsceneQ;
   private static int cutsceneR;
   private static int cutsceneS;
   private static boolean fT;
   private static int fU;
   private static int fV;
   public static int P;
   public static int Q;
   private static boolean fW;
   private static String[] fX;
   private static int fY;
   private static int fZ;
   private static int ga;
   private static boolean gb;
   private static int scriptMapId;
   private static int scriptExtraD;
   private static int scriptExtraE;
   private static int scriptExtraF;
   private static int scriptExtraG;
   private static int scriptExtraH;
   private static int scriptExtraI;
   private static int scriptExtraJ;
   private static int scriptExtraK;
   private static boolean escortActive;
   private static int escortReservedLegacy;
   private static int escortMapId;
   private static int companionX;
   private static int companionY;
   private static int companionVel;
   private static int companionAccel;
   private static int companionMode;
   private static int companionT0;
   private static int companionT1;
   private static int companionT2;
   private static int companionT3;
   private static int companionT4;
   private static int companionT5;
   private static int companionT6;
   private static int companionFaceDir;
   private static int companionB;
   private static int companionC;
   private static int companionD;
   private static int companionE;
   private static int companionF;
   private static int companionG;
   private static int companionH;
   private static int companionI;
   private static int companionJ;
   private static int companionK;
   private static int gL;
   private static int playTimeSeconds;
   private static long playTimeSessionStartMs;
   private static boolean gO;
   private static int gP;
   private static int gQ;
   private static int gR;
   private static int gS;
   private static int gT;
   private static int gU;
   private static int gV;
   private static int gW;
   private static int gX;
   private static int gY;
   private static int gZ;
   private static int hpCurrentAlt;
   private static int hpMaxBaseline;
   private static int hc;
   private static boolean hd;
   private static boolean he;
   private static boolean hf;
   private static int hg;
   private static int regenTimer;
   private static int hi;
   private static boolean hj;
   private static int hk;
   private static int hl;
   private static int hm;
   private static int idleTimerLong;
   private static int ho;
   private static int scriptHitGauge;
   private static int hq;
   private static int hr;
   private static int scriptHsStep;
   private static int ht;
   private static int hu;
   private static int hv;
   private static int hw;
   private static int hx;
   private static int[][] hy;
   private static int[][] hz;
   private static int[][] hA;
   private static int[][] hB;
   private static int[][] hC;
   private static int[][] hD;
   private static int[] hE;
   private static int[] hF;
   private static int[] hG;
   private static int[] hH;
   private static int[] hI;
   private static int[] hJ;
   private static boolean hK;
   private static int hL;
   private static int hM;
   private static int bossThreshold;
   private static int hO;
   private static int hP;
   private static int hQ;
   private static int hR;
   private static int hS;
   private static int hT;
   private static int hU;
   private static int hV;
   private static int hW;
   private static int hX;
   private static int hY;
   private static int hZ;
   private static int ia;
   private static int ib;
   private static int ic;
   private static int id;
   private static int scriptTableId;
   private static boolean scriptRunnerActive;
   private static int scriptStep;
   private static int npcInteractIndex;
   private static int npcInteractSub;
   private static int mapObjectBundleCount;
   private static int mapObjectMountIndex;
   private static int[] mapObjTileX;
   private static int[] mapObjTileY;
   private static int[] mapObjFacing;
   private static int[] mapObjAnim;
   private static int[] mapObjType;
   private static int[] mapObjExtra;
   private static int mapNpcBundleCount;
   private static int mapNpcFocusIndex;
   private static int[] mapNpcTileX;
   private static int[] mapNpcTileY;
   private static int[] mapNpcDir;
   private static int[] mapNpcIw;
   private static int[] mapNpcIx;
   private static int[] mapNpcIy;
   private static int[] mapNpcIz;
   private static boolean iA;
   private static int iB;
   private static int iC;
   private static int iD;
   private static int iE;
   private static String[][] iF;
   private static int iG;
   private static int iH;
   private static int iI;
   private static int iJ;
   private static int iK;
   private static int iL;
   private static String iM;
   private static int iN;
   private static int iO;
   private static int iP;
   private static int iQ;
   private static byte[] iR;
   private static int[] iS;
   private static boolean[] iT;
   private static Image iU;
   private static Image iV;
   private static Image iW;
   private static Image[] iX;
   private static int iY;
   private static int[] iZ;
   private static int[] ja;
   private static int[] jb;
   private static int[] jc;
   private static int[] jd;
   private static Image je;
   private static int jf;
   private static int jg;
   private static int jh;
   private static int ji;
   private static int jj;
   private static String[] jk;
   private static int[] jl;
   private static int[] jm;
   private static int[] jn;
   private static int jo;
   private static int jp;
   private static int jq;
   private static int jr;
   private static int js;
   private static int jt;
   private static int ju;
   private static int jv;
   private static int jw;
   private static int jx;
   private static int jy;
   private static int jz;
   private static int jA;
   private static int jB;
   static int R;
   private static int jC;
   static int S;
   private static Image jD;
   private static Image jE;
   private static int jF;
   private static int jG;
   public static boolean T;
   private static Image[][][] jH;
   private static int jI;
   private static int jJ;
   private static int[] jK;
   private static int[] jL;
   private static int[] jM;
   private static int[] jN;
   private static int[] jO;
   private static int[] jP;
   private static int[] jQ;
   private static int[] jR;
   private static int[] jS;
   private static int[] jT;
   private static int[] jU;
   private static int[] jV;
   private static int[] jW;
   private static int[] jX;
   private static int[] jY;
   private static int[] jZ;
   private static int[] ka;
   private static int[] kb;
   private static int[] kc;
   private static int[] kd;
   private static int[] ke;
   private static int[] kf;
   private static int[] kg;
   private static int[] kh;
   private static int[] ki;
   private static boolean[] kj;
   private static int[][] kk;
   private static int[][] kl;
   private static boolean[][] km;
   private static int[] kn;
   private static int[] ko;
   static int U;
   private static int kp;
   private static int kq;
   private static int kr;
   private static int ks;
   private static int kt;
   private static int[] ku;
   private static String[][] kv;
   private static String[][] kw;
   private static int[][] kx;
   private static Image[] ky;
   private static String[][] kz;
   private static String[][] kA;
   private static int kB;
   private static int kC;
   private static int kD;
   private static int kE;
   private static int[] kF;
   private static String[] kG;
   static int[] inventoryCounts;
   private static int[] kH;
   /** 6 ô hàng dưới túi đồ (chưa lưu save). */
   private static int[] kBagExt;
   private static Image[] kI;
   private static int kJ;
   private static int kK;
   private static int kL;
   private static String[] kM;
   private static String[] kN;
   private static int[] kO;
   public static boolean[] mapUnlockFlags;
   private static int[] kP;
   private static int[] kQ;
   private static int[] kR;
   private static int[] kS;
   private static Image kT;
   private static Image kU;
   private static int kV;
   private static int kW;
   private static int kX;
   private static int kY;
   private static int kZ;
   private static int la;
   private static int lb;
   private static int lc;
   private static int ld;
   private static int le;
   private static int lf;
   private static int lg;
   private static int lh;
   private static int li;
   private static int lj;
   private static String lk;
   private static Image ll;
   private static boolean lm;
   private static int ln;
   public static int X;
   private static int lo;
   private static int lp;
   private static int lq;
   private static String lr;
   private static String ls;
   private static String[] lt;
   private static Image[][] lu;
   private static int lv;
   private static int[] lw;
   private static int[] lx;
   private static int[] ly;
   private static int[] lF;
   /** Số lượng / mục tiêu cần đạt để hoàn thành nhiệm vụ (theo {@link #activeQuestId}), song hành với {@link #lF}. */
   private static int[] questRequiredAmounts;
   private static int[] lH;
   private static int lI;
   private static int lJ;
   private static int lK;
   private static int lL;
   private static boolean lM;
   private static String[] lN;
   private static String[] lO;
   public static int Y;
   private static int lP;
   private static int lQ;
   private static Font lR;
   private static Font lS;
   private static int lT;
   private String lU = "12345678";
   private int lV;
   private static String lW;
   private static int[] lX;
   private static int lY;
   private int lZ = 0;
   private boolean ma = false;
   private String mb = "";
   private int mc;
   private int md;

   static {
      aH = new int[aq.length][3][3];

      for(int var0 = 0; var0 < aq.length; ++var0) {
         for(int var1 = 0; var1 < 3; ++var1) {
            for(int var2 = 0; var2 < 3; ++var2) {
               aH[var0][var1][var2] = aq[var0][var1][var2];
               if (var1 == 0 && var2 == 0) {
                  switch (aq[var0][var1][var2]) {
                     case 1:
                     case 2:
                        aH[var0][var1][var2] = 1;
                        break;
                     default:
                        aH[var0][var1][var2] = 0;
                  }
               }
            }
         }
      }

      aI = new int[]{-1, 2, 1, -2};
      aJ = new int[]{-3, 2, -1, 1};
      aK = -1;
      aM = true;
      aS = new boolean[14];
      aT = new boolean[14];
      aY = 0;
      bw = "";
      bH = -22;
      bI = 18;
      bJ = -10;
      bK = -19;
      bL = -12;
      bM = -26;
      WallJumpSkill.getInstance().setLearned(false);
      WallJumpSkill.getInstance().setL2Learned(false);
      WallJumpSkill.getInstance().setL3Learned(false);
      skillLegacyFlagEK = false;
      skillShurikenLearned = false;
      skillBurrowLearned = false;
      skillMotorcycleLearned = false;
      skillAttackDoubledQuest = false;
      skillSwimLearned = false;
      skillWaterRunLearned = false;
      skillTransformLearned = false;
      questBatReward5000Done = false;
      questTonikuBranchDone = false;
      questMeetGirlUnlocked = false;
      skillGateBeforeKC2 = false;
      shurikenLevel2Learned = false;
      skillSpeedBoostLearned = false;
      skillStandOnWaterLearned = false;
      skillStealthLegacyFlag = false;
      skillSetAmSatLearned(false);
      skillSetDashLearned(false);
      skillDashLevel = 1;
      syncSkillsFromLegacyFlags();
      questGeninFlagFB = false;
      questGeninGraduated = false;
      gameModeFv = true;
      fT = false;
      fV = 0;
      fX = new String[]{""};
      ga = 0;
      scriptMapId = -1;
      scriptExtraI = 1;
      escortActive = false;
      escortMapId = -1;
      hk = 500;
      hl = 60;
      hm = 60;
      hL = 20;
      hM = 60;
      hP = 50;
      scriptTableId = 10;
      mapObjectMountIndex = -1;
      mapNpcFocusIndex = -1;
      iA = false;

      try {
         Image.createImage("/attkButton.png");
      } catch (IOException var3) {
      }

      iM = "oplj";
      jf = 24;
      R = 0;
      jC = 0;
      S = 0;
      kn = null;
      ko = new int[]{0, 10, 15, 20};
      ku = ShopCatalog.ku;
      kv = ShopCatalog.kv;
      kw = new String[][]{{"2000vnđ / 50 bình", "3000vnđ / 50 bình", "3000vnđ / 30 bình", "2000vnđ / 50 bình", "2000vnđ / 30 bình", "3000vnđ / 50 bình"}, {"2000vnđ", "3000vnđ", "3000vnđ", "5000vnđ"}};
      kx = ShopCatalog.kx;
      kz = ShopCatalog.kz;
      kA = ShopCatalog.kA;
      kF = new int[]{12281360, 13859359, 15439166, 16693877, 16765346, 16777215, 16765346, 16693877, 15439166, 13859359, 12281360};
      kG = Item.getAllItemNames();
      inventoryCounts = new int[]{5, 2, 1, 5, 2, 1};
      kH = new int[]{100, 400, 1000, 100, 200, 300};
      kBagExt = new int[]{2, 0, 0, 1, 0, 0};
      kM = new String[]{"Sử dụng item", "Xem bản đồ", "Lưu và thoát", "Nhạc: Bật"};
      kN = map.getAllMapNames();
      kO = new int[]{50, 60, 70, 80, 90, 70, 100, 120, 150, 180, 220, 250, 300, 320, 350, 370, 390, 420, 450};
      mapUnlockFlags = new boolean[19];
      kP = new int[]{49, 31, 98, 112, 106, 42, 75, 84, 37, 39, 80, 117, 157, 201, 208, 170, 186, 219, 161};
      kQ = new int[]{35, 65, 38, 75, 98, 97, 95, 128, 142, 185, 212, 189, 189, 204, 156, 142, 96, 59, 39};
      kR = new int[]{62, 52, 17, 4, 8, 12, 14, 5, 1, 2, 3, 2, 2, 2, 2, 1, 2, 3, 1};
      kS = new int[]{17, 9, 12, 9, 10, 5, 9, 7, 12, 11, 4, 11, 8, 9, 7, 6, 11, 16, 8};
      lk = "Chuyển đến";
      lF = new int[]{1, 7, 100, 100, 6, 100, 100, 13, 100, 15, 100, 100, 18, 17, 10, 100, 100, 100};
      questRequiredAmounts = new int[]{2, 2, 0, 0, 20, 0, 0, 15, 0, 20, 0, 0, 70, 50, 30, 0, 0, 0};
      lH = new int[]{7, 6, 6, 5, 2, 4};
      lI = -1;
      lN = new String[]{"1. Tiep tuc", "2. Kich hoat", "3. Nhap ma kich hoat"};
      lO = new String[]{"1. Kich hoat", "2. Nhap ma kich hoat"};
      lR = Font.getFont(0, 0, 0);
      lS = Font.getFont(0, 1, 0);
      lT = lR.getHeight() + 6;
      lX = new int[9];
      lY = 10;

      for(int var4 = 0; var4 < 9; ++var4) {
         lX[var4] = (var4 << 1) + 1;
         int[] var7 = lX;
         var7[var4] += aW;
      }

   }

   public static void a() {
      int[] var1 = new int[500];
      int var2 = 0;
      if (playTimeSessionStartMs > 0L) {
         playTimeSeconds += (int)((System.currentTimeMillis() - playTimeSessionStartMs) / 1000L);
      }

      playTimeSessionStartMs = System.currentTimeMillis();
      ++var2;
      var1[0] = playTimeSeconds;
      ++var2;
      var1[1] = mapId;
      ++var2;
      var1[2] = mapSubIdLegacy;
      ++var2;
      var1[3] = hasSaveGame ? 1 : 0;
      ++var2;
      var1[4] = gold;
      ++var2;
      var1[5] = activationTrialFlag ? 1 : 0;
      ++var2;
      var1[6] = unlockedMap97 ? 1 : 0;
      ++var2;
      var1[7] = unlockedMap96 ? 1 : 0;
      ++var2;
      var1[8] = unlockedMap95 ? 1 : 0;
      ++var2;
      var1[9] = escortActive ? 1 : 0;
      ++var2;
      var1[10] = escortReservedLegacy;
      ++var2;
      var1[11] = escortMapId;
      ++var2;
      var1[12] = mapObjectMountIndex;
      ++var2;
      var1[13] = equippedWeaponIndex;
      ++var2;
      var1[14] = shurikenLevel2Learned ? 1 : 0;

      for(int var0 = 0; var0 < mapUnlockFlags.length; ++var0) {
         var1[var2++] = mapUnlockFlags[var0] ? 1 : 0;
      }

      for(int var4 = 0; var4 < inventoryCounts.length; ++var4) {
         var1[var2++] = inventoryCounts[var4];
      }

      var1[var2++] = WallJumpSkill.getInstance().getSaveFlag();
      var1[var2++] = skillLegacyFlagEK ? 1 : 0;
      var1[var2++] = skillShurikenLearned ? 1 : 0;
      var1[var2++] = skillBurrowLearned ? 1 : 0;
      var1[var2++] = skillMotorcycleLearned ? 1 : 0;
      var1[var2++] = skillAttackDoubledQuest ? 1 : 0;
      var1[var2++] = skillSwimLearned ? 1 : 0;
      var1[var2++] = skillWaterRunLearned ? 1 : 0;
      var1[var2++] = skillTransformLearned ? 1 : 0;
      var1[var2++] = questBatReward5000Done ? 1 : 0;
      var1[var2++] = questTonikuBranchDone ? 1 : 0;
      var1[var2++] = questMeetGirlUnlocked ? 1 : 0;
      var1[var2++] = skillGateBeforeKC2 ? 1 : 0;
      var1[var2++] = WallJumpSkill.getInstance().getL2SaveFlag();
      var1[var2++] = skillSpeedBoostLearned ? 1 : 0;
      var1[var2++] = skillStandOnWaterLearned ? 1 : 0;
      var1[var2++] = skillStealthLegacyFlag ? 1 : 0;
      var1[var2++] = questGeninFlagFB ? 1 : 0;
      var1[var2++] = questGeninGraduated ? 1 : 0;
      var1[var2++] = mountFacing;
      var1[var2++] = mountSubstate;
      var1[var2++] = playerX;
      var1[var2++] = playerY;
      var1[var2++] = y;
      var1[var2++] = z;
      var1[var2++] = playerState;
      var1[var2++] = B;
      var1[var2++] = playerTimer0;
      var1[var2++] = spriteHeight;
      var1[var2++] = halfWidth;
      var1[var2++] = halfHeight;
      var1[var2++] = playerTimer1;
      var1[var2++] = playerTimer2;
      var1[var2++] = playerFacing;
      var1[var2++] = airComboTier;
      var1[var2++] = burrowSubstate;
      var1[var2++] = moveCounter;
      var1[var2++] = atk;
      var1[var2++] = shurikenDmg;
      var1[var2++] = hp;
      var1[var2++] = hpMax;
      var1[var2++] = mp;
      var1[var2++] = mpMax;
      var1[var2++] = K;
      var1[var2++] = L;
      var1[var2++] = cameraScrollX;
      var1[var2++] = cameraScrollY;
      var1[var2++] = cameraBound;
      var1[var2++] = timerFt;
      var1[var2++] = timerFu;
      var1[var2++] = level;
      var1[var2++] = expInLevel;
      var1[var2++] = gameModeFv ? 1 : 0;
      var1[var2++] = gameModeFw ? 1 : 0;
      var1[var2++] = gameModeFx ? 1 : 0;
      var1[var2++] = genderSpriteFlag ? 1 : 0;
      var1[var2++] = activeQuestId;
      var1[var2++] = questParam;
      var1[var2++] = questTarget;
      var1[var2++] = questBool ? 1 : 0;
      var1[var2++] = questProgress;
      var1[var2++] = interactTargetId;
      var1[var2++] = interactSubId;
      var1[var2++] = npcInteractIndex;
      var1[var2++] = npcInteractSub;
      var1[var2++] = cutsceneG;
      var1[var2++] = cutsceneH;
      var1[var2++] = cutsceneI;
      var1[var2++] = cutsceneJ;
      var1[var2++] = cutsceneK;
      var1[var2++] = cutsceneL;
      var1[var2++] = cutsceneM;
      var1[var2++] = cutsceneN;
      var1[var2++] = cutsceneO;
      var1[var2++] = cutsceneP;
      var1[var2++] = cutsceneQ;
      var1[var2++] = cutsceneR;
      var1[var2++] = cutsceneS;
      var1[var2++] = scriptRunnerActive ? 1 : 0;
      var1[var2++] = scriptTableId;
      var1[var2++] = scriptStep;
      var1[var2++] = scriptMapId;
      var1[var2++] = scriptExtraD;
      var1[var2++] = scriptExtraE;
      var1[var2++] = scriptExtraF;
      var1[var2++] = scriptExtraG;
      var1[var2++] = scriptExtraH;
      var1[var2++] = scriptExtraI;
      var1[var2++] = scriptExtraJ;
      var1[var2++] = scriptExtraK;
      var1[var2++] = companionX;
      var1[var2++] = companionY;
      var1[var2++] = companionVel;
      var1[var2++] = companionAccel;
      var1[var2++] = companionMode;
      var1[var2++] = companionT0;
      var1[var2++] = companionT1;
      var1[var2++] = companionT2;
      var1[var2++] = companionT3;
      var1[var2++] = companionT4;
      var1[var2++] = companionT5;
      var1[var2++] = companionT6;
      var1[var2++] = companionFaceDir;
      var1[var2++] = companionB;
      var1[var2++] = companionC;
      var1[var2++] = companionD;
      var1[var2++] = companionE;
      var1[var2++] = companionF;
      var1[var2++] = companionG;
      var1[var2++] = companionH;
      var1[var2++] = companionI;
      var1[var2++] = companionJ;
      var1[var2++] = companionK;
      var1[var2++] = hpCurrentAlt;
      var1[var2++] = regenTimer;
      var1[var2++] = idleTimerLong;
      var1[var2++] = bossThreshold;
      var1[var2++] = scriptHsStep;
      var1[var2++] = mapObjectBundleCount;
      if (mapObjectBundleCount > 0) {
         for(int var5 = 0; var5 < mapObjType.length; ++var5) {
            var1[var2++] = mapObjType[var5];
         }

         for(int var6 = 0; var6 < mapObjFacing.length; ++var6) {
            var1[var2++] = mapObjFacing[var6];
         }

         for(int var7 = 0; var7 < mapObjAnim.length; ++var7) {
            var1[var2++] = mapObjAnim[var7];
         }

         for(int var8 = 0; var8 < mapObjExtra.length; ++var8) {
            var1[var2++] = mapObjExtra[var8];
         }

         for(int var9 = 0; var9 < mapObjTileX.length; ++var9) {
            var1[var2++] = mapObjTileX[var9];
         }

         for(int var10 = 0; var10 < mapObjTileY.length; ++var10) {
            var1[var2++] = mapObjTileY[var10];
         }
      }

      var1[var2++] = mapNpcBundleCount;
      if (mapNpcBundleCount > 0) {
         var1[var2++] = mapNpcFocusIndex;
         if (mapNpcDir != null) {
            for(int var11 = 0; var11 < mapNpcDir.length; ++var11) {
               var1[var2++] = mapNpcDir[var11];
            }
         }

         if (mapNpcIz != null) {
            for(int var12 = 0; var12 < mapNpcIz.length; ++var12) {
               var1[var2++] = mapNpcIz[var12];
            }
         }

         if (mapNpcIy != null) {
            for(int var13 = 0; var13 < mapNpcIy.length; ++var13) {
               var1[var2++] = mapNpcIy[var13];
            }
         }

         if (mapNpcIw != null) {
            for(int var14 = 0; var14 < mapNpcIw.length; ++var14) {
               var1[var2++] = mapNpcIw[var14];
            }
         }

         if (mapNpcIx != null) {
            for(int var15 = 0; var15 < mapNpcIx.length; ++var15) {
               var1[var2++] = mapNpcIx[var15];
            }
         }

         if (mapNpcTileX != null) {
            for(int var16 = 0; var16 < mapNpcTileX.length; ++var16) {
               var1[var2++] = mapNpcTileX[var16];
            }
         }

         if (mapNpcTileY != null) {
            for(int var17 = 0; var17 < mapNpcTileY.length; ++var17) {
               var1[var2++] = mapNpcTileY[var17];
            }
         }
      }

      var1[var2++] = WallJumpSkill.getInstance().getL3SaveFlag();
      skillSyncDashLevelToLegacy();
      var1[var2++] = skillDashLearned ? 1 : 0;
      var1[var2++] = skillAmbushLearned ? 1 : 0;
      var1[var2++] = skillDashLevel;
      int[] var18 = var1;
      int var19;
      byte[] var156 = new byte[(var19 = var1.length) << 2];

      for(int var3 = 0; var3 < var19; ++var3) {
         var156[var3 << 2] = (byte)(var18[var3] >> 24);
         var156[(var3 << 2) + 1] = (byte)(var18[var3] >>> 16);
         var156[(var3 << 2) + 2] = (byte)(var18[var3] >>> 8);
         var156[(var3 << 2) + 3] = (byte)var18[var3];
      }

      Midlet.a("ninjasave", var156);
      Midlet.a(true);
   }

   private static boolean mapIdValid(int var0) {
      if (var0 >= 0 && var0 <= 18) {
         return true;
      } else {
         return var0 == 94 || var0 == 95 || var0 == 96 || var0 == 97 || var0 == 99 || var0 == 101;
      }
   }

   private static int fixMapId(int var0) {
      if (mapIdValid(var0)) {
         return var0;
      } else {
         System.err.println("[MAP] invalid map id " + var0 + " in save -> 0");
         return 0;
      }
   }

   public static void b() {
      int[] var0 = a(Midlet.b("ninjasave"));
      int var2 = 0;
      ++var2;
      playTimeSeconds = var0[0];
      ++var2;
      mapId = fixMapId(var0[1]);
      ++var2;
      mapSubIdLegacy = var0[2];
      ++var2;
      hasSaveGame = var0[3] == 1;
      ++var2;
      gold = var0[4];
      ++var2;
      activationTrialFlag = var0[5] == 1;
      ++var2;
      unlockedMap97 = var0[6] == 1;
      ++var2;
      unlockedMap96 = var0[7] == 1;
      ++var2;
      unlockedMap95 = var0[8] == 1;
      ++var2;
      escortActive = var0[9] == 1;
      ++var2;
      escortReservedLegacy = var0[10];
      ++var2;
      escortMapId = var0[11];
      ++var2;
      mapObjectMountIndex = var0[12];
      ++var2;
      equippedWeaponIndex = var0[13];
      ++var2;
      shurikenLevel2Learned = var0[14] == 1;

      for(int var1 = 0; var1 < mapUnlockFlags.length; ++var1) {
         mapUnlockFlags[var1] = var0[var2++] == 1;
      }

      for(int var7 = 0; var7 < inventoryCounts.length; ++var7) {
         inventoryCounts[var7] = var0[var2++];
      }

      WallJumpSkill.getInstance().loadSaveFlag(var0[var2++]);
      skillLegacyFlagEK = var0[var2++] == 1;
      skillShurikenLearned = var0[var2++] == 1;
      skillBurrowLearned = var0[var2++] == 1;
      skillMotorcycleLearned = var0[var2++] == 1;
      skillAttackDoubledQuest = var0[var2++] == 1;
      skillSwimLearned = var0[var2++] == 1;
      skillWaterRunLearned = var0[var2++] == 1;
      skillTransformLearned = var0[var2++] == 1;
      questBatReward5000Done = var0[var2++] == 1;
      questTonikuBranchDone = var0[var2++] == 1;
      questMeetGirlUnlocked = var0[var2++] == 1;
      skillGateBeforeKC2 = var0[var2++] == 1;
      WallJumpSkill.getInstance().loadL2SaveFlag(var0[var2++]);
      skillSpeedBoostLearned = var0[var2++] == 1;
      skillStandOnWaterLearned = var0[var2++] == 1;
      skillStealthLegacyFlag = var0[var2++] == 1;
      questGeninFlagFB = var0[var2++] == 1;
      questGeninGraduated = var0[var2++] == 1;
      mountFacing = var0[var2++];
      mountSubstate = var0[var2++];
      playerX = var0[var2++];
      playerY = var0[var2++];
      y = var0[var2++];
      z = var0[var2++];
      playerState = var0[var2++];
      B = var0[var2++];
      playerTimer0 = var0[var2++];
      spriteHeight = var0[var2++];
      halfWidth = var0[var2++];
      halfHeight = var0[var2++];
      playerTimer1 = var0[var2++];
      playerTimer2 = var0[var2++];
      playerFacing = var0[var2++];
      airComboTier = var0[var2++];
      burrowSubstate = var0[var2++];
      moveCounter = var0[var2++];
      atk = var0[var2++];
      shurikenDmg = var0[var2++];
      hp = var0[var2++];
      hpMax = var0[var2++];
      mp = var0[var2++];
      mpMax = var0[var2++];
      K = var0[var2++];
      L = var0[var2++];
      cameraScrollX = var0[var2++];
      cameraScrollY = var0[var2++];
      cameraBound = var0[var2++];
      timerFt = var0[var2++];
      timerFu = var0[var2++];
      level = var0[var2++];
      expInLevel = var0[var2++];
      gameModeFv = var0[var2++] == 1;
      gameModeFw = var0[var2++] == 1;
      gameModeFx = var0[var2++] == 1;
      genderSpriteFlag = var0[var2++] == 1;
      activeQuestId = var0[var2++];
      questParam = var0[var2++];
      questTarget = var0[var2++];
      questBool = var0[var2++] == 1;
      questProgress = var0[var2++];
      interactTargetId = var0[var2++];
      interactSubId = var0[var2++];
      npcInteractIndex = var0[var2++];
      npcInteractSub = var0[var2++];
      cutsceneG = var0[var2++];
      cutsceneH = var0[var2++];
      cutsceneI = var0[var2++];
      cutsceneJ = var0[var2++];
      cutsceneK = var0[var2++];
      cutsceneL = var0[var2++];
      cutsceneM = var0[var2++];
      cutsceneN = var0[var2++];
      cutsceneO = var0[var2++];
      cutsceneP = var0[var2++];
      cutsceneQ = var0[var2++];
      cutsceneR = var0[var2++];
      cutsceneS = var0[var2++];
      scriptRunnerActive = var0[var2++] == 1;
      scriptTableId = var0[var2++];
      scriptStep = var0[var2++];
      scriptMapId = var0[var2++];
      scriptExtraD = var0[var2++];
      scriptExtraE = var0[var2++];
      scriptExtraF = var0[var2++];
      scriptExtraG = var0[var2++];
      scriptExtraH = var0[var2++];
      scriptExtraI = var0[var2++];
      scriptExtraJ = var0[var2++];
      scriptExtraK = var0[var2++];
      companionX = var0[var2++];
      companionY = var0[var2++];
      companionVel = var0[var2++];
      companionAccel = var0[var2++];
      companionMode = var0[var2++];
      companionT0 = var0[var2++];
      companionT1 = var0[var2++];
      companionT2 = var0[var2++];
      companionT3 = var0[var2++];
      companionT4 = var0[var2++];
      companionT5 = var0[var2++];
      companionT6 = var0[var2++];
      companionFaceDir = var0[var2++];
      companionB = var0[var2++];
      companionC = var0[var2++];
      companionD = var0[var2++];
      companionE = var0[var2++];
      companionF = var0[var2++];
      companionG = var0[var2++];
      companionH = var0[var2++];
      companionI = var0[var2++];
      companionJ = var0[var2++];
      companionK = var0[var2++];
      if ((hpCurrentAlt = var0[var2++]) <= 0) {
         hpCurrentAlt = hpMaxBaseline;
      }

      regenTimer = var0[var2++];
      idleTimerLong = var0[var2++];
      bossThreshold = var0[var2++];
      scriptHsStep = var0[var2++];
      int var275 = var2++;
      int var10000 = var0[var275];
      var275 = var0[var275];
      if (var10000 > 0) {
         try {
            for(int var8 = 0; var8 < mapObjType.length; ++var8) {
               ++var2;
            }

            for(int var9 = 0; var9 < mapObjFacing.length; ++var9) {
               ++var2;
            }

            for(int var10 = 0; var10 < mapObjAnim.length; ++var10) {
               ++var2;
            }

            for(int var11 = 0; var11 < mapObjExtra.length; ++var11) {
               ++var2;
            }

            for(int var12 = 0; var12 < mapObjTileX.length; ++var12) {
               ++var2;
            }

            for(int var13 = 0; var13 < mapObjTileY.length; ++var13) {
               ++var2;
            }
         } catch (Exception var6) {
         }
      }

      if ((mapNpcBundleCount = var0[var2++]) > 0) {
         ensureIrNpcArraysSized();
         mapNpcFocusIndex = var0[var2++];

         try {
            for(int var14 = 0; var14 < mapNpcDir.length; ++var14) {
               mapNpcDir[var14] = var0[var2++];
            }

            for(int var15 = 0; var15 < mapNpcIz.length; ++var15) {
               mapNpcIz[var15] = var0[var2++];
            }

            for(int var16 = 0; var16 < mapNpcIy.length; ++var16) {
               mapNpcIy[var16] = var0[var2++];
            }

            for(int var17 = 0; var17 < mapNpcIw.length; ++var17) {
               mapNpcIw[var17] = var0[var2++];
            }

            for(int var18 = 0; var18 < mapNpcIx.length; ++var18) {
               mapNpcIx[var18] = var0[var2++];
            }

            for(int var19 = 0; var19 < mapNpcTileX.length; ++var19) {
               mapNpcTileX[var19] = var0[var2++];
            }

            for(int var20 = 0; var20 < mapNpcTileY.length; ++var20) {
               mapNpcTileY[var20] = var0[var2++];
            }
         } catch (Exception var5) {
         }
      }

      if (var0.length > var2) {
         WallJumpSkill.getInstance().loadL3SaveFlag(var0[var2++]);
      } else {
         WallJumpSkill.getInstance().setL3Learned(false);
      }

      if (var0.length > var2) {
         skillSetDashLearned(var0[var2++] == 1);
      } else {
         skillSetDashLearned(false);
      }

      if (var0.length > var2) {
         skillSetAmSatLearned(var0[var2++] == 1);
      } else {
         skillSetAmSatLearned(false);
      }

      if (var0.length > var2) {
         skillDashLevel = var0[var2++];
      } else {
         skillDashLevel = 1;
      }

      syncSkillsFromLegacyFlags();
      syncDashDurationToLevel();

      if (genderSpriteFlag) {
         if (eq == null) {
            eq = new Image[4];

            try {
               eq[0] = Image.createImage("/cp/ch0x.png");
               eq[1] = Image.createImage("/cp/ch1x.png");
            } catch (Exception var4) {
            }

            eq[2] = eq[1];
            eq[3] = eq[0];
         }

         for(int var21 = 0; var21 < 4; ++var21) {
            Image var3 = ep[var21];
            ep[var21] = eq[var21];
            eq[var21] = var3;
         }
      }

   }

   private static int[] a(byte[] var0) {
      int var1;
      int[] var3 = new int[(var1 = var0.length) >> 2];

      for(int var2 = 0; var2 < var3.length; ++var2) {
         var3[var2] = (var0[var2 << 2] << 24) + ((var0[(var2 << 2) + 1] & 255) << 16) + ((var0[(var2 << 2) + 2] & 255) << 8) + (var0[(var2 << 2) + 3] & 255);
      }

      return var3;
   }

   public static final int a(int var0) {
      return var0 > 0 ? var0 : -var0;
   }

   /** MP tiêu hao mỗi lần dash — ủy quyền {@link DashSkill}. */
   static int getDashManaCostPublic() {
      return DashSkill.getInstance().resolveManaCost();
   }

   /** Trừ MP (mp/mpMax — thanh trắng); hp/hpMax là HP (thanh đỏ). Popup dùng fs1 (không dùng fs0 đỏ như trừ HP). */
   private static boolean spendMp(int var0) {
      if (mp < var0) {
         return false;
      }
      mp -= var0;
      if (mp < 0) {
         mp = 0;
      }
      c = true;
      a("-" + var0, 0, playerX, playerY - spriteHeight, 0, -2);
      return true;
   }

   // --- Skill bridge (SkillContext / SkillTemplate) — skill con gọi qua GameSkillContext ---

   static boolean skillBridgeIsGameplay() {
      return d == 1 && !fT && !iA;
   }

   static int skillBridgeGetPlayerState() {
      return playerState;
   }

   static int skillBridgeGetPlayerX() {
      return playerX;
   }

   static int skillBridgeGetPlayerY() {
      return playerY;
   }

   static int skillBridgeGetPlayerMp() {
      return mp;
   }

   static int skillBridgeGetPlayerFacing() {
      return playerFacing;
   }

   static void skillBridgeSetPlayerFacing(int var0) {
      playerFacing = var0;
   }

   static void skillBridgeSetPlayerPosition(int var0, int var1) {
      playerX = var0;
      playerY = var1;
   }

   static boolean skillBridgeSpendMp(int var0) {
      return spendMp(var0);
   }

   static void skillBridgeShowMessage(String var0) {
      c(var0);
   }

   static void skillBridgeRequestRepaint() {
      c = true;
   }

   /** Trạng thái cho phép ám sát (đứng / chạy / rơi; không dash / state đặc biệt). */
   static boolean skillBridgeCanUseAmbush(int var0) {
      if (var0 == DashSkill.STATE_DASH || var0 == 5 || var0 == 3) {
         return false;
      }
      return var0 == 1 || var0 == 2 || var0 == 4;
   }

   static void syncSkillsFromLegacyFlags() {
      DashSkill dash = DashSkill.getInstance();
      dash.setLearned(skillDashLearned);
      dash.setManaCostOverride(dashManaCost);
      dash.syncLevelFromLegacy(skillDashLevel);
      AmbushSkill.getInstance().setLearned(skillAmbushLearned);
      AmbushSkill.getInstance().setBaseManaCost(amSatManaCost > 0 ? amSatManaCost : 40);
   }

   static void skillSetDashLearned(boolean var0) {
      skillDashLearned = var0;
      DashSkill.getInstance().setLearned(var0);
   }

   static void skillSyncDashLevelToLegacy() {
      skillDashLevel = DashSkill.getInstance().getLevelForLegacySave();
   }

   static void skillSetAmSatLearned(boolean var0) {
      skillAmbushLearned = var0;
      AmbushSkill.getInstance().setLearned(var0);
      if (!var0) {
         AmbushSkill.getInstance().clearAmbushPose();
      }
   }

   static int getAmSatManaCostPublic() {
      return amSatManaCost > 0 ? amSatManaCost : 40;
   }

   static int skillBridgeAbs(int var0) {
      return a(var0);
   }

   static int skillBridgeGetFallZ() {
      return z;
   }

   static void skillBridgeSetPlayerState(int var0) {
      playerState = var0;
   }

   static void skillBridgeResetMoveVelocity() {
      y = 0;
      z = 0;
      airComboTier = 0;
      burrowSubstate = 0;
   }

   static void skillBridgeClearInteractHint() {
      interactTargetId = -1;
      interactSubId = -1;
      o = " ";
   }

   static int skillBridgeGetHalfWidth() {
      return halfWidth;
   }

   static int skillBridgeGetHalfHeight() {
      return halfHeight;
   }

   static int skillBridgeGetSpriteH() {
      return spriteHeight;
   }

   static boolean skillBridgeWallLeft(int var0, int var1) {
      return g(var0 - halfWidth - 1, var1 - halfHeight, 8);
   }

   static boolean skillBridgeWallRight(int var0, int var1) {
      return g(var0 + halfWidth, var1 - halfHeight, 4);
   }

   static int skillBridgeSnapXFromWallLeft(int var0) {
      return I(var0 - halfWidth - 1) + jf + halfWidth;
   }

   static int skillBridgeSnapXFromWallRight(int var0) {
      return I(var0 + halfWidth) - halfWidth;
   }

   static boolean skillBridgeDashFeetOnGround() {
      return ((i(playerX, playerY) | i(playerX, playerY + halfHeight) | i(playerX, playerY + 8) | i(playerX, playerY + 14)) & 2) != 0;
   }

   static boolean skillBridgeTileOnGround(int var0, int var1) {
      return ((i(var0, var1) | i(var0, var1 + halfHeight) | i(var0, var1 + 8)) & 2) != 0;
   }

   /** Hiệu ứng ám sát (không còn flash {@code dY}) — pose vẽ trên nhân vật qua {@link AmbushSkill}. */
   static void skillBridgePlayAmbushFx(int var0, int var1, int var2) {
      e(var2, var0 - (var2 << 3), var1);
      S();
      x();
   }

   static boolean skillBridgeDeferAmbushGravity() {
      return AmbushSkill.getInstance().shouldDeferGravity();
   }

   static void skillBridgeDashRunFx(int var0, int var1) {
      e(var0, var1 - (var0 << 3), playerY);
   }

   static void skillBridgeSetCombatAttackPhase() {
      timerFu = 0;
      airComboTier = 0;
   }

   static int skillBridgeProjectileSlots() {
      return cW;
   }

   static boolean skillBridgeProjectileAlive(int var0) {
      return cZ[var0] != -1;
   }

   static int skillBridgeProjectileX(int var0) {
      return cX[var0];
   }

   static int skillBridgeProjectileY(int var0) {
      return cY[var0];
   }

   static int skillBridgeProjectileDir(int var0) {
      return db[var0];
   }

   static boolean skillBridgeProjectileFlying(int var0) {
      return dd[var0];
   }

   static int skillBridgeMapMobSlots() {
      return cq;
   }

   static int skillBridgeMapMobState(int var0) {
      return cF[var0];
   }

   static int skillBridgeMapMobX(int var0) {
      return cv[var0];
   }

   static int skillBridgeMapMobY(int var0) {
      return cw[var0];
   }

   static int skillBridgeMapMobFace(int var0) {
      return cI[var0];
   }

   static int skillBridgeJMobSlots() {
      return jI;
   }

   static int skillBridgeJMobState(int var0) {
      return jQ[var0];
   }

   static int skillBridgeJMobX(int var0) {
      return jL[var0];
   }

   static int skillBridgeJMobY(int var0) {
      return jM[var0];
   }

   static int skillBridgeJMobFace(int var0) {
      return jZ[var0];
   }

   static void skillBridgeSetFallZ(int var0) {
      z = var0;
   }

   static int skillBridgeGetAirComboTier() {
      return airComboTier;
   }

   static void skillBridgeIncrementAirComboTier() {
      ++airComboTier;
   }

   static boolean skillBridgeGetLegacyFlagEK() {
      return skillLegacyFlagEK;
   }

   /** Trừ MP khinh công trên không — không popup (giữ feel cũ). */
   static void skillBridgeSubtractMpSilent(int var0) {
      if ((mp -= var0) < 0) {
         mp = 0;
      }
      c = true;
   }

   static void skillBridgePlayWallJumpAirFx() {
      e(-1, playerX - -8, playerY);
      e(1, playerX - 8, playerY);
      g(playerX, playerY);
   }

   static boolean skillBridgeIsWallJumpLearned() {
      return WallJumpSkill.getInstance().isLearned();
   }

   static boolean skillBridgeIsWallJumpL2Learned() {
      return WallJumpSkill.getInstance().isL2Learned();
   }

   static boolean skillBridgeIsWallJumpL3Learned() {
      return WallJumpSkill.getInstance().isL3Learned();
   }

   static int skillBridgeZForInitialJump() {
      return WallJumpSkill.getInstance().zForInitialJump();
   }

   static boolean skillBridgeTryAirKhinhCongBoost() {
      return WallJumpSkill.getInstance().tryAirBoost();
   }

   static void skillBridgeSetWallJumpLearned(boolean var0) {
      WallJumpSkill.getInstance().setLearned(var0);
   }

   static void skillBridgeSetWallJumpL2Learned(boolean var0) {
      WallJumpSkill.getInstance().setL2Learned(var0);
   }

   static void skillBridgeSetWallJumpL3Learned(boolean var0) {
      WallJumpSkill.getInstance().setL3Learned(var0);
   }

   static void skillBridgeSetMoveD(int var0) {
      burrowSubstate = var0;
   }

   static void skillBridgeDashAfterMove() {
      x();
      S();
   }

   /** Cập nhật thời gian dash theo cấp — ủy quyền {@link DashSkill}. */
   public static void syncDashDurationToLevel() {
      DashSkill dash = DashSkill.getInstance();
      dash.syncLevelFromLegacy(skillDashLevel);
      dashManaCost = dash.getManaCostOverride();
      dashDurationMs = dash.getDurationMs();
   }

   /** Học kỹ năng dash (gọi từ NPC / nhiệm vụ). */
   public static void learnDashSkill() {
      skillSetDashLearned(true);
      if (skillDashLevel < 1) {
         skillDashLevel = 1;
      }
      DashSkill.getInstance().syncLevelFromLegacy(skillDashLevel);
      syncDashDurationToLevel();
      c("đã học kỹ năng lướt (dash)!");
   }

   /*
    * LEGACY skill trong a.java (đã chuyển sang DashSkill / AmbushSkill) — giữ log đối chiếu.
    * Dash: tryStartPlayerDash, onDashDirectionKey, updatePlayerDash, canPlayerDash, dashPlayerFeetTouchGroundMask
    * Ám sát: tryAmSatSkill, amSatEntityOnGround, amSatProjectileVerticalOk, amSatMapMobVerticalOk, amSatJMobVerticalOk
    */

   // --- Debug refactor bridge (no-op unless DebugRefactor.DEBUG_REFACTOR) ---

   static int debugBridgeGetMapId() {
      return mapId;
   }

   static void debugBridgeTeleportMap(int var0) {
      if (!DebugRefactor.DEBUG_REFACTOR) {
         return;
      }
      if (!mapIdValid(var0)) {
         System.err.println("[DBG] invalid map id " + var0);
         return;
      }
      A();
      Midlet.f = true;
      x(var0);
      skillBridgeShowMessage("DBG map -> " + var0);
   }

   static void debugBridgeUnlockAllSkills() {
      if (!DebugRefactor.DEBUG_REFACTOR) {
         return;
      }
      skillBridgeSetWallJumpLearned(true);
      skillLegacyFlagEK = true;
      skillShurikenLearned = true;
      skillBurrowLearned = true;
      skillMotorcycleLearned = true;
      skillAttackDoubledQuest = true;
      skillSwimLearned = true;
      skillWaterRunLearned = true;
      skillTransformLearned = true;
      questBatReward5000Done = true;
      questTonikuBranchDone = true;
      questMeetGirlUnlocked = true;
      skillGateBeforeKC2 = true;
      skillBridgeSetWallJumpL2Learned(true);
      skillBridgeSetWallJumpL3Learned(true);
      skillSpeedBoostLearned = true;
      skillStandOnWaterLearned = true;
      skillStealthLegacyFlag = true;
      skillSetAmSatLearned(true);
      skillSetDashLearned(true);
      syncDashDurationToLevel();
      for (int var1 = 0; var1 < mapUnlockFlags.length; ++var1) {
         mapUnlockFlags[var1] = true;
      }
      skillBridgeShowMessage("DBG unlock skills+maps");
   }

   static void debugBridgeAddExp(int var0) {
      if (!DebugRefactor.DEBUG_REFACTOR) {
         return;
      }
      u(var0);
   }

   static void debugBridgeSpawnTestMob(int var0) {
      if (!DebugRefactor.DEBUG_REFACTOR) {
         return;
      }
      if (var0 < 0 || var0 >= MonsterData.NAMES.length) {
         var0 = 0;
      }
      int var2;
      for (var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }
      if (var2 >= jI) {
         skillBridgeShowMessage("DBG mob slots full");
         return;
      }
      ki[var2] = 0;
      jK[var2] = var0;
      jL[var2] = playerX + (playerFacing >= 0 ? 48 : -48);
      jM[var2] = playerY;
      ke[var2] = 25;
      kf[var2] = 10;
      jN[var2] = 27;
      jO[var2] = 15;
      jZ[var2] = playerFacing != 0 ? playerFacing : -1;
      jQ[var2] = 2;
      jV[var2] = var2 * 7;
      ka[var2] = kb[var2] = MonsterData.HP[jK[var2]];
      kc[var2] = MonsterData.DAMAGE[jK[var2]];
      kh[var2] = MonsterData.HIT_STAT[jK[var2]];
      kd[var2] = 0;
      skillBridgeShowMessage("DBG spawn " + MonsterData.getName(var0));
   }

   static String debugBridgeDumpPlayerState() {
      if (!DebugRefactor.DEBUG_REFACTOR) {
         return "";
      }
      String var0;
      try {
         var0 = map.getMapName(mapId);
      } catch (Exception var1) {
         var0 = "?";
      }
      return "map=" + mapId + "(" + var0 + ") xy=" + playerX + "," + playerY + " st=" + playerState
         + " lv=" + level + " exp=" + expInLevel + "/" + ai[level - 1]
         + " HP=" + hp + "/" + hpMax + " MP=" + mp + "/" + mpMax
         + " dash=" + skillDashLearned + " L" + skillDashLevel + " amsat=" + skillAmbushLearned
         + " quest=" + activeQuestId;
   }

   static String debugBridgeDumpSaveState() {
      if (!DebugRefactor.DEBUG_REFACTOR) {
         return "";
      }
      return "save map=" + mapId + " money=" + gold + " xy=" + playerX + "," + playerY
         + " lv=" + level + " exp=" + expInLevel + " escortActive=" + (escortActive ? 1 : 0)
         + " escortMapId=" + escortMapId + " dash=" + (skillDashLearned ? 1 : 0)
         + " amsat=" + (skillAmbushLearned ? 1 : 0) + " dashLv=" + skillDashLevel;
   }

   private static void a(int var0, int var1, int var2, int var3, int var4) {
      int var5;
      for(var5 = 0; var5 < df && di[var5] != 0; ++var5) {
      }

      if (var5 != df) {
         dg[var5] = var0;
         dh[var5] = var1;
         dj[var5] = var2;
         dk[var5] = var3;
         di[var5] = 1;
         dm[var5] = var4;
         if (var4 < 160) {
            dn[var5] = 0;
         } else if (var4 < 600) {
            dn[var5] = 1;
         } else {
            dn[var5] = 2;
         }
      }
   }

   private static void a(int var0, int var1, int var2, int var3, int var4, int var5) {
      for(var3 = 0; var3 < cN && cR[var3] != 0; ++var3) {
      }

      if (var3 != cN) {
         cP[var3] = var0;
         cQ[var3] = var1;
         cS[var3] = var2;
         cT[var3] = -5;
         cR[var3] = 1;
         cV[var3] = var4;
         cO[var3] = var5;
         if (var4 < 100) {
            cU[var3] = 0;
         } else if (var4 < 200) {
            cU[var3] = 1;
         } else {
            cU[var3] = 2;
         }
      }
   }

   private static void u(int var0) {
      if ((expInLevel += var0) > ai[level - 1]) {
         expInLevel = 0;
         if (Midlet.lowGfx && level == 6) {
            s(6);
            a("Xin đăng ký để có thể lên cấp 7!");
            d = 7;
            return;
         }

         ++level;
         atk += ah[level - 2];
         shurikenDmg += 2;
         hp = hpMax += aj[level - 2];
         mp = mpMax;
         a("level-up", 2, playerX, playerY - spriteHeight, 0, -2);
         s(6);
         a("Chúc mừng! Bạn đạt được cấp " + level + '\n' + "HP: " + hpMax + '\n' + "Sức đánh: " + (atk + (atk >> 2) * (equippedWeaponIndex + 1)));
         d = 7;
      } else {
         a("+" + var0, 2, playerX, playerY - spriteHeight, 0, -2);
      }

      c = true;
   }

   private static void u() {
      if (activeQuestId == 11 && z != 0) {
         ++questProgress;
         if (activeQuestId >= 20) {
            c("Thành công 20 hit!");
         } else {
            c("Hit: " + questProgress);
         }
      }

      int var0;
      var0 = (var0 = atk + mapSubIdLegacy % (atk >> 1)) + (var0 >> 1) * equippedWeaponIndex;
      if (genderSpriteFlag) {
         var0 <<= 1;
      }

      if (mountSubstate == 1) {
         a(playerX + (playerFacing << 3), playerY - 12, (playerFacing << 3) + y, z << 1, false);
      } else {
         if (z > 0 && y == 0) {
            z = -2;
         }

         int var1 = z();
         fs = false;
         if (var1 != -1) {
            fs = true;
            k(var1, var0, -playerFacing);
            f(jL[var1], jM[var1] - (jN[var1] >> 1), playerFacing);
            a("-" + var0, 0, jL[var1], jM[var1] - jN[var1], 0, -2);
            if (z > 0) {
               z = -6;
            }

            Q();
         }

         for(int var3 = 0; var3 < mapNpcBundleCount; ++var3) {
            if (a(playerY - halfHeight - mapNpcTileY[var3]) < 20 && a(playerX + (playerFacing << 4) - mapNpcTileX[var3]) < 24) {
               mapNpcDir[var3] = 2;
               mapNpcIw[var3] = playerFacing << 3;
               f(mapNpcTileX[var3], mapNpcTileY[var3] - 12, playerFacing);
               Q();
               break;
            }
         }

         if (gO && a(playerY - gR) < 30 && a(playerX + (playerFacing << 4) - gQ) < 40) {
            if (!c(var0, -playerFacing)) {
               f(playerX + (gQ - playerX >> 1), playerY - 12, playerFacing);
               a("-" + var0, 0, gQ, gR - gX, 0, -2);
            }

            Q();
         }

         for(int var4 = 0; var4 < cq; ++var4) {
            if (a(playerY - cw[var4]) <= 12 && a(playerX + (playerFacing << 4) - cv[var4]) < 24) {
               a(var4, var0, -playerFacing);
               f(cv[var4], cw[var4] - 15, playerFacing);
               a("-" + var0, 0, cv[var4], cw[var4] - 28, 0, -2);
               Q();
               break;
            }
         }

         if (hK && a(playerY - (hR - 40)) < 30 && a(playerX + (playerFacing << 4) - hQ) < 40) {
            if ((bossThreshold -= var0) <= 0) {
               bossThreshold = 0;
               ic = 0;
               id = 0;
               hY = 1;
               a(hQ, hR, 4, -10, 600);
               a(hQ, hR, -4, -17, 600);
               a(hQ, hR, -3, -18, 600);
               a(hQ, hR, 4, -19, 600);
               a(hQ, hR, 0, -10, 600);
               boolean var10000 = false;
            } else {
               id = 50;
               boolean var5 = false;
            }

            f(playerX + (hQ - playerX >> 1), playerY - 12, playerFacing);
            a("-" + var0, 0, hQ, hR - hM, 0, -2);
            Q();
         }

         if (hd) {
            if (a(playerY - dB[0]) < 5 && a(playerX + (playerFacing << 4) - dA[0]) < 30) {
               d(var0, playerFacing);
            }

            Q();
         }

         if (hj) {
            if (a(playerY - (hr - 30)) < 30 && a(playerX + (playerFacing << 4) - hq) < 30) {
               if ((idleTimerLong -= var0) <= 0) {
                  idleTimerLong = 0;
                  hw = 0;
                  scriptHitGauge = 0;
                  scriptHsStep = 6;
                  a(hq, hr, 4, -10, 500);
                  a(hq, hr, -4, -17, 500);
                  a(hq, hr, -3, -18, 500);
                  a(hq, hr, 4, -19, 500);
                  a(hq, hr, 0, -10, 500);
                  boolean var6 = false;
               } else {
                  scriptHitGauge = 50;
                  f(hq, hr - 47, playerFacing);
                  a("-" + var0, 0, hq, hr - 55, 0, -2);
                  boolean var7 = false;
               }
            }

            Q();
         }

      }
   }

   private static void v() {
      for(int var0 = 0; var0 < mapNpcBundleCount; ++var0) {
         if (mapNpcDir[var0] != 4 && a(playerX - mapNpcTileX[var0]) < 20 && mapNpcTileY[var0] > playerY && mapNpcTileY[var0] - 24 <= playerY) {
            y = 0;
            z = 0;
            playerY = mapNpcTileY[var0] - 24;
            playerState = 1;
            mountFacing = -1;
            mapNpcFocusIndex = var0;
            if (mapNpcDir[var0] == 11) {
               g(mapNpcTileX[var0], mapNpcTileY[var0] - 10);
               int[] var10000 = mapNpcTileY;
               var10000[var0] += 4;
               var10000 = mapNpcIx;
               var10000[var0] += 4;
               return;
            }
            break;
         }
      }

   }

   private static void w() {
      for(int var0 = 0; var0 < mapNpcBundleCount; ++var0) {
         if (a(playerX - mapNpcTileX[var0]) < 20 && a(mapNpcTileY[var0] - playerY) < 4) {
            y = 0;
            if (playerX < mapNpcTileX[var0]) {
               playerX = mapNpcTileX[var0] - 20;
            } else {
               playerX = mapNpcTileX[var0] + 20;
            }

            if (mapNpcDir[var0] != 4) {
               mapNpcDir[var0] = 2;
               mapNpcIw[var0] = -playerFacing << 1;
               return;
            }
         }
      }

   }

   private static void v(int var0) {
      if (a(playerY - cw[var0]) <= 24 && a(cv[var0] + (cI[var0] << 3) - playerX) < 25 && (cE[var0] == 6 || cE[var0] == 2 || cE[var0] == 3)) {
         cH[var0] = cG[var0] = 0;
         cF[var0] = 4;
      }

   }

   private static void w(int var0) {
      if (!gameModeFx) {
         if (a(cv[var0] - playerX) < 100 && a(cw[var0] - playerY) < 20) {
            switch (cE[var0]) {
               case 0:
               case 1:
               case 4:
               case 5:
                  cI[var0] = cv[var0] < playerX ? 1 : -1;
                  cH[var0] = cG[var0] = 0;
                  cF[var0] = 4;
                  break;
               case 2:
               case 3:
               case 6:
                  cH[var0] = playerX;
                  if (cv[var0] < playerX) {
                     int[] var10000 = cH;
                     var10000[var0] -= 10;
                  } else {
                     int[] var1 = cH;
                     var1[var0] += 10;
                  }

                  cI[var0] = cH[var0] < playerX ? 1 : -1;
                  cF[var0] = 7;
                  cz[var0] = cI[var0] << 3;
                  if (cH[var0] < cL[var0]) {
                     cH[var0] = cL[var0];
                  }

                  if (cH[var0] > cM[var0]) {
                     cH[var0] = cM[var0];
                     return;
                  }
            }
         }

      }
   }

   private static void x() {
      for(int var0 = 0; var0 < mapNpcBundleCount; ++var0) {
         if (a(playerX - mapNpcTileX[var0]) < 20 && mapNpcTileY[var0] == playerY) {
            y = 0;
            if (playerX < mapNpcTileX[var0]) {
               playerX = mapNpcTileX[var0] - 20;
            } else {
               playerX = mapNpcTileX[var0] + 20;
            }

            if (mapNpcDir[var0] != 4) {
               mapNpcDir[var0] = 2;
               mapNpcIw[var0] = playerFacing << 2;
               return;
            }
         }
      }

   }

   static void c() {
      for(int var0 = 0; var0 < 14; ++var0) {
         aS[var0] = false;
      }

   }

   static void d() {
      for(int var0 = 0; var0 < 14; ++var0) {
         aT[var0] = false;
      }

   }

   private static void y() {
      switch (iE) {
         case 3:
            activeQuestId = 0;
            questProgress = 0;
            c("NV: Giết 2 ốc sên");
            break;
         case 4:
            skillBridgeSetWallJumpLearned(true);
            skillBridgeSetWallJumpL2Learned(true);
            skillBridgeSetWallJumpL3Learned(true);
            skillSetAmSatLearned(true);
            skillSetDashLearned(true);
            skillLegacyFlagEK = true;
            if (skillDashLevel < 1) {
               skillDashLevel = 1;
            }
            syncDashDurationToLevel();
            activeQuestId = -1;
            questProgress = 0;
            c("đã học khinh công, dash và sức công nhân đôi!");
            break;
         case 5:
            activeQuestId = 1;
            questProgress = 0;
            c("NV: đánh ngã 2 bù nhìn");
            break;
         case 6:
            skillShurikenLearned = true;
            skillBridgeSetWallJumpL3Learned(true);
            activeQuestId = -1;
            questProgress = 0;
            c("đã học ném phi tiêu");
         case 7:
         default:
            break;
         case 8:
            c((String)null);
            break;
         case 9:
            activeQuestId = 2;
            questParam = 103;
            questTarget = 2;
            questBool = false;
            c("NV: Tìm bí kíp");
            break;
         case 10:
            skillBurrowLearned = true;
            activeQuestId = -1;
            questParam = 0;
            questTarget = 0;
            questBool = false;
            c("đã học thuật độn thổ");
            break;
         case 11:
            activeQuestId = 3;
            escortMapId = 3;
            companionX = 2808;
            companionY = 216;
            companionFaceDir = -1;
            companionMode = 1;
            companionVel = 5;
            break;
         // Trường hợp 12 trong một cấu trúc switch-case, thực hiện các hành động sau:
         // 1. Đánh dấu đã học/nhận được một kỹ năng hoặc trạng thái nào đó bằng cách đặt skillAttackDoubledQuest = true.
         // 2. Tăng gấp đôi sức mạnh tấn công (biến atk) bằng cách dịch trái 1 bit (atk <<= 1, tương đương nhân đôi atk).
         // 3. Gán biến activeQuestId = -1, có thể để kết thúc nhiệm vụ hiện tại hoặc reset trạng thái nhiệm vụ.
         // 4. Đặt questParam = 0 và questTarget = 0, có thể là reset các bộ đếm liên quan nhiệm vụ.
         // 5. Đặt questBool = false, có thể để đánh dấu trạng thái chưa hoàn thành hoặc reset lại cờ kiểm tra nào đó.
         // 6. Gọi phương thức c("sức công nhân đôi!"), có thể là để thông báo cho người chơi về trạng thái mới: "sức công nhân đôi!".
         case 12:
            skillAttackDoubledQuest = true;
            atk = atk * 2;
            activeQuestId = -1;
            questParam = 0;
            questTarget = 0;
            questBool = false;
            c("sức công nhân đôi!");
            break;
         case 13:
            activeQuestId = 4;
            questProgress = 0;
            c("NV: giết 20 con ong");
            break;
         case 14:
            activeQuestId = 5;
            questBool = false;
            questProgress = 0;
            questTarget = 10;
            c("NV: giết heo rừng");
            break;
         case 15:
            activeQuestId = -1;
            skillSwimLearned = true;
            skillWaterRunLearned = true;
            c("đã học chạy nước.");
            break;
         case 16:
            activeQuestId = 6;
            questBool = false;
            questTarget = 10;
            c("NV: vượt sông");
            break;
         case 17:
            activeQuestId = -1;
            skillTransformLearned = true;
            c("đã học biến hình.");
            break;
         case 18:
            activeQuestId = 7;
            questProgress = 0;
            c("NV: giết 15 dơi vàng");
            break;
         case 19:
            questBatReward5000Done = true;
            gold += 5000;
            c = true;
            activeQuestId = -1;
            questParam = 0;
            questTarget = 0;
            questBool = false;
            c("Nhận được tiền 5000$");
            break;
         case 20:
            activeQuestId = 15;
            questProgress = 0;
            questBool = false;
            c("NV: tìm bí kíp");
            break;
         case 21:
            skillStealthLegacyFlag = true;
            activeQuestId = -1;
            questProgress = 0;
            questBool = false;
            c("đã có thể ẩn thân");
            break;
         case 22:
            activeQuestId = 8;
            c("NV: tìm đánh Toniku");
            break;
         case 23:
            activeQuestId = -1;
            questTonikuBranchDone = true;
            c("Hoàn thành nhiệm vụ.");
            break;
         case 24:
            activeQuestId = 9;
            questProgress = 0;
            c("NV: giết 20 thổ dân");
            break;
         case 25:
            questMeetGirlUnlocked = true;
            activeQuestId = -1;
            questParam = 0;
            questTarget = 0;
            questBool = false;
            c("đến gặp cô bé!");
            break;
         case 26:
            activeQuestId = 10;
            questProgress = 0;
            escortActive = true;
            c("NV: dẫn cô bé đi chơi");
            break;
         case 27:
            activeQuestId = -1;
            skillBridgeSetWallJumpL2Learned(true);
            questProgress = 0;
            c("Học khinh công cấp 2");
            break;
         case 28:
            activeQuestId = 11;
            questProgress = 0;
            c("NV: 20 hit trên không");
            break;
         case 29:
            shurikenLevel2Learned = true;
            shurikenDmg <<= 2;
            activeQuestId = -1;
            questProgress = 0;
            c("đã học phi tiêu cấp 2");

            for(int var0 = 0; var0 < 2; ++var0) {
               try {
                  el[var0] = Image.createImage("/c/pt" + (var0 + 2) + ".png");
               } catch (IOException var1) {
               }
            }
            break;
         case 30:
            activeQuestId = 12;
            questProgress = 0;
            c("NV: đánh 70 quỷ hoa đỏ");
            break;
         case 31:
            skillSpeedBoostLearned = true;
            activeQuestId = -1;
            questProgress = 0;
            c("đã có thể chạy nhanh");
            break;
         case 32:
            activeQuestId = 13;
            questProgress = 0;
            c("NV: Giết 50 bò cạp");
            break;
         case 33:
            skillStandOnWaterLearned = true;
            activeQuestId = -1;
            questProgress = 0;
            c("đã có thể đứng nước");
            break;
         case 34:
            activeQuestId = 14;
            questProgress = 0;
            c("NV: Giết 30 cá đỏ");
            break;
         case 35:
            activeQuestId = -1;
            questProgress = 0;
            questBool = false;
            break;
         case 36:
            activeQuestId = 16;
            questProgress = 0;
            questBool = false;
            c("NV: cứu Sakura");
            break;
         case 37:
            skillBridgeSetWallJumpL3Learned(true);
            activeQuestId = -1;
            questProgress = 0;
            c("đã học khinh công cấp 3");
      }

      if (lI >= 0) {
         a(lI, lJ, lK, lL);
         lI = -1;
      }

   }

   private static int z() {
      int var0 = playerFacing > 0 ? playerX - 20 : playerX - 40;
      int var1 = playerFacing > 0 ? playerX + 40 : playerX + 20;
      int var2 = playerY - spriteHeight - 15;
      int var3 = playerY + 5;

      for(int var4 = 0; var4 < jI; ++var4) {
         if (jQ[var4] != 5 && jL[var4] >= var0 && jL[var4] <= var1 && jM[var4] >= var2 && jM[var4] <= var3) {
            return var4;
         }
      }

      return -1;
   }

   private static void A() {
      lu = null;
      System.gc();
      ec = null;
      ef = null;
      ew = null;
      System.gc();
      ey = null;
      System.gc();
      jH = null;
      System.gc();
      B();
      et = null;
      ej = null;
      dZ = null;
      System.gc();
   }

   private static void B() {
      ev = null;
      eu = null;
      System.gc();
   }

   private static void C() {
      if (escortActive) {
         if (playerY <= companionY - 24 && g(companionX, companionY - 1, 2)) {
            companionMode = 3;
            companionVel = 0;
            companionAccel = -7;
            return;
         }

         if (playerY <= companionY - 24 && g(companionX, companionY - 25, 2)) {
            companionMode = 3;
            companionVel = 0;
            companionAccel = -10;
            return;
         }

         if (companionX >= cutsceneP - 24 && companionX <= cutsceneP + q + 24) {
            if (companionY < cutsceneQ - 30 || companionY > cutsceneQ + r + 30) {
               companionFaceDir = playerX + (playerFacing << 5) > companionX ? 1 : -1;
               int var2 = playerX;
               int var6 = playerY > companionY ? cutsceneQ - 20 : cutsceneQ + r;
               companionX = var2;
               companionY = var6;
               companionMode = 3;
               companionVel = companionFaceDir << 2;
               companionAccel = -4;
               return;
            }

            if (a(playerX + (playerFacing << 5) - companionX) <= (playerState == 5 ? 10 : 60)) {
               companionMode = 1;
            } else if (playerY >= companionY) {
               if (playerY > companionY) {
                  if (g(companionX + companionFaceDir * companionT1, companionY, 2)) {
                     companionFaceDir = playerX > companionX ? 1 : -1;
                     companionMode = 2;
                     companionVel = companionFaceDir * P;
                     return;
                  }

                  if (g(companionX + companionFaceDir * 48, companionY + 24, 2)) {
                     companionMode = 3;
                     companionVel = companionFaceDir * 7;
                     companionAccel = -5;
                     return;
                  }

                  for(int var5 = 1; var5 <= 5 && companionY + var5 * 24 < iQ && !g(companionX + companionFaceDir * 24, companionY + var5 * 24, 64); ++var5) {
                     if (g(companionX + companionFaceDir * 24, companionY + var5 * 24, 2)) {
                        companionMode = 3;
                        companionVel = companionFaceDir << 2;
                        companionAccel = -4;
                        return;
                     }

                     if (g(companionX + companionFaceDir * 48, companionY + var5 * 24, 2)) {
                        companionMode = 3;
                        companionVel = companionFaceDir * 6;
                        companionAccel = -4;
                        return;
                     }
                  }

                  if (g(companionX + companionFaceDir * 24, companionY - 24, 2)) {
                     companionMode = 3;
                     companionVel = companionFaceDir * 5;
                     companionAccel = -7;
                     return;
                  }

                  if (g(companionX + companionFaceDir * 48, companionY - 24, 2)) {
                     companionMode = 3;
                     companionVel = companionFaceDir * 6;
                     companionAccel = -8;
                     return;
                  }

                  if (g(companionX + companionFaceDir * 24, companionY - 48, 2)) {
                     companionMode = 3;
                     companionVel = companionFaceDir * 5;
                     companionAccel = -11;
                     return;
                  }
               } else if (g(companionX + companionFaceDir * companionT1, companionY, 2)) {
                  companionFaceDir = playerX + (playerFacing << 5) > companionX ? 1 : -1;
                  companionMode = 2;
                  companionVel = companionFaceDir * P;
                  return;
               }
            } else {
               if (g(companionX + companionFaceDir * 48, companionY - 24, 2)) {
                  companionMode = 3;
                  companionVel = companionFaceDir * 5;
                  companionAccel = -8;
                  return;
               }

               for(int var3 = 1; var3 <= 3; ++var3) {
                  if (g(companionX + companionFaceDir * 24, companionY - var3 * 24, 2)) {
                     companionMode = 3;
                     companionVel = companionFaceDir * 6;
                     companionAccel = -5 - var3 * 3;
                     return;
                  }
               }

               if (!g(companionX + companionFaceDir * 48, companionY - 2, 64)) {
                  if (companionY + 24 >= iQ || g(companionX + companionFaceDir * 48, companionY + 24, 2)) {
                     companionMode = 3;
                     companionVel = companionFaceDir * 7;
                     companionAccel = -4;
                     return;
                  }

                  for(int var4 = 1; var4 <= 5; ++var4) {
                     if (companionY + var4 * 24 >= iQ || g(companionX + companionFaceDir * 24, companionY + var4 * 24, 64)) {
                        return;
                     }

                     if (g(companionX + companionFaceDir * 48, companionY + var4 * 24, 2)) {
                        companionMode = 3;
                        companionVel = companionFaceDir * 6;
                        companionAccel = -4;
                        return;
                     }

                     if (g(companionX + companionFaceDir * 24, companionY + var4 * 24, 2)) {
                        companionMode = 3;
                        companionVel = companionFaceDir << 2;
                        companionAccel = -4;
                        return;
                     }
                  }

                  return;
               }
            }
         } else {
            companionFaceDir = playerX + (playerFacing << 5) > companionX ? 1 : -1;
            int var0 = playerX > companionX ? cutsceneP - 24 : cutsceneP + q + 24;
            int var1 = playerY - 20;
            if (!g(var0, var1, 8192)) {
               companionX = var0;
               companionY = var1;
               companionMode = 4;
               companionVel = 4;
               companionAccel = 3;
               return;
            }

            if (g(companionX + companionFaceDir * companionT1, companionY, 2)) {
               companionFaceDir = playerX > companionX ? 1 : -1;
               companionMode = 2;
               companionVel = companionFaceDir * 12;
               return;
            }
         }
      }

   }

   private static void a(int var0, int var1) {
      hp -= var0;
      mountFacing = -1;
      c = true;
      mapNpcFocusIndex = -1;
      if (hp <= 0) {
         hp = 0;
         z = -7;
         y = var1 << 2;
         playerState = 6;
         mapObjectMountIndex = -1;
      } else if (mapObjectMountIndex == -1 && playerState != 23) {
         y = var1 << 2;
         z = -2;
         airComboTier = 0;
         burrowSubstate = 0;
         playerState = 7;
      }

      f(playerX, playerY - 12, -playerFacing);
      a("-" + var0, 0, playerX, playerY - spriteHeight, 0, -2);
   }

   private static void b(int var0, int var1) {
      npcInteractIndex = -1;
      companionVel = var1 << 2;
      companionAccel = -2;
      companionB = 0;
      companionC = 0;
      companionMode = 7;
      f(companionX, companionY - 12, -companionFaceDir);
      a("-" + var0, 0, companionX, companionY - companionT2, 0, -2);
   }

   private static boolean a(int var0, int var1, int var2) {
      int[] var10000 = cs;
      var10000[var0] -= var1;
      if (cF[var0] != 1 && cF[var0] != 5) {
         if (cs[var0] <= 0) {
            cs[var0] = 0;
            cI[var0] = var2;
            cz[var0] = 0;
            cA[var0] = 0;
            cB[var0] = -(var2 << 3);
            cC[var0] = -6;
            cG[var0] = 0;
            cr[var0] = 0;
            cF[var0] = 1;
            u(ac[cE[var0]]);
            a(cv[var0], cw[var0], -(cI[var0] << 2), -4, aa[cE[var0]] + mapSubIdLegacy % 10);
            if (mapSubIdLegacy % 20 > 5) {
               a(cv[var0], cw[var0], -(cI[var0] << 3), -5, ab[cE[var0]] << 2, (mapSubIdLegacy + 1) % 2);
            }

            return true;
         } else {
            cG[var0] = 0;
            cI[var0] = var2;
            cr[var0] = 100;
            cF[var0] = 6;
            return false;
         }
      } else {
         return true;
      }
   }

   private static boolean c(int var0, int var1) {
      if (gT == 1 || gT == 2) {
         if ((hpCurrentAlt -= var0) <= 0) {
            hpCurrentAlt = 0;
            gY = -5;
            gS = -(var1 << 3);
            hc = 0;
            gT = 6;
            a(gQ, gR, 4, -6, 50);
            a(gQ, gR, -5, -7, 50);
            a(gQ, gR, -4, -8, 50);
            a(gQ, gR, 5, -9, 50);
            a(gQ, gR, 0, -10, 50);
            if (activeQuestId == 5) {
               e(gQ, gR);
            }

            return true;
         }

         gY = 0;
         gU = var1;
         gT = 7;
         hc = 10;
         gV = 0;
         if (var0 <= shurikenDmg) {
            gZ = 0;
         } else {
            gZ = 2 + mapSubIdLegacy % 5;
         }
      }

      return false;
   }

   private static void d(int var0, int var1) {
      regenTimer -= var0;
      dJ[0] = -1;
      if (regenTimer <= 0) {
         regenTimer = 0;
      } else {
         dC[0] = var1 << 2;
         dD[0] = -2;
         dF[0] = 0;
         dG[0] = 0;
         dE[0] = 7;
         f(dA[0], dB[0] - 12, playerFacing);
         a("-" + var0, 0, dA[0], dB[0] - 32, 0, -2);
      }
   }

   public static final void b(int var0) {
      bN = 0;
      if (var0 == 0) {
         bN = 0;
      } else {
         if (dZ == null) {
            dZ = new Image[4][2];

            for(int var3 = 0; var3 < 4; ++var3) {
               for(int var1 = 0; var1 < 2; ++var1) {
                  try {
                     dZ[var3][var1] = Image.createImage("/c/ar" + var3 + var1 + ".png");
                  } catch (IOException var2) {
                  }
               }
            }
         }

         bN = 10;
         bO = new int[10];
         bP = new int[bN];
         bQ = new int[bN];
         bR = new int[bN];
         bS = new int[bN];
         bT = new int[bN];

         for(int var4 = 0; var4 < bN; ++var4) {
            bQ[var4] = -1;
         }

      }
   }

   public static void e() {
      if (ea == null) {
         ea = new Image[4];

         for(int var0 = 0; var0 < 4; ++var0) {
            try {
               ea[var0] = Image.createImage("/u/arr" + var0 + ".png");
            } catch (Exception var1) {
            }
         }
      }

   }

   public static void f() {
      bU = 8;
      bV = new int[8];
      bW = new int[bU];
      bX = new int[bU];
      bY = new int[bU];
      bZ = new int[bU];
      ca = new int[bU];

      try {
         eb = Image.createImage("/e/b.png");
      } catch (Exception var0) {
      }
   }

   public static final void c(int var0) {
      mapObjectBundleCount = 0;
      int var1 = mapObjectMountIndex == -1 ? 0 : 1;
      if ((var0 == 0 || var0 == 1 || var0 == 7 || var0 == 5 || var0 == 18 || var0 >= 94) && var1 == 1) {
         mapObjectBundleCount = 1;
         D();
         b(0, playerX, playerY);
         mapObjectMountIndex = 0;
         mapObjFacing[mapObjectMountIndex] = playerFacing;
      }

      if (var0 == 2) {
         d(var1, 18, 12);
      }

      if (var0 == 3) {
         d(var1, 2, 9);
      }

      if (var0 == 4) {
         d(var1, 3, 6);
      }

      if (var0 == 6) {
         d(var1, 12, 9);
      }

      if (var0 == 8) {
         d(var1, 3, 12);
      }

      if (var0 == 9) {
         d(var1, 2, 11);
      }

      if (var0 == 10) {
         d(var1, 3, 12);
      }

      if (var0 == 11) {
         d(var1, 5, 6);
      }

      if (var0 == 12) {
         d(var1, 4, 8);
      }

      if (var0 == 13) {
         d(var1, 16, 11);
      }

      if (var0 == 14) {
         d(var1, 18, 7);
      }

      if (var0 == 15) {
         d(var1, 1, 11);
      }

      if (var0 == 16) {
         d(var1, 7, 11);
      }

      if (var0 == 17) {
         d(var1, 14, 12);
      }

   }

   private static void D() {
      if (ec == null) {
         ec = new Image[3];

         try {
            for(int var0 = 0; var0 < 3; ++var0) {
               ec[var0] = Image.createImage("/c/v" + var0 + ".png");
            }
         } catch (Exception var1) {
         }
      }

      mapObjTileX = new int[mapObjectBundleCount];
      mapObjTileY = new int[mapObjectBundleCount];
      mapObjFacing = new int[mapObjectBundleCount];
      mapObjAnim = new int[mapObjectBundleCount];
      mapObjType = new int[mapObjectBundleCount];
      mapObjExtra = new int[mapObjectBundleCount];
   }

   private static void b(int var0, int var1, int var2) {
      mapObjTileX[var0] = var1 * jf + 12;
      mapObjTileY[var0] = var2 * jf;
      mapObjAnim[var0] = 0;
      mapObjFacing[var0] = 1;
   }

   public static void g() {
      try {
         ed = Image.createImage("/i/bk.png");
      } catch (Exception var0) {
      }
   }

   public static final void d(int var0) {
      mapNpcBundleCount = 0;
      if (var0 == 1) {
         mapNpcBundleCount = 2;
         E();
         c(0, 21, 9);
         c(1, 13, 8);
      }

      if (var0 == 11) {
         mapNpcBundleCount = 2;
         E();
         c(0, 33, 7);
         c(1, 44, 10);
      }

      if (var0 == 5) {
         mapNpcBundleCount = 2;
         E();
         c(0, 5, 46);
         c(1, 15, 46);
      }

      if (var0 == 97) {
         mapNpcBundleCount = 4;
         E();
         c(0, 3, 6);
         c(1, 7, 4);
         c(2, 12, 3);
         c(3, 22, 6);
      }

   }

   private static void E() {
      if (ef == null) {
         try {
            ef = Image.createImage("/i/b.png");
         } catch (Exception var0) {
         }
      }

      mapNpcTileX = new int[mapNpcBundleCount];
      mapNpcTileY = new int[mapNpcBundleCount];
      mapNpcDir = new int[mapNpcBundleCount];
      mapNpcIw = new int[mapNpcBundleCount];
      mapNpcIx = new int[mapNpcBundleCount];
      mapNpcIy = new int[mapNpcBundleCount];
      mapNpcIz = new int[mapNpcBundleCount];
   }

   /** Ensure NPC arrays sized for {@link #mapNpcBundleCount} (save-load can set mapNpcBundleCount without calling map init). */
   private static void ensureIrNpcArraysSized() {
      if (mapNpcBundleCount <= 0) {
         return;
      }

      if (mapNpcTileX == null || mapNpcTileY == null || mapNpcDir == null || mapNpcIw == null || mapNpcIx == null || mapNpcIy == null || mapNpcIz == null
         || mapNpcTileX.length != mapNpcBundleCount || mapNpcTileY.length != mapNpcBundleCount || mapNpcDir.length != mapNpcBundleCount || mapNpcIw.length != mapNpcBundleCount || mapNpcIx.length != mapNpcBundleCount
         || mapNpcIy.length != mapNpcBundleCount || mapNpcIz.length != mapNpcBundleCount) {
         E();
      }
   }

   private static void c(int var0, int var1, int var2) {
      mapNpcTileX[var0] = var1 * jf + 12;
      mapNpcTileY[var0] = var2 * jf + 24;
      mapNpcDir[var0] = 1;
   }

   public static final void h() {
      q = aU;
      if (aV >= 208) {
         bf = true;
         bj = 50;
         r = aV - bj;
         bi = q;
         bg = 0;
         bh = r + 1;
      } else {
         bj = 16;
         r = aV - bj;
         bf = false;
         bj = 0;
         bi = q;
         bg = 0;
         bh = r + 1;
         br = (bp = q / 3) + 29;
         bs = bp + 50;
      }

      if ((bu = aV / 6) < 48) {
         bu = 48;
      }

      bD = q >> 1;
      bE = r >> 1;
      bF = 3 * r / 4;
      bG = q / 6;
      bz = q / jf + 2;
      bA = r / jf + 2;
      if (q % 24 != 0) {
         ++bz;
      }

      cutsceneR = (iN - 1) * jf - q;
      cutsceneS = (iO - 1) * jf - r;
      cutsceneP = cutsceneJ = playerX - bD + bG * playerFacing;
      cutsceneQ = cutsceneK = playerY - bF;
      if (cutsceneP < 0) {
         cutsceneP = 0;
      }

      if (cutsceneP > cutsceneR) {
         cutsceneP = cutsceneR;
      }

      if (cutsceneQ < 0) {
         cutsceneQ = 0;
      }

      if (cutsceneQ > cutsceneS) {
         cutsceneQ = cutsceneS;
      }

      if ((bx = cutsceneP / jf - 1) < 0) {
         bx = 0;
      }

      by = cutsceneQ / jf;
      bB = bx + bz;
      bC = by + bA;
      if (by < 0) {
         by = 0;
      }

      if (bC > iO - 1) {
         bC = iO - 1;
      }

   }

   public static final void i() {
      mountFacing = -1;
      if (ee == null) {
         try {
            ee = new Image[20];

            for(int var0 = 0; var0 < 20; ++var0) {
               ee[var0] = Image.createImage("/cp/cb" + var0 + ".png");
            }

            ep = new Image[11];

            for(int var2 = 0; var2 < 11; ++var2) {
               ep[var2] = Image.createImage("/cp/ch" + var2 + ".png");
            }

            er = new Image[10];

            for(int var3 = 0; var3 < 10; ++var3) {
               er[var3] = Image.createImage("/cp/cl" + var3 + ".png");
            }
         } catch (Exception var1) {
         }
      }

      F();
      playerTimer0 = 22;
      spriteHeight = 32;
      halfWidth = playerTimer0 >> 1;
      halfHeight = spriteHeight >> 1;
      playerTimer1 = playerTimer0 >> 2;
      playerTimer2 = spriteHeight >> 2;
      interactTargetId = -1;
   }

   private static void F() {
      eC = new Image[11];
      System.gc();

      for(int var0 = 0; var0 < 11; ++var0) {
         try {
            eC[var0] = Image.createImage("/c/w" + var0 + "t" + equippedWeaponIndex + ".png");
         } catch (Exception var3) {
            try {
               eC[var0] = Image.createImage("/c/w" + var0 + "t0.png");
            } catch (IOException var2) {
               ((Throwable)var2).printStackTrace();
            }
         }
      }

   }

   public static void j() {
      G();
      if (bf) {
         try {
            if (eg == null) {
               eg = new Image[2];

               for(int var0 = 0; var0 < 2; ++var0) {
                  eg[var0] = Image.createImage("/u/c" + var0 + ".png");
               }
            }

            bk = eg[0].getWidth();
            bl = eg[1].getWidth();
            bm = q - bk - bl + 1;
            bn = 78;
            bo = bh + 7;
            bp = q - 134;
            bq = q - 84;
            bt = 5;
         } catch (IOException var1) {
         }
      }
   }

   private static void G() {
      try {
         if (ei == null) {
            ei = Image.createImage("/u/co.png");
         }

         (eD = new Image[2])[1] = Image.createImage("/u/wpt1.png");
         if (equippedWeaponIndex == 0) {
            eD[0] = Image.createImage("/u/wpt0.png");
         } else {
            eD[0] = Image.createImage("/u/wpt" + (equippedWeaponIndex + 1) + ".png");
         }
      } catch (Exception var0) {
      }
   }

   public static void k() {
      df = 5;
      if (eh == null) {
         try {
            eh = new Image[3];

            for(int var0 = 0; var0 < 3; ++var0) {
               eh[var0] = Image.createImage("/i/dm" + var0 + ".png");
            }
         } catch (Exception var1) {
         }
      }

      dg = new int[df];
      dh = new int[df];
      di = new int[df];
      dj = new int[df];
      dk = new int[df];
      dl = new int[df];
      dn = new int[df];
      dm = new int[df];
   }

   public static void e(int var0) {
      doFlag = false;
      if (var0 == 0) {
         if (ej == null) {
            ej = new Image[2];

            for(int var2 = 0; var2 < 2; ++var2) {
               try {
                  ej[var2] = Image.createImage("/npc/d" + var2 + ".png");
               } catch (Exception var1) {
               }
            }
         }

         doFlag = true;
         dp = 348;
         dq = 408;
         dr = 1;
         ds = 252;
         dt = 708;
      }

   }

   public static final void l() {
      if (!a) {
         if (ek == null) {
            ek = new Image[2][5];

            for(int var0 = 0; var0 < 2; ++var0) {
               for(int var1 = 0; var1 < 5; ++var1) {
                  try {
                     ek[var0][var1] = Image.createImage("/e/d" + var0 + var1 + ".png");
                  } catch (IOException var2) {
                  }
               }
            }
         }

         ck = new int[2];
         cl = new int[2];
         (cm = new int[2])[0] = cm[1] = -1;
      }
   }

   public static final void m() {
      if (el == null) {
         el = new Image[2];

         for(int var0 = 0; var0 < 2; ++var0) {
            try {
               if (shurikenLevel2Learned) {
                  el[var0] = Image.createImage("/c/pt" + (var0 + 2) + ".png");
               } else {
                  el[var0] = Image.createImage("/c/pt" + var0 + ".png");
               }
            } catch (IOException var1) {
            }
         }
      }

      cW = 10;
      cX = new int[10];
      cY = new int[cW];
      cZ = new int[cW];
      da = new int[cW];
      db = new int[cW];
      dd = new boolean[cW];
      dc = new int[cW];

      for(int var2 = 0; var2 < cW; ++var2) {
         cZ[var2] = -1;
      }

   }

   public static final void n() {
      dQ = new int[5];
      dR = new int[5];
      dS = new int[5];
      dT = new int[5];
      dU = new int[5];
      dV = new int[5];
      dP = new String[5];

      for(int var0 = 0; var0 < 5; ++var0) {
         dU[var0] = -1;
      }

   }

   private static void x(int var0) {
      d = 2;
      mapId = var0;
      Midlet.d = 1;
      DebugRefactor.onMapLoading(var0);
      aw();
      (new Thread(Midlet.c)).start();
   }

   public static final void f(int var0) {
      if (escortActive) {
         escortMapId = var0;
      }

      if (escortMapId == var0) {
         npcInteractIndex = -1;
         if (em == null) {
            try {
               em = new Image[8];

               for(int var2 = 0; var2 < 8; ++var2) {
                  em[var2] = Image.createImage("/cp/gb" + var2 + ".png");
               }

               en = new Image[3];

               for(int var3 = 0; var3 < 3; ++var3) {
                  en[var3] = Image.createImage("/cp/gh" + var3 + ".png");
               }

               eo = new Image[9];

               for(int var4 = 0; var4 < 9; ++var4) {
                  eo[var4] = Image.createImage("/cp/gl" + var4 + ".png");
               }
            } catch (Exception var1) {
            }
         }

         companionT1 = 22;
         companionT2 = 32;
         companionT3 = companionT1 >> 1;
         companionT4 = companionT2 >> 1;
         companionT5 = companionT1 >> 2;
         companionT6 = companionT2 >> 2;
         if (escortActive) {
            companionX = playerX - playerFacing * 10;
            companionY = playerY;
            companionFaceDir = playerFacing;
            companionMode = 4;
         }

      }
   }

   public static void o() {
      if (es == null) {
         es = new Image[2];

         for(int var0 = 0; var0 < 2; ++var0) {
            try {
               es[var0] = Image.createImage("/e/l" + var0 + ".png");
            } catch (IOException var1) {
            }
         }
      }

   }

   public static void g(int var0) {
      dv = 0;
      dy = false;
      if (var0 == 0) {
         dv = 7;
         H();
         a(0, 0, 14, 17, 130, 11, 22, new String[]{"Chào, cậu là ai thế, mình chưa từng gặp bạn thì phải?", "Nói cậu nghe nhé, thầy cô trường này khó tính lắm đó.", "Cẩn thận với ông thầy Hiroyaki nhé. Đừng chọc giận ổng."});
         a(1, 1, 24, 17, 160, 15, 30, new String[]{"Mình là MinhXP, lớp trưởng lớp kiếm thuật.", "Kiếm là vũ khí lợi hại nhất của một ninja đấy bạn biết không?", "Khu vực luyện tập nằm ở bên trái. Hãy sang đấy tập luyện nhiều hơn nữa."});
         if (skillTransformLearned) {
            a(2, 6, 17, 12, 200, 7, 29, new String[]{"Thằng bên kia là sát thủ giả mạo.", "Ta đây mới là ninja sát thủ thứ thiệt đây!"});
         } else {
            a(2, 2, 17, 12, 200, 7, 29, new String[]{"Chào, tao tên là Tonic, mày là thằng nào?", "Nhìn lão hiệu trưởng kìa, lão có một hũ rượu trông hấp dẫn quá!", "Nếu muốn rủ tao đi nhậu thì ok, còn không thì biến đi.", "À, nếu mày có thấy con chó của tao thì báo tao 1 tiếng nhé."});
         }

         a(3, 3, 48, 17, 200, 44, 63, new String[]{"Hi, mình là Craze, trông bạn có vẻ hơi buồn thì phải?", "Bạn có thấy chán khi tối ngày quanh quẩn trong trường không?", "Đi về phía tay phải bạn sẽ đến được ngôi làng, ra đó để tìm niềm vui đi!"});
         a(4, 4, 46, 12, 200, 40, 54, new String[]{"Thằng nhà quê kia, mày mau kiếm tiền đóng thuế thân cho tao.", "Tao cho mày 2 ngày, nếu không đưa tao 1000$ thì mày ăn chém đó."});
         a(5, 5, 38, 17, 200, 34, 49, new String[]{"Xin chào, bạn là học sinh mới phải không?", "Nhìn thầy hiệu trưởng kìa, thầy vốn là một ninja sát thủ đấy.", "Thầy đã bỏ nghề sát thủ lâu rồi, nhưng tài năng vẫn còn đó", "Chúng ta có tập luyện cả đời cũng không bằng thầy đâu."});
         a(6, 6, 58, 12, 200, 46, 60, new String[]{"Đừng hỏi ta là ai...", "Ta chỉ là một ninja sát thủ thôi, ngươi biết thế là được rồi.", "Biến đi cho ta luyện tập."});
         y(7);
      }

      if (var0 == 1) {
         dv = 3;
         H();
         a(0, 5, 35, 9, 40, 33, 36, new String[]{"Bạn có thể nhảy lên cây cầu này nếu đã học xong khinh công từ cô Ayumi xinh đẹp."});
         if (skillTransformLearned) {
            a(1, 6, 25, 10, 40, 22, 28, new String[]{"Ta đây là một ninja sát thủ!", "Ha hpCurrentAlt hpCurrentAlt!"});
         } else {
            a(1, 2, 25, 10, 40, 22, 28, new String[]{"Mày đã học khinh công rồi hả?", "À, mày có thấy con chó của tao chạy đâu đâu không?"});
         }

         a(2, 1, 6, 9, 40, 2, 10, new String[]{"Bên kia là một thác nước rất lớn đấy.", "Nó không thuộc phạm vi trường chúng ta nữa nên có rất nhiều quái vật hung dữ.", "Nghe nói có một con quái vật rất to đấy, tốt hơn ngươi đừng qua làm gì!"});
         y(7);
      }

      if (var0 == 2) {
         dv = 7;
         H();
         a(0, 3, 16, 12, 60, 14, 21, new String[]{"Cậu nhìn thấy chiếc xe máy kia không?", "Phải có bằng lái từ thầy chủ nhiệm bạn mới có thể chạy được."});
         a(1, 4, 8, 12, 50, 2, 15, new String[]{"Thằng nhà quê kia, mày đi đâu đấy?"});
         if (skillTransformLearned) {
            a(2, 6, 29, 13, 200, 27, 40, new String[]{"Ninja sát thủ là ta - Thiên hạ vô địch!"});
         } else {
            a(2, 2, 29, 13, 200, 27, 40, new String[]{"Mày có thấy con chó của tao ở đâu không?"});
         }

         a(3, 5, 46, 13, 200, 41, 49, new String[]{"Nếu bạn muốn lên kia thì phải học khinh công từ cô Ayumi đã."});
         a(4, 1, 46, 11, 200, 43, 53, new String[]{"Cậu có thấy ở đây ai cũng tài giỏi không?", "Hãy cố gắng tập luyện hơn nữa nhé"});
         a(5, 0, 54, 11, 200, 50, 58, new String[]{"Ra ngoài rừng hoa đào có rất nhiều điều thú vị đấy.", "Bạn nên ra thử một lần để biết."});
         a(6, 6, 34, 13, 200, 28, 48, new String[]{"Đừng hỏi ta là ai...", "Ta chỉ là một ninja sát thủ thôi, ngươi biết thế là được rồi.", "Biến đi cho ta luyện tập."});
         y(7);
      }

      if (var0 == 99 || var0 == 101) {
         dv = 7;
         H();
         String[] var1 = new String[]{"Này, cậu đi tìm con heo đó trước đi. Tớ đi theo bọc lót cho!"};
         a(0, 0, 8, 13, 0, 0, 1000, var1);
         a(1, 1, 5, 13, 0, 0, 1000, var1);
         a(2, 6, 6, 13, 0, 0, 1000, var1);
         a(3, 2, 7, 13, 0, 0, 1000, var1);
         a(4, 4, 6, 13, 0, 0, 1000, var1);
         a(5, 5, 5, 13, 0, 0, 1000, var1);
         a(6, 3, 8, 13, 0, 0, 1000, var1);
         y(7);
      }

      if (var0 == 94) {
         dv = 7;
         H();
         String[] var2 = new String[]{"Chúc mừng, sắp được ra trường rồi nhé!"};
         a(0, 0, 5, 12, 0, 0, 1000, var2);
         a(1, 1, 5, 12, 0, 0, 1000, var2);
         a(2, 6, 6, 12, 0, 0, 1000, var2);
         a(3, 7, 3, 12, 0, 0, 1000, var2);
         a(4, 4, 6, 12, 0, 0, 1000, var2);
         a(5, 5, 5, 12, 0, 0, 1000, var2);
         a(6, 3, 8, 12, 0, 0, 1000, var2);
         y(8);
      }

   }

   private static void H() {
      dA = new int[dv];
      dB = new int[dv];
      dC = new int[dv];
      dD = new int[dv];
      dE = new int[dv];
      dF = new int[dv];
      dK = new int[dv];
      dG = new int[dv];
      dH = new int[dv];
      dI = new int[dv];
      dJ = new int[dv];
      dL = new int[dv];
      dM = new int[dv];
      dN = new int[dv];
      dO = new int[dv];
      dw = new String[dv][];
   }

   private static void y(int var0) {
      if (et == null) {
         et = new Image[var0][2];

         for(int var1 = 0; var1 < var0; ++var1) {
            for(int var2 = 0; var2 < 2; ++var2) {
               try {
                  et[var1][var2] = Image.createImage("/cp/f" + var1 + "h" + var2 + ".png");
               } catch (Exception var3) {
               }
            }
         }
      }

   }

   private static void a(int var0, int var1, int var2, int var3, int var4, int var5, int var6, String[] var7) {
      dA[var0] = var2 * 24 + (var0 << 2);
      dB[var0] = var3 * 24;
      dC[var0] = 0;
      dD[var0] = 0;
      dE[var0] = 1;
      dK[var0] = -1;
      dF[var0] = 0;
      dG[var0] = (var0 + 1) * 20 + var0;
      dH[var0] = 0;
      dI[var0] = var1;
      dJ[var0] = -1;
      dM[var0] = -1;
      dN[var0] = var5 * 24 + 12;
      dO[var0] = var6 * 24 + 12;
      dL[var0] = var4;
      dw[var0] = var7;
   }

   private static void I() {
      d = 2;
      aw();
      Midlet.d = 3;
      mapId = 99;

      try {
         eB = Image.createImage("/u/tt.png");
      } catch (Exception var1) {
      }

      bd = aV - 30;
      be = aV;
      aZ = 30;
      ba = aV - 50;
      bb = bc = aZ + ba >> 1;
      if (Midlet.b()) {
         aY = 1;
      }

      String var0;
      if ((var0 = System.getProperty("microedition.platform")).endsWith("JAVASDK") || var0.endsWith("wtk")) {
         Midlet.lowGfx = true;
         Y(1);
         lM = true;
      }

      (new Thread(Midlet.c)).start();
   }

   public static void h(int var0) {
      cq = 0;
      if (var0 == 9) {
         cq = 6;
         du = new boolean[]{false, false, true, false, false, false, false};
         J();
         b(0, 10, 12, 9, 12, 2);
         b(1, 7, 8, 6, 8, 2);
         b(2, 30, 8, 27, 33, 2);
         b(3, 29, 12, 27, 33, 2);
         b(4, 45, 5, 42, 50, 2);
         b(5, 64, 9, 62, 66, 2);
      }

      if (var0 == 10) {
         cq = 12;
         du = new boolean[]{true, false, true, false, false, false, false};
         J();
         b(0, 5, 8, 4, 6, 2);
         b(1, 6, 12, 5, 9, 0);
         b(2, 16, 12, 9, 21, 2);
         b(3, 28, 15, 26, 29, 0);
         b(4, 25, 15, 22, 27, 2);
         b(5, 16, 25, 14, 17, 0);
         b(6, 4, 29, 2, 6, 0);
         b(7, 8, 38, 2, 28, 2);
         b(8, 14, 38, 2, 28, 2);
         b(9, 20, 38, 2, 28, 2);
         b(10, 31, 30, 28, 37, 2);
         b(11, 33, 30, 28, 37, 0);
      }

      if (var0 == 11) {
         cq = 8;
         du = new boolean[]{true, true, true, false, false, false, false};
         J();
         b(0, 6, 11, 3, 7, 1);
         b(1, 19, 12, 18, 20, 0);
         b(2, 33, 8, 28, 36, 2);
         b(3, 53, 11, 53, 54, 1);
         b(5, 54, 11, 53, 54, 0);
         b(4, 68, 12, 62, 79, 2);
         b(6, 71, 12, 70, 72, 0);
         b(7, 72, 8, 70, 73, 1);
      }

      if (var0 == 16) {
         cq = 4;
         du = new boolean[]{false, false, false, true, false, false, false};
         J();
         b(0, 5, 11, 3, 10, 3);
         b(1, 26, 12, 24, 29, 3);
         b(2, 47, 10, 30, 55, 3);
         b(3, 60, 11, 56, 64, 3);
      }

      if (var0 == 17) {
         cq = 8;
         du = new boolean[]{false, false, false, true, true, false, false};
         J();
         b(0, 11, 8, 9, 13, 3);
         b(1, 20, 6, 18, 21, 4);
         b(2, 20, 11, 18, 21, 3);
         b(3, 26, 3, 24, 29, 3);
         b(4, 26, 8, 24, 29, 4);
         b(5, 26, 13, 24, 29, 4);
         b(6, 33, 6, 32, 35, 3);
         b(7, 33, 10, 32, 35, 4);
      }

      if (var0 == 18) {
         cq = 8;
         du = new boolean[]{false, false, false, false, true, true, true};
         J();
         b(0, 2, 8, 1, 4, 5);
         b(1, 2, 12, 1, 5, 6);
         b(2, 18, 12, 12, 23, 6);
         b(3, 18, 8, 15, 21, 5);
         b(4, 42, 9, 38, 45, 4);
         b(5, 42, 13, 34, 67, 6);
         b(6, 62, 13, 34, 67, 6);
         b(7, 60, 9, 57, 64, 4);
      }

   }

   private static void J() {
      boolean var0 = false;
      if (ev == null) {
         try {
            ev = new Image[4];

            for(int var3 = 0; var3 < 4; ++var3) {
               ev[var3] = Image.createImage("/mob/x" + var3 + ".png");
            }

            eu = new Image[7][2];

            for(int var4 = 0; var4 < 7; ++var4) {
               if (du[var4]) {
                  for(int var1 = 0; var1 < 2; ++var1) {
                     eu[var4][var1] = Image.createImage("/mob/y" + var4 + var1 + ".png");
                  }
               }
            }
         } catch (Exception var2) {
         }
      }

      ct = new int[cq];
      cu = new int[cq];
      cv = new int[cq];
      cw = new int[cq];
      cx = new int[cq];
      cy = new int[cq];
      cE = new int[cq];
      cF = new int[cq];
      cG = new int[cq];
      cH = new int[cq];
      cI = new int[cq];
      cJ = new int[cq];
      cK = new int[cq];
      cD = new int[cq];
      cL = new int[cq];
      cM = new int[cq];
      cz = new int[cq];
      cA = new int[cq];
      cB = new int[cq];
      cC = new int[cq];
      cs = new int[cq];
      cr = new int[cq];
   }

   private static void b(int var0, int var1, int var2, int var3, int var4, int var5) {
      ct[var0] = var1 * 24 + 12;
      cu[var0] = var2 * 24;
      cv[var0] = ct[var0];
      cw[var0] = cu[var0];
      cx[var0] = cv[var0];
      cy[var0] = cw[var0] - 9;
      cE[var0] = var5;
      cF[var0] = 3;
      cG[var0] = var0 << 1;
      cH[var0] = 0;
      cI[var0] = 1;
      cJ[var0] = 0;
      cK[var0] = 0;
      cD[var0] = 0;
      cL[var0] = var3 * 24 + 12;
      cM[var0] = var4 * 24 + 12;
      cs[var0] = ad[cE[var0]];
   }

   public static void i(int var0) {
      hpMaxBaseline = 1200;
      hpCurrentAlt = 1200;
      gP = 30;
      gO = false;
      if (var0 == 4) {
         gO = true;
         if (ew == null) {
            ew = new Image[5];

            for(int var1 = 0; var1 < 5; ++var1) {
               try {
                  ew[var1] = Image.createImage("/mob/b0" + var1 + ".png");
               } catch (Exception var3) {
               }
            }
         }

         gW = ew[0].getWidth();
         gX = ew[0].getHeight();
         gQ = 55 * jf + 12;
         gR = 13 * jf;
         gT = 1;
         gU = -1;
         gV = 0;
      }

      if (var0 == 5) {
         gO = true;
         if (ew == null) {
            ew = new Image[5];

            for(int var4 = 0; var4 < 5; ++var4) {
               try {
                  ew[var4] = Image.createImage("/mob/b0" + var4 + ".png");
               } catch (Exception var2) {
               }
            }
         }

         gW = ew[0].getWidth();
         gX = ew[0].getHeight();
         gQ = 8 * jf + 12;
         gR = 56 * jf;
         gT = 1;
         gU = -1;
         gV = 0;
      }

   }

   public static void p() {
      cN = 5;
      if (ex == null) {
         try {
            (ex = new Image[2])[0] = Image.createImage("/i/pt0.png");
            ex[1] = Image.createImage("/i/pt1.png");
            ex[2] = Image.createImage("/i/dm1.png");
         } catch (Exception var0) {
         }
      }

      cP = new int[cN];
      cQ = new int[cN];
      cR = new int[cN];
      cS = new int[cN];
      cT = new int[cN];
      cU = new int[cN];
      cV = new int[cN];
      cO = new int[cN];
   }

   public static void j(int var0) {
      hK = false;
      if (var0 == 97 && !unlockedMap97) {
         hK = true;
         ey = new Image[4];

         for(int var2 = 0; var2 < 4; ++var2) {
            try {
               ey[var2] = Image.createImage("/mob/b1" + var2 + ".png");
            } catch (IOException var1) {
            }
         }

         hQ = 168;
         hR = 226;
         ia = 144;
         ib = 480;
         hY = 2;
         hZ = -1;
         hO = 8000;
         bossThreshold = 8000;
      }

   }

   public static final void q() {
      if (ez == null) {
         ez = new Image[3];

         for(int var0 = 0; var0 < 3; ++var0) {
            try {
               ez[var0] = Image.createImage("/e/sp" + var0 + ".png");
            } catch (IOException var1) {
            }
         }
      }

      cb = new int[2];
      cc = new int[2];
      cd = new int[2];
      ce = new int[2];
      cf = new int[2];
      cd[0] = cd[1] = -1;
   }

   public static void k(int var0) {
      hj = false;
      if (var0 == 95 && !unlockedMap95) {
         hj = true;
         eA = new Image[6];

         try {
            eA[0] = Image.createImage("/mob/b20.png");
            eA[1] = Image.createImage("/mob/b21.png");
            eA[2] = Image.createImage("/mob/b22.png");
            eA[3] = eA[1];
            eA[4] = Image.createImage("/mob/b23.png");
            eA[5] = Image.createImage("/cp/f2h0.png");
         } catch (IOException var1) {
         }

         hq = 192;
         hr = 264;
         hu = 120;
         hv = 504;
         scriptHsStep = 0;
         ht = -1;
         ho = 90000;
         idleTimerLong = 90000;
         hE = new int[6];
         hF = new int[6];
         hI = new int[6];
         hJ = new int[6];
         hG = new int[]{20, 10, 0, -10, -16, 2};
         hH = new int[]{-16, 0, -12, 0, -18, -42};
         hy = new int[][]{new int[6], {0, 0, 1, 0, 1, 1}};
         hz = new int[][]{new int[6], {1, 0, 1, 0, 2, 1}};
         hA = new int[][]{{6, -1, 1, 1, 5, 1}, {14, -1, 2, 1, 12, 2}};
         hB = new int[][]{{1, 0, 0, 0, 1, 0}, {2, 0, 1, 0, 2, 1}};
         hC = new int[][]{{-3, 3, 0, -3, 3, 0}, new int[6], {3, -3, 0, 3, -3, 0}};
         hD = new int[][]{{-1, -2, 1, 0, 1, 1}, new int[6], {1, 0, 1, -2, -1, 1}};
      }

   }

   public static void l(int var0) {
      hd = false;
      if (var0 == 96 && !unlockedMap96) {
         hd = true;
         dv = 1;
         H();
         a(0, 2, 5, 11, 200, 4, 22, (String[])null);
         y(3);
         hi = 15000;
         regenTimer = 15000;
         hg = 120;
         dv = 0;
         dE[0] = 0;
         dK[0] = 1;
      }

   }

   // public static void m(int var0) {
   //    if (var0 == 94) {
   //       activationTrialFlag = true;
   //       playerX = 24;
   //       playerY = 288;
   //       escortMapId = 94;
   //       companionX = 12;
   //       companionY = 288;
   //       companionFaceDir = 1;
   //       escortActive = false;
   //       playerFacing = 1;
   //    }

   //    if (var0 == 0 && activeQuestId == 15 && questBool) {
   //       escortMapId = -1;
   //       escortActive = false;
   //    }

   //    if (var0 == 0 && activeQuestId == 16 && questGeninGraduated) {
   //       questGeninFlagFB = true;
   //       escortMapId = 0;
   //       escortActive = true;
   //       gameModeFv = true;
   //       activeQuestId = -1;
   //       playerX = 984;
   //       playerY = 408;
   //    } else {
   //       if (var0 == 95 && !unlockedMap95) {
   //          escortActive = false;
   //          companionX = 599;
   //          companionY = 264;
   //          companionFaceDir = -1;
   //          escortMapId = 95;
   //       }

   //    }
   // }
   
   public static void setCurrentQuestIndex(int value) {
      activeQuestId = value;
   }

   public static int getCurrentQuestIndex() {
      return activeQuestId;
   }
   public static boolean isFv() {
      return gameModeFv;
   }

   public static void setFv(boolean value) {
      gameModeFv = value;
   }
   public static boolean isEI() {
      return unlockedMap95;
   }

   public static void setEI(boolean value) {
      unlockedMap95 = value;
   }
   public static boolean isFc() {
      return questGeninGraduated;
   }

   public static void setFc(boolean value) {
      questGeninGraduated = value;
   }

   public static boolean isFb() {
      return questGeninFlagFB;
   }

   public static void setFb(boolean value) {
      questGeninFlagFB = value;
   }

   public static boolean isDx() {
      return activationTrialFlag;
   }

   public static void setDx(boolean value) {
      activationTrialFlag = value;
   }
   public static int getFf() {
      return playerX;
   }

   public static void setFf(int value) {
      playerX = value;
   }

   public static int getFg() {
      return playerY;
   }

   public static void setFg(int value) {
      playerY = value;
   }

   public static int getGn() {
      return escortMapId;
   }

   public static void setGn(int value) {
      escortMapId = value;
   }

   public static int getGo() {
      return companionX;
   }

   public static void setGo(int value) {
      companionX = value;
   }

   public static int getGp() {
      return companionY;
   }

   public static void setGp(int value) {
      companionY = value;
   }

   public static int getGA() {
      return companionFaceDir;
   }

   public static void setGA(int value) {
      companionFaceDir = value;
   }

   public static boolean isGl() {
      return escortActive;
   }

   public static void setGl(boolean value) {
      escortActive = value;
   }

   public static int getFn() {
      return playerFacing;
   }

   public static void setFn(int value) {
      playerFacing = value;
   }

   public static void n(int var0) {
      scriptRunnerActive = false;
      fT = false;
      cutsceneI = 0;
      if (var0 == 15 && activeQuestId == 15) {
         e(216, 432);
      }

      if (var0 == 8 && activeQuestId == 6) {
         e(72, 240);
      }

      if (var0 == 4 && hasSaveGame) {
         T = true;
         skillBridgeSetWallJumpLearned(true);
         skillTransformLearned = true;
         skillWaterRunLearned = true;
         skillSetAmSatLearned(true);
         skillSetDashLearned(true);
         syncDashDurationToLevel();
         hpMax = 1000;
         hp = 1000;
         mpMax = 2000;
         mp = 2000;
         atk = 25;
         playerState = 4;
         hpMaxBaseline = 500;
         hpCurrentAlt = 500;
         D(0);
      } else if (var0 == 99) {
         hasSaveGame = true;
         activationTrialFlag = true;
         playerX = 108;
         playerY = 312;
         playerFacing = -1;
         D(1);
      } else if (var0 == 94) {
         D(10);
      } else if (var0 == 0 && hasSaveGame) {
         T = false;
         skillBridgeSetWallJumpLearned(false);
         skillWaterRunLearned = false;
         skillTransformLearned = false;
         skillSetDashLearned(false);
         skillSetAmSatLearned(false);
         skillDashLevel = 1;
         syncSkillsFromLegacyFlags();
         genderSpriteFlag = false;
         hp = 200;
         hpMax = 200;
         mp = 200;
         mpMax = 200;
         hpMaxBaseline = 1000;
         hpCurrentAlt = 1000;
         expInLevel = 0;
         level = 1;
         atk = 20;
         playerX = 864;
         playerY = 336;

         for(int var1 = 0; var1 < 19; ++var1) {
            mapUnlockFlags[var1] = false;
         }

         mapUnlockFlags[0] = true;
         playerFacing = -1;
         activationTrialFlag = false;
         dy = false;
         D(2);
         hasSaveGame = false;
      } else if (var0 == 3 && activeQuestId == 3 && !escortActive) {
         D(3);
      } else if (var0 == 0 && activeQuestId == 3 && escortActive) {
         D(4);
      } else if (var0 == 97 && !unlockedMap97) {
         D(5);
      } else if (var0 == 96 && !unlockedMap96) {
         D(6);
      } else if (var0 == 95 && !unlockedMap95) {
         D(7);
      } else if (var0 == 101) {
         D(8);
         cutsceneQ = cutsceneK = 336 - r;
         cutsceneJ = 24;
         cutsceneP = 24;
      } else if (var0 == 9 && activeQuestId == 10) {
         D(9);
      }

      if (var0 == 97 && unlockedMap97) {
         for(int var2 = 0; var2 <= 6; ++var2) {
            i(24, var2, 0);
         }
      }

      if (var0 == 96 && unlockedMap96) {
         for(int var3 = 0; var3 <= 11; ++var3) {
            i(24, var3, 0);
         }
      }

   }

   public static final void r() {
      if (!a) {
         eE = new Image[3];

         for(int var0 = 0; var0 < 3; ++var0) {
            try {
               eE[var0] = Image.createImage("/e/w" + var0 + ".png");
            } catch (IOException var1) {
            }
         }

         cg = new int[2];
         ch = new int[2];
         ci = new int[2];
         cj = new int[2];
         ci[0] = ci[1] = -1;
      }
   }

   private static void z(int var0) {
      if (dB[0] == playerY && a(dA[0] + (dK[0] << 5) - playerX) < 25) {
         a(hg, dK[0]);
      }

   }

   private static void A(int var0) {
      int var1;
      int var6;
      label29: {
         var1 = atk;
         var6 = dM[var0];
         int var4 = -dK[var0];
         int var2 = var6;
         if (jQ[var2] == 2 || jQ[var2] == 3 || jQ[var2] == 4) {
            int[] var5 = ka;
            var5[var2] -= var1;
            if (ka[var2] <= 0) {
               ka[var2] = 0;
               jV[var2] = -5;
               jW[var2] = -(var4 << 3);
               jX[var2] = 0;
               jP[var2] = 0;
               jQ[var2] = 1;
               var6 = 1;
               break label29;
            }

            jV[var2] = 0;
            jZ[var2] = var4;
            jQ[var2] = 6;
            jY[var2] = 3;
         }

         var6 = 0;
      }

      if (var6 == 0) {
         f(jL[dM[var0]], jM[dM[var0]] - (jN[dM[var0]] >> 1), jZ[dM[var0]]);
         a("-" + var1, 0, jL[dM[var0]], jM[dM[var0]] - jN[dM[var0]], 0, -2);
      }

   }

   private static void B(int var0) {
      for(int var1 = 0; var1 < jI; ++var1) {
         if (jQ[var1] != 5 && jM[var1] == dB[var0] && a(dA[var0] + (dK[var0] << 3) - jL[var1]) < 20) {
            if (jL[var1] < dA[var0]) {
               dK[var0] = -1;
            } else {
               dK[var0] = 1;
            }

            dE[var0] = 5;
            dF[var0] = dG[var0] = 0;
            dM[var0] = var1;
         }
      }

   }

   private static void K() {
      if (iJ < iF[iD].length) {
         iJ = iF[iD].length;
         iI = 0;
      } else {
         ++iD;
         iJ = 0;
         iI = 0;
      }
   }

   private static void a(Graphics var0) {
      if (b && !a) {
         var0.setColor(i);
         var0.fillRect(0, 0, q, p);

         for(int var2 = -((cutsceneP >> 1) % 24); var2 < q; var2 += 24) {
            var0.drawImage(s[0], var2, j, 0);
         }

         for(int var3 = -((cutsceneP >> 2) % 24); var3 < q; var3 += 24) {
            var0.drawImage(s[1], var3, k, 0);
         }

         for(int var4 = -((cutsceneP >> 4) % 64); var4 < q; var4 += 64) {
            var0.drawImage(s[3], var4, m, 0);
         }

         var0.drawImage(u, g, h, 3);

         for(int var5 = 0; var5 < 2; ++var5) {
            var0.drawImage(t, e[var5], f[var5], 3);
         }

         for(int var6 = -((cutsceneP >> 3) % 192); var6 < q; var6 += 192) {
            var0.drawImage(s[2], var6, l, 0);
         }

      } else {
         var0.setColor(i);
         var0.fillRect(0, 0, q, r);
         if (!a) {
            var0.drawImage(u, g, h, 3);

            for(int var1 = 0; var1 < 2; ++var1) {
               var0.drawImage(t, e[var1], f[var1], 3);
            }

         }
      }
   }

   private static void b(Graphics var0) {
      if (gameModeFx) {
         if (mapSubIdLegacy % 20 > 2) {
            B = 25;
         } else {
            B = 26;
         }
      }

      if (DashSkill.getInstance().renderPlayer(GameSkillContext.INSTANCE, var0)) {
         return;
      }

      if (AmbushSkill.getInstance().renderPoseIfActive(GameSkillContext.INSTANCE, var0)) {
         return;
      }

      if (playerFacing == 1) {
         var0.drawImage(ep[aq[B][0][0]], playerX + aq[B][0][1], playerY - aq[B][0][2], 0);
         var0.drawImage(er[aq[B][1][0]], playerX + aq[B][1][1], playerY - aq[B][1][2], 0);
         var0.drawImage(ee[aq[B][2][0]], playerX + aq[B][2][1], playerY - aq[B][2][2], 0);
         if (mountFacing != -1) {
            var0.drawImage(eC[mountFacing], playerX - ar[mountFacing], playerY - as[mountFacing], 0);
            return;
         }
      } else {
         var0.drawRegion(ep[aq[B][0][0]], 0, 0, ep[aq[B][0][0]].getWidth(), ep[aq[B][0][0]].getHeight(), 2, playerX - aq[B][0][1], playerY - aq[B][0][2], 24);
         var0.drawRegion(er[aq[B][1][0]], 0, 0, er[aq[B][1][0]].getWidth(), er[aq[B][1][0]].getHeight(), 2, playerX - aq[B][1][1], playerY - aq[B][1][2], 24);
         var0.drawRegion(ee[aq[B][2][0]], 0, 0, ee[aq[B][2][0]].getWidth(), ee[aq[B][2][0]].getHeight(), 2, playerX - aq[B][2][1], playerY - aq[B][2][2], 24);
         if (mountFacing != -1) {
            var0.drawRegion(eC[mountFacing], 0, 0, eC[mountFacing].getWidth(), eC[mountFacing].getHeight(), 2, playerX + ar[mountFacing], playerY - as[mountFacing], 24);
         }
      }

   }

   private static void c(Graphics var0) {
      if (!bf) {
         var0.translate(-var0.getTranslateX(), -var0.getTranslateY());
         var0.drawImage(ep[0], 0, 2, 0);
         var0.setColor(0);
         var0.drawRect(23, 2, bp + 1, 4);
         var0.drawRect(23, 8, bp + 1, 4);
         var0.drawRect(23, 14, bp + 1, 3);
         var0.setColor(16711680);
         int var1 = hp * bp / hpMax;
         var0.fillRect(24, 3, var1, 3);
         var0.setColor(5570560);
         var0.fillRect(var1 + 24, 3, bp - var1, 3);
         var0.setColor(255);
         var1 = mp * bp / mpMax;
         var0.fillRect(24, 9, var1, 3);
         var0.setColor(5570560);
         var0.fillRect(var1 + 24, 9, bp - var1, 3);
         var0.setColor(7274435);
         var1 = expInLevel * bp / ai[level - 1];
         var0.fillRect(24, 15, var1, 2);
         var0.setColor(19506);
         var0.fillRect(var1 + 24, 15, bp - var1, 2);
         Midlet.a(var0, "lv:" + level, 2, br, 7, 0);
         Midlet.a(var0, gold + "$", 1, bs, 7, 0);
      }
   }

   private static void d(Graphics var0) {
      c = false;
      var0.translate(-var0.getTranslateX(), -var0.getTranslateY());
      var0.setClip(-1, bh - 1, bi + 2, 100);
      var0.setColor(0);
      if (!bf) {
         var0.fillRect(0, bh, bi, 15);
         Midlet.a(var0, n, 3, bh + 3, 0);
         Midlet.a(var0, o, bi - 3, bh + 3, 1);
      } else {
         var0.fillRect(0, bh + 33, bi, 15);
         Midlet.a(var0, n, 3, bh + 36, 0);
         Midlet.a(var0, o, bi - 3, bh + 36, 1);
         var0.setColor(4352);
         var0.fillRect(bk, bh, bm, 1);
         var0.fillRect(bk, bh + 35, bm, 1);
         var0.fillRect(bk, bh + 33, bm, 1);
         var0.fillRect(bk, bh + 30, bm, 1);
         var0.fillRect(bk, bh + 28, bm, 1);
         var0.fillRect(bk, bh + 26, bm, 1);
         var0.fillRect(bk, bh + 12, bm, 1);
         var0.fillRect(bk, bh + 24, bm, 1);
         var0.fillRect(bk, bh + 18, bm, 1);
         var0.fillRect(bk, bh + 16, bm, 1);
         var0.fillRect(bk, bh + 2, bm, 1);
         var0.fillRect(bk, bh + 4, bm, 1);
         var0.fillRect(bk, bh + 6, bm, 1);
         var0.fillRect(bk, bh + 14, bm, 1);
         var0.setColor(15649843);
         var0.fillRect(bk, bh + 1, bm, 1);
         var0.fillRect(bk, bh + 5, bm, 1);
         var0.fillRect(bk, bh + 17, bm, 1);
         var0.fillRect(bk, bh + 34, bm, 1);
         var0.fillRect(bk, bh + 29, bm, 1);
         var0.setColor(16767871);
         var0.fillRect(bk, bh + 3, bm, 1);
         var0.fillRect(bk, bh + 15, bm, 1);
         var0.fillRect(bk, bh + 27, bm, 1);
         var0.setColor(3355443);
         var0.fillRect(bk, bh + 7, bm, 5);
         var0.fillRect(bk, bh + 19, bm, 5);
         var0.fillRect(bk, bh + 31, bm, 2);
         var0.setColor(12281361);
         var0.fillRect(bk, bh + 25, bm, 1);
         var0.fillRect(bk, bh + 13, bm, 1);
         var0.drawImage(eg[0], 0, bh, 0);
         var0.drawImage(eg[1], 0 + bi, bh, 24);
         int var1 = hp * bp / hpMax;
         var0.setColor(7798784);
         var0.fillRect(bn, bo, var1, 2);
         var0.setColor(13369344);
         var0.fillRect(bn, bo + 1, var1, 4);
         var1 = mp * bp / mpMax;
         var0.setColor(119);
         var0.fillRect(bn, bo + 12, var1, 2);
         var0.setColor(204);
         var0.fillRect(bn, bo + 14, var1, bt - 2);
         Midlet.a(var0, "" + gold, 1, bi - 18, bh + 6, 2);
         var1 = expInLevel * bq / ai[level - 1];
         var0.setColor(94373);
         var0.fillRect(31, bh + 31, var1, 1);
         var0.setColor(65535);
         var0.fillRect(31, bh + 32, var1, 1);
         Midlet.a(var0, "" + level, 2, 26, bh + 11, 2);
         var0.drawImage(eD[mountSubstate], 43, bh + 16, 3);
         Midlet.a(var0, "" + (inventoryCounts[0] + inventoryCounts[1] + inventoryCounts[2]), 2, bi - 29, bh + 19, 2);
         Midlet.a(var0, "" + (inventoryCounts[3] + inventoryCounts[4] + inventoryCounts[5]), 2, bi - 9, bh + 19, 2);
      }
   }

   private static void e(Graphics var0) {
      var0.translate(-var0.getTranslateX(), -var0.getTranslateY());
      var0.setClip(-1, -1, aU + 2, aV + 2);
      var0.setColor(0);
      var0.fillRect(0, 0, q, bv);
      if (bf) {
         var0.fillRect(0, aV - bv + 1, q, bv);
      } else {
         var0.fillRect(0, aV - 13, aU, 13);
      }

      if (fW) {
         for(int var1 = 0; var1 < fX.length; ++var1) {
            Midlet.a(var0, fX[var1], bD, fY + (var1 << 4), 2);
         }
      }

   }

   private static void f(Graphics var0) {
      var0.translate(-var0.getTranslateX(), -var0.getTranslateY());
      var0.setClip(-1, -1, aU + 2, aV + 2);
      iB = iF[iD].length;
      int var1 = iH - cutsceneQ - (iB << 4);
      boolean var2 = true;
      if (var1 < 10) {
         var2 = false;
         var1 = 10;
      }

      var0.setColor(16777215);
      if (a) {
         var0.fillRect(iL, var1 - 5, iK, (iB << 4) + 7);
      } else {
         var0.fillRoundRect(iL, var1 - 5, iK, (iB << 4) + 7, 10, 10);
      }

      var0.setColor(17408);
      if (a) {
         var0.drawRect(iL - 1, var1 - 5, iK + 1, (iB << 4) + 7);
      } else {
         var0.drawRoundRect(iL - 1, var1 - 5, iK + 1, (iB << 4) + 7, 10, 10);
      }

      for(int var3 = 0; var3 < iJ; ++var3) {
         Midlet.b(var0, iF[iD][var3], iL + (iK >> 1), var1 + (var3 << 4), 2);
      }

      if (iJ < iF[iD].length) {
         Midlet.b(var0, iF[iD][iJ].substring(0, iI), iL + (iK >> 1), var1 + (iJ << 4), 2);
      }

      var0.setColor(0);
      var0.fillRect(0, bh + 33, bi, 15);
      if (var2 && iG > cutsceneP + 10 && iG < cutsceneP + q - 10) {
         var0.drawImage(ei, iG - cutsceneP, iH - cutsceneQ + 2, 17);
      }

      if (mapSubIdLegacy % 10 < 8) {
         Midlet.a(var0, "Tiếp tục", bD, aV - 13, 2);
      }

   }

   private static void g(Graphics var0) {
      for(int var1 = 0; var1 < dv; ++var1) {
         if (dA[var1] + halfWidth >= cutsceneP && dA[var1] - halfWidth <= cutsceneP + q && dB[var1] >= cutsceneQ && dB[var1] - spriteHeight <= cutsceneQ + r) {
            if (dK[var1] == 1) {
               var0.drawImage(et[dI[var1]][aH[dH[var1]][0][0]], dA[var1] + aH[dH[var1]][0][1], dB[var1] - aH[dH[var1]][0][2], 0);
               var0.drawImage(er[aH[dH[var1]][1][0]], dA[var1] + aH[dH[var1]][1][1], dB[var1] - aH[dH[var1]][1][2], 0);
               var0.drawImage(ee[aH[dH[var1]][2][0]], dA[var1] + aH[dH[var1]][2][1], dB[var1] - aH[dH[var1]][2][2], 0);
               if (dJ[var1] != -1) {
                  var0.drawImage(eC[dJ[var1]], dA[var1] - ar[dJ[var1]], dB[var1] - as[dJ[var1]], 0);
               }
            } else {
               var0.drawRegion(et[dI[var1]][aH[dH[var1]][0][0]], 0, 0, et[dI[var1]][aH[dH[var1]][0][0]].getWidth(), et[dI[var1]][aH[dH[var1]][0][0]].getHeight(), 2, dA[var1] - aH[dH[var1]][0][1], dB[var1] - aH[dH[var1]][0][2], 24);
               var0.drawRegion(er[aH[dH[var1]][1][0]], 0, 0, er[aH[dH[var1]][1][0]].getWidth(), er[aH[dH[var1]][1][0]].getHeight(), 2, dA[var1] - aH[dH[var1]][1][1], dB[var1] - aH[dH[var1]][1][2], 24);
               var0.drawRegion(ee[aH[dH[var1]][2][0]], 0, 0, ee[aH[dH[var1]][2][0]].getWidth(), ee[aH[dH[var1]][2][0]].getHeight(), 2, dA[var1] - aH[dH[var1]][2][1], dB[var1] - aH[dH[var1]][2][2], 24);
               if (dJ[var1] != -1) {
                  var0.drawRegion(eC[dJ[var1]], 0, 0, eC[dJ[var1]].getWidth(), eC[dJ[var1]].getHeight(), 2, dA[var1] + ar[dJ[var1]], dB[var1] - as[dJ[var1]], 24);
               }
            }
         }
      }

   }

   private static void h(Graphics var0) {
      var0.setClip(-1, -1, aU + 2, aV + 1);
      a(var0);
      var0.translate(-cutsceneP, -cutsceneQ);
      if (a) {
         j(var0);
      } else {
         k(var0);
      }

      i(var0);
      g(var0);
      b(var0);
      r(var0);
      l(var0);
      e(var0);
      if (iA) {
         f(var0);
      }

   }

   private static void L() {
      if (!gameModeFx && playerState != 14 && a(playerY - gR) < 30 && a(playerX - gQ) < 200) {
         gT = 5;
         gU = gQ < playerX ? 1 : -1;
         gZ = playerX + (gU << 5);
         gS = gU * 6;
         if (hpCurrentAlt < hpMaxBaseline >> 1) {
            gS = gU << 3;
         }
      }

   }

   private static void d(int var0, int var1, int var2) {
      mapObjectBundleCount = var0 + 1;
      D();
      b(0, var1, var2);
      if (var0 == 1) {
         b(1, playerX, playerY);
         mapObjectMountIndex = 1;
         mapObjFacing[mapObjectMountIndex] = playerFacing;
      }

   }

   private static void b(int var0, int var1, int var2, int var3, int var4) {
      int var5 = -1;

      for(int var6 = 0; var6 < bN; ++var6) {
         if (bQ[var6] == -1) {
            var5 = var6;
            break;
         }
      }

      if (var5 != -1) {
         bQ[var5] = 1;
         bO[var5] = var0;
         bP[var5] = var1;
         bR[var5] = var2;
         bS[var5] = var3;
         bT[var5] = var4;
      }
   }

   private static void a(int var0, int var1, int var2, int var3) {
      scriptMapId = var0;
      scriptExtraD = var1;
      scriptExtraE = var2;
      scriptExtraK = var3;
   }

   private static void c(int var0, int var1, int var2, int var3, int var4) {
      int var5 = -1;

      for(int var6 = 0; var6 < bU; ++var6) {
         if (bX[var6] == 0) {
            var5 = var6;
            break;
         }
      }

      if (var5 != -1) {
         bX[var5] = 1;
         bV[var5] = var0;
         bW[var5] = var1;
         bY[var5] = var2;
         bZ[var5] = var3;
         ca[var5] = var4;
      }
   }

   private static void e(int var0, int var1) {
      cutsceneG = var0;
      cutsceneH = var1;
      cutsceneI = 1;
   }

   private static void C(int var0) {
      ga = 0;
      fU = var0;
      fV = 0;
      fT = true;
      gb = false;
      c();
      d();
   }

   private static void a(String[] var0, int var1, int var2, int var3) {
      iE = var1;
      iG = var2;
      iH = var3;
      iC = var0.length;
      iD = 0;
      iF = new String[iC][];
      if ((iK = q >> 1) < 120) {
         iK = 120;
      }

      for(int var4 = 0; var4 < iC; ++var4) {
         iF[var4] = Midlet.b(var0[var4], iK - 20);
      }

      if ((iL = iG - (iK >> 1) - cutsceneP) < 2) {
         iL = 2;
      }

      if (iL + iK > q - 2) {
         iL = q - 2 - iK;
      }

      iA = true;
      iI = 0;
      iJ = 0;
   }

   private static boolean e(int var0, int var1, int var2) {
      if (a) {
         return false;
      } else {
         var0 = var0 == 1 ? 0 : 1;
         if (cm[var0] != -1) {
            return false;
         } else {
            cm[var0] = 0;
            ck[var0] = var1;
            cl[var0] = var2;
            return true;
         }
      }
   }

   private static void a(int var0, int var1, int var2, int var3, boolean var4) {
      int var5 = -1;

      for(int var6 = 0; var6 < cW; ++var6) {
         if (cZ[var6] == -1) {
            var5 = var6;
            break;
         }
      }

      if (var5 != -1) {
         cZ[var5] = 1;
         cX[var5] = var0;
         cY[var5] = var1;
         db[var5] = var2;
         dc[var5] = var3;
         dd[var5] = var4;
      }
   }

   private static void a(String var0, int var1, int var2, int var3, int var4, int var5) {
      var4 = -1;

      for(int var6 = 0; var6 < 5; ++var6) {
         if (dU[var6] == -1) {
            var4 = var6;
            break;
         }
      }

      if (var4 != -1) {
         dP[var4] = var0;
         dQ[var4] = var2;
         dR[var4] = var3;
         dS[var4] = 0;
         dT[var4] = var5;
         dU[var4] = 0;
         dV[var4] = var1;
      }
   }

   private static void f(int var0, int var1) {
      dY = 1;
      dW = var0;
      dX = var1;
   }

   private static void c(String var0) {
      cp = var0;
      co = 0;
      cn = true;
   }

   private static boolean f(int var0, int var1, int var2) {
      int var3 = cd[0] == -1 ? 0 : 1;
      if (cd[var3] != -1) {
         return false;
      } else {
         cd[var3] = 0;
         cf[var3] = var2;
         cb[var3] = var0;
         cc[var3] = var1;
         return true;
      }
   }

   private static void D(int var0) {
      scriptStep = 0;
      scriptTableId = var0;
      scriptRunnerActive = true;
   }

   private static boolean g(int var0, int var1) {
      if (a) {
         return false;
      } else {
         int var2 = ci[0] == -1 ? 0 : 1;
         if (ci[var2] != -1) {
            return false;
         } else {
            ci[var2] = 0;
            cg[var2] = var0;
            ch[var2] = var1;
            return true;
         }
      }
   }

   private static void M() {
      for(int var0 = 0; var0 < bN; ++var0) {
         if (bQ[var0] == 1) {
            int[] var10000 = bO;
            var10000[var0] += bR[var0];
            if (bO[var0] >= cutsceneP && bO[var0] <= cutsceneP + q && bP[var0] >= cutsceneQ && bP[var0] <= cutsceneQ + r) {
               if (a(playerX - bO[var0]) < halfWidth && a(playerY - halfHeight - bP[var0]) < halfHeight) {
                  if (playerState == 5 && mountSubstate == 0 && bT[var0] < 3) {
                     bR[var0] = -bR[var0];
                     var10000 = bO;
                     var10000[var0] += bR[var0];
                     return;
                  }

                  a(bS[var0], bO[var0] < playerX ? 1 : -1);
                  bQ[var0] = -1;
                  return;
               }
            } else {
               bQ[var0] = -1;
            }
         }
      }

   }

   private static void N() {
      if (scriptMapId >= 0) {
         if (scriptExtraD > cutsceneP + 10 && scriptExtraD < cutsceneP + q - 10 && scriptExtraE > cutsceneQ + 10 && scriptExtraE < cutsceneQ + r - 10) {
            scriptExtraF = 2;
            scriptExtraG = scriptExtraD;
            scriptExtraH = scriptExtraE + scriptExtraJ;
         } else if (a(playerX - scriptExtraD) > a(playerY - scriptExtraE)) {
            if (playerX > scriptExtraD) {
               scriptExtraF = 1;
               scriptExtraG = cutsceneP + 20 + scriptExtraJ;
            } else {
               scriptExtraF = 0;
               scriptExtraG = cutsceneP + q - 20 + scriptExtraJ;
            }

            if ((scriptExtraH = scriptExtraE + 24) < cutsceneQ + 10) {
               scriptExtraH = cutsceneQ + 10;
            }

            if (scriptExtraH > cutsceneQ + r - 10) {
               scriptExtraH = cutsceneQ + r - 10;
            }
         } else if (playerY > scriptExtraE) {
            scriptExtraF = 3;
            scriptExtraG = playerX;
            scriptExtraH = cutsceneQ + 20 + scriptExtraJ;
         } else {
            scriptExtraF = 2;
            scriptExtraG = playerX;
            scriptExtraH = cutsceneQ + r - 20 + scriptExtraJ;
         }

         if ((scriptExtraJ += scriptExtraI) == 5 || scriptExtraJ == -5) {
            scriptExtraI = -scriptExtraI;
         }
      }

   }

   private static void O() {
      for(int var0 = 0; var0 < bU; ++var0) {
         if (bX[var0] != 0) {
            int[] var10000 = bV;
            var10000[var0] += bY[var0];
            var10000 = bW;
            var10000[var0] += bZ[var0];
            int var10002 = bZ[var0]++;
            if (bW[var0] > cutsceneQ + r) {
               bX[var0] = 0;
            }

            if (a(playerX - bV[var0]) < halfWidth && a(playerY - halfHeight - bW[var0]) < halfHeight) {
               a(ca[var0], bV[var0] < playerX ? 1 : -1);
               bX[var0] = -1;
               return;
            }
         }
      }

   }

   private static void P() {
      if (cutsceneI != 0) {
         if (cutsceneI == 1) {
            if (a(playerY - (spriteHeight >> 1) - (cutsceneH - 7)) < 10 && a(playerX - cutsceneG) < 10) {
               cutsceneI = 2;
               questBool = true;
               c("đã lấy được bí kíp");
               return;
            }
         } else {
            ++cutsceneI;
            cutsceneH -= 3;
            if (cutsceneI > 40) {
               cutsceneI = 0;
            }
         }

      }
   }

   private static void Q() {
      if (genderSpriteFlag) {
         aK = 0;
      }

   }

   private static void R() {
      if (gameModeFv) {
         cutsceneJ = playerX - bD + bG * playerFacing;
         cutsceneK = playerY - bF;
      }

      label788:
      switch (playerState) {
         case 1:
            if (++airComboTier > 30) {
               airComboTier = 0;
            }

            if (airComboTier % 15 < 5) {
               B = 0;
            } else {
               B = 1;
            }

            S();

            if (AmbushSkill.getInstance().isAmbushPoseActive() && (i(playerX, playerY) & 2) != 2 && !skillBridgeDeferAmbushGravity()) {
               playerState = 4;
               z = 2;
               y = 3 * playerFacing;
               burrowSubstate = 0;
               break;
            }

            for(int var5 = 0; var5 < dv; ++var5) {
               if (dE[var5] == 1 && playerY == dB[var5] && a(playerX - dA[var5]) < 30 && interactSubId == -1) {
                  o = "Trò chuyện";
                  c = true;
                  interactSubId = var5;
                  break;
               }
            }

            if (escortMapId == mapId && companionMode == 1 && playerY == companionY && a(playerX - companionX) < 30) {
               o = "Nói chuyện";
               c = true;
               fC = true;
            }

            for(int var6 = 0; var6 < lv; ++var6) {
               if (playerY == lx[var6] && a(playerX - lw[var6]) < 30 && interactTargetId == -1) {
                  o = "Giao tiếp";
                  c = true;
                  interactTargetId = var6;
                  break label788;
               }
            }
            break;
         case 2:
            if (++airComboTier >= 10) {
               airComboTier = 0;
               cameraScrollX = 0;
               if (skillSpeedBoostLearned) {
                  cameraScrollX = playerFacing << 1;
               }
            }

            B = (airComboTier >> 1) + 2;
            if (playerFacing == 1) {
               if (g(playerX + halfWidth, playerY - halfHeight, 4)) {
                  y = 0;
                  playerX = I(playerX + halfWidth) - halfWidth;
               }
            } else if (g(playerX - halfWidth - 1, playerY - halfHeight, 8)) {
               y = 0;
               playerX = I(playerX - halfWidth - 1) + jf + halfWidth;
            }

            if ((i(playerX, playerY - 1) & 64) == 64) {
               playerX += y >> 1;
            } else {
               playerX += y;
            }

            if (y > 0) {
               --y;
            } else if (y < 0) {
               ++y;
            } else {
               playerState = 1;
               cameraScrollX = 0;
            }

            if (mapNpcFocusIndex != -1) {
               if (a(playerX - mapNpcTileX[mapNpcFocusIndex]) >= 20) {
                  mapNpcFocusIndex = -1;
                  if (g(playerX, playerY, 2)) {
                     playerState = 1;
                  } else {
                     playerState = 4;
                     z = 2;
                     y = 3 * playerFacing;
                     burrowSubstate = 0;
                  }
               }
            } else if ((i(playerX, playerY) & 2) != 2) {
               playerState = 4;
               y = 3 * playerFacing;
               burrowSubstate = 0;
            }

            x();
            e(playerFacing, playerX - (playerFacing << 3), playerY);
            S();
            break;
         case 3:
            playerX += y;
            if ((playerY += z) < 0) {
               playerY = 0;
               z = -1;
            }

            if (airComboTier == 0) {
               B = 7;
            } else {
               B = 23;
            }

            ++z;
            if (skillBridgeIsWallJumpLearned() && !genderSpriteFlag) {
               if (z == -3) {
                  B = 8;
               } else if (z == -2) {
                  B = 9;
               } else if (z == -1) {
                  B = 10;
               } else if (z == 0) {
                  B = 11;
               }
            }

            if (z == 0) {
               playerState = 4;
               airComboTier = 0;
               burrowSubstate = skillBridgeIsWallJumpLearned() ? 1 : 0;
               z = 1;
               c = true;
            }

            if (moveCounter < 0) {
               ++moveCounter;
            }

            if (playerFacing == 1) {
               if ((i(playerX + halfWidth, playerY) & 4) == 4) {
                  playerX = I(playerX + halfWidth) - halfWidth;
                  y = 0;
               }
            } else if ((i(playerX - halfWidth, playerY) & 8) == 8) {
               playerX = I(playerX + 24 - halfWidth) + halfWidth;
               y = 0;
            }
            break;
         case 4:
            mountFacing = -1;
            playerX += y;
            if (!skillBridgeDeferAmbushGravity()) {
               playerY += z;
               if (z < 18) {
                  ++z;
               }
            }

            if (y > 0) {
               --y;
            }

            B = 7;
            if (playerY >= iQ) {
               playerState = 6;
               hp = 0;
            } else if (playerY + 4 >= iQ) {
               playerState = 6;
               hp = 0;
            } else if (z > 4 && (i(playerX, playerY + 3) & 2) == 2) {
               if (z > 12) {
                  playerState = 8;
               } else {
                  playerState = 1;
               }

               z = 0;
               y = 0;
               burrowSubstate = 0;
               airComboTier = 0;
               playerY = I(playerY + 3);
               e(-1, playerX - -8, playerY);
               e(1, playerX - 8, playerY);
               if (skillMotorcycleLearned) {
                  for(int var4 = 0; var4 < mapObjectBundleCount; ++var4) {
                     if (playerY == mapObjTileY[var4] && a(playerX - mapObjTileX[var4]) < 16) {
                        playerX = mapObjTileX[var4];
                        playerState = 18;
                        mapObjectMountIndex = var4;
                        mapObjFacing[var4] = playerFacing;
                        mapObjAnim[var4] = 0;
                     }
                  }
               }

               if (activeQuestId == 11 && questProgress < 20) {
                  questProgress = 0;
                  c("Hit: " + questProgress);
               }
            } else {
               if (g(playerX, playerY, 64) && playerY % jf > 8) {
                  g(playerX, H(playerY) + 8);
                  playerY = H(playerY) + 8;
                  playerState = 11;
                  y = playerFacing << 1;
                  z >>= 2;
                  playerY = H(playerY) + 12;
                  if (mp == 0 || !skillWaterRunLearned) {
                     playerState = 12;
                  }
               }

               if (g(playerX, playerY, 4096)) {
                  playerState = 12;
               }

               if (burrowSubstate == 1 && !genderSpriteFlag) {
                  if (z == 3) {
                     B = 11;
                  } else if (z == 2) {
                     B = 8;
                  } else if (z == 1) {
                     B = 9;
                  } else if (z == 0) {
                     B = 10;
                  }
               } else {
                  B = 23;
               }

               if (z > 6) {
                  B = 12;
               }

               if (moveCounter < 0) {
                  ++moveCounter;
               }

               if (playerFacing == 1) {
                  if ((i(playerX + halfWidth, playerY) & 4) == 4) {
                     playerX = I(playerX + halfWidth) - halfWidth;
                     y = 0;
                  }
               } else if ((i(playerX - halfWidth, playerY) & 8) == 8) {
                  playerX = I(playerX + 24 - halfWidth) + halfWidth;
                  y = 0;
               }

               v();
               if (gO && z >= 4 && a(playerX - gQ) < 30 && a(playerY - (gR - 25)) < 5) {
                  z = -(z >> 1);
                  y = playerFacing << 3;
                  airComboTier = 0;
               }
            }
            break;
         case 5:
            ++airComboTier;
            if (playerFacing == 1) {
               if ((i(playerX + halfWidth, playerY - halfHeight) & 4) == 4) {
                  y = 0;
               }
            } else if ((i(playerX - halfWidth, playerY - halfHeight) & 8) == 8) {
               y = 0;
            }

            playerX += y;
            if ((playerY += z) < 0) {
               z = 0;
               playerY = 0;
            }

            if (z == 0) {
               if (mapNpcFocusIndex == -1 && (i(playerX, playerY) & 2) != 2) {
                  playerState = 4;
                  mountFacing = -1;
                  y = (P >> 1) * playerFacing;
                  burrowSubstate = 0;
                  airComboTier = 0;
               }

               if (mapNpcFocusIndex != -1 && a(playerX - mapNpcTileX[mapNpcFocusIndex]) >= 20) {
                  mapNpcFocusIndex = -1;
                  if (g(playerX, playerY, 2)) {
                     playerState = 1;
                  } else {
                     playerState = 4;
                     z = 2;
                     y = 3 * playerFacing;
                     mountFacing = -1;
                     burrowSubstate = 0;
                  }
               }
            } else if (z < 0) {
               if (++z == 0) {
                  z = 1;
               }
            } else {
               if (z < 20 && airComboTier % 5 == 0) {
                  ++z;
               }

               if (z > 3) {
                  z = 3;
               }

               if (z > 2 && (i(playerX, playerY + 3) & 2) == 2) {
                  z = 0;
                  y = 0;
                  playerY = I(playerY + 3);
                  if (activeQuestId == 11 && questProgress < 20) {
                     questProgress = 0;
                     c("Hit: " + questProgress);
                  }
               }

               if (g(playerX, playerY, 64) && playerY % jf > 8) {
                  g(playerX, H(playerY) + 8);
                  playerState = 11;
                  y = playerFacing << 1;
                  z >>= 2;
                  playerY = H(playerY) + 12;
                  mountFacing = -1;
                  if (mp == 0 || !skillWaterRunLearned) {
                     playerState = 12;
                  }
                  break;
               }

               if (g(playerX, playerY, 4096)) {
                  playerState = 12;
                  mountFacing = -1;
                  break;
               }

               v();
            }

            if (y > 0) {
               --y;
            } else if (y < 0) {
               ++y;
            }

            if (y != 0) {
               x();
            }

            label728:
            switch (timerFu) {
               case 0:
                  switch (airComboTier) {
                     case 1:
                     case 2:
                     case 3:
                        mountFacing = -1;
                        B = 13;
                        break label728;
                     case 4:
                        mountFacing = 0;
                        B = 14;
                        break label728;
                     case 5:
                        mountFacing = 1;
                        B = 15;
                        break label728;
                     case 6:
                        mountFacing = 1;
                        B = 15;
                        u();
                        break label728;
                     case 7:
                        mountFacing = 2;
                        B = 16;
                        break label728;
                     case 8:
                        mountFacing = 2;
                        B = 16;
                        if (gameModeFw) {
                           gameModeFw = false;
                           timerFu = 2;
                        } else {
                           timerFu = 1;
                        }

                        airComboTier = 1;
                     default:
                        break label728;
                  }
               case 1:
                  switch (airComboTier) {
                     case 1:
                        mountFacing = 1;
                        B = 15;
                        break label728;
                     case 2:
                        mountFacing = 1;
                        B = 15;
                        timerFu = 10;
                     default:
                        break label728;
                  }
               case 2:
                  switch (airComboTier) {
                     case 1:
                     case 2:
                     case 3:
                        mountFacing = 3;
                        B = 17;
                        break label728;
                     case 4:
                        mountFacing = 4;
                        B = 18;
                        break label728;
                     case 5:
                        mountFacing = 5;
                        B = 19;
                        break label728;
                     case 6:
                        mountFacing = 6;
                        B = 20;
                        u();
                        break label728;
                     case 7:
                        mountFacing = 6;
                        B = 20;
                        if (gameModeFw && timerFt < 2) {
                           if (z == 0 && fs) {
                              airComboTier = 0;
                              gameModeFw = false;
                              timerFu = 9;
                           } else {
                              gameModeFw = false;
                              timerFu = 3;
                              ++timerFt;
                           }
                        } else {
                           timerFu = 10;
                        }

                        airComboTier = 1;
                     default:
                        break label728;
                  }
               case 3:
                  switch (airComboTier) {
                     case 1:
                        mountFacing = 1;
                        B = 15;
                        break;
                     case 2:
                        mountFacing = 1;
                        B = 15;
                        break;
                     case 3:
                        mountFacing = 2;
                        B = 16;
                        break;
                     case 4:
                        mountFacing = 2;
                        B = 16;
                        if (gameModeFw) {
                           gameModeFw = false;
                           timerFu = 2;
                        } else {
                           timerFu = 1;
                        }

                        airComboTier = 1;
                  }
               case 4:
               case 5:
               case 6:
               case 7:
               case 8:
               default:
                  break;
               case 9:
                  switch (airComboTier) {
                     case 1:
                     case 2:
                     case 3:
                        mountFacing = -1;
                        B = 13;
                        break label728;
                     case 4:
                        mountFacing = 0;
                        B = 14;
                        break label728;
                     case 5:
                     case 6:
                        mountFacing = 9;
                        B = 15;
                        int var3 = z();
                        fs = false;
                        if (var3 != -1) {
                           fs = true;
                           f(jL[var3], jM[var3] - (jN[var3] >> 1), playerFacing);
                           jQ[var3] = 9;
                           jV[var3] = -8;
                           Q();
                        }
                        break label728;
                     case 7:
                     case 8:
                        mountFacing = 10;
                        B = 16;
                        break label728;
                     case 9:
                        mountFacing = -1;
                        B = 16;
                        if (fs) {
                           playerState = 3;
                           y = 0;
                           z = -8;
                        } else {
                           airComboTier = 0;
                           burrowSubstate = 0;
                           timerFu = 10;
                        }
                     default:
                        break label728;
                  }
               case 10:
                  switch (airComboTier) {
                     case 1:
                        mountFacing = 2;
                        B = 16;
                        break;
                     case 2:
                        mountFacing = 0;
                        B = 14;
                        break;
                     case 3:
                     case 4:
                        B = 13;
                        mountFacing = -1;
                        break;
                     case 5:
                        B = 13;
                        mountFacing = -1;
                        if (z != 0) {
                           playerState = 4;
                        } else {
                           playerState = 1;
                        }

                        timerFt = 0;
                        burrowSubstate = 0;
                  }
            }

            if (mountSubstate == 1) {
               mountFacing = -1;
            }

            if (playerState == 5) {
               if (z != 0) {
                  B += 14;
               } else if (y != 0) {
                  B += 22;
               }
            }
            break;
         case 6:
            playerX += y;
            if (y > 1) {
               --y;
            }

            if (y < -1) {
               ++y;
            }

            ++z;
            playerY += z;
            B = 21;
            if (playerY >= iQ || playerY > cutsceneQ + r + spriteHeight || g(playerX, playerY - spriteHeight, 4096)) {
               playerX = cameraScrollY;
               playerY = cameraBound;
               playerState = 4;
               hp = hpMax / 3;
               mp = mpMax / 3;
               z = 0;
               y = 0;
               burrowSubstate = 0;
               airComboTier = 0;
               expInLevel >>= 1;
               c = true;
               if (hd) {
                  regenTimer = hi;
               }

               if (hj) {
                  idleTimerLong = ho;
               }

               aI();
               s(5);
               d = 7;
            }
            break;
         case 7:
            if ((i(playerX + halfWidth, playerY - halfHeight) & 4) == 4) {
               y = -y;
            }

            if ((i(playerX - halfWidth, playerY - halfHeight) & 8) == 8) {
               y = -y;
            }

            playerX += y;
            playerY += z;
            B = 21;
            if (y > 1) {
               --y;
            }

            if (y < -1) {
               ++y;
            }

            if (++z > 0) {
               z = 0;
            }

            if (++airComboTier >= 7) {
               playerState = 4;
               moveCounter = -20;
               burrowSubstate = 0;
               airComboTier = 0;
               z = 0;
            }

            w();
            break;
         case 8:
            B = 22;
            if (airComboTier < 5) {
               ++airComboTier;
            } else if (!aS[8]) {
               playerState = 1;
            }

            if (++burrowSubstate > 6 && g(playerX + halfWidth, playerY + 2, 8192) && g(playerX - halfWidth, playerY + 2, 8192) && skillBurrowLearned & mp > 0) {
               playerState = 13;
            }
         case 9:
         case 10:
         case 22:
         default:
            break;
         case 11:
            U();
            break;
         case 12:
            playerY += z;
            if (z < 20 && mapSubIdLegacy % 2 == 0) {
               ++z;
            }

            B = 7;
            if (playerY >= iQ) {
               hp = 0;
               playerState = 6;
               mountFacing = -1;
            } else if (g(playerX, playerY, 2)) {
               playerY = H(playerY);
               if (g(playerX, playerY - 2, 64)) {
                  playerState = 1;
                  z = 0;
                  y = 0;
                  burrowSubstate = 0;
                  airComboTier = 0;
               } else if (skillSwimLearned) {
                  playerState = 17;
                  z = 0;
                  y = 0;
                  burrowSubstate = 0;
                  airComboTier = 0;
               } else {
                  playerState = 6;
               }

               playerY = I(playerY);
            } else if (g(playerX, playerY - spriteHeight - 5, 4096)) {
               hp = 0;
               playerState = 6;
               mountFacing = -1;
            }
            break;
         case 13:
            B = 24;
            playerY += 28;
            playerState = 14;
            break;
         case 14:
            if (mapSubIdLegacy % 20 > 2) {
               B = 25;
            } else {
               B = 26;
            }

            if (mapSubIdLegacy % 8 == 0) {
               if (--mp <= 0) {
                  mp = 0;
                  playerState = 15;
               }

               c = true;
            }
            break;
         case 15:
            playerY -= 10;
            z = -10;
            playerState = 3;
            break;
         case 16:
            if (++airComboTier >= 20) {
               airComboTier = 0;
            }

            if ((B = (airComboTier >> 2) + 2) % 2 == 0) {
               mountFacing = 7;
            } else {
               mountFacing = 8;
            }

            if (playerFacing == 1) {
               if (g(playerX + halfWidth, playerY - halfHeight, 4)) {
                  y = 0;
                  playerX = I(playerX + halfWidth) - halfWidth;
               }
            } else if (g(playerX - halfWidth - 1, playerY - halfHeight, 8)) {
               y = 0;
               playerX = I(playerX - halfWidth - 1) + jf + halfWidth;
            }

            playerX += y;
            if (y > 0) {
               --y;
            } else if (y < 0) {
               ++y;
            } else {
               playerState = 17;
            }

            if ((i(playerX, playerY) & 2) != 2) {
               playerState = 12;
               y = playerFacing << 2;
               burrowSubstate = 0;
            }
            break;
         case 17:
            if (++airComboTier > 30) {
               airComboTier = 0;
            }

            if (airComboTier % 15 < 5) {
               B = 0;
               mountFacing = 7;
            } else {
               B = 1;
               mountFacing = 8;
            }
            break;
         case 18:
            if (mapSubIdLegacy % 8 > 3) {
               B = 43;
            } else {
               B = 44;
               e(playerFacing, playerX - (playerFacing << 4), playerY - 5);
            }

            airComboTier = 0;
            break;
         case 19:
            if (mapSubIdLegacy % 8 > 3) {
               B = 43;
            } else {
               B = 44;
               e(playerFacing, playerX - (playerFacing << 4), playerY - 5);
            }

            if (airComboTier > 0) {
               --airComboTier;
               B = 45;
            }

            if (playerFacing == 1) {
               if (g(playerX + halfWidth, playerY - halfHeight, 4)) {
                  y = 0;
                  playerX = I(playerX + halfWidth) - halfWidth;
               }
            } else if (g(playerX - halfWidth - 1, playerY - halfHeight, 8)) {
               y = 0;
               playerX = I(playerX - halfWidth - 1) + jf + halfWidth;
            }

            if ((i(playerX, playerY - 1) & 64) == 64) {
               playerX += y >> 1;
            } else {
               playerX += y;
            }

            mapObjTileX[mapObjectMountIndex] = playerX;
            mapObjTileY[mapObjectMountIndex] = playerY;
            if (y > 0) {
               --y;
            } else if (y < 0) {
               ++y;
            } else {
               playerState = 18;
               cameraScrollX = 0;
            }

            if (mapNpcFocusIndex != -1) {
               if (a(playerX - mapNpcTileX[mapNpcFocusIndex]) >= 20) {
                  mapNpcFocusIndex = -1;
                  if (g(playerX, playerY, 2)) {
                     playerState = 18;
                  } else {
                     playerState = 20;
                     z = 2;
                     y = 3 * playerFacing;
                     burrowSubstate = 0;
                  }
               }
            } else if ((i(playerX, playerY) & 2) != 2) {
               playerState = 20;
               y = 3 * playerFacing;
               burrowSubstate = 0;
            }

            e(playerFacing, playerX - (playerFacing << 3), playerY);
            S();
            int var0;
            if ((var0 = z()) != -1 && (jQ[var0] == 2 || jQ[var0] == 3)) {
               k(var0, 2, -playerFacing);
               f(jL[var0], jM[var0] - (jN[var0] >> 1), playerFacing);
               a("-2", 0, jL[var0], jM[var0] - jN[var0], 0, -2);
            }
            break;
         case 20:
            try {
               if (playerFacing == 1) {
                  if ((i(playerX + halfWidth, playerY - halfHeight) & 4) == 4) {
                     y = 0;
                  }
               } else if ((i(playerX - halfWidth, playerY - halfHeight) & 8) == 8) {
                  y = 0;
               }

               mountFacing = -1;
               playerX += y;
               playerY += z;
               if (z < 20) {
                  ++z;
               }

               if (y > 0) {
                  --y;
               }

               if (mapSubIdLegacy % 8 > 3) {
                  B = 43;
               } else {
                  B = 44;
                  e(playerFacing, playerX - (playerFacing << 4), playerY - 5);
               }

               if (z > 4 && (i(playerX, playerY) & 2) == 2) {
                  if (z < 8) {
                     playerState = 18;
                     z = 0;
                     y = 0;
                     burrowSubstate = 0;
                     airComboTier = 0;
                     playerY = I(playerY);
                  } else {
                     playerState = 21;
                     z = -(z / 3);
                     playerY = I(playerY);
                  }
               }

               if (g(playerX, playerY, 64) && playerY % jf > 8) {
                  g(playerX, H(playerY) + 8);
               }

               mapObjTileX[mapObjectMountIndex] = playerX;
               mapObjTileY[mapObjectMountIndex] = playerY;
               if (g(playerX, playerY, 4096)) {
                  mapObjType[mapObjectMountIndex] = 1;
                  mapObjectMountIndex = -1;
                  playerState = 12;
               }
            } catch (Exception var2) {
            }

            if (moveCounter < 0) {
               ++moveCounter;
            }
            break;
         case 21:
            if (playerFacing == 1) {
               if ((i(playerX + halfWidth, playerY - halfHeight) & 4) == 4) {
                  y = 0;
               }
            } else if ((i(playerX - halfWidth, playerY - halfHeight) & 8) == 8) {
               y = 0;
            }

            playerX += y;
            playerY += z;
            mapObjTileX[mapObjectMountIndex] = playerX;
            mapObjTileY[mapObjectMountIndex] = playerY;
            if (y > 0) {
               --y;
            }

            if (++z == 0) {
               playerState = 20;
               airComboTier = 0;
               burrowSubstate = skillBridgeIsWallJumpLearned() ? 1 : 0;
               z = 1;
               c = true;
            }

            if (moveCounter < 0) {
               ++moveCounter;
            }

            if (mapSubIdLegacy % 8 > 3) {
               B = 43;
            } else {
               B = 44;
               e(playerFacing, playerX - (playerFacing << 4), playerY - 5);
            }

            if (airComboTier > 0) {
               --airComboTier;
               B = 45;
            }
            break;
         case 25:
            DashSkill.getInstance().tick(GameSkillContext.INSTANCE);
            break;
         case 23:
            T();
      }

      if (mapSubIdLegacy % 3 == 0) {
         if (gameModeFx) {
            if (--mp <= 0) {
               mp = 0;
               gameModeFx = false;
            }

            c = true;
         }

         if (genderSpriteFlag) {
            if (--mp <= 0) {
               mp = 0;
               genderSpriteFlag = false;

               for(int var1 = 0; var1 < 4; ++var1) {
                  Image var7 = ep[var1];
                  ep[var1] = eq[var1];
                  eq[var1] = var7;
               }
            }

            c = true;
         }
      }

   }

   private static final void S() {
      if (!a) {
         if (g(playerX, playerY + 1, 2048)) {
            h(playerX, playerY + 1, 1024);
            h(playerX, playerY - 2, 1024);
         }

         if (g(playerX - jf, playerY + 1, 1024)) {
            j(playerX - jf, playerY + 1, 1024);
            j(playerX - jf, playerY - 2, 1024);
         }

         if (g(playerX + jf, playerY + 1, 1024)) {
            j(playerX + jf, playerY + 1, 1024);
            j(playerX + jf, playerY - 2, 1024);
         }

      }
   }

   private static void T() {
      if (++airComboTier == 1) {
         f(playerX, playerY - 40);
         aK = 0;
         if (eq == null) {
            eq = new Image[4];

            try {
               eq[0] = Image.createImage("/cp/ch0x.png");
               eq[1] = Image.createImage("/cp/ch1x.png");
            } catch (Exception var2) {
            }

            eq[2] = eq[1];
            eq[3] = eq[0];
         }
      } else if (airComboTier >= 30) {
         playerState = 1;
         airComboTier = 0;
         if (mp == 0) {
            return;
         }

         for(int var1 = 0; var1 < 4; ++var1) {
            Image var0 = ep[var1];
            ep[var1] = eq[var1];
            eq[var1] = var0;
         }

         genderSpriteFlag = !genderSpriteFlag;
      } else if (airComboTier <= 10) {
         if (airComboTier % 5 == 0) {
            for(int var6 = 0; var6 < 4; ++var6) {
               Image var3 = ep[var6];
               ep[var6] = eq[var6];
               eq[var6] = var3;
            }
         }
      } else if (airComboTier < 20) {
         if (airComboTier % 3 == 0) {
            for(int var7 = 0; var7 < 4; ++var7) {
               Image var4 = ep[var7];
               ep[var7] = eq[var7];
               eq[var7] = var4;
            }
         }
      } else if (airComboTier < 30 && airComboTier % 2 == 0) {
         for(int var8 = 0; var8 < 4; ++var8) {
            Image var5 = ep[var8];
            ep[var8] = eq[var8];
            eq[var8] = var5;
         }
      }

      if (airComboTier % 2 > 0) {
         B = 0;
      } else {
         B = 1;
      }
   }

   private static void U() {
      if (++airComboTier >= 5) {
         airComboTier = 0;
         cameraScrollX = 0;
      }

      B = airComboTier + 2;
      if (playerFacing == 1) {
         if (g(playerX + halfWidth, playerY - 1, 4)) {
            y = 0;
            playerX = I(playerX + halfWidth) - halfWidth;
         }
      } else if (g(playerX - halfWidth - 1, playerY - 1, 8)) {
         y = 0;
         playerX = I(playerX - halfWidth - 1) + jf + halfWidth;
      }

      playerX += y;
      if (y > 0) {
         --y;
      } else if (y < 0) {
         ++y;
      } else if (!skillStandOnWaterLearned) {
         playerState = 12;
         cameraScrollX = 0;
      } else {
         playerState = 3;
         z = -8;
         burrowSubstate = 0;
         airComboTier = 0;
      }

      if (mapSubIdLegacy % 8 == 0) {
         if ((mp -= 3) <= 0) {
            mp = 0;
            y = 0;
            playerState = 12;
         }

         c = true;
      }

      for(int var0 = 0; var0 < mapNpcBundleCount; ++var0) {
         if (a(playerX - mapNpcTileX[var0]) < 20 && mapNpcTileY[var0] > playerY && mapNpcTileY[var0] - 24 < playerY) {
            y = 0;
            if (playerX < mapNpcTileX[var0]) {
               playerX = mapNpcTileX[var0] - 20;
            } else {
               playerX = mapNpcTileX[var0] + 20;
            }

            playerState = 12;
            break;
         }
      }

      g(playerX, playerY);
      e(playerFacing, playerX - (playerFacing << 3), playerY);
   }

   private static boolean V() {
      if (!fT) {
         if (bv > 1) {
            bv >>= 1;
            c = true;
         }

         return false;
      } else {
         if (gb) {
            if (aT[5]) {
               d();
               K();
               if (iD == iC) {
                  iA = false;
                  gb = false;
                  y();
               }
            }
         } else {
            if (bv < bu) {
               bv += (bu - bv >> 1) + 1;
            }

            if (fW) {
               if (fY < fZ) {
                  fY += 2;
               } else {
                  fY = fZ;
               }
            }

            if (++ga >= az[fU][fV]) {
               ga = az[fU][fV];
               switch (ax[fU][fV]) {
                  case 1:
                     F(ay[fU][fV]);
                     ++fV;
                     break;
                  case 2:
                     G(ay[fU][fV]);
                     ++fV;
                     break;
                  case 3:
                     fT = false;
                     c = true;
                     ++fV;
                     break;
                  case 4:
                     if (playerState == 1) {
                        fW = false;
                        int var3 = 0;
                        int var1 = 0;
                        switch (aC[ay[fU][fV]]) {
                           case 0:
                              var3 = playerX;
                              var1 = playerY;
                              break;
                           case 1:
                              var3 = lw[aB[ay[fU][fV]]];
                              var1 = lx[aB[ay[fU][fV]]];
                              break;
                           case 2:
                              var3 = dA[aB[ay[fU][fV]]];
                              var1 = dB[aB[ay[fU][fV]]];
                              break;
                           case 3:
                           case 4:
                              var3 = companionX;
                              var1 = companionY;
                        }

                        var1 -= 40;
                        a(StoryDialogue.aE[ay[fU][fV]], -1, var3, var1);
                        ++fV;
                        gb = true;
                     }
                     break;
                  case 5:
                     a(mapId, ay[fU][fV], playerY - 50, -1);
                     ++fV;
                     break;
                  case 6:
                     scriptMapId = -1;
                     ++fV;
                     break;
                  case 7:
                     gameModeFv = true;
                     ++fV;
                     break;
                  case 8:
                     gameModeFv = false;
                     ++fV;
                     break;
                  case 9:
                     cutsceneP = aA[ay[fU][fV]][0] - bD;
                     cutsceneQ = aA[ay[fU][fV]][1] - bE;
                     if (cutsceneP < 0) {
                        cutsceneP = 0;
                     }

                     if (cutsceneP > cutsceneR) {
                        cutsceneP = cutsceneR;
                     }

                     if (cutsceneQ < 0) {
                        cutsceneQ = 0;
                     }

                     if (cutsceneQ > cutsceneS) {
                        cutsceneQ = cutsceneS;
                     }

                     cutsceneJ = cutsceneP;
                     cutsceneK = cutsceneQ;
                     ++fV;
                     break;
                  case 10:
                     cutsceneJ = aA[ay[fU][fV]][0] - bD;
                     cutsceneK = aA[ay[fU][fV]][1] - bE;
                     if (cutsceneJ < 0) {
                        cutsceneJ = 0;
                     }

                     if (cutsceneJ > cutsceneR) {
                        cutsceneJ = cutsceneR;
                     }

                     if (cutsceneK < 0) {
                        cutsceneK = 0;
                     }

                     if (cutsceneK > cutsceneS) {
                        cutsceneK = cutsceneS;
                     }

                     ++fV;
                     break;
                  case 11:
                     cutsceneJ = gQ - bD;
                     cutsceneK = gR - bE;
                     if (cutsceneJ < 0) {
                        cutsceneJ = 0;
                     }

                     if (cutsceneJ > cutsceneR) {
                        cutsceneJ = cutsceneR;
                     }

                     if (cutsceneK < 0) {
                        cutsceneK = 0;
                     }

                     if (cutsceneK > cutsceneS) {
                        cutsceneK = cutsceneS;
                     }

                     ++fV;
                     break;
                  case 12:
                     cutsceneK = cutsceneQ += 2;
                     if (cutsceneQ > aA[ay[fU][fV]][1] - bE) {
                        ++fV;
                     }
                  case 13:
                  default:
                     break;
                  case 14:
                     cutsceneJ = cutsceneP -= 2;
                     if (cutsceneP < aA[ay[fU][fV]][0] - bD) {
                        ++fV;
                     }
                     break;
                  case 15:
                     fW = true;
                     fX = Midlet.a(StoryDialogue.aF[ay[fU][fV]], q - 40);
                     if ((fZ = (bu >> 1) - (fX.length << 3)) < 3) {
                        fZ = 2;
                     }

                     fY = -fX.length << 3;
                     ++fV;
                     break;
                  case 16:
                     dy = true;
                     dz = ay[fU][fV];
                     ++fV;
                     break;
                  case 17:
                     cameraScrollY = playerX = jv;
                     cameraBound = playerY = jw;
                     A();
                     Midlet.f = true;
                     x(ay[fU][fV]);
                     return true;
                  case 18:
                     V(ay[fU][fV]);
                     ++fV;
                     break;
                  case 19:
                     escortActive = true;
                     ++fV;
                     break;
                  case 20:
                     escortActive = false;
                     escortMapId = 0;
                     companionX = 1080;
                     companionY = 408;
                     ++fV;
                     break;
                  case 21:
                     activeQuestId = -1;
                     skillMotorcycleLearned = true;
                     c("nhận bằng lái môtô");
                     a(0, lw[4], lx[4] - 40, 4);
                     ++fV;
                     break;
                  case 22:
                     for(int var2 = 0; var2 <= 6; ++var2) {
                        i(24, var2, 0);
                     }

                     unlockedMap97 = true;
                     ++fV;
                     break;
                  case 23:
                     gameModeFv = false;
                     cutsceneJ = dA[ay[fU][fV]] - bD;
                     cutsceneK = dB[ay[fU][fV]] - bE;
                     if (cutsceneJ < 0) {
                        cutsceneJ = 0;
                     }

                     if (cutsceneJ > cutsceneR) {
                        cutsceneJ = cutsceneR;
                     }

                     if (cutsceneK < 0) {
                        cutsceneK = 0;
                     }

                     if (cutsceneK > cutsceneS) {
                        cutsceneK = cutsceneS;
                     }

                     ++fV;
                     break;
                  case 24:
                     dy = true;
                     dz = ay[fU][fV];
                     ++fV;
                     break;
                  case 25:
                     hf = true;
                     ++fV;
                     break;
                  case 26:
                     for(int var0 = 0; var0 <= 10; ++var0) {
                        i(24, var0, 0);
                     }

                     unlockedMap96 = true;
                     ++fV;
                     break;
                  case 27:
                     gameModeFv = false;
                     cutsceneJ = hq - bD;
                     cutsceneK = hr - bE;
                     if (cutsceneJ < 0) {
                        cutsceneJ = 0;
                     }

                     if (cutsceneJ > cutsceneR) {
                        cutsceneJ = cutsceneR;
                     }

                     if (cutsceneK < 0) {
                        cutsceneK = 0;
                     }

                     if (cutsceneK > cutsceneS) {
                        cutsceneK = cutsceneS;
                     }

                     ++fV;
                     break;
                  case 28:
                     scriptHsStep = 1;
                     ++fV;
                     break;
                  case 29:
                     d();
                     c();
                     iU = null;
                     iV = null;
                     iW = null;
                     iX = null;
                     iR = null;
                     iS = null;
                     TileCollision.clear();
                     System.gc();
                     lu = null;
                     System.gc();
                     ec = null;
                     ef = null;
                     eh = null;
                     ew = null;
                     System.gc();
                     ey = null;
                     System.gc();
                     jH = null;
                     System.gc();
                     B();
                     et = null;
                     ej = null;
                     dZ = null;
                     ek = null;
                     el = null;
                     es = null;
                     ez = null;
                     eE = null;
                     ea = null;
                     System.gc();
                     er = null;
                     ee = null;
                     ep = null;
                     eq = null;
                     eC = null;
                     System.gc();
                     I();
                     return true;
                  case 30:
                     activeQuestId = -1;
                     questMeetGirlUnlocked = false;
                     skillGateBeforeKC2 = true;
                     escortMapId = 0;
                     companionX = 648;
                     companionY = 288;
                     escortActive = false;
                     c("gặp cô Ayumi");
                     a(0, 1032, 368, 4);
                     ++fV;
                     break;
                  case 31:
                     gameModeFv = false;
                     cutsceneJ = companionX - bD;
                     cutsceneK = companionY - bE;
                     if (cutsceneJ < 0) {
                        cutsceneJ = 0;
                     }

                     if (cutsceneJ > cutsceneR) {
                        cutsceneJ = cutsceneR;
                     }

                     if (cutsceneK < 0) {
                        cutsceneK = 0;
                     }

                     if (cutsceneK > cutsceneS) {
                        cutsceneK = cutsceneS;
                     }

                     ++fV;
                     break;
                  case 32:
                     escortActive = true;
                     companionMode = 2;
                     companionVel = -5;
                     companionFaceDir = -1;
                     gL = 8;
                     ++fV;
                     break;
                  case 33:
                     questGeninGraduated = true;
                     escortActive = true;
                     ++fV;
               }
            }
         }

         aS[5] = false;
         aT[5] = false;
         return false;
      }
   }

   private static void W() {
      for(int var0 = 0; var0 < df; ++var0) {
         if (di[var0] != 0) {
            if (a(playerY - (spriteHeight >> 1) - (dh[var0] - 7)) < 10 && a(playerX - dg[var0]) < 10) {
               gold += dm[var0];
               c = true;
               di[var0] = 301;
               a("+" + dm[var0], 1, dg[var0], dh[var0] - 15, 0, -1);
            }

            int[] var10000 = dg;
            var10000[var0] += dj[var0];
            var10000 = dh;
            var10000[var0] += dk[var0];
            if (dj[var0] > 1) {
               int var10002 = dj[var0]--;
            }

            if (dj[var0] < -1) {
               int var2 = dj[var0]++;
            }

            if (dk[var0] < 20) {
               int var3 = dk[var0]++;
            }

            int var4 = di[var0]++;
            if (di[var0] > 200) {
               di[var0] = 0;
            }

            if (di[var0] % 20 > 18) {
               dl[var0] = 0;
            } else if (di[var0] % 20 > 16) {
               dl[var0] = 1;
            } else {
               dl[var0] = 2;
            }

            if (dh[var0] >= 0 && dh[var0] < iQ && dg[var0] < iP && dg[var0] >= 0) {
               if (dk[var0] > 2 && (i(dg[var0], dh[var0]) & 2) == 2) {
                  dh[var0] = H(dh[var0]);
                  if (dk[var0] > 2) {
                     dk[var0] = -(dk[var0] >> 1);
                  } else {
                     dj[var0] = 0;
                     dk[var0] = 0;
                  }
               }
            } else {
               di[var0] = 0;
            }
         }
      }

   }

   private static void X() {
      if (iA && iJ < iF[iD].length && ++iI >= iF[iD][iJ].length()) {
         iI = 0;
         ++iJ;
      }

   }

   private static void Y() {
      if (mapSubIdLegacy % 2 == 0 && ((dp += dr) > dt || dp < ds)) {
         dr = -dr;
         dp += dr;
      }

   }

   private static void Z() {
      for(int var0 = 0; var0 < cW; ++var0) {
         if (cZ[var0] != 1) {
            if (cZ[var0] > 1) {
               int var12 = cZ[var0]++;
               if (cZ[var0] >= 10) {
                  cZ[var0] = 1;
                  dc[var0] = 12;
                  db[var0] = 0;
               }
            }
         } else {
            int[] var10000 = cX;
            var10000[var0] += db[var0];
            var10000 = cY;
            var10000[var0] += dc[var0];
            if (cX[var0] >= cutsceneP && cX[var0] <= cutsceneP + q && cY[var0] >= cutsceneQ && cY[var0] <= cutsceneQ + r) {
               if (db[var0] > 0 && (i(cX[var0], cY[var0]) & 4) == 4) {
                  cZ[var0] = 2;
                  cX[var0] = I(cX[var0]);
               } else if (db[var0] < 0 && (i(cX[var0], cY[var0]) & 8) == 8) {
                  cZ[var0] = 2;
                  cX[var0] = I(cX[var0]) + jf;
               }

               int var10002 = da[var0]++;
               if (da[var0] > 1) {
                  da[var0] = 0;
               }

               if (db[var0] != 0) {
                  for(int var1 = 0; var1 < jI; ++var1) {
                     if (jQ[var1] != 5 && jQ[var1] != 1 && a(jL[var1] - cX[var0]) < jO[var1] && a(jM[var1] - (jN[var1] >> 1) - cY[var0]) < jN[var1]) {
                        int var2;
                        boolean var9;
                        label205: {
                           var2 = dd[var0] ? shurikenDmg << 1 : shurikenDmg;
                           if (jQ[var1] == 2 || jQ[var1] == 3 || jQ[var1] == 4) {
                              if (jK[var1] == 9 && db[var0] * jZ[var1] < 0) {
                                 jQ[var1] = 4;
                                 jV[var1] = 4;
                                 db[var0] = -db[var0];
                                 dc[var0] = -dc[var0];
                                 var10000 = cX;
                                 var10000[var0] += db[var0];
                                 var10000 = cY;
                                 var10000[var0] += dc[var0];
                                 var9 = true;
                                 break label205;
                              }

                              var10000 = ka;
                              var10000[var1] -= var2;
                              if (ka[var1] <= 0) {
                                 ka[var1] = 0;
                                 jV[var1] = -5;
                                 jW[var1] = db[var0];
                                 jX[var1] = 0;
                                 jP[var1] = 0;
                                 jQ[var1] = 1;
                                 L(var1);
                                 var9 = true;
                                 break label205;
                              }

                              jV[var1] = 0;
                              jZ[var1] = db[var0] < 0 ? 1 : -1;
                              jQ[var1] = 6;
                              jY[var1] = 3;
                              cZ[var0] = -1;
                           }

                           var9 = false;
                        }

                        if (!var9) {
                           f(jL[var1], jM[var1] - (jN[var1] >> 1), jZ[var1]);
                           a("-" + var2, 0, jL[var1], jM[var1] - jN[var1], 0, -2);
                        }
                        break;
                     }
                  }

                  for(int var6 = 0; var6 < cq; ++var6) {
                     if (cF[var6] != 5 && cF[var6] != 1 && a(cv[var6] - cX[var0]) < 20 && a(cw[var6] - 15 - cY[var0]) < 20) {
                        if (dd[var0]) {
                           a(var6, shurikenDmg << 1, cI[var0]);
                           f(cv[var6], cw[var6] - 15, cI[var6]);
                           a("-" + (shurikenDmg << 1), 0, cv[var6], cw[var6] - 32, 0, -2);
                           cZ[var0] = -1;
                        } else {
                           cF[var6] = 4;
                           cG[var6] = 0;
                           cH[var6] = 0;
                           cI[var6] = db[var0] > 0 ? -1 : 1;
                           db[var0] = -db[var0];
                        }
                        break;
                     }
                  }

                  if (!dd[var0] && a(playerX - cX[var0]) < halfWidth && a(playerY - halfHeight - cY[var0]) < halfHeight) {
                     if (playerState == 5 && mountSubstate == 0) {
                        db[var0] = -db[var0];
                        dc[var0] = -3;
                        return;
                     }

                     a(shurikenDmg, -playerFacing);
                     cZ[var0] = -1;
                     return;
                  }

                  if (gO && a(gQ - cX[var0]) < gW >> 1 && a(gR - (gX >> 1) - cY[var0]) < gX >> 1) {
                     c(shurikenDmg, -gU);
                     f(cX[var0], cY[var0], gU);
                     a("-" + shurikenDmg, 0, gQ, gR - gX, 0, -2);
                     cZ[var0] = -1;
                  }

                  if (hK && a(hQ - cX[var0]) < hP >> 1 && a(hR - (hM >> 1) - cY[var0]) < hM >> 1) {
                     db[var0] = -db[var0];
                     dc[var0] = -1;
                  }

                  if (hd && a(dA[0] - cX[var0]) < 12 && a(dB[0] - 16 - cY[var0]) < 32) {
                     if (dE[0] == 5 && db[var0] * dK[0] < 0) {
                        db[var0] = -db[var0];
                     } else if (dE[0] == 1 && db[var0] * dK[0] < 0) {
                        db[var0] = -db[var0];
                        dF[0] = dG[0] = 0;
                        dE[0] = 5;
                     } else {
                        d(shurikenDmg, -dK[0]);
                        cZ[var0] = -1;
                     }
                  }
               }
            } else {
               cZ[var0] = -1;
            }
         }
      }

   }

   private static void aa() {
      if (aN) {
         aN = false;
         c();
         if (fT) {
            aT[5] = true;
         } else if (aO > aU - 40 && aP < 40) {
            aT[5] = true;
         } else if (aP > aV - 30) {
            if (aO < aW) {
               aT[12] = true;
            } else {
               aT[13] = true;
            }
         } else if (aP <= playerY - cutsceneQ + 24 && aP >= playerY - cutsceneQ - 80 && aO <= playerX - cutsceneP + 48 && aO >= playerX - cutsceneP - 48) {
            playerFacing = playerX - cutsceneP < aO ? 1 : -1;
            aT[5] = true;
         } else if (d == 1 && !fT && aP <= playerY - cutsceneQ + 24 && aP >= playerY - cutsceneQ - 80) {
            if (aO < playerX - cutsceneP - 20) {
               DashSkill.getInstance().onDirectionKey(4);
            } else if (aO > playerX - cutsceneP + 20) {
               DashSkill.getInstance().onDirectionKey(6);
            }
         }
      }

      if (aQ && !fT && (aO <= aU - 40 || aP >= 40) && aP <= aV - 30) {
         if (aP > playerY - cutsceneQ + 24) {
            aS[8] = true;
         } else if (aP < playerY - cutsceneQ - 80) {
            aS[2] = true;
         } else if (aO > playerX - cutsceneP + 48) {
            aS[6] = true;
         } else if (aO < playerX - cutsceneP - 48) {
            aS[4] = true;
         }
      }

      if (++mapSubIdLegacy == 10000) {
         mapSubIdLegacy = 0;
      }

      if (playerX < 0) {
         if (jp != -1) {
            A();
            cameraScrollY = playerX = jt - 1;
            cameraBound = playerY = ju;
            Midlet.f = true;
            x(jp);
            return;
         }
      } else if (playerX >= iP - 24) {
         if (jq != -1) {
            if (!skillStealthLegacyFlag && jq == 95) {
               s(6);
               a("Khu vực phía trước rất nguy hiểm! Chỉ những người có thể ẩn thân có thể vào!");
               playerX = iP - 60;
               playerState = 4;
               d = 7;
               return;
            }

            A();
            if (jr != -1 && playerY > jB) {
               cameraScrollY = playerX = jx;
               cameraBound = playerY = jy;
               Midlet.f = true;
               x(jr);
               return;
            }

            cameraScrollY = playerX = jv;
            cameraBound = playerY = jw;
            Midlet.f = true;
            x(jq);
            return;
         }
      } else if (playerY + z >= iQ && playerState != 6 && js != -1) {
         A();
         cameraScrollY = playerX = jz;
         cameraBound = playerY = jA;
         Midlet.f = true;
         x(js);
         playerState = 4;
         return;
      }

      aq();
      X();
      if (!V()) {
         if (!a) {
            for(int var0 = 0; var0 < 2; ++var0) {
               if (mapSubIdLegacy % (var0 + 2 << 3) == 0) {
                  int var10002 = e[var0]++;
                  if (e[var0] > q + (t.getWidth() >> 1)) {
                     e[var0] = -(t.getWidth() >> 1);
                  }
               }
            }
         }

         if (iA) {
            if (aT[5]) {
               d();
               K();
               if (iD == iC) {
                  iA = false;
                  y();
               }
            }

            c = true;
         } else {
            label1126: {
               if (aT[12]) {
                  aD();
                  d = 5;
                  c();
                  d();
               } else if (aT[0]) {
                  if (mountSubstate == 0) {
                     if (skillShurikenLearned) {
                        mountSubstate = 1;
                     }
                  } else {
                     mountSubstate = 0;
                  }

                  c = true;
                  aT[0] = false;
               } else if (aT[6]) {
                  cameraScrollX = 2;
                  aT[6] = false;
               } else if (aT[4]) {
                  cameraScrollX = -2;
                  aT[4] = false;
               } else {
                  if (aT[9]) {
                     aT[9] = false;
                     if (AmbushSkill.getInstance().tryActivate(GameSkillContext.INSTANCE)) {
                        break label1126;
                     }
                     if (skillStealthLegacyFlag) {
                        gameModeFx = !gameModeFx;
                     }

                     break label1126;
                  }

                  if (aT[7]) {
                     if (playerState == 1 && skillTransformLearned) {
                        AmbushSkill.getInstance().clearAmbushPose();
                        playerState = 23;
                        airComboTier = 0;
                     }

                     aT[7] = false;
                  } else if (aT[10]) {
                     aT[10] = false;
                     if (hp < hpMax) {
                        for(int var4 = 0; var4 < 3; ++var4) {
                           if (inventoryCounts[var4] > 0) {
                              int var26 = inventoryCounts[var4]--;
                              if ((hp += kH[var4]) > hpMax) {
                                 hp = hpMax;
                              }

                              c = true;
                              break;
                           }
                        }
                     }
                  } else if (aT[11]) {
                     aT[11] = false;
                     if (mp < mpMax) {
                        for(int var5 = 3; var5 < 6; ++var5) {
                           if (inventoryCounts[var5] > 0) {
                              int var27 = inventoryCounts[var5]--;
                              if ((mp += kH[var5]) > mpMax) {
                                 mp = mpMax;
                              }

                              c = true;
                              break;
                           }
                        }
                     }
                  }
               }

               if (playerState == DashSkill.STATE_DASH) {
                  if (aT[5]) {
                     DashSkill.getInstance().cancelForCombat(GameSkillContext.INSTANCE);
                     aT[5] = false;
                     c = true;
                  }
               } else if (playerState == 1) {
                  if (aT[13]) {
                     d();
                     if (o.equals("Giao tiếp")) {
                        int var6 = interactTargetId;
                        switch (ly[var6]) {
                           case 0:
                              if (questGeninGraduated) {
                                 a(NPCDialogue.lD[7], -1, lw[var6], lx[var6] - 40);
                              } else if (!skillBridgeIsWallJumpLearned()) {
                                 V(2);
                                 a(QuestText.lA[0], -1, lw[var6], lx[var6] - 40);
                              } else {
                                 if (skillStealthLegacyFlag && !questGeninFlagFB) {
                                    if (activeQuestId == 16) {
                                       if (unlockedMap95) {
                                          a(QuestText.lB[14], 35, lw[var6], lx[var6] - 40);
                                       } else {
                                          a(QuestText.lC[14], -1, lw[var6], lx[var6] - 40);
                                       }
                                    } else if (activeQuestId == -1) {
                                       a(QuestText.lA[22], 36, lw[var6], lx[var6] - 40);
                                    } else {
                                       a(QuestText.lE, 1, lw[var6], lx[var6] - 40);
                                    }
                                    break;
                                 }

                                 a(NPCDialogue.lD[1], -1, lw[var6], lx[var6] - 40);
                              }
                              break;
                           case 1:
                              if (questGeninGraduated) {
                                 a(NPCDialogue.lD[5], -1, lw[var6], lx[var6] - 40);
                              } else if (!skillBridgeIsWallJumpLearned()) {
                                 if (activeQuestId == 0) {
                                    if (questProgress < questRequiredAmounts[0]) {
                                       a(QuestText.lC[0], -1, lw[var6], lx[var6] - 40);
                                    } else {
                                       boolean var2 = true;
                                       var2 = true;
                                       var2 = true;
                                       var2 = false;
                                       lI = 0;
                                       lL = 4;
                                       lJ = 1044;
                                       lK = 240;
                                       a(QuestText.lB[0], 4, lw[var6], lx[var6] - 40);
                                    }
                                 } else if (activeQuestId == -1) {
                                    a(QuestText.lA[1], 3, lw[var6], lx[var6] - 40);
                                 } else {
                                    a(QuestText.lE, 1, lw[var6], lx[var6] - 40);
                                 }
                              } else if (!questBatReward5000Done && skillTransformLearned) {
                                 if (level < 10) {
                                    a(new String[]{"Hãy quay lại gặp ta khi con đạt cấp độ 10"}, -1, lw[var6], lx[var6] - 40);
                                 } else if (activeQuestId == 7) {
                                    if (questProgress < questRequiredAmounts[7]) {
                                       a(QuestText.lC[6], -1, lw[var6], lx[var6] - 40);
                                    } else {
                                       V(2);
                                       a(QuestText.lB[6], 19, lw[var6], lx[var6] - 40);
                                    }
                                 } else if (activeQuestId == -1) {
                                    a(QuestText.lA[14], 18, lw[var6], lx[var6] - 40);
                                 } else {
                                    a(QuestText.lE, 1, lw[var6], lx[var6] - 40);
                                 }
                              } else if (skillGateBeforeKC2 && !skillBridgeIsWallJumpL2Learned()) {
                                 if (level < 12) {
                                    a(new String[]{"Hãy quay lại gặp ta khi con đạt cấp độ 12"}, -1, lw[var6], lx[var6] - 40);
                                 } else if (activeQuestId == 11) {
                                    if (questProgress < 20) {
                                       a(QuestText.lC[9], -1, lw[var6], lx[var6] - 40);
                                    } else {
                                       V(4);
                                       a(QuestText.lB[9], 27, lw[var6], lx[var6] - 40);
                                    }
                                 } else if (activeQuestId == -1) {
                                    a(QuestText.lA[17], 28, lw[var6], lx[var6] - 40);
                                 } else {
                                    a(QuestText.lE, 1, lw[var6], lx[var6] - 40);
                                 }
                              } else {
                                 if (!skillSpeedBoostLearned && shurikenLevel2Learned) {
                                    if (level < 15) {
                                       a(new String[]{"Hãy quay lại gặp ta khi con đạt cấp độ 15"}, -1, lw[var6], lx[var6] - 40);
                                    } else if (activeQuestId == 13) {
                                       if (questProgress < questRequiredAmounts[13]) {
                                          a(QuestText.lC[11], -1, lw[var6], lx[var6] - 40);
                                       } else {
                                          V(3);
                                          a(QuestText.lB[11], 31, lw[var6], lx[var6] - 40);
                                       }
                                    } else if (activeQuestId == -1) {
                                       a(QuestText.lA[19], 32, lw[var6], lx[var6] - 40);
                                    } else {
                                       a(QuestText.lE, 1, lw[var6], lx[var6] - 40);
                                    }
                                    break;
                                 }

                                 a(NPCDialogue.lD[0], -1, lw[var6], lx[var6] - 40);
                              }
                              break;
                           case 2:
                              if (questGeninGraduated) {
                                 a(NPCDialogue.lD[9], -1, lw[var6], lx[var6] - 40);
                              } else if (!skillBridgeIsWallJumpLearned()) {
                                 V(1);
                                 a(QuestText.lA[2], -1, lw[var6], lx[var6] - 40);
                              } else if (skillBurrowLearned && !skillMotorcycleLearned) {
                                 if (activeQuestId == 3) {
                                    a(QuestText.lA[9], -1, lw[var6], lx[var6] - 40);
                                 } else if (activeQuestId == -1) {
                                    a(QuestText.lA[10], 11, lw[var6], lx[var6] - 40);
                                 } else {
                                    a(QuestText.lE, 1, lw[var6], lx[var6] - 40);
                                 }
                              } else if (questBatReward5000Done && !questTonikuBranchDone) {
                                 if (activeQuestId == 8) {
                                    if (unlockedMap96) {
                                       V(2);
                                       a(QuestText.lB[7], 23, lw[var6], lx[var6] - 40);
                                    } else {
                                       a(QuestText.lC[7], -1, lw[var6], lx[var6] - 40);
                                    }
                                 } else if (activeQuestId == -1) {
                                    a(QuestText.lA[15], 22, lw[var6], lx[var6] - 40);
                                 } else {
                                    a(QuestText.lE, 1, lw[var6], lx[var6] - 40);
                                 }
                              } else {
                                 if (questTonikuBranchDone && !questMeetGirlUnlocked) {
                                    if (activeQuestId == 9) {
                                       if (questProgress < questRequiredAmounts[9]) {
                                          a(QuestText.lC[8], -1, lw[var6], lx[var6] - 40);
                                       } else {
                                          V(3);
                                          a(QuestText.lB[8], 25, lw[var6], lx[var6] - 40);
                                       }
                                    } else if (activeQuestId == -1) {
                                       a(QuestText.lA[16], 24, lw[var6], lx[var6] - 40);
                                    } else {
                                       a(QuestText.lE, 1, lw[var6], lx[var6] - 40);
                                    }
                                    break;
                                 }

                                 a(NPCDialogue.lD[3], -1, lw[var6], lx[var6] - 40);
                              }
                              break;
                           case 3:
                              if (questGeninGraduated) {
                                 a(NPCDialogue.lD[9], -1, lw[var6], lx[var6] - 40);
                              } else {
                                 if (skillBridgeIsWallJumpLearned() && skillShurikenLearned) {
                                    if (!skillBurrowLearned) {
                                       if (activeQuestId == 2) {
                                          if (!questBool) {
                                             a(QuestText.lC[2], -1, lw[var6], lx[var6] - 40);
                                          } else {
                                             V(2);
                                             a(QuestText.lB[2], 10, lw[var6], lx[var6] - 40);
                                          }
                                       } else if (activeQuestId == -1) {
                                          a(QuestText.lA[8], 9, lw[var6], lx[var6] - 40);
                                       } else {
                                          a(QuestText.lE, 1, lw[var6], lx[var6] - 40);
                                       }
                                       break;
                                    }

                                    if (!skillSwimLearned && skillAttackDoubledQuest) {
                                       if (activeQuestId == 5) {
                                          if (!questBool) {
                                             a(QuestText.lC[4], -1, lw[var6], lx[var6] - 40);
                                          } else {
                                             V(4);
                                             a(QuestText.lB[4], 15, lw[var6], lx[var6] - 40);
                                          }
                                       } else if (activeQuestId == -1) {
                                          a(QuestText.lA[12], 14, lw[var6], lx[var6] - 40);
                                       } else {
                                          a(QuestText.lE, 1, lw[var6], lx[var6] - 40);
                                       }
                                       break;
                                    }

                                    if (!skillStandOnWaterLearned && skillSpeedBoostLearned) {
                                       if (level < 16) {
                                          a(new String[]{"Hãy quay lại gặp ta khi con đạt cấp độ 16"}, -1, lw[var6], lx[var6] - 40);
                                       } else if (activeQuestId == 14) {
                                          if (questProgress < questRequiredAmounts[14]) {
                                             a(QuestText.lC[12], -1, lw[var6], lx[var6] - 40);
                                          } else {
                                             V(3);
                                             a(QuestText.lB[12], 33, lw[var6], lx[var6] - 40);
                                          }
                                       } else if (activeQuestId == -1) {
                                          a(QuestText.lA[20], 34, lw[var6], lx[var6] - 40);
                                       } else {
                                          a(QuestText.lE, 1, lw[var6], lx[var6] - 40);
                                       }
                                       break;
                                    }

                                    if (!skillStealthLegacyFlag && skillStandOnWaterLearned) {
                                       if (activeQuestId == 15) {
                                          if (!questBool) {
                                             a(QuestText.lC[13], -1, lw[var6], lx[var6] - 40);
                                          } else {
                                             V(0);
                                             a(QuestText.lB[13], 21, lw[var6], lx[var6] - 40);
                                          }
                                       } else if (activeQuestId == -1) {
                                          a(QuestText.lA[21], 20, lw[var6], lx[var6] - 40);
                                       } else {
                                          a(QuestText.lE, 1, lw[var6], lx[var6] - 40);
                                       }
                                       break;
                                    }

                                    a(NPCDialogue.lD[4], -1, lw[var6], lx[var6] - 40);
                                    break;
                                 }

                                 a(QuestText.lA[5], -1, lw[var6], lx[var6] - 40);
                              }
                              break;
                           case 4:
                              if (questGeninGraduated) {
                                 a(NPCDialogue.lD[8], -1, lw[var6], lx[var6] - 40);
                              } else if (mapId == 99) {
                                 a(QuestText.lA[7], -1, lw[var6], lx[var6] - 40);
                              } else if (!skillBridgeIsWallJumpLearned()) {
                                 a(QuestText.lA[4], -1, lw[var6], lx[var6] - 40);
                              } else if (!skillShurikenLearned) {
                                 if (activeQuestId == 1) {
                                    if (questProgress < questRequiredAmounts[1]) {
                                       a(QuestText.lC[3], -1, lw[var6], lx[var6] - 40);
                                    } else {
                                       V(3);
                                       a(QuestText.lB[1], 6, lw[var6], lx[var6] - 40);
                                    }
                                 } else if (activeQuestId == -1) {
                                    a(QuestText.lA[6], 5, lw[var6], lx[var6] - 40);
                                 } else {
                                    a(QuestText.lE, 1, lw[var6], lx[var6] - 40);
                                 }
                              } else if (skillMotorcycleLearned && !skillAttackDoubledQuest) {
                                 if (activeQuestId == 4) {
                                    if (questProgress < questRequiredAmounts[4]) {
                                       a(QuestText.lC[3], -1, lw[var6], lx[var6] - 40);
                                    } else {
                                       V(3);
                                       a(QuestText.lB[3], 12, lw[var6], lx[var6] - 40);
                                    }
                                 } else if (activeQuestId == -1) {
                                    a(QuestText.lA[11], 13, lw[var6], lx[var6] - 40);
                                 } else {
                                    a(QuestText.lE, 1, lw[var6], lx[var6] - 40);
                                 }
                              } else if (skillSwimLearned && !skillTransformLearned) {
                                 if (level < 8) {
                                    a(new String[]{"Hãy quay lại gặp ta khi con đạt cấp độ 8"}, -1, lw[var6], lx[var6] - 40);
                                 } else if (activeQuestId == 6) {
                                    if (!questBool) {
                                       a(QuestText.lC[5], -1, lw[var6], lx[var6] - 40);
                                    } else {
                                       V(1);
                                       a(QuestText.lB[5], 17, lw[var6], lx[var6] - 40);
                                    }
                                 } else if (activeQuestId == -1) {
                                    a(QuestText.lA[13], 16, lw[var6], lx[var6] - 40);
                                 } else {
                                    a(QuestText.lE, 1, lw[var6], lx[var6] - 40);
                                 }
                              } else {
                                 if (!shurikenLevel2Learned && skillBridgeIsWallJumpL2Learned()) {
                                    if (activeQuestId == 12) {
                                       if (questProgress < questRequiredAmounts[12]) {
                                          a(QuestText.lC[10], -1, lw[var6], lx[var6] - 40);
                                       } else {
                                          V(1);
                                          a(QuestText.lB[10], 29, lw[var6], lx[var6] - 40);
                                       }
                                    } else if (activeQuestId == -1) {
                                       a(QuestText.lA[18], 30, lw[var6], lx[var6] - 40);
                                    } else {
                                       a(QuestText.lE, 1, lw[var6], lx[var6] - 40);
                                    }
                                    break;
                                 }

                                 a(NPCDialogue.lD[2], -1, lw[var6], lx[var6] - 40);
                              }
                              break;
                           case 5:
                              if (mapId == 0) {
                                 if (var6 == 5) {
                                    a(NPCDialogue.lz[0], -1, lw[var6], lx[var6] - 40);
                                 }

                                 if (var6 == 6) {
                                    aA();
                                    d = 9;
                                    kt = 0;
                                 }
                              }

                              if (mapId == 2 && var6 == 0) {
                                 aA();
                                 d = 9;
                                 kt = 1;
                              }

                              if (mapId == 1 && var6 == 0) {
                                 a(NPCDialogue.lz[1], -1, lw[var6], lx[var6] - 40);
                              }

                              if (mapId == 5 && var6 == 0) {
                                 a(NPCDialogue.lz[2], -1, lw[var6], lx[var6] - 40);
                              }

                              if (mapId == 6 && var6 == 0) {
                                 a(NPCDialogue.lz[3], -1, lw[var6], lx[var6] - 40);
                              }
                        }

                        if (mapId == scriptMapId && var6 == scriptExtraK) {
                           scriptMapId = -1;
                        }
                     } else if (o.equals("Trò chuyện")) {
                        d();
                        dK[interactSubId] = -playerFacing;
                        a(dw[interactSubId], 0, dA[interactSubId], dB[interactSubId] - 44);
                     } else if (o.equals("Nói chuyện") && fC) {
                        if (escortActive) {
                           a(StoryDialogue.aG[0], 0, companionX, companionY - 44);
                        } else if (skillGateBeforeKC2) {
                           a(StoryDialogue.aG[2], 0, companionX, companionY - 44);
                           escortActive = true;
                        } else if (questMeetGirlUnlocked) {
                           a(StoryDialogue.aG[3], 26, companionX, companionY - 44);
                           questMeetGirlUnlocked = false;
                        } else {
                           a(StoryDialogue.aG[1], 0, companionX, companionY - 44);
                        }
                     }
                  } else {
                     label1097: {
                        if (aS[2]) {
                           if (skillMotorcycleLearned) {
                              for(int var7 = 0; var7 < mapObjectBundleCount; ++var7) {
                                 if (playerY == mapObjTileY[var7] && a(playerX - mapObjTileX[var7]) < 20) {
                                    AmbushSkill.getInstance().clearAmbushPose();
                                    playerX = mapObjTileX[var7];
                                    playerState = 18;
                                    c();
                                    mapObjectMountIndex = var7;
                                    mapObjFacing[var7] = playerFacing;
                                    mapObjAnim[var7] = 0;
                                    break label1097;
                                 }
                              }
                           }

                           AmbushSkill.getInstance().clearAmbushPose();
                           z = skillBridgeZForInitialJump();
                           playerState = 3;
                           mapNpcFocusIndex = -1;
                           airComboTier = 0;
                           interactTargetId = -1;
                           interactSubId = -1;
                           o = " ";
                           c = true;
                        } else if (aS[4]) {
                           if (playerFacing == 1) {
                              playerFacing = -1;
                           } else {
                              AmbushSkill.getInstance().clearAmbushPose();
                              playerState = 2;
                              y = -P;
                           }

                           interactTargetId = -1;
                           interactSubId = -1;
                           o = " ";
                           c = true;
                        } else if (aS[6]) {
                           if (playerFacing == -1) {
                              playerFacing = 1;
                           } else {
                              AmbushSkill.getInstance().clearAmbushPose();
                              playerState = 2;
                              y = P;
                           }

                           interactSubId = -1;
                           interactTargetId = -1;
                           o = " ";
                           c = true;
                        } else if (aS[8]) {
                           AmbushSkill.getInstance().clearAmbushPose();
                           airComboTier = 0;
                           burrowSubstate = 0;
                           playerState = 8;
                        } else if (aS[1]) {
                           AmbushSkill.getInstance().clearAmbushPose();
                           z = skillBridgeZForInitialJump();
                           playerFacing = -1;
                           y = -4;
                           playerState = 3;
                           mapNpcFocusIndex = -1;
                           airComboTier = 0;
                           interactTargetId = -1;
                           interactSubId = -1;
                           o = " ";
                           c = true;
                        } else if (aS[3]) {
                           AmbushSkill.getInstance().clearAmbushPose();
                           z = skillBridgeZForInitialJump();

                           playerFacing = 1;
                           y = 4;
                           playerState = 3;
                           mapNpcFocusIndex = -1;
                           airComboTier = 0;
                           interactTargetId = -1;
                           interactSubId = -1;
                           o = " ";
                           c = true;
                        }

                        if (aT[5]) {
                           AmbushSkill.getInstance().clearAmbushPose();
                           playerState = 5;
                           timerFu = 0;
                           airComboTier = 0;
                           z = 0;
                           aT[5] = false;
                           interactTargetId = -1;
                           interactSubId = -1;
                           o = " ";
                           c = true;
                        }
                     }
                  }
               } else if (playerState == 2) {
                  if (aS[2]) {
                     mapNpcFocusIndex = -1;
                     AmbushSkill.getInstance().clearAmbushPose();
                     z = skillBridgeZForInitialJump();
                     playerState = 3;
                     airComboTier = 0;
                  } else if (aS[4]) {
                     if (playerFacing == 1) {
                        playerFacing = -1;
                     } else {
                        AmbushSkill.getInstance().clearAmbushPose();
                        y = -P + cameraScrollX;
                     }
                  } else if (aS[6]) {
                     if (playerFacing == -1) {
                        playerFacing = 1;
                     } else {
                        AmbushSkill.getInstance().clearAmbushPose();
                        y = P + cameraScrollX;
                     }
                  }

                  if (aT[5]) {
                     AmbushSkill.getInstance().clearAmbushPose();
                     playerState = 5;
                     timerFu = 0;
                     airComboTier = 0;
                     z = 0;
                     aT[5] = false;
                  }
               } else if (playerState == 11) {
                  if (aS[2]) {
                     AmbushSkill.getInstance().clearAmbushPose();
                     z = skillBridgeZForInitialJump();
                     playerState = 3;
                     airComboTier = 0;
                  } else if (aS[4]) {
                     if (playerFacing == 1) {
                        playerFacing = -1;
                     } else {
                        AmbushSkill.getInstance().clearAmbushPose();
                        y = -K + cameraScrollX;
                     }
                  } else if (aS[6]) {
                     if (playerFacing == -1) {
                        playerFacing = 1;
                     } else {
                        AmbushSkill.getInstance().clearAmbushPose();
                        y = K + cameraScrollX;
                     }
                  }
               } else if (playerState == 3) {
                  if (aS[4]) {
                     if (playerFacing == 1) {
                        playerFacing = -1;
                     } else {
                        y = -P;
                     }
                  } else if (aS[6]) {
                     if (playerFacing == -1) {
                        playerFacing = 1;
                     } else {
                        y = P;
                     }
                  }

                  if (aT[5]) {
                     AmbushSkill.getInstance().clearAmbushPose();
                     playerState = 5;
                     timerFu = 0;
                     airComboTier = 0;
                     aT[5] = false;
                  }

                  if (aS[2] && mp > 0 && z > -4) {
                     skillBridgeTryAirKhinhCongBoost();
                  }
               } else if (playerState == 4) {
                  if (aS[4]) {
                     if (playerFacing == 1) {
                        playerFacing = -1;
                     } else {
                        AmbushSkill.getInstance().clearAmbushPose();
                        y = -P;
                     }
                  } else if (aS[6]) {
                     if (playerFacing == -1) {
                        playerFacing = 1;
                     } else {
                        AmbushSkill.getInstance().clearAmbushPose();
                        y = P;
                     }
                  }

                  if (aT[5] && z > 4) {
                     AmbushSkill.getInstance().clearAmbushPose();
                     playerState = 5;
                     airComboTier = 0;
                     timerFu = 0;
                     aT[5] = false;
                  }
               } else if (playerState == 5) {
                  if (aS[4]) {
                     if (playerFacing == 1) {
                        playerFacing = -1;
                     } else {
                        y = -P + 2;
                     }
                  } else if (aS[6]) {
                     if (playerFacing == -1) {
                        playerFacing = 1;
                     } else {
                        y = P - 2;
                     }
                  }

                  if (aT[5]) {
                     gameModeFw = true;
                     aT[5] = false;
                  }
               } else if (playerState == 18) {
                  if (aS[2]) {
                     z = -10;
                     playerState = 21;
                     airComboTier = 10;
                     mapNpcFocusIndex = -1;
                  } else if (aS[4]) {
                     if (playerFacing == 1) {
                        playerFacing = -1;
                        mapObjFacing[mapObjectMountIndex] = -1;
                     } else {
                        airComboTier = 1;
                        playerState = 19;
                        airComboTier = 10;
                        y = -Q;
                     }
                  } else if (aS[6]) {
                     if (playerFacing == -1) {
                        playerFacing = 1;
                        mapObjFacing[mapObjectMountIndex] = 1;
                     } else {
                        playerState = 19;
                        airComboTier = 10;
                        y = Q;
                     }
                  } else if (aS[8]) {
                     playerState = 1;
                     mapObjectMountIndex = -1;
                  }
               } else if (playerState == 19) {
                  if (aS[2]) {
                     z = -10;
                     playerState = 21;
                     mapNpcFocusIndex = -1;
                     airComboTier = 10;
                  } else if (aS[4]) {
                     if (playerFacing == 1) {
                        playerFacing = -1;
                        mapObjFacing[mapObjectMountIndex] = -1;
                     } else {
                        y = -Q;
                     }
                  } else if (aS[6]) {
                     if (playerFacing == -1) {
                        playerFacing = 1;
                        mapObjFacing[mapObjectMountIndex] = 1;
                     } else {
                        y = Q;
                     }
                  }
               } else if (playerState == 21) {
                  if (aS[4]) {
                     if (playerFacing == 1) {
                        playerFacing = -1;
                        mapObjFacing[mapObjectMountIndex] = -1;
                     } else {
                        y = -Q;
                     }
                  } else if (aS[6]) {
                     if (playerFacing == -1) {
                        playerFacing = 1;
                        mapObjFacing[mapObjectMountIndex] = 1;
                     } else {
                        y = Q;
                     }
                  }
               } else if (playerState == 20) {
                  if (aS[4]) {
                     if (playerFacing == 1) {
                        playerFacing = -1;
                        mapObjFacing[mapObjectMountIndex] = -1;
                     } else {
                        y = -Q;
                     }
                  } else if (aS[6]) {
                     if (playerFacing == -1) {
                        playerFacing = 1;
                        mapObjFacing[mapObjectMountIndex] = 1;
                     } else {
                        y = Q;
                     }
                  }
               } else if (playerState == 17) {
                  if (aS[2]) {
                     z = skillBridgeZForInitialJump();
                     playerState = 3;
                     mountFacing = -1;
                     airComboTier = 0;
                  } else if (aS[4]) {
                     if (playerFacing == 1) {
                        playerFacing = -1;
                     } else {
                        playerState = 16;
                        y = -L;
                     }
                  } else if (aS[6]) {
                     if (playerFacing == -1) {
                        playerFacing = 1;
                     } else {
                        playerState = 16;
                        y = L;
                     }
                  }
               } else if (playerState == 16) {
                  if (aS[2]) {
                     z = skillBridgeZForInitialJump();
                     playerState = 3;
                     mountFacing = -1;
                     airComboTier = 0;
                  } else if (aS[4]) {
                     if (playerFacing == 1) {
                        playerFacing = -1;
                     } else {
                        y = -L;
                     }
                  } else if (aS[6]) {
                     if (playerFacing == -1) {
                        playerFacing = 1;
                     } else {
                        y = L;
                     }
                  }
               } else if (playerState == 12) {
                  if (aS[2] && skillWaterRunLearned) {
                     z = -10;
                     playerState = 3;
                     mountFacing = -1;
                     airComboTier = 0;
                  }
               } else if (playerState == 14) {
                  if (aS[4]) {
                     playerFacing = -1;
                  } else if (aS[6]) {
                     playerFacing = 1;
                  } else if (aS[2]) {
                     playerState = 15;
                  }
               }
            }
         }

         if (cutsceneP != cutsceneJ || cutsceneQ != cutsceneK) {
            cutsceneL = cutsceneJ - cutsceneP << 2;
            cutsceneM = cutsceneK - cutsceneQ << 2;
            cutsceneN += cutsceneL;
            cutsceneP += cutsceneN >> 4;
            cutsceneN &= 15;
            cutsceneO += cutsceneM;
            cutsceneQ += cutsceneO >> 4;
            cutsceneO &= 15;
            if (cutsceneP < 0) {
               cutsceneP = 0;
            }

            if (cutsceneP > cutsceneR) {
               cutsceneP = cutsceneR;
            }

            if (cutsceneQ < 0) {
               cutsceneQ = 0;
            }

            if (cutsceneQ > cutsceneS) {
               cutsceneQ = cutsceneS;
            }
         }

         if (aK >= 0) {
            cutsceneP += aI[aK];
            cutsceneQ += aJ[aK];
            if (++aK == 4) {
               aK = -1;
            }

            if (cutsceneP < 0) {
               cutsceneP = 0;
            }

            if (cutsceneP > cutsceneR) {
               cutsceneP = cutsceneR;
            }

            if (cutsceneQ < 0) {
               cutsceneQ = 0;
            }

            if (cutsceneQ > cutsceneS) {
               cutsceneQ = cutsceneS;
            }
         }

         if ((bx = cutsceneP / jf - 1) < 0) {
            bx = 0;
         }

         by = cutsceneQ / jf;
         bB = bx + bz;
         bC = by + bA;
         if (by < 0) {
            by = 0;
         }

         if (bC > iO - 1) {
            bC = iO - 1;
         }

         if (mapNpcDir == null && mapNpcBundleCount > 0) { ensureIrNpcArraysSized(); }
         for(int var8 = 0; mapNpcDir != null && var8 < mapNpcBundleCount; ++var8) {
            switch (mapNpcDir[var8]) {
               case 2:
                  int[] var20 = mapNpcTileX;
                  var20[var8] += mapNpcIw[var8];
                  if (mapNpcIw[var8] > 0) {
                     int var29 = mapNpcIw[var8]--;
                  } else if (mapNpcIw[var8] < 0) {
                     int var30 = mapNpcIw[var8]++;
                  } else {
                     mapNpcDir[var8] = 1;
                  }

                  if (!g(mapNpcTileX[var8] - 12, mapNpcTileY[var8] + 1, 2) && !g(mapNpcTileX[var8] + 12, mapNpcTileY[var8] + 1, 2)) {
                     mapNpcDir[var8] = 4;
                     mapNpcIx[var8] = 2;
                  }

                  if (g(mapNpcTileX[var8] + 12, mapNpcTileY[var8] - 2, 4) || g(mapNpcTileX[var8] - 12, mapNpcTileY[var8] - 2, 8)) {
                     mapNpcTileX[var8] = I(mapNpcTileX[var8]) + 12;
                  }
                  break;
               case 4:
                  int[] var19 = mapNpcTileY;
                  var19[var8] += mapNpcIx[var8];
                  if (mapNpcIx[var8] < 20) {
                     int var28 = mapNpcIx[var8]++;
                  }

                  if (!g(mapNpcTileX[var8] + 12, mapNpcTileY[var8], 2) && !g(mapNpcTileX[var8] - 12, mapNpcTileY[var8], 2)) {
                     if (g(mapNpcTileX[var8], mapNpcTileY[var8] - jf, 64)) {
                        mapNpcTileY[var8] = H(mapNpcTileY[var8]) + 1;
                        g(mapNpcTileX[var8], mapNpcTileY[var8] - 13);
                        g(mapNpcTileX[var8] + 1, mapNpcTileY[var8] - 10);
                        mapNpcIx[var8] = 1;
                        mapNpcIy[var8] = -1;
                        mapNpcIz[var8] = 1;
                        mapNpcDir[var8] = 11;
                     }
                  } else {
                     mapNpcTileY[var8] = H(mapNpcTileY[var8]);
                     mapNpcIx[var8] = 0;
                     mapNpcDir[var8] = 1;
                  }
                  break;
               case 11:
                  if (mapSubIdLegacy % 2 == 0) {
                     int[] var10000 = mapNpcTileY;
                     var10000[var8] += mapNpcIy[var8];
                     var10000 = mapNpcIx;
                     var10000[var8] += mapNpcIy[var8];
                     if (mapNpcIx[var8] >= 1) {
                        mapNpcIy[var8] = -1;
                     }

                     if (mapNpcIx[var8] <= -1) {
                        mapNpcIy[var8] = 1;
                     }

                     var10000 = mapNpcTileX;
                     var10000[var8] += mapNpcIz[var8];
                     if (var8 == mapNpcFocusIndex) {
                        playerY = mapNpcTileY[mapNpcFocusIndex] - 24;
                        playerX += mapNpcIz[var8];
                     }

                     if (g(mapNpcTileX[var8] + 12, mapNpcTileY[var8], 4) || g(mapNpcTileX[var8] - 12, mapNpcTileY[var8], 8)) {
                        mapNpcIz[var8] = -mapNpcIz[var8];
                     }
                  }
            }
         }

         for(int var9 = 0; var9 < mapObjectBundleCount; ++var9) {
            if (var9 == mapObjectMountIndex) {
               if (airComboTier > 1) {
                  mapObjAnim[var9] = 2;
               } else if (mapSubIdLegacy % 8 > 3) {
                  mapObjAnim[var9] = 1;
               } else {
                  mapObjAnim[var9] = 0;
               }
            }

            if (mapObjType[var9] == 1) {
               int[] var21 = mapObjTileY;
               var21[var9] += mapObjExtra[var9];
               if (mapObjExtra[var9] < 20) {
                  int var31 = mapObjExtra[var9]++;
               }

               if (mapObjTileY[var9] >= iQ || g(mapObjTileX[var9], mapObjTileY[var9], 2)) {
                  mapObjExtra[var9] = 0;
                  mapObjType[var9] = 0;
                  mapObjTileY[var9] = H(mapObjTileY[var9]);
               }
            }
         }

         for(int var10 = 0; var10 < 5; ++var10) {
            if (dU[var10] != -1) {
               int[] var22 = dU;
               var22[var10] += a(dT[var10]);
               if (dU[var10] > 30) {
                  dU[var10] = -1;
               }

               var22 = dQ;
               var22[var10] += dS[var10];
               var22 = dR;
               var22[var10] += dT[var10];
            }
         }

         if (!a) {
            for(int var11 = 0; var11 < 2; ++var11) {
               if (ci[var11] != -1) {
                  int var32 = ch[var11]--;
                  if (mapSubIdLegacy % 2 == 0) {
                     var32 = ci[var11]++;
                     if (ci[var11] > 2) {
                        ci[var11] = -1;
                     } else {
                        cj[var11] = ci[var11];
                     }
                  }
               }
            }
         }

         if (!a) {
            for(int var12 = 0; var12 < 2; ++var12) {
               if (cm[var12] != -1) {
                  int var34 = cm[var12]++;
                  if (cm[var12] >= 5) {
                     cm[var12] = -1;
                  }

                  if (var12 == 0) {
                     var34 = ck[var12]--;
                  } else {
                     var34 = ck[var12]++;
                  }

                  var34 = cl[var12]--;
               }
            }
         }

         for(int var13 = 0; var13 < 2; ++var13) {
            if (cd[var13] != -1) {
               int var38 = cd[var13]++;
               int[] var25 = cb;
               var25[var13] += cf[var13] << 2;
               var38 = cc[var13]--;
               if (cd[var13] >= 6) {
                  cd[var13] = -1;
               } else {
                  ce[var13] = (cd[var13] >> 1) % 3;
               }
            }
         }

         Z();
         M();
         if (dY > 0 && ++dY > 30) {
            dY = 0;
         }

         O();
         N();
         R();
         if (escortMapId == mapId) {
            try {
               switch (companionMode) {
                  case 1:
                     ag();
                     break;
                  case 2:
                     af();
                     break;
                  case 3:
                     ae();
                     break;
                  case 4:
                     ac();
                     break;
                  case 5:
                     ab();
                  case 6:
                  default:
                     break;
                  case 7:
                     ad();
               }
            } catch (Exception var3) {
               companionX = playerX;
               companionY = playerY;
               companionVel = 0;
               companionAccel = 0;
               companionMode = 4;
            }
         }

         ah();
         Y();
         ax();
         aj();
         al();
         an();
         ao();
         ap();
         W();
         am();
         P();
         if (cn) {
            ak();
         }

      }
   }

   private static void ab() {
      label79:
      switch (++companionB) {
         case 1:
         case 2:
         case 3:
            npcInteractIndex = -1;
            companionT0 = 9;
            break;
         case 4:
         case 5:
            npcInteractIndex = 0;
            companionT0 = 10;
            break;
         case 6:
            npcInteractIndex = 1;
            companionT0 = 11;
            if (npcInteractSub == 1) {
               int var0 = companionFaceDir << 3;
               int var1 = playerY - companionY >> 3;
               a(companionX + (companionFaceDir << 3), companionY - 12, var0, var1 + (var0 - 8), true);
            } else {
               int var6 = atk << 1;
               int var7 = companionFaceDir > 0 ? companionX - 20 : companionX - 40;
               int var2 = companionFaceDir > 0 ? companionX + 40 : companionX + 20;
               int var3 = companionY - companionT2 - 15;
               int var4 = companionY + 5;
               int var5 = 0;

               int var10000;
               while(true) {
                  if (var5 >= jI) {
                     var10000 = -1;
                     break;
                  }

                  if (jQ[var5] != 5 && jL[var5] >= var7 && jL[var5] <= var2 && jM[var5] >= var3 && jM[var5] <= var4) {
                     var10000 = var5;
                     break;
                  }

                  ++var5;
               }

               var7 = var10000;
               if (var10000 != -1) {
                  k(var7, var6, -companionFaceDir);
                  f(jL[var7], jM[var7] - (jN[var7] >> 1), companionFaceDir);
                  a("-" + var6, 0, jL[var7], jM[var7] - jN[var7], 0, -2);
               }

               if (gO && a(companionY - gR) < 30 && a(companionX + (companionFaceDir << 4) - gQ) < 40 && !c(var6, -companionFaceDir)) {
                  f(companionX + (gQ - companionX >> 1), companionY - 12, companionFaceDir);
                  a("-" + var6, 0, gQ, gR - gX, 0, -2);
               }

               for(int var9 = 0; var9 < cq; ++var9) {
                  if (companionY == cw[var9] && a(companionX + (companionFaceDir << 4) - cv[var9]) < 24) {
                     a(var9, var6, -companionFaceDir);
                     f(cv[var9], cw[var9] - 15, companionFaceDir);
                     a("-" + var6, 0, cv[var9], cw[var9] - 28, 0, -2);
                     break label79;
                  }
               }
            }
            break;
         case 7:
            npcInteractIndex = 2;
            companionT0 = 11;
            break;
         case 8:
            npcInteractIndex = -1;
            companionT0 = 12;
            break;
         case 9:
            npcInteractIndex = -1;
            companionT0 = 9;
            companionMode = 1;
            companionB = 0;
            companionC = 0;
      }

      if (npcInteractSub == 1) {
         npcInteractIndex = -1;
      }

   }

   private static void ac() {
      if (companionFaceDir == 1) {
         if ((i(companionX + companionT1, companionY) & 4) == 4) {
            companionVel = 0;
         }
      } else if ((i(companionX - companionT1, companionY) & 8) == 8) {
         companionVel = 0;
      }

      npcInteractIndex = -1;
      if ((companionX += companionVel) < 0) {
         companionX = 0;
      }

      if (companionX >= iP) {
         companionX = iP - 1;
      }

      companionY += companionAccel;
      if (companionAccel < 18) {
         ++companionAccel;
      }

      if (companionAccel > 5) {
         companionVel = 0;
      }

      if (companionVel > 1) {
         --companionVel;
      }

      companionT0 = 8;
      if (companionY >= iQ) {
         companionY = iQ - 1;
         companionMode = 3;
         companionAccel = -20;
      }

      if (companionAccel > 4 && (i(companionX, companionY) & 2) == 2) {
         companionMode = 1;
         companionAccel = 0;
         companionVel = 0;
         companionC = 0;
         companionB = 0;
         companionY = I(companionY);
         e(-1, companionX - -8, companionY);
         e(1, companionX - 8, companionY);
      }

      if (g(companionX, companionY, 64) && g(companionX, companionY + 24, 4096) && companionY % jf > 8) {
         g(companionX, H(companionY) + 8);
         companionMode = 3;
         companionVel = (companionFaceDir = playerX > companionX ? 1 : -1) << 2;
         companionAccel = -11;
      }

      if (companionAccel > 6) {
         companionT0 = 6;
      }

      if (companionD < 0) {
         ++companionD;
      }

   }

   private static void ad() {
      if ((i(companionX + companionT3, companionY - companionT4) & 4) == 4) {
         companionVel = -companionVel;
      }

      if ((i(companionX - companionT3, companionY - companionT4) & 8) == 8) {
         companionVel = -companionVel;
      }

      companionX += companionVel;
      companionY += companionAccel;
      companionT0 = 7;
      if (companionVel > 1) {
         --companionVel;
      }

      if (companionVel < -1) {
         ++companionVel;
      }

      if (++companionAccel > 0) {
         companionAccel = 0;
      }

      if (++companionB >= 7) {
         companionMode = 4;
         companionD = -20;
         companionC = 0;
         companionB = 0;
         companionAccel = 1;
      }

   }

   private static void ae() {
      if (companionVel == 0) {
         companionVel = companionFaceDir << 2;
      }

      if (companionFaceDir == 1) {
         if ((i(companionX + companionT3, companionY - companionT4) & 4) == 4) {
            companionVel = 0;
         }
      } else if ((i(companionX - companionT3, companionY - companionT4) & 8) == 8) {
         companionVel = 0;
      }

      if (playerY < 0) {
         playerY = 0;
         z = -1;
      }

      if ((companionX += companionVel) < 0) {
         companionX = 0;
      }

      if (companionX >= iP) {
         companionX = iP - 1;
      }

      companionY += companionAccel;
      if (companionB == 0) {
         companionT0 = 7;
      } else {
         companionT0 = 8;
      }

      if (companionVel > 1) {
         --companionVel;
      }

      if (++companionAccel == 0) {
         companionMode = 4;
         companionB = 0;
         companionC = 0;
         companionAccel = 1;
      }

      if (companionD < 0) {
         ++companionD;
      }

   }

   private static void af() {
      if (++companionB >= 10) {
         companionB = 0;
      }

      companionT0 = (companionB >> 1) + 2;
      if (companionFaceDir == 1) {
         if (g(companionX + companionT3, companionY - companionT4, 4)) {
            companionVel = 0;
            companionX = I(companionX + companionT3) - companionT3;
         }
      } else if (g(companionX - companionT3 - 1, companionY - companionT4, 8)) {
         companionVel = 0;
         companionX = I(companionX - companionT3 - 1) + jf + companionT3;
      }

      if ((companionX += companionVel) < 0) {
         companionX = 0;
      }

      if (companionX >= iP) {
         companionX = iP - 1;
      }

      if (mapNpcFocusIndex != -1) {
         if (a(companionX - mapNpcTileX[mapNpcFocusIndex]) >= 20) {
            mapNpcFocusIndex = -1;
            if (g(companionX, companionY, 2)) {
               companionMode = 1;
            } else {
               companionMode = 4;
               companionAccel = 2;
               companionVel = 3 * companionFaceDir;
               companionC = 0;
            }
         }
      } else if ((i(companionX + companionFaceDir * companionT1, companionY) & 2) != 2) {
         companionMode = 1;
         companionT0 = 0;
         companionVel = 0;
         companionB = 0;
         companionC = 0;
      }

      e(companionFaceDir, companionX - (companionFaceDir << 3), companionY);
      if (gL > 0) {
         --gL;
      } else {
         C();
      }
   }

   private static void ag() {
      if (++companionB > 30) {
         companionB = 0;
      }

      if (companionB % 15 < 5) {
         companionT0 = 0;
      } else {
         companionT0 = 1;
      }

      if (escortActive && mapSubIdLegacy % 6 == 0) {
         int var0 = 0;

         label69:
         while(true) {
            if (var0 >= jI) {
               for(int var1 = 0; var1 < cq; ++var1) {
                  if (cF[var1] != 5 && cw[var1] == companionY && a(cv[var1] - companionX) < 40) {
                     companionFaceDir = cv[var1] > companionX ? 1 : -1;
                     companionMode = 5;
                     npcInteractSub = 0;
                     companionB = 0;
                     companionC = 0;
                     break label69;
                  }
               }

               if (a(playerX - companionX) > 25 && playerY != companionY && playerState == 5) {
                  companionFaceDir = playerX > companionX ? 1 : -1;
                  companionMode = 5;
                  npcInteractSub = 1;
                  companionB = 0;
                  companionC = 0;
               }
               break;
            }

            if (jQ[var0] != 5 && a(jM[var0] - companionY) < 20 && a(jL[var0] - companionX) < 40) {
               companionFaceDir = jL[var0] > companionX ? 1 : -1;
               companionMode = 5;
               npcInteractSub = 0;
               companionB = 0;
               companionC = 0;
               break;
            }

            ++var0;
         }
      }

      if (mapSubIdLegacy % 15 == 0) {
         C();
      }

   }

   private static void ah() {
      for(int var0 = 0; var0 < dv; ++var0) {
         switch (dE[var0]) {
            case 1:
               int var6 = dF[var0]++;
               if (dF[var0] > 30) {
                  dF[var0] = 0;
               }

               if (dF[var0] % (var0 + 18) < var0 + 6) {
                  dH[var0] = 0;
               } else {
                  dH[var0] = 1;
               }

               if (dy) {
                  dG[var0] = dz;
                  dK[var0] = dz > dA[var0] ? 1 : -1;
                  dC[var0] = dK[var0] << 2;
                  dC[var0] = dK[var0] > 0 ? dC[var0] + var0 % 2 : dC[var0] - var0 % 2;
                  dE[var0] = 2;
               } else if (!activationTrialFlag) {
                  var6 = dG[var0]++;
                  if (dG[var0] > (dL[var0] + dA[var0]) % 20 + (dL[var0] >> 1)) {
                     if (iA && interactSubId == var0) {
                        break;
                     }

                     dG[var0] = 0;
                     int var2;
                     if ((var2 = (mapSubIdLegacy + dL[var0]) % 120 - 60) > 0) {
                        var2 += dL[var0];
                     } else {
                        var2 -= dL[var0];
                     }

                     dG[var0] = dA[var0] + var2;
                     dK[var0] = var2 > 0 ? 1 : -1;
                     dC[var0] = dK[var0] << 2;
                     dE[var0] = 2;
                     if (interactSubId == var0) {
                        interactSubId = -1;
                        o = " ";
                        c = true;
                     }
                  }

                  if (mapSubIdLegacy % 10 == 1) {
                     B(var0);
                  }
               }
               break;
            case 2:
               int var5 = dF[var0]++;
               if (dF[var0] >= 10) {
                  dF[var0] = 0;
               }

               dH[var0] = (dF[var0] >> 1) + 2;
               int[] var10000 = dA;
               var10000[var0] += dC[var0];
               if (dA[var0] <= dO[var0] && dA[var0] >= dN[var0] && a(dA[var0] - dG[var0]) >= 8) {
                  if (mapSubIdLegacy % 10 == 0) {
                     B(var0);
                  }
               } else {
                  dF[var0] = dG[var0] = 0;
                  var10000 = dA;
                  var10000[var0] -= dC[var0];
                  dC[var0] = 0;
                  dE[var0] = 1;
               }
            case 3:
            case 4:
            default:
               break;
            case 5:
               int var10002 = dF[var0]++;
               switch (dG[var0]) {
                  case 0:
                     switch (dF[var0]) {
                        case 1:
                        case 2:
                        case 3:
                           dJ[var0] = -1;
                           dH[var0] = 13;
                           continue;
                        case 4:
                           dJ[var0] = 0;
                           dH[var0] = 14;
                           continue;
                        case 5:
                           dJ[var0] = 1;
                           dH[var0] = 15;
                           continue;
                        case 6:
                           dJ[var0] = 1;
                           dH[var0] = 15;
                           A(var0);
                           continue;
                        case 7:
                           dJ[var0] = 2;
                           dH[var0] = 16;
                           continue;
                        case 8:
                           dJ[var0] = 2;
                           dH[var0] = 16;
                           dG[var0] = 2;
                           dF[var0] = 1;
                        default:
                           continue;
                     }
                  case 1:
                     switch (dF[var0]) {
                        case 1:
                           dJ[var0] = 1;
                           dH[var0] = 15;
                           continue;
                        case 2:
                           dJ[var0] = 1;
                           dH[var0] = 15;
                           dG[var0] = 10;
                        default:
                           continue;
                     }
                  case 2:
                     switch (dF[var0]) {
                        case 1:
                        case 2:
                        case 3:
                           dJ[var0] = 3;
                           dH[var0] = 17;
                           continue;
                        case 4:
                           dJ[var0] = 4;
                           dH[var0] = 18;
                           continue;
                        case 5:
                           dJ[var0] = 5;
                           dH[var0] = 19;
                           continue;
                        case 6:
                           dJ[var0] = 6;
                           dH[var0] = 20;
                           A(var0);
                           continue;
                        case 7:
                           dJ[var0] = 6;
                           dH[var0] = 20;
                           dG[var0] = 3;
                           dF[var0] = 1;
                        default:
                           continue;
                     }
                  case 3:
                     switch (dF[var0]) {
                        case 1:
                           dJ[var0] = 1;
                           dH[var0] = 15;
                           break;
                        case 2:
                           dJ[var0] = 1;
                           dH[var0] = 15;
                           break;
                        case 3:
                           dJ[var0] = 2;
                           dH[var0] = 16;
                           break;
                        case 4:
                           dJ[var0] = 2;
                           dH[var0] = 16;
                           dG[var0] = 1;
                           dF[var0] = 1;
                     }
                  case 4:
                  case 5:
                  case 6:
                  case 7:
                  case 8:
                  case 9:
                  default:
                     break;
                  case 10:
                     switch (dF[var0]) {
                        case 1:
                           dJ[var0] = 2;
                           dH[var0] = 16;
                           break;
                        case 2:
                           dJ[var0] = 0;
                           dH[var0] = 14;
                           break;
                        case 3:
                        case 4:
                           dH[var0] = 13;
                           dJ[var0] = -1;
                           break;
                        case 5:
                           dH[var0] = 13;
                           dJ[var0] = -1;
                           dE[var0] = 1;
                           dG[var0] = 120;
                           dF[var0] = 0;
                     }
               }
         }
      }

   }

   private static void ai() {
      if (aN) {
         aN = false;
         aT[5] = true;
      }

      if (++mapSubIdLegacy == 10000) {
         mapSubIdLegacy = 0;
      }

      aq();
      if (!V()) {
         ah();
         R();
         X();
      }
   }

   private static void aj() {
      for(int var0 = 0; var0 < cq; ++var0) {
         if (cr[var0] > 0) {
            int var10002 = cr[var0]--;
         }

         label144:
         switch (cF[var0]) {
            case 1:
               cK[var0] = 1;
               int var14 = cG[var0]++;
               int[] var6 = cv;
               var6[var0] += cz[var0];
               var6 = cw;
               var6[var0] += cA[var0];
               var6 = cx;
               var6[var0] += cB[var0];
               var6 = cy;
               var6[var0] += cC[var0];
               if (cG[var0] > 14) {
                  if (cz[var0] > 1) {
                     var14 = cz[var0]--;
                  } else if (cz[var0] < -1) {
                     var14 = cz[var0]++;
                  }

                  var14 = cA[var0]++;
               }

               if (cB[var0] > 1) {
                  var14 = cB[var0]--;
               } else if (cB[var0] < -1) {
                  var14 = cB[var0]++;
               }

               var14 = cC[var0]++;
               if (cw[var0] <= cutsceneQ + r + 32 && cw[var0] < iQ) {
                  continue;
               }

               cG[var0] = 0;
               cH[var0] = 0;
               cF[var0] = 5;
               break;
            case 2:
               if (mapSubIdLegacy % 12 > 7) {
                  cD[var0] = 1;
                  cJ[var0] = 1;
                  if (mapSubIdLegacy % 12 < 10) {
                     if (a(cv[var0] - cH[var0]) < 4) {
                        cG[var0] = cH[var0] = 0;
                        cF[var0] = 3;
                        break;
                     }

                     int[] var5 = cv;
                     var5[var0] += cz[var0];
                  }

                  w(var0);
               } else {
                  cJ[var0] = 0;
                  cD[var0] = 0;
               }
               break;
            case 3:
               if ((mapSubIdLegacy + var0) % 10 > 5) {
                  cD[var0] = 1;
               } else {
                  cD[var0] = 0;
               }

               int var13 = cG[var0]++;
               cJ[var0] = 0;
               cK[var0] = 0;
               if (cG[var0] > 50) {
                  int var1;
                  if ((var1 = (mapSubIdLegacy - var0) % (var0 + 80) - 40) > 0) {
                     var1 += 20;
                  } else {
                     var1 -= 20;
                  }

                  cH[var0] = cv[var0] + var1;
                  cI[var0] = var1 > 0 ? 1 : -1;
                  if (mapSubIdLegacy % 4 > 1) {
                     cF[var0] = 2;
                     cz[var0] = cI[var0] << 1;
                  } else {
                     cF[var0] = 7;
                     cz[var0] = cI[var0] << 2;
                  }

                  if (cH[var0] < cL[var0]) {
                     cH[var0] = cL[var0];
                  }

                  if (cH[var0] > cM[var0]) {
                     cH[var0] = cM[var0];
                  }
               }

               if (mapSubIdLegacy % 30 == 28) {
                  w(var0);
                  v(var0);
               }
               break;
            case 4:
               int var12 = cG[var0]++;
               if (cG[var0] < 3) {
                  cD[var0] = 0;
                  cJ[var0] = 0;
                  cK[var0] = 0;
               } else if (cG[var0] < 14) {
                  cD[var0] = 1;
                  cJ[var0] = 1;
                  cK[var0] = 1;
               } else {
                  cF[var0] = 3;
                  cG[var0] = 1;
               }

               if (cG[var0] == 3) {
                  switch (cE[var0]) {
                     case 0:
                     case 4:
                        b(cv[var0] + (cI[var0] << 3), cw[var0] - 15, cI[var0] * 12, ab[cE[var0]], 0);
                        break label144;
                     case 1:
                     case 5:
                        b(cv[var0] + (cI[var0] << 3), cw[var0] - 15, cI[var0] << 3, ab[cE[var0]], 1);
                        break label144;
                     case 2:
                     case 3:
                     case 6:
                        if (a(playerY - cw[var0]) < 5 && a(playerX - cv[var0]) < 30) {
                           a(ab[cE[var0]], cI[var0]);
                        }
                  }
               }
               break;
            case 5:
               int var11 = cG[var0]++;
               if (cG[var0] > 550 + var0 * 5) {
                  cv[var0] = ct[var0];
                  cw[var0] = cu[var0];
                  cG[var0] = 0;
                  cF[var0] = 3;
                  cs[var0] = ad[cE[var0]];
               }
               break;
            case 6:
               if ((mapSubIdLegacy + var0) % 10 > 5) {
                  cD[var0] = 1;
               } else {
                  cD[var0] = 0;
               }

               cJ[var0] = 0;
               cK[var0] = 0;
               int var10 = cG[var0]++;
               if (cG[var0] >= 5) {
                  cH[var0] = playerX;
                  if (cv[var0] < playerX) {
                     int[] var3 = cH;
                     var3[var0] -= 80;
                  } else {
                     int[] var4 = cH;
                     var4[var0] += 80;
                  }

                  cG[var0] = 0;
                  cI[var0] = cH[var0] < playerX ? -1 : 1;
                  cF[var0] = 7;
                  cz[var0] = cI[var0] << 3;
                  if (cH[var0] < cL[var0]) {
                     cH[var0] = cL[var0];
                  }

                  if (cH[var0] > cM[var0]) {
                     cH[var0] = cM[var0];
                  }
               }
               break;
            case 7:
               if (a(cv[var0] - cH[var0]) < 12) {
                  cG[var0] = cH[var0] = 0;
                  cF[var0] = 3;
                  v(var0);
               } else {
                  int[] var10000 = cv;
                  var10000[var0] += cz[var0];
                  if (mapSubIdLegacy % 2 == 1) {
                     cD[var0] = 1;
                     cJ[var0] = 3;
                  } else {
                     cJ[var0] = 2;
                     cD[var0] = 0;
                  }
               }
         }

         cx[var0] = cv[var0];
         cy[var0] = cw[var0] - 9 + cD[var0] + af[cE[var0]][cK[var0]];
      }

   }

   private static void ak() {
      if (++co >= 150) {
         cn = false;
      }

   }

   private static void al() {
      if (gO) {
         if (hc > 0) {
            --hc;
         }

         switch (gT) {
            case 1:
               if (gY > 0) {
                  --gY;
               } else {
                  int var0;
                  if ((var0 = mapSubIdLegacy % 80 - 40) > 0) {
                     var0 += 20;
                  } else {
                     var0 -= 20;
                  }

                  gZ = gQ + var0;
                  gS = (gU = var0 > 0 ? 1 : -1) << 2;
                  if (hpCurrentAlt < hpMaxBaseline >> 1) {
                     gS = gU << 3;
                  }

                  gT = 2;
                  if (mapSubIdLegacy % 5 == 0) {
                     L();
                  }
               }

               gV = 0;
               if (mapSubIdLegacy % 10 == 6) {
                  e(-gU, gQ + gU * 28, gR - 5);
                  return;
               }
               break;
            case 2:
               if (mapSubIdLegacy % 8 == 0) {
                  L();
               }

               if (!g(gQ + (gU << 4), gR + 1, 2)) {
                  gT = 1;
                  gY = 0;
                  return;
               }

               if (a(gQ - gZ) < 8) {
                  gT = 1;
                  gY = 20;
               }

               if (mapSubIdLegacy % 2 == 0) {
                  gQ += gS;
                  gV = 0;
                  return;
               }

               gV = 1;
               return;
            case 3:
            case 4:
            default:
               break;
            case 5:
               if (!g(gQ + (gU << 4), gR + 1, 2)) {
                  gT = 1;
                  gY = 0;
                  return;
               }

               if (a(gQ - gZ) < 4) {
                  gT = 1;
                  gY = 35;
               }

               if (a(playerY - gR) < 18 && a(gQ + (gU << 4) - playerX) < 10) {
                  a(gP, gU);
                  gT = 1;
                  gY = 45;
                  if (hpCurrentAlt < hpMaxBaseline >> 1) {
                     gY = 18;
                  }
               }

               gQ += gS;
               gV = mapSubIdLegacy % 3;
               return;
            case 6:
               gR += gY;
               ++gY;
               gQ += gS;
               if (gS > 1) {
                  --gS;
               }

               if (gS < -1) {
                  ++gS;
               }

               if (gR > cutsceneQ + r + gX || gR >= iQ + gX) {
                  gY = 0;
                  gT = 22;
                  return;
               }
               break;
            case 7:
               gQ -= gU;
               gV = 2;
               if (++gY == 4) {
                  gT = 1;
                  if ((gY = gZ) > 0 && hpCurrentAlt < hpMaxBaseline >> 1) {
                     gY = 5;
                     return;
                  }
               }
         }

      }
   }

   private static void am() {
      for(int var0 = 0; var0 < cN; ++var0) {
         if (cR[var0] != 0) {
            if (a(playerY - (spriteHeight >> 1) - (cQ[var0] - 7)) < 10 && a(playerX - cP[var0]) < 10) {
               if (cO[var0] == 0) {
                  if ((hp += cV[var0]) > hpMax) {
                     hp = hpMax;
                  }

                  a("+" + cV[var0], 0, cP[var0], cQ[var0] - 15, 0, -1);
               } else {
                  if ((mp += cV[var0]) > mpMax) {
                     mp = mpMax;
                  }

                  a("+" + cV[var0], 2, cP[var0], cQ[var0] - 15, 0, -1);
               }

               c = true;
               cR[var0] = 301;
            }

            int[] var10000 = cP;
            var10000[var0] += cS[var0];
            var10000 = cQ;
            var10000[var0] += cT[var0];
            if (cS[var0] > 1) {
               int var10002 = cS[var0]--;
            }

            if (cS[var0] < -1) {
               int var2 = cS[var0]++;
            }

            if (cT[var0] < 20) {
               int var3 = cT[var0]++;
            }

            int var4 = cR[var0]++;
            if (cR[var0] > 200) {
               cR[var0] = 0;
            }

            if (cQ[var0] < iQ && cQ[var0] >= 0 && cP[var0] < iP && cP[var0] >= 0) {
               if (cT[var0] > 2 && (i(cP[var0], cQ[var0]) & 2) == 2) {
                  cQ[var0] = H(cQ[var0]);
                  if (cT[var0] > 2) {
                     cT[var0] = -(cT[var0] >> 1);
                  } else {
                     cS[var0] = 0;
                     cT[var0] = 0;
                  }
               }
            } else {
               cR[var0] = 0;
            }
         }
      }

   }

   private static void an() {
      if (hK) {
         int var0 = mapSubIdLegacy % 10;
         if (id > 0) {
            --id;
         }

         switch (hY) {
            case 1:
               ++ic;
               hR += 2;
               ++bK;
               ++bL;
               ++bM;
               if (ic > 50) {
                  hY = 5;
               }
               break;
            case 2:
               if (bossThreshold < hO >> 1) {
                  hQ += hZ << 2;
               } else {
                  hQ += hZ << 1;
               }

               if (hQ < ia) {
                  hZ = 1;
               }

               if (hQ > ib) {
                  hZ = -1;
               }

               if (ic > 0) {
                  --ic;
               }

               if (ic == 0 && a(playerX - (hQ - 40)) < 30) {
                  ic = 0;
                  hY = 4;
                  hZ = hQ < playerX ? 1 : -1;
               }

               if (mapSubIdLegacy % 122 == 0) {
                  c(hQ, hR - 45, -1, -12, hL);
                  c(hQ, hR - 50, 0, -15, hL);
                  c(hQ, hR - 45, 1, -12, hL);
               } else if (mapSubIdLegacy % 200 == 0) {
                  hY = 7;
                  ic = 0;
               }
            case 3:
            case 5:
            case 6:
            default:
               break;
            case 4:
               if (ic == 110) {
                  hY = 2;
                  ic = 30;
               } else if (ic < 35) {
                  --hR;
               } else if (ic >= 75) {
                  ++hR;
                  if (var0 == 5) {
                     c(hQ, hR - 45, -2, -10, hL);
                  } else if (var0 == 7 && bossThreshold < hO >> 1) {
                     c(hQ, hR - 50, 0, -11, hL);
                  } else if (var0 == 9) {
                     c(hQ, hR - 45, 2, -10, hL);
                  }
               }

               if (ic > 20 && ic < 50 && var0 == 0) {
                  b(hQ + hZ * 20, hR - 29, hZ << 3, hL, 2);
               }

               if (ic > 45 && ic < 50) {
                  bJ += hZ;
               } else if (ic > 50 && ic < 55) {
                  bJ -= hZ;
               }

               ++ic;
               break;
            case 7:
               if (++ic == 50) {
                  hY = 2;
                  ic = 1;
               } else if (ic == 30) {
                  if ((hQ = playerX + (playerFacing << 6)) > ib) {
                     hQ = ib - 30;
                  }

                  if (hQ < ia) {
                     hQ = ia + 30;
                  }

                  hZ = hQ < playerX ? 1 : -1;
               } else if (ic < 10) {
                  hR += 10;
               } else if (ic > 40) {
                  hR -= 10;
               }
         }

         if (var0 < 4) {
            --hR;
         } else if (var0 < 8) {
            ++hR;
         }

         if (var0 > 4) {
            --bK;
            ++bL;
         } else {
            ++bK;
            --bL;
         }

         if (hZ == -1) {
            hS = hQ + bH;
            hW = hR + bK;
            hV = hQ + bI;
            hX = hR + bL;
            hT = hQ + bJ;
            hU = hR + bM;
         } else {
            hS = hQ - bH;
            hW = hR + bK;
            hV = hQ - bI;
            hX = hR + bL;
            hT = hQ - bJ;
            hU = hR + bM;
         }
      }
   }

   private static void ao() {
      if (hj) {
         int var0 = mapSubIdLegacy % 10;
         int var1 = a(playerX - hq);
         int var2 = a(playerY - hr);
         switch (scriptHsStep) {
            case 0:
               if (var0 < 7) {
                  hI = hy[0];
                  hJ = hz[0];
               } else {
                  hI = hy[1];
                  hJ = hz[1];
               }
               break;
            case 1:
               if (var0 < 7) {
                  hI = hy[0];
                  hJ = hz[0];
               } else {
                  hI = hy[1];
                  hJ = hz[1];
               }

               if (var1 > 90 && var1 < 100 && var0 < 2) {
                  ht = hq < playerX ? 1 : -1;
                  scriptHsStep = 23;
                  hw = 0;
               } else if ((var1 > 120 && var1 < 150 || playerY < hr && var1 > 40) && var0 < 2) {
                  ht = hq < playerX ? 1 : -1;
                  hw = 0;
                  scriptHsStep = 8;
               } else if (var1 < 40 && var0 == 1) {
                  ht = hq < playerX ? 1 : -1;
                  hw = 0;
                  scriptHsStep = 5;
               } else if (var1 > 40 && var1 < 100 && var0 < 3) {
                  ht = hq < playerX ? 1 : -1;
                  hw = 0;
                  if ((hx = playerX) > hv) {
                     hx = hv;
                  } else if (hx < hu) {
                     hx = hu;
                  }

                  scriptHsStep = 24;
               } else if (var1 > 80 && var0 == 2) {
                  hw = 0;
                  scriptHsStep = 2;
                  if ((hx = playerX) > hv) {
                     hx = hv;
                  } else if (hx < hu) {
                     hx = hu;
                  }
               }
               break;
            case 2:
               if ((var2 = ++hw % 6 >> 1) == 3) {
                  aK = 0;
               }

               hI = hC[var2];
               hJ = hD[var2];
               if ((hq += ht << 2) > hx && ht > 0 || hq < hx && ht < 0 || hq > hv || hq < hu || hw > 100) {
                  hw = 0;
                  scriptHsStep = 1;
               }

               if (var1 > 50 && var1 < 100 && var0 == 1) {
                  ht = hq < playerX ? 1 : -1;
                  scriptHsStep = 23;
                  hw = 0;
               }
               break;
            case 5:
               if (++hw < 2) {
                  hI = hy[0];
                  hJ = hz[0];
               } else if (hw < 2) {
                  hI = hA[0];
                  hJ = hB[0];
               } else if (hw < 12) {
                  hI = hA[1];
                  hJ = hB[1];
               } else if (hw < 14) {
                  hI = hA[0];
                  hJ = hB[0];
               } else if (hw == 14) {
                  hw = 0;
                  scriptHsStep = 1;
               }

               if (hw == 3 && var1 < 40 && var2 < 10) {
                  a(hk, ht);
               }
               break;
            case 6:
               ++hw;

               for(int var5 = 0; var5 < hH.length; ++var5) {
                  int[] var10000 = hH;
                  var10000[var5] += a(var5 - 3) + 2;
                  var10000 = hG;
                  var10000[var5] += var5 - 3 << 1;
               }

               if (hw >= 50) {
                  scriptHsStep = 22;
               }
               break;
            case 8:
               if (++hw < 2) {
                  hI = hy[0];
                  hJ = hz[0];
               } else if (hw < 2) {
                  hI = hA[0];
                  hJ = hB[0];
               } else if (hw < 12) {
                  hI = hA[1];
                  hJ = hB[1];
               } else if (hw < 14) {
                  hI = hA[0];
                  hJ = hB[0];
               } else if (hw == 14) {
                  hw = 0;
                  scriptHsStep = 1;
               }

               if (hw % 5 == 0) {
                  a(hq + (ht << 3), hr - 20, ht << 3, -var0 + 2, false);
               }
               break;
            case 23:
               var0 = ++hw % 4 >> 1;
               hI = hA[var0];
               hJ = hB[var0];
               if (hw > 20 && hw % 10 == 0) {
                  b(hq + (ht << 3), hr - 24, ht << 3, hk, 3);
               }

               if (hw == 100) {
                  ht = hq < playerX ? 1 : -1;
                  hw = 0;
                  if ((hx = playerX) > hv) {
                     hx = hv;
                  } else if (hx < hu) {
                     hx = hu;
                  }

                  scriptHsStep = 24;
               }
               break;
            case 24:
               var0 = ++hw % 6 >> 1;
               hI = hC[var0];
               hJ = hD[var0];
               if ((hq += ht << 3) > hx && ht > 0 || hq < hx && ht < 0 || hq > hv || hq < hu || hw > 100) {
                  hw = 0;
                  scriptHsStep = 5;
               }
         }

         for(int var7 = 0; var7 < 6; ++var7) {
            if (ht == 1) {
               hE[var7] = hq + hG[var7] + hI[var7];
            } else {
               hE[var7] = hq - hG[var7] - hI[var7];
            }

            hF[var7] = hr + hH[var7] + hJ[var7];
         }

      }
   }

   private static void ap() {
      if (hd) {
         int var0 = mapSubIdLegacy % 50;
         int var1 = a(dA[0] - playerX);
         switch (dE[0]) {
            case 0:
               int var17 = dF[0]++;
               if (dF[0] > 30) {
                  dF[0] = 0;
               }

               if (dF[0] % 18 < 6) {
                  dH[0] = 0;
               } else {
                  dH[0] = 1;
               }

               if (dy) {
                  he = false;
                  dG[0] = dz;
                  dK[0] = dz > dA[0] ? 1 : -1;
                  dC[0] = dK[0] << 2;
                  dC[0] = dK[0] > 0 ? dC[0] : dC[0];
                  dE[0] = 2;
                  return;
               }

               if (var1 >= 40 || playerState != 5) {
                  return;
               }

               he = true;
               dE[0] = 3;
               dK[0] = -playerFacing;
               if (var0 > 35) {
                  dC[0] = playerFacing * 5;
                  dD[0] = -9;
               } else {
                  dC[0] = -playerFacing * 6;
                  dD[0] = -9;
               }

               if (dA[0] < dN[0] + 40) {
                  dC[0] = 10;
                  dK[0] = -1;
               } else if (dA[0] > dO[0] - 40) {
                  dC[0] = -10;
                  dK[0] = 1;
               }
               break;
            case 1:
               int var16 = dF[0]++;
               if (dF[0] > 30) {
                  dF[0] = 0;
               }

               if (dF[0] % 18 < 6) {
                  dH[0] = 0;
               } else {
                  dH[0] = 1;
               }

               if (hf) {
                  dE[0] = 0;
                  dF[0] = dG[0] = 0;
               }

               if (var1 < 40 && playerState == 5 && playerFacing != dK[0]) {
                  dE[0] = 3;
                  dK[0] = -playerFacing;
                  if (var0 > 35) {
                     dC[0] = playerFacing * 5;
                     dD[0] = -9;
                  } else {
                     dC[0] = -playerFacing * 6;
                     dD[0] = -9;
                  }

                  if (dA[0] < dN[0] + 40) {
                     dC[0] = 10;
                     dK[0] = -1;
                  } else if (dA[0] > dO[0] - 40) {
                     dC[0] = -10;
                     dK[0] = 1;
                  }

                  dF[0] = dG[0] = 0;
                  return;
               }

               if (var1 < 40 && var0 < 10) {
                  dK[0] = playerX > dA[0] ? 1 : -1;
                  dE[0] = 5;
                  dF[0] = dG[0] = dM[0] = 0;
                  return;
               }

               if (var1 < 100 && var1 > 40 && var0 < 1) {
                  dK[0] = playerX > dA[0] ? 1 : -1;
                  dE[0] = 24;
                  dF[0] = dG[0] = dM[0] = 0;
                  dC[0] = (a(dA[0] - playerX) >> 3) * dK[0];
                  return;
               }

               if (var1 > 100 && var1 < 160 && var0 < 30) {
                  dK[0] = playerX > dA[0] ? 1 : -1;
                  dE[0] = 8;
                  dF[0] = dG[0] = dM[0] = 0;
                  return;
               }

               if (var1 >= 20 && var0 != 42) {
                  if (var1 > 160) {
                     dK[0] = playerX > dA[0] ? 1 : -1;
                     dG[0] = dA[0] + (dK[0] << 7);
                     if (dG[0] < dN[0]) {
                        dG[0] = dN[0];
                     } else if (dG[0] > dO[0]) {
                        dG[0] = dO[0];
                     }

                     dF[0] = 0;
                     dE[0] = 2;
                     dC[0] = dK[0] << 2;
                     return;
                  }

                  return;
               }

               dK[0] = -playerFacing;
               dG[0] = dA[0] + (dK[0] << 6);
               if (dG[0] < dN[0] || dG[0] > dO[0]) {
                  dK[0] = -dK[0];
                  dG[0] = dA[0] + (dK[0] << 6);
               }

               dF[0] = 0;
               dE[0] = 2;
               dC[0] = dK[0] << 3;
               return;
            case 2:
               int var15 = dF[0]++;
               if (dF[0] >= 10) {
                  dF[0] = 0;
               }

               dH[0] = (dF[0] >> 1) + 2;
               int[] var6 = dA;
               var6[0] += dC[0];
               if (dy || (dK[0] <= 0 || dA[0] <= dG[0]) && (dK[0] >= 0 || dA[0] >= dG[0])) {
                  return;
               }

               dK[0] = playerX > dA[0] ? 1 : -1;
               dG[0] = dF[0] = 0;
               dE[0] = 1;
               return;
            case 3:
            case 7:
               int[] var4 = dA;
               var4[0] += dC[0];
               if (dA[0] < dN[0]) {
                  dA[0] = dN[0];
               }

               if (dA[0] > dO[0]) {
                  dA[0] = dO[0];
               }

               var4 = dB;
               var4[0] += dD[0];
               dH[0] = 23;
               if (dC[0] > 0) {
                  int var13 = dC[0]--;
               }

               int var14 = dD[0]++;
               if (dD[0] == 0) {
                  dE[0] = 4;
                  dF[0] = 0;
                  dD[0] = 1;
                  return;
               }

               return;
            case 4:
               int[] var2 = dA;
               var2[0] += dC[0];
               if (dA[0] < dN[0]) {
                  dA[0] = dN[0];
               }

               if (dA[0] > dO[0]) {
                  dA[0] = dO[0];
               }

               var2 = dB;
               var2[0] += dD[0];
               dH[0] = 7;
               if (dD[0] < 18) {
                  int var11 = dD[0]++;
               }

               if (dC[0] > 0) {
                  int var12 = dC[0]--;
               }

               dH[0] = 7;
               if (dB[0] >= iQ) {
                  dE[0] = 6;
                  return;
               }

               if ((i(dA[0], dB[0]) & 2) == 2) {
                  dE[0] = 1;
                  dF[0] = dG[0] = 0;
                  dC[0] = dD[0] = 0;
                  dB[0] = I(dB[0]);
                  e(-1, dA[0] - -8, dB[0]);
                  e(1, dA[0] - 8, dB[0]);
                  if (a(dA[0] - playerX) < 40 && var0 < 25) {
                     dK[0] = playerX > dA[0] ? 1 : -1;
                     dE[0] = 5;
                     dF[0] = dG[0] = dM[0] = 0;
                  }

                  if (var1 < 40) {
                     dK[0] = playerFacing;
                     dG[0] = dA[0] + dK[0] * 110;
                     if (dG[0] < dN[0] || dG[0] > dO[0]) {
                        dK[0] = -dK[0];
                        dG[0] = dA[0] + (dK[0] << 6);
                     }

                     dF[0] = 0;
                     dE[0] = 2;
                     dC[0] = dK[0] * 10;
                     return;
                  }
               }

               return;
            case 5:
               int var10 = dF[0]++;
               switch (dG[0]) {
                  case 0:
                     switch (dF[0]) {
                        case 1:
                        case 2:
                        case 3:
                           dJ[0] = -1;
                           dH[0] = 13;
                           return;
                        case 4:
                           dJ[0] = 0;
                           dH[0] = 14;
                           return;
                        case 5:
                           dJ[0] = 1;
                           dH[0] = 15;
                           return;
                        case 6:
                           dJ[0] = 1;
                           dH[0] = 15;
                           z(0);
                           return;
                        case 7:
                           dJ[0] = 2;
                           dH[0] = 16;
                           return;
                        case 8:
                           dJ[0] = 2;
                           dH[0] = 16;
                           dG[0] = 2;
                           dF[0] = 1;
                        default:
                           return;
                     }
                  case 1:
                     switch (dF[0]) {
                        case 1:
                           dJ[0] = 1;
                           dH[0] = 15;
                           return;
                        case 2:
                           dJ[0] = 1;
                           dH[0] = 15;
                           dG[0] = 10;
                        default:
                           return;
                     }
                  case 2:
                     switch (dF[0]) {
                        case 1:
                        case 2:
                        case 3:
                           dJ[0] = 3;
                           dH[0] = 17;
                           return;
                        case 4:
                           dJ[0] = 4;
                           dH[0] = 18;
                           return;
                        case 5:
                           dJ[0] = 5;
                           dH[0] = 19;
                           return;
                        case 6:
                           dJ[0] = 6;
                           dH[0] = 20;
                           z(0);
                           return;
                        case 7:
                           dJ[0] = 6;
                           dH[0] = 20;
                           dG[0] = 3;
                           dF[0] = 1;
                        default:
                           return;
                     }
                  case 3:
                     switch (dF[0]) {
                        case 1:
                           dJ[0] = 1;
                           dH[0] = 15;
                           return;
                        case 2:
                           dJ[0] = 1;
                           dH[0] = 15;
                           return;
                        case 3:
                           dJ[0] = 2;
                           dH[0] = 16;
                           return;
                        case 4:
                           dJ[0] = 2;
                           dH[0] = 16;
                           dG[0] = 1;
                           dF[0] = 1;
                        default:
                           return;
                     }
                  case 10:
                     switch (dF[0]) {
                        case 1:
                           dJ[0] = 2;
                           dH[0] = 16;
                           return;
                        case 2:
                           dJ[0] = 0;
                           dH[0] = 14;
                           return;
                        case 3:
                        case 4:
                           dH[0] = 13;
                           dJ[0] = -1;
                           return;
                        case 5:
                           dH[0] = 13;
                           dJ[0] = -1;
                           dE[0] = 1;
                           dG[0] = 120;
                           dF[0] = 0;
                     }
                  case 4:
                  case 5:
                  case 6:
                  case 7:
                  case 8:
                  case 9:
                  default:
                     return;
               }
            case 8:
               int var9 = dF[0]++;
               switch (dF[0]) {
                  case 1:
                  case 2:
                  case 3:
                     dH[0] = 13;
                     return;
                  case 4:
                     dH[0] = 14;
                     return;
                  case 5:
                     dH[0] = 15;
                     return;
                  case 6:
                     dH[0] = 15;
                     a(dA[0] + (dK[0] << 3), dB[0] - 12, dK[0] << 3, 0, false);
                     return;
                  case 7:
                     dH[0] = 16;
                     return;
                  case 8:
                     dH[0] = 16;
                     dG[0] = 2;
                     return;
                  case 9:
                     dF[0] = 0;
                     dE[0] = 1;
                  default:
                     return;
               }
            case 24:
               int var10002 = dG[0]++;
               if (dG[0] < 7) {
                  var10002 = dF[0]++;
                  if (dF[0] >= 10) {
                     dF[0] = 0;
                  }

                  dH[0] = (dF[0] >> 1) + 2;
                  int[] var10000 = dA;
                  var10000[0] += dC[0];
                  if (a(dA[0] - playerX) < 30) {
                     if (playerState != 5 || playerFacing == dK[0]) {
                        dG[0] = 6;
                        return;
                     }

                     dE[0] = 3;
                     dK[0] = -playerFacing;
                     dC[0] = playerFacing << 1;
                     if (dA[0] < dN[0] + 30) {
                        dC[0] = 6;
                        dK[0] = -1;
                     } else if (dA[0] > dO[0] - 30) {
                        dC[0] = -6;
                        dK[0] = 1;
                     }

                     dD[0] = -9;
                     break;
                  }

                  return;
               } else {
                  if (dG[0] == 7) {
                     dF[0] = 0;
                     return;
                  }

                  if (dG[0] < 15) {
                     var10002 = dF[0]++;
                     switch (dF[0]) {
                        case 1:
                        case 2:
                        case 3:
                           dJ[0] = -1;
                           dH[0] = 13;
                           return;
                        case 4:
                           dJ[0] = 0;
                           dH[0] = 14;
                           return;
                        case 5:
                           dJ[0] = 1;
                           dH[0] = 15;
                           return;
                        case 6:
                           dJ[0] = 1;
                           dH[0] = 15;
                           z(0);
                           return;
                        case 7:
                           dJ[0] = 2;
                           dH[0] = 16;
                           return;
                        case 8:
                           dJ[0] = 2;
                           dH[0] = 16;
                           dG[0] = 2;
                           dF[0] = 1;
                        default:
                           return;
                     }
                  }

                  dJ[0] = -1;
                  dE[0] = 1;
                  break;
               }
            default:
               return;
         }

         dF[0] = dG[0] = 0;
      }
   }

   private static void aq() {
      if (scriptRunnerActive) {
         switch (at[scriptTableId][scriptStep]) {
            case 1:
               if (playerX > av[scriptTableId][scriptStep]) {
                  C(au[scriptTableId][scriptStep]);
                  ++scriptStep;
                  return;
               }
               break;
            case 2:
               C(au[scriptTableId][scriptStep]);
               ++scriptStep;
               return;
            case 3:
            default:
               return;
            case 4:
               if (playerX > cutsceneP + q) {
                  C(au[scriptTableId][scriptStep]);
                  ++scriptStep;
                  return;
               }
               break;
            case 6:
               if (playerX < av[scriptTableId][scriptStep] && playerX > av[scriptTableId][scriptStep] - 96 && playerY == aw[scriptTableId][scriptStep]) {
                  C(au[scriptTableId][scriptStep]);
                  ++scriptStep;
               }
            case 5:
               if (gT == 22) {
                  C(au[scriptTableId][scriptStep]);
                  ++scriptStep;
                  return;
               }
               break;
            case 7:
               if (hY == 5) {
                  C(au[scriptTableId][scriptStep]);
                  ++scriptStep;
                  return;
               }
               break;
            case 8:
               if (regenTimer < 10) {
                  C(au[scriptTableId][scriptStep]);
                  ++scriptStep;
                  return;
               }
               break;
            case 9:
               if (scriptHsStep == 22) {
                  C(au[scriptTableId][scriptStep]);
                  unlockedMap95 = true;
                  ++scriptStep;
                  return;
               }
         }
      } else if (scriptTableId == 10) {
         Display.getDisplay(Midlet.c).setCurrent(Midlet.b);
         scriptTableId = 0;
      }

   }

   public static void s() {
      Midlet.b = new a();
      aq();
      a var0 = Midlet.b;
      Midlet.a((Midlet.g = Midlet.a()) == 0 ? 1 : 0);
      lM = false;
      d = 13;
      (new Thread(var0)).start();
   }

   public a() {
      ((Canvas)this).setFullScreenMode(true);
      this.ma = false;
      boolean var2 = false;
      // Calendar.getInstance().getTime();
      // int var3 = Calendar.getInstance().get(2);
      // int var4;
      // if ((var4 = Calendar.getInstance().get(1)) >= 2012 && var4 <= 2013) {
      //    if (var4 == 2012 && var3 < 0) {
      //       var2 = true;
      //    }

      //    if (var4 == 2013 && var3 > 0) {
      //       var2 = true;
      //    }
      // } else {
      //    var2 = true;
      // }

      // if (var2) {
      //    this.ma = true;
      //    Y = 14;
      // }

      System.out.println("vaoo");
      System.gc();
      aL = this;
      aR = ((Canvas)this).getKeyCode(8) == -20;
      aU = ((Displayable)this).getWidth();
      aV = ((Displayable)this).getHeight();
      aW = aU / 2;
      aX = aV / 2;
      lM = aV() == 1;
      this.ar();
      a var1 = this;
      this.lV = 100;
      this.aM();
      byte[] var8;
      byte var10000 = (var8 = f("np")) == null ? -1 : var8[0];
      lY = var10000;
      if (var10000 == -1) {
         W(lY = this.lV / 10);
      }

      if (lY <= 0) {
         W(lY = this.lV / 10);
      }

      c();
      a var7 = this;
      String var9;
      if ((var9 = System.getProperty("phone.imei")) == null || var9.equals("")) {
         var9 = System.getProperty("com.nokia.IMEI");
      }

      if (var9 != null && !var9.equals("")) {
         this.lU = var9;
      }

      byte[] var5;
      String var12 = (var5 = f("mapObjTileY")) == null ? null : new String(var5);
      String var11 = var12;
      if (var12 == null) {
         String var6 = var7.lU;
         a("mapObjTileY", var6.getBytes());
      } else if (!var11.equals(var7.lU)) {
         lY = 2;
         W(2);
         g("TEAM PAY " + (int)(System.currentTimeMillis() % 8599L + 1000L) + "009" + "007");
         X(0);
      }

      byte[] var10;
      Y = (var10 = f("r")) == null ? 0 : var10[0];
      if (var1.ma) {
         Y = 14;
      }

      if (aV() == 1) {
         d = 4;
         av();
      } else {
         d = 13;
      }

      lQ = aW - (lR.stringWidth(lO[1]) >> 1);
      System.out.println(d + ">>>" + Y);
   }

   private void ar() {
      String var4 = System.getProperty("microedition.platform");
      String var1 = "";
      if (var4 == null) {
         var4 = "TeaMobile";
      }

      if (lM) {
         byte[] var2;
         String var10000 = (var2 = f("lv")) == null ? null : new String(var2);
         String var10 = var10000;
         if (var10000 == null) {
            X(0);
            Y(0);
            e(var4);
            return;
         }

         if (!var10.equals(var4)) {
            X(0);
            Y(0);
            e(var4);
            return;
         }

         for(int var11 = 0; var11 < 4; ++var11) {
            var1 = var1 + (char)(iM.charAt(var11) - 1);
         }

         var1 = var1 + 'a';
         if (var4.toLowerCase().indexOf(var1) != -1) {
            d = 13;
            byte[] var5;
            byte var13 = (var5 = f("bc")) == null ? 0 : var5[0];
            byte var12 = var13;
            if (var13 < iM.length() - 1) {
               E(var12 + 1);
               return;
            }

            String var7 = (var5 = f("girl")) == null ? null : new String(var5);
            var1 = null;

            try {
               var1 = LocalDevice.getLocalDevice().getBluetoothAddress();
            } catch (Exception var3) {
            }

            if (var1 == null) {
               aM = !aM;
            } else if (var7 == null) {
               d(var1);
            } else if (!var1.equals(var7)) {
               X(0);
               Y(0);
               d(var1);
               g("TEAM PAY " + (int)(System.currentTimeMillis() % 8599L + 1000L) + "009" + "007");
            } else {
               E(0);
            }
         }
      } else {
         e(var4);
      }

   }

   private static void E(int var0) {
      byte[] var1;
      (var1 = new byte[1])[0] = (byte)var0;
      a("bc", var1);
   }

   private static void d(String var0) {
      a("girl", var0.getBytes());
   }

   private static void e(String var0) {
      a("lv", var0.getBytes());
   }

   protected final void keyPressed(int var1) {
      if (var1 == 35) {
         if (bw.equals("1984")) {
            skillBridgeSetWallJumpLearned(true);
            skillLegacyFlagEK = true;
            skillStealthLegacyFlag = true;
            skillBurrowLearned = true;
            skillSwimLearned = true;
            skillMotorcycleLearned = true;
            skillShurikenLearned = true;
            skillWaterRunLearned = true;
            skillTransformLearned = true;
            skillBridgeSetWallJumpL2Learned(true);
            skillBridgeSetWallJumpL3Learned(true);
            skillSetAmSatLearned(true);
            skillSetDashLearned(true);
            syncDashDurationToLevel();
            c("Learned All Skill");
         } else if (bw.equals("30538")) {
            mpMax = 500000;
            mp = 500000;
            hpMax = 500000;
            hp = 500000;
            c("Unlimit HP MP");
         } else if (bw.equals("38305")) {
            atk = 10000;
            c("Unlimit Damage");
         } else if (bw.equals("1982")) {
            u(100000);
         } else if (bw.equals("1983")) {
            gold += 50000;
            c("Money+=50000");
         } else if (bw.equals("12456")) {
            TextBox var4;
            (var4 = new TextBox("Type anything:", "", 50, 0)).addCommand(new Command("OK", 4, 0));
            ((Displayable)var4).addCommand(new Command("Back", 2, 0));
            ((Displayable)var4).setCommandListener(this);
            Display.getDisplay(Midlet.c).setCurrent(var4);
         } else if (bw.equals("99999")) {
            a(aU(), "sms://8101", 0);
            d = 13;
         } else if (!bw.equals("1981")) {
            if (bw.equals("8463")) {
               int var3 = playTimeSeconds + (int)((System.currentTimeMillis() - playTimeSessionStartMs) / 1000L);
               c(var3 / 3600 + ":" + var3 % 3600 / 60 + ":" + var3 % 60);
            }
         } else {
            for(int var2 = 0; var2 < 19; ++var2) {
               mapUnlockFlags[var2] = true;
            }

            c("Unlock all map!");
         }

         c = true;
         bw = "";
      }

      if (var1 >= 48 && var1 <= 57 && (bw = bw + (char)var1).length() > 10) {
         bw = "";
      }

      DebugRefactor.onKeyPressed(var1);

      if (aR) {
         switch (var1) {
            case -23:
               var1 = -8;
               break;
            case -22:
            case 22:
               var1 = -7;
               break;
            case -21:
            case 21:
               var1 = -6;
               break;
            case -20:
               var1 = -5;
               break;
            case -6:
               var1 = -2;
               break;
            case -5:
               var1 = -4;
               break;
            case -2:
               var1 = -3;
         }
      }

      if (!fT || var1 == -5) {
         F(var1);
      }
   }

   protected final void keyReleased(int var1) {
      if (aR) {
         switch (var1) {
            case -23:
               var1 = -8;
               break;
            case -22:
            case 22:
               var1 = -7;
               break;
            case -21:
            case 21:
               var1 = -6;
               break;
            case -20:
               var1 = -5;
               break;
            case -6:
               var1 = -2;
               break;
            case -5:
               var1 = -4;
               break;
            case -2:
               var1 = -3;
         }
      }

      if (!fT || var1 == -5) {
         G(var1);
      }
   }

   private static void F(int var0) {
      switch (var0) {
         case -22:
         case -7:
            aS[13] = true;
            aT[13] = true;
            return;
         case -21:
         case -6:
            aS[12] = true;
            aT[12] = true;
            return;
         case -5:
         case 10:
            aS[5] = true;
            aT[5] = true;
            return;
         case -4:
         case 54:
            if (!DashSkill.getInstance().onDirectionKey(6)) {
               aS[6] = true;
               aT[6] = true;
            }
            return;
         case -3:
         case 52:
            if (!DashSkill.getInstance().onDirectionKey(4)) {
               aS[4] = true;
               aT[4] = true;
            }
            return;
         case -2:
            aS[8] = true;
            aT[8] = true;
            return;
         case -1:
            aS[2] = true;
            aT[2] = true;
            return;
         case 35:
            aS[11] = true;
            aT[11] = true;
            return;
         case 42:
            aS[10] = true;
            aT[10] = true;
            return;
         case 48:
         case 49:
         case 50:
         case 51: 
         case 53: 
         case 55:
         case 56:
         case 57:
            aS[var0 - 48] = true;
            aT[var0 - 48] = true;
            return;
         default:
      }
   }

   private static void G(int var0) {
      switch (var0) {
         case -22:
         case -7:
            aS[13] = false;
            return;
         case -21:
         case -6:
            aS[12] = false;
            return;
         case -5:
         case 10:
            aS[5] = false;
            return;
         case -4:
            aS[6] = false;
            aT[6] = false;
            return;
         case -3:
            aS[4] = false;
            aT[4] = false;
            return;
         case -2:
            aS[8] = false;
            aT[8] = false;
            return;
         case -1:
            aS[2] = false;
            aT[2] = false;
            return;
         case 35:
            aS[11] = false;
            return;
         case 42:
            aS[10] = false;
            return;
         case 48:
         case 49:
         case 50:
         case 51:
         case 52:
         case 53:
         case 54:
         case 55:
         case 56:
         case 57:
            aS[var0 - 48] = false;
            return;
         default:
      }
   }

   protected final void paint(Graphics var1) {
      try {
         switch (d) {
            case 1:
               var1.setClip(-1, -1, q + 2, r + 2);
               a(var1);
               var1.translate(-cutsceneP, -cutsceneQ);
               var1 = var1;

               for(int var2 = 0; var2 < iY; ++var2) {
                  if (ja[var2] + jc[var2] >= cutsceneP && ja[var2] - jc[var2] <= cutsceneP + q && jb[var2] >= cutsceneQ && jb[var2] - jd[var2] <= cutsceneQ + r) {
                     jh = (jg = ja[var2] - cutsceneP) - bD;
                     ji = (jj = (jf - 2) * jh / jf) + bD;
                     var1.drawImage(iX[iZ[var2]], cutsceneP + ji, jb[var2], 33);
                  }
               }

               if (a) {
                  j(var1);
               } else {
                  k(var1);
               }

               i(var1);
               r(var1);
               if (hK) {
                  if (hZ < 0) {
                     var1.drawImage(ey[0], hQ, hR, 33);
                     var1.drawImage(ey[2], hS, hW, 33);
                     var1.drawImage(ey[3], hV, hX, 33);
                     var1.drawImage(ey[1], hT, hU, 33);
                  } else {
                     var1.drawRegion(ey[0], 0, 0, ey[0].getWidth(), ey[0].getHeight(), 2, hQ, hR, 33);
                     var1.drawRegion(ey[2], 0, 0, ey[2].getWidth(), ey[2].getHeight(), 2, hS, hW, 33);
                     var1.drawRegion(ey[3], 0, 0, ey[3].getWidth(), ey[3].getHeight(), 2, hV, hX, 33);
                     var1.drawRegion(ey[1], 0, 0, ey[1].getWidth(), ey[1].getHeight(), 2, hT, hU, 33);
                  }

                  if (id != 0) {
                     var1.setColor(3342353);
                     var1.drawRect(hQ - (hP >> 1) - 1, hR - hM - 7, hP + 2, 4);
                     int var22 = bossThreshold * hP / hO;
                     var1.setColor(15597568);
                     var1.fillRect(hQ - (hP >> 1), hR - hM - 6, var22, 3);
                     var1.setColor(4456482);
                     var1.fillRect(hQ - (hP >> 1) + var22, hR - hM - 6, hP - var22 + 1, 3);
                  }
               }

               var1 = var1;

               if (mapNpcBundleCount > 0 && mapNpcTileX != null && mapNpcTileY != null) {
                  for(int var23 = 0; var23 < mapNpcBundleCount; ++var23) {
                     if (cutsceneP <= mapNpcTileX[var23] + 12 && cutsceneP + q >= mapNpcTileX[var23] - 12 && cutsceneQ <= mapNpcTileY[var23] && cutsceneQ + r >= mapNpcTileY[var23] - 24) {
                        var1.drawImage(ef, mapNpcTileX[var23], mapNpcTileY[var23], 33);
                     }
                  }
               }

               var1 = var1;

               for(int var24 = 0; var24 < mapObjectBundleCount; ++var24) {
                  if (cutsceneP <= mapObjTileX[var24] + 12 && cutsceneP + q >= mapObjTileX[var24] - 12 && cutsceneQ <= mapObjTileY[var24] && cutsceneQ + r >= mapObjTileY[var24] - 24) {
                     if (mapObjFacing[var24] == 1) {
                        var1.drawImage(ec[mapObjAnim[var24]], mapObjTileX[var24], mapObjTileY[var24], 33);
                     } else {
                        var1.drawRegion(ec[mapObjAnim[var24]], 0, 0, ec[mapObjAnim[var24]].getWidth(), ec[mapObjAnim[var24]].getHeight(), 2, mapObjTileX[var24], mapObjTileY[var24], 33);
                     }
                  }
               }

               var1 = var1;

               for(int var25 = 0; var25 < df; ++var25) {
                  if (di[var25] != 0 && dg[var25] >= cutsceneP - 10 && dg[var25] <= cutsceneP + q + 10 && dh[var25] >= cutsceneQ && dh[var25] <= cutsceneQ + r + 20) {
                     var1.drawRegion(eh[dn[var25]], 0, dl[var25] * 15, 8, 15, 0, dg[var25], dh[var25], 33);
                  }
               }

               var1 = var1;

               for(int var26 = 0; var26 < cN; ++var26) {
                  if (cR[var26] != 0 && cP[var26] >= cutsceneP - 10 && cP[var26] <= cutsceneP + q + 10 && cQ[var26] >= cutsceneQ && cQ[var26] <= cutsceneQ + r + 20) {
                     var1.drawRegion(ex[cO[var26]], 0, cU[var26] * 15, 13, 15, 0, cP[var26], cQ[var26], 33);
                  }
               }

               if (gO && gT != 22 && cutsceneP + q >= gQ - (gW >> 1) && cutsceneP <= gQ + (gW >> 1) && cutsceneQ <= gR && cutsceneQ + r >= gR - gX) {
                  byte var27 = 0;
                  if (gV == 0) {
                     var27 = -2;
                     if (gT == 1 && mapSubIdLegacy % 10 > 5) {
                        var27 = -1;
                     }

                     if (gU == 1) {
                        var1.drawImage(ew[4], gQ, gR + 1, 33);
                     } else {
                        var1.drawRegion(ew[4], 0, 0, ew[4].getWidth(), ew[4].getHeight(), 2, gQ, gR + 1, 33);
                     }
                  }

                  if (gU == 1) {
                     var1.drawImage(ew[gV], gQ, gR + var27 + 1, 33);
                  } else {
                     var1.drawRegion(ew[gV], 0, 0, ew[gV].getWidth(), ew[gV].getHeight(), 2, gQ, gR + var27 + 1, 33);
                  }

                  if (gT == 7) {
                     if (gU == 1) {
                        var1.drawImage(ew[3], gQ + 10, gR - 25 + 1, 0);
                     } else {
                        var1.drawRegion(ew[3], 0, 0, ew[3].getWidth(), ew[3].getHeight(), 2, gQ - 10, gR - 25 + 1, 24);
                     }
                  }

                  if (hc != 0) {
                     var1.setColor(3342353);
                     var1.drawRect(gQ - (gW >> 1) - 1, gR - gX - 7, gW + 2, 4);
                     int var3 = hpCurrentAlt * gW / hpMaxBaseline;
                     var1.setColor(15597568);
                     var1.fillRect(gQ - (gW >> 1), gR - gX - 6, var3, 3);
                     var1.setColor(4456482);
                     var1.fillRect(gQ - (gW >> 1) + var3, gR - gX - 6, gW - var3 + 1, 3);
                  }
               }

               var1 = var1;
               if (hj) {
                  if (ht > 0) {
                     for(int var28 = 0; var28 < 6; ++var28) {
                        var1.drawImage(eA[var28], hE[var28], hF[var28], 33);
                     }
                  } else {
                     for(int var29 = 0; var29 < 6; ++var29) {
                        var1.drawRegion(eA[var29], 0, 0, eA[var29].getWidth(), eA[var29].getHeight(), 2, hE[var29], hF[var29], 33);
                     }
                  }

                  if (scriptHitGauge != 0) {
                     var1.setColor(3342353);
                     var1.drawRect(hq - (hl >> 1) - 1, hr - hm - 7, hl + 2, 4);
                     int var30 = idleTimerLong * hl / ho;
                     var1.setColor(15597568);
                     var1.fillRect(hq - (hl >> 1), hr - hm - 6, var30, 3);
                     var1.setColor(4456482);
                     var1.fillRect(hq - (hl >> 1) + var30, hr - hm - 6, hl - var30 + 1, 3);
                  }
               }

               var1 = var1;

               for(int var31 = 0; var31 < jI; ++var31) {
                  if (jQ[var31] != 5 && jQ[var31] != 8 && jL[var31] >= cutsceneP - 10 && jL[var31] <= cutsceneP + q + 10 && jM[var31] >= cutsceneQ && jM[var31] <= cutsceneQ + r + 20) {
                     var1.drawImage(jH[ki[var31]][jZ[var31] >= 0 ? 0 : 1][jY[var31]], jL[var31], jM[var31], 33);
                     if (jP[var31] != 0) {
                        var1.setColor(13073);
                        var1.drawRect(jL[var31] - (jO[var31] >> 1) - 1, jM[var31] - jN[var31] - 7, jO[var31] + 2, 4);
                        int var43 = ka[var31] * jO[var31] / kb[var31];
                        var1.setColor(60928);
                        var1.fillRect(jL[var31] - (jO[var31] >> 1), jM[var31] - jN[var31] - 6, var43, 3);
                        var1.setColor(17442);
                        var1.fillRect(jL[var31] - (jO[var31] >> 1) + var43, jM[var31] - jN[var31] - 6, jO[var31] - var43 + 1, 3);
                     }
                  }
               }

               var1 = var1;

               for(int var32 = 0; var32 < cq; ++var32) {
                  if (cF[var32] != 5 && cv[var32] + 15 >= cutsceneP && cv[var32] - 15 <= cutsceneP + q && cw[var32] >= cutsceneQ && cw[var32] - 30 <= cutsceneQ + r) {
                     if (cI[var32] == -1) {
                        var1.drawImage(ev[cJ[var32]], cv[var32] + ag[cE[var32]], cw[var32], 33);
                        var1.drawImage(eu[cE[var32]][cK[var32]], cx[var32] + ae[cE[var32]][cK[var32]], cy[var32], 33);
                     } else {
                        var1.drawRegion(ev[cJ[var32]], 0, 0, ev[cJ[var32]].getWidth(), ev[cJ[var32]].getHeight(), 2, cv[var32] - ag[cE[var32]], cw[var32], 33);
                        var1.drawRegion(eu[cE[var32]][cK[var32]], 0, 0, eu[cE[var32]][cK[var32]].getWidth(), eu[cE[var32]][cK[var32]].getHeight(), 2, cx[var32] - ae[cE[var32]][cK[var32]], cy[var32], 33);
                     }

                     if (cr[var32] != 0) {
                        var1.setColor(13073);
                        var1.drawRect(cv[var32] - 13, cw[var32] - 40, 26, 4);
                        int var44 = cs[var32] * 24 / ad[cE[var32]];
                        var1.setColor(15597568);
                        var1.fillRect(cv[var32] - 12, cw[var32] - 39, var44, 3);
                        var1.setColor(4456482);
                        var1.fillRect(cv[var32] - 12 + var44, cw[var32] - 39, 24 - var44 + 1, 3);
                     }
                  }
               }

               g(var1);
               if (doFlag && dp + 15 >= cutsceneP && dp - 15 <= cutsceneP + q && dq >= cutsceneQ && dq - 10 <= cutsceneQ + r) {
                  int var33 = mapSubIdLegacy % 8 > 3 ? 0 : 1;
                  if (dr > 0) {
                     var1.drawImage(ej[var33], dp, dq, 33);
                  } else {
                     var1.drawRegion(ej[var33], 0, 0, ej[var33].getWidth(), ej[var33].getHeight(), 2, dp, dq, 33);
                  }
               }

               if (hd) {
                  if (he) {
                     var1.setColor(16768477);
                     int var34 = cutsceneP + 50;
                     int var45 = cutsceneQ + 15;
                     if (!bf) {
                        var45 += 20;
                     }

                     var1.drawRect(var34 - 35 - 1, var45 - 7, 72, 4);
                     int var46 = regenTimer * 70 / hi;
                     var1.setColor(15597568);
                     var1.fillRect(var34 - 35, var45 - 6, var46, 3);
                     var1.setColor(4456482);
                     var1.fillRect(var34 - 35 + var46, var45 - 6, 70 - var46 + 1, 3);
                  }

                  if (dA[0] + halfWidth >= cutsceneP && dA[0] - halfWidth <= cutsceneP + q && dB[0] >= cutsceneQ && dB[0] - spriteHeight <= cutsceneQ + r) {
                     if (dK[0] == 1) {
                        var1.drawImage(et[dI[0]][aH[dH[0]][0][0]], dA[0] + aH[dH[0]][0][1], dB[0] - aH[dH[0]][0][2], 0);
                        var1.drawImage(er[aH[dH[0]][1][0]], dA[0] + aH[dH[0]][1][1], dB[0] - aH[dH[0]][1][2], 0);
                        var1.drawImage(ee[aH[dH[0]][2][0]], dA[0] + aH[dH[0]][2][1], dB[0] - aH[dH[0]][2][2], 0);
                        if (dJ[0] != -1) {
                           var1.drawImage(eC[dJ[0]], dA[0] - ar[dJ[0]], dB[0] - as[dJ[0]], 0);
                        }
                     } else {
                        var1.drawRegion(et[dI[0]][aH[dH[0]][0][0]], 0, 0, et[dI[0]][aH[dH[0]][0][0]].getWidth(), et[dI[0]][aH[dH[0]][0][0]].getHeight(), 2, dA[0] - aH[dH[0]][0][1], dB[0] - aH[dH[0]][0][2], 24);
                        var1.drawRegion(er[aH[dH[0]][1][0]], 0, 0, er[aH[dH[0]][1][0]].getWidth(), er[aH[dH[0]][1][0]].getHeight(), 2, dA[0] - aH[dH[0]][1][1], dB[0] - aH[dH[0]][1][2], 24);
                        var1.drawRegion(ee[aH[dH[0]][2][0]], 0, 0, ee[aH[dH[0]][2][0]].getWidth(), ee[aH[dH[0]][2][0]].getHeight(), 2, dA[0] - aH[dH[0]][2][1], dB[0] - aH[dH[0]][2][2], 24);
                        if (dJ[0] != -1) {
                           var1.drawRegion(eC[dJ[0]], 0, 0, eC[dJ[0]].getWidth(), eC[dJ[0]].getHeight(), 2, dA[0] + ar[dJ[0]], dB[0] - as[dJ[0]], 24);
                        }
                     }
                  }
               }

               if (dY != 0) {
                  SkillDashSprite.drawAmbushFx(var1, dW, dX, playerFacing);
               }

               if (escortMapId == mapId) {
                  if (companionFaceDir == 1) {
                     var1.drawImage(en[ap[companionT0][0][0]], companionX + ap[companionT0][0][1], companionY - ap[companionT0][0][2], 0);
                     var1.drawImage(eo[ap[companionT0][1][0]], companionX + ap[companionT0][1][1], companionY - ap[companionT0][1][2], 0);
                     var1.drawImage(em[ap[companionT0][2][0]], companionX + ap[companionT0][2][1], companionY - ap[companionT0][2][2], 0);
                     if (npcInteractIndex != -1) {
                        var1.drawImage(eC[npcInteractIndex], companionX - ar[npcInteractIndex], companionY - as[npcInteractIndex], 0);
                     }
                  } else {
                     var1.drawRegion(en[ap[companionT0][0][0]], 0, 0, en[ap[companionT0][0][0]].getWidth(), en[ap[companionT0][0][0]].getHeight(), 2, companionX - ap[companionT0][0][1], companionY - ap[companionT0][0][2], 24);
                     var1.drawRegion(eo[ap[companionT0][1][0]], 0, 0, eo[ap[companionT0][1][0]].getWidth(), eo[ap[companionT0][1][0]].getHeight(), 2, companionX - ap[companionT0][1][1], companionY - ap[companionT0][1][2], 24);
                     var1.drawRegion(em[ap[companionT0][2][0]], 0, 0, em[ap[companionT0][2][0]].getWidth(), em[ap[companionT0][2][0]].getHeight(), 2, companionX - ap[companionT0][2][1], companionY - ap[companionT0][2][2], 24);
                     if (npcInteractIndex != -1) {
                        var1.drawRegion(eC[npcInteractIndex], 0, 0, eC[npcInteractIndex].getWidth(), eC[npcInteractIndex].getHeight(), 2, companionX + ar[npcInteractIndex], companionY - as[npcInteractIndex], 24);
                     }
                  }
               }

               b(var1);
               if (cutsceneI != 0) {
                  var1.drawImage(ed, cutsceneG, cutsceneH, 33);
               }

               var1 = var1;

               for(int var36 = 0; var36 < 2; ++var36) {
                  if (cd[var36] != -1) {
                     if (cf[var36] == 1) {
                        var1.drawImage(ez[ce[var36]], cb[var36], cc[var36], 3);
                     } else {
                        var1.drawRegion(ez[ce[var36]], 0, 0, ez[ce[var36]].getWidth(), ez[ce[var36]].getHeight(), 2, cb[var36], cc[var36], 3);
                     }
                  }
               }

               var1 = var1;
               if (!a) {
                  for(int var37 = 0; var37 < 2; ++var37) {
                     if (cm[var37] != -1) {
                        var1.drawImage(ek[var37][cm[var37]], ck[var37], cl[var37], 3);
                     }
                  }
               }

               var1 = var1;

               for(int var38 = 0; var38 < bN; ++var38) {
                  if (bQ[var38] != -1) {
                     var1.drawImage(dZ[bT[var38]][bR[var38] > 0 ? 0 : 1], bO[var38], bP[var38], 3);
                  }
               }

               var1 = var1;

               for(int var39 = 0; var39 < cW; ++var39) {
                  if (cZ[var39] != -1) {
                     var1.drawImage(el[da[var39]], cX[var39], cY[var39], 3);
                  }
               }

               var1 = var1;

               for(int var40 = 0; var40 < bU; ++var40) {
                  if (bX[var40] != 0) {
                     var1.drawImage(eb, bV[var40], bW[var40], 3);
                  }
               }

               var1 = var1;
               if (!a) {
                  for(int var41 = 0; var41 < 2; ++var41) {
                     if (ci[var41] != -1) {
                        var1.drawImage(eE[cj[var41]], cg[var41], ch[var41], 3);
                     }
                  }
               }

               l(var1);
               var1 = var1;

               for(int var42 = 0; var42 < 5; ++var42) {
                  if (dU[var42] != -1) {
                     Midlet.a(var1, dP[var42], dV[var42], dQ[var42], dR[var42], 0);
                  }
               }

               if (scriptMapId == mapId) {
                  var1.drawImage(ea[scriptExtraF], scriptExtraG, scriptExtraH, 3);
               }

               c(var1);
               if (c) {
                  d(var1);
               }

               if (bv > 1) {
                  e(var1);
               }

               if (cn) {
                  var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
                  var1.setClip(-1, -1, aU + 2, aV + 2);
                  var1.setColor(0);
                  var1.fillRect(0, 0, aU, 21);
                  var1.setColor(10275899);
                  var1.fillRect(0, 19, aU, 1);
                  if (mapSubIdLegacy % 10 > 2) {
                     Midlet.a(var1, cp, bD, 4, 2);
                  }
               }

               if (iA) {
                  f(var1);
               }

               DebugRefactor.paintOverlay(var1);
               return;
            case 2:
               var1.setColor(0);
               var1.fillRect(0, 0, aU, 21);
               Midlet.a(var1, "www.giaitri321.pro " + S + "%", aU >> 1, 4, 2);
               return;
            case 3:
               var1.setClip(-1, -1, aU + 2, aV + 1);
               a(var1);
               var1.translate(-cutsceneP, -cutsceneQ);
               if (a) {
                  j(var1);
               } else {
                  k(var1);
               }

               i(var1);
               l(var1);
               var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
               var1.setColor(0);
               var1.fillRect(0, 0, q, bb);
               var1.fillRect(0, bc, q, aV - bc + 1);
               var1.setColor(10275899);
               var1.fillRect(0, bb - 1, aU, 1);
               var1.fillRect(0, bc + 1, aU, 1);
               var1.drawImage(eB, aW, aZ + bc >> 1, 3);
               Midlet.a(var1, "*", aW - 50 - mapSubIdLegacy % 3, be, 0);
               Midlet.a(var1, "/", aW + 50 + mapSubIdLegacy % 3, be, 1);
               Midlet.a(var1, StoryDialogue.aD[aY], aW, be, 3);
               return;
            case 4:
               var1.setColor(0);
               var1.fillRect(0, 0, aU, aV);
               if (jF >= 0) {
                  if (jD != null && jG >= 0) {
                     var1.drawRegion(jD, 0, jG * 51, 71, 51, 0, aU >> 1, aV >> 1, 3);
                  }

                  return;
               }

               var1.drawImage((Image)null, aW, aX, 3);
               break;
            case 5:
               o(var1);
               return;
            case 6:
               p(var1);
               return;
            case 7:
               q(var1);
               return;
            case 8:
               n(var1);
               return;
            case 9:
               m(var1);
               return;
            case 10:
               var1.setColor(0);
               var1.fillRect(0, 0, aU, aV);
               if (!lm) {
                  var1.drawImage(ll, aW, aX - 30, 3);
                  if (ln == 0) {
                     Midlet.a(var1, "www.giaitri321.pro", aW, aX + 15, 2);
                     Midlet.a(var1, "Bật", 4, aV - 14, 0);
                     Midlet.a(var1, "Tắt", aU - 4, aV - 14, 1);
                     break;
                  }

                  Midlet.a(var1, "Chất lượng hình ảnh?", aW, aX + 15, 2);
                  Midlet.a(var1, "Cao", 4, aV - 14, 0);
                  Midlet.a(var1, "Thấp", aU - 4, aV - 14, 1);
               }

               return;
            case 11:
               h(var1);
               return;
            case 12:
               h(var1);
               return;
            case 13:
               var1.setColor(15395562);
               var1.fillRect(0, 0, aU, aV);
               var1.setColor(11788624);
               var1.fillRect(0, 0, aU, lT);
               var1.fillRect(0, aV - lT, aU, lT);
               var1.setColor(16777215);
               var1.setFont(lS);
               var1.drawString("Ninja School", aW, 3, 17);
               var1.setFont(lR);
               if (!this.ma) {
                  switch (Y) {
                     case 0:
                        this.t(var1);
                        return;
                     case 1:
                        var1.setColor(lP % 10 > 5 ? 16777215 : 7171437);
                        var1.drawString("Dang gui tin", aW, aX - lT, 17);
                        var1.drawString("kich hoat...", aW, aX, 17);
                        return;
                     case 2:
                        var1.setColor(7171437);
                        var1.setFont(lR);
                        var1.drawString("Gui tin kich hoat ton phi", aW, aX - (lT << 1), 17);
                        var1.drawString("15.000đ. Ban se nhan", aW, aX - lT, 17);
                        var1.drawString("duoc ma kich hoat trong", aW, aX, 17);
                        var1.drawString("tin nhan tra loi.", aW, aX + lT, 17);
                        var1.setColor(16777215);
                        var1.setFont(lS);
                        var1.drawString("Dong y", 2, aV - lT + 3, 20);
                        var1.drawString("Khong", aU - 2, aV - lT + 3, 24);
                        return;
                     case 3:
                     default:
                        return;
                     case 4:
                        this.s(var1);
                        return;
                     case 5:
                        var1.setColor(7171437);
                        var1.drawString("Da gui tin kich hoat.", aW, aX - (lT << 1), 17);
                        var1.drawString("Xin thoat game va", aW, aX - lT, 17);
                        var1.drawString("cho giay lat. Ban se", aW, aX, 17);
                        var1.drawString("nhan duoc ma kich hoat.", aW, aX + lT, 17);
                        var1.setColor(16777215);
                        var1.setFont(lS);
                        var1.drawString("OK", 2, aV - lT + 3, 20);
                        return;
                     case 6:
                        var1.setColor(7171437);
                        var1.drawString("Khong the gui SMS", aW, aX - (lT << 1), 17);
                        var1.drawString("Xin hay thu lai. Vao", aW, aX - lT, 17);
                        var1.drawString("www.giaitri321.pro", aW, aX, 17);
                        var1.drawString("gold biet them thong tin.", aW, aX + lT, 17);
                        var1.setColor(16777215);
                        var1.setFont(lS);
                        var1.drawString("OK", 2, aV - lT + 3, 20);
                        return;
                     case 7:
                        var1.setColor(0);
                        var1.fillRect(0, 0, aU, aV);
                        String var4 = this.mb;
                        if (lP % 10 > 5) {
                           var4 = var4 + "|";
                        }

                        var1.drawString(var4, aW - 20, aX - 40, 20);
                        X(7);
                        av();
                        d = 4;
                        lM = aV() == 1;
                        return;
                     case 8:
                        var1.setColor(7171437);
                        var1.drawString("Xin vui long", aW, aX - (lT << 1), 17);
                        var1.drawString("Bat Bluetooth", aW, aX - lT, 17);
                        var1.setColor(16777215);
                        var1.setFont(lS);
                        var1.drawString("OK", 2, aV - lT + 3, 20);
                        return;
                  }
               } else {
                  var1.setColor(7171437);
                  var1.setFont(lS);
                  var1.drawString("Phien ban da het han", aW, aX - (lT << 1), 17);
                  var1.drawString("vao website http://wap.teamobi.com", aW, aX - (lT << 1) + 20, 17);
                  var1.drawString(" gold download mien phi tro choi", aW, aX - (lT << 1) + 40, 17);
                  var1.drawString("Thoát", aU - 2, aV - lT + 3, 24);
               }
            default:
               return;
         }
      } catch (Exception var5) {
         ((Throwable)var5).printStackTrace();
      }

   }

   protected final void pointerDragged(int var1, int var2) {
      aO = var1;
      aP = var2;
   }

   protected final void pointerPressed(int var1, int var2) {
      aQ = true;
      aO = var1;
      aP = var2;
   }

   protected final void pointerReleased(int var1, int var2) {
      aQ = false;
      aN = true;
      aO = var1;
      aP = var2;
   }

   public final void run() {
      if (!aM) {
         aM = true;
         d = 13;
         Y = 8;
      }

      while(aM) {
         long var1 = System.currentTimeMillis();
         switch (d) {
            case 1:
               aa();
               DebugRefactor.tick();
               break;
            case 2:
               if (S < R) {
                  S += 5;
               }
               break;
            case 3:
               if (aN) {
                  aN = false;
                  if (aP > aV - 40) {
                     if (aO < aW - 40) {
                        aT[4] = true;
                     } else if (aO > aW + 40) {
                        aT[6] = true;
                     } else {
                        aT[5] = true;
                     }
                  }
               }

               if (++mapSubIdLegacy == 10000) {
                  mapSubIdLegacy = 0;
               }

               if (aT[4]) {
                  if (--aY < 0) {
                     aY = StoryDialogue.aD.length - 1;
                  }

                  aT[4] = false;
               }

               if (aT[6]) {
                  if (++aY == StoryDialogue.aD.length) {
                     aY = 0;
                  }

                  aT[6] = false;
               }

               if (aT[5]) {
                  label412: {
                     d();
                     if (aY == 0) {
                        eB = null;
                        A();
                        Midlet.f = true;
                        playTimeSessionStartMs = System.currentTimeMillis();
                        x(99);
                     } else if (aY == 1) {
                        if (!Midlet.b()) {
                           break label412;
                        }

                        eB = null;
                        A();
                        int[] var9;
                        playTimeSeconds = (var9 = a(Midlet.b("ninjasave")))[0];
                        mapId = fixMapId(var9[1]);
                        mapSubIdLegacy = var9[2];
                        hasSaveGame = var9[3] == 1;
                        gold = var9[4];
                        activationTrialFlag = var9[5] == 1;
                        unlockedMap97 = var9[6] == 1;
                        unlockedMap96 = var9[7] == 1;
                        unlockedMap95 = var9[8] == 1;
                        escortActive = var9[9] == 1;
                        escortReservedLegacy = var9[10];
                        escortMapId = var9[11];
                        mapObjectMountIndex = var9[12];
                        equippedWeaponIndex = var9[13];
                        shurikenLevel2Learned = var9[14] == 1;
                        Midlet.e = true;
                        playTimeSessionStartMs = System.currentTimeMillis();
                        x(mapId);
                     } else if (aY == 2) {
                        eB = null;
                        A();
                        d = 2;
                        aw();
                        Midlet.d = 11;
                        mapId = 101;
                        (new Thread(Midlet.c)).start();
                     } else if (aY == 3) {
                        try {
                           Midlet.c.platformRequest("http://giaitri321.pro/");
                        } catch (Exception var6) {
                        }
                     } else if (aY == 4) {
                        Midlet.c.exit("menu aY==4");
                     }

                     aT[5] = false;
                  }
               }

               if (cutsceneP == 0) {
                  cutsceneP = 960;
                  cutsceneQ = 48;
                  cutsceneL = 1;
                  cutsceneM = 1;
               }

               cutsceneP += cutsceneL;
               cutsceneQ += cutsceneM;
               if (cutsceneP > cutsceneR) {
                  cutsceneP = cutsceneR;
                  cutsceneL = -cutsceneL;
               }

               if (cutsceneP < 24) {
                  cutsceneP = 24;
                  cutsceneL = -cutsceneL;
               }

               if (cutsceneQ < 0) {
                  cutsceneQ = 0;
                  cutsceneM = -cutsceneM;
               }

               if (cutsceneQ > cutsceneS) {
                  cutsceneQ = cutsceneS;
                  cutsceneM = -cutsceneM;
               }

               if ((bx = cutsceneP / jf - 1) < 0) {
                  bx = 0;
               }

               by = cutsceneQ / jf;
               bB = bx + bz;
               bC = by + bA;
               if (by < 0) {
                  by = 0;
               }

               if (bC > iO - 1) {
                  bC = iO - 1;
               }

               if (bb > aZ) {
                  bb -= 4;
               }

               if (bc < ba) {
                  bc += 4;
               }

               if (be > bd) {
                  be -= 2;
               }
               break;
            case 4:
               if (jF < 4) {
                  jG = jF;
               }

               if (jF > 51) {
                  jD = null;
                  jE = null;
                  aH();
                  d = 10;
               } else if (jF > 46) {
                  jG = 4 - (jF - 46);
               }

               aU = aL.getWidth();
               aV = aL.getHeight();
               ++jF;
               break;
            case 5:
               aE();
               break;
            case 6:
               if (aN) {
                  aN = false;
                  if (aP > aV - 40) {
                     if (aO < aW) {
                        aT[12] = true;
                     } else {
                        aT[13] = true;
                     }
                  }

                  c();
               }

               if (aQ) {
                  int var7 = aO + lf;
                  int var4 = aP + lg;
                  if (var7 > kV) {
                     aS[6] = true;
                  }

                  if (var7 < kV) {
                     aS[4] = true;
                  }

                  if (var4 > kW) {
                     aS[8] = true;
                  }

                  if (var4 < kW) {
                     aS[2] = true;
                  }
               }

               if (++kY > 10000) {
                  kY = 0;
               }

               if (lf != kZ || lg != la) {
                  lb = kZ - lf << 1;
                  lc = la - lg << 1;
                  ld += lb;
                  lf += ld >> 4;
                  ld &= 15;
                  le += lc;
                  lg += le >> 4;
                  le &= 15;
                  if (lf < -40) {
                     lf = -40;
                  }

                  if (lf > lh) {
                     lf = lh;
                  }

                  if (lg < -40) {
                     lg = -40;
                  }

                  if (lg > li) {
                     lg = li;
                  }
               }

               boolean var8 = false;
               if (aT[5] || aT[12]) {
                  d();
                  if (kX != -1) {
                     if (!mapUnlockFlags[kX]) {
                        s(1);
                        d = 7;
                     } else if (lj == kX) {
                        s(3);
                        d = 7;
                     } else {
                        s(2);
                        d = 7;
                     }
                  }
               }

               if (aT[13]) {
                  aF();
                  kI = null;
                  au();
                  d = 1;
                  d();
                  c();
                  aT[12] = true;
               } else {
                  if (aS[2]) {
                     if ((kW -= 4) < -20) {
                        kW = -20;
                     }

                     var8 = true;
                  }

                  if (aS[8]) {
                     if ((kW += 4) > 279) {
                        kW = 279;
                     }

                     var8 = true;
                  }

                  if (aS[4]) {
                     if ((kV -= 4) < -20) {
                        kV = -20;
                     }

                     var8 = true;
                  }

                  if (aS[6]) {
                     if ((kV += 4) > 279) {
                        kV = 279;
                     }

                     var8 = true;
                  }

                  if (var8) {
                     kZ = kV - bD;
                     la = kW - bE;
                     aG();
                  }
               }
               break;
            case 7:
               if (aN) {
                  aN = false;
                  if (aP > aV - 40) {
                     if (aO < aW) {
                        aT[12] = true;
                     } else {
                        aT[13] = true;
                     }
                  }
               }

               if (++lq < 10) {
                  d();
               }

               if (aT[12]) {
                  d();
                  switch (lo) {
                     case 1:
                     case 3:
                     case 4:
                        d = 6;
                        break;
                     case 2:
                        if (lp >= gold) {
                           s(4);
                        } else {
                           gold -= lp;
                           aF();
                           kI = null;
                           au();
                           A();
                           cameraScrollY = playerX = kR[kX] * 24;
                           cameraBound = playerY = kS[kX] * 24;
                           Midlet.f = true;
                           x(kX);
                        }
                        break;
                     case 5:
                     case 6:
                        kI = null;
                        d = 1;
                  }
               }

               if (aT[13]) {
                  d();
                  switch (lo) {
                     case 1:
                     case 3:
                     case 4:
                     case 5:
                     case 6:
                     default:
                        break;
                     case 2:
                        d = 6;
                        break;
                     case 7:
                        d = 9;
                  }
               }

               c = true;
               break;
            case 8:
               aC();
               break;
            case 9:
               aB();
               break;
            case 10:
               if (aN) {
                  aN = false;
                  if (aP > aV - 40) {
                     if (aO < aW) {
                        aT[12] = true;
                     } else {
                        aT[13] = true;
                     }
                  }
               }

               if (lm) {
                  ll = null;
                  I();
               }

               boolean var3 = false;
               if (aT[12]) {
                  if (ln == 0) {
                     Midlet.h = false;
                  } else {
                     a = false;
                  }

                  var3 = true;
               } else if (aT[13]) {
                  if (ln == 0) {
                     Midlet.h = true;
                  } else {
                     a = true;
                  }

                  var3 = true;
               }

               if (var3) {
                  d();
                  c();
                  if (ln == 0) {
                     try {
                        ll = Image.createImage("/u/m2.png");
                     } catch (Exception var5) {
                     }

                     ln = 1;
                  } else {
                     Midlet.lowGfx = !lM;
                     lm = true;
                  }
               }
               break;
            case 11:
               ai();
               break;
            case 12:
               ai();
               break;
            case 13:
               if (++lP > 10000) {
                  lP = 0;
               }

               aU = ((Displayable)this).getWidth();
               aV = ((Displayable)this).getHeight();
               if (aN && aP > aV - 20) {
                  if (aO < aW) {
                     aT[12] = true;
                  } else {
                     aT[13] = true;
                  }

                  aN = false;
               }

               switch (Y) {
                  case 0:
                     this.aS();
                  case 1:
                  case 3:
                  case 9:
                  case 10:
                  case 11:
                  case 12:
                  case 13:
                  default:
                     break;
                  case 2:
                     this.aR();
                     break;
                  case 4:
                     this.aL();
                     break;
                  case 5:
                     if (aT[5] || aT[12]) {
                        Midlet.c.exit("screen Y=5 key5/12");
                     }
                     break;
                  case 6:
                     aQ();
                     break;
                  case 7:
                     aK();
                     break;
                  case 8:
                     if (aT[12]) {
                        Midlet.c.exit("screen Y=8 key12");
                     }
                     break;
                  case 14:
                     if (aT[13] || aT[12] || aT[5]) {
                        aT[13] = false;
                        aT[5] = false;
                        aT[12] = false;
                        Midlet.c.exit("screen Y=14 key5/12/13");
                     }
               }
         }

         ((Canvas)this).repaint();
         ((Canvas)this).serviceRepaints();

         while(System.currentTimeMillis() - var1 < (long)Z) {
            Thread.yield();
         }
      }

      a();
      Midlet.c.exit("game loop ended");
   }

   public static void o(int var0) {
      jo = 0;
      if (var0 == 0) {
         jo = 16;
         as();
         a(0, "Bộ môn Khí", 1044, 336);
         a(1, "Cô Ayumi", 1044, 347);
         a(2, "Phòng chủ nhiệm", 1212, 336);
         a(3, "Thầy Takanashi", 1212, 347);
         a(4, "Phòng", 1380, 336);
         a(5, "đào tạo", 1380, 347);
         a(6, "Phòng", 1212, 216);
         a(7, "Hiệu trưởng", 1212, 227);
         a(8, "Bộ môn Lực", 1044, 216);
         a(9, "Thầy Hiroyaki", 1044, 227);
         a(10, "Bộ môn Thuật", 1380, 216);
         a(11, "Thầy Honda", 1380, 227);
         a(12, "Kí Túc Xá", 444, 341);
         a(13, "* Khu luyện tập", 72, 341);
         a(14, "Cổng /", 1860, 317);
         a(15, "Bán HP-MP", 612, 341);
      } else if (var0 == 1) {
         jo = 2;
         as();
         a(0, "Trường /", 1356, 173);
         a(1, "* Thác nước", 48, 173);
      } else if (var0 == 2) {
         jo = 4;
         as();
         a(0, "* Lối vào", 60, 245);
         a(1, "Trường Hirosaki", 240, 197);
         a(2, "Lối ra /", 420, 245);
         a(2, "Mua đồ tiền thật", 552, 245);
         a(3, "đường hoa đào /", 1356, 221);
      } else if (var0 == 3) {
         jo = 2;
         as();
         a(0, "* Ngôi làng", 48, 173);
         a(1, "Rừng trúc /", 2808, 173);
      } else if (var0 == 4) {
         jo = 2;
         as();
         a(0, "* Vườn đào", 48, 101);
         a(1, "Rừng tối", 1704, 245);
      } else if (var0 == 5) {
         jo = 2;
         as();
         a(0, "Trường /", 420, 77);
         a(1, "Rừng tối /", 408, 1829);
      } else if (var0 == 6) {
         jo = 3;
         as();
         a(0, "* Thác nước", 72, 101);
         a(1, "Rừng tối /", 504, 53);
         a(2, "Sông Watamoro /", 5916, 197);
      } else {
         if (var0 == 99) {
            jo = 1;
            as();
            a(0, "Trường Hirosaki", 744, 173);
         }

      }
   }

   private static void a(int var0, String var1, int var2, int var3) {
      jk[var0] = var1;
      jl[var0] = var2;
      jm[var0] = var3;
      int[] var10000 = jl;
      var10000[var0] -= Midlet.a(var1) >> 1;
      jn[var0] = Midlet.a(var1);
   }

   private static void i(Graphics var0) {
      for(int var1 = 0; var1 < jo; ++var1) {
         if (jl[var1] + jn[var1] >= cutsceneP && jl[var1] <= cutsceneP + q && jm[var1] >= cutsceneQ && jm[var1] - 14 <= cutsceneQ + r) {
            Midlet.a(var0, jk[var1], jl[var1], jm[var1], 0);
         }
      }

   }

   private static void as() {
      jk = new String[jo];
      jl = new int[jo];
      jm = new int[jo];
      jn = new int[jo];
   }

   public static void p(int var0) {
      iY = 0;
      if (var0 == 2) {
         if (iX == null) {
            iX = new Image[3];

            try {
               iX[0] = Image.createImage("/t/h0.png");
               iX[1] = Image.createImage("/t/h1.png");
               iX[2] = Image.createImage("/t/h2.png");
            } catch (Exception var2) {
            }
         }

         iY = 5;
         at();
         b(0, 0, 29, 13);
         b(1, 1, 34, 13);
         b(2, 2, 39, 13);
         b(3, 1, 46, 11);
         b(4, 2, 51, 11);
      }

      if (var0 == 16) {
         if (iX == null) {
            iX = new Image[3];

            try {
               iX[0] = Image.createImage("/t/h0.png");
               iX[1] = Image.createImage("/t/h1.png");
               iX[2] = Image.createImage("/t/h2.png");
            } catch (Exception var1) {
            }
         }

         iY = 5;
         at();
         b(0, 0, 5, 11);
         b(1, 1, 14, 12);
         b(2, 2, 33, 10);
         b(3, 1, 53, 10);
         b(4, 0, 59, 11);
      }

   }

   private static void b(int var0, int var1, int var2, int var3) {
      iZ[var0] = var1;
      ja[var0] = var2 * jf + 12;
      jb[var0] = var3 * jf;
      jc[var0] = iX[var1].getWidth() >> 1;
      jd[var0] = iX[var1].getHeight();
   }

   private static void at() {
      iZ = new int[iY];
      ja = new int[iY];
      jb = new int[iY];
      jc = new int[iY];
      jd = new int[iY];
   }

   private static void au() {
      try {
         if (iU == null) {
            iU = Image.createImage("/t/t.png");
         }

         if (iV == null) {
            iV = Image.createImage("/t/wtf.png");
         }

         if (iW == null) {
            iW = Image.createImage("/t/wts.png");
         }

         if (je == null && !a) {
            je = Image.createImage("/t/tb.png");
         }

         System.gc();
      } catch (Exception var0) {
         ((Throwable)var0).printStackTrace();
         Midlet.c.exit("au() load tile images");
      }
   }

   public static void q(int var0) {
      var0 = fixMapId(var0);
      iT = new boolean[200];
      if (var0 == 101) {
         var0 = 99;
      }

      if (var0 == 0) {
         iN = 80;
         iO = 19;
         jp = 1;
         jt = 59 * jf;
         ju = 9 * jf;
         jq = 2;
         jv = 3;
         jw = 12 * jf;
         jr = -1;
         js = -1;
      } else if (var0 == 1) {
         iN = 60;
         iO = 14;
         jp = 5;
         jt = 19 * jf;
         ju = 5 * jf;
         jq = 0;
         jv = 3;
         jw = 16 * jf;
         jr = -1;
         js = -1;
      } else if (var0 == 2) {
         iN = 60;
         iO = 16;
         jp = 0;
         jt = 79 * jf;
         ju = 15 * jf;
         jq = 3;
         jv = 3;
         jw = 9 * jf;
         jr = -1;
         js = -1;
      } else if (var0 == 3) {
         iN = 120;
         iO = 12;
         jp = 2;
         jt = 59 * jf;
         ju = 11 * jf;
         jq = 4;
         jv = 3;
         jw = 144;
         jr = -1;
         js = -1;
      } else if (var0 == 4) {
         iN = 80;
         iO = 15;
         jp = 3;
         jt = 119 * jf;
         ju = 9 * jf;
         jq = -1;
         jr = -1;
         js = 6;
         jz = 26 * jf;
         jA = 10;
      } else if (var0 == 5) {
         iN = 20;
         iO = 80;
         jp = -1;
         jq = 1;
         jv = 3;
         jw = 9 * jf;
         jB = 40 * jf;
         jr = 6;
         jx = 3;
         jy = 5 * jf;
         js = -1;
      } else if (var0 == 6) {
         iN = 250;
         iO = 12;
         jp = 5;
         jt = 19 * jf;
         ju = 78 * jf;
         jq = 7;
         jv = 1 * jf;
         jw = 7 * jf;
         jr = -1;
         js = -1;
      } else if (var0 == 7) {
         iN = 80;
         iO = 14;
         jp = 6;
         jt = 249 * jf;
         ju = 10 * jf;
         jq = 97;
         jv = 1 * jf;
         jw = 3 * jf;
         jr = -1;
         js = -1;
      } else if (var0 == 97) {
         iN = 25;
         iO = 13;
         jp = 7;
         jt = 79 * jf;
         ju = 11 * jf;
         jq = 8;
         jv = 1 * jf;
         jw = 12 * jf;
         jr = -1;
         js = -1;
      } else if (var0 == 8) {
         iN = 80;
         iO = 14;
         jp = 97;
         jt = 23 * jf;
         ju = 7 * jf;
         jq = 9;
         jv = 1 * jf;
         jw = 11 * jf;
         jr = -1;
         js = -1;
      } else if (var0 == 9) {
         iN = 80;
         iO = 14;
         jp = 8;
         jt = 79 * jf;
         ju = 9 * jf;
         jq = -1;
         jv = 1 * jf;
         jw = 11 * jf;
         jr = -1;
         js = 10;
         jz = 2 * jf;
         jA = 0 * jf;
      } else if (var0 == 10) {
         iN = 40;
         iO = 40;
         jp = -1;
         jq = 11;
         jv = 24;
         jw = 264;
         jr = -1;
         js = -1;
      } else if (var0 == 11) {
         iN = 90;
         iO = 14;
         jp = 10;
         jt = 936;
         ju = 720;
         jq = 96;
         jv = 24;
         jw = 192;
         jr = -1;
         js = -1;
      } else if (var0 == 96) {
         iN = 25;
         iO = 14;
         jp = 11;
         jt = 2112;
         ju = 288;
         jq = 12;
         jv = 24;
         jw = 192;
         jr = -1;
         js = -1;
      } else if (var0 == 12) {
         iN = 40;
         iO = 25;
         jp = 96;
         jt = 552;
         ju = 264;
         jq = 13;
         jv = 24;
         jw = 216;
         jr = -1;
         js = -1;
      } else if (var0 == 13) {
         iN = 80;
         iO = 14;
         jp = 12;
         jt = 936;
         ju = 456;
         jq = 14;
         jv = 24;
         jw = 168;
         jr = -1;
         js = -1;
      } else if (var0 == 14) {
         iN = 60;
         iO = 16;
         jp = 13;
         jt = 1896;
         ju = 264;
         jq = 15;
         jv = 24;
         jw = 120;
         jr = -1;
         js = -1;
      } else if (var0 == 15) {
         iN = 40;
         iO = 30;
         jp = 14;
         jt = 1416;
         ju = 144;
         jq = 16;
         jv = 24;
         jw = 264;
         jr = -1;
         js = -1;
      } else if (var0 == 16) {
         iN = 70;
         iO = 15;
         jp = 15;
         jt = 936;
         ju = 168;
         jq = 17;
         jv = 24;
         jw = 432;
         jr = -1;
         js = -1;
      } else if (var0 == 17) {
         iN = 50;
         iO = 20;
         jp = 16;
         jt = 1656;
         ju = 144;
         jq = 18;
         jv = 24;
         jw = 288;
         jr = -1;
         js = -1;
      } else if (var0 == 18) {
         iN = 70;
         iO = 15;
         jp = 17;
         jt = 1176;
         ju = 384;
         jq = 95;
         jv = 24;
         jw = 192;
         jr = -1;
         js = -1;
      } else if (var0 == 95) {
         iN = 25;
         iO = 14;
         jp = 18;
         jt = 1632;
         ju = 312;
         jq = -1;
         jr = -1;
         js = -1;
      } else if (var0 == 94) {
         iN = 24;
         iO = 14;
         jp = -1;
         jq = -1;
         jr = -1;
         js = -1;
      } else if (var0 == 99) {
         iN = 70;
         iO = 15;
         jp = -1;
         jq = 4;
         jv = 2 * jf;
         jw = 5 * jf;
         jr = -1;
         js = -1;
      }

      iP = iN * jf;
      iQ = iO * jf;

      try {
         InputStream var4;
         if ((var4 = "".getClass().getResourceAsStream("/m/" + var0)) == null) {
            throw new Exception("missing map file /m/" + var0 + " (copy thu muc m/ vao res/)");
         }

         iR = new byte[iN * iO];
         iS = new int[iN * iO];

         for(int var1 = 0; var1 < iN * iO; ++var1) {
            iR[var1] = (byte)var4.read();
            if (iR[var1] != 0) {
               iT[iR[var1] - 1] = true;
            }

            if (iR[var1] == 1 || iR[var1] == 2 || iR[var1] == 3 || iR[var1] == 4 || iR[var1] == 5 || iR[var1] == 6 || iR[var1] == 7 || iR[var1] == 36 || iR[var1] == 37 || iR[var1] == 54 || iR[var1] == 91 || iR[var1] == 92 || iR[var1] == 93 || iR[var1] == 94 || iR[var1] == 73 || iR[var1] == 74 || iR[var1] == 97 || iR[var1] == 98 || iR[var1] == 120) {
               int[] var10000 = iS;
               var10000[var1] |= 2;
            }

            if (iR[var1] == 2 || iR[var1] == 3 || iR[var1] == 4 || iR[var1] == 5 || iR[var1] == 6 || iR[var1] == 20 || iR[var1] == 21 || iR[var1] == 22 || iR[var1] == 23 || iR[var1] == 36 || iR[var1] == 37 || iR[var1] == 38 || iR[var1] == 39) {
               int[] var5 = iS;
               var5[var1] |= 8192;
            }

            if (iR[var1] == 8 || iR[var1] == 9 || iR[var1] == 10 || iR[var1] == 12 || iR[var1] == 13 || iR[var1] == 14 || iR[var1] == 30) {
               int[] var6 = iS;
               var6[var1] |= 16;
            }

            if (iR[var1] == 17) {
               int[] var7 = iS;
               var7[var1] |= 32;
            }

            if (iR[var1] == 18) {
               int[] var8 = iS;
               var8[var1] |= 128;
            }

            if (iR[var1] == 37 || iR[var1] == 38) {
               int[] var9 = iS;
               var9[var1] |= 4;
            }

            if (iR[var1] == 36 || iR[var1] == 39) {
               int[] var10 = iS;
               var10[var1] |= 8;
            }

            if (iR[var1] == 19) {
               int[] var11 = iS;
               var11[var1] |= 64;
               if ((iS[var1 - iN] & 8192) == 8192) {
                  var11 = iS;
                  var11[var1] |= 8192;
               }
            }

            if (iR[var1] == 35) {
               int[] var13 = iS;
               var13[var1] |= 4096;
            }

            if (iR[var1] == 32) {
               int[] var14 = iS;
               var14[var1] |= 256;
            }

            if (iR[var1] == 7) {
               int[] var15 = iS;
               var15[var1] |= 2048;
            }

            if (iR[var1] == 33 || iR[var1] == 34) {
               int[] var16 = iS;
               var16[var1] |= 512;
            }
         }
      } catch (Exception var2) {
         ((Throwable)var2).printStackTrace();
         Midlet.c.exit("q() map init");
      }

      TileCollision.bind(iN, iO, iP, iQ, jf, iS);
      au();
   }

   private static void j(Graphics var0) {
      for(int var1 = bx; var1 < bB; ++var1) {
         for(int var2 = by; var2 < bC; ++var2) {
            int var3;
            if ((var3 = iR[var2 * iN + var1] - 1) != -1) {
               var0.drawRegion(iU, 0, var3 * jf, 24, 24, 0, var1 * jf, var2 * jf, 0);
            }

            if ((h(var1, var2) & 32) == 32) {
               var0.drawRegion(iV, 0, 24 * (mapSubIdLegacy % 4), 24, 24, 0, var1 * jf, var2 * jf, 0);
            } else if ((h(var1, var2) & 64) == 64) {
               if ((h(var1, var2 - 1) & 32) == 32) {
                  var0.drawRegion(iV, 0, 24 * (mapSubIdLegacy % 4), 24, 24, 0, var1 * jf, var2 * jf, 0);
               } else if ((h(var1, var2 - 1) & 8192) == 8192) {
                  var0.drawRegion(iU, 0, 504, 24, 24, 0, var1 * jf, var2 * jf, 0);
               }

               var0.drawRegion(iW, 0, (mapSubIdLegacy % 8 >> 2) * 24, 24, 24, 0, var1 * jf, var2 * jf, 0);
            }

            if ((h(var1, var2) & 4096) == 4096) {
               if ((h(var1, var2 - 1) & 32) == 32) {
                  var0.drawRegion(iV, 0, 24 * (mapSubIdLegacy % 4), 24, 24, 0, var1 * jf, var2 * jf, 0);
               } else if ((h(var1, var2 - 1) & 8192) == 8192) {
                  var0.drawRegion(iU, 0, 504, 24, 24, 0, var1 * jf, var2 * jf, 0);
               }

               var0.drawRegion(iU, 0, (iR[var2 * iN + var1] - 1) * jf, 24, 24, 0, var1 * jf, var2 * jf, 0);
            }
         }
      }

   }

   private static void k(Graphics var0) {
      for(int var1 = bx; var1 < bB; ++var1) {
         for(int var2 = by; var2 < bC; ++var2) {
            int var3 = iR[var2 * iN + var1] - 1;
            if ((h(var1, var2) & 16) == 16) {
               jh = (jg = var1 * jf - cutsceneP) - bD;
               ji = (jj = (jf - 2) * jh / jf) + bD;
               var0.drawRegion(iU, 0, var3 * jf, 24, 24, 0, ji + cutsceneP, var2 * jf, 0);
            } else if ((h(var1, var2) & 256) != 256 && (h(var1, var2) & 512) != 512) {
               if ((h(var1, var2) & 32) == 32) {
                  var0.drawRegion(iV, 0, 24 * (mapSubIdLegacy % 4), 24, 24, 0, var1 * jf, var2 * jf, 0);
               } else if ((h(var1, var2) & 64) != 64 && (h(var1, var2) & 4096) != 4096) {
                  if ((h(var1, var2) & 1024) == 1024) {
                     var0.drawRegion(iU, 0, var3 * jf, 24, 24, 0, var1 * jf, var2 * jf + 1, 0);
                  } else if (var3 != -1) {
                     var0.drawRegion(iU, 0, var3 * jf, 24, 24, 0, var1 * jf, var2 * jf, 0);
                  }
               } else if ((h(var1, var2 - 1) & 32) == 32) {
                  var0.drawRegion(iV, 0, 24 * (mapSubIdLegacy % 4), 24, 24, 0, var1 * jf, var2 * jf, 0);
               } else if ((h(var1, var2 - 1) & 8192) == 8192) {
                  var0.drawRegion(iU, 0, 504, 24, 24, 0, var1 * jf, var2 * jf, 0);
               }
            }
         }
      }

   }

   private static void l(Graphics var0) {
      if (!a) {
         for(int var1 = bx; var1 < bB; ++var1) {
            for(int var2 = by; var2 < bC; ++var2) {
               if ((h(var1, var2) & 64) == 64) {
                  var0.drawRegion(iW, 0, (mapSubIdLegacy % 8 >> 2) * 24, 24, 24, 0, var1 * jf, var2 * jf, 0);
               } else if ((h(var1, var2) & 256) == 256) {
                  jh = (jg = var1 * jf - cutsceneP) - bD;
                  ji = (jj = (jf - 1) * jh / jf) + bD;
                  var0.drawImage(je, ji + cutsceneP - 2 + (var1 + var2) % 5, var2 * jf - 3 + var2 % 5, 0);
               }

               if ((h(var1, var2) & 512) == 512) {
                  var0.drawRegion(iU, 0, (iR[var2 * iN + var1] - 1) * jf, 24, 24, 0, var1 * jf, var2 * jf + 2, 0);
               }

               if ((h(var1, var2) & 4096) == 4096) {
                  var0.drawRegion(iU, 0, (iR[var2 * iN + var1] - 1) * jf, 24, 24, 0, var1 * jf, var2 * jf, 0);
               }
            }
         }

      }
   }

   private static int h(int var0, int var1) {
      return TileCollision.getFlagsTile(var0, var1);
   }

   private static int i(int var0, int var1) {
      return TileCollision.getFlagsPx(var0, var1);
   }

   private static boolean g(int var0, int var1, int var2) {
      return TileCollision.hasAllFlagsPx(var0, var1, var2);
   }

   private static void h(int var0, int var1, int var2) {
      TileCollision.setPlatformPx(var0, var1);
   }

   private static void i(int var0, int var1, int var2) {
      TileCollision.clearBlockedAtColumn24(var0, var1, var2);
   }

   private static void j(int var0, int var1, int var2) {
      TileCollision.clearPlatformPx(var0, var1);
   }

   private static int H(int var0) {
      return TileCollision.snapToTileOrigin(var0);
   }

   private static int I(int var0) {
      return TileCollision.snapToTileOrigin(var0);
   }

   public static void av() {
      try {
         jD = Image.createImage("/u/lg.png");
      } catch (Exception var0) {
      }

      jF = 0;
   }

   private static void aw() {
      S = 0;
      R = 0;
      jC = 0;
   }

   private static void J(int var0) {
      if (kd[var0] > 30) {
         int var2 = jZ[var0] > 0 ? jL[var0] : jL[var0] - ke[var0];
         int var3 = jZ[var0] >= 0 ? jL[var0] + ke[var0] : jL[var0];
         int var4 = jM[var0] - kf[var0];
         int var1 = jM[var0] + kf[var0];
         if (playerState == 6 ? false : (gameModeFx ? false : (playerState == 14 ? false : (playerX < var2 ? false : (playerX > var3 ? false : (playerY < var4 ? false : playerY <= var1)))))) {
            kd[var0] = 0;
            jQ[var0] = 4;
            jV[var0] = 0;
         }
      }

   }

   private static void K(int var0) {
      if (kd[var0] > 30) {
         int var2 = jZ[var0] > 0 ? jL[var0] : jL[var0] - ke[var0];
         int var3 = jZ[var0] >= 0 ? jL[var0] + ke[var0] : jL[var0];
         int var4 = jM[var0] - kf[var0];
         int var1 = jM[var0] + kf[var0];
         if (companionMode == 14 ? false : (companionX < var2 ? false : (companionX > var3 ? false : (companionY < var4 ? false : companionY <= var1)))) {
            kd[var0] = 0;
            jQ[var0] = 4;
            jV[var0] = 0;
            kj[var0] = true;
         }
      }

   }

   private static boolean k(int var0, int var1, int var2) {
      if (jQ[var0] == 2 || jQ[var0] == 3 || jQ[var0] == 4 || jQ[var0] == 9) {
         int[] var10000 = ka;
         var10000[var0] -= var1;
         if (ka[var0] <= 0) {
            ka[var0] = 0;
            jV[var0] = -5;
            jW[var0] = -(var2 << 3);
            jX[var0] = 0;
            jP[var0] = 0;
            jQ[var0] = 1;
            L(var0);
            return true;
         }

         if (jQ[var0] == 9) {
            var10000 = jV;
            var10000[var0] -= 7;
            jZ[var0] = var2;
         } else {
            jV[var0] = 0;
            jZ[var0] = var2;
            jQ[var0] = 6;
            jY[var0] = 3;
         }
      }

      return false;
   }

   private static void L(int var0) {
      u(MonsterData.getExpDrop(jK[var0]));
      int var1;
      if ((var1 = mapSubIdLegacy % 20) > 15) {
         a(jL[var0], jM[var0], -(jZ[var0] << 3), -5, kc[var0] << 2, (mapSubIdLegacy + 1) % 2);
      } else if (var1 == 15) {
         a(jL[var0], jM[var0], -(jZ[var0] << 2), -4, (kh[var0] << 3) + mapSubIdLegacy % 10);
      } else {
         var1 = ((jK[var0] << 2) / 10 + 1) * 10;
         a(jL[var0], jM[var0], -(jZ[var0] << 1), -6, var1);
         a(jL[var0], jM[var0], -(jZ[var0] << 4), -3, var1);
      }

      if (activeQuestId != -1 && lF[activeQuestId] == jK[var0]) {
         ++questProgress;
         c(MonsterData.getName(lF[activeQuestId]) + ": " + questProgress + "#" + questRequiredAmounts[activeQuestId]);
      }

      if (jK[var0] == questParam - 100 && mapSubIdLegacy % 10 < questTarget) {
         e(jL[var0], jM[var0]);
         f(jL[var0], jM[var0] - 28);
      }

   }

   public static final void r(int var0) {
      jI = 0;
      switch (var0) {
         case 0:
            kn = new int[]{7};
            ay();
            kk[0] = new int[]{68, 71, 74, 64};
            kl[0] = new int[]{15, 15, 15, 17};
            az();
            M(2);
            q(0, 2);
            break;
         case 1:
            kn = new int[]{1, 7, 0};
            ay();
            kk[0] = new int[]{44, 40, 42, 39, 41, 39, 34};
            kl[0] = new int[]{10, 11, 9, 9, 7, 5, 9};
            kk[1] = new int[]{48, 51};
            kl[1] = new int[]{9, 9};
            kk[2] = new int[]{8, 3, 24, 25, 26};
            kl[2] = new int[]{9, 9, 10, 8, 6};
            az();
            M(7);
            u(0, 3);
            q(1, 1);
            s(2, 3);
            break;
         case 2:
            kn = new int[]{1, 6};
            ay();
            kk[0] = new int[]{32, 41, 44, 48};
            kl[0] = new int[]{13, 13, 11, 11};
            kk[1] = new int[]{41, 47, 57, 36};
            kl[1] = new int[]{9, 7, 7, 8};
            az();
            M(4);
            u(0, 2);
            o(1, 2);
            break;
         case 3:
            kn = new int[]{1, 6, 0};
            ay();
            kk[0] = new int[]{6, 10, 17, 26, 42, 83, 96};
            kl[0] = new int[]{9, 10, 10, 10, 10, 10, 11};
            kk[1] = new int[]{10, 19, 24, 32, 41, 49, 59, 68, 80, 87, 110};
            kl[1] = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 7};
            kk[2] = new int[]{17, 24, 28, 35, 42, 49, 59, 69, 78, 86, 97, 107, 113};
            kl[2] = new int[]{10, 10, 8, 8, 10, 9, 9, 9, 10, 10, 8, 8, 9};
            az();
            M(20);
            u(0, 4);
            o(1, 8);
            s(2, 8);
            break;
         case 4:
            kn = new int[]{6, 0, 4, 9, 1};
            ay();
            kk[0] = new int[]{29, 26, 37, 43, 58, 67, 11, 74, 57};
            kl[0] = new int[]{11, 10, 11, 10, 8, 3, 8, 7, 7};
            kk[1] = new int[]{21, 39, 37, 45, 25, 62, 58};
            kl[1] = new int[]{12, 12, 12, 8, 12, 9, 5};
            kk[2] = new int[]{29, 33, 68, 42, 57};
            kl[2] = new int[]{13, 12, 7, 12, 9};
            kk[3] = new int[]{55, 59, 53};
            kl[3] = new int[]{5, 5, 5};
            kk[4] = new int[]{19, 11};
            kl[4] = new int[]{12, 11};
            az();
            M(20);
            o(0, 6);
            s(1, 6);
            r(2, 4);
            l(3, 2);
            u(4, 2);
            break;
         case 5:
            kn = new int[]{0, 3, 4};
            ay();
            kk[0] = new int[]{7, 14, 7, 14, 7, 6, 15, 9};
            kl[0] = new int[]{9, 13, 18, 28, 29, 35, 42, 70};
            kk[1] = new int[]{6, 4, 14, 4, 16, 7, 15, 11};
            kl[1] = new int[]{14, 26, 33, 44, 47, 62, 65, 78};
            kk[2] = new int[]{14, 14, 7, 12, 8, 14, 8};
            kl[2] = new int[]{23, 39, 56, 62, 66, 70, 78};
            az();
            M(20);
            s(0, 7);
            boolean var15 = true;
            var0 = 1;

            int var19;
            for(var19 = 0; var19 < jI && jK[var19] != -1; ++var19) {
            }

            if (var19 != jI) {
               for(int var11 = var19; var11 < var19 + 7; ++var11) {
                  ki[var11] = 1;
                  jK[var11] = 3;
                  ke[var11] = 30;
                  kf[var11] = 10;
                  jN[var11] = 27;
                  jO[var11] = 15;
                  jZ[var11] = 1;
                  jQ[var11] = 5;
                  jV[var11] = var11 << 3;
                  ka[var11] = kb[var11] = MonsterData.HP[jK[var11]];
                  kc[var11] = MonsterData.DAMAGE[jK[var11]];
                  kh[var11] = MonsterData.HIT_STAT[jK[var11]];
                  kd[var11] = 0;
               }
            }

            r(2, 6);
            break;
         case 6:
            kn = new int[]{9, 2, 5};
            ay();
            kk[0] = new int[]{42, 47, 72, 82, 85, 93, 104, 130, 139, 151, 165, 182, 189, 200, 207, 214, 225, 225, 237};
            kl[0] = new int[]{10, 8, 10, 8, 6, 6, 6, 9, 9, 7, 4, 7, 9, 10, 10, 8, 4, 10, 8};
            kk[1] = new int[]{39, 40, 41, 72, 73, 74, 132, 106, 107, 130, 131, 142, 149, 157, 168, 182, 183, 194, 214, 215, 216, 236, 39, 40, 56, 57};
            kl[1] = new int[]{5, 5, 6, 6, 4, 3, 2, 3, 4, 5, 5, 5, 2, 1, 3, 4, 5, 6, 6, 5, 4, 5, 6, 6, 6, 6};
            kk[2] = new int[]{45, 64, 83, 101, 119, 147, 173, 220};
            kl[2] = new int[]{6, 8, 4, 3, 6, 7, 5, 4};
            az();
            M(26);
            l(0, 5);
            j(1, 18);
            boolean var14 = true;
            var0 = 2;

            int var18;
            for(var18 = 0; var18 < jI && jK[var18] != -1; ++var18) {
            }

            if (var18 != jI) {
               for(int var9 = var18; var9 < var18 + 3; ++var9) {
                  ki[var9] = 2;
                  jK[var9] = 5;
                  ke[var9] = 7;
                  kf[var9] = 10;
                  jN[var9] = 16;
                  jO[var9] = 15;
                  jZ[var9] = 0;
                  jQ[var9] = 5;
                  jV[var9] = var9 << 3;
                  ka[var9] = kb[var9] = MonsterData.HP[jK[var9]];
                  kc[var9] = MonsterData.DAMAGE[jK[var9]];
                  kh[var9] = MonsterData.HIT_STAT[jK[var9]];
                  kd[var9] = 100;
               }
            }
            break;
         case 7:
            kn = new int[]{9, 8, 10};
            ay();
            kk[0] = new int[]{38, 39, 47, 52, 56, 61, 66, 73, 71};
            kl[0] = new int[]{5, 5, 3, 8, 4, 4, 4, 4, 8};
            kk[1] = new int[]{16, 23, 26, 29, 32, 35, 38, 41, 44, 47, 56, 59, 61, 64, 66};
            kl[1] = new int[]{11, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
            kk[2] = new int[]{36, 42, 45, 487, 56, 60, 64};
            kl[2] = new int[]{11, 11, 11, 11, 11, 11, 11};
            az();
            M(23);
            l(0, 7);
            m(1, 10);
            n(2, 6);
            break;
         case 8:
            kn = new int[]{11, 8, 10, 2};
            ay();
            kk[0] = new int[]{12, 29, 6, 12, 24, 18, 37, 50, 65, 72, 47};
            kl[0] = new int[]{10, 8, 12, 12, 11, 12, 10, 8, 8, 7, 7};
            kk[1] = new int[]{29, 45, 48, 70, 73};
            kl[1] = new int[]{12, 12, 12, 12, 12};
            kk[2] = new int[]{46, 47, 71, 72};
            kl[2] = new int[]{13, 13, 13, 13};
            kk[3] = new int[]{25, 7, 69, 69, 50, 51};
            kl[3] = new int[]{25, 8, 6, 7, 5, 5};
            az();
            M(22);
            boolean var13 = true;
            var0 = 0;

            int var17;
            for(var17 = 0; var17 < jI && jK[var17] != -1; ++var17) {
            }

            if (var17 != jI) {
               for(int var7 = var17; var7 < var17 + 10; ++var7) {
                  ki[var7] = 0;
                  jK[var7] = 11;
                  ke[var7] = 32;
                  kf[var7] = 10;
                  jN[var7] = 27;
                  jO[var7] = 15;
                  jZ[var7] = 1;
                  jQ[var7] = 5;
                  jV[var7] = jJ - var7;
                  ka[var7] = kb[var7] = MonsterData.HP[jK[var7]];
                  kc[var7] = MonsterData.DAMAGE[jK[var7]];
                  kh[var7] = MonsterData.HIT_STAT[jK[var7]];
                  kd[var7] = 0;
               }
            }

            m(1, 4);
            n(2, 3);
            j(3, 5);
            break;
         case 9:
            kn = new int[]{13};
            ay();
            kk[0] = new int[]{10, 37, 23, 65};
            kl[0] = new int[]{7, 6, 6, 4};
            az();
            M(3);
            k(0, 3);
            break;
         case 10:
            kn = new int[]{13};
            ay();
            kk[0] = new int[]{31, 12, 25, 12};
            kl[0] = new int[]{19, 23, 23, 6};
            az();
            M(3);
            k(0, 3);
            break;
         case 11:
            kn = new int[]{14, 8};
            ay();
            kk[0] = new int[]{15, 16, 17, 31, 32, 33, 68, 69, 72};
            kl[0] = new int[]{12, 12, 12, 12, 8, 8, 8, 8, 8};
            kk[1] = new int[]{47, 48, 50, 49};
            kl[1] = new int[]{12, 12, 12, 12};
            az();
            M(10);
            boolean var1 = true;
            var0 = 0;

            int var2;
            for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
            }

            if (var2 != jI) {
               for(int var5 = var2; var5 < var2 + 7; ++var5) {
                  ki[var5] = 0;
                  jK[var5] = 14;
                  ke[var5] = 7;
                  kf[var5] = 10;
                  jN[var5] = 16;
                  jO[var5] = 15;
                  jZ[var5] = 1;
                  jQ[var5] = 5;
                  jV[var5] = var5 << 3;
                  ka[var5] = kb[var5] = MonsterData.HP[jK[var5]];
                  kc[var5] = MonsterData.DAMAGE[jK[var5]];
                  kh[var5] = MonsterData.HIT_STAT[jK[var5]];
                  kd[var5] = 500;
               }
            }

            m(1, 3);
            break;
         case 12:
            kn = new int[]{15, 16, 10};
            ay();
            kk[0] = new int[]{11, 18, 20, 9, 9, 17, 18, 22, 31};
            kl[0] = new int[]{7, 5, 10, 14, 17, 15, 20, 19, 21};
            kk[1] = new int[]{5, 10, 5, 10, 14, 21, 16, 37};
            kl[1] = new int[]{6, 12, 15, 19, 16, 17, 9, 17};
            kk[2] = new int[]{25, 26, 27, 34};
            kl[2] = new int[]{23, 23, 23, 23};
            az();
            M(19);
            t(0, 7);
            p(1, 8);
            n(2, 4);
            break;
         case 13:
            kn = new int[]{18, 15, 13};
            ay();
            kk[0] = new int[]{6, 12, 30, 34, 34, 43, 54, 53, 70, 76};
            kl[0] = new int[]{9, 11, 11, 10, 5, 5, 5, 11, 11, 11};
            kk[1] = new int[]{11, 16, 18, 29, 50, 38, 48, 58, 62, 74};
            kl[1] = new int[]{11, 9, 7, 5, 11, 5, 5, 5, 5, 11};
            kk[2] = new int[]{22, 41, 42, 61};
            kl[2] = new int[]{9, 8, 2, 8};
            az();
            M(18);
            v(0, 8);
            t(1, 6);
            k(2, 4);
            break;
         case 14:
            kn = new int[]{12, 17, 16};
            ay();
            kk[0] = new int[]{7, 12, 16, 25, 28, 45, 50};
            kl[0] = new int[]{4, 7, 11, 14, 8, 14, 9};
            kk[1] = new int[]{14, 18, 29, 28, 29, 53, 47, 51};
            kl[1] = new int[]{7, 11, 12, 8, 4, 14, 9, 4};
            kk[2] = new int[]{4, 41, 26, 26, 34, 41, 49, 56};
            kl[2] = new int[]{4, 9, 11, 2, 2, 5, 7, 2};
            az();
            M(19);
            y(0, 6);
            x(1, 7);
            p(2, 6);
            break;
         case 15:
            kn = new int[]{19, 18, 17};
            ay();
            kk[0] = new int[]{22, 7, 19, 32};
            kl[0] = new int[]{28, 25, 28, 14};
            kk[1] = new int[]{3, 13, 31, 35, 24};
            kl[1] = new int[]{6, 25, 25, 21, 27};
            kk[2] = new int[]{35, 29, 24, 17, 13, 2};
            kl[2] = new int[]{8, 11, 9, 7, 7, 17};
            az();
            M(15);
            w(0, 4);
            v(1, 5);
            x(2, 6);
            break;
         case 16:
            kn = new int[]{19, 13};
            ay();
            kk[0] = new int[]{15, 33, 53};
            kl[0] = new int[]{12, 10, 10};
            kk[1] = new int[]{20, 39, 59};
            kl[1] = new int[]{10, 8, 8};
            az();
            M(6);
            w(0, 3);
            k(1, 3);
            break;
         case 17:
            kn = new int[]{12};
            ay();
            kk[0] = new int[]{8, 14, 39, 45};
            kl[0] = new int[]{12, 12, 9, 16};
            az();
            M(4);
            y(0, 4);
            break;
         case 95:
            kn = new int[]{13};
            ay();
            kk[0] = new int[]{7, 10, 14, 18};
            kl[0] = new int[]{8, 8, 8, 8};
            az();
            M(4);
            k(0, 4);
      }

      if (jI > 0) {
         jH = new Image[kn.length][2][4];

         for(int var12 = 0; var12 < kn.length; ++var12) {
            for(int var16 = 0; var16 < 2; ++var16) {
               for(int var20 = 0; var20 < 4; ++var20) {
                  try {
                     jH[var12][var16][var20] = Image.createImage("/mob/m" + kn[var12] + var16 + var20 + ".png");
                  } catch (Exception var3) {
                  }

                  if (jH[var12][var16][var20] == null && var16 == 1) {
                     jH[var12][1][var20] = jH[var12][0][var20];
                  }
               }

               if (jH[var12][var16][2] == null) {
                  jH[var12][var16][2] = jH[var12][var16][1];
               }
            }
         }
      }

   }

   private static void ax() {
      for(int var0 = 0; var0 < jI; ++var0) {
         if (kd[var0] <= 30) {
            int var10002 = kd[var0]++;
         }

         if (jP[var0] > 0) {
            int var69 = jP[var0]--;
         }

         switch (jQ[var0]) {
            case 1:
               int var121 = jV[var0]++;
               int[] var67 = jM;
               var67[var0] += jV[var0];
               if (mapSubIdLegacy % 2 == 0) {
                  if (jW[var0] > 1) {
                     var121 = jW[var0]--;
                  } else if (jW[var0] < -1) {
                     var121 = jW[var0]++;
                  }
               }

               var67 = jL;
               var67[var0] += jW[var0];
               jY[var0] = 2;
               if (jM[var0] < iQ && jL[var0] >= 0 && jL[var0] < iP) {
                  if ((jX[var0] == 0 || jX[var0] < 3 && jV[var0] > 7) && (i(jL[var0], jM[var0]) & 2) == 2) {
                     jV[var0] = jV[var0] > 4 ? -4 : -jV[var0];
                     var121 = jX[var0]++;
                  }

                  if (g(jL[var0], jM[var0], 64) && jM[var0] % jf > 8) {
                     g(jL[var0], H(jM[var0]) + 8);
                  }
               } else {
                  jV[var0] = -300;
                  jQ[var0] = 5;
                  if (T) {
                     jQ[var0] = 8;
                  }

                  km[ki[var0]][kg[var0]] = false;
               }
               break;
            case 2:
               switch (jK[var0]) {
                  case 0:
                     if (mapSubIdLegacy % 4 == 0) {
                        int var120 = jY[var0]++;
                        if (jY[var0] > 1) {
                           jY[var0] = 0;
                        }
                     }

                     int[] var66 = jL;
                     var66[var0] += jZ[var0];
                     if (jL[var0] > jS[var0]) {
                        jZ[var0] = -1;
                     } else if (jL[var0] < jR[var0]) {
                        jZ[var0] = 1;
                     }

                     J(var0);
                     if (mapSubIdLegacy % 9 == 0) {
                        K(var0);
                     }
                     continue;
                  case 1:
                     U(var0);
                     continue;
                  case 2:
                     int[] var62 = jL;
                     var62[var0] += jT[var0];
                     var62 = jM;
                     var62[var0] += jU[var0];
                     if (jL[var0] - jR[var0] > 40) {
                        jT[var0] = -(mapSubIdLegacy % 3 + 1);
                     }

                     if (jL[var0] - jR[var0] < -40) {
                        jT[var0] = mapSubIdLegacy % 3 + 1;
                     }

                     if (jM[var0] - jS[var0] > 40) {
                        jU[var0] = -(mapSubIdLegacy % 3 + 1);
                     }

                     if (jM[var0] - jS[var0] < -40) {
                        jU[var0] = mapSubIdLegacy % 3 + 1;
                     }

                     if (mapSubIdLegacy % 15 == 0) {
                        jT[var0] = mapSubIdLegacy % 4 - 1;
                        jU[var0] = (mapSubIdLegacy >> 1) % 4 - 1;
                     }

                     if (mapSubIdLegacy % 2 == 0) {
                        int var119 = jY[var0]++;
                        if (jY[var0] > 1) {
                           jY[var0] = 0;
                        }

                        if (jY[var0] == 0) {
                           var62 = jM;
                           var62[var0] -= 3;
                        } else {
                           var62 = jM;
                           var62[var0] += 2;
                        }
                     }

                     J(var0);
                     continue;
                  case 3:
                     int[] var60 = jL;
                     var60[var0] += jV[var0];
                     if (jV[var0] > 1) {
                        int var116 = jV[var0]--;
                     } else if (jV[var0] < -1) {
                        int var117 = jV[var0]++;
                     }

                     var60 = jM;
                     var60[var0] += jW[var0];
                     int var118 = jW[var0]++;
                     if (jW[var0] > 4) {
                        jW[var0] = -4;
                        jV[var0] = jZ[var0] * 3;
                     }

                     if (a(jW[var0]) == 3) {
                        if (jL[var0] > jS[var0]) {
                           jZ[var0] = -1;
                        } else if (jL[var0] < jR[var0]) {
                           jZ[var0] = 1;
                        }

                        jY[var0] = 0;
                     } else {
                        jY[var0] = 1;
                     }

                     J(var0);
                     if (mapSubIdLegacy % 9 == 0) {
                        K(var0);
                     }
                     continue;
                  case 4:
                     int[] var58 = jL;
                     var58[var0] += jX[var0];
                     if (jX[var0] > 1) {
                        int var113 = jX[var0]--;
                     } else if (jX[var0] < -1) {
                        int var114 = jX[var0]++;
                     }

                     var58 = jM;
                     var58[var0] += jW[var0];
                     int var115 = jW[var0]++;
                     if (jW[var0] > 3) {
                        jW[var0] = -3;
                        jX[var0] = jZ[var0] << 2;
                        jV[var0] = 0;
                        jM[var0] = kl[ki[var0]][kg[var0]];
                        jQ[var0] = 3;
                     }

                     if (jW[var0] == -2) {
                        if (jL[var0] > jS[var0]) {
                           jZ[var0] = -1;
                        } else if (jL[var0] < jR[var0]) {
                           jZ[var0] = 1;
                        }

                        jX[var0] = jZ[var0] * 6;
                        jY[var0] = 0;
                     } else {
                        jY[var0] = 1;
                     }

                     J(var0);
                     if (mapSubIdLegacy % 9 == 0) {
                        K(var0);
                     }
                     continue;
                  case 5:
                     if (mapSubIdLegacy % 4 == 0) {
                        int var112 = jY[var0]++;
                        if (jY[var0] > 1) {
                           jY[var0] = 0;
                        }

                        int[] var57 = jM;
                        var57[var0] += jV[var0];
                     }

                     if (jM[var0] > jS[var0]) {
                        jV[var0] = -1;
                     } else if (jM[var0] < jR[var0]) {
                        jV[var0] = 1;
                     }

                     J(var0);
                     continue;
                  case 6:
                     P(var0);
                  case 7:
                  default:
                     continue;
                  case 8:
                     int var111 = jY[var0]++;
                     if (jY[var0] > 1) {
                        jY[var0] = 0;
                     }

                     int[] var56 = jL;
                     var56[var0] += mapSubIdLegacy % 5 * jZ[var0];
                     if (jL[var0] > jS[var0]) {
                        jZ[var0] = -1;
                     } else if (jL[var0] < jR[var0]) {
                        jZ[var0] = 1;
                     }

                     J(var0);
                     continue;
                  case 9:
                     Q(var0);
                     continue;
                  case 10:
                     int var110 = jY[var0]++;
                     if (jY[var0] > 1) {
                        jY[var0] = 0;
                     }

                     int[] var55 = jL;
                     var55[var0] += 5 * jZ[var0];
                     if (jL[var0] > jS[var0]) {
                        jZ[var0] = -1;
                     } else if (jL[var0] < jR[var0]) {
                        jZ[var0] = 1;
                     }

                     J(var0);
                     continue;
                  case 11:
                     if (mapSubIdLegacy % 4 == 0) {
                        int var109 = jY[var0]++;
                        jV[var0] = 0;
                        if (jY[var0] > 1) {
                           jY[var0] = 0;
                           jV[var0] = 1;
                        }
                     }

                     int[] var54 = jL;
                     var54[var0] += jV[var0] * jZ[var0];
                     if (jL[var0] > jS[var0]) {
                        jZ[var0] = -1;
                     } else if (jL[var0] < jR[var0]) {
                        jZ[var0] = 1;
                     }

                     J(var0);
                     if (mapSubIdLegacy % 9 == 0) {
                        K(var0);
                     }
                     continue;
                  case 12:
                     Q(var0);
                     continue;
                  case 13:
                     int[] var48 = jL;
                     var48[var0] += jT[var0];
                     if (jL[var0] - jR[var0] > 100) {
                        jZ[var0] = -1;
                        jT[var0] = jZ[var0] * (mapSubIdLegacy % 4 + 1);
                        var48 = jL;
                        var48[var0] += jZ[var0] << 2;
                     } else if (jL[var0] - jR[var0] < -100) {
                        jZ[var0] = 1;
                        jT[var0] = jZ[var0] * (mapSubIdLegacy % 4 + 1);
                        var48 = jL;
                        var48[var0] += jZ[var0] << 2;
                     }

                     if (jM[var0] - jS[var0] > 20) {
                        jU[var0] = -(mapSubIdLegacy % 4 + 1);
                     } else if (jM[var0] - jS[var0] < -20) {
                        jU[var0] = mapSubIdLegacy % 4 + 1;
                     } else {
                        jU[var0] = 0;
                     }

                     var48 = jM;
                     var48[var0] += jU[var0];
                     if (mapSubIdLegacy % 2 == 0) {
                        int var108 = jY[var0]++;
                        if (jY[var0] > 1) {
                           jY[var0] = 0;
                           var48 = jM;
                           var48[var0] -= 12;
                        } else {
                           var48 = jM;
                           var48[var0] += 12;
                        }
                     }

                     J(var0);
                     continue;
                  case 14:
                     int var107 = jY[var0]++;
                     if (jY[var0] > 1) {
                        jY[var0] = 0;
                     }

                     if (mapSubIdLegacy % 2 == 0) {
                        int[] var46 = jL;
                        var46[var0] += jZ[var0] << 2;
                     } else {
                        int[] var47 = jL;
                        var47[var0] += jZ[var0] << 1;
                     }

                     if (jL[var0] > jS[var0]) {
                        jZ[var0] = -1;
                     } else if (jL[var0] < jR[var0]) {
                        jZ[var0] = 1;
                     }

                     J(var0);
                     if (mapSubIdLegacy % 5 == 0) {
                        K(var0);
                     }
                     continue;
                  case 15:
                     int[] var44 = jL;
                     var44[var0] += jV[var0];
                     if (jV[var0] > 1) {
                        int var104 = jV[var0]--;
                     } else if (jV[var0] < -1) {
                        int var105 = jV[var0]++;
                     }

                     var44 = jM;
                     var44[var0] += jW[var0];
                     int var106 = jW[var0]++;
                     if (jW[var0] > 4) {
                        jW[var0] = -4;
                        jV[var0] = jZ[var0] * 3;
                     }

                     if (a(jW[var0]) == 3) {
                        if (jL[var0] > jS[var0]) {
                           jZ[var0] = -1;
                        } else if (jL[var0] < jR[var0]) {
                           jZ[var0] = 1;
                        }

                        jY[var0] = 0;
                     } else {
                        jY[var0] = 1;
                     }

                     J(var0);
                     if (mapSubIdLegacy % 9 == 0) {
                        K(var0);
                     }
                     continue;
                  case 16:
                     P(var0);
                     continue;
                  case 17:
                     U(var0);
                     continue;
                  case 18:
                  case 19:
                     if (mapSubIdLegacy % 4 == 0) {
                        int var103 = jY[var0]++;
                        if (jY[var0] > 1) {
                           jY[var0] = 0;
                        }
                     }

                     if (jL[var0] > playerX) {
                        jZ[var0] = -1;
                     } else {
                        jZ[var0] = 1;
                     }

                     J(var0);
                     if (mapSubIdLegacy % 9 == 0) {
                        K(var0);
                     }
                     continue;
               }
            case 3:
               int var102 = jV[var0]++;
               if (jV[var0] >= 35) {
                  jV[var0] = 0;
                  jQ[var0] = 2;
               }

               jY[var0] = 0;
               J(var0);
               break;
            case 4:
               if (playerState == 14 || gameModeFx) {
                  jY[var0] = 0;
                  jQ[var0] = 2;
                  jV[var0] = 0;
                  jW[var0] = 0;
               }

               switch (jK[var0]) {
                  case 0:
                     int var101 = jV[var0]++;
                     if (jV[var0] == 2) {
                        if (kj[var0]) {
                           kj[var0] = false;
                           b(kc[var0], jZ[var0]);
                        } else {
                           a(kc[var0], jZ[var0]);
                        }
                     }

                     if ((jV[var0] >> 2) % 2 == 0) {
                        int[] var42 = jL;
                        var42[var0] += jZ[var0];
                        jY[var0] = 3;
                     } else {
                        jY[var0] = 0;
                        int[] var43 = jL;
                        var43[var0] -= jZ[var0];
                     }

                     if (jV[var0] == 12) {
                        jQ[var0] = 3;
                        jV[var0] = 0;
                     }
                     continue;
                  case 1:
                     a(kc[var0], -playerFacing);
                     jQ[var0] = 3;
                     jV[var0] = 0;
                     jY[var0] = 2;
                     continue;
                  case 2:
                     if (jL[var0] < playerX) {
                        jT[var0] = 3 + mapSubIdLegacy % 4;
                     } else if (jL[var0] > playerX) {
                        jT[var0] = -(3 + mapSubIdLegacy % 4);
                     }

                     if (jM[var0] < playerY) {
                        jU[var0] = mapSubIdLegacy % 3;
                     } else if (jM[var0] > playerY) {
                        jU[var0] = -mapSubIdLegacy % 3;
                     }

                     int[] var40 = jL;
                     var40[var0] += jT[var0];
                     var40 = jM;
                     var40[var0] += jU[var0];
                     if (mapSubIdLegacy % 2 == 0) {
                        int var100 = jY[var0]++;
                        if (jY[var0] > 1) {
                           jY[var0] = 0;
                        }
                     }

                     if (a(jL[var0] - playerX) < 5 && a(jM[var0] - playerY) < 5) {
                        kd[var0] = 0;
                        a(kc[var0], -playerFacing);
                        jV[var0] = 0;
                        jQ[var0] = 2;
                     }

                     if (a(jL[var0] - playerX) > 160 || a(jM[var0] - playerY) > 160) {
                        jQ[var0] = 2;
                        jV[var0] = 0;
                        jT[var0] = jU[var0] = 0;
                        kd[var0] = 0;
                     }
                     continue;
                  case 3:
                     int var99 = jV[var0]++;
                     if (jV[var0] == 3) {
                        if (kj[var0]) {
                           kj[var0] = false;
                           b(kc[var0], jZ[var0]);
                        } else {
                           a(kc[var0], jZ[var0]);
                        }
                     }

                     if ((jV[var0] >> 2) % 2 == 0) {
                        int[] var38 = jL;
                        var38[var0] += jZ[var0];
                        jY[var0] = 0;
                     } else {
                        jY[var0] = 3;
                        int[] var39 = jL;
                        var39[var0] -= jZ[var0];
                     }

                     if (jV[var0] == 12) {
                        jM[var0] = kl[ki[var0]][kg[var0]];
                        jQ[var0] = 3;
                        jW[var0] = -4;
                        jV[var0] = 0;
                     }
                     continue;
                  case 4:
                     int var98 = jV[var0]++;
                     if (jV[var0] == 3) {
                        if (kj[var0]) {
                           kj[var0] = false;
                           b(kc[var0], jZ[var0]);
                        } else {
                           a(kc[var0], jZ[var0]);
                        }
                     }

                     if ((jV[var0] >> 2) % 2 == 0) {
                        int[] var36 = jL;
                        var36[var0] += jZ[var0];
                        jY[var0] = 0;
                     } else {
                        jY[var0] = 1;
                        int[] var37 = jL;
                        var37[var0] -= jZ[var0];
                     }

                     if (jV[var0] == 12) {
                        jM[var0] = kl[ki[var0]][kg[var0]];
                        jQ[var0] = 3;
                        jW[var0] = -4;
                        jV[var0] = 0;
                     }
                     continue;
                  case 5:
                     a(kc[var0], -playerFacing);
                     jQ[var0] = 2;
                     jV[var0] = 1;
                     continue;
                  case 6:
                     N(var0);
                  case 7:
                  default:
                     continue;
                  case 8:
                     int var96 = jV[var0]++;
                     if (jV[var0] <= 10) {
                        if (jM[var0] > playerY) {
                           int[] var32 = jM;
                           var32[var0] -= 4;
                        }

                        if (jL[var0] < playerX) {
                           int[] var33 = jL;
                           var33[var0] += 2;
                        } else if (jL[var0] > playerX) {
                           int[] var34 = jL;
                           var34[var0] -= 2;
                        }

                        if (a(jL[var0] - playerX) < 16 && a(jM[var0] - (playerY - 16)) < 20) {
                           a(kc[var0], -playerFacing);
                           jV[var0] = 10;
                        }
                     }

                     if (jV[var0] == 10) {
                        jW[var0] = 1;
                     }

                     if (jV[var0] > 10) {
                        int[] var35 = jM;
                        var35[var0] += jW[var0];
                        var96 = jW[var0]++;
                        if (jM[var0] > kl[ki[var0]][kg[var0]]) {
                           jM[var0] = kl[ki[var0]][kg[var0]];
                           jW[var0] = 0;
                           jV[var0] = 0;
                           jQ[var0] = 2;
                        }
                     }

                     jY[var0] = jV[var0] % 2 == 0 ? 0 : 1;
                     continue;
                  case 9:
                     int var95 = jV[var0]++;
                     if (jV[var0] < 6) {
                        int[] var30 = jL;
                        var30[var0] += jZ[var0] << 2;
                     } else if (jV[var0] == 6) {
                        if (a(jL[var0] + (jZ[var0] << 3) - playerX) < 13 + halfWidth) {
                           a(kc[var0], jZ[var0]);
                        }
                     } else if (jV[var0] < 12) {
                        int[] var31 = jL;
                        var31[var0] -= jZ[var0] << 1;
                     } else if (jV[var0] == 12) {
                        jM[var0] = kl[ki[var0]][kg[var0]];
                        jQ[var0] = 3;
                        jW[var0] = -4;
                        jV[var0] = 0;
                     }

                     jY[var0] = 1;
                     if (jV[var0] > 3 && jV[var0] < 9 && jV[var0] % 2 == 0) {
                        jY[var0] = 3;
                     }
                     continue;
                  case 10:
                     int var91 = jV[var0]++;
                     jY[var0] = 3;
                     if (jV[var0] <= 15) {
                        int[] var28 = jM;
                        var28[var0] -= 7;
                        if (jL[var0] < playerX) {
                           var91 = jL[var0]++;
                        } else if (jL[var0] > playerX) {
                           var91 = jL[var0]--;
                        }

                        if (a(jL[var0] - playerX) < 16 && a(jM[var0] - (playerY - 16)) < 20) {
                           a(kc[var0], -playerFacing);
                           jV[var0] = 15;
                        }
                     }

                     if (jV[var0] == 15) {
                        jW[var0] = 1;
                     }

                     if (jV[var0] > 15) {
                        jY[var0] = 2;
                        int[] var29 = jM;
                        var29[var0] += jW[var0];
                        var91 = jW[var0]++;
                        if (a(jL[var0] - playerX) < 16 && a(jM[var0] - (playerY - 16)) < 20) {
                           a(kc[var0], -playerFacing);
                        }

                        if (jM[var0] > kl[ki[var0]][kg[var0]]) {
                           jM[var0] = kl[ki[var0]][kg[var0]];
                           jW[var0] = 0;
                           jV[var0] = 0;
                           jQ[var0] = 2;
                        }
                     }
                     continue;
                  case 11:
                     int var90 = jV[var0]++;
                     if (jV[var0] == 4 && jM[var0] == playerY) {
                        a(kc[var0], jZ[var0]);
                     }

                     if (jV[var0] < 8) {
                        int[] var26 = jL;
                        var26[var0] += jZ[var0] << 1;
                        jY[var0] = 3;
                     } else {
                        jY[var0] = 0;
                        int[] var27 = jL;
                        var27[var0] -= jZ[var0] << 1;
                     }

                     if (jV[var0] == 12) {
                        jQ[var0] = 3;
                        jV[var0] = 0;
                        kd[var0] = 25;
                     }
                     continue;
                  case 12:
                     R(var0);
                     continue;
                  case 13:
                     if (jL[var0] < playerX) {
                        jT[var0] = 4 + mapSubIdLegacy % 6;
                     } else if (jL[var0] > playerX) {
                        jT[var0] = -(4 + mapSubIdLegacy % 6);
                     }

                     if (jM[var0] < playerY) {
                        jU[var0] = 2 + mapSubIdLegacy % 4;
                     } else if (jM[var0] > playerY) {
                        jU[var0] = -(2 + mapSubIdLegacy % 4);
                     }

                     int[] var24 = jL;
                     var24[var0] += jT[var0];
                     var24 = jM;
                     var24[var0] += jU[var0];
                     if (mapSubIdLegacy % 2 == 0) {
                        int var89 = jY[var0]++;
                        if (jY[var0] > 1) {
                           jY[var0] = 0;
                        }
                     }

                     if (a(jL[var0] - playerX) < 5 && a(jM[var0] - playerY) < 5) {
                        a(kc[var0], -playerFacing);
                        jQ[var0] = 2;
                        jV[var0] = 0;
                        jZ[var0] = jL[var0] > jR[var0] ? -1 : 1;
                        jT[var0] = jZ[var0] * (mapSubIdLegacy % 4 + 1);
                        kd[var0] = 10;
                     }

                     if (a(jL[var0] - playerX) > 130 || a(jM[var0] - playerY) > 130) {
                        jQ[var0] = 2;
                        jV[var0] = 0;
                        jT[var0] = jU[var0] = 0;
                        jZ[var0] = jL[var0] > jR[var0] ? -1 : 1;
                        jT[var0] = jZ[var0] * (mapSubIdLegacy % 4 + 1);
                        kd[var0] = 0;
                     }
                     continue;
                  case 14:
                     R(var0);
                     continue;
                  case 15:
                     int var88 = jV[var0]++;
                     if (jV[var0] == 3) {
                        if (kj[var0]) {
                           kj[var0] = false;
                           b(kc[var0], jZ[var0]);
                        } else {
                           a(kc[var0], jZ[var0]);
                        }
                     }

                     if ((jV[var0] >> 2) % 2 == 0) {
                        int[] var22 = jL;
                        var22[var0] += jZ[var0];
                        jY[var0] = 0;
                     } else {
                        jY[var0] = 3;
                        int[] var23 = jL;
                        var23[var0] -= jZ[var0];
                     }

                     if (jV[var0] == 12) {
                        jM[var0] = kl[ki[var0]][kg[var0]];
                        jQ[var0] = 3;
                        jW[var0] = -4;
                        jV[var0] = 0;
                     }
                     continue;
                  case 16:
                     N(var0);
                     continue;
                  case 17:
                  case 18:
                     int var87 = jV[var0]++;
                     jY[var0] = 3;
                     if (jV[var0] == 3) {
                        b(jL[var0] + (jZ[var0] << 3), jM[var0] - 12, jZ[var0] << 3, kc[var0], 2);
                     } else if (jV[var0] == 6) {
                        jQ[var0] = 3;
                        jV[var0] = 0;
                     }
                     continue;
                  case 19:
                     int var85 = jV[var0]++;
                     jY[var0] = 3;
                     if (jV[var0] == 3) {
                        var85 = jW[var0]++;
                        if (jW[var0] == 3) {
                           jW[var0] = 0;
                        }

                        if (jW[var0] == 2) {
                           c(jL[var0], jM[var0] - 22, jZ[var0], -10, kc[var0]);
                        } else if (jW[var0] == 0) {
                           c(jL[var0], jM[var0] - 22, jZ[var0] << 1, -9, kc[var0]);
                        } else {
                           c(jL[var0], jM[var0] - 22, 0, -11, kc[var0]);
                        }

                        g(jL[var0], jM[var0] - 20);
                     } else if (jV[var0] == 6) {
                        jQ[var0] = 3;
                        jV[var0] = 0;
                     }
                     continue;
               }
            case 5:
               int var84 = jV[var0]++;
               if (jV[var0] >= jJ) {
                  jV[var0] = 0;
                  int var2 = mapSubIdLegacy % kk[ki[var0]].length;
                  if (km[ki[var0]][var2]) {
                     jV[var0] = jJ;
                  } else {
                     jL[var0] = kk[ki[var0]][var2];
                     jM[var0] = kl[ki[var0]][var2];
                     km[ki[var0]][var2] = true;
                     kg[var0] = var2;
                     jQ[var0] = 2;
                     ka[var0] = kb[var0];
                     switch (jK[var0]) {
                        case 0:
                           jR[var0] = jL[var0] - 20;
                           jS[var0] = jL[var0] + 20;
                           break;
                        case 1:
                           jR[var0] = jL[var0] - 10;
                           jS[var0] = jL[var0] + 10;
                           break;
                        case 2:
                           jR[var0] = jL[var0] + 12;
                           jS[var0] = jM[var0] + 12;
                           break;
                        case 3:
                           jR[var0] = jL[var0] - 20;
                           jS[var0] = jL[var0] + 20;
                           jW[var0] = -4;
                        case 4:
                           jR[var0] = jL[var0] - 20;
                           jS[var0] = jL[var0] + 20;
                           jW[var0] = -3;
                           break;
                        case 5:
                           jR[var0] = jM[var0] - 10;
                           jS[var0] = jM[var0] + 10;
                           jV[var0] = 1;
                           break;
                        case 6:
                           jR[var0] = jL[var0];
                           jS[var0] = jM[var0];
                           break;
                        case 7:
                           jQ[var0] = 3;
                           break;
                        case 8:
                        case 9:
                        case 11:
                        case 12:
                           jR[var0] = jL[var0] - 20;
                           jS[var0] = jL[var0] + 20;
                           break;
                        case 10:
                           jR[var0] = jL[var0] - 30;
                           jS[var0] = jL[var0] + 30;
                           break;
                        case 13:
                           jR[var0] = jL[var0] + 12;
                           jS[var0] = jM[var0] + 12;
                           break;
                        case 14:
                           jR[var0] = jL[var0] - 40;
                           jS[var0] = jL[var0] + 40;
                           break;
                        case 15:
                           jR[var0] = jL[var0] - 20;
                           jS[var0] = jL[var0] + 20;
                           jW[var0] = -4;
                           break;
                        case 16:
                           jR[var0] = jL[var0];
                           jS[var0] = jM[var0];
                           break;
                        case 17:
                           jR[var0] = jL[var0] - 30;
                           jS[var0] = jL[var0] + 30;
                     }
                  }
               }
               break;
            case 6:
               jP[var0] = 100;
               jY[var0] = 2;
               switch (jK[var0]) {
                  case 0:
                     if (kd[var0] < 30) {
                        int[] var18 = jL;
                        var18[var0] -= jZ[var0] << 1;
                     } else {
                        int[] var19 = jL;
                        var19[var0] -= jZ[var0];
                     }

                     int var83 = jV[var0]++;
                     if (jV[var0] == 1) {
                        int[] var20 = jM;
                        var20[var0] -= 2;
                     } else if (jV[var0] == 5) {
                        int[] var21 = jM;
                        var21[var0] += 2;
                        jQ[var0] = 2;
                     }
                     break;
                  case 1:
                     S(var0);
                     break;
                  case 2:
                     int var82 = jV[var0]++;
                     int[] var16 = jL;
                     var16[var0] -= jT[var0] >> 3;
                     var16 = jM;
                     var16[var0] -= jU[var0] >> 3;
                     if (jT[var0] == 0) {
                        jT[var0] = 2;
                     }

                     if (jU[var0] == 0) {
                        jU[var0] = 2;
                     }

                     if (jV[var0] == 5) {
                        jQ[var0] = 2;
                        jV[var0] = 0;
                        jT[var0] = jU[var0] = 0;
                        kd[var0] = 10;
                     }
                     break;
                  case 3:
                     int[] var15 = jL;
                     var15[var0] -= jZ[var0];
                     jY[var0] = 2;
                     int var81 = jV[var0]++;
                     if (jV[var0] == 7) {
                        jM[var0] = kl[ki[var0]][kg[var0]];
                        jQ[var0] = 2;
                        jW[var0] = -4;
                        jV[var0] = jZ[var0] * 3;
                     }
                     break;
                  case 4:
                     int[] var14 = jL;
                     var14[var0] -= jZ[var0];
                     jY[var0] = 2;
                     int var80 = jV[var0]++;
                     if (jV[var0] == 7) {
                        jM[var0] = kl[ki[var0]][kg[var0]];
                        jQ[var0] = 2;
                        jW[var0] = -4;
                        jV[var0] = jZ[var0] * 3;
                     }
                     break;
                  case 5:
                     int var78 = jV[var0]++;
                     var78 = jM[var0]--;
                     if (jV[var0] == 3) {
                        jQ[var0] = 2;
                        jV[var0] = 1;
                     }

                     jY[var0] = 2;
                     break;
                  case 6:
                     O(var0);
                     break;
                  case 7:
                     int var77 = jV[var0]++;
                     jZ[var0] = -playerFacing;
                     if (jV[var0] % 4 > 1) {
                        jY[var0] = 0;
                     } else {
                        jY[var0] = 2;
                     }

                     if (jV[var0] == 8) {
                        jQ[var0] = 3;
                        jZ[var0] = 0;
                        jT[var0] = jU[var0] = 0;
                        kd[var0] = 0;
                     }
                     break;
                  case 8:
                     jQ[var0] = 4;
                     break;
                  case 9:
                     int[] var12 = jL;
                     var12[var0] -= jZ[var0];
                     jY[var0] = 2;
                     int var76 = jV[var0]++;
                     if (jV[var0] == 6) {
                        jM[var0] = kl[ki[var0]][kg[var0]];
                        jQ[var0] = 4;
                        jV[var0] = 4;
                        var12 = jL;
                        var12[var0] += jZ[var0] << 3;
                     }
                     break;
                  case 10:
                     jQ[var0] = 4;
                     break;
                  case 11:
                     int[] var10 = jL;
                     var10[var0] -= jZ[var0];
                     jY[var0] = 2;
                     int var75 = jV[var0]++;
                     if (jV[var0] == 6) {
                        jM[var0] = kl[ki[var0]][kg[var0]];
                        jQ[var0] = 4;
                        jV[var0] = 0;
                        var10 = jL;
                        var10[var0] += jZ[var0] << 3;
                     }
                     break;
                  case 12:
                     S(var0);
                     break;
                  case 13:
                     int var74 = jV[var0]++;
                     int[] var8 = jL;
                     var8[var0] -= jT[var0] >> 3;
                     var8 = jM;
                     var8[var0] -= jU[var0] >> 3;
                     if (jT[var0] == 0) {
                        jT[var0] = 2;
                     }

                     if (jU[var0] == 0) {
                        jU[var0] = 2;
                     }

                     if (jV[var0] == 5) {
                        jQ[var0] = 2;
                        jV[var0] = 0;
                        jZ[var0] = jL[var0] > jR[var0] ? -1 : 1;
                        jT[var0] = jZ[var0] << 3;
                        kd[var0] = 0;
                     }
                     break;
                  case 14:
                     T(var0);
                     break;
                  case 15:
                     int[] var7 = jL;
                     var7[var0] -= jZ[var0];
                     jY[var0] = 2;
                     int var73 = jV[var0]++;
                     if (jV[var0] == 3) {
                        jM[var0] = kl[ki[var0]][kg[var0]];
                        jQ[var0] = 2;
                        jW[var0] = -4;
                        jV[var0] = jZ[var0] * 3;
                     }
                     break;
                  case 16:
                     O(var0);
                     break;
                  case 17:
                     T(var0);
                     break;
                  case 18:
                     int var72 = jV[var0]++;
                     int[] var5 = jL;
                     var5[var0] -= jZ[var0];
                     if (jV[var0] == 4) {
                        var5 = jL;
                        var5[var0] += jZ[var0] << 2;
                        jQ[var0] = 2;
                     }
                     break;
                  case 19:
                     int var71 = jV[var0]++;
                     int[] var3 = jL;
                     var3[var0] -= jZ[var0];
                     if (jV[var0] == 4) {
                        var3 = jL;
                        var3[var0] += jZ[var0] << 2;
                        jV[var0] = 0;
                        jQ[var0] = 4;
                     }
               }
            case 7:
            case 8:
            default:
               break;
            case 9:
               int[] var10000 = jM;
               var10000[var0] += jV[var0];
               int var70 = jV[var0]++;
               jY[var0] = 2;
               if (jM[var0] > kl[ki[var0]][kg[var0]]) {
                  if (jK[var0] != 2 && jK[var0] != 6 && jK[var0] != 16 && jK[var0] != 13) {
                     jM[var0] = kl[ki[var0]][kg[var0]];
                  }

                  jQ[var0] = 3;
               }
         }
      }

   }

   private static void j(int var0, int var1) {
      int var2;
      for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }

      if (var2 != jI) {
         for(int var3 = var2; var3 < var2 + var1; ++var3) {
            ki[var3] = var0;
            jK[var3] = 2;
            ke[var3] = 120;
            kf[var3] = 100;
            jN[var3] = 20;
            jO[var3] = 30;
            jZ[var3] = 0;
            jQ[var3] = 5;
            jV[var3] = var3 * 7 + var3;
            ka[var3] = kb[var3] = MonsterData.HP[jK[var3]];
            kc[var3] = MonsterData.DAMAGE[jK[var3]];
            kh[var3] = MonsterData.HIT_STAT[jK[var3]];
            kd[var3] = 100;
            jT[var3] = 2;
            jU[var3] = 3;
         }

      }
   }

   private static void k(int var0, int var1) {
      int var2;
      for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }

      if (var2 != jI) {
         for(int var3 = var2; var3 < var2 + var1; ++var3) {
            ki[var3] = var0;
            jK[var3] = 13;
            ke[var3] = 120;
            kf[var3] = 50;
            jN[var3] = 20;
            jO[var3] = 20;
            jZ[var3] = -1;
            jQ[var3] = 5;
            jV[var3] = var3 << 1;
            ka[var3] = kb[var3] = MonsterData.HP[jK[var3]];
            kc[var3] = MonsterData.DAMAGE[jK[var3]];
            kh[var3] = MonsterData.HIT_STAT[jK[var3]];
            kd[var3] = 100;
            jT[var3] = -3;
            jU[var3] = 3;
         }

      }
   }

   private static void l(int var0, int var1) {
      int var2;
      for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }

      if (var2 != jI) {
         for(int var3 = var2; var3 < var2 + var1; ++var3) {
            ki[var3] = var0;
            jK[var3] = 9;
            ke[var3] = 36;
            kf[var3] = 20;
            jN[var3] = 34;
            jO[var3] = 32;
            jZ[var3] = 1;
            jQ[var3] = 5;
            jV[var3] = var3 * 6;
            ka[var3] = kb[var3] = MonsterData.HP[jK[var3]];
            kc[var3] = MonsterData.DAMAGE[jK[var3]];
            kh[var3] = MonsterData.HIT_STAT[jK[var3]];
            kd[var3] = 100;
         }

      }
   }

   private static void m(int var0, int var1) {
      for(var0 = 0; var0 < jI && jK[var0] != -1; ++var0) {
      }

      if (var0 != jI) {
         for(int var2 = var0; var2 < var0 + var1; ++var2) {
            ki[var2] = 1;
            jK[var2] = 8;
            ke[var2] = 40;
            kf[var2] = 30;
            jN[var2] = 12;
            jO[var2] = 16;
            int[] var10000 = jM;
            var10000[var2] += 5;
            jZ[var2] = 1;
            jQ[var2] = 5;
            jV[var2] = var2 * 5;
            ka[var2] = kb[var2] = MonsterData.HP[jK[var2]];
            kc[var2] = MonsterData.DAMAGE[jK[var2]];
            kh[var2] = MonsterData.HIT_STAT[jK[var2]];
            kd[var2] = 60;
         }

      }
   }

   private static void n(int var0, int var1) {
      for(var0 = 0; var0 < jI && jK[var0] != -1; ++var0) {
      }

      if (var0 != jI) {
         for(int var2 = var0; var2 < var0 + var1; ++var2) {
            ki[var2] = 2;
            jK[var2] = 10;
            ke[var2] = 80;
            kf[var2] = 100;
            jN[var2] = 12;
            jO[var2] = 16;
            jZ[var2] = 1;
            jQ[var2] = 5;
            jV[var2] = var2 * 5;
            ka[var2] = kb[var2] = MonsterData.HP[jK[var2]];
            kc[var2] = MonsterData.DAMAGE[jK[var2]];
            kh[var2] = MonsterData.HIT_STAT[jK[var2]];
            kd[var2] = 40;
         }

      }
   }

   private static void o(int var0, int var1) {
      int var2;
      for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }

      if (var2 != jI) {
         for(int var3 = var2; var3 < var2 + var1; ++var3) {
            ki[var3] = var0;
            jK[var3] = 6;
            ke[var3] = 60;
            kf[var3] = 60;
            jN[var3] = 16;
            jO[var3] = 16;
            jZ[var3] = -1;
            jQ[var3] = 5;
            jV[var3] = var3 << 3;
            ka[var3] = kb[var3] = MonsterData.HP[jK[var3]];
            kc[var3] = MonsterData.DAMAGE[jK[var3]];
            kh[var3] = MonsterData.HIT_STAT[jK[var3]];
            kd[var3] = 100;
            jT[var3] = 2;
            jU[var3] = 3;
         }

      }
   }

   private static void p(int var0, int var1) {
      int var2;
      for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }

      if (var2 != jI) {
         for(int var3 = var2; var3 < var2 + var1; ++var3) {
            ki[var3] = var0;
            jK[var3] = 16;
            ke[var3] = 60;
            kf[var3] = 60;
            jN[var3] = 16;
            jO[var3] = 16;
            jZ[var3] = -1;
            jQ[var3] = 5;
            jV[var3] = var3 + 60;
            ka[var3] = kb[var3] = MonsterData.HP[jK[var3]];
            kc[var3] = MonsterData.DAMAGE[jK[var3]];
            kh[var3] = MonsterData.HIT_STAT[jK[var3]];
            kd[var3] = 100;
            jT[var3] = 2;
            jU[var3] = 3;
         }

      }
   }

   private static void q(int var0, int var1) {
      int var2;
      for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }

      if (var2 != jI) {
         for(int var3 = var2; var3 < var2 + var1; ++var3) {
            ki[var3] = var0;
            jK[var3] = 7;
            ke[var3] = 10;
            kf[var3] = 10;
            jN[var3] = 30;
            jO[var3] = 25;
            jZ[var3] = 1;
            jQ[var3] = 5;
            jV[var3] = var3 << 2;
            ka[var3] = kb[var3] = MonsterData.HP[jK[var3]];
            kc[var3] = MonsterData.DAMAGE[jK[var3]];
            kh[var3] = MonsterData.HIT_STAT[jK[var3]];
            kd[var3] = 0;
         }

      }
   }

   private static void r(int var0, int var1) {
      for(var0 = 0; var0 < jI && jK[var0] != -1; ++var0) {
      }

      if (var0 != jI) {
         for(int var2 = var0; var2 < var0 + var1; ++var2) {
            ki[var2] = 2;
            jK[var2] = 4;
            ke[var2] = 20;
            kf[var2] = 10;
            jN[var2] = 18;
            jO[var2] = 18;
            jZ[var2] = 1;
            jQ[var2] = 5;
            jV[var2] = var2 << 3;
            ka[var2] = kb[var2] = MonsterData.HP[jK[var2]];
            kc[var2] = MonsterData.DAMAGE[jK[var2]];
            kh[var2] = MonsterData.HIT_STAT[jK[var2]];
            kd[var2] = 0;
         }

      }
   }

   private static void ay() {
      kk = new int[kn.length][];
      kl = new int[kn.length][];
      km = new boolean[kn.length][];
   }

   private static void M(int var0) {
      jI = var0;
      jJ = 70;
      jK = new int[jI];
      ki = new int[jI];
      jL = new int[jI];
      jM = new int[jI];
      jQ = new int[jI];
      jR = new int[jI];
      jS = new int[jI];
      jT = new int[jI];
      jU = new int[jI];
      jV = new int[jI];
      jW = new int[jI];
      jX = new int[jI];
      jY = new int[jI];
      jZ = new int[jI];
      ka = new int[jI];
      kj = new boolean[jI];
      kb = new int[jI];
      kc = new int[jI];
      kd = new int[jI];
      jN = new int[jI];
      jO = new int[jI];
      jO = new int[jI];
      jP = new int[jI];
      ke = new int[jI];
      kf = new int[jI];
      kg = new int[jI];
      kh = new int[jI];

      for(int var1 = 0; var1 < jI; ++var1) {
         jK[var1] = -1;
      }

   }

   private static void s(int var0, int var1) {
      int var2;
      for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }

      if (var2 != jI) {
         for(int var3 = var2; var3 < var2 + var1; ++var3) {
            ki[var3] = var0;
            jK[var3] = 0;
            ke[var3] = 25;
            kf[var3] = 10;
            jN[var3] = 27;
            jO[var3] = 15;
            jZ[var3] = 1;
            jQ[var3] = 5;
            jV[var3] = var3 * 7;
            ka[var3] = kb[var3] = MonsterData.HP[jK[var3]];
            kc[var3] = MonsterData.DAMAGE[jK[var3]];
            kh[var3] = MonsterData.HIT_STAT[jK[var3]];
            kd[var3] = 0;
         }

      }
   }

   private static void t(int var0, int var1) {
      int var2;
      for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }

      if (var2 != jI) {
         for(int var3 = var2; var3 < var2 + var1; ++var3) {
            ki[var3] = var0;
            jK[var3] = 15;
            ke[var3] = 36;
            kf[var3] = 10;
            jN[var3] = 27;
            jO[var3] = 15;
            jZ[var3] = 1;
            jQ[var3] = 5;
            jV[var3] = var3 << 1;
            ka[var3] = kb[var3] = MonsterData.HP[jK[var3]];
            kc[var3] = MonsterData.DAMAGE[jK[var3]];
            kh[var3] = MonsterData.HIT_STAT[jK[var3]];
            kd[var3] = 0;
         }

      }
   }

   private static void u(int var0, int var1) {
      int var2;
      for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }

      if (var2 != jI) {
         for(int var3 = var2; var3 < var2 + var1; ++var3) {
            ki[var3] = var0;
            jK[var3] = 1;
            ke[var3] = 7;
            kf[var3] = 10;
            jN[var3] = 16;
            jO[var3] = 15;
            jZ[var3] = 1;
            jQ[var3] = 5;
            jV[var3] = var3 << 3;
            ka[var3] = kb[var3] = MonsterData.HP[jK[var3]];
            kc[var3] = MonsterData.DAMAGE[jK[var3]];
            kh[var3] = MonsterData.HIT_STAT[jK[var3]];
            kd[var3] = 100;
         }

      }
   }

   private static void v(int var0, int var1) {
      int var2;
      for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }

      if (var2 != jI) {
         for(int var3 = var2; var3 < var2 + var1; ++var3) {
            ki[var3] = var0;
            jK[var3] = 18;
            ke[var3] = 120;
            kf[var3] = 10;
            jN[var3] = 24;
            jO[var3] = 20;
            jZ[var3] = 1;
            jQ[var3] = 5;
            jV[var3] = 60;
            ka[var3] = kb[var3] = MonsterData.HP[jK[var3]];
            kc[var3] = MonsterData.DAMAGE[jK[var3]];
            kh[var3] = MonsterData.HIT_STAT[jK[var3]];
            kd[var3] = 100;
         }

      }
   }

   private static void w(int var0, int var1) {
      for(var0 = 0; var0 < jI && jK[var0] != -1; ++var0) {
      }

      if (var0 != jI) {
         for(int var2 = var0; var2 < var0 + var1; ++var2) {
            ki[var2] = 0;
            jK[var2] = 19;
            ke[var2] = 60;
            kf[var2] = 30;
            jN[var2] = 24;
            jO[var2] = 20;
            jZ[var2] = 1;
            jQ[var2] = 5;
            jV[var2] = 62;
            ka[var2] = kb[var2] = MonsterData.HP[jK[var2]];
            kc[var2] = MonsterData.DAMAGE[jK[var2]];
            kh[var2] = MonsterData.HIT_STAT[jK[var2]];
            kd[var2] = 70;
         }

      }
   }

   private static void x(int var0, int var1) {
      int var2;
      for(var2 = 0; var2 < jI && jK[var2] != -1; ++var2) {
      }

      if (var2 != jI) {
         for(int var3 = var2; var3 < var2 + var1; ++var3) {
            ki[var3] = var0;
            jK[var3] = 17;
            ke[var3] = 60;
            kf[var3] = 10;
            jN[var3] = 22;
            jO[var3] = 22;
            jZ[var3] = 1;
            jQ[var3] = 5;
            jV[var3] = 50 + (var3 << 1);
            ka[var3] = kb[var3] = MonsterData.HP[jK[var3]];
            kc[var3] = MonsterData.DAMAGE[jK[var3]];
            kh[var3] = MonsterData.HIT_STAT[jK[var3]];
            kd[var3] = 500;
         }

      }
   }

   private static void y(int var0, int var1) {
      for(var0 = 0; var0 < jI && jK[var0] != -1; ++var0) {
      }

      if (var0 != jI) {
         for(int var2 = var0; var2 < var0 + var1; ++var2) {
            ki[var2] = 0;
            jK[var2] = 12;
            ke[var2] = 24;
            kf[var2] = 10;
            jN[var2] = 16;
            jO[var2] = 22;
            jZ[var2] = 1;
            jQ[var2] = 5;
            jV[var2] = 70;
            ka[var2] = kb[var2] = MonsterData.HP[jK[var2]];
            kc[var2] = MonsterData.DAMAGE[jK[var2]];
            kh[var2] = MonsterData.HIT_STAT[jK[var2]];
            kd[var2] = 500;
         }

      }
   }

   private static void az() {
      for(int var0 = 0; var0 < kn.length; ++var0) {
         km[var0] = new boolean[kk[var0].length];
      }

      for(int var2 = 0; var2 < kk.length; ++var2) {
         for(int var1 = 0; var1 < kk[var2].length; ++var1) {
            kk[var2][var1] = kk[var2][var1] * jf + 12;
            kl[var2][var1] *= jf;
            if (var2 == 8) {
               int[] var10000 = kl[var2];
               var10000[var1] -= 12;
            }
         }
      }

   }

   private static void N(int var0) {
      if (jL[var0] < playerX) {
         jT[var0] = mapSubIdLegacy % 3 + 3;
         jZ[var0] = 1;
      } else if (jL[var0] > playerX) {
         jT[var0] = -mapSubIdLegacy % 3 - 3;
         jZ[var0] = -1;
      }

      if (jM[var0] < playerY) {
         jU[var0] = mapSubIdLegacy % 3 + 3;
      } else if (jM[var0] > playerY) {
         jU[var0] = -mapSubIdLegacy % 3 - 3;
      }

      int[] var10000 = jL;
      var10000[var0] += jT[var0];
      var10000 = jM;
      var10000[var0] += jU[var0];
      int var10002 = jY[var0]++;
      if (jY[var0] > 1) {
         jY[var0] = 0;
      }

      if (a(jL[var0] - playerX) < 10 && a(jM[var0] - playerY) < 10) {
         kd[var0] = 0;
         if (kj[var0]) {
            kj[var0] = false;
            b(kc[var0], jZ[var0]);
         } else {
            a(kc[var0], jZ[var0]);
         }

         jV[var0] = 0;
         jQ[var0] = 2;
      }

      if (a(jL[var0] - playerX) > 160 || a(jM[var0] - playerY) > 160) {
         jQ[var0] = 2;
         jV[var0] = 0;
         jT[var0] = jU[var0] = 0;
         kd[var0] = 0;
      }

   }

   private static void O(int var0) {
      int var10002 = jV[var0]++;
      int[] var10000 = jL;
      var10000[var0] -= jT[var0];
      var10000 = jM;
      var10000[var0] -= jU[var0];
      if (jT[var0] == 0) {
         jT[var0] = 2;
      }

      if (jU[var0] == 0) {
         jU[var0] = 2;
      }

      if (jV[var0] == 5) {
         jQ[var0] = 2;
         jV[var0] = 0;
         jT[var0] = jU[var0] = 0;
         kd[var0] = 0;
      }

   }

   private static void P(int var0) {
      int[] var10000 = jL;
      var10000[var0] += jT[var0];
      var10000 = jM;
      var10000[var0] += jU[var0];
      if (jL[var0] - jR[var0] > 40) {
         jT[var0] = -(mapSubIdLegacy % 2 + 1);
      }

      if (jL[var0] - jR[var0] < -40) {
         jT[var0] = mapSubIdLegacy % 2 + 1;
      }

      if (jM[var0] - jS[var0] > 40) {
         jU[var0] = -(mapSubIdLegacy % 2 + 1);
      }

      if (jM[var0] - jS[var0] < -40) {
         jU[var0] = mapSubIdLegacy % 2 + 1;
      }

      if (mapSubIdLegacy % 15 == 0) {
         jT[var0] = mapSubIdLegacy % 3 - 1;
         jU[var0] = (mapSubIdLegacy >> 1) % 3 - 1;
      }

      int var10002 = jY[var0]++;
      if (jY[var0] > 1) {
         jY[var0] = 0;
      }

      J(var0);
      if (mapSubIdLegacy % 5 == 0) {
         K(var0);
      }

   }

   private static void Q(int var0) {
      if (mapSubIdLegacy % 4 == 1) {
         int var10002 = jY[var0]++;
         if (jY[var0] > 1) {
            jY[var0] = 0;
         }

         int[] var10000 = jL;
         var10000[var0] += jZ[var0] << 1;
         if (jL[var0] > jS[var0]) {
            jZ[var0] = -1;
         } else if (jL[var0] < jR[var0]) {
            jZ[var0] = 1;
         }
      }

      J(var0);
   }

   private static void R(int var0) {
      a(kc[var0], -playerFacing);
      jQ[var0] = 2;
      jV[var0] = 0;
      jY[var0] = 2;
   }

   private static void S(int var0) {
      int var10002 = jV[var0]++;
      int[] var10000 = jL;
      var10000[var0] -= jZ[var0];
      if (jV[var0] == 5) {
         jQ[var0] = 2;
      }

   }

   private static void T(int var0) {
      int var10002 = jV[var0]++;
      int[] var10000 = jL;
      var10000[var0] -= jZ[var0];
      if (jV[var0] == 3) {
         jQ[var0] = 2;
      }

   }

   private static void U(int var0) {
      if (mapSubIdLegacy % 4 == 0) {
         int var10002 = jY[var0]++;
         if (jY[var0] > 1) {
            jY[var0] = 0;
         }

         int[] var10000 = jL;
         var10000[var0] += jZ[var0];
      }

      if (jL[var0] > jS[var0]) {
         jZ[var0] = -1;
      } else if (jL[var0] < jR[var0]) {
         jZ[var0] = 1;
      }

      J(var0);
      if (mapSubIdLegacy % 5 == 0) {
         K(var0);
      }

   }

   private static void aA() {
      U = bE - 40;
      kp = bD - 50;
      iU = null;
      ky = new Image[4];

      try {
         ky[0] = Image.createImage("/u/wpt0.png");
         ky[1] = Image.createImage("/u/wpt2.png");
         ky[2] = Image.createImage("/u/wpt3.png");
         ky[3] = Image.createImage("/u/wpt4.png");
      } catch (Exception var3) {
      }

      if (kI == null) {
         kI = new Image[4];

         for(int var0 = 0; var0 < 4; ++var0) {
            try {
               kI[var0] = Image.createImage("/u/bd" + var0 + ".png");
            } catch (IOException var2) {
               ((Throwable)var2).printStackTrace();
            }
         }
      }

      System.gc();
   }

   private static void m(Graphics var0) {
      var0.translate(-var0.getTranslateX(), -var0.getTranslateY());
      d(var0);
      c(var0);
      var0.setClip(0, 0, aU, aV);
      var0.setColor(0);
      var0.fillRect(bD - 64, U - 19, 129, 102);
      var0.fillRect(0, aV - 13, aU, 13);
      Midlet.a(var0, "Mua", 3, aV - 13, 0);
      Midlet.a(var0, "Quay lại", aU - 3, aV - 13, 1);
      var0.setColor(12281361);
      var0.drawRect(bD - 63, U - 18, 126, 99);
      var0.setColor(6562304);
      var0.fillRect(bD - 61, U - 16, 123, 97);
      if (kt == 0) {
         Midlet.a(var0, "Tiền: " + gold + "$", bD, U - 8, 2);
      } else {
         Midlet.a(var0, kv[ks][kq], bD, U - 8, 2);
      }

      for(int var1 = 0; var1 < 3; ++var1) {
         var0.setColor(0);
         var0.fillRect(kp - 10 + var1 * 20, U + 10, 19, 20);
         var0.fillRect(kp + 50 + var1 * 20, U + 10, 19, 20);
         var0.setColor(4856064);
         var0.drawRect(kp - 10 + var1 * 20, U + 10, 20, 20);
         var0.drawRect(kp + 50 + var1 * 20, U + 10, 20, 20);
         var0.drawRegion(ex[0], 0, var1 * 15, 13, 15, 0, kp + var1 * 20, U + 20, 3);
         var0.drawRegion(ex[1], 0, var1 * 15, 13, 15, 0, kp + 60 + var1 * 20, U + 20, 3);
      }

      for(int var2 = 0; var2 < 4; ++var2) {
         var0.setColor(0);
         var0.fillRect(kp + 10 + var2 * 20, U + 32, 19, 20);
         var0.setColor(4856064);
         var0.drawRect(kp + 10 + var2 * 20, U + 32, 18, 20);
         var0.drawImage(ky[var2], kp + 20 + var2 * 20, U + 42, 3);
      }

      var0.setColor(ku[kr]);
      if (ks == 0) {
         var0.drawRect(kp - 10 + kq * 20, U + 10, 19, 20);
      } else {
         var0.drawRect(kp + 10 + kq * 20, U + 32, 19, 20);
      }

      if (kt == 0) {
         Midlet.a(var0, kv[ks][kq] + "-" + kx[ks][kq] + "$", bD, U + 58, 2);
      } else {
         Midlet.a(var0, kw[ks][kq], bD, U + 58, 2);
      }

      var0.drawImage(kI[0], bD - 64, U - 19, 20);
      var0.drawImage(kI[1], bD + 65, U - 19, 24);
      var0.drawImage(kI[2], bD - 64, U + 83, 36);
      var0.drawImage(kI[3], bD + 65, U + 83, 40);
   }

   private static void aB() {
      if (aN) {
         aN = false;
         if (aP > aV - 40) {
            if (aO < aW) {
               aT[12] = true;
            } else {
               aT[13] = true;
            }
         }

         if (aP > U && aP < U + 32) {
            ks = 0;
            kq = 0;

            for(int var1 = 0; var1 < 6; ++var1) {
               if (aO > kp - 10 + var1 * 20 && aO < kp - 10 + var1 * 20 + 20) {
                  kq = var1;
               }
            }
         } else if (aP < U + 60) {
            ks = 1;
            kq = 0;

            for(int var0 = 0; var0 < 4; ++var0) {
               if (aO > kp + 10 + var0 * 20 && aO < kp + 10 + var0 * 20 + 20) {
                  kq = var0;
               }
            }
         }
      }

      if (kr > 0) {
         --kr;
      }

      if (aT[5] || aT[12]) {
         d();
         if (ks == 0) {
            if (kt == 0) {
               if (kq < 3) {
                  if (inventoryCounts[0] + inventoryCounts[1] + inventoryCounts[2] > 99) {
                     return;
                  }
               } else if (inventoryCounts[3] + inventoryCounts[4] + inventoryCounts[5] > 99) {
                  return;
               }

               if (gold >= kx[ks][kq]) {
                  int var10002 = inventoryCounts[kq]++;
                  gold -= kx[ks][kq];
               }
            } else {
               a("TEAM BUY 009007 " + kz[ks][kq], kA[ks][kq], kq + 1);
            }
         } else {
            if (equippedWeaponIndex >= kq) {
               s(7);
               a("Không cần thiết phải mua vũ khí này vì vũ khí đang sử dụng mạnh hơn!");
               X = U;
               d = 7;
               return;
            }

            if (level < ko[kq]) {
               s(7);
               a("Bạn phải đạt cấp độ " + ko[kq] + " mới có thể mua vũ khí này!");
               X = U;
               d = 7;
               return;
            }

            if (kt == 0) {
               if (gold >= kx[ks][kq]) {
                  gold -= kx[ks][kq];
                  equippedWeaponIndex = kq;
                  t();
                  return;
               }

               s(7);
               a("Không có đủ tiền: " + kx[ks][kq] + "$. Bạn chỉ có: " + gold + "$. Hãy đi tìm thêm.");
               X = U;
               d = 7;
               return;
            }

            a("TEAM BUY 009007 " + kz[ks][kq], kA[ks][kq], kq + 6);
         }
      }

      if (aT[13]) {
         kI = null;
         ky = null;
         System.gc();
         au();
         d();
         c();
         d = 1;
         c = true;
      } else {
         if (aT[2]) {
            d();
            if (ks == 1) {
               ks = 0;
               ++kq;
            }
         }

         if (aT[8]) {
            d();
            if (ks == 0) {
               ks = 1;
               if (--kq < 0) {
                  kq = 0;
               }

               if (kq > 3) {
                  kq = 3;
               }
            }
         }

         if (aT[4]) {
            d();
            if (--kq < 0) {
               if (ks == 0) {
                  kq = 5;
               } else {
                  kq = 3;
               }
            }
         }

         if (aT[6]) {
            d();
            ++kq;
            if (ks == 0 && kq == 6) {
               kq = 0;
            }

            if (ks == 1 && kq == 4) {
               kq = 0;
            }
         }

      }
   }

   /**
    * Phương thức vẽ giao diện danh sách sử dụng item.
    * @param var0 Graphics: đối tượng để vẽ lên màn hình.
    */
   private static int invQtyAt(int var0) {
      return var0 < 6 ? inventoryCounts[var0] : kBagExt[var0 - 6];
   }

   private static void invUseAt(int var0) {
      if (var0 < 6) {
         inventoryCounts[var0]--;
      } else {
         kBagExt[var0 - 6]--;
      }
   }

   private static void n(Graphics var0) {
      final int invSlots = 12;
      final int invRowH = 22;
      var0.translate(-var0.getTranslateX(), -var0.getTranslateY());
      d(var0);
      c(var0);
      var0.setClip(0, 0, aU, aV);
      var0.setColor(0);
      var0.fillRect(bD - 64, kB - 19, 129, 124);
      var0.fillRect(0, aV - 13, aU, 13);
      Midlet.a(var0, "Sử dụng", 3, aV - 13, 0);
      Midlet.a(var0, "Quay lại", aU - 3, aV - 13, 1);
      var0.setColor(12281361);
      var0.drawRect(bD - 63, kB - 18, 126, 121);
      var0.setColor(6562304);
      var0.fillRect(bD - 61, kB - 16, 123, 119);
      Midlet.a(var0, "Sử dụng Item", bD, kB - 8, 2);

      for(int var2 = 0; var2 < 2; ++var2) {
         int var3 = kB + 10 + var2 * invRowH;
         int var4 = var3 + 10;

         for(int var1 = 0; var1 < 3; ++var1) {
            int var5 = kC - 10 + var1 * 20;
            int var6 = kC + 50 + var1 * 20;
            int var7 = var2 * 6 + var1;
            int var8 = var7 + 3;
            var0.setColor(0);
            var0.fillRect(var5, var3, 19, 20);
            var0.fillRect(var6, var3, 19, 20);
            var0.setColor(4856064);
            var0.drawRect(var5, var3, 20, 20);
            var0.drawRect(var6, var3, 20, 20);
            if (var7 < invSlots && invQtyAt(var7) > 0 && ex != null) {
               var0.drawRegion(ex[0], 0, (var7 % 3) * 15, 13, 15, 0, var5 + 10, var4, 3);
            }

            if (var8 < invSlots && invQtyAt(var8) > 0 && ex != null && ex.length > 1) {
               var0.drawRegion(ex[1], 0, (var8 % 3) * 15, 13, 15, 0, var6 + 10, var4, 3);
            }
         }
      } 

      if (kD >= 0 && kD < invSlots) {
         int var9 = kD / 6;
         int var10 = kD % 6;
         var0.setColor(kF[kE]);
         var0.drawRect(kC - 10 + var10 * 20, kB + 10 + var9 * invRowH, 20, 20);
 

         Midlet.a(var0, kG[kD], bD, kB + 58, 2);
         Midlet.a(var0, "Số lượng: " + invQtyAt(kD), bD, kB + 73, 2);
         Midlet.a(var0, "Tấn công: " + atk, bD, kB + 88, 2);
      }

      var0.drawImage(kI[0], bD - 64, kB - 19, 20);
      var0.drawImage(kI[1], bD + 65, kB - 19, 24);
      var0.drawImage(kI[2], bD - 64, kB + 105, 36);
      var0.drawImage(kI[3], bD + 65, kB + 105, 40);
   }

   private static void aC() {
      if (aN) {
         aN = false;
         if (aP > aV - 40) {
            if (aO < aW) {
               aT[12] = true;
            } else {
               aT[13] = true;
            }
         }

         if (aP > kB - 20 && aP < kB + 76) {
            for(int var0 = 0; var0 < 12; ++var0) {
               int var1 = var0 / 6;
               int var2 = var0 % 6;
               int var3 = kC - 10 + var2 * 20;
               int var4 = kB + 10 + var1 * 22;
               if (aO > var3 && aO < var3 + 20 && aP > var4 && aP < var4 + 20) {
                  kD = var0;
               }
            }
         }
      }

      if (kE > 0) {
         --kE;
      }

      if (aT[5] || aT[12]) {
         if (kD >= 0 && kD < 12 && invQtyAt(kD) > 0) {
            invUseAt(kD);
            kE = kF.length - 1;
            if (kD % 6 <= 2) {
               if (hp < hpMax) {
                  hp += kH[kD % 6];
               }

               if (hp > hpMax) {
                  hp = hpMax;
               }
            } else {
               if (mp < mpMax) {
                  mp += kH[kD % 6];
               }

               if (mp > mpMax) {
                  mp = mpMax;
               }
            }
         }

         d();
      }

      if (aT[13]) {
         d();
         c();
         d = 5;
      } else {
         if (aT[4]) {
            d();
            if (--kD < 0) {
               kD = 11;
            }
         }

         if (aT[6]) {
            d();
            if (++kD == 12) {
               kD = 0;
            }
         }

      }
   }

   private static void aD() {
      kJ = bE - 40;
      iU = null;
      if (kI == null) {
         kI = new Image[4];

         for(int var0 = 0; var0 < 4; ++var0) {
            try {
               kI[var0] = Image.createImage("/u/bd" + var0 + ".png");
            } catch (IOException var2) {
               ((Throwable)var2).printStackTrace();
            }
         }
      }

   }

   private static void o(Graphics var0) {
      var0.translate(-var0.getTranslateX(), -var0.getTranslateY());
      var0.setColor(0);
      var0.fillRect(bD - 64, kJ - 19, 129, 102);
      var0.fillRect(0, aV - 13, aU, 13);
      Midlet.a(var0, "Chọn", 3, aV - 13, 0);
      Midlet.a(var0, "Quay lại", aU - 3, aV - 13, 1);
      var0.setColor(12281361);
      var0.drawRect(bD - 63, kJ - 18, 126, 99);
      var0.setColor(6562304);
      var0.fillRect(bD - 61, kJ - 16, 123, 97);

      for(int var1 = 0; var1 < 4; ++var1) {
         Midlet.a(var0, kM[var1], aW - 30, kJ + var1 * 18, 0);
      }

      var0.drawImage(eD[0], aW - 55 + kL % 2, kJ + kK * 18 - kL % 2, 0);
      var0.drawImage(kI[0], bD - 64, kJ - 19, 20);
      var0.drawImage(kI[1], bD + 65, kJ - 19, 24);
      var0.drawImage(kI[2], bD - 64, kJ + 83, 36);
      var0.drawImage(kI[3], bD + 65, kJ + 83, 40);
   }

   private static void aE() {
      if (aN) {
         aN = false;
         if (aP > aV - 40) {
            if (aO < aW) {
               aT[12] = true;
            } else {
               aT[13] = true;
            }
         }

         for(int var0 = 0; var0 < 4; ++var0) {
            if (aP > kJ + var0 * 18 - 4 && aP < kJ + var0 * 18 + 14) {
               kK = var0;
            }
         }
      }

      if (++kL > 10000) {
         kL = 0;
      }

      boolean var5 = false;
      if (aT[13]) {
         var5 = true;
         kI = null;
         au();
         d = 1;
         c = true;
      } else if (!aT[5] && !aT[12]) {
         if (aT[8]) {
            var5 = true;
            if (++kK > 3) {
               kK = 0;
            }
         } else if (aT[2]) {
            var5 = true;
            if (--kK < 0) {
               kK = 3;
            }
         } else if (aT[4]) {
            var5 = true;
         } else if (aT[6]) {
            var5 = true;
         }
      } else {
         var5 = true;
         if (kK == 0) {
            kB = bE - 40;
            kC = bD - 50;
            if (kI == null) {
               kI = new Image[4];

               for(int var1 = 0; var1 < 4; ++var1) {
                  try {
                     kI[var1] = Image.createImage("/u/bd" + var1 + ".png");
                  } catch (IOException var4) {
                     ((Throwable)var4).printStackTrace();
                  }
               }
            }

            d = 8;
         }

         if (kK == 1) {
            lh = 280 - q;
            li = 280 - r;
            kX = 0;

            try {
               kT = Image.createImage("/wm.png");
               kU = Image.createImage("/u/x.png");
            } catch (Exception var3) {
            }

            lj = mapId;
            if (mapId == 99) {
               lj = 0;
            }

            if (mapId == 97) {
               lj = 7;
            }

            if (mapId == 96) {
               lj = 11;
            }

            if (mapId == 95) {
               lj = 18;
            }

            kV = kP[lj];
            kW = kQ[lj];
            aG();
            kZ = kV - bD;
            la = kW - bE;
            if (lf < -40) {
               lf = -40;
            }

            if (lf > lh) {
               lf = lh;
            }

            if (lg < -40) {
               lg = -40;
            }

            if (lg > li) {
               lg = li;
            }

            d = 6;
         }

         if (kK == 2) {
            if (playerState != 1) {
               kI = null;
               au();
               aI();
               s(5);
               a("Bạn chỉ có thể lưu và thoát khi nhân vật đang đứng yên.");
               X = bE - 40;
               d = 7;
            } else {
               aM = false;
            }
         }
      }

      if (var5) {
         d();
      }

   }

   private static void aF() {
      kT = null;
      kU = null;
      System.gc();
   }

   private static void p(Graphics var0) {
      var0.translate(-var0.getTranslateX(), -var0.getTranslateY());
      var0.setColor(0);
      var0.fillRect(0, 0, q, r);
      var0.fillRect(0, aV - 13, aU, 13);
      Midlet.a(var0, lk, 3, aV - 13, 0);
      Midlet.a(var0, "Quay lại", aU - 3, aV - 13, 1);
      var0.setClip(0, 0, q, r);
      var0.translate(-lf, -lg);
      var0.drawImage(kT, 0, 0, 0);

      for(int var1 = 0; var1 < 19; ++var1) {
         if (var1 == lj) {
            var0.drawImage(ep[0], kP[var1] + 10, kQ[var1], 3);
         }

         if (mapUnlockFlags[var1] && (var1 != kX || kY % 10 > 5)) {
            var0.drawImage(kU, kP[var1], kQ[var1], 3);
         }
      }

      var0.drawImage(eD[0], kV, kW, 24);
      if (kX != -1) {
         var0.translate(-var0.getTranslateX(), -var0.getTranslateY());
         var0.setColor(6562304);
         var0.fillRect(aW - 60, r - 35, 120, 33);
         var0.setColor(12281361);
         var0.drawRect(aW - 59, r - 34, 117, 30);
         Midlet.a(var0, kN[kX], aW, r - 25, 2);
         var0.drawImage(kI[0], aW - 60, r - 35, 20);
         var0.drawImage(kI[1], aW + 60, r - 35, 24);
         var0.drawImage(kI[2], aW - 60, r - 2, 36);
         var0.drawImage(kI[3], aW + 60, r - 2, 40);
      }

   }

   private static void aG() {
      kX = -1;
      lk = "";

      for(int var0 = 0; var0 < 19; ++var0) {
         if (a(kV - kP[var0]) < 8 && a(kW - kQ[var0]) < 8) {
            kX = var0;
            lk = "Chuyển đến";
            return;
         }
      }

   }

   private static void aH() {
      try {
         ll = Image.createImage("/u/m.png");
      } catch (Exception var0) {
      }
   }

   public static void a(String var0) {
      lt = Midlet.a(var0, 100);
      X = bE - lt.length * 9;
   }

   public static void s(int var0) {
      aI();
      lo = var0;
      if (var0 == 1) {
         a("Không thể chuyển. Vì bạn chưa từng đi bộ đến đây!");
         lr = "OK";
         ls = "";
      } else if (var0 == 3) {
         a("Không cần phải chuyển vì bạn đang ở vị trí này!");
         lr = "OK";
         ls = "";
      } else if (var0 != 2) {
         if (var0 == 4) {
            a("Bạn không có đủ tiền!");
            lr = "OK";
            ls = "";
         } else if (var0 == 5) {
            a("Bạn đã bị trọng thương! Mất một số điểm kinh nghiệm!");
            lr = "OK";
            ls = "";
         } else if (var0 == 6) {
            a("Level up!");
            lr = "OK";
            ls = "";
         } else {
            if (var0 == 7) {
               a("Buy OK!");
               lr = "";
               ls = "OK";
            }

         }
      } else {
         var0 = lj < kX ? lj : kX;
         int var1 = lj > kX ? lj : kX;
         int var2 = 0;

         for(int var4 = var0; var4 <= var1; ++var4) {
            var2 += kO[var4];
         }

         int var5;
         lp = var5 = (var2 << 1) / 3;
         a("Chuyển đến đây phải trả " + var5 + "$. Bạn có " + gold + "$. Chuyển?");
         lr = "Chuyển";
         ls = "Không";
      }
   }

   private static void aI() {
      lq = 0;
      if (kI == null) {
         kI = new Image[4];

         for(int var0 = 0; var0 < 4; ++var0) {
            try {
               kI[var0] = Image.createImage("/u/bd" + var0 + ".png");
            } catch (IOException var2) {
               ((Throwable)var2).printStackTrace();
            }
         }
      }

   }

   private static void q(Graphics var0) {
      var0.translate(-var0.getTranslateX(), -var0.getTranslateY());
      var0.setColor(0);
      var0.fillRect(bD - 64, X - 19, 129, 102);
      var0.fillRect(0, aV - 13, aU, 13);
      Midlet.a(var0, lr, 3, aV - 13, 0);
      Midlet.a(var0, ls, aU - 3, aV - 13, 1);
      var0.setColor(12281361);
      var0.drawRect(bD - 63, X - 18, 126, 99);
      var0.setColor(6562304);
      var0.fillRect(bD - 61, X - 16, 123, 97);

      for(int var1 = 0; var1 < lt.length; ++var1) {
         Midlet.a(var0, lt[var1], aW, X + var1 * 18, 2);
      }

      var0.drawImage(kI[0], bD - 64, X - 19, 20);
      var0.drawImage(kI[1], bD + 65, X - 19, 24);
      var0.drawImage(kI[2], bD - 64, X + 83, 36);
      var0.drawImage(kI[3], bD + 65, X + 83, 40);
   }

   private static void V(int var0) {
      lI = mapId;
      lL = var0;
      lJ = lw[var0];
      lK = lx[var0] - 44;
   }

   public static void t(int var0) {
      lv = 0;
      if (var0 == 0) {
         lu = new Image[6][2];

         try {
            lu[0][0] = Image.createImage("/npc/00.png");
            lu[0][1] = Image.createImage("/npc/01.png");
            lu[1][0] = Image.createImage("/npc/10.png");
            lu[1][1] = Image.createImage("/npc/11.png");
            lu[2][0] = Image.createImage("/npc/20.png");
            lu[2][1] = Image.createImage("/npc/21.png");
            lu[3][0] = Image.createImage("/npc/30.png");
            lu[3][1] = Image.createImage("/npc/31.png");
            lu[4][0] = Image.createImage("/npc/40.png");
            lu[4][1] = Image.createImage("/npc/41.png");
            lu[5][0] = Image.createImage("/npc/50.png");
            lu[5][1] = Image.createImage("/npc/51.png");
         } catch (Exception var7) {
         }

         lv = 7;
         aJ();
         c(0, 0, 34, 13);
         c(1, 1, 43, 17);
         c(2, 2, 50, 17);
         c(3, 3, 57, 12);
         c(4, 4, 43, 12);
         c(5, 5, 77, 15);
         c(6, 5, 25, 17);
      }

      if (var0 == 1) {
         lu = new Image[6][2];

         try {
            lu[5][0] = Image.createImage("/npc/50.png");
            lu[5][1] = Image.createImage("/npc/51.png");
         } catch (Exception var6) {
         }

         lv = 1;
         aJ();
         c(0, 5, 54, 9);
      }

      if (var0 == 2) {
         lu = new Image[6][2];

         try {
            lu[5][0] = Image.createImage("/npc/50.png");
            lu[5][1] = Image.createImage("/npc/51.png");
         } catch (Exception var5) {
         }

         lv = 1;
         aJ();
         c(0, 5, 23, 12);
      }

      if (var0 == 5) {
         lu = new Image[6][2];

         try {
            lu[5][0] = Image.createImage("/npc/50.png");
            lu[5][1] = Image.createImage("/npc/51.png");
         } catch (Exception var4) {
         }

         lv = 1;
         aJ();
         c(0, 5, 12, 5);
      }

      if (var0 == 6) {
         lu = new Image[6][2];

         try {
            lu[5][0] = Image.createImage("/npc/50.png");
            lu[5][1] = Image.createImage("/npc/51.png");
         } catch (Exception var3) {
         }

         lv = 1;
         aJ();
         c(0, 5, 14, 9);
      }

      if (var0 == 99 || var0 == 101) {
         lu = new Image[6][2];

         try {
            lu[4][0] = Image.createImage("/npc/40.png");
            lu[4][1] = Image.createImage("/npc/41.png");
         } catch (Exception var2) {
         }

         lv = 1;
         aJ();
         c(0, 4, 3, 12);
      }

      if (var0 == 94) {
         lu = new Image[6][2];

         try {
            lu[0][0] = Image.createImage("/npc/00.png");
            lu[0][1] = Image.createImage("/npc/01.png");
            lu[4][0] = Image.createImage("/npc/40.png");
            lu[4][1] = Image.createImage("/npc/41.png");
            lu[2][0] = Image.createImage("/npc/20.png");
            lu[2][1] = Image.createImage("/npc/21.png");
         } catch (Exception var1) {
         }

         lv = 3;
         aJ();
         c(0, 4, 2, 10);
         c(1, 0, 3, 10);
         c(2, 2, 4, 10);
      }

   }

   private static void c(int var0, int var1, int var2, int var3) {
      ly[var0] = var1;
      lw[var0] = var2 * jf + 12;
      lx[var0] = var3 * jf;
   }

   private static void aJ() {
      lw = new int[lv];
      lx = new int[lv];
      ly = new int[lv];
   }

   private static void r(Graphics var0) {
      for(int var1 = 0; var1 < lv; ++var1) {
         if (lw[var1] + 10 >= cutsceneP && lw[var1] - 10 <= cutsceneP + q && lx[var1] >= cutsceneQ && lx[var1] - 32 <= cutsceneQ + r) {
            var0.drawImage(lu[ly[var1]][1], lw[var1], lx[var1], 33);
            var0.drawImage(lu[ly[var1]][0], lw[var1], lx[var1] - lH[ly[var1]] + (mapSubIdLegacy % (15 + ly[var1]) > 4 ? 0 : 1), 33);
         }
      }

   }

   private static void aK() {
      if (aT[12]) {
         Midlet.c.exit("aK key12");
      }

      Y(1);
      int var10002 = lX[0]++;
   }

   private void aL() {
      if (aT[2]) {
         --this.md;
         if (this.md < 0) {
            this.md = 1;
         }

         d();
      }

      if (aT[8]) {
         ++this.md;
         if (this.md > 1) {
            this.md = 0;
         }

         d();
      }

      if (aT[4]) {
         --this.mc;
         if (this.mc < 0) {
            this.mc = 4;
         }

         d();
      }

      if (aT[6]) {
         ++this.mc;
         if (this.mc > 4) {
            this.mc = 0;
         }

         d();
      }

      if (aT[5]) {
         this.aP();
         d();
      }

      if (aT[12]) {
         int var1 = "TEAM".length() + 5;
         lX[5] = Integer.parseInt(lW.substring(var1++, var1));
         lX[6] = Integer.parseInt(lW.substring(var1++, var1));
         lX[7] = Integer.parseInt(lW.substring(var1++, var1));
         lX[8] = Integer.parseInt(lW.substring(var1++, var1));
         a var8 = this;
         if (this.mb.length() < 4) {
            Y = 0;
         } else {
            lX[1] = Integer.parseInt(this.mb.substring(0, 1));
            lX[2] = Integer.parseInt(this.mb.substring(1, 2));
            lX[3] = Integer.parseInt(this.mb.substring(2, 3));
            lX[4] = Integer.parseInt(this.mb.substring(3, 4));
            lX[8] = (lX[8] + lX[7]) % 10;
            lX[7] = (lX[7] + lX[6]) % 10;
            lX[6] = (lX[6] + lX[5]) % 10;
            lX[5] = (lX[5] + lX[8]) % 10;

            for(int var2 = 1; var2 < 8; ++var2) {
               if (lX[var2 - 1] != lX[var2]) {
                  var8.aN();
               } else if (lX[var2] != lX[var2] + 1) {
                  var8.aO();
               } else {
                  d();
                  var8.aR();
                  var8.aO();
                  aK();
                  d();
               }
            }
         }

         d();
      }

      if (aT[13]) {
         this.aM();
         d();
      }

      if (aN) {
         for(int var9 = 0; var9 < 2; ++var9) {
            for(int var10 = 0; var10 < 5; ++var10) {
               if (aO > var10 * 20 + aW - 50 && aO < var10 * 20 + aW - 50 + 20 && aP > var9 * 25 + aX && aP < var9 * 25 + aX + 25) {
                  this.mc = var10;
                  this.md = var9;
                  this.aP();
                  aN = false;
               }
            }
         }
      }

   }

   private void aM() {
      if (this.mb.length() != 0) {
         this.mb = this.mb.substring(0, this.mb.length() - 1);
      }

   }

   private void aN() {
      d();
      Y = 0;
      aQ();
      d();
   }

   private void aO() {
      d();
      this.aR();
      Y = 4;
      this.aN();
      d();
   }

   private void aP() {
      if (this.mb.length() < 4) {
         this.mb = this.mb + (this.md * 5 + this.mc);
      }

   }

   private static void aQ() {
      if (aT[5] || aT[12]) {
         d();
         Y = 0;
      }

   }

   private void aR() {
      if (aT[5] || aT[12]) {
         String var1;
         if ((var1 = aU()) == null || var1.equals("")) {
            g(var1 = "TEAM PAY " + (System.currentTimeMillis() % 8000L + 1000L) + "009" + "007");
         }

         Y = 1;
         a(var1, "sms://8722", 0);
         d();
      }

      if (aT[13]) {
         Y = 0;
         d();
      }

   }

   private void aS() {
      if (aT[2]) {
         --this.lZ;
         if (this.lZ < 0) {
            this.lZ = lY == 0 ? 1 : 2;
         }

         d();
      }

      if (aT[8]) {
         ++this.lZ;
         if (this.lZ > (lY == 0 ? 1 : 2)) {
            this.lZ = 0;
         }

         d();
      }

      if (aT[5] || aT[12]) {
         this.aT();
         d();
      }

      if (aT[13]) {
         Midlet.c.exit("settings aT key13");
         }

      if (aN) {
         for(int var1 = 0; var1 < (lY == 0 ? 2 : 3); ++var1) {
            if (aP > aX - 5 + var1 * lT && aP < aX - 5 + var1 * lT + lT) {
               if (this.lZ != var1) {
                  this.lZ = var1;
               } else {
                  this.aT();
               }

               aN = false;
               return;
            }
         }
      }

   }

   private void aT() {
      if (this.lZ == 0 && lY > 0) {
         W(--lY);
         d = 4;
         av();
         System.gc();
      }

      if (this.lZ == 1 && lY > 0 || this.lZ == 0 && lY == 0) {
         Y = 2;
      }

      if (this.lZ == 2 && lY > 0 || this.lZ == 1 && lY == 0) {
         lW = aU();
         Y = 4;
      }

   }

   private void s(Graphics var1) {
      var1.setColor(7171437);
      var1.drawString("Nhap ma kich hoat:", aW, aX - 60, 17);
      var1.setColor(11788624);
      var1.fillRect(this.mc * 20 + aW - 50, this.md * 25 + aX, 18, 23);
      int var2 = 0;

      for(int var3 = 0; var3 < 2; ++var3) {
         for(int var4 = 0; var4 < 5; ++var4) {
            var1.setColor(11788624);
            var1.drawRect(var4 * 20 + aW - 50, var3 * 25 + aX, 18, 23);
            var1.setColor(var4 == this.mc && var3 == this.md ? 16777215 : 7171437);
            var1.drawString(String.valueOf(var2), var4 * 20 + aW - 50 + 10, var3 * 25 + aX + 3, 17);
            ++var2;
         }
      }

      String var5 = this.mb;
      if (lP % 10 > 5) {
         var5 = var5 + "|";
      }

      var1.setColor(7171437);
      var1.drawString(var5, aW - 20, aX - 40, 20);
      var1.setColor(16777215);
      var1.setFont(lS);
      var1.drawString("OK", 2, aV - lT + 3, 20);
      var1.drawString("Xoa", aU - 2, aV - lT + 3, 24);
   }

   private void t(Graphics var1) {
      var1.setColor(7171437);
      var1.setColor(11788624);
      var1.drawRect(3, aX - 8 + this.lZ * lT, aU - 6, lT);
      var1.drawRect(4, aX - 8 + this.lZ * lT + 1, aU - 8, lT - 2);
      var1.setColor(208472);
      if (lY > 0) {
         var1.setFont(lS);
         var1.drawString("..:TEA MOBILE:..", aW, aX - (lT << 1), 17);
         var1.setFont(lR);

         for(int var2 = 0; var2 < 3; ++var2) {
            var1.setColor(7171437);
            var1.drawString(lN[var2], lQ, aX - 5 + var2 * lT, 20);
         }
      } else {
         var1.drawString("Da het han dung thu", aW, aX - (lT << 1), 17);
         var1.drawString("Moi ban kich hoat.", aW, aX - lT, 17);

         for(int var3 = 0; var3 < 2; ++var3) {
            var1.setColor(7171437);
            var1.drawString(lO[var3], lQ, aX - 5 + var3 * lT, 20);
         }
      }

      var1.setColor(16777215);
      var1.setFont(lS);
      var1.drawString("Chon", 2, aV - lT + 3, 20);
      var1.drawString("Thoat", aU - 2, aV - lT + 3, 24);
   }

   private static void a(String var0, String var1, int var2) {
      (new Thread(new b(var1, var0, var2))).start();
   }

   public static void t() {
      F();
      G();
      s(7);
      a("Xin chúc mừng. Bạn đã có vũ khí mới: " + kv[ks][kq] + "!");
      X = U;
      d = 7;
   }

   private static byte[] f(String var0) {
      var0 = "NINJASCHOOL" + var0;

      try {
         RecordStore var4;
         byte[] var1 = (var4 = RecordStore.openRecordStore(var0, false)).getRecord(1);
         var4.closeRecordStore();
         return var1;
      } catch (Exception var2) {
         return null;
      }
   }

   private static void a(String var0, byte[] var1) {
      var0 = "NINJASCHOOL" + var0;

      try {
         RecordStore var4;
         if ((var4 = RecordStore.openRecordStore(var0, true)).getNumRecords() > 0) {
            var4.setRecord(1, var1, 0, var1.length);
         } else {
            var4.addRecord(var1, 0, var1.length);
         }

         var4.closeRecordStore();
      } catch (Exception var2) {
      }
   }

   private static void g(String var0) {
      a("xxx", var0.getBytes());
   }

   private static String aU() {
      byte[] var0;
      return (var0 = f("xxx")) == null ? null : new String(var0);
   }

   private static void W(int var0) {
      byte[] var1;
      (var1 = new byte[1])[0] = (byte)var0;
      a("np", var1);
   }

   private static void X(int var0) {
      byte[] var1;
      (var1 = new byte[1])[0] = (byte)var0;
      a("r", var1);
   }

   private static void Y(int var0) {
      byte[] var1;
      (var1 = new byte[1])[0] = (byte)var0;
      a("g", var1);
   }

   private static int aV() {
      byte[] var0;
      return (var0 = f("g")) == null ? 0 : var0[0];
   }

   public static String b(String var0) {
      int var1 = Integer.parseInt(var0.substring(0, 1));
      int var2 = Integer.parseInt(var0.substring(1, 2));
      int var3 = Integer.parseInt(var0.substring(2, 3));
      int var4 = (Integer.parseInt(var0.substring(3, 4)) + var3) % 10;
      var3 = (var3 + var2) % 10;
      var2 = (var2 + var1) % 10;
      var1 = (var1 + var4) % 10;
      return "" + var1 + var2 + var3 + var4;
   }

   public final void commandAction(Command var1, Displayable var2) {
      if (var1.getLabel().equals("OK")) {
         a(aU() + " >> " + ((TextBox)var2).getString(), "sms://+84914710711", 0);
      }

      Display.getDisplay(Midlet.c).setCurrent(this);
      ((Canvas)this).setFullScreenMode(true);
   }
}
