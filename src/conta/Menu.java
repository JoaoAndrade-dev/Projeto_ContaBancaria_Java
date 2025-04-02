package conta;

import conta.util.Cores;
import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

import java.io.IOException;
import java.security.PublicKey;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner sc = new Scanner(System.in);

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;

		System.out.println("\nCriar contas\n");

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);

		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Maria da Silva", 2000f, 100.0f);
		
		contas.cadastrar(cc2);

		ContaCorrente cp1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Mariana dos Santos", 4000f, 12);
		
		contas.cadastrar(cp1);

		ContaCorrente cp2 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Juliana Ramos", 8000f, 15);
		
		contas.cadastrar(cp2);

		contas.listarTodas();

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

			try {
				opcao = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite os valores inteiros!");
				sc.nextLine();
				opcao = 0;

			}

			if (opcao == 9) {
				System.out.println(Cores.TEXT_PURPLE_BOLD + "\nBugBank -O banco que reinicia, mas nunca para!");
				sobre();
				sc.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Criar Conta\n\n");

				System.out.println("Digite o número da Agência: ");
				agencia = sc.nextInt();
				System.out.println("Digite o nome do Titular: ");
				sc.skip("\\R?");
				titular = sc.nextLine();

				do {
					System.out.println("Digite o tipo da Conta (1-CC ou 2-CP): ");
					tipo = sc.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o saldo da Conta (R$): ");
				saldo = sc.nextFloat();

				switch (tipo) {

				case 1 -> {

					System.out.println("Digite o limite de crédito (R$): ");
					limite = sc.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do aniversario da Conta: ");
					aniversario = sc.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Listar todas as Contas\n\n");
				contas.listarTodas();

				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Consultar dados da Conta - por número\n\n");

				System.out.println("Digite o número da conta: ");
				numero = sc.nextInt();

				contas.procurarPorNumero(numero);

				keyPress();

				break;
			case 4:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Atualizar dados da Conta\n\n");

				System.out.println("Digite o número da conta: ");
				numero = sc.nextInt();

				var buscaConta = contas.buscarNaColletion(numero);

				if (buscaConta != null) {

					tipo = buscaConta.getTipo();

					System.out.println("Digite o numero da Agência: ");
					agencia = sc.nextInt();
					System.out.println("Digite o nome do Titular: ");
					sc.skip("\\R?");
					titular = sc.nextLine();

					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = sc.nextFloat();

					switch (tipo) {

					case 1 -> {

						System.out.println("Digite o limite de crédito (R$): ");
						limite = sc.nextFloat();
						contas.atualizar(
								new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do aniversario da Conta: ");
						aniversario = sc.nextInt();
						contas.atualizar(
								new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo de conta inválido!");
					}
					}
				} else {
					System.out.println("A conta não foi encontrada!");
				}
				keyPress();

				break;
			case 5:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Apagar a Conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = sc.nextInt();
				
				contas.deletar(numero);

				keyPress();

				break;
			case 6:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Saque\n\n");
				
				System.out.println("Digite o nuúmero da conta: ");
				numero = sc.nextInt();
				
				do {
					System.out.println("Digite o valor do saque (R$): ");
					valor = sc.nextFloat();
				}while(valor <= 0);
				
				contas.sacar(numero, valor);

				keyPress();

				break;
			case 7:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Depósito\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = sc.nextInt();
				
				do {
					System.out.println("Digite o valor do depósito (R$): ");
					valor =sc.nextFloat();
				}while (valor <= 0);
				
				contas.depositar(numero,valor);
				
				keyPress();

				break;
			case 8:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Transferência entre Contas\n\n");
				
				System.out.println("Digite o numero da conta de origem: ");
				numero = sc.nextInt();
				System.out.println("Digite o numero da conta de destino: ");
				numeroDestino = sc.nextInt();
				
				do {
					System.out.println("Digite o valor da transferência (R$): ");
					valor = sc.nextFloat();
				}while(valor <=0);
				
				contas.transferir(numero, numeroDestino, valor);
				
				keyPress();

				break;
			default:
				System.out.println(Cores.TEXT_BLACK_BOLD + "\nOpção Inválida!\n");

				keyPress();
				break;
			}
		}
	}

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter! ");
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: João Andrade                     ");
		System.out.println("Generation Brasil - joaoa@generation.org                   ");
		System.out.println("github.com/JoaoAndrade-dev                                 ");
		System.out.println("***********************************************************");
	}

}
