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
public interface PendientecierreFacadeLocal {

    void create(Pendientecierre pendientecierre);

    void edit(Pendientecierre pendientecierre);

    void remove(Pendientecierre pendientecierre);

    Pendientecierre find(Object id);

    List<Pendientecierre> findAll();

    List<Pendientecierre> findRange(int[] range);

    int count();
    
}
