public class Prog {
    private DeclSeq ds;
    private StmtSeq ss;

    public Prog(){
        ds = null;
        ss = null;
    }

    void ParseProg(){
        Tokenizer.INSTANCE.skipToken(); //program
        ds = new DeclSeq();
        ds.ParseDeclSeq();

        Tokenizer.INSTANCE.skipToken(); //begin
        ss = new StmtSeq();
        ss.ParseStmtSeq();
    }

    void PrintProg(){
        System.out.println("program");
        System.out.print("\t");
        ds.PrintDeclSeq();
        System.out.println("begin");
        ss.PrintStmtSeq();
        System.out.println("end");
    }

    void ExecProg(){
        ss.ExecStmtSeq();
    }
}
