public class DeclSeq {
    private Decl    d;
    private DeclSeq ds;

    public DeclSeq() {
        d  = null;
        ds = null;
    }

    void ParseDeclSeq() {
        d = new Decl();
        d.ParseDecl();
        Tokenizer.INSTANCE.skipToken();
        if (!Tokenizer.INSTANCE.getToken().equals("begin")) {
            ds = new DeclSeq();
            ds.ParseDeclSeq();
        }
    }

    void PrintDeclSeq() {
        d.PrintDecl();
        if (ds != null) {
            ds.PrintDeclSeq();
        }
    }

    void ExecDeclSeq() {}
}
