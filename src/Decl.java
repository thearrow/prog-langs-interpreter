public class Decl {
    private IdList il;

    public Decl() {
        il = null;
    }

    void ParseDecl() {
        Tokenizer.INSTANCE.skipToken();
        il = new IdList();
        il.ParseIdList();
    }

    void PrintDecl() {
        System.out.print("int ");
        il.PrintIdList();
    }

    void ExecDecl() {}
}
