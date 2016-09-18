package edu.univas.projeto.tcc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import edu.univas.projeto.tcc.listeners.DadosFrete;
import edu.univas.projeto.tcc.model.Cliente_DestinoDAO;
import edu.univas.projeto.tcc.model.Cliente_DestinoTO;
import edu.univas.projeto.tcc.model.DAOException;
import edu.univas.projeto.tcc.model.FreteTO;
import edu.univas.projeto.tcc.model.MotoqueiroDAO;
import edu.univas.projeto.tcc.model.MotoqueiroTO;

public class PanelDadosFrete extends JPanel {

	private static final long serialVersionUID = -184778272193343536L;

	private JLabel num_freteLabel;
	private JTextField num_freteTextField;

	private JLabel dataLabel;
	private JFormattedTextField dataTextField;
	 
	//private JXDatePicker validadeTextField;
	private JLabel destinoLabel;
	private JComboBox destinoTextField;

	private JLabel motoqueiroLabel;
	private JComboBox motoqueiroTextField;

	private JLabel hora_ligLabel;
	private JTextField hora_ligTextField;

	private JLabel hora_saidaLabel;
	private JTextField hora_saidaTextField;

	private JLabel hora_chegLabel;
	private JTextField hora_chegTextField;

	private JLabel valorLabel;
	private JTextField valorTextField;

	private JTextField idTextField;
	// ----------------------------------------------------

	private GridBagConstraints num_freteLabelConstraints;
	private GridBagConstraints dataLabelConstraints;
	private GridBagConstraints destinoLabelConstraints;
	private GridBagConstraints motoqueiroLabelConstraints;
	private GridBagConstraints hora_ligLabelConstraints;
	private GridBagConstraints hora_saidaLabelConstraints;
	private GridBagConstraints hora_chegLabelConstraints;
	private GridBagConstraints valorLabelConstraints;

	private GridBagConstraints num_freteTextFieldConstraints;
	private GridBagConstraints dataTextFieldConstraints;
	private GridBagConstraints destinoTextFieldConstraints;
	private GridBagConstraints motoqueiroTextFieldConstraints;
	private GridBagConstraints hora_ligTextFieldConstraints;
	private GridBagConstraints hora_saidaTextFieldConstraints;
	private GridBagConstraints hora_chegTextFieldConstraints;
	private GridBagConstraints valorTextFieldConstraints;

	private FreteTO freteTO;

	private ArrayList<DadosFrete> listeners = new ArrayList<DadosFrete>();

	public PanelDadosFrete() {
		super();
		initialize();
	}

	private void initialize() {
		setLayout(new GridBagLayout());

		add(getNum_freteLabel(), getNum_freteLabelConstraints());
		add(getNum_freteTextField(), getNum_freteTextFieldConstraints());

		add(getDataLabel(), getDataLabelConstraints());
		add(getDataTextField(), getDataTextFieldConstraints());

		add(getDestinoLabel(), getDestinoLabelConstraints());
		add(getDestinoTextField(), getDestinoTextFieldConstraints());

		add(getMotoqueiroLabel(), getMotoqueiroLabelConstraints());
		add(getMotoqueiroTextField(), getMotoqueiroTextFieldConstraints());

		add(getHora_ligLabel(), getHora_ligLabelConstraints());
		add(getHora_ligTextField(), getHora_ligTextFieldConstraints());

		add(getHora_saidaLabel(), getHora_saidaLabelConstraints());
		add(getHora_saidaTextField(), getHora_saidaTextFieldConstraints());

		add(getHora_chegLabel(), getHora_chegLabelConstraints());
		add(getHora_chegTextField(), getHora_chegTextFieldConstraints());

		add(getValorLabel(), getValorLabelConstraints());
		add(getValorTextField(), getValorTextFieldConstraints());

		add(getIdTextField());

	}

	private JTextField getIdTextField() {
		if (idTextField == null) {
			idTextField = new JTextField();
			idTextField.setVisible(false);
		}
		return idTextField;
	}

	private JLabel getNum_freteLabel() {
		if (num_freteLabel == null) {
			num_freteLabel = new JLabel();
			num_freteLabel.setText("Número Corrida: ");
		}
		return num_freteLabel;
	}

	private JTextField getNum_freteTextField() {
		if (num_freteTextField == null) {
			num_freteTextField = new JTextField();

		}
		return num_freteTextField;
	}

	private JLabel getDataLabel() {
		if (dataLabel == null) {
			dataLabel = new JLabel();
			dataLabel.setText("Data: ");
		}
		return dataLabel;
	}

