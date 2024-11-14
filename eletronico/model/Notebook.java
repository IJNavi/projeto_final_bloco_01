package eletronico.model;

public class Notebook extends Eletronico{
	
	private String processador;
	private String placaDeVideo;

	public Notebook(int numero, int tipo, String nome, float preço, String processador, String placaDeVideo) {
		super(numero, tipo, nome, preço);
		
		this.processador = processador;
		this.placaDeVideo = placaDeVideo;
	}
	
	public Notebook(int numero, float preço) {
		super(numero, preço);
	}


	public void setProcessador(String processador) {
		this.processador = processador;
	}


	public void setPlacaDeVideo(String placaDeVideo) {
		this.placaDeVideo = placaDeVideo;
	}
		
    @Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Processador: " + this.processador);
		System.out.println("Placa de Video: " + this.placaDeVideo);
	}
}
