package cc.minsnail.flood.beans;

/**
 * Created by yg on 2017/2/10.
 */
public class WorkSubject {
    private String info;
    private String url;
    public WorkSubject(){}
    public WorkSubject(String info){
        this.info = info;
    }
    public String getInfo() {
        return info;
    }

    public WorkSubject setInfo(String info) {
        this.info = info;
        return this;
    }

    public WorkSubject(String info, String url) {
        this.info = info;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public WorkSubject setUrl(String url) {
        this.url = url;
        return this;
    }
}
