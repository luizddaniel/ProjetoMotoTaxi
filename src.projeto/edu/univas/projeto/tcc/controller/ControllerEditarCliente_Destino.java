package edu.univas.projeto.tcc.controller;

import javax.swing.JOptionPane;

import edu.univas.projeto.tcc.listeners.DadosCliente_Destino;
import edu.univas.projeto.tcc.model.Cliente_DestinoDAO;
import edu.univas.projeto.tcc.model.Cliente_DestinoTO;
import edu.univas.projeto.tcc.model.DAOException;
import edu.univas.projeto.tcc.view.FrameEditarCliente_Destino;

public class ControllerEditarCliente_Destino {

	private Cliente_DestinoDAO cliente_DestinoDAO;
	private FrameEditarCliente_Destino frameEditarCliente_Destino;
	private ControllerConsultaCliente_Destino cliente_Destino;

	public ControllerEditarCliente_Destino(Cliente_DestinoDAO cliente_DestinoDAO) {
		this.cliente_DestinoDAO = cliente_DestinoDAO;
	}

	public void editarCadastro(Cliente_DestinoTO cliente_DestinoTO) {
		frameEditarCliente_Destino = new FrameEditarCliente_Destino();
		frameEditarCliente_Destino.getPanelDadosCliente_Destino().setCliente_DestinoTO(cliente_DestinoTO);
		frameEditarCliente_Destino.addDadosEdicaoFrete(new DadosCliente_Destino() {

			@Override
			public void dadosCancelados() {
				cliente_Destino = new ControllerConsultaCliente_Destino(cliente_DestinoDAO);
				cliente_Destino.listarCliente_Destino();
				frameEditarCliente_Destino.dispose();

			}

			@Override
			public void dadosgravados(Cliente_DestinoTO cliente_DestinoTO) {
				JOptionPane
						.showMessageDialog(null, "Valor->" + cliente_DestinoTO.getId());
				editarFrete(cliente_DestinoTO);
				frameEditarCliente_Destino.dispose();
				cliente_Destino = new ControllerConsultaCliente_Destino(cliente_DestinoDAO);
				cliente_Destino.listarCliente_Destino();
			}

		});
		frameEditarCliente_Destino.setResizable(false);
		frameEditarCliente_Destino.setLocationRelativeTo(null);
		frameEditarCliente_Destino.setVisible(true);
	}

	private void editarFrete(Cliente_DestinoTO cliente_DestinoTO) {

		try {
			cliente_DestinoDAO.editarCliente_Destino(cliente_DestinoTO);
		} catch (DAOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro: "
					+ e.getMessage());
			e.printStackTrace();
		}
	}


}
