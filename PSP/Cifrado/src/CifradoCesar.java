public class CifradoCesar {

    // Definimos la clave para el cifrado (desplazamiento)
    private static final int clave = 3;

    // Método para cifrar un string utilizando el método César
    public static String cifrar(String texto) {
        String resultado = "";
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (Character.isUpperCase(caracter)) {
                resultado += (char) (((caracter - 'A') + clave) % 26 + 'A');
            } else if (Character.isLowerCase(caracter)) {
                resultado += (char) (((caracter - 'a') + clave) % 26 + 'a');
            } else {
                resultado += caracter;
            }
        }
        return resultado;
    }

    // Método para descifrar un string cifrado con el método César
    public static String descifrar(String texto) {
        String resultado = "";
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (Character.isUpperCase(caracter)) {
                resultado += (char) (((caracter - 'A') - clave + 26) % 26 + 'A');
            } else if (Character.isLowerCase(caracter)) {
                resultado += (char) (((caracter - 'a') - clave + 26) % 26 + 'a');
            } else {
                resultado += caracter;
            }
        }
        return resultado;
    }
}
