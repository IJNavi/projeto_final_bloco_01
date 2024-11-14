package eletronico.model;

public abstract class Eletronico {
	
	private int numero;
	private int tipo;
	private String nome;
	private float preço;

	public Eletronico(int numero, int tipo, String nome, float preço) {
		this.numero = numero;
		this.tipo = tipo;
		this.nome = nome;
		this.preço = preço;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setValor(float preço) {
		this.preço = preço;
	}
	
	
	public void visualizar() {

		String tipo = "";

		switch (this.tipo) {
		case 1:
			tipo = "Notebook";

			break;
		}
		System.out.println("\n\n***********************************************************");
		System.out.println("Dados do Eletrônico:");
		System.out.println("***********************************************************");
		System.out.println("Numero do Eletrônico: " + this.numero);
		System.out.println("Tipo da Conta: " + tipo);
		System.out.println("Nome: " + this.nome);
		System.out.println("Preço: " + this.preço);
	}
	
}
