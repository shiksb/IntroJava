/*
This class contains different functions and variables to automatically generate a letter
Name: Shikhar Bakhda
*/

public class Letter {

    public String from;
    public String to;
    public String body="";
    public String letter="";

    //This constructor saves the sender and recipient of the letter
    public Letter(String f, String t)
    {
        from = f;
        to = t;
    }

    //This function adds a line to the body of the letter
    public void addLine(String line) {
        body = body.concat(line).concat("\n");
    }

    //This function concatinates various elements of the letter and returns the letter string
    public String getText() {
        letter = letter.concat("Dear ").concat(to).concat(":\n\n");
        letter = letter.concat(body);
        letter = letter.concat("\n").concat("Sincerely,\n\n");
        letter = letter.concat(from);

        return letter;
    }

}
