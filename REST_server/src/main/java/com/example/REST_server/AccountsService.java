package com.example.REST_server;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class AccountsService {
	private final AtomicLong counter = new AtomicLong(0);
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
    LocalDateTime date_created = LocalDateTime.now();
    String formatted_date = date_created.format(myFormatObj);
    
	public Map address0 = new LinkedHashMap(2);
	private Map address1 = new LinkedHashMap(2);
	private Map address2 = new LinkedHashMap(2);

	private Map activationFailed = new LinkedHashMap(5);
	
	Accounts account0 = new Accounts("<uid" + counter.getAndIncrement() + ">", "Virgil Bistriceanu", address0, "312-567-5146", "http://cs.iit.edu/~virgil/pictures/virgil-head-small-200811.jpg", true, formatted_date);
	Accounts account1 = new Accounts("<uid" + counter.getAndIncrement() + ">", "Jane Smith", address1, "217-456-7890", "http://example.com/images/jane-smith.jpeg", false, formatted_date);
	Accounts account2 = new Accounts("<uid" + counter.getAndIncrement() + ">", "CSR #1",  address2, "(847) 842-8048", "http://example.com/images/jane-smith.jpeg", true, formatted_date);
	Accounts account3;
	Accounts account4;
	Accounts account5;

	public List<Accounts> getAccounts() {
		
		this.address0.put("street", "10 West 31st ST");
		this.address0.put("zip", "60616");
		this.address1.put("street", "123 2nd ST");
		this.address1.put("zip", "60607");
		this.address2.put("street", "101 W Main St.");
		this.address2.put("zip", "60010");


	    List<Accounts> list = new ArrayList<>();
	    list.add(account0);
	    list.add(account1);
	    list.add(account2);
	    if(account3 != null) {
		    list.add(account3);
	    }
	    return list;
	}
	
	public Accounts getAccountsbyUid(String uid) {
		
		Predicate<Accounts> byUid = p -> p.getUid().equals(uid);
		return filterAccounts(byUid);
	}

	private Accounts filterAccounts(Predicate<Accounts> strategy) {
		return getAccounts().stream().filter(strategy).findFirst().orElse(null);
	}

	public Accounts addAccount(Accounts newAccount) {
		account3 = new Accounts("<uid" + counter.get() + ">", newAccount.getName(),  newAccount.getAddress(), newAccount.getPhone(), newAccount.getPicture(), newAccount.getIs_active(), formatted_date);
		return account3;
	}


	public Map updateAccounts(Accounts updatedAccount) {
		if (account3.getIs_active() != updatedAccount.getIs_active()) {
			activationFailed.put("type", "http://cs.iit.edu/~virgil/cs445/mail.spring2022/project/api/problems/data-validation");
			activationFailed.put("title", "Your request data didn't pass validation");
			activationFailed.put("detail", "You may not use PUT to activate an account, use GET /accounts/<uid3>/activate instead");
			activationFailed.put("status", 400);
			activationFailed.put("instance", "/accounts/<uid3>");
			return activationFailed;
		}else {
			account3 = new Accounts(account3.getUid(), updatedAccount.getName(),  updatedAccount.getAddress(), updatedAccount.getPhone(), updatedAccount.getPicture(), updatedAccount.getIs_active(), formatted_date);
			return null;
		}
	}
	
	public Accounts activateAccountsByUid(Accounts activateAccount){
		Accounts activatedAccount = new Accounts(activateAccount.getUid(), activateAccount.getName(), activateAccount.getAddress(), activateAccount.getPhone(), activateAccount.getPicture(), true, activateAccount.getDate_created());
		account3 = activatedAccount;
		return activatedAccount;
	}
	
	public List<Accounts> getMainAccounts() {
		Accounts accountMain = getAccountsbyUid("<uid2>");
		Accounts accountMain0 = getAccountsbyUid("<uid3>");
		List<Accounts> mainAccounts = null;

		mainAccounts.add(accountMain);
		mainAccounts.add(accountMain0);

		return mainAccounts;
		
	}
	

}
