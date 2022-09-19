/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica;

import Controladores.ControladorNaves;
import Interfaces.IControladorNaves;

/**
 *
 * @author milto
 */
public class Fabrica {
    private static Fabrica instancia;
    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;
    }
    
    public IControladorNaves getIControladorNaves() {
        IControladorNaves ControladorN = ControladorNaves.getInstance();
        return ControladorN;
    }
}
