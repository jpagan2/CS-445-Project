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
public class GivesService {
	 private final AtomicLong counter = new AtomicLong(0);
	    private final AtomicLong gcounter = new AtomicLong(0);

	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
	    LocalDateTime date_created = LocalDateTime.now();
	    String formatted_date = date_created.format(myFormatObj);
	    String extraZipCodes[] = {"'60607'", "'60608'"};
	    
	    Gives g;
	    Gives g3;
	    
	    List<Asks> aList;
	    
	    
	    public List<Gives> getGives() {
	        List<Gives> list = new ArrayList<>();
		    list.add(g);
		    if(g3 != null) {
			    list.add(g3);
		    }
		    return list;
	    }
	    
	    public Gives addGives(Gives newGive) {
			g = new Gives(newGive.getUid(), "<gid1>", newGive.getType(), newGive.getDescription(), newGive.getStart_date(), newGive.getEnd_date(), newGive.getExtra_zip(), newGive.getIs_active(), formatted_date);
			return g;
		}
	    
		public Map updateGives(Gives updatedGive) {
			g3 = new Gives("<uid3>", "<gid1>",  updatedGive.getType(), updatedGive.getDescription(), updatedGive.getStart_date(), updatedGive.getEnd_date(), updatedGive.getExtra_zip(), updatedGive.getIs_active(), updatedGive.getDate_created());
			return null;
	}

/*
	    
		public Gives getGivesByGid(String gid) {
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
			g3 = deactivatedAsk;
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
*/
}