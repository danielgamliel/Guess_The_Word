public class WordStock {
    public static Word Stock() {
        Word[] arr = new Word[] {
                new Word("computer"), new Word("circle"), new Word("available"), new Word("game"),
                new Word("water"), new Word("lexical"), new Word("java"), new Word("syntax"),
                new Word("word"), new Word("win") };
        Word someWord = arr[(int) Math.floor(Math.random() * 10)];
        return someWord;
    }

}
