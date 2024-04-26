import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceTest extends JFrame implements ActionListener {
    private JTextField campoMatricula;
    private JComboBox<String> comboBoxTipo;
    private JButton botonA�adir;
    private JComboBox<String> comboBoxVehiculos;
    private JButton botonEliminar;
    private JButton botonSalir;

    public InterfaceTest() {
        // Configuraci�n del JFrame
        setTitle("Registro de Veh�culos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        getContentPane().setBackground(new Color(220, 220, 220)); // Fondo gris claro
        setLayout(new BorderLayout());

        // Panel para los campos de entrada y bot�n de a�adir
        JPanel panelEntrada = new JPanel();
        panelEntrada.setBackground(new Color(220, 220, 220)); // Fondo gris claro
        panelEntrada.setLayout(new GridLayout(2, 2));

        JLabel labelMatricula = new JLabel("Matr�cula:");
        campoMatricula = new JTextField();
        JLabel labelTipo = new JLabel("Tipo:");
        String[] tipos = {"Coche", "Moto"};
        comboBoxTipo = new JComboBox<>(tipos);
        botonA�adir = new JButton("A�adir");
        botonA�adir.addActionListener(this);

        panelEntrada.add(labelMatricula);
        panelEntrada.add(campoMatricula);
        panelEntrada.add(labelTipo);
        panelEntrada.add(comboBoxTipo);

        // Panel para la lista de veh�culos y bot�n de eliminar
        JPanel panelVehiculos = new JPanel();
        panelVehiculos.setBackground(new Color(220, 220, 220)); // Fondo gris claro
        panelVehiculos.setLayout(new BorderLayout());

        comboBoxVehiculos = new JComboBox<>();
        botonEliminar = new JButton("Salir");
        botonEliminar.addActionListener(this);
        JButton botonAgregarCoches = new JButton("Entrar");
        botonAgregarCoches.addActionListener(this);

        panelVehiculos.add(new JLabel("Veh�culos en el parking:"), BorderLayout.NORTH);
        panelVehiculos.add(comboBoxVehiculos, BorderLayout.CENTER);
        JPanel panelBotonEliminar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotonEliminar.add(botonEliminar);
        panelBotonEliminar.add(botonAgregarCoches);
        panelVehiculos.add(panelBotonEliminar, BorderLayout.SOUTH);

        // Panel para los botones de acci�n
        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(220, 220, 220)); // Fondo gris claro
        botonSalir = new JButton("Cerrar");
        botonSalir.addActionListener(this);
        panelBotones.add(botonSalir);

        // A�adir paneles al JFrame
        add(panelEntrada, BorderLayout.NORTH);
        add(panelVehiculos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == botonEliminar) {
            // Eliminar veh�culo seleccionado
            int selectedIndex = comboBoxVehiculos.getSelectedIndex();
            if (selectedIndex != -1) {
                comboBoxVehiculos.removeItemAt(selectedIndex);
            }
        } else if (e.getActionCommand().equals("Entrar")) {
            // Agregar veh�culo al parking
            String matricula = campoMatricula.getText();
            String tipo = comboBoxTipo.getSelectedItem().toString();
            String vehiculo = matricula + " - " + tipo;
            comboBoxVehiculos.addItem(vehiculo);
            campoMatricula.setText("");
        } else if (e.getSource() == botonSalir) {
            // Cierra la aplicaci�n
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfaceTest interfaz = new InterfaceTest();
            interfaz.setVisible(true);
        });
    }
}

