import java.util.Scanner;
import java.text.DecimalFormat;

public class erroresSemanticos {
    private static Scanner scanner = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("#.####");

    // Funciones predefinidas para entrada
    public static int readInt() {
        return scanner.nextInt();
    }

    public static float readFloat() {
        return scanner.nextFloat();
    }

    public static String readString() {
        return scanner.next();
    }

    public static boolean readBoolean() {
        return scanner.nextBoolean();
    }

    public static void write(int value) {
        System.out.println(value);
    }

    public static void write(float value) {
        System.out.println(df.format(value));
    }

    public static void write(String str) {
        System.out.println(str);
    }

    public static void write(boolean value) {
        System.out.println(value);
    }

    public static void write(Object value) {
        System.out.println(value);
    }

    public static String unidad(int a) {
        String textoUnidad = "";
        if (a == 1) {
            textoUnidad = "uno";
        } else if (a == 2) {
            textoUnidad = "dos";
        } else if (a == 3) {
            textoUnidad = "tres";
        } else if (a == 4) {
            textoUnidad = "cuatro";
        } else if (a == 5) {
            textoUnidad = "cinco";
        } else if (a == 6) {
            textoUnidad = "seis";
        } else if (a == 7) {
            textoUnidad = "siete";
        } else if (a == 8) {
            textoUnidad = "ocho";
        } else if (a == 9) {
            textoUnidad = "nueve";
        }        return textoUnidad;
    }

    public static String decena(int numero) {
        String texto = "";
        int temp = numero % 10;
        if (numero < 20) {
            texto = "dieci y";
            if (temp == 0) {
                texto = "diez ";
            }        } else if (numero < 30) {
            texto = "veinti y";
            if (temp == 0) {
                texto = "veinte ";
            }        } else if (numero < 40) {
            texto = "treinta y ";
            if (temp == 0) {
                texto = "treinta";
            }        } else if (numero < 50) {
            texto = "cuarenta y ";
            if (temp == 0) {
                texto = "cuarenta ";
            }        } else if (numero < 60) {
            texto = "cincuenta y ";
            if (temp == 0) {
                texto = "cincuenta ";
            }        } else if (numero < 70) {
            texto = "sesenta y";
            if (temp == 0) {
                texto = "sesenta ";
            }        } else if (numero < 80) {
            texto = "setenta y ";
            if (temp == 0) {
                texto = "setenta ";
            }        } else if (numero < 90) {
            texto = "ochenta y ";
            if (temp == 0) {
                texto = "ochenta ";
            }        } else if (numero < 100) {
            texto = "noventa y ";
            if (temp == 0) {
                texto = "noventa ";
            }        }        return texto;
    }

    public static String centena() {
        return "cien";
    }

    public static void main(String[] args) {
        int numero = 0;
        write("Pon un numero");
        numero = readInt();
        String resultado = "";
        String resultadoFinal = "";
        while (numero != 0) {
            if (numero <= 9) {
                resultado = unidad(numero);
                numero = numero % 1;
            } else if (numero <= 99) {
                resultado = decena(numero);
                numero = numero % 10;
            } else if (numero == 100) {
                resultado = decena(numero);
                numero = 0;
            }            resultadoFinal = resultadoFinal + resultado;
        }
        write(resultadoFinal);
    }

}
