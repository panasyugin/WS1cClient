
package ws1c.client;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="forecastingPeriod" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
    "forecastingPeriod"
})
@XmlRootElement(name = "GetAverageWeightedRates")
public class GetAverageWeightedRates {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar forecastingPeriod;

    /**
     * Gets the value of the forecastingPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getForecastingPeriod() {
        return forecastingPeriod;
    }

    /**
     * Sets the value of the forecastingPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setForecastingPeriod(XMLGregorianCalendar value) {
        this.forecastingPeriod = value;
    }

}
