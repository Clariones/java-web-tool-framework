
package weather;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Forecast {

    private String date;
    private String fengli;
    private String fengxiang;
    private String hightemp;
    private String lowtemp;
    private String type;
    private String week;

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

    public Forecast withDate(String date) {
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

    public Forecast withFengli(String fengli) {
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

    public Forecast withFengxiang(String fengxiang) {
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

    public Forecast withHightemp(String hightemp) {
        this.hightemp = hightemp;
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

    public Forecast withLowtemp(String lowtemp) {
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

    public Forecast withType(String type) {
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

    public Forecast withWeek(String week) {
        this.week = week;
        return this;
    }



}
