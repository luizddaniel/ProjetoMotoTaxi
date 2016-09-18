package edu.univas.projeto.tcc.listeners;

import edu.univas.projeto.tcc.model.Cliente_DestinoTO;
import edu.univas.projeto.tcc.model.FreteTO;
import edu.univas.projeto.tcc.model.MotoqueiroTO;

public interface ListarListener {

	public void listarFrete(FreteTO freteTO);

	public void listarCliente(Cliente_DestinoTO cliente_DestinoTO);

	public void listarMotoqueiro(MotoqueiroTO motoqueiroTO);

}
