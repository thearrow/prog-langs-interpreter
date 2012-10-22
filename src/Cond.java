public class Cond {
    private Comp comp;
    private Cond c1;
    private Cond c2;

    void ParseCond(){
        String token = Tokenizer.INSTANCE.getToken();

        if (token.equals("(")) {
            comp = new Comp();
            comp.ParseComp();
        }
        else if (token.equals("!")) {
            Tokenizer.INSTANCE.skipToken(); //!
            comp = new Comp();
            comp.ParseComp();
            comp.negate();
        }
        else if (token.equals("[")) {
            Tokenizer.INSTANCE.skipToken(); //[
            //TODO: Handle [
            c1 = new Cond();
            c1.ParseCond();

            System.out.println(Tokenizer.INSTANCE.getToken());
        }
    }

    void PrintCond(){
        comp.PrintComp();
    }

    public boolean EvalCond(){
        return comp.EvalComp();
    }
}
