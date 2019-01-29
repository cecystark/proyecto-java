package menues;

import clases.Inventario;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Baja extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
					Baja frame = new Baja();
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
	
	
	public Baja() {
		Inventario inventarioPointer = Inventario.getInstancia();
		
		setDefaultCloseOperation(JFrame.ICONIFIED);
		setBounds(100, 100, 739, 395);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dar BAJA por PRODUCTO o C\u00D3DIGO ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(25, 16, 356, 38);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("PRODUCTO");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(25, 112, 126, 20);
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
		textProducto.setBounds(25, 148, 398, 49);
		contentPane.add(textProducto);
		
		JLabel lblCodigo = new JLabel("CODIGO");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigo.setBounds(25, 217, 126, 20);
		contentPane.add(lblCodigo);
		
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
		textCodigo.setBounds(25, 253, 398, 49);
		contentPane.add(textCodigo);
		
		Button buttonDarBaja = new Button("Dar BAJA");
		buttonDarBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String textoprod = textProducto.getText();
				String textocod = textCodigo.getText();
				int codigo;
				
				if(textoprod.isEmpty() && textocod.isEmpty())
					JOptionPane.showMessageDialog(null," Por favor, complete el campo PRODUCTO o CODIGO");
				else {
				
					if (textoprod.isEmpty()) { //si complete el campo CODIGO en el form
					
						codigo = Integer.parseInt(textocod);
					
						if(inventarioPointer.buscarProducto(codigo)!= null) //si encuentro el codigo, lo doy de baja sino aviso
						{			
							inventarioPointer.bajaProducto(codigo);
						
							JOptionPane.showMessageDialog(null,"El producto " +codigo+ " fue dado exitosamente de BAJA en el sistema");
						}
							else
								JOptionPane.showMessageDialog(null,"El producto " +codigo+ " no existe");
					}
				
					else { //si complete el campo PRODUCTO en el form
					
						if (inventarioPointer.buscarProducto(textoprod)!= null)
						{
							inventarioPointer.bajaProducto(textoprod);
							JOptionPane.showMessageDialog(null,"El producto " +textoprod+ " fue dado de BAJA exitosamente en el sistema");
						}
						else
							JOptionPane.showMessageDialog(null,"El producto " +textoprod+ " no existe");
					}
				}
				
				//limpio los campos:
				
				textProducto.setText("");
				textProducto.setEnabled(true);
				textProducto.setBackground(Color.white);
				textCodigo.setText("");
				textCodigo.setEnabled(true);
				textCodigo.setBackground(Color.white);
					
			}
				
		});
		buttonDarBaja.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonDarBaja.setBackground(new Color(241, 57, 83));
		buttonDarBaja.setActionCommand("Ingresar");
		buttonDarBaja.setBounds(520, 137, 154, 81);
		contentPane.add(buttonDarBaja);
	}
}
