//インポート
import java.awt.Font;

import sun.misc.GC;
import gameCanvasUtil.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/** ゲームクラス。
 *
 * 学生が編集すべきソースコードです。
 */
public class Game extends GameBase
{
		public static final int Main_Menu = 0;
		public static final int Choose_Map = 1;
		public static final int Select_Units = 2;
		public static final int Game_Session = 3;
		public static final int Victory = 4;
		public static final int Game_Over = 5;
		public static final int Break = 6;
		public static final int Help = 7;
		public static final int StatusPage = 8;
		public static final int OptionsMenu = 9;
		public static final int LEFT = 0;
		public static final int RIGHT = 1;
		public static final int BLUE = 0;
		public static final int RED = 1;
		public static final int GREEN = 2;
		public static final int CLEAR = -1;
		public static final int Empty = 0;
		public static final int Ally = 1;
		public static final int Enemy = 2;
		public static final int Obstacle = 3;
		
		// Cannot be Zero
		public static final int WyvernLord = 1;
		public static final int FalconKnight = 2;
		public static final int Paladin = 3;
		public static final int Hero = 4;
		public static final int Sage = 5;
		public static final int Sniper = 6;
		public static final int General = 7;
		public static final int Druid = 8;
		public static final int Bishop = 9;
		public static final int Swordmaster = 10;
		public static final int Valkyrie = 11;
		
		static int SquareSize = 32;
		
		boolean Menu;
		boolean HideCursor = false;
		int MenuPos;
		
		int GameState;
		static int Map;
		int MapCenterX, MapCenterY;
		int map_chosen;
		int time, lag;
		static int turn;
		int spin, angle;
		int MvAnim;
		int shiftVar, shiftCount, spin_width;
		int mapsize[] = new int[] {52, 56, 47, 37, 41, 39, 49, 42, 41};
		int unit_zoom;
		boolean spinner;
		boolean moveNow = false;
		static int stepsTaken;
		
		int ShiftX, ShiftY;
		static int MaxShiftX, MaxShiftY;
		int ScreenCenterX, ScreenCenterY;
		int ViewX, ViewY, displaySide, displayNum;
		
		int MapShiftX, MapShiftY;
		
		int Animation;
		int waitTimer = 0;
		boolean UpDown;
		int UnitAnimate, SelectedAnimate;
		int RunAnimate, RunTimer, see_data;
		
		static int CursorH;// pixels
		static int CursorV;
		int CursorAnimation, CursorWait;
		int CursorMvmt = 1;
		int ButtonStage = 0;
		boolean cursor_hover;
		int selection = 64+8;
		int commandLoc = 0;
		int commandHold = 0;
		int selectionI1 = 32;
		int selectionA1 = 32;
		int commandLocA1 = 0;
		int DataTab = 75;
		boolean BattlePhase = false;
		
		static int SelectedSide;
		boolean SelectedUpDown, SelectedRun;
		boolean Selected, SelectedE;
		int SelectedH, SelectedV;
		static int SelectedUnit, SelectedEUnit;
		
		static boolean mvtInitialized;
		boolean turnEnd = false;
		boolean turnEnded = false;
		int MvmtBoundH, MvmtBoundV;
		static int MvmtNum;
		boolean inMovement, prepareMove, alMoved, MvmtMax;
		int returnUnit;
		static int select_grid[][] = new int[130][130];
		static int weaponR[][][] = new int[5][100][100];
		static int drawn[][] = new int[100][100];
		static int CH;//grids
		static int CV;
		boolean commands[] = new boolean[6]; /** Attack, Heal, Dance, Rescue/Drop, Item, Trade **/
		
		static int pathX[] = new int[15];
		static int pathY[] = new int[15];
		
		static String pathDirection[] = new String[15];
		
		int grid_x[] = new int[100];//pixels
		int grid_y[] = new int[100];
		int grid_mvmt[][] = new int[100][100];
		static int occupied[][] = new int[100][100];
		static int terrain[][][] = new int[100][100][100];
		static String tile_type[][] = new String[100][100];
		
		static int GridMax_X;
		static int GridMax_Y;
		
		static String[] EUnit = new String[100];
		static int EClassNum[] = new int[100];
		static String[] EClass = new String[100];
		static int ELocationX[] = new int[100];
		static int ELocationY[] = new int[100];
		static int[][] EHP = new int[100][100];
		static String[][] EWeapon = new String[100][5];
		static int[][][] EWeaponDur = new int[100][5][2];
		static int[][] EStats = new int[100][8]; /** Str, Mag, Skill, Spd, Luck, Def, Res, Mvmt **/
		static int[][] EStatistics = new int[100][6]; /** Atk, Hit, RngMin, RngMax, Crit, Avo **/
		static int[][] EWeaponType = new int[100][3];
		static boolean[] EAlive = new boolean[100];
		static boolean[][] EStatus = new boolean[100][5];//idle, run, left/ right, up /down
		static boolean[] EMoved = new boolean[100];
		
		static String[] AUnit = new String[100];
		static int AClassNum[] = new int[100];
		static String[] AClass = new String[100];
		static int ALocationX[] = new int[100];
		static int ALocationY[] = new int[100];
		static int[][] AHP = new int[100][100];
		static String[][] AWeapon = new String[100][5];
		static int[][][] AWeaponDur = new int[100][5][2];
		static int[][] AStats = new int[100][8];
		static int[][] AStatistics = new int[100][6];
		static int[][] AWeaponType = new int[100][3];
		static boolean[] AAlive = new boolean[100];
		static boolean[][] AStatus = new boolean[100][5];
		static boolean[] AMoved = new boolean[100];
		
		int Wepnum = 0;
		int indx = 0;
		int WeaponId[] = new int[5];
		static int TargetId[] = new int[100];
		int targetIdx = 0;
		int atkIdx = 0;
		boolean IgnoreB = false;
		int wpNb = 0;
		boolean weaponInitialized = false;
		int wpList[] = new int[5];
		boolean gaveTime = false; //gives time to choose weapon
		int aX = 0;
		int aY = 0;
		int AButtonUnlocked = 0;
		int BButtonUnlocked = 0;
		
		boolean outofBoundsD = false;
		boolean outofBoundsU = false;
		boolean outofBoundsR = false;
		boolean outofBoundsL = false;
		boolean ignoreKeys = false;
		boolean outofBoundsAD = false;
		boolean outofBoundsAU = false;
		boolean outofBoundsAR = false;
		boolean outofBoundsAL = false;
		int ShiftAX = 0;
		int ShiftAY = 0;
		int targetFHor = 0;
		int targetFVer = 0;
		boolean ItemLookup = false;
		static boolean tryEquip = false;
		boolean startChoose = false;
		int optionsM = grid(2)+16;
		int lSelec = grid(2) + 16;
		
		int aDmg = 0;
		int dDef = 0;
		int dDmg = 0;
		int aDef = 0;
		
		String font = "小塚ゴシック Pro　H"; //Trebuchet MS　小塚ゴシック Pro　H
		int fType = Font.BOLD;
		int Lang = 0;
		int atkStg = 0;
		static String team1Name;
		static String team2Name;
		
    /********* 初期化の手順はこちらに *********/
    public void initGame() {
    	
		Menu = false;
		MenuPos = RIGHT;
		
		GameState = Main_Menu;
		Map = 6;
		MapCenterX = 0;
		MapCenterY = 0;
		map_chosen = 4;
		GridMax_X = grid(MapCenterX*2) -1;
		GridMax_Y = grid(MapCenterY*2) -1;
		time = 0;
		lag = 0;
		turn = Ally;
		spin = 0;
		angle = 0;
		MvAnim = 0;
		alMoved = false;
		shiftVar = 640;
		shiftCount = 0;
		spin_width = 200;
		unit_zoom = 160;
		spinner = true;
		
		ShiftX = 0;
		ShiftY = 0;
		ScreenCenterX = 0;
		ScreenCenterY = 0;
		ViewX = 0;
		ViewY = 0;
		
		MapShiftX = 0;
		MapShiftY = 0;
		
		Animation = 0;
		UpDown = true;
		UnitAnimate = 0;
		SelectedUpDown = false;
		SelectedAnimate = 0;
		RunAnimate = 0;
		RunTimer = 0;
		see_data = 400;
		
		CursorH = 0;
		CursorV = 0;
		CursorAnimation = 0;
		CursorWait = 0;
		cursor_hover = false;
		
		Selected = false;
		SelectedE = false;
		mvtInitialized = false;
		
		SelectedH = 0;
		SelectedV = 0;
		SelectedUnit = 0;
		SelectedEUnit = 0;
		MvmtBoundH = 0;
		MvmtBoundV = 0;
		MvmtNum = 0;
		inMovement = false;
		MvmtMax = false;
		returnUnit = 0;
		
		for(int i=0; i<6; i++){
			commands[i] = false;
			if(i == 6){
				commands[i] = true;
			}
		}
		
		for(int i=0; i<100; i++){
			AClass[i] = null;
			EClass[i] = null;
			AAlive[i] = false;
			EAlive[i] = false;
			AMoved[i] = false;
			EMoved[i] = false;
			ALocationX[i] = -1;
			ALocationY[i] = -1;
			ELocationX[i] = -1;
			ELocationY[i] = -1;
			for(int j=0; j<5; j++){
				AStatus[i][j] = false;
				EStatus[i][j] = false;
			}
		}
		clearMvmtSquare();
		/*AUnit[0] = "Kent";
		AClassNum[0] = General;
		AClass[0] = "General";
		ALocationX[0] = grid(1);
		ALocationY[0] = grid(5);
		AWeapon[0][0] = "Brave Sword";
		AWeapon[0][1] = "Brave Sword";
		AWeapon[0][2] = "Killer Lance";
		AWeapon[0][3] = "Silver Lance";
		AWeapon[0][4] = "Killing Edge";
		AStats[0][7] = 8;
		AAlive[0] = true;
		AMoved[0] = false;

		
		AUnit[1] = "Heath";
		AClassNum[1] = WyvernLord;
		AClass[1] = "WyvernLord";
		ALocationX[1] = grid(17);
		ALocationY[1] = grid(19);
		AWeapon[1][0] = "Brave Sword";
		AWeapon[1][1] = "Spear";
		AWeapon[1][2] = "Killer Lance";
		AStats[1][7] = 8;
		AAlive[1] = true;
		AMoved[1] = false;

		
		AUnit[2] = "Raven";
		AClassNum[2] = Hero;
		AClass[2] = "Hero";
		ALocationX[2] = grid(16);
		ALocationY[2] = grid(8);
		AStats[2][7] = 6;
		AAlive[2] = true;
		AMoved[2] = false;

		
		AUnit[3] = "Pent";
		AClassNum[3] = Sage;
		AClass[3] = "Sage";
		ALocationX[3] = grid(5);
		ALocationY[3] = grid(15);
		AWeapon[3][0] = "Excalibur";
		AWeapon[3][1] = "Physic";
		AWeapon[3][2] = "Bolting";
		AWeapon[3][3] = "Elfire";
		AStats[3][7] = 6;
		AAlive[3] = true;
		AMoved[3] = false;

		
		AUnit[4] = "Leonardo";
		AClassNum[4] = Sniper;
		AClass[4] = "Sniper";
		ALocationX[4] = grid(12);
		ALocationY[4] = grid(10);
		AWeapon[4][0] = "Silver Bow";
		AWeapon[4][1] = "Longbow";
		AWeapon[4][2] = "Brave Bow";
		AStats[4][7] = 6;
		AAlive[4] = true;
		AMoved[4] = false;
		
		AUnit[5] = "Karel";
		AClassNum[5] = Swordmaster;
		AClass[5] = "Swordmaster";
		ALocationX[5] = grid(12);
		ALocationY[5] = grid(13);
		AWeapon[5][0] = "Killing Edge";
		AWeapon[5][1] = "Armorslayer";
		AWeapon[5][2] = "Brave Sword";
		AStats[5][7] = 6;
		AAlive[5] = true;
		AMoved[5] = false;

		
		EUnit[0] = "Enemy0";
		EClassNum[0] = Valkyrie;
		EClass[0] = "Valkyrie";
		ELocationX[0] = grid(1);
		ELocationY[0] = grid(6);
		EStats[0][7] = 8;
		EAlive[0] = true;
		EMoved[0] = false;

		
		EUnit[1] = "Enemy1";
		EClassNum[1] = Bishop;
		EClass[1] = "Bishop";
		ELocationX[1] = grid(16);
		ELocationY[1] = grid(10);
		EStats[1][7] = 8;
		EAlive[1] = true;
		EMoved[1] = false;

		
		EUnit[2] = "Enemy2";
		EClassNum[2] = Druid;
		EClass[2] = "Druid";
		ELocationX[2] = grid(12);
		ELocationY[2] = grid(11);
		EWeapon[2][0] = "Flux";
		EWeapon[2][1] = "Luna";
		EWeapon[2][2] = "Nosferatu";
		EStats[2][7] = 8;
		EAlive[2] = true;
		EMoved[2] = false;

		
		EUnit[3] = "Enemy3";
		EClassNum[3] = WyvernLord;
		EClass[3] = "WyvernLord";
		ELocationX[3] = grid(15);
		ELocationY[3] = grid(16);
		EWeapon[3][0] = "Hammer";
		EWeapon[3][1] = "Brave Axe";
		EWeapon[3][2] = "Killer Lance";
		EWeapon[3][3] = "Spear";
		EStats[3][7] = 8;
		EAlive[3] = true;
		EMoved[3] = false;

		
		EUnit[4] = "Enemy4";
		EClassNum[4] = FalconKnight;
		EClass[4] = "FalconKnight";
		ELocationX[4] = grid(7);
		ELocationY[4] = grid(12);
		EStats[4][7] = 8;
		EAlive[4] = true;
		EMoved[4] = false;*/

		
		
	}
	
    /********* 物体の移動等の更新処理はこちらに *********/
    public void updateGame() {
    	if(font == "小塚ゴシック Pro　H"){
			Lang = 1;
		} else{
			Lang = 0;
		}
		if(GameState == Main_Menu){
			if(gc.isKeyPushed(gc.KEY_M)){
				gc.playSE(0);
				team1Name = gc.showInputDialog("Choose a Team Name for Player 1:", "Team 1");
				team2Name = gc.showInputDialog("Choose a Team Name for Player 2:", "Team 2");
				GameState = Choose_Map;
			}
		}
		else if(GameState == Choose_Map){
			choosing();
			spin++;
			if(spin_width == 200){
				spinner = true;
			}else if(spin_width == 300){
				spinner = false;
			}
			if(spinner){
				spin_width++;
			}else if(!spinner){
				spin_width--;
			}
		}
		else if(GameState == Game_Session){
			checkOccupation();
			determineRightLeft();
			checkStatistics();
			if(turn == Ally){
				if(!ignoreKeys){
					AllyMvmt();
				}
			}
			else if(turn == Enemy){
				if(!ignoreKeys){
					EnemyMvmt();
				}
			}
			AnimationHandler();
			time++;
			if(moveNow){
				MvAnim+=16;
				UnitStats.determineDirection();
				if(MvAnim%32 == 0 && stepsTaken > 0){
					stepsTaken--;
					wayPointMark();
				}
			}
			if(!HideCursor || atkStg == 2){
				centerScreen();
			}
			Animation++;
			checkTurnEnd();
			waitTimer++;
			checkVictory();
		}
		else if(GameState == StatusPage){
			dataKeyControl();
			shiftCount++;
		}
		else if(GameState == OptionsMenu){
			shiftCount++;
		}
		CursorAnimation++;
		CursorWait++;
	}

    /********* 画像の描画はこちらに *********/
    public void drawGame(){
        // 画面を白で塗りつぶします
        gc.clearScreen();
		
		
		//gc.drawImage(0, 0-grid(ShiftX), 0-grid(ShiftY));
        gc.setColor(0, 0, 0);

        // ここから、画像を表示する命令を記述していく
		if(GameState == Main_Menu){
			gc.drawString("Castle Siege", 120, 220);
		}
		else if(GameState == Choose_Map){
			gc.drawScaledRotateImage(0, 640/2, 480/2, 200+(200/3), 300, 0);
			gc.drawScaledRotateImage(14, 640/2, 480+50, 400, 400, spinning(360));
			drawCanvas();
			drawHighlights();
			
			gc.drawScaledRotateImage(4, grid(4)-16, grid(6) - grid(MapShiftY * 7), mapsize[0], mapsize[0], 0);
			gc.drawScaledRotateImage(5, grid(10), grid(6) - grid(MapShiftY * 7), mapsize[1], mapsize[1], 0);
			gc.drawScaledRotateImage(6, grid(16)+16, grid(6) - grid(MapShiftY * 7), mapsize[2], mapsize[2], 0);
			
			gc.drawScaledRotateImage(7, grid(4)-16, grid(15) - grid(MapShiftY * 7), mapsize[3], mapsize[3], 0);
			gc.drawScaledRotateImage(8, grid(10), grid(15) - grid(MapShiftY * 7), mapsize[4], mapsize[4], 0);
			gc.drawScaledRotateImage(9, grid(16)+16, grid(15) - grid(MapShiftY * 7), mapsize[5], mapsize[5], 0);
			
			gc.drawScaledRotateImage(10, grid(4)-16, grid(23) - grid(MapShiftY * 7), mapsize[6], mapsize[6], 0);
			gc.drawScaledRotateImage(11, grid(10), grid(23) - grid(MapShiftY * 7), mapsize[7], mapsize[7], 0);
			gc.drawScaledRotateImage(12, grid(16)+16, grid(23) - grid(MapShiftY * 7), mapsize[8], mapsize[8], 0);
			
			gc.setColor(0,0,0);
			//gc.drawString("Choose Map", 120, 220);
		}
		else if(GameState == Game_Session){
			gc.drawScaledRotateImage(Map, MapCenterX-grid(ShiftX), MapCenterY-grid(ShiftY), 200, 200, 0);
			//Draw Mvmt Range
			if(Selected && !alMoved){
				drawMvmtSquare();
			}
			
			//Draw Grid
			gc.setColor(255,0,0);
			/*for(int i=0; i<GridMax_X; i++){
				for(int j=0; j<GridMax_Y; j++){
					gc.drawRect(grid_x[i], grid_y[j], grid(1), grid(1));
				}
			}*/
			if(Selected && !alMoved){
				drawArrows();
			}
			if(ButtonStage == 2 && !moveNow){
				CalculatePath.checkAttackRange(SelectedSide, SelectedUnit);
				//showAtkRng();
			}
			if(ButtonStage == 2 && !moveNow && atkStg == 0){
				checkItems();
				showAtkRng();
			}
			if(atkStg == 1 && weaponInitialized || atkStg == 2){
				showSpAtkRng(wpNb);
			}
			drawUnits();
			if(!Menu && !moveNow && !HideCursor){
				drawCursor();
			}
			if(ButtonStage == 2 && !moveNow && atkStg == 0 && !ItemLookup){
				//checkCommand();
				showCommand();
				IgnoreB = false;
			}
			if(ItemLookup){
				displayItems();
			}
			if(atkStg == 1){
				IgnoreB = true;
				displayWpChoice();
			}
			else if(atkStg == 2 && startChoose){
				chooseEnemy();
			}
			else if(atkStg == 2 && !startChoose){
				startChoose = true;
			}
			showMenu();
		}
		else if(GameState == StatusPage){
			gc.drawScaledRotateImage(13, shifting(640)/2, 480/2, 200+(200/3), 300, 0);
			showStatus();
		}
		else if(GameState == OptionsMenu){
			gc.drawScaledRotateImage(13, shifting(640)/2, 480/2, 200+(200/3), 300, 0);
			showOptions();
		}
		
    }

    /********* 終了時の処理はこちらに *********/
    public void finalGame() {}
	
