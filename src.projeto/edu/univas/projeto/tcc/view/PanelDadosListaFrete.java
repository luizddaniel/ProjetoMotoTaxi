package edu.univas.projeto.tcc.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.univas.projeto.tcc.listeners.ConsultaFrete;
import edu.univas.projeto.tcc.model.Cliente_DestinoTO;
import edu.univas.projeto.tcc.model.FreteTO;

public class PanelDadosListaFrete extends JPanel {

	private static final long serialVersionUID = -4830920684384899652L;
	@SuppressWarnings("unused")
	private FreteTO frete;
	private ArrayList<ConsultaFrete> listeners = new ArrayList<ConsultaFrete>();

	private JTable table;
	private JScrollPane scrolltable;
	private DefaultTableModel tableModel;
	private GridBagConstraints scrollTableConstraints;

	public PanelDadosListaFrete() {
		super();
		initialize();
	}

	private void initialize() {
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

		tableModel.setColumnIdentifiers(new String[] { "Codigo", "Nº Corrida",
				"Destino", "Motoqueiro", "Hora Ligação", "Hora Saida",
				"Hora Chegada", "Data", "Valor"

		});

		return tableModel;
	}

	public void setFreteTable(ArrayList<FreteTO> freteTO) {
		for (FreteTO frete : freteTO) {
			String[] linha = new String[] { Integer.toString(frete.getId()),
					Integer.toString(frete.getNum_frete()), frete.getDestino(),
					frete.getMotoq(), frete.getHora_lig(),
					frete.getHora_saida(), frete.getHora_cheg(),
					apresentarData(frete), Float.toString(frete.getValor()) };
			getTableModel().addRow(linha);
			getTable().repaint();
		}
	}

	public void setFreteTableModel(FreteTO frete) {
		// for (FreteTO frete : freteTO) {
		String[] linha = new String[] { Integer.toString(frete.getId()),
				Integer.toString(frete.getNum_frete()), frete.getDestino(),
				frete.getMotoq(), frete.getHora_lig(), frete.getHora_saida(),
				frete.getHora_cheg(), apresentarData(frete),
				Float.toString(frete.getValor()) };
		getTableModel().addRow(linha);
		getTable().repaint();
		// }
	}

	private String apresentarData(FreteTO frete) {

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		Date dtnasc = null;

		dtnasc = frete.getData();
		String dtnasc1 = format.format(dtnasc);

		return dtnasc1;
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

	public void addClienteTable(Cliente_DestinoTO cliente_destino) {
		String[] linha = new String[] {
				Integer.toString(cliente_destino.getId()),
				cliente_destino.getNome(), cliente_destino.getEndereco(),
				Integer.toString(cliente_destino.getNumero()),
				cliente_destino.getBairro(), cliente_destino.getCidade(),
				cliente_destino.getCep(), cliente_destino.getTelefone(),
				cliente_destino.getE_mail() };
		getTableModel().addRow(linha);
	}

	private GridBagConstraints createConstraintsPrototype() {

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(3, 3, 3, 3);

		return gbc;
	}

	public void addConsultaFrete(ConsultaFrete listener) {
		listeners.add(listener);
	}
}
