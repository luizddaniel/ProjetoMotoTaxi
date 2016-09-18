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

public class Cliente_DestinoDAO {

	public void cadastrar(Cliente_DestinoTO cliente_DestinoTO)
			throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;

		if (cliente_DestinoTO != null) {
			try {
				conn = new ConnectionBanco().getConnection();
				String sql = " INSERT INTO cliente_destino (nome, tipo, endereco, numero, bairro, cidade, cep, telefone, cnpj_cpf, insc_rg, e_mail, data_cad ) "
						+ " values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

				ps = conn.prepareStatement(sql);

				ps.setString(1, cliente_DestinoTO.getNome());
				ps.setString(2, cliente_DestinoTO.getTipo());
				ps.setString(3, cliente_DestinoTO.getEndereco());
				ps.setInt(4, cliente_DestinoTO.getNumero());
				ps.setString(5, cliente_DestinoTO.getBairro());
				ps.setString(6, cliente_DestinoTO.getCidade());
				ps.setString(7, cliente_DestinoTO.getCep());
				ps.setString(8, cliente_DestinoTO.getTelefone());
				ps.setString(9, cliente_DestinoTO.getCnpj_cpf());
				ps.setString(10, cliente_DestinoTO.getInsc_rg());
				ps.setString(11, cliente_DestinoTO.getE_mail());
				ps.setDate(12, new Date(cliente_DestinoTO.getData_cad()
						.getTime()));

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

	public ArrayList<Cliente_DestinoTO> listarClientes_Destino()
			throws DAOException {

		Connection conn = null;
		Statement sttm = null;
		ResultSet rs = null;

		try {
			ArrayList<Cliente_DestinoTO> result = new ArrayList<Cliente_DestinoTO>();
			conn = new ConnectionBanco().getConnection();

			// String sql =
			// "SELECT num_conta, cod_agencia, cod_cliente, saldo, limite FROM contacorrente  ORDER BY cod_cliente";
			String sql = "SELECT cd.id, cd.nome, cd.endereco, cd.numero, cd.bairro, cd.cidade, cd.cep, cd.telefone,cd.e_mail FROM cliente_destino AS cd ORDER BY cd.id";
			sttm = conn.createStatement();
			rs = sttm.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				int numero = rs.getInt("numero");
				String bairro = rs.getString("bairro");
				String cidade = rs.getString("cidade");
				String cep = rs.getString("cep");
				String telefone = rs.getString("telefone");
				String e_mail = rs.getString("e_mail");

				Cliente_DestinoTO cliente_destino = new Cliente_DestinoTO();

				cliente_destino.setId(id);
				cliente_destino.setNome(nome);
				cliente_destino.setEndereco(endereco);
				cliente_destino.setNumero(numero);
				cliente_destino.setBairro(bairro);
				cliente_destino.setCidade(cidade);
				cliente_destino.setCep(cep);
				cliente_destino.setTelefone(telefone);
				cliente_destino.setE_mail(e_mail);
				result.add(cliente_destino);

			}
			sttm.close();
			rs.close();
			return result;

		} catch (SQLException e) {
			throw new DAOException("Erro:" + e.getMessage());
		}

	}

	public ArrayList<Cliente_DestinoTO> listarClientes_DestinoCombobox()
			throws DAOException {

		Connection conn = null;
		Statement sttm = null;
		ResultSet rs = null;

		try {
			ArrayList<Cliente_DestinoTO> result = new ArrayList<Cliente_DestinoTO>();
			conn = new ConnectionBanco().getConnection();

			// String sql =
			// "SELECT num_conta, cod_agencia, cod_cliente, saldo, limite FROM contacorrente  ORDER BY cod_cliente";
			String sql = "SELECT cd.nome FROM cliente_destino AS cd ORDER BY cd.id";
			sttm = conn.createStatement();
			rs = sttm.executeQuery(sql);

			while (rs.next()) {

				String nome = rs.getString("nome");

				Cliente_DestinoTO cliente_destino = new Cliente_DestinoTO();

				cliente_destino.setNome(nome);
				result.add(cliente_destino);

			}
			sttm.close();
			rs.close();
			return result;

		} catch (SQLException e) {
			throw new DAOException("Erro:" + e.getMessage());
		}

	}

	public void excluirDestino(String codigo) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		String i = codigo;
		Statement sttm = null;
		ResultSet rs = null;
		Cliente_DestinoTO clienteDestino = null;

		try {
			conn = new ConnectionBanco().getConnection();
			String sql1 = "SELECT * FROM cliente_destino cd WHERE cd.id= "
					+ codigo;

			sttm = conn.createStatement();
			rs = sttm.executeQuery(sql1);

			while (rs.next()) {

				int id = rs.getInt("id");

				clienteDestino = new Cliente_DestinoTO();
				clienteDestino.setId(id);

			}

			sttm.close();
			rs.close();

			if (clienteDestino.getId() != null) {
				try {

					// conn = new ConnectionBanco().getConnection();
					String sql = " delete from cliente_destino cd where cd.id = "
							+ i;
					ps = conn.prepareStatement(sql);
					ps.executeUpdate();
					ps.close();

				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Código " + codigo
							+ " Inexistente!\n Não foi possível o registro!");
					throw new DAOException(
							"Não foi possível excluir o registro.\nError: "
									+ e.getMessage());
				}

			} else {
				throw new DAOException("Não há dados a serem cadastrados.");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Não Foi Possível excluir o registro!");

		}
	}

