package menues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

public class InventarioRespuesta extends JFrame {

	private JPanel contentPane;
	protected JTable tableInv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventarioRespuesta frame = new InventarioRespuesta();
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
	public InventarioRespuesta() {
		setDefaultCloseOperation(JFrame.ICONIFIED);
		setBounds(100, 100, 594, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 26, 542, 202);
		contentPane.add(scrollPane);
		
		tableInv = new JTable();
		tableInv.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Codigo", "Descripcion", "Cantidad", "Precio"
			}
		));
		tableInv.getColumnModel().getColumn(2).setPreferredWidth(173);
		scrollPane.setViewportView(tableInv);
	}
}
