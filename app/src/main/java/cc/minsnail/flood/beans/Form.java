package cc.minsnail.flood.beans;

/**
 * Created by yg on 2017/2/10.
 */
public class Form {
    private String variable;
    private Object value;
    public Form(){}
    public Form(String variable,Object value) {
        this.value = value;
        this.variable = variable;
    }
    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }
}
