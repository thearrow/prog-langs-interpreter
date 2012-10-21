public class Assign {
    private Id id;
    private Exp exp;

    public Assign() {
        id = null;
        exp = null;
    }

    void ParseAssign(){
        id = Id.ParseId();
        Tokenizer.INSTANCE.skipToken(); //id
        Tokenizer.INSTANCE.skipToken(); //=
        exp = new Exp();
        exp.ParseExp();
        Tokenizer.INSTANCE.skipToken(); //;
        System.out.println(Tokenizer.INSTANCE.getToken());
    }

    void PrintAssign(){
        id.PrintId();
        System.out.print(" = ");
        exp.PrintExp();
        System.out.println(";");
    }

    void ExecAssign(){

    }
}
