public class Comp {
    private Op     op1;
    private Op     op2;
    private CompOp compOp;

    public Comp() {
        op1    = null;
        op2    = null;
        compOp = null;
    }

    void ParseComp() {
        Tokenizer.INSTANCE.skipToken();    // (
        op1 = new Op();
        op1.ParseOp();
        compOp = new CompOp();
        compOp.ParseCompOp();
        op2 = new Op();
        op2.ParseOp();
        Tokenizer.INSTANCE.skipToken();    // )
    }

    void PrintComp() {
        System.out.print("(");
        op1.PrintOp();
        compOp.PrintCompOp();
        op2.PrintOp();
        System.out.print(")");
    }

    public boolean EvalComp() {
        Boolean result = false;

        if(compOp.getOp() == CompOp.CompSymb.EQ)
            result = op1.getVal() == op2.getVal();
        else if(compOp.getOp() == CompOp.CompSymb.NOTEQ)
            result = op1.getVal() != op2.getVal();
        else if(compOp.getOp() == CompOp.CompSymb.LESS)
            result = op1.getVal() < op2.getVal();
        else if(compOp.getOp() == CompOp.CompSymb.GREATER)
            result = op1.getVal() > op2.getVal();
        else if(compOp.getOp() == CompOp.CompSymb.LESSEQ)
            result = op1.getVal() <= op2.getVal();
        else if(compOp.getOp() == CompOp.CompSymb.GREATEREQ)
            result = op1.getVal() >= op2.getVal();

        return result;
    }
}
