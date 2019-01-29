package menues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Inventario;
import clases.Producto;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Buscar extends JFrame {

	Inventario inventarioPointer = Inventario.getInstancia();
	private JPanel contentPane;
	private JTextField textProducto;
	private JTextField textCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buscar frame = new Buscar();
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
	public Buscar() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.ICONIFIED);
		setBounds(100, 100, 757, 337);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuscarPorProducto = new JLabel("Buscar por PRODUCTO o CODIGO ");
		lblBuscarPorProducto.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBuscarPorProducto.setBounds(32, 0, 356, 38);
		contentPane.add(lblBuscarPorProducto);
		
		JLabel label = new JLabel("PRODUCTO");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(32, 59, 126, 20);
		contentPane.add(label);
		
		textProducto = new JTextField();
		textProducto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String nombre = textProducto.getText();
				
				boolean isDisabled = nombre.isEmpty();
				
				if(isDisabled==true) {
					textCodigo.setEnabled(true);
					textCodigo.setBackground(Color.WHITE);
			    }
				
				if(isDisabled==false) {
					textCodigo.setEnabled(false);
					textCodigo.setBackground(Color.GRAY);
				}
				
			}
		});
		textProducto.setColumns(10);
		textProducto.setBounds(32, 95, 398, 49);
		contentPane.add(textProducto);
		
		JLabel label_1 = new JLabel("CODIGO");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(32, 160, 126, 20);
		contentPane.add(label_1);
		
		textCodigo = new JTextField();
		
		textCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String nombre = textCodigo.getText();
				
				boolean isDisabled = nombre.isEmpty();
				
				if(isDisabled==true) {
					textProducto.setEnabled(true);
					textProducto.setBackground(Color.WHITE);
			    }
				
				if(isDisabled==false) {
					textProducto.setEnabled(false);
					textProducto.setBackground(Color.GRAY);
				}
				
			}
		});
		
		textCodigo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String nombre = textProducto.getText();

			}
		});
		textCodigo.setColumns(10);
		textCodigo.setBounds(32, 196, 398, 49);
		contentPane.add(textCodigo);
		
		Button button = new Button("Buscar");
		button.setForeground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String textoprod = textProducto.getText();
				String textocod = textCodigo.getText();
				BuscarProducto buscar = new BuscarProducto();
				DatosProducto prodAMostrar = new DatosProducto();
				
				if(textoprod.isEmpty() && textocod.isEmpty())
					JOptionPane.showMessageDialog(null," Por favor, complete el campo PRODUCTO o CODIGO");
				
				else {
						 Producto productoBuscado = buscar.buscarProducto(textoprod,textocod);
						 prodAMostrar.mostrarProducto(productoBuscado);
					}
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBackground(new Color(241, 57, 83));
		button.setActionCommand("Ingresar");
		button.setBounds(511, 105, 154, 81);
		contentPane.add(button);
		
		//limpio los campos:
		
		textProducto.setText("");
		textProducto.setEnabled(true);
		textProducto.setBackground(Color.white);
		textCodigo.setText("");
		textCodigo.setEnabled(true);
		textCodigo.setBackground(Color.white);
	}

}
