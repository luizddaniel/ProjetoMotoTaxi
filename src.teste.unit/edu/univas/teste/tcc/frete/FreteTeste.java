package edu.univas.teste.tcc.frete;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import junit.framework.TestCase;
import edu.univas.projeto.tcc.model.FreteTO;

public class FreteTeste extends TestCase {

	private FreteTO frete;

	protected void setUp() throws Exception {
		super.setUp();
		frete = new FreteTO();
	}

	public void testId() {
		int result;
		frete.setId(1);
		result = frete.getId();
		assertEquals(1, result);
	}

	public void testNumeroFrete() {
		int result;
		frete.setNum_frete(134);
		result = frete.getNum_frete();
		assertEquals(134, result);
	}

	public void testHoraLig() {
		String result;
		frete.setHora_lig("01:51");
		result = frete.getHora_lig();
		assertEquals("01:51", result);
	}

	public void testHoraSaida() {
		String result;
		frete.setHora_saida("01:52");
		result = frete.getHora_saida();
		assertEquals("01:52", result);
	}

	public void testValor() {
		float result;
		frete.setValor(2.50f);
		result = frete.getValor();
		assertEquals(2.50f, result);
	}

	public void testMotoq() {
		String result;
		frete.setMotoq("Anderson");
		result = frete.getMotoq();
		assertEquals("Anderson", result);
	}

	public void testDestino() {
		String result;
		frete.setDestino("Magsul");
		result = frete.getDestino();
		assertEquals("Magsul", result);
	}

	public void testData() {
		String result;
		lerData(frete);
		result = apresentarData(frete);
		assertEquals("11/08/2011", result);
	}

	private boolean lerData(FreteTO frete) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String data = "";
		try {
			data = "11/08/2011";
			Date dtcad = formatter.parse(data);
			frete.setData(dtcad);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "O valor informado " + data
					+ " não é válido como data.\n Informe uma data correta!");
			return false;
		}
		return true;
	}

	private String apresentarData(FreteTO frete) {

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dtnasc1;
		Date dtc = null;
		try {
			dtc = frete.getData();
			dtnasc1 = format.format(dtc);

		} catch (Exception e) {
			return null;
		}
		return dtnasc1;
	}

}
