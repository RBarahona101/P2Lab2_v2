package p2lab2_v2_rigobertobarahona;


public class Bots {
    private int velocidad;
    private char caracter;
    private String aspecto;
    private String audio;
    private String muerte;

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public String getAspecto() {
        return aspecto;
    }

    public void setAspecto(String aspecto) {
        this.aspecto = aspecto;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getMuerte() {
        return muerte;
    }

    public void setMuerte(String muerte) {
        this.muerte = muerte;
    }

    public Bots(int velocidad, char caracter, String aspecto, String audio, String muerte) {
        this.velocidad = velocidad;
        this.caracter = caracter;
        this.aspecto = aspecto;
        this.audio = audio;
        this.muerte = muerte;
    }

    @Override
    public String toString() {
        return "Caracter: " + caracter;
    }
    
}
