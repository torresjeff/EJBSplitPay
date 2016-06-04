/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import integracion.LoginPayPalResponse;
import integracion.LoginRequest;
import integracion.WSPayPal;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Sid
 */
@Stateless
public class FacadeMemberToMember implements FacadeMemberToMemberRemote {

    @WebServiceRef(wsdlLocation = "META-INF/wsdl/localhost_63033/WSPayPal.asmx.wsdl")
    private WSPayPal service;

    @Override
    public String Hello() {
        return "Hello from Member to Member";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public LoginPayPalResponse LoginPayPal(LoginRequest request) {
        
        return login(request);
    }
    
    

    private LoginPayPalResponse login(integracion.LoginRequest request) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        integracion.WSPayPalSoap port = service.getWSPayPalSoap();
        return port.login(request);
    }
    
}
