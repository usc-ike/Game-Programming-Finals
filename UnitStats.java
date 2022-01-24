//インポート
import gameCanvasUtil.*;

import java.util.*;

public class UnitStats{
	static int MaxUnitNum = 0;
	static int AStartLocationX[] = new int[50];
	static int AStartLocationY[] = new int[50];
	static int EStartLocationX[] = new int[50];
	static int EStartLocationY[] = new int[50];
	
	
	static String Strength[] = new String[]{"Str", "力"};
	static String Magic[] = new String[]{"Mag", "魔力"};
	static String Skill[] = new String[]{"Skill", "技"};
	static String Speed[] = new String[]{"Spd", "速さ"};
	static String Luck[] = new String[]{"Luck", "幸運"};
	static String Defense[] = new String[]{"Def", "守備"};
	static String Resistance[] = new String[]{"Res", "魔防"};
	static String Movement[] = new String[]{"Mvmt", "移動"};
	
	static String Equipment[] = new String[]{"Equipment", "戦闘力"};
	static String Range[] = new String[]{"Rng", "射程"};
	static String Attack[] = new String[]{"Atk", "攻撃"};
	static String Hit[] = new String[]{"Hit", "命中"};
	static String Crit[] = new String[]{"Crit", "必殺"};
	static String Avoid[] = new String[]{"Avoid", "回避"};
	static String Might[] = new String[]{"Mt", "威力"};
	
	static String Fight[] = new String[]{"Attack", "攻撃"};
	static String Heal[] = new String[]{"Heal", "杖"};
	static String Dance[] = new String[]{"Dance", "踊る"};
	static String Rescue[] = new String[]{"Rescue", "救出"};
	static String Drop[] = new String[]{"Drop", "降ろす"};
	static String Items[] = new String[]{"Item", "持ち物"};
	static String Trade[] = new String[]{"Trade", "交換"};
	static String Wait[] = new String[]{"Wait", "待機"};
	
	static String LSetting[] = new String[]{"Select Language", "言語設定"};
	static String Units[] = new String[]{"Units", "部隊表"};
	static String Help[] = new String[]{"Help", "指南"};
	static String Options[] = new String[]{"Options", "環境"};
	static String End[] = new String[]{"End", "終了"};
	
	static Random rand = new Random();
	static String PaladinName[] = new String[]{"Paladin", "パラディン"};
	static String WyvernLordName[] = new String[]{"Wyvern Lord", "ドラゴンマスター"};
	static String SageName[] = new String[]{"Sage", "賢者"};
	static String SniperName[] = new String[]{"Sniper", "スナイパー"};
	static String HeroName[] = new String[]{"Hero", "勇者"};
	static String GeneralName[] = new String[]{"Genaral", "ジェネラル"};
	static String DruidName[] = new String[]{"Druid", "ドルイド"};
	static String BishopName[] = new String[]{"Bishop", "司祭"};
	static String ValkyrieName[] = new String[]{"Valkyrie", "ヴァルキュリア"};
	static String SwordmasterName[] = new String[]{"Swordmaster", "ソードマスター"};
	static String FalconKnightName[] = new String[]{"Falcon Knight", "ファルコンナイト"};
	
	static String Arena[] = new String[]{"Arena", "闘技場"};
	static String Bridge[] = new String[]{"Bridge", "橋"};
	static String Cliff[] = new String[]{"Cliff", "崖"};
	static String Deck[] = new String[]{"Deck", "甲板"};
	static String Desert[] = new String[]{"Desert", "砂漠"};
	static String Door[] = new String[]{"Door", "扉"};
	static String Fence[] = new String[]{"Fence", "柵"};
	static String Floor[] = new String[]{"Floor", "床"};
	static String Forest[] = new String[]{"Forest", "森"};
	static String Fort[] = new String[]{"Fort", "砦"};
	static String Flat[] = new String[]{"Flat", "荒地"};
	static String Gate[] = new String[]{"Gate", "城門"};
	static String House[] = new String[]{"House", "民家"};
	static String Lake[] = new String[]{"Lake", "湖"};
	static String Mountain[] = new String[]{"Mountain", "山"};
	static String Peak[] = new String[]{"Peak", "高山"};
	static String Pillar[] = new String[]{"Pillar", "柱"};
	static String Plain[] = new String[]{"Plains", "平地"};
	static String River[] = new String[]{"River", "河"};
	static String Road[] = new String[]{"Road", "道路"};
	static String Ruins[] = new String[]{"Ruins", "廃墟"};
	static String VRuins[] = new String[]{"Ruins", "遺跡"};
	static String Sand[] = new String[]{"Sand", "砂"};
	static String Sea[] = new String[]{"Sea", "海"};
	static String Shop[] = new String[]{"Shop", "道具屋"};
	static String Snag[] = new String[]{"Snag", "枯れ木"};
	static String Stairs[] = new String[]{"Stairs", "階段"};
	static String Throne[] = new String[]{"Throne", "玉座"};
	static String Valley[] = new String[]{"Valley", "谷"};
	static String Village[] = new String[]{"Village", "村"};
	static String Wall[] = new String[]{"Wall", "壁"};
	static String WWall[] = new String[]{"Wall", "壁"};
	static String Wasteland[] = new String[]{"Wasteland", "荒野"};
	
