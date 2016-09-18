package edu.univas.projeto.tcc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JFrame;

import edu.univas.projeto.tcc.listeners.ButtonsCrud;
import edu.univas.projeto.tcc.listeners.ButtonsListarListener;
import edu.univas.projeto.tcc.listeners.ButtonsPesquisa;
import edu.univas.projeto.tcc.listeners.ConsultaFrete;
import edu.univas.projeto.tcc.listeners.ListarListener;
import edu.univas.projeto.tcc.model.FreteTO;

public class FrameConsultaFrete extends JFrame {

	private static final long serialVersionUID = 7217142567346284990L;

	private PanelDadosListaFrete panelDadosListaFrete;
	private PanelListaButtons panelListaButtons;
	private PanelButtonsCrud panelButtonsCrud;
	private PanelButtonsPesquisa panelButtonsPesquisa;

	private GridBagConstraints panelListaDadosConstraints;
	private GridBagConstraints panelListaButtonsConstraints;
	private GridBagConstraints panelButtonsCrudConstraints;
	private GridBagConstraints panelButtonsPesquisaConstraints;

	private ArrayList<ConsultaFrete> listeners = new ArrayList<ConsultaFrete>();

	public FrameConsultaFrete() {

		super("Consulta Frete ");

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
		add(getPanelDadosListaFrete(), getPanelDadosListaFreteConstraints());
		add(getPanelListaButtons(), getPanelListaButtonsConstraints());
	}

	private GridBagConstraints createConstraintsPrototype() {

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.insets = new Insets(3, 3, 3, 3);

		return gbc;
	}

	private GridBagConstraints getPanelDadosListaFreteConstraints() {
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

	private PanelDadosListaFrete getPanelDadosListaFrete() {
		if (panelDadosListaFrete == null) {
			panelDadosListaFrete = new PanelDadosListaFrete();
		}
		return panelDadosListaFrete;
	}

	private PanelListaButtons getPanelListaButtons() {
		if (panelListaButtons == null) {
			panelListaButtons = new PanelListaButtons();
			panelListaButtons
					.addButtonsListarListener(new ButtonsListarListener() {

						@Override
						public void fechar() {
							for (ConsultaFrete listener : listeners) {
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
					for (ConsultaFrete listener : listeners) {
						listener.editar(codigo);
					}

				}

				@Override
				public void excluir(String codigo) {
					for (ConsultaFrete listener : listeners) {
						listener.excluir(codigo);
					}

				}

				@Override
				public void incluir() {
					for (ConsultaFrete listener : listeners) {
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
					for (ConsultaFrete listener : listeners) {
						listener.cancelar();
					}
				}

				@Override
				public void listarTudo() {
					for (ConsultaFrete listener : listeners) {
						listener.listarTudo();
					}

				}

				@Override
				public void pesquisar(String codigo) {
					for (ConsultaFrete listener : listeners) {
						listener.pesquisar(codigo);
					}

				}

				@Override
				public void relacaoTela() {
					for (ConsultaFrete listener : listeners) {
						listener.relacaoTela();
					}

				}

			});
		}
		return panelButtonsPesquisa;
	}

	public void setDadosFrete(ArrayList<FreteTO> fretes) {
		getPanelDadosListaFrete().setFreteTable(fretes);
	}

	public void setDadosFreteTO(FreteTO frete) {
		getPanelDadosListaFrete().setFreteTableModel(frete);
	}

	public void addFrete(ButtonsCrud buttonsCrud) {
		getPanelButtonsCrud().addButtonsCrud(buttonsCrud);

	}

	public void relacaoFrete(ButtonsPesquisa buttonsPesquisa) {

	}

	public void addListarLienter(ListarListener listener) {

	}

	public void addConsultaFrete(ConsultaFrete listener) {
		listeners.add(listener);
		getPanelDadosListaFrete().addConsultaFrete(listener);
	}
}
