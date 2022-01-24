//インポート
import gameCanvasUtil.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class CalculatePath{
	static boolean visited[][] = new boolean[Game.GridMax_X+1][Game.GridMax_Y+1];
	static ArrayList closed = new ArrayList();
	static Possibilities open = new Possibilities();
	static Node[][] nodes;
	static int MaxIndex;
	static int MARange = 0;
	
	static int pathColor(int Unit, int CH, int CV, int MvmtCap){
		for(int i=0; i<15; i++){
			Game.pathX[i] = CH;
			Game.pathY[i] = CV;
		}
		
		for(int i=-MvmtCap; i<=MvmtCap; i++){
			for(int j=-MvmtCap; j<=MvmtCap; j++){
				if(Math.abs(i)+Math.abs(j) <= MvmtCap){
					if(i+CH >= 0 && j+CV <= Game.GridMax_Y && i+CH <= Game.GridMax_X && j+CV <= Game.GridMax_Y && i+CH <= Game.GridMax_X && j+CV >= 0 && i+CH >= 0 && j+CV >= 0){
						//System.out.println("" + Unit  + ", " + CH + ", " + CV + ", " + (i+CH) + ", " + (j+CV));
						if(CH+1 >= 0 && CH-1 <= Game.GridMax_X && CV+1 >= 0 && CV-1<= Game.GridMax_Y){
							findPath(Unit, CH, CV, i+CH, j+CV, MvmtCap);
							setColor();
						}
					}
				}
			}
		}
		//System.out.println(Game.GridMax_X + ", " + Game.GridMax_Y);
		/*for(int i=-1; i>=-MvmtCap; i--){//bottom-left
			for(int j=0; j<=MvmtCap+i; j++){
				if(i+CH >= 0 && j+CV <= Game.GridMax_Y){
					System.out.println("" + Unit  + ", " + CH + ", " + CV + ", " + (i+CH) + ", " + (j+CV));
					findPath(Unit, CH, CV, i+CH, j+CV, MvmtCap);
					setColor();
					//System.out.println("coloredBL");
				}
			}
		}
		for(int i=0; i<=MvmtCap; i++){//bottom-right
			for(int j=0; j<=MvmtCap-i; j++){
				if(i+CH <= Game.GridMax_X && j+CV <= Game.GridMax_Y){
					findPath(Unit, CH, CV, i+CH, j+CV, MvmtCap);
					setColor();
					//System.out.println("coloredBR");
				}
			}
		}
		for(int i=0; i<=MvmtCap; i++){//top-right
			for(int j=-1; j>=-(MvmtCap-i); j--){
				if(i+CH <= Game.GridMax_X && j+CV >= 0){
					findPath(Unit, CH, CV, i+CH, j+CV, MvmtCap);
					setColor();
					//System.out.println("coloredTR");
				}
			}
		}
		for(int i=-1; i>=-MvmtCap; i--){//top-left
			for(int j=-1; j>=-(MvmtCap+i); j--){
				if(i+CH >= 0 && j+CV >= 0){
					findPath(Unit, CH, CV, i+CH, j+CV, MvmtCap);
					setColor();
					//System.out.println("coloredTL");
				}
			}
		}*/
		for(int i=0; i<15; i++){
			Game.pathX[i] = 70;
			Game.pathY[i] = 70;
		}
		//System.out.println("working");
		return(0);
	}
	static void setColor(){
		for(int i=0; i<=MaxIndex; i++){
			if(Game.select_grid[(Game.pathX[i])][(Game.pathY[i])] != Game.BLUE){
				Game.select_grid[(Game.pathX[i])][(Game.pathY[i])] = Game.BLUE;
				for(int x=-MARange; x <=MARange; x++){
					for(int y=-MARange; y<=MARange; y++){
						if(Math.abs(x) + Math.abs(y) <= MARange){
							if(Game.select_grid[(Game.pathX[i])][(Game.pathY[i])] == Game.BLUE){
								if(Game.pathX[i] + x >= 0 && Game.pathX[i] + x <= Game.GridMax_X && Game.pathY[i] + y >= 0 && Game.pathY[i] + y <= Game.GridMax_Y){
									if(Game.select_grid[(Game.pathX[i])+x][(Game.pathY[i])+y] != Game.BLUE){
										Game.select_grid[(Game.pathX[i])+x][(Game.pathY[i])+y] = Game.RED;
									}
								}
							}
						}
					}
				}
			}
		}
	}
	/**Unit = Unit Class Number 
	 * CX = Current X
	 * CY = Current Y
	 * TX = Target X
	 * TY = Target Y **/
	static double heuECalc(int CX, int CY, int TX, int TY){
		double heuE;
		double edx, edy;
		edx = TX * 1.0 - CX * 1.0;
		edy = TY * 1.0 - CY * 1.0;
		//Figure Euclidean Distance
		heuE = Math.sqrt((edx * edx) + (edy * edy));
		return(heuE);
	}
	static int heuMCalc(int CX, int CY, int TX, int TY){
		int heuM;
		int mdx, mdy;
		mdx = TX - CX;
		mdy = TY - CY;
		heuM = Math.abs(mdx)+Math.abs(mdy);
		return(heuM);
	}
	static int heuCalc(int Unit, int CX, int CY, int TX, int TY){
		int heuC = 0;
		int hdx, hdy;
		//Figure the Distances
		hdx = TX - CX;
		hdy = TY - CY;
		//Find Heuristic Distance
		if(hdx > 0){//Right
			for(int i=1; i<=hdx; i++){
				heuC+=Game.terrain[Unit][CX+i][CY];
			}
		}
		else if(hdx < 0){//Left
			for(int i=-1; i>=hdx; i--){
				heuC+=Game.terrain[Unit][CX+i][CY];
			}
		}
		if(hdy > 0){//Down
			for(int i=1; i<=hdy; i++){
				heuC+=Game.terrain[Unit][CX][CY+i];
			}
		}
		else if(hdy < 0){//Up
			for(int i=-1; i>=hdy; i--){
				heuC+=Game.terrain[Unit][CX][CY+i];
			}
		}
		return(heuC);
	}
	
	static void showArrow(int UIndex, int TX, int TY, int CX, int CY){
		if(Game.select_grid[TX][TY] == Game.BLUE){
			if(Game.turn == Game.Ally){
				findPath(Game.AClassNum[UIndex], CX, CY, TX, TY, Game.AStats[UIndex][7]);
			}
			else if(Game.turn == Game.Enemy){
				findPath(Game.EClassNum[UIndex], CX, CY, TX, TY, Game.EStats[UIndex][7]);
			}
		}
	}
	
	/** Main Algorithm**/
	static public boolean findPath(int Unit, int CX, int CY, int TX, int TY, int MvmMax){
		boolean found;
		if(Game.terrain[Unit][TX][TY] > 50 || Game.occupied[TX][TY] == Game.Enemy && Game.SelectedSide == Game.Ally || Game.occupied[TX][TY] == Game.Ally && Game.SelectedSide == Game.Enemy){
			found = false;
		}
		else{
			int testX = 16;
			int testY = 4;
			/*if(TX == testX && TY == testY){
				System.out.println(TX + ", " + TY + ", " + MvmMax);
			}//*/
			nodes = new Node[Game.GridMax_X+1][Game.GridMax_Y+1];
			for (int i=0; i<=Game.GridMax_X; i++) {
				for (int j=0; j<=Game.GridMax_Y; j++) {
					nodes[i][j] = new Node(i,j);
				}
			}
			for(int i=0; i<=Game.GridMax_X; i++){
				for(int j=0; j<=Game.GridMax_Y; j++){
					visited[i][j] = false;
				}
			}
			for(int i=0; i<15; i++){
				Game.pathDirection[i] = "---";
			}
			nodes[CX][CY].G = 0;
			nodes[CX][CY].MvCost = 0;
			closed.clear();
			open.clear();
			//System.out.println(CX + ", " + CY);
			open.add(nodes[CX][CY]);
			visited[CX][CY] = true;
			int CostMax = 0;
			//System.out.println("coord: " + CX + ", " + CY );
			if((CX+1 > Game.GridMax_X || Game.terrain[Unit][CX+1][CY] > 50 || Game.occupied[CX+1][CY] == Game.Enemy && Game.SelectedSide == Game.Ally || Game.occupied[CX+1][CY] == Game.Ally && Game.SelectedSide == Game.Enemy)
					&& (CX - 1 < 0 || Game.terrain[Unit][CX-1][CY] > 50 || Game.occupied[CX-1][CY] == Game.Enemy && Game.SelectedSide == Game.Ally || Game.occupied[CX-1][CY] == Game.Ally && Game.SelectedSide == Game.Enemy)
					&& (CY + 1 > Game.GridMax_Y || Game.terrain[Unit][CX][CY+1] > 50 || Game.occupied[CX][CY+1] == Game.Enemy && Game.SelectedSide == Game.Ally || Game.occupied[CX][CY+1] == Game.Ally && Game.SelectedSide == Game.Enemy)
					&& (CY -1 <0 || Game.terrain[Unit][CX][CY-1] > 50 || Game.occupied[CX][CY-1] == Game.Enemy && Game.SelectedSide == Game.Ally || Game.occupied[CX][CY-1] == Game.Ally && Game.SelectedSide == Game.Enemy)){
				for(int i=0; i<15; i++){
					Game.pathX[i] = CX;
					Game.pathY[i] = CY;
				}
				CostMax = MvmMax + 1;
				found = false;
			}
			//Searching
			while(CostMax < MvmMax){
				//System.out.println(Game.SelectedSide);
				/*if(TX == testX && TY == testY){
					System.out.println("Starting");
				}//*/
				Node current = getFirstOpen();
				if(current == nodes[TX][TY]){
					/*if(TX == testX && TY == testY){
						System.out.println("breaked");
					}//*/
					break;
				}
				removeFromOpen(current);
				/*if(TX == testX && TY == testY){
					System.out.println("Current: " + current.x + ", " + current.y);
				}//*/
				addToClosed(current);
				/*if(TX == testX && TY == testY){
					System.out.println("going");
				}//*/
				
				//Check the squares around the current node
				for(int p=-1; p<2; p++){
					for(int q=-1; q<2; q++){
						if((p==0 && q==0)||(p!=0 && q!=0)){
							continue;
						}
						int nx = current.x + p;
						int ny = current.y + q;
						
						if(nx >= 0 && ny >= 0 && nx <= Game.GridMax_X && ny <= Game.GridMax_Y && Game.terrain[Unit][nx][ny] < 50){
							if((Game.occupied[nx][ny] != Game.Enemy && Game.SelectedSide == Game.Ally) || (Game.occupied[nx][ny] != Game.Ally && Game.SelectedSide == Game.Enemy)){
								int NextCost = current.G + Game.terrain[Unit][nx][ny];
								//System.out.println("Data: " + nx + ", " + ny + ", " + current.G + ", " + Game.terrain[Unit][nx][ny]);
								Node adjacent = nodes[nx][ny];
								visited[nx][ny] = true;
								
								if (NextCost < adjacent.G) {
									if (inOpenList(adjacent)) {
										removeFromOpen(adjacent);
									}
									if (inClosedList(adjacent)) {
										removeFromClosed(adjacent);
									}
								}
								
								if(!inOpenList(adjacent) && (!inClosedList(adjacent))){
									adjacent.G = NextCost;
									/*if(TX == testX && TY == testY){
										System.out.println("Grid: " + adjacent.x + ", " + adjacent.y + " G: " + adjacent.G);
									}//*/
									adjacent.H = heuMCalc(nx, ny, TX, TY);//Alternative: heuCalc(Unit, nx, ny, TX, TY);
									adjacent.M = Game.terrain[Unit][nx][ny];
									if(adjacent.G <= MvmMax){
										adjacent.setParent(current);
									}
									//CostMax = Math.max(CostMax, adjacent.setParent(current));
									adjacent.seeDistance(adjacent, TX, TY);
									addToOpen(adjacent);
								}
								/*if(TX == testX && TY == testY){
									System.out.println("Adjacent: " + adjacent.x + ", " + adjacent.y + ", " + adjacent.G + ", " + adjacent.H + ", " + adjacent.M + ", " + (adjacent.G + adjacent.H));
								}//*/
							}//
						}
					}
				}
				/*if(TX == testX && TY == testY){
					System.out.println("Round over: " + CostMax + ", " + MvmMax);
				}//*/
				int checkExist = getListLength();
				if(checkExist == 0){
					nodes[TX][TY].parent = null;
					//System.out.println("not found");
					break;
				}
				else{
					Node result = getFirstOpen();
					CostMax = Math.max(CostMax, result.G);
					//System.out.println(Unit + ", " + MvmMax + ", " + CostMax + ", " + result.G);
					if(CostMax > MvmMax){
						nodes[TX][TY].parent = null;
					}
				}
			}
			if (nodes[TX][TY].parent == null) {
				found = false;
				/*if(TX == testX && TY == testY){
					System.out.println("failed");
				}//*/
				//System.out.println("failed");*/
			}
			else {
				Node target = nodes[TX][TY];
				int indexNumber = 0;
				for(int i=0; i<15; i++){
					Game.pathX[i] = CX;
					Game.pathY[i] = CY;
				}
				while(target != nodes[CX][CY]){
					Game.pathX[indexNumber] = target.x;
					Game.pathY[indexNumber] = target.y;
					/*if(TX == testX && TY == testY){
						System.out.println("list: " + indexNumber + ", " + Game.pathX[indexNumber] + ", " + Game.pathY[indexNumber]);
					}//*/
					target = target.parent;
					indexNumber++;
				}
				Game.pathX[indexNumber] = target.x;
				Game.pathY[indexNumber] = target.y;
				
				MaxIndex = indexNumber;
				/** Select Arrow Type **/
				if(Game.mvtInitialized){
					for(int i=MaxIndex; i>=0; i--){
						int dh1 = Game.pathX[MaxIndex-i] - Game.pathX[MaxIndex-i+1];
						int dv1 = Game.pathY[MaxIndex-i] - Game.pathY[MaxIndex-i+1];
						
						if(i == MaxIndex){
							if(dh1 == -1 && dv1 == 0){//Left
								Game.pathDirection[0] = "LArrow";
							} else if(dh1 == 0 && dv1 == -1){//Up
								Game.pathDirection[0] = "UArrow";
							} else if(dh1 == 1 && dv1 == 0){//Right
								Game.pathDirection[0] = "RArrow";
							} else if(dh1 == 0 && dv1 == 1){//Down
								Game.pathDirection[0] = "DArrow";
							}
						}
						else if(i == 0){
							if(Game.pathX[MaxIndex-1] - Game.pathX[MaxIndex] == -1 && Game.pathY[MaxIndex-1] - Game.pathY[MaxIndex] == 0){//Left
								Game.pathDirection[MaxIndex] = "LStart";
							} else if(Game.pathX[MaxIndex-1] - Game.pathX[MaxIndex] == 0 && Game.pathY[MaxIndex-1] - Game.pathY[MaxIndex] == -1){//Up
								Game.pathDirection[MaxIndex] = "UStart";
							} else if(Game.pathX[MaxIndex-1] - Game.pathX[MaxIndex] == 1 && Game.pathY[MaxIndex-1] - Game.pathY[MaxIndex] == 0){//Right
								Game.pathDirection[MaxIndex] = "RStart";
							} else if(Game.pathX[MaxIndex-1] - Game.pathX[MaxIndex] == 0 && Game.pathY[MaxIndex-1] - Game.pathY[MaxIndex] == 1){//Down
								Game.pathDirection[MaxIndex] = "DStart";
							}
						}
						else{
							int dh2 = Game.pathX[MaxIndex-i] - Game.pathX[MaxIndex-i-1];
							int dv2 = Game.pathY[MaxIndex-i] - Game.pathY[MaxIndex-i-1];
							if((dh1 == -1 && dv1 == 0 && dh2 == 1 && dv2 == 0)){//Horizontal Right
								Game.pathDirection[MaxIndex-i] = "HorizontalL";
							} else if((dh1 == 1 && dv1 == 0 && dh2 == -1 && dv2 == 0)){//Horizontal Left
								Game.pathDirection[MaxIndex-i] = "HorizontalR";
							} else if((dh1 == 0 && dv1 == -1 && dh2 == 0 && dv2 == 1)){//Vertical Down
								Game.pathDirection[MaxIndex-i] = "VerticalU";
							} else if((dh1 == 0 && dv1 == 1 && dh2 == 0 && dv2 == -1)){//Vertical Up
								Game.pathDirection[MaxIndex-i] = "VerticalD";
							} else if((dh1 == -1 && dv1 == 0 && dh2 == 0 && dv2 == -1)){//Left-Up
								Game.pathDirection[MaxIndex-i] = "EastSouth";
							} else if((dh1 == 0 && dv1 == -1 && dh2 == -1 && dv2 == 0)){//Up-Left
								Game.pathDirection[MaxIndex-i] = "SouthEast";
							} else if((dh1 == -1 && dv1 == 0 && dh2 == 0 && dv2 == 1)){//Left-Down
								Game.pathDirection[MaxIndex-i] = "EastNorth";
							} else if((dh1 == 0 && dv1 == 1 && dh2 == -1 && dv2 == 0)){//Down-Left
								Game.pathDirection[MaxIndex-i] = "NorthEast";
							} else if((dh1 == 0 && dv1 == -1 && dh2 == 1 && dv2 == 0)){//Up-Right
								Game.pathDirection[MaxIndex-i] = "SouthWest";
							} else if((dh1 == 1 && dv1 == 0 && dh2 == 0 && dv2 == -1)){//Right-Up
								Game.pathDirection[MaxIndex-i] = "WestSouth";
							} else if((dh1 == 0 && dv1 == 1 && dh2 == 1 && dv2 == 0)){//Down-Right
								Game.pathDirection[MaxIndex-i] = "NorthWest";
							} else if((dh1 == 1 && dv1 == 0 && dh2 == 0 && dv2 == 1)){//Right-Down
								Game.pathDirection[MaxIndex-i] = "WestNorth";
							} 
						}
					}
				}
				/*if(TX == testX && TY == testY){
					for(int i=0; i<=indexNumber; i++){
						System.out.println("list: " + i + ", " + Game.pathX[i] + ", " + Game.pathY[i]);
					}
				}//*/
				/*for(int i=0; i<15; i++){
					System.out.println("list: " + i + ", " + Game.pathX[i] + ", " + Game.pathY[i]);
				}//*/
				
				found = true;
				/*if(TX == testX && TY == testY){
					System.out.println("success");
				}
				//System.out.println("success");*/
			}
	}
		return found;
	}
	
	static Node getFirstOpen(){
		return(Node)open.getFirst();
	}
	static void addToOpen(Node node) {
		open.add(node);
	}
	static int getListLength(){
		return open.getSize();
	}
	static boolean inOpenList(Node node) {
		return open.contains(node);
	}
	static void removeFromOpen(Node node) {
		open.remove(node);
	}
	static void addToClosed(Node node) {
		closed.add(node);
	}
	static boolean inClosedList(Node node) {
		return closed.contains(node);
	}
	static void removeFromClosed(Node node) {
		closed.remove(node);
	}
	
	static public class Possibilities{
		public ArrayList list = new ArrayList();
		
		public Object getFirst(){
			if(list.size() > 0){
				return list.get(0);
			}
			else{
				System.out.println("failed");
				return(0);
			}
			
		}
		public void clear(){
			list.clear();
		}
		public void add(Object e){
			list.add(e);
			Collections.sort(list);//sorts the openlist in order of lowest F to highest F
		}
		public void remove(Object e){
			list.remove(e);
		}
		public int getSize(){
			return list.size();
		}
		public boolean contains(Object e){
			return list.contains(e);
		}
	}
	static public class Node implements Comparable{
		public int x;
		public int y;
		public int F;// G+H
		public int G;// Mvmt cost from initial point to current point
		public int M;
		public int H;// approximate Mvmt cost from current point to target point
		public Node parent;
		public int MvCost;
		public double Distance;// The Euclidean Distance
		
		public Node(int a, int b){
			x = a;
			y = b;
		}
		public int setParent(Node parent){
			MvCost = parent.MvCost + this.G;
			this.parent = parent;
			
			return MvCost;
		}
		public void seeDistance(Node position, int targetX, int targetY){
			double pdx = targetX * 1.0 - position.x * 1.0;
			double pdy = targetY * 1.0 - position.y * 1.0;
			
			//Figure Euclidean Distance
			this.Distance = (Math.sqrt((pdx * pdx) + (pdy * pdy)));
		}
		public int compareTo(Object other) {//Compare the F on each node in the openlist
			Node o = (Node) other;
			
			int F = G + H;
			int oF = o.G + o.H;
			double D = Distance;
			double oD = o.Distance;
			
			if (F < oF) {
				return -1;
			} else if (F > oF) {
				return 1;
			} else {
				return 0;
				/*if(D < oD){
					return -1;
				}
				else if(D > oD){
					return 1;
				}
				else{
					return 0;
				}*/
			}
		}
		
	}
	
	/** Atk Ranges **/
	static void findMaxAtkRange(int side, int uIndex){
		MARange = 0;
		if(side == Game.Ally){
			if(Game.AWeapon[uIndex][0] != null && WeaponData.rWeaponInfo(Game.AWeapon[uIndex][0], 3) != "Special"){
				MARange = WeaponData.rWeaponDat(Game.AWeapon[uIndex][0], 4);
				for(int i=1; i<5; i++){
					if(Game.AWeapon[uIndex][i] != null && WeaponData.rWeaponInfo(Game.AWeapon[uIndex][i], 3) != "Special"){
						if(MARange < WeaponData.rWeaponDat(Game.AWeapon[uIndex][i], 4)){
							MARange = WeaponData.rWeaponDat(Game.AWeapon[uIndex][i], 4);
						}
					}
				}
			}
		}
		else if(side == Game.Enemy){
			if(Game.EWeapon[uIndex][0] != null && WeaponData.rWeaponInfo(Game.EWeapon[uIndex][0], 3) != "Special"){
				MARange = WeaponData.rWeaponDat(Game.EWeapon[uIndex][0], 4);
				for(int i=1; i<5; i++){
					if(Game.EWeapon[uIndex][i] != null && WeaponData.rWeaponInfo(Game.EWeapon[uIndex][i], 3) != "Special"){
						if(MARange < WeaponData.rWeaponDat(Game.EWeapon[uIndex][i], 4)){
							MARange = WeaponData.rWeaponDat(Game.EWeapon[uIndex][i], 4);
						}
					}
				}
			}
		}
		//System.out.println(CalculatePath.MARange);
	}
	
	static void checkAttackRange(int side, int inx){
		int posH = 0;
		int posV = 0;
		for(int i=0; i<5; i++){
			for(int j=0; j<100; j++){
				for(int k=0; k<100; k++){
					Game.weaponR[i][j][k] = Game.CLEAR;
				}
			}
		}
		if(side == Game.Ally){
			posH = Game.square(Game.ALocationX[inx]);
			posV = Game.square(Game.ALocationY[inx]);
			for(int i=0; i<5; i++){
				if(Game.AWeapon[inx][i] != null && WeaponData.rWeaponInfo(Game.AWeapon[inx][i], 3) != "Special"){
					getRange(posH, posV, Game.AWeapon[inx][i], i);
				}
			}
		}
		else if(side == Game.Enemy){
			posH = Game.square(Game.ELocationX[inx]);
			posV = Game.square(Game.ELocationY[inx]);
			for(int i=0; i<5; i++){
				if(Game.EWeapon[inx][i] != null && WeaponData.rWeaponInfo(Game.EWeapon[inx][i], 3) != "Special"){
					getRange(posH, posV, Game.EWeapon[inx][i], i);
				}
			}
		}
	}
	
	static void getRange(int pX, int pY, String wName, int idx){
		int minR = WeaponData.rWeaponDat(wName, 3);
		int maxR = WeaponData.rWeaponDat(wName, 4);
		
		for(int i=-maxR; i<=maxR; i++){
			for(int j=-maxR; j<=maxR; j++){
				if(Math.abs(i)+Math.abs(j) <= maxR && Math.abs(i)+Math.abs(j) >= minR && pX+i >= 0 && pX+i <= Game.GridMax_X && pY+j >= 0 && pY+j <= Game.GridMax_Y){
					if(Game.weaponR[idx][pX+i][pY+j] != Game.RED){
						Game.weaponR[idx][pX+i][pY+j] = Game.RED;
					}
				}
			}
		}
	}
}
