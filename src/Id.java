import java.util.Set;

public class Id {

    private String name;
    private int val;
    private Boolean declared;
    private Boolean initialized;
    private static Set<Id> idSet;

    private Id(String n) {
        name = n;
        declared = false;
        initialized =false;
        val = -1;
    }

    public static void ParseId(){

    }

    void PrintId(){

    }

    void ExecId(){

    }
}
