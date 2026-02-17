import java.util.Scanner;

public class ExamenMina{

	static final int FILAS = 5;
	static final int COLUMNAS = 7;
	static final int NUM_MINAS = 5;

	static String[][] mapaMinasMostrar = 	
		{ 
			{" ",	"1", 	"2", 	"3", 	"4",	"5",	"6", 	"7"},
			{"1", 	"-", 	"-", 	"-", 	"-", 	"-", 	"-",	"-"},
			{"2", 	"-", 	"-",	"-", 	"-", 	"-", 	"-",	"-"},
			{"3", 	"-", 	"-", 	"-",	"-", 	"-", 	"-",	"-"},
			{"4", 	"-", 	"-",	"-", 	"-", 	"-", 	"-",	"-"},
			{"5", 	"-", 	"-",	"-", 	"-", 	" -", 	"-",	"-"}
		};
		
	static String[][] mapaMinasActivas = 	
		{
			{" ",	"1", 	"2", 	"3", 	"4",	"5",	"6", 	"7"},
			{"1", 	"0", 	"0", 	"0", 	"0", 	"0", 	"0",	"0"},
			{"2", 	"0", 	"0",	"0", 	"0", 	"0", 	"0",	"0"},
			{"3", 	"0", 	"0", 	"0",	"0", 	"0", 	"0",	"0"},
			{"4", 	"0", 	"0",	"0", 	"0", 	"0", 	"0",	"0"},
			{"5", 	"0", 	"0",	"0", 	"0", 	"0", 	"0",	"0"}
		};

	public static void main(String[] args){	
	Scanner scan = new Scanner(System.in);

		colocarMinas(); // NUEVO METODO
	
		int posX=0, posY=0, juegoEncendido=1, valoresCorrectos, contadorMapa=0, contadorMinas=0;

		while(juegoEncendido==1){

			mostrarMapa();

			valoresCorrectos=0;
			while(valoresCorrectos==0){
				System.out.println(" ");
				System.out.println("Ingrese X");
				posY = scan.nextInt();
				System.out.println("Ingrese Y");
				posX = scan.nextInt();

				if(posX>FILAS){
					valoresCorrectos=0;
				}
				else if(posY>COLUMNAS){
					valoresCorrectos=0;
				}
				else{
					valoresCorrectos=1;
				}
			}

			if(mapaMinasActivas[posX][posY].equals("1")){
				mapaMinasMostrar[posX][posY]="x";
				contadorMinas++;
			}
			else if(mapaMinasActivas[posX][posY].equals("0")){
				mapaMinasMostrar[posX][posY]=".";
			}
			else{
				System.out.println("No es correcta esa opcion.");
			}
			
			contadorMapa++;
			if(contadorMinas>2){
				juegoEncendido=0;
				System.out.println("Has perdido");
			}
			else if(contadorMapa>=31){
				System.out.println("Felicidades Ganador!");
				juegoEncendido=0;
			}
		}
	}

	public static void colocarMinas(){
		int i=0;	
		while ( i < NUM_MINAS){

			int PosXMina = (int)(Math.random()*FILAS+1);
			int PosYMina = (int)(Math.random()*COLUMNAS+1);

			if (mapaMinasActivas[PosXMina][PosYMina].equals("1")){
				i=i-1;
			}
			else {
				mapaMinasActivas[PosXMina][PosYMina]="1";
			}
			i++;
		}
	}

	public static void mostrarMapa(){
		for(int i = 0; i<mapaMinasMostrar.length; i++){            
			for (int j = 0; j < mapaMinasMostrar[i].length; j++) {                                     
				System.out.print(mapaMinasMostrar[i][j]);
			}
			System.out.println(" ");
		}
	}
}




