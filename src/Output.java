public class Output {
    private IdList idl;

    public Output() {
        idl = null;
    }

    void ParseOutput(){
        Tokenizer.INSTANCE.skipToken();
        idl = new IdList();
        idl.ParseIdList();
    }

    void PrintOutput(){
        System.out.print("write ");
        idl.PrintIdList();
    }

    void ExecOutput(){

    }
}
