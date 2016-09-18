package edu.univas.projeto.tcc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import edu.univas.projeto.tcc.listeners.LoginListener;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private PanelDadosLogin panelDadosLogin;
	private PanelButtonsLogin panelButtonsLogin;
	
	private ArrayList<LoginListener> loginListeners = new ArrayList<LoginListener>();

	public LoginFrame() {
		super("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		initialize();
		setSize(new Dimension(200, 130));
		//new LoginFrame().setVisible(true);

	}

	private void initialize() {
		add(getPanelDadosLogin(), BorderLayout.CENTER);
		add(getPanelButtonsLogin(), BorderLayout.SOUTH);

	}

	private PanelDadosLogin getPanelDadosLogin() {
		if (panelDadosLogin == null) {
			panelDadosLogin = new PanelDadosLogin();

		}
		return panelDadosLogin;
	}

	private PanelButtonsLogin getPanelButtonsLogin() {
		if (panelButtonsLogin == null) {
			panelButtonsLogin = new PanelButtonsLogin();

		}
		return panelButtonsLogin;
	}

	public void addLoginListener(LoginListener listener) {
		loginListeners.add(listener);
	}

	
	// public static void main(String[] args) {
	// new LoginFrame().setVisible(true);
	// }

}
