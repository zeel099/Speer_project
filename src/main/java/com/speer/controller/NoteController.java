package com.speer.controller;

import com.speer.payload.NoteDto;
import com.speer.response.ResponseHandler;
import com.speer.service.NoteService;
import lombok.Getter;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/notes")
@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    //login api
    @PostMapping("/login/{userId}")
    public ResponseEntity<Object>createNote(@val @RequestBody NoteDto noteDto,@PathVariable("userId") Long userId){

        NoteDto createNote = this.noteService.createNote(noteDto,userId);
        return ResponseHandler.responseBuilder("Account created successfully", HttpStatus.OK,createNote);
    }

    //get note by userid API
    @GetMapping("/{userId}")
    public ResponseEntity<List<NoteDto>>getUserNotes(@PathVariable("userId") Long userId){
        List<NoteDto>emp = this.noteService.getUserNotes(userId);
        ResponseEntity<List<NoteDto>> listResponseEntity = new ResponseEntity<>(emp, HttpStatus.OK);
        return listResponseEntity;
    }
    //update note api
    @PutMapping("/{noteId}")
    public ResponseEntity<Object>updateNote(@val @RequestBody NoteDto noteDto,@PathVariable("noteId") Long noteId){
        NoteDto updateNote = this.noteService.updateNote(noteDto,noteId);
        return ResponseHandler.responseBuilder("Notes added successfully",HttpStatus.OK,updateNote);
    }

    //delete note api
    @DeleteMapping("/{noteId}")
    public ResponseEntity<Object>deleteNote(@PathVariable("noteId") Long noteId){
        NoteDto deletedNote = this.noteService.deleteNote(noteId);
        return ResponseHandler.responseBuilder("Deleted Successfully",HttpStatus.OK,deletedNote);
    }

    //search note api
    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<NoteDto>>searchNote(@PathVariable("keyword") String keyword){
        List<NoteDto>searchResult = this.noteService.searchNote(keyword);
        return new ResponseEntity<>(searchResult,HttpStatus.OK);
    }

}