	/** Class Statcap (HP, Strength, Magic, Skill, Speed, Luck, Defense, Resistance, Movement)**/
	static int PaladinStat[] = new int[] {60, 26, 20, 26, 27, 40, 27, 25, 9};
	static int WyvernLordStat[] = new int[] {60, 29, 20, 28, 26, 30, 39, 22, 9};
	static int SageStat[] = new int[] {60, 15, 30, 28, 28, 40, 20, 28, 6};
	static int SniperStat[] = new int[] {60, 25, 20, 30, 28, 40, 25, 23, 7};
	static int HeroStat[] = new int[] {60, 26, 20, 27, 28, 40, 24, 22, 7};
	static int GeneralStat[] = new int[]{60, 29, 20, 27, 24, 40, 30, 25, 6};
	static int DruidStat[] = new int[]{60, 15, 29, 26, 26, 30, 21, 28, 6};
	static int FalconKnightStat[] = new int[]{60, 23, 20, 26, 28, 40, 24, 27, 9};
	static int BishopStat[] = new int[]{60, 15, 29, 22, 25, 40, 20, 30, 6};
	static int ValkyrieStat[] = new int[]{60, 20, 26, 24, 26, 40, 20, 29, 8};
	static int SwordmasterStat[] = new int[]{60, 24, 20, 29, 30, 40, 24, 22, 7};
	
	
	static String className(String sClass, int lang){
		String cName = "";
		switch(sClass){
			case "Paladin":
				cName = PaladinName[lang];
				break;
			case "WyvernLord":
				cName = WyvernLordName[lang];
				break;
			case "Sage":
				cName = SageName[lang];
				break;
			case "Sniper":
				cName = SniperName[lang];
				break;
			case "Hero":
				cName = HeroName[lang];
				break;
			case "General":
				cName = GeneralName[lang];
				break;
			case "Druid":
				cName = DruidName[lang];
				break;
			case "Bishop":
				cName = BishopName[lang];
				break;
			case "Valkyrie":
				cName = ValkyrieName[lang];
				break;
			case "Swordmaster":
				cName = SwordmasterName[lang];
				break;
			case "FalconKnight":
				cName = FalconKnightName[lang];
				break;
			
			default:
				break;
		}
		return cName;
	}
	
	static void randomizeStats(int side, int i){
		if(side == Game.Ally && Game.AClass[i] != null && Game.AAlive[i]){
			for(int j=0; j<9; j++){
				if(j==7){
					Game.AStats[i][j] = getStat(Game.AClass[i], 8);
				}
				else if(j == 8){
					Game.AHP[i][1] = getStat(Game.AClass[i], 0);
					Game.AHP[i][0] = Game.AHP[i][1];
				}
				else{
					Game.AStats[i][j] = getStat(Game.AClass[i], j+1);
				}
			}
		}
		else if(side == Game.Enemy && Game.EClass[i] != null && Game.EAlive[i]){
			for(int j=0; j<9; j++){
				if(j==7){
					Game.EStats[i][j] = getStat(Game.EClass[i], 8);
				}
				else if(j == 8){
					Game.EHP[i][1] = getStat(Game.EClass[i], 0);
					Game.EHP[i][0] = Game.EHP[i][1];
				}
				else{
					Game.EStats[i][j] = getStat(Game.EClass[i], j+1);
				}
			}
		}
	}
	
