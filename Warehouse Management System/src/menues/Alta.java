package menues;

import clases.Inventario;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.TextArea;
import javax.swing.JSpinner;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Alta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textProducto;
	private JTextField textPrecio;
	//protected Inventario inventarioPointer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alta frame = new Alta();
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
	public Alta() {
		
		
		setDefaultCloseOperation(JFrame.ICONIFIED);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 568);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProducto = new JLabel("PRODUCTO");
		lblProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProducto.setBounds(98, 41, 80, 20);
		contentPane.add(lblProducto);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(166, 52, 1, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(155, 52, 1, 2);
		contentPane.add(separator_1);
		
		textProducto = new JTextField();
		textProducto.setColumns(10);
		textProducto.setBounds(98, 70, 398, 49);
		contentPane.add(textProducto);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(136, 135, 1, 2);
		contentPane.add(separator_2);
		
		JLabel lblDescripcin = new JLabel("DESCRIPCION");
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescripcin.setBounds(98, 135, 126, 20);
		contentPane.add(lblDescripcin);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(155, 171, 1, 2);
		contentPane.add(separator_3);
		
		TextArea textDescripcion = new TextArea();
		textDescripcion.setBounds(98, 161, 398, 127);
		contentPane.add(textDescripcion);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(196, 294, 1, 2);
		contentPane.add(separator_4);
		
		JLabel lblCantidad = new JLabel("CANTIDAD");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCantidad.setBounds(98, 294, 126, 20);
		contentPane.add(lblCantidad);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(136, 330, 1, 2);
		contentPane.add(separator_5);
		
		JLabel lblPrecioEnPesos = new JLabel("PRECIO EN PESOS");
		lblPrecioEnPesos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecioEnPesos.setBounds(98, 395, 137, 20);
		contentPane.add(lblPrecioEnPesos);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(98, 421, 398, 49);
		contentPane.add(textPrecio);
		
		JSpinner spinnerCantidad = new JSpinner();
		spinnerCantidad.setBounds(98, 330, 92, 49);
		contentPane.add(spinnerCantidad);
		
		Button buttonDarAlta = new Button("Dar ALTA");
		buttonDarAlta.setForeground(Color.WHITE);
		buttonDarAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textProducto.getText().equals("")||textPrecio.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Por favor, complete los campos obligatorios(*) ",null,JOptionPane.ERROR_MESSAGE);
				} else {
					
					int cantidad= (int) spinnerCantidad.getValue();
					int codigo;
					Inventario inventarioPointer = Inventario.getInstancia();
					codigo = inventarioPointer.altaProducto(textProducto.getText(), textDescripcion.getText(), cantidad,textPrecio.getText());
					JOptionPane.showMessageDialog(null,"El producto fue ingresado exitosamente al sistema con el código número: "+codigo);
					
					textProducto.setText("");
					textDescripcion.setText("");
					textPrecio.setText("");
					spinnerCantidad.setValue(0);
				}
				
			}
		});
		buttonDarAlta.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonDarAlta.setBackground(new Color(241, 57, 83));
		buttonDarAlta.setActionCommand("Ingresar");
		buttonDarAlta.setBounds(564, 181, 154, 81);
		contentPane.add(buttonDarAlta);
		
		JLabel label = new JLabel("*");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setForeground(Color.RED);
		label.setBounds(182, 41, 69, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(235, 395, 69, 20);
		contentPane.add(label_1);
	}
}
