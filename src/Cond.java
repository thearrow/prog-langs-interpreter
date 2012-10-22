public class Cond {
    private Comp comp;
    private Cond c1;
    private Cond c2;
    private Boolean and;
    private Boolean or;
    private Boolean negated;

    public Cond() {
        comp = null;
        c1 = null;
        c2 = null;
        and = false;
        or = false;
        negated = false;
    }

    void ParseCond(){
        String token = Tokenizer.INSTANCE.getToken();

        if (token.equals("(")) {
            comp = new Comp();
            comp.ParseComp();
        }
        else if (token.equals("!")) {
            Tokenizer.INSTANCE.skipToken(); //!
            negated = true;
            c1 = new Cond();
            c1.ParseCond();
        }
        else if (token.equals("[")) {
            Tokenizer.INSTANCE.skipToken(); //[
            c1 = new Cond();
            c1.ParseCond();

            token = Tokenizer.INSTANCE.getToken();
            if (token.equals("&&")) {
                Tokenizer.INSTANCE.skipToken(); //&&
                and = true;
                c2 = new Cond();
                c2.ParseCond();
                Tokenizer.INSTANCE.skipToken(); //]
            } else if (token.equals("||")) {
                Tokenizer.INSTANCE.skipToken(); //||
                or = true;
                c2 = new Cond();
                c2.ParseCond();
                Tokenizer.INSTANCE.skipToken();//]
            }
        }
    }

    void PrintCond() {
        if(negated) System.out.print("!");
        if (and) {
            System.out.print("[");
            c1.PrintCond();
            System.out.print("&&");
            c2.PrintCond();
            System.out.print("]");
        } else if (or) {
            System.out.print("[");
            c1.PrintCond();
            System.out.print("||");
            c2.PrintCond();
            System.out.print("]");
        } else{
            if(c1 != null) c1.PrintCond();
            else comp.PrintComp();
        }

    }

    public boolean EvalCond() {
        if (and) {
            return (c1.EvalCond() && c2.EvalCond());
        } else if (or) {
            return (c1.EvalCond() || c2.EvalCond());
        } else {
            if (c1 != null) return c1.EvalCond();
            else return comp.EvalComp();
        }
    }
}
