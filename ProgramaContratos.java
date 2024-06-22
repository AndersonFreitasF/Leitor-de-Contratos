package questao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Contrato;
import entidades.Departamento;
import entidades.Funcionario;
import entidades.enums.NivelProgramador;

public class ProgramaContratos {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Informe o departamento:");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Informe as informações do funcionario:");
		System.out.println("Nome:");
		String nomeFunc = sc.nextLine();
		System.out.println("Nivel:");
		String nivel = sc.nextLine();
		System.out.println("Salario Base");
		double salarioBase = sc.nextDouble();
		Funcionario funci = new Funcionario(nomeFunc, NivelProgramador.valueOf(nivel), 
				salarioBase, new Departamento(nomeDepartamento));

		System.out.println("Quantos contratos serão alocados para esse trabalhador?");
		int quantCon = sc.nextInt();
		int v[] = new int[quantCon];
		for (int i = 0; i < v.length; i++) {
			System.out.println("Informe os dados do " + (i + 1) + "º Contrato:");
			System.out.println("Data (Dia/Mês/Ano)");
			Date dataContrato = sdf.parse(sc.next());
			System.out.println("Valor por Hora:");
			double valorPorHora = sc.nextDouble();
			System.out.println("Duração (em horas):");
			double horas = sc.nextDouble();
			Contrato contrato = new Contrato(dataContrato, valorPorHora, horas);
			funci.addContrato(contrato);
		}

		System.out.println();
		System.out.println("Informe o mês e o ano para calcular os lucros(MM/AAAA)");
		String mesEAno = sc.next();
		int mes = Integer.parseInt(mesEAno.substring(0, 2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		System.out.println("Nome:" + funci.getNome());
		System.out.println("Departamento:" + funci.getDepartamento().getNome());
		System.out.println("Lucros em " + mesEAno + ": " 
		+ String.format("%.2f", funci.Ganhos(ano, mes)));
		sc.close();
	}

}
