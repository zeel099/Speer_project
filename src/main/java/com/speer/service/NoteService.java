package com.speer.service;

import com.speer.entity.Note;
import com.speer.entity.User;
import com.speer.payload.NoteDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface NoteService {

    NoteDto createNote(NoteDto note, Long userId);
    List<NoteDto>getUserNotes(Long userId);

    //List<NoteDto> searchNotes(String keyword);

    NoteDto deleteNote(Long noteId);

    NoteDto updateNote(NoteDto noteDto,Long noteId);

    List<NoteDto> searchNote(String keyword);

}