	/********* Basics *********/
	static int grid(int i){ // Independent
		return(i*SquareSize);
	}
	static int square(int i){ //Independent
		return(i/SquareSize);
	}
	int tlUX(int file_id, int grid_num){ //Independent
		return(grid_num - gc.getImageWidth(file_id));
	}
	int tlUY(int file_id, int grid_num){ //Independent
		return(grid_num - gc.getImageHeight(file_id));
	}
	int tlX(int file_id, int grid_num, int size_adjust){ //Independent
		return(grid_num - gc.getImageWidth(file_id)/2*size_adjust/100);
	}
	int tlY(int file_id, int grid_num, int size_adjust){ //Independent
		return(grid_num - gc.getImageHeight(file_id)/2*size_adjust/100);
	}
	int spinning(int i){ //Independent
		if((spin%2)==0){
			angle++;
		}
		return(angle);
	}
	int shifting(int i){ //Independent
		if((shiftCount%1)==0){
			shiftVar--;
			//System.out.println(shiftVar);
		}
		if(shiftVar <= -640-64-16-4){
			shiftVar = 640;
		}
		return(shiftVar);
	}
	void AnimationHandler(){ // Independent, unused
		if(Animation%18 == 0){
			UpDown = !UpDown;
		}
		if(UpDown && UnitAnimate < 2){
			UnitAnimate++;
		} else if(!UpDown && UnitAnimate > 0){
			UnitAnimate--;
		}
		if(Animation%15 == 0){
			SelectedUpDown = !SelectedUpDown;
		}
		if(SelectedUpDown && SelectedAnimate < 2){
			SelectedAnimate++;
		} else if(!SelectedUpDown && SelectedAnimate > 0){
			SelectedAnimate--;
		}
		if(Animation%10 == 0 && RunAnimate == 0 || Animation%10 == 0 && RunAnimate == 3){
			SelectedRun = !SelectedRun;
		}
		if(SelectedRun && RunAnimate < 3 && Animation%2 == 0){
			RunAnimate++;
		} else if(!SelectedRun && RunAnimate > 0 && Animation%2 == 0){
			RunAnimate--;
		}
		/**** Stable Mvmt****/
		/*if(Animation%3 == 0 && RunAnimate == 0 || Animation%3 == 0 && RunAnimate == 3){
			SelectedRun = !SelectedRun;
		}
		if(SelectedRun && RunAnimate < 3 && Animation%3 == 0){
			RunAnimate++;
		} else if(!SelectedRun && RunAnimate > 0 && Animation%3 == 0){
			RunAnimate--;
		}*/
	}

	void getMapCenter(){ //Independent
		MapCenterX = gc.getImageWidth(Map);
		MapCenterY = gc.getImageHeight(Map);
		GridMax_X = square(MapCenterX*2) -1;
		GridMax_Y = square(MapCenterY*2) -1;
		for(int i=0; i<GridMax_X; i++){
			grid_x[i] = grid(1)*i;
		}
		for(int i=0; i<GridMax_Y; i++){
			grid_y[i] = grid(1)*i;
		}
	}
	void checkTurnEnd(){ //Independent
		boolean EndTurn = true;
		if(turn == Ally){
			for(int i=0; i<100; i++){
				if(AAlive[i] && !AMoved[i]){
					EndTurn = false;
				}
			}
			if(turnEnded){
				EndTurn = true;
			}
			if(EndTurn){
				for(int i=0; i<100; i++){
					if(AAlive[i]){
						AMoved[i] = false;
					}
				}
				settingsReset();
				for(int i=0; i<100; i++){
					if(EAlive[i]){
						CursorH = ELocationX[i];
						CursorV = ELocationY[i];
						break;
					}
				}
				turnEnd = true;
			}
			if(turnEnd && waitTimer%12 == 0){
				turn = Enemy;
				Menu = false;
				turnEnd = false;
				turnEnded = false;
			}
		} else if(turn == Enemy){
			for(int i=0; i<100; i++){
				if(EAlive[i] && !EMoved[i]){
					EndTurn = false;
				}
			}
			if(turnEnded){
				EndTurn = true;
			}
			if(EndTurn){
				for(int i=0; i<100; i++){
					if(EAlive[i]){
						EMoved[i] = false;
					}
				}
				settingsReset();
				for(int i=0; i<100; i++){
					if(AAlive[i]){
						CursorH = ALocationX[i];
						CursorV = ALocationY[i];
						break;
					}
				}
				turnEnd = true;
			}
			if(turnEnd && waitTimer%12 == 0){
				turn = Ally;
				turnEnd = false;
				Menu = false;
				turnEnded = false;
			}
		}
	}
	
	/********* KeyBindings and Movements *********/
	void centerScreen(){
		if(CursorV -grid(ShiftY) >= 480 && !outofBoundsD){
			outofBoundsD = true;
			ignoreKeys = true;
		}
		else if(CursorV -grid(ShiftY) < 0 && !outofBoundsU){
			outofBoundsU = true;
			ignoreKeys =true;
		}
		if(CursorH -grid(ShiftX) >= 640 && !outofBoundsR){
			outofBoundsR = true;
			ignoreKeys = true;
		}
		else if(CursorH -grid(ShiftX) < 0 && !outofBoundsL){
			outofBoundsL = true;
			ignoreKeys = true;
		}
		if(outofBoundsU){
			int moveIn = 0;
			if(moveIn%10 == 0){
				ShiftY--;
			}
			moveIn++;
			if(CursorV -grid(ShiftY) >= grid(3) || ShiftY == 0){
				outofBoundsU = false;
				ignoreKeys = false;
			}
		}
		if(outofBoundsD){
			int moveIn = 0;
			if(moveIn%10 == 0){
				ShiftY++;
			}
			moveIn++;
			//System.out.println(CursorV + ", " + grid(ShiftY) + ", " + grid(GridMax_Y));
			if(CursorV -grid(ShiftY) <= grid(12) || ShiftY == MaxShiftY){ //grid(14) + grid(ShiftY) >= grid(GridMax_Y)
				outofBoundsD = false;
				ignoreKeys = false;
			}
		}
		if(outofBoundsR){
			int moveIn = 0;
			if(moveIn%10 == 0){
				ShiftX++;
			}
			moveIn++;
			if(CursorH -grid(ShiftX) <= grid(17) || ShiftX == MaxShiftX){ //grid(20) + grid(ShiftX) >= grid(GridMax_X)
				outofBoundsR = false;
				ignoreKeys = false;
			}
		}
		if(outofBoundsL){
			int moveIn = 0;
			if(moveIn%10 == 0){
				ShiftX--;
			}
			moveIn++;
			if(CursorH -grid(ShiftX) >= grid(2) || ShiftX == 0){
				outofBoundsL = false;
				ignoreKeys = false;
			}
		}
	}
	/*void centerTarget(){
		//Math.abs(ALocationY[SelectedUnit] -ELocationY[TargetId[atkIdx]]) <= targetFHor
		System.out.println(aX + ", " + aY);
		if(aY - grid(ShiftY) > 480-grid(3) && !outofBoundsAD){
			outofBoundsAD = true;
		}
		else if(aY - grid(ShiftY) < 0 +grid(3)&& !outofBoundsAU){
			outofBoundsAU = true;
		}
		else if(aX - grid(ShiftX) > 640 -grid(3) && !outofBoundsAR){
			outofBoundsAR = true;
		}
		else if(aX - grid(ShiftX) < 0 +grid(3) && !outofBoundsAL){
			outofBoundsAL = true;
		}
		
	}*/
	void wayPointMark(){
		int wptLocX = 0;
		int wptLocY = 0;
		boolean udDetermine = false;
		boolean rlDetermine = false;
		if(SelectedSide == Ally){
			udDetermine = AStatus[SelectedUnit][3];
			rlDetermine = AStatus[SelectedUnit][4];
			wptLocX = ALocationX[SelectedUnit];
			wptLocY = ALocationY[SelectedUnit];
		}
		else if(SelectedSide == Enemy){
			udDetermine = EStatus[SelectedUnit][3];
			rlDetermine = EStatus[SelectedUnit][4];
			wptLocX = ELocationX[SelectedUnit];
			wptLocY = ELocationY[SelectedUnit];
		}
		if(udDetermine && rlDetermine){
			wptLocX+=grid(1);
			MvAnim = 0;
		}
		else if(udDetermine && !rlDetermine){
			wptLocX-=grid(1);
			MvAnim = 0;
		}
		else if(!udDetermine && rlDetermine){
			wptLocY-=grid(1);
			MvAnim = 0;
		}
		else if(!udDetermine && !rlDetermine){
			wptLocY+=grid(1);
			MvAnim = 0;
		}
		if(SelectedSide == Ally){
			ALocationX[SelectedUnit] = wptLocX;
			ALocationY[SelectedUnit] = wptLocY;
		}
		else if(SelectedSide == Enemy){
			ELocationX[SelectedUnit] = wptLocX;
			ELocationY[SelectedUnit] = wptLocY;
		}
		if(stepsTaken <= 0){
			moveNow = false;
			//AStatus[SelectedUnit][2] = false;
			MvAnim = 0;
		}
	}
	void settingsReset(){
		alMoved = false;
		ButtonStage = 0;
		atkStg = 0;
		commandLoc = 0;
	}
	
	void choosing(){ //Independent
		if(GameState == Choose_Map){
			if(gc.isKeyPushed(gc.KEY_W) && map_chosen>=7){
				map_chosen-=3;
				MapShiftY--;
			}
			else if(gc.isKeyPushed(gc.KEY_A) && map_chosen!=4 && map_chosen!=7 && map_chosen!=10){
				map_chosen--;
			}
			else if(gc.isKeyPushed(gc.KEY_S) && map_chosen<=9){
				map_chosen+=3;
				MapShiftY++;
			}
			else if(gc.isKeyPushed(gc.KEY_D) && map_chosen!=6 && map_chosen!=9 && map_chosen!=12){
				map_chosen++;
			}
			if(gc.isKeyPushed(gc.KEY_M)){
				Map = map_chosen;
				getMapCenter();
				MapData.InsertData();
				numberSet();
				UnitStats.randomizeUnits();
				for(int i=0; i<100; i++){
					UnitStats.randomizeStats(Ally, i);
					UnitStats.randomizeStats(Enemy, i);
					WeaponData.setWeaponData(Ally, i);
					WeaponData.setWeaponData(Enemy, i);
					//System.out.println("randomized");
				}
				//AWeaponDur[4][1][0] = 1;
				CursorH = ALocationX[0];
				CursorV = ALocationY[0];
				GameState = Game_Session;
			}
		}
	}
	void numberSet(){ //Independent
		MapData.determineMvmt(Paladin);
		MapData.determineMvmt(WyvernLord);
		MapData.determineMvmt(Sage);
		MapData.determineMvmt(Sniper);
		MapData.determineMvmt(Hero);
		MapData.determineMvmt(Druid);
		MapData.determineMvmt(General);
		MapData.determineMvmt(Valkyrie);
		MapData.determineMvmt(FalconKnight);
		MapData.determineMvmt(Swordmaster);
		MapData.determineMvmt(Bishop);
		
	}
	void determineRightLeft(){ //Independent
		if(CursorH <= grid(9) + grid(ShiftX)){
			MenuPos = RIGHT;
		}
		else if(CursorH > grid(9) + grid(ShiftX)){
			MenuPos = LEFT;
		}
	}
	void KeyBind(){ //Independent
		if(!Menu){
			if(turn == Ally){
				for(int i=0; i<100; i++){
					if(AAlive[i] && gc.checkHitRect(CursorH, CursorV, grid(1), grid(1), ALocationX[i]+5, ALocationY[i]+5, grid(1)-10, grid(1)-10)){
						//System.out.println(CursorH + ", " + CursorV + ", " +grid(1) + ", " + grid(1) +", " + (ALocationX[i]+5) + ", " + (ALocationY[i]+5) + ", " + (grid(1)-10) + ", " + (grid(1)-10) + ", " + i);
						AStatus[i][0] = true;
						cursor_hover = true;
						//System.out.println("" + cursor_hover);
						see_data = i;
					}
					else if(!gc.checkHitRect(CursorH, CursorV, grid(1), grid(1), ALocationX[i]+5, ALocationY[i]+5, grid(1)-10, grid(1)-10)){
						AStatus[i][0] = false;
						if(!Selected){
							cursor_hover = false;
							//System.out.println("" + cursor_hover);
							see_data = 400;
						}
					}
					else if(EAlive[i] && gc.checkHitRect(CursorH, CursorV, grid(1), grid(1), ELocationX[i]+5, ELocationY[i]+5, grid(1)-10, grid(1)-10)){
						EStatus[i][0] = true;
						cursor_hover = true;
						see_data = i;
					}
					else if(!gc.checkHitRect(CursorH, CursorV, grid(1), grid(1), ELocationX[i]+5, ELocationY[i]+5, grid(1)-10, grid(1)-10)){
						EStatus[i][0] = false;
						if(!Selected){
							cursor_hover = false;
							see_data = 400;
						}
					}
				}
			}
			else if(turn == Enemy){
				for(int i=0; i<100; i++){
					if(gc.checkHitRect(CursorH, CursorV, grid(1), grid(1), ELocationX[i]+5, ELocationY[i]+5, grid(1)-10, grid(1)-10)){
						//System.out.println(CursorH + ", " + CursorV + ", " +grid(1) + ", " + grid(1) +", " + (ALocationX[i]+5) + ", " + (ALocationY[i]+5) + ", " + (grid(1)-10) + ", " + (grid(1)-10) + ", " + i);
						EStatus[i][0] = true;
						cursor_hover = true;
						//System.out.println("" + cursor_hover);
						see_data = i;
					}
					else if(!gc.checkHitRect(CursorH, CursorV, grid(1), grid(1), ELocationX[i]+5, ELocationY[i]+5, grid(1)-10, grid(1)-10)){
						EStatus[i][0] = false;
						if(!Selected){
							cursor_hover = false;
							//System.out.println("" + cursor_hover);
							see_data = 400;
						}
					}
					else if(gc.checkHitRect(CursorH, CursorV, grid(1), grid(1), ALocationX[i]+5, ALocationY[i]+5, grid(1)-10, grid(1)-10)){
						AStatus[i][0] = true;
						cursor_hover = true;
						see_data = i;
					}
					else if(!gc.checkHitRect(CursorH, CursorV, grid(1), grid(1), ALocationX[i]+5, ALocationY[i]+5, grid(1)-10, grid(1)-10)){
						AStatus[i][0] = false;
						if(!Selected){
							cursor_hover = false;
							see_data = 400;
						}
					}
				}
			}
			if(!HideCursor){
				if(gc.isKeyPushed(gc.KEY_W) && turn == Ally || gc.isKeyPushed(gc.KEY_I) && turn == Enemy){
					UpMovement();
					CursorWait = 0;
				}
				if(gc.isKeyPushed(gc.KEY_S) && turn == Ally || gc.isKeyPushed(gc.KEY_K) && turn == Enemy){
					DownMovement();
					CursorWait = 0;
				}
				if(gc.isKeyPushed(gc.KEY_A) && turn == Ally || gc.isKeyPushed(gc.KEY_J) && turn == Enemy){
					LeftMovement();
					CursorWait = 0;
				}
				if(gc.isKeyPushed(gc.KEY_D) && turn == Ally || gc.isKeyPushed(gc.KEY_L) && turn == Enemy){
					RightMovement();
					CursorWait = 0;
				}
				if(gc.isKeyPress(gc.KEY_W) && turn == Ally && CursorWait>12 || gc.isKeyPress(gc.KEY_I) && turn == Enemy && CursorWait>12){
					UpMovement();
				}
				if(gc.isKeyPress(gc.KEY_S) && turn == Ally && CursorWait>12 || gc.isKeyPress(gc.KEY_K) && turn == Enemy && CursorWait>12){
					DownMovement();
				}
				if(gc.isKeyPress(gc.KEY_A) && turn == Ally && CursorWait>12 || gc.isKeyPress(gc.KEY_J) && turn == Enemy && CursorWait>12){
					LeftMovement();
				}
				if(gc.isKeyPress(gc.KEY_D) && turn == Ally && CursorWait>12 || gc.isKeyPress(gc.KEY_L) && turn == Enemy && CursorWait>12){
					RightMovement();
				}
			}
		}
		if(gc.isKeyPushed(gc.KEY_M) && turn == Ally || gc.isKeyPushed(gc.KEY_RIGHT) && turn == Enemy){
			/*for(int i=0; i<2; i++){
				System.out.println(CursorH +" "+ CursorV + " "+ grid(1) +" " + grid(1) + " " + (ALocationX[i]+5) +" " + (ALocationY[i]+5) + " " + (grid(1)-10) +" "+ (grid(1)-10));
			}*/
			if(ButtonStage == 0){
				for(int i=0; i<100; i++){
					if(!Selected && !Menu){ 
						if(gc.checkHitRect(CursorH, CursorV, grid(1), grid(1), ALocationX[i]+5, ALocationY[i]+5, grid(1)-10, grid(1)-10) && !AMoved[i] && turn == Ally){
							//System.out.println("Collided");
							Selected = true;
							SelectedSide = Ally;
							SelectedUnit = i;
							CH = square(ALocationX[i]);
							CV = square(ALocationY[i]);
							//System.out.println("Before: " + ALocationX[i] + ", " + ALocationY[i]);
							AStatus[i][1] = true;
							CalculatePath.findMaxAtkRange(Ally, i);
							CalculatePath.pathColor(AClassNum[i], CH, CV, AStats[SelectedUnit][7]);
							prepareMove = true;
							
						}
						else if(gc.checkHitRect(CursorH, CursorV, grid(1), grid(1), ELocationX[i]+5, ELocationY[i]+5, grid(1)-10, grid(1)-10) && !EMoved[i] && turn == Enemy){
							//System.out.println("Collided");
							Selected = true;
							SelectedSide = Enemy;
							SelectedUnit = i;
							CH = square(ELocationX[i]);
							CV = square(ELocationY[i]);
							//System.out.println("Before: " + ALocationX[i] + ", " + ALocationY[i]);
							EStatus[i][1] = true;
							CalculatePath.findMaxAtkRange(Enemy, i);
							CalculatePath.pathColor(EClassNum[i], CH, CV, EStats[SelectedUnit][7]);
							prepareMove = true;
							
						}
						else if(gc.checkHitRect(CursorH, CursorV, grid(1), grid(1), ELocationX[i]+5, ELocationY[i]+5, grid(1)-10, grid(1)-10) && turn == Ally){
							//System.out.println("Collided");
							Selected = true;
							SelectedSide = Enemy;
							//System.out.println(SelectedSide);
							SelectedUnit = i;
							CH = square(ELocationX[i]);
							CV = square(ELocationY[i]);
							CalculatePath.findMaxAtkRange(Enemy, i);
							CalculatePath.pathColor(EClassNum[i], CH, CV, EStats[SelectedUnit][7]);
							
						}
						else if(gc.checkHitRect(CursorH, CursorV, grid(1), grid(1), ALocationX[i]+5, ALocationY[i]+5, grid(1)-10, grid(1)-10) && turn == Enemy){
							//System.out.println("Collided");
							Selected = true;
							SelectedSide = Ally;
							//System.out.println(SelectedSide);
							SelectedUnit = i;
							CH = square(ALocationX[i]);
							CV = square(ALocationY[i]);
							CalculatePath.findMaxAtkRange(Ally, i);
							CalculatePath.pathColor(AClassNum[i], CH, CV, AStats[SelectedUnit][7]);
							
						}
						else if(i==99){
							Menu = true;
						}
						mvtInitialized = true;
					}
					
				}
				ButtonStage = 1;
			}
			else if((ButtonStage == 1 && turn == Ally && SelectedSide == Enemy) || (ButtonStage == 1 && turn == Enemy && SelectedSide == Ally)){
				reset();
			}
			else if((ButtonStage == 1 && turn == Ally && SelectedSide == Ally) || (ButtonStage == 1 && turn == Enemy && SelectedSide == Enemy)){
				/*for(int i=CalculatePath.MaxIndex; i>=0; i--){
					System.out.println("index " + i + " (" + pathX[i] + ", " + pathY[i] + ") " + pathDirection[i]);
				}*/
				//if(){
					if(square(CursorH) == CH && square(CursorV) == CV && Selected && !Menu && prepareMove){
						HideCursor = true;
						ButtonStage = 2;
						alMoved = true;
					}
					else if((CursorH != CH || CursorV != CV) && Selected && !Menu && prepareMove && occupied[square(CursorH)][square(CursorV)] == Empty){
						if(select_grid[square(CursorH)][square(CursorV)] == BLUE){
							MvAnim = 0;
							stepsTaken = CalculatePath.MaxIndex;
							moveNow = true;
							alMoved = true;
							ButtonStage = 2;
							HideCursor = true;
						}
					}
				//}
			}
			else if(ButtonStage == 4){
				ButtonStage = 0;
			}
			
		}
		if(gc.isKeyPushed(gc.KEY_B) && !moveNow && atkStg == 0 && !IgnoreB && turn == Ally || gc.isKeyPushed(gc.KEY_LEFT) && !moveNow && atkStg == 0 && !IgnoreB && turn == Enemy){
			reset();
		}
		if(gc.isKeyPushed(gc.KEY_H) && ButtonStage == 0 && turn == Ally || gc.isKeyPushed(gc.KEY_UP) && ButtonStage == 0 && turn == Enemy){
			for(int i=0; i<100; i++){
				if(gc.checkHitRect(CursorH, CursorV, grid(1), grid(1), ALocationX[i]+5, ALocationY[i]+5, grid(1)-10, grid(1)-10)){
					displaySide = Ally;
					displayNum = i;
					GameState = StatusPage;
				}else if(gc.checkHitRect(CursorH, CursorV, grid(1), grid(1), ELocationX[i]+5, ELocationY[i]+5, grid(1)-10, grid(1)-10)){
					displaySide = Enemy;
					displayNum = i;
					GameState = StatusPage;
				}
				//displayStatus(i);
			}
		}
	}
	
