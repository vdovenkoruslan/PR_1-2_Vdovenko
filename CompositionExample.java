import java.util.function.Function;

public class CompositionExample {

    public static void main(String[] args) {
        int input = 10;

        Function<Integer, Integer> add5 = x -> {
            return x + 5;
        };
        
        Function<Integer, Integer> multiplyBy3 = x -> {
            return x * 3;
        };

        System.out.println("andThen (add5 -> multiplyBy3) ---");
        Function<Integer, Integer> addThenMultiply = add5.andThen(multiplyBy3);
        System.out.println("Результат: " + addThenMultiply.apply(input));

        System.out.println("compose (multiplyBy3 -> add5) ---");
        Function<Integer, Integer> multiplyThenAdd = add5.compose(multiplyBy3);
        System.out.println("Результат: " + multiplyThenAdd.apply(input));
    }
}


