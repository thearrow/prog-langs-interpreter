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
            //TODO: Handle !
        }
        else if (token.equals("[")) {
            //TODO: Handle [
        }
    }

    void PrintCond(){
        comp.PrintComp();

    }

    public boolean EvalCond(){
        return comp.EvalComp();
    }
}
