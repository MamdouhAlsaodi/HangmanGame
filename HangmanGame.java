import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HangmanGame {
    private final String secretWord;
    private final String theme;
    private final Set<Character> guessedLetters = new HashSet<>();
    private int attempts = 0;
    private int maxAttempts = 6;

    public HangmanGame(String secretWord, String theme) {
        this.secretWord = secretWord.toLowerCase();
        this.theme = theme;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Jogo da Forca!");
        System.out.println("Tema: " + theme);
        System.out.println("A palavra tem " + secretWord.length() + " letras.");
        
        while (attempts < maxAttempts) {
            printGameState();
            System.out.print("Digite uma letra: ");
            char guess = scanner.nextLine().toLowerCase().charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("Você já tentou essa letra!");
                continue;
            }

            guessedLetters.add(guess);

            if (secretWord.contains(String.valueOf(guess))) {
                System.out.println("Boa! A letra está na palavra.");
                if (isWordGuessed()) {
                    System.out.println("Parabéns! Você adivinhou a palavra: " + secretWord);
                    break;
                }
            } else {
                attempts++;
                System.out.println("Errado! Tentativas restantes: " + (maxAttempts - attempts));
                if (attempts == maxAttempts) {
                    System.out.println("Você perdeu! A palavra era: " + secretWord);
                }
            }
        }

        scanner.close();
    }

    private void printGameState() {
        System.out.print("Palavra: ");
        for (char c : secretWord.toCharArray()) {
            if (guessedLetters.contains(c)) {
                System.out.print(c + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println("\nLetras usadas: " + guessedLetters);
        drawHangman();
    }

    private void drawHangman() {
        String[] hangmanStages = {
            "",
            " O ",
            " O \n | ",
            " O \n/| ",
            " O \n/|\\",
            " O \n/|\\ \n/  ",
            " O \n/|\\ \n/ \\"
        };
        System.out.println("Boneco:");
        System.out.println(hangmanStages[attempts]);
    }

    private boolean isWordGuessed() {
        for (char c : secretWord.toCharArray()) {
            if (!guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }
}