	void dataKeyControl(){ //Independent
		if((gc.isKeyPushed(gc.KEY_A) || gc.isKeyPushed(gc.KEY_D)) && turn == Ally || (gc.isKeyPushed(gc.KEY_J) || gc.isKeyPushed(gc.KEY_L)) && turn == Enemy){
			if(DataTab == 75){
				DataTab = 76;
			}else if(DataTab == 76){
				DataTab = 75;
			}
		}
	}
	
	void UpMovement(){ // Independent
		int MvT = 0;
		int MvY = 0;
		if(turn == Ally){
			MvT = AStats[SelectedUnit][7];
			MvY = ALocationY[SelectedUnit];
		} else if(turn == Enemy){
			MvT = EStats[SelectedUnit][7];
			MvY = ELocationY[SelectedUnit];
		}
		if(square(CursorV) > 0){
			if(Selected){
				if(MvmtBoundH + MvmtBoundV < MvT){
					if(CursorV > MvY){
						CursorV-=grid(1);
						MvmtBoundV--;
					}
					else if(CursorV <= MvY){
						CursorV-=grid(1);
						MvmtBoundV++;
					}
				}
				else if(MvmtBoundH + MvmtBoundV <= MvT && CursorV > MvY){
					CursorV-=grid(1);
					MvmtBoundV--;
				}
				else{
					CursorV-=grid(1);
					MvmtNum = MvT;
				}
				if(MvmtNum <= MvT){
					MvmtNum++;
				}
				CalculatePath.showArrow(SelectedUnit, square(CursorH), square(CursorV), CH, CV);
				//UnitStats.MvmtTracker(MvmtNum, AStats[SelectedUnit][7], MvmtBoundH,  MvmtBoundV);
				//System.out.println(MvmtBoundV + "+" + MvmtBoundH);
			}
			else{
				CursorV-=grid(1);
			}
			if(CursorV < grid(2) + grid(ShiftY) && CursorV > grid(1)){
				ShiftY--;
			}
		}
		CursorMvmt = 1;
	}
	void DownMovement(){ //Independent
		//System.out.println("ShiftY: " + ShiftY);
		int MvT = 0;
		int MvY = 0;
		if(turn == Ally){
			MvT = AStats[SelectedUnit][7];
			MvY = ALocationY[SelectedUnit];
		} else if(turn == Enemy){
			MvT = EStats[SelectedUnit][7];
			MvY = ELocationY[SelectedUnit];
		}
		if(square(CursorV) < GridMax_Y){
			if(Selected){
				if(MvmtBoundH + MvmtBoundV < MvT){
					if(CursorV >= MvY){
						CursorV+=grid(1);
						MvmtBoundV++;
					}
					else if(CursorV < MvY){
						CursorV+=grid(1);
						MvmtBoundV--;
					}
				}
				else if(MvmtBoundH + MvmtBoundV >= MvT && CursorV < MvY){
					CursorV+=grid(1);
					MvmtBoundV--;
				}
				else{
					CursorV+=grid(1);
					MvmtNum = MvT;
				}
				if(MvmtNum <= MvT){
					MvmtNum++;
				}
				CalculatePath.showArrow(SelectedUnit, square(CursorH), square(CursorV), CH, CV);
				//UnitStats.MvmtTracker(MvmtNum, AStats[SelectedUnit][7], MvmtBoundH, MvmtBoundV);
				//System.out.println(MvmtBoundV + "+" + MvmtBoundH);
			}
			else{
				CursorV+=grid(1);
			}
			if(CursorV > grid(12)+grid(ShiftY) && CursorV < grid(GridMax_Y - 1)){
				ShiftY++;
			}
		}
		CursorMvmt = 1;
		
	}
	void LeftMovement(){ // Independent
		int MvT = 0;
		int MvX = 0;
		if(turn == Ally){
			MvT = AStats[SelectedUnit][7];
			MvX = ALocationX[SelectedUnit];
		} else if(turn == Enemy){
			MvT = EStats[SelectedUnit][7];
			MvX = ELocationX[SelectedUnit];
		}
		if(square(CursorH) > 0){
			if(Selected){
				if(MvmtBoundH + MvmtBoundV < MvT){
					if(CursorH <= MvX){
						CursorH-=grid(1);
						MvmtBoundH++;
					}
					else if(CursorH > MvX){
						CursorH-=grid(1);
						MvmtBoundH--;
					}
				}
				else if(MvmtBoundH + MvmtBoundV >= MvT && CursorH > MvX){
					CursorH-=grid(1);
					MvmtBoundH--;
				}
				else{
					CursorH-=grid(1);
					MvmtNum = MvT;
				}
				if(MvmtNum <= MvT){
					MvmtNum++;
				}
				CalculatePath.showArrow(SelectedUnit, square(CursorH), square(CursorV), CH, CV);
				//UnitStats.MvmtTracker(MvmtNum, AStats[SelectedUnit][7], MvmtBoundH, MvmtBoundV);
				//System.out.println(MvmtBoundV + "+" + MvmtBoundH);
			}
			else{
				CursorH-=grid(1);
			}
			if(CursorH < grid(2) + grid(ShiftX) && CursorH > grid(1)){
				ShiftX--;
			}
		}
		CursorMvmt = 1;
	}
	void RightMovement(){ //Independent
		//System.out.println("ShiftX: " + ShiftX);
		int MvT = 0;
		int MvX = 0;
		if(turn == Ally){
			MvT = AStats[SelectedUnit][7];
			MvX = ALocationX[SelectedUnit];
		} else if(turn == Enemy){
			MvT = EStats[SelectedUnit][7];
			MvX = ELocationX[SelectedUnit];
		}
		if(square(CursorH) < GridMax_X){
			if(Selected){
				if(MvmtBoundH + MvmtBoundV < MvT){
					if(CursorH < MvX){
						CursorH+=grid(1);
						MvmtBoundH--;
					}
					else if(CursorH >= MvX){
						CursorH+=grid(1);
						MvmtBoundH++;
					}
				}
				else if(MvmtBoundH + MvmtBoundV >= MvT && CursorH < MvX){
					CursorH+=grid(1);
					MvmtBoundH--;
				}
				else{
					CursorH+=grid(1);
					MvmtNum = MvT;
				}
				if(MvmtNum <= MvT){
					MvmtNum++;
				}
				CalculatePath.showArrow(SelectedUnit, square(CursorH), square(CursorV), CH, CV);
				//UnitStats.MvmtTracker(MvmtNum, AStats[SelectedUnit][7], MvmtBoundH, MvmtBoundV);
				//System.out.println(MvmtBoundV + "+" + MvmtBoundH);
				
			}
			else{
				CursorH+=grid(1);
			}
			if(CursorH > grid(17) + grid(ShiftX) && CursorH < grid(GridMax_X - 1)){
				ShiftX++;
			}
		}
		CursorMvmt = 1;
	}
	void AllyMvmt(){ //Independent
		KeyBind();
	}
	void EnemyMvmt(){ // Independent
		KeyBind();
	}
	/********* Draw-Related *********/
	void showOptions(){
		gc.setColor(0,0,255);
		gc.fillRect(0, grid(8), grid(20), grid(2));
		gc.setColor(255,255,255);
		gc.setFont(font, Font.PLAIN, 40);
		gc.drawCenterString(UnitStats.LSetting[Lang], 320, grid(4));
		gc.setFont("小塚ゴシック Pro　H", Font.BOLD, 30);
		gc.drawString("日本語", grid(2)+16, grid(8)+12);
		gc.setFont("Trebuchet MS", Font.BOLD, 30);
		gc.drawString("English", grid(8)+16, grid(8)+12);
		gc.setFont("Ancient Heron Tongue", Font.PLAIN, 30);
		gc.drawString("Galldr", grid(14)+16, grid(8)+12);
		gc.setFont(font, Font.PLAIN, 18);
		gc.drawClipImage(74, lSelec, grid(8)+4, 0, 400, 102, 58);
		
		
		if(gc.isKeyPushed(gc.KEY_D) && turn == Ally || gc.isKeyPushed(gc.KEY_L) && turn == Enemy){
			if(lSelec < grid(14)+8){
				lSelec+=grid(6)-4;
			}
		}
		if(gc.isKeyPushed(gc.KEY_A) && turn == Ally || gc.isKeyPushed(gc.KEY_J) && turn == Enemy){
			if(lSelec > grid(2)+16){
				lSelec-=grid(6)-4;
			}
		}
		if(gc.isKeyPushed(gc.KEY_M) && turn == Ally || gc.isKeyPushed(gc.KEY_RIGHT) && turn == Enemy){
			if(lSelec == 80){
				font = "小塚ゴシック Pro　H";
			}
			else if(lSelec == 268){
				font = "Trebuchet MS";
			}
			else if(lSelec == 456){
				font = "Ancient Heron Tongue";
			}
		}
		if(gc.isKeyPushed(gc.KEY_B) && turn == Ally || gc.isKeyPushed(gc.KEY_LEFT) && turn == Enemy){
			GameState = Game_Session;
		}
	}
	void drawArrows(){ //Independent
		if((turn == Ally && SelectedSide == Ally) || (turn == Enemy && SelectedSide == Enemy)){
			for(int i=0; i<=CalculatePath.MaxIndex; i++){
				if(pathDirection[i] == "RStart"){
					gc.drawClipImage(15, grid(pathX[i])-grid(ShiftX), grid(pathY[i])-grid(ShiftY), 0, 0, 32, 32);
				} else if(pathDirection[i] == "UStart"){
					gc.drawClipImage(15, grid(pathX[i])-grid(ShiftX), grid(pathY[i])-grid(ShiftY), 0, 32, 32, 32);
				} else if(pathDirection[i] == "LStart"){
					gc.drawClipImage(15, grid(pathX[i])-grid(ShiftX), grid(pathY[i])-grid(ShiftY), 32, 32, 32, 32);
				} else if(pathDirection[i] == "DStart"){
					gc.drawClipImage(15, grid(pathX[i])-grid(ShiftX), grid(pathY[i])-grid(ShiftY), 32, 0, 32, 32);
				} else if(pathDirection[i] == "RArrow"){
					gc.drawClipImage(15, grid(pathX[i])-grid(ShiftX), grid(pathY[i])-grid(ShiftY), 192, 0, 32, 32);
				} else if(pathDirection[i] == "UArrow"){
					gc.drawClipImage(15, grid(pathX[i])-grid(ShiftX), grid(pathY[i])-grid(ShiftY), 192, 32, 32, 32);
				} else if(pathDirection[i] == "LArrow"){
					gc.drawClipImage(15, grid(pathX[i])-grid(ShiftX), grid(pathY[i])-grid(ShiftY), 224, 32, 32, 32);
				} else if(pathDirection[i] == "DArrow"){
					gc.drawClipImage(15, grid(pathX[i])-grid(ShiftX), grid(pathY[i])-grid(ShiftY), 224, 0, 32, 32);
				} else if(pathDirection[i] == "NorthWest" || pathDirection[i] == "WestNorth"){
					gc.drawClipImage(15, grid(pathX[i])-grid(ShiftX), grid(pathY[i])-grid(ShiftY), 160, 32, 32, 32);
				} else if(pathDirection[i] == "NorthEast" || pathDirection[i] == "EastNorth"){
					gc.drawClipImage(15, grid(pathX[i])-grid(ShiftX), grid(pathY[i])-grid(ShiftY), 128, 32, 32, 32);
				} else if(pathDirection[i] == "SouthEast" || pathDirection[i] == "EastSouth"){
					gc.drawClipImage(15, grid(pathX[i])-grid(ShiftX), grid(pathY[i])-grid(ShiftY), 128, 0, 32, 32);
				} else if(pathDirection[i] == "SouthWest" || pathDirection[i] == "WestSouth"){
					gc.drawClipImage(15, grid(pathX[i])-grid(ShiftX), grid(pathY[i])-grid(ShiftY), 160, 0, 32, 32);
				} else if(pathDirection[i] == "HorizontalL" || pathDirection[i] == "HorizontalR"){
					gc.drawClipImage(15, grid(pathX[i])-grid(ShiftX), grid(pathY[i])-grid(ShiftY), 96, 0, 32, 32);
				} else if(pathDirection[i] == "VerticalD" || pathDirection[i] == "VerticalU"){
					gc.drawClipImage(15, grid(pathX[i])-grid(ShiftX), grid(pathY[i])-grid(ShiftY), 64, 0, 32, 32);
				}
			}
		}
	}
	void drawCursor(){ //Independent
		//System.out.println(cursor_hover);
		if(cursor_hover){
			gc.drawImage(1, CursorH-5-grid(ShiftX), CursorV-5-grid(ShiftY));
		}
		else{
			/*if(CursorAnimation%8 == 0){
				CursorMvmt++;
				if(CursorMvmt>3){
					CursorMvmt=1;
				}
			}*/
			gc.drawImage(2, CursorH-5-grid(ShiftX), CursorV-5-grid(ShiftY));
		}
	}
	void reset(){ //Independent
		if(Selected){
			if(SelectedSide == Ally && turn == Ally){
				ALocationX[SelectedUnit] = grid(CH);
				ALocationY[SelectedUnit] = grid(CV);
				//System.out.println("After: " + ALocationX[SelectedUnit] + ", " + ALocationY[SelectedUnit]);
				CursorH = ALocationX[SelectedUnit];
				CursorV = ALocationY[SelectedUnit];
				AStatus[SelectedUnit][1] = false;
			}
			else if(SelectedSide == Enemy && turn == Enemy){
				ELocationX[SelectedUnit] = grid(CH);
				ELocationY[SelectedUnit] = grid(CV);
				CursorH = ELocationX[SelectedUnit];
				CursorV = ELocationY[SelectedUnit];
				EStatus[SelectedUnit][1] = false;
			}
			for(int i=0; i<6; i++){
				commands[i] = false;
			}
			MvmtBoundV = 0;
			MvmtBoundH = 0;
			MvmtNum = 0;
			Selected = false;
			mvtInitialized = false;
			alMoved = false;
			IgnoreB = false;
		}
		clearMvmtSquare();
		if(Menu){
			Menu = false;
		}
		ButtonStage = 0;
		HideCursor = false;
	}
	void drawUnits(){ //Independent. might need editing for direction facing
		for(int i=99; i>=0; i--){
			/** Ally **/
			if(AAlive[i] && !AStatus[i][1] && !AStatus[i][0] && !AMoved[i]){
				gc.drawScaledRotateImage(UnitStats.UnitType(Ally, i, "Idle"), ALocationX[i]+SquareSize/2 -grid(ShiftX), ALocationY[i]+SquareSize/2 - grid(ShiftY) -10, unit_zoom, unit_zoom, 0);
				occupied[square(ALocationX[i])][square(ALocationY[i])] = Ally;
				//System.out.println(returnUnit);
			}
			else if(AAlive[i] && !AStatus[i][1] && AStatus[i][0] && !AMoved[i] && turn == Ally){
				cursor_hover = true;
				see_data = i;
				gc.drawScaledRotateImage(UnitStats.UnitType(Ally, i, "Active"), ALocationX[i]+SquareSize/2 -grid(ShiftX), ALocationY[i]+SquareSize/2 - grid(ShiftY) -10, unit_zoom, unit_zoom, 0);
				SelectedAnimate = 0;
				occupied[square(ALocationX[i])][square(ALocationY[i])] = Ally;
				//System.out.println(returnUnit);
			}
			else if(AAlive[i] && AStatus[i][1] && !AStatus[i][2] && !AMoved[i] && turn == Ally){
				gc.drawScaledRotateImage(UnitStats.UnitType(Ally, i, "Running"), ALocationX[i]+SquareSize/2 -grid(ShiftX), ALocationY[i]+SquareSize/2 - grid(ShiftY) -10, unit_zoom, unit_zoom, 0);
				occupied[square(ALocationX[i])][square(ALocationY[i])] = Ally;
			}
			else if(AAlive[i] && AStatus[i][1] && AStatus[i][2] && AStatus[i][3] && AStatus[i][4] && !AMoved[i] && turn == Ally){
				gc.drawScaledRotateImage(UnitStats.UnitType(Ally, i, "Right"), ALocationX[i]+SquareSize/2 -grid(ShiftX) + MvAnim, ALocationY[i]+SquareSize/2 - grid(ShiftY) -10, -unit_zoom, unit_zoom, 0);
				occupied[square(ALocationX[i])][square(ALocationY[i])] = Ally;
			}
			else if(AAlive[i] && AStatus[i][1] && AStatus[i][2] && AStatus[i][3] && !AStatus[i][4] && !AMoved[i] && turn == Ally){
				gc.drawScaledRotateImage(UnitStats.UnitType(Ally, i, "Left"), ALocationX[i]+SquareSize/2 -grid(ShiftX) - MvAnim, ALocationY[i]+SquareSize/2 - grid(ShiftY) -10, unit_zoom, unit_zoom, 0);
				occupied[square(ALocationX[i])][square(ALocationY[i])] = Ally;
			}
			else if(AAlive[i] && AStatus[i][1] && AStatus[i][2] && !AStatus[i][3] && AStatus[i][4] && !AMoved[i] && turn == Ally){
				gc.drawScaledRotateImage(UnitStats.UnitType(Ally, i, "Up"), ALocationX[i]+SquareSize/2 -grid(ShiftX), ALocationY[i]+SquareSize/2 - grid(ShiftY) -10 - MvAnim, unit_zoom, unit_zoom, 0);
				occupied[square(ALocationX[i])][square(ALocationY[i])] = Ally;
			}
			else if(AAlive[i] && AStatus[i][1] && AStatus[i][2] && !AStatus[i][3] && !AStatus[i][4] && !AMoved[i] && turn == Ally){
				gc.drawScaledRotateImage(UnitStats.UnitType(Ally, i, "Down"), ALocationX[i]+SquareSize/2 -grid(ShiftX), ALocationY[i]+SquareSize/2 - grid(ShiftY) -10 + MvAnim, unit_zoom, unit_zoom, 0);
				occupied[square(ALocationX[i])][square(ALocationY[i])] = Ally;
			}
			else if(AAlive[i] && AMoved[i] && turn == Ally){
				gc.drawScaledRotateImage(UnitStats.UnitType(Ally, i, "Wait"), ALocationX[i]+SquareSize/2 -grid(ShiftX), ALocationY[i]+SquareSize/2 - grid(ShiftY) -10, unit_zoom, unit_zoom, 0);
				occupied[square(ALocationX[i])][square(ALocationY[i])] = Ally;
			}
			
			if(AAlive[i]){
				gc.setColor(0,0,0);
				gc.fillRect(ALocationX[i] -grid(ShiftX) -1, ALocationY[i] - grid(ShiftY) +29, 34, 6);
				gc.drawClipImage(146, ALocationX[i]-grid(ShiftX), ALocationY[i] - grid(ShiftY) +30, 0, 0, 32*(AHP[i][0]*100/AHP[i][1])/100, 4);
			}
			
			/** Enemy **/
			if(EAlive[i] && !EStatus[i][1] && !EStatus[i][0] && !EMoved[i]){
				gc.drawScaledRotateImage(UnitStats.UnitType(Enemy, i, "Idle"), ELocationX[i]+SquareSize/2 -grid(ShiftX), ELocationY[i]+SquareSize/2 - grid(ShiftY) -10, unit_zoom, unit_zoom, 0);
				occupied[square(ELocationX[i])][square(ELocationY[i])] = Enemy;
				//System.out.println(returnUnit);
			}
			else if(EAlive[i] && !EStatus[i][1] && EStatus[i][0] && !EMoved[i] && turn == Enemy){
				cursor_hover = true;
				see_data = i;
				gc.drawScaledRotateImage(UnitStats.UnitType(Enemy, i, "Active"), ELocationX[i]+SquareSize/2 -grid(ShiftX), ELocationY[i]+SquareSize/2 - grid(ShiftY) -10, unit_zoom, unit_zoom, 0);
				SelectedAnimate = 0;
				occupied[square(ELocationX[i])][square(ELocationY[i])] = Enemy;
				//System.out.println(returnUnit);
			}
			else if(EAlive[i] && EStatus[i][1]  && !EStatus[i][2] && !EMoved[i] && turn == Enemy){
				gc.drawScaledRotateImage(UnitStats.UnitType(Enemy, i, "Running"), ELocationX[i]+SquareSize/2 -grid(ShiftX) + MvAnim, ELocationY[i]+SquareSize/2 - grid(ShiftY) -10, unit_zoom, unit_zoom, 0);
				occupied[square(ELocationX[i])][square(ELocationY[i])] = Enemy;
			}
			else if(EAlive[i] && EStatus[i][1] && EStatus[i][2] && EStatus[i][3] && EStatus[i][4] && !EMoved[i] && turn == Enemy){
				gc.drawScaledRotateImage(UnitStats.UnitType(Enemy, i, "Right"), ELocationX[i]+SquareSize/2 -grid(ShiftX) + MvAnim, ELocationY[i]+SquareSize/2 - grid(ShiftY) -10, -unit_zoom, unit_zoom, 0);
				occupied[square(ELocationX[i])][square(ELocationY[i])] = Enemy;
			}
			else if(EAlive[i] && EStatus[i][1] && EStatus[i][2] && EStatus[i][3] && !EStatus[i][4] && !EMoved[i] && turn == Enemy){
				gc.drawScaledRotateImage(UnitStats.UnitType(Enemy, i, "Left"), ELocationX[i]+SquareSize/2 -grid(ShiftX) - MvAnim, ELocationY[i]+SquareSize/2 - grid(ShiftY) -10, unit_zoom, unit_zoom, 0);
				occupied[square(ELocationX[i])][square(ELocationY[i])] = Enemy;
			}
			else if(EAlive[i] && EStatus[i][1] && EStatus[i][2] && !EStatus[i][3] && EStatus[i][4] && !EMoved[i] && turn == Enemy){
				gc.drawScaledRotateImage(UnitStats.UnitType(Enemy, i, "Up"), ELocationX[i]+SquareSize/2 -grid(ShiftX), ELocationY[i]+SquareSize/2 - grid(ShiftY) -10 - MvAnim, unit_zoom, unit_zoom, 0);
				occupied[square(ELocationX[i])][square(ELocationY[i])] = Enemy;
			}
			else if(EAlive[i] && EStatus[i][1] && EStatus[i][2] && !EStatus[i][3] && !EStatus[i][4] && !EMoved[i] && turn == Enemy){
				gc.drawScaledRotateImage(UnitStats.UnitType(Enemy, i, "Down"), ELocationX[i]+SquareSize/2 -grid(ShiftX), ELocationY[i]+SquareSize/2 - grid(ShiftY) -10 + MvAnim, unit_zoom, unit_zoom, 0);
				occupied[square(ELocationX[i])][square(ELocationY[i])] = Enemy;
			}
			else if(EAlive[i] && EMoved[i] && turn == Enemy){
				gc.drawScaledRotateImage(UnitStats.UnitType(Enemy, i, "Wait"), ELocationX[i]+SquareSize/2 -grid(ShiftX), ELocationY[i]+SquareSize/2 - grid(ShiftY) -10, unit_zoom, unit_zoom, 0);
				occupied[square(ELocationX[i])][square(ELocationY[i])] = Enemy;
			}
			if(EAlive[i]){
				gc.setColor(0,0,0);
				gc.fillRect(ELocationX[i] -grid(ShiftX) -1, ELocationY[i] - grid(ShiftY) +29, 34, 6);
				gc.drawClipImage(145, ELocationX[i]-grid(ShiftX), ELocationY[i] - grid(ShiftY) +30, 0, 0, 32*(EHP[i][0]*100/EHP[i][1])/100, 4);
			}

		}
		
	}
	void drawCanvas(){ //Independent
		gc.setColor(255,0,0);
		gc.fillRect(tlX(4, grid(4)-16,mapsize[0])-5, tlY(4, grid(6) - grid(MapShiftY * 7),mapsize[0])-4, gc.getImageWidth(4)*mapsize[0]/100 + 9, gc.getImageHeight(4)*mapsize[0]/100 + 8);
		gc.fillRect(tlX(5, grid(10),mapsize[1])-5, tlY(5, grid(6) - grid(MapShiftY * 7), mapsize[1])-4, gc.getImageWidth(5)*mapsize[1]/100 + 9, gc.getImageHeight(5)*mapsize[1]/100 + 8);
		gc.fillRect(tlX(6, grid(16)+16, mapsize[2])-5, tlY(6, grid(6) - grid(MapShiftY * 7), mapsize[2])-5, gc.getImageWidth(6)*mapsize[2]/100 + 9, gc.getImageHeight(6)*mapsize[2]/100 + 9);
		
		gc.fillRect(tlX(7, grid(4)-16, mapsize[3])-5, tlY(7, grid(15) - grid(MapShiftY * 7), mapsize[3])-4, gc.getImageWidth(7)*mapsize[3]/100 + 9, gc.getImageHeight(7)*mapsize[3]/100 + 8);
		gc.fillRect(tlX(8, grid(10), mapsize[4])-5, tlY(8, grid(15) - grid(MapShiftY * 7), mapsize[4])-5, gc.getImageWidth(8)*mapsize[4]/100 + 9, gc.getImageHeight(8)*mapsize[4]/100 + 9);
		gc.fillRect(tlX(9, grid(16)+16, mapsize[5])-5, tlY(9, grid(15) - grid(MapShiftY * 7), mapsize[5])-4, gc.getImageWidth(9)*mapsize[5]/100 + 9, gc.getImageHeight(9)*mapsize[5]/100 + 8);
		
		gc.fillRect(tlX(10, grid(4)-16, mapsize[6])-4, tlY(10, grid(23) - grid(MapShiftY * 7), mapsize[6])-4, gc.getImageWidth(10)*mapsize[6]/100 + 8, gc.getImageHeight(10)*mapsize[6]/100 + 8);
		gc.fillRect(tlX(11, grid(10), mapsize[7])-5, tlY(11, grid(23) - grid(MapShiftY * 7), mapsize[7])-3, gc.getImageWidth(11)*mapsize[7]/100 + 9, gc.getImageHeight(11)*mapsize[7]/100 + 7);
		gc.fillRect(tlX(12, grid(16)+16, mapsize[8])-5, tlY(12, grid(23) - grid(MapShiftY * 7), mapsize[8])-4, gc.getImageWidth(12)*mapsize[8]/100 + 9, gc.getImageHeight(12)*mapsize[8]/100 + 8);
	}
	void drawHighlights(){ // Independent
		gc.setColor(0,255,255);
		switch(map_chosen){
			case 4:	gc.fillRect(tlX(map_chosen, grid(4)-16, mapsize[0])-5, tlY(map_chosen, grid(6), mapsize[0])-4, gc.getImageWidth(map_chosen)*mapsize[0]/100 + 9, gc.getImageHeight(map_chosen)*mapsize[0]/100 + 8);
					break;
			case 5:	gc.fillRect(tlX(map_chosen, grid(10), mapsize[1])-5, tlY(map_chosen, grid(6), mapsize[1])-4, gc.getImageWidth(map_chosen)*mapsize[1]/100 + 9, gc.getImageHeight(map_chosen)*mapsize[1]/100 + 8);
					break;
			case 6: gc.fillRect(tlX(map_chosen, grid(16)+16, mapsize[2])-5, tlY(map_chosen, grid(6), mapsize[2])-5, gc.getImageWidth(map_chosen)*mapsize[2]/100 + 9, gc.getImageHeight(map_chosen)*mapsize[2]/100 + 9);
					break;
			case 7:	gc.fillRect(tlX(map_chosen, grid(4)-16, mapsize[3])-5, tlY(map_chosen, grid(8), mapsize[3])-4, gc.getImageWidth(map_chosen)*mapsize[3]/100 + 9, gc.getImageHeight(map_chosen)*mapsize[3]/100 + 8);
					break;
			case 8: gc.fillRect(tlX(map_chosen, grid(10), mapsize[4])-5, tlY(map_chosen, grid(8), mapsize[4])-5, gc.getImageWidth(map_chosen)*mapsize[4]/100 + 9, gc.getImageHeight(map_chosen)*mapsize[4]/100 + 9);
					break;
			case 9: gc.fillRect(tlX(map_chosen, grid(16)+16, mapsize[5])-5, tlY(map_chosen, grid(8), mapsize[5])-4, gc.getImageWidth(map_chosen)*mapsize[5]/100 + 9, gc.getImageHeight(map_chosen)*mapsize[5]/100 + 8);
					break;
			case 10:gc.fillRect(tlX(map_chosen, grid(4)-16, mapsize[6])-4, tlY(map_chosen, grid(9), mapsize[6])-4, gc.getImageWidth(map_chosen)*mapsize[6]/100 + 8, gc.getImageHeight(map_chosen)*mapsize[6]/100 + 8);
					break;
			case 11:gc.fillRect(tlX(map_chosen, grid(10), mapsize[7])-5, tlY(map_chosen, grid(9), mapsize[7])-4, gc.getImageWidth(map_chosen)*mapsize[7]/100 + 9, gc.getImageHeight(map_chosen)*mapsize[7]/100 + 8);
					break;
			case 12:gc.fillRect(tlX(map_chosen, grid(16)+16, mapsize[8])-5, tlY(map_chosen, grid(9), mapsize[8])-4, gc.getImageWidth(map_chosen)*mapsize[8]/100 + 9, gc.getImageHeight(map_chosen)*mapsize[8]/100 + 8);
					break;
			default:
					break;
		}
	}
	void showMenu(){ // Independent
		int rorl = 0;
		int tileText = 0;
		if(MenuPos == RIGHT){
			rorl = grid(17);
			tileText = grid(18);
		} else if(MenuPos == LEFT){
			rorl = grid(1);
			tileText = grid(2);
		}
		if(!Menu){
			gc.setColor(255, 255, 255);
			gc.fillRect(rorl, grid(12), grid(2), grid(2));
			gc.setColor(0,0,255);
			gc.fillRect(rorl+2, grid(12)+2, grid(2)-4, grid(1)-4);
			gc.setColor(255,255,255);
			gc.setFont(font, Font.PLAIN, 18);
			//System.out.println(square(CursorH) + ", " + square(CursorV));
			gc.drawCenterString(UnitStats.tileName(tile_type[square(CursorH)][square(CursorV)], Lang), tileText, grid(12)+4);//string switch
			gc.setColor(0,0,255);
			gc.setFont(font, fType, 11);
			gc.drawCenterString("Def.", rorl + 17, grid(13)+1);
			gc.drawCenterString("Avo.", rorl + 18, grid(13)+15);
			//System.out.println(square(CursorH) + ", " + square(CursorV) + ", " + MapData.getTerrainBonus(tile_type[square(CursorH)][square(CursorV)], 0));
			gc.drawRightString("" + MapData.getTerrainBonus(tile_type[square(CursorH)][square(CursorV)], 0), rorl + grid(2)-8, grid(13)+1);
			gc.drawRightString("" + MapData.getTerrainBonus(tile_type[square(CursorH)][square(CursorV)], 1), rorl + grid(2)-8, grid(13)+15);
			gc.setFont(font, Font.PLAIN, 18);
		}
		else if(Menu){
			gc.setColor(0, 0, 255);
			gc.fillRect(rorl, grid(2), grid(2), grid(4));
			gc.setColor(255,255,255);
			gc.drawRect(rorl, grid(2), grid(2), grid(4));
			gc.setColor(255,255,255);
			gc.drawCenterString(UnitStats.Help[Lang], rorl+grid(1), grid(2)+16);
			gc.drawCenterString(UnitStats.Options[Lang], rorl+grid(1), grid(3)+16);
			gc.drawCenterString(UnitStats.End[Lang], rorl+grid(1), grid(4)+16);
			gc.drawClipImage(74, rorl+8, optionsM+2, 0, 0, 54, 20);
			if(gc.isKeyPushed(gc.KEY_W) && turn == Ally || gc.isKeyPushed(gc.KEY_I) && turn == Enemy){
				if(optionsM > grid(2)+16){
					optionsM-=grid(1);
				}
			}
			if(gc.isKeyPushed(gc.KEY_S) && turn == Ally || gc.isKeyPushed(gc.KEY_K) && turn == Enemy){
				if(optionsM < grid(4)+16){
					optionsM+=grid(1);
				}
			}
			if(gc.isKeyPushed(gc.KEY_M) && turn == Ally || gc.isKeyPushed(gc.KEY_RIGHT) && turn == Enemy){
				if(optionsM == grid(2)+16){
					System.out.println("helpscreen");
				}
				else if(optionsM == grid(3)+16){
					GameState = OptionsMenu;
				}
				else if(optionsM == grid(4)+16){
					turnEnded = true;
					/*for(int i=0; i<100; i++){
						if(AAlive[i] && turn == Ally){
							unitMoved(Ally, i);
						} else if(EAlive[i] && turn == Enemy){
							unitMoved(Enemy, i);
						}
					}*/
				}
			}
		}
	}
	
