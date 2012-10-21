public class Exp {
    private Fac fac;

    private enum PM {
        PLUS,
        MINUS,
        NONE
    }
    private PM pm;
    private Exp exp;

    public Exp() {
        fac = null;
        exp = null;
        pm = PM.NONE;
    }

    void ParseExp(){
        fac = new Fac();
        fac.ParseFac();

        String token = Tokenizer.INSTANCE.getToken();
        if(token.equals("+")){
            pm = PM.PLUS;
            Tokenizer.INSTANCE.skipToken();
            exp = new Exp();
            exp.ParseExp();
        }
        else if(token.equals("-")){
            pm = PM.MINUS;
            Tokenizer.INSTANCE.skipToken();
            exp = new Exp();
            exp.ParseExp();
        }
    }

    void PrintExp(){
        if(fac != null) fac.PrintFac();
        if(pm == PM.PLUS) System.out.print("+");
        if(pm == PM.MINUS) System.out.print("-");
        if(exp != null) exp.PrintExp();
    }

    void ExecExp(){

    }

    public int getVal() {

        if (exp == null) {
            return fac.getVal();
        } else {
            if (pm == PM.PLUS) {
                return fac.getVal()+exp.getVal();
            } else if (pm == PM.MINUS) {
                return fac.getVal()-exp.getVal();
            }
        }
        return 0;
    }
}
