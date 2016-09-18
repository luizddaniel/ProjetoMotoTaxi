package edu.univas.teste.tcc.motoqueiro;

import java.util.HashMap;

import edu.univas.projeto.tcc.model.DAOException;
import edu.univas.projeto.tcc.model.MotoqueiroDAO;
import edu.univas.projeto.tcc.model.MotoqueiroTO;

public class MotoquieroDAOMock extends MotoqueiroDAO {

	private HashMap<Integer, MotoqueiroTO> motoqueiroMap = new HashMap<Integer, MotoqueiroTO>();

	@Override
	public MotoqueiroTO buscarMotoqueiro(String id) {
		try {
			MotoqueiroDAO dao = new MotoqueiroDAO();
			MotoqueiroTO mot = new MotoqueiroTO();
			mot = dao.buscarMotoqueiro(id);
			addMotoqueiro(mot);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return motoqueiroMap.get(id);
	}

	public void addMotoqueiro(MotoqueiroTO funcionario) {
		motoqueiroMap.put(funcionario.getId(), funcionario);
	}
}
