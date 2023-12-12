import java.util.InputMismatchException;
import java.util.Scanner;

public class JuegoChino {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int opcionJuego;
        int contador = 0;

        do {
            try {
                System.out.println("BIENVENIDO AL JUEGO CHINO");
                System.out.println("¿Quieres jugar contra la maquina? - Pulsa 1");
                System.out.println("Salir - Pulsa 0 ");

                opcionJuego= sc.nextInt();
                sc.nextLine();

                switch (opcionJuego){
                    case 0:
                        System.out.println("Gracias por tu visita, hasta luego");
                        break;
                    case 1:
                        System.out.println("Bienvenido al Juego");

                        //Eligiendo monedasUsuario
                        int monedasUser= monedasUsuario();
                        System.out.println("Has elegido: " + monedasUser + "moneda/s");

                        //Eligiendo monedasRobot
                        int monedaRobot= monedaMaquina();
                        System.out.println("El robot ha elegido: " + monedaRobot);


                        //ApuestaUsuario
                        int apuestaUser= apuestaUsuario(monedasUser);
                        System.out.println("Has apostado: " + apuestaUser + "monedas/s" + "\n");

                        //ApuestRobot
                        int apuestaRobot= apuestaMaquina(apuestaUser, monedaRobot);
                        System.out.println("La apuesta de la maquina es: " + apuestaRobot + "\n");


                        //AdvinarApuesta
                        adivinadoApuesta(apuestaUser, apuestaRobot, monedasUser, monedaRobot);
                        contador++;
                        System.out.println("El numero de intentos/partidas son: "+ contador);



                        break;

                    default:
                        System.out.println("Opción no presente");
                        break;

                }

            }catch(InputMismatchException e){
                System.out.println("Carácter no valido");
                sc.nextLine();
                opcionJuego= -1;
            }


        }while(opcionJuego!=0);
    }


    public static int monedasUsuario(){
        Scanner sc= new Scanner(System.in);

        do {
            try {
                System.out.println("Elige monedas de 0 al 3");
                int monedas= sc.nextInt();

                if (monedas>=0 && monedas<=3){
                    return monedas;

                } else {
                    System.out.println("Moneda fuera de rango");
                }


            }catch(InputMismatchException e){
                System.out.println("Caracter no válido");
                sc.nextLine();
            }


        }while (true); // se ejecutara hasta que se retorne, es decir, con el return finaliza el bucle

    }

    public static int monedaMaquina(){
        int moneda= 1+(int)(Math.random()*3);
        return moneda;

    }



    public static int apuestaUsuario(int monedasUsuario){
        Scanner sc= new Scanner(System.in);
        int apuesta;

        do {
            try {
                System.out.println("Apuesta eligiendo monedas de 0 al 6");
                apuesta= sc.nextInt();

                if (apuesta< 0 || apuesta>6){
                    System.out.println("Tiene que estas entre 0-6)");


                }else if (apuesta<monedasUsuario) {
                    System.out.println("Estas apostando por debajo de tus monedas seleccionadas");



                }else {
                    return apuesta;
                }



            }catch(InputMismatchException e){
                System.out.println("Caracter no válido");
                sc.nextLine();
            }


        }while (true); // se ejecutara hasta que se retorne, es decir, con el return finaliza el bucle

    }



    public static int apuestaMaquina(int apuestaUsuario, int monedasRobot){
        int apuesta;

        do {
            apuesta= 1+(int)(Math.random()*6);

        }while (apuesta<=apuestaUsuario && apuesta<=monedasRobot); // mientras que apuestamaquiina sea menos a apueata usariom u apuesta sea menos a monedarobot se jecuta, una de las 2 solo se debe cumplir


        return apuesta;

    }


    public static void adivinadoApuesta(int apuestaUsuario, int apuestaMaquina, int monedasUsuario, int monedasMaquina){
        int monedasSuma= monedasMaquina + monedasUsuario;
        if (monedasSuma==apuestaMaquina){
            System.out.println("Ganó la maquina \n");

        }else if (monedasSuma==apuestaUsuario){
            System.out.println("Ganaste \n");
        }
        else if(apuestaMaquina==apuestaUsuario){
            System.out.println("Ambos habeis acertado");
        }else{
            System.out.println("Ninguno acertó. Intentarlo de nuevo \n");

        }





    }
}