	static int getStat(String unit, int index){
		int rm = 65;
		int rM = 80;
		int N = 0;
		switch(unit){
			case "Paladin":
				if(index == 8){
					N = PaladinStat[8];
				}else if(index == 0){
					N = rng(PaladinStat[0] * rm/100, PaladinStat[0] * rM/100);
				}else{
					N = rng(PaladinStat[index] * rm/100, PaladinStat[index] * rM/100);
				}
				break;
			case "WyvernLord":
				if(index == 8){
					N = WyvernLordStat[8];
				}else if(index == 0){
					N = rng(WyvernLordStat[0] * rm/100, WyvernLordStat[0] * rM/100);
				}else{
					N = rng(WyvernLordStat[index] * rm/100, WyvernLordStat[index] * rM/100);
				}
				break;
			case "Sage":
				if(index == 8){
					N = SageStat[8];
				}else if(index == 0){
					N = rng(SageStat[0] * rm/100, SageStat[0] * rM/100);
				}else{
					N = rng(SageStat[index] * rm/100, SageStat[index] * rM/100);
				}
				break;
			case "Hero":
				if(index == 8){
					N = HeroStat[8];
				}else if(index == 0){
					N = rng(HeroStat[0] * rm/100, HeroStat[0] * rM/100);
				}else{
					N = rng(HeroStat[index] * rm/100, HeroStat[index] * rM/100);
				}
				break;
			case "Sniper":
				if(index == 8){
					N = SniperStat[8];
				}else if(index == 0){
					N = rng(SniperStat[0] * rm/100, SniperStat[0] * rM/100);
				}else{
					N = rng(SniperStat[index] * rm/100, SniperStat[index] * rM/100);
				}
				break;
			case "General":
				if(index == 8){
					N = GeneralStat[8];
				}else if(index == 0){
					N = rng(GeneralStat[0] * rm/100, GeneralStat[0] * rM/100);
				}else{
					N = rng(GeneralStat[index] * rm/100, GeneralStat[index] * rM/100);
				}
				break;
			case "Druid":
				if(index == 8){
					N = DruidStat[8];
				}else if(index == 0){
					N = rng(DruidStat[0] * rm/100, DruidStat[0] * rM/100);
				}else{
					N = rng(DruidStat[index] * rm/100, DruidStat[index] * rM/100);
				}
				break;
			case "Valkyrie":
				if(index == 8){
					N = ValkyrieStat[8];
				}else if(index == 0){
					N = rng(ValkyrieStat[0] * rm/100, ValkyrieStat[0] * rM/100);
				}else{
					N = rng(ValkyrieStat[index] * rm/100, ValkyrieStat[index] * rM/100);
				}
				break;
			case "FalconKnight":
				if(index == 8){
					N = FalconKnightStat[8];
				}else if(index == 0){
					N = rng(FalconKnightStat[0] * rm/100, FalconKnightStat[0] * rM/100);
				}else{
					N = rng(FalconKnightStat[index] * rm/100, FalconKnightStat[index] * rM/100);
				}
				break;
			case "Swordmaster":
				if(index == 8){
					N = SwordmasterStat[8];
				}else if(index == 0){
					N = rng(SwordmasterStat[0] * rm/100, SwordmasterStat[0] * rM/100);
				}else{
					N = rng(SwordmasterStat[index] * rm/100, SwordmasterStat[index] * rM/100);
				}
				break;
			case "Bishop":
				if(index == 8){
					N = BishopStat[8];
				}else if(index == 0){
					N = rng(BishopStat[0] * rm/100, BishopStat[0] * rM/100);
				}else{
					N = rng(BishopStat[index] * rm/100, BishopStat[index] * rM/100);
				}
				break;
			default:
				break;
		}
		return N;
	}
	
	static int rng(int min, int max)
    {
        if(min < 0 || max < 0) return -1;

        int tmp = rand.nextInt();
        if (tmp < 0)
            tmp = -tmp;
        if (min < max)
        {
            max = max - min + 1;
            return tmp % max + min;
        }
        else
        {
            min = min - max + 1;
            return tmp % min + max;
        }
    }
	
