package cc.minsnail.flood.beans;

/**
 * Created by yg on 2017/2/13.
 */
public class BaseColumns {
    private int id;
    private String name;

    public BaseColumns() {
    }

    public BaseColumns(String name) {
        this.name = name;
    }

    public BaseColumns(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
