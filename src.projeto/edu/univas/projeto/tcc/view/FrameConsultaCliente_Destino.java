package edu.univas.projeto.tcc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JFrame;

import edu.univas.projeto.tcc.listeners.ButtonsCrud;
import edu.univas.projeto.tcc.listeners.ButtonsListarListener;
import edu.univas.projeto.tcc.listeners.ButtonsPesquisa;
import edu.univas.projeto.tcc.listeners.ConsultaCliente_Dest;
import edu.univas.projeto.tcc.listeners.ListarListener;
import edu.univas.projeto.tcc.model.Cliente_DestinoTO;
import edu.univas.projeto.tcc.model.FreteTO;

public class FrameConsultaCliente_Destino extends JFrame {

	private static final long serialVersionUID = -8977920568553788138L;

	private PanelDadosListaCliente_Destino panelDadosListaCliente_Destino;
	private PanelListaButtons panelListaButtons;
	private PanelButtonsCrud panelButtonsCrud;
	private PanelButtonsPesquisa panelButtonsPesquisa;

	private GridBagConstraints panelListaDadosConstraints;
	private GridBagConstraints panelListaButtonsConstraints;
	private GridBagConstraints panelButtonsCrudConstraints;
	private GridBagConstraints panelButtonsPesquisaConstraints;

	private ArrayList<ConsultaCliente_Dest> listeners = new ArrayList<ConsultaCliente_Dest>();

	public FrameConsultaCliente_Destino() {

		super("Consulta Cliente / Destino ");

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
		add(getPanelDadosListaClienteDestino(),
				getPanelDadosListaClienteDestinoConstraints());
		add(getPanelListaButtons(), getPanelListaButtonsConstraints());
	}

	private GridBagConstraints createConstraintsPrototype() {

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.insets = new Insets(3, 3, 3, 3);

		return gbc;
	}

	private GridBagConstraints getPanelDadosListaClienteDestinoConstraints() {
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

	private PanelDadosListaCliente_Destino getPanelDadosListaClienteDestino() {
		if (panelDadosListaCliente_Destino == null) {
			panelDadosListaCliente_Destino = new PanelDadosListaCliente_Destino();
		}
		return panelDadosListaCliente_Destino;
	}

	private PanelListaButtons getPanelListaButtons() {
		if (panelListaButtons == null) {
			panelListaButtons = new PanelListaButtons();
			panelListaButtons
					.addButtonsListarListener(new ButtonsListarListener() {

						@Override
						public void fechar() {
							for (ConsultaCliente_Dest listener : listeners) {
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
					for (ConsultaCliente_Dest listener : listeners) {
						listener.editar(codigo);
					}

				}

				@Override
				public void excluir(String codigo) {
					for (ConsultaCliente_Dest listener : listeners) {
						listener.excluir(codigo);
					}

				}

				@Override
				public void incluir() {
					for (ConsultaCliente_Dest listener : listeners) {
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
					for (ConsultaCliente_Dest listener : listeners) {
						listener.cancelar();
					}
				}

				@Override
				public void listarTudo() {
					for (ConsultaCliente_Dest listener : listeners) {
						listener.listarTudo();
					}

				}

				@Override
				public void pesquisar(String codigo) {
					for (ConsultaCliente_Dest listener : listeners) {
						listener.pesquisar();
					}

				}

				@Override
				public void relacaoTela() {
					for (ConsultaCliente_Dest listener : listeners) {
						listener.relacaoTela();
					}

				}

			});
		}
		return panelButtonsPesquisa;
	}

	public void setDadosClienteDestino(ArrayList<Cliente_DestinoTO> clientes) {
		getPanelDadosListaClienteDestino().setClienteTable(clientes);
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

	public void addClienteDestino(ButtonsCrud buttonsCrud) {
		getPanelButtonsCrud().addButtonsCrud(buttonsCrud);
		// TODO Auto-generated method stub

	}

	public void addListarLienter(ListarListener listener) {
		// getPanelDadosListaFrete().addListaFreteListener(listener);

	}

	public void addConsultaClienteDestino(ConsultaCliente_Dest listener) {
		listeners.add(listener);
		getPanelDadosListaClienteDestino().addConsultaClienteDestino(listener);
	}
}
