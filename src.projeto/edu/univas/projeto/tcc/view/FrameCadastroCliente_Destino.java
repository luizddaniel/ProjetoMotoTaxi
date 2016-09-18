package edu.univas.projeto.tcc.view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import edu.univas.projeto.tcc.listeners.ButtonsListener;
import edu.univas.projeto.tcc.listeners.DadosCliente_Destino;
import edu.univas.projeto.tcc.model.Cliente_DestinoTO;

public class FrameCadastroCliente_Destino extends JFrame {

	private static final long serialVersionUID = -8125462419220250722L;

	private PanelDadosCliente_Destino panelDadosCliente_Destino;
	private PanelButtons panelButtons;

	private ArrayList<DadosCliente_Destino> listeners = new ArrayList<DadosCliente_Destino>();

	public FrameCadastroCliente_Destino() {
		super("Cadastro Cliente/Destino");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		initialize();

		pack();

		setLocationRelativeTo(null);

	}

	private void initialize() {

		add(getPanelDadosCliente_Destino(), BorderLayout.CENTER);
		add(getPanelButtons(), BorderLayout.SOUTH);

	}

	private PanelDadosCliente_Destino getPanelDadosCliente_Destino() {
		if (panelDadosCliente_Destino == null) {
			panelDadosCliente_Destino = new PanelDadosCliente_Destino();
		}
		return panelDadosCliente_Destino;
	}

	private PanelButtons getPanelButtons() {
		if (panelButtons == null) {
			panelButtons = new PanelButtons();
			panelButtons.addButtonsListener(new ButtonsListener() {

				@Override
				public void cancelar() {
					for (DadosCliente_Destino listener : listeners) {
						listener.dadosCancelados();
					}

				}

				@Override
				public void gravar() {
					Cliente_DestinoTO cliente_DestinoTO = getPanelDadosCliente_Destino()
							.getCliente_DestinoTO();
					if (cliente_DestinoTO != null) {
						for (DadosCliente_Destino listener : listeners) {
							listener.dadosgravados(cliente_DestinoTO);
						}
					}

				}

			});
		}
		return panelButtons;
	}

	public void addDadosCliente_Destino(DadosCliente_Destino listener) {
		listeners.add(listener);
		getPanelDadosCliente_Destino().addDadosCliente_Dest(listener);
	}

}
