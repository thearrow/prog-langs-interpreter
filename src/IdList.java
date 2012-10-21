public class IdList {
    private Id     id;
    private IdList il;

    public IdList() {
        id = null;
        il = null;
    }

    void ParseIdList() {
        id = Id.ParseId();
        Tokenizer.INSTANCE.skipToken();
        if (!Tokenizer.INSTANCE.getToken().equals(";")) {
            Tokenizer.INSTANCE.skipToken();
            il = new IdList();
            il.ParseIdList();
        } else {
            Tokenizer.INSTANCE.skipToken();
        }
    }

    void PrintIdList() {
        id.PrintId();
        if (il != null) {
            System.out.print(",");
            il.PrintIdList();
        } else System.out.println(";");
    }

    void ExecIdList() {}
}
