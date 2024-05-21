package Tickets;

import java.io.*;
import park.and.run.Dominio.MegaParking;
import park.and.run.Dominio.Parking;
/**
 *
 * @author raffs
 */
public class WriteTicket {

    public WriteTicket() {
        crearTicket();
    }

    public void crearTicket() {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            for(int i = 0; i < 5; i++){
            fichero = new FileWriter("C:\\Users\\raffs\\Desktop\\Grado Superior DAW\\Programación\\Park-And-Run\\Tickets\\Ticket n= .txt");
            // notacion para sistemas linux
            
            pw = new PrintWriter(fichero);
            pw.println("---------------------------");
            pw.println();
            pw.println();
            pw.println();
            pw.println("---------------------------");
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
    }

}
