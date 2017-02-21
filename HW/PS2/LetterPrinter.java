/*
This class prints a letter by using the class Letter
Name: Shikhar Bakhda
*/

public class LetterPrinter {
    public static void main(String[] args) {
        Letter letter = new Letter("Mary", "John");
        letter.addLine("I am sorry we must part.");
        letter.addLine("I wish you all the best.");
        System.out.println(letter.getText());
    }
}
