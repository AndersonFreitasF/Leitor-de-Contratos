package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.NivelProgramador;

public class Funcionario {
	private String nome;
	private NivelProgramador nivel;
	private double SalarioBase;

	private Departamento departamento;
	private List<Contrato> contratos = new ArrayList<>();

	public Funcionario() {

	}

	public Funcionario(String nome, NivelProgramador nivel, double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		SalarioBase = salarioBase;
		this.departamento = departamento;
	}
	
public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelProgramador getNivel() {
		return nivel;
	}

	public void setNivel(NivelProgramador nivel) {
		this.nivel = nivel;
	}

	public double getSalarioBase() {
		return SalarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		SalarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

public void addContrato(Contrato contrato){
	contratos.add(contrato);
	
}
public void removerContrato(Contrato contrato) {
	contratos.remove(contrato);	
}
public double Ganhos(int ano, int mes) {
	double soma = SalarioBase;
	Calendar cal = Calendar.getInstance();
	for (Contrato c : contratos) {
		cal.setTime(c.getData());
		int c_ano = cal.get(Calendar.YEAR);
		int c_mes = 1 + cal.get(Calendar.MONTH);
		if( ano == c_ano && mes == c_mes) {
			
		soma += c.ValorTotal();
	}
	}
	return soma;
}
}
