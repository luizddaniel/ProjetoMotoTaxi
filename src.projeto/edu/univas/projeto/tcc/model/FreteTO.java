package edu.univas.projeto.tcc.model;

import java.util.Date;

public class FreteTO {

	private Integer id;
	private Integer num_frete;
	private String hora_lig;
	private String hora_saida;
	private String hora_cheg;
	private Float valor;
	private Date data;
	private String destino;
	private String motoq;

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getMotoq() {
		return motoq;
	}

	public void setMotoq(String motoq) {
		this.motoq = motoq;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNum_frete() {
		return num_frete;
	}

	public void setNum_frete(Integer num_frete) {
		this.num_frete = num_frete;
	}

	public String getHora_lig() {
		return hora_lig;
	}

	public void setHora_lig(String hora_lig) {
		this.hora_lig = hora_lig;
	}

	public String getHora_saida() {
		return hora_saida;
	}

	public void setHora_saida(String hora_saida) {
		this.hora_saida = hora_saida;
	}

	public String getHora_cheg() {
		return hora_cheg;
	}

	public void setHora_cheg(String hora_cheg) {
		this.hora_cheg = hora_cheg;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
