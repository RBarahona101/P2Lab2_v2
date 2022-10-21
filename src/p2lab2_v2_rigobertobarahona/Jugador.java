package p2lab2_v2_rigobertobarahona;
import java.util.ArrayList;

public class Jugador {

    private String name;
    private char caracter;
    private int victorias;
    private int dinero;
    private ArrayList<Items> items;
    
    public Jugador(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }
    
    public Jugador(String name, char caracter, int victorias, int dinero, ArrayList<Items> items) {
        this.name = name;
        this.caracter = caracter;
        this.victorias = victorias;
        this.dinero = dinero;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n"
        + "Caracter: " + caracter + "\n"
        + "Items: " + items;        
    }
    
}
