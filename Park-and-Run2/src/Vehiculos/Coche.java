package Vehiculos;

/**
 *
 * @author raffs
 */
public class Coche extends Vehiculo{
    // Identificador para indicar que es un coche
    private final String identificador;
    // Constructor
    public Coche(String matricula, boolean trabajador) {
        super(matricula, trabajador);
        this.identificador = "Coche";
    }

    // Getter del identificador
    public String getIdentificador() {
        return identificador;
    }
    
    // Metodo para añadir el identificador y la matricula al ArrayList.
    @Override
    public String toString() {
        return "Coche:"+ matricula;
    }
    
    
}
