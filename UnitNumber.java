//インポート
import gameCanvasUtil.*;

public class UnitNumber{
	public static final int APaladinIdle = 18;
	public static final int APaladinActive = 19;
	public static final int APaladinRun = 20;
	public static final int APaladinDown = 21;
	public static final int APaladinUp = 22;
	
	public static final int EPaladinIdle = 23;
	public static final int EPaladinActive = 24;
	public static final int EPaladinRun = 25;
	public static final int EPaladinDown = 26;
	public static final int EPaladinUp = 27;
	
	public static final int PaladinWait = 28;
	

	public static final int AWyvernLordIdle = 29;
	public static final int AWyvernLordActive = 30;
	public static final int AWyvernLordRun = 31;
	public static final int AWyvernLordDown = 32;
	public static final int AWyvernLordUp = 33;
	
	public static final int EWyvernLordIdle = 34;
	public static final int EWyvernLordActive = 35;
	public static final int EWyvernLordRun = 36;
	public static final int EWyvernLordDown = 37;
	public static final int EWyvernLordUp = 38;
	
	public static final int WyvernLordWait = 39;
	
	public static final int ASageIdle = 40;
	public static final int ASageActive = 41;
	public static final int ASageRun = 42;
	public static final int ASageDown = 43;
	public static final int ASageUp = 44;
	
	public static final int ESageIdle = 45;
	public static final int ESageActive = 46;
	public static final int ESageRun = 47;
	public static final int ESageDown = 48;
	public static final int ESageUp = 49;
	
	public static final int SageWait = 50;
	
	public static final int ASniperIdle = 51;
	public static final int ASniperActive = 52;
	public static final int ASniperRun = 53;
	public static final int ASniperDown = 54;
	public static final int ASniperUp = 55;
	
	public static final int ESniperIdle = 56;
	public static final int ESniperActive = 57;
	public static final int ESniperRun = 58;
	public static final int ESniperDown = 59;
	public static final int ESniperUp = 60;
	
	public static final int SniperWait = 61;
	
	public static final int AHeroIdle = 62;
	public static final int AHeroActive = 63;
	public static final int AHeroRun = 64;
	public static final int AHeroDown = 65;
	public static final int AHeroUp = 66;
	
	public static final int EHeroIdle = 67;
	public static final int EHeroActive = 68;
	public static final int EHeroRun = 69;
	public static final int EHeroDown = 70;
	public static final int EHeroUp = 71;
	
	public static final int HeroWait = 72;
	
	public static final int AGeneralIdle = 79;
	public static final int AGeneralActive = 80;
	public static final int AGeneralRun = 81;
	public static final int AGeneralDown = 82;
	public static final int AGeneralUp = 83;
	
	public static final int EGeneralIdle = 84;
	public static final int EGeneralActive = 85;
	public static final int EGeneralRun = 86;
	public static final int EGeneralDown = 87;
	public static final int EGeneralUp = 88;
	
	public static final int GeneralWait = 89;
	
	public static final int ADruidIdle = 90;
	public static final int ADruidActive = 91;
	public static final int ADruidRun = 92;
	public static final int ADruidDown = 93;
	public static final int ADruidUp = 94;
	
	public static final int EDruidIdle = 95;
	public static final int EDruidActive = 96;
	public static final int EDruidRun = 97;
	public static final int EDruidDown = 98;
	public static final int EDruidUp = 99;
	
	public static final int DruidWait = 100;
	
	public static final int ABishopIdle = 101;
	public static final int ABishopActive = 102;
	public static final int ABishopRun = 103;
	public static final int ABishopDown = 104;
	public static final int ABishopUp = 105;
	
	public static final int EBishopIdle = 106;
	public static final int EBishopActive = 107;
	public static final int EBishopRun = 108;
	public static final int EBishopDown = 109;
	public static final int EBishopUp = 110;
	
	public static final int BishopWait = 111;
	
	public static final int AValkyrieIdle = 112;
	public static final int AValkyrieActive = 113;
	public static final int AValkyrieRun = 114;
	public static final int AValkyrieDown = 115;
	public static final int AValkyrieUp = 116;
	
	public static final int EValkyrieIdle = 117;
	public static final int EValkyrieActive = 118;
	public static final int EValkyrieRun = 119;
	public static final int EValkyrieDown = 120;
	public static final int EValkyrieUp = 121;
	
	public static final int ValkyrieWait = 122;
	
	public static final int ASwordmasterIdle = 123;
	public static final int ASwordmasterActive = 124;
	public static final int ASwordmasterRun = 125;
	public static final int ASwordmasterDown = 126;
	public static final int ASwordmasterUp = 127;
	
	public static final int ESwordmasterIdle = 128;
	public static final int ESwordmasterActive = 129;
	public static final int ESwordmasterRun = 130;
	public static final int ESwordmasterDown = 131;
	public static final int ESwordmasterUp = 132;
	
	public static final int SwordmasterWait = 133;
	
	public static final int AFalconKnightIdle = 134;
	public static final int AFalconKnightActive = 135;
	public static final int AFalconKnightRun = 136;
	public static final int AFalconKnightDown = 137;
	public static final int AFalconKnightUp = 138;
	
	public static final int EFalconKnightIdle = 139;
	public static final int EFalconKnightActive = 140;
	public static final int EFalconKnightRun = 141;
	public static final int EFalconKnightDown = 142;
	public static final int EFalconKnightUp = 143;
	
	public static final int FalconKnightWait = 144;
	
	static int ptCd(int UX, int UY, int UN){
		int PX = 0;
		int PY = 0;
		int PR = 0;
		switch(UN){
			case Game.Paladin: 	
				PX = 918;
				PY = 208;
				break;
			case Game.Sniper:	
				PX = 24;
				PY = 627;
				break;
			case Game.WyvernLord:
				PX = 24;
				PY = 208;
				break;
			case Game.Sage:
				PX = 471;
				PY = 627;
				break;
			case Game.Hero:
				PX = 24;
				PY = 1053;
				break;
			case Game.General:
				PX = 471;
				PY = 1053;
				break;
			case Game.FalconKnight:
				PX = 247;
				PY = 208;
				break;
			case Game.Druid:
				PX = 247;
				PY = 627;
				break;
			case Game.Bishop:
				PX = 695;
				PY = 627;
				break;
			case Game.Swordmaster:
				PX = 247;
				PY = 1053;
				break;
			case Game.Valkyrie:
				PX = 695;
				PY = 208;
				break;
				
		}
		if(UX == 0){
			PR = PY;
		}
		else if(UY == 0){
			PR = PX;
		}
		return(PR);
	}
}
