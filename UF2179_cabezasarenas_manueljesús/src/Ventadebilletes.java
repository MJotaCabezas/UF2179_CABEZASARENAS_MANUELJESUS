import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventadebilletes extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtPrecio;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextArea textArea;
	private JRadioButton rdbtnIdayvuelta;
	private JRadioButton rdbtnTarjeta;
	private JRadioButton rdbtnIda;
	private JComboBox comboDestino;
	private JComboBox comboOrigen;
	private JButton btnCalcular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventadebilletes frame = new Ventadebilletes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventadebilletes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][18.00][85.00,grow][][58.00][][45.00,grow][][][][][]", "[][][][][][][][][][grow][]"));
		
		JLabel lblNewLabel = new JLabel("Venta de billetes");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel, "cell 0 0 6 1");
		
		JLabel lblNewLabel_1 = new JLabel("Origen:");
		contentPane.add(lblNewLabel_1, "cell 1 2,alignx right");
		
		comboOrigen = new JComboBox();
		comboOrigen.setModel(new DefaultComboBoxModel(new String[] {"Adamuz", "And\u00FAjar", "Cabra", "Carde\u00F1a", "Obejo", "Santaella"}));
		contentPane.add(comboOrigen, "cell 3 2 10 1,growx");
		
		JLabel lblNewLabel_2 = new JLabel("Destino:");
		contentPane.add(lblNewLabel_2, "cell 1 3,alignx right");
		
		comboDestino = new JComboBox();
		comboDestino.setModel(new DefaultComboBoxModel(new String[] {"Adamuz", "And\u00FAjar", "Cabra", "Carde\u00F1a", "Obejo", "Santaella"}));
		contentPane.add(comboDestino, "cell 3 3 10 1,growx");
		
		JLabel lblNewLabel_3 = new JLabel("Nombre:");
		contentPane.add(lblNewLabel_3, "cell 1 4,alignx right");
		
		txtNombre = new JTextField();
		contentPane.add(txtNombre, "cell 3 4 2 1,growx");
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Apellidos:");
		contentPane.add(lblNewLabel_4, "cell 5 4,alignx center");
		
		txtApellidos = new JTextField();
		contentPane.add(txtApellidos, "cell 6 4 7 1,growx");
		txtApellidos.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Precio:");
		contentPane.add(lblNewLabel_5, "cell 1 5,alignx right");
		
		txtPrecio = new JTextField();
		txtPrecio.setText("20");
		contentPane.add(txtPrecio, "cell 3 5,growx");
		txtPrecio.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Billete:");
		contentPane.add(lblNewLabel_6, "cell 1 6,alignx right");
		
		rdbtnIda = new JRadioButton("Ida");
		rdbtnIda.setSelected(true);
		buttonGroup.add(rdbtnIda);
		contentPane.add(rdbtnIda, "cell 3 6");
		
		rdbtnIdayvuelta = new JRadioButton("Ida y vuelta");
		buttonGroup.add(rdbtnIdayvuelta);
		contentPane.add(rdbtnIdayvuelta, "cell 4 6");
		
		rdbtnTarjeta = new JRadioButton("Tarjeta Dorada");
		buttonGroup.add(rdbtnTarjeta);
		contentPane.add(rdbtnTarjeta, "cell 5 6");
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					if(comboOrigen.getSelectedIndex()==comboDestino.getSelectedIndex()) {
					JOptionPane.showMessageDialog(null, "Elige un origen y destino diferente");

					}
					
					else {
					double precio = Double.parseDouble(txtPrecio.getText());
					textArea.setText(textArea.getText() + "\n" + "Trayecto: " + comboOrigen.getSelectedItem() + " hasta " + comboDestino.getSelectedItem());
					textArea.setText(textArea.getText() + "\n" + "Viajero: " + txtNombre.getText() + txtApellidos.getText());

						if(rdbtnIda.isSelected()) {
						textArea.setText(textArea.getText() + "\n" + "Precio: " + txtPrecio.getText());
					}
						else if(rdbtnIdayvuelta.isSelected()) {
						textArea.setText(textArea.getText() + "\n" + "Precio: " + (precio-(precio*0.20)));
					}
						else { 
						textArea.setText(textArea.getText() + "\n" + "Precio: " + (precio-(precio*0.30)));
		
					}
					}
				
			}
		});
		contentPane.add(btnCalcular, "cell 4 7,alignx center");
		
		textArea = new JTextArea();
		contentPane.add(textArea, "cell 1 8 11 3,grow");
	}

}
