package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class ProductoRespuesta extends JFrame {

	protected JPanel contentPane;
	private JTable table;

	public ProductoRespuesta() {
		setDefaultCloseOperation(JFrame.ICONIFIED);
		setBounds(100, 100, 559, 194);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 43, 462, 61);
		contentPane.add(scrollPane);
		
		setTable(new JTable());
		getTable().setFont(new Font("Tahoma", Font.PLAIN, 18));
		getTable().setBackground(new Color(211, 211, 211));
		getTable().setBorder(new LineBorder(new Color(0, 0, 0)));

		scrollPane.setViewportView(getTable());
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

}
