public class IdList {
    private Id     id;
    private IdList il;

    public IdList() {
        id = null;
        il = null;
    }

    void ParseIdList() {
        id = new Id();
        id.ParseId();
        if (Tokenizer.INSTANCE.getToken() != 12) {
            il = new IdList();
            il.ParseIdList();
        } else {
            Tokenizer.INSTANCE.skipToken();
        }
    }

    void PrintIdList() {
        id.PrintId();
        if (il != null) {
            System.out.print(", ");
            il.PrintIdList();
        }
    }

    void ExecIdList() {}
}