	void showCommand(){ //Independent
		int CmdOptions = 1;
		int RorL = RIGHT;
		int optionNum = grid(2) + 4;
		char CmdOptionDetect[] = new char[7];
		int CmdDetect = 0;
		for(int i=0; i<6; i++){
			if(commands[i]){
				CmdOptions++;
			}
		}
		if(MenuPos == RIGHT){
			RorL = grid(17);
		}
		else if(MenuPos == LEFT){
			RorL = grid(1);
		}
		//System.out.println(CH + " " + CV + " " + ALocationX[SelectedUnit] + " " + ALocationY[SelectedUnit]);
		gc.setColor(0, 0, 255);
		gc.fillRect(RorL, grid(2), grid(2), grid(CmdOptions));
		gc.setColor(255,255,255);
		gc.drawRect(RorL, grid(2), grid(2), grid(CmdOptions));
		if(commands[0]){
			gc.drawString(UnitStats.Fight[Lang], RorL + 3, optionNum);
			optionNum+=grid(1);
			CmdOptionDetect[CmdDetect] = 'A';
			CmdDetect++;
		}
		if(commands[1]){
			gc.drawString(UnitStats.Heal[Lang], RorL + 3, optionNum);
			optionNum+=grid(1);
			CmdOptionDetect[CmdDetect] = 'H';
			CmdDetect++;
		}
		if(commands[2]){
			gc.drawString(UnitStats.Dance[Lang], RorL + 3, optionNum);
			optionNum+=grid(1);
			CmdOptionDetect[CmdDetect] = 'D';
			CmdDetect++;
		}
		if(commands[3]){
			gc.drawString(UnitStats.Rescue[Lang], RorL + 3, optionNum);
			optionNum+=grid(1);
			CmdOptionDetect[CmdDetect] = 'R';
			CmdDetect++;
		}
		if(commands[4]){
			gc.drawString(UnitStats.Items[Lang], RorL + 3, optionNum);
			optionNum+=grid(1);
			CmdOptionDetect[CmdDetect] = 'I';
			CmdDetect++;
		}
		if(commands[5]){
			gc.setColor(0,255,0);
			gc.drawString(UnitStats.Trade[Lang], RorL + 3, optionNum);
			optionNum+=grid(1);
			gc.setColor(255,255,255);
			CmdOptionDetect[CmdDetect] = 'T';
			CmdDetect++;
		}
		gc.drawString(UnitStats.Wait[Lang], RorL + 3, optionNum);
		CmdOptionDetect[CmdDetect] = 'W';
		gc.drawClipImage(74, RorL+3, selection, 0, 0, 54, 20);
		
		if(gc.isKeyPushed(gc.KEY_W) && turn == Ally || gc.isKeyPushed(gc.KEY_I) && turn == Enemy){
			if(selection > grid(2)+8){
				selection-=grid(1);
				commandLoc--;
			}
		}
		if(gc.isKeyPushed(gc.KEY_S) && turn == Ally || gc.isKeyPushed(gc.KEY_K) && turn == Enemy){
			if(selection < optionNum){
				selection+=grid(1);
				commandLoc++;
			}
		}
		if(gc.isKeyPushed(gc.KEY_M) && turn == Ally || gc.isKeyPushed(gc.KEY_RIGHT) && turn == Enemy){
			if(CmdOptionDetect[commandLoc] == 'W'){
				//if(SelectedSide == Ally){
				unitMoved(SelectedSide, SelectedUnit);
				//}
			}
			else if(CmdOptionDetect[commandLoc] == 'I'){
				selectionI1 = grid(1);
				commandHold = commandLoc;
				commandLoc = 0;
				ItemLookup = true;
				AButtonUnlocked = 0;
			}
			else if(CmdOptionDetect[commandLoc] == 'A'){
				String sctWeapon = null;
				int LocX = 0;
				int LocY = 0;
				commandLocA1 = 0;
				selectionA1 = grid(1);
				for(int i=0; i<5; i++){
					WeaponId[i] = -1;
				}
				indx = 0;
				for(int i=0; i<5; i++){
					if(turn == Ally){
						sctWeapon = AWeapon[SelectedUnit][i];
					} else if(turn == Enemy){
						sctWeapon = EWeapon[SelectedUnit][i];
					}
					//CalculatePath.checkAttackRange(turn, SelectedUnit);
					if(sctWeapon!= null){
						//System.out.println("sctweapon!= null");
						if(WeaponData.rWeaponInfo(sctWeapon, 3) != "Special"){
							for(int j=0; j<100; j++){
								if(turn == Ally){
									LocX = ELocationX[j];
									LocY = ELocationY[j];
								} else if(turn == Enemy){
									LocX = ALocationX[j];
									LocY = ALocationY[j];
								}
								if(weaponR[i][square(LocX)][square(LocY)] == RED){
									WeaponId[indx] = i;
									//System.out.println("Weapon List: " + indx + " = " + i);
									indx++;
									break;
								}
							}
						}
					}
				}
				//System.out.println(indx);
				atkStg = 1;
			}
		}
		else if(gc.isKeyPushed(gc.KEY_B) && turn == Ally || gc.isKeyPushed(gc.KEY_LEFT) && turn == Enemy){
			selection = 64+8;
			ButtonStage = 4;
			commandLoc = 0;
		}
	}
	void unitMoved(int side, int uSelect){
		if(side == Ally){
			AMoved[uSelect] = true;
			AStatus[uSelect][1] = false;
			AStatus[uSelect][2] = false;
			CursorH = ALocationX[uSelect];
			CursorV = ALocationY[uSelect];
			waitTimer = 1;
		} else if(side == Enemy){
			EMoved[uSelect] = true;
			EStatus[uSelect][1] = false;
			EStatus[uSelect][2] = false;
			CursorH = ELocationX[uSelect];
			CursorV = ELocationY[uSelect];
			waitTimer = 1;
		}
		waitCommand();
		startChoose = false;
	}
	void displayWpChoice(){ //Independent
		int CmdOptions = 1;
		int optionNum = 1;
		int CmdOptionDetect[] = new int[5];
		gc.setColor(255,255,255);
		gc.fillRect(grid(1)-5, grid(1)-5, grid(7)+10, grid(indx)+10);
		gc.setColor(0,0,255);
		gc.fillRect(grid(1)-4, grid(1)-4, grid(7)+8, grid(indx)+8);
		gc.setColor(255,255,255);
		if(indx > 0){
			//System.out.println("1st");
			if(turn == Ally){
				gc.drawClipImage(147, grid(1)-2, grid(1)-2, WeaponData.rWeaponDat(AWeapon[SelectedUnit][WeaponId[0]], 6), WeaponData.rWeaponDat(AWeapon[SelectedUnit][WeaponId[0]], 7), 32, 32);
				gc.drawString("" + WeaponData.rWeaponInfo(AWeapon[SelectedUnit][WeaponId[0]], Lang), grid(2), grid(1));
				gc.drawRightString("" + AWeaponDur[SelectedUnit][WeaponId[0]][0], grid(7)-2, grid(1));
				gc.drawRightString("" + AWeaponDur[SelectedUnit][WeaponId[0]][1], grid(8)-2, grid(1));
			} else if (turn == Enemy){
				gc.drawClipImage(147, grid(1)-2, grid(1)-2, WeaponData.rWeaponDat(EWeapon[SelectedUnit][WeaponId[0]], 6), WeaponData.rWeaponDat(EWeapon[SelectedUnit][WeaponId[0]], 7), 32, 32);
				gc.drawString("" + WeaponData.rWeaponInfo(EWeapon[SelectedUnit][WeaponId[0]], Lang), grid(2), grid(1));
				gc.drawRightString("" + EWeaponDur[SelectedUnit][WeaponId[0]][0], grid(7)-2, grid(1));
				gc.drawRightString("" + EWeaponDur[SelectedUnit][WeaponId[0]][1], grid(8)-2, grid(1));
			}
			gc.drawRightString("/", grid(7)+6, grid(1));
			CmdOptionDetect[optionNum-1] = 0;
			wpList[0] = WeaponId[0];
			optionNum++;
		}if(indx > 1){
			//System.out.println("2nd");
			if(turn == Ally){
				gc.drawClipImage(147, grid(1)-2, grid(2)-2, WeaponData.rWeaponDat(AWeapon[SelectedUnit][WeaponId[1]], 6), WeaponData.rWeaponDat(AWeapon[SelectedUnit][WeaponId[1]], 7), 32, 32);
				gc.drawString("" + WeaponData.rWeaponInfo(AWeapon[SelectedUnit][WeaponId[1]], Lang), grid(2), grid(2));
				gc.drawRightString("" + AWeaponDur[SelectedUnit][WeaponId[1]][0], grid(7)-2, grid(2));
				gc.drawRightString("" + AWeaponDur[SelectedUnit][WeaponId[1]][1], grid(8)-2, grid(2));
			} else if(turn == Enemy){
				gc.drawClipImage(147, grid(1)-2, grid(2)-2, WeaponData.rWeaponDat(EWeapon[SelectedUnit][WeaponId[1]], 6), WeaponData.rWeaponDat(EWeapon[SelectedUnit][WeaponId[1]], 7), 32, 32);
				gc.drawString("" + WeaponData.rWeaponInfo(EWeapon[SelectedUnit][WeaponId[1]], Lang), grid(2), grid(2));
				gc.drawRightString("" + EWeaponDur[SelectedUnit][WeaponId[1]][0], grid(7)-2, grid(2));
				gc.drawRightString("" + EWeaponDur[SelectedUnit][WeaponId[1]][1], grid(8)-2, grid(2));
			}
			gc.drawRightString("/", grid(7)+6, grid(2));
			CmdOptionDetect[optionNum-1] = 1;
			wpList[1] = WeaponId[1];
			optionNum++;
		}if(indx > 2){
			//System.out.println("3rd");
			if(turn == Ally){
				gc.drawClipImage(147, grid(1)-2, grid(3)-2, WeaponData.rWeaponDat(AWeapon[SelectedUnit][WeaponId[2]], 6), WeaponData.rWeaponDat(AWeapon[SelectedUnit][WeaponId[2]], 7), 32, 32);
				gc.drawString("" + WeaponData.rWeaponInfo(AWeapon[SelectedUnit][WeaponId[2]], Lang), grid(2), grid(3));
				gc.drawRightString("" + AWeaponDur[SelectedUnit][WeaponId[2]][0], grid(7)-2, grid(3));
				gc.drawRightString("" + AWeaponDur[SelectedUnit][WeaponId[2]][1], grid(8)-2, grid(3));
			} else if(turn == Enemy){
				gc.drawClipImage(147, grid(1)-2, grid(3)-2, WeaponData.rWeaponDat(EWeapon[SelectedUnit][WeaponId[2]], 6), WeaponData.rWeaponDat(EWeapon[SelectedUnit][WeaponId[2]], 7), 32, 32);
				gc.drawString("" + WeaponData.rWeaponInfo(EWeapon[SelectedUnit][WeaponId[2]], Lang), grid(2), grid(3));
				gc.drawRightString("" + EWeaponDur[SelectedUnit][WeaponId[2]][0], grid(7)-2, grid(3));
				gc.drawRightString("" + EWeaponDur[SelectedUnit][WeaponId[2]][1], grid(8)-2, grid(3));
			}
			gc.drawRightString("/", grid(7)+6, grid(3));
			CmdOptionDetect[optionNum-1] = 2;
			wpList[2] = WeaponId[2];
			optionNum++;
		}if(indx > 3){
			//System.out.println("4th");
			if(turn == Ally){
				gc.drawClipImage(147, grid(1)-2, grid(4)-2, WeaponData.rWeaponDat(AWeapon[SelectedUnit][WeaponId[3]], 6), WeaponData.rWeaponDat(AWeapon[SelectedUnit][WeaponId[3]], 7), 32, 32);
				gc.drawString("" + WeaponData.rWeaponInfo(AWeapon[SelectedUnit][WeaponId[3]], Lang), grid(2), grid(4));
				gc.drawRightString("" + AWeaponDur[SelectedUnit][WeaponId[3]][0], grid(7)-2, grid(4));
				gc.drawRightString("" + AWeaponDur[SelectedUnit][WeaponId[3]][1], grid(8)-2, grid(4));
			} else if(turn == Enemy){
				gc.drawClipImage(147, grid(1)-2, grid(4)-2, WeaponData.rWeaponDat(EWeapon[SelectedUnit][WeaponId[3]], 6), WeaponData.rWeaponDat(EWeapon[SelectedUnit][WeaponId[3]], 7), 32, 32);
				gc.drawString("" + WeaponData.rWeaponInfo(EWeapon[SelectedUnit][WeaponId[3]], Lang), grid(2), grid(4));
				gc.drawRightString("" + EWeaponDur[SelectedUnit][WeaponId[3]][0], grid(7)-2, grid(4));
				gc.drawRightString("" + EWeaponDur[SelectedUnit][WeaponId[3]][1], grid(8)-2, grid(4));
			}
			gc.drawRightString("/", grid(7)+6, grid(4));
			CmdOptionDetect[optionNum-1] = 3;
			wpList[3] = WeaponId[3];
			optionNum++;
		}if(indx > 4){
			//System.out.println("5th");
			if(turn == Ally){
				gc.drawClipImage(147, grid(1)-2, grid(5)-2, WeaponData.rWeaponDat(AWeapon[SelectedUnit][WeaponId[4]], 6), WeaponData.rWeaponDat(AWeapon[SelectedUnit][WeaponId[4]], 7), 32, 32);
				gc.drawString("" + WeaponData.rWeaponInfo(AWeapon[SelectedUnit][WeaponId[4]], Lang), grid(2), grid(5));
				gc.drawRightString("" + AWeaponDur[SelectedUnit][WeaponId[4]][0], grid(7)-2, grid(5));
				gc.drawRightString("" + AWeaponDur[SelectedUnit][WeaponId[4]][1], grid(8)-2, grid(5));
			} else if(turn == Enemy){
				gc.drawClipImage(147, grid(1)-2, grid(5)-2, WeaponData.rWeaponDat(EWeapon[SelectedUnit][WeaponId[4]], 6), WeaponData.rWeaponDat(EWeapon[SelectedUnit][WeaponId[4]], 7), 32, 32);
				gc.drawString("" + WeaponData.rWeaponInfo(EWeapon[SelectedUnit][WeaponId[4]], Lang), grid(2), grid(5));
				gc.drawRightString("" + EWeaponDur[SelectedUnit][WeaponId[4]][0], grid(7)-2, grid(5));
				gc.drawRightString("" + EWeaponDur[SelectedUnit][WeaponId[4]][1], grid(8)-2, grid(5));
			}
			gc.drawRightString("/", grid(7)+6, grid(5));
			CmdOptionDetect[optionNum-1] = 4;
			wpList[4] = WeaponId[4];
			optionNum++;
		}
		gc.drawClipImage(74, grid(2), selectionA1 + 8, 0, 370, 54, 20);
		/*System.out.println("" + commandLocA1 + ", " + wpNb);
		System.out.println("" + AWeapon[SelectedUnit][wpNb]);
		for(int i=0; i<5; i++){
			System.out.println(i + " = " + AWeapon[SelectedUnit][WeaponId[i]]);
		}*/
		if(gc.isKeyPushed(gc.KEY_W) && turn == Ally || gc.isKeyPushed(gc.KEY_I) && turn == Enemy){
			if(selectionA1 > grid(1)){
				selectionA1-=grid(1);
				commandLocA1--;
			}
		}
		else if(gc.isKeyPushed(gc.KEY_S) && turn == Ally || gc.isKeyPushed(gc.KEY_K) && turn == Enemy){
			if(selectionA1 < grid(optionNum-1)){
				selectionA1+=grid(1);
				commandLocA1++;
			}
		}
		wpNb = wpList[commandLocA1];
		if(gc.isKeyPushed(gc.KEY_M) && gaveTime && turn == Ally || gc.isKeyPushed(gc.KEY_RIGHT) && gaveTime && turn == Enemy){
			// Choose enemy
			//System.out.println(AWeapon[SelectedUnit][wpNb]);
			//System.out.println("wpNb = " + wpNb);
			possibleEnemyTarget();
			atkStg = 2;
		}
		
		//System.out.println("wpNb after = " + wpNb);
		weaponInitialized = true;
		if(gc.isKeyPushed(gc.KEY_B) && turn == Ally || gc.isKeyPushed(gc.KEY_LEFT) && turn == Enemy){
			if(atkStg == 1){
				selection = 64+8;
				weaponInitialized = false;
				atkStg = 0;
				commandLocA1 = 0;
				gaveTime = false;
				selectionA1 = grid(1);
				for(int i=0; i<5; i++){
					WeaponId[i] = -1;
				}
			}
		}
	}
	void possibleEnemyTarget(){ //Independent
		//System.out.println("Runnning");
		int xC = 0;
		int yC = 0;
		for(int i=0; i<100; i++){
			TargetId[i] = -1;
		}
		targetIdx = 0;
		//System.out.println("Reset");
		for(int i=0; i<100; i++){
			if(turn == Ally){
				xC = square(ELocationX[i]);
				yC = square(ELocationY[i]);
			}
			else if(turn == Enemy){
				xC = square(ALocationX[i]);
				yC = square(ALocationY[i]);
			}
			//System.out.println("weaponR = " +  wpNb + " + " + weaponR[wpNb][7][22]);
			if(weaponR[wpNb][xC][yC] == RED){ //wpNb
				TargetId[targetIdx] = i;
				targetIdx++;
			}
		}
		
		/*for(int i=0; TargetId[i]!= -1; i++){
			System.out.println(i + ", " + TargetId[i] + ", " + AUnit[TargetId[i]]);
		}
		for(int i = 0; i<targetIdx; i++){
			System.out.println(i + " = " + TargetId[i]);
		}*/
		atkIdx = 0;
		aX = 0;
		aY = 0;
		
		
	}

