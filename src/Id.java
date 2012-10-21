import java.util.HashMap;

public class Id {
    private static HashMap<String, Id> idSet = new HashMap<String, Id>();
    private String                     name;
    private int                        val;
    private Boolean                    declared;
    private Boolean                    initialized;

    private Id(String n) {
        name        = n;
        declared    = false;
        initialized = false;
        val         = -1;
    }

    public static Id ParseId() {
        String token = Tokenizer.INSTANCE.getToken();
        if (idSet.containsKey(token)) {
            return idSet.get(token);
        } else {
            Id id = new Id(token);
            idSet.put(token, id);
            return id;
        }
    }

    void PrintId() {
        System.out.print(name);
    }

    void ExecId() {}
}
