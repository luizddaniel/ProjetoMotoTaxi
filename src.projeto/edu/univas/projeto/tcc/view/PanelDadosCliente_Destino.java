package edu.univas.projeto.tcc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import edu.univas.projeto.tcc.listeners.DadosCliente_Destino;
import edu.univas.projeto.tcc.model.Cliente_DestinoTO;

public class PanelDadosCliente_Destino extends JPanel {

	private static final long serialVersionUID = 7993654755801213711L;

	private JLabel nomeLabel;
	private JTextField nomeTextField;

	private JLabel enderecoLabel;
	private JTextField enderecoTextField;

	private JLabel numeroLabel;
	private JTextField numeroTextField;

	private JLabel bairroLabel;
	private JTextField bairroTextField;

	private JLabel cidadeLabel;
	private JTextField cidadeTextField;

	private JLabel cepLabel;
	private JTextField cepTextField;

	private JLabel telefoneLabel;
	private JFormattedTextField telefoneTextField;

	private JLabel cnpj_cpfLabel;
	private JTextField cnpj_cpfTextField;

	private JLabel ie_rgLabel;
	private JTextField ie_rgTextField;

	private JLabel emailLabel;
	private JTextField emailTextField;

	private JLabel dtcadastroLabel;
	private JFormattedTextField dtcadstroTextField;

	private JTextField idTextField;
	// --------------------------------------------------------
	private GridBagConstraints nomeLabelConstraints;
	private GridBagConstraints enderecoLabelConstraints;
	private GridBagConstraints numeroLabelConstraints;
	private GridBagConstraints bairroLabelConstraints;
	private GridBagConstraints cidadeLabelConstraints;
	private GridBagConstraints cepLabelConstraints;
	private GridBagConstraints telefoneLabelConstraints;
	private GridBagConstraints cnpj_cpfLabelConstraints;
	private GridBagConstraints ie_rgLabelConstraints;
	private GridBagConstraints emailLabelConstraints;
	private GridBagConstraints dtcadastroLabelConstraints;

	private GridBagConstraints nomeTextFieldConstraints;
	private GridBagConstraints enderecoTextFieldConstraints;
	private GridBagConstraints numeroTextFieldConstraints;
	private GridBagConstraints bairroTextFieldConstraints;
	private GridBagConstraints cidadeTextFieldConstraints;
	private GridBagConstraints cepTextFieldConstraints;
	private GridBagConstraints telefoneTextFieldConstraints;
	private GridBagConstraints cnpj_cpfTextFieldConstraints;
	private GridBagConstraints ie_rgTextFieldConstraints;
	private GridBagConstraints emailTextFieldConstraints;
	private GridBagConstraints dtcadastroTextFieldConstraints;
	// -------------------------------------------------------------------------

	private Cliente_DestinoTO cliente_DestinoTO;

	private ArrayList<DadosCliente_Destino> listeners = new ArrayList<DadosCliente_Destino>();

	public PanelDadosCliente_Destino() {
		super();
		initialize();
	}

	private void initialize() {
		setLayout(new GridBagLayout());

		add(getNomeLabel(), getNomeLabelConstraints());
		add(getNomeTextField(), getNomeTextFieldConstraints());

		add(getEnderecoLabel(), getEnderecoLabelConstraints());
		add(getEnderecoTextField(), getEnderecoTextFieldConstraints());

		add(getNumeroLabel(), getNumeroLabelConstraints());
		add(getNumeroTextField(), getNumeroTextFieldConstraints());

		add(getBairroLabel(), getBairroLabelConstraints());
		add(getBairroTextField(), getBairroTextFieldConstraints());

		add(getCidadeLabel(), getCidadeLabelConstraints());
		add(getCidadeTextField(), getCidadeTextFieldConstraints());

		add(getCepLabel(), getCepLabelConstraints());
		add(getCepTextField(), getCepTextFieldConstraints());

		add(getTelefoneLabel(), getTelefoneLabelConstraints());
		add(getTelefoneTextField(), getTelefoneTextFieldConstraints());

		add(getCnpj_cpfLabel(), getCnpj_cpfLabelConstraints());
		add(getCnpj_cpfTextField(), getCnpj_cpfTextFieldConstraints());

		add(getIe_rgLabel(), getIe_rgLabelConstraints());
		add(getIe_rgTextField(), getIe_rgTextFieldConstraints());

		add(getEmailLabel(), getEmailLabelConstraints());
		add(getEmailTextField(), getEmailTextFieldConstraints());

		add(getDtcadastroLabel(), getDtcadastroLabelConstraints());
		add(getDtcadstroTextField(), getDtcadastroTextFieldConstraints());

		add(getIdTextField());
	}

