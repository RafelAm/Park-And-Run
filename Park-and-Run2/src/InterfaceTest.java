import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceTest extends JFrame implements ActionListener {
    private JTextField campoMatricula;
    private JComboBox<String> comboBoxTipo;
    private JButton botonAñadir;
    private JComboBox<String> comboBoxVehiculos;
    private JButton botonEliminar;
    private JButton botonSalir;

    public InterfaceTest() {
        // Configuración del JFrame
        setTitle("Registro de Vehículos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        getContentPane().setBackground(new Color(220, 220, 220)); // Fondo gris claro
        setLayout(new BorderLayout());

        // Panel para los campos de entrada y botón de añadir
        JPanel panelEntrada = new JPanel();
        panelEntrada.setBackground(new Color(220, 220, 220)); // Fondo gris claro
        panelEntrada.setLayout(new GridLayout(2, 2));

        JLabel labelMatricula = new JLabel("Matrícula:");
        campoMatricula = new JTextField();
        JLabel labelTipo = new JLabel("Tipo:");
        String[] tipos = {"Coche", "Moto"};
        comboBoxTipo = new JComboBox<>(tipos);
        botonAñadir = new JButton("Añadir");
        botonAñadir.addActionListener(this);

        panelEntrada.add(labelMatricula);
        panelEntrada.add(campoMatricula);
        panelEntrada.add(labelTipo);
        panelEntrada.add(comboBoxTipo);

        // Panel para la lista de vehículos y botón de eliminar
        JPanel panelVehiculos = new JPanel();
        panelVehiculos.setBackground(new Color(220, 220, 220)); // Fondo gris claro
        panelVehiculos.setLayout(new BorderLayout());

        comboBoxVehiculos = new JComboBox<>();
        botonEliminar = new JButton("Salir");
        botonEliminar.addActionListener(this);
        JButton botonAgregarCoches = new JButton("Entrar");
        botonAgregarCoches.addActionListener(this);

        panelVehiculos.add(new JLabel("Vehículos en el parking:"), BorderLayout.NORTH);
        panelVehiculos.add(comboBoxVehiculos, BorderLayout.CENTER);
        JPanel panelBotonEliminar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotonEliminar.add(botonEliminar);
        panelBotonEliminar.add(botonAgregarCoches);
        panelVehiculos.add(panelBotonEliminar, BorderLayout.SOUTH);

        // Panel para los botones de acción
        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(220, 220, 220)); // Fondo gris claro
        botonSalir = new JButton("Cerrar");
        botonSalir.addActionListener(this);
        panelBotones.add(botonSalir);

        // Añadir paneles al JFrame
        add(panelEntrada, BorderLayout.NORTH);
        add(panelVehiculos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == botonEliminar) {
            // Eliminar vehículo seleccionado
            int selectedIndex = comboBoxVehiculos.getSelectedIndex();
            if (selectedIndex != -1) {
                comboBoxVehiculos.removeItemAt(selectedIndex);
            }
        } else if (e.getActionCommand().equals("Entrar")) {
            // Agregar vehículo al parking
            String matricula = campoMatricula.getText();
            String tipo = comboBoxTipo.getSelectedItem().toString();
            String vehiculo = matricula + " - " + tipo;
            comboBoxVehiculos.addItem(vehiculo);
            campoMatricula.setText("");
        } else if (e.getSource() == botonSalir) {
            // Cierra la aplicación
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

