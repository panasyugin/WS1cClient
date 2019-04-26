
package ws1c.client;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://interrao.ru/UH/DashBoard}TableCreditsLoans"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "_return"
})
@XmlRootElement(name = "GetAverageWeightedRatesResponse")
public class GetAverageWeightedRatesResponse {

    @XmlElement(name = "return", required = true)
    protected TableAverageWeightedRates _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link TableAverageWeightedRates }
     *     
     */
    public TableAverageWeightedRates getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableAverageWeightedRates }
     *     
     */
    public void setReturn(TableAverageWeightedRates value) {
        this._return = value;
    }

}
