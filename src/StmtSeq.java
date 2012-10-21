public class StmtSeq {
    private Stmt st;
    private StmtSeq sq;

    public StmtSeq() {
        st = null;
        sq = null;
    }

    void ParseStmtSeq(){
        st = new Stmt();
        st.ParseStmt();

        if(!Tokenizer.INSTANCE.getToken().equals("end")){
            sq = new StmtSeq();
            sq.ParseStmtSeq();
        }
        else Tokenizer.INSTANCE.skipToken();
    }

    void PrintStmtSeq(){

    }

    void ExecStmtSeq(){

    }
}
