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
        Tokenizer.INSTANCE.skipToken();    // if
        c = new Cond();
        c.ParseCond();
        Tokenizer.INSTANCE.skipToken();    // then
        ss1 = new StmtSeq();
        ss1.ParseStmtSeq();
        if (!Tokenizer.INSTANCE.getToken().equals("end")) {
            Tokenizer.INSTANCE.skipToken();
            ss2 = new StmtSeq();
            ss2.ParseStmtSeq();
        } else {
            Tokenizer.INSTANCE.skipToken();    // end
            Tokenizer.INSTANCE.skipToken();    // ;
        }
    }

    void PrintIf() {
        System.out.print("if ");
        c.PrintCond();
        System.out.println(" then");
        ss1.PrintStmtSeq();
        if (ss2 != null) {
            System.out.println("\telse");
            ss2.PrintStmtSeq();
        }
        System.out.println("\tend;");
    }

    void ExecIf() {}
}
