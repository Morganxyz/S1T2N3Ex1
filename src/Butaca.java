
public class Butaca {

	private static int nomb_Fila;
	private static int nomb_Seient;
	private static String nomRes;
	
	public Butaca(int nom_Fila,int nomb_Seient,String nomRes) {
		Butaca.nomb_Fila = nom_Fila;
		Butaca.nomb_Seient = nomb_Seient;
		Butaca.nomRes = nomRes;
	}
	
	public int getNomb_Fila() {
		return Butaca.nomb_Fila;
	}
	public int getNomb_Seient() {
		return Butaca.nomb_Seient;
	}
	public String getNomRes() {
		return Butaca.nomRes;
	}
	
	public static boolean equals(int nom_Fila, int nom_Seient) {
		
		boolean iguals = false;
		
		if(Butaca.nomb_Fila == nom_Fila && Butaca.nomb_Seient == nom_Seient) {
			iguals = true;
		}else {
			iguals = false;
		}
		return iguals;
	}
	
	
	public String toString() {
		return "Fila: " + Butaca.nomb_Fila + "\n Seient: " + Butaca.nomb_Seient + "\n Persona: " 
				+ this.nomRes;
	}
}

