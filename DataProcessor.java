import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class DataProcessor {


    public String processEmails(List<String> emails) {
        if (emails == null) {
            return "";
        }
        

        Predicate<String> isGmail = email -> email.contains("@gmail.com");
        Function<String, String> toLoginUppercase = email -> 
            email.substring(0, email.indexOf('@')).toUpperCase();

        return emails.stream()
            .filter(isGmail)
            .map(toLoginUppercase)
            .reduce("", (s1, s2) -> s1.isEmpty() ? s2 : s1 + ", " + s2);
    }


    Function<Integer, Integer> add5 = x -> x + 5;
    Function<Integer, Integer> multiplyBy3 = x -> x * 3;



    public Function<Integer, Integer> getAddThenMultiply() {
        return add5.andThen(multiplyBy3);
    }

    public Function<Integer, Integer> getMultiplyThenAdd() {
        return add5.compose(multiplyBy3);
    }
}


