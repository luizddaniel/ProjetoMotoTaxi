package edu.univas.projeto.tcc.controller;

import javax.swing.JOptionPane;

import edu.univas.projeto.tcc.listeners.DadosMotoqueiro;
import edu.univas.projeto.tcc.model.DAOException;
import edu.univas.projeto.tcc.model.MotoqueiroDAO;
import edu.univas.projeto.tcc.model.MotoqueiroTO;
import edu.univas.projeto.tcc.view.FrameCadastroMotoqueiro;

public class ControllerCadastroMotoqueiro {

	private MotoqueiroDAO motoqueiroDAO;
	private FrameCadastroMotoqueiro frameCadastroMotoqueiro;
	private ControllerConsultaMotoqueiro motoqueiro;

	public ControllerCadastroMotoqueiro(MotoqueiroDAO motoqueiroDAO) {
		this.motoqueiroDAO = motoqueiroDAO;
	}

	public void criarNovoCadastro() {
		frameCadastroMotoqueiro = new FrameCadastroMotoqueiro();

		frameCadastroMotoqueiro.addDadosMotoqueiro(new DadosMotoqueiro() {

			@Override
			public void dadosCancelados() {
				motoqueiro = new ControllerConsultaMotoqueiro(motoqueiroDAO);
				motoqueiro.listarMotoqueiros();
				frameCadastroMotoqueiro.dispose();

			}

			@Override
			public void dadosgravados(MotoqueiroTO motoqueiroTO) {
				inserirMotoqueiro(motoqueiroTO);
				frameCadastroMotoqueiro.dispose();
				motoqueiro = new ControllerConsultaMotoqueiro(motoqueiroDAO);
				motoqueiro.listarMotoqueiros();

			}

		});
		frameCadastroMotoqueiro.setResizable(false);
		frameCadastroMotoqueiro.setLocationRelativeTo(null);
		frameCadastroMotoqueiro.setVisible(true);
	}

	private void inserirMotoqueiro(MotoqueiroTO motoqueiroTO) {

		try {
			motoqueiroDAO.cadastrarMotoqueiro(motoqueiroTO);
		} catch (DAOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro: "
					+ e.getMessage());
			e.printStackTrace();
		}
	}

}
