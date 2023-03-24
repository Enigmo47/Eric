public class CifradoPosicion {

    // Definimos la clave para el cifrado (un string de letras)
    private static final String clave = "SECRETO";

    // Método para cifrar un string utilizando el método polialfabético
    public static String cifrar(String texto) {
        String resultado = "";
        int indiceClave = 0;
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (Character.isLetter(caracter)) {
                int desplazamiento = clave.charAt(indiceClave) - 'A';
                if (Character.isUpperCase(caracter)) {
                    resultado += (char) (((caracter - 'A') + desplazamiento) % 26 + 'A');
                } else {
                    resultado += (char) (((caracter - 'a') + desplazamiento) % 26 + 'a');
                }
                indiceClave = (indiceClave + 1) % clave.length();
            } else {
                resultado += caracter;
            }
        }
        return resultado;
    }

    // Método para descifrar un string cifrado con el método polialfabético
    public static String descifrar(String texto) {
        String resultado = "";
        int indiceClave = 0;
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (Character.isLetter(caracter)) {
                int desplazamiento = clave.charAt(indiceClave) - 'A';
                if (Character.isUpperCase(caracter)) {
                    resultado += (char) (((caracter - 'A') - desplazamiento + 26) % 26 + 'A');
                } else {
                    resultado += (char) (((caracter - 'a') - desplazamiento + 26) % 26 + 'a');
                }
                indiceClave = (indiceClave + 1) % clave.length();
            } else {
                resultado += caracter;
            }
        }
        return resultado;
    }
}
