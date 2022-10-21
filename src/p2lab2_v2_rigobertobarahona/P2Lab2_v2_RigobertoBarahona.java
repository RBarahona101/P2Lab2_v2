package p2lab2_v2_rigobertobarahona;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class P2Lab2_v2_RigobertoBarahona {

static Scanner lea = new Scanner(System.in);
static Random r = new Random();

    public static void main(String[] args) {
        boolean flag = true;
        ArrayList<Jugador> jugadores = new ArrayList();
        ArrayList<Bots> bots = new ArrayList();        
        while (flag == true) {
            System.out.println("1) Agregar Jugador");
            System.out.println("2) Agregar Bot");
            System.out.println("3) Agregar Item a Jugador");
            System.out.println("4) Simulacion");
            System.out.println("5) Salir");
            System.out.print("Ingresar Opcion: ");
            int opcion = lea.nextInt();
            char [][] matriz = new char [30][30];
            
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
                                    System.out.println("Jugador Agregado Exitosamente");
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
                        System.out.println("Bot Agregado Exitosamente");
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
                            System.out.println("Bot Agregado Exitosamente");
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
                        System.out.print("Eligir Item ---" + jugadores.get(index).getName() + " " );
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
                    if (jugadores.isEmpty() ){
                        System.out.println("No Hay Jugadores");
                    }else{
                        int cant_jug = 0 + r.nextInt(jugadores.size() );
                        ArrayList<Jugador> Jug = jugadores;
                        Collections.shuffle(Jug);
                        ArrayList<Jugador> jugadores_game = new ArrayList();
                        for (int i = 0; i < cant_jug; i++) {
                            jugadores_game.add(Jug.get(i) );
                        }
                        int cant_bots = (cant_jug / 4) + 1;
                        if (cant_bots == 0){
                            System.out.println("No hay Bots");
                        }
                        else{
                            ArrayList <Bots> Bot = bots;
                            Collections.shuffle(Bot);
                            ArrayList<Bots> bots_game = new ArrayList();
                            for (int i = 0; i < cant_bots; i++){
                                bots_game.add(Bot.get(i) );
                            }
                            boolean juego = true;
                            boolean victory = true;
                            matriz = Fill(matriz);
                            System.out.println("=========================================");
                            while (juego == true){
                                matriz = Juego(matriz, jugadores_game, bots_game);
                                Imprimir(matriz);
                                if (jugadores_game.size() == 1){
                                    juego = false;
                                }else if (jugadores_game.isEmpty() ){
                                    juego = false;
                                    victory = false;
                                }
                                System.out.println("=========================================");
                            }
                            if (victory == false){
                                System.out.println("Nadie Gano");
                            }
                            if (jugadores_game.size() == 1){
                                System.out.println(jugadores_game.get(0).getName() + " ha Ganado!");
                                for (int i = 0; i < jugadores.size(); i++){
                                    if (jugadores_game.get(0).getName().equals(jugadores.get(i).getName() ) ){
                                        int dinero = jugadores.get(i).getDinero() + 200;
                                        jugadores.get(i).setDinero(dinero);
                                        int victorias = jugadores.get(i).getVictorias() + 1;
                                        jugadores.get(i).setVictorias(victorias);
                                    }
                                }
                            }
                        }
                    }
                    break;
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
    public static char [][] Juego (char [][] matriz, ArrayList<Jugador> jugadores_game, ArrayList <Bots> bots_game){
        char [][] temp = matriz;
        
        int cont_jug = 0;
        int cont_bots = 0;
        int cant_walls = 0+r.nextInt(30);
        int cont_walls = 0;
        while (cont_walls < cant_walls){
            int y = r.nextInt(temp.length);
            int x = r.nextInt(temp.length);
            temp[y][x] = 'X';
            cont_walls++;
        }
        while (cont_jug < jugadores_game.size() ){
            int y = r.nextInt(temp.length);
            int x = r.nextInt(temp.length);
            temp [y][x] = jugadores_game.get(cont_jug).getCaracter();
            cont_jug++;
        }
        while (cont_bots < bots_game.size() ){
            int y = r.nextInt(temp.length);
            int x = r.nextInt(temp.length);
            if (temp [y][x] != ' ' && temp [y][x] != 'X'){
                char analysis = temp[y][x];
                for (int i = 0; i < jugadores_game.size() ; i++) {
                    if (analysis == jugadores_game.get(i).getCaracter() ){
                        System.out.println(bots_game.get(cont_bots).getCaracter() + " ha Eliminado " + jugadores_game.get(i).getName() );
                        System.out.println(bots_game.get(cont_bots).getMuerte() );
                        jugadores_game.remove(i);
                    }
                }
            }
            temp [y][x] = bots_game.get(cont_bots).getCaracter();
            cont_bots++;
        }
        return temp;
    }
    public static char [][] Fill (char [][] matriz){
        char[][] temp = matriz;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                temp[i][j] = ' ';
            }
        }
        int cant_walls = 0 + r.nextInt(30);
        int cont_walls = 0;
        while (cont_walls < cant_walls) {
            int y = r.nextInt(temp.length);
            int x = r.nextInt(temp.length);
            temp[y][x] = 'X';
            cont_walls++;
        }
        return temp;
    }
}
