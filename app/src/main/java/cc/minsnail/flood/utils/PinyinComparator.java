package cc.minsnail.flood.utils;

import java.util.Comparator;

import cc.minsnail.flood.beans.Contact;

/**
 * Created by yg on 2017/2/14.
 */
public class PinyinComparator implements Comparator<Contact> {
    @Override
    public int compare(Contact t0, Contact t1) {
        if (t0.getFirstWord().equals("@") || t1.getFirstWord().equals("#")) {
            return -1;
        } else if (t0.getFirstWord().equals("#") || t1.equals("@")) {
            return 1;
        } else {
            return t0.getFirstWord().compareTo(t1.getFirstWord());
        }
    }
}
