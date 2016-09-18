package edu.univas.projeto.tcc.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import edu.univas.projeto.tcc.controller.ConnectionBanco;

public class FreteDAO {

	public void cadastrarFrete(FreteTO freteTO) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		if (freteTO != null) {
			try {
				conn = new ConnectionBanco().getConnection();
				String sql = " INSERT INTO "
						+ "frete (num_frete, hora_lig, hora_saida, hora_cheg,"
						+ " valor, data, destino, motoqueiro )"
						+ " values ( ?, ?, ?, ?, ?, ?, ?, ?) ";

				ps = conn.prepareStatement(sql);

				ps.setInt(1, freteTO.getNum_frete());
				ps.setString(2, freteTO.getHora_lig());
				ps.setString(3, freteTO.getHora_saida());
				ps.setString(4, freteTO.getHora_cheg());
				ps.setFloat(5, freteTO.getValor());
				ps.setDate(6, new Date(freteTO.getData().getTime()));
				ps.setString(7, freteTO.getDestino());
				ps.setString(8, freteTO.getMotoq());

				ps.executeUpdate();

				ps.close();
			} catch (SQLException e) {
				throw new DAOException(
						"Não foi possível realizar o cadastro.\nError: "
								+ e.getMessage());
			}
		} else {
			throw new DAOException("Não há dados a serem cadastrados.");
		}
	}

	public ArrayList<FreteTO> listarFretes() throws DAOException {

		Connection conn = null;
		Statement sttm = null;
		ResultSet rs = null;

		try {
			ArrayList<FreteTO> result = new ArrayList<FreteTO>();
			conn = new ConnectionBanco().getConnection();

			// String sql =
			// "SELECT num_conta, cod_agencia, cod_cliente, saldo, limite FROM contacorrente  ORDER BY cod_cliente";
			String sql = "SELECT f.id, f.num_frete, f.hora_lig, f.hora_saida, f.hora_cheg, f.valor, f.data, f.destino, f.motoqueiro FROM frete AS f ORDER BY f.id";
			sttm = conn.createStatement();
			rs = sttm.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("id");
				int num_frete = rs.getInt("num_frete");
				String hl = rs.getString("hora_lig");
				String hs = rs.getString("hora_saida");
				String hc = rs.getString("hora_cheg");
				Float vlr = rs.getFloat("valor");
				Date data = rs.getDate("data");
				String destino = rs.getString("destino");
				String motoq = rs.getString("motoqueiro");

				FreteTO frete = new FreteTO();

				frete.setId(id);
				frete.setHora_lig(hl);
				frete.setHora_saida(hs);
				frete.setNum_frete(num_frete);
				frete.setHora_cheg(hc);
				frete.setValor(vlr);
				frete.setData(data);
				frete.setDestino(destino);
				frete.setMotoq(motoq);
				result.add(frete);

			}
			sttm.close();
			rs.close();
			return result;

		} catch (SQLException e) {
			throw new DAOException("Erro:" + e.getMessage());
		}

	}

	public void excluirFrete(String codigo) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		String i = codigo;
		Statement sttm = null;
		ResultSet rs = null;
		FreteTO freteTO = null;

		try {
			conn = new ConnectionBanco().getConnection();
			String sql1 = "SELECT * FROM frete f WHERE f.id= " + codigo;

			sttm = conn.createStatement();
			rs = sttm.executeQuery(sql1);

			while (rs.next()) {

				int id = rs.getInt("id");

				freteTO = new FreteTO();
				freteTO.setId(id);

			}

			sttm.close();
			rs.close();

			if (freteTO.getId() != null) {
				try {

					String sql = " delete from frete f where f.id = " + i;
					ps = conn.prepareStatement(sql);
					ps.executeUpdate();
					ps.close();

				} catch (SQLException e) {
					throw new DAOException(
							"Não foi possível excluir o frete.\nError: "
									+ e.getMessage());
				}

			} else {
				throw new DAOException("Não há dados a serem excluidos.");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Não Foi Possível excluir o registro!");

		}
	}

	public FreteTO buscarFrete(String codigo) throws DAOException {

		Connection conn = null;
		Statement sttm = null;
		ResultSet rs = null;

		try {
			FreteTO result = new FreteTO();
			conn = new ConnectionBanco().getConnection();
			String sql = "SELECT f.id, f.num_frete, f.hora_lig, f.hora_saida, f.hora_cheg, f.valor, f.data, f.destino, f.motoqueiro FROM frete f WHERE f.id= "
					+ codigo;
			sttm = conn.createStatement();
			rs = sttm.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("id");
				int num_frete = rs.getInt("num_frete");
				String hl = rs.getString("hora_lig");
				String hs = rs.getString("hora_saida");
				String hc = rs.getString("hora_cheg");
				Float vlr = rs.getFloat("valor");
				Date data = rs.getDate("data");
				String destino = rs.getString("destino");
				String motoq = rs.getString("motoqueiro");

				FreteTO frete = new FreteTO();

				frete.setId(id);
				frete.setHora_lig(hl);
				frete.setHora_saida(hs);
				frete.setNum_frete(num_frete);
				frete.setHora_cheg(hc);
				frete.setValor(vlr);
				frete.setData(data);
				frete.setDestino(destino);
				frete.setMotoq(motoq);
				result = frete;

			}
			sttm.close();
			rs.close();

			return result;

		} catch (SQLException e) {
			throw new DAOException("Erro:" + e.getMessage());
		}

	}

	public FreteTO pesquisarFrete(String codigo) throws DAOException {

		Connection conn = null;
		Statement sttm = null;
		ResultSet rs = null;
		// Character nome = codigo.toCharArray();
		try {
			// FreteTO freteTO = new FreteTO();
			// freteTO.setDestino(codigo);
			FreteTO result = new FreteTO();
			conn = new ConnectionBanco().getConnection();
			String sql = "SELECT f.id, f.num_frete, f.hora_lig, f.hora_saida, f.hora_cheg, f.valor, f.data, f.destino, f.motoqueiro FROM frete f WHERE f.destino= "
					+ codigo;
			sttm = conn.createStatement();
			rs = sttm.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("id");
				int num_frete = rs.getInt("num_frete");
				String hl = rs.getString("hora_lig");
				String hs = rs.getString("hora_saida");
				String hc = rs.getString("hora_cheg");
				Float vlr = rs.getFloat("valor");
				Date data = rs.getDate("data");
				String destino = rs.getString("destino");
				String motoq = rs.getString("motoqueiro");

				FreteTO frete = new FreteTO();

				frete.setId(id);
				frete.setHora_lig(hl);
				frete.setHora_saida(hs);
				frete.setNum_frete(num_frete);
				frete.setHora_cheg(hc);
				frete.setValor(vlr);
				frete.setData(data);
				frete.setDestino(destino);
				frete.setMotoq(motoq);
				result = frete;

			}
			sttm.close();
			rs.close();

			return result;

		} catch (SQLException e) {
			throw new DAOException("Erro:" + e.getMessage());
		}

	}

	public void editarFrete(FreteTO freteTO) throws DAOException {

		JOptionPane.showMessageDialog(null, "Valor ID: " + freteTO.getId());
		Connection conn = null;

		PreparedStatement ps = null;
		if (freteTO != null) {
			try {
				conn = new ConnectionBanco().getConnection();
				String sql = " UPDATE frete set num_frete = ?, hora_lig = ?, hora_saida = ?, hora_cheg = ?, valor = ?, data = ?, destino = ?, motoqueiro = ? where id = "
						+ freteTO.getId();

				ps = conn.prepareStatement(sql);

				ps.setInt(1, freteTO.getNum_frete());
				ps.setString(2, freteTO.getHora_lig());
				ps.setString(3, freteTO.getHora_saida());
				ps.setString(4, freteTO.getHora_cheg());
				ps.setFloat(5, freteTO.getValor());
				ps.setDate(6, new Date(freteTO.getData().getTime()));
				ps.setString(7, freteTO.getDestino());
				ps.setString(8, freteTO.getMotoq());

				ps.executeUpdate();

				ps.close();
			} catch (SQLException e) {
				throw new DAOException(
						"Não foi possível realizar a atualização do cadastro.\nError: "
								+ e.getMessage());
			}

		} else {
			throw new DAOException("Não há dados a serem cadastrados.");
		}
	}
}
