package Controller;

import java.util.List;

import Modules.ExpenseType;
import Modules.Expense.ExpenseData;
import Modules.Split.Split;
import Repository.ExpenseRepository;

public class SplitController {
	
	ExpenseRepository expRepo;

	public SplitController(ExpenseRepository expRepo) {
		
		this.expRepo = expRepo;
	}
	
	public void addExpense(ExpenseType expenseType, double amount, String expensePaidBy, List<Split> splits, ExpenseData expenseData)
	{
		expRepo.addExpense(expenseType, amount, expensePaidBy, splits, expenseData);		
	}
	
	public void showBalance(String userName)
	{
		List<String> balances = expRepo.getBalance(userName);				
		
		if(balances.isEmpty())
		{
			System.out.println("NO BALANCE");
		}
		else
		{
			for(String bal: balances)
				System.out.println(bal);
		}
	}
	
	public void showBalances()
	{
		List<String> balances = expRepo.getBalances();
		
		if(balances.isEmpty())
			System.out.println("NO BALANCE");
		
		else
		{
			for(String bal: balances)
				System.out.println(bal);
		}
		
	}

}
