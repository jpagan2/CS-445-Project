package com.example.REST_server;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class AsksService {
	 private final AtomicLong counter = new AtomicLong(0);
	    private final AtomicLong acounter = new AtomicLong(0);

	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
	    LocalDateTime date_created = LocalDateTime.now();
	    String formatted_date = date_created.format(myFormatObj);
	    String extraZipCodes[] = {"60607", "60608"};
	    
	    Asks a;
	    Asks a3;
	    
	    List<Asks> aList;
	    
	    
	    public List<Asks> getAsks() {
	        List<Asks> list = new ArrayList<>();
		    list.add(a);
		    if(a3 != null) {
			    list.add(a3);
		    }
		    return list;
	    }
	    
	    public Asks addAsks(Asks newAsk) {
			a = new Asks(newAsk.getUid(), "<aid1>", newAsk.getType(), newAsk.getDescription(), newAsk.getStart_date(), newAsk.getEnd_date(), newAsk.getExtra_zip(), newAsk.getIs_active(), formatted_date);
			return a;
		}
	    
	    
		public Asks getAsksByAid(String aid) {
			Predicate<Asks> byAid = p -> p.getAid().equals(aid);
			return filterAccounts(byAid);
		}
		private Asks filterAccounts(Predicate<Asks> strategy) {
			return getAsks().stream().filter(strategy).findFirst().orElse(null);
		}

		public Map updateAsks(Asks updatedAsk) {
				a3 = new Asks(updatedAsk.getUid(), updatedAsk.getAid(),  updatedAsk.getType(), updatedAsk.getDescription(), updatedAsk.getStart_date(), updatedAsk.getEnd_date(), updatedAsk.getExtra_zip(), updatedAsk.getIs_active(), updatedAsk.getDate_created());
				return null;
		}
		
		public Asks deactivateAsks(Asks deactivateAsks){
			Asks deactivatedAsk = new Asks(deactivateAsks.getUid(), deactivateAsks.getAid(), deactivateAsks.getType(), deactivateAsks.getDescription(), deactivateAsks.getStart_date(), deactivateAsks.getEnd_date(), deactivateAsks.getExtra_zip(), false, deactivateAsks.getDate_created());
			a3 = deactivatedAsk;
			return deactivatedAsk;
		}
		public List<Asks> deleteAsks(String aid) {
			for (Iterator<Asks> iterator = aList.iterator(); iterator.hasNext(); ) {
			    Asks ask = iterator.next();
			    if (ask.getAid() == aid) {
			        iterator.remove();
			    }
			}
			return aList;
		}

}
