package edu.univas.projeto.tcc.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import edu.univas.projeto.tcc.listeners.ConsultaFrete;
import edu.univas.projeto.tcc.model.DAOException;
import edu.univas.projeto.tcc.model.FreteDAO;
import edu.univas.projeto.tcc.model.FreteTO;
import edu.univas.projeto.tcc.view.FrameConsultaFrete;

public class ControllerConsultaFrete {

	private FreteDAO freteDAO;
	private FrameConsultaFrete frameConsultaFrete;

	public ControllerConsultaFrete(FreteDAO freteDAO) {
		this.freteDAO = freteDAO;
	}

	public void listarFretes() {

		try {
			ArrayList<FreteTO> fretes = freteDAO.listarFretes();
			frameConsultaFrete = new FrameConsultaFrete();
			frameConsultaFrete.setDadosFrete(fretes);
		} catch (DAOException e) {
			e.printStackTrace();
		}

		frameConsultaFrete.addConsultaFrete(new ConsultaFrete() {

			@Override
			public void cancelar() {
				frameConsultaFrete.dispose();

			}

			@Override
			public void editar(String codigo) {
				ControllerEditarFrete frete = new ControllerEditarFrete(
						freteDAO);
				try {
					FreteTO freteTO = freteDAO.buscarFrete(codigo);
					if (freteTO.getId() != null) {
						frameConsultaFrete.setVisible(false);
						frete.editarCadastro(freteTO);
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
						freteDAO.excluirFrete(codigo);
					}

					listarTudo();
				} catch (DAOException e) {
					e.printStackTrace();
				}

			}

			@Override
			public void fechar() {
				frameConsultaFrete.dispose();

			}

			@Override
			public void incluir() {
				ControllerCadastroFrete frete = new ControllerCadastroFrete(
						freteDAO);
				frameConsultaFrete.setVisible(false);
				frete.criarNovoCadastro();

			}

			@Override
			public void listarTudo() {
				frameConsultaFrete.dispose();
				listarFretes();

			}

			@Override
			public void pesquisar(String codigo) {
				try {
					FreteTO freteTO = freteDAO.pesquisarFrete(codigo);
					frameConsultaFrete.setDadosFreteTO(freteTO);
				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			@Override
			public void relacaoTela() {
				// TODO Auto-generated method stub

			}

		});
		frameConsultaFrete.setResizable(false);
		frameConsultaFrete.setLocationRelativeTo(null);
		frameConsultaFrete.setVisible(true);

	}

}
