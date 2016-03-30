
package translation;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class TranslationResponse {

    private String errMsg;
    private Integer errNum;
    private RetData retData;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    /**
     * 
     * @return
     *     The errNum
     */
    public Integer getErrNum() {
        return errNum;
    }

    /**
     * 
     * @param errNum
     *     The errNum
     */
    public void setErrNum(Integer errNum) {
        this.errNum = errNum;
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



    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
