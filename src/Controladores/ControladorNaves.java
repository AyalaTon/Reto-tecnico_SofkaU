/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import BD.Conexion;
import Clases.NaveEspacial;
import Clases.Origen;
import Interfaces.IControladorNaves;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author milto
 */
public class ControladorNaves implements IControladorNaves{

    private List<NaveEspacial> naves;
    private List<Origen> origenes;
    private static ControladorNaves instancia;
    
    public ControladorNaves() {
    }
    public static ControladorNaves getInstance() {
        if (instancia == null) {
            instancia = new ControladorNaves();
        }
        return instancia;
    }
    
    public List<NaveEspacial> getNaves() {
        List<NaveEspacial> naves = new ArrayList<>();
        naves = Conexion.getInstance().getNaves();
        return naves;
    }
    public List<NaveEspacial> getTripuladasAndNoTripuladas() {
        List<NaveEspacial> naves = new ArrayList<>();
        
        List<NaveEspacial> navesActivas = new ArrayList<>();
        naves = Conexion.getInstance().getTripuladasAndNoTripuladas();
        Date today = new Date();
        for(NaveEspacial p : naves){
            if(!p.getFinActividad().before(today)){
                navesActivas.add(p);
            }
        }
        return navesActivas;
    }
    public List<NaveEspacial> getVehiculosLanzadera() {
        List<NaveEspacial> naves = new ArrayList<>();
        List<NaveEspacial> navesActivas = new ArrayList<>();
        naves = Conexion.getInstance().getVehiculosLanzadera();
        Date today = new Date();
        for(NaveEspacial p : naves){
            if(!p.getFinActividad().before(today)){
                navesActivas.add(p);
            }
        }
        return navesActivas;
    }
    
    public boolean save(Object obj) {
        return Conexion.getInstance().save(obj);
    }
    public boolean merge(Object obj) {
        return Conexion.getInstance().merge(obj);
    }
    
    public List<NaveEspacial> buscarNaves(String buscar){
        return Conexion.getInstance().buscarNaves(buscar);
    }
    
    public List<Origen> getOrigenes() {
        List<Origen> origenes = new ArrayList<>();
        origenes = Conexion.getInstance().getOrigenes();
        return origenes;
    }
    public Origen getOrigen(String nombre) {
        return Conexion.getInstance().getOrigen(nombre);
    }
    public boolean existeOrigen(String nombre) {
        return Conexion.getInstance().existeOrigen(nombre);
    }
}
