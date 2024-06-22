package entidades;

import java.util.Date;

public class Contrato {
	private Date data;
	private double valorPorHora;
	private double horas;

	public Contrato(Date data, double valorPorHora, double horas) {
		this.data = data;
		this.valorPorHora = valorPorHora;
		this.horas = horas;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public double getHoras() {
		return horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}

	

	public double ValorTotal() {
		return horas * valorPorHora;
	}

	}


