package menues;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Inventario;

import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Button;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.SwingConstants;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Menu frame = new Menu();
//					frame.setVisible(false);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
	/**
	 * Create the frame.
	 */
	
	int xx,xy;
	
	private void jLabelMousePressed(java.awt.event.MouseEvent evt) {
		
		xx = evt.getX();
		xy = evt.getY();	
	}
	
	private void jLabelMouseDragged(java.awt.event.MouseEvent evt) {
		
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		
		this.setLocation(x-xx, y-xy);
	}
	
	public Menu() {
		
		Inventario inventarioPointer = Inventario.getInstancia();
		
		inventarioPointer.levantarArchivo();
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 942, 552);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			
			public void mouseDragged(MouseEvent e) {
				jLabelMouseDragged(e);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				jLabelMousePressed(e);
			
			}
			
		});
		

		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(675, 139, 1, 2);
		panel.add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 421, 552);
		panel.add(panel_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setVerticalAlignment(SwingConstants.TOP);
		label_2.setIcon(new ImageIcon(Menu.class.getResource("/menues/Captura.JPG")));
		label_2.setBounds(-93, 0, 556, 335);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Warehouse Management System");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_3.setBounds(62, 402, 298, 29);
		panel_1.add(label_3);
		
		Button button = new Button("Ingresar mercaderia");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IngresarMercaderia ingreso = new IngresarMercaderia();
				ingreso.setVisible(true);
				
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBackground(new Color(241, 57, 83));
		button.setActionCommand("Ingresar");
		button.setBounds(508, 291, 342, 62);
		panel.add(button);
		
		JLabel lblExit = new JLabel("X");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Inventario inventarioPointer = Inventario.getInstancia();
				
				inventarioPointer.guardarEnArchivo();
				System.exit(0);
			}
		});
		
		lblExit.setForeground(Color.RED);
		lblExit.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblExit.setBounds(897, 0, 43, 49);
		panel.add(lblExit);
		
		
		JLabel label = new JLabel("__");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				setExtendedState(JFrame.ICONIFIED);
			}
		});
		
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label.setBounds(848, -13, 37, 49);
		panel.add(label);
		
		Button button_1 = new Button("Dar ALTA a un nuevo produto");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Alta alta = new Alta();
				alta.setVisible(true);
	
		}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_1.setBackground(new Color(241, 57, 83));
		button_1.setActionCommand("");
		button_1.setBounds(508, 87, 342, 62);
		panel.add(button_1);
		
		Button button_2 = new Button("Dar BAJA a un nuevo producto");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Baja baja = new Baja();
				baja.setVisible(true);
				
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_2.setBackground(new Color(241, 57, 83));
		button_2.setActionCommand("Ingresar");
		button_2.setBounds(508, 155, 342, 62);
		panel.add(button_2);
		
		Button button_3 = new Button("Buscar un producto");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscar buscar = new Buscar();
				buscar.setVisible(true);
			
				
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_3.setBackground(new Color(241, 57, 83));
		button_3.setActionCommand("Ingresar");
		button_3.setBounds(508, 223, 342, 62);
		panel.add(button_3);
		
		Button button_4 = new Button("Retirar mercader\u00EDa");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RetirarMercaderia retirar = new RetirarMercaderia();
				retirar.setVisible(true);
			}
		});
		button_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_4.setBackground(new Color(241, 57, 83));
		button_4.setActionCommand("Ingresar");
		button_4.setBounds(508, 359, 342, 62);
		panel.add(button_4);
		
		Button button_5 = new Button("Ver Inventario");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TodosLosProductos alltheprods = new TodosLosProductos();
				 
				 InventarioRespuesta inventario = new InventarioRespuesta();
				 
				 alltheprods.listarTodosLosProductos();
				
			}
		});
		button_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_5.setBackground(new Color(241, 57, 83));
		button_5.setActionCommand("Ingresar");
		button_5.setBounds(508, 428, 342, 62);
		panel.add(button_5);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(675, 424, 1, 2);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(639, 351, 1, 2);
		panel.add(separator_2);
		
		setUndecorated(true);
	}
}
