package edu.univas.projeto.tcc.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.univas.projeto.tcc.listeners.ButtonsCrud;

public class PanelButtonsCrud extends JPanel {

	private static final long serialVersionUID = -2079959225640636346L;

	private JTextField del_editField;
	private JButton incluirButton;
	private JButton editarButton;
	private JButton excluirButton;
	private ArrayList<ButtonsCrud> listeners = new ArrayList<ButtonsCrud>();
	private GridLayout gridLayout;

	public PanelButtonsCrud() {
		super();
		initialize();
	}

	private void initialize() {

		setLayout(getGridLayout());

		add(getIncluirButton());
		add(getEditarButton());
		add(getExcluirButton());
		add(getSelectField());

	}

	private GridLayout getGridLayout() {
		if (gridLayout == null) {
			gridLayout = new GridLayout();
			gridLayout.setRows(1); // definindo o número de linas do grid
			gridLayout.setColumns(5); // definindo o número de colunas do grid
			gridLayout.setHgap(10); // espaçamento horizontal
			gridLayout.setVgap(10);// espaçamento vertical

		}
		return gridLayout;
	}

	private JTextField getSelectField() {
		if (del_editField == null) {
			del_editField = new JTextField();
			del_editField
					.setToolTipText("Colque o código referente ao registro que deseja EXCLUIR ou EDITAR");
		}
		return del_editField;
	}

	private JButton getExcluirButton() {
		if (excluirButton == null) {

			URL pathToImage = getClass().getResource(
					"/edu/univas/projeto/tcc/files/image/del.png");
			excluirButton = new JButton("Excluir", new ImageIcon(pathToImage));
			excluirButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for (ButtonsCrud listener : listeners) {
						listener.excluir(getSelectField().getText());
					}
				}
			});
		}

		return excluirButton;
	}

	private JButton getIncluirButton() {
		if (incluirButton == null) {
			URL pathToImage = getClass().getResource(
					"/edu/univas/projeto/tcc/files/image/accept.png");
			incluirButton = new JButton("Incluir", new ImageIcon(pathToImage));
			incluirButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for (ButtonsCrud listener : listeners) {
						listener.incluir();
					}
				}
			});
		}

		return incluirButton;
	}

	private JButton getEditarButton() {
		if (editarButton == null) {

			URL pathToImage = getClass().getResource(
					"/edu/univas/projeto/tcc/files/image/edit.png");
			editarButton = new JButton("Editar", new ImageIcon(pathToImage));
			editarButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for (ButtonsCrud listener : listeners) {
						listener.editar(getSelectField().getText());
					}
				}
			});
		}

		return editarButton;
	}

	public void addButtonsCrud(ButtonsCrud listener) {
		if (listener != null) {
			listeners.add(listener);
		}
	}

}
