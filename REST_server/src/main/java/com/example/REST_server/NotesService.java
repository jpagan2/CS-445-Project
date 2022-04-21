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
public class NotesService {
	 private final AtomicLong counter = new AtomicLong(0);
	 private final AtomicLong ncounter = new AtomicLong(0);

	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
	    LocalDateTime date_created = LocalDateTime.now();
	    String formatted_date = date_created.format(myFormatObj);
	    String extraZipCodes[] = {"60607", "60608"};
	    
	    Notes a;
	    Notes a3;
	    public List<Notes> getNotes() {
	        List<Notes> list = new ArrayList<>();
		    list.add(a);
		    if(a3 != null) {
			    list.add(a3);
		    }
		    return list;
	    }
	    
	    public Notes addNotes(Notes newNote) {
			a = new Notes(newNote.getUid(), "", newNote.getTo_type(), newNote.getTo_user_id(), newNote.getToid(), newNote.getDescription(), formatted_date);
			//	public Notes (String uid, String to_type, String to_user_id, String to_id, String description) {
	    	//a = new Notes(newNote.getUid(), "<aid1>", newNote.getType(), newNote.getDescription(), newNote.getStart_date(), newNote.getEnd_date(), newNote.getExtra_zip(), newNote.getIs_active(), formatted_date);
			return a;
		}
	    
	    
		public Notes getNotesbyNid(String nid) {
			Predicate<Notes> byNid = p -> p.getNid().equals(nid);
			return filterNotes(byNid);
		}
		private Notes filterNotes(Predicate<Notes> strategy) {
			return getNotes().stream().filter(strategy).findFirst().orElse(null);
		}

		public Notes updateNotes(Notes updatedNotes) {
			a3 = new Notes(updatedNotes.getUid(), updatedNotes.getNid(), updatedNotes.getTo_type(), updatedNotes.getTo_user_id(), updatedNotes.getToid(), updatedNotes.getDescription(), formatted_date);
			return null;
		}
		
		public Notes deactivateNotes(Notes deactivateNotes){
			Notes deactivateNote = new Notes(deactivateNotes.getUid(), deactivateNotes.getNid(), deactivateNotes.getTo_type(), deactivateNotes.getTo_user_id(), deactivateNotes.getToid(), deactivateNotes.getDescription(), formatted_date);
			a3 = deactivateNote;
			return deactivateNote;
		}
}