/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author milto
 */
@Entity
public class Tripulada extends NaveEspacial implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    private String proposito;
    private int tripulantes; // NUMERO MAXIMO DE TRIPULANTES

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    public int getTripulantes() {
        return tripulantes;
    }

    public void setTripulantes(int tripulantes) {
        this.tripulantes = tripulantes;
    }
    
    public Long getId() {
        return super.getId();
    }

    public void setId(Long id) {
        super.setId(id);
    }

    
    public boolean despegar(int cantidadTripulantes){ // Desde una Avion o similar a altura de la estratosfera 
        int random = (int) Math.floor(Math.random()*10+1); // Puede tener exito o no, dependerá de el azar como simulación
        if(random <= 8){ // Exito
            return true;
        } else { // Fracaso se da como destruido por lo que se settea como fuera de actividad
            this.finalizarActividad();
            return false;
        }
    }
    
    public boolean despegar(VehiculoLanzadera vehiculo, int cantidadTripulantes){ // Desde una un Vehiculo Lanzadera que se selecciona en la vista
        int random = (int) Math.floor(Math.random()*10+1); // Puede tener exito o no, dependerá de el azar como simulación
        if(random <= 8){ // Exito
            return true;
        } else { // Fracaso se dan como destruidos por lo que se settean como fuera de actividad y los tripulantes pierden la vida
            this.finalizarActividad();
            vehiculo.finalizarActividad();
            return false;
        }
    }
    @Override
    public String toString() {
        return "" + super.getNombre();
    }
    
}
