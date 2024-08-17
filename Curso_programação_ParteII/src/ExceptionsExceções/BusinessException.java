package ExceptionsExceções;

public class BusinessException extends RuntimeException {
    
    // SERIAL VERSION UID PARA CONTROLE DE VERSÃO DA CLASSE DURANTE A SERIALIZAÇÃO
	private static final long serialVersionUID = 1L;

    // CONSTRUTOR QUE RECEBE UMA MENSAGEM E A PASSA PARA A SUPERCLASSE (RuntimeException)
	public BusinessException(String msg) {
		super(msg);
	}
}
