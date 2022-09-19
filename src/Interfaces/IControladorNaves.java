/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.NaveEspacial;
import Clases.Origen;
import java.util.List;

/**
 *
 * @author milto
 */
public interface IControladorNaves {
    
    public abstract List<NaveEspacial> getNaves();
    public abstract List<NaveEspacial> getVehiculosLanzadera();
    public abstract List<NaveEspacial> getTripuladasAndNoTripuladas();
    public abstract boolean save(Object obj);
    public abstract boolean merge(Object obj);
    public abstract List<NaveEspacial> buscarNaves(String buscar);
    public abstract List<Origen> getOrigenes();
    public abstract Origen getOrigen(String nombre);
    public abstract boolean existeOrigen(String nombre);
    
}
