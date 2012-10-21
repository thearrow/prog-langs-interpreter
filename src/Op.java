public class Op {
    private int i;
    private Id id;
    private Exp exp;

    public Op() {
        i = -1;
        id = null;
        exp = null;
    }

    void ParseOp(){
        String token = Tokenizer.INSTANCE.getToken();
        if(token.equals("(")){
            Tokenizer.INSTANCE.skipToken();// (
            exp = new Exp();
            exp.ParseExp();
            Tokenizer.INSTANCE.skipToken(); // )
        }
        else if (token.matches("\\d*")) {
            i = Integer.valueOf(token);
            Tokenizer.INSTANCE.skipToken(); // ###
        }
        else {
            id = Id.ParseId();
            Tokenizer.INSTANCE.skipToken(); //id
        }
    }

    void PrintOp(){
        if(i != -1) System.out.print(i);
        if(id != null) id.PrintId();
        if(exp != null) {
            System.out.print("(");
            exp.PrintExp();
            System.out.print(")");
        }
    }

    void ExecOp(){

    }
}
