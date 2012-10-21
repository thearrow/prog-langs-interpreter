public class Output {
    private IdList idl;

    public Output() {
        idl = null;
    }

    void ParseOutput(){
        Tokenizer.INSTANCE.skipToken(); //write
        idl = new IdList();
        idl.ParseIdList();
        Tokenizer.INSTANCE.skipToken(); //;
    }

    void PrintOutput(){
        System.out.print("write ");
        idl.PrintIdList();
    }

    void ExecOutput(){
        idl.WriteIdList();
    }
}
