package edu.univas.projeto.tcc.controller;

import javax.swing.JOptionPane;

import edu.univas.projeto.tcc.listeners.DadosFrete;
import edu.univas.projeto.tcc.model.DAOException;
import edu.univas.projeto.tcc.model.FreteDAO;
import edu.univas.projeto.tcc.model.FreteTO;
import edu.univas.projeto.tcc.view.FrameEditarFrete;

public class ControllerEditarFrete {

	private FreteDAO freteDAO;
	private FrameEditarFrete frameEditarFrete;
	private ControllerConsultaFrete frete;

	public ControllerEditarFrete(FreteDAO freteDAO) {
		this.freteDAO = freteDAO;
	}

	public void editarCadastro(FreteTO freteTO) {
		
		frameEditarFrete = new FrameEditarFrete();
		frameEditarFrete.getPanelDadosFrete().setFreteTO(freteTO);
		frameEditarFrete.addDadosEdicaoFrete(new DadosFrete() {

			@Override
			public void dadosCancelados() {
				frete = new ControllerConsultaFrete(freteDAO);
				frete.listarFretes();
				frameEditarFrete.dispose();

			}

			@Override
			public void dadosgravados(FreteTO freteTO) {
				JOptionPane
						.showMessageDialog(null, "Valor->" + freteTO.getId());
				editarFrete(freteTO);
				frameEditarFrete.dispose();
				frete = new ControllerConsultaFrete(freteDAO);
				frete.listarFretes();
			}

		});
		frameEditarFrete.setResizable(false);
		frameEditarFrete.setLocationRelativeTo(null);
		frameEditarFrete.setVisible(true);
	}

	private void editarFrete(FreteTO freteTO) {

		try {
			freteDAO.editarFrete(freteTO);
		} catch (DAOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro: "
					+ e.getMessage());
			e.printStackTrace();
		}
	}

}
