package com.example.REST_server;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

	    Asks a0 = new Asks("<uid" + counter.getAndIncrement() + ">", "<aid" + acounter.getAndIncrement() + ">", "type", "description",  "2022-03-14", "End Date", extraZipCodes, true, formatted_date);
	    Asks a1 = new Asks("<uid" + counter.getAndIncrement() + ">", "<aid" + acounter.getAndIncrement() + ">", "type", "description",  "2022-03-14", "End Date", extraZipCodes, true, formatted_date);
	    Asks a2 = new Asks("<uid" + counter.getAndIncrement() + ">", "<aid" + acounter.getAndIncrement() + ">", "type",  "description",  "2022-03-14", "End Date", extraZipCodes, true, formatted_date);
	    Asks a3;
	    public List<Asks> getAsks() {
	        List<Asks> list = new ArrayList<>();
	        list.add(a0);
	        list.add(a1);
	        list.add(a2);
	        return list;
	    }
	    
	    public Asks addAsks(Asks newAsk) {
			Asks ask = new Asks("<uid" + counter.get() + ">", "", newAsk.getType(), newAsk.getDescription(), newAsk.getStart_date(), newAsk.getEnd_date(), newAsk.getExtra_zip(), newAsk.getIs_active(), formatted_date);
			return ask;
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

}
