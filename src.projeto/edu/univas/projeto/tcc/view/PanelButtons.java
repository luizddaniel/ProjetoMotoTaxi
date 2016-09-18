package edu.univas.projeto.tcc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import edu.univas.projeto.tcc.listeners.ButtonsListener;

public class PanelButtons extends JPanel {

	private static final long serialVersionUID = -6180442199389873498L;

	private JButton okButton;
	private JButton cancelButton;

	private ArrayList<ButtonsListener> listeners = new ArrayList<ButtonsListener>();

	public PanelButtons() {
		super();
		initialize();
	}

	private void initialize() {
		add(getOkButton());
		add(getCancelButton());

	}

	private JButton getOkButton() {
		if (okButton == null) {
			URL pathToImage = getClass().getResource(
					"/edu/univas/projeto/tcc/files/image/confirma.png");
			okButton = new JButton("OK", new ImageIcon(pathToImage));
			okButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for (ButtonsListener listener : listeners) {
						listener.gravar();
					}
				}
			});
		}

		return okButton;
	}

	private JButton getCancelButton() {
		if (cancelButton == null) {

			URL pathToImage = getClass().getResource(
					"/edu/univas/projeto/tcc/files/image/cancel.png");
			cancelButton = new JButton("Cancelar", new ImageIcon(pathToImage));
			cancelButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for (ButtonsListener listener : listeners) {
						listener.cancelar();
					}
				}
			});
		}

		return cancelButton;
	}

	public void addButtonsListener(ButtonsListener listener) {
		if (listener != null) {
			listeners.add(listener);
		}
	}
}