	private JFormattedTextField getDataTextField() {
		if (dataTextField == null) {
			dataTextField = new JFormattedTextField(getFormatterDataCadastro());
		}
		return dataTextField;
	}

	private JLabel getDestinoLabel() {
		if (destinoLabel == null) {
			destinoLabel = new JLabel();
			destinoLabel.setText("Destino: ");
		}
		return destinoLabel;
	}

	private JComboBox getDestinoTextField() {
		Object[] itens = null;
		ArrayList<String> lista = new ArrayList<String>();
		if (destinoTextField == null) {
			ArrayList<Cliente_DestinoTO> destinos;
			try {
				destinos = new Cliente_DestinoDAO()
						.listarClientes_DestinoCombobox();
				for (Cliente_DestinoTO cliente_destino : destinos) {
					lista.add(cliente_destino.getNome());
				}
			} catch (DAOException e) {
				e.printStackTrace();
			}
			itens = lista.toArray();
			destinoTextField = new JComboBox(itens);
		}
		return destinoTextField;
	}

	private JLabel getMotoqueiroLabel() {
		if (motoqueiroLabel == null) {
			motoqueiroLabel = new JLabel();
			motoqueiroLabel.setText("Motoqueiro: ");
		}
		return motoqueiroLabel;
	}

	private JComboBox getMotoqueiroTextField() {
		Object[] itens = null;
		ArrayList<String> lista = new ArrayList<String>();
		if (motoqueiroTextField == null) {
			ArrayList<MotoqueiroTO> motoqs;
			try {
				motoqs = new MotoqueiroDAO().listarMotoqueirosCombobox();
				for (MotoqueiroTO motoqueiro : motoqs) {
					lista.add(motoqueiro.getNome());
				}
			} catch (DAOException e) {
				e.printStackTrace();
			}
			itens = lista.toArray();
			motoqueiroTextField = new JComboBox(itens);
		}
		return motoqueiroTextField;
	}

	private JLabel getHora_ligLabel() {
		if (hora_ligLabel == null) {
			hora_ligLabel = new JLabel();
			hora_ligLabel.setText("Hora Ligação: ");
		}
		return hora_ligLabel;
	}

	private JTextField getHora_ligTextField() {
		if (hora_ligTextField == null) {
			hora_ligTextField = new JFormattedTextField(getFormatterHoras());
		}
		return hora_ligTextField;
	}

	private JLabel getHora_saidaLabel() {
		if (hora_saidaLabel == null) {
			hora_saidaLabel = new JLabel();
			hora_saidaLabel.setText("Hora Saída: ");
		}
		return hora_saidaLabel;
	}

	private JTextField getHora_saidaTextField() {
		if (hora_saidaTextField == null) {
			hora_saidaTextField = new JFormattedTextField(getFormatterHoras());
		}
		return hora_saidaTextField;
	}

	private JLabel getHora_chegLabel() {
		if (hora_chegLabel == null) {
			hora_chegLabel = new JLabel();
			hora_chegLabel.setText("Hora Chegada: ");
		}
		return hora_chegLabel;
	}

	private JTextField getHora_chegTextField() {
		if (hora_chegTextField == null) {
			hora_chegTextField = new JFormattedTextField(getFormatterHoras());
		}
		return hora_chegTextField;
	}

	private JLabel getValorLabel() {
		if (valorLabel == null) {
			valorLabel = new JLabel();
			valorLabel.setText("Valor: ");
		}
		return valorLabel;
	}

	private JTextField getValorTextField() {
		if (valorTextField == null) {
			valorTextField = new JTextField();
		}
		return valorTextField;
	}

	private GridBagConstraints getNum_freteLabelConstraints() {
		if (num_freteLabelConstraints == null) {
			num_freteLabelConstraints = createConstraintsPrototype();
			num_freteLabelConstraints.gridx = 0;
			num_freteLabelConstraints.gridy = 0;
		}
		return num_freteLabelConstraints;
	}

	private GridBagConstraints getDataLabelConstraints() {
		if (dataLabelConstraints == null) {
			dataLabelConstraints = createConstraintsPrototype();
			dataLabelConstraints.gridx = 2;
			dataLabelConstraints.gridy = 0;
		}
		return dataLabelConstraints;
	}

	private GridBagConstraints getDestinoLabelConstraints() {
		if (destinoLabelConstraints == null) {
			destinoLabelConstraints = createConstraintsPrototype();
			destinoLabelConstraints.gridx = 0;
			destinoLabelConstraints.gridy = 1;
		}
		return destinoLabelConstraints;
	}