	void chooseEnemy(){ //Independent
		aDmg = 0;
		dDef = 0;
		dDmg = 0;
		aDef = 0;
		int rl = 0;
		if(MenuPos == RIGHT){
			rl = grid(15)-16;
		} else if(MenuPos == LEFT){
			rl = 16;
		}
		
		//System.out.println("" + targetIdx);
		if((gc.isKeyPushed(gc.KEY_W) || gc.isKeyPushed(gc.KEY_D)) && turn == Ally || (gc.isKeyPushed(gc.KEY_I) || gc.isKeyPushed(gc.KEY_L)) && turn == Enemy){
			if(targetIdx > 1){
				if(atkIdx < targetIdx-1){
					atkIdx++;
				}else if(atkIdx >= targetIdx-1){
					atkIdx = 0;
				}
			}
		}
		else if((gc.isKeyPushed(gc.KEY_S) || gc.isKeyPushed(gc.KEY_A)) && turn == Ally || (gc.isKeyPushed(gc.KEY_J) || gc.isKeyPushed(gc.KEY_K)) && turn == Enemy){
			if(targetIdx > 1){
				if(atkIdx > 0){
					atkIdx--;
				}else if(atkIdx <= 0){
					atkIdx = targetIdx-1;
				}
			}
		}
		//System.out.println("" + atkIdx + "," + TargetId[atkIdx]);
		if(turn == Ally){
			aX = ELocationX[TargetId[atkIdx]];
			aY = ELocationY[TargetId[atkIdx]];
			CursorH = aX;
			CursorV = aY;
		}
		else if(turn == Enemy){
			aX = ALocationX[TargetId[atkIdx]];
			aY = ALocationY[TargetId[atkIdx]];
			CursorH = aX;
			CursorV = aY;
		}
		/** Damage **/
		if(turn == Ally){
			if(WeaponData.rWeaponInfo(AWeapon[SelectedUnit][wpNb], 3) == "Physical"){
				aDmg = DmgFormula.pAttack(AStats[SelectedUnit][0], AWeapon[SelectedUnit][wpNb], UnitStats.detectDefWeapon(Ally, atkIdx), EClass[TargetId[atkIdx]]);
				dDef = DmgFormula.defense(Enemy, atkIdx);
			} else if(WeaponData.rWeaponInfo(AWeapon[SelectedUnit][wpNb], 3) == "Magical"){
				aDmg = DmgFormula.mAttack(AStats[SelectedUnit][1], AWeapon[SelectedUnit][wpNb], UnitStats.detectDefWeapon(Ally, atkIdx), EClass[TargetId[atkIdx]]);
				if(WeaponData.rWeaponInfo(AWeapon[SelectedUnit][wpNb], 0) == "Luna"){
					dDef = 0;
				} else{
					dDef = DmgFormula.mdefense(Enemy, atkIdx);
				}
			}
			
			if(UnitStats.detectDefWeapon(Ally, atkIdx) == null || UnitStats.detectDefWeapon(Ally, atkIdx) == "--"){
				dDmg = -1;
			} else if(WeaponData.rWeaponInfo(UnitStats.detectDefWeapon(Ally, atkIdx), 3) == "Physical"){
				dDmg = DmgFormula.pAttack(EStats[TargetId[atkIdx]][0], UnitStats.detectDefWeapon(Ally, atkIdx), AWeapon[SelectedUnit][wpNb], AClass[SelectedUnit]);
				aDef = DmgFormula.defense(Ally, SelectedUnit);
			} else if(WeaponData.rWeaponInfo(UnitStats.detectDefWeapon(Ally, atkIdx), 3) == "Magical"){
				dDmg = DmgFormula.mAttack(EStats[TargetId[atkIdx]][1], UnitStats.detectDefWeapon(Ally, atkIdx), AWeapon[SelectedUnit][wpNb], AClass[SelectedUnit]);
				if(WeaponData.rWeaponInfo(UnitStats.detectDefWeapon(Ally, atkIdx), 0) == "Luna"){
					aDef = 0;
				} else{
					aDef = DmgFormula.mdefense(Ally, SelectedUnit);
				}
			}
			if(square(CalculatePath.heuMCalc(ALocationX[SelectedUnit], ALocationY[SelectedUnit], ELocationX[TargetId[atkIdx]], ELocationY[TargetId[atkIdx]])) > WeaponData.rWeaponDat(UnitStats.detectDefWeapon(Ally, atkIdx), 4)){
				dDmg = -1111;
			} else if(square(CalculatePath.heuMCalc(ALocationX[SelectedUnit], ALocationY[SelectedUnit], ELocationX[TargetId[atkIdx]], ELocationY[TargetId[atkIdx]])) < WeaponData.rWeaponDat(UnitStats.detectDefWeapon(Ally, atkIdx), 3)){
				dDmg = -1111;
			}
			
			
			//System.out.println(aDmg + ", " + aDef + ", " + dDmg + ", " + dDef);
		}
		else if(turn == Enemy){
			if(WeaponData.rWeaponInfo(EWeapon[SelectedUnit][wpNb], 3) == "Physical"){
				aDmg = DmgFormula.pAttack(EStats[SelectedUnit][0], EWeapon[SelectedUnit][wpNb], UnitStats.detectDefWeapon(Enemy, atkIdx), AClass[TargetId[atkIdx]]);
				dDef = DmgFormula.defense(Ally, atkIdx);
			} else if(WeaponData.rWeaponInfo(EWeapon[SelectedUnit][wpNb], 3) == "Magical"){
				aDmg = DmgFormula.mAttack(EStats[SelectedUnit][1], EWeapon[SelectedUnit][wpNb], UnitStats.detectDefWeapon(Enemy, atkIdx), AClass[TargetId[atkIdx]]);
				if(WeaponData.rWeaponInfo(EWeapon[SelectedUnit][wpNb], 0) == "Luna"){
					dDef = 0;
				} else {
					dDef = DmgFormula.mdefense(Ally, atkIdx);
				}
			}
			
			if(UnitStats.detectDefWeapon(Enemy, atkIdx) == null || UnitStats.detectDefWeapon(Enemy, atkIdx) == "--"){
				dDmg = -1;
			} else if(WeaponData.rWeaponInfo(UnitStats.detectDefWeapon(Enemy, atkIdx), 3) == "Physical"){
				dDmg = DmgFormula.pAttack(AStats[TargetId[atkIdx]][0], UnitStats.detectDefWeapon(Enemy, atkIdx), EWeapon[SelectedUnit][wpNb], EClass[SelectedUnit]);
				aDef = DmgFormula.defense(Enemy, SelectedUnit);
			} else if(WeaponData.rWeaponInfo(UnitStats.detectDefWeapon(Enemy, atkIdx), 3) == "Magical"){
				dDmg = DmgFormula.mAttack(AStats[TargetId[atkIdx]][1], UnitStats.detectDefWeapon(Enemy, atkIdx), EWeapon[SelectedUnit][wpNb], EClass[SelectedUnit]);
				if(WeaponData.rWeaponInfo(UnitStats.detectDefWeapon(Enemy, atkIdx), 0) == "Luna"){
					aDef = 0;
				} else {
					aDef = DmgFormula.mdefense(Enemy, SelectedUnit);
				}
			}
			if(square(CalculatePath.heuMCalc(ELocationX[SelectedUnit], ELocationY[SelectedUnit], ALocationX[TargetId[atkIdx]], ALocationY[TargetId[atkIdx]])) > WeaponData.rWeaponDat(UnitStats.detectDefWeapon(Enemy, atkIdx), 4)){
				dDmg = -1111;
			} else if(square(CalculatePath.heuMCalc(ELocationX[SelectedUnit], ELocationY[SelectedUnit], ALocationX[TargetId[atkIdx]], ALocationY[TargetId[atkIdx]])) < WeaponData.rWeaponDat(UnitStats.detectDefWeapon(Enemy, atkIdx), 3)){
				dDmg = -1111;
			}
		}/** End of Damage **/
		
		/** Accuracy **/
		int aAcc = 0;
		int dAcc = 0;
		if(turn == Ally){
			aAcc = DmgFormula.accuracy(DmgFormula.hitRate(Ally, SelectedUnit, AWeapon[SelectedUnit][wpNb]), EStatistics[TargetId[atkIdx]][5], AWeapon[SelectedUnit][wpNb], UnitStats.detectDefWeapon(Ally, atkIdx));
			dAcc = DmgFormula.accuracy(EStatistics[TargetId[atkIdx]][1], AStatistics[SelectedUnit][5], UnitStats.detectDefWeapon(Ally, atkIdx), AWeapon[SelectedUnit][wpNb]);
			if(square(CalculatePath.heuMCalc(ALocationX[SelectedUnit], ALocationY[SelectedUnit], ELocationX[TargetId[atkIdx]], ELocationY[TargetId[atkIdx]])) > WeaponData.rWeaponDat(UnitStats.detectDefWeapon(Ally, atkIdx), 4)){
				dAcc = -1111;
			} else if(square(CalculatePath.heuMCalc(ALocationX[SelectedUnit], ALocationY[SelectedUnit], ELocationX[TargetId[atkIdx]], ELocationY[TargetId[atkIdx]])) < WeaponData.rWeaponDat(UnitStats.detectDefWeapon(Ally, atkIdx), 3)){
				dAcc = -1111;
			}
		}
		else if(turn == Enemy){
			aAcc = DmgFormula.accuracy(DmgFormula.hitRate(Enemy, SelectedUnit, EWeapon[SelectedUnit][wpNb]), AStatistics[TargetId[atkIdx]][5], EWeapon[SelectedUnit][wpNb], UnitStats.detectDefWeapon(Enemy, atkIdx));
			dAcc = DmgFormula.accuracy(AStatistics[TargetId[atkIdx]][1], EStatistics[SelectedUnit][5], UnitStats.detectDefWeapon(Enemy, atkIdx), EWeapon[SelectedUnit][wpNb]);
			if(square(CalculatePath.heuMCalc(ELocationX[SelectedUnit], ELocationY[SelectedUnit], ALocationX[TargetId[atkIdx]], ALocationY[TargetId[atkIdx]])) > WeaponData.rWeaponDat(UnitStats.detectDefWeapon(Enemy, atkIdx), 4)){
				dAcc = -1111;
			} else if(square(CalculatePath.heuMCalc(ELocationX[SelectedUnit], ELocationY[SelectedUnit], ALocationX[TargetId[atkIdx]], ALocationY[TargetId[atkIdx]])) < WeaponData.rWeaponDat(UnitStats.detectDefWeapon(Enemy, atkIdx), 3)){
				dAcc = -1111;
			}
		}
		/** End of Accuracy **/
		/** Critical **/
		int aCrit = 0;
		int dCrit = 0;
		if(turn == Ally){
			aCrit = DmgFormula.critChance(DmgFormula.critRate(Ally, SelectedUnit, AWeapon[SelectedUnit][wpNb]), EStats[TargetId[atkIdx]][4]);
			dCrit = DmgFormula.critChance(EStatistics[TargetId[atkIdx]][4], AStats[SelectedUnit][4]);
			if(square(CalculatePath.heuMCalc(ALocationX[SelectedUnit], ALocationY[SelectedUnit], ELocationX[TargetId[atkIdx]], ELocationY[TargetId[atkIdx]])) > WeaponData.rWeaponDat(UnitStats.detectDefWeapon(Ally, atkIdx), 4)){
				dCrit = -1111;
			} else if(square(CalculatePath.heuMCalc(ALocationX[SelectedUnit], ALocationY[SelectedUnit], ELocationX[TargetId[atkIdx]], ELocationY[TargetId[atkIdx]])) < WeaponData.rWeaponDat(UnitStats.detectDefWeapon(Ally, atkIdx), 3)){
				dCrit = -1111;
			}
		}
		else if(turn == Enemy){
			aCrit = DmgFormula.critChance(DmgFormula.critRate(Enemy, SelectedUnit, EWeapon[SelectedUnit][wpNb]), AStats[TargetId[atkIdx]][4]);
			dCrit = DmgFormula.critChance(AStatistics[TargetId[atkIdx]][4], EStats[SelectedUnit][4]);
			if(square(CalculatePath.heuMCalc(ELocationX[SelectedUnit], ELocationY[SelectedUnit], ALocationX[TargetId[atkIdx]], ALocationY[TargetId[atkIdx]])) > WeaponData.rWeaponDat(UnitStats.detectDefWeapon(Enemy, atkIdx), 4)){
				dCrit = -1111;
			} else if(square(CalculatePath.heuMCalc(ELocationX[SelectedUnit], ELocationY[SelectedUnit], ALocationX[TargetId[atkIdx]], ALocationY[TargetId[atkIdx]])) < WeaponData.rWeaponDat(UnitStats.detectDefWeapon(Enemy, atkIdx), 3)){
				dCrit = -1111;
			}
		}
		/** End of Critical **/
		
		int aStrikes = 1;
		int dStrikes = 1;
		if(turn == Ally){
			if(AStats[SelectedUnit][3] - 5 >= EStats[TargetId[atkIdx]][3]){
				aStrikes++;
			}
			else if(AStats[SelectedUnit][3] <= EStats[TargetId[atkIdx]][3] - 5){
				dStrikes++;
			}
			if(dDmg == -1111){
				dStrikes  = 0;
			}
			/*if(AWeapon[SelectedUnit][wpNb] == "Brave Sword" || AWeapon[SelectedUnit][wpNb] == "Brave Lance" || AWeapon[SelectedUnit][wpNb] == "Brave Axe" || AWeapon[SelectedUnit][wpNb] == "Brave Bow"){
				aStrikes*=2;
			}
			if(UnitStats.detectDefWeapon(Ally, atkIdx) == "Brave Sword" || UnitStats.detectDefWeapon(Ally, atkIdx) == "Brave Lance" || UnitStats.detectDefWeapon(Ally, atkIdx) == "Brave Axe" || UnitStats.detectDefWeapon(Ally, atkIdx) == "Brave Bow"){
				dStrikes*=2;
			}*/
		}
		if(turn == Enemy){
			if(EStats[SelectedUnit][3] - 5 >= AStats[TargetId[atkIdx]][3]){
				aStrikes++;
			}
			else if(EStats[SelectedUnit][3] <= AStats[TargetId[atkIdx]][3] - 5){
				dStrikes++;
			}
			if(dDmg == -1111){
				dStrikes  = 0;
			}
			/*if(EWeapon[SelectedUnit][wpNb] == "Brave Sword" || EWeapon[SelectedUnit][wpNb] == "Brave Lance" || EWeapon[SelectedUnit][wpNb] == "Brave Axe" || EWeapon[SelectedUnit][wpNb] == "Brave Bow"){
				aStrikes*=2;
			}
			if(UnitStats.detectDefWeapon(Enemy, atkIdx) == "Brave Sword" || UnitStats.detectDefWeapon(Enemy, atkIdx) == "Brave Lance" || UnitStats.detectDefWeapon(Enemy, atkIdx) == "Brave Axe" || UnitStats.detectDefWeapon(Enemy, atkIdx) == "Brave Bow"){
				dStrikes*=2;
			}*/
		}
		
		
		
		//System.out.println(aX + ", " + aY);
		gc.drawImage(78, rl, 16);
		gc.setColor(255,255,255);
		gc.setFont(font, Font.BOLD, 20);
		gc.drawCenterString("Team1", rl + grid(3)+1, grid(1));
		gc.drawCenterString("Team2", rl + grid(1)+26, grid(6)+16);
		gc.setColor(250, 246, 35);
		//gc.setColor(220, 245, 0);
		gc.setFont(font, fType, 30);
		gc.drawCenterString("HP", rl + grid(2)+16 , grid(1)+28);
		gc.setFont(font, fType, 24);
		gc.drawCenterString("" + UnitStats.Might[Lang], rl + grid(2)+16 , grid(3)+8);
		gc.drawCenterString("" + UnitStats.Hit[Lang], rl + grid(2)+16 , grid(4)+8);
		gc.drawCenterString("" + UnitStats.Crit[Lang], rl + grid(2)+16 , grid(5)+8);
		
		gc.drawImage(3, aX -5 -grid(ShiftX), aY -5 -grid(ShiftY));
		gc.setFont(font, fType, 30);
		gc.setColor(203, 224, 247);
		
		int atkD = 0;
		int defD = 0;
		int atkH = 0;
		int defH = 0;
		int atkC = 0;
		int defC = 0;
		
		if(turn == Ally){
			gc.drawClipImage(147, rl +9, grid(1)-9, WeaponData.rWeaponDat(AWeapon[SelectedUnit][wpNb], 6), WeaponData.rWeaponDat(AWeapon[SelectedUnit][wpNb], 7), 32, 32);
			if(UnitStats.detectDefWeapon(Ally, atkIdx) != null && UnitStats.detectDefWeapon(Ally, atkIdx) != "--"){
				gc.drawClipImage(147, rl + grid(3)+17, grid(6)+16 -2, WeaponData.rWeaponDat(EWeapon[TargetId[atkIdx]][0], 6), WeaponData.rWeaponDat(EWeapon[TargetId[atkIdx]][0], 7), 32, 32);
			}
			/** Damage **/
			gc.drawCenterString("" + EHP[TargetId[atkIdx]][0], rl + grid(1)-4 , grid(1)+28);
			if(dDmg > -500 && (dStrikes > 1 || UnitStats.detectDefWeapon(Ally, atkIdx) == "Brave Sword" || UnitStats.detectDefWeapon(Ally, atkIdx) == "Brave Lance" || UnitStats.detectDefWeapon(Ally, atkIdx) == "Brave Axe" || UnitStats.detectDefWeapon(Ally, atkIdx) == "Brave Bow")){
				gc.setFont(font, Font.BOLD, 25);
				gc.setColor(150, 0, 145);
				if(dStrikes > 1 && (UnitStats.detectDefWeapon(Ally, atkIdx) == "Brave Sword" || UnitStats.detectDefWeapon(Ally, atkIdx) == "Brave Lance" || UnitStats.detectDefWeapon(Ally, atkIdx) == "Brave Axe" || UnitStats.detectDefWeapon(Ally, atkIdx) == "Brave Bow")){
					gc.drawCenterString("x4", rl + grid(2), grid(2)+32);
				}
				else{
					gc.drawCenterString("x2", rl + grid(2), grid(2)+32);
				}
				gc.setFont(font, fType, 30);
				gc.setColor(203, 224, 247);
			}
			gc.drawCenterString("" + AHP[SelectedUnit][0], rl + grid(4)+4 , grid(1)+28);
			if(aStrikes > 1 || AWeapon[SelectedUnit][wpNb] == "Brave Sword" || AWeapon[SelectedUnit][wpNb] == "Brave Lance" || AWeapon[SelectedUnit][wpNb] == "Brave Axe" || AWeapon[SelectedUnit][wpNb] == "Brave Bow"){
				gc.setFont(font, Font.BOLD, 25);
				gc.setColor(150, 0, 145);
				if(aStrikes > 1 && (AWeapon[SelectedUnit][wpNb] == "Brave Sword" || AWeapon[SelectedUnit][wpNb] == "Brave Lance" || AWeapon[SelectedUnit][wpNb] == "Brave Axe" || AWeapon[SelectedUnit][wpNb] == "Brave Bow")){
					gc.drawCenterString("x4", rl + grid(5), grid(2)+32);
				}
				else{
					gc.drawCenterString("x2", rl + grid(5), grid(2)+32);
				}
				gc.setFont(font, fType, 30);
				gc.setColor(203, 224, 247);
			}
			if(dDmg < 0){
				gc.drawCenterString("--", rl + grid(1)-4 , grid(2)+32);
			}else{
				gc.drawCenterString("" + DmgFormula.damage(dDmg, aDef), rl + grid(1)-4 , grid(2)+32);
			}
			if(aDmg < 0){
				gc.drawCenterString("--", rl + grid(4)+4 , grid(2)+32);
			} else {
				gc.drawCenterString("" + DmgFormula.damage(aDmg, dDef), rl + grid(4)+4 , grid(2)+32);
			}
			
			/** Accuracy **/
			if(UnitStats.detectDefWeapon(Ally, atkIdx) == "--" || dAcc == -1111){
				gc.drawCenterString("--", rl + grid(1)-4 , grid(3)+34);
			} else if(dAcc < 0){
				gc.drawCenterString("0", rl + grid(1)-4 , grid(3)+34);
			} else if (dAcc > 100){
				gc.drawCenterString("100", rl + grid(1)-4 , grid(3)+34);
			} else {
				gc.drawCenterString("" + dAcc, rl + grid(1)-4 , grid(3)+34);
			}
			if(aAcc < 0){
				gc.drawCenterString("0", rl + grid(4)+4 , grid(3)+34);
			} else if(aAcc >100){
				gc.drawCenterString("100", rl + grid(4)+4 , grid(3)+34);
			} else{
				gc.drawCenterString("" + aAcc, rl + grid(4)+4 , grid(3)+34);
			}
			
			/** Crit Chance **/
			if(UnitStats.detectDefWeapon(Ally, atkIdx) == "--" || dCrit == -1111){
				gc.drawCenterString("--", rl + grid(1)-4 , grid(4)+36);
			} else if(dCrit < 0){
				gc.drawCenterString("0", rl + grid(1)-4 , grid(4)+36);
			} else if (dCrit > 100){
				gc.drawCenterString("100", rl + grid(1)-4 , grid(4)+36);
			} else {
				gc.drawCenterString("" + dCrit, rl + grid(1)-4 , grid(4)+36);
			}
			if(aCrit < 0){
				gc.drawCenterString("0", rl + grid(4)+4 , grid(4)+36);
			} else if(aCrit >100){
				gc.drawCenterString("100", rl + grid(4)+4 , grid(4)+36);
			} else{
				gc.drawCenterString("" + aCrit, rl + grid(4)+4 , grid(4)+36);
			}
			
			atkD = DmgFormula.damage(aDmg, dDef);
			defD = DmgFormula.damage(dDmg, aDef);
			atkH = aAcc;
			defH = dAcc;
			atkC = aCrit;
			defC = dCrit;
			if(atkD < 0){
				atkD = 0;
			} if(defD < 0){
				defD = 0;
			} if(atkH < 0){
				atkH = 0;
			} else if(atkH > 100){
				atkH = 100;
			} if(defH < 0){
				defH = 0;
			} else if(defH > 100){
				defH = 100;
			} if(atkC < 0){
				atkC = 0;
			} else if(atkC > 100){
				atkC = 100;
			} if(defC < 0){
				defC = 0;
			} else if(defC > 100){
				defC = 100;
			} 
		}
		else if(turn == Enemy){
			if(UnitStats.detectDefWeapon(Enemy, atkIdx) != null && UnitStats.detectDefWeapon(Enemy, atkIdx) != "--"){
				gc.drawClipImage(147, rl +9, grid(1)-9, WeaponData.rWeaponDat(AWeapon[TargetId[atkIdx]][0], 6), WeaponData.rWeaponDat(AWeapon[TargetId[atkIdx]][0], 7), 32, 32);
			}
			gc.drawClipImage(147, rl + grid(3)+17, grid(6)+16 -2, WeaponData.rWeaponDat(EWeapon[SelectedUnit][wpNb], 6), WeaponData.rWeaponDat(EWeapon[SelectedUnit][wpNb], 7), 32, 32);
			/** Damage **/
			gc.drawCenterString("" + EHP[SelectedUnit][0], rl + grid(1)-4 , grid(1)+28);
			if(aStrikes > 1 || EWeapon[SelectedUnit][wpNb] == "Brave Sword" || EWeapon[SelectedUnit][wpNb] == "Brave Lance" || EWeapon[SelectedUnit][wpNb] == "Brave Axe" || EWeapon[SelectedUnit][wpNb] == "Brave Bow"){
				gc.setFont(font, Font.BOLD, 25);
				gc.setColor(150, 0, 145);
				if(aStrikes > 1 && (EWeapon[SelectedUnit][wpNb] == "Brave Sword" || EWeapon[SelectedUnit][wpNb] == "Brave Lance" || EWeapon[SelectedUnit][wpNb] == "Brave Axe" || EWeapon[SelectedUnit][wpNb] == "Brave Bow")){
					gc.drawCenterString("x4", rl + grid(2), grid(2)+32);
				}
				else{
					gc.drawCenterString("x2", rl + grid(2), grid(2)+32);
				}
				gc.setFont(font, fType, 30);
				gc.setColor(203, 224, 247);
			}
			gc.drawCenterString("" + AHP[TargetId[atkIdx]][0], rl + grid(4)+4 , grid(1)+28);
			if(dDmg > -500 && (dStrikes > 1 || UnitStats.detectDefWeapon(Enemy, atkIdx) == "Brave Sword" || UnitStats.detectDefWeapon(Enemy, atkIdx) == "Brave Lance" || UnitStats.detectDefWeapon(Enemy, atkIdx) == "Brave Axe" || UnitStats.detectDefWeapon(Enemy, atkIdx) == "Brave Bow")){
				gc.setFont(font, Font.BOLD, 25);
				gc.setColor(150, 0, 145);
				if(dStrikes > 1 && (UnitStats.detectDefWeapon(Enemy, atkIdx) == "Brave Sword" || UnitStats.detectDefWeapon(Enemy, atkIdx) == "Brave Lance" || UnitStats.detectDefWeapon(Enemy, atkIdx) == "Brave Axe" || UnitStats.detectDefWeapon(Enemy, atkIdx) == "Brave Bow")){
					gc.drawCenterString("x4", rl + grid(5), grid(2)+32);
				}
				else{
					gc.drawCenterString("x2", rl + grid(5), grid(2)+32);
				}
				gc.setFont(font, fType, 30);
				gc.setColor(203, 224, 247);
			}
			if(dDmg < 0){
				gc.drawCenterString("--", rl + grid(4)+4 , grid(2)+32);
			}else{
				gc.drawCenterString("" + DmgFormula.damage(dDmg, aDef), rl + grid(4)+4 , grid(2)+32);
			}
			if(aDmg < 0){
				gc.drawCenterString("--", rl + grid(1)-4 , grid(2)+32);
			} else {
				gc.drawCenterString("" + DmgFormula.damage(aDmg, dDef), rl + grid(1)-4 , grid(2)+32);
			}
			
			/** Accuracy **/
			if(UnitStats.detectDefWeapon(Enemy, atkIdx) == "--" || dAcc == -1111){
				gc.drawCenterString("--", rl + grid(4)+4 , grid(3)+34);
			} else if(dAcc < 0){
				gc.drawCenterString("0", rl + grid(4)+4 , grid(3)+34);
			} else if (dAcc > 100){
				gc.drawCenterString("100", rl + grid(4)+4 , grid(3)+34);
			} else {
				gc.drawCenterString("" + dAcc, rl + grid(4)+4 , grid(3)+34);
			}
			if(aAcc < 0){
				gc.drawCenterString("0", rl + grid(1)-4 , grid(3)+34);
			} else if(aAcc >100){
				gc.drawCenterString("100", rl + grid(1)-4 , grid(3)+34);
			} else{
				gc.drawCenterString("" + aAcc, rl + grid(1)-4 , grid(3)+34);
			}
			
			/** Crit Chance **/
			if(UnitStats.detectDefWeapon(Enemy, atkIdx) == "--" || dCrit == -1111){
				gc.drawCenterString("--", rl + grid(4)+4 , grid(4)+36);
			} else if(dCrit < 0){
				gc.drawCenterString("0", rl + grid(4)+4 , grid(4)+36);
			} else if (dCrit > 100){
				gc.drawCenterString("100", rl + grid(4)+4 , grid(4)+36);
			} else {
				gc.drawCenterString("" + dCrit, rl + grid(4)+4 , grid(4)+36);
			}
			if(aCrit < 0){
				gc.drawCenterString("0", rl + grid(1)-4 , grid(4)+36);
			} else if(aCrit >100){
				gc.drawCenterString("100", rl + grid(1)-4 , grid(4)+36);
			} else{
				gc.drawCenterString("" + aCrit, rl + grid(1)-4 , grid(4)+36);
			}
			
			atkD = DmgFormula.damage(aDmg, dDef);
			defD = DmgFormula.damage(dDmg, aDef);
			atkH = aAcc;
			defH = dAcc;
			atkC = aCrit;
			defC = dCrit;
			if(atkD < 0){
				atkD = 0;
			} if(defD < 0){
				defD = 0;
			} if(atkH < 0){
				atkH = 0;
			} else if(atkH > 100){
				atkH = 100;
			} if(defH < 0){
				defH = 0;
			} else if(defH > 100){
				defH = 100;
			} if(atkC < 0){
				atkC = 0;
			} else if(atkC > 100){
				atkC = 100;
			} if(defC < 0){
				defC = 0;
			} else if(defC > 100){
				defC = 100;
			} 
		}
		
		if(gc.isKeyPushed(gc.KEY_M) && turn == Ally){
			Battle(SelectedUnit, TargetId[atkIdx], wpNb, atkIdx, AWeapon[SelectedUnit][wpNb], UnitStats.detectDefWeapon(Ally, atkIdx), atkD, defD, atkH, defH, atkC, defC, aStrikes, dStrikes);
			//System.out.println("Attacker: " + AUnit[SelectedUnit] + " Weapon: " + AWeapon[SelectedUnit][wpNb] + " Distance: " + CalculatePath.heuMCalc(ALocationX[SelectedUnit], ALocationY[SelectedUnit], ELocationX[TargetId[atkIdx]], ELocationY[TargetId[atkIdx]]));
			//System.out.println("Defender: " + EUnit[TargetId[atkIdx]] + " Weapon: " + UnitStats.detectDefWeapon(Ally, atkIdx));
			BattlePhase = true;
		}	
		else if(gc.isKeyPushed(gc.KEY_RIGHT) && turn == Enemy){//Battle
			Battle(SelectedUnit, TargetId[atkIdx], wpNb, atkIdx, EWeapon[SelectedUnit][wpNb], UnitStats.detectDefWeapon(Enemy, atkIdx), atkD, defD, atkH, defH, atkC, defC, aStrikes, dStrikes);
			//System.out.println("Attacker: " + EUnit[SelectedUnit] + " Weapon: " + EWeapon[SelectedUnit][wpNb] + " Distance: " + CalculatePath.heuMCalc(ELocationX[SelectedUnit], ELocationY[SelectedUnit], ALocationX[TargetId[atkIdx]], ALocationY[TargetId[atkIdx]]));
			//System.out.println("Defender: " + AUnit[TargetId[atkIdx]] + " Weapon: " + UnitStats.detectDefWeapon(Enemy, atkIdx));
		}
		if(gc.isKeyPushed(gc.KEY_B) && turn == Ally || gc.isKeyPushed(gc.KEY_LEFT) && turn == Enemy){
			atkStg = 1;
		}
	}
	void checkItems(){
		commands[4] = false;
		for(int i=0; i<5; i++){
			if(turn == Ally && AWeapon[SelectedUnit][i] != null){
				commands[4] = true;
				break;
			}
			else if(turn == Enemy && EWeapon[SelectedUnit][i] != null){
				commands[4] = true;
				break;
			}
		}
	}
	void Battle(int atkIdx, int defIdx, int aWId, int dWId, String aWep, String dWep, int atkD, int defD, int atkH, int defH, int atkC, int defC, int aStrike, int dStrike){
		System.out.println("");
		System.out.println("Battle Phase Start");
		boolean atkHits = false;
		boolean defHits = false;
		boolean atkCrits = false;
		boolean defCrits = false;
		
		int aStrikes = 1;
		int dStrikes = 0;
		if(dWep != null && dWep != "--" && WeaponData.rWeaponInfo(dWep, 3) != "Special"){//if the enemy doesnt have a staff/unequipped
			dStrikes = 1;
		} 
		else{
			dStrikes = 0;
		}
		
		if(aWep == "Brave Sword" || aWep == "Brave Lance" || aWep == "Brave Axe" || aWep == "Brave Bow"){
			aStrikes=2;
		}
		if(dWep == "Brave Sword" || dWep == "Brave Lance" || dWep == "Brave Axe" || dWep == "Brave Bow"){
			dStrikes=2;
		}
		System.out.println("Strikes: " + aStrikes + ", Enemy Strikes: " + dStrikes);
		/** Ally Attacks **/
		if(turn == Ally){
			UnitStats.equipWeapon(Ally, SelectedUnit, wpNb);
			for(int i=aStrikes; i>0; i--){//1st Strike
				atkHits = UnitStats.checkHitCrit(atkH);
				if(atkHits){
					atkCrits = UnitStats.checkHitCrit(atkC);
					if(atkCrits){
						EHP[defIdx][0]-=(atkD * 3);
						System.out.println("Critical Strike, did " + (atkD * 3) + " dmg. Enemys remaining HP: " + EHP[defIdx][0]);
						AWeaponDur[atkIdx][0][0]--;
						if(aWep == "Nosferatu"){
							recoverHP(Ally, 3, atkIdx, atkD);
						}
					} else {
						EHP[defIdx][0]-=atkD;
						System.out.println("Successful strike, did " + atkD + " dmg. Enemys remaining HP: " + EHP[defIdx][0]);
						AWeaponDur[atkIdx][0][0]--;
						if(aWep == "Nosferatu"){
							recoverHP(Ally, 1, atkIdx, atkD);
						}
					}
					
					if(EHP[defIdx][0] <= 0){
						System.out.println("Enemy Successfully Killed");
						EAlive[defIdx] = false;
						break;
					}
				} else{
					System.out.println("Attack has Missed. Enemys remaining HP: " + EHP[defIdx][0]);
				}
				if(AWeaponDur[atkIdx][aWId][0] <= 0){
					break;
				}
			}
			if(EAlive[defIdx] && dStrike != 0){//Enemy 1st Strike
				for(int i=dStrikes; i>0; i--){
					defHits = UnitStats.checkHitCrit(defH);
					if(defHits){
						defCrits = UnitStats.checkHitCrit(defC);
						if(defCrits){
							AHP[atkIdx][0]-=(defD * 3);
							System.out.println("Enemy Performed a Critical Strike, did " + (defD * 3) + " dmg. Ally Remaining Hp: " + AHP[atkIdx][0]);
							EWeaponDur[defIdx][dWId][0]--;
							if(dWep == "Nosferatu"){
								recoverHP(Enemy, 3, defIdx, defD);
							}
						} else {
							AHP[atkIdx][0]-=defD;
							System.out.println("Enemy has Striked, did " + defD + " damage. Ally Remaining Hp: " + AHP[atkIdx][0]);
							EWeaponDur[defIdx][dWId][0]--;
							if(dWep == "Nosferatu"){
								recoverHP(Enemy, 1, defIdx, defD);
							}
						}
						
						if(AHP[atkIdx][0] <= 0){
							System.out.println("Ally has been Killed");
							AAlive[atkIdx] = false;
							break;
						}
					} else{
						System.out.println("Enemys Atk Missed, Remaining Hp: " + AHP[atkIdx][0]);
					}
					if(EWeaponDur[defIdx][dWId][0] <= 0){
						EWeapon[defIdx][dWId] = null;
						UnitStats.weaponBroke(Enemy, defIdx, dWId);
						break;
					}
				}
			}
			if(AAlive[atkIdx] && EAlive[defIdx] && aStrike > 1 && AWeaponDur[atkIdx][aWId][0] > 0){//2nd Strike
				for(int i=aStrikes; i>0; i--){
					atkHits = UnitStats.checkHitCrit(atkH);
					if(atkHits){
						atkCrits = UnitStats.checkHitCrit(atkC);
						if(atkCrits){
							EHP[defIdx][0]-=(atkD * 3);
							System.out.println("Critical Strike, did " + (atkD * 3) + " dmg. Enemys remaining HP: " + EHP[defIdx][0]);
							AWeaponDur[atkIdx][0][0]--;
							if(aWep == "Nosferatu"){
								recoverHP(Ally, 3, atkIdx, atkD);
							}
						} else {
							EHP[defIdx][0]-=atkD;
							System.out.println("Successful strike, did " + atkD + " dmg. Enemys remaining HP: " + EHP[defIdx][0]);
							AWeaponDur[atkIdx][0][0]--;
							if(aWep == "Nosferatu"){
								recoverHP(Ally, 1, atkIdx, atkD);
							}
						}
						
						if(EHP[defIdx][0] <= 0){
							System.out.println("Enemy Successfully Killed");
							EAlive[defIdx] = false;
							break;
						}
					} else{
						System.out.println("Attack has Missed. Enemys remaining HP: " + EHP[defIdx][0]);
					}
					if(AWeaponDur[atkIdx][aWId][0] <= 0){
						break;
					}
				}
			}
			else if(AAlive[atkIdx] && EAlive[defIdx] && dStrike > 1 && EWeaponDur[defIdx][dWId][0] > 0){ //Enemy 2nd Strike
				for(int i=dStrikes; i>0; i--){
					defHits = UnitStats.checkHitCrit(defH);
					if(defHits){
						defCrits = UnitStats.checkHitCrit(defC);
						if(defCrits){
							AHP[atkIdx][0]-=(defD * 3);
							System.out.println("Enemy Performed a Critical Strike, did " + (defD * 3) + " dmg. Ally Remaining Hp: " + AHP[atkIdx][0]);
							EWeaponDur[defIdx][dWId][0]--;
							if(dWep == "Nosferatu"){
								recoverHP(Enemy, 3, defIdx, defD);
							}
						} else {
							AHP[atkIdx][0]-=defD;
							System.out.println("Enemy has Striked, did " + defD + " damage. Ally Remaining Hp: " + AHP[atkIdx][0]);
							EWeaponDur[defIdx][dWId][0]--;
							if(dWep == "Nosferatu"){
								recoverHP(Enemy, 1, defIdx, defD);
							}
						}
						if(AHP[atkIdx][0] <= 0){
							System.out.println("Ally has been Killed");
							AAlive[atkIdx] = false;
							break;
						}
					} else{
						System.out.println("Enemys Atk Missed, Remaining Hp: " + AHP[atkIdx][0]);
					}
					if(EWeaponDur[defIdx][dWId][0] <= 0){
						EWeapon[defIdx][dWId] = null;
						UnitStats.weaponBroke(Enemy, defIdx, dWId);
						break;
					}
				}
			}
			if(AWeaponDur[atkIdx][aWId][0] <= 0){
				AWeapon[SelectedUnit][0] = null;
				UnitStats.weaponBroke(Ally, SelectedUnit, 0);
			}
			unitMoved(Ally, atkIdx);
		}
		
		/** Enemy Attacks **/
		else if(turn == Enemy){
			UnitStats.equipWeapon(Enemy, SelectedUnit, wpNb);
			for(int i=aStrikes; i>0; i--){
				atkHits = UnitStats.checkHitCrit(atkH);
				//System.out.println("enemy atkh = " + atkH);
				if(atkHits){
					atkCrits = UnitStats.checkHitCrit(atkC);
					if(atkCrits){
						AHP[defIdx][0]-=(atkD * 3);
						System.out.println("Critical Strike, did " + (atkD * 3) + " dmg. Enemys remaining HP: " + AHP[defIdx][0]);
						EWeaponDur[atkIdx][0][0]--;
						if(aWep == "Nosferatu"){
							recoverHP(Enemy, 3, atkIdx, atkD);
						}
						
					} else {
						AHP[defIdx][0]-=atkD;
						System.out.println("Successful strike, did " + atkD + " dmg. Enemys remaining HP: " + AHP[defIdx][0]);
						EWeaponDur[atkIdx][0][0]--;
						if(aWep == "Nosferatu"){
							recoverHP(Enemy, 1, atkIdx, atkD);
						}
					}
					
					if(AHP[defIdx][0] <= 0){
						System.out.println("Enemy Successfully Killed");
						AAlive[defIdx] = false;
						break;
					}
				} else{
					System.out.println("Attack has Missed. Enemys remaining HP: " + AHP[defIdx][0]);
				}
				if(EWeaponDur[atkIdx][aWId][0] <= 0){
					break;
				}
			}
			if(AAlive[defIdx] && dStrike != 0){
				for(int i=dStrikes; i>0; i--){
					defHits = UnitStats.checkHitCrit(defH);
					if(defHits){
						defCrits = UnitStats.checkHitCrit(defC);
						if(defCrits){
							EHP[atkIdx][0]-=(defD * 3);
							System.out.println("Enemy Performed a Critical Strike, did " + (defD * 3) + " dmg. Ally Remaining Hp: " + EHP[atkIdx][0]);
							AWeaponDur[defIdx][dWId][0]--;
							if(dWep == "Nosferatu"){
								recoverHP(Ally, 3, defIdx, defD);
							}
						} else {
							EHP[atkIdx][0]-=defD;
							System.out.println("Enemy has Striked, did " + defD + " damage. Ally Remaining Hp: " + EHP[atkIdx][0]);
							AWeaponDur[defIdx][dWId][0]--;
							if(dWep == "Nosferatu"){
								recoverHP(Ally, 1, defIdx, defD);
							}
						}
						
						if(EHP[atkIdx][0] <= 0){
							System.out.println("Ally has been Killed");
							EAlive[atkIdx] = false;
							break;
						}
					} else{
						System.out.println("Enemys Atk Missed, Remaining Hp: " + EHP[atkIdx][0]);
					}
					if(AWeaponDur[defIdx][dWId][0] <= 0){
						AWeapon[defIdx][dWId] = null;
						UnitStats.weaponBroke(Ally, defIdx, dWId);
						break;
					}
				}
			}
			if(EAlive[atkIdx] && AAlive[defIdx] && aStrike > 1 && EWeaponDur[atkIdx][aWId][0] > 0){
				for(int i=aStrikes; i>0; i--){
					atkHits = UnitStats.checkHitCrit(atkH);
					if(atkHits){
						atkCrits = UnitStats.checkHitCrit(atkC);
						if(atkCrits){
							AHP[defIdx][0]-=(atkD * 3);
							System.out.println("Critical Strike, did " + (atkD * 3) + " dmg. Enemys remaining HP: " + AHP[defIdx][0]);
							EWeaponDur[atkIdx][0][0]--;
							if(aWep == "Nosferatu"){
								recoverHP(Enemy, 3, atkIdx, atkD);
							}
						} else {
							AHP[defIdx][0]-=atkD;
							System.out.println("Successful strike, did " + atkD + " dmg. Enemys remaining HP: " + AHP[defIdx][0]);
							EWeaponDur[atkIdx][0][0]--;
							if(aWep == "Nosferatu"){
								recoverHP(Enemy, 1, atkIdx, atkD);
							}
						}
						
						if(AHP[defIdx][0] <= 0){
							System.out.println("Enemy Successfully Killed");
							AAlive[defIdx] = false;
							break;
						}
					} else{
						System.out.println("Attack has Missed. Enemys remaining HP: " + AHP[defIdx][0]);
					}
					if(EWeaponDur[atkIdx][aWId][0] <= 0){
						break;
					}
				}
			}
			else if(EAlive[atkIdx] && AAlive[defIdx] && dStrike > 1 && AWeaponDur[defIdx][dWId][0] > 0){
				for(int i=dStrikes; i>0; i--){
					defHits = UnitStats.checkHitCrit(defH);
					if(defHits){
						defCrits = UnitStats.checkHitCrit(defC);
						if(defCrits){
							EHP[atkIdx][0]-=(defD * 3);
							System.out.println("Enemy Performed a Critical Strike, did " + (defD * 3) + " dmg. Ally Remaining Hp: " + EHP[atkIdx][0]);
							AWeaponDur[defIdx][dWId][0]--;
							if(dWep == "Nosferatu"){
								recoverHP(Ally, 3, defIdx, defD);
							}
						} else {
							EHP[atkIdx][0]-=defD;
							System.out.println("Enemy has Striked, did " + defD + " damage. Ally Remaining Hp: " + EHP[atkIdx][0]);
							AWeaponDur[defIdx][dWId][0]--;
							if(dWep == "Nosferatu"){
								recoverHP(Ally, 1, defIdx, defD);
							}
						}
						if(EHP[atkIdx][0] <= 0){
							System.out.println("Ally has been Killed");
							EAlive[atkIdx] = false;
							break;
						}
					} else{
						System.out.println("Enemys Atk Missed, Remaining Hp: " + EHP[atkIdx][0]);
					}
					if(AWeaponDur[defIdx][dWId][0] <= 0){
						AWeapon[defIdx][dWId] = null;
						UnitStats.weaponBroke(Ally, defIdx, dWId);
						break;
					}
				}
			}
			if(EWeaponDur[atkIdx][aWId][0] <= 0){
				EWeapon[SelectedUnit][0] = null;
				UnitStats.weaponBroke(Enemy, SelectedUnit, 0);
			}
			unitMoved(Enemy, atkIdx);
		}
		
	}
	void recoverHP(int side, int crit, int aIdx, int aDmg){
		if(side == Ally){
			if(AHP[aIdx][0] + (aDmg * crit) > AHP[aIdx][1]){
				AHP[aIdx][0] = AHP[aIdx][1];
			}
			else{
				AHP[aIdx][0]+=(aDmg * crit);
			}
		}
		else if(side == Enemy){
			if(EHP[aIdx][0] + (aDmg * crit) > EHP[aIdx][1]){
				EHP[aIdx][0] = EHP[aIdx][1];
			}
			else{
				EHP[aIdx][0]+=(aDmg * crit);
			}
		}
	}
	void showAtkRng(){ //Independent
		commands[0] = false;
		for(int i=0; i<=GridMax_X; i++){
			for(int j=0; j<=GridMax_Y; j++){
				drawn[i][j] = CLEAR;
			}
		}
		for(int i=0; i<=GridMax_X; i++){
			for(int j=0; j<=GridMax_Y; j++){
				for(int k=0; k<5; k++){
					if(weaponR[k][i][j] == RED && drawn[i][j] != RED){
						gc.drawClipImage(16, grid(i)-grid(ShiftX), grid(j)-grid(ShiftY), 0, 32, 32, 32);
						drawn[i][j] = RED;
					}
				}
			}
		}
		for(int i=0; i<100; i++){
			if(drawn[square(ELocationX[i])][square(ELocationY[i])] == RED && turn == Ally || drawn[square(ALocationX[i])][square(ALocationY[i])] == RED && turn == Enemy ){
				//System.out.println(square(ELocationX[i]) + ", " +square(ELocationY[i]) + ", " + i);
				commands[0] = true;
			}
		}
	
	}
	
