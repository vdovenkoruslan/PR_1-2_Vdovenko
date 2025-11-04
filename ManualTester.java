import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ManualTester {

    private static void check(String testName, Object actual, Object expected) {
        if (expected.equals(actual)) {
            System.out.println("[PASS] " + testName);
        } else {
            System.out.println("[FAIL] " + testName + " | Очікували: " + expected + " | Отримали: " + actual);
        }
    }

    public static void main(String[] args) {
        System.out.println("Запуск тестів");
        
        DataProcessor processor = new DataProcessor();


        

        List<String> input1 = Arrays.asList("test@gmail.com", "user@yahoo.com", "admin@gmail.com");
        check("Email: Стандартний випадок", processor.processEmails(input1), "TEST, ADMIN");


        List<String> input2 = Collections.emptyList();
        check("Email: Порожній список", processor.processEmails(input2), "");


        List<String> input3 = Arrays.asList("user@yahoo.com", "info@meta.com");
        check("Email: Немає збігів", processor.processEmails(input3), "");


        check("Email: Null вхід", processor.processEmails(null), "");

        
        
        

        int resultAndThen = processor.getAddThenMultiply().apply(10); 
        check("Композиція: andThen", resultAndThen, 45);


        int resultCompose = processor.getMultiplyThenAdd().apply(10); 
        check("Композиція: compose", resultCompose, 35);
        
        System.out.println("--- Тестування завершено ---");
    }
}
