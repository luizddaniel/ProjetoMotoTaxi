package edu.univas.projeto.tcc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import edu.univas.projeto.tcc.listeners.ButtonsListarListener;

public class PanelListaButtons extends JButton {

	private static final long serialVersionUID = -4615838566498236537L;

	private JButton fecharButton;

	private ArrayList<ButtonsListarListener> listeners = new ArrayList<ButtonsListarListener>();

	public PanelListaButtons() {
		super();
		initialize();
	}

	private void initialize() {

		add(getCancelarButton());

	}

	private JButton getCancelarButton() {
		if (fecharButton == null) {
			URL pathToImage = getClass().getResource(
					"/edu/univas/projeto/tcc/files/image/fechar.png");
			fecharButton = new JButton("Fechar", new ImageIcon(pathToImage));
			fecharButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for (ButtonsListarListener listener : listeners) {
						listener.fechar();
					}
				}
			});
		}
		return fecharButton;
	}

	public void addButtonsListarListener(ButtonsListarListener listener) {
		if (listener != null) {
			listeners.add(listener);
		}
	}
}
