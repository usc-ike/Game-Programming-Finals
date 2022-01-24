//インポート
import gameCanvasUtil.*;

public class WeaponData{
	
	static int SilverSwordStat[] = new int[]{12, 85, 0, 1, 1, 20, 104, 2};
	static int BraveSwordStat[] = new int[]{9, 80, 0, 1, 1, 30, 205, 2};
	static int KillingEdgeStat[] = new int[]{9, 90, 30, 1, 1, 20, 342, 36};
	static int ArmorslayerStat[] = new int[]{8, 80, 0, 1, 1, 18, 443, 2};
	static int WyrmslayerStat[] = new int[]{8, 80, 0, 1, 1, 20, 478, 2};
	static int RapierStat[] = new int[]{7, 95, 10, 1, 1, 25, 274, 2};
	
	static int SilverLanceStat[] = new int[]{14, 75, 0, 1, 1, 20, 36, 70};
	static int BraveLanceStat[] = new int[]{10, 70, 0, 1, 1, 30, 172, 104};
	static int KillerLanceStat[] = new int[]{10, 80, 30, 1, 1, 20, 138, 70};
	static int SpearStat[] = new int[]{8, 70, 0, 1, 2, 15, 240, 70};
	
	static int SilverAxeStat[] = new int[]{16, 65, 0, 1, 1, 20, 342, 104};
	static int BraveAxeStat[] = new int[]{12, 60, 0, 1, 1, 30, 410, 104};
	static int KillerAxeStat[] = new int[]{12, 70, 30, 1, 1, 20, 444, 104};
	static int TomahawkStat[] = new int[]{10, 60, 0, 1, 2, 15, 104, 138};
	static int HammerStat[] = new int[]{10, 60, 0, 1, 1, 20, 512, 104};
	
	static int SilverBowStat[] = new int[]{14, 75, 0, 2, 2, 20, 444, 138};
	static int BraveBowStat[] = new int[]{10, 70, 0, 2, 2, 30, 2, 172};
	static int KillerBowStat[] = new int[]{10, 80, 30, 2, 2, 20, 512, 138};
	static int LongbowStat[] = new int[]{9, 70, 0, 2, 3, 20, 70, 172};
	
	static int ThunderStat[] = new int[]{10, 70, 10, 1, 2, 35, 410, 172};
	static int ElfireStat[] = new int[]{10, 85, 0, 1, 2, 30, 444, 172};
	static int BoltingStat[] = new int[]{12, 60, 0, 3, 10, 5, 478, 172};
	static int FimbulvetrStat[] = new int[]{13, 80, 0, 1, 2, 20, 512, 172};
	static int ExcaliburStat[] = new int[]{18, 90, 10, 1, 2, 25, 36, 206};
	
	static int ShineStat[] = new int[]{6, 90, 8, 1, 2, 30, 104, 206};
	static int DivineStat[] = new int[]{8, 85, 10, 1, 2, 25, 138, 206};
	static int PurgeStat[] = new int[]{10, 75, 5, 3, 10, 5, 172, 206};
	
	static int FluxStat[] = new int[]{7, 80, 0, 1, 2, 45, 376, 206};
	static int LunaStat[] = new int[]{0, 95, 20, 1, 2, 35, 410, 206};
	static int NosferatuStat[] = new int[]{10, 70, 0, 1, 2, 20, 478, 206};
	
	static int MendStat[] = new int[]{0, 100, 0, 1, 1, 20, 342, 240};
	static int PhysicStat[] = new int[]{0, 100, 0, 1, 99, 15, 410, 240};
	
	static String SilverSword[] = new String[]{"Silver Sword", "銀の剣", "Sword", "Physical", "NA", "NA", "NA"};
	static String BraveSword[] = new String[]{"Brave Sword", "勇者の剣", "Sword", "Physical", "NA", "NA", "NA"};
	static String KillingEdge[] = new String[]{"Killing Edge", "キルソード", "Sword", "Physical", "NA", "NA", "NA"};
	static String Armorslayer[] = new String[]{"Armorslayer", "アーマーキラー", "Sword", "Physical", "Armor", "NA", "NA"};
	static String Wyrmslayer[] = new String[]{"Wyrmslayer", "ドラゴンキラー", "Sword", "Physical", "Dragon", "NA", "NA"};
	static String Rapier[] = new String[]{"Rapier", "レイピア", "Sword", "Physical", "Armor", "Mounted", "Exclusive"};
	
