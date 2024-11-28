package org.example;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Examen {

    public static void bingo() {
        Scanner entrada = new Scanner(System.in);
        Random random = new Random();

        System.out.println("*** BIENVENIDO AL BINGO DEL CASINO CANTÁBRICO ***");

        int can = random.nextInt(10,41);
        int bolas[] = new int[can];

        do {
            for (int i = 0; i < bolas.length; i++) {
                int num = random.nextInt(1,91);
                bolas[i] = num;
            }
        }while(Arrays.stream(bolas).distinct().toArray().length < bolas.length);

        System.out.print(can + " bolas extraidas hasta ahora: ");
        System.out.print(Arrays.toString(bolas));
        System.out.println();
        System.out.println("*** Introduce los datos de tu cartón ***");

        String f1;
        String f2;
        String f3;

        System.out.println("Fila 1:");
        f1 = entrada.next();

        System.out.println("Fila 2:");
        f2 = entrada.next();

        System.out.println("Fila 3:");
        f3 = entrada.next();

        if(f1.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}") && f2.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}") && f3.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}")) {

            String x[];
            String y[];
            String z[];
            x = f1.split("-");
            y = f2.split("-");
            z = f3.split("-");
            int x1[] = new int[3];
            int y2[] = new int[3];
            int z3[] = new int[3];

            for (int i = 0; i < 3; i++) {
                int num = Integer.parseInt(x[i]);
                x1[i] = num;
            }

            for (int i = 0; i < 3; i++) {
                int num = Integer.parseInt(y[i]);
                y2[i] = num;
            }

            for (int i = 0; i < 3; i++) {
                int num = Integer.parseInt(z[i]);
                z3[i] = num;
            }

            System.out.println("Datos del cartón introducido:");
            int carton[][] = new int[3][3];
            int j = 0;

            bucle1:
            for (int i = 0; i < 3; ++i) {
                carton[j][i] = x1[i];

                if (i == 2) {
                    j++;

                    for (int k = 0; k < 3; k++) {
                        carton[j][k] = y2[k];

                        if (k == 2) {
                            j++;

                            for (int m = 0; m < 3; m++) {
                                carton[j][m] = z3[m];

                                if (m == 2) {
                                    System.out.println();
                                    j = 0;
                                    for (int n = 0; n < 3; n++) {
                                        System.out.print(carton[j][n] + " ");

                                        if (n == 2) {
                                            j++;
                                            System.out.println();
                                            for (int l = 0; l < 3; l++) {
                                                System.out.print(carton[j][l] + " ");

                                                if (l == 2) {
                                                    j++;
                                                    System.out.println();
                                                    for (int o = 0; o < 3; o++) {
                                                        System.out.print(carton[j][o] + " ");

                                                        if (o == 2) {
                                                            System.out.println();
                                                            System.out.println("PREMIOS:");

                                                            if (Arrays.asList(carton[0][0]).contains(bolas) && Arrays.asList(carton[0][1]).contains(bolas) && Arrays.asList(carton[0][2]).contains(bolas) && Arrays.asList(carton[1][0]).contains(bolas) && Arrays.asList(carton[1][1]).contains(bolas) && Arrays.asList(carton[1][2]).contains(bolas) && Arrays.asList(carton[2][0]).contains(bolas) && Arrays.asList(carton[2][1]).contains(bolas) && Arrays.asList(carton[2][2]).contains(bolas)) {
                                                                System.out.println("Hay BINGO!");
                                                            }else{
                                                                System.out.println("No hay BINGO...");

                                                                if (Arrays.asList(carton[0][0]).contains(bolas) && Arrays.asList(carton[0][1]).contains(bolas) && Arrays.asList(carton[0][2]).contains(bolas)) {
                                                                    System.out.println("Línea 1: CORRECTA!!");
                                                                }else{
                                                                    System.out.println("Línea 1: NO");
                                                                }

                                                                if (Arrays.asList(carton[1][0]).contains(bolas) && Arrays.asList(carton[1][1]).contains(bolas) && Arrays.asList(carton[1][2]).contains(bolas)) {
                                                                    System.out.println("Línea 2: CORRECTA!!");
                                                                }else{
                                                                    System.out.println("Línea 2: NO");
                                                                }

                                                                if (Arrays.asList(carton[2][0]).contains(bolas) && Arrays.asList(carton[2][1]).contains(bolas) && Arrays.asList(carton[2][2]).contains(bolas)) {
                                                                    System.out.println("Línea 3: CORRECTA!!");
                                                                    break bucle1;
                                                                }else{
                                                                    System.out.println("Línea 3: NO");
                                                                    break bucle1;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }

        }else{
            System.out.println("Cerrando programa... Introduce valores con el formato correcto (N-N-N)");
        }

    }
}
