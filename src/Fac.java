public class Fac {
    private Op op;
    private Fac fac;
    private Boolean m;

    public Fac() {
        op=null;
        fac=null;
        m = false;
    }

    void ParseFac(){
        op = new Op();
        op.ParseOp();

        if(Tokenizer.INSTANCE.getToken().equals("*"))
        {
            m=true;
            Tokenizer.INSTANCE.skipToken(); //*
            fac = new Fac();
            fac.ParseFac();
        }
    }

    void PrintFac(){
        if(op != null) op.PrintOp();
        if(m) System.out.print("*");
        if(fac != null) fac.PrintFac();
    }

    void ExecFac(){

    }
}
