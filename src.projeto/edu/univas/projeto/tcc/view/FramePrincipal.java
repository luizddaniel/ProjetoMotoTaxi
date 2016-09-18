package edu.univas.projeto.tcc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import edu.univas.projeto.tcc.listeners.MenuListener;

public class FramePrincipal extends JFrame {

	private static final long serialVersionUID = 7548144117551668423L;

	private JMenuBar mainmenuBar;
	private JMenu cadastromenu;
	private JMenu relatoriomenu;
	//private JMenu sairmenu;
	private JMenuItem clientesItem;
	private JMenuItem motoqueiroItem;
	private JMenuItem corridaItem;
	private JMenuItem cli_m_s_servItem;
	private JMenuItem ep_ano_m_servItem;
	private JMenuItem mot_m_servItem;
	private JMenuItem qtd_serv_solicItem;
	private JMenuItem bairro_m_s_servItem;
	private JMenuItem sairItem;
	private JLabel label;

	private ArrayList<MenuListener> menuListeners = new ArrayList<MenuListener>();

	public FramePrincipal() {

		super("Sistema Disk Motos");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initialize();
		setSize(new Dimension(1000, 700));
		setResizable(false);
		
		setLocationRelativeTo(null);
	}

	private void initialize() {
		add(getLabel(), BorderLayout.BEFORE_FIRST_LINE);
		setJMenuBar(getmainMenuBar());

	}

	private JLabel getLabel() {
		if (label == null) {
			URL pathToImage = getClass().getResource(
					"/edu/univas/projeto/tcc/files/image/");
			label = new JLabel(new ImageIcon(pathToImage));
		}
		return label;
	}

	private JMenuBar getmainMenuBar() {
		if (mainmenuBar == null) {
			mainmenuBar = new JMenuBar();
			mainmenuBar.add(getCadastromenu());
			mainmenuBar.add(getRelatoriomenu());
			//mainmenuBar.add(getSairmenu());
		}
		return mainmenuBar;
	}

	private JMenu getCadastromenu() {
		if (cadastromenu == null) {
			cadastromenu = new JMenu();
			cadastromenu.setText("Cadastros");
			cadastromenu.add(getClientesItem());
			cadastromenu.add(new JSeparator());
			cadastromenu.add(getCorridaItem());
			cadastromenu.add(new JSeparator());
			cadastromenu.add(getMotoqueiroItem());
			cadastromenu.add(new JSeparator());
			cadastromenu.add(getSairItem());
		}
		return cadastromenu;
	}

	private JMenu getRelatoriomenu() {
		if (relatoriomenu == null) {
			relatoriomenu = new JMenu();
			relatoriomenu.setText("Relatórios");
			relatoriomenu.add(getCli_m_s_servItem());
			relatoriomenu.add(new JSeparator());
			relatoriomenu.add(getEp_ano_m_servItem());
			relatoriomenu.add(new JSeparator());
			relatoriomenu.add(getMot_m_servItem());
			relatoriomenu.add(new JSeparator());
			relatoriomenu.add(getQtd_serv_solicItem());
			relatoriomenu.add(new JSeparator());
			relatoriomenu.add(getBairro_m_s_servItem());

		}
		return relatoriomenu;
	}

//	private JMenu getSairmenu() {
//		if (sairmenu == null) {
//			sairmenu = new JMenu();
//			sairmenu.setText("Sair");
			

				
			
			
	//	}
//		return sairmenu;
//	}

	private JMenuItem getClientesItem() {
		if (clientesItem == null) {
			clientesItem = new JMenuItem();
			clientesItem.setText("Clientes / Destinos");
			clientesItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					for (MenuListener listener : menuListeners) {
						listener.cadastrar_Cli_Dest();
					}
				}

			});
		}
		return clientesItem;
	}

	private JMenuItem getMotoqueiroItem() {
		if (motoqueiroItem == null) {
			motoqueiroItem = new JMenuItem();
			motoqueiroItem.setText("Motoqueiros");
			motoqueiroItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					for (MenuListener listener : menuListeners) {
						listener.cadastrar_Mot();
					}

				}

			});
		}
		return motoqueiroItem;
	}

	private JMenuItem getCorridaItem() {
		if (corridaItem == null) {
			corridaItem = new JMenuItem();
			corridaItem.setText("Corridas");
			corridaItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					for (MenuListener listener : menuListeners) {
						listener.cadastrar_Frete();
					}

				}

			});
		}
		return corridaItem;
	}

	private JMenuItem getCli_m_s_servItem() {
		if (cli_m_s_servItem == null) {
			cli_m_s_servItem = new JMenuItem();
			cli_m_s_servItem.setText("Cliente que mais solicitou o serviço");
			cli_m_s_servItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					for (MenuListener listener : menuListeners) {
						listener.rel_cli_m_s_serv();
					}

				}

			});
		}
		return cli_m_s_servItem;
	}

	private JMenuItem getEp_ano_m_servItem() {
		if (ep_ano_m_servItem == null) {
			ep_ano_m_servItem = new JMenuItem();
			ep_ano_m_servItem
					.setText("Qual época do ano que teve mais serviço");
			ep_ano_m_servItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					for (MenuListener listener : menuListeners) {
						listener.rel_ep_ano_m_serv();
					}

				}

			});
		}
		return ep_ano_m_servItem;
	}

	private JMenuItem getMot_m_servItem() {
		if (mot_m_servItem == null) {
			mot_m_servItem = new JMenuItem();
			mot_m_servItem.setText("Motoqueiro que realizou mais serviço");
			mot_m_servItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					for (MenuListener listener : menuListeners) {
						listener.rel_mot_m_serv();
					}

				}

			});
		}
		return mot_m_servItem;
	}

	private JMenuItem getQtd_serv_solicItem() {
		if (qtd_serv_solicItem == null) {
			qtd_serv_solicItem = new JMenuItem();
			qtd_serv_solicItem.setText("Quantidade de serviços solicitados");
			qtd_serv_solicItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					for (MenuListener listener : menuListeners) {
						listener.rel_qtd_serv_solic();
					}

				}

			});
		}

		return qtd_serv_solicItem;
	}

	private JMenuItem getBairro_m_s_servItem() {
		if (bairro_m_s_servItem == null) {
			bairro_m_s_servItem = new JMenuItem();
			bairro_m_s_servItem
					.setText("Qual bairro teve maior solicitação de serviço");
			bairro_m_s_servItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					for (MenuListener listener : menuListeners) {
						listener.rel_bairro_m_s_serv();
					}

				}

			});
		}
		return bairro_m_s_servItem;
	}

	private JMenuItem getSairItem() {
		if (sairItem == null) {
			sairItem = new JMenuItem();
			sairItem.setText("Sair");
			sairItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (JOptionPane.showConfirmDialog(FramePrincipal.this,
							"Sair da aplicação?", "Sistema Disk Motos",
							JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
						System.exit(0);
					}

				}
			});
		}

		return sairItem;
	}

	public void addMenuListener(MenuListener listener) {
		menuListeners.add(listener);
	}
}
