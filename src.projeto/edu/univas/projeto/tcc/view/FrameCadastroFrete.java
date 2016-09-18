package edu.univas.projeto.tcc.view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import edu.univas.projeto.tcc.listeners.ButtonsListener;
import edu.univas.projeto.tcc.listeners.DadosFrete;
import edu.univas.projeto.tcc.model.FreteTO;

public class FrameCadastroFrete extends JFrame {

	private static final long serialVersionUID = 2884354886849662451L;
	private PanelDadosFrete panelDadosFrete;
	private PanelButtons panelButtons;

	private ArrayList<DadosFrete> listeners = new ArrayList<DadosFrete>();

	public FrameCadastroFrete() {
		super("Cadastro Corrida");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		initialize();

		pack();

		setLocationRelativeTo(null);

	}

	private void initialize() {

		add(getPanelDadosFrete(), BorderLayout.CENTER);
		add(getPanelButtons(), BorderLayout.SOUTH);

	}

	private PanelDadosFrete getPanelDadosFrete() {
		if (panelDadosFrete == null) {
			panelDadosFrete = new PanelDadosFrete();
		}
		return panelDadosFrete;
	}

	private PanelButtons getPanelButtons() {
		if (panelButtons == null) {
			panelButtons = new PanelButtons();
			panelButtons.addButtonsListener(new ButtonsListener() {

				@Override
				public void cancelar() {
					for (DadosFrete listener : listeners) {
						listener.dadosCancelados();
					}

				}

				@Override
				public void gravar() {
					FreteTO freteTO = getPanelDadosFrete().getFreteTO();
					if (freteTO != null) {
						for (DadosFrete listener : listeners) {
							listener.dadosgravados(freteTO);
						}
					}

				}

			});
		}
		return panelButtons;
	}

	public void addDadosFrete(DadosFrete listener) {
		listeners.add(listener);
		getPanelDadosFrete().addDadosFrete(listener);
	}

}