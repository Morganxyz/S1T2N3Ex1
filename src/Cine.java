import java.util.Scanner;

public class Cine {

	static Scanner entrada = new Scanner(System.in);
	private static int nombreFiles;
	private static int nombreSeientsPF;
	static Gestio_Butaques gb0;
	
	public Cine() {
		
		gb0  = new Gestio_Butaques();
		demanarDadesInicials();
		
	}
	
	public int getNombreFiles() {
		return nombreFiles;
	}
	
	public int getNombreSeientsPF() {
		return nombreSeientsPF;
	}
	public static void setNombreFiles(int nombreFiles) {
		nombreFiles = nombreFiles;
	}
	public static void setNombreSeientsPF(int nombreSeientsPF) {
		nombreSeientsPF = nombreSeientsPF;
	}
	
	public void iniciar() {
		menu();
	}
	
	public void menu() {
		
		int  opcio;
		
		do {
		
		System.out.println("Introdueix l´opció desitjada: \n1. Mostrar Butaques\n2. Mostrar Butaques Persona"
				+ "\n3. Reservar Butaca\n4. Anular Reserva\n5. Anular Reserva Persona\n6. Introduir Persona"
				+ "\n7. Demanar Dades Inicials\n8. Introduir Fila\n9. Introduir Seient\n0. Sortir");
		opcio = entrada.nextInt();
		
			switch(opcio) {
			
				case 1: mostrarButaques();
					break;
				case 2: mostrarButaquesPersona();
					break;
				case 3: reservarButaca();
					break;
				case 4: anularReserva();
					break;
				case 5: anularReservaPersona();
					break;
				case 6: introduirPersona();
					break;
				case 7: demanarDadesInicials();
					break;
				case 8: introduirFila();
					break;
				case 9: introduirSeient();
					break;
				case 0:
					System.out.println("Sortint!");
					System.out.println("");
					break;
				default:
					System.out.println("La opció escollida no és vàlida");
					System.out.println("");
			}
				
	}while(opcio != 0);

}
	public void mostrarButaques() {
		Gestio_Butaques.cercarButaques();
	}
	
	public void mostrarButaquesPersona(){
		Gestio_Butaques.cercarButaquesPP();
	}
	
	public void reservarButaca(){
		introduirFila();
		introduirSeient();
		introduirPersona();
		Gestio_Butaques.setButaques();
		
	}
	
	public void anularReserva(){
		introduirFila();
		introduirSeient();
		eliminarButaques();
	}
	
	public void anularReservaPersona(){
		introduirPersona();
		eliminarButaquesPP();
		
	}
	public void introduirPersona() throws ExcepcioNomPersonaIncorrecte{
		
		String pers;
		boolean numTrovat = false;
		
		System.out.println("Introdueix el nom de la persona per fer la reserva: ");
		pers = entrada.nextLine();
		
		for(int i = 0; i < pers.length();i++) {
			if(pers.charAt(i) >= 0 || pers.charAt(i) <= 9) {
				numTrovat = true;
			}	
		}
		if(numTrovat) {
			throw new ExcepcioNomPersonaIncorrecte("Format incorrecte");
		}
	
	}
		
	public static void demanarDadesInicials(){
		
		int files;
		int seientsPF;
		
		System.out.println("Introdueix la quantitat de files que té el cinema: ");
		files = entrada.nextInt();
		System.out.println("Introdueix la quantitat de seients per fila que té el cinema: ");
		seientsPF = entrada.nextInt();
		setNombreFiles(files);
		setNombreSeientsPF(seientsPF);
		
	}
	public static void introduirFila() throws Exception{
		
		int numFila;
		
		System.out.println("Introdueix el numero de fila:");
		numFila = entrada.nextInt();
		
		if(numFila >= 1 && numFila <= nombreFiles) {
			System.out.println("La fila " + numFila + " és lliure");
			System.out.println("");
		}else {
			throw new ExcepcioFilaIncorrecta("Fila incorrecte");
		}
	}
	
	public static void introduirSeient() throws Exception{
		
		int numSeient;
		
		System.out.println("Introdueix el numero de seient:");
		numSeient = entrada.nextInt();
		if(numSeient >= 1 && numSeient <= nombreSeientsPF) {
			System.out.println("El seient " + numSeient + " és lliure");
			System.out.println("");
		}else {
			throw new ExcepcioSeientIncorrecte("Seient incorrecte");
		}
	}
}
