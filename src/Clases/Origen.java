/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author milto
 */
@Entity
public class Origen implements Serializable {

    @OneToMany(mappedBy = "origen")
    private List<NaveEspacial> navesEspaciales;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;

    public List<NaveEspacial> getNavesEspaciales() {
        return navesEspaciales;
    }

    public void setNavesEspaciales(List<NaveEspacial> navesEspaciales) {
        this.navesEspaciales = navesEspaciales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "" + nombre;
    }
    
}
