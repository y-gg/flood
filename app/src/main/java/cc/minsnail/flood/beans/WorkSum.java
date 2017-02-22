package cc.minsnail.flood.beans;

/**
 * Created by yg on 2017/2/10.
 */
public class WorkSum {
    private String name;
    private String basin;
    private String region;
    public WorkSum(){}
    public WorkSum(String name,String basin,String region){
        this.name = name;
        this.basin = basin;
        this.region = region;
    }
    public String getBasin() {
        return basin;
    }

    public void setBasin(String basin) {
        this.basin = basin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
