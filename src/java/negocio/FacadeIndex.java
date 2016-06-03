/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import DTO.GetGroupsRequest;
import DTO.GetGroupsResponse;
import entities.Grupo;
import entities.GrupoFacadeLocal;
import entities.Usuariosxgrupo;
import entities.UsuariosxgrupoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Sid
 */
@Stateless
public class FacadeIndex implements FacadeIndexRemote {

    @EJB
    private UsuariosxgrupoFacadeLocal usuariosxgrupoFacade;

    

    @Override
    public GetGroupsResponse GetGroups(GetGroupsRequest request) {
        GetGroupsResponse response = new GetGroupsResponse();
        List<Usuariosxgrupo> usuariosxgrupo = usuariosxgrupoFacade.findAll();
        
        for (Usuariosxgrupo uxg : usuariosxgrupo) {
            if (uxg.getUsuario().getId().intValue() == request.userId) {
                response.grupos.add(uxg.getGrupo());
            }
        }
        
        return response;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
