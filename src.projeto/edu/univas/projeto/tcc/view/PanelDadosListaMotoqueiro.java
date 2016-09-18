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

import edu.univas.projeto.tcc.listeners.ConsultaMotoqueiro;
import edu.univas.projeto.tcc.listeners.ListarListener;
import edu.univas.projeto.tcc.model.FreteTO;
import edu.univas.projeto.tcc.model.MotoqueiroTO;

public class PanelDadosListaMotoqueiro extends JPanel {

	private static final long serialVersionUID = -9099161336054632381L;

	@SuppressWarnings("unused")
	private FreteTO frete;
	private ArrayList<ConsultaMotoqueiro> listeners = new ArrayList<ConsultaMotoqueiro>();

	private JTable table;
	private JScrollPane scrolltable;
	private DefaultTableModel tableModel;
	private GridBagConstraints scrollTableConstraints;

	public PanelDadosListaMotoqueiro() {
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
				"Nº Motoqueiro", "Telefone", "Moto", "Cor", "Placa", "Tipo Sang."

		});

		return tableModel;
	}

	public void setMotoqueiroTable(ArrayList<MotoqueiroTO> motoqueiroTO) {
		for (MotoqueiroTO motoqueiro : motoqueiroTO) {
			String[] linha = new String[] {
					Integer.toString(motoqueiro.getId()), motoqueiro.getNome(),
					Integer.toString(motoqueiro.getNum_motoq()),
				 motoqueiro.getTelefone(),
					motoqueiro.getMoto(), motoqueiro.getCor(),
					motoqueiro.getPlaca_moto(),
					motoqueiro.getTipo_sang()};
			getTableModel().addRow(linha);
		}
	}
	public void refresh(){
		getTable().repaint();
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

	public void addConsultaMotoqueiro(ConsultaMotoqueiro listener) {
		listeners.add(listener);
	}

}
