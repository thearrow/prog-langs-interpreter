public class Stmt {
    private Assign a;
    private If     i;
    private Loop   loop;
    private Input  in;
    private Output out;

    public Stmt() {
        a    = null;
        i    = null;
        loop = null;
        in   = null;
        out  = null;
    }

    void ParseStmt() {
        String token = Tokenizer.INSTANCE.getToken();

        if (token.equals("if")) {
            i = new If();
            i.ParseIf();
        }
        if (token.equals("while")) {
            loop = new Loop();
            loop.ParseLoop();
        }
        if (token.equals("read")) {
            in = new Input();
            in.ParseInput();
        }
        if (token.equals("write")) {
            out = new Output();
            out.ParseOutput();
        }
        else {
            //handle Assign
        }
    }

    void PrintStmt() {
        if(a != null) a.PrintAssign();
        if(i != null) i.PrintIf();
        if(loop != null) loop.PrintLoop();
        if(in != null) in.PrintInput();
        if(out != null) out.PrintOutput();
    }

    void ExecStmt() {}
}