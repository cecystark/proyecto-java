package menues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RetirarMercaderia extends JFrame {

	private JPanel contentPane;
	private JTextField lblCodigo;
	private JLabel label_1;
	private JSpinner spinnerCantidad;
	private Button button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RetirarMercaderia frame = new RetirarMercaderia();
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
	public RetirarMercaderia() {
		setDefaultCloseOperation(JFrame.ICONIFIED);
		setBounds(100, 100, 748, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("CODIGO");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(15, 16, 126, 20);
		contentPane.add(label);
		
		lblCodigo = new JTextField();
		lblCodigo.setColumns(10);
		lblCodigo.setBounds(15, 43, 398, 49);
		contentPane.add(lblCodigo);
		
		label_1 = new JLabel("CANTIDAD");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(15, 115, 126, 20);
		contentPane.add(label_1);
		
		spinnerCantidad = new JSpinner();
		spinnerCantidad.setBounds(15, 152, 398, 49);
		contentPane.add(spinnerCantidad);
		
		button = new Button("Retirar Mercader\u00EDa ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean sePudo;
				
				ActualizacionStock update = new ActualizacionStock();
				
				if(lblCodigo.getText()== "")
					JOptionPane.showMessageDialog(null," Por favor, complete el campo CODIGO");
				else {
						sePudo = update.descargarMercaderia(lblCodigo.getText(),(int)spinnerCantidad.getValue());
						
						if (sePudo)
							JOptionPane.showMessageDialog(null,"La mercadería ha sido retirada correctamente del sistema.");
						else 
							JOptionPane.showMessageDialog(null,"El stock es insuficiente, ingrese otra cantidad");
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBackground(new Color(241, 57, 83));
		button.setActionCommand("Ingresar");
		button.setBounds(457, 69, 224, 81);
		contentPane.add(button);
	}

}