	private JLabel getNomeLabel() {
		if (nomeLabel == null) {
			nomeLabel = new JLabel();
			nomeLabel.setText("Nome/Destino: ");
		}
		return nomeLabel;
	}

	private JTextField getNomeTextField() {
		if (nomeTextField == null) {
			nomeTextField = new JTextField();
		}
		return nomeTextField;
	}

	private JTextField getIdTextField() {
		if (idTextField == null) {
			idTextField = new JTextField();
			idTextField.setVisible(false);
		}
		return idTextField;
	}

	private JLabel getEnderecoLabel() {
		if (enderecoLabel == null) {
			enderecoLabel = new JLabel();
			enderecoLabel.setText("Endereço: ");

		}
		return enderecoLabel;
	}

	private JTextField getEnderecoTextField() {
		if (enderecoTextField == null) {
			enderecoTextField = new JTextField();
		}
		return enderecoTextField;
	}

	private JLabel getNumeroLabel() {
		if (numeroLabel == null) {
			numeroLabel = new JLabel();
			numeroLabel.setText("Numero: ");

		}
		return numeroLabel;
	}

	private JTextField getNumeroTextField() {
		if (numeroTextField == null) {
			numeroTextField = new JTextField();
		}
		return numeroTextField;
	}

	private JLabel getBairroLabel() {
		if (bairroLabel == null) {
			bairroLabel = new JLabel();
			bairroLabel.setText("Bairro: ");

		}
		return bairroLabel;
	}

	private JTextField getBairroTextField() {
		if (bairroTextField == null) {
			bairroTextField = new JTextField();
		}
		return bairroTextField;
	}

	private JLabel getCidadeLabel() {
		if (cidadeLabel == null) {
			cidadeLabel = new JLabel();
			cidadeLabel.setText("Cidade: ");

		}
		return cidadeLabel;
	}

	private JTextField getCidadeTextField() {
		if (cidadeTextField == null) {
			cidadeTextField = new JTextField();
		}
		return cidadeTextField;
	}

	private JLabel getCepLabel() {
		if (cepLabel == null) {
			cepLabel = new JLabel();
			cepLabel.setText("CEP: ");

		}
		return cepLabel;
	}

	private JTextField getCepTextField() {
		if (cepTextField == null) {
			cepTextField = new JTextField();
		}
		return cepTextField;
	}

	private JLabel getTelefoneLabel() {
		if (telefoneLabel == null) {
			telefoneLabel = new JLabel();
			telefoneLabel.setText("Telefone: ");

		}
		return telefoneLabel;
	}

	private JFormattedTextField getTelefoneTextField() {
		if (telefoneTextField == null) {
			telefoneTextField = new JFormattedTextField(getFormatterTelefone());
		}
		return telefoneTextField;
	}

	private JLabel getCnpj_cpfLabel() {
		if (cnpj_cpfLabel == null) {
			cnpj_cpfLabel = new JLabel();
			cnpj_cpfLabel.setText("CNPJ/CPF: ");

		}
		return cnpj_cpfLabel;
	}

	private JTextField getCnpj_cpfTextField() {
		if (cnpj_cpfTextField == null) {
			cnpj_cpfTextField = new JTextField();
		}
		return cnpj_cpfTextField;
	}

	private JLabel getIe_rgLabel() {
		if (ie_rgLabel == null) {
			ie_rgLabel = new JLabel();
			ie_rgLabel.setText("Inscriçao/RG: ");

		}
		return ie_rgLabel;
	}

	private JTextField getIe_rgTextField() {
		if (ie_rgTextField == null) {
			ie_rgTextField = new JTextField();
		}
		return ie_rgTextField;
	}

	private JLabel getEmailLabel() {
		if (emailLabel == null) {
			emailLabel = new JLabel();
			emailLabel.setText("E-mail: ");

		}
		return emailLabel;
	}

	private JTextField getEmailTextField() {
		if (emailTextField == null) {
			emailTextField = new JTextField();
		}
		return emailTextField;
	}

	private JLabel getDtcadastroLabel() {
		if (dtcadastroLabel == null) {
			dtcadastroLabel = new JLabel();
			dtcadastroLabel.setText("Data Cadastro: ");

		}
		return dtcadastroLabel;
	}

