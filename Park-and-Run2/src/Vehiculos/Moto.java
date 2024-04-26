/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculos;

/**
 *
 * @author raffs
 */
public class Moto extends Vehiculo {

    // Identificador para indicar que es una moto.
    private final String identificador;

    // Constructor
    public Moto(String matricula, boolean trabajador) {
        super(matricula, trabajador);
        this.identificador = "Moto";
    }

    // Getter del identificador.
    public String getIdentificador() {
        return identificador;
    }

    // Metodo para añadir el identificador y la matricula al ArrayList.
    @Override
    public String toString() {
        return "Moto:" + matricula;
    }
}
