/*
Tokenizer for Principles of Programming Languages
Jacob Klingler / Klingler.45
9/29/12
See README, DOC
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public enum Tokenizer {
    INSTANCE;

    private String                   program;
    private ArrayList<String>        tokens;
    private HashMap<String, Integer> numbers;
    private ArrayList<String>        output;
    private int                      counter;

    public void tokenize(String filename) {
        LoadFile(filename);
        splitProgram();
        handleSpecialCases();
        setUpNumberMap();
        produceOutput();
    }

    private void LoadFile(String filename) {
        try {
            program = readFile(filename);
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
        tokens  = new ArrayList<String>();
        numbers = new HashMap<String, Integer>();
        output  = new ArrayList<String>();
        counter = 0;
    }

    private String readFile(String filepath) throws IOException {
        // one-line file input to string from http://weblogs.java.net/blog/pat/archive/2004/10/stupid_scanner.html
        return new Scanner(new File(filepath), "UTF-8").useDelimiter("\\A").next();
    }

    private void splitProgram() {
        // Set up the Scanner with RegExp Look-aheads and Look-behinds (to keep delimiters)
        Scanner scn             = new Scanner(program);
        String  symbs           = "(&&)|(\\|\\|)|(!=)|(<=)|(>=)|[;,=!<>()\\+\\-\\*]";
        Pattern special_symbols = Pattern.compile("\\s+|(?<=" + symbs + ")|(?=" + symbs + ")");

        scn.useDelimiter(special_symbols);

        // Split the program
        while (scn.hasNext()) {
            tokens.add(scn.next());
        }
    }

    private void handleSpecialCases() {

        // handle special cases for == | <= | >= | !=
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);

            // handle ==
            if (token.equals("=") && tokens.get(i + 1).equals("=")) {
                tokens.set(i, "==");
                tokens.remove(i + 1);
            }

            // handle <=
            if (token.equals("=") && tokens.get(i - 1).equals("<")) {
                tokens.set(i - 1, "<=");
                tokens.remove(i);
            }

            // handle >=
            if (token.equals("=") && tokens.get(i - 1).equals(">")) {
                tokens.set(i - 1, ">=");
                tokens.remove(i);
            }

            // handle !=
            if (token.equals("=") && tokens.get(i - 1).equals("!")) {
                tokens.set(i - 1, "!=");
                tokens.remove(i);
            }
        }
    }

    private void setUpNumberMap() {
        // reserved words
        numbers.put("program", 1);
        numbers.put("begin", 2);
        numbers.put("end", 3);
        numbers.put("int", 4);
        numbers.put("if", 5);
        numbers.put("then", 6);
        numbers.put("else", 7);
        numbers.put("while", 8);
        numbers.put("loop", 9);
        numbers.put("read", 10);
        numbers.put("write", 11);

        // special symbols
        numbers.put(";", 12);
        numbers.put(",", 13);
        numbers.put("=", 14);
        numbers.put("!", 15);
        numbers.put("[", 16);
        numbers.put("]", 17);
        numbers.put("&&", 18);
        numbers.put("||", 19);
        numbers.put("(", 20);
        numbers.put(")", 21);
        numbers.put("+", 22);
        numbers.put("-", 23);
        numbers.put("*", 24);
        numbers.put("!=", 25);
        numbers.put("==", 26);
        numbers.put("<", 27);
        numbers.put(">", 28);
        numbers.put("<=", 29);
        numbers.put(">=", 30);
    }

    private void produceOutput() {
        for (String token : tokens) {
            if (numbers.containsKey(token)) {
                //output.add(numbers.get(token).toString());
                output.add(token);
            } else if (token.matches("\\d*")) {
                output.add(token);  //31
            } else if (token.matches("[A-Z]*\\d*")) {
                output.add(token);  //32
            } else {
                output.add("ERROR");
            }
        }
    }

    public String getToken() {
        if (output.get(counter).equals("ERROR")) {
            System.out.println("Invalid Token Detected, Exiting.");
            System.exit(1);
        }

        return output.get(counter);
    }

    public void skipToken() {
        counter++;
    }
}