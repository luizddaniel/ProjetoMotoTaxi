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

import edu.univas.projeto.tcc.listeners.DadosMotoqueiro;
import edu.univas.projeto.tcc.model.MotoqueiroTO;

public class PanelDadosMotoqueiro extends JPanel {

	private static final long serialVersionUID = 6741932651913690111L;

	private JLabel nomeLabel;
	private JTextField nomeTextField;

	private JLabel num_motLabel;
	private JTextField num_motTextField;

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

	private JLabel cpfLabel;
	private JTextField cpfTextField;

	private JLabel rgLabel;
	private JTextField rgTextField;

	private JLabel dtcadastroLabel;
	private JFormattedTextField dtcadstroTextField;

	private JLabel tipo_sangLabel;
	private JTextField tipo_sangTextField;

	private JTextField idTextField;

	// -----------------Dados Moto----------------------------------------
	private JLabel motoLabel;
	private JTextField motoTextField;

	private JLabel renavanLabel;
	private JTextField renavanTextField;

	private JLabel ano_modLabel;
	private JFormattedTextField ano_modTextField;

	private JLabel corLabel;
	private JTextField corTextField;

	private JLabel cilindradaLabel;
	private JTextField cilindradaTextField;

	private JLabel placaLabel;
	private JTextField placaTextField;

	private JLabel cnhLabel;
	private JTextField cnhTextField;

	private JLabel categoriaLabel;
	private JTextField categoriaTextField;

	// -----------------Constraints Moto----------------------------------------
	private GridBagConstraints motoLabelConstraints;
	private GridBagConstraints renavanLabelConstraints;
	private GridBagConstraints ano_modLabelConstraints;
	private GridBagConstraints corLabelConstraints;
	private GridBagConstraints cilindradaLabelConstraints;
	private GridBagConstraints placaLabelConstraints;
	private GridBagConstraints cnhLabelConstraints;
	private GridBagConstraints categoriaLabelConstraints;

	private GridBagConstraints motoTextFieldConstraints;
	private GridBagConstraints renavanTextFieldConstraints;
	private GridBagConstraints ano_modTextFieldConstraints;
	private GridBagConstraints corTextFieldConstraints;
	private GridBagConstraints cilindradaTextFieldConstraints;
	private GridBagConstraints placaTextFieldConstraints;
	private GridBagConstraints cnhTextFieldConstraints;
	private GridBagConstraints categoriaTextFieldConstraints;

	// --------------------------------------------------------
	private GridBagConstraints nomeLabelConstraints;
	private GridBagConstraints num_motLabelConstraints;
	private GridBagConstraints enderecoLabelConstraints;
	private GridBagConstraints numeroLabelConstraints;
	private GridBagConstraints bairroLabelConstraints;
	private GridBagConstraints cidadeLabelConstraints;
	private GridBagConstraints cepLabelConstraints;
	private GridBagConstraints telefoneLabelConstraints;
	private GridBagConstraints cpfLabelConstraints;
	private GridBagConstraints rgLabelConstraints;
	private GridBagConstraints dtcadastroLabelConstraints;
	private GridBagConstraints tipo_sangLabelConstraints;

	private GridBagConstraints nomeTextFieldConstraints;
	private GridBagConstraints num_motTextFieldConstraints;
	private GridBagConstraints enderecoTextFieldConstraints;
	private GridBagConstraints numeroTextFieldConstraints;
	private GridBagConstraints bairroTextFieldConstraints;
	private GridBagConstraints cidadeTextFieldConstraints;
	private GridBagConstraints cepTextFieldConstraints;
	private GridBagConstraints telefoneTextFieldConstraints;
	private GridBagConstraints cpfTextFieldConstraints;
	private GridBagConstraints rgTextFieldConstraints;
	private GridBagConstraints dtcadastroTextFieldConstraints;
	private GridBagConstraints tipo_sangTextFieldConstraints;

	private MotoqueiroTO motoqueiroTO;

