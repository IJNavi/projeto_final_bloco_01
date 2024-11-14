package eletronico;

import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;

import eletronico.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao, numero;
		String nomeEletronico;

		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                  ELÉTRO100.K.O.                     ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("           1 - Criar produto.                        ");
			System.out.println("           2 - Listar todos os produtos.             ");
			System.out.println("           3 - Buscar produto por número.            ");
			System.out.println("           4 - Atualizar dados do produto.           ");
			System.out.println("           5 - Excluir produto.                      ");
			System.out.println("           6 - Sair.		                     ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 6) {
				System.out.println(
						Cores.TEXT_WHITE_BOLD + "\nElétro100.K.O. - Evite K.O.! Eletrônico é na Elétro100.K.O.");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Produto\n\n");

				System.out.println("Digite o Número do eletrônico: ");
				numero = leia.nextInt();
				System.out.println("Digite o Nome do eletrônico: ");
				leia.skip("\\R?");
				nomeEletronico = leia.nextLine();

				keyPress();

				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas os Eletrônicos.\n\n");

				keyPress();

				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar Eletronicos - por número.\n\n");

				System.out.println("Digite o número do Eletrônico: ");
				numero = leia.nextInt();

				keyPress();
				break;

			case 4: {
				System.out.println("Atualizar quantidade do produto.\n\n");

				System.out.println("Digite o número do Eletrônico: ");
				numero = leia.nextInt();

				keyPress();
				break;
			}
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Excluir eletrônico.\n\n");

				System.out.println("Digite o número do eletrônico: ");
				numero = leia.nextInt();


				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();

				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n**************************************************");
		System.out.println("Projeto Desenvolvido por:                         ");
		System.out.println("Ivan Barbosa - ivanjulio.ij@gmail.com             ");
		System.out.println("github.com/IJNavi                                 ");
		System.out.println("**************************************************");
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}

	}

}
