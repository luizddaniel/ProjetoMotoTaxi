package edu.univas.projeto.tcc.controller;

import javax.swing.JOptionPane;

import edu.univas.projeto.tcc.listeners.DadosFrete;
import edu.univas.projeto.tcc.model.DAOException;
import edu.univas.projeto.tcc.model.FreteDAO;
import edu.univas.projeto.tcc.model.FreteTO;
import edu.univas.projeto.tcc.view.FrameCadastroFrete;

public class ControllerCadastroFrete {
	private FreteDAO freteDAO;
	private FrameCadastroFrete frameCadastroFrete;
	private ControllerConsultaFrete controllerConsultaFrete;

	public ControllerCadastroFrete(FreteDAO freteDAO) {
		this.freteDAO = freteDAO;
	}

	public void criarNovoCadastro() {
		frameCadastroFrete = new FrameCadastroFrete();

		frameCadastroFrete.addDadosFrete(new DadosFrete() {

			@Override
			public void dadosCancelados() {
				controllerConsultaFrete = new ControllerConsultaFrete(freteDAO);
				controllerConsultaFrete.listarFretes();
				frameCadastroFrete.dispose();

			}

			@Override
			public void dadosgravados(FreteTO freteTO) {
				inserirFrete(freteTO);
				frameCadastroFrete.dispose();
				controllerConsultaFrete = new ControllerConsultaFrete(freteDAO);
				controllerConsultaFrete.listarFretes();
			}

		});
		frameCadastroFrete.setResizable(false);
		frameCadastroFrete.setLocationRelativeTo(null);
		frameCadastroFrete.setVisible(true);
	}

	private void inserirFrete(FreteTO frete) {

		try {
			freteDAO.cadastrarFrete(frete);
		} catch (DAOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro: "
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	/*
	 * private FreteDAO freteDAO; private FrameCadastroFrete frameCadastroFrete;
	 * private ControllerConsultaFrete frete;
	 * 
	 * public ControllerCadastroFrete(FreteDAO freteDAO) { this.freteDAO =
	 * freteDAO; }
	 * 
	 * public void criarNovCadastro() { frameCadastroFrete = new
	 * FrameCadastroFrete();
	 * 
	 * frameCadastroFrete.addDadosFrete(new DadosFrete() {
	 * 
	 * @Override public void dadosCancelados() { frete = new
	 * ControllerConsultaFrete(freteDAO); frete.listarFretes();
	 * frameCadastroFrete.dispose();
	 * 
	 * }
	 * 
	 * @Override public void dadosgravados(FreteTO freteTO) {
	 * inserirFrete(freteTO); frameCadastroFrete.dispose(); frete = new
	 * ControllerConsultaFrete(freteDAO); frete.listarFretes(); }
	 * 
	 * }); frameCadastroFrete.setResizable(false);
	 * frameCadastroFrete.setLocationRelativeTo(null);
	 * frameCadastroFrete.setVisible(true); }
	 * 
	 * private void inserirFrete(FreteTO freteTO) {
	 * 
	 * try { freteDAO.cadastrarFrete(freteTO); } catch (DAOException e) {
	 * JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro: " +
	 * e.getMessage()); e.printStackTrace(); } }
	 */
}
