/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package park.and.run.Dominio;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author raffs
 */
public class Test {
    ArrayList<String> parking = new ArrayList<>();

    public static void Menu() {
        Scanner sc = new Scanner(System.in);
            ArrayList<String> parking = new ArrayList<>();

        int opcion;
         do{

            System.out.print("Park And Run\n");
            System.out.println("1. Crear Parking");
            System.out.println("2. Ver cantidad de Parkings");
            System.out.println("3. Test");
            System.out.println("4. Test");
            System.out.println("5. Test");
            System.out.println("6. Salir");
            System.out.println("Digite su opcion: ");
            opcion = sc.nextInt();
            switch (opcion){
                case 1: 
                    sc.nextLine();
                    System.out.println("CREAR PARKING");
                    System.out.print("Nombre del Parking: ");
                    String nom = sc.nextLine();
                    System.out.print("Plazas de Motos:");
                    int plMotos = sc.nextInt();
                    System.out.print("Plazas de Coches:");
                    int plCoches = sc.nextInt();
                    System.out.print("Plantas del Parking:");
                    System.out.println("Si no tiene plantas introduce un 0");
                    int plantas = sc.nextInt();
                    new MegaParking(nom, plMotos,plCoches,plantas);
                    
                break;
                case 2:
                    System.out.println(parking);
                    
                break; 
 
                case 3:
                    System.out.println("Aun no esta");
                break;
                case 4:
                    System.out.println("Aun no esta");
                break;
                case 5:
                    System.out.println("Aun no esta");
                break;
                case 6:
                    System.out.close();
                default :
                    System.out.print("OPCION ERRONEA");
            }System.out.println();
        }while (opcion != 6);
    }

    public void addList(Parking MegaParking) {
        parking.add(MegaParking.nombre);
    }

    public ArrayList<String> getParking() {
        return new ArrayList<>(parking);
    }
}
