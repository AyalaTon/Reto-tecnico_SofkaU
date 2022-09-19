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
public class NoTripulada extends NaveEspacial implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    public Long getId() {
        return super.getId();
    }

    public void setId(Long id) {
        super.setId(id);
    }

    
    @Override
    public boolean despegar(){ // Desde una Avion o similar a altura de la estratosfera
        int random = (int) Math.floor(Math.random()*10+1); // Puede tener exito o no, dependerá de el azar como simulación
        if(random <= 8){ // Exito
            return true;
        } else { // Fracaso se da como destruido por lo que se settea como fuera de actividad
            this.finalizarActividad();
            return false;
        }
    }
    
    public boolean despegar(VehiculoLanzadera vehiculo){ // Desde una un Vehiculo Lanzadera que se selecciona en la vista
        int random = (int) Math.floor(Math.random()*10+1); // Puede tener exito o no, dependerá de el azar como simulación
        if(random <= 8){ // Exito
            return true;
        } else { // Fracaso se dan como destruidos por lo que se settean como fuera de actividad
            this.finalizarActividad();
            vehiculo.finalizarActividad();
            return false;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof NoTripulada)) {
//            return false;
//        }
//        NoTripulada other = (NoTripulada) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "" + super.getNombre();
    }
    
}
