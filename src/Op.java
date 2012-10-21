public class Op {
    private Integer i;
    private Id id;
    private Exp exp;

    public Op() {
        i = null;
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
        if(i != null) System.out.print(i);
        if(id != null) id.PrintId();
        if(exp != null) {
            System.out.print("(");
            exp.PrintExp();
            System.out.print(")");
        }
    }

    public int getVal() {
        if (i != null) {
            return i;
        } else if(id != null){
            return id.getVal();
        } else if (exp != null) {
            return exp.getVal();
        }

        return 0;
    }
}
