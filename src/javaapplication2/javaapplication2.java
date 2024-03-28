/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author angie
 */


import java.util.*;

public class javaapplication2 {
    public static void main(String[] args) {
        javaapplication2 utilidades = new javaapplication2();
        utilidades.ejecutarMenu();
    }
    
    
    public void ejecutarMenu() {
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("**** Menu ****");
            System.out.println("1. Multiplicar dos matrices");
            System.out.println("2. Suma del cuadrado de la diagonal principal");
            System.out.println("3. Transpuesta de una matriz");
            System.out.println("4. Moda de un grupo de elementos");
            System.out.println("5. Diferencia entre dos fechas");
            System.out.println("6. Verificar validez de una cedula");
            System.out.println("7. Convertir un monto a letras");
            System.out.println("8. Minimo comun multiplo");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opcion: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Ingrese un numero valido. Por favor intentelo de nuevo.");
                scanner.nextLine();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> multiplicarMatrices();
                case 2 -> sumaCuadradoDiagonalPrincipal();
                case 3 -> obtenerTranspuesta();
                case 4 -> calcularModa();
                case 5 -> calcularDiferenciaFechas();
                case 6 -> validarCedula();
                case 7 -> convertirMontoLetras();
                case 8 -> calcularMCM();
                case 9 -> System.out.println("Cerrando el programa");
                default -> System.out.println("Opcion invalida. Intntelo nuevamente.");
            }
            System.out.println();
        } while (opcion != 9);
    }



   public static void multiplicarMatrices() {
        Scanner entrada = new Scanner(System.in);
        int matA[][];
        int matB[][];
        int matC[][];

        try {
            System.out.print("Introduzca la cantidad de filas de las matrices: ");
            int vFilas = entrada.nextInt();

            System.out.print("Introduzca la cantidad de columnas de las matrices: ");
            int vColumnas = entrada.nextInt();

            matA = new int[vFilas][vColumnas];
            matB = new int[vFilas][vColumnas];
            matC = new int[vFilas][vColumnas];

            System.out.println("\r\nDatos de la Primera Matriz");

            for (int vContFila = 0; vContFila < vFilas; vContFila++) {
                for (int vContCol = 0; vContCol < vColumnas; vContCol++) {
                    System.out.println("Introduzca el elemento " + vContFila + "," + vContCol + ": ");
                    matA[vContFila][vContCol] = obtenerNumeroValido(entrada);
                }
            }

            System.out.println("\r\nDatos de la Segunda Matriz");

            for (int vContFila = 0; vContFila < vFilas; vContFila++) {
                for (int vContCol = 0; vContCol < vColumnas; vContCol++) {
                    System.out.println("Introduzca el elemento " + vContFila + "," + vContCol + ": ");
                    matB[vContFila][vContCol] = obtenerNumeroValido(entrada);
                }
            }

            multiplicarMatrices(matA, matB, matC);

            System.out.println("\r\nMatriz Resultante:");

            for (int vContFila = 0; vContFila < vFilas; vContFila++) {
                for (int vContCol = 0; vContCol < vColumnas; vContCol++) {
                    System.out.print(matC[vContFila][vContCol] + "  ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static int obtenerNumeroValido(Scanner entrada) {
        int numero;

        do {
            String input = entrada.next();

            try {
                numero = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                numero = Integer.MIN_VALUE;
            }

            if (numero == Integer.MIN_VALUE) {
                System.out.println("Valor invalido. Solo se aceptan numeros enteros positivos o negativos. Por favor, intente de nuevo.");
            }
        } while (numero == Integer.MIN_VALUE);

        return numero;
    }

    public static void multiplicarMatrices(int[][] matA, int[][] matB, int[][] matC) {
        int filasA = matA.length;
        int columnasA = matA[0].length;
        int columnasB = matB[0].length;

        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                matC[i][j] = 0;

                for (int k = 0; k < columnasA; k++) {
                    matC[i][j] += matA[i][k] * matB[k][j];
                }
            }
        }
    }



  public static void sumaCuadradoDiagonalPrincipal() {
  Scanner entrada = new Scanner(System.in);

try {
    System.out.print("Introduzca la cantidad de filas y columnas de la matriz: ");
    int n = entrada.nextInt();

    int matriz[][] = new int[n][n];

    System.out.println("\r\nIngrese los elementos de la matriz:");

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            boolean entradaValida = false;
            while (!entradaValida) {
                System.out.println("Introduzca el elemento [" + i + "][" + j + "]: ");
                if (entrada.hasNextInt()) {
                    matriz[i][j] = entrada.nextInt();
                    entradaValida = true;
                } else {
                    System.out.println("Valor invalido. Solo se aceptan numeros enteros. Por favor, intente de nuevo.");
                    entrada.next(); 
                }
            }
        }
    }

    System.out.println("\r\nMatriz ingresada:");

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.print(matriz[i][j] + "  ");
        }
        System.out.println();
    }

    int sumaDiagonal = 0;

    for (int i = 0; i < n; i++) {
        sumaDiagonal += matriz[i][i] * matriz[i][i];
    }

    System.out.println("\r\nLa suma del cuadrado de los elementos de la diagonal principal es: " + sumaDiagonal);
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
}
  }



      public void obtenerTranspuesta() {
        Scanner entrada = new Scanner(System.in);
        int matriz[][] = new int[10][10];

        try {
            System.out.print("Introduzca la cantidad de filas de la matriz: ");
            int filas = entrada.nextInt();

            System.out.print("Introduzca la cantidad de columnas de la matriz: ");
            int columnas = entrada.nextInt();

            System.out.println("\r\nDatos de la Matriz");

            for (int fila = 0; fila < filas; fila++) {
                for (int columna = 0; columna < columnas; columna++) {
                    matriz[fila][columna] = obtenerEnteroValido("Introduzca el elemento " + fila + "," + columna + ": ", entrada);
                }
            }

            System.out.println("\r\nMatriz Original:");

            for (int fila = 0; fila < filas; fila++) {
                System.out.println();

                for (int columna = 0; columna < columnas; columna++) {
                    System.out.print(matriz[fila][columna] + "  ");
                }
            }

            System.out.println("\r\nMatriz Transpuesta:");

            int[][] transpuesta = obtenerTranspuesta(matriz, filas, columnas);

            for (int fila = 0; fila < columnas; fila++) {
                System.out.println();

                for (int columna = 0; columna < filas; columna++) {
                    System.out.print(transpuesta[fila][columna] + "  ");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public int obtenerEnteroValido(String mensaje, Scanner scanner) {
        while (true) {
            try {
                System.out.print(mensaje);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Valor invalido. Solo se aceptan numeros enteros positivos o negativos. Por favor, intentelo de nuevo.");
                scanner.nextLine(); 
            }
        }
    }

    public int[][] obtenerTranspuesta(int[][] matriz, int filas, int columnas) {
        int[][] transpuesta = new int[columnas][filas];

        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                transpuesta[columna][fila] = matriz[fila][columna];
            }
        }

        return transpuesta;
    }
    
    
    

public void calcularModa(){
    Scanner scanner = new Scanner(System.in);

    System.out.println("/// Calcular la Moda ///");
    System.out.print("Ingrese la cantidad de elementos: ");
    int n = obtenerNumeroEntero2(scanner);

    int[] elementos = new int[n];

    System.out.println("Ingrese los elementos uno por uno:");
    for (int i = 0; i < n; i++) {
        System.out.print("Elemento " + (i + 1) + ": ");
        elementos[i] = obtenerNumeroEntero2(scanner);
    }

    Map<Integer, Integer> frecuencia = new HashMap<>();

    for (int elemento : elementos) {
        if (frecuencia.containsKey(elemento)) {
            frecuencia.put(elemento, frecuencia.get(elemento) + 1);
        } else {
            frecuencia.put(elemento, 1);
        }
    }

    int maxFrecuencia = 0;
    List<Integer> moda = new ArrayList<>();

    for (Map.Entry<Integer, Integer> entry : frecuencia.entrySet()) {
        int elemento = entry.getKey();
        int frec = entry.getValue();

        if (frec > maxFrecuencia) {
            maxFrecuencia = frec;
            moda.clear();
            moda.add(elemento);
        } else if (frec == maxFrecuencia) {
            moda.add(elemento);
        }
    }

    if (moda.isEmpty()) {
        System.out.println("No hay moda. Todos los elementos tienen la misma frecuencia.");
    } else {
        System.out.print("La moda es: ");
        for (int i = 0; i < moda.size(); i++) {
            System.out.print(moda.get(i));
            if (i < moda.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}

public void calcularDiferenciaFechas(){
    Scanner scanner = new Scanner(System.in);

    System.out.println("/// Calcular Diferencia Entre Dos Fechas ///");
    System.out.println("Ingrese la primera fecha (DD/MM/AAAA):");
    System.out.print("Dia: ");
    int dia1 = obtenerNumeroEntero3(scanner);
    System.out.print("Mes: ");
    int mes1 = obtenerNumeroEntero3(scanner);
    System.out.print("Año: ");
    int anio1 = obtenerNumeroEntero3(scanner);

    System.out.println("Ingrese la segunda fecha (DD/MM/AAAA):");
    System.out.print("Dia: ");
    int dia2 = obtenerNumeroEntero3(scanner);
    System.out.print("Mes: ");
    int mes2 = obtenerNumeroEntero3(scanner);
    System.out.print("Año: ");
    int anio2 = obtenerNumeroEntero3(scanner);

    int dias = dia2 - dia1;
    int meses = mes2 - mes1;
    int anios = anio2 - anio1;

    if (meses < 0) {
        anios--;
        meses += 12;
    }

    if (dias < 0) {
        meses--;
        int diasMesAnterior = obtenerDiasMes(mes2 - 1, anio2);
        dias += diasMesAnterior;
    }

    System.out.println("La diferencia entre las dos fechas es:");
    System.out.println(anios + " años, " + meses + " meses, " + dias + " dias.");
}

private int obtenerNumeroEntero3(Scanner scanner) {
    while (true) {
        String input = scanner.nextLine();
        if (input.matches("-?\\d+")) {
            return Integer.parseInt(input);
        } else {
            System.out.println("Ingrese un numero valido. Por favor intentelo de nuevo.");
        }
    }
}

private int obtenerDiasMes(int mes, int anio) {
    int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    if (mes == 2 && esAnioBisiesto(anio)) {
        return 29;
    } else {
        return diasPorMes[mes];
    }
}

private boolean esAnioBisiesto(int anio) {
    return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
}

 public void validarCedula() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese la cedula a validar: ");
    String cedula = scanner.next();

    if (cedula == null || cedula.length() != 11 || !cedula.matches("\\d+")) {
        System.out.println("La cedula no es valida");
        return;
    }

    int suma = 0;
    int[] peso = { 1, 2, 1, 2, 1, 2, 1, 2, 1, 2 };

    for (int i = 0; i < 10; i++) {
        int a = Character.getNumericValue(cedula.charAt(i));
        int b = peso[i];

        int mult = a * b;
        int multDigitSum = (mult >= 10) ? (mult % 10) + 1 : mult;

        suma += multDigitSum;
    }

    int digito = (10 - (suma % 10)) % 10;

    if (digito != Character.getNumericValue(cedula.charAt(10))) {
        System.out.println("La cedula no es valida");
        return;
    }

    System.out.println("La cedula es valida");
}





public void convertirMontoLetras() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("//// Convertir Monto a Letras ////");
    System.out.print("Ingrese el monto: ");
    double monto = scanner.nextDouble();

    long parteEntera = (long) monto;
    int parteDecimal = (int) ((monto - parteEntera) * 100);

    String montoEnLetras = convertirNumeroEnLetras(parteEntera) + " pesos";

    if (parteDecimal > 0) {
        montoEnLetras += " con " + convertirNumeroEnLetras(parteDecimal) + " centavos";
    }

    System.out.println(montoEnLetras);
}

private String convertirNumeroEnLetras(long numero) {
    String[] unidades = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez", "once",
            "doce", "trece", "catorce", "quince", "dieciseis", "diecisiete", "dieciocho", "diecinueve"};
    String[] decenas = {"", "", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};
    String[] centenas = {"", "ciento", "doscientos", "trescientos", "cuatrocientos", "quinientos", "seiscientos", "setecientos",
            "ochocientos", "novecientos"};

    if (numero <= 19) {
        return unidades[(int) numero];
    }

    if (numero <= 99) {
        int unidad = (int) numero % 10;
        int decena = (int) numero / 10;

        if (unidad == 0) {
            return decenas[decena];
        } else {
            return decenas[decena] + " y " + unidades[unidad];
        }
    }

    if (numero <= 999) {
        int centena = (int) numero / 100;
        int resto = (int) numero % 100;

        if (resto == 0) {
            return centenas[centena];
        } else {
            return centenas[centena] + " " + convertirNumeroEnLetras(resto);
        }
    }

    return "Mayor de Mil";
}


public static void calcularMCM() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("/// Calcular Minimo Comun Multiplo ///");
    System.out.print("Ingrese la cantidad de numeros: ");
    int n = obtenerNumeroEntero2(scanner);

    int[] numeros = new int[n];

    System.out.println("Ingrese los numeros:");
    for (int i = 0; i < n; i++) {
        numeros[i] = obtenerNumeroEntero2(scanner);
    }

    int mcm = calcularMCM(numeros);

    System.out.println("El MCM es: " + mcm);
}

private static int obtenerNumeroEntero2(Scanner scanner) {
    while (true) {
        try {
            int numero = scanner.nextInt();
            return numero;
        } catch (InputMismatchException e) {
            System.out.println("Ingrese un numero valido. Por favor intentelo de nuevo.");
            scanner.nextLine();
        }
    }
}

private static int calcularMCM(int[] numeros) {
    int mcm = numeros[0];

    for (int i = 1; i < numeros.length; i++) {
        mcm = calcularMCM(mcm, numeros[i]);
    }

    return mcm;
}

private static int calcularMCM(int a, int b) {
    int mcd = calcularMCD(a, b);
    return Math.abs(a * b) / mcd;
}

private static int calcularMCD(int a, int b) {
    a = Math.abs(a);
    b = Math.abs(b);

    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}
}
