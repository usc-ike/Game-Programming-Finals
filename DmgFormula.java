//インポート
import gameCanvasUtil.*;

import java.util.Arrays;
// Game.AStats[Unit Index][x] //0:Str  1:Mag  2:Skill  3:Spd 
							  //4:Luck  5:Def  6:Res  7:Mvmt
// WeaponData.rWeaponInfo(String wName, int index) //0: name, 1: japanese name, 2: weapon type, 3: stat dependency, 4: bonus type1, 5: bonus type2, 6: exclusivity
//WeaponData.rWeaponDat(String wName, int index) //0: might, 1: accuracy, 2: critical, 3: range min, 4: range max, 5: durability

public class DmgFormula{
	static String Armored[] = new String[]{"Great Knight", "General"};
	static String Mounted[] = new String[]{"Paladin", "Great Knight", "Falcon Knight", "Valkyrie", "Nomad Trooper", "Mage Knight"};
	static String Flying[] = new String[]{"Falcon Knight", "Wyvern Lord", "Wyvern Knight"};
	static String Dragon[] = new String[]{"Wyvern Lord", "Wyvern Knight"};
	
	static int hitRate(int side, int UIdx, String aWep){//Display
		//Hit Rate = Weapon Accuracy + Skill x 2 + Luck
		int HitRate = 0;
		if(aWep == "---" || aWep == null){
			HitRate = -1;
		} else{
			if(side == Game.Ally){
				HitRate = WeaponData.rWeaponDat(aWep, 1) + Game.AStats[UIdx][2]*2 + Game.AStats[UIdx][4];
			} else if(side == Game.Enemy){
				HitRate = WeaponData.rWeaponDat(aWep, 1) + Game.EStats[UIdx][2]*2 + Game.EStats[UIdx][4];
			}
		}
		return HitRate;
	}
	static int evadeRate(int side, int UIdx){//Display
		//Evade = Attack Speed x 2 + Luck + Terrain Bonus
		int EvadeRate = 0;
		if(side == Game.Ally){
			//System.out.println(Game.square(Game.ALocationX[UIdx]) + ", " + Game.square(Game.ALocationY[UIdx]));
			EvadeRate = Game.AStats[UIdx][3] * 2 + Game.AStats[UIdx][4] + MapData.getTerrainBonus(Game.tile_type[Game.square(Game.ALocationX[UIdx])][Game.square(Game.ALocationY[UIdx])], 1);
		} else if(side == Game.Enemy){
			EvadeRate = Game.EStats[UIdx][3] * 2 + Game.EStats[UIdx][4] + MapData.getTerrainBonus(Game.tile_type[Game.square(Game.ELocationX[UIdx])][Game.square(Game.ELocationY[UIdx])], 1);
		}
		return EvadeRate;
	}
	
