package edu.univas.projeto.tcc.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import edu.univas.projeto.tcc.listeners.ConsultaCliente_Dest;
import edu.univas.projeto.tcc.model.Cliente_DestinoDAO;
import edu.univas.projeto.tcc.model.Cliente_DestinoTO;
import edu.univas.projeto.tcc.model.DAOException;
import edu.univas.projeto.tcc.view.FrameConsultaCliente_Destino;

public class ControllerConsultaCliente_Destino {

	private Cliente_DestinoDAO clienteDestinoDAO;
	private FrameConsultaCliente_Destino frameConsultaClienteDestino;

	public ControllerConsultaCliente_Destino(
			Cliente_DestinoDAO clienteDestinoDAO) {
		this.clienteDestinoDAO = clienteDestinoDAO;
	}

	public void listarCliente_Destino() {

		try {
			ArrayList<Cliente_DestinoTO> clientes = clienteDestinoDAO
					.listarClientes_Destino();
			frameConsultaClienteDestino = new FrameConsultaCliente_Destino();
			frameConsultaClienteDestino.setDadosClienteDestino(clientes);

		} catch (DAOException e) {
			e.printStackTrace();
		}
		frameConsultaClienteDestino
				.addConsultaClienteDestino(new ConsultaCliente_Dest() {

					@Override
					public void cancelar() {
						frameConsultaClienteDestino.dispose();

					}

					@Override
					public void editar(String codigo) {
						ControllerEditarCliente_Destino cliente_destino = new ControllerEditarCliente_Destino(
								clienteDestinoDAO);
						try {
							Cliente_DestinoTO cliente_DestinoTO = clienteDestinoDAO
									.buscarClienteDestino(codigo);
							if (cliente_DestinoTO.getId() != null) {
								frameConsultaClienteDestino.setVisible(false);
								cliente_destino
										.editarCadastro(cliente_DestinoTO);
							} else {
								JOptionPane.showMessageDialog(null, "Código "
										+ codigo + " Inexistente!");
							}
						} catch (DAOException e) {
							JOptionPane.showMessageDialog(null,
									"Código Inexistente!");
							e.printStackTrace();
						}

					}

					@Override
					public void excluir(String codigo) {
						try {
							if (JOptionPane.showConfirmDialog(null,
									"Você Deseja realmente excluir o registro de código "
											+ codigo + "?",
									"Sistema Disk Motos",
									JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
								clienteDestinoDAO.excluirDestino(codigo);
							}
							listarTudo();

						} catch (DAOException e) {
							e.printStackTrace();
						}

					}

					@Override
					public void fechar() {
						frameConsultaClienteDestino.dispose();

					}

					@Override
					public void incluir() {
						ControllerCadastroCliente_Destino cliente = new ControllerCadastroCliente_Destino(
								clienteDestinoDAO);
						frameConsultaClienteDestino.setVisible(false);
						cliente.criarNovoCadastro();

					}

					@Override
					public void listarTudo() {
						frameConsultaClienteDestino.dispose();
						listarCliente_Destino();
					}

					@Override
					public void pesquisar() {
						// TODO Auto-generated method stub

					}

					@Override
					public void relacaoTela() {
						// TODO Auto-generated method stub

					}

				});
		frameConsultaClienteDestino.setResizable(false);
		frameConsultaClienteDestino.setLocationRelativeTo(null);
		frameConsultaClienteDestino.setVisible(true);

	}

}
