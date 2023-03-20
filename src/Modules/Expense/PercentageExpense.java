package Modules.Expense;
import java.util.*;

import Modules.User;
import Modules.Split.ExactSplit;
import Modules.Split.PercentSplit;
import Modules.Split.Split;

public class PercentageExpense extends Expense{
	
	public PercentageExpense(double amount, User expensePaidBy, List<Split> splits, ExpenseData expenseData)
	{
		super(amount, expensePaidBy, splits, expenseData);
	}
	
	@Override
	public boolean validate()
	{
		double totalSplitPercent = 0;
		
		for(Split split: getSplits())
		{
			if(!(split instanceof PercentSplit)) return false;
			
			PercentSplit percentSplit = (PercentSplit) split;
			
			totalSplitPercent += percentSplit.getPercent();
		}
		return 100 == totalSplitPercent;
	}

}
