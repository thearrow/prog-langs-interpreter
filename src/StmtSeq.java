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
    }

    void PrintStmtSeq(){
        System.out.print("\t");
        st.PrintStmt();
        if (sq != null) {
            sq.PrintStmtSeq();
        }
    }

    void ExecStmtSeq(){

    }
}
