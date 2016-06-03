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
public interface UsuariosxgrupoFacadeLocal {

    void create(Usuariosxgrupo usuariosxgrupo);

    void edit(Usuariosxgrupo usuariosxgrupo);

    void remove(Usuariosxgrupo usuariosxgrupo);

    Usuariosxgrupo find(Object id);

    List<Usuariosxgrupo> findAll();

    List<Usuariosxgrupo> findRange(int[] range);

    int count();
    
}
