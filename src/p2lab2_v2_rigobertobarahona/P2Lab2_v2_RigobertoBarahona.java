package p2lab2_v2_rigobertobarahona;

import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Object;
public class P2Lab2_v2_RigobertoBarahona {

static Scanner lea = new Scanner(System.in);
    public static void main(String[] args) {
        boolean flag = true;
        ArrayList<Jugador> jugadores = new ArrayList();
        ArrayList<Bots> bots = new ArrayList();
        char [][] Tabla = new char [30][30];
        
        while (flag == true) {
            System.out.println("1) Agregar Jugador");
            System.out.println("2) Agregar Bot");
            System.out.println("3) Agregar Item a Jugador");
            System.out.println("4) Simulacion");
            System.out.println("5) Salir");
            System.out.print("Ingresar Opcion: ");
            int opcion = lea.nextInt();

            switch (opcion) {
                case 1: {
                    if (jugadores.isEmpty()) {
                        System.out.print("Nombre: ");
                        Scanner lea = new Scanner(System.in);
                        String name = lea.nextLine();
                        System.out.print("Caracter: ");
                        char caracter = lea.next().charAt(0);
                        int victorias = 0;
                        int dinero = 0;
                        ArrayList<Items> items = new ArrayList();
                        jugadores.add( new Jugador( name, caracter, victorias, dinero, items ) );
                        System.out.println("Jugador Agregado Exitosamente");
                    } else {
                        boolean repeat = false;
                        System.out.print("Nombre: ");
                        Scanner lea = new Scanner(System.in);
                        String name = lea.nextLine();
                        for (int i = 0; i < jugadores.size(); i++){
                            if (name.equals(jugadores.get(i).getName() ) ){
                                repeat = true;
                            }
                        }
                        if (repeat == true){
                            System.out.println("Repeticion Detectada");
                        }else{ 
                            boolean repeat2 = false;
                            System.out.print("Caracter: ");
                            char caracter = lea.next().charAt(0);
                            for (int i = 0; i < jugadores.size() ; i++){
                                if (name.equals(jugadores.get(i).getCaracter() ) ){
                                    repeat2 = true;
                                }
                            }
                            if (repeat2 == true){
                                System.out.println("Repeticion Detectada");
                            }else{
                                if (repeat == false && repeat2 == false){                                  
                                    int victorias = 0;
                                    int dinero = 0;
                                    ArrayList<Items> items = new ArrayList();
                                    jugadores.add( new Jugador( name, caracter, victorias, dinero, items ) );
                                }else{
                                    System.out.println("Error Detectado");
                                }
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    if (bots.isEmpty() ){
                        System.out.print("Velocidad: ");
                        int velocidad = lea.nextInt();
                        System.out.print("Ingresar Caracter: ");
                        String carac = lea.next();
                        carac = carac.toUpperCase();
                        char caracter = carac.charAt(0);
                        System.out.print("Aspecto: ");
                        Scanner lea = new Scanner(System.in);
                        String aspecto = lea.nextLine();
                        System.out.print("Audio Normal: ");
                        String audio = lea.next();
                        System.out.print("Audio de Muerte: ");
                        String muerte = lea.next();
                        bots.add( new Bots (velocidad, caracter, aspecto, audio, muerte) );
                    }else{
                        boolean repeat = false;
                        System.out.print("Velocidad: ");
                        int velocidad = lea.nextInt();
                        System.out.print("Ingresar Caracter: ");
                        String carac = lea.next();
                        carac = carac.toUpperCase();
                        char caracter = carac.charAt(0);
                        for (int i = 0; i < bots.size(); i++){
                            if (caracter == (bots.get(i).getCaracter() ) ){
                                repeat = true;
                            }
                        }
                        if (repeat == true){
                            System.out.println("Repeticion Detectada");
                        }else{
                            System.out.print("Aspecto: ");
                            Scanner lea = new Scanner(System.in);
                            String aspecto = lea.nextLine();
                            System.out.print("Audio Normal: ");
                            String audio = lea.next();
                            System.out.print("Audio de Muerte: ");
                            String muerte = lea.next();
                            bots.add( new Bots (velocidad, caracter, aspecto, audio, muerte) );  
                        }
                    }
                    break;
                }
                case 3: {
                    if (jugadores.isEmpty() ){
                        System.out.println("No hay Jugadores");
                    } else {
                        String list = "";
                        for (Object temp : jugadores) {
                            if (temp instanceof Jugador) {
                                list += jugadores.indexOf(temp) + " - " + temp + "\n";
                            }
                        }
                        System.out.println(list);
                        System.out.print("Seleccionar Indice: ");
                        int index = lea.nextInt();
                        System.out.println("1) Cola - 60");
                        System.out.println("2) Acelerador - 30");
                        System.out.println("3) Mina - 45");
                        System.out.println("4) Iluminador - 45");
                        System.out.println("5) Detector - 30");
                        System.out.print("Eligir Item --- + " + jugadores.get(index).getName() );
                        int opcion2 = lea.nextInt();
                        switch(opcion2){
                            case 1: {
                                if (jugadores.get(index).getDinero() >= 60){
                                    int dinero = jugadores.get(index).getDinero() - 60;
                                    jugadores.get(index).getItems().add( new Items("Cola") );
                                    jugadores.get(index).setDinero(dinero);
                                }else{
                                    System.out.println("No tiene suficiente monedas");
                                }
                                break;
                            }
                            case 2: {
                                if (jugadores.get(index).getDinero() >= 30){
                                    int dinero = jugadores.get(index).getDinero() - 30;
                                    jugadores.get(index).getItems().add( new Items("Acelerador") );
                                    jugadores.get(index).setDinero(dinero);
                                }else{
                                    System.out.println("No tiene suficiente monedas");
                                }
                                break;
                            }
                            case 3: {
                                if (jugadores.get(index).getDinero() >= 45){
                                    int dinero = jugadores.get(index).getDinero() - 45;
                                    jugadores.get(index).getItems().add( new Items("Mina") );
                                    jugadores.get(index).setDinero(dinero);
                                }else{
                                    System.out.println("No tiene suficiente monedas");
                                }
                                break;
                            }
                            case 4: {
                                if (jugadores.get(index).getDinero() >= 45){
                                    int dinero = jugadores.get(index).getDinero() - 45;
                                    jugadores.get(index).getItems().add( new Items("Iluminador") );
                                    jugadores.get(index).setDinero(dinero);
                                }else{
                                    System.out.println("No tiene suficiente monedas");
                                }
                                break;
                            }
                            case 5: {
                                if (jugadores.get(index).getDinero() >= 30){
                                    int dinero = jugadores.get(index).getDinero() - 30;
                                    jugadores.get(index).getItems().add( new Items("Detector") );
                                    jugadores.get(index).setDinero(dinero);
                                }else{
                                    System.out.println("No tiene suficiente monedas");
                                }
                                break;
                            }
                            default: {
                                System.out.println("Opcion Invalida");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 4: {
                    
                }
                case 6: {
                String list = "";
                        for (Object temp : bots) {
                            if (temp instanceof Bots) {
                                list += jugadores.indexOf(temp) + " - " + temp + "\n";
                            }
                        }
                        System.out.println(list);
                        break;
                }
                default: {
                    flag = false;
                    break;
                }
            }
        }
    }
        public static void Imprimir(char [][] matriz){
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                System.out.print("[" + matriz[i][j] + "]");            
            }
            System.out.println();
        }
    }
}
