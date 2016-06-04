/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import DTO.LoginSplitPayRequest;
import DTO.LoginSplitPayResponse;
import entities.Auth;
import entities.AuthFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Sid
 */
@Stateless
public class FacadeLogin implements FacadeLoginRemote {

    @EJB
    private AuthFacadeLocal authFacade;

    @Override
    public LoginSplitPayResponse Login(LoginSplitPayRequest request) {
        LoginSplitPayResponse response = new LoginSplitPayResponse();
        
        List<Auth> auths = authFacade.findAll();
        
        for (Auth auth : auths) {
            if (auth.getCc().equals(request.cc) && auth.getPassword().equals(request.password)) {
                response.userId = auth.getUsuario().getId().intValue();
                return response;
            }
        }
        
        response.operationError = "Usuario o contraseña incorrectos";
        return response;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
