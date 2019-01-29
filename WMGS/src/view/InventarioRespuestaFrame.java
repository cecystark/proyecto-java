package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

public class InventarioRespuestaFrame extends JFrame {

	private JPanel contentPane;
	private JTable tableInv;


	public InventarioRespuestaFrame() {
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
		
		setTableInv(new JTable());
		getTableInv().setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Codigo", "Descripcion", "Cantidad", "Precio"
			}
		));
		getTableInv().getColumnModel().getColumn(2).setPreferredWidth(173);
		scrollPane.setViewportView(getTableInv());
	}

	public JTable getTableInv() {
		return tableInv;
	}

	public void setTableInv(JTable tableInv) {
		this.tableInv = tableInv;
	}
}
