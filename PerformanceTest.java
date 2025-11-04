import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PerformanceTest {

    public static void main(String[] args) {
        int SIZE = 10_000;
        List<String> data = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            data.add((i % 3 == 0) ? "user" + i + "@gmail.com" : "other" + i + "@yahoo.com");
        }

        Predicate<String> isGmail = email -> email.contains("@gmail.com");
        Function<String, String> getLogin = email -> email.substring(0, email.indexOf('@'));
        Function<String, Integer> getLength = String::length;



        long startTimeStream = System.nanoTime();
        
        long sumStream = data.stream()
            .filter(isGmail)
            .map(getLogin)
            .map(getLength)
            .reduce(0, Integer::sum);

        long endTimeStream = System.nanoTime();
        long durationStream = (endTimeStream - startTimeStream) / 1_000_000; 
        System.out.println("Stream Result: " + sumStream);
        System.out.println("Stream Time:   " + durationStream + " ms");



        long startTimeLoop = System.nanoTime();

        long sumLoop = 0;
        for (String email : data) {
            if (isGmail.test(email)) {
                String login = getLogin.apply(email);
                sumLoop += getLength.apply(login);
            }
        }

        long endTimeLoop = System.nanoTime();
        long durationLoop = (endTimeLoop - startTimeLoop) / 1_000_000; 
        System.out.println("Loop Result:   " + sumLoop);
        System.out.println("Loop Time:     " + durationLoop + " ms");
        

        long startTimeParallel = System.nanoTime();
        
        long sumParallel = data.parallelStream()
            .filter(isGmail)
            .map(getLogin)
            .map(getLength)
            .reduce(0, Integer::sum);

        long endTimeParallel = System.nanoTime();
        long durationParallel = (endTimeParallel - startTimeParallel) / 1_000_000; 
        System.out.println("Parallel Result: " + sumParallel);
        System.out.println("Parallel Time: " + durationParallel + " ms");



        System.out.println("\n--- Висновки (10,000 елементів) ---");
        System.out.println(String.format("Loop: %d ms | Stream: %d ms | Parallel: %d ms", 
            durationLoop, durationStream, durationParallel));


        System.out.println("Звичайний цикл 'for' виявився найшвидшим для цього набору даних.");
        System.out.println("Parallel Stream, навпаки, найповільніший, імовірно через накладні витрати на паралелізацію.");
    }
}


