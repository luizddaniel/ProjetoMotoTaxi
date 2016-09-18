package edu.univas.projeto.tcc.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PanelDadosLogin extends JPanel {

	private static final long serialVersionUID = -4947482615643014995L;

	private GridLayout gridLayout;

	private EmptyBorder emptyBorder;

	private JLabel loginLabel;
	private JLabel senhaLabel;

	private JTextField loginField;
	private JTextField senhaField;

	public PanelDadosLogin() {
		super();
		initialize();

	}

	private void initialize() {

		setLayout(getGridLayout());
		setBorder(getEmptyBorder());

		add(getNomeLabel());
		add(getNomeField());
		add(getSenhaLabel());
		add(getSenhaField());

	}

	private JLabel getNomeLabel() {
		if (loginLabel == null) {
			loginLabel = new JLabel();
			loginLabel.setText("Nome: ");
		}
		return loginLabel;
	}

	private JLabel getSenhaLabel() {
		if (senhaLabel == null) {
			senhaLabel = new JLabel();
			senhaLabel.setText("Senha: ");
		}

		return senhaLabel;
	}

	public JTextField getNomeField() {
		if (loginField == null) {
			loginField = new JTextField();

		}

		return loginField;
	}

	public JTextField getSenhaField() {
		if (senhaField == null) {
			senhaField = new JPasswordField();

		}
		return senhaField;
	}

	private GridLayout getGridLayout() {
		if (gridLayout == null) {
			gridLayout = new GridLayout();
			gridLayout.setRows(2);
			gridLayout.setColumns(2);
			gridLayout.setHgap(10);
			gridLayout.setVgap(10);

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
