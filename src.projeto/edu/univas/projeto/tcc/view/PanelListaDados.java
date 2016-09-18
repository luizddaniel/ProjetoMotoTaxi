package edu.univas.projeto.tcc.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.univas.projeto.tcc.listeners.ListarListener;
import edu.univas.projeto.tcc.model.FreteTO;

public class PanelListaDados extends JPanel {

	private static final long serialVersionUID = -4830920684384899652L;
	@SuppressWarnings("unused")
	private FreteTO frete;
	private ArrayList<ListarListener> listeners = new ArrayList<ListarListener>();

	private JTable table;
	private JScrollPane scrolltable;
	private DefaultTableModel tableModel;
	private GridBagConstraints scrollTableConstraints;

	public PanelListaDados() {
		super();
		initialize();
	}

	private void initialize() {
		// TODO
		setLayout(new GridBagLayout());

		add(getScrolltable(), getScrollTableConstraints());
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setAutoCreateRowSorter(true);

			table.setModel(getTableModel());

		}
		return table;
	}

	private DefaultTableModel getTableModel() {
		if (tableModel == null) {
			tableModel = new DefaultTableModel() {

				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int rowIndex, int columnIndex) {
					return false;
				}

			};
		}

		tableModel.setColumnIdentifiers(new String[] { "Codigo", "Nome",
				"E_mail", "Telefone", "UF"

		});

		return tableModel;
	}

	private JScrollPane getScrolltable() {
		if (scrolltable == null) {
			scrolltable = new JScrollPane();
			scrolltable.setViewportView(getTable());
			scrolltable.setPreferredSize(new Dimension(0, 0));

		}
		return scrolltable;
	}

	private GridBagConstraints getScrollTableConstraints() {
		if (scrollTableConstraints == null) {
			scrollTableConstraints = createConstraintsPrototype();
			scrollTableConstraints.gridx = 0;
			scrollTableConstraints.gridy = 0;
			scrollTableConstraints.gridwidth = 1;
			scrollTableConstraints.ipady = 500;
			scrollTableConstraints.ipadx = 950;
		}
		return scrollTableConstraints;
	}

	public void addListarListener(ListarListener listener) {
		listeners.add(listener);
	}

	public void limpaTela() {

	}

	private GridBagConstraints createConstraintsPrototype() {

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(3, 3, 3, 3);

		return gbc;
	}

	/*public void setFrete(ArrayList<FreteTO> fretes) {
		for (FreteTO freteTO : fretes) {
			String[] linha = new String[] {
					Integer.toString(freteTO.getNum_frete()),
					freteTO.getHora_lig(), freteTO.getHora_saida(),
					freteTO.getHora_cheg(), };
			getTableModel().addRow(linha);

		}
	}
*/
	public void addListaClienteListener(ListarListener listener) {
		listeners.add(listener);
	}

}
