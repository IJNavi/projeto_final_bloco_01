package eletronico.controller;

import java.util.ArrayList;

import eletronico.model.Eletronico;
import eletronico.repository.EletronicoRepository;

public class EletronicoController implements EletronicoRepository {

	private ArrayList<Eletronico> listaEletronicos = new ArrayList<Eletronico>();
	int numero = 0;
	
	public Eletronico buscarNaCollection(int numero) {
		for (var eletronico : listaEletronicos) {
			if (eletronico.getNumero() == numero) {
				return eletronico;
			}
		}
		return null;
	}
	
	@Override
	public void procurarPorNumero(int numero) {
		var eletronico = buscarNaCollection(numero);

		if (eletronico != null) {
			eletronico.visualizar();
		} else {
			System.out.println("O eletrônico número: " + numero + " não foi encontrado.");
		}
	}
	
	@Override
	public void listarTodos() {
		for (var eletronico : listaEletronicos) {
			eletronico.visualizar();
		}
		
	}
	@Override
	public void cadastrar(Eletronico eletronico) {
		listaEletronicos.add(eletronico);
		System.out.println("\nO eletrônico: " + eletronico.getNumero() + " foi cadastrado com sucesso!");
		
	}
	@Override
	public void atualizar(Eletronico eletronico) {
		var buscaEletronico = buscarNaCollection(eletronico.getNumero());

		if (buscaEletronico != null) {
			listaEletronicos.set(listaEletronicos.indexOf(buscaEletronico), eletronico);
			System.out.println("\nO eletrônico número: " + eletronico.getNumero() + " foi atualizado com sucesso!");
		} else {
			System.out.println("\nO eletrônico número: " + eletronico.getNumero() + " não foi encontrado!");
		}
		
	}
	
	@Override
	public void excluir(int numero) {
		var eletronico = buscarNaCollection(numero);

		if (eletronico != null) {
			if (listaEletronicos.remove(eletronico) == true)
				System.out.println("\nO Eletrônico número: " + numero + " foi deletado com sucesso!");
		} else
			System.out.println("\nO Eletrônico número: " + numero + " não foi encontrado!");
	}
	
	public int gerarNumero() {
		return ++numero;
	}

	
}