	static int UnitType(int s, int i, String u){
		String cName = "";
		int aState = 0;
		int eState = 0;
		int cState = 0;
		if(s == Game.Ally){
			cName = Game.AClass[i];
		}
		else if(s == Game.Enemy){
			cName = Game.EClass[i];
		}
		switch(cName){
			case "Paladin":	if(u == "Idle"){
								aState = UnitNumber.APaladinIdle;//UnitNumber.APaladinIdle1 + UnitAnimate;
								eState = UnitNumber.EPaladinIdle;
							}else if(u == "Active"){
								aState = UnitNumber.APaladinActive; //UnitNumber.APaladinActive1 + SelectedAnimate;
								eState = UnitNumber.EPaladinActive;
							}else if(u == "Running" || u == "Left" || u == "Right"){
								aState = UnitNumber.APaladinRun; //UnitNumber.APaladinRun1 + RunAnimate;
								eState = UnitNumber.EPaladinRun;
							}else if(u == "Up"){
								aState = UnitNumber.APaladinUp; //UnitNumber.APaladinUp1 + RunAnimate;
								eState = UnitNumber.EPaladinUp;
							}else if(u == "Down"){
								aState = UnitNumber.APaladinDown; //UnitNumber.APaladinDown1 + RunAnimate;
								eState = UnitNumber.EPaladinDown;
							}else if(u == "Wait"){
								aState = UnitNumber.PaladinWait; //UnitNumber.PaladinWait1 + RunAnimate;
								eState = UnitNumber.PaladinWait;
							}
							break;
			case "WyvernLord":	if(u == "Idle"){
								aState = UnitNumber.AWyvernLordIdle;
								eState = UnitNumber.EWyvernLordIdle;
							}else if(u == "Active"){
								aState = UnitNumber.AWyvernLordActive;
								eState = UnitNumber.EWyvernLordActive;
							}else if(u == "Running" || u == "Left" || u == "Right"){
								aState = UnitNumber.AWyvernLordRun;
								eState = UnitNumber.EWyvernLordRun;
							}else if(u == "Up"){
								aState = UnitNumber.AWyvernLordUp;
								eState = UnitNumber.EWyvernLordUp;
							}else if(u == "Down"){
								aState = UnitNumber.AWyvernLordDown;
								eState = UnitNumber.EWyvernLordDown;
							}else if(u == "Wait"){
								aState = UnitNumber.WyvernLordWait;
								eState = UnitNumber.WyvernLordWait;
							}
							break;
			case "Sage":	if(u == "Idle"){
								aState = UnitNumber.ASageIdle;
								eState = UnitNumber.ESageIdle;
							}else if(u == "Active"){
								aState = UnitNumber.ASageActive;
								eState = UnitNumber.ESageActive;
							}else if(u == "Left" || u == "Right"){
								aState = UnitNumber.ASageRun;
								eState = UnitNumber.ESageRun;
							}else if(u == "Up"){
								aState = UnitNumber.ASageUp;
								eState = UnitNumber.ESageUp;
							}else if(u == "Down" || u == "Running"){
								aState = UnitNumber.ASageDown;
								eState = UnitNumber.ESageDown;
							}else if(u == "Wait"){
								aState = UnitNumber.SageWait;
								eState = UnitNumber.SageWait;
							}
							break;
			case "Sniper":	if(u == "Idle"){
								aState = UnitNumber.ASniperIdle;
								eState = UnitNumber.ESniperIdle;
							}else if(u == "Active"){
								aState = UnitNumber.ASniperActive;
								eState = UnitNumber.ESniperActive;
							}else if(u == "Left" || u == "Right"){
								aState = UnitNumber.ASniperRun;
								eState = UnitNumber.ESniperRun;
							}else if(u == "Up"){
								aState = UnitNumber.ASniperUp;
								eState = UnitNumber.ESniperUp;
							}else if(u == "Down" || u == "Running"){
								aState = UnitNumber.ASniperDown;
								eState = UnitNumber.ESniperDown;
							}else if(u == "Wait"){
								aState = UnitNumber.SniperWait;
								eState = UnitNumber.SniperWait;
							}
							break;
			case "Hero":	if(u == "Idle"){
								aState = UnitNumber.AHeroIdle;
								eState = UnitNumber.EHeroIdle;
							}else if(u == "Active"){
								aState = UnitNumber.AHeroActive;
								eState = UnitNumber.EHeroActive;
							}else if(u == "Left" || u == "Right"){
								aState = UnitNumber.AHeroRun;
								eState = UnitNumber.EHeroRun;
							}else if(u == "Up"){
								aState = UnitNumber.AHeroUp;
								eState = UnitNumber.EHeroUp;
							}else if(u == "Down" || u == "Running"){
								aState = UnitNumber.AHeroDown;
								eState = UnitNumber.EHeroDown;
							}else if(u == "Wait"){
								aState = UnitNumber.HeroWait;
								eState = UnitNumber.HeroWait;
							}
							break;
			case "General":	if(u == "Idle"){
								aState = UnitNumber.AGeneralIdle;
								eState = UnitNumber.EGeneralIdle;
							}else if(u == "Active"){
								aState = UnitNumber.AGeneralActive;
								eState = UnitNumber.EGeneralActive;
							}else if(u == "Left" || u == "Right"){
								aState = UnitNumber.AGeneralRun;
								eState = UnitNumber.EGeneralRun;
							}else if(u == "Up"){
								aState = UnitNumber.AGeneralUp;
								eState = UnitNumber.EGeneralUp;
							}else if(u == "Down" || u == "Running"){
								aState = UnitNumber.AGeneralDown;
								eState = UnitNumber.EGeneralDown;
							}else if(u == "Wait"){
								aState = UnitNumber.GeneralWait;
								eState = UnitNumber.GeneralWait;
							}
							break;
			case "Swordmaster":	if(u == "Idle"){
								aState = UnitNumber.ASwordmasterIdle;
								eState = UnitNumber.ESwordmasterIdle;
							}else if(u == "Active"){
								aState = UnitNumber.ASwordmasterActive;
								eState = UnitNumber.ESwordmasterActive;
							}else if(u == "Left" || u == "Right"){
								aState = UnitNumber.ASwordmasterRun;
								eState = UnitNumber.ESwordmasterRun;
							}else if(u == "Up"){
								aState = UnitNumber.ASwordmasterUp;
								eState = UnitNumber.ESwordmasterUp;
							}else if(u == "Down" || u == "Running"){
								aState = UnitNumber.ASwordmasterDown;
								eState = UnitNumber.ESwordmasterDown;
							}else if(u == "Wait"){
								aState = UnitNumber.SwordmasterWait;
								eState = UnitNumber.SwordmasterWait;
							}
							break;		
			case "Bishop":	if(u == "Idle"){
								aState = UnitNumber.ABishopIdle;
								eState = UnitNumber.EBishopIdle;
							}else if(u == "Active"){
								aState = UnitNumber.ABishopActive;
								eState = UnitNumber.EBishopActive;
							}else if(u == "Left" || u == "Right"){
								aState = UnitNumber.ABishopRun;
								eState = UnitNumber.EBishopRun;
							}else if(u == "Up"){
								aState = UnitNumber.ABishopUp;
								eState = UnitNumber.EBishopUp;
							}else if(u == "Down" || u == "Running"){
								aState = UnitNumber.ABishopDown;
								eState = UnitNumber.EBishopDown;
							}else if(u == "Wait"){
								aState = UnitNumber.BishopWait;
								eState = UnitNumber.BishopWait;
							}
							break;		
			case "Druid":	if(u == "Idle"){
								aState = UnitNumber.ADruidIdle;
								eState = UnitNumber.EDruidIdle;
							}else if(u == "Active"){
								aState = UnitNumber.ADruidActive;
								eState = UnitNumber.EDruidActive;
							}else if(u == "Left" || u == "Right"){
								aState = UnitNumber.ADruidRun;
								eState = UnitNumber.EDruidRun;
							}else if(u == "Up"){
								aState = UnitNumber.ADruidUp;
								eState = UnitNumber.EDruidUp;
							}else if(u == "Down" || u == "Running"){
								aState = UnitNumber.ADruidDown;
								eState = UnitNumber.EDruidDown;
							}else if(u == "Wait"){
								aState = UnitNumber.DruidWait;
								eState = UnitNumber.DruidWait;
							}
							break;		
			case "Valkyrie":	if(u == "Idle"){
								aState = UnitNumber.AValkyrieIdle;
								eState = UnitNumber.EValkyrieIdle;
							}else if(u == "Active"){
								aState = UnitNumber.AValkyrieActive;
								eState = UnitNumber.EValkyrieActive;
							}else if(u == "Running" || u == "Left" || u == "Right"){
								aState = UnitNumber.AValkyrieRun;
								eState = UnitNumber.EValkyrieRun;
							}else if(u == "Up"){
								aState = UnitNumber.AValkyrieUp;
								eState = UnitNumber.EValkyrieUp;
							}else if(u == "Down"){
								aState = UnitNumber.AValkyrieDown;
								eState = UnitNumber.EValkyrieDown;
							}else if(u == "Wait"){
								aState = UnitNumber.ValkyrieWait;
								eState = UnitNumber.ValkyrieWait;
							}
							break;
			case "FalconKnight":	if(u == "Idle"){
								aState = UnitNumber.AFalconKnightIdle;
								eState = UnitNumber.EFalconKnightIdle;
							}else if(u == "Active"){
								aState = UnitNumber.AFalconKnightActive;
								eState = UnitNumber.EFalconKnightActive;
							}else if(u == "Running" || u == "Left" || u == "Right"){
								aState = UnitNumber.AFalconKnightRun;
								eState = UnitNumber.EFalconKnightRun;
							}else if(u == "Up"){
								aState = UnitNumber.AFalconKnightUp;
								eState = UnitNumber.EFalconKnightUp;
							}else if(u == "Down"){
								aState = UnitNumber.AFalconKnightDown;
								eState = UnitNumber.EFalconKnightDown;
							}else if(u == "Wait"){
								aState = UnitNumber.FalconKnightWait;
								eState = UnitNumber.FalconKnightWait;
							}
							break;
			default: break;
		}
		if(s == Game.Ally){
			cState = aState;
		}
		else if(s == Game.Enemy){
			cState = eState;
		}
		return(cState);
	}
	
