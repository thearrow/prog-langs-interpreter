public class Loop {
    private Cond c;
    private StmtSeq ss;

    public Loop() {
        c = null;
        ss = null;
    }

    void ParseLoop(){
        Tokenizer.INSTANCE.skipToken();
        c = new Cond();
        c.ParseCond();

        Tokenizer.INSTANCE.skipToken();
        ss = new StmtSeq();
        ss.ParseStmtSeq();

        Tokenizer.INSTANCE.skipToken(); //end
        Tokenizer.INSTANCE.skipToken(); //;
    }

    void PrintLoop(){
        System.out.print("while ");
        c.PrintCond();
        System.out.println(" loop");
        ss.PrintStmtSeq();
        System.out.println("\tend;");
    }

    void ExecLoop() {

        while (c.EvalCond()) {
            ss.ExecStmtSeq();
        }

    }
}