	static String SilverLance[] = new String[]{"Silver Lance", "銀の槍", "Lance", "Physical", "NA", "NA", "NA"};
	static String BraveLance[] = new String[]{"Brave Lance", "勇者の槍", "Lance", "Physical", "NA", "NA", "NA"};
	static String KillerLance[] = new String[]{"Killer Lance", "キラーランス", "Lance", "Physical", "NA", "NA", "NA"};
	static String Spear[] = new String[]{"Spear", "スレンドスピア", "Lance", "Physical", "NA", "NA", "NA"};
	
	static String SilverAxe[] = new String[]{"Silver Axe", "銀の斧", "Axe", "Physical", "NA", "NA", "NA"};
	static String BraveAxe[] = new String[]{"Brave Axe", "勇者の斧", "Axe", "Physical", "NA", "NA", "NA"};
	static String KillerAxe[] = new String[]{"Killer Axe", "キラーアクス", "Axe", "Physical", "NA", "NA", "NA"};
	static String Tomahawk[] = new String[]{"Tomahawk", "トマホーク", "Axe", "Physical", "NA", "NA", "NA"};
	static String Hammer[] = new String[]{"Hammer", "ハンマー", "Axe", "Physical", "Armor", "NA", "NA"};
	
	static String SilverBow[] = new String[]{"Silver Bow", "銀の弓", "Bow", "Physical", "Flying", "NA", "NA"};
	static String BraveBow[] = new String[]{"Brave Bow", "勇者の弓", "Bow", "Physical", "Flying", "NA", "NA"};
	static String KillerBow[] = new String[]{"Killer Bow", "キラーボウ", "Bow", "Physical", "Flying", "NA", "NA"};
	static String Longbow[] = new String[]{"Longbow", "ロングボウ", "Bow", "Physical", "Flying", "NA", "Exclusive"};
	
	static String Thunder[] = new String[]{"Thunder", "サンダー", "Anima", "Magical", "NA", "NA", "NA"};
	static String Elfire[] = new String[]{"Elfire", "エルファイアー", "Anima", "Magical", "NA", "NA", "NA"};
	static String Bolting[] = new String[]{"Bolting", "サンダーストーム", "Anima", "Magical", "NA", "NA", "NA"};
	static String Fimbulvetr[] = new String[]{"Fimbulvetr", "フィンブル", "Anima", "Magical", "NA", "NA", "NA"};
	static String Excalibur[] = new String[]{"Excalibur", "エクスカリバー", "Anima", "Magical", "NA", "NA", "NA"};
	
	static String Shine[] = new String[]{"Shine", "シャイン", "Light", "Magical", "NA", "NA", "NA"};
	static String Divine[] = new String[]{"Divine", "ディヴァイン", "Light", "Magical", "NA", "NA", "NA"};
	static String Purge[] = new String[]{"Purge", "パージ", "Light", "Magical", "NA", "NA", "NA"};
	
	static String Flux[] = new String[]{"Flux", "ミィル", "Dark", "Magical", "NA", "NA", "NA"};
	static String Luna[] = new String[]{"Luna", "ルナ", "Dark", "Magical", "NA", "NA", "NA"};
	static String Nosferatu[] = new String[]{"Nosferatu", "リザイア", "Dark", "Magical", "NA", "NA", "NA"};
	
	static String Mend[] = new String[]{"Mend", "リカバー", "Staff", "Special", "NA", "NA", "NA", "NA"};
	static String Physic[] = new String[]{"Physic", "リブロー", "Staff", "Special", "NA", "NA", "NA", "NA"};
	
	static void setWeaponData(int side, int index){
		if(side == Game.Ally){
			for(int i=0; i<5; i++){
				if(Game.AWeapon[index][i] != null){
					Game.AWeaponDur[index][i][1] = rWeaponDat(Game.AWeapon[index][i], 5);
					Game.AWeaponDur[index][i][0] = Game.AWeaponDur[index][i][1];
				}
			}
		}
		else if(side == Game.Enemy){
			for(int i=0; i<5; i++){
				if(Game.EWeapon[index][i] != null){
					Game.EWeaponDur[index][i][1] = rWeaponDat(Game.EWeapon[index][i], 5);
					Game.EWeaponDur[index][i][0] = Game.EWeaponDur[index][i][1];
				}
			}
		}
	}
	