	static void determineDirection(){
		boolean triggerDetermine = false;
		boolean udDetermine = false;
		boolean rlDetermine = false;
		if(Game.SelectedSide == Game.Ally){
			Game.AStatus[Game.SelectedUnit][2] = true;
		}
		else if(Game.SelectedSide == Game.Enemy){
			Game.EStatus[Game.SelectedUnit][2] = true;
		}
		if(Game.pathDirection[Game.stepsTaken] == "RStart" || Game.pathDirection[Game.stepsTaken] == "RArrow" || Game.pathDirection[Game.stepsTaken] == "SouthEast" || Game.pathDirection[Game.stepsTaken] == "NorthEast" || Game.pathDirection[Game.stepsTaken] == "HorizontalR"){
			udDetermine = true;
			rlDetermine = true;
			//System.out.println("working3R");
		}
		else if(Game.pathDirection[Game.stepsTaken] == "LStart" || Game.pathDirection[Game.stepsTaken] == "LArrow" || Game.pathDirection[Game.stepsTaken] == "NorthWest" || Game.pathDirection[Game.stepsTaken] == "SouthWest" || Game.pathDirection[Game.stepsTaken] == "HorizontalL"){
			udDetermine = true;
			rlDetermine = false;
			//System.out.println("working3L");
		}
		else if(Game.pathDirection[Game.stepsTaken] == "UStart" || Game.pathDirection[Game.stepsTaken] == "UArrow" || Game.pathDirection[Game.stepsTaken] == "WestNorth" || Game.pathDirection[Game.stepsTaken] == "EastNorth" || Game.pathDirection[Game.stepsTaken] == "VerticalU"){
			udDetermine = false;
			rlDetermine = true;
			//System.out.println("working3U");
		}
		else if(Game.pathDirection[Game.stepsTaken] == "DStart" || Game.pathDirection[Game.stepsTaken] == "DArrow" || Game.pathDirection[Game.stepsTaken] == "WestSouth" || Game.pathDirection[Game.stepsTaken] == "EastSouth" || Game.pathDirection[Game.stepsTaken] == "VerticalD"){
			udDetermine = false;
			rlDetermine = false;
			//System.out.println("working3D");
		}
		if(Game.SelectedSide == Game.Ally){
			Game.AStatus[Game.SelectedUnit][3] = udDetermine;
			Game.AStatus[Game.SelectedUnit][4] = rlDetermine;
		}
		else if(Game.SelectedSide == Game.Enemy){
			Game.EStatus[Game.SelectedUnit][3] = udDetermine;
			Game.EStatus[Game.SelectedUnit][4] = rlDetermine;
		}
	}
	static String detectDefWeapon(int side, int aIdx){
		String dWpn = null;
		
		if(side == Game.Ally){
			if(Game.EWeapon[Game.TargetId[aIdx]][0] == null){
				dWpn = "--";
			}
			else{
				for(int i=0; i<5; i++){
					if(WeaponData.rWeaponInfo(Game.EWeapon[Game.TargetId[aIdx]][i], 3) != "Special"){
						dWpn = Game.EWeapon[Game.TargetId[aIdx]][i];
						break;
					}
				}
				if(dWpn == null){
					for(int i=0; i<5; i++){
						if(WeaponData.rWeaponInfo(Game.EWeapon[Game.TargetId[aIdx]][i], 2) == "Staff"){
							dWpn = Game.EWeapon[Game.TargetId[aIdx]][i];
							break;
						}
					}
				}
			}
		} else if(side == Game.Enemy){
			if(Game.AWeapon[Game.TargetId[aIdx]][0] == null){
				dWpn = "--";
			}
			else{
				for(int i=0; i<5; i++){
					if(WeaponData.rWeaponInfo(Game.AWeapon[Game.TargetId[aIdx]][i], 3) != "Special"){
						dWpn = Game.AWeapon[Game.TargetId[aIdx]][i];
						break;
					}
				}
				if(dWpn == null){
					for(int i=0; i<5; i++){
						if(WeaponData.rWeaponInfo(Game.AWeapon[Game.TargetId[aIdx]][i], 2) == "Staff"){
							dWpn = Game.AWeapon[Game.TargetId[aIdx]][i];
							break;
						}
					}
				}
			}
		}
		return(dWpn);
	}
	
