import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaAutocar extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatr�cula;
	private JLabel lblNewLabel_2;
	private JTextField txtMarca;
	private JLabel lblNewLabel_3;
	private JTextField txtModelo;
	private JLabel lblNewLabel_4;
	private JSpinner contadorPlazas;
	private JLabel lblNewLabel_5;
	private JTextField txtKil�metros;
	private JButton btnInsertar;
	private JButton btnMostrar;
	private JTextArea textArea;
	private ArrayList<Autocar> listaAutocar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAutocar frame = new VentanaAutocar();
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
	public VentanaAutocar() {
		listaAutocar = new ArrayList<Autocar>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][67.00,grow][105.00,grow][][66.00][][106.00][][]", "[][][][][][][][][grow][][]"));
		
		JLabel lblNewLabel = new JLabel("Gesti\u00F3n autocares");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel, "cell 0 0 8 1");
		
		JLabel lblNewLabel_1 = new JLabel("Matr\u00EDcula");
		contentPane.add(lblNewLabel_1, "cell 1 2,alignx trailing");
		
		txtMatr�cula = new JTextField();
		contentPane.add(txtMatr�cula, "cell 2 2 2 1,growx");
		txtMatr�cula.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Marca");
		contentPane.add(lblNewLabel_2, "cell 1 3,alignx trailing");
		
		txtMarca = new JTextField();
		contentPane.add(txtMarca, "cell 2 3 2 1,growx");
		txtMarca.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Modelo");
		contentPane.add(lblNewLabel_3, "cell 4 3,alignx center");
		
		txtModelo = new JTextField();
		contentPane.add(txtModelo, "cell 5 3 2 1,growx");
		txtModelo.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Kil\u00F3metros");
		contentPane.add(lblNewLabel_5, "cell 1 4,alignx trailing");
		
		txtKil�metros = new JTextField();
		contentPane.add(txtKil�metros, "cell 2 4 2 1,growx");
		txtKil�metros.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Plazas");
		contentPane.add(lblNewLabel_4, "cell 4 4,alignx center");
		
		contadorPlazas = new JSpinner();
		contadorPlazas.setModel(new SpinnerNumberModel(30, 1, 80, 1));
		contentPane.add(contadorPlazas, "cell 5 4 2 1");
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtMatr�cula.getText()==null || txtMatr�cula.getText().equals("") ||
						txtMarca.getText()==null || txtMarca.getText().equals("") ||
						txtKil�metros.getText()==null || txtKil�metros.getText().equals("") ||
						txtModelo.getText()==null || txtModelo.getText().equals("") 
						) {
						JOptionPane.showMessageDialog(null, "Debe rellenar todo los campos");
						return;
					}
					Autocar a = new Autocar();
					a.setMatr�cula(txtMatr�cula.getText());
					a.setMarca(txtMarca.getText());
					a.setKil�metros(Integer.parseInt(txtKil�metros.getText()));
					a.setModelo(txtModelo.getText());
					a.setNum_plazas((Integer) contadorPlazas.getValue());
					
					listaAutocar.add(a);
					vaciarTexts();
			}
		});
		contentPane.add(btnInsertar, "cell 2 6 2 1,growx");
		
		btnMostrar = new JButton("Mostrar Datos");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				for (Autocar autocar : listaAutocar) {
					textArea.setText(textArea.getText()+ autocar+"\n");
				
			}
			}});
		contentPane.add(btnMostrar, "cell 4 6,growx");
		
		textArea = new JTextArea();
		contentPane.add(textArea, "cell 1 8 8 3,grow");
	}

	
	protected void vaciarTexts() {
		txtMatr�cula.setText("");
		txtMarca.setText("");
		txtKil�metros.setText("");
		txtModelo.setText("");
		contadorPlazas.setValue(30);
		
	}
}