	static int pAttack(int aStr, String aWep, String dWep, String dClass){//Display
		//Physical Attack = Strength + (Weapon Might + Weapon Triangle Bonus) X Weapon effectiveness (x2)
		// +/- 1 Might, +/- 10 Hit%
		int PhyAtk = 0;
		if(WeaponData.rWeaponInfo(aWep, 2) == "Staff" || WeaponData.rWeaponInfo(aWep, 2) == "Item" || aWep == "---" || aWep == null){
			PhyAtk = -1;
		} else if(dWep == "---" || dWep == null){
			PhyAtk = aStr + (WeaponData.rWeaponDat(aWep, 0)) * wepEffect(aWep, dClass);
		} else{
			PhyAtk = aStr + (WeaponData.rWeaponDat(aWep, 0) + wepTriangle(aWep, dWep, 0)) * wepEffect(aWep, dClass);
		}
		return PhyAtk;
	}
	static int mAttack(int aMag, String aWep, String dWep, String dClass){//Display
		//Magical Attack = magic + (Magic Might + Trinity of Magic Bonus) X Magic Effectiveness (x2)
		// +/- 1 Might, +/- 10 Hit%
		int MagAtk = 0;
		if(WeaponData.rWeaponInfo(aWep, 2) == "Staff" || WeaponData.rWeaponInfo(aWep, 2) == "Item" || aWep == "---" || aWep == null){
			MagAtk = -1;
		} else if(dWep == "---" || dWep == null){
			MagAtk = aMag + (WeaponData.rWeaponDat(aWep, 0)) * wepEffect(aWep, dClass);
		} else{
			MagAtk = aMag + (WeaponData.rWeaponDat(aWep, 0) + wepTriangle(aWep, dWep, 0)) * wepEffect(aWep, dClass);
		}
		return MagAtk;
	}
	static int defense(int side, int UIdx){
		//Terrain Bonus + Defense
		int Def = 0;
		if(side == Game.Ally){
			Def = MapData.getTerrainBonus(Game.tile_type[Game.square(Game.ALocationX[UIdx])][Game.square(Game.ALocationY[UIdx])], 0) + Game.AStats[UIdx][5];
			//System.out.println("Terrain: " + MapData.getTerrainBonus(Game.tile_type[Game.square(Game.ALocationX[UIdx])][Game.square(Game.ALocationY[UIdx])], 0) + ", " + Game.AStats[UIdx][5] + ", " + Def);
		} else if(side == Game.Enemy){
			Def = MapData.getTerrainBonus(Game.tile_type[Game.square(Game.ELocationX[UIdx])][Game.square(Game.ELocationY[UIdx])], 0) + Game.EStats[UIdx][5];
		}
		return Def;
	}
	static int mdefense(int side, int UIdx){
		//DP = Terrain Bonus + Resistance
		int Res = 0;
		if(side == Game.Ally){
			Res = MapData.getTerrainBonus(Game.tile_type[Game.square(Game.ALocationX[UIdx])][Game.square(Game.ALocationY[UIdx])], 0) + Game.AStats[UIdx][6];
		} else if(side == Game.Enemy){
			Res = MapData.getTerrainBonus(Game.tile_type[Game.square(Game.ELocationX[UIdx])][Game.square(Game.ELocationY[UIdx])], 0) + Game.EStats[UIdx][6];
		}
		return Res;
	}
	
	static int critRate(int side, int UIdx, String aWep){//Display
		//Critical Rate = Weapon Critical + Skill / 2 + Class Critical (Swordmasters, Berserkers, and Snipers +15%)
		int CritRate = 0;
		if(aWep == "---" || aWep == null){
			CritRate = -1;
		} else{
			if(side == Game.Ally){
				CritRate = WeaponData.rWeaponDat(aWep, 2) + (Game.AStats[UIdx][2]/2) + classCrit(Game.AClass[UIdx]);
			} else if(side == Game.Ally){
				CritRate = WeaponData.rWeaponDat(aWep, 2) + (Game.EStats[UIdx][2]/2) + classCrit(Game.EClass[UIdx]);
			}
		}
		return CritRate;
	}
	static int critEvade(){
		//Critical Evade = Luck
		return 0;
	}
	
	/**Battle Phase**/
	static int damage(int PhyAtk, int Def){
		int output = 0;
		//Damage = Attack Power (attacker) - Defense Power (defender)
		if(PhyAtk - Def <= 0){
			output = 0;
		} else{
			output = PhyAtk - Def;
		}
		return (output);
	}
	static int accuracy(int hRate, int eRate, String aWep, String dWep){
		//Accuracy = Hit Rate (Attacker) - Evade (Defender) + Triangle Bonus*
		// +/- 1 Might, +/- 10 Hit%
		int Accuracy = 0;
		Accuracy = hRate - eRate + wepTriangle(aWep, dWep, 1);
		return Accuracy;
	}
	static int critChance(int CritRate, int dLuck){
		//Critical = Critical Rate - Critical Evade
		return(CritRate-dLuck);
	}
	
