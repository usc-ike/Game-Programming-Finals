//インポート
import gameCanvasUtil.*;

public class MapData{
	static void InsertData(){
		if(Game.Map == 4){
			UnitStats.MaxUnitNum = 7;
			UnitStats.AStartLocationX[0] = 0; //{0, 0, 1, 1, 0, 2, 2};
			UnitStats.AStartLocationX[1] = 0;
			UnitStats.AStartLocationX[2] = 1;
			UnitStats.AStartLocationX[3] = 1;
			UnitStats.AStartLocationX[4] = 0;
			UnitStats.AStartLocationX[5] = 2;
			UnitStats.AStartLocationX[6] = 2;
			UnitStats.AStartLocationY[0] = 21; //{21, 23, 22, 24, 25, 23, 25};
			UnitStats.AStartLocationY[1] = 23;
			UnitStats.AStartLocationY[2] = 22;
			UnitStats.AStartLocationY[3] = 24;
			UnitStats.AStartLocationY[4] = 25;
			UnitStats.AStartLocationY[5] = 23;
			UnitStats.AStartLocationY[6] = 25;
			UnitStats.EStartLocationX[0] = 8; //{8, 10, 1, 8, 14, 13, 12};
			UnitStats.EStartLocationX[1] = 10;
			UnitStats.EStartLocationX[2] = 9;
			UnitStats.EStartLocationX[3] = 8;
			UnitStats.EStartLocationX[4] = 14;
			UnitStats.EStartLocationX[5] = 13;
			UnitStats.EStartLocationX[6] = 12;
			UnitStats.EStartLocationY[0] = 0; //{0, 0, 9, 2, 3, 4, 3};
			UnitStats.EStartLocationY[1] = 0;
			UnitStats.EStartLocationY[2] = 1;
			UnitStats.EStartLocationY[3] = 2;
			UnitStats.EStartLocationY[4] = 3;
			UnitStats.EStartLocationY[5] = 4;
			UnitStats.EStartLocationY[6] = 3;
			
			Game.MaxShiftX = 3;
			Game.MaxShiftY = 13;
			for(int i=0; i<Game.GridMax_X+1; i++){
				for(int j=0; j<Game.GridMax_Y+1; j++){
					Game.tile_type[i][j] = "Flat";
				}
			}
			for(int i=0; i<7; i++){
				if(i != 0){
					Game.tile_type[i][0] = "Cliff";
				}
				if(i != 4){
					Game.tile_type[i][1] = "Cliff";
				}
				if(i != 4 && i != 5 && i != 6){
					Game.tile_type[i][2] = "Cliff";
				}
				Game.tile_type[i][3] = "Cliff";
				Game.tile_type[i][4] = "Cliff";
				if(i != 6){
					Game.tile_type[i][5] = "Cliff";
				}
				Game.tile_type[i][6] = "Cliff";
			}
			Game.tile_type[13][0] = "Cliff";
			Game.tile_type[14][0] = "Cliff";
			for(int i=15; i<23; i++){
				Game.tile_type[i][0] = "Valley";
				if(i != 15){
					Game.tile_type[i][1] = "Valley";
					Game.tile_type[i][2] = "Valley";
				}
			}
			for(int i=11; i<16; i++){
				if(i != 14){
					Game.tile_type[i][1] = "Cliff";
				}
				if(i != 14 && i != 15){
					Game.tile_type[i][2] = "Cliff";
				}
			}
			Game.tile_type[7][3] = "Cliff";
			Game.tile_type[7][4] = "Cliff";
			Game.tile_type[7][5] = "Cliff";
			Game.tile_type[8][3] = "Cliff";
			Game.tile_type[10][2] = "Cliff";
			Game.tile_type[10][3] = "Cliff";
			Game.tile_type[16][3] = "Cliff";
			Game.tile_type[18][3] = "Cliff";
			Game.tile_type[20][3] = "Cliff";
			Game.tile_type[21][3] = "Cliff";
			Game.tile_type[19][4] = "Cliff";
			Game.tile_type[5][6] = "Valley";
			Game.tile_type[10][6] = "Cliff";
			Game.tile_type[11][6] = "Cliff";
			Game.tile_type[14][6] = "Cliff";
			Game.tile_type[15][6] = "Cliff";
			Game.tile_type[20][6] = "Cliff";
			for(int i=0; i<6; i++){
				if(i != 2 && i != 3){
					Game.tile_type[i][7] = "Valley";
				}
				if(i != 5){
					Game.tile_type[i][8] = "Valley";
					Game.tile_type[i][9] = "Valley";
				}
				Game.tile_type[i][10] = "Valley";
				Game.tile_type[i][11] = "Valley";
				Game.tile_type[i][12] = "Valley";
				Game.tile_type[i][13] = "Valley";
				Game.tile_type[i][14] = "Valley";
				Game.tile_type[i][15] = "Valley";
				if(i != 0){
					Game.tile_type[i][16] = "Valley";
				}
			}
			Game.tile_type[6][7] = "Cliff";
			Game.tile_type[9][7] = "Cliff";
			for(int i=10; i<16; i++){
				if(i != 12 && i != 13){
					Game.tile_type[i][7] = "Valley";
				}
				Game.tile_type[i][8] = "Valley";
				Game.tile_type[i][9] = "Valley";
				Game.tile_type[i][10] = "Valley";
				Game.tile_type[i][11] = "Valley";
			}
			Game.tile_type[12][7] = "Cliff";
			Game.tile_type[13][7] = "Cliff";
			Game.tile_type[16][7] = "Cliff";
			Game.tile_type[17][7] = "Cliff";
			Game.tile_type[21][7] = "Cliff";
			Game.tile_type[22][7] = "Cliff";
			Game.tile_type[5][8] = "Cliff";
			Game.tile_type[9][8] = "Cliff";
			Game.tile_type[16][8] = "Valley";
			Game.tile_type[17][8] = "Valley";
			Game.tile_type[5][9] = "Cliff";
			Game.tile_type[9][9] = "Cliff";
			Game.tile_type[16][9] = "Valley";
			Game.tile_type[17][9] = "Cliff";
			Game.tile_type[20][9] = "Cliff";
			Game.tile_type[21][9] = "Cliff";
			Game.tile_type[9][10] = "Cliff";
			Game.tile_type[16][10] = "Valley";
			for(int i=20; i<23; i++){
				if(i != 22){
					Game.tile_type[i][10] = "Valley";
				}
				Game.tile_type[i][11] = "Valley";
				Game.tile_type[i][12] = "Valley";
				Game.tile_type[i][13] = "Valley";
			}
			Game.tile_type[22][10] = "Cliff";
			Game.tile_type[6][11] = "Cliff";
			Game.tile_type[7][11] = "Cliff";
			Game.tile_type[16][11] = "Cliff";
			Game.tile_type[19][11] = "Cliff";
			Game.tile_type[6][12] = "Valley";
			Game.tile_type[7][12] = "Valley";
			Game.tile_type[8][12] = "Cliff";
			Game.tile_type[10][12] = "Cliff";
			Game.tile_type[11][12] = "Valley";
			Game.tile_type[12][12] = "Valley";
			Game.tile_type[13][12] = "Cliff";
			Game.tile_type[14][12] = "Cliff";
			Game.tile_type[15][12] = "Cliff";
			Game.tile_type[19][12] = "Valley";
			Game.tile_type[6][13] = "Cliff";
			Game.tile_type[8][13] = "Cliff";
			Game.tile_type[11][13] = "Cliff";
			Game.tile_type[12][13] = "Cliff";
			Game.tile_type[19][13] = "Cliff";
			Game.tile_type[6][14] = "Cliff";
			Game.tile_type[9][14] = "Cliff";
			Game.tile_type[16][14] = "Cliff";
			Game.tile_type[17][14] = "Cliff";
			Game.tile_type[21][14] = "Cliff";
			Game.tile_type[22][14] = "Valley";
			Game.tile_type[8][15] = "Cliff";
			Game.tile_type[9][15] = "Cliff";
			Game.tile_type[15][15] = "Cliff";
			for(int i=16; i<21; i++){
				if(i != 18 && i != 19 && i != 20){
					Game.tile_type[i][15] = "Valley";
					Game.tile_type[i][16] = "Valley";
				}
				if(i != 19 && i != 20){
					Game.tile_type[i][17] = "Valley";
				}
				Game.tile_type[i][18] = "Valley";
				Game.tile_type[i][19] = "Valley";
				Game.tile_type[i][20] = "Valley";
				Game.tile_type[i][21] = "Valley";
			}
			Game.tile_type[18][15] = "Cliff";
			Game.tile_type[22][15] = "Cliff";
			Game.tile_type[0][16] = "Cliff";
			Game.tile_type[6][16] = "Cliff";
			Game.tile_type[7][16] = "Cliff";
			Game.tile_type[8][16] = "Cliff";
			Game.tile_type[15][16] = "Cliff";
			Game.tile_type[18][16] = "Cliff";
			for(int i=0; i<6; i++){
				Game.tile_type[i][17] = "Cliff";
				Game.tile_type[i][18] = "Cliff";
				Game.tile_type[i][19] = "Cliff";
				if(i != 0){
					Game.tile_type[i][20] = "Cliff";
				}
			}
			Game.tile_type[6][17] = "Cliff";
			Game.tile_type[7][17] = "Cliff";
			Game.tile_type[11][17] = "Cliff";
			Game.tile_type[12][17] = "Cliff";
			Game.tile_type[15][17] = "Cliff";
			Game.tile_type[19][17] = "Cliff";
			Game.tile_type[20][17] = "Cliff";
			Game.tile_type[10][18] = "Cliff";
			Game.tile_type[13][18] = "Cliff";
			Game.tile_type[15][18] = "Cliff";
			Game.tile_type[21][18] = "Cliff";
			Game.tile_type[10][19] = "Cliff";
			Game.tile_type[11][19] = "Cliff";
			Game.tile_type[12][19] = "Cliff";
			Game.tile_type[16][19] = "Cliff";
			Game.tile_type[21][19] = "Cliff";
			Game.tile_type[10][20] = "Cliff";
			Game.tile_type[11][20] = "Cliff";
			Game.tile_type[12][20] = "Valley";
			Game.tile_type[13][20] = "Cliff";
			Game.tile_type[16][20] = "Cliff";
			Game.tile_type[20][20] = "Cliff";
			Game.tile_type[3][21] = "Cliff";
			Game.tile_type[4][21] = "Cliff";
			for(int j=21; j<28; j++){
				if(j != 21 && j != 22 && j != 23){
					Game.tile_type[4][j] = "Cliff";
					Game.tile_type[5][j] = "Cliff";
					Game.tile_type[6][j] = "Cliff";
				}
				if(j != 21 && j!= 22){
					Game.tile_type[7][j] = "Cliff";
				}
				if(j != 21){
					Game.tile_type[8][j] = "Cliff";
				}
				Game.tile_type[9][j] = "Cliff";
				Game.tile_type[10][j] = "Cliff";
				Game.tile_type[11][j] = "Valley";
				Game.tile_type[12][j] = "Valley";
				if(j != 23 && j != 27){
					Game.tile_type[13][j] = "Cliff";
				}
			}
			Game.tile_type[16][21] = "Cliff";
			Game.tile_type[20][21] = "Cliff";
			Game.tile_type[17][22] = "Cliff";
			Game.tile_type[20][22] = "Cliff";
			Game.tile_type[22][23] = "Cliff";
			for(int i=14; i<17; i++){
				if(i != 15 && i != 16){
					Game.tile_type[i][24] = "Cliff";
				}
				Game.tile_type[i][25] = "Cliff";
				Game.tile_type[i][26] = "Cliff";
				Game.tile_type[i][27] = "Cliff";
			}
			Game.tile_type[21][24] = "Cliff";
			Game.tile_type[21][25] = "Cliff";
			Game.tile_type[3][26] = "Cliff";
			Game.tile_type[21][26] = "Cliff";
			Game.tile_type[22][26] = "Cliff";
			Game.tile_type[2][27] = "Cliff";
			Game.tile_type[3][27] = "Cliff";
			Game.tile_type[17][27] = "Cliff";
			Game.tile_type[18][27] = "Cliff";
			Game.tile_type[19][27] = "Cliff";
			Game.tile_type[22][27] = "Cliff";
			Game.tile_type[10][24] = "Valley";
			Game.tile_type[10][25] = "Valley";
			Game.tile_type[8][27] = "Valley";
			for(int i=9; i<11; i++){
				Game.tile_type[i][26] = "Valley";
				Game.tile_type[i][27] = "Valley";
			}
		}// finished map 4
		else if(Game.Map == 5){
			
			UnitStats.MaxUnitNum = 10;
			
			UnitStats.AStartLocationX[0] = 0; 
			UnitStats.AStartLocationY[0] = 26;
			
			UnitStats.AStartLocationX[1] = 1;
			UnitStats.AStartLocationY[1] = 25;
			
			UnitStats.AStartLocationX[2] = 0;
			UnitStats.AStartLocationY[2] = 24;
			
			UnitStats.AStartLocationX[3] = 2;
			UnitStats.AStartLocationY[3] = 24;
			
			UnitStats.AStartLocationX[4] = 2;
			UnitStats.AStartLocationY[4] = 26;
			
			UnitStats.AStartLocationX[5] = 3;
			UnitStats.AStartLocationY[5] = 25;
			
			UnitStats.AStartLocationX[6] = 4;			
			UnitStats.AStartLocationY[6] = 26;
			
			UnitStats.AStartLocationX[7] = 17;			
			UnitStats.AStartLocationY[7] = 18;
			
			UnitStats.AStartLocationX[8] = 18;			
			UnitStats.AStartLocationY[8] = 17;
			
			UnitStats.AStartLocationX[9] = 19;			
			UnitStats.AStartLocationY[9] = 18;
			
			
			UnitStats.EStartLocationX[0] = 10; 
			UnitStats.EStartLocationY[0] = 2; 
			
			UnitStats.EStartLocationX[1] = 9;
			UnitStats.EStartLocationY[1] = 3;
			
			UnitStats.EStartLocationX[2] = 11;
			UnitStats.EStartLocationY[2] = 3;
			
			UnitStats.EStartLocationX[3] = 9;
			UnitStats.EStartLocationY[3] = 7;
			
			UnitStats.EStartLocationX[4] = 10;
			UnitStats.EStartLocationY[4] = 7;
			
			UnitStats.EStartLocationX[5] = 11;
			UnitStats.EStartLocationY[5] = 7;
			
			UnitStats.EStartLocationX[6] = 10;
			UnitStats.EStartLocationY[6] = 4;
			
			UnitStats.EStartLocationX[7] = 2;
			UnitStats.EStartLocationY[7] = 12;
			
			UnitStats.EStartLocationX[8] = 3;
			UnitStats.EStartLocationY[8] = 12;
			
			UnitStats.EStartLocationX[9] = 4;
			UnitStats.EStartLocationY[9] = 12;
			
			
			Game.MaxShiftX = 1;
			Game.MaxShiftY = 12;
			for(int i=0; i<Game.GridMax_X+1; i++){
				for(int j=0; j<Game.GridMax_Y+1; j++){
					Game.tile_type[i][j] = "Plain";
				}
			}
			Game.tile_type[0][1] = "Forest";
			for(int j=14; j<21; j++){
				Game.tile_type[0][1] = "Peak";
			}
			for(int j=21; j<24; j++){
				Game.tile_type[0][j] = "--";
				Game.tile_type[1][j] = "--";
				Game.tile_type[2][j] = "--";
			}
			Game.tile_type[0][25] = "Forest";
			Game.tile_type[0][26] = "Forest";
			for(int j=0; j<5; j++){
				Game.tile_type[1][j] = "Peak";
			}
			Game.tile_type[1][6] = "Forest";
			for(int j=15; j<21; j++){
				Game.tile_type[1][j] = "Peak";
			}
			Game.tile_type[1][23] = "Village";
			Game.tile_type[1][25] = "Forest";
			Game.tile_type[1][26] = "Forest";
			for(int j=0; j<8; j++){
				if(j != 6 && j != 7){
					Game.tile_type[2][j] = "Peak";
				}
				if(j != 7){
					Game.tile_type[3][j] = "Peak";
				}
				Game.tile_type[4][j] = "Peak";
				Game.tile_type[5][j] = "Peak";
			}
			Game.tile_type[2][8] = "Forest";
			Game.tile_type[2][9] = "Forest";
			Game.tile_type[2][12] = "Fort";
			for(int j=16; j<21; j++){
				Game.tile_type[2][j] = "Peak";
			}
			Game.tile_type[2][26] = "Forest";
			Game.tile_type[3][9] = "Forest";
			Game.tile_type[3][11] = "Forest";
			Game.tile_type[3][12] = "Fort";
			for(int j=17; j<23; j++){
				Game.tile_type[3][j] = "Peak";
				if(j != 17){
					Game.tile_type[4][j] = "Peak";
				}
			}
			Game.tile_type[5][13] = "Forest";
			Game.tile_type[5][14] = "Peak";
			Game.tile_type[5][15] = "Forest";
			Game.tile_type[5][18] = "Peak";
			for(int j=19; j<21; j++){
				Game.tile_type[5][j] = "Peak";
				Game.tile_type[6][j] = "Peak";
				Game.tile_type[7][j] = "Peak";
			}
			for(int j=21; j<25; j++){
				Game.tile_type[5][j] = "Peak";
				Game.tile_type[6][j] = "Peak";
				Game.tile_type[7][j] = "Peak";
				Game.tile_type[8][j] = "Peak";
				Game.tile_type[9][j] = "Peak";
				Game.tile_type[10][j] = "Peak";
				Game.tile_type[11][j] = "Peak";
			}
			Game.tile_type[6][0] = "Peak";
			Game.tile_type[6][4] = "Peak";
			for(int j=5; j<9; j++){
				Game.tile_type[6][j] = "Peak";
				Game.tile_type[7][j] = "Peak";
			}
			for(int j=13; j<16; j++){
				Game.tile_type[6][j] = "Peak";
				Game.tile_type[7][j] = "Peak";
				Game.tile_type[8][j] = "Peak";
				Game.tile_type[9][j] = "Peak";
				Game.tile_type[10][j] = "Peak";
				Game.tile_type[11][j] = "Peak";
				Game.tile_type[12][j] = "Peak";
				Game.tile_type[13][j] = "Peak";
			}
			Game.tile_type[6][18] = "Forest";
			Game.tile_type[6][25] = "Peak";
			Game.tile_type[6][26] = "Forest";
			Game.tile_type[7][0] = "Peak";
			Game.tile_type[7][2] = "Peak";
			Game.tile_type[7][3] = "Peak";
			Game.tile_type[7][10] = "Forest";
			Game.tile_type[7][26] = "Forest";
			Game.tile_type[8][4] = "Fort";
			Game.tile_type[8][5] = "Peak";
			Game.tile_type[8][6] = "Peak";
			Game.tile_type[8][7] = "Peak";
			Game.tile_type[8][11] = "Forest";
			Game.tile_type[8][17] = "Forest";
			Game.tile_type[8][19] = "Forest";
			for(int j=0; j<3; j++){
				Game.tile_type[9][j] = "--";
				Game.tile_type[10][j] = "--";
				Game.tile_type[11][j] = "--";
			}
			Game.tile_type[9][4] = "Fort";
			Game.tile_type[9][12] = "Forest";
			Game.tile_type[9][17] = "Forest";
			Game.tile_type[9][20] = "Forest";
			Game.tile_type[9][26] = "Forest";
			Game.tile_type[10][2] = "Gate";
			Game.tile_type[10][9] = "Forest";
			Game.tile_type[10][19] = "Forest";
			Game.tile_type[11][12] = "Forest";
			Game.tile_type[11][16] = "Forest";
			Game.tile_type[12][2] = "Forest";
			Game.tile_type[12][5] = "Peak";
			Game.tile_type[12][6] = "Peak";
			Game.tile_type[12][7] = "Peak";
			Game.tile_type[12][11] = "Forest";
			Game.tile_type[12][16] = "Forest";
			Game.tile_type[12][18] = "Forest";
			Game.tile_type[12][20] = "Forest";
			Game.tile_type[12][21] = "Peak";
			Game.tile_type[12][22] = "Peak";
			Game.tile_type[12][23] = "Peak";
			Game.tile_type[12][26] = "Forest";
			Game.tile_type[13][0] = "Peak";
			Game.tile_type[13][2] = "Fort";
			Game.tile_type[13][3] = "Fort";
			for(int j=5; j<10; j++){
				Game.tile_type[13][j] = "Peak";
				Game.tile_type[14][j] = "Peak";
			}
			for(int j=16; j<19; j++){
				Game.tile_type[13][j] = "Mountain";
				Game.tile_type[14][j] = "Mountain";
			}
			Game.tile_type[13][22] = "Peak";
			Game.tile_type[13][23] = "Mountain";
			Game.tile_type[13][25] = "Forest";
			Game.tile_type[14][0] = "Peak";
			Game.tile_type[14][1] = "Peak";
			Game.tile_type[14][2] = "Forest";
			Game.tile_type[14][3] = "Forest";
			Game.tile_type[14][4] = "Peak";
			Game.tile_type[14][10] = "Forest";
			Game.tile_type[14][12] = "Forest";
			for(int j=13; j<15; j++){
				Game.tile_type[14][j] = "Peak";
				Game.tile_type[15][j] = "Peak";
				Game.tile_type[16][j] = "Peak";
				Game.tile_type[17][j] = "Peak";
			}
			Game.tile_type[14][15] = "Mountain";
			Game.tile_type[14][19] = "Mountain";
			Game.tile_type[14][25] = "Forest";
			for(int j=0; j<6; j++){
				Game.tile_type[15][j] = "Peak";
				Game.tile_type[16][j] = "Peak";
				Game.tile_type[17][j] = "Peak";
			}
			for(int j=6; j<8; j++){
				Game.tile_type[15][j] = "Peak";
				Game.tile_type[16][j] = "Peak";
			}
			Game.tile_type[15][9] = "Forest";
			Game.tile_type[15][10] = "Forest";
			for(int j=11; j<13; j++){
				Game.tile_type[15][j] = "Peak";
				Game.tile_type[16][j] = "Peak";
				Game.tile_type[17][j] = "Peak";
				Game.tile_type[18][j] = "Peak";
				Game.tile_type[19][j] = "Peak";
				Game.tile_type[20][j] = "Peak";
			}
			for(int j=17; j<21; j++){
				Game.tile_type[15][j] = "Mountain";
			}
			Game.tile_type[15][23] = "Fort";
			Game.tile_type[16][10] = "Forest";
			for(int j=18; j<22; j++){
				Game.tile_type[16][j] = "Mountain";
			}
			Game.tile_type[16][23] = "Fort";
			Game.tile_type[16][26] = "Peak";
			for(int i=17; i<21; i++){
				Game.tile_type[i][10] = "Peak";
			}
			Game.tile_type[17][16] = "House";
			Game.tile_type[17][19] = "Mountain";
			Game.tile_type[17][20] = "Mountain";
			Game.tile_type[17][25] = "Peak";
			Game.tile_type[17][26] = "Peak";
			Game.tile_type[18][13] = "Mountain";
			Game.tile_type[18][16] = "House";
			for(int j=24; j<27; j++){
				Game.tile_type[18][j] = "Peak";
				Game.tile_type[19][j] = "Peak";
				Game.tile_type[20][j] = "Peak";
			}
			Game.tile_type[19][0] = "Peak";
			Game.tile_type[19][4] = "Shop";
			Game.tile_type[19][5] = "Forest";
			Game.tile_type[19][6] = "Forest";
			Game.tile_type[19][9] = "Forest";
			Game.tile_type[19][20] = "Forest";
			Game.tile_type[19][21] = "Forest";
			Game.tile_type[20][0] = "Peak";
			Game.tile_type[20][1] = "Peak";
			Game.tile_type[20][4] = "Shop";
			Game.tile_type[20][7] = "Forest";
			Game.tile_type[20][9] = "Peak";
			Game.tile_type[20][16] = "Peak";
			Game.tile_type[20][17] = "Peak";
			Game.tile_type[20][23] = "Peak";
			
		}//finish Map 5
		else if(Game.Map == 6){
			
			UnitStats.MaxUnitNum = 10;
			
			UnitStats.AStartLocationX[0] = 19; 
			UnitStats.AStartLocationY[0] = 3;
			
			UnitStats.AStartLocationX[1] = 19;
			UnitStats.AStartLocationY[1] = 5;
			
			UnitStats.AStartLocationX[2] = 14;
			UnitStats.AStartLocationY[2] = 6;
			
			UnitStats.AStartLocationX[3] = 15;
			UnitStats.AStartLocationY[3] = 7;
			
			UnitStats.AStartLocationX[4] = 15;
			UnitStats.AStartLocationY[4] = 8;
			
			UnitStats.AStartLocationX[5] = 18;
			UnitStats.AStartLocationY[5] = 8;
			
			UnitStats.AStartLocationX[6] = 7;			
			UnitStats.AStartLocationY[6] = 16;
			
			UnitStats.AStartLocationX[7] = 5;			
			UnitStats.AStartLocationY[7] = 16;
			
			UnitStats.AStartLocationX[8] = 6;			
			UnitStats.AStartLocationY[8] = 15;
			
			UnitStats.AStartLocationX[9] = 5;			
			UnitStats.AStartLocationY[9] = 17;
			
			
			UnitStats.EStartLocationX[0] = 1; 
			UnitStats.EStartLocationY[0] = 30; 
			
			UnitStats.EStartLocationX[1] = 2;
			UnitStats.EStartLocationY[1] = 29;
			
			UnitStats.EStartLocationX[2] = 0;
			UnitStats.EStartLocationY[2] = 29;
			
			UnitStats.EStartLocationX[3] = 4;
			UnitStats.EStartLocationY[3] = 30;
			
			UnitStats.EStartLocationX[4] = 4;
			UnitStats.EStartLocationY[4] = 28;
			
			UnitStats.EStartLocationX[5] = 20;
			UnitStats.EStartLocationY[5] = 25;
			
			UnitStats.EStartLocationX[6] = 18;
			UnitStats.EStartLocationY[6] = 25;
			
			UnitStats.EStartLocationX[7] = 20;
			UnitStats.EStartLocationY[7] = 23;
			
			UnitStats.EStartLocationX[8] = 19;
			UnitStats.EStartLocationY[8] = 21;
			
			UnitStats.EStartLocationX[9] = 18;
			UnitStats.EStartLocationY[9] = 24;
			
			Game.MaxShiftX = 3;
			Game.MaxShiftY = 17;
			for(int i=0; i<Game.GridMax_X+1; i++){
				for(int j=0; j<Game.GridMax_Y+1; j++){
					Game.tile_type[i][j] = "Forest";
				}
			}
			Game.tile_type[7][0] = "Plain";
			Game.tile_type[8][0] = "River";
			Game.tile_type[14][0] = "River";
			Game.tile_type[16][0] = "River";
			Game.tile_type[21][0] = "River";
			Game.tile_type[7][1] = "River";
			Game.tile_type[8][1] = "River";
			Game.tile_type[13][1] = "River";
			Game.tile_type[14][1] = "River";
			Game.tile_type[16][1] = "River";
			for(int i=18; i<21; i++){
				for(int j=1; j<4; j++){
					Game.tile_type[i][j] = "--";
				}
			}
			Game.tile_type[21][1] = "River";
			Game.tile_type[22][1] = "River";
			for(int i=1; i<4; i++){
				for(int j=2; j<5; j++){
					Game.tile_type[i][j] = "--";
				}
			}
			Game.tile_type[6][2] = "Plain";
			Game.tile_type[7][2] = "River";
			Game.tile_type[13][2] = "River";
			Game.tile_type[15][2] = "River";
			Game.tile_type[16][2] = "River";
			Game.tile_type[22][2] = "River";
			Game.tile_type[4][3] = "Plain";
			Game.tile_type[7][3] = "River";
			Game.tile_type[12][3] = "River";
			Game.tile_type[13][3] = "River";
			Game.tile_type[15][3] = "River";
			Game.tile_type[16][3] = "River";
			Game.tile_type[19][3] = "Gate";
			Game.tile_type[22][3] = "River";
			Game.tile_type[2][4] = "Village";
			Game.tile_type[4][4] = "Plain";
			Game.tile_type[5][4] = "Plain";
			Game.tile_type[6][4] = "River";
			Game.tile_type[7][4] = "River";
			Game.tile_type[8][4] = "Plain";
			Game.tile_type[12][4] = "River";
			for(int i=16; i<23; i++){
				Game.tile_type[i][4] = "River";
				if(i==19){
					Game.tile_type[i][4] = "Bridge";
				}
			}
			for(int i=0; i<23; i++){
				if(i<5 || i==8 || i==9 || i==19 || i==22){
					Game.tile_type[i][5] = "Plain";
				}
				else if(i==5 || i==6 || i==11 || i==12 || i==17 || i==18 || i==20 || i==21){
					Game.tile_type[i][5] = "River";
				}
			}
			Game.tile_type[0][6] = "Plain";
			Game.tile_type[3][6] = "Cliff";
			Game.tile_type[4][6] = "Plain";
			Game.tile_type[5][6] = "River";
			Game.tile_type[9][6] = "Plain";
			Game.tile_type[11][6] = "River";
			Game.tile_type[12][6] = "Plain";
			for(int i=14; i<20; i++){
				Game.tile_type[i][6] = "Plain";
			}
			Game.tile_type[21][6] = "River";
			Game.tile_type[22][6] = "River";
			Game.tile_type[0][7] = "Plain";
			Game.tile_type[3][7] = "Cliff";
			Game.tile_type[5][7] = "River";
			Game.tile_type[9][7] = "Plain";
			Game.tile_type[11][7] = "River";
			Game.tile_type[13][7] = "Plain";
			Game.tile_type[14][7] = "Plain";
			Game.tile_type[18][7] = "Plain";
			for(int i=19; i<22; i++){
				for (int j=7; j<10; j++){
					Game.tile_type[i][j] = "--";
				}
			}
			Game.tile_type[22][7] = "River";
			for(int i=0; i<23; i++){
				if(i==0 || i==10 || i==12 || i==13 || i==18){
					Game.tile_type[i][8] = "Plain";
				}
				else if(i>=1 && i<=3 || i==8 || i==9){
					Game.tile_type[i][8] = "Cliff";
				}
				else if(i==4 || i==5){
					Game.tile_type[i][8] = "River";
				}
				else if(i==11){
					Game.tile_type[i][8] = "Bridge";
				}
			}
			for(int i=1; i<23; i++){
				if(i<4 || i==8 || i==9){
					Game.tile_type[i][9] = "Plain";
				}
				else if(i==4 || i==11){
					Game.tile_type[i][9] = "River";
				}
			}
			Game.tile_type[20][9] = "Village";
			for(int i=2; i<23; i++){
				if(i<4 || i==7 || i==18 || i==20){
					Game.tile_type[i][10] = "Plain";
				}
				else if(i==4 || i==10 || i==11){
					Game.tile_type[i][10] = "River";
				}
			}
			for(int i=0; i<23; i++){
				if(i<2){
					Game.tile_type[i][11] = "Cliff";
				}
				else if(i==2 || i==3 || i==15 || i==17 || i==18){
					Game.tile_type[i][11] = "Plain";
				}
				else if(i==4 || i==10){
					Game.tile_type[i][11] = "River";
				}
			}
			for(int i=1; i<23; i++){
				if(i==1 || i==6 || i>=14 && i<=17 || i==19){
					Game.tile_type[i][12] = "Plain";
				}
				else if(i==3 || i==4 || i==10 || i==11){
					Game.tile_type[i][12] = "River";
				}
			}
			for(int i=1; i<23; i++){
				if(i==1 || i==6 || i==14 || i==19){
					Game.tile_type[i][13] = "Plain";
				}
				else if(i==2 || i==3 || i==11){
					Game.tile_type[i][13] = "River";
				}
			}
			Game.tile_type[5][13] = "Cliff";
			for(int i=0; i<23; i++){
				if(i==5 || i==13 || i==14 || i==17 || i==18){
					Game.tile_type[i][14] = "Plain";
				}
				else if(i<3 || i==11 || i==12){
					Game.tile_type[i][14] = "River";
				}
			}
			Game.tile_type[4][14] = "Cliff";
			for(int i=0; i<23; i++){
				if(i==4 || i==8 || i==11 || i==15 || i==18){
					Game.tile_type[i][15] = "Plain";
				}
				else if(i==0 || i==12 || i==13){
					Game.tile_type[i][15] = "River";
				}
			}
			Game.tile_type[9][15] = "Cliff";
			for(int i=5; i<23; i++){
				if(i==5 || i==10 || i==15 || i==19){
					Game.tile_type[i][16] = "Plain";
				}
				else if(i==8 || i==16){
					Game.tile_type[i][16] = "Cliff";
				}
			}
			Game.tile_type[13][16] = "River";
			Game.tile_type[7][17] = "House";
			Game.tile_type[13][17] = "River";
			Game.tile_type[15][17] = "Cliff";
			Game.tile_type[16][17] = "Cliff";
			Game.tile_type[17][17] = "Plain";
			Game.tile_type[18][17] = "Plain";
			Game.tile_type[20][17] = "River";
			Game.tile_type[21][17] = "River";
			Game.tile_type[22][17] = "River";
			Game.tile_type[6][18] = "Plain";
			Game.tile_type[7][18] = "Plain";
			Game.tile_type[12][18] = "River";
			Game.tile_type[13][18] = "River";
			Game.tile_type[18][18] = "Plain";
			Game.tile_type[19][18] = "River";
			Game.tile_type[20][18] = "River";
			Game.tile_type[1][19] = "Plain";
			Game.tile_type[6][19] = "Plain";
			Game.tile_type[12][19] = "River";
			Game.tile_type[17][19] = "River";
			Game.tile_type[18][19] = "Bridge";
			Game.tile_type[19][19] = "River";
			Game.tile_type[12][19] = "River";
			Game.tile_type[0][20] = "Plain";
			Game.tile_type[4][20] = "House";
			Game.tile_type[5][20] = "Plain";
			Game.tile_type[6][20] = "Plain";
			Game.tile_type[12][20] = "River";
			Game.tile_type[16][20] = "River";
			Game.tile_type[18][20] = "Plain";
			Game.tile_type[21][20] = "Cliff";
			Game.tile_type[22][20] = "Cliff";
			Game.tile_type[4][21] = "Plain";
			Game.tile_type[8][21] = "Cliff";
			Game.tile_type[9][21] = "Cliff";
			Game.tile_type[12][21] = "River";
			Game.tile_type[16][21] = "River";
			Game.tile_type[19][21] = "Plain";
			Game.tile_type[21][21] = "Cliff";
			Game.tile_type[22][21] = "Plain";
			for(int i=0; i<23; i++){
				if(i<3 || i==10 || i==11 || i==22){
					Game.tile_type[i][22] = "Cliff";
				}
				else if(i==4 || i==5 || i==8 || i==9 || i==20){
					Game.tile_type[i][22] = "Plain";
				}
				else if(i>=12 && i<=16){
					Game.tile_type[i][22] = "River";
				}
			}
			Game.tile_type[3][22] = "House";
			for(int i=17; i<20; i++){
				for(int j=22; j<25; j++){
					Game.tile_type[i][j] = "--";
				}
			}
			for(int i=0; i<23; i++){
				if(i==0 || i>=13 && i<=15){
					Game.tile_type[i][23] = "River";
				}
				else if(i>=1 && i<=7 && i!=3 || i==16 || i==20){
					Game.tile_type[i][23] = "Plain";
				}
				else if(i==3 || i==22){
					Game.tile_type[i][23] = "Cliff";
				}
			}
			for(int i=0; i<23; i++){
				if(i<3 || i>=13 && i<=14){
					Game.tile_type[i][24] = "River";
				}
				else if(i==11 || i==12){
					Game.tile_type[i][24] = "Lake";
				}
				else if(i>=3 && i<=5 || i==8 || i==10 || i==20 || i==21){
					Game.tile_type[i][24] = "Plain";
				}
				else if(i==6 || i==7 || i==22){
					Game.tile_type[i][24] = "Cliff";
				}
			}
			Game.tile_type[18][24] = "Village";
			for(int i=1; i<23; i++){
				if(i>=2 && i<=5 && i!=4){
					Game.tile_type[i][25] = "River";
				}
				else if(i>=10 && i<=16){
					Game.tile_type[i][25] = "Lake";
				}
				else if(i==1 || i==6 || i==7 || i==9 || i==18 || i==20){
					Game.tile_type[i][25] = "Plain";
				}
			}
			Game.tile_type[4][25] = "Bridge";
			Game.tile_type[22][25] = "Cliff";
			for(int i=1; i<23; i++){
				if(i>=5 && i<=7){
					Game.tile_type[i][26] = "River";
				}
				else if(i>=10 && i<=16){
					Game.tile_type[i][26] = "Lake";
				}
				else if(i==1 || i==4 || i==8 || i==19){
					Game.tile_type[i][26] = "Plain";
				}
				else if(i==3|| i==22){
					Game.tile_type[i][26] = "Cliff";
				}
			}
			for(int i=0; i<23; i++){
				if(i==7){
					Game.tile_type[i][27] = "River";
				}
				else if(i>=10 && i<=18){
					Game.tile_type[i][27] = "Lake";
				}
				else if(i>=2 && i<=4 || i==6 || i==8 || i==9 || i==22){
					Game.tile_type[i][27] = "Plain";
				}
				else if(i<2 || i==21){
					Game.tile_type[i][27] = "Cliff";
				}
			}
			for(int i=0; i<23; i++){
				if(i==7){
					Game.tile_type[i][28] = "River";
				}
				else if(i>=11 && i<=13 || i>=16 && i<=18){
					Game.tile_type[i][28] = "Lake";
				}
				else if(i<7 || i==10 || i==21){
					Game.tile_type[i][28] = "Plain";
				}
			}
			for(int i=0; i<23; i++){
				if(i==7 || i==11){
					Game.tile_type[i][29] = "River";
				}
				else if(i>=12 && i<=18){
					Game.tile_type[i][29] = "Lake";
				}
				else if(i<4){
					Game.tile_type[i][29] = "Plain";
				}
			}
			for(int i=0; i<23; i++){
				if(i>=7 && i<=11 && i!=9){
					Game.tile_type[i][30] = "River";
				}
				else if(i>=13 && i<=17){
					Game.tile_type[i][30] = "Lake";
				}
				else if(i<4){
					Game.tile_type[i][30] = "Plain";
				}
			}
			for(int i=0; i<23; i++){
				if(i>=8 && i<=10 && i!=9){
					Game.tile_type[i][31] = "River";
				}
				else if(i<3 || i==7 || i==9){
					Game.tile_type[i][31] = "Plain";
				}
			}
		}//finished with map 6
		
		else if(Game.Map == 7){
			
			UnitStats.MaxUnitNum = 20;
			
			UnitStats.AStartLocationX[0] = 6; 
			UnitStats.AStartLocationY[0] = 3;
			
			UnitStats.AStartLocationX[1] = 4;
			UnitStats.AStartLocationY[1] = 5;
			
			UnitStats.AStartLocationX[2] = 5;
			UnitStats.AStartLocationY[2] = 5;
			
			UnitStats.AStartLocationX[3] = 6;
			UnitStats.AStartLocationY[3] = 5;
			
			UnitStats.AStartLocationX[4] = 2;
			UnitStats.AStartLocationY[4] = 7;
			
			UnitStats.AStartLocationX[5] = 3;
			UnitStats.AStartLocationY[5] = 7;
			
			UnitStats.AStartLocationX[6] = 4;			
			UnitStats.AStartLocationY[6] = 7;
			
			UnitStats.AStartLocationX[7] = 5;			
			UnitStats.AStartLocationY[7] = 12;
			
			UnitStats.AStartLocationX[8] = 6;			
			UnitStats.AStartLocationY[8] = 11;
			
			UnitStats.AStartLocationX[9] = 7;			
			UnitStats.AStartLocationY[9] = 10;
			
			UnitStats.AStartLocationX[10] = 6; 
			UnitStats.AStartLocationY[10] = 8;
			
			UnitStats.AStartLocationX[11] = 7;
			UnitStats.AStartLocationY[11] = 8;
			
			UnitStats.AStartLocationX[12] = 8;
			UnitStats.AStartLocationY[12] = 8;
			
			UnitStats.AStartLocationX[13] = 1;
			UnitStats.AStartLocationY[13] = 11;
			
			UnitStats.AStartLocationX[14] = 2;
			UnitStats.AStartLocationY[14] = 11;
			
			UnitStats.AStartLocationX[15] = 3;
			UnitStats.AStartLocationY[15] = 11;
			
			UnitStats.AStartLocationX[16] = 4;			
			UnitStats.AStartLocationY[16] = 11;
			
			UnitStats.AStartLocationX[17] = 8;			
			UnitStats.AStartLocationY[17] = 10;
			
			UnitStats.AStartLocationX[18] = 7;			
			UnitStats.AStartLocationY[18] = 11;
			
			UnitStats.AStartLocationX[19] = 9;			
			UnitStats.AStartLocationY[19] = 9;
			
			
			UnitStats.EStartLocationX[0] = 28; 
			UnitStats.EStartLocationY[0] = 21; 
			
			UnitStats.EStartLocationX[1] = 27;
			UnitStats.EStartLocationY[1] = 20;
			
			UnitStats.EStartLocationX[2] = 27;
			UnitStats.EStartLocationY[2] = 22;
			
			UnitStats.EStartLocationX[3] = 29;
			UnitStats.EStartLocationY[3] = 20;
			
			UnitStats.EStartLocationX[4] = 26;
			UnitStats.EStartLocationY[4] = 17;
			
			UnitStats.EStartLocationX[5] = 27;
			UnitStats.EStartLocationY[5] = 17;
			
			UnitStats.EStartLocationX[6] = 28;
			UnitStats.EStartLocationY[6] = 17;
			
			UnitStats.EStartLocationX[7] = 23;
			UnitStats.EStartLocationY[7] = 21;
			
			UnitStats.EStartLocationX[8] = 23;
			UnitStats.EStartLocationY[8] = 22;
			
			UnitStats.EStartLocationX[9] = 23;
			UnitStats.EStartLocationY[9] = 23;
			
			UnitStats.EStartLocationX[10] = 23; 
			UnitStats.EStartLocationY[10] = 17; 
			
			UnitStats.EStartLocationX[11] = 24;
			UnitStats.EStartLocationY[11] = 16;
			
			UnitStats.EStartLocationX[12] = 25;
			UnitStats.EStartLocationY[12] = 15;
			
			UnitStats.EStartLocationX[13] = 21;
			UnitStats.EStartLocationY[13] = 20;
			
			UnitStats.EStartLocationX[14] = 21;
			UnitStats.EStartLocationY[14] = 19;
			
			UnitStats.EStartLocationX[15] = 21;
			UnitStats.EStartLocationY[15] = 21;
			
			UnitStats.EStartLocationX[16] = 21;
			UnitStats.EStartLocationY[16] = 22;
			
			UnitStats.EStartLocationX[17] = 21;
			UnitStats.EStartLocationY[17] = 23;
			
			UnitStats.EStartLocationX[18] = 22;
			UnitStats.EStartLocationY[18] = 19;
			
			UnitStats.EStartLocationX[19] = 21;
			UnitStats.EStartLocationY[19] = 18;
			
			Game.MaxShiftX = 12;
			Game.MaxShiftY = 17;
			for(int i=0; i<Game.GridMax_X+1; i++){
				for(int j=0; j<Game.GridMax_Y+1; j++){
					Game.tile_type[i][j] = "Plain";
				}
			}
			for(int i=0; i<5; i++){
				for(int j=0; j<5; j++){
					Game.tile_type[i][j] = "Peak";
				}
			}
			Game.tile_type[5][0] = "Peak";
			Game.tile_type[6][0] = "Peak";
			for(int i=7; i<16; i++){
				Game.tile_type[i][0] = "Peak";
				Game.tile_type[i][1] = "Peak";
			}
			Game.tile_type[16][0] = "Peak";
			for(int i=20; i<30; i++){
				Game.tile_type[i][0] = "Lake";
			}
			for(int j=0; j<4; j++){
				Game.tile_type[30][j] = "Peak";
				Game.tile_type[31][j] = "Peak";
			}
			for(int i=20; i<25; i++){
				Game.tile_type[i][1] = "Lake";
			}
			Game.tile_type[29][1] = "Peak";
			Game.tile_type[8][2] = "Peak";
			for(int i=9; i<15; i++){
				Game.tile_type[i][2] = "Peak";
				Game.tile_type[i][3] = "Peak";
				Game.tile_type[i][4] = "Peak";
			}
			Game.tile_type[15][2] = "Peak";
			Game.tile_type[21][2] = "Lake";
			Game.tile_type[22][2] = "Lake";
			Game.tile_type[26][2] = "Cliff";
			Game.tile_type[27][2] = "Cliff";
			Game.tile_type[28][2] = "Cliff";
			Game.tile_type[29][2] = "Peak";
			Game.tile_type[6][3] = "Fort";
			Game.tile_type[25][3] = "Cliff";
			Game.tile_type[29][3] = "Cliff";
			for(int i=7; i<12; i++){
				Game.tile_type[i][4] = "Peak";
				Game.tile_type[i][5] = "Peak";
				Game.tile_type[i][6] = "Peak";
			}
			Game.tile_type[20][4] = "Fort";
			Game.tile_type[25][4] = "Cliff";
			Game.tile_type[30][4] = "Cliff";
			Game.tile_type[31][4] = "Peak";
			Game.tile_type[1][5] = "Peak";
			Game.tile_type[2][5] = "Peak";
			Game.tile_type[13][5] = "Fort";
			Game.tile_type[27][5] = "Fort";
			Game.tile_type[31][5] = "Cliff";
			Game.tile_type[31][6] = "Cliff";
			Game.tile_type[29][7] = "Cliff";
			Game.tile_type[30][7] = "Cliff";
			Game.tile_type[3][8] = "Forest";
			Game.tile_type[11][8] = "Fort";
			Game.tile_type[21][8] = "Peak";
			for(int i=25; i<29; i++){
				Game.tile_type[i][8] = "Cliff";
			}
			Game.tile_type[31][8] = "River";
			Game.tile_type[9][9] = "Forest";
			Game.tile_type[29][9] = "River";
			Game.tile_type[30][9] = "River";
			Game.tile_type[31][9] = "River";
			Game.tile_type[1][10] = "Forest";
			Game.tile_type[2][10] = "Forest";
			Game.tile_type[8][10] = "Fort";
			Game.tile_type[15][10] = "Forest";
			Game.tile_type[17][10] = "Fort";
			Game.tile_type[28][10] = "River";
			Game.tile_type[29][10] = "River";
			Game.tile_type[1][11] = "Forest";
			Game.tile_type[2][11] = "Forest";
			Game.tile_type[25][11] = "Cliff";
			Game.tile_type[27][11] = "Cliff";
			Game.tile_type[28][11] = "River";
			Game.tile_type[29][11] = "Cliff";
			Game.tile_type[30][11] = "Cliff";
			Game.tile_type[26][12] = "Cliff";
			Game.tile_type[28][12] = "River";
			Game.tile_type[31][12] = "Cliff";
			Game.tile_type[23][13] = "Fort";
			Game.tile_type[28][13] = "River";
			Game.tile_type[29][13] = "River";
			Game.tile_type[30][13] = "River";
			Game.tile_type[7][14] = "Fort";
			Game.tile_type[30][14] = "River";
			Game.tile_type[0][15] = "Forest";
			Game.tile_type[28][15] = "Forest";
			Game.tile_type[30][15] = "River";
			Game.tile_type[28][16] = "Forest";
			Game.tile_type[30][16] = "River";
			Game.tile_type[29][17] = "River";
			Game.tile_type[30][17] = "River";
			Game.tile_type[3][18] = "Fort";
			Game.tile_type[23][18] = "Fort";
			Game.tile_type[26][18] = "River";
			Game.tile_type[27][18] = "Bridge";
			Game.tile_type[28][18] = "River";
			Game.tile_type[29][18] = "River";
			Game.tile_type[5][19] = "Forest";
			Game.tile_type[10][19] = "Fort";
			Game.tile_type[25][19] = "River";
			Game.tile_type[26][19] = "River";
			Game.tile_type[31][19] = "Forest";
			Game.tile_type[6][20] = "Forest";
			Game.tile_type[20][20] = "Fort";
			Game.tile_type[25][20] = "River";
			Game.tile_type[30][20] = "Forest";
			Game.tile_type[31][20] = "Forest";
			Game.tile_type[0][21] = "Cliff";
			Game.tile_type[1][21] = "Cliff";
			Game.tile_type[16][21] = "Fort";
			Game.tile_type[24][21] = "River";
			Game.tile_type[25][21] = "River";
			Game.tile_type[28][21] = "Fort";
			Game.tile_type[31][21] = "Forest";
			Game.tile_type[6][22] = "Cliff";
			Game.tile_type[7][22] = "Cliff";
			Game.tile_type[24][22] = "Bridge";
			Game.tile_type[30][22] = "Forest";
			Game.tile_type[0][23] = "Forest";
			Game.tile_type[5][23] = "Cliff";
			Game.tile_type[24][23] = "River";
			Game.tile_type[25][23] = "River";
			Game.tile_type[26][23] = "River";
			Game.tile_type[27][23] = "River";
			Game.tile_type[31][23] = "Forest";
			Game.tile_type[11][24] = "Cliff";
			Game.tile_type[27][24] = "River";
			Game.tile_type[28][24] = "River";
			Game.tile_type[29][24] = "River";
			Game.tile_type[1][25] = "Fort";
			Game.tile_type[4][25] = "Forest";
			Game.tile_type[12][25] = "Cliff";
			Game.tile_type[13][25] = "Cliff";
			Game.tile_type[16][25] = "Sea";
			Game.tile_type[17][25] = "Sea";
			Game.tile_type[29][25] = "River";
			Game.tile_type[30][25] = "River";
			Game.tile_type[4][26] = "Forest";
			Game.tile_type[16][26] = "Sea";
			Game.tile_type[17][26] = "Cliff";
			Game.tile_type[24][26] = "Fort";
			Game.tile_type[25][26] = "Forest";
			Game.tile_type[29][26] = "River";
			Game.tile_type[30][26] = "River";
			Game.tile_type[5][27] = "Forest";
			Game.tile_type[16][27] = "Sea";
			for(int i=17; i<21; i++){
				Game.tile_type[i][27] = "Cliff";
			}
			Game.tile_type[23][27] = "Forest";
			Game.tile_type[24][27] = "Forest";
			for(int i=27; i<32; i++){
				Game.tile_type[i][27] = "Cliff";
			}
			Game.tile_type[29][27] = "River";
			Game.tile_type[1][28] = "Sea";
			Game.tile_type[2][28] = "Sea";
			Game.tile_type[3][28] = "Cliff";
			Game.tile_type[4][28] = "Cliff";
			Game.tile_type[16][28] = "Sea";
			for(int j=28; j<32; j++){
				Game.tile_type[17][j] = "Sea";
				Game.tile_type[18][j] = "Sea";
				Game.tile_type[19][j] = "Sea";
			}
			Game.tile_type[20][28] = "Sea";
			Game.tile_type[21][28] = "Cliff";
			Game.tile_type[25][28] = "Cliff";
			Game.tile_type[26][28] = "Cliff";
			Game.tile_type[28][28] = "River";
			Game.tile_type[29][28] = "River";
			for(int i=0; i<4; i++){
				for(int j=29; j<32; j++){
					if(i != 1 || j != 30){
						Game.tile_type[i][j] = "Sea";
					}
				}
			}
			Game.tile_type[5][29] = "Cliff";
			Game.tile_type[13][29] = "Fort";
			Game.tile_type[23][29] = "Cliff";
			Game.tile_type[24][29] = "Cliff";
			Game.tile_type[28][29] = "River";
			Game.tile_type[6][30] = "Cliff";
			Game.tile_type[24][30] = "Sea";
			Game.tile_type[25][30] = "Sea";
			Game.tile_type[28][30] = "River";
			Game.tile_type[4][31] = "Sea";
			Game.tile_type[5][31] = "Sea";
			Game.tile_type[6][31] = "Sea";
			Game.tile_type[10][31] = "Cliff";
			Game.tile_type[12][31] = "Forest";
			Game.tile_type[13][31] = "Forest";
			Game.tile_type[16][31] = "Sea";
			Game.tile_type[20][31] = "Sea";
			for(int i=23; i<30; i++){
				Game.tile_type[i][31] = "Sea";
			}
			
			
			
		}//finished with map 7
		
		else if(Game.Map == 8){
			
			UnitStats.MaxUnitNum = 10;
			
			UnitStats.AStartLocationX[0] = 15; 
			UnitStats.AStartLocationY[0] = 1;
			
			UnitStats.AStartLocationX[1] = 14;
			UnitStats.AStartLocationY[1] = 2;
			
			UnitStats.AStartLocationX[2] = 16;
			UnitStats.AStartLocationY[2] = 2;
			
			UnitStats.AStartLocationX[3] = 12;
			UnitStats.AStartLocationY[3] = 2;
			
			UnitStats.AStartLocationX[4] = 12;
			UnitStats.AStartLocationY[4] = 3;
			
			UnitStats.AStartLocationX[5] = 12;
			UnitStats.AStartLocationY[5] = 4;
			
			UnitStats.AStartLocationX[6] = 12;			
			UnitStats.AStartLocationY[6] = 5;
			
			UnitStats.AStartLocationX[7] = 18;			
			UnitStats.AStartLocationY[7] = 3;
			
			UnitStats.AStartLocationX[8] = 18;			
			UnitStats.AStartLocationY[8] = 4;
			
			UnitStats.AStartLocationX[9] = 18;			
			UnitStats.AStartLocationY[9] = 5;
			
			
			UnitStats.EStartLocationX[0] = 14; 
			UnitStats.EStartLocationY[0] = 14; 
			
			UnitStats.EStartLocationX[1] = 2;
			UnitStats.EStartLocationY[1] = 26;
			
			UnitStats.EStartLocationX[2] = 3;
			UnitStats.EStartLocationY[2] = 25;
			
			UnitStats.EStartLocationX[3] = 3;
			UnitStats.EStartLocationY[3] = 27;
			
			UnitStats.EStartLocationX[4] = 29;
			UnitStats.EStartLocationY[4] = 7;
			
			UnitStats.EStartLocationX[5] = 28;
			UnitStats.EStartLocationY[5] = 24;
			
			UnitStats.EStartLocationX[6] = 28;
			UnitStats.EStartLocationY[6] = 25;
			
			UnitStats.EStartLocationX[7] = 28;
			UnitStats.EStartLocationY[7] = 23;
			
			UnitStats.EStartLocationX[8] = 5;
			UnitStats.EStartLocationY[8] = 13;
			
			UnitStats.EStartLocationX[9] = 22;
			UnitStats.EStartLocationY[9] = 13;
			
			Game.MaxShiftX = 10;
			Game.MaxShiftY = 13;
			for(int i=0; i<Game.GridMax_X+1; i++){
				for(int j=0; j<Game.GridMax_Y+1; j++){
					Game.tile_type[i][j] = "Floor";
				}
			}
			Game.tile_type[8][0] = "Wall";
			Game.tile_type[9][0] = "Plain";
			Game.tile_type[10][0] = "Forest";
			Game.tile_type[11][0] = "Forest";
			Game.tile_type[12][0] = "Forest";
			Game.tile_type[13][0] = "Plain";
			Game.tile_type[14][0] = "Plain";
			Game.tile_type[15][0] = "Plain";
			Game.tile_type[16][0] = "Plain";
			Game.tile_type[17][0] = "Forest";
			Game.tile_type[18][0] = "Plain";
			Game.tile_type[19][0] = "Plain";
			for(int i=20; i<30; i++){
				Game.tile_type[i][0] = "Wall";
				Game.tile_type[i][1] = "Wall";
			}
			Game.tile_type[8][1] = "Wall";
			for(int i=9; i<20; i++){
				for(int j=1; j<7; j++){
					Game.tile_type[i][j] = "Plain";
				}
			}
			Game.tile_type[19][1] = "Forest";
			Game.tile_type[1][2] = "Pillar";
			for(int j=3; j<11; j++){
				Game.tile_type[3][j] = "Wall";
			}
			for(int j=2; j<5; j++){
				Game.tile_type[4][j] = "Wall";
				Game.tile_type[5][j] = "Wall";
				Game.tile_type[7][j] = "Wall";
				Game.tile_type[8][j] = "Wall";
			}
			Game.tile_type[20][2] = "Wall";
			Game.tile_type[20][3] = "Stairs";
			Game.tile_type[6][4] = "Stairs";
			Game.tile_type[20][4] = "Stairs";
			for(int i=4; i<9; i++){
				Game.tile_type[i][5] = "Plain";
				Game.tile_type[i][6] = "Plain";
			}
			for(int i=20; i<30; i++){
				if(i != 26){
					Game.tile_type[i][5] = "Wall";
					Game.tile_type[i][6] = "Wall";
				}
			}
			Game.tile_type[1][7] = "Pillar";
			for(int i=3; i<21; i++){
				Game.tile_type[i][7] = "Wall";
				Game.tile_type[i][8] = "Wall";
			}
			Game.tile_type[26][7] = "Wall";
			Game.tile_type[28][7] = "Wall";
			for(int i=3; i<15; i++){
				Game.tile_type[i][9] = "Wall";
			}
			Game.tile_type[28][9] = "Pillar";
			Game.tile_type[29][9] = "Pillar";
			Game.tile_type[3][10] = "Stairs";
			Game.tile_type[14][10] = "Stairs";
			Game.tile_type[3][11] = "Stairs";
			Game.tile_type[8][11] = "Stairs";
			for(int i=9; i<19; i++){
				Game.tile_type[i][11] = "Wall";
				Game.tile_type[i][12] = "Wall";
			}
			Game.tile_type[1][12] = "Pillar";
			for(int j=12; j<17; j++){
				Game.tile_type[3][j] = "Wall";
				Game.tile_type[8][j] = "Wall";
			}
			Game.tile_type[4][12] = "Wall";
			Game.tile_type[5][12] = "Wall";
			Game.tile_type[6][12] = "Wall";
			Game.tile_type[7][12] = "Wall";
			for(int i=19; i<27; i++){
				Game.tile_type[i][12] = "Wall";
			}
			Game.tile_type[27][12] = "Stairs";
			Game.tile_type[28][12] = "Stairs";
			Game.tile_type[29][12] = "Stairs";
			for(int j=13; j<17; j++){
				Game.tile_type[9][j] = "Wall";
				Game.tile_type[18][j] = "Wall";
			}
			for(int j=13; j<18; j++){
				Game.tile_type[19][j] = "Wall";
				Game.tile_type[24][j] = "Wall";
			}
			Game.tile_type[25][13] = "Wall";
			Game.tile_type[26][13] = "Wall";
			Game.tile_type[11][14] = "Pillar";
			Game.tile_type[16][14] = "Pillar";
			Game.tile_type[26][14] = "Wall";
			Game.tile_type[27][14] = "Wall";
			for(int j=15; j<17; j++){
				Game.tile_type[4][j] = "Wall";
				Game.tile_type[6][j] = "Wall";
				Game.tile_type[7][j] = "Wall";
			}
			Game.tile_type[10][15] = "Pillar";
			Game.tile_type[17][15] = "Pillar";
			Game.tile_type[26][15] = "Wall";
			Game.tile_type[27][15] = "Wall";
			Game.tile_type[5][16] = "Stairs";
			for(int i=19; i<25; i++){
				if(i != 21){
					Game.tile_type[i][16] = "Wall";
					Game.tile_type[i][17] = "Wall";
				}
			}
			Game.tile_type[27][16] = "Wall";
			Game.tile_type[4][17] = "Wall";
			Game.tile_type[6][17] = "Wall";
			for(int j=17; j<20; j++){
				Game.tile_type[9][j] = "Wall";
				Game.tile_type[10][j] = "Wall";
				Game.tile_type[11][j] = "Wall";
				Game.tile_type[12][j] = "Wall";
				Game.tile_type[15][j] = "Wall";
				Game.tile_type[16][j] = "Wall";
				Game.tile_type[17][j] = "Wall";
				Game.tile_type[18][j] = "Wall";
			}
			Game.tile_type[21][17] = "Stairs";
			Game.tile_type[27][17] = "Stairs";
			Game.tile_type[0][18] = "Pillar";
			Game.tile_type[1][18] = "Pillar";
			Game.tile_type[20][18] = "Wall";
			Game.tile_type[22][18] = "Wall";
			for(int j=18; j<22; j++){
				Game.tile_type[26][j] = "Wall";
				Game.tile_type[27][j] = "Wall";
			}
			Game.tile_type[13][19] = "Stairs";
			Game.tile_type[14][19] = "Stairs";
			Game.tile_type[12][20] = "Wall";
			Game.tile_type[15][20] = "Wall";
			for(int j=22; j<25; j++){
				Game.tile_type[0][j] = "Wall";
				Game.tile_type[1][j] = "Wall";
				Game.tile_type[2][j] = "Wall";
				Game.tile_type[3][j] = "Wall";
				Game.tile_type[4][j] = "Wall";
				Game.tile_type[5][j] = "Wall";
				Game.tile_type[9][j] = "Wall";
				Game.tile_type[10][j] = "Wall";
				Game.tile_type[11][j] = "Wall";
				Game.tile_type[12][j] = "Wall";
				Game.tile_type[13][j] = "Wall";
				Game.tile_type[14][j] = "Wall";
				Game.tile_type[15][j] = "Wall";
			}
			for(int j=22; j<28; j++){
				Game.tile_type[16][j] = "Wall";
			}
			Game.tile_type[26][22] = "Wall";
			for(int j=23; j<26; j++){
				Game.tile_type[17][j] = "Wall";
				Game.tile_type[18][j] = "Wall";
				Game.tile_type[19][j] = "Wall";
				Game.tile_type[22][j] = "Wall";
				Game.tile_type[23][j] = "Wall";
				Game.tile_type[24][j] = "Wall";
				Game.tile_type[25][j] = "Wall";
				Game.tile_type[26][j] = "Wall";
			}
			Game.tile_type[6][24] = "Stairs";
			Game.tile_type[7][24] = "Stairs";
			Game.tile_type[8][24] = "Stairs";
			Game.tile_type[5][25] = "Wall";
			Game.tile_type[9][25] = "Wall";
			Game.tile_type[20][25] = "Stairs";
			Game.tile_type[21][25] = "Stairs";
			Game.tile_type[19][26] = "Wall";
			Game.tile_type[22][26] = "Wall";
		}//finished with map 8
		
		else if(Game.Map == 9){
			
			UnitStats.MaxUnitNum = 15;
			
			UnitStats.AStartLocationX[0] = 17; 
			UnitStats.AStartLocationY[0] = 8;
			
			UnitStats.AStartLocationX[1] = 21;
			UnitStats.AStartLocationY[1] = 15;
			
			UnitStats.AStartLocationX[2] = 17;
			UnitStats.AStartLocationY[2] = 12;
			
			UnitStats.AStartLocationX[3] = 18;
			UnitStats.AStartLocationY[3] = 13;
			
			UnitStats.AStartLocationX[4] = 19;
			UnitStats.AStartLocationY[4] = 14;
			
			UnitStats.AStartLocationX[5] = 23;
			UnitStats.AStartLocationY[5] = 16;
			
			UnitStats.AStartLocationX[6] = 23;			
			UnitStats.AStartLocationY[6] = 17;
			
			UnitStats.AStartLocationX[7] = 22;			
			UnitStats.AStartLocationY[7] = 19;
			
			UnitStats.AStartLocationX[8] = 20;			
			UnitStats.AStartLocationY[8] = 10;
			
			UnitStats.AStartLocationX[9] = 19;			
			UnitStats.AStartLocationY[9] = 10;
			
			UnitStats.AStartLocationX[10] = 21; 
			UnitStats.AStartLocationY[10] = 10;
			
			UnitStats.AStartLocationX[11] = 14;
			UnitStats.AStartLocationY[11] = 10;
			
			UnitStats.AStartLocationX[12] = 15;
			UnitStats.AStartLocationY[12] = 11;
			
			UnitStats.AStartLocationX[13] = 16;
			UnitStats.AStartLocationY[13] = 12;
			
			UnitStats.AStartLocationX[14] = 17;
			UnitStats.AStartLocationY[14] = 13;
			
			
			UnitStats.EStartLocationX[0] = 15; 
			UnitStats.EStartLocationY[0] = 20; 
			
			UnitStats.EStartLocationX[1] = 16;
			UnitStats.EStartLocationY[1] = 19;
			
			UnitStats.EStartLocationX[2] = 16;
			UnitStats.EStartLocationY[2] = 21;
			
			UnitStats.EStartLocationX[3] = 14;
			UnitStats.EStartLocationY[3] = 21;
			
			UnitStats.EStartLocationX[4] = 18;
			UnitStats.EStartLocationY[4] = 19;
			
			UnitStats.EStartLocationX[5] = 17;
			UnitStats.EStartLocationY[5] = 19;
			
			UnitStats.EStartLocationX[6] = 15;
			UnitStats.EStartLocationY[6] = 17;
			
			UnitStats.EStartLocationX[7] = 14;
			UnitStats.EStartLocationY[7] = 16;
			
			UnitStats.EStartLocationX[8] = 13;
			UnitStats.EStartLocationY[8] = 15;
			
			UnitStats.EStartLocationX[9] = 9;
			UnitStats.EStartLocationY[9] = 18;
			
			UnitStats.EStartLocationX[10] = 10; 
			UnitStats.EStartLocationY[10] = 19; 
			
			UnitStats.EStartLocationX[11] = 11;
			UnitStats.EStartLocationY[11] = 20;
			
			UnitStats.EStartLocationX[12] = 9;
			UnitStats.EStartLocationY[12] = 20;
			
			UnitStats.EStartLocationX[13] = 13;
			UnitStats.EStartLocationY[13] = 20;
			
			UnitStats.EStartLocationX[14] = 17;
			UnitStats.EStartLocationY[14] = 22;
			
			Game.MaxShiftX = 9;
			Game.MaxShiftY = 14;
			for(int i=0; i<Game.GridMax_X+1; i++){
				for(int j=0; j<Game.GridMax_Y+1; j++){
					Game.tile_type[i][j] = "Plain";
				}
			}
			Game.tile_type[3][0] = "River";
			Game.tile_type[17][0] = "River";
			Game.tile_type[21][0] = "Peak";
			Game.tile_type[22][0] = "Peak";
			Game.tile_type[23][0] = "Peak";
			for(int j=1; j<6; j++){
				Game.tile_type[2][j] = "River";
			}
			Game.tile_type[3][1] = "River";
			Game.tile_type[4][1] = "Forest";
			Game.tile_type[17][1] = "Bridge";
			Game.tile_type[22][1] = "Forest";
			Game.tile_type[2][2] = "Bridge";
			Game.tile_type[9][2] = "River";
			Game.tile_type[10][2] = "River";
			Game.tile_type[11][2] = "River";
			Game.tile_type[16][2] = "River";
			Game.tile_type[17][2] = "River";
			for(int i=8; i<17; i++){
				Game.tile_type[i][3] = "River";
			}
			Game.tile_type[10][3] = "Forest";
			Game.tile_type[28][3] = "Peak";
			Game.tile_type[1][4] = "Forest";
			Game.tile_type[7][4] = "Forest";
			Game.tile_type[8][4] = "River";
			Game.tile_type[9][4] = "River";
			for(int i=16; i<21; i++){
				Game.tile_type[i][4] = "River";
			}
			Game.tile_type[26][4] = "Peak";
			for(int j=4; j<10; j++){
				Game.tile_type[27][j] = "Peak";
				Game.tile_type[28][j] = "Peak";
			}
			for(int i=3; i<10; i++){
				Game.tile_type[i][5] = "River";
			}
			Game.tile_type[20][5] = "River";
			Game.tile_type[21][5] = "River";
			Game.tile_type[22][5] = "River";
			Game.tile_type[4][6] = "River";
			Game.tile_type[5][6] = "River";
			Game.tile_type[8][6] = "River";
			Game.tile_type[9][6] = "River";
			Game.tile_type[10][6] = "River";
			for(int i=16; i<19; i++){
				Game.tile_type[i][6] = "--";
				Game.tile_type[i][7] = "--";
				Game.tile_type[i][8] = "--";
			}
			Game.tile_type[22][6] = "River";
			Game.tile_type[10][7] = "River";
			Game.tile_type[11][7] = "River";
			Game.tile_type[12][7] = "River";
			Game.tile_type[22][7] = "River";
			Game.tile_type[23][7] = "River";
			for(int j=7; j<10; j++){
				Game.tile_type[26][j] = "Peak";
			}
			for(int i=2; i<5; i++){
				Game.tile_type[i][8] = "--";
				Game.tile_type[i][9] = "--";
				Game.tile_type[i][10] = "--";
			}
			Game.tile_type[12][8] = "River";
			Game.tile_type[13][8] = "River";
			Game.tile_type[17][8] = "Gate";
			for(int j=8; j<11; j++){
				Game.tile_type[23][j] = "River";
			}
			for(int j=9; j<14; j++){
				Game.tile_type[13][j] = "River";
			}
			Game.tile_type[3][10] = "Gate";
			Game.tile_type[13][10] = "Bridge";
			for(int j=10; j<14; j++){
				Game.tile_type[24][j] = "River";
			}
			Game.tile_type[26][11] = "Forest";
			for(int i=7; i<10; i++){
				Game.tile_type[i][12] = "--";
				Game.tile_type[i][13] = "--";
				Game.tile_type[i][14] = "--";
			}
			Game.tile_type[12][12] = "River";
			for(int i=11; i<16; i++){
				Game.tile_type[i][13] = "River";
			}
			for(int i=20; i<23; i++){
				Game.tile_type[i][13] = "--";
				Game.tile_type[i][14] = "--";
				Game.tile_type[i][15] = "--";
			}
			for(int j=13; j<17; j++){
				Game.tile_type[25][j] = "River";
			}
			Game.tile_type[27][13] = "Forest";
			Game.tile_type[8][14] = "Gate";
			Game.tile_type[10][14] = "Forest";
			Game.tile_type[11][14] = "River";
			Game.tile_type[15][14] = "River";
			Game.tile_type[10][15] = "River";
			Game.tile_type[11][15] = "River";
			Game.tile_type[15][15] = "River";
			Game.tile_type[16][15] = "River";
			Game.tile_type[17][15] = "Forest";
			Game.tile_type[21][15] = "Gate";
			Game.tile_type[0][16] = "Forest";
			Game.tile_type[5][16] = "Forest";
			Game.tile_type[8][16] = "River";
			Game.tile_type[9][16] = "River";
			Game.tile_type[10][16] = "River";
			Game.tile_type[11][16] = "Forest";
			Game.tile_type[16][16] = "River";
			Game.tile_type[17][16] = "River";
			for(int j=16; j<22; j++){
				Game.tile_type[26][j] = "River";
			}
			for(int i=0; i<9; i++){
				Game.tile_type[i][17] = "River";
			}
			Game.tile_type[3][17] = "Bridge";
			Game.tile_type[12][17] = "Peak";
			for(int j=17; j<20; j++){
				Game.tile_type[13][j] = "Peak";
				Game.tile_type[14][j] = "Peak";
			}
			Game.tile_type[17][17] = "River";
			Game.tile_type[18][17] = "River";
			Game.tile_type[19][17] = "River";
			Game.tile_type[25][17] = "Forest";
			Game.tile_type[0][18] = "River";
			Game.tile_type[0][18] = "River";
			Game.tile_type[6][18] = "River";
			Game.tile_type[17][18] = "Forest";
			Game.tile_type[19][18] = "River";
			Game.tile_type[20][18] = "River";
			Game.tile_type[23][18] = "Forest";
			Game.tile_type[6][19] = "Bridge";
			for(int j=19; j<29; j++){
				Game.tile_type[20][j] = "River";
			}
			for(int j=19; j<23; j++){
				Game.tile_type[25][j] = "River";
			}
			Game.tile_type[6][20] = "River";
			Game.tile_type[15][20] = "Forest";
			Game.tile_type[21][20] = "River";
			for(int i=6; i<11; i++){
				Game.tile_type[i][21] = "River";
			}
			for(int i=19; i<27; i++){
				Game.tile_type[i][21] = "River";
			}
			for(int i=2; i<5; i++){
				Game.tile_type[i][22] = "--";
				Game.tile_type[i][23] = "--";
				Game.tile_type[i][24] = "--";
			}
			Game.tile_type[6][22] = "Forest";
			for(int i=10; i<15; i++){
				Game.tile_type[i][22] = "River";
			}
			for(int i=19; i<29; i++){
				if(i != 21 && i != 24){
					Game.tile_type[i][22] = "River";
				}
			}
			Game.tile_type[27][22] = "Bridge";
			for(int i=14; i<17; i++){
				Game.tile_type[i][23] = "River";
			}
			Game.tile_type[20][23] = "Bridge";
			Game.tile_type[28][23] = "River";
			Game.tile_type[3][24] = "Gate";
			for(int i=11; i<14; i++){
				Game.tile_type[i][24] = "--";
				Game.tile_type[i][25] = "--";
				Game.tile_type[i][26] = "--";
			}
			Game.tile_type[17][24] = "Forest";
			Game.tile_type[18][24] = "Forest";
			Game.tile_type[21][24] = "Forest";
			for(int i=16; i<21; i++){
				Game.tile_type[i][25] = "River";
			}
			Game.tile_type[24][25] = "Peak";
			Game.tile_type[25][25] = "Peak";
			Game.tile_type[26][25] = "Peak";
			Game.tile_type[6][26] = "Forest";
			Game.tile_type[7][26] = "Forest";
			Game.tile_type[12][26] = "Gate";
			Game.tile_type[18][26] = "Forest";
			Game.tile_type[19][26] = "River";
			for(int i=25; i<29; i++){
				Game.tile_type[i][26] = "Peak";
				Game.tile_type[i][27] = "Peak";
				Game.tile_type[i][28] = "Peak";
			}
			Game.tile_type[5][27] = "Forest";
			Game.tile_type[6][27] = "Forest";
			Game.tile_type[7][27] = "Forest";
			Game.tile_type[21][28] = "River";
			Game.tile_type[24][28] = "Peak";
		}//finish with map 9
		
		else if(Game.Map == 10){
			
			UnitStats.MaxUnitNum = 12;
			
			UnitStats.AStartLocationX[0] = 2; 
			UnitStats.AStartLocationY[0] = 17;
			
			UnitStats.AStartLocationX[1] = 1;
			UnitStats.AStartLocationY[1] = 18;
			
			UnitStats.AStartLocationX[2] = 3;
			UnitStats.AStartLocationY[2] = 18;
			
			UnitStats.AStartLocationX[3] = 2;
			UnitStats.AStartLocationY[3] = 14;
			
			UnitStats.AStartLocationX[4] = 3;
			UnitStats.AStartLocationY[4] = 14;
			
			UnitStats.AStartLocationX[5] = 4;
			UnitStats.AStartLocationY[5] = 14;
			
			UnitStats.AStartLocationX[6] = 5;			
			UnitStats.AStartLocationY[6] = 14;
			
			UnitStats.AStartLocationX[7] = 12;			
			UnitStats.AStartLocationY[7] = 19;
			
			UnitStats.AStartLocationX[8] = 13;			
			UnitStats.AStartLocationY[8] = 19;
			
			UnitStats.AStartLocationX[9] = 14;			
			UnitStats.AStartLocationY[9] = 19;
			
			UnitStats.AStartLocationX[10] = 12; 
			UnitStats.AStartLocationY[10] = 20;
			
			UnitStats.AStartLocationX[11] = 13;
			UnitStats.AStartLocationY[11] = 20;
			
			
			UnitStats.EStartLocationX[0] = 21; 
			UnitStats.EStartLocationY[0] = 4; 
			
			UnitStats.EStartLocationX[1] = 22;
			UnitStats.EStartLocationY[1] = 5;
			
			UnitStats.EStartLocationX[2] = 20;
			UnitStats.EStartLocationY[2] = 5;
			
			UnitStats.EStartLocationX[3] = 17;
			UnitStats.EStartLocationY[3] = 2;
			
			UnitStats.EStartLocationX[4] = 17;
			UnitStats.EStartLocationY[4] = 3;
			
			UnitStats.EStartLocationX[5] = 17;
			UnitStats.EStartLocationY[5] = 4;
			
			UnitStats.EStartLocationX[6] = 22;
			UnitStats.EStartLocationY[6] = 9;
			
			UnitStats.EStartLocationX[7] = 23;
			UnitStats.EStartLocationY[7] = 10;
			
			UnitStats.EStartLocationX[8] = 21;
			UnitStats.EStartLocationY[8] = 10;
			
			UnitStats.EStartLocationX[9] = 19;
			UnitStats.EStartLocationY[9] = 7;
			
			UnitStats.EStartLocationX[10] = 19; 
			UnitStats.EStartLocationY[10] = 8; 
			
			UnitStats.EStartLocationX[11] = 19;
			UnitStats.EStartLocationY[11] = 9;
			
			
			Game.MaxShiftX = 5;
			Game.MaxShiftY = 6;
			for(int i=0; i<Game.GridMax_X+1; i++){
				for(int j=0; j<Game.GridMax_Y+1; j++){
					Game.tile_type[i][j] = "Plain";
				}
			}
			for(int i=3; i<6; i++){
				Game.tile_type[i][1] = "--";
				Game.tile_type[i][2] = "--";
				Game.tile_type[i][3] = "--";
			}
			Game.tile_type[13][0] = "Cliff";
			for(int i=14; i<25; i++){
				Game.tile_type[i][0] = "Lake";
			}
			Game.tile_type[9][1] = "Fort";
			Game.tile_type[10][1] = "Fort";
			Game.tile_type[15][1] = "Cliff";
			Game.tile_type[16][1] = "Cliff";
			Game.tile_type[17][1] = "Cliff";
			Game.tile_type[18][1] = "Lake";
			Game.tile_type[19][1] = "Lake";
			Game.tile_type[20][1] = "Cliff";
			Game.tile_type[21][1] = "Cliff";
			Game.tile_type[22][1] = "Cliff";
			Game.tile_type[23][1] = "Lake";
			Game.tile_type[24][1] = "Lake";
			Game.tile_type[15][2] = "Bridge";
			Game.tile_type[18][2] = "Cliff";
			Game.tile_type[19][2] = "Cliff";
			for(int i=20; i<23; i++){
				Game.tile_type[i][2] = "--";
				Game.tile_type[i][3] = "--";
				Game.tile_type[i][4] = "--";
			}
			Game.tile_type[23][2] = "Cliff";
			Game.tile_type[24][2] = "Lake";
			Game.tile_type[4][3] = "Gate";
			Game.tile_type[7][3] = "Cliff";
			Game.tile_type[8][3] = "Cliff";
			Game.tile_type[11][3] = "Cliff";
			Game.tile_type[14][3] = "Cliff";
			Game.tile_type[15][3] = "Lake";
			Game.tile_type[19][3] = "Cliff";
			Game.tile_type[24][3] = "Cliff";
			for(int j=4; j<8; j++){
				Game.tile_type[7][j] = "Lake";
				Game.tile_type[8][j] = "Lake";
			}
			Game.tile_type[9][4] = "Cliff";
			Game.tile_type[10][4] = "Cliff";
			Game.tile_type[11][4] = "Lake";
			Game.tile_type[13][4] = "Cliff";
			Game.tile_type[14][4] = "Lake";
			Game.tile_type[15][4] = "Lake";
			Game.tile_type[21][4] = "Gate";
			Game.tile_type[24][4] = "Cliff";
			Game.tile_type[0][5] = "Cliff";
			Game.tile_type[1][5] = "Cliff";
			Game.tile_type[3][5] = "Fort";
			Game.tile_type[4][5] = "Fort";
			Game.tile_type[5][5] = "Fort";
			for(int i=7; i<16; i++){
				Game.tile_type[i][5] = "Lake";
			}
			Game.tile_type[12][5] = "Cliff";
			Game.tile_type[16][5] = "Cliff";
			Game.tile_type[0][6] = "Lake";
			Game.tile_type[1][6] = "Lake";
			Game.tile_type[2][6] = "Cliff";
			Game.tile_type[6][6] = "Cliff";
			Game.tile_type[7][6] = "Lake";
			for(int i=8; i<18; i++){
				Game.tile_type[i][6] = "Lake";
				Game.tile_type[i][7] = "Lake";
				Game.tile_type[i][8] = "Lake";
			}
			Game.tile_type[17][6] = "Cliff";
			for(int i=0; i<8; i++){
				Game.tile_type[i][7] = "Lake";
			}
			Game.tile_type[3][7] = "Bridge";
			Game.tile_type[4][7] = "Bridge";
			Game.tile_type[5][7] = "Bridge";
			Game.tile_type[18][7] = "Cliff";
			for(int i=21; i<24; i++){
				Game.tile_type[i][7] = "--";
				Game.tile_type[i][8] = "--";
				Game.tile_type[i][9] = "--";
			}
			Game.tile_type[0][8] = "Cliff";
			Game.tile_type[8][8] = "Cliff";
			Game.tile_type[18][8] = "Cliff";
			for(int i=9; i<18; i++){
				Game.tile_type[i][9] = "Lake";
			}
			Game.tile_type[18][9] = "Cliff";
			Game.tile_type[22][9] = "Village";
			Game.tile_type[1][10] = "Forest";
			Game.tile_type[2][10] = "River";
			Game.tile_type[3][10] = "Bridge";
			Game.tile_type[4][10] = "Bridge";
			Game.tile_type[5][10] = "River";
			Game.tile_type[6][10] = "Forest";
			Game.tile_type[7][10] = "Forest";
			Game.tile_type[9][10] = "Lake";
			Game.tile_type[10][10] = "Lake";
			Game.tile_type[12][10] = "Cliff";
			for(int i=13; i<20; i++){
				Game.tile_type[i][10] = "Lake";
				Game.tile_type[i][11] = "Lake";
				Game.tile_type[i][12] = "Lake";
			}
			Game.tile_type[18][10] = "Cliff";
			Game.tile_type[19][10] = "Cliff";
			Game.tile_type[1][11] = "River";
			Game.tile_type[2][11] = "River";
			Game.tile_type[3][11] = "Forest";
			Game.tile_type[4][11] = "Forest";
			Game.tile_type[5][11] = "River";
			Game.tile_type[6][11] = "River";
			Game.tile_type[7][11] = "River";
			Game.tile_type[20][11] = "Cliff";
			for(int j=11; j<16; j++){
				Game.tile_type[24][j] = "Peak";
			}
			Game.tile_type[0][12] = "River";
			Game.tile_type[1][12] = "River";
			Game.tile_type[3][12] = "Forest";
			Game.tile_type[5][12] = "Forest";
			Game.tile_type[6][12] = "Forest";
			Game.tile_type[7][12] = "River";
			Game.tile_type[8][12] = "Forest";
			Game.tile_type[20][12] = "Lake";
			Game.tile_type[21][12] = "Cliff";
			Game.tile_type[23][12] = "Peak";
			Game.tile_type[0][13] = "Forest";
			Game.tile_type[2][13] = "Forest";
			Game.tile_type[4][13] = "Forest";
			Game.tile_type[5][13] = "Forest";
			Game.tile_type[7][13] = "River";
			Game.tile_type[8][13] = "River";
			Game.tile_type[9][13] = "Forest";
			Game.tile_type[10][13] = "Forest";
			for(int i=15; i<22; i++){
				Game.tile_type[i][13] = "Lake";
			}
			Game.tile_type[23][13] = "Peak";
			for(int j=14; j<21; j++){
				Game.tile_type[0][j] = "Forest";
			}
			Game.tile_type[1][14] = "Forest";
			for(int i=3; i<11; i++){
				Game.tile_type[i][14] = "Forest";
			}
			Game.tile_type[8][14] = "River";
			for(int i=15; i<20; i++){
				Game.tile_type[i][14] = "Lake";
			}
			for(int i=1; i<4; i++){
				Game.tile_type[i][15] = "--";
				Game.tile_type[i][16] = "--";
				Game.tile_type[i][17] = "--";
			}
			Game.tile_type[4][15] = "Forest";
			for(int i=6; i<12; i++){
				Game.tile_type[i][15] = "Forest";
			}
			Game.tile_type[8][15] = "River";
			Game.tile_type[9][15] = "River";
			Game.tile_type[17][15] = "Lake";
			Game.tile_type[18][15] = "Lake";
			Game.tile_type[19][15] = "Lake";
			Game.tile_type[21][15] = "Shop";
			Game.tile_type[22][15] = "Shop";
			Game.tile_type[4][16] = "Forest";
			Game.tile_type[5][16] = "Forest";
			Game.tile_type[7][16] = "Forest";
			Game.tile_type[8][16] = "Forest";
			Game.tile_type[9][16] = "River";
			Game.tile_type[10][16] = "River";
			Game.tile_type[11][16] = "Forest";
			for(int i=15; i<18; i++){
				Game.tile_type[i][16] = "River";
			}
			Game.tile_type[18][16] = "Peak";
			Game.tile_type[19][16] = "Peak";
			Game.tile_type[2][17] = "Gate";
			for(int i=6; i<13; i++){
				Game.tile_type[i][17] = "Forest";
			}
			Game.tile_type[10][17] = "River";
			for(int i=13; i<19; i++){
				Game.tile_type[i][17] = "River";
			}
			Game.tile_type[14][17] = "Bridge";
			Game.tile_type[18][17] = "Peak";
			Game.tile_type[19][17] = "Peak";
			Game.tile_type[1][18] = "Forest";
			Game.tile_type[3][18] = "Forest";
			Game.tile_type[4][18] = "Forest";
			Game.tile_type[6][18] = "Forest";
			Game.tile_type[8][18] = "Forest";
			for(int i=10; i<14; i++){
				Game.tile_type[i][18] = "River";
			}
			Game.tile_type[14][18] = "Forest";
			Game.tile_type[18][18] = "River";
			Game.tile_type[19][18] = "River";
			for(int i=20; i<23; i++){
				Game.tile_type[i][18] = "Peak";
				Game.tile_type[i][19] = "Peak";
				Game.tile_type[i][20] = "Peak";
			}
			Game.tile_type[2][19] = "Forest";
			Game.tile_type[4][19] = "Forest";
			Game.tile_type[6][19] = "Forest";
			Game.tile_type[10][19] = "Forest";
			Game.tile_type[11][19] = "Forest";
			Game.tile_type[13][19] = "Forest";
			Game.tile_type[15][19] = "Forest";
			Game.tile_type[16][19] = "Forest";
			Game.tile_type[19][19] = "River";
			Game.tile_type[1][20] = "Forest";
			Game.tile_type[3][20] = "Forest";
			Game.tile_type[5][20] = "Forest";
			Game.tile_type[7][20] = "Forest";
			Game.tile_type[8][20] = "Forest";
			Game.tile_type[9][20] = "Forest";
			Game.tile_type[11][20] = "Forest";
			Game.tile_type[12][20] = "Forest";
			Game.tile_type[14][20] = "Forest";
			Game.tile_type[16][20] = "Forest";
			Game.tile_type[17][20] = "Forest";
			Game.tile_type[19][20] = "River";
			Game.tile_type[23][20] = "Peak";
			Game.tile_type[24][20] = "Peak";
		}// finished with map 10
		
		else if(Game.Map == 11){
			
			UnitStats.MaxUnitNum = 12;
			
			UnitStats.AStartLocationX[0] = 24; 
			UnitStats.AStartLocationY[0] = 3;
			
			UnitStats.AStartLocationX[1] = 5;
			UnitStats.AStartLocationY[1] = 2;
			
			UnitStats.AStartLocationX[2] = 23;
			UnitStats.AStartLocationY[2] = 4;
			
			UnitStats.AStartLocationX[3] = 25;
			UnitStats.AStartLocationY[3] = 4;
			
			UnitStats.AStartLocationX[4] = 24;
			UnitStats.AStartLocationY[4] = 5;
			
			UnitStats.AStartLocationX[5] = 5;
			UnitStats.AStartLocationY[5] = 4;
			
			UnitStats.AStartLocationX[6] = 6;			
			UnitStats.AStartLocationY[6] = 3;
			
			UnitStats.AStartLocationX[7] = 4;			
			UnitStats.AStartLocationY[7] = 3;
			
			UnitStats.AStartLocationX[8] = 2;			
			UnitStats.AStartLocationY[8] = 5;
			
			UnitStats.AStartLocationX[9] = 10;			
			UnitStats.AStartLocationY[9] = 2;
			
			UnitStats.AStartLocationX[10] = 18; 
			UnitStats.AStartLocationY[10] = 1;
			
			UnitStats.AStartLocationX[11] = 23;
			UnitStats.AStartLocationY[11] = 8;
			
			
			UnitStats.EStartLocationX[0] = 9; 
			UnitStats.EStartLocationY[0] = 18; 
			
			UnitStats.EStartLocationX[1] = 10;
			UnitStats.EStartLocationY[1] = 19;
			
			UnitStats.EStartLocationX[2] = 8;
			UnitStats.EStartLocationY[2] = 19;
			
			UnitStats.EStartLocationX[3] = 8;
			UnitStats.EStartLocationY[3] = 17;
			
			UnitStats.EStartLocationX[4] = 10;
			UnitStats.EStartLocationY[4] = 17;
			
			UnitStats.EStartLocationX[5] = 23;
			UnitStats.EStartLocationY[5] = 26;
			
			UnitStats.EStartLocationX[6] = 22;
			UnitStats.EStartLocationY[6] = 28;
			
			UnitStats.EStartLocationX[7] = 24;
			UnitStats.EStartLocationY[7] = 28;
			
			UnitStats.EStartLocationX[8] = 25;
			UnitStats.EStartLocationY[8] = 27;
			
			UnitStats.EStartLocationX[9] = 25;
			UnitStats.EStartLocationY[9] = 25;
			
			UnitStats.EStartLocationX[10] = 21; 
			UnitStats.EStartLocationY[10] = 27; 
			
			UnitStats.EStartLocationX[11] = 9;
			UnitStats.EStartLocationY[11] = 20;
			
			Game.MaxShiftX = 8;
			Game.MaxShiftY = 15;
			for(int i=0; i<Game.GridMax_X+1; i++){
				for(int j=0; j<Game.GridMax_Y+1; j++){
					Game.tile_type[i][j] = "Plain";
				}
			}
			Game.tile_type[1][0] = "Fort";
			Game.tile_type[2][0] = "Cliff";
			Game.tile_type[11][0] = "Forest";
			Game.tile_type[12][0] = "River";
			Game.tile_type[13][0] = "River";
			Game.tile_type[15][0] = "Cliff";
			Game.tile_type[23][0] = "Cliff";
			Game.tile_type[24][0] = "Cliff";
			Game.tile_type[25][0] = "Forest";
			Game.tile_type[27][0] = "Forest";
			Game.tile_type[0][1] = "Fort";
			Game.tile_type[3][1] = "Cliff";
			for(int i=4; i<7; i++){
				Game.tile_type[i][1] = "--";
				Game.tile_type[i][2] = "--";
			}
			Game.tile_type[11][1] = "Cliff";
			Game.tile_type[13][1] = "Bridge";
			for(int i=23; i<27; i++){
				Game.tile_type[i][1] = "Forest";
			}
			Game.tile_type[5][2] = "Ruins (Village)";
			for(int i=13; i<17; i++){
				Game.tile_type[i][2] = "River";
			}
			for(int i= 17; i<21; i++){
				Game.tile_type[i][2] = "Cliff";
			}
			for(int i=23; i<26; i++){
				Game.tile_type[i][2] = "--";
				Game.tile_type[i][3] = "--";
			}
			Game.tile_type[16][3] = "River";
			Game.tile_type[17][3] = "River";
			Game.tile_type[20][3] = "Cliff";
			Game.tile_type[21][3] = "Cliff";
			Game.tile_type[24][3] = "Ruins (Village)";
			Game.tile_type[27][3] = "Forest";
			for(int i=8; i<16; i++){
				Game.tile_type[i][4] = "Peak";
				Game.tile_type[i][5] = "Peak";
				Game.tile_type[i][6] = "Peak";
				Game.tile_type[i][7] = "Peak";
			}
			Game.tile_type[16][4] = "Peak";
			Game.tile_type[17][4] = "River";
			Game.tile_type[18][4] = "River";
			Game.tile_type[22][4] = "Forest";
			Game.tile_type[26][4] = "Forest";
			for(int j=5; j<10; j++){
				Game.tile_type[6][j] = "Peak";
				Game.tile_type[7][j] = "Peak";
				Game.tile_type[8][j] = "Peak";
			}
			Game.tile_type[9][8] = "Peak";
			Game.tile_type[16][5] = "Peak";
			Game.tile_type[18][5] = "River";
			Game.tile_type[20][5] = "Mountain";
			Game.tile_type[21][5] = "Forest";
			Game.tile_type[25][5] = "Forest";
			Game.tile_type[26][5] = "Forest";
			Game.tile_type[4][6] = "Peak";
			for(int j=6; j<10; j++){
				Game.tile_type[6][j] = "Peak";
			}
			Game.tile_type[18][6] = "River";
			for(int i=19; i<22; i++){
				Game.tile_type[i][6] = "Peak";
				Game.tile_type[i][7] = "Peak";
			}
			Game.tile_type[24][6] = "Fort";
			Game.tile_type[25][6] = "Forest";
			Game.tile_type[27][6] = "Forest";
			Game.tile_type[15][7] = "Forest";
			Game.tile_type[17][7] = "River";
			Game.tile_type[18][7] = "River";
			Game.tile_type[27][7] = "Forest";
			Game.tile_type[3][8] = "Peak";
			Game.tile_type[4][8] = "Peak";
			for(int i=10; i<13; i++){
				Game.tile_type[i][8] = "--";
				Game.tile_type[i][9] = "--";
			}
			Game.tile_type[17][8] = "River";
			for(int i=18; i<21; i++){
				Game.tile_type[i][8] = "Peak";
				Game.tile_type[i][9] = "Peak";
			}
			for(int i=25; i<28; i++){
				Game.tile_type[i][8] = "Forest";
			}
			for(int i=0; i<5; i++){
				Game.tile_type[i][9] = "River";
			}
			Game.tile_type[1][9] = "Bridge";
			Game.tile_type[11][9] = "Ruins (Village)";
			Game.tile_type[15][9] = "River";
			Game.tile_type[16][9] = "Bridge";
			Game.tile_type[17][9] = "River";
			Game.tile_type[18][9] = "River";
			Game.tile_type[22][9] = "Forest";
			Game.tile_type[25][9] = "Forest";
			Game.tile_type[27][9] = "Forest";
			for(int i=4; i<8; i++){
				Game.tile_type[i][10] = "River";
			}
			Game.tile_type[14][10] = "River";
			Game.tile_type[15][10] = "River";
			Game.tile_type[18][10] = "River";
			Game.tile_type[19][10] = "River";
			Game.tile_type[24][10] = "Forest";
			Game.tile_type[26][10] = "Forest";
			Game.tile_type[1][11] = "Forest";
			for(int i=7; i<11; i++){
				Game.tile_type[i][11] = "River";
			}
			Game.tile_type[12][11] = "Forest";
			Game.tile_type[13][11] = "River";
			Game.tile_type[14][11] = "River";
			Game.tile_type[15][11] = "Forest";
			for(int i=19; i<24; i++){
				Game.tile_type[i][11] = "River";
			}
			Game.tile_type[24][11] = "Forest";
			for(int i=8; i<11; i++){
				Game.tile_type[i][12] = "Peak";
				Game.tile_type[i][13] = "Peak";
				Game.tile_type[i][14] = "Peak";
				Game.tile_type[i][15] = "Peak";
			}
			for(int i=11; i<15; i++){
				Game.tile_type[i][12] = "River";
			}
			Game.tile_type[20][12] = "Forest";
			Game.tile_type[21][12] = "Forest";
			Game.tile_type[22][12] = "Forest";
			Game.tile_type[23][12] = "River";
			Game.tile_type[24][12] = "Bridge";
			Game.tile_type[25][12] = "River";
			Game.tile_type[26][12] = "Forest";
			Game.tile_type[27][12] = "Peak";
			for(int j=13; j<16; j++){
				Game.tile_type[6][j] = "Peak";
				Game.tile_type[7][j] = "Peak";
			}
			Game.tile_type[10][13] = "Peak";
			Game.tile_type[16][13] = "Fort";
			for(int i=19; i<26; i++){
				Game.tile_type[i][13] = "Forest";
				Game.tile_type[i][14] = "Forest";
			}
			for(int i=25; i<28; i++){
				Game.tile_type[i][13] = "River";
			}
			for(int j=14; j<18; j++){
				Game.tile_type[5][j] = "Peak";
			}
			Game.tile_type[10][14] = "Forest";
			Game.tile_type[11][14] = "Fort";
			Game.tile_type[13][14] = "Forest";
			Game.tile_type[14][14] = "Forest";
			for(int j=14; j<17; j++){
				Game.tile_type[27][j] = "Peak";
			}
			Game.tile_type[1][15] = "Forest";
			for(int j=15; j<20; j++){
				Game.tile_type[3][j] = "Peak";
				Game.tile_type[4][j] = "Peak";
			}
			Game.tile_type[12][15] = "Fort";
			for(int i=13; i<16; i++){
				Game.tile_type[i][15] = "Peak";
				Game.tile_type[i][16] = "Peak";
			}
			for(int i=18; i<23; i++){
				Game.tile_type[i][15] = "Forest";
			}
			for(int j=15; j<18; j++){
				Game.tile_type[25][j] = "Peak";
				Game.tile_type[26][j] = "Peak";
			}
			Game.tile_type[0][16] = "Forest";
			for(int j=16; j<20; j++){
				Game.tile_type[2][j] = "Peak";
			}
			Game.tile_type[8][16] = "Forest";
			for(int j=16; j<22; j++){
				Game.tile_type[15][j] = "Peak";
				Game.tile_type[16][j] = "Peak";
			}
			for(int i=17; i<22; i++){
				Game.tile_type[i][16] = "Forest";
			}
			Game.tile_type[0][17] = "Forest";
			Game.tile_type[7][17] = "Peak";
			Game.tile_type[14][17] = "Peak";
			for(int j=17; j<23; j++){
				Game.tile_type[17][j] = "Peak";
			}
			for(int i=18; i<22; i++){
				Game.tile_type[i][17] = "Forest";
			}
			Game.tile_type[9][18] = "Forest";
			Game.tile_type[18][18] = "Peak";
			Game.tile_type[19][18] = "Forest";
			Game.tile_type[27][18] = "Mountain";
			Game.tile_type[1][19] = "Forest";
			Game.tile_type[10][19] = "Forest";
			for(int j=19; j<22; j++){
				Game.tile_type[14][j] = "Peak";
			}
			for(int j=19; j<24; j++){
				Game.tile_type[18][j] = "Peak";
				Game.tile_type[19][j] = "Peak";
				Game.tile_type[20][j] = "Peak";
				Game.tile_type[21][j] = "Peak";
				Game.tile_type[22][j] = "Peak";
			}
			Game.tile_type[4][20] = "Fort";
			Game.tile_type[13][20] = "Mountain";
			Game.tile_type[23][20] = "Forest";
			Game.tile_type[26][20] = "Cliff";
			Game.tile_type[5][21] = "Fort";
			for(int j=21; j<26; j++){
				Game.tile_type[6][j] = "Peak";
				Game.tile_type[7][j] = "Peak";
				Game.tile_type[8][j] = "Peak";
			}
			Game.tile_type[11][21] = "Mountain";
			Game.tile_type[12][21] = "Mountain";
			Game.tile_type[13][21] = "Mountain";
			Game.tile_type[26][21] = "Forest";
			Game.tile_type[27][21] = "Cliff";
			Game.tile_type[5][22] = "Peak";
			for(int i=9; i<12; i++){
				Game.tile_type[i][22] = "Peak";
				Game.tile_type[i][23] = "Peak";
				Game.tile_type[i][24] = "Peak";
			}
			Game.tile_type[5][23] = "Forest";
			Game.tile_type[11][24] = "Forest";
			for(int i=19; i<25; i++){
				Game.tile_type[i][24] = "Peak";
			}
			Game.tile_type[26][24] = "Forest";
			Game.tile_type[6][25] = "Forest";
			Game.tile_type[10][25] = "Forest";
			for(int j=25; j<30; j++){
				Game.tile_type[13][j] = "Peak";
				Game.tile_type[14][j] = "Peak";
				Game.tile_type[15][j] = "Peak";
			}
			Game.tile_type[16][25] = "Peak";
			Game.tile_type[20][25] = "Peak";
			Game.tile_type[21][25] = "Peak";
			for(int i=22; i<25; i++){
				Game.tile_type[i][25] = "--";
				Game.tile_type[i][26] = "--";
			}
			Game.tile_type[1][26] = "Forest";
			Game.tile_type[8][26] = "Forest";
			Game.tile_type[9][26] = "Forest";
			Game.tile_type[16][26] = "Peak";
			Game.tile_type[21][26] = "Peak";
			Game.tile_type[23][26] = "Ruins (Village)";
			Game.tile_type[3][27] = "Forest";
			Game.tile_type[25][27] = "Forest";
			Game.tile_type[4][28] = "Forest";
			Game.tile_type[12][28] = "Peak";
			Game.tile_type[22][28] = "Forest";
			Game.tile_type[25][28] = "Forest";
			Game.tile_type[27][28] = "Fort";
			Game.tile_type[12][29] = "Peak";
			Game.tile_type[19][29] = "Forest";
			Game.tile_type[24][29] = "Forest";
			Game.tile_type[26][29] = "Fort";
			
		}//finished with map 11
		
		else if(Game.Map == 12){
			
UnitStats.MaxUnitNum = 14;
			
			UnitStats.AStartLocationX[0] = 16; 
			UnitStats.AStartLocationY[0] = 10;
			
			UnitStats.AStartLocationX[1] = 15;
			UnitStats.AStartLocationY[1] = 11;
			
			UnitStats.AStartLocationX[2] = 17;
			UnitStats.AStartLocationY[2] = 11;
			
			UnitStats.AStartLocationX[3] = 15;
			UnitStats.AStartLocationY[3] = 15;
			
			UnitStats.AStartLocationX[4] = 16;
			UnitStats.AStartLocationY[4] = 15;
			
			UnitStats.AStartLocationX[5] = 17;
			UnitStats.AStartLocationY[5] = 15;
			
			UnitStats.AStartLocationX[6] = 8;			
			UnitStats.AStartLocationY[6] = 17;
			
			UnitStats.AStartLocationX[7] = 9;			
			UnitStats.AStartLocationY[7] = 17;
			
			UnitStats.AStartLocationX[8] = 7;			
			UnitStats.AStartLocationY[8] = 5;
			
			UnitStats.AStartLocationX[9] = 8;			
			UnitStats.AStartLocationY[9] = 5;
			
			UnitStats.AStartLocationX[10] = 13; 
			UnitStats.AStartLocationY[10] = 5;
			
			UnitStats.AStartLocationX[11] = 19;
			UnitStats.AStartLocationY[11] = 5;
			
			UnitStats.AStartLocationX[12] = 7;
			UnitStats.AStartLocationY[12] = 14;
			
			UnitStats.AStartLocationX[13] = 8;
			UnitStats.AStartLocationY[13] = 14;
			
			
			UnitStats.EStartLocationX[0] = 0; 
			UnitStats.EStartLocationY[0] = 23; 
			
			UnitStats.EStartLocationX[1] = 1;
			UnitStats.EStartLocationY[1] = 24;
			
			UnitStats.EStartLocationX[2] = 2;
			UnitStats.EStartLocationY[2] = 23;
			
			UnitStats.EStartLocationX[3] = 28;
			UnitStats.EStartLocationY[3] = 0;
			
			UnitStats.EStartLocationX[4] = 27;
			UnitStats.EStartLocationY[4] = 0;
			
			UnitStats.EStartLocationX[5] = 28;
			UnitStats.EStartLocationY[5] = 1;
			
			UnitStats.EStartLocationX[6] = 27;
			UnitStats.EStartLocationY[6] = 2;
			
			UnitStats.EStartLocationX[7] = 15;
			UnitStats.EStartLocationY[7] = 24;
			
			UnitStats.EStartLocationX[8] = 14;
			UnitStats.EStartLocationY[8] = 23;
			
			UnitStats.EStartLocationX[9] = 16;
			UnitStats.EStartLocationY[9] = 23;
			
			UnitStats.EStartLocationX[10] = 25; 
			UnitStats.EStartLocationY[10] = 2; 
			
			UnitStats.EStartLocationX[11] = 3;
			UnitStats.EStartLocationY[11] = 23;
			
			UnitStats.EStartLocationX[12] = 16;
			UnitStats.EStartLocationY[12] = 23;
			
			UnitStats.EStartLocationX[13] = 26;
			UnitStats.EStartLocationY[13] = 3;
			
			Game.MaxShiftX = 8;
			Game.MaxShiftY = 15;
			for(int i=0; i<Game.GridMax_X+1; i++){
				for(int j=0; j<Game.GridMax_Y+1; j++){
					Game.tile_type[i][j] = "Floor";
				}
			}
			for(int j=0; j<4; j++){
				Game.tile_type[0][j] = "Plain";
			}
			for(int j=0; j<4; j++){
				Game.tile_type[1][j] = "Wall";
			}
			for(int i=2; i<25; i++){
				Game.tile_type[i][0] = "Wall";
				Game.tile_type[i][1] = "Wall";
			}
			for(int j=0; j<5; j++){
				Game.tile_type[25][j] = "Plain";
				Game.tile_type[26][j] = "Plain";
				Game.tile_type[27][j] = "Plain";
				Game.tile_type[28][j] = "Plain";
			}
			for(int j=5; j<8; j++){
				Game.tile_type[28][j] = "Plain";
			}
			for(int j=2; j<5; j++){
				Game.tile_type[23][j] = "Stairs";
				Game.tile_type[24][j] = "Stairs";
			}
			for(int j=4; j<16; j++){
				Game.tile_type[0][j] = "Wall";
				Game.tile_type[6][j] = "Wall";
			}
			for(int j=4; j<6; j++){
				Game.tile_type[1][j] = "Wall";
				Game.tile_type[2][j] = "Wall";
				Game.tile_type[4][j] = "Wall";
				Game.tile_type[5][j] = "Wall";
			}
			for(int i=10; i<23; i++){
				Game.tile_type[i][4] = "Wall";
			}
			Game.tile_type[9][5] = "Wall";
			Game.tile_type[10][5] = "Wall";
			Game.tile_type[13][5] = "Stairs";
			Game.tile_type[22][5] = "Wall";
			for(int i=23; i<27; i++){
				Game.tile_type[i][5] = "Wall";
				Game.tile_type[i][6] = "Wall";
			}
			Game.tile_type[9][6] = "Wall";
			for(int i=14; i<19; i++){
				Game.tile_type[i][6] = "Wall";
				Game.tile_type[i][7] = "Wall";
				Game.tile_type[i][8] = "Wall";
				Game.tile_type[i][9] = "Wall";
			}
			Game.tile_type[16][9] = "--";
			for(int j=7; j<10; j++){
				Game.tile_type[9][j] = "Wall";
				Game.tile_type[12][j] = "Wall";
				Game.tile_type[13][j] = "Wall";
				Game.tile_type[19][j] = "Wall";
				Game.tile_type[20][j] = "Wall";
				Game.tile_type[23][j] = "Wall";
			}
			Game.tile_type[27][7] = "Wall";
			Game.tile_type[4][8] = "Stairs";
			for(int j=8; j<10; j++){
				Game.tile_type[10][j] = "Stairs";
				Game.tile_type[11][j] = "Stairs";
				Game.tile_type[21][j] = "Stairs";
				Game.tile_type[22][j] = "Stairs";
			}
			for(int j=8; j<20; j++){
				Game.tile_type[25][j] = "Wall";
				Game.tile_type[28][j] = "Wall";
			}
			Game.tile_type[26][8] = "Wall";
			Game.tile_type[27][8] = "Wall";
			for(int j=9; j<11; j++){
				Game.tile_type[1][j] = "Wall";
				Game.tile_type[2][j] = "Wall";
				Game.tile_type[3][j] = "Wall";
				Game.tile_type[4][j] = "Wall";
				Game.tile_type[5][j] = "Wall";
			}
			Game.tile_type[16][10] = "Throne";
			for(int j=11; j<13; j++){
				Game.tile_type[10][j] = "Wall";
				Game.tile_type[11][j] = "Wall";
				Game.tile_type[12][j] = "Wall";
				Game.tile_type[20][j] = "Wall";
				Game.tile_type[21][j] = "Wall";
				Game.tile_type[22][j] = "Wall";
			}
			for(int j=12; j<14; j++){
				Game.tile_type[13][j] = "Wall";
				Game.tile_type[19][j] = "Wall";
			}
			for(int j=14; j<16; j++){
				Game.tile_type[0][j] = "Wall";
				Game.tile_type[1][j] = "Wall";
				Game.tile_type[2][j] = "Wall";
				Game.tile_type[4][j] = "Wall";
				Game.tile_type[5][j] = "Wall";
				Game.tile_type[6][j] = "Wall";
				Game.tile_type[14][j] = "Wall";
				Game.tile_type[18][j] = "Wall";
			}
			Game.tile_type[10][15] = "Pillar";
			Game.tile_type[12][15] = "Pillar";
			Game.tile_type[15][15] = "Stairs";
			Game.tile_type[16][15] = "Stairs";
			Game.tile_type[17][15] = "Stairs";
			Game.tile_type[20][15] = "Pillar";
			Game.tile_type[22][15] = "Pillar";
			for(int j=18; j<22; j++){
				Game.tile_type[0][j] = "Wall";
				Game.tile_type[1][j] = "Wall";
				Game.tile_type[2][j] = "Wall";
				Game.tile_type[3][j] = "Wall";
				Game.tile_type[14][j] = "Wall";
				Game.tile_type[15][j] = "Wall";
				Game.tile_type[16][j] = "Wall";
			}
			for(int i=4; i<8; i++){
				Game.tile_type[i][18] = "Wall";
				Game.tile_type[i][19] = "Wall";
			}
			for(int i=10; i<14; i++){
				Game.tile_type[i][18] = "Wall";
				Game.tile_type[i][19] = "Wall";
			}
			Game.tile_type[4][20] = "Wall";
			Game.tile_type[5][20] = "Wall";
			Game.tile_type[12][20] = "Wall";
			Game.tile_type[13][20] = "Wall";
			for(int j=18; j<25; j++){
				Game.tile_type[17][j] = "Wall";
			}
			Game.tile_type[20][18] = "Wall";
			Game.tile_type[22][18] = "Wall";
			Game.tile_type[26][19] = "Stairs";
			Game.tile_type[27][19] = "Stairs";
			Game.tile_type[4][21] = "Stairs";
			Game.tile_type[5][21] = "Stairs";
			Game.tile_type[12][21] = "Stairs";
			Game.tile_type[13][21] = "Stairs";
			Game.tile_type[4][22] = "Stairs";
			Game.tile_type[5][22] = "Stairs";
			Game.tile_type[12][22] = "Stairs";
			Game.tile_type[13][22] = "Stairs";
			Game.tile_type[4][23] = "Stairs";
			Game.tile_type[13][23] = "Stairs";
			for(int j=21; j<25; j++){
				Game.tile_type[18][j] = "Wall";
				Game.tile_type[19][j] = "Wall";
			}
			Game.tile_type[4][24] = "Wall";
			Game.tile_type[13][24] = "Wall";
			for(int i=5; i<13; i++){
				Game.tile_type[i][23] = "Wall";
				Game.tile_type[i][24] = "Wall";
			}
			for(int i=19; i<29; i++){
				Game.tile_type[i][23] = "Wall";
				Game.tile_type[i][24] = "Wall";
			}
			
		}
		
		
		
		
	}
	
