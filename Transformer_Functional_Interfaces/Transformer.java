import java.util.function.Function;
import java.util.function.Predicate;

public class Transformer {

    public String transforming(String input, Predicate<String> predicate, Function<String, String> function) {
        String[] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (predicate.test(words[i])) {
                words[i] = function.apply(words[i]);
            }
        }

        return String.join(" ", words);

    }
}


