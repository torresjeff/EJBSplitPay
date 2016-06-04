/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import DTO.LoginSplitPayRequest;
import DTO.LoginSplitPayResponse;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import negocio.FacadeLoginRemote;

/**
 *
 * @author Sid
 */
@WebService(serviceName = "WSSplitPay")
@Stateless()
public class WSSplitPay {

    @EJB
    private FacadeLoginRemote ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "Login")
    public LoginSplitPayResponse Login(@WebParam(name = "request") LoginSplitPayRequest request) {
        return ejbRef.Login(request);
    }
    
}
