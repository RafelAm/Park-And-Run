package park.and.run.Dominio;

import Exceptions.NotSpaceForParking;
import Vehiculos.Coche;
import Vehiculos.Moto;
import Vehiculos.Vehiculo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author raffs
 */
public class MegaParking extends Parking {
    // Integer del numero de plantas que tiene el parking.
    private int plantas;

    // Constructor
    public MegaParking(String nombre, int plazasMotos, int plazasCoches, int plantas) {
        super(nombre, plazasMotos, plazasCoches);
        this.plantas = plantas;
    }
    // Constructor vacio
    public MegaParking() {

    }

    // Getter para sacar las plantas.
    public int getPlantas() {
        return plantas;
    }

    // Getter para conseguir las plazas totales del parking
    public int getPlazasPorPlantas() {
        return (plazasMotos * plantas) + (plazasCoches * plantas);
    }

    // Getter para conseguir las plazas totales de motos
    public int getPlazasPorPlantaMoto() {
        return plazasMotos * plantas;
    }

    // Getter para conseguir las plazas totales de coches
    public int getPlazasPorPlantaCoche() {
        return (plazasCoches * plantas);
    }

    // Getter para conseguir la capacidad de los coches
    public int getCapacidadCoches() {
        int plazasMaxCoche = 0;

        for (Vehiculo Coche : parked) {
            if (Coche.getIdentificador() == "Coche" && plazasMaxCoche < getPlazasPorPlantas()) {
                plazasMaxCoche++;
            }
        }
        return plazasMaxCoche;
    }

    // Getter para conseguir la capacidad de las motos
    public int getCapacidadMotos() {
        int plazasMaxMoto = 0;
        for (Vehiculo Moto : parked) {
            if (Moto.getIdentificador() == "Moto" && plazasMaxMoto < getPlazasPorPlantas()) {
                plazasMaxMoto++;
            }
        }
        return plazasMaxMoto;
    }
    // Getter para sacar la capacidad de las plantas
    public int getCapacidadPlantas() {
        return getCapacidadCoches() + getCapacidadMotos();
    }

    // Setter para introducir los vehiculos en el parking, mirando a ver si hay plazas disponibles
    public void addVehiculoPlantas(Coche Coche) {
        try {
            if (getCapacidadCoches() == getPlazasPorPlantaCoche()) {
                throw new NotSpaceForParking("El vehiculo " + Coche.toString() + " no puede acceder porque no hay espacio.");
            }

            if (Coche.getIdentificador() == "Coche" && getCapacidadCoches() < getPlazasPorPlantaCoche() && status == true) {
                parked.add(Coche);
            } else if (status == false) {
                System.out.println("-----------------------------");
                System.out.println("El Parking se encuentra cerrado");
                System.out.println("-----------------------------");
            }
        } catch (NotSpaceForParking e) {
            System.out.println(e.getMessage());
        }
    }
    // Setter para introducir los vehiculos en el parking, mirando a ver si hay plazas disponibles
    public void addVehiculoPlantas(Moto Moto) {
        try {
            if (getCapacidadMotos() == getPlazasPorPlantaMoto()) {
                throw new NotSpaceForParking("El vehiculo " + Moto.toString() + " no puede acceder porque no hay espacio.");
            }
            if (Moto.getIdentificador() == "Moto" && getCapacidadMotos() < getPlazasPorPlantaMoto() && status == true) {
                parked.add(Moto);
            } else if (status == false) {
                System.out.println("-----------------------------");
                System.out.println("El Parking se encuentra cerrado");
                System.out.println("-----------------------------");
            }
        } catch (NotSpaceForParking e) {
            System.out.println(e.getMessage());
        }

    }
    // Metodo para introducir cada Vehiculo en la base de datos con toda la informaci�n de estos
    public void addVehiculosSQL(String url, String usuario, String contrase�a) {
        try (Connection conexion = DriverManager.getConnection(url, usuario, contrase�a)) {
            // Sentencia SQL de inserci�n con par�metros
            for (Vehiculo vehiculo : parked) {
                String sql = "INSERT INTO vehiculos (Nombre_Parking ,Tipo_Vehiculo, Matricula, Trabajador) VALUES ('" + nombre + "','" + vehiculo.getIdentificador() + "','" + vehiculo.getMatricula() + "', '" + vehiculo.isTrabajador() + "')";

                // Crear un PreparedStatement para evitar SQL injection y mejorar la eficiencia
                try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
                    // Establecer los valores de los par�metros
                    pstmt.setString(1, "Nombre_Parking");
                    pstmt.setString(2, "Tipo_Vehiculo");
                    pstmt.setString(3, "Matricula");
                    pstmt.setString(4, "Trabajador");

                    // Ejecutar la sentencia SQL de inserci�n
                    int filasAfectadas = pstmt.executeUpdate();

                    // Verificar si la conexi�n ha sido buena
                    if (filasAfectadas > 0) {
                        System.out.println("Datos insertados correctamente.");
                    } else {
                        System.out.println("No se pudo insertar los datos.");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
    // Eliminar vehiculo del Parking (ArrayList)
    public void remVehiculo(String matricula) {
        for (int i = 0; i < parked.size(); i++) {

            if (matricula.equals(parked.get(i).getMatricula())) {
                System.out.println("Vehiculo recogido.");
                parked.remove(i);
            }

        }
    }
    // Auto Generaciones de NetBeans
    public void add() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
