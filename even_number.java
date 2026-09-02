import java.util.ArrayList;
import java.util.Iterator;

public class even_number {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(15);
        numbers.add(20);
        numbers.add(25);
        numbers.add(30);
        numbers.add(35);
        numbers.add(40);

        Iterator<Integer> it = numbers.iterator();

        while (it.hasNext()) {
            int num = it.next();

            if (num % 2 != 0) {
                it.remove();
            }
        }

        System.out.println("Even numbers: " + numbers);
    }
}