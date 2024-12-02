import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // قائمة الكلمات السرية مع موضوعاتها
        List<Puzzle> puzzles = Arrays.asList(
            new Puzzle("programming", "Tecnologia"),
            new Puzzle("computer", "Tecnologia"),
            new Puzzle("university", "Educação"),
            new Puzzle("language", "Educação"),
            new Puzzle("brazil", "Geografia"),
            new Puzzle("amazon", "Geografia"),
            new Puzzle("soccer", "Esportes"),
            new Puzzle("olympics", "Esportes"),
            new Puzzle("cinema", "Entretenimento"),
            new Puzzle("music", "Entretenimento")
        );

        // اختيار عشوائي للغز
        Random random = new Random();
        Puzzle selectedPuzzle = puzzles.get(random.nextInt(puzzles.size()));

        // تشغيل اللعبة مع اللغز المختار
        HangmanGame game = new HangmanGame(selectedPuzzle.getWord(), selectedPuzzle.getTheme());
        game.start();
    }
}
