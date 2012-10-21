public class IdList {
    private Id     id;
    private IdList il;

    public IdList() {
        id = null;
        il = null;
    }

    void ParseIdList() {
        id = Id.ParseId();
        Tokenizer.INSTANCE.skipToken(); //id
        if (!Tokenizer.INSTANCE.getToken().equals(";")) {
            Tokenizer.INSTANCE.skipToken(); //,
            il = new IdList();
            il.ParseIdList();
        }
    }

    void PrintIdList() {
        id.PrintId();
        if (il != null) {
            System.out.print(",");
            il.PrintIdList();
        } else System.out.println(";");
    }

    void WriteIdList() {
        id.OutputId();
        if (il != null) {
            il.WriteIdList();
        }
    }

    public int ReadIdList(int pos){
        id.setVal(Input.getVal(pos));
        if (il != null) {
            il.ReadIdList(pos + 1);
        }

        return pos+1;
    }


}
