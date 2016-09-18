package edu.univas.projeto.tcc.controller;

import edu.univas.projeto.tcc.listeners.MenuListener;
import edu.univas.projeto.tcc.model.Cliente_DestinoDAO;
import edu.univas.projeto.tcc.model.FreteDAO;
import edu.univas.projeto.tcc.model.MotoqueiroDAO;
import edu.univas.projeto.tcc.view.FramePrincipal;

public class ControllerPrincipal {

	private MotoqueiroDAO motoqueiroDAO;
	private Cliente_DestinoDAO cliente_DestinoDAO;
	private FreteDAO freteDAO;
	private FramePrincipal principal;

	public ControllerPrincipal(Cliente_DestinoDAO cliente_DestinoDAO,
			MotoqueiroDAO motoqueiroDAO, FreteDAO freteDAO) {
		this.motoqueiroDAO = motoqueiroDAO;
		this.cliente_DestinoDAO = cliente_DestinoDAO;
		this.freteDAO = freteDAO;
	}

	public void showFramePrincipal() {

		principal = new FramePrincipal();
		principal.addMenuListener(new MenuListener() {

			@Override
			public void cadastrar_Cli_Dest() {
				ControllerConsultaCliente_Destino cliente = new ControllerConsultaCliente_Destino(
						cliente_DestinoDAO);
				cliente.listarCliente_Destino();
			}

			@Override
			public void cadastrar_Frete() {
				ControllerConsultaFrete frete = new ControllerConsultaFrete(
						freteDAO);
				frete.listarFretes();

			}

			@Override
			public void cadastrar_Mot() {
				ControllerConsultaMotoqueiro motoqueiro = new ControllerConsultaMotoqueiro(
						motoqueiroDAO);
				motoqueiro.listarMotoqueiros();

			}

			@Override
			public void rel_bairro_m_s_serv() {
				// TODO Auto-generated method stub

			}

			@Override
			public void rel_cli_m_s_serv() {
				// TODO Auto-generated method stub

			}

			@Override
			public void rel_ep_ano_m_serv() {
				// TODO Auto-generated method stub

			}

			@Override
			public void rel_mot_m_serv() {
				// TODO Auto-generated method stub

			}

			@Override
			public void rel_qtd_serv_solic() {
				// TODO Auto-generated method stub

			}

		});
		principal.setLocationRelativeTo(null);
		principal.setVisible(true);
	}
}
