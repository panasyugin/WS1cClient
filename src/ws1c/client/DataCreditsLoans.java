
package ws1c.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DataCreditsLoans complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataCreditsLoans">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="companyID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="companyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="companyType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="segment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="territoriality" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="creditorID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="creditorName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="creditSecurity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="loanPeriod" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="loanForm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="limit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="balanceDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="remainingDebt" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="remainingDebtInCurrency" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataCreditsLoans", propOrder = {
    "companyID",
    "companyName",
    "companyType",
    "segment",
    "territoriality",
    "creditorID",
    "creditorName",
    "creditSecurity",
    "loanPeriod",
    "loanForm",
    "currency",
    "limit",
    "balanceDate",
    "remainingDebt",
    "remainingDebtInCurrency"
})
public class DataCreditsLoans {

    @XmlElement(required = true)
    protected String companyID;
    @XmlElement(required = true, nillable = true)
    protected String companyName;
    @XmlElement(required = true)
    protected String companyType;
    @XmlElement(required = true)
    protected String segment;
    @XmlElement(required = true)
    protected String territoriality;
    @XmlElement(required = true)
    protected String creditorID;
    @XmlElement(required = true)
    protected String creditorName;
    @XmlElement(required = true)
    protected String creditSecurity;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar loanPeriod;
    @XmlElement(required = true)
    protected String loanForm;
    @XmlElement(required = true)
    protected String currency;
    protected double limit;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar balanceDate;
    protected double remainingDebt;
    protected double remainingDebtInCurrency;

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
     * Gets the value of the companyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * Sets the value of the companyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyType(String value) {
        this.companyType = value;
    }

    /**
     * Gets the value of the segment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegment() {
        return segment;
    }

    /**
     * Sets the value of the segment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegment(String value) {
        this.segment = value;
    }

    /**
     * Gets the value of the territoriality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerritoriality() {
        return territoriality;
    }

    /**
     * Sets the value of the territoriality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerritoriality(String value) {
        this.territoriality = value;
    }

    /**
     * Gets the value of the creditorID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditorID() {
        return creditorID;
    }

    /**
     * Sets the value of the creditorID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditorID(String value) {
        this.creditorID = value;
    }

    /**
     * Gets the value of the creditorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditorName() {
        return creditorName;
    }

    /**
     * Sets the value of the creditorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditorName(String value) {
        this.creditorName = value;
    }

    /**
     * Gets the value of the creditSecurity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditSecurity() {
        return creditSecurity;
    }

    /**
     * Sets the value of the creditSecurity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditSecurity(String value) {
        this.creditSecurity = value;
    }

    /**
     * Gets the value of the loanPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLoanPeriod() {
        return loanPeriod;
    }

    /**
     * Sets the value of the loanPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLoanPeriod(XMLGregorianCalendar value) {
        this.loanPeriod = value;
    }

    /**
     * Gets the value of the loanForm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoanForm() {
        return loanForm;
    }

    /**
     * Sets the value of the loanForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoanForm(String value) {
        this.loanForm = value;
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
    public double getLimit() {
        return limit;
    }

    /**
     * Sets the value of the limit property.
     * 
     */
    public void setLimit(double value) {
        this.limit = value;
    }

    /**
     * Gets the value of the balanceDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBalanceDate() {
        return balanceDate;
    }

    /**
     * Sets the value of the balanceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBalanceDate(XMLGregorianCalendar value) {
        this.balanceDate = value;
    }

    /**
     * Gets the value of the remainingDebt property.
     * 
     */
    public double getRemainingDebt() {
        return remainingDebt;
    }

    /**
     * Sets the value of the remainingDebt property.
     * 
     */
    public void setRemainingDebt(double value) {
        this.remainingDebt = value;
    }

    /**
     * Gets the value of the remainingDebtInCurrency property.
     * 
     */
    public double getRemainingDebtInCurrency() {
        return remainingDebtInCurrency;
    }

    /**
     * Sets the value of the remainingDebtInCurrency property.
     * 
     */
    public void setRemainingDebtInCurrency(double value) {
        this.remainingDebtInCurrency = value;
    }

}
