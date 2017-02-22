package cc.minsnail.flood.beans;

/**
 * Created by yg on 2017/2/10.
 */
public class TaskObject {
    private String name;
    private String scope;
    private String structure;
    public TaskObject(){}
    public TaskObject(String name, String scope, String structure) {
        this.name = name;
        this.scope = scope;
        this.structure = structure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }
}
