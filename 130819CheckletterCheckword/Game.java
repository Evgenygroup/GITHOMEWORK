import java.util.Scanner;

public class Game {

    private WordRepository wordRepository;
    private WordToGuess wordToGuess;
    boolean playerWon = false;


    public Game() {
        wordRepository = new WordRepository();
    }

    public void startNewGame() {

        Word word = wordRepository.getRandomWord();
        wordToGuess = new WordToGuess(word.getWord(), word.getDescription());
        System.out.println("Guess the word with following meaning");
        System.out.println(wordToGuess.getDescription());
        System.out.println(wordToGuess.getWordWithStars());

        int numberOfTries = 3;


        while (numberOfTries > 0 && !playerWon) {
            if (askPlayerLetterOrWord()) {
                //letter
                char letterFromPlayer = scannerMethod("Please enter a letter").charAt(0);
                if (wordToGuess.hasChar(letterFromPlayer)) {
                    wordToGuess.openLetter(letterFromPlayer);
                    if (wordToGuess.checkIfGuessed()) {
                        informPlayerAboutWin();
                        break;
                    }
                    informPlayerAboutSuccess(numberOfTries);


                } else {
                    numberOfTries--;
                    informPlayerAboutMistake(numberOfTries);
                    if (numberOfTries == 0) informPlayerAboutFailure();


                }
            } else {
                String wordFromPlayer = scannerMethod("Please enter a word ");
                if (wordToGuess.openWord(wordFromPlayer)) {
                    informPlayerAboutWin();


                } else informPlayerAboutFailure();


            }
        }
    }

    private void informPlayerAboutMistake(int numberOfTries) {
        System.out.println("You are wrong. You have " + numberOfTries + " attempts left");
        System.out.println(wordToGuess.getWordWithStars());
    }

    private void informPlayerAboutWin() {
        System.out.println(wordToGuess.getWordWithStars());
        System.out.println("Congratulations! " + "You won and can get your " +
                "reward from  President");
        playerWon = true;

    }

    private void informPlayerAboutSuccess(int numberOfTries) {

        System.out.println("you guessed correctly and still have "
                + numberOfTries + " attempts left");
        System.out.println(wordToGuess.getWordWithStars());

    }

    private void informPlayerAboutFailure() {
        System.out.println("Sorry man, you lost.");
        System.out.println("By the way,the word was " + wordToGuess.getWord().toUpperCase() + ". Easy,huh?");
        playerWon = true;
    }

   /* private char askPlayerALetter() {
        String reader = scannerMethod("Please enter a letter");
        return reader.charAt(0);

    }

    private String askPlayerAWord() {
        return scannerMethod("Please enter a word ");


    }*/


    private boolean askPlayerLetterOrWord() {

        String letterOrWord = scannerMethod("Would you like to guess the letter or word?" +
                "(type w for word and any other letter for letter) ");
        if (letterOrWord.equals("w")) {
            return false;
        } else
            return true;
    }

    private String scannerMethod(String str) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(str);
        return scanner.nextLine().toLowerCase();

    }
}
