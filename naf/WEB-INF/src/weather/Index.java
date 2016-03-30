
package weather;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Index {

    private String code;
    private String details;
    private String index;
    private String name;
    private String otherName;

    /**
     * 
     * @return
     *     The code
     */
    public String getCode() {
        return code;
    }

    /**
     * 
     * @param code
     *     The code
     */
    public void setCode(String code) {
        this.code = code;
    }

    public Index withCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * 
     * @return
     *     The details
     */
    public String getDetails() {
        return details;
    }

    /**
     * 
     * @param details
     *     The details
     */
    public void setDetails(String details) {
        this.details = details;
    }

    public Index withDetails(String details) {
        this.details = details;
        return this;
    }

    /**
     * 
     * @return
     *     The index
     */
    public String getIndex() {
        return index;
    }

    /**
     * 
     * @param index
     *     The index
     */
    public void setIndex(String index) {
        this.index = index;
    }

    public Index withIndex(String index) {
        this.index = index;
        return this;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public Index withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     *     The otherName
     */
    public String getOtherName() {
        return otherName;
    }

    /**
     * 
     * @param otherName
     *     The otherName
     */
    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public Index withOtherName(String otherName) {
        this.otherName = otherName;
        return this;
    }



}