	static String tileName(String terr, int lan){
		String reTile = "";
		switch(terr){
			case "--":
				reTile = "--";
				break;
			case "Arena":
				reTile = Arena[lan];
				break;
			case "Bridge":
				reTile = Bridge[lan];
				break;
			case "Cliff":
				reTile = Cliff[lan];
				break;
			case "Deck":
				reTile = Deck[lan];
				break;
			case "Desert":
				reTile = Desert[lan];
				break;
			case "Door":
				reTile = Door[lan];
				break;
			case "Fence":
				reTile = Fence[lan];
				break;
			case "Floor":
				reTile = Floor[lan];
				break;
			case "Forest":
				reTile = Forest[lan];
				break;
			case "Fort":
				reTile = Fort[lan];
				break;
			case "Flat":
				reTile = Flat[lan];
				break;
			case "Gate":
				reTile = Gate[lan];
				break;
			case "House":
				reTile = House[lan];
				break;
			case "Lake":
				reTile = Lake[lan];
				break;
			case "Mountain":
				reTile = Mountain[lan];
				break;
			case "Peak": 
				reTile = Peak[lan];
				break;
			case "Pillar": 
				reTile = Pillar[lan];
				break;
			case "Plain":
				reTile = Plain[lan];
				break;
			case "River":
				reTile = River[lan];
				break;
			case "Road":
				reTile = Road[lan];
				break;
			case "Ruins":
				reTile = Ruins[lan];
				break;
			case "Ruins (Village)":
				reTile = VRuins[lan];
				break;
			case "Sand":
				reTile = Sand[lan];
				break;
			case "Sea":
				reTile = Sea[lan];
				break;
			case "Shop":
				reTile = Shop[lan];
				break;
			case "Snag":
				reTile = Snag[lan];
				break;
			case "Stairs":
				reTile = Stairs[lan];
				break;
			case "Throne":
				reTile = Throne[lan];
				break;
			case "Valley":
				reTile = Valley[lan];
				break;
			case "Village":
				reTile = Village[lan];
				break;
			case "Wall":
				reTile = Wall[lan];
				break;
			case "Wall (Weak)":
				reTile = WWall[lan];
			case "Wasteland":
				reTile = Wasteland[lan];
				break;
			default: 
				break;
		}
		return(reTile);
	}
	static void weaponBroke(int side, int UnitNum, int BrIdx){
		if(side == Game.Ally){
			for(int i=BrIdx; i<5; i++){
				if(i+1 < 4){
					Game.AWeapon[UnitNum][i] = Game.AWeapon[UnitNum][i+1];
					Game.AWeaponDur[UnitNum][i][0] = Game.AWeaponDur[UnitNum][i+1][0];
					Game.AWeaponDur[UnitNum][i][1] = Game.AWeaponDur[UnitNum][i+1][1];
				}
			}
		}
		else if(side == Game.Enemy){
			for(int i=BrIdx; i<5; i++){
				if(i+1 < 4){
					Game.EWeapon[UnitNum][i] = Game.EWeapon[UnitNum][i+1];
					Game.EWeaponDur[UnitNum][i][0] = Game.EWeaponDur[UnitNum][i+1][0];
					Game.EWeaponDur[UnitNum][i][1] = Game.EWeaponDur[UnitNum][i+1][1];
				}
			}
		}
	}
	static void equipWeapon(int side, int UnitNum, int EqIdx){
		//System.out.println("working " + side + ", " + UnitNum + ", " + EqIdx);
		String Equipping = null;
		int EquippingDur1 = -1;
		int EquippingDur2 = -1;
		int skip = 1;
		if(side == Game.Ally){
			Equipping = Game.AWeapon[UnitNum][EqIdx];
			EquippingDur1 = Game.AWeaponDur[UnitNum][EqIdx][0];
			EquippingDur2 = Game.AWeaponDur[UnitNum][EqIdx][1];
			for(int i=EqIdx; i>0; i--){
				/*if(Game.AWeapon[UnitNum][i-skip] == null){
					skip++;
				}
				if(i-skip >= 0){*/
					Game.AWeapon[UnitNum][i] = Game.AWeapon[UnitNum][i-skip];
					Game.AWeaponDur[UnitNum][i][0] = Game.AWeaponDur[UnitNum][i-skip][0];
					Game.AWeaponDur[UnitNum][i][1] = Game.AWeaponDur[UnitNum][i-skip][1];
				//}
			}
			Game.AWeapon[UnitNum][0] = Equipping;
			Game.AWeaponDur[UnitNum][0][0] = EquippingDur1;
			Game.AWeaponDur[UnitNum][0][1] = EquippingDur2;
		}
		else if(side == Game.Enemy){
			Equipping = Game.EWeapon[UnitNum][EqIdx];
			EquippingDur1 = Game.EWeaponDur[UnitNum][EqIdx][0];
			EquippingDur2 = Game.EWeaponDur[UnitNum][EqIdx][1];
			for(int i=EqIdx; i>0; i--){
				if(Game.EWeapon[UnitNum][i-skip] == null){
					skip++;
				}
				Game.EWeapon[UnitNum][i] = Game.EWeapon[UnitNum][i-skip];
				Game.EWeaponDur[UnitNum][i][0] = Game.EWeaponDur[UnitNum][i-skip][0];
				Game.EWeaponDur[UnitNum][i][1] = Game.EWeaponDur[UnitNum][i-skip][1];
			}
			Game.EWeapon[UnitNum][0] = Equipping;
			Game.EWeaponDur[UnitNum][0][0] = EquippingDur1;
			Game.EWeaponDur[UnitNum][0][1] = EquippingDur2;
		}
		CalculatePath.checkAttackRange(side, UnitNum);
	}
	static boolean checkHitCrit(int perct){
		int num = rng(0, 100);
		if(num < perct){
			//System.out.println("" + num);
			return true;
		} else{
			//System.out.println("" + num);
			return false;
		}
		
	}
	
