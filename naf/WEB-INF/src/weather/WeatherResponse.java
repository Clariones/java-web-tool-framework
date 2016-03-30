
package weather;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class WeatherResponse {

    private String errMsg;
    private long errNum;
    private RetData retData;

    /**
     * 
     * @return
     *     The errMsg
     */
    public String getErrMsg() {
        return errMsg;
    }

    /**
     * 
     * @param errMsg
     *     The errMsg
     */
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public WeatherResponse withErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }

    /**
     * 
     * @return
     *     The errNum
     */
    public long getErrNum() {
        return errNum;
    }

    /**
     * 
     * @param errNum
     *     The errNum
     */
    public void setErrNum(long errNum) {
        this.errNum = errNum;
    }

    public WeatherResponse withErrNum(long errNum) {
        this.errNum = errNum;
        return this;
    }

    /**
     * 
     * @return
     *     The retData
     */
    public RetData getRetData() {
        return retData;
    }

    /**
     * 
     * @param retData
     *     The retData
     */
    public void setRetData(RetData retData) {
        this.retData = retData;
    }

    public WeatherResponse withRetData(RetData retData) {
        this.retData = retData;
        return this;
    }



}
