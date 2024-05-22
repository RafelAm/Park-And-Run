package Vehiculos;


/**
 *
 * @author raffs
 */
public abstract class Vehiculo{

    // Matricula del vehiculo para poder identificar cada vehiculo
    protected String matricula;
    // Booleano que nos indica si trabaja en el parking
    // Si trabaja en el parking esta exento de pagar.
    protected final boolean trabajador;
    
    
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
    // toString que debe ser reescrito en las clases hijas
    public abstract String toString();
    
    
    // Auto Generaciones NetBeans
    public String getIdentificador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object matches(String matricula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
