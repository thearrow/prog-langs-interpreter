import java.util.HashMap;

public class Id {
    private static HashMap<String, Id> idSet = new HashMap<String, Id>();
    private String                     name;
    private Integer                    val;
    private Boolean                    declared;
    private Boolean                    initialized;

    private Id(String n) {
        name        = n;
        declared    = false;
        initialized = false;
        val         = null;
    }

    public static Id ParseId() {
        String token = Tokenizer.INSTANCE.getToken();

        if (idSet.containsKey(token)) {
            return idSet.get(token);
        } else {
            Id id = new Id(token);

            id.declared = true;
            idSet.put(token, id);

            return id;
        }
    }

    void PrintId() {
        System.out.print(name);
    }

    void OutputId() {
        System.out.println(name + " = " + val);
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val    = val;
        initialized = true;
    }
}

