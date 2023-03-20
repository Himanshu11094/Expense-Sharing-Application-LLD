package Modules.Expense;

import java.util.UUID;
import Modules.Split.*;
import java.util.*;


import Modules.User;

public abstract class Expense {
	
	private final String id;
	private double amount;
	private User expensePaidBy;
	private List<Split> splits;
	private ExpenseData expenseData;
	
	public Expense(double amount, User expensePaidBy, List<Split> splits, ExpenseData expenseData) {
		 
		this.id = UUID.randomUUID().toString();
		this.amount = amount;
		this.expensePaidBy = expensePaidBy;
		this.splits = splits;
		this.expenseData = expenseData;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public User getExpensePaidBy() {
		return expensePaidBy;
	}

	public void setExpensePaidBy(User expensePaidBy) {
		this.expensePaidBy = expensePaidBy;
	}

	public List<Split> getSplits() {
		return splits;
	}

	public void setSplits(List<Split> splits) {
		this.splits = splits;
	}

	public ExpenseData getExpenseData() {
		return expenseData;
	}

	public void setExpenseData(ExpenseData expenseData) {
		this.expenseData = expenseData;
	}

	public String getId() {
		return id;
	}
	
	public abstract boolean validate();

	
	

}
