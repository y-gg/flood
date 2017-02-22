package cc.minsnail.flood.beans;

/**
 * Created by yg on 2017/2/16.
 */
public class Rain extends BaseColumns {
    private int oneHRainfall;
    private int threeHRainfall;
    private int todayRainfall;

    public Rain() {
        super();
    }

    public Rain(String name) {
        super(name);
    }

    public Rain(String name, int oneHRainfall, int threeHRainfall, int todayRainfall) {
        super(name);
        this.oneHRainfall = oneHRainfall;
        this.threeHRainfall = threeHRainfall;
        this.todayRainfall = todayRainfall;
    }

    public int getOneHRainfall() {
        return oneHRainfall;
    }

    public void setOneHRainfall(int oneHRainfall) {
        this.oneHRainfall = oneHRainfall;
    }

    public int getThreeHRainfall() {
        return threeHRainfall;
    }

    public void setThreeHRainfall(int threeHRainfall) {
        this.threeHRainfall = threeHRainfall;
    }

    public int getTodayRainfall() {
        return todayRainfall;
    }

    public void setTodayRainfall(int todayRainfall) {
        this.todayRainfall = todayRainfall;
    }
}