	static void randomizeUnits(){
		for(int i=0; i<MaxUnitNum; i++){
			Game.AUnit[i]=Game.team1Name;
			Game.ALocationX[i] = Game.grid(AStartLocationX[i]);
			Game.ALocationY[i] = Game.grid(AStartLocationY[i]);
			Game.AClassNum[i] = rng(1,11);
			Game.AClass[i] = getClName(Game.AClassNum[i]);
			Game.AAlive[i] = true;
			Game.AWeapon[i][0] = getWeapon(Game.AClass[i], 0);
			Game.AWeapon[i][1] = getWeapon(Game.AClass[i], 1);
			Game.AWeapon[i][2] = getWeapon(Game.AClass[i], 2);
			if(Game.AWeapon[i][2] != null){
				Game.AWeapon[i][3] = getWeapon(Game.AClass[i], 3);
				if(Game.AWeapon[i][3] != null){
					Game.AWeapon[i][4] = getWeapon(Game.AClass[i], 4);
				}
			}
			
			Game.EUnit[i]=Game.team2Name;
			Game.ELocationX[i] = Game.grid(EStartLocationX[i]);
			Game.ELocationY[i] = Game.grid(EStartLocationY[i]);
			Game.EClassNum[i] = rng(1,11);
			Game.EClass[i] = getClName(Game.EClassNum[i]);
			Game.EAlive[i] = true;
			Game.EWeapon[i][0] = getWeapon(Game.EClass[i], 0);
			Game.EWeapon[i][1] = getWeapon(Game.EClass[i], 1);
			Game.EWeapon[i][2] = getWeapon(Game.EClass[i], 2);
			if(Game.EWeapon[i][2] != null){
				Game.EWeapon[i][3] = getWeapon(Game.EClass[i], 3);
				if(Game.EWeapon[i][3] != null){
					Game.EWeapon[i][4] = getWeapon(Game.EClass[i], 4);
				}
			}
		}
	}
	