	private JFormattedTextField getDtcadstroTextField() {
		if (dtcadstroTextField == null) {
			dtcadstroTextField = new JFormattedTextField(
					getFormatterDataCadastro());
		}
		return dtcadstroTextField;
	}

	private GridBagConstraints getNomeLabelConstraints() {
		if (nomeLabelConstraints == null) {
			nomeLabelConstraints = createConstraintsPrototype();
			nomeLabelConstraints.gridx = 0;
			nomeLabelConstraints.gridy = 0;
		}
		return nomeLabelConstraints;
	}

	private GridBagConstraints getEnderecoLabelConstraints() {
		if (enderecoLabelConstraints == null) {
			enderecoLabelConstraints = createConstraintsPrototype();
			enderecoLabelConstraints.gridx = 0;
			enderecoLabelConstraints.gridy = 1;
		}
		return enderecoLabelConstraints;
	}

	private GridBagConstraints getNumeroLabelConstraints() {
		if (numeroLabelConstraints == null) {
			numeroLabelConstraints = createConstraintsPrototype();
			numeroLabelConstraints.gridx = 4;
			numeroLabelConstraints.gridy = 1;
		}
		return numeroLabelConstraints;
	}

	private GridBagConstraints getBairroLabelConstraints() {
		if (bairroLabelConstraints == null) {
			bairroLabelConstraints = createConstraintsPrototype();
			bairroLabelConstraints.gridx = 0;
			bairroLabelConstraints.gridy = 2;
		}
		return bairroLabelConstraints;
	}

	private GridBagConstraints getCidadeLabelConstraints() {
		if (cidadeLabelConstraints == null) {
			cidadeLabelConstraints = createConstraintsPrototype();
			cidadeLabelConstraints.gridx = 3;
			cidadeLabelConstraints.gridy = 2;
		}
		return cidadeLabelConstraints;
	}

	private GridBagConstraints getCepLabelConstraints() {
		if (cepLabelConstraints == null) {
			cepLabelConstraints = createConstraintsPrototype();
			cepLabelConstraints.gridx = 0;
			cepLabelConstraints.gridy = 3;
		}
		return cepLabelConstraints;
	}

	private GridBagConstraints getTelefoneLabelConstraints() {
		if (telefoneLabelConstraints == null) {
			telefoneLabelConstraints = createConstraintsPrototype();
			telefoneLabelConstraints.gridx = 3;
			telefoneLabelConstraints.gridy = 3;
		}
		return telefoneLabelConstraints;
	}

	private GridBagConstraints getCnpj_cpfLabelConstraints() {
		if (cnpj_cpfLabelConstraints == null) {
			cnpj_cpfLabelConstraints = createConstraintsPrototype();
			cnpj_cpfLabelConstraints.gridx = 0;
			cnpj_cpfLabelConstraints.gridy = 4;
		}
		return cnpj_cpfLabelConstraints;
	}

	private GridBagConstraints getIe_rgLabelConstraints() {
		if (ie_rgLabelConstraints == null) {
			ie_rgLabelConstraints = createConstraintsPrototype();
			ie_rgLabelConstraints.gridx = 3;
			ie_rgLabelConstraints.gridy = 4;
		}
		return ie_rgLabelConstraints;
	}

	private GridBagConstraints getEmailLabelConstraints() {
		if (emailLabelConstraints == null) {
			emailLabelConstraints = createConstraintsPrototype();
			emailLabelConstraints.gridx = 0;
			emailLabelConstraints.gridy = 5;
		}
		return emailLabelConstraints;
	}

	private GridBagConstraints getDtcadastroLabelConstraints() {
		if (dtcadastroLabelConstraints == null) {
			dtcadastroLabelConstraints = createConstraintsPrototype();
			dtcadastroLabelConstraints.gridx = 3;
			dtcadastroLabelConstraints.gridy = 5;
		}
		return dtcadastroLabelConstraints;
	}

	private GridBagConstraints getNomeTextFieldConstraints() {
		if (nomeTextFieldConstraints == null) {
			nomeTextFieldConstraints = createConstraintsPrototype();
			nomeTextFieldConstraints.gridx = 1;
			nomeTextFieldConstraints.gridy = 0;
			nomeTextFieldConstraints.gridwidth = 5;
		}
		return nomeTextFieldConstraints;
	}

