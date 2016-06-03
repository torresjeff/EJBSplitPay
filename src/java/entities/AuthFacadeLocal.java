/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sid
 */
@Local
public interface AuthFacadeLocal {

    void create(Auth auth);

    void edit(Auth auth);

    void remove(Auth auth);

    Auth find(Object id);

    List<Auth> findAll();

    List<Auth> findRange(int[] range);

    int count();
    
}
