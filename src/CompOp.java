public class CompOp {
    private enum CompSymb {
        NOTEQ,
        EQ,
        LESS,
        GREATER,
        LESSEQ,
        GREATEREQ
    }
    private CompSymb cmp;

    void ParseCompOp(){
        String token = Tokenizer.INSTANCE.getToken();

        if(token.equals("!=")) cmp=CompSymb.NOTEQ;
        if(token.equals("==")) cmp=CompSymb.EQ;
        if(token.equals(">")) cmp=CompSymb.GREATER;
        if(token.equals("<")) cmp=CompSymb.LESS;
        if(token.equals(">=")) cmp=CompSymb.GREATEREQ;
        if(token.equals("<=")) cmp=CompSymb.LESSEQ;

        Tokenizer.INSTANCE.skipToken(); //comparison op
    }

    void PrintCompOp(){
        if(cmp==CompSymb.NOTEQ) System.out.print("!=");
        if(cmp==CompSymb.EQ) System.out.print("==");
        if(cmp==CompSymb.GREATER) System.out.print(">");
        if(cmp==CompSymb.LESS) System.out.print("<");
        if(cmp==CompSymb.GREATEREQ) System.out.print(">=");
        if(cmp==CompSymb.LESSEQ) System.out.print("<=");
    }

    void ExecCompOp(){

    }
}
