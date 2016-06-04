 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import DTO.FinalDebtResponse;
import DTO.GetGroupUsersRequest;
import DTO.GetGroupUsersResponse;
import DTO.MailMessage;
import entities.Usuario;
import entities.Usuariosxgrupo;
import entities.UsuariosxgrupoFacadeLocal;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.Queue;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Sid
 */
@Stateless
public class FacadeFinalDebt implements FacadeFinalDebtRemote {

    @Resource(mappedName = "jms/queueCorreos")
    private Queue queueCorreos;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

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
            sendJMSMessageToQueueCorreos(new MailMessage(uxg.getUsuario(), uxg.getGrupo()));
            if (uxg.getGrupo().getId().intValue() == request.groupId) {
                usuariosDebt.add(uxg.getUsuario());
                sendJMSMessageToQueueCorreos(new MailMessage(uxg.getUsuario(), uxg.getGrupo()));
                totalDebt += uxg.getDeuda().intValue();
                
            }
        }
        
        response.totalDebt = totalDebt;
        
        for (Usuariosxgrupo uxg : usuariosxgrupo) {
            if (uxg.getGrupo().getId().intValue() == request.groupId) {
                uxg.setDeuda(BigInteger.valueOf(totalDebt/usuariosDebt.size()));
            }
        }
        //TODO: agregar gurpo a la tabla PendienteCierre
        
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

    private void sendJMSMessageToQueueCorreos(MailMessage messageData) {
        
        //context.createProducer().send(queueCorreos, messageData);
        context.createProducer().send(queueCorreos, context.createObjectMessage(messageData));
    }
    
}
