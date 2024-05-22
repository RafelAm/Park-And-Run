package park.and.run.Dominio;

/**
 *
 * @author raffs
 */
// Interfaz que define metodos de acciones para el Parking
// Estos se deben reescribir en las clases hijas
public interface Acciones {
    
    public void apagarLuces();
    
    public void encenderLuces();
    
    public void cerrarPuertas();
    
    public void abrirPuertas();
    
}
