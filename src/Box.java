import java.util.ArrayList;

public class Box <T extends Fruit>{
    private ArrayList<T> fruitBox;
    private T type;

    public Box(ArrayList<T> fruitBox, T type) {
        this.fruitBox = fruitBox;
        this.type = type;
    }

    public void compare(Box<?> fbox){
        System.out.println(Math.abs(Main.getWeight(fbox) - Main.getWeight(this)) < 0.0001
                ? "коробки весят одинаково" : "у коробок разный вес");
    }

    public ArrayList<T> getFruitBox() {
        return fruitBox;
    }

    public T getType() {
        return type;
    }

    public void setFruitBox(ArrayList<T> fruitBox) {
        this.fruitBox = fruitBox;
    }
}

