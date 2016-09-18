package edu.univas.projeto.tcc.controller;

import javax.swing.JOptionPane;

import edu.univas.projeto.tcc.listeners.DadosMotoqueiro;
import edu.univas.projeto.tcc.model.DAOException;
import edu.univas.projeto.tcc.model.MotoqueiroDAO;
import edu.univas.projeto.tcc.model.MotoqueiroTO;
import edu.univas.projeto.tcc.view.FrameEditarMotoqueiro;

public class ControllerEditarMotoqueiro {

	private MotoqueiroDAO motoqueiroDAO;
	private FrameEditarMotoqueiro frameEditarMotoqueiro;
	private ControllerConsultaMotoqueiro motoqueiro;

	public ControllerEditarMotoqueiro(MotoqueiroDAO motoqueiroDAO) {
		this.motoqueiroDAO = motoqueiroDAO;
	}

	public void editarCadastro(MotoqueiroTO motoqueiroTO) {
		frameEditarMotoqueiro = new FrameEditarMotoqueiro();
		frameEditarMotoqueiro.getPanelDadosMotoqueiro().setMotoqueiroTO(
				motoqueiroTO);
		frameEditarMotoqueiro.addDadosEdicaoMotoqueiro(new DadosMotoqueiro() {

			@Override
			public void dadosCancelados() {
				motoqueiro = new ControllerConsultaMotoqueiro(motoqueiroDAO);
				motoqueiro.listarMotoqueiros();
				frameEditarMotoqueiro.dispose();

			}

			@Override
			public void dadosgravados(MotoqueiroTO motoqueiroTO) {
				editarFrete(motoqueiroTO);
				frameEditarMotoqueiro.dispose();
				motoqueiro = new ControllerConsultaMotoqueiro(motoqueiroDAO);
				motoqueiro.listarMotoqueiros();
			}

		});
		frameEditarMotoqueiro.setResizable(false);
		frameEditarMotoqueiro.setLocationRelativeTo(null);
		frameEditarMotoqueiro.setVisible(true);
	}

	private void editarFrete(MotoqueiroTO freteTO) {

		try {
			motoqueiroDAO.editarMotoqueiro(freteTO);
		} catch (DAOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro: "
					+ e.getMessage());
			e.printStackTrace();
		}
	}

}
