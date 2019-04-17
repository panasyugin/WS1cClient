
package ws1c.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "GetDataForDashBoardPortType", targetNamespace = "http://interrao.ru/UH/DashBoard")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface GetDataForDashBoardPortType {


    /**
     * 
     * @param forecastingPeriod
     * @return
     *     returns ws1c.client.TableCreditsLoans
     */
    @WebMethod(operationName = "GetLoanData", action = "http://interrao.ru/UH/DashBoard#GetDataForDashBoard:GetLoanData")
    @WebResult(targetNamespace = "http://interrao.ru/UH/DashBoard")
    @RequestWrapper(localName = "GetLoanData", targetNamespace = "http://interrao.ru/UH/DashBoard", className = "ws1c.client.GetLoanData")
    @ResponseWrapper(localName = "GetLoanDataResponse", targetNamespace = "http://interrao.ru/UH/DashBoard", className = "ws1c.client.GetLoanDataResponse")
    public TableCreditsLoans getLoanData(
        @WebParam(name = "forecastingPeriod", targetNamespace = "http://interrao.ru/UH/DashBoard")
        XMLGregorianCalendar forecastingPeriod);

    /**
     * 
     * @param forecastingPeriod
     * @return
     *     returns ws1c.client.TableCreditsLoans
     */
    @WebMethod(operationName = "GetMaxDebt", action = "http://interrao.ru/UH/DashBoard#GetDataForDashBoard:GetMaxDebt")
    @WebResult(targetNamespace = "http://interrao.ru/UH/DashBoard")
    @RequestWrapper(localName = "GetMaxDebt", targetNamespace = "http://interrao.ru/UH/DashBoard", className = "ws1c.client.GetMaxDebt")
    @ResponseWrapper(localName = "GetMaxDebtResponse", targetNamespace = "http://interrao.ru/UH/DashBoard", className = "ws1c.client.GetMaxDebtResponse")
    public TableCreditsLoans getMaxDebt(
        @WebParam(name = "forecastingPeriod", targetNamespace = "http://interrao.ru/UH/DashBoard")
        XMLGregorianCalendar forecastingPeriod);

}