	void showSpAtkRng(int k){// Independent
		//System.out.println(WeaponId[commandLocA1] + " = " + AWeapon[SelectedUnit][wpNb]);
		for(int i=0; i<=GridMax_X; i++){
			for(int j=0; j<=GridMax_Y; j++){
				drawn[i][j] = CLEAR;
			}
		}
		for(int i=0; i<=GridMax_X; i++){
			for(int j=0; j<=GridMax_Y; j++){
				if(weaponR[k][i][j] == RED && drawn[i][j] != RED){
					gc.drawClipImage(16, grid(i)-grid(ShiftX), grid(j)-grid(ShiftY), 0, 32, 32, 32);
					drawn[i][j] = RED;
				}
			}
		}
		gaveTime = true;
	}
	void waitCommand(){ //Independent
		MvmtBoundV = 0;
		MvmtBoundH = 0;
		MvmtNum = 0;
		Selected = false;
		mvtInitialized = false;
		alMoved = false;
		clearMvmtSquare();
		ButtonStage = 4;
		atkStg = 0;
		HideCursor = false;
		selection = 64 + 8;
		commandLoc = 0;
		ignoreKeys = false;
		IgnoreB = false;
		gaveTime = false;
		wpNb = 0;
		
	}
	void drawMvmtSquare(){ //Independent
		for(int i=0; i<100; i++){
			for(int j=0; j<100; j++){
				if(select_grid[i][j] == BLUE){
					gc.drawClipImage(16, grid(i)-grid(ShiftX), grid(j)-grid(ShiftY), 0, 0, 32, 32);
				}
				else if(select_grid[i][j] == RED){
					gc.drawClipImage(16, grid(i)-grid(ShiftX), grid(j)-grid(ShiftY), 0, 32, 32, 32);
				}
				else if(select_grid[i][j] == GREEN){
					gc.drawClipImage(16, grid(i)-grid(ShiftX), grid(j)-grid(ShiftY), 0, 64, 32, 32);
				}
			}
		}
	}
	void clearMvmtSquare(){ //Independent
		for(int i=0; i<100; i++){
			for(int j=0; j<100; j++){
				select_grid[i][j] = CLEAR;
			}
		}
	}
	/********** Unit Handling **********/
	void checkOccupation(){ //Independent
		for(int i=0; i<=GridMax_X; i++){
			for(int j=0; j<=GridMax_Y; j++){
				occupied[i][j] = Empty;
			}
		}
		for(int i=0; i<100; i++){
			for(int j=0; j<100; j++){
				if(square(ALocationX[i]) <= GridMax_X && square(ALocationY[j]) <= GridMax_Y && i == j){
					occupied[square(ALocationX[i])][square(ALocationY[j])] = Ally;
				}
				if(square(ELocationX[i]) <= GridMax_X && square(ELocationY[j]) <= GridMax_Y && i == j){
					occupied[square(ELocationX[i])][square(ELocationY[j])] = Enemy;
				}
			}
		}
	}
	
