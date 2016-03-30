
package weather;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Today {

    private String aqi;
    private String curTemp;
    private String date;
    private String fengli;
    private String fengxiang;
    private String hightemp;
    private List<Index> index = new ArrayList<Index>();
    private String lowtemp;
    private String type;
    private String week;
    
    /**
     * 
     * @return
     *     The aqi
     */
    public String getAqi() {
        return aqi;
    }

    /**
     * 
     * @param aqi
     *     The aqi
     */
    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public Today withAqi(String aqi) {
        this.aqi = aqi;
        return this;
    }

    /**
     * 
     * @return
     *     The curTemp
     */
    public String getCurTemp() {
        return curTemp;
    }

    /**
     * 
     * @param curTemp
     *     The curTemp
     */
    public void setCurTemp(String curTemp) {
        this.curTemp = curTemp;
    }

    public Today withCurTemp(String curTemp) {
        this.curTemp = curTemp;
        return this;
    }

    /**
     * 
     * @return
     *     The date
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    public Today withDate(String date) {
        this.date = date;
        return this;
    }

    /**
     * 
     * @return
     *     The fengli
     */
    public String getFengli() {
        return fengli;
    }

    /**
     * 
     * @param fengli
     *     The fengli
     */
    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public Today withFengli(String fengli) {
        this.fengli = fengli;
        return this;
    }

    /**
     * 
     * @return
     *     The fengxiang
     */
    public String getFengxiang() {
        return fengxiang;
    }

    /**
     * 
     * @param fengxiang
     *     The fengxiang
     */
    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public Today withFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
        return this;
    }

    /**
     * 
     * @return
     *     The hightemp
     */
    public String getHightemp() {
        return hightemp;
    }

    /**
     * 
     * @param hightemp
     *     The hightemp
     */
    public void setHightemp(String hightemp) {
        this.hightemp = hightemp;
    }

    public Today withHightemp(String hightemp) {
        this.hightemp = hightemp;
        return this;
    }

    /**
     * 
     * @return
     *     The index
     */
    public List<Index> getIndex() {
        return index;
    }

    /**
     * 
     * @param index
     *     The index
     */
    public void setIndex(List<Index> index) {
        this.index = index;
    }

    public Today withIndex(List<Index> index) {
        this.index = index;
        return this;
    }

    /**
     * 
     * @return
     *     The lowtemp
     */
    public String getLowtemp() {
        return lowtemp;
    }

    /**
     * 
     * @param lowtemp
     *     The lowtemp
     */
    public void setLowtemp(String lowtemp) {
        this.lowtemp = lowtemp;
    }

    public Today withLowtemp(String lowtemp) {
        this.lowtemp = lowtemp;
        return this;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    public Today withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * 
     * @return
     *     The week
     */
    public String getWeek() {
        return week;
    }

    /**
     * 
     * @param week
     *     The week
     */
    public void setWeek(String week) {
        this.week = week;
    }

    public Today withWeek(String week) {
        this.week = week;
        return this;
    }


}
