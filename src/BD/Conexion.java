/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Clases.NaveEspacial;
import Clases.NoTripulada;
import Clases.Origen;
import Clases.Tripulada;
import Clases.VehiculoLanzadera;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author milto
 */
public class Conexion {
    
    private Conexion() {
    }
    
    public static Conexion getInstance() {
        return ConexionHolder.INSTANCE;
    }
    
    private static class ConexionHolder {
        private static final Conexion INSTANCE = new Conexion();
        private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("RetoTecnicoPU");
        private static final EntityManager em = emf.createEntityManager();
    }

    public EntityManager getEntity(){
        return ConexionHolder.em;
    }
    
    public boolean save(Object object) {
        EntityManager em=getEntity();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }
    public boolean merge(Object object) {
        EntityManager em = getEntity();
        em.getTransaction().begin();
        try {
            em.merge(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }
    public boolean remove(Object object) {
        EntityManager em = getEntity();
        em.getTransaction().begin();
        try {
            em.remove(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }
    public boolean refresh(Object object) {
        EntityManager em = getEntity();
        em.getTransaction().begin();
        try {
            em.refresh(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }
    
    public boolean existeOrigen(String nombre){
        EntityManager em = getEntity();
        Origen resultado = null;
        em.getTransaction().begin();
        try {
            resultado = (Origen) em.createNativeQuery("SELECT * FROM origen WHERE nombre='" + nombre + "'", Origen.class).getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        if(resultado != null)
            return true;
        else 
            return false;
    }
    public Origen getOrigen(String nombre){
        EntityManager em = getEntity();
        Origen resultado = null;
        em.getTransaction().begin();
        try {
            resultado = (Origen) em.createNativeQuery("SELECT * FROM origen WHERE nombre='" + nombre + "'", Origen.class).getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return resultado;
    }
    public List<Origen> getOrigenes(){
        EntityManager em = getEntity();
        List<Origen> resultado = new ArrayList<>();
        em.getTransaction().begin();
        try {
            resultado = em.createNativeQuery("SELECT * FROM origen", Origen.class).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return resultado;
    }
    public List<NaveEspacial> getNaves(){
        EntityManager em = getEntity();
        List<NaveEspacial> resultado = new ArrayList<>();
        em.getTransaction().begin();
        try {
            resultado = em.createNativeQuery("SELECT * FROM naveespacial, notripulada WHERE naveespacial.id = notripulada.id", NoTripulada.class).getResultList();
            resultado.addAll(em.createNativeQuery("SELECT * FROM naveespacial, tripulada WHERE naveespacial.id = tripulada.id", Tripulada.class).getResultList());
            resultado.addAll(em.createNativeQuery("SELECT * FROM naveespacial, vehiculolanzadera WHERE naveespacial.id = vehiculolanzadera.id", VehiculoLanzadera.class).getResultList());
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return resultado;
    }
    public List<NaveEspacial> getTripuladasAndNoTripuladas(){
        EntityManager em = getEntity();
        List<NaveEspacial> resultado = new ArrayList<>();
        em.getTransaction().begin();
        try {
            resultado = em.createNativeQuery("SELECT * FROM naveespacial, notripulada WHERE naveespacial.id = notripulada.id", NoTripulada.class).getResultList();
            resultado.addAll(em.createNativeQuery("SELECT * FROM naveespacial, tripulada WHERE naveespacial.id = tripulada.id", Tripulada.class).getResultList());
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return resultado;
    }
    public List<NaveEspacial> getVehiculosLanzadera(){
        EntityManager em = getEntity();
        List<NaveEspacial> resultado = new ArrayList<>();
        em.getTransaction().begin();
        try {
            resultado = em.createNativeQuery("SELECT * FROM naveespacial, vehiculolanzadera WHERE naveespacial.id = vehiculolanzadera.id ", VehiculoLanzadera.class).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return resultado;
    }
    public List<NaveEspacial> buscarNaves(String buscar){
        EntityManager em = getEntity();
        List<NaveEspacial> resultado = new ArrayList<>();
        em.getTransaction().begin();
        try { // nombre origen combustible
            resultado = em.createNativeQuery("SELECT * FROM naveespacial, notripulada WHERE naveespacial.id = notripulada.id AND (nombre LIKE '%" + buscar + "%' OR combustible LIKE '%" + buscar + "%')", NoTripulada.class).getResultList();
            resultado.addAll(em.createNativeQuery("SELECT * FROM naveespacial, tripulada WHERE naveespacial.id = tripulada.id AND (nombre LIKE '%" + buscar + "%' OR combustible LIKE '%" + buscar + "%')", Tripulada.class).getResultList());
            resultado.addAll(em.createNativeQuery("SELECT * FROM naveespacial, vehiculolanzadera WHERE naveespacial.id = vehiculolanzadera.id AND (nombre LIKE '%" + buscar + "%' OR combustible LIKE '%" + buscar + "%')", VehiculoLanzadera.class).getResultList());
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return resultado;
    }
    
}
