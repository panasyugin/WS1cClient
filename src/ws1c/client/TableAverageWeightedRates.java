
package ws1c.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for TableAverageWeightedRates complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TableAverageWeightedRates">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataAverageWeightedRates" type="{http://interrao.ru/UH/DashBoard}DataCreditsLoans" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TableAverageWeightedRates", propOrder = {
    "dataAverageWeightedRates"
})
public class TableAverageWeightedRates {

    @XmlElement(required = true)
    protected List<DataAverageWeightedRates> dataAverageWeightedRates;

    /**
     * Gets the value of the dataCreditsLoans property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataCreditsLoans property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataAverageWeightedRates().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataAverageWeightedRates }
     * 
     * 
     */
    public List<DataAverageWeightedRates> getDataAverageWeightedRates() {
        if (dataAverageWeightedRates == null) {
            dataAverageWeightedRates = new ArrayList<DataAverageWeightedRates>();
        }
        return this.dataAverageWeightedRates;
    }

}
