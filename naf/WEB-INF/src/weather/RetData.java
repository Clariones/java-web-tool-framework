
package weather;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class RetData {

    private String city;
    private String cityid;
    private List<Forecast> forecast = new ArrayList<Forecast>();
    private List<History> history = new ArrayList<History>();
    private Today today;
  
    /**
     * 
     * @return
     *     The city
     */
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    public RetData withCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * 
     * @return
     *     The cityid
     */
    public String getCityid() {
        return cityid;
    }

    /**
     * 
     * @param cityid
     *     The cityid
     */
    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public RetData withCityid(String cityid) {
        this.cityid = cityid;
        return this;
    }

    /**
     * 
     * @return
     *     The forecast
     */
    public List<Forecast> getForecast() {
        return forecast;
    }

    /**
     * 
     * @param forecast
     *     The forecast
     */
    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    public RetData withForecast(List<Forecast> forecast) {
        this.forecast = forecast;
        return this;
    }

    /**
     * 
     * @return
     *     The history
     */
    public List<History> getHistory() {
        return history;
    }

    /**
     * 
     * @param history
     *     The history
     */
    public void setHistory(List<History> history) {
        this.history = history;
    }

    public RetData withHistory(List<History> history) {
        this.history = history;
        return this;
    }

    /**
     * 
     * @return
     *     The today
     */
    public Today getToday() {
        return today;
    }

    /**
     * 
     * @param today
     *     The today
     */
    public void setToday(Today today) {
        this.today = today;
    }

    public RetData withToday(Today today) {
        this.today = today;
        return this;
    }



}
