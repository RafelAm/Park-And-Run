/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package park.and.run.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Vehiculos.Coche;
import Vehiculos.Moto;
import park.and.run.Dominio.MegaParking;

/**
 *
 * @author raffs
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Parámetros de conexión
        String url = "jdbc:mariadb://localhost:3306/park-and-run";
        String usuario = "root";
        String contraseña = "072003";

        // Intentar establecer la conexión
        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión exitosa a la base de datos MariaDB");
            
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }

        // Parking de muestra
        MegaParking test = new MegaParking("Plaza de España", 1, 2, 2);
        // Vehiculos de muestra
        Coche C1 = new Coche("1422 KDF", false);
        Moto M1 = new Moto("4125 MGG", false);
        Coche C2 = new Coche("0024 BBD", false);
        Moto M2 = new Moto("7455 JCD", false);
        Moto M3 = new Moto("7455 JCD", false);
        Coche C3 = new Coche("2014 DCS", false);
        Coche C4 = new Coche("1542 CHL", false);
        Coche C5 = new Coche("0021 BBD", false);

        // Introduccion de vehiculos al parking
        // Si las plantas son 0 utiliza el metodo de la clase abstracta Parking77
        // Si no la de MegaParking
        if (test.getPlantas() == 0) {
            test.addVehiculo(C1);
            test.addVehiculo(M1);
            test.addVehiculo(C2);
            test.addVehiculo(M2);
            test.addVehiculo(M3);
            test.addVehiculo(C3);
            test.addVehiculo(C4);
            test.addVehiculo(C5);
        } else {
            test.addVehiculoPlantas(C1);
            test.addVehiculoPlantas(M1);
            test.addVehiculoPlantas(C2);
            test.addVehiculoPlantas(M2);
            test.addVehiculoPlantas(M3);
            test.addVehiculoPlantas(C3);
            test.addVehiculoPlantas(C4);
            test.addVehiculoPlantas(C5);
        }
        test.addVehiculosSQL(url, usuario, contraseña);

        // Información general del Parking
        
        // Muestra el nombre del parking
        System.out.println("\nParking: " + test.getNombre());
        // Muestra la lista de vehiculos en el parking
        System.out.println("Vehiculos en el interior del Parking:" + "\n \n" + test.getParked() + "\n");
        // Muestra cuantos vehiculos de trabajadores hay
        System.out.println("Hay " + test.getTrabajadores() + " vehiculos de trabajadores.");

        // Si las plantas son 0 
        // Utiliza los metodos de la clase Parking
        // Si no usa los de la clase MegaParking
        if (test.getPlantas() == 0) {
            System.out.println("Motos: " + test.getCapacidadMoto());
            System.out.println("Coches: " + test.getCapacidadCoche() + "\n");
            System.out.println("La capacidad esta al: " + test.getCapacidad() + "/" + test.getPlazas());
        } else {
            System.out.println("Motos: " + test.getPlazasPorPlantaMoto());
            System.out.println("Coches: " + test.getPlazasPorPlantaCoche());
            System.out.println("La capacidad esta al: " + test.getCapacidadPlantas() + "/" + test.getPlazasPorPlantas());
        }
        // Muestra las ganancias totales si los vehiculos saliesen del parking
        System.out.println("Al vaciarse el Parking el ingreso va a ser de: " + test.getGanancias() + "€");
    }

}
