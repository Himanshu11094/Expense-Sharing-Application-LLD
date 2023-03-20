package Modules.Expense;
import java.util.*;

import Modules.User;
import Modules.Split.ExactSplit;
import Modules.Split.Split;

public class ExactExpense extends Expense{
	
	public ExactExpense(double amount, User expensePaidBy, List<Split> splits, ExpenseData expenseData)
	{
		super(amount, expensePaidBy, splits, expenseData);
	}
	
	@Override
	
	public boolean validate()
	{
		double totalAmount = getAmount();
		double totalSplitAmount = 0;
		for(Split split: getSplits())
		{
			if(!(split instanceof ExactSplit)) return false;
			
			ExactSplit exactSplit = (ExactSplit) split;
			
			totalSplitAmount+=exactSplit.getAmount();
		}
		return totalAmount == totalSplitAmount;
	}
	

}
