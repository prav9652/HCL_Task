package com.example;  
public class Transaction {

	public long TransactionId;
	public java.sql.Timestamp TransDate;
	public long  credit;
	public long debit;
	public long balance;
	
	public long getTransactionId() {
		return TransactionId;
	}
	public void setTransactionId(long transactionId) {
		TransactionId = transactionId;
	}
	public void setTransDate(java.sql.Timestamp transDate) {
		TransDate=transDate;
	}
	public java.sql.Timestamp getTransDate(){
		return this.TransDate;
	}
	public long getCredit() {
		return credit;
	}
	public void setCredit(long credit) {
		this.credit = credit;
	}
	public long getDebit() {
		return debit;
	}
	public void setDebit(long debit) {
		this.debit = debit;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
}
