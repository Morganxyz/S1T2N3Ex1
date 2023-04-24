import java.util.ArrayList;
import java.util.Scanner;

public class Gestio_Butaques {

	static Scanner entrada = new Scanner(System.in);
	static ArrayList<Butaca>Butaques;
	
	public Gestio_Butaques() {
		
	this.Butaques = new ArrayList<>();
		
	}

	public ArrayList<Butaca> getButaques() {
		return this.Butaques;
	}
	
	public static void cercarButaques() {
		
		int numFil = 0;
		int numSe = 0;
		int i = 0;
		boolean esc = false;
		int posBut = -1;
		
		System.out.println("Introdueix el numero de la fila: ");
		numFil = entrada.nextInt();
		System.out.println("Introdueix el numero del seient: ");
		numSe = entrada.nextInt();
		
		while(i < Butaques.size()) {
			 Butaca butacaTrovada = Butaques.get(i);
			
			if(butacaTrovada.getNomb_Fila() == numFil && butacaTrovada.getNomb_Seient() == numSe) {
				esc = true;
				posBut = i;
				System.out.println("Posició de la butaca: " + Butaques.get(i));
				System.out.println("Aquesta butaca pertany a : " + butacaTrovada.getNomRes());
				System.out.println("");
			}
			i++;	
		}
		if(!esc) {
				System.out.println(posBut);
				System.out.println("Butaca no reservada");
				System.out.println("");
		}
	}
	
	public static void cercarButaquesPP() {
		
		String nomP;
		int i = 0;
		boolean esc = false;
		int posBut = -1;
		
		System.out.println("Introdueix a nom de qui está feta la reserva: ");
		nomP = entrada.nextLine();
		
		while(i < Butaques.size()) {
			 Butaca butacaTrovada = Butaques.get(i);
			
			if(butacaTrovada.getNomRes().equalsIgnoreCase(nomP)) {
				esc = true;
				posBut = i;
				System.out.println("Aquesta butaca pertany a : " + butacaTrovada.getNomRes());
				System.out.println("Posició de la butaca: " + Butaques.get(i));
				System.out.println("");
			}
			i++;	
		}
		if(!esc) {
				System.out.println(posBut);
				System.out.println("Aquesta persona no té cap butaca reservada");
				System.out.println("");
		}
		
	}
	
	public static void setButaques() throws ExcepcioButacaOcupada {
		
		int numBut = 0;
		int numSe = 0;
		String nom = "";
		boolean esc = false;
		
		cercarButaques();
		
		if(!esc) {
			System.out.println("Introdueix el nom de la persona per reservar el seient: ");
			nom = entrada.nextLine();
			Butaca b0 = new Butaca(numBut,numSe,nom);
			Butaques.add(b0);
			System.out.println("Reserva realitzada correctament!");
			System.out.println("");
		}else {
			throw new ExcepcioButacaOcupada("Butaca Ocupada!");
		}
	}
	
	public static void eliminarButaques() throws ButacaLliure {
		
		boolean esc = false;
		Butaca butacaTrovada = null;
		int posBut = -1;
		String resp = "";
		
		cercarButaques();
		
		if(esc) {
			System.out.println("Està segur d´eliminar la reserva? s/n : ");
			
			if(resp.equalsIgnoreCase("s")){
				Butaques.remove(posBut);	
				System.out.println("Butaca alliverada");
				System.out.println("");
			}else {
				System.out.println("Eliminació de reserva avortada!");
				System.out.println("");
			}
			
		}else {
			throw new ButacaLliure("Butaca lluire!");
		}
	}
	
	public static void eliminarButaquesPP() throws ButacaLliure {
	
		boolean esc = false;
		Butaca butacaTrovada = null;
		String resp = "";
		int posBut = -1;
		
		cercarButaquesPP();
		
		if(esc) {
			System.out.println("Està segur d´eliminar totes les reserves? s/n : ");
			
			if(resp.equalsIgnoreCase("s")){
				for(int i = 0; i < Butaques.size();i++) {
					Butaques.remove(posBut);	
				}
				System.out.println("Butaques alliverades");
				System.out.println("");
			}else {
				System.out.println("Eliminació de reserva avortada!");
				System.out.println("");
			}
			
		}else {
			throw new ButacaLliure("Butaca lluire!");
		}
	}
}
