package Controller;

import java.util.*;

import Modules.Expense.EqualExpense;
import Modules.Expense.ExactExpense;
import Modules.Expense.Expense;
import Modules.Expense.ExpenseData;
import Modules.Expense.PercentageExpense;
import Modules.Split.ExactSplit;
import Modules.Split.PercentSplit;
import Modules.Split.Split;

import Modules.ExpenseType;
import Modules.SplitType;
import Modules.User;
import Repository.ExpenseRepository;
import java.util.List;


public class ExpenseController {
	
	public static Expense createExpense(ExpenseType expenseType, double amount, User expensePaidBy, List<Split> splits, ExpenseData expenseData)
	{
		
		switch(expenseType)
		{
		case EXACT: return new ExactExpense(amount, expensePaidBy, splits, expenseData);
		
		case PERCENT: 
			for(Split split: splits)
		{
				PercentSplit percentSplit = (PercentSplit) split;
				split.setAmount((amount*percentSplit.getPercent())/100);
		}
			return new PercentageExpense(amount, expensePaidBy, splits, expenseData);
		
		case EQUAL: 
			int totalSplits = splits.size();
			double splitAmount = ((double) Math.round(amount*100/totalSplits))/100;
			
			for(Split split: splits)
			{
				split.setAmount(splitAmount);
			}
			return new EqualExpense(amount, expensePaidBy, splits, expenseData);
			
			default: return null;
		}
		
	}

}
