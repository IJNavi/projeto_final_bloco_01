package eletronico;

import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;

import eletronico.controller.EletronicoController;
import eletronico.model.Eletronico;
import eletronico.model.Notebook;
import eletronico.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		EletronicoController eletronicos = new EletronicoController();

		Scanner leia = new Scanner(System.in);

		float preço;
		int opcao, numero, tipo;
		String nome, processador = "", placaDeVideo = "";

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
				System.out.println(Cores.TEXT_WHITE + "Cadastrar Produto\n\n");


				System.out.println("Digite o Nome do eletrônico: ");
				leia.skip("\\R?");
				nome = leia.nextLine();
				
				// Para atualizações futuras.
				/*
				do {
					System.out.println("Digite o Tipo da Conta (1- Notebook ou 2- Smartphone): ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);
				*/

				tipo = 1;
				
				System.out.println("Digite o Preço (R$) do Eletrônico {Ex.: 00,00}: ");
				preço = leia.nextFloat();
				
				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o nome do Processador: ");
					leia.skip("\\R?");
					processador = leia.nextLine();
					System.out.println("Digite o nome da Placa de vídeo: ");
					leia.skip("\\R?");
					placaDeVideo = leia.nextLine();
					eletronicos.cadastrar(new Notebook(eletronicos.gerarNumero(), tipo, nome, preço, processador, placaDeVideo));
				}/*
				case 2 -> {
					System.out.println("Digite o dia do Aniversário da Conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(
							new ContaPoupança(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}*/
				}
				
				keyPress();

				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas os Eletrônicos.\n\n");
				eletronicos.listarTodos();
				keyPress();

				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar Eletronicos - por número.\n\n");

				System.out.println("Digite o número do Eletrônico: ");
				numero = leia.nextInt();
				
				eletronicos.procurarPorNumero(numero);

				keyPress();
				break;

			case 4: {
				System.out.println("Atualizar dados do produto.\n\n");

				System.out.println("Digite o número do Eletrônico: ");
				numero = leia.nextInt();

				var buscaEletronico = eletronicos.buscarNaCollection(numero);
				if (buscaEletronico != null) {
					
					
					System.out.println("Digite o Número do eletrônico: ");
					numero = leia.nextInt();
					
					tipo = 1;
					
					System.out.println("Digite o Nome do Eletrônico: ");
					leia.skip("\\R?");
					nome = leia.nextLine();

					System.out.println("Digite o Preço (R$) do Eletrônico {Ex.: 00,00}: ");
					preço = leia.nextFloat();

					System.out.println("Digite o Nome do Processador: ");
					leia.skip("\\R?");
					nome = leia.nextLine();
					
					System.out.println("Digite o Nome da Placa de Vídeo: ");
					leia.skip("\\R?");
					nome = leia.nextLine();
					
					eletronicos.atualizar(new Notebook(numero, tipo, nome, preço, processador, placaDeVideo));

				} else {
					System.out.println("O Eletrônico não foi encontrado!");
				}
				
				keyPress();
				break;
			}
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Excluir eletrônico.\n\n");

				System.out.println("Digite o número do eletrônico: ");
				numero = leia.nextInt();

				eletronicos.excluir(numero);
				
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