	private ArrayList<DadosMotoqueiro> listeners = new ArrayList<DadosMotoqueiro>();

	public PanelDadosMotoqueiro() {
		super();
		initialize();
	}

	private void initialize() {
		setLayout(new GridBagLayout());

		add(getNomeLabel(), getNomeLabelConstraints());
		add(getNomeTextField(), getNomeTextFieldConstraints());

		add(getNum_motLabel(), getNum_motLabelConstraints());
		add(getNum_motTextField(), getNum_motTextFieldConstraints());

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

		add(getCpfLabel(), getCpfLabelConstraints());
		add(getCpfTextField(), getCpfTextFieldConstraints());

		add(getRgLabel(), getRgLabelConstraints());
		add(getRgTextField(), getRgTextFieldConstraints());

		add(getDtcadastroLabel(), getDtcadastroLabelConstraints());
		add(getDtcadstroTextField(), getDtcadastroTextFieldConstraints());

		add(getTipo_sangLabel(), getTipo_sangLabelConstraints());
		add(getTipo_sangTextField(), getTipo_sangTextFieldConstraints());

		add(getIdTextField());
		// ----------------------------------
		add(getMotoLabel(), getMotoLabelConstraints());
		add(getMotoTextField(), getMotoTextFieldConstraints());

		add(getRenavanLabel(), getRenavanLabelConstraints());
		add(getRenavanTextField(), getRenavanTextFieldConstraints());

		add(getAno_modLabel(), getAno_modLabelConstraints());
		add(getAno_modTextField(), getAno_modTextFieldConstraints());

		add(getCorLabel(), getCorLabelConstraints());
		add(getCorTextField(), getCorTextFieldConstraints());

		add(getCilindradaLabel(), getCilindradaLabelConstraints());
		add(getCilindradaTextField(), getCilindradaTextFieldConstraints());

		add(getPlacaLabel(), getPlacaLabelConstraints());
		add(getPlacaTextField(), getPlacaTextFieldConstraints());

		add(getCnhLabel(), getCnhLabelConstraints());
		add(getCnhTextField(), getCnhTextFieldConstraints());

		add(getCategoriaLabel(), getCategoriaLabelConstraints());
		add(getCategoriaTextField(), getCategoriaTextFieldConstraints());

	}