	static String getClName(int num){
		String cls = null;
		if(num == 1){
			cls = "WyvernLord";
		} else if(num == 2){
			cls = "FalconKnight";
		} else if(num == 3){
			cls = "Paladin";
		} else if(num == 4){
			cls = "Hero";
		} else if(num == 5){
			cls = "Sage";
		} else if(num == 6){
			cls = "Sniper";
		} else if(num == 7){
			cls = "General";
		} else if(num == 8){
			cls = "Druid";
		} else if(num == 9){
			cls = "Bishop";
		} else if(num == 10){
			cls = "Swordmaster";
		} else if(num == 11){
			cls = "Valkyrie";
		} 
		return(cls);
	}
	
	static String getWeapon(String classN, int inx){
		String weapon = null;
		int wType = rng(0,1);
		switch(classN){
			case "WyvernLord":
				if(wType == 0){
					weapon = randAxe();
				} else{
					weapon = randSword();
				} break;
			case "FalconKnight":
				if(wType == 0){
					weapon = randLance();
				} else{
					weapon = randSword();
				} break;
			case "Paladin":
				if(wType == 0){
					weapon = randSword();
				} else{
					weapon = randLance();
				} break;
			case "Hero":
				if(wType == 0){
					weapon = randSword();
				} else{
					weapon = randAxe();
				} break;
			case "Sage":
				weapon = randAnima();
				break;
			case "Sniper":
				weapon = randBow();
				break;
			case "General":
				if(wType == 0){
					weapon = randAxe();
				} else{
					weapon = randLance();
				} break;
			case "Druid":
				weapon = randDark();
				break;
			case "Bishop":
				weapon = randLight();
				break;
			case "Swordmaster":
				weapon = randSword();
				break;
			case "Valkyrie":
				weapon = randAnima();
				break;
			default: break;
		}
		if(inx > 1){
			if(rng(0,1) == 0){
				weapon = null;
			}
		}
		return(weapon);
	}
	
	static String randSword(){
		int idx = rng(0, 9);
		String sword = null;
		if(idx == 0 || idx == 5 || idx == 8){
			sword = "Silver Sword";
		} else if(idx == 1 || idx == 6){
			sword = "Brave Sword";
		} else if(idx == 2 || idx == 7 || idx == 9){
			sword = "Killing Edge";
		} else if(idx == 3){
			sword = "Armorslayer";
		} else if(idx == 4){
			sword = "Wyrmslayer";
		}
		return sword;
	}
	static String randLance(){
		int idx = rng(0,3);
		String lance = null;
		if(idx == 0 || idx == 4 || idx == 8 || idx == 9){
			lance = "Silver Lance";
		} else if(idx == 1 || idx == 5){
			lance = "Brave Lance";
		} else if(idx == 2 || idx == 6 || idx == 7){
			lance = "Killer Lance";
		} else if(idx == 3){
			lance = "Spear";
		}
		return lance;
	}
	static String randAxe(){
		int idx = rng(0,13);
		String axe = null;
		if(idx == 0 || idx == 5 || idx == 10 || idx == 13){
			axe = "Silver Axe";
		} else if(idx == 1 || idx == 6){
			axe = "Brave Axe";
		} else if(idx == 2 || idx == 7 || idx == 11){
			axe = "Killer Axe";
		} else if(idx == 3 || idx == 8 || idx == 12){
			axe = "Tomahawk";
		} else if(idx == 4 || idx == 9){
			axe = "Hammer";
		}
		return axe;
	}
	static String randBow(){
		int idx = rng(0,9);
		String bow = null;
		if(idx == 0 || idx == 4 || idx == 7 || idx == 9){
			bow = "Silver Bow";
		} else if(idx == 1 || idx == 5){
			bow = "Brave Bow";
		} else if(idx == 2 || idx == 6 || idx == 8){
			bow = "Killer Bow";
		} else if(idx == 3){
			bow = "Longbow";
		} 
		return bow;
	}
	static String randAnima(){
		int idx = rng(0,10);
		String anima = null;
		if(idx == 0 || idx == 5 || idx == 9){
			anima = "Thunder";
		} else if(idx == 1 || idx == 6 || idx == 10){
			anima = "Elfire";
		} else if(idx == 2 || idx == 7){
			anima = "Excalibur";
		} else if(idx == 3){
			anima = "Bolting";
		} else if(idx == 4 || idx == 8){
			anima = "Fimbulvetr";
		}
		return anima;
	}
	static String randLight(){
		int idx = rng(0,5);
		String light = null;
		if(idx == 0 || idx == 3 || idx == 5){
			light = "Shine";
		} else if(idx == 1 || idx == 4){
			light = "Divine";
		} else if(idx == 2){
			light = "Purge";
		} 
		return light;
	}
	static String randDark(){
		int idx = rng(0,5);
		String dark = null;
		if(idx == 0 || idx == 3 || idx == 5){
			dark = "Flux";
		} else if(idx == 1 || idx == 4){
			dark = "Luna";
		} else if(idx == 2){
			dark = "Nosferatu";
		} 
		return dark;
	}
}
