package conta;

import conta.util.Cores;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		// Teste Conta Corrente
		ContaCorrente cc1 = new ContaCorrente(1, 123, 1, "Mariana", 1500.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();

		// Teste Conta Poupança
		ContaPoupanca cp1 = new ContaPoupanca(3, 123, 2, "Victor", 100000.0f, 15);
		cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();

		Scanner sc = new Scanner(System.in);
		int opcao;

		while (true) {
			System.out.println(Cores.TEXT_BLACK_BOLD + Cores.ANSI_WHITE_BACKGROUND
					+ "*********************************************");
			System.out.println("                                             ");
			System.out.println("               Banco BugBank                 ");
			System.out.println("                                             ");
			System.out.println("*********************************************");
			System.out.println("                                             ");
			System.out.println("         1- Criar conta                      ");
			System.out.println("         2- Listar todas as contas           ");
			System.out.println("         3- Buscar conta por número          ");
			System.out.println("         4- Atualizar dados da conta         ");
			System.out.println("         5- Apagar Conta                     ");
			System.out.println("         6- Sacar                            ");
			System.out.println("         7- Depositar                        ");
			System.out.println("         8- Transferir valores entre contas  ");
			System.out.println("         9- Sair                             ");
			System.out.println("*********************************************");
			System.out.println("Entre com a opção desejada:                 *");
			System.out.println("                                             ");

			opcao = sc.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.TEXT_PURPLE_BOLD + "\nBugBank -O banco que reinicia, mas nunca para!");
				sobre();
				sc.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Criar Conta\n\n");

				break;
			case 2:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Listar todas as Contas\n\n");

				break;
			case 3:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Consultar dados da Conta - por número\n\n");

				break;
			case 4:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Apagar a Conta\n\n");

				break;
			case 6:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Saque\n\n");

				break;
			case 7:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Depósito\n\n");

				break;
			case 8:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Transferência entre Contas\n\n");

				break;
			default:
				System.out.println(Cores.TEXT_BLACK_BOLD + "\nOpção Inválida!\n");
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: João Andrade");
		System.out.println("Generation Brasil - joaoa@generation.org");
		System.out.println("github.com/JoaoAndrade-dev");
		System.out.println("*********************************************************");
	}

}
