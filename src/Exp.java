public class Exp {
    private Fac fac;
    private Exp exp;

    public Exp() {
        fac = null;
        exp = null;
    }

    void ParseExp(){
        fac = new Fac();
        fac.ParseFac();
        Tokenizer.INSTANCE.skipToken();
        String token = Tokenizer.INSTANCE.getToken();
        if(token.equals("+") || token.equals("-")){
            System.out.println("+/-");
            Tokenizer.INSTANCE.skipToken();
            exp = new Exp();
            exp.ParseExp();
        }
    }

    void PrintExp(){

    }

    void ExecExp(){

    }
}
