package edu.univas.teste.tcc.all;

import junit.framework.Test;
import junit.framework.TestSuite;
import edu.univas.teste.tcc.clienteDestino.ClienteDestinoTeste;
import edu.univas.teste.tcc.frete.FreteTeste;
import edu.univas.teste.tcc.motoqueiro.MotoqueiroTeste;

public class junit {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for edu.univas.teste.tcc.motoqueiro");
		suite.addTestSuite(MotoqueiroTeste.class);
		suite.addTestSuite(ClienteDestinoTeste.class);
		suite.addTestSuite(FreteTeste.class);
		
		return suite;
	}

}