	private GridBagConstraints getEnderecoTextFieldConstraints() {
		if (enderecoTextFieldConstraints == null) {
			enderecoTextFieldConstraints = createConstraintsPrototype();
			enderecoTextFieldConstraints.gridx = 1;
			enderecoTextFieldConstraints.gridy = 1;
			enderecoTextFieldConstraints.gridwidth = 3;
		}
		return enderecoTextFieldConstraints;
	}

	private GridBagConstraints getNumeroTextFieldConstraints() {
		if (numeroTextFieldConstraints == null) {
			numeroTextFieldConstraints = createConstraintsPrototype();
			numeroTextFieldConstraints.gridx = 5;
			numeroTextFieldConstraints.gridy = 1;
			numeroTextFieldConstraints.ipadx = 100;
		}
		return numeroTextFieldConstraints;
	}

	private GridBagConstraints getBairroTextFieldConstraints() {
		if (bairroTextFieldConstraints == null) {
			bairroTextFieldConstraints = createConstraintsPrototype();
			bairroTextFieldConstraints.gridx = 1;
			bairroTextFieldConstraints.gridy = 2;
			bairroTextFieldConstraints.gridwidth = 2;
			bairroTextFieldConstraints.ipadx = 200;
		}
		return bairroTextFieldConstraints;
	}

	private GridBagConstraints getCidadeTextFieldConstraints() {
		if (cidadeTextFieldConstraints == null) {
			cidadeTextFieldConstraints = createConstraintsPrototype();
			cidadeTextFieldConstraints.gridx = 4;
			cidadeTextFieldConstraints.gridy = 2;
			cidadeTextFieldConstraints.gridwidth = 2;
		}
		return cidadeTextFieldConstraints;
	}

	private GridBagConstraints getCepTextFieldConstraints() {
		if (cepTextFieldConstraints == null) {
			cepTextFieldConstraints = createConstraintsPrototype();
			cepTextFieldConstraints.gridx = 1;
			cepTextFieldConstraints.gridy = 3;
			cepTextFieldConstraints.gridwidth = 2;
		}
		return cepTextFieldConstraints;
	}

	private GridBagConstraints getTelefoneTextFieldConstraints() {
		if (telefoneTextFieldConstraints == null) {
			telefoneTextFieldConstraints = createConstraintsPrototype();
			telefoneTextFieldConstraints.gridx = 4;
			telefoneTextFieldConstraints.gridy = 3;
			telefoneTextFieldConstraints.gridwidth = 2;
		}
		return telefoneTextFieldConstraints;
	}

	private GridBagConstraints getCnpj_cpfTextFieldConstraints() {
		if (cnpj_cpfTextFieldConstraints == null) {
			cnpj_cpfTextFieldConstraints = createConstraintsPrototype();
			cnpj_cpfTextFieldConstraints.gridx = 1;
			cnpj_cpfTextFieldConstraints.gridy = 4;
			cnpj_cpfTextFieldConstraints.gridwidth = 2;
		}
		return cnpj_cpfTextFieldConstraints;
	}

	private GridBagConstraints getIe_rgTextFieldConstraints() {
		if (ie_rgTextFieldConstraints == null) {
			ie_rgTextFieldConstraints = createConstraintsPrototype();
			ie_rgTextFieldConstraints.gridx = 4;
			ie_rgTextFieldConstraints.gridy = 4;
			ie_rgTextFieldConstraints.gridwidth = 2;
		}
		return ie_rgTextFieldConstraints;
	}

	private GridBagConstraints getEmailTextFieldConstraints() {
		if (emailTextFieldConstraints == null) {
			emailTextFieldConstraints = createConstraintsPrototype();
			emailTextFieldConstraints.gridx = 1;
			emailTextFieldConstraints.gridy = 5;
			emailTextFieldConstraints.gridwidth = 2;
		}
		return emailTextFieldConstraints;
	}

	private GridBagConstraints getDtcadastroTextFieldConstraints() {
		if (dtcadastroTextFieldConstraints == null) {
			dtcadastroTextFieldConstraints = createConstraintsPrototype();
			dtcadastroTextFieldConstraints.gridx = 4;
			dtcadastroTextFieldConstraints.gridy = 5;
			dtcadastroTextFieldConstraints.gridwidth = 2;
		}
		return dtcadastroTextFieldConstraints;
	}

	private GridBagConstraints createConstraintsPrototype() {

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.insets = new Insets(3, 3, 3, 3);

		return gbc;
	}