	/** Weapon Triangle **/
	static int wepTriangle(String aWep, String dWep, int type){ //0: Might 1: Hit%
		int retVal = 0;
		int mgtBonus = 0;
		int accBonus = 0;
		if(WeaponData.rWeaponInfo(aWep, 2) == "Sword" && WeaponData.rWeaponInfo(dWep, 2) == "Axe" 
				|| WeaponData.rWeaponInfo(aWep, 2) == "Axe" && WeaponData.rWeaponInfo(dWep, 2) == "Lance" 
				|| WeaponData.rWeaponInfo(aWep, 2) == "Lance" && WeaponData.rWeaponInfo(dWep, 2) == "Sword"){
			mgtBonus = 1;
			accBonus = 10;
		} else if(WeaponData.rWeaponInfo(aWep, 2) == "Sword" && WeaponData.rWeaponInfo(dWep, 2) == "Lance" 
				|| WeaponData.rWeaponInfo(aWep, 2) == "Lance" && WeaponData.rWeaponInfo(dWep, 2) == "Axe" 
				|| WeaponData.rWeaponInfo(aWep, 2) == "Axe" && WeaponData.rWeaponInfo(dWep, 2) == "Sword"){
			mgtBonus = -1;
			accBonus = -10;
		} else if(WeaponData.rWeaponInfo(aWep, 2) == "Anima" && WeaponData.rWeaponInfo(dWep, 2) == "Light" 
				|| WeaponData.rWeaponInfo(aWep, 2) == "Light" && WeaponData.rWeaponInfo(dWep, 2) == "Dark" 
				|| WeaponData.rWeaponInfo(aWep, 2) == "Dark" && WeaponData.rWeaponInfo(dWep, 2) == "Anima"){
			mgtBonus = 1;
			accBonus = 10;
		} else if(WeaponData.rWeaponInfo(aWep, 2) == "Anima" && WeaponData.rWeaponInfo(dWep, 2) == "Dark" 
				|| WeaponData.rWeaponInfo(aWep, 2) == "Light" && WeaponData.rWeaponInfo(dWep, 2) == "Anima" 
				|| WeaponData.rWeaponInfo(aWep, 2) == "Dark" && WeaponData.rWeaponInfo(dWep, 2) == "Light"){
			mgtBonus = -1;
			accBonus = -10;
		}
		if(type == 0){
			retVal = mgtBonus;
		} else if(type == 1){
			retVal = accBonus;
		}
		return retVal;
	}
	
	static int wepEffect(String aWep, String dClass){
		int dMult = 1;
		if((WeaponData.rWeaponInfo(aWep, 4) == "Armored" || WeaponData.rWeaponInfo(aWep, 5) == "Armored") && Arrays.asList(Armored).contains(dClass)){
			dMult = 2;
		} else if((WeaponData.rWeaponInfo(aWep, 4) == "Mounted" || WeaponData.rWeaponInfo(aWep, 5) == "Mounted") && Arrays.asList(Mounted).contains(dClass)){
			dMult = 2;
		} else if((WeaponData.rWeaponInfo(aWep, 4) == "Flying" || WeaponData.rWeaponInfo(aWep, 5) == "Flying") && Arrays.asList(Flying).contains(dClass)){
			dMult = 2; System.out.println("found");
		} else if((WeaponData.rWeaponInfo(aWep, 4) == "Dragon" || WeaponData.rWeaponInfo(aWep, 5) == "Dragon") && Arrays.asList(Dragon).contains(dClass)){
			dMult = 2;
		} else{
			dMult = 1;
		}
		return dMult;
	}
	static int classCrit(String aClass){
		int ClassCrit = 0;
		if(aClass == "Swordmaster" || aClass == "Berserker" || aClass == "Sniper"){
			ClassCrit = 15;
		}
		return ClassCrit;
	}
	
}
