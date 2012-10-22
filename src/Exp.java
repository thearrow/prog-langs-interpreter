public class Exp {
    private Fac     fac;
    private Exp     exp;
    private Boolean plus;
    private Boolean minus;

    public Exp() {
        fac   = null;
        exp   = null;
        plus  = false;
        minus = false;
    }

    void ParseExp() {
        fac = new Fac();
        fac.ParseFac();

        String token = Tokenizer.INSTANCE.getToken();

        if (token.equals("+")) {
            plus = true;
            Tokenizer.INSTANCE.skipToken();    // +
            exp = new Exp();
            exp.ParseExp();
        } else if (token.equals("-")) {
            minus = true;
            Tokenizer.INSTANCE.skipToken();    // -
            exp = new Exp();
            exp.ParseExp();
        }
    }

    void PrintExp() {
        if (fac != null) {
            fac.PrintFac();
        }
        if (plus) {
            System.out.print("+");
        }
        if (minus) {
            System.out.print("-");
        }
        if (exp != null) {
            exp.PrintExp();
        }
    }

    public int getVal() {
        if (exp == null) {
            return fac.getVal();
        } else {
            if (plus) {
                return fac.getVal() + exp.getVal();
            } else if (minus) {
                return fac.getVal() - exp.getVal();
            }
        }

        return 0;
    }
}