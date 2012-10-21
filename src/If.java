public class If {
    private Cond    c;
    private StmtSeq ss1;
    private StmtSeq ss2;

    public If() {
        c   = null;
        ss1 = null;
        ss2 = null;
    }

    void ParseIf() {
        Tokenizer.INSTANCE.skipToken();
        c = new Cond();
        c.ParseCond();
        Tokenizer.INSTANCE.skipToken();
        ss1 = new StmtSeq();
        ss1.ParseStmtSeq();
        if (!Tokenizer.INSTANCE.getToken().equals("end")) {
            Tokenizer.INSTANCE.skipToken();
            ss2 = new StmtSeq();
            ss2.ParseStmtSeq();
        } else {
            Tokenizer.INSTANCE.skipToken();
            Tokenizer.INSTANCE.skipToken();
        }
    }

    void PrintIf() {}

    void ExecIf() {}
}

