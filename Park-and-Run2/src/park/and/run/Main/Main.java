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
import Vehiculos.Vehiculo;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.InputMismatchException;
import park.and.run.Dominio.MegaParking;
import java.util.Scanner;

/**
 *
 * @author raffs
 */
public class Main {

    static Scanner sc = new Scanner(System.in);

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

        // Inicialización de Parkings por defecto
        // Los parkings ya van a estar creados y solo debemos Indicar en cual estamos, y nos devolvera tickets etc.
        MegaParking Parking1 = new MegaParking("Son Castelló", 10, 25, 0);
        MegaParking Parking2 = new MegaParking("Passeig Maritim Palma", 25, 40, 2);
        MegaParking Parking3 = new MegaParking("Carrer Aragon", 20, 35, 2);

        int opcionParking = 0;
        String matricula;
        int tipo = 0;
        FileWriter fichero = null;
        PrintWriter pw = null;
        do {
            System.out.println("Bienvenido al Sistema de Parkings para aparcar y salir a entrenar");
            System.out.println("Los precios son: Moto 2€ Coche 4€ \n");
            System.out.println("Indica el Parking en el que te encuentras porfavor");
            System.out.println("1. Son Castello " + " | La capacidad esta al: " + Parking1.getCapacidad() + "/" + Parking1.getPlazas());
            System.out.println("2. Passeig Maritim Palma " + " | Capacidad: " + Parking2.getCapacidadPlantas() + "/" + Parking2.getPlazasPorPlantas());
            System.out.println("3. Carrer Aragón " + " | La capacidad esta al: " + Parking3.getCapacidadPlantas() + "/" + Parking3.getPlazasPorPlantas());
            System.out.println("4. Opciones Avanzadas");
            System.out.println("5. Salir");
            opcionParking = valNum();

            switch (opcionParking) {
                case 1:
                    System.out.println("Has seleccionado" + Parking1.getNombre());
                    System.out.println("Porfavor indica que vehiculo llevas (Coche = 1 / Moto = 2)");
                    tipo = valNum();
                    if (tipo == 1) {
                        System.out.println("Introduce tu matricula");
                        matricula = sc.next();
                        Coche test = new Coche(matricula.replaceAll(" ", ""), false);
                        Parking1.addVehiculo(test);

                    } else if (tipo == 2) {
                        System.out.println("Introduce tu matricula");
                        matricula = sc.next();

                        Moto test = new Moto(matricula.replaceAll(" ", ""), false);
                        Parking1.addVehiculo(test);
                    }

                    try {
                        int i = 0;
                        Date current = new Date();
                        for (Vehiculo vehiculo : Parking1.parked) {
                            String ruta = "C:\\Users\\raffs\\Desktop\\Grado Superior DAW\\Programación\\Park-And-Run\\Tickets\\Ticket n" + i + " " + Parking1.getNombre() + ".txt";
                            fichero = new FileWriter(ruta);
                            // notacion para sistemas linux

                            pw = new PrintWriter(fichero);
                            pw.println("  - " + Parking1.getNombre() + " -  ");
                            pw.println("***********************");
                            pw.println("Fecha y hora:");
                            pw.println(current);
                            pw.println();
                            pw.println("Matricula de tu vehiculo:");
                            pw.println(vehiculo.getMatricula());
                            pw.println();
                            pw.println("***********************");
                            pw.println("Precio por vehiculo:");
                            if (tipo == 1) {
                                pw.println("Coche: 4€");
                            } else {
                                pw.println("Moto: 2€");
                            }
                            pw.println("***********************");
                            fichero.close();
                            i++;
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            // Nuevamente aprovechamos el finally para
                            // asegurarnos que se cierra el fichero.
                            if (null != fichero) {
                                fichero.close();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    Parking1.addVehiculosSQL(url, usuario, contraseña);

                    break;
                case 2:
                    System.out.println("Has seleccionado" + Parking2.getNombre());
                    System.out.println("Porfavor indica que vehiculo llevas (Coche = 1 / Moto = 2)");
                    tipo = valNum();
                    if (tipo == 1) {
                        System.out.println("Introduce tu matricula");
                        matricula = sc.next();
                        Coche test = new Coche(matricula, false);
                        Parking2.addVehiculoPlantas(test);
                    } else if (tipo == 2) {
                        System.out.println("Introduce tu matricula");
                        matricula = sc.next();
                        Moto test = new Moto(matricula.replaceAll(" ", "_"), false);
                        Parking2.addVehiculoPlantas(test);
                    }
                    // Creación del Ticket 
                    try {
                        int i = 0;
                        Date current = new Date();
                        for (Vehiculo vehiculo : Parking2.parked) {
                            String ruta = "C:\\Users\\raffs\\Desktop\\Grado Superior DAW\\Programación\\Park-And-Run\\Tickets\\Ticket n" + i + " " + Parking2.getNombre() + ".txt";
                            fichero = new FileWriter(ruta);
                            // notacion para sistemas linux

                            pw = new PrintWriter(fichero);
                            pw.println("  - " + Parking2.getNombre() + " -  ");
                            pw.println("***********************");
                            pw.println("Fecha y hora:");
                            pw.println(current);
                            pw.println();
                            pw.println("Matricula de tu vehiculo:");
                            pw.println(vehiculo.getMatricula());
                            pw.println();
                            pw.println("***********************");
                            pw.println("Precio por vehiculo:");
                            if (tipo == 1) {
                                pw.println("Coche: 4€");
                            } else {
                                pw.println("Moto: 2€");
                            }
                            pw.println("***********************");
                            fichero.close();
                            i++;
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            // Nuevamente aprovechamos el finally para
                            // asegurarnos que se cierra el fichero.
                            if (null != fichero) {
                                fichero.close();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    Parking2.addVehiculosSQL(url, usuario, contraseña);
                    break;
                case 3:
                    System.out.println("Has seleccionado" + Parking3.getNombre());
                    System.out.println("Porfavor indica que vehiculo llevas (Coche = 1 / Moto = 2)");
                    tipo = valNum();
                    if (tipo == 1) {
                        System.out.println("Introduce tu matricula");
                        matricula = sc.next();
                        Coche test = new Coche(matricula.replaceAll(" ", ""), false);
                        Parking3.addVehiculoPlantas(test);
                    } else if (tipo == 2) {
                        System.out.println("Introduce tu matricula");
                        matricula = sc.next();
                        Moto test = new Moto(matricula.replaceAll(" ", ""), false);
                        Parking3.addVehiculoPlantas(test);
                    }
                    try {
                        int i = 0;
                        Date current = new Date();
                        for (Vehiculo vehiculo : Parking3.parked) {
                            String ruta = "C:\\Users\\raffs\\Desktop\\Grado Superior DAW\\Programación\\Park-And-Run\\Tickets\\Ticket n" + i + " " + Parking3.getNombre() + ".txt";
                            fichero = new FileWriter(ruta);
                            // notacion para sistemas linux

                            pw = new PrintWriter(fichero);
                            pw.println("  - " + Parking3.getNombre() + " -  ");
                            pw.println("***********************");
                            pw.println("Fecha y hora:");
                            pw.println(current);
                            pw.println();
                            pw.println("Matricula de tu vehiculo:");
                            pw.println(vehiculo.getMatricula());
                            pw.println();
                            pw.println("***********************");
                            pw.println("Precio por vehiculo:");
                            if (tipo == 1) {
                                pw.println("Coche: 4€");
                            } else {
                                pw.println("Moto: 2€");
                            }
                            pw.println("***********************");
                            fichero.close();
                            i++;
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            // Nuevamente aprovechamos el finally para
                            // asegurarnos que se cierra el fichero.
                            if (null != fichero) {
                                fichero.close();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    Parking3.addVehiculosSQL(url, usuario, contraseña);
                    break;
                case 4:
                    System.out.println("Introduce el Pin de Acceso:");
                    int Pin = valNum();
                    int opcAvz = 0;
                    int park = 0;
                    if (Pin == 5544) {
                        do {
                            System.out.println("1. Ver Vehiculos Aparcados");
                            System.out.println("2. Ver Vehiculos Trabajadores");
                            System.out.println("3. Ver Ganancias Totales");
                            System.out.println("4. Llamar a la grua");
                            System.out.println("5. Cerrar Parking");
                            System.out.println("6. Abrir Parking");
                            System.out.println("7. Salir");
                            opcAvz = valNum();
                            switch (opcAvz) {
                                case 1:
                                    System.out.println("Indica el Parking que quieres ver los vehiculos Aparcados");
                                    System.out.println("1. " + Parking1.getNombre());
                                    System.out.println("2. " + Parking2.getNombre());
                                    System.out.println("3. " + Parking3.getNombre());
                                    System.out.println("Introduce el numero de parking");
                                    park = valNum();
                                    if (park == 1) {
                                        System.out.println(Parking1.getParked());
                                    } else if (park == 2) {
                                        System.out.println(Parking2.getParked());
                                    } else if (park == 3) {
                                        System.out.println(Parking3.getParked());
                                    }
                                    opcAvz = 0;
                                    break;
                                case 2:
                                    System.out.println("Indica el Parking que quieres ver los vehiculos de Trabajadores");
                                    System.out.println("1. " + Parking1.getNombre());
                                    System.out.println("2. " + Parking2.getNombre());
                                    System.out.println("3. " + Parking3.getNombre());
                                    System.out.println("Introduce el numero de parking");
                                    park = valNum();
                                    if (park == 1) {
                                        System.out.println(Parking1.getTrabajadores());
                                    } else if (park == 2) {
                                        System.out.println(Parking2.getTrabajadores());
                                    } else if (park == 3) {
                                        System.out.println(Parking3.getTrabajadores());
                                    }
                                    opcAvz = 0;
                                    break;
                                case 3:
                                    System.out.println("Indica el Parking que quieres ver las Ganancias Totales");
                                    System.out.println("1. " + Parking1.getNombre());
                                    System.out.println("2. " + Parking2.getNombre());
                                    System.out.println("3. " + Parking3.getNombre());
                                    System.out.println("Introduce el numero de parking");
                                    park = valNum();
                                    if (park == 1) {
                                        System.out.println("Dinero Total:" + Parking1.getGanancias() + "€");
                                    } else if (park == 2) {
                                        System.out.println("Dinero Total:" + Parking2.getGanancias() + "€");
                                    } else if (park == 3) {
                                        System.out.println("Dinero Total:" + Parking3.getGanancias() + "€");
                                    }

                                    opcAvz = 0;
                                    break;
                                case 4:
                                    System.out.println("Indica el Parking del cual quieres sacar un vehiculo");
                                    System.out.println("1. " + Parking1.getNombre());
                                    System.out.println("2. " + Parking2.getNombre());
                                    System.out.println("3. " + Parking3.getNombre());
                                    System.out.println("Introduce el numero de parking");
                                    int park1 = valNum();
                                    switch (park1) {
                                        case 1:
                                            System.out.println("Indica la matricula del vehiculo que quieres sacar:");
                                            System.out.println(Parking1.getParked());
                                            String matricula1 = sc.next();

                                            Parking1.remVehiculo(matricula1);

                                            break;
                                        case 2:
                                            System.out.println("Indica la matricula del vehiculo que quieres sacar:");
                                            System.out.println(Parking2.getParked());
                                            matricula1 = sc.next();

                                            Parking2.remVehiculo(matricula1);

                                            break;
                                        case 3:
                                            System.out.println("Indica la matricula del vehiculo que quieres sacar:");
                                            System.out.println(Parking3.getParked());
                                            matricula1 = sc.next();
                                            Parking3.remVehiculo(matricula1);
                                            break;
                                    }
                                    opcAvz = 0;
                                    break;
                                case 5:
                                    System.out.println("Indica el Parking que quieres cerrar");
                                    System.out.println("1. " + Parking1.getNombre());
                                    System.out.println("2. " + Parking2.getNombre());
                                    System.out.println("3. " + Parking3.getNombre());
                                    int park2 = valNum();
                                    switch (park2) {
                                        case 1:
                                            System.out.println("Cerrando el Parking de " + Parking1.getNombre());
                                            Parking1.cerrarPuertas();

                                            break;
                                        case 2:
                                            System.out.println("Cerrando el Parking de " + Parking2.getNombre());
                                            Parking2.cerrarPuertas();

                                            break;
                                        case 3:
                                            System.out.println("Cerrando el Parking de " + Parking3.getNombre());
                                            Parking3.cerrarPuertas();
                                            break;
                                    }

                            }

                        } while (opcAvz != 7);

                    }
                    break;
            }
        } while (opcionParking != 5);

    }

    public static int valNum() {
        boolean correcte = true;
        int i = 0;
        do {
            try {
                i = sc.nextInt();
                correcte = true;
            } catch (InputMismatchException e) {
                correcte = false;
                System.out.println("Introduce un numero valido:");
                sc.next();

            }
        } while (!correcte);
        return i;
    }

}