	private GridBagConstraints getMotoqueiroLabelConstraints() {
		if (motoqueiroLabelConstraints == null) {
			motoqueiroLabelConstraints = createConstraintsPrototype();
			motoqueiroLabelConstraints.gridx = 2;
			motoqueiroLabelConstraints.gridy = 1;
		}
		return motoqueiroLabelConstraints;
	}

	private GridBagConstraints getHora_ligLabelConstraints() {
		if (hora_ligLabelConstraints == null) {
			hora_ligLabelConstraints = createConstraintsPrototype();
			hora_ligLabelConstraints.gridx = 0;
			hora_ligLabelConstraints.gridy = 2;
		}
		return hora_ligLabelConstraints;
	}

	private GridBagConstraints getHora_saidaLabelConstraints() {
		if (hora_saidaLabelConstraints == null) {
			hora_saidaLabelConstraints = createConstraintsPrototype();
			hora_saidaLabelConstraints.gridx = 2;
			hora_saidaLabelConstraints.gridy = 2;
		}
		return hora_saidaLabelConstraints;
	}

	private GridBagConstraints getHora_chegLabelConstraints() {
		if (hora_chegLabelConstraints == null) {
			hora_chegLabelConstraints = createConstraintsPrototype();
			hora_chegLabelConstraints.gridx = 0;
			hora_chegLabelConstraints.gridy = 3;
		}
		return hora_chegLabelConstraints;
	}

	private GridBagConstraints getValorLabelConstraints() {
		if (valorLabelConstraints == null) {
			valorLabelConstraints = createConstraintsPrototype();
			valorLabelConstraints.gridx = 2;
			valorLabelConstraints.gridy = 3;
		}
		return valorLabelConstraints;
	}

	private GridBagConstraints getNum_freteTextFieldConstraints() {
		if (num_freteTextFieldConstraints == null) {
			num_freteTextFieldConstraints = createConstraintsPrototype();
			num_freteTextFieldConstraints.gridx = 1;
			num_freteTextFieldConstraints.gridy = 0;
			num_freteTextFieldConstraints.ipadx = 100;
		}
		return num_freteTextFieldConstraints;
	}

	private GridBagConstraints getDataTextFieldConstraints() {
		if (dataTextFieldConstraints == null) {
			dataTextFieldConstraints = createConstraintsPrototype();
			dataTextFieldConstraints.gridx = 3;
			dataTextFieldConstraints.gridy = 0;
			dataTextFieldConstraints.ipadx = 100;
		}
		return dataTextFieldConstraints;
	}

	private GridBagConstraints getDestinoTextFieldConstraints() {
		if (destinoTextFieldConstraints == null) {
			destinoTextFieldConstraints = createConstraintsPrototype();
			destinoTextFieldConstraints.gridx = 1;
			destinoTextFieldConstraints.gridy = 1;
			destinoTextFieldConstraints.ipadx = 100;
		}
		return destinoTextFieldConstraints;
	}

	private GridBagConstraints getMotoqueiroTextFieldConstraints() {
		if (motoqueiroTextFieldConstraints == null) {
			motoqueiroTextFieldConstraints = createConstraintsPrototype();
			motoqueiroTextFieldConstraints.gridx = 3;
			motoqueiroTextFieldConstraints.gridy = 1;
			motoqueiroTextFieldConstraints.ipadx = 100;
		}
		return motoqueiroTextFieldConstraints;
	}

	private GridBagConstraints getHora_ligTextFieldConstraints() {
		if (hora_ligTextFieldConstraints == null) {
			hora_ligTextFieldConstraints = createConstraintsPrototype();
			hora_ligTextFieldConstraints.gridx = 1;
			hora_ligTextFieldConstraints.gridy = 2;
			hora_ligTextFieldConstraints.ipadx = 100;
		}
		return hora_ligTextFieldConstraints;
	}

	private GridBagConstraints getHora_saidaTextFieldConstraints() {
		if (hora_saidaTextFieldConstraints == null) {
			hora_saidaTextFieldConstraints = createConstraintsPrototype();
			hora_saidaTextFieldConstraints.gridx = 3;
			hora_saidaTextFieldConstraints.gridy = 2;
			hora_saidaTextFieldConstraints.ipadx = 100;
		}
		return hora_saidaTextFieldConstraints;
	}

	private GridBagConstraints getHora_chegTextFieldConstraints() {
		if (hora_chegTextFieldConstraints == null) {
			hora_chegTextFieldConstraints = createConstraintsPrototype();
			hora_chegTextFieldConstraints.gridx = 1;
			hora_chegTextFieldConstraints.gridy = 3;
			hora_chegTextFieldConstraints.ipadx = 100;
		}
		return hora_chegTextFieldConstraints;
	}

