/*
Interpreter for Principles of Programming Languages
Jacob Klingler / Klingler.45
10/20/12
See README, DOC
*/

public class Interpreter {

    public static String program,data;

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please enter proper arguments!\n");
            System.exit(1);
        }

        program = args[0];
        data = args[1];

        // Initialize Tokenizer
        Tokenizer.INSTANCE.tokenize(program);

        Prog program = new Prog();
        program.ParseProg();
        program.PrintProg();
        program.ExecProg();
    }
}


