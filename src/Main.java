import java.util.ArrayList;
import java.util.Collections;

public class Main {
        public static int index1 = 2;
        public static int index2 = 4;

    public static void main(String[] args) {

        //задание 1
        String[] strings = new String[]{"один", "два", "три", "четыре", "пять"};
        mixArray(strings);

        Integer[] integers = new Integer[]{1, 2, 3, 4, 5};
        mixArray(integers);

        //задание 2
        arrayToArrayList(strings);
        arrayToArrayList(integers);

        //задание 3
        System.out.println("Задагие 3");
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());

        ArrayList<Orange> oranges = new ArrayList<>();
        oranges.add(new Orange());
        oranges.add(new Orange());
        oranges.add(new Orange());
        oranges.add(new Orange());
        oranges.add(new Orange());

        Box<Apple> appleBox = new Box<>(apples, apples.get(0));
        Box<Orange> orangeBox = new Box<>(oranges, oranges.get(0));
        System.out.println("вес коробки с апельсинами - " + getWeight(orangeBox));
        System.out.println("вес коробки с яблоками - " + getWeight(appleBox));

        Orange orange1 = new Orange();
        Apple apple1 = new Apple();

        addFruitInBox(orangeBox, orange1);
        addFruitInBox(appleBox, apple1);
        System.out.println("вес коробки с апельсинами после добавления 1 апельсина - " + getWeight(orangeBox));
        System.out.println("вес коробки с яблоками после добавления 1 яблока - " + getWeight(appleBox));

        appleBox.compare(orangeBox);
        orangeBox.compare(appleBox);

        mixFruit(orangeBox, orangeBox);
    }

    @SafeVarargs
    public static <T> void  mixArray(T... arr){
        if (index1 < arr.length && index2 < arr.length){
            T buf = arr[index2];
            arr[index2] = arr[index1];
            arr[index1] = buf;

            //использую вывод в консоль только потому, что в примере у меня массивы строк и чисел
            for (T x : arr) {
                System.out.print(x + " ");
            }
            System.out.print("\n");
        }else {
            System.out.println("Индексы выходят за пределы массива!");
        }
    }

    @SafeVarargs
    public static <E> void arrayToArrayList(E... arr){
        ArrayList<E> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, arr);
        System.out.println(arrayList);
    }

    public static float getWeight(Box <?> fbox){

            return fbox.getFruitBox().size() * fbox.getType().getWeight();
    }

    public static <T extends Fruit> void mixFruit(Box <T> box1, Box <T> box2){

                ArrayList<T> bufBox = new ArrayList<>(box1.getFruitBox());
                box1.setFruitBox(box2.getFruitBox());
                box2.setFruitBox(bufBox);
    }

    public static <T extends Fruit> void addFruitInBox(Box <T> box, T fruit){
        ArrayList<T> bufBox = new ArrayList<>(box.getFruitBox());
        bufBox.add(fruit);
        box.setFruitBox(bufBox);
    }
}
