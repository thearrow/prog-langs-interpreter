public class DeclSeq {
    private Decl d;
    private DeclSeq ds;

    public DeclSeq() {
        d = null;
        ds = null;
    }

    void ParseDeclSeq(){
        d = new Decl();
        d.ParseDecl();

        if(Tokenizer.INSTANCE.getToken() != 2){
            ds = new DeclSeq();
            ds.ParseDeclSeq();
        }
        else Tokenizer.INSTANCE.skipToken();

    }

    void PrintDeclSeq(){
        d.PrintDecl();
        if(ds != null) ds.PrintDeclSeq();
    }

    void ExecDeclSeq(){

    }
}
