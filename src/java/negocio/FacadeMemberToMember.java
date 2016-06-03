/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import javax.ejb.Stateless;

/**
 *
 * @author Sid
 */
@Stateless
public class FacadeMemberToMember implements FacadeMemberToMemberRemote {

    @Override
    public String Hello() {
        return "Hello from Member to Member";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
