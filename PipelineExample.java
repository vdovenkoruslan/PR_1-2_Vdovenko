import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PipelineExample {

    public static void main(String[] args) {
        List<String> userEmails = Arrays.asList(
            "test@gmail.com", 
            "user1@yahoo.com", 
            "admin@gmail.com", 
            "invalid-email", 
            "user2@yahoo.com"
        );



        Predicate<String> isGmail = email -> email.endsWith("@gmail.com");




        Function<String, String> toLoginUppercase = email -> 
            email.substring(0, email.indexOf('@')).toUpperCase();




        Consumer<String> logger = login -> 
            System.out.println("[Consumer] Обробка логіну: " + login);



        String allLogins = userEmails.stream()
            .filter(isGmail)           
            .map(toLoginUppercase)     
            .peek(logger)              
            .reduce("", (s1, s2) -> s1.isEmpty() ? s2 : s1 + ", " + s2); 


        System.out.println("\nРезультат агрегування:");
        System.out.println(allLogins); 
    }
}

