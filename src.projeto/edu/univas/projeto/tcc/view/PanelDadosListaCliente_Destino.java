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

import edu.univas.projeto.tcc.listeners.ConsultaCliente_Dest;
import edu.univas.projeto.tcc.listeners.ListarListener;
import edu.univas.projeto.tcc.model.Cliente_DestinoTO;

public class PanelDadosListaCliente_Destino extends JPanel {

	private static final long serialVersionUID = 9222106027989171956L;

	@SuppressWarnings("unused")
	private Cliente_DestinoTO cli_dest;
	private ArrayList<ConsultaCliente_Dest> listeners = new ArrayList<ConsultaCliente_Dest>();
	// private ArrayList<ListarListener> listeners = new
	// ArrayList<ListarListener>();

	private JTable table;
	private JScrollPane scrolltable;
	private DefaultTableModel tableModel;
	private GridBagConstraints scrollTableConstraints;

	public PanelDadosListaCliente_Destino() {
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
				"Endereco", "Numero", "Bairro", "Cidade", "Cep", "Telefone",
				"E_mail"

		});

		return tableModel;
	}

	public void setClienteTable(ArrayList<Cliente_DestinoTO> cliente_destinoTO) {

		for (Cliente_DestinoTO cliente_destino : cliente_destinoTO) {
			String[] linha = new String[] {
					Integer.toString(cliente_destino.getId()),
					cliente_destino.getNome(), cliente_destino.getEndereco(),
					Integer.toString(cliente_destino.getNumero()),
					cliente_destino.getBairro(), cliente_destino.getCidade(),
					cliente_destino.getCep(), cliente_destino.getTelefone(),
					cliente_destino.getE_mail() };
			getTableModel().addRow(linha);
		}

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
		// listeners.add(listener);
	}

	public void limpaTela() {

	}

	private GridBagConstraints createConstraintsPrototype() {

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(3, 3, 3, 3);

		return gbc;
	}

	public void addConsultaClienteDestino(ConsultaCliente_Dest listener) {
		listeners.add(listener);
	}

}
