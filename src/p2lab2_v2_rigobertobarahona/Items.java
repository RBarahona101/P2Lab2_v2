
package p2lab2_v2_rigobertobarahona;


public class Items {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Items(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
