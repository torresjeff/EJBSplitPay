/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sid
 */
@Stateless
public class AuthFacade extends AbstractFacade<Auth> implements AuthFacadeLocal {

    @PersistenceContext(unitName = "EJBSplitPayPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuthFacade() {
        super(Auth.class);
    }
    
}
