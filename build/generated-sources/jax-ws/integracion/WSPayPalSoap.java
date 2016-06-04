
package integracion;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WSPayPalSoap", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSPayPalSoap {


    /**
     * 
     * @param tp
     * @return
     *     returns integracion.PagarPayPalResponse
     */
    @WebMethod(operationName = "Pagar", action = "http://tempuri.org/Pagar")
    @WebResult(name = "PagarResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "Pagar", targetNamespace = "http://tempuri.org/", className = "integracion.Pagar")
    @ResponseWrapper(localName = "PagarResponse", targetNamespace = "http://tempuri.org/", className = "integracion.PagarResponse")
    public PagarPayPalResponse pagar(
        @WebParam(name = "tp", targetNamespace = "http://tempuri.org/")
        PagarRequest tp);

    /**
     * 
     * @param request
     * @return
     *     returns integracion.LoginPayPalResponse
     */
    @WebMethod(operationName = "Login", action = "http://tempuri.org/Login")
    @WebResult(name = "LoginResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "Login", targetNamespace = "http://tempuri.org/", className = "integracion.Login")
    @ResponseWrapper(localName = "LoginResponse", targetNamespace = "http://tempuri.org/", className = "integracion.LoginResponse")
    public LoginPayPalResponse login(
        @WebParam(name = "request", targetNamespace = "http://tempuri.org/")
        LoginRequest request);

}
