package Controller;

import Modules.User;
import Repository.ExpenseRepository;

public class UserController {
	
	ExpenseRepository expRepo;
	
	public UserController(ExpenseRepository expRepo)
	{
		this.expRepo = expRepo;
	}
	
	public void addUser(User user)
	{
		expRepo.addUser(user);
	}
	
	public User getUser(String userName)
	{
		return expRepo.getUser(userName);
	}

}
