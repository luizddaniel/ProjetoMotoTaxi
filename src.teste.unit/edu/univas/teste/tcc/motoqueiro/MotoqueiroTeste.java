package edu.univas.teste.tcc.motoqueiro;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import edu.univas.projeto.tcc.model.MotoqueiroTO;
import junit.framework.TestCase;

public class MotoqueiroTeste extends TestCase {

	private MotoqueiroTO motoqueiro;

	protected void setUp() throws Exception {
		super.setUp();
		motoqueiro = new MotoqueiroTO();
	}

	public void testId() {
		int result;
		motoqueiro.setId(1);
		result = motoqueiro.getId();
		assertEquals(1, result);
	}

	public void testNome() {
		String result;
		motoqueiro.setNome("Luiz Fernando");
		result = motoqueiro.getNome();
		assertEquals("Luiz Fernando", result);
	}

	public void testEndereco() {
		String result;
		motoqueiro.setEndereco("Rua Dr. Paulino Pereira da Silva");
		result = motoqueiro.getEndereco();
		assertEquals("Rua Dr. Paulino Pereira da Silva", result);
	}

	public void testNumero() {
		int result;
		motoqueiro.setNumero(25);
		result = motoqueiro.getNumero();
		assertEquals(25, result);
	}

	public void testNum_Motoqueiro() {
		int result;
		motoqueiro.setNum_motoq(7);
		result = motoqueiro.getNum_motoq();
		assertEquals(7, result);
	}

	public void testBairro() {
		String result;
		motoqueiro.setBairro("Centro");
		result = motoqueiro.getBairro();
		assertEquals("Centro", result);
	}

	public void testCidade() {
		String result;
		motoqueiro.setCidade("Pouso Alegre");
		result = motoqueiro.getCidade();
		assertEquals("Pouso Alegre", result);
	}

	public void testCep() {
		String result;
		motoqueiro.setCep("37550000");
		result = motoqueiro.getCep();
		assertEquals("37550000", result);
	}

	public void testTelefone() {
		String result;
		motoqueiro.setTelefone("3534237316");
		result = motoqueiro.getTelefone();
		assertEquals("3534237316", result);
	}


	public void testTipoSang() {
		String result;
		motoqueiro.setTipo_sang("O+");
		result = motoqueiro.getTipo_sang();
		assertEquals("O+", result);
	}

	public void testCPF() {
		String result;
		motoqueiro.setCpf("055.244.676-97");
		result = motoqueiro.getCpf();
		assertEquals("055.244.676-97", result);
	}

	public void testRG() {
		String result;
		motoqueiro.setRg("mg-11.610.733");
		result = motoqueiro.getRg();
		assertEquals("mg-11.610.733", result);
	}

	public void testCNH() {
		String result;
		motoqueiro.setCnh("25483651229");
		result = motoqueiro.getCnh();
		assertEquals("25483651229", result);
	}

	public void testCategoria() {
		String result;
		motoqueiro.setCategoria("AB");
		result = motoqueiro.getCategoria();
		assertEquals("AB", result);
	}

	public void testMoto() {
		String result;
		motoqueiro.setMoto("Hornet");
		result = motoqueiro.getMoto();
		assertEquals("Hornet", result);
	}

	public void testRenavan() {
		String result;
		motoqueiro.setRenavan("9673457891");
		result = motoqueiro.getRenavan();
		assertEquals("9673457891", result);
	}

	public void testAnoModelo() {
		String result;
		motoqueiro.setAno_modelo("2011/2011");
		result = motoqueiro.getAno_modelo();
		assertEquals("2011/2011", result);
	}

	public void testCilindrada() {
		String result;
		motoqueiro.setCilindrada("125cc");
		result = motoqueiro.getCilindrada();
		assertEquals("125cc", result);
	}

	public void testPlaca() {
		String result;
		motoqueiro.setPlaca_moto("HHD-9994");
		result = motoqueiro.getPlaca_moto();
		assertEquals("HHD-9994", result);
	}

	public void testCor() {
		String result;
		motoqueiro.setCor("Vermelha");
		result = motoqueiro.getCor();
		assertEquals("Vermelha", result);
	}

	public void testData() {
		String result;
		lerData(motoqueiro);
		result = apresentarData(motoqueiro);
		assertEquals("11/08/2011", result);
	}
	private boolean lerData(MotoqueiroTO motoqueiro) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String data = "";
		try {
			data = "11/08/2011";
			Date dtcad = formatter.parse(data);
			motoqueiro.setData(dtcad);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "O valor informado " + data
					+ " não é válido como data.\n Informe uma data correta!");
			return false;
		}
		return true;
	}
	private String apresentarData(MotoqueiroTO motoqueiro) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dtnasc1;
		Date dtc = null;
		try {
			dtc = motoqueiro.getData();
			dtnasc1 = format.format(dtc);
		} catch (Exception e) {
			return null;
		}
		return dtnasc1;
	}
}
