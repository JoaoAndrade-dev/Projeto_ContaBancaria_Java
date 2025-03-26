package conta;

import conta.util.Cores;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcao;

		while (true) {
			System.out.println(Cores.TEXT_CYAN_BOLD + Cores.ANSI_WHITE_BACKGROUND +
					           "*********************************************");
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
				System.out.println(Cores.TEXT_CYAN_BOLD+ "Criar Conta\n\n");

				break;
			case 2:
				System.out.println(Cores.TEXT_CYAN_BOLD +"Listar todas as Contas\n\n");

				break;
			case 3:
				System.out.println(Cores.TEXT_CYAN_BOLD +"Consultar dados da Conta - por número\n\n");

				break;
			case 4:
				System.out.println(Cores.TEXT_CYAN_BOLD +"Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println(Cores.TEXT_CYAN_BOLD + "Apagar a Conta\n\n");

				break;
			case 6:
				System.out.println(Cores.TEXT_CYAN_BOLD + "Saque\n\n");

				break;
			case 7:
				System.out.println(Cores.TEXT_CYAN_BOLD +"Depósito\n\n");

				break;
			case 8:
				System.out.println(Cores.TEXT_CYAN_BOLD + "Transferência entre Contas\n\n");

				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
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
