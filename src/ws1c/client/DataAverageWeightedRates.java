
package ws1c.client;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DataCreditsLoans complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataAverageWeightedRates">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="companyID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="companyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="averageWeightedRate" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataAverageWeightedRates", propOrder = {
    "companyID",
    "companyName",
    "currency",
    "averageWeightedRate",
})
public class DataAverageWeightedRates {

    @XmlElement(required = true)
    protected String companyID;
    @XmlElement(required = true, nillable = true)
    protected String companyName;
    protected String currency;
    protected double averageWeightedRate;

    /**
     * Gets the value of the companyID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyID() {
        return companyID;
    }

    /**
     * Sets the value of the companyID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyID(String value) {
        this.companyID = value;
    }

    /**
     * Gets the value of the companyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the value of the companyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyName(String value) {
        this.companyName = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the limit property.
     * 
     */
    public double getAverageWeightedRate() {
        return averageWeightedRate;
    }

    /**
     * Sets the value of the limit property.
     * 
     */
    public void setAverageWeightedRate(double averageWeightedRate) {
        this.averageWeightedRate = averageWeightedRate;
    }
}