	static String rWeaponInfo(String wName, int index){ //0: name, 1: japanese name, 2: weapon type, 3: stat dependency, 4: bonus type1, 5: bonus type2, 6: exclusivity
		String word = "";
		switch(wName){
			case "Silver Sword":
				word = SilverSword[index];
				break;
			case "Brave Sword":
				word = BraveSword[index];
				break;
			case "Killing Edge":
				word = KillingEdge[index];
				break;
			case "Armorslayer":
				word = Armorslayer[index];
				break;
			case "Wyrmslayer":
				word = Wyrmslayer[index];
				break;
			case "Rapier":
				word = Rapier[index];
				break;
			case "Silver Lance":
				word = SilverLance[index];
				break;
			case "Brave Lance":
				word = BraveLance[index];
				break;
			case "Killer Lance":
				word = KillerLance[index];
				break;
			case "Spear":
				word = Spear[index];
				break;
			case "Silver Axe":
				word = SilverAxe[index];
				break;
			case "Brave Axe":
				word = BraveAxe[index];
				break;
			case "Killer Axe":
				word = KillerAxe[index];
				break;
			case "Tomahawk":
				word = Tomahawk[index];
				break;
			case "Hammer":
				word = Hammer[index];
				break;
			case "Silver Bow":
				word = SilverBow[index];
				break;
			case "Brave Bow":
				word = BraveBow[index];
				break;
			case "Killer Bow":
				word = KillerBow[index];
				break;
			case "Longbow":
				word = Longbow[index];
				break;
			case "Thunder":
				word = Thunder[index];
				break;
			case "Elfire":
				word = Elfire[index];
				break;
			case "Bolting":
				word = Bolting[index];
				break;
			case "Fimbulvetr":
				word = Fimbulvetr[index];
				break;
			case "Excalibur":
				word = Excalibur[index];
				break;
			case "Shine":
				word = Shine[index];
				break;
			case "Divine":
				word = Divine[index];
				break;
			case "Purge":
				word = Purge[index];
				break;
			case "Flux":
				word = Flux[index];
				break;
			case "Luna":
				word = Luna[index];
				break;
			case "Nosferatu":
				word = Nosferatu[index];
				break;
			case "Mend":
				word = Mend[index];
				break;
			case "Physic":
				word = Physic[index];
				break;
			default: 
				break;
		}
		return word;
	}
	
	static int rWeaponDat(String wName, int index){ //0: might, 1: accuracy, 2: critical, 3: range min, 4: range max, 5: durability, 6: Icon X, 7: Icon Y
		int num = 0;
		switch(wName){
			case "Silver Sword":
				num = SilverSwordStat[index];
				break;
			case "Brave Sword":
				num = BraveSwordStat[index];
				break;
			case "Killing Edge":
				num = KillingEdgeStat[index];
				break;
			case "Armorslayer":
				num = ArmorslayerStat[index];
				break;
			case "Wyrmslayer":
				num = WyrmslayerStat[index];
				break;
			case "Rapier":
				num = RapierStat[index];
				break;
			case "Silver Lance":
				num = SilverLanceStat[index];
				break;
			case "Brave Lance":
				num = BraveLanceStat[index];
				break;
			case "Killer Lance":
				num = KillerLanceStat[index];
				break;
			case "Spear":
				num = SpearStat[index];
				break;
			case "Silver Axe":
				num = SilverAxeStat[index];
				break;
			case "Brave Axe":
				num = BraveAxeStat[index];
				break;
			case "Killer Axe":
				num = KillerAxeStat[index];
				break;
			case "Tomahawk":
				num = TomahawkStat[index];
				break;
			case "Hammer":
				num = HammerStat[index];
				break;
			case "Silver Bow":
				num = SilverBowStat[index];
				break;
			case "Brave Bow":
				num = BraveBowStat[index];
				break;
			case "Killer Bow":
				num = KillerBowStat[index];
				break;
			case "Longbow":
				num = LongbowStat[index];
				break;
			case "Thunder":
				num = ThunderStat[index];
				break;
			case "Elfire":
				num = ElfireStat[index];
				break;
			case "Bolting":
				num = BoltingStat[index];
				break;
			case "Fimbulvetr":
				num = FimbulvetrStat[index];
				break;
			case "Excalibur":
				num = ExcaliburStat[index];
				break;
			case "Shine":
				num = ShineStat[index];
				break;
			case "Divine":
				num = DivineStat[index];
				break;
			case "Purge":
				num = PurgeStat[index];
				break;
			case "Flux":
				num = FluxStat[index];
				break;
			case "Luna":
				num = LunaStat[index];
				break;
			case "Nosferatu":
				num = NosferatuStat[index];
				break;
			case "Mend":
				num = MendStat[index];
				break;
			case "Physic":
				num = PhysicStat[index];
				break;
			default: 
				break;
		}
		return num;
	}
}
