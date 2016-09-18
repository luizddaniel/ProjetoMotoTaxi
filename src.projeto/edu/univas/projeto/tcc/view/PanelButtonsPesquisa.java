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
import javax.swing.border.EmptyBorder;

import edu.univas.projeto.tcc.listeners.ButtonsPesquisa;

public class PanelButtonsPesquisa extends JPanel {

	private static final long serialVersionUID = -7423581374456464251L;

	private GridLayout gridLayout;

	// borda vazia do panel
	private EmptyBorder emptyBorder;

	private JButton pesquisarButton;
	private JTextField pesquisarField;
	private JButton listarTudoButton;
	private JButton relacaoTelaButton;
	private JButton fecharButton;

	private ArrayList<ButtonsPesquisa> listeners = new ArrayList<ButtonsPesquisa>();

	public PanelButtonsPesquisa() {
		super();
		initialize();
	}

	private void initialize() {
		setLayout(getGridLayout());

		// ajusta a borda do panel
		setBorder(getEmptyBorder());

		add(getPesquisarButton());
		add(getPesquisarField());
		add(getListarTudoButton());
		add(getRelacaoTelaButton());
		add(getFecharButton());

	}

	private JButton getPesquisarButton() {
		if (pesquisarButton == null) {

			URL pathToImage = getClass().getResource(
					"/edu/univas/projeto/tcc/files/image/pesquisar.png");
			pesquisarButton = new JButton("Pesquisar", new ImageIcon(
					pathToImage));
			pesquisarButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for (ButtonsPesquisa listener : listeners) {
						listener.pesquisar(getPesquisarField().getText());
					}
				}
			});
		}

		return pesquisarButton;
	}

	private JTextField getPesquisarField() {
		if (pesquisarField == null) {
			pesquisarField = new JTextField();
			pesquisarField.getHorizontalVisibility();
		}
		return pesquisarField;
	}

	private JButton getListarTudoButton() {
		if (listarTudoButton == null) {
			URL pathToImage = getClass().getResource(
					"/edu/univas/projeto/tcc/files/image/listar.png");
			listarTudoButton = new JButton("Listar Tudo", new ImageIcon(
					pathToImage));
			listarTudoButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for (ButtonsPesquisa listener : listeners) {
						listener.listarTudo();
					}
				}
			});
		}

		return listarTudoButton;
	}

	private JButton getRelacaoTelaButton() {
		if (relacaoTelaButton == null) {

			URL pathToImage = getClass().getResource(
					"/edu/univas/projeto/tcc/files/image/print.png");
			relacaoTelaButton = new JButton("Relação Tela", new ImageIcon(
					pathToImage));
			relacaoTelaButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for (ButtonsPesquisa listener : listeners) {
						listener.relacaoTela();
					}
				}
			});
		}

		return relacaoTelaButton;
	}

	private JButton getFecharButton() {
		if (fecharButton == null) {

			URL pathToImage = getClass().getResource(
					"/edu/univas/projeto/tcc/files/image/bcancel.png");
			fecharButton = new JButton("Cancelar", new ImageIcon(pathToImage));
			fecharButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for (ButtonsPesquisa listener : listeners) {
						listener.fechar();
					}
				}
			});
		}

		return fecharButton;
	}

	public void addButtonsPesquisa(ButtonsPesquisa listener) {
		if (listener != null) {
			listeners.add(listener);
		}
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

	private EmptyBorder getEmptyBorder() {
		if (emptyBorder == null) {
			emptyBorder = new EmptyBorder(5, 5, 5, 5);
		}
		return emptyBorder;
	}

}
