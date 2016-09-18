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

public class MotoqueiroDAO {

	public void cadastrarMotoqueiro(MotoqueiroTO motoqueiroTO)
			throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;

		if (motoqueiroTO != null) {
			try {
				conn = new ConnectionBanco().getConnection();
				String sql = " INSERT INTO motoqueiro (nome, endereco, numero, num_motoq, bairro, cidade, cep, telefone, data, tipo_sang, cpf, rg, cnh, categoria, moto, renavan, ano_modelo, cilindrada, placa, cor) "
						+ " values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

				ps = conn.prepareStatement(sql);

				ps.setString(1, motoqueiroTO.getNome());
				ps.setString(2, motoqueiroTO.getEndereco());
				ps.setInt(3, motoqueiroTO.getNumero());
				ps.setInt(4, motoqueiroTO.getNum_motoq());
				ps.setString(5, motoqueiroTO.getBairro());
				ps.setString(6, motoqueiroTO.getCidade());
				ps.setString(7, motoqueiroTO.getCep());
				ps.setString(8, motoqueiroTO.getTelefone());
				ps.setDate(9, new Date(motoqueiroTO.getData().getTime()));
				ps.setString(10, motoqueiroTO.getTipo_sang());
				ps.setString(11, motoqueiroTO.getCpf());
				ps.setString(12, motoqueiroTO.getRg());
				ps.setString(13, motoqueiroTO.getCnh());
				ps.setString(14, motoqueiroTO.getCategoria());
				ps.setString(15, motoqueiroTO.getMoto());
				ps.setString(16, motoqueiroTO.getRenavan());
				ps.setString(17, motoqueiroTO.getAno_modelo());
				ps.setString(18, motoqueiroTO.getCilindrada());
				ps.setString(19, motoqueiroTO.getPlaca_moto());
				ps.setString(20, motoqueiroTO.getCor());

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

	public ArrayList<MotoqueiroTO> listarMotoqueiros() throws DAOException {

		Connection conn = null;
		Statement sttm = null;
		ResultSet rs = null;

		try {
			ArrayList<MotoqueiroTO> result = new ArrayList<MotoqueiroTO>();
			conn = new ConnectionBanco().getConnection();

			// String sql =
			// "SELECT num_conta, cod_agencia, cod_cliente, saldo, limite FROM contacorrente  ORDER BY cod_cliente";
			String sql = "SELECT m.id, m.nome, m.num_motoq, m.telefone, m.moto, m.cor, m.placa, m.tipo_sang FROM motoqueiro AS m ORDER BY m.id";
			sttm = conn.createStatement();
			rs = sttm.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				int numero = rs.getInt("num_motoq");
				String telefone = rs.getString("telefone");
				String moto = rs.getString("moto");
				String cor = rs.getString("cor");
				String placa = rs.getString("placa");
				String tipo_sang = rs.getString("tipo_sang");

				MotoqueiroTO motoqueiro = new MotoqueiroTO();

				motoqueiro.setId(id);
				motoqueiro.setNome(nome);
				motoqueiro.setNum_motoq(numero);
				motoqueiro.setTelefone(telefone);
				motoqueiro.setMoto(moto);
				motoqueiro.setCor(cor);
				motoqueiro.setPlaca_moto(placa);
				motoqueiro.setTipo_sang(tipo_sang);

				result.add(motoqueiro);

			}
			sttm.close();
			rs.close();
			return result;

		} catch (SQLException e) {
			throw new DAOException("Erro:" + e.getMessage());

		}

	}

	public ArrayList<MotoqueiroTO> listarMotoqueirosCombobox()throws DAOException {

		Connection conn = null;
		Statement sttm = null;
		ResultSet rs = null;
		try {
			ArrayList<MotoqueiroTO> result = new ArrayList<MotoqueiroTO>();
			conn = new ConnectionBanco().getConnection();
			String sql = "SELECT m.nome, m.num_motoq FROM motoqueiro AS m ORDER BY m.num_motoq";
			sttm = conn.createStatement();
			rs = sttm.executeQuery(sql);

			while (rs.next()) {

				String nome = rs.getString("nome");
				int numero = rs.getInt("num_motoq");

				MotoqueiroTO motoqueiro = new MotoqueiroTO();

				motoqueiro.setNome(nome);
				motoqueiro.setNum_motoq(numero);

				result.add(motoqueiro);

			}
			sttm.close();
			rs.close();
			return result;

		} catch (SQLException e) {
			throw new DAOException("Erro:" + e.getMessage());
		}
	}

	public void excluirMotoqueiro(String codigo) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		// String i = codigo;
		Statement sttm = null;
		ResultSet rs = null;
		MotoqueiroTO motoqueiroTO = null;

		try {
			conn = new ConnectionBanco().getConnection();
			String sql1 = "SELECT * FROM motoqueiro m WHERE m.id= " + codigo;

			sttm = conn.createStatement();
			rs = sttm.executeQuery(sql1);

			while (rs.next()) {

				int id = rs.getInt("id");

				motoqueiroTO = new MotoqueiroTO();
				motoqueiroTO.setId(id);

			}

			sttm.close();
			rs.close();

			if (motoqueiroTO.getId() != null) {
				try {

					String sql = " delete from motoqueiro m where m.id = "
							+ motoqueiroTO.getId();
					ps = conn.prepareStatement(sql);
					ps.executeUpdate();
					ps.close();

				} catch (SQLException e) {
					throw new DAOException(
							"Não foi possível excluir o Motoqueiro.\nError: "
									+ e.getMessage());
				}

			} else {
				throw new DAOException("Não há dados a serem excluídos.");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Não Foi Possível excluir o registro!");

		}
	}

	public MotoqueiroTO buscarMotoqueiro(String codigo) throws DAOException {

		Connection conn = null;
		Statement sttm = null;
		ResultSet rs = null;

		try {
			MotoqueiroTO result = new MotoqueiroTO();
			conn = new ConnectionBanco().getConnection();
			String sql = "SELECT * FROM motoqueiro m WHERE m.id= " + codigo;

			sttm = conn.createStatement();
			rs = sttm.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String end = rs.getString("endereco");
				int num = rs.getInt("numero");
				int num_motoq = rs.getInt("num_motoq");
				String bairro = rs.getString("bairro");
				String cidade = rs.getString("cidade");
				String cep = rs.getString("cep");
				String telefone = rs.getString("telefone");
				Date data = rs.getDate("data");
				String tipo_sang = rs.getString("tipo_sang");
				String cpf = rs.getString("cpf");
				String rg = rs.getString("rg");
				String cnh = rs.getString("cnh");
				String categoria = rs.getString("categoria");
				String moto = rs.getString("moto");
				String renavan = rs.getString("renavan");
				String ano_modelo = rs.getString("ano_modelo");
				String cilindrada = rs.getString("cilindrada");
				String placa = rs.getString("placa");
				String cor = rs.getString("cor");

				MotoqueiroTO motoqueiro = new MotoqueiroTO();

				motoqueiro.setId(id);
				motoqueiro.setNome(nome);
				motoqueiro.setEndereco(end);
				motoqueiro.setNumero(num);
				motoqueiro.setNum_motoq(num_motoq);
				motoqueiro.setBairro(bairro);
				motoqueiro.setCidade(cidade);
				motoqueiro.setCep(cep);
				motoqueiro.setTelefone(telefone);
				motoqueiro.setData(data);
				motoqueiro.setTipo_sang(tipo_sang);
				motoqueiro.setCpf(cpf);
				motoqueiro.setRg(rg);
				motoqueiro.setCnh(cnh);
				motoqueiro.setCategoria(categoria);
				motoqueiro.setMoto(moto);
				motoqueiro.setRenavan(renavan);
				motoqueiro.setAno_modelo(ano_modelo);
				motoqueiro.setCilindrada(cilindrada);
				motoqueiro.setPlaca_moto(placa);
				motoqueiro.setCor(cor);
				result = motoqueiro;

			}
			sttm.close();
			rs.close();

			return result;

		} catch (SQLException e) {
			throw new DAOException("Erro:" + e.getMessage());
		}
	}

