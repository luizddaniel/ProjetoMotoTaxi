package edu.univas.projeto.tcc.controller;

import javax.swing.JOptionPane;

import edu.univas.projeto.tcc.listeners.DadosCliente_Destino;
import edu.univas.projeto.tcc.model.Cliente_DestinoDAO;
import edu.univas.projeto.tcc.model.Cliente_DestinoTO;
import edu.univas.projeto.tcc.model.DAOException;
import edu.univas.projeto.tcc.view.FrameCadastroCliente_Destino;

public class ControllerCadastroCliente_Destino {

	private Cliente_DestinoDAO cliente_DestinoDAO;
	private FrameCadastroCliente_Destino frameCadastroCliente_Destino;
	private ControllerConsultaCliente_Destino controllerConsultaCliente_Destino;

	public ControllerCadastroCliente_Destino(
			Cliente_DestinoDAO cliente_DestinoDAO) {
		this.cliente_DestinoDAO = cliente_DestinoDAO;
	}

	public void criarNovoCadastro() {
		frameCadastroCliente_Destino = new FrameCadastroCliente_Destino();

		frameCadastroCliente_Destino
				.addDadosCliente_Destino(new DadosCliente_Destino() {

					@Override
					public void dadosCancelados() {
						controllerConsultaCliente_Destino = new ControllerConsultaCliente_Destino(
								cliente_DestinoDAO);
						controllerConsultaCliente_Destino
								.listarCliente_Destino();
						frameCadastroCliente_Destino.dispose();

					}

					@Override
					public void dadosgravados(
							Cliente_DestinoTO cliente_DestinoTO) {
						inserirCliente_Dest(cliente_DestinoTO);
						frameCadastroCliente_Destino.dispose();
						controllerConsultaCliente_Destino = new ControllerConsultaCliente_Destino(	cliente_DestinoDAO);
						controllerConsultaCliente_Destino
						.listarCliente_Destino();
					}

				});
		frameCadastroCliente_Destino.setResizable(false);
		frameCadastroCliente_Destino.setLocationRelativeTo(null);
		frameCadastroCliente_Destino.setVisible(true);
	}

	private void inserirCliente_Dest(Cliente_DestinoTO cliente_destino) {

		try {
			cliente_DestinoDAO.cadastrar(cliente_destino);
		} catch (DAOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro: "
					+ e.getMessage());
			e.printStackTrace();
		}
	}

}