	private JLabel getNomeLabel() {
		if (nomeLabel == null) {
			nomeLabel = new JLabel();
			nomeLabel.setText("Nome: ");
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

	private JLabel getNum_motLabel() {
		if (num_motLabel == null) {
			num_motLabel = new JLabel();
			num_motLabel.setText("Número Motoqueiro: ");

		}
		return num_motLabel;
	}

	private JTextField getNum_motTextField() {
		if (num_motTextField == null) {
			num_motTextField = new JTextField();
		}
		return num_motTextField;
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

	private JLabel getCpfLabel() {
		if (cpfLabel == null) {
			cpfLabel = new JLabel();
			cpfLabel.setText("CPF: ");

		}
		return cpfLabel;
	}

	private JTextField getCpfTextField() {
		if (cpfTextField == null) {
			cpfTextField = new JTextField();
		}
		return cpfTextField;
	}

	private JLabel getRgLabel() {
		if (rgLabel == null) {
			rgLabel = new JLabel();
			rgLabel.setText("Identidade/RG: ");

		}
		return rgLabel;
	}

	private JTextField getRgTextField() {
		if (rgTextField == null) {
			rgTextField = new JTextField();
		}
		return rgTextField;
	}

	private JLabel getDtcadastroLabel() {
		if (dtcadastroLabel == null) {
			dtcadastroLabel = new JLabel();
			dtcadastroLabel.setText("Data Cadastro: ");

		}
		return dtcadastroLabel;
	}

	private JLabel getTipo_sangLabel() {
		if (tipo_sangLabel == null) {
			tipo_sangLabel = new JLabel();
			tipo_sangLabel.setText("Tipo Sang.: ");
		}
		return tipo_sangLabel;
	}

	private JTextField getTipo_sangTextField() {
		if (tipo_sangTextField == null) {
			tipo_sangTextField = new JTextField();
		}
		return tipo_sangTextField;
	}

	private JFormattedTextField getDtcadstroTextField() {
		if (dtcadstroTextField == null) {
			dtcadstroTextField = new JFormattedTextField(
					getFormatterDataCadastro());
		}
		return dtcadstroTextField;
	}

	private JLabel getMotoLabel() {
		if (motoLabel == null) {
			motoLabel = new JLabel();
			motoLabel.setText("Moto: ");
		}
		return motoLabel;
	}

	private JTextField getMotoTextField() {
		if (motoTextField == null) {
			motoTextField = new JTextField();
		}

		return motoTextField;
	}

	private JLabel getRenavanLabel() {
		if (renavanLabel == null) {
			renavanLabel = new JLabel();
			renavanLabel.setText("Renavan: ");
		}

		return renavanLabel;
	}

	private JTextField getRenavanTextField() {
		if (renavanTextField == null) {
			renavanTextField = new JTextField();
		}

		return renavanTextField;
	}

	private JLabel getAno_modLabel() {
		if (ano_modLabel == null) {
			ano_modLabel = new JLabel();
			ano_modLabel.setText("Ano/Modelo: ");
		}

		return ano_modLabel;
	}

	private JTextField getAno_modTextField() {
		if (ano_modTextField == null) {
			ano_modTextField = new JFormattedTextField(getFormatterAno_Modelo());
		}

		return ano_modTextField;
	}

	private JLabel getCorLabel() {
		if (corLabel == null) {
			corLabel = new JLabel();
			corLabel.setText("Cor: ");
		}

		return corLabel;
	}

	private JTextField getCorTextField() {
		if (corTextField == null) {
			corTextField = new JTextField();
		}

		return corTextField;
	}

	private JLabel getCilindradaLabel() {
		if (cilindradaLabel == null) {
			cilindradaLabel = new JLabel();
			cilindradaLabel.setText("Cilindrada: ");
		}

		return cilindradaLabel;
	}

	private JTextField getCilindradaTextField() {
		if (cilindradaTextField == null) {
			cilindradaTextField = new JTextField();
		}

		return cilindradaTextField;
	}

	private JLabel getPlacaLabel() {
		if (placaLabel == null) {
			placaLabel = new JLabel();
			placaLabel.setText("Placa: ");
		}

		return placaLabel;
	}

	private JTextField getPlacaTextField() {
		if (placaTextField == null) {
			placaTextField = new JTextField();
		}

		return placaTextField;
	}

	private JLabel getCnhLabel() {
		if (cnhLabel == null) {
			cnhLabel = new JLabel();
			cnhLabel.setText("CNH: ");
		}

		return cnhLabel;
	}

	private JTextField getCnhTextField() {
		if (cnhTextField == null) {
			cnhTextField = new JTextField();
		}

		return cnhTextField;
	}

	private JLabel getCategoriaLabel() {
		if (categoriaLabel == null) {
			categoriaLabel = new JLabel();
			categoriaLabel.setText("Categoria: ");
		}

		return categoriaLabel;
	}

	private JTextField getCategoriaTextField() {
		if (categoriaTextField == null) {
			categoriaTextField = new JTextField();
		}

		return categoriaTextField;
	}

	private GridBagConstraints getTipo_sangLabelConstraints() {
		if (tipo_sangLabelConstraints == null) {
			tipo_sangLabelConstraints = createConstraintsPrototype();
			tipo_sangLabelConstraints.gridx = 3;
			tipo_sangLabelConstraints.gridy = 5;
		}

		return tipo_sangLabelConstraints;
	}

	private GridBagConstraints getTipo_sangTextFieldConstraints() {
		if (tipo_sangTextFieldConstraints == null) {
			tipo_sangTextFieldConstraints = createConstraintsPrototype();
			tipo_sangTextFieldConstraints.gridx = 4;
			tipo_sangTextFieldConstraints.gridy = 5;
			tipo_sangTextFieldConstraints.ipadx = 100;
		}
		return tipo_sangTextFieldConstraints;
	}

	private GridBagConstraints getMotoLabelConstraints() {
		if (motoLabelConstraints == null) {
			motoLabelConstraints = createConstraintsPrototype();
			motoLabelConstraints.gridx = 0;
			motoLabelConstraints.gridy = 6;
		}
		return motoLabelConstraints;
	}

	private GridBagConstraints getRenavanLabelConstraints() {
		if (renavanLabelConstraints == null) {
			renavanLabelConstraints = createConstraintsPrototype();
			renavanLabelConstraints.gridx = 2;
			renavanLabelConstraints.gridy = 6;
		}
		return renavanLabelConstraints;
	}

	private GridBagConstraints getAno_modLabelConstraints() {
		if (ano_modLabelConstraints == null) {
			ano_modLabelConstraints = createConstraintsPrototype();
			ano_modLabelConstraints.gridx = 4;
			ano_modLabelConstraints.gridy = 6;
		}
		return ano_modLabelConstraints;
	}

	private GridBagConstraints getCorLabelConstraints() {
		if (corLabelConstraints == null) {
			corLabelConstraints = createConstraintsPrototype();
			corLabelConstraints.gridx = 0;
			corLabelConstraints.gridy = 7;
		}
		return corLabelConstraints;
	}

	private GridBagConstraints getCilindradaLabelConstraints() {
		if (cilindradaLabelConstraints == null) {
			cilindradaLabelConstraints = createConstraintsPrototype();
			cilindradaLabelConstraints.gridx = 2;
			cilindradaLabelConstraints.gridy = 7;
		}
		return cilindradaLabelConstraints;
	}

	private GridBagConstraints getPlacaLabelConstraints() {
		if (placaLabelConstraints == null) {
			placaLabelConstraints = createConstraintsPrototype();
			placaLabelConstraints.gridx = 4;
			placaLabelConstraints.gridy = 7;
		}
		return placaLabelConstraints;
	}

	private GridBagConstraints getCnhLabelConstraints() {
		if (cnhLabelConstraints == null) {
			cnhLabelConstraints = createConstraintsPrototype();
			cnhLabelConstraints.gridx = 0;
			cnhLabelConstraints.gridy = 8;
		}
		return cnhLabelConstraints;
	}

	private GridBagConstraints getCategoriaLabelConstraints() {
		if (categoriaLabelConstraints == null) {
			categoriaLabelConstraints = createConstraintsPrototype();
			categoriaLabelConstraints.gridx = 2;
			categoriaLabelConstraints.gridy = 8;
		}
		return categoriaLabelConstraints;
	}

	private GridBagConstraints getMotoTextFieldConstraints() {
		if (motoTextFieldConstraints == null) {
			motoTextFieldConstraints = createConstraintsPrototype();
			motoTextFieldConstraints.gridx = 1;
			motoTextFieldConstraints.gridy = 6;
			motoTextFieldConstraints.ipadx = 100;
		}

		return motoTextFieldConstraints;
	}

	private GridBagConstraints getRenavanTextFieldConstraints() {
		if (renavanTextFieldConstraints == null) {
			renavanTextFieldConstraints = createConstraintsPrototype();
			renavanTextFieldConstraints.gridx = 3;
			renavanTextFieldConstraints.gridy = 6;
			renavanTextFieldConstraints.ipadx = 100;
		}

		return renavanTextFieldConstraints;
	}

	private GridBagConstraints getAno_modTextFieldConstraints() {
		if (ano_modTextFieldConstraints == null) {
			ano_modTextFieldConstraints = createConstraintsPrototype();
			ano_modTextFieldConstraints.gridx = 5;
			ano_modTextFieldConstraints.gridy = 6;
			ano_modTextFieldConstraints.ipadx = 100;
		}

		return ano_modTextFieldConstraints;
	}

	private GridBagConstraints getCorTextFieldConstraints() {
		if (corTextFieldConstraints == null) {
			corTextFieldConstraints = createConstraintsPrototype();
			corTextFieldConstraints.gridx = 1;
			corTextFieldConstraints.gridy = 7;
			corTextFieldConstraints.ipadx = 100;
		}

		return corTextFieldConstraints;
	}

	private GridBagConstraints getCilindradaTextFieldConstraints() {
		if (cilindradaTextFieldConstraints == null) {
			cilindradaTextFieldConstraints = createConstraintsPrototype();
			cilindradaTextFieldConstraints.gridx = 3;
			cilindradaTextFieldConstraints.gridy = 7;
			cilindradaTextFieldConstraints.ipadx = 100;
		}

		return cilindradaTextFieldConstraints;
	}

	private GridBagConstraints getPlacaTextFieldConstraints() {
		if (placaTextFieldConstraints == null) {
			placaTextFieldConstraints = createConstraintsPrototype();
			placaTextFieldConstraints.gridx = 5;
			placaTextFieldConstraints.gridy = 7;
			placaTextFieldConstraints.ipadx = 100;
		}

		return placaTextFieldConstraints;
	}

	private GridBagConstraints getCnhTextFieldConstraints() {
		if (cnhTextFieldConstraints == null) {
			cnhTextFieldConstraints = createConstraintsPrototype();
			cnhTextFieldConstraints.gridx = 1;
			cnhTextFieldConstraints.gridy = 8;
			cnhTextFieldConstraints.ipadx = 100;
		}

		return cnhTextFieldConstraints;
	}

	private GridBagConstraints getCategoriaTextFieldConstraints() {
		if (categoriaTextFieldConstraints == null) {
			categoriaTextFieldConstraints = createConstraintsPrototype();
			categoriaTextFieldConstraints.gridx = 3;
			categoriaTextFieldConstraints.gridy = 8;
			categoriaTextFieldConstraints.ipadx = 100;
		}

		return categoriaTextFieldConstraints;
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

	private GridBagConstraints getCpfLabelConstraints() {
		if (cpfLabelConstraints == null) {
			cpfLabelConstraints = createConstraintsPrototype();
			cpfLabelConstraints.gridx = 0;
			cpfLabelConstraints.gridy = 4;
		}
		return cpfLabelConstraints;
	}

	private GridBagConstraints getRgLabelConstraints() {
		if (rgLabelConstraints == null) {
			rgLabelConstraints = createConstraintsPrototype();
			rgLabelConstraints.gridx = 3;
			rgLabelConstraints.gridy = 4;
		}
		return rgLabelConstraints;
	}

	private GridBagConstraints getNum_motLabelConstraints() {
		if (num_motLabelConstraints == null) {
			num_motLabelConstraints = createConstraintsPrototype();
			num_motLabelConstraints.gridx = 4;
			num_motLabelConstraints.gridy = 0;
		}
		return num_motLabelConstraints;
	}

	private GridBagConstraints getDtcadastroLabelConstraints() {
		if (dtcadastroLabelConstraints == null) {
			dtcadastroLabelConstraints = createConstraintsPrototype();
			dtcadastroLabelConstraints.gridx = 0;
			dtcadastroLabelConstraints.gridy = 5;
		}
		return dtcadastroLabelConstraints;
	}

	private GridBagConstraints getNomeTextFieldConstraints() {
		if (nomeTextFieldConstraints == null) {
			nomeTextFieldConstraints = createConstraintsPrototype();
			nomeTextFieldConstraints.gridx = 1;
			nomeTextFieldConstraints.gridy = 0;
			nomeTextFieldConstraints.gridwidth = 3;
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

	private GridBagConstraints getCpfTextFieldConstraints() {
		if (cpfTextFieldConstraints == null) {
			cpfTextFieldConstraints = createConstraintsPrototype();
			cpfTextFieldConstraints.gridx = 1;
			cpfTextFieldConstraints.gridy = 4;
			cpfTextFieldConstraints.gridwidth = 2;
		}
		return cpfTextFieldConstraints;
	}

	private GridBagConstraints getRgTextFieldConstraints() {
		if (rgTextFieldConstraints == null) {
			rgTextFieldConstraints = createConstraintsPrototype();
			rgTextFieldConstraints.gridx = 4;
			rgTextFieldConstraints.gridy = 4;
			rgTextFieldConstraints.gridwidth = 2;
		}
		return rgTextFieldConstraints;
	}

	private GridBagConstraints getNum_motTextFieldConstraints() {
		if (num_motTextFieldConstraints == null) {
			num_motTextFieldConstraints = createConstraintsPrototype();
			num_motTextFieldConstraints.gridx = 5;
			num_motTextFieldConstraints.gridy = 0;
			num_motTextFieldConstraints.ipadx = 100;
		}
		return num_motTextFieldConstraints;
	}

	private GridBagConstraints getDtcadastroTextFieldConstraints() {
		if (dtcadastroTextFieldConstraints == null) {
			dtcadastroTextFieldConstraints = createConstraintsPrototype();
			dtcadastroTextFieldConstraints.gridx = 1;
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

	private MaskFormatter getFormatterAno_Modelo() {
		try {
			MaskFormatter formatter = new MaskFormatter();
			formatter.setMask("####/####");
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

	public MotoqueiroTO getMotoqueiroTO() {
		if (motoqueiroTO == null) {
			motoqueiroTO = new MotoqueiroTO();
		}

		motoqueiroTO.setNome(getNomeTextField().getText());
		motoqueiroTO.setEndereco(getEnderecoTextField().getText());
		motoqueiroTO.setBairro(getBairroTextField().getText());
		motoqueiroTO.setCidade(getCidadeTextField().getText());
		motoqueiroTO.setCep(getCepTextField().getText());
		motoqueiroTO.setTelefone(getTelefoneTextField().getText());
		motoqueiroTO.setCpf(getCpfTextField().getText());
		motoqueiroTO.setRg(getRgTextField().getText());
		motoqueiroTO.setMoto(getMotoTextField().getText());
		motoqueiroTO.setRenavan(getRenavanTextField().getText());
		motoqueiroTO.setAno_modelo(getAno_modTextField().getText());
		motoqueiroTO.setCor(getCorTextField().getText());
		motoqueiroTO.setCilindrada(getCilindradaTextField().getText());
		motoqueiroTO.setPlaca_moto(getPlacaTextField().getText());
		motoqueiroTO.setCnh(getCnhTextField().getText());
		motoqueiroTO.setCategoria(getCategoriaTextField().getText());
		motoqueiroTO.setTipo_sang(getTipo_sangTextField().getText());

		if (!lernumero(motoqueiroTO) || !lerData(motoqueiroTO)
				|| !lerNum_Mot(motoqueiroTO)) {
			return null;
		}
		return motoqueiroTO;
	}

	public void setMotoqueiroTO(MotoqueiroTO motoquerioTO) {
		// JOptionPane.showMessageDialog(null, "Valor ID: " +
		// motoquerioTO.getId());

		getIdTextField().setText(Integer.toString(motoquerioTO.getId()));
		getNomeTextField().setText(motoquerioTO.getNome());
		getEnderecoTextField().setText(motoquerioTO.getEndereco());
		getNumeroTextField()
				.setText(Integer.toString(motoquerioTO.getNumero()));
		getNum_motTextField().setText(
				Integer.toString(motoquerioTO.getNum_motoq()));
		getBairroTextField().setText(motoquerioTO.getBairro());
		getCidadeTextField().setText(motoquerioTO.getCidade());
		getCepTextField().setText(motoquerioTO.getCep());
		getTelefoneTextField().setText(motoquerioTO.getTelefone());
		getCpfTextField().setText(motoquerioTO.getCpf());
		getRgTextField().setText(motoquerioTO.getRg());
		getMotoTextField().setText(motoquerioTO.getMoto());
		getRenavanTextField().setText(motoquerioTO.getRenavan());
		getAno_modTextField().setText(motoquerioTO.getAno_modelo());
		getCorTextField().setText(motoquerioTO.getCor());
		getCilindradaTextField().setText(motoquerioTO.getCilindrada());
		getPlacaTextField().setText(motoquerioTO.getPlaca_moto());
		getCnhTextField().setText(motoquerioTO.getCnh());
		getCategoriaTextField().setText(motoquerioTO.getCategoria());
		getTipo_sangTextField().setText(motoquerioTO.getTipo_sang());
		apresentarData(motoquerioTO);
	}

	private boolean apresentarData(MotoqueiroTO motoqueiro) {

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		Date dtc = null;
		try {
			dtc = motoqueiro.getData();
			String dtnasc1 = format.format(dtc);
			getDtcadstroTextField().setText(dtnasc1);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public MotoqueiroTO getEditarMotoqueiroTO() {
		if (motoqueiroTO == null) {
			motoqueiroTO = new MotoqueiroTO();
		}
		motoqueiroTO.setId(Integer.parseInt(getIdTextField().getText()));
		motoqueiroTO.setNome(getNomeTextField().getText());
		motoqueiroTO.setEndereco(getEnderecoTextField().getText());
		motoqueiroTO.setBairro(getBairroTextField().getText());
		motoqueiroTO.setCidade(getCidadeTextField().getText());
		motoqueiroTO.setCep(getCepTextField().getText());
		motoqueiroTO.setTelefone(getTelefoneTextField().getText());
		motoqueiroTO.setCpf(getCpfTextField().getText());
		motoqueiroTO.setRg(getRgTextField().getText());
		motoqueiroTO.setMoto(getMotoTextField().getText());
		motoqueiroTO.setRenavan(getRenavanTextField().getText());
		motoqueiroTO.setAno_modelo(getAno_modTextField().getText());
		motoqueiroTO.setCor(getCorTextField().getText());
		motoqueiroTO.setCilindrada(getCilindradaTextField().getText());
		motoqueiroTO.setPlaca_moto(getPlacaTextField().getText());
		motoqueiroTO.setCnh(getCnhTextField().getText());
		motoqueiroTO.setCategoria(getCategoriaTextField().getText());
		motoqueiroTO.setTipo_sang(getTipo_sangTextField().getText());

		if (!lernumero(motoqueiroTO) || !lerData(motoqueiroTO)
				|| !lerNum_Mot(motoqueiroTO)) {
			return null;
		}
		return motoqueiroTO;

	}

	private boolean lerData(MotoqueiroTO motoqueiro) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String data = "";
		try {
			data = getDtcadstroTextField().getText();
			Date dtcad = formatter.parse(data);
			motoqueiro.setData(dtcad);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "O valor informado " + data
					+ " não é válido como data.\n Informe uma data correta!");
			return false;
		}
		return true;
	}

	private boolean lernumero(MotoqueiroTO motoqueiroTO) {

		String num = "";

		try {
			num = getNumeroTextField().getText();
			Integer numero = Integer.parseInt(num);
			motoqueiroTO.setNumero(numero);
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

	private boolean lerNum_Mot(MotoqueiroTO motoqueiroTO) {

		String num = "";

		try {
			num = getNum_motTextField().getText();
			Integer numero = Integer.parseInt(num);
			motoqueiroTO.setNum_motoq(numero);
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

	public void addDadosMotoqueiro(DadosMotoqueiro listener) {
		listeners.add(listener);
	}

}
