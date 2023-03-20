import java.util.Scanner;
import java.util.*;

import Modules.Expense.ExpenseData;
import Modules.Split.EqualSplit;
import Modules.Split.ExactSplit;
import Modules.Split.PercentSplit;
import Modules.Split.Split;
import Controller.SplitController;
import Controller.UserController;
import Modules.ExpenseType;
import Modules.SplitType;
import Modules.User;
import Repository.ExpenseRepository;

public class Main {

	public static void main(String[] args) {
		
		User user1 = new User("123", "u1", "123@gmail.com", "12345678");
		User user2 = new User("456", "u2", "456@gmail.com", "12345678");
		User user3 = new User("789", "u3", "789@gmail.com", "12345678");
		User user4 = new User("101", "u4", "101@gmail.com", "12345678");
		
		
		ExpenseRepository  expRepo = new ExpenseRepository();
		UserController userControl = new UserController(expRepo);
		
		userControl.addUser(user1);
		userControl.addUser(user2);
		userControl.addUser(user3);
		userControl.addUser(user4);
		
		SplitController splitControl = new SplitController(expRepo);
		
		while(true)
		{
			Scanner inp = new Scanner(System.in);
			
			
						
			String commands[] = inp.nextLine().split(" ");
			
			
		
			SplitType sType = SplitType.of(commands[0]);
			
			 try {
			
			switch(sType)
			{
			case EXPENSE:
				String userName = commands[1];
				double amountSpent = Double.parseDouble(commands[2]);
				int totalMembers = Integer.parseInt(commands[3]);
				List<Split> splits = new ArrayList<>();
				int expenseIndex = 3 + totalMembers + 1;
				ExpenseType expense = ExpenseType.of(commands[expenseIndex]);
				
				switch(expense)
				{
				case EQUAL: 
					for(int i=0; i< totalMembers; i++)
					{
						splits.add(new EqualSplit(userControl.getUser(commands[4+i])));
					}
					splitControl.addExpense(
							ExpenseType.EQUAL, amountSpent, userName, splits, new ExpenseData("GoaFlight")
							);
					break;
					
				case EXACT:
					for(int i=0; i<totalMembers; i++)
					{
						splits.add(
								new ExactSplit(
										userControl.getUser(commands[4+i]),
										Double.parseDouble(commands[expenseIndex+i+1]))
								);
					}
					splitControl.addExpense(
							ExpenseType.EXACT, amountSpent, userName, splits, new ExpenseData("CabTickets")
							);
					break;
					
				case PERCENT:
					for(int i=0; i<totalMembers; i++)
					{
						splits.add(
								new PercentSplit(
										userControl.getUser(commands[4+i]),
										Double.parseDouble(commands[expenseIndex+i+1])
										)
								);
					}
					splitControl.addExpense(
							ExpenseType.PERCENT, amountSpent, userName, splits, new ExpenseData("Dinner")
							);
					break;
					
				}
				break;
				
			case SHOW:
				if(commands.length == 1)
					splitControl.showBalances();
				
				else splitControl.showBalance(commands[1]);
				
				break;
				
			case QUIT: System.out.println("QUITING...");
			return;
			
			default: System.out.println("No expected Argument found");
			break;
				
			}
			
			 }
			 
			 catch(NullPointerException e)
		        {
		            System.out.print("ENTER THE VALID INPUT");
		        }
			
		}

	}

}
