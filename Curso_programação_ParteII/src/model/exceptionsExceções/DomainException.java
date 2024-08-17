package model.exceptionsExceções;

public class DomainException extends RuntimeException {
	
	// IDENTIFICADOR DE VERSÃO PARA SERIALIZAÇÃO
	private static final long serialVersionUID = 1L;

	// CONSTRUTOR QUE RECEBE UMA MENSAGEM DE ERRO E CHAMA O CONSTRUTOR DA SUPERCLASSE
	public DomainException(String msg) {
		super(msg);
	}
} 