	private MaskFormatter getFormatterTelefone() {
		try {
			MaskFormatter formatter = new MaskFormatter();
			formatter.setMask("(##)####-####");
			formatter.setPlaceholderCharacter('_');
			return formatter;
		} catch (ParseException e) {
			return new MaskFormatter();
		}
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

	public Cliente_DestinoTO getCliente_DestinoTO() {
		if (cliente_DestinoTO == null) {
			cliente_DestinoTO = new Cliente_DestinoTO();
		}

		cliente_DestinoTO.setNome(getNomeTextField().getText());
		cliente_DestinoTO.setEndereco(getEnderecoTextField().getText());
		cliente_DestinoTO.setBairro(getBairroTextField().getText());
		cliente_DestinoTO.setCidade(getCidadeTextField().getText());
		cliente_DestinoTO.setCep(getCepTextField().getText());
		cliente_DestinoTO.setTelefone(getTelefoneTextField().getText());
		cliente_DestinoTO.setCnpj_cpf(getCnpj_cpfTextField().getText());
		cliente_DestinoTO.setInsc_rg(getIe_rgTextField().getText());
		cliente_DestinoTO.setE_mail(getEmailTextField().getText());

		if (!lernumero(cliente_DestinoTO) || !lerData(cliente_DestinoTO)) {
			return null;
		}
		return cliente_DestinoTO;
	}

	public void setCliente_DestinoTO(Cliente_DestinoTO cliente_Destino) {
		if (cliente_Destino == null) {
			cliente_Destino = new Cliente_DestinoTO();
		}


		getIdTextField().setText(Integer.toString(cliente_Destino.getId()));
		getNomeTextField().setText(cliente_Destino.getNome());
		getEnderecoTextField().setText(cliente_Destino.getEndereco());
		getNumeroTextField().setText(
				Integer.toString(cliente_Destino.getNumero()));
		getBairroTextField().setText(cliente_Destino.getBairro());
		getCidadeTextField().setText(cliente_Destino.getCidade());
		getCepTextField().setText(cliente_Destino.getCep());
		getTelefoneTextField().setText(cliente_Destino.getTelefone());
		getCnpj_cpfTextField().setText(cliente_Destino.getCnpj_cpf());
		getIe_rgTextField().setText(cliente_Destino.getInsc_rg());
		getEmailTextField().setText(cliente_Destino.getE_mail());
		apresentarData(cliente_Destino);

	}

	private boolean apresentarData(Cliente_DestinoTO cliente_Destino) {

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		Date dtnasc = null;
		try {
			dtnasc = cliente_Destino.getData_cad();
			String dtnasc1 = format.format(dtnasc);
			getDtcadstroTextField().setText(dtnasc1);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public Cliente_DestinoTO getEditarCliente_DestinoTO() {
		if (cliente_DestinoTO == null) {
			cliente_DestinoTO = new Cliente_DestinoTO();
		}
		cliente_DestinoTO.setId(Integer.parseInt(getIdTextField().getText()));
		cliente_DestinoTO.setNome(getNomeTextField().getText());
		cliente_DestinoTO.setEndereco(getEnderecoTextField().getText());
		cliente_DestinoTO.setBairro(getBairroTextField().getText());
		cliente_DestinoTO.setCidade(getCidadeTextField().getText());
		cliente_DestinoTO.setCep(getCepTextField().getText());
		cliente_DestinoTO.setTelefone(getTelefoneTextField().getText());
		cliente_DestinoTO.setCnpj_cpf(getCnpj_cpfTextField().getText());
		cliente_DestinoTO.setInsc_rg(getIe_rgTextField().getText());
		cliente_DestinoTO.setE_mail(getEmailTextField().getText());

		if (!lernumero(cliente_DestinoTO) || !lerData(cliente_DestinoTO)) {
			return null;
		}
		return cliente_DestinoTO;

	}

	private boolean lerData(Cliente_DestinoTO cliente) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String data = "";
		try {
			data = getDtcadstroTextField().getText();
			Date dtcad = formatter.parse(data);
			cliente.setData_cad(dtcad);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "O valor informado " + data
					+ " não é válido como data.\n Informe uma data correta!");
			return false;
		}
		return true;
	}

	private boolean lernumero(Cliente_DestinoTO cliente_DestinoTO) {

		String num = "";

		try {
			num = getNumeroTextField().getText();
			Integer numero = Integer.parseInt(num);
			cliente_DestinoTO.setNumero(numero);
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

	public void addDadosCliente_Dest(DadosCliente_Destino listener) {
		listeners.add(listener);
	}

}
