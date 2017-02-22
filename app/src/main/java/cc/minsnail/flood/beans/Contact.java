package cc.minsnail.flood.beans;

import cc.minsnail.flood.utils.PinyinUtils;

/**
 * Created by yg on 2017/2/13.
 */
public class Contact extends BaseColumns{
    private String pinyin;
    private String number;
    private String role;
    public Contact(){
        super();
    }
    public Contact(String name) {
        super(name);
    }

    public Contact(String name, String number) {
        super(name);
        this.number = number;
    }

    public String getPinyin() {
        if (pinyin!=null)return pinyin;
        pinyin = PinyinUtils.getPinYin(this.getName());
        return pinyin;
    }

    public Contact setPinyin(String pinyin) {
        this.pinyin = pinyin;
        return this;
    }
    public String getFirstWord(){
        if (this.getPinyin()!=null){
            String c = pinyin.substring(0,1).toUpperCase();
            if (c.matches("[A-Z]")){
                return c;
            }
            return "#";
        }
        return null;
    }
    public String getNumber() {
        return number;
    }

    public Contact setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getRole() {
        return role;
    }

    public Contact setRole(String role) {
        this.role = role;
        return this;
    }
}
