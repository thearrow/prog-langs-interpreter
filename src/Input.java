public class Input {
    private IdList idl;

    public Input() {
        idl = null;
    }

    void ParseInput(){
        Tokenizer.INSTANCE.skipToken(); //read
        idl = new IdList();
        idl.ParseIdList();
        Tokenizer.INSTANCE.skipToken(); //;
    }

    void PrintInput(){
        System.out.print("read ");
        idl.PrintIdList();
    }

    void ExecInput(){

    }
}