	void showStatus(){ //Independent
		if(GameState == StatusPage){
			gc.drawImage(DataTab, grid(8)+16-8, grid(2)+8);
			gc.drawImage(73, grid(1)-16-8, grid(1)-20+8);
			gc.drawClipImage(74, 0-8-8, grid(9)+8, 0, 20, 275, 150);
			gc.setFont(font, fType, 30);
			gc.setColor(250, 246, 35);
			gc.drawString("HP", grid(1), grid(10)+16);
			gc.setColor(255, 255, 255);
			gc.setFont(font, fType, 25);
			if(displaySide == Ally){
				gc.drawString(AHP[displayNum][0] + " / " + AHP[displayNum][1], grid(3), grid(10)+20);
			}else if(displaySide == Enemy){
				gc.drawString(EHP[displayNum][0] + " / " + EHP[displayNum][1], grid(3), grid(10)+20);
			}
			gc.setColor(250, 246, 35);
			gc.setFont(font, fType, 20);
			if(DataTab == 76){
				gc.drawString("" + UnitStats.Strength[Lang], grid(9)+16, grid(3));
				gc.drawString("" + UnitStats.Magic[Lang], grid(9)+16, grid(4)+16);
				gc.drawString("" + UnitStats.Skill[Lang], grid(9)+16, grid(5)+32);
				gc.drawString("" + UnitStats.Speed[Lang], grid(9)+16, grid(6)+48);
				gc.drawString("" + UnitStats.Luck[Lang], grid(14)+16, grid(3));
				gc.drawString("" + UnitStats.Defense[Lang], grid(14)+16, grid(4)+16);
				gc.drawString("" + UnitStats.Resistance[Lang], grid(14)+16, grid(5)+32);
				gc.drawString("" + UnitStats.Movement[Lang], grid(14)+16, grid(6)+48);
				gc.setFont(font, Font.BOLD, 20);
				gc.setColor(255,255,255);
				gc.drawCenterString("" + UnitStats.Equipment[Lang], grid(12)-4, grid(10)-4);
				gc.setColor(250, 246, 35);
				gc.drawString("" + UnitStats.Attack[Lang], grid(10)-2, grid(11)+4);
				gc.drawString("" + UnitStats.Hit[Lang], grid(10)-2, grid(12)+16);
				gc.drawString("" + UnitStats.Range[Lang], grid(15)-16, grid(10)-8);
				gc.drawString("" + UnitStats.Crit[Lang], grid(15)-16, grid(11)+4);
				gc.drawString("" + UnitStats.Avoid[Lang], grid(15)-16, grid(12)+15);
			}			
			
			gc.setColor(110,110,110);
			if(displaySide == Ally){
				gc.drawCenterString(AUnit[displayNum], grid(5)-12, grid(7)+12);
				gc.setColor(255,255,255);
				gc.drawClipImage(17, grid(1)+16-8, grid(1)-4+8, UnitNumber.ptCd(AClassNum[displayNum], 0, AClassNum[displayNum]), UnitNumber.ptCd(0, AClassNum[displayNum], AClassNum[displayNum]), 208, 187);
				gc.drawString(UnitStats.className(AClass[displayNum], Lang), grid(1), grid(9)+16);
				if(DataTab == 76){
					gc.setColor(203, 224, 247);
					gc.drawRightString("" + AStats[displayNum][0], grid(13), grid(3));
					gc.drawRightString("" + AStats[displayNum][1], grid(13), grid(4)+16);
					gc.drawRightString("" + AStats[displayNum][2], grid(13), grid(5)+32);
					gc.drawRightString("" + AStats[displayNum][3], grid(13), grid(6)+48);
					gc.drawRightString("" + AStats[displayNum][4], grid(18), grid(3));
					gc.drawRightString("" + AStats[displayNum][5], grid(18), grid(4)+16);
					gc.drawRightString("" + AStats[displayNum][6], grid(18), grid(5)+32);
					gc.drawRightString("" + AStats[displayNum][7], grid(18), grid(6)+48);
					
					if(AStatistics[displayNum][0] == -1){
						gc.drawRightString("--", grid(14), grid(11)+4);
					} if(AStatistics[displayNum][1] == -1){
						gc.drawRightString("--", grid(14), grid(12)+16);
					} if(AStatistics[displayNum][2] == -1 && AStatistics[displayNum][3] == -1){
						gc.drawRightString("--", grid(19)-8, grid(10)-8);
					} if(AStatistics[displayNum][4] == -1){
						gc.drawRightString("--", grid(19)-8, grid(11)+4);
					}
					else{
						gc.drawRightString("" + AStatistics[displayNum][0], grid(14), grid(11)+4);
						gc.drawRightString("" + AStatistics[displayNum][1], grid(14), grid(12)+16);
						if(AStatistics[displayNum][2] == AStatistics[displayNum][3]){
							gc.drawRightString("" + AStatistics[displayNum][3], grid(19)-8, grid(10)-8);
						}else{
							//gc.drawRightString("" + AStatistics[displayNum][2], grid(18)-10, grid(10)-8);
							//gc.drawCenterString("~", grid(18)-4, grid(10)-8);
							gc.drawRightString(AStatistics[displayNum][2] + "~" + AStatistics[displayNum][3], grid(19)-8, grid(10)-8);
						}
						gc.drawRightString("" + AStatistics[displayNum][4], grid(19)-8, grid(11)+4);
					}
					gc.drawRightString("" + AStatistics[displayNum][5], grid(19)-8, grid(12)+16);
				}
				else if(DataTab == 75){
					for(int i=0; i<5; i++){
						if(AWeapon[displayNum][i] != null){
							gc.drawClipImage(147, grid(9)-6, grid(3)+grid(i)+i*15 -2, WeaponData.rWeaponDat(AWeapon[displayNum][i], 6), WeaponData.rWeaponDat(AWeapon[displayNum][i], 7), 32, 32);
							gc.drawString("" + WeaponData.rWeaponInfo(AWeapon[displayNum][i], Lang), grid(10), grid(3)+grid(i)+i*15);
							gc.drawRightString("" + AWeaponDur[displayNum][i][0], grid(17), grid(3)+grid(i)+i*15);
							gc.setColor(250, 246, 35);
							gc.drawRightString("/", grid(17)+8, grid(3)+grid(i)+i*15);
							gc.setColor(255,255,255);
							gc.drawRightString("" + AWeaponDur[displayNum][i][1], grid(18), grid(3)+grid(i)+i*15);
						}
					}
				}
				
			}
			else if(displaySide == Enemy){
				gc.drawClipImage(74, grid(2)-16-8, grid(1)-4+8, 0, 180, 208, 188);
				gc.drawClipImage(17, grid(1)+16-8, grid(1)-4+8, UnitNumber.ptCd(EClassNum[displayNum], 0, EClassNum[displayNum]), UnitNumber.ptCd(0, EClassNum[displayNum], EClassNum[displayNum]), 208, 187);
				gc.drawCenterString(EUnit[displayNum], grid(5)-12, grid(7)+12);
				gc.setColor(255,255,255);
				gc.drawString(UnitStats.className(EClass[displayNum], Lang), grid(1), grid(9)+16);
				if(DataTab == 76){
					gc.setColor(203, 224, 247);
					gc.drawRightString("" + EStats[displayNum][0], grid(13), grid(3));
					gc.drawRightString("" + EStats[displayNum][1], grid(13), grid(4)+16);
					gc.drawRightString("" + EStats[displayNum][2], grid(13), grid(5)+32);
					gc.drawRightString("" + EStats[displayNum][3], grid(13), grid(6)+48);
					gc.drawRightString("" + EStats[displayNum][4], grid(18), grid(3));
					gc.drawRightString("" + EStats[displayNum][5], grid(18), grid(4)+16);
					gc.drawRightString("" + EStats[displayNum][6], grid(18), grid(5)+32);
					gc.drawRightString("" + EStats[displayNum][7], grid(18), grid(6)+48);
					
					if(EStatistics[displayNum][0] == -1){
						gc.drawRightString("--", grid(14), grid(11)+4);
					} if(EStatistics[displayNum][1] == -1){
						gc.drawRightString("--", grid(14), grid(12)+16);
					} if(EStatistics[displayNum][2] == -1 && EStatistics[displayNum][3] == -1){
						gc.drawRightString("--", grid(19)-8, grid(10)-8);
					} if(EStatistics[displayNum][4] == -1){
						gc.drawRightString("--", grid(19)-8, grid(11)+4);
					}
					else{
						gc.drawRightString("" + EStatistics[displayNum][0], grid(14), grid(11)+4);
						gc.drawRightString("" + EStatistics[displayNum][1], grid(14), grid(12)+16);
						if(EStatistics[displayNum][2] == EStatistics[displayNum][3]){
							gc.drawRightString("" + EStatistics[displayNum][3], grid(19)-8, grid(10)-8);
						}else{
							//gc.drawRightString("" + AStatistics[displayNum][2], grid(18)-10, grid(10)-8);
							//gc.drawCenterString("~", grid(18)-4, grid(10)-8);
							gc.drawRightString(EStatistics[displayNum][2] + "~" + EStatistics[displayNum][3], grid(19)-8, grid(10)-8);
						}
						gc.drawRightString("" + EStatistics[displayNum][4], grid(19)-8, grid(11)+4);
					}
					gc.drawRightString("" + EStatistics[displayNum][5], grid(19)-8, grid(12)+16);
				}
				else if(DataTab == 75){
					for(int i=0; i<5; i++){
						if(EWeapon[displayNum][i] != null){
							gc.drawClipImage(147, grid(9)-6, grid(3)+grid(i)+i*15 -2, WeaponData.rWeaponDat(EWeapon[displayNum][i], 6), WeaponData.rWeaponDat(EWeapon[displayNum][i], 7), 32, 32);
							gc.drawString("" + WeaponData.rWeaponInfo(EWeapon[displayNum][i], Lang), grid(10), grid(3)+grid(i)+i*15);
							gc.drawRightString("" + EWeaponDur[displayNum][i][0], grid(17), grid(3)+grid(i)+i*15);
							gc.setColor(250, 246, 35);
							gc.drawRightString("/", grid(17)+8, grid(3)+grid(i)+i*15);
							gc.setColor(255,255,255);
							gc.drawRightString("" + EWeaponDur[displayNum][i][1], grid(18), grid(3)+grid(i)+i*15);
						}
					}
					
				}
				
			}
			if(gc.isKeyPushed(gc.KEY_B) && turn == Ally || gc.isKeyPushed(gc.KEY_LEFT) && turn == Enemy){
				GameState = Game_Session;
			}
		}
	}
	void displayItems(){
		IgnoreB = true;
		int numberItems = 0;
		for(int i=0; i<5; i++){
			if(turn == Ally){
				if(AWeapon[SelectedUnit][i] != null){
					numberItems = i+1;
					//System.out.println("" + i);
				}
			} else if(turn == Enemy){
				if(EWeapon[SelectedUnit][i] != null){
					numberItems = i+1;
				}
			}
		}
		int itemOption[] = new int[numberItems];
		gc.setColor(255,255,255);
		gc.fillRect(grid(1)-6, grid(1)-6, grid(7)+12, grid(numberItems)+12);
		gc.setColor(0,0,255);
		gc.fillRect(grid(1)-4, grid(1)-4, grid(7)+8, grid(numberItems)+8);
		gc.setColor(255,255,255);
		for(int i=0; i<numberItems; i++){
			if(turn == Ally){
				gc.drawClipImage(147, grid(1)-2, grid(i+1)-2, WeaponData.rWeaponDat(AWeapon[SelectedUnit][i], 6), WeaponData.rWeaponDat(AWeapon[SelectedUnit][i], 7), 32, 32);
				gc.drawString("" + WeaponData.rWeaponInfo(AWeapon[SelectedUnit][i], Lang), grid(2), grid(i+1));
				gc.drawRightString("" + AWeaponDur[SelectedUnit][i][0], grid(7)-2, grid(i+1));
				gc.drawCenterString("/", grid(7)+2, grid(i+1));
				gc.drawRightString("" + AWeaponDur[SelectedUnit][i][1], grid(8)-4, grid(i+1));
				//System.out.println(i + ", " + AWeapon[SelectedUnit][i]);
			} else if(turn == Enemy){
				gc.drawClipImage(147, grid(1)-2, grid(i+1)-2, WeaponData.rWeaponDat(EWeapon[SelectedUnit][i], 6), WeaponData.rWeaponDat(EWeapon[SelectedUnit][i], 7), 32, 32);
				gc.drawString("" + WeaponData.rWeaponInfo(EWeapon[SelectedUnit][i], Lang), grid(2), grid(i+1));
				gc.drawRightString("" + EWeaponDur[SelectedUnit][i][0], grid(7)-2, grid(i+1));
				gc.drawCenterString("/", grid(7)+2, grid(i+1));
				gc.drawRightString("" + EWeaponDur[SelectedUnit][i][1], grid(8)-4, grid(i+1));
			}
		}
		gc.drawClipImage(74, grid(2), selectionI1, 0, 0, 54, 20);
		if(tryEquip){
			String item = "--";
			if(turn == Ally){
				item = AWeapon[SelectedUnit][commandLoc];
			} else if(turn == Enemy){
				item = EWeapon[SelectedUnit][commandLoc];
			}
			//System.out.println("" + item);
			if(WeaponData.rWeaponInfo(item, 2) != "Item"){
				gc.setColor(0,0,255);
				gc.fillRect(grid(6)-17, grid(commandLoc)+17, grid(3)+2, (grid(3)+2)/2);
				gc.setColor(255,255,255);
				gc.drawRect(grid(6)-17, grid(commandLoc)+17, grid(3)+2, (grid(3)+2)/2);
				gc.setColor(0, 255, 0);
				String equip = "";
				if(Lang == 0){
					equip = "Equip";
				} else if(Lang == 1){
					equip = "装備";
				}
				gc.drawCenterString(equip + "", grid(7) + 1, grid(commandLoc)+28);
				gc.drawClipImage(74, grid(6)+6, grid(commandLoc)+32, 0, 0, 54, 20);
				if(gc.isKeyPushed(gc.KEY_M) && turn == Ally && tryEquip || gc.isKeyPushed(gc.KEY_RIGHT) && turn == Enemy && tryEquip){
					UnitStats.equipWeapon(turn, SelectedUnit, commandLoc);
					tryEquip = false;
					BButtonUnlocked = 1;
					AButtonUnlocked = 2;
					selectionI1 = grid(1);
					commandLoc = 0;
				}
			}
			if(gc.isKeyPushed(gc.KEY_B) && turn == Ally || gc.isKeyPushed(gc.KEY_LEFT) && turn == Enemy && tryEquip){
				tryEquip = false;
				BButtonUnlocked = 1;
				AButtonUnlocked = 1;
			}
			
		}
		if(gc.isKeyPushed(gc.KEY_W) && turn == Ally && !tryEquip || gc.isKeyPushed(gc.KEY_I) && turn == Enemy && !tryEquip){
			if(selectionI1 > grid(1)){
				selectionI1-=grid(1);
				commandLoc--;
			}
		}
		else if(gc.isKeyPushed(gc.KEY_S) && turn == Ally && !tryEquip|| gc.isKeyPushed(gc.KEY_K) && turn == Enemy && !tryEquip){
			if(selectionI1 < grid(numberItems)){
				selectionI1+=grid(1);
				commandLoc++;
			}
		}
		else if(gc.isKeyPushed(gc.KEY_B) && turn == Ally && BButtonUnlocked == 0|| gc.isKeyPushed(gc.KEY_LEFT) && turn == Enemy && BButtonUnlocked == 0){
			selectionI1 = grid(1);
			ItemLookup = false;
			commandLoc = commandHold;
		}
		else if(gc.isKeyPushed(gc.KEY_M) && AButtonUnlocked == 1 && turn == Ally && WeaponData.rWeaponInfo(AWeapon[SelectedUnit][commandLoc], 2) != "Staff"|| 
				gc.isKeyPushed(gc.KEY_RIGHT) && AButtonUnlocked == 1 && turn == Enemy && WeaponData.rWeaponInfo(EWeapon[SelectedUnit][commandLoc], 2) != "Staff"){
			tryEquip = true;
		}
		AButtonUnlocked = 1;
		BButtonUnlocked = 0;
		
	}
	void checkStatistics(){
		for(int i=0; i<100; i++){
			if(AAlive[i]){
				if(AWeapon[i][0] != null){
					if(WeaponData.rWeaponInfo(AWeapon[i][0], 3) != "Special"){
						AStatistics[i][1] = DmgFormula.hitRate(Ally, i, AWeapon[i][0]);//hit
						AStatistics[i][2] = WeaponData.rWeaponDat(AWeapon[i][0], 3);
						AStatistics[i][3] = WeaponData.rWeaponDat(AWeapon[i][0], 4);
						AStatistics[i][4] = DmgFormula.critRate(Ally, i, AWeapon[i][0]);//crit
						if(WeaponData.rWeaponInfo(AWeapon[i][0], 3) == "Physical"){
							AStatistics[i][0] = DmgFormula.pAttack(AStats[i][0], AWeapon[i][0], "---", "---");//attack
						}
						else if(WeaponData.rWeaponInfo(AWeapon[i][0], 3) == "Magical"){
							AStatistics[i][0] = DmgFormula.mAttack(AStats[i][1], AWeapon[i][0], "---", "---");//attack
						}
					} else{
						AStatistics[i][1] = DmgFormula.hitRate(Ally, i, "---");//hit
						AStatistics[i][4] = DmgFormula.critRate(Ally, i, "---");//crit
					}
				}
				else if(AWeapon[i][0] == null){
					AStatistics[i][0] = -1;
					AStatistics[i][1] = -1;
					AStatistics[i][2] = -1;
					AStatistics[i][3] = -1;
					AStatistics[i][4] = -1;
				}
				AStatistics[i][5] = DmgFormula.evadeRate(Ally, i);//evade
			}
			if(EAlive[i]){
				if(EWeapon[i][0] != null){
					if(WeaponData.rWeaponInfo(EWeapon[i][0], 3) != "Special"){
						EStatistics[i][1] = DmgFormula.hitRate(Enemy, i, EWeapon[i][0]);//hit
						EStatistics[i][2] = WeaponData.rWeaponDat(EWeapon[i][0], 3);
						EStatistics[i][3] = WeaponData.rWeaponDat(EWeapon[i][0], 4);
						EStatistics[i][4] = DmgFormula.critRate(Enemy, i, EWeapon[i][0]);//crit
						if(WeaponData.rWeaponInfo(EWeapon[i][0], 3) == "Physical"){
							EStatistics[i][0] = DmgFormula.pAttack(EStats[i][0], EWeapon[i][0], "---", "---");//attack
						}
						else if(WeaponData.rWeaponInfo(EWeapon[i][0], 3) == "Magical"){
							EStatistics[i][0] = DmgFormula.mAttack(EStats[i][1], EWeapon[i][0], "---", "---");//attack
						}
					} else{
						EStatistics[i][1] = DmgFormula.hitRate(Enemy, i, "---");//hit
						EStatistics[i][4] = DmgFormula.critRate(Enemy, i, "---");//crit
					}					
				}
				else if(EWeapon[i][0] == null){
					EStatistics[i][0] = -1;
					EStatistics[i][1] = -1;
					EStatistics[i][2] = -1;
					EStatistics[i][3] = -1;
					EStatistics[i][4] = -1;
				}
				EStatistics[i][5] = DmgFormula.evadeRate(Enemy, i);//evade
			}
		}
	}
	void checkVictory(){
		boolean p1loss = false;
		boolean p2loss = false;
		for(int i=0; i<100; i++){
			if(AAlive[i]){
				break;
			}
			else if(!AAlive[99]){
				p1loss = true;
			}
		}
		for(int i=0; i<100; i++){
			if(EAlive[i]){
				break;
			}
			else if(!EAlive[99]){
				p2loss = true;
			}
		}
		if(p1loss){
			ignoreKeys = true;
			System.out.println("p2 victory");
		}
		else if(p2loss){
			ignoreKeys = true;
			System.out.println("p1 victory");
		}
	}
}
