package edu.univas.projeto.tcc.view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import edu.univas.projeto.tcc.listeners.ButtonsListener;

import edu.univas.projeto.tcc.listeners.DadosMotoqueiro;

import edu.univas.projeto.tcc.model.MotoqueiroTO;

public class FrameEditarMotoqueiro extends JFrame {

	private static final long serialVersionUID = 527971407804474758L;

	private PanelDadosMotoqueiro panelDadosMotoqueiro;
	private PanelButtons panelButtons;

	private ArrayList<DadosMotoqueiro> listeners = new ArrayList<DadosMotoqueiro>();

	public FrameEditarMotoqueiro() {
		super("Editar Motoqueiro ");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		initialize();

		pack();

		setLocationRelativeTo(null);

	}

	private void initialize() {

		add(getPanelDadosMotoqueiro(), BorderLayout.CENTER);
		add(getPanelButtons(), BorderLayout.SOUTH);

	}

	public PanelDadosMotoqueiro getPanelDadosMotoqueiro() {
		if (panelDadosMotoqueiro == null) {
			panelDadosMotoqueiro = new PanelDadosMotoqueiro();
		}
		return panelDadosMotoqueiro;
	}

	private PanelButtons getPanelButtons() {
		if (panelButtons == null) {
			panelButtons = new PanelButtons();
			panelButtons.addButtonsListener(new ButtonsListener() {

				@Override
				public void cancelar() {
					for (DadosMotoqueiro listener : listeners) {
						listener.dadosCancelados();
					}

				}

				@Override
				public void gravar() {
					// Integer a = 1;
					MotoqueiroTO motoqueiroTO = getPanelDadosMotoqueiro()
							.getEditarMotoqueiroTO();
					if (motoqueiroTO != null) {
						for (DadosMotoqueiro listener : listeners) {
							listener.dadosgravados(motoqueiroTO);
						}

					}

				}

			});
		}
		return panelButtons;
	}

	public void addDadosEdicaoMotoqueiro(DadosMotoqueiro listener) {
		listeners.add(listener);
		getPanelDadosMotoqueiro().addDadosMotoqueiro(listener);
	}

}
