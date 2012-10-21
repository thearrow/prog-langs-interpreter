public class Fac {
    private Op      op;
    private Fac     fac;
    private Boolean mult;

    public Fac() {
        op   = null;
        fac  = null;
        mult = false;
    }

    void ParseFac() {
        op = new Op();
        op.ParseOp();
        if (Tokenizer.INSTANCE.getToken().equals("*")) {
            mult = true;
            Tokenizer.INSTANCE.skipToken();    // *
            fac = new Fac();
            fac.ParseFac();
        }
    }

    void PrintFac() {
        if (op != null) {
            op.PrintOp();
        }
        if (mult) {
            System.out.print("*");
        }
        if (fac != null) {
            fac.PrintFac();
        }
    }

    void ExecFac() {}
}
