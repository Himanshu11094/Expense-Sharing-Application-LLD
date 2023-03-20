package Modules.Expense;
import Modules.User;
import Modules.Split.*;
import java.util.*;

public class EqualExpense extends Expense{
	
	public EqualExpense(double amount, User expensePaidBy, List<Split> splits, ExpenseData expenseData)
	{
		super(amount, expensePaidBy, splits, expenseData);
	}
	
	@Override
	
	public boolean validate()
	{
		for(Split split: getSplits())
		{
			if(!(split instanceof EqualSplit)) return false;
			
		}
		return true;
	}

}
