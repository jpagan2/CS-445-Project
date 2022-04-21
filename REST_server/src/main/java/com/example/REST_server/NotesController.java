package com.example.REST_server;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotesController {
	
	@Autowired
	NotesService notesService;
	
	
	@GetMapping("/bn/api/notes")
	public List<Notes> getNotes() {
	    return notesService.getNotes();
	}
	
	@PostMapping("/bn/api/notes")
	@ResponseStatus(HttpStatus.CREATED)
	public Notes addNotes(@RequestBody Notes newNotes, HttpServletResponse response) {
		response.setHeader("Location", "/bn/api/notes/");
		return notesService.addNotes(newNotes);
	}
	
	@GetMapping("/bn/api/notes/{nid}")
	public ResponseEntity<Notes> getNotesByNid(@PathVariable("nid")String noteId) {
		Notes notes = notesService.getNotesbyNid(noteId);
		if(notes == null) {
			return new ResponseEntity<Notes> (HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Notes> (notes,HttpStatus.OK);
	}

	@PutMapping("/bn/api/notes/{nid}")
	public Notes putNotes(@RequestBody Notes updatedNote,  HttpServletResponse response) {
		response.setStatus(204);
		return notesService.updateNotes(updatedNote);
		
	}
}