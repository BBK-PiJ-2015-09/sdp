package worksheet_01;

public class BankAccount {
	private float balance;
	
	public void deposit(float amount) {
		this.balance += amount;
	}
	
	public float showBalance() {
		return this.balance;
	}
	
	BankAccount() {
		balance = 100;
	}
}
