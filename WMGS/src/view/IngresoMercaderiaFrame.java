package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.ServicioActualizacionStock;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IngresoMercaderiaFrame extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCodigo;


	public IngresoMercaderiaFrame() {
		setDefaultCloseOperation(JFrame.ICONIFIED);
		setBounds(100, 100, 792, 380);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textCodigo = new JTextField();
		textCodigo.setColumns(10);
		textCodigo.setBounds(43, 94, 398, 49);
		contentPane.add(textCodigo);
		
		JLabel lblCodigo = new JLabel("CODIGO");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigo.setBounds(43, 58, 126, 20);
		contentPane.add(lblCodigo);
		
		JLabel label_1 = new JLabel("CANTIDAD");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(43, 171, 126, 20);
		contentPane.add(label_1);
		
		JSpinner spinnerCantidad = new JSpinner();
		spinnerCantidad.setBounds(43, 207, 398, 49);
		contentPane.add(spinnerCantidad);
		
		Button button = new Button("Ingresar Mercader\u00EDa ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ServicioActualizacionStock update = new ServicioActualizacionStock();
					
			
				if(textCodigo.getText()== "")
					JOptionPane.showMessageDialog(null," Por favor, complete el campo CODIGO");
				else {	
					
						String codigo = textCodigo.getText();
						Object cantidad = spinnerCantidad.getValue();
						
					
						update.cargarMercaderia(codigo,cantidad);
						JOptionPane.showMessageDialog(null,"La mercader�a ha ingresado correctamente al sistema.");
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBackground(new Color(241, 57, 83));
		button.setActionCommand("Ingresar");
		button.setBounds(513, 133, 224, 81);
		contentPane.add(button);
	}
}
