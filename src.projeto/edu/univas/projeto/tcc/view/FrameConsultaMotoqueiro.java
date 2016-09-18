package edu.univas.projeto.tcc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JFrame;

import edu.univas.projeto.tcc.listeners.ButtonsCrud;
import edu.univas.projeto.tcc.listeners.ButtonsListarListener;
import edu.univas.projeto.tcc.listeners.ButtonsPesquisa;
import edu.univas.projeto.tcc.listeners.ConsultaMotoqueiro;
import edu.univas.projeto.tcc.listeners.ListarListener;
import edu.univas.projeto.tcc.model.FreteTO;
import edu.univas.projeto.tcc.model.MotoqueiroTO;

public class FrameConsultaMotoqueiro extends JFrame {

	private static final long serialVersionUID = -9058620370714082608L;

	private PanelDadosListaMotoqueiro panelDadosListaMotoqueiro;
	private PanelListaButtons panelListaButtons;
	private PanelButtonsCrud panelButtonsCrud;
	private PanelButtonsPesquisa panelButtonsPesquisa;

	private GridBagConstraints panelListaDadosConstraints;
	private GridBagConstraints panelListaButtonsConstraints;
	private GridBagConstraints panelButtonsCrudConstraints;
	private GridBagConstraints panelButtonsPesquisaConstraints;

	private ArrayList<ConsultaMotoqueiro> listeners = new ArrayList<ConsultaMotoqueiro>();

	public FrameConsultaMotoqueiro() {

		super("Consulta Motoqueiro ");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initialize();
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
	}

	private void initialize() {

		setLayout(new GridBagLayout());

		add(getPanelButtonsPesquisa(), getPanelButtonsPesquisaConstraints());
		add(getPanelButtonsCrud(), getPanelButtonsCrudConstraints());
		add(getPanelDadosListaMotoqueiro(),
				getPanelDadosListaMotoqueiroConstraints());
		add(getPanelListaButtons(), getPanelListaButtonsConstraints());
	}

	private GridBagConstraints createConstraintsPrototype() {

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.insets = new Insets(3, 3, 3, 3);

		return gbc;
	}

	private GridBagConstraints getPanelDadosListaMotoqueiroConstraints() {
		if (panelListaDadosConstraints == null) {
			panelListaDadosConstraints = createConstraintsPrototype();
			panelListaDadosConstraints.gridx = 0;
			panelListaDadosConstraints.gridy = 2;
		}
		return panelListaDadosConstraints;
	}

	private GridBagConstraints getPanelListaButtonsConstraints() {
		if (panelListaButtonsConstraints == null) {
			panelListaButtonsConstraints = createConstraintsPrototype();
			panelListaButtonsConstraints.gridx = 0;
			panelListaButtonsConstraints.gridy = 3;
		}

		return panelListaButtonsConstraints;
	}

	private GridBagConstraints getPanelButtonsCrudConstraints() {
		if (panelButtonsCrudConstraints == null) {
			panelButtonsCrudConstraints = createConstraintsPrototype();
			panelButtonsCrudConstraints.gridx = 0;
			panelButtonsCrudConstraints.gridy = 1;
		}

		return panelButtonsCrudConstraints;
	}

	private GridBagConstraints getPanelButtonsPesquisaConstraints() {
		if (panelButtonsPesquisaConstraints == null) {
			panelButtonsPesquisaConstraints = createConstraintsPrototype();
			panelButtonsPesquisaConstraints.gridx = 0;
			panelButtonsPesquisaConstraints.gridy = 0;
		}
		return panelButtonsPesquisaConstraints;
	}

	private PanelDadosListaMotoqueiro getPanelDadosListaMotoqueiro() {
		if (panelDadosListaMotoqueiro == null) {
			panelDadosListaMotoqueiro = new PanelDadosListaMotoqueiro();
		}
		return panelDadosListaMotoqueiro;
	}

	private PanelListaButtons getPanelListaButtons() {
		if (panelListaButtons == null) {
			panelListaButtons = new PanelListaButtons();
			panelListaButtons
					.addButtonsListarListener(new ButtonsListarListener() {

						@Override
						public void fechar() {
							for (ConsultaMotoqueiro listener : listeners) {
								listener.fechar();
							}

						}
					});

		}
		return panelListaButtons;
	}

	private PanelButtonsCrud getPanelButtonsCrud() {
		if (panelButtonsCrud == null) {
			panelButtonsCrud = new PanelButtonsCrud();
			panelButtonsCrud.addButtonsCrud(new ButtonsCrud() {

				@Override
				public void editar(String codigo) {
					for (ConsultaMotoqueiro listener : listeners) {
						listener.editar(codigo);
					}

				}

				@Override
				public void excluir(String codigo) {
					for (ConsultaMotoqueiro listener : listeners) {
						listener.excluir(codigo);
					}

				}

				@Override
				public void incluir() {
					for (ConsultaMotoqueiro listener : listeners) {
						listener.incluir();
					}

				}

			});
		}

		return panelButtonsCrud;
	}

	private PanelButtonsPesquisa getPanelButtonsPesquisa() {
		if (panelButtonsPesquisa == null) {
			panelButtonsPesquisa = new PanelButtonsPesquisa();
			panelButtonsPesquisa.addButtonsPesquisa(new ButtonsPesquisa() {

				@Override
				public void fechar() {
					for (ConsultaMotoqueiro listener : listeners) {
						listener.cancelar();
					}
				}

				@Override
				public void listarTudo() {
					for (ConsultaMotoqueiro listener : listeners) {
						listener.listarTudo();
					}

				}

				@Override
				public void pesquisar(String codigo) {
					for (ConsultaMotoqueiro listener : listeners) {
						listener.pesquisar();
					}

				}

				@Override
				public void relacaoTela() {
					for (ConsultaMotoqueiro listener : listeners) {
						listener.relacaoTela();
					}

				}

			});
		}
		return panelButtonsPesquisa;
	}

	public void setDadosMotoqueiro(ArrayList<MotoqueiroTO> motoqueiros) {
		getPanelDadosListaMotoqueiro().setMotoqueiroTable(motoqueiros);
	}

	/**
	 * Método para popular o formulário de cadastro
	 * 
	 * @param contatoTO
	 */

	public void setFreteTO(FreteTO freteTO) {
		// getPanelDadosListaFrete().addFreteTable(freteTO);
	}

	// adiciona listeners ao array list public void
	// public void pesquisarFrete(DadosFrete listener) {
	// listeners.add(listener);
	// getPanelDadosListaFrete().addDadosCliente(listener);
	// }

	public void addFrete(ButtonsCrud buttonsCrud) {
		getPanelButtonsCrud().addButtonsCrud(buttonsCrud);
		// TODO Auto-generated method stub

	}

	public void relacaoFrete(ButtonsPesquisa buttonsPesquisa) {

	}

	public void addListarLienter(ListarListener listener) {
		// getPanelDadosListaFrete().addListaFreteListener(listener);

	}

	public void addConsultaMotoqueiro(ConsultaMotoqueiro listener) {
		listeners.add(listener);
		getPanelDadosListaMotoqueiro().addConsultaMotoqueiro(listener);
	}
}
