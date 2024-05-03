/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculos;


/**
 *
 * @author raffs
 */
public abstract class Vehiculo{

    // Matricula del vehiculo para poder identificar cada vehiculo
    final String matricula;
    // Booleano que nos indica si trabaja en el parking
    // Si trabaja en el parking esta exento de pagar.
    private final boolean trabajador;

    // Constructor
    public Vehiculo(String matricula, boolean trabajador) {
        this.matricula = matricula;
        this.trabajador = trabajador;
    }
    
    // Getter de si es trabajador
    public boolean isTrabajador(){
        return trabajador;
    }
    
    // Getter de la matricula
    public String getMatricula(){
        return matricula;
    }

    public String getIdentificador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
