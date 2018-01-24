package pl.pawelkwiecien;

public class EncoderDecoder {

    private String inputMessage;
    private String outputMessage;
    private int codingKey;
    private char mode;

    public EncoderDecoder() {
    }

    public String getInputMessage() {
        return inputMessage;
    }

    public void setInputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public String getOutputMessage() {
        return outputMessage;
    }

    public void setOutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public int getCodingKey() {
        return codingKey;
    }

    public void setCodingKey(int codingKey) {
        this.codingKey = codingKey;
    }

    public char getMode() {
        return mode;
    }

    public void setMode(char mode) {
        this.mode = mode;
    }


    public String encode(String input, int key) {
        StringBuilder output = new StringBuilder();
        char encodedLetter;
        if (key >= 128) {
            key %= 128;
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 32) {
                output.append(input.charAt(i));
                continue;
            }
            encodedLetter = (char) (input.charAt(i) + key);
            if (outOfAsciiRange(encodedLetter)) {
                encodedLetter = putEncodedLetterWithinAsciiRange(encodedLetter);
                output.append(encodedLetter);
            } else {
                output.append(encodedLetter);
            }
        }
        return output.toString();
    }

    public String decode(String input, int key) {
        StringBuilder output = new StringBuilder();
        char decodedLetter;
        if (key >= 128) {
            key %= 128;
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 32) {
                output.append(input.charAt(i));
                continue;
            }
            decodedLetter = (char) (input.charAt(i) - key);
            if (outOfAsciiRange(decodedLetter)) {
                decodedLetter = putDecodedLetterWithinAsciiRange(decodedLetter);
                output.append(decodedLetter);
            } else {
                output.append(decodedLetter);
            }
        }
        return output.toString();
    }


    private static boolean outOfAsciiRange(char letter) {
        return letter > 126 || letter < 33;
    }

    private static char putEncodedLetterWithinAsciiRange(char letter) {
        int correctionFactor = 94;
        letter -= correctionFactor;
        if (letter > 126) {
            letter -= correctionFactor;
            return letter;
        } else {
            return letter;
        }
    }

    private static char putDecodedLetterWithinAsciiRange(char letter) {
        int correctionFactor = 94;
        letter += correctionFactor;
        if (letter < 33) {
            letter += correctionFactor;
            return letter;
        } else {
            return letter;
        }
    }

}