	private GridBagConstraints getValorTextFieldConstraints() {
		if (valorTextFieldConstraints == null) {
			valorTextFieldConstraints = createConstraintsPrototype();
			valorTextFieldConstraints.gridx = 3;
			valorTextFieldConstraints.gridy = 3;
			valorTextFieldConstraints.ipadx = 100;
		}
		return valorTextFieldConstraints;
	}

	private MaskFormatter getFormatterDataCadastro() {
		try {
			MaskFormatter formatter = new MaskFormatter();
			formatter.setMask("##/##/####");
			formatter.setPlaceholderCharacter('_');
			return formatter;
		} catch (ParseException e) {
			return new MaskFormatter();
		}
	}

	private MaskFormatter getFormatterHoras() {
		try {
			MaskFormatter formatter = new MaskFormatter();
			formatter.setMask("##:##");
			formatter.setPlaceholderCharacter('_');
			return formatter;
		} catch (ParseException e) {
			return new MaskFormatter();
		}
	}

	public FreteTO getFreteTO() {
		if (freteTO == null) {
			freteTO = new FreteTO();
		}
		freteTO.setMotoq((String) getMotoqueiroTextField().getSelectedItem());
		freteTO.setDestino((String) getDestinoTextField().getSelectedItem());
		freteTO.setHora_lig(getHora_ligTextField().getText());
		freteTO.setHora_saida(getHora_saidaTextField().getText());
		freteTO.setHora_cheg(getHora_chegTextField().getText());

		if (!lerNum_Frete(freteTO) || !lerData(freteTO) || !lerValor(freteTO)) {
			return null;
		}

		return freteTO;
	}

	public FreteTO getEditarFreteTO() {
		if (freteTO == null) {
			freteTO = new FreteTO();
		}
		freteTO.setId(Integer.parseInt(getIdTextField().getText()));
		freteTO.setMotoq((String) getMotoqueiroTextField().getSelectedItem());
		freteTO.setDestino((String) getDestinoTextField().getSelectedItem());
		freteTO.setHora_lig(getHora_ligTextField().getText());
		freteTO.setHora_saida(getHora_saidaTextField().getText());
		freteTO.setHora_cheg(getHora_chegTextField().getText());

		if (!lerNum_Frete(freteTO) || !lerData(freteTO) || !lerValor(freteTO)) {
			return null;
		}

		return freteTO;
	}

	public void setFreteTO(FreteTO frete) {
		JOptionPane.showMessageDialog(null, "Valor ID: " + frete.getId());

		getIdTextField().setText(Integer.toString(frete.getId()));
		getNum_freteTextField().setText(Integer.toString(frete.getNum_frete()));
		getHora_ligTextField().setText(frete.getHora_lig());
		getHora_saidaTextField().setText(frete.getHora_saida());
		getHora_chegTextField().setText(frete.getHora_cheg());
		getDestinoTextField().setSelectedItem(frete.getDestino());
		getMotoqueiroTextField().setSelectedItem(frete.getMotoq());
		getValorTextField().setText(Float.toString(frete.getValor()));
		apresentarData(frete);
	
	}

	private boolean lerData(FreteTO freteTO) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String data = "";
		try {
			data = getDataTextField().getText();
			Date dtcad = formatter.parse(data);
			freteTO.setData(dtcad);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "O valor informado " + data
					+ " não é válido como data.\n Informe uma data correta!");
			return false;
		}
		return true;
	}

	private boolean lerNum_Frete(FreteTO freteTO) {

		String num = "";

		try {
			num = getNum_freteTextField().getText();
			Integer numero = Integer.parseInt(num);
			freteTO.setNum_frete(numero);
		} catch (Exception e) {
			JOptionPane
					.showMessageDialog(
							null,
							"O valor informado "
									+ num
									+ " não é válido como número.\n Informe um número correto!");
			return false;
		}
		return true;
	}

	private boolean lerValor(FreteTO freteTO) {

		String num = "";

		try {
			num = getValorTextField().getText();
			Float numero = Float.parseFloat(num);
			freteTO.setValor(numero);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "O valor informado " + num
					+ " não é válido.\n Informe um valor correto!");
			return false;
		}
		return true;
	}

	private boolean apresentarData(FreteTO frete) {

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		Date dtnasc = null;
		try {
			dtnasc = frete.getData();
			String dtnasc1 = format.format(dtnasc);
			getDataTextField().setText(dtnasc1);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private GridBagConstraints createConstraintsPrototype() {

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.insets = new Insets(3, 3, 3, 3);

		return gbc;
	}

	public void addDadosFrete(DadosFrete listener) {
		listeners.add(listener);
	}
}
