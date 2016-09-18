package edu.univas.projeto.tcc.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import edu.univas.projeto.tcc.listeners.ConsultaMotoqueiro;
import edu.univas.projeto.tcc.model.DAOException;
import edu.univas.projeto.tcc.model.MotoqueiroDAO;
import edu.univas.projeto.tcc.model.MotoqueiroTO;
import edu.univas.projeto.tcc.view.FrameConsultaMotoqueiro;

public class ControllerConsultaMotoqueiro {

	private MotoqueiroDAO motoqueiroDAO;
	private FrameConsultaMotoqueiro frameConsultaMotoqueiro;

	public ControllerConsultaMotoqueiro(MotoqueiroDAO motoqueiroDAO) {
		this.motoqueiroDAO = motoqueiroDAO;
	}

	public void listarMotoqueiros() {

		try {
			ArrayList<MotoqueiroTO> motoqueiros = motoqueiroDAO
					.listarMotoqueiros();
			frameConsultaMotoqueiro = new FrameConsultaMotoqueiro();
			frameConsultaMotoqueiro.setDadosMotoqueiro(motoqueiros);
		} catch (DAOException e) {

			e.printStackTrace();
		}

		frameConsultaMotoqueiro.addConsultaMotoqueiro(new ConsultaMotoqueiro() {

			@Override
			public void cancelar() {
				frameConsultaMotoqueiro.dispose();

			}

			@Override
			public void editar(String codigo) {
				ControllerEditarMotoqueiro frete = new ControllerEditarMotoqueiro(
						motoqueiroDAO);
				try {
					MotoqueiroTO motoqueiroTO = motoqueiroDAO
							.buscarMotoqueiro(codigo);
					if (motoqueiroTO.getId() != null) {
						frameConsultaMotoqueiro.setVisible(false);
						frete.editarCadastro(motoqueiroTO);
					} else {
						JOptionPane.showMessageDialog(null, "Código " + codigo
								+ " Inexistente!");
					}
				} catch (DAOException e) {
					JOptionPane.showMessageDialog(null, "Código Inexistente!");
					e.printStackTrace();
				}
			}

			@Override
			public void excluir(String codigo) {
				try {
					if (JOptionPane.showConfirmDialog(null,
							"Você Deseja realmente excluir o registro de código "
									+ codigo + "?", "Sistema Disk Motos",
							JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
						motoqueiroDAO.excluirMotoqueiro(codigo);
					}
					listarTudo();
				} catch (DAOException e) {
					e.printStackTrace();
				}

			}

			@Override
			public void fechar() {
				frameConsultaMotoqueiro.dispose();

			}

			@Override
			public void incluir() {
				ControllerCadastroMotoqueiro motoqueiro = new ControllerCadastroMotoqueiro(
						motoqueiroDAO);
				frameConsultaMotoqueiro.setVisible(false);
				motoqueiro.criarNovoCadastro();

			}

			@Override
			public void listarTudo() {
				frameConsultaMotoqueiro.dispose();
				listarMotoqueiros();

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
		frameConsultaMotoqueiro.setResizable(false);
		frameConsultaMotoqueiro.setLocationRelativeTo(null);
		frameConsultaMotoqueiro.setVisible(true);

	}
}
