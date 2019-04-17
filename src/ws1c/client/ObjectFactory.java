
package ws1c.client;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws1c.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws1c.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMaxDebtResponse }
     * 
     */
    public GetMaxDebtResponse createGetMaxDebtResponse() {
        return new GetMaxDebtResponse();
    }

    /**
     * Create an instance of {@link TableCreditsLoans }
     * 
     */
    public TableCreditsLoans createTableCreditsLoans() {
        return new TableCreditsLoans();
    }

    /**
     * Create an instance of {@link GetMaxDebt }
     * 
     */
    public GetMaxDebt createGetMaxDebt() {
        return new GetMaxDebt();
    }

    /**
     * Create an instance of {@link GetLoanData }
     * 
     */
    public GetLoanData createGetLoanData() {
        return new GetLoanData();
    }

    /**
     * Create an instance of {@link GetLoanDataResponse }
     * 
     */
    public GetLoanDataResponse createGetLoanDataResponse() {
        return new GetLoanDataResponse();
    }

    /**
     * Create an instance of {@link DataCreditsLoans }
     * 
     */
    public DataCreditsLoans createDataCreditsLoans() {
        return new DataCreditsLoans();
    }

}
