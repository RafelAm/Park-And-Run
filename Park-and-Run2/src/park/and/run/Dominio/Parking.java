/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package park.and.run.Dominio;

import Exceptions.NotSpaceForParking;
import Vehiculos.Coche;
import Vehiculos.Moto;
import Vehiculos.Vehiculo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raffs
 */
public abstract class Parking implements Acciones {

    // Nombre del Parking
    public String nombre;
    // Plazas de motos
    public int plazasMotos;
    // Plazas de coches
    public int plazasCoches;
    // Lista donde se van a guardar los vehiculos que entran
    public List<Vehiculo> parked;

    public boolean status;

    // Constructor
    public Parking(String nombre, int plazasMotos, int plazasCoches) {
        this.nombre = nombre;
        this.plazasMotos = plazasMotos;
        this.plazasCoches = plazasCoches;
        parked = new ArrayList<>();
        this.status = true;
    }
        public Parking() {
            
    }

    // Getter del nombre del Parking
    public String getNombre() {
        return nombre;
    }

    // Getter para sacar las plazas de motos
    public int getPlazasMotos() {
        return plazasMotos;
    }

    // Getter para sacar las plazas de coches
    public int getPlazasCoches() {
        return plazasCoches;
    }

    // Getter del total de todas las plazas
    public int getPlazas() {
        return plazasCoches + plazasMotos;
    }

    // Getter para consultar los vehiculos aparcados en el interior del parking
    public List<Vehiculo> getParked() {
        return new ArrayList<>(parked);
    }

    public boolean getSatus() {
        return status;
    }



    // Getter para sacar la capacidad total de las motos
    public int getCapacidadMoto() {
        int plazasMaxMotos = 0;
       
        for (Vehiculo Moto : parked) {
            if (Moto.getIdentificador() == "Moto" && plazasMaxMotos < getPlazasMotos()) {
                plazasMaxMotos++;
            }
        }
      
        return plazasMaxMotos;
    }

    // Getter para sacar la capacidad total de los coches
    public int getCapacidadCoche() {
        int plazasMaxCoche = 0;

        for (Vehiculo Coche : parked) {
            if (Coche.getIdentificador() == "Coche" && plazasMaxCoche < getPlazas()) {
                plazasMaxCoche++;
            }
        }
        return plazasMaxCoche;
    }
        // Getter para sacar la capacidad total de todos los vehiculos
    public int getCapacidad() {
        return getCapacidadMoto() + getCapacidadCoche();
    }

    // Setter para introducir los vehiculos en el parking, mirando a ver si hay plazas disponibles
    public void addVehiculo(Coche Coche) {
        try {
            if (getCapacidadCoche() == getPlazasCoches()) {
                throw new NotSpaceForParking("El vehiculo " + Coche.toString() + " no puede acceder porque no hay espacio.");
            }

            if (Coche.getIdentificador() == "Coche" && getCapacidadCoche() < getPlazasCoches() && status == true) {
                parked.add(Coche);
            }
        } catch (NotSpaceForParking e) {
            System.out.println(e.getMessage());
        }
    }

    public void addVehiculo(Moto Moto) {
        try {
            if (getCapacidadMoto() == getPlazasMotos()) {
                throw new NotSpaceForParking("El vehiculo " + Moto.toString() + " no puede acceder porque no hay espacio.");
            }
            if (Moto.getIdentificador() == "Moto" && getCapacidadMoto() < getPlazasMotos() && status == true) {
                parked.add(Moto);
            }
        } catch (NotSpaceForParking e) {
            System.out.println(e.getMessage());
        }

    }

    public void remove(String matricula){
        parked.remove(matricula);
    }
    
    // Getter de las ganancias totales si todos los vehiculos que hubiese en el parking se marcharan
    public int getGanancias() {
        int gTotales = 0;
        for (Vehiculo Coche : parked) {
            if (Coche.getIdentificador() == "Coche" && Coche.isTrabajador() == false) {
                gTotales += 4;
            }
        }
        for (Vehiculo Moto : parked) {
            if (Moto.getIdentificador() == "Moto" && Moto.isTrabajador() == false) {
                gTotales += 2;
            }
        }
        return gTotales;
    }

    // Getter oara conseguir el numero de trabajadores en el parking
    public int getTrabajadores() {
        int trabajadores = 0;
        for (Vehiculo vehiculo : parked) {
            if (vehiculo.isTrabajador() == true) {
                trabajadores++;
            }
        }
        return trabajadores;
    }

    public void apagarLuces() {
        System.out.println("Apagando luces");
    }

    public void encenderLuces() {
        System.out.println("Encendiendo luces");
    }

    public void cerrarPuertas() {
        if (status == true) {
            System.out.println("Cerrando puertas.");
            this.status = false;
            apagarLuces();
        } else {
            System.out.println("El parking ya esta cerrado.");
        }
    }

    public void abrirPuertas() {
        if (status == false) {
            System.out.println("Abriendo puertas.");
            this.status = true;
            encenderLuces();
        } else {
            System.out.println("El parking ya esta abierto.");
        }
    }
}
