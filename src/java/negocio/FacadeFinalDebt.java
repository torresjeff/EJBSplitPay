/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import DTO.FinalDebtResponse;
import DTO.GetGroupUsersRequest;
import DTO.GetGroupUsersResponse;
import entities.Usuario;
import entities.Usuariosxgrupo;
import entities.UsuariosxgrupoFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Sid
 */
@Stateless
public class FacadeFinalDebt implements FacadeFinalDebtRemote {

    @EJB
    private UsuariosxgrupoFacadeLocal usuariosxgrupoFacade;
    
    
    @Override
    public String Hello() {
        return "Hello from Final Debt 3";
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public FinalDebtResponse FinalDebtResolution(DTO.FinalDebtRequest request) {
        FinalDebtResponse response =  new FinalDebtResponse();
        List<Usuariosxgrupo> usuariosxgrupo = usuariosxgrupoFacade.findAll();
        List<Usuario> usuariosDebt = new ArrayList<>();
        int totalDebt = 0;
        for (Usuariosxgrupo uxg : usuariosxgrupo) {
            if (uxg.getGrupo().getId().intValue() == request.groupId) {
                usuariosDebt.add(uxg.getUsuario());
                
                totalDebt += uxg.getDeuda().intValue();
            }
        }
        
        return response;
    }

    @Override
    public GetGroupUsersResponse GetGroupUsers(GetGroupUsersRequest request) {
        GetGroupUsersResponse response =  new GetGroupUsersResponse();
        List<Usuariosxgrupo> usuariosxgrupo = usuariosxgrupoFacade.findAll();
        for (Usuariosxgrupo uxg : usuariosxgrupo) {
            if (uxg.getGrupo().getId().intValue() == request.groupId) {
                response.usuarios.add(uxg.getUsuario());
                
            }
        }
        
        return response;
    }
    
}
