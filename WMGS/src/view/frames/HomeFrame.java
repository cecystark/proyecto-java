package view.frames;

import controller.Sistema;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class HomeFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public static JTextField textUsuario;
	public static JPasswordField textContrasenia;
	
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
	
	
	public HomeFrame() {
		
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 962, 510);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				jLabelMouseDragged(arg0);
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				jLabelMousePressed(e);
			}
		});
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(675, 139, 1, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(483, 121, 126, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CONTRASE\u00D1A");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(484, 254, 150, 20);
		contentPane.add(lblNewLabel_1);
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		textUsuario.setBounds(483, 154, 398, 49);
		contentPane.add(textUsuario);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(-34, 0, 441, 510);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(HomeFrame.class.getResource("/view/images/Captura.JPG")));
		lblNewLabel_2.setBounds(-84, -19, 770, 319);
		panel.add(lblNewLabel_2);
		
		JLabel lblWarehouseManagementSystem = new JLabel("Warehouse Management System");
		lblWarehouseManagementSystem.setForeground(Color.WHITE);
		lblWarehouseManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWarehouseManagementSystem.setBounds(87, 377, 298, 29);
		panel.add(lblWarehouseManagementSystem);
		
		Button Ingresar = new Button("Ingresar");
		Ingresar.setFont(new Font("Tahoma", Font.BOLD, 16));
		Ingresar.setActionCommand("Ingresar");
		Ingresar.setBackground(new Color(241, 57, 83));
		Ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuFrame menu = new MenuFrame();
				
				if(Sistema.getInstancia().validarUsuario(textUsuario.getText(), textContrasenia.getText())) {
					menu.setVisible(true);
					dispose();
				} else {
                    JOptionPane.showMessageDialog(null, "Usuario o Contrase�a incorrecta");
                }
			}
		});
		Ingresar.setBounds(582, 406, 225, 62);
		contentPane.add(Ingresar);
		
		JLabel lblExit = new JLabel("X");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.exit(0);
			}
		});
		lblExit.setForeground(new Color(255, 0, 0));
		lblExit.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblExit.setBounds(897, 0, 43, 49);
		contentPane.add(lblExit);
		
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
		contentPane.add(label);
		
		textContrasenia = new JPasswordField();
		textContrasenia.setBounds(483, 290, 387, 49);
		contentPane.add(textContrasenia);
		
		setUndecorated(true);
	
	}
}
