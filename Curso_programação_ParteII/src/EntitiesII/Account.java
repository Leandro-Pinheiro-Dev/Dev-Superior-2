package EntitiesII;

import ExceptionsExceções.BusinessException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
    // CONSTRUTOR PADRÃO SEM PARÂMETROS
	public Account() {
	}

    // CONSTRUTOR QUE INICIALIZA A CONTA COM NÚMERO, TITULAR, SALDO E LIMITE DE SAQUE
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

    // MÉTODOS GETTERS E SETTERS PARA ACESSO E MODIFICAÇÃO DAS VARIÁVEIS DE INSTÂNCIA
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
    // MÉTODO PARA DEPOSITAR UM VALOR NO SALDO DA CONTA
	public void deposit(double amount) {
		balance += amount;
	}
	
    // MÉTODO PARA SACAR UM VALOR DA CONTA
	public void withdraw(double amount) {
        // VALIDA O SAQUE ANTES DE REALIZAR A OPERAÇÃO
		validateWithdraw(amount);
		balance -= amount; 
	}
	
    // MÉTODO PRIVADO QUE VALIDA SE O SAQUE É VÁLIDO DE ACORDO COM O LIMITE E SALDO DISPONÍVEL
	private void validateWithdraw(double amount) {
		if (amount > getWithdrawLimit()) {
            // LANÇA UMA EXCEÇÃO SE O MONTANTE EXCEDE O LIMITE DE SAQUE
			throw new BusinessException("Erro de saque: A quantia excede o limite de saque");
		} 
		if (amount > getBalance()) {
            // LANÇA UMA EXCEÇÃO SE O MONTANTE EXCEDE O SALDO DISPONÍVEL
			throw new BusinessException("Erro de saque: Saldo insuficiente");
		}
	}
}
