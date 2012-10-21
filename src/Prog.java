public class Prog {
    private DeclSeq ds;
    private StmtSeq ss;

    public Prog(){
        ds = null;
        ss = null;
    }

    void ParseProg(){
        Tokenizer.INSTANCE.skipNext();
        ds = new DeclSeq();
        ds.ParseDeclSeq();

        Tokenizer.INSTANCE.skipNext();
        ss = new StmtSeq();
        ss.ParseStmtSeq();
    }

    void PrintProg(){
        System.out.println("program");
        ds.PrintDeclSeq();
        System.out.println("begin");
        ss.PrintStmtSeq();
        System.out.println("end");
    }

    void ExecProg(){

    }
}
