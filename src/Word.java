public class Word {

    private String letters;
    private String hiddenWord;

    public Word(String word) {
        this.letters = word.toString();
    }

    public String getLetters() {
        return this.letters;
    }

    public String getHiddenWord() {
        hiddenWord = this.letters.replaceAll(".", "_");
        return hiddenWord;
    }

    // update to hidden word to a word that contains the guess letter
    public String updateTheWord(String theWord, char chosenLetter, String lines) {
        StringBuilder updatedWord = new StringBuilder(lines);
        boolean contains = false;
        for (int i = 0; i < theWord.length(); i++) {
            if (theWord.charAt(i) == chosenLetter) {
                updatedWord.setCharAt(i, chosenLetter);
                contains = true;
            }
        }
        if (!contains) {
            System.out.println("Doesn't contain: " + chosenLetter);
            return lines;
        }
        System.out.println("nice!, you revealed : " + updatedWord.toString());
        return updatedWord.toString();
    }
}
