/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Hector
 */
public interface Crud {
    
    public abstract boolean agregar();
    public abstract boolean listar();
    public abstract boolean actualizar();
    public abstract boolean eliminar(int id);
    
}
