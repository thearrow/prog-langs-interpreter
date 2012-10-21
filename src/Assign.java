public class Assign {
    private Id id;
    private Exp exp;

    public Assign() {
        id = null;
        exp = null;
    }

    void ParseAssign(){
        id = Id.ParseId();
        Tokenizer.INSTANCE.skipToken();
        exp = new Exp();
        exp.ParseExp();
    }

    void PrintAssign(){
        id.PrintId();
        System.out.print(" = ");
        exp.PrintExp();
    }

    void ExecAssign(){

    }
}
