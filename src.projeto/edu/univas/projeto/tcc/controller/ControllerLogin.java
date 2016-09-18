package edu.univas.projeto.tcc.controller;

import edu.univas.projeto.tcc.listeners.LoginListener;
import edu.univas.projeto.tcc.view.LoginFrame;
import edu.univas.projeto.tcc.view.PanelDadosLogin;

public class ControllerLogin {

	private LoginFrame loginFrame;
	private PanelDadosLogin panelDadosLogin;

	public void login() {
		loginFrame = new LoginFrame();
		loginFrame.addLoginListener(new LoginListener() {

			@Override
			public void logar() {
				if (panelDadosLogin.getNomeField().equals("admin")
						&& panelDadosLogin.getSenhaField().equals("1234")) {
					new Runner().main();
				}
			}

		});
		loginFrame.setVisible(true);
	}

}
