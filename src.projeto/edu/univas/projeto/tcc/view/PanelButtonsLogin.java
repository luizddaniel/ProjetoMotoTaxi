package edu.univas.projeto.tcc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.univas.projeto.tcc.controller.Runner;

public class PanelButtonsLogin extends JPanel {

	private static final long serialVersionUID = -3028233194715422213L;

	private JButton okButton;

	private PanelDadosLogin dadosLogin = new PanelDadosLogin();

	public PanelButtonsLogin() {
		super();
		initialize();
	}

	private void initialize() {
		add(getOkButton());

	}

	private JButton getOkButton() {
		if (okButton == null) {
			okButton = new JButton();
			okButton.setText("OK");
			okButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					String nome = dadosLogin.getNomeField().getText();
					String senha = dadosLogin.getSenhaField()
							.getText();
					if (nome != null && senha != null && nome.equals("admin")
							&& senha.equals("1234")) {
						new Runner().main();
					} else {
						JOptionPane.showMessageDialog(null, "Falha!!!",
								"Senha ou Login Errado",
								JOptionPane.INFORMATION_MESSAGE);
					}

				}

			});
		}
		return okButton;
	}

}