	public void editarMotoqueiro(MotoqueiroTO motoqueiroTO) throws DAOException {

		JOptionPane
				.showMessageDialog(null, "Valor ID: " + motoqueiroTO.getId());
		Connection conn = null;

		PreparedStatement ps = null;
		if (motoqueiroTO != null) {
			try {
				conn = new ConnectionBanco().getConnection();
				String sql = " UPDATE motoqueiro set nome=?, endereco=?, numero=?, num_motoq=?, bairro=?, cidade=?, cep=?, telefone=?, data=?, tipo_sang=?, cpf=?, rg=?, cnh=?, categoria=?, moto=?, renavan=?, ano_modelo=?, cilindrada=?, placa=?, cor=? where id = "
						+ motoqueiroTO.getId();

				ps = conn.prepareStatement(sql);

				// nome=?, endereco=?, numero=?, num_motoq=?, bairro=?,
				// cidade=?,
				// cep=?, telefone=?, data=?, tipo_sang=?, cpf=?, rg=?, cnh=?,
				// categoria=?, moto=?, renavan=?, ano_modelo=?, cilindrada=?,
				// placa=?, cor=?
				ps.setString(1, motoqueiroTO.getNome());
				ps.setString(2, motoqueiroTO.getEndereco());
				ps.setInt(3, motoqueiroTO.getNumero());
				ps.setInt(4, motoqueiroTO.getNum_motoq());
				ps.setString(5, motoqueiroTO.getBairro());
				ps.setString(6, motoqueiroTO.getCidade());
				ps.setString(7, motoqueiroTO.getCep());
				ps.setString(8, motoqueiroTO.getTelefone());
				ps.setDate(9, new Date(motoqueiroTO.getData().getTime()));
				ps.setString(10, motoqueiroTO.getTipo_sang());
				ps.setString(11, motoqueiroTO.getCpf());
				ps.setString(12, motoqueiroTO.getRg());
				ps.setString(13, motoqueiroTO.getCnh());
				ps.setString(14, motoqueiroTO.getCategoria());
				ps.setString(15, motoqueiroTO.getMoto());
				ps.setString(16, motoqueiroTO.getRenavan());
				ps.setString(17, motoqueiroTO.getAno_modelo());
				ps.setString(18, motoqueiroTO.getCilindrada());
				ps.setString(19, motoqueiroTO.getPlaca_moto());
				ps.setString(20, motoqueiroTO.getCor());

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
