package eletronico.repository;

import eletronico.model.Eletronico;

public interface EletronicoRepository {
	
	// CRUD eletrônico.
	public void procurarPorNumero(int numero);
	public void listarTodos();
	public void cadastrar(Eletronico eletronico);
	public void atualizar(Eletronico eletronico);
	public void excluir(int numero);

}
