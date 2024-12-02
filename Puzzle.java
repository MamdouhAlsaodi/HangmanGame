public class Puzzle {
    private final String word;
    private final String theme;

    public Puzzle(String word, String theme) {
        this.word = word.toLowerCase();
        this.theme = theme;
    }

    public String getWord() {
        return word;
    }

    public String getTheme() {
        return theme;
    }
}
