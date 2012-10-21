public class Input {
    private IdList idl;

    public Input() {
        idl = null;
    }

    void ParseInput(){
        Tokenizer.INSTANCE.skipToken();
        idl = new IdList();
        idl.ParseIdList();
    }

    void PrintInput(){
        System.out.print("print ");
        idl.PrintIdList();
    }

    void ExecInput(){

    }
}
