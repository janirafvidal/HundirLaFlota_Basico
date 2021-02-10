package hundeLaFlota;
/**
 * 
 * @author JANIRA
 *
 */
public class HundeLaFlota {
	
	public static void printTablero (int [][] matriz){
		System.out.println("  1 2 3 4 5 6 7 8");
		for (int i=0; i<=matriz.length-1; i++) {
			System.out.print(Character.toString ((char) 65+i));
			for (int j=0; j<=matriz[i].length-1; j++) {
				
				if (matriz[i][j]==0) {
					System.out.print(" ·");
				}else if (matriz[i][j]==1) {
					System.out.print(" ·");
				}else if (matriz[i][j]==2) {
					System.out.print(" O");
				}else if (matriz[i][j]==3) {
					System.out.print(" X");
				}
			}
			System.out.println();
		}
	}

	public static void createShips(int numShips, int[][] shipPlaces) {
	    int r1, r2;
	    int cont = 0;

	    while (cont < numShips) {
	        r1 = (int) (Math.random()*8); 
	        r2 = (int) (Math.random()*8);
	        if (shipPlaces[r1][r2] != 1) {
	            shipPlaces[r1][r2]=1;
	            cont++;
	        }
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] tablero=new int[8][8];
		Utilidades.rellenaMatriz(tablero, 0, 0);

		int coorLetra;
		int coorNum;
		
		int hundidos=0;
		int totalShots=0;
		
		System.out.println("Bienvenido al juego HUNDIR LA FLOTA:");
		System.out.println("El juego va a pedir posiciones hasta que hundas todos los barcos.");
		System.out.println("Los barcos hundidos son X y los disparos fallidos son O.");
		
	    createShips(10, tablero);
	    
	    do {
	    	printTablero(tablero);
	    	do {
	    		coorLetra = Utilidades.leerCaracter("Introduce letra: ")-65;
	    	}while(coorLetra>(72-65));
	    	
	    	do {
	    		coorNum = Utilidades.leerEntero("Introduce numero: ")-1;
	    	}while(coorNum>(8-1));
	    	
	    	if (tablero[coorLetra][coorNum]==1) {
	    		tablero[coorLetra][coorNum]=3;
	    		hundidos++;
	    		totalShots++;
	    		System.out.println("HUNDIDOS : " +hundidos +"/10");
	    		System.out.println("TOTAL DISPAROS : " +totalShots);
	    	}else {
	    		tablero[coorLetra][coorNum]=2;
	    		totalShots++;
	    		System.out.println("HUNDIDOS : " +hundidos +"/10");
	    		System.out.println("TOTAL DISPAROS : " +totalShots);
	    		System.out.println();
	    	}
	    		
	    		
	    }while (hundidos!=10);

	    
}
}