package edu.univas.projeto.tcc.controller;

import edu.univas.projeto.tcc.model.Cliente_DestinoDAO;
import edu.univas.projeto.tcc.model.FreteDAO;
import edu.univas.projeto.tcc.model.MotoqueiroDAO;

public class Runner {
	public static void main(String[] args) {
//		new LoginFrame().setVisible(true);
		new ControllerPrincipal(new Cliente_DestinoDAO(), new MotoqueiroDAO(),
				new FreteDAO()).showFramePrincipal();

		
		//new ControllerLogin();
	}

	public void main() {
		new ControllerPrincipal(new Cliente_DestinoDAO(), new MotoqueiroDAO(),
				new FreteDAO()).showFramePrincipal();
	}

}
