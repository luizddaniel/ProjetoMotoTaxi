package edu.univas.projeto.tcc.view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import edu.univas.projeto.tcc.listeners.ButtonsListener;
import edu.univas.projeto.tcc.listeners.DadosFrete;
import edu.univas.projeto.tcc.model.FreteTO;

public class FrameEditarFrete extends JFrame {

	private static final long serialVersionUID = 233226304495596032L;

	private PanelDadosFrete panelDadosfrete;
	private PanelButtons panelButtons;

	private ArrayList<DadosFrete> listeners = new ArrayList<DadosFrete>();

	public FrameEditarFrete() {
		super("Editar Corridas ");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		initialize();

		pack();

		setLocationRelativeTo(null);

	}

	private void initialize() {

		add(getPanelDadosFrete(), BorderLayout.CENTER);
		add(getPanelButtons(), BorderLayout.SOUTH);

	}

	public PanelDadosFrete getPanelDadosFrete() {
		if (panelDadosfrete == null) {
			panelDadosfrete = new PanelDadosFrete();
		}
		return panelDadosfrete;
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
					//Integer a = 1;
					FreteTO freteTO = getPanelDadosFrete().getEditarFreteTO();
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

	public void addDadosEdicaoFrete(DadosFrete listener) {
		listeners.add(listener);
		getPanelDadosFrete().addDadosFrete(listener);
	}

}