	static int determineMvmt(int h){
			for(int i=0; i<Game.GridMax_X+1; i++){
				for(int j=0; j<Game.GridMax_Y+1; j++){
					if(Game.tile_type[i][j] == "Plain" || Game.tile_type[i][j] == "Floor" || Game.tile_type[i][j] == "Bridge" || Game.tile_type[i][j] == "Shop" || Game.tile_type[i][j] == "Ruins" || Game.tile_type[i][j] == "House" || Game.tile_type[i][j] == "Stairs" || Game.tile_type[i][j] == "Village" || Game.tile_type[i][j] == "Flat" || Game.tile_type[i][j] == "Throne" || Game.tile_type[i][j] == "Wasteland"){
						Game.terrain[h][i][j] = 1;
					}
					else if(Game.tile_type[i][j] == "Fort"){
						if(h == Game.WyvernLord || h == Game.FalconKnight){
							Game.terrain[h][i][j] = 1;
						}
						else{
							Game.terrain[h][i][j] = 2;
						}
					}
					else if(Game.tile_type[i][j] == "Forest" || Game.tile_type[i][j] == "Pillar"){
						if(h == Game.WyvernLord || h == Game.FalconKnight){
							Game.terrain[h][i][j] = 1;
						}
						else if(h == Game.Paladin || h == Game.Valkyrie){
							Game.terrain[h][i][j] = 3;
						}
						else{
							Game.terrain[h][i][j] = 2;
						}
					}
					else if(Game.tile_type[i][j] == "Cliff" || Game.tile_type[i][j] == "--" || Game.tile_type[i][j] == "Valley"){
						if(h == Game.WyvernLord || h == Game.FalconKnight){
							Game.terrain[h][i][j] = 1;
						}
						else{
							Game.terrain[h][i][j] = 99;
						}
					}
					else if(Game.tile_type[i][j] == "River"){
						if(h == Game.WyvernLord || h == Game.FalconKnight){
							Game.terrain[h][i][j] = 1;
						}
						else if(h == Game.Hero || h == Game.Sniper || h == Game.Swordmaster){
							Game.terrain[h][i][j] = 5;
						}
						else{
							Game.terrain[h][i][j] = 99;
						}
					}
					else if(Game.tile_type[i][j] == "Lake"){
						if(h == Game.WyvernLord || h == Game.FalconKnight){
							Game.terrain[h][i][j] = 1;
						}
						else{
							Game.terrain[h][i][j] = 99;
						}
					}
					else if(Game.tile_type[i][j] == "Sea"){
						if(h == Game.WyvernLord || h == Game.FalconKnight){
							Game.terrain[h][i][j] = 1;
						}
						else{
							Game.terrain[h][i][j] = 99;
						}
					}
					else if(Game.tile_type[i][j] == "Mountain"){
						if(h == Game.WyvernLord || h == Game.FalconKnight){
							Game.terrain[h][i][j] = 1;
						}
						else if(h == Game.Sage || h == Game.Hero || h == Game.Sniper || h == Game.Swordmaster){
							Game.terrain[h][i][j] = 4;
						}
						else if(h == Game.Paladin){
							Game.terrain[h][i][j] = 6;
						}
						else{
							Game.terrain[h][i][j] = 99;
						}
					}
					else if(Game.tile_type[i][j] == "Peak"){
						if(h == Game.WyvernLord || h == Game.FalconKnight){
							Game.terrain[h][i][j] = 1;
						}
						else{
							Game.terrain[h][i][j] = 99;
						}
					}
					else if(Game.tile_type[i][j] == "Desert"){
						if(h == Game.WyvernLord || h == Game.FalconKnight || h == Game.Sage || h == Game.Druid || h == Game.Bishop){
							Game.terrain[h][i][j] = 1;
						}
						else if(h == Game.Hero || h == Game.Sniper || h == Game.Swordmaster){
							Game.terrain[h][i][j] = 2;
						}
						else if(h == Game.Paladin || h == Game.Valkyrie){
							Game.terrain[h][i][j] = 4;
						}
						else if(h == Game.General){
							Game.terrain[h][i][j] = 3;
						}
					}
					else if(Game.tile_type[i][j] == "Wall"){
						Game.terrain[h][i][j] = 99;
					}
				}
			}
		return(0);
	}
	static int getTerrainBonus(String terr, int bonType){ //tile_type[square(CursorH)][square(CurosrV)]; 0: Def 1:Avoid 2:Heal
		int defB = 0;
		int avdB = 0;
		int healB = 0;
		switch(terr){
			case "--":
				break;
			case "Arena": 
				defB = 0;
				avdB = 10;
				healB = 0;
				break;
			case "Bridge":
				break;
			case "Cliff":
				break;
			case "Deck":
				break;
			case "Desert":
				defB = 0;
				avdB = 5;
				healB = 0;
				break;
			case "Door":
				break;
			case "Fence":
				break;
			case "Floor":
				break;
			case "Forest":
				defB = 1;
				avdB = 20;
				healB = 0;
				break;
			case "Fort":
				defB = 2;
				avdB = 20;
				healB = 20;
				break;
			case "Flat":
				break;
			case "Gate":
				defB = 2;
				avdB = 20;
				healB = 10;
				break;
			case "House":
				defB = 0;
				avdB = 10;
				healB = 0;
				break;
			case "Lake":
				defB = 0;
				avdB = 10;
				healB = 0;
				break;
			case "Mountain":
				defB = 1;
				avdB = 30;
				healB = 0;
				break;
			case "Peak":
				defB = 2;
				avdB = 40;
				healB = 0;
				break;
			case "Pillar":
				defB = 1;
				avdB = 20;
				healB = 0;
				break;
			case "Plain":
				break;
			case "River":
				break;
			case "Road":
				break;
			case "Ruins":
				defB = 0;
				avdB = 10;
				healB = 0;
				break;
			case "Ruins (Village)":
				break;
			case "Sand":
				defB = 0;
				avdB = 5;
				healB = 0;
				break;
			case "Sea":
				defB = 0;
				avdB = 10;
				healB = 0;
				break;
			case "Shop":
				defB = 0;
				avdB = 10;
				healB = 0;
				break;
			case "Snag":
				break;
			case "Stairs":
				break;
			case "Throne":
				defB = 2;
				avdB = 20;
				healB = 10;
				break;
			case "Valley":
				healB = -10;
				break;
			case "Village":
				defB = 0;
				avdB = 10;
				healB = 0;
				break;
			case "Wall":
				break;
			case "Wall (Weak)":
				break;
			case "Wasteland":
				break;
			default:
				break;
		}
		int retData = 0;
		if(bonType == 0){
			retData = defB;
		} else if(bonType == 1){
			retData = avdB;
		} else if(bonType == 2){
			retData = healB;
		}
		return(retData);
	}
}