	public Cliente_DestinoTO buscarClienteDestino(String codigo)
			throws DAOException {

		Connection conn = null;
		Statement sttm = null;
		ResultSet rs = null;

		try {
			Cliente_DestinoTO result = new Cliente_DestinoTO();
			conn = new ConnectionBanco().getConnection();
			String sql = "SELECT * FROM cliente_destino cd WHERE cd.id= "
					+ codigo;

			sttm = conn.createStatement();
			rs = sttm.executeQuery(sql);

			while (rs.next()) {

				// nome=?, tipo=?, endereco=?, numero=?, bairro=?, cidade=?,
				// cep=?, telefone=?, cnpj_cpf=?, insc_rg=?, e_mail=?,
				// data_cad=?
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String tipo = rs.getString("tipo");
				String end = rs.getString("endereco");
				int num = rs.getInt("numero");
				String bairro = rs.getString("bairro");
				String cidade = rs.getString("cidade");
				String cep = rs.getString("cep");
				String telefone = rs.getString("telefone");
				String cnpj_cpf = rs.getString("cnpj_cpf");
				String insc_rg = rs.getString("insc_rg");
				String e_mail = rs.getString("e_mail");
				Date data_cad = rs.getDate("data_cad");

				Cliente_DestinoTO clienteDestino = new Cliente_DestinoTO();

				clienteDestino.setId(id);
				clienteDestino.setNome(nome);
				clienteDestino.setTipo(tipo);
				clienteDestino.setEndereco(end);
				clienteDestino.setNumero(num);
				clienteDestino.setBairro(bairro);
				clienteDestino.setCidade(cidade);
				clienteDestino.setCep(cep);
				clienteDestino.setTelefone(telefone);
				clienteDestino.setCnpj_cpf(cnpj_cpf);
				clienteDestino.setInsc_rg(insc_rg);
				clienteDestino.setE_mail(e_mail);
				clienteDestino.setData_cad(data_cad);
				result = clienteDestino;
			}
			sttm.close();
			rs.close();

			return result;

		} catch (SQLException e) {
			throw new DAOException("Erro:" + e.getMessage());
		}

	}

	public void editarCliente_Destino(Cliente_DestinoTO cliente_DestinoTO)
			throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;

		if (cliente_DestinoTO != null) {
			try {
				conn = new ConnectionBanco().getConnection();
				String sql = " UPDATE cliente_destino SET nome=?, tipo=?, endereco=?, numero=?, bairro=?, cidade=?, cep=?, telefone=?, cnpj_cpf=?, insc_rg=?, e_mail=?, data_cad=? WHERE id = "
						+ cliente_DestinoTO.getId();

				ps = conn.prepareStatement(sql);

				ps.setString(1, cliente_DestinoTO.getNome());
				ps.setString(2, cliente_DestinoTO.getTipo());
				ps.setString(3, cliente_DestinoTO.getEndereco());
				ps.setInt(4, cliente_DestinoTO.getNumero());
				ps.setString(5, cliente_DestinoTO.getBairro());
				ps.setString(6, cliente_DestinoTO.getCidade());
				ps.setString(7, cliente_DestinoTO.getCep());
				ps.setString(8, cliente_DestinoTO.getTelefone());
				ps.setString(9, cliente_DestinoTO.getCnpj_cpf());
				ps.setString(10, cliente_DestinoTO.getInsc_rg());
				ps.setString(11, cliente_DestinoTO.getE_mail());
				ps.setDate(12, new Date(cliente_DestinoTO.getData_cad()
						.getTime()));

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

}
