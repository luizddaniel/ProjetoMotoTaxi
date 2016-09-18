package edu.univas.teste.tcc.clienteDestino;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import junit.framework.TestCase;
import edu.univas.projeto.tcc.model.Cliente_DestinoTO;

public class ClienteDestinoTeste extends TestCase {

	private Cliente_DestinoTO cliente_destino;

	protected void setUp() throws Exception {
		super.setUp();
		cliente_destino = new Cliente_DestinoTO();
	}

	public void testId() {
		int result;
		cliente_destino.setId(1);
		result = cliente_destino.getId();
		assertEquals(1, result);
	}

	public void testNome() {
		String result;
		cliente_destino.setNome("Luiz Fernando");
		result = cliente_destino.getNome();
		assertEquals("Luiz Fernando", result);
	}

	public void testTipo() {
		String result;
		cliente_destino.setTipo("Destino");
		result = cliente_destino.getTipo();
		assertEquals("Destino", result);
	}

	public void testEndereco() {
		String result;
		cliente_destino.setEndereco("Rua Dr. Paulino Pereira da Silva");
		result = cliente_destino.getEndereco();
		assertEquals("Rua Dr. Paulino Pereira da Silva", result);
	}

	public void testNumero() {
		int result;
		cliente_destino.setNumero(25);
		result = cliente_destino.getNumero();
		assertEquals(25, result);
	}

	public void testBairro() {
		String result;
		cliente_destino.setBairro("Centro");
		result = cliente_destino.getBairro();
		assertEquals("Centro", result);
	}

	public void testCidade() {
		String result;
		cliente_destino.setCidade("Pouso Alegre");
		result = cliente_destino.getCidade();
		assertEquals("Pouso Alegre", result);
	}

	public void testCep() {
		String result;
		cliente_destino.setCep("37550000");
		result = cliente_destino.getCep();
		assertEquals("37550000", result);
	}

	public void testTelefone() {
		String result;
		cliente_destino.setTelefone("3534237316");
		result = cliente_destino.getTelefone();
		assertEquals("3534237316", result);
	}

	public void testCnpjCpf() {
		String result;
		cliente_destino.setCnpj_cpf("055.244.676-97");
		result = cliente_destino.getCnpj_cpf();
		assertEquals("055.244.676-97", result);
	}

	public void testIeRg() {
		String result;
		cliente_destino.setInsc_rg("mg-11.610.733");
		result = cliente_destino.getInsc_rg();
		assertEquals("mg-11.610.733", result);
	}

	public void testEmail() {
		String result;
		cliente_destino.setE_mail("luizddaniel@hotmail.com");
		result = cliente_destino.getE_mail();
		assertEquals("luizddaniel@hotmail.com", result);
	}

	public void testData() {
		String result;
		lerData(cliente_destino);
		result = apresentarData(cliente_destino);
		assertEquals("11/08/2011", result);
	}

	private boolean lerData(Cliente_DestinoTO cliente_destino) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String data = "";
		try {
			data = "11/08/2011";
			Date dtcad = formatter.parse(data);
			cliente_destino.setData_cad(dtcad);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "O valor informado " + data
					+ " não é válido como data.\n Informe uma data correta!");
			return false;
		}
		return true;
	}

	private String apresentarData(Cliente_DestinoTO cliente_destino) {

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dtnasc1;
		Date dtc = null;
		try {
			dtc = cliente_destino.getData_cad();
			dtnasc1 = format.format(dtc);

		} catch (Exception e) {
			return null;
		}
		return dtnasc1;
	}

}
