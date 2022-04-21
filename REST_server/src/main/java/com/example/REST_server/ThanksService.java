package com.example.REST_server;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class ThanksService {
	 private final AtomicLong counter = new AtomicLong(0);
	    private final AtomicLong tcounter = new AtomicLong(0);

	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
	    LocalDateTime date_created = LocalDateTime.now();
	    String formatted_date = date_created.format(myFormatObj);
	    String extraZipCodes[] = {"'60607'", "'60608'"};
	    
	    Thanks t;
	    Thanks t3;
	    
	    List<Thanks> tList;
	    
	    
	    public List<Thanks> getThanks() {
	        List<Thanks> list = new ArrayList<>();
		    list.add(t);
		    if(t3 != null) {
			    list.add(t3);
		    }
		    return list;
	    }
	    
		public Thanks getThanksByUid(String uid) {
			Predicate<Thanks> byUid = p -> p.getUid().equals(uid);
			return filterAccounts(byUid);
		}
		private Thanks filterAccounts(Predicate<Thanks> strategy) {
			return getThanks().stream().filter(strategy).findFirst().orElse(null);
		}

	    
	    public Thanks addThanks(Thanks newThanks) {
			t = new Thanks(newThanks.getUid(), "<tid1>", newThanks.getThank_to(), newThanks.getDescription(), formatted_date);
			return t;
		}
	    
		public Map updateThanks(Thanks updatedThanks) {
			t3 = new Thanks("<gid3>", "<tid1>",  updatedThanks.getThank_to(), updatedThanks.getDescription(), updatedThanks.getDate_created());
			return null;
	}
}