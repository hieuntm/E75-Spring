package ga.demo.spring.dto;

// Bánh xe
public class Tire {
    private int id;
    private String color;

    public Tire() {
        this.id = 20;
        this.color = "Black";
    }

    @Override
    public String toString() {
        return "Tire{" +
                "id=" + id +
                ", color='" + color + '\'' +
                '}';
    }
}
