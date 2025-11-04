
@FunctionalInterface
public interface DataTransformer<T, R> {

   
    R transform(T input);

   
    default void logInput(T input) {
        System.out.println("[Default Method] Обробка: " + input);
    }

    static <T> boolean isNotNull(T input) {
        System.out.println("[Static Method] Перевірка на null...");
        return input != null;
    }
}