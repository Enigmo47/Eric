package ActividadEntrevista;

import java.util.ArrayList;

public class Respuestas {

	ArrayList<String> respuesta1 = new ArrayList<String>();
	int respuesta1Num1=0;
	int respuesta1Num2=0;
	
	ArrayList<String> respuesta2 = new ArrayList<String>();
	int respuesta2Num1=0;
	int respuesta2Num2=0;
	
	ArrayList<String> respuesta3 = new ArrayList<String>();
	int respuesta3Num1=0;
	int respuesta3Num2=0;
	
	ArrayList<String> respuesta4 = new ArrayList<String>();
	int respuesta4Num1=0;
	int respuesta4Num2=0;
	
	
	public synchronized void setRespuesta(int num, String respuesta) {
		respuesta=respuesta.toLowerCase();
		switch (num) {
		case 1: {
			if(respuesta.equals("azul")) {
				respuesta1Num1++;
			}else if (respuesta.equals("rojo")) {
				respuesta1Num2++;
			}
			
			respuesta1.add(respuesta);
			break;
		}
		case 2: {
			if(respuesta.equals("gatos")) {
				respuesta2Num1++;
			}else if (respuesta.equals("perros")) {
				respuesta2Num2++;
			}
			
			respuesta2.add(respuesta);
			break;
		}
		case 3: {
			if(respuesta.equals("futbol")) {
				respuesta3Num1++;
			}else if (respuesta.equals("baloncesto")) {
				respuesta3Num2++;
			}
			
			respuesta3.add(respuesta);
			break;
		}
		case 4: {
			if(respuesta.equals("playa")) {
				respuesta4Num1++;
			}else if (respuesta.equals("montaña")) {
				respuesta4Num2++;
			}
			
			respuesta4.add(respuesta);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + 0);
		}
	}

	@Override
	public String toString() {
		String salida ="Respuesta 1: Rojo= "+respuesta1Num2+", Azul= "+respuesta1Num1+",Otros= "+(respuesta1.size()-(respuesta1Num2+respuesta1Num1))+"☺"
				+ "Respuesta 2: Gatos= "+respuesta2Num1+", Perros= "+respuesta2Num2+", Otros= "+(respuesta2.size()-(respuesta2Num1+respuesta2Num2))+"☺"
				+ "Respuesta 3: Futbol= "+respuesta3Num1+", Baloncesto= "+respuesta3Num2+", Otros= "+(respuesta3.size()-(respuesta3Num1+respuesta3Num2))+"☺"
				+ "Respuesta 4: Playa= "+respuesta4Num1+", Montaña= "+respuesta4Num2+", Otros= "+(respuesta4.size()-(respuesta4Num1+respuesta4Num2))+"☺";
		return salida;
	}
	
	
	
}
