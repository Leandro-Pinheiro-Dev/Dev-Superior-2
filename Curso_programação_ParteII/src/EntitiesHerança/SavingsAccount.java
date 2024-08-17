package EntitiesHerança;

public class SavingsAccount extends Account{
	
	private Double interestRate;
	
	public SavingsAccount() {
		super();
	}

	public SavingsAccount(Integer number, String holder, double balance, Double interestRate) {
		super(number, holder, balance);
		this.interestRate = interestRate;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public void updateBalance() {
		balance += balance* interestRate;
	}
	
	//SOBREPOSIÇÃO (INFORMA O COMPILADOR UTILIZANDO @Override
	@Override
	public void withdraw(double amount) {
		balance -= amount;
	}
}
