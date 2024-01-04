package com.speer.service.impl;

import com.speer.entity.Note;
import com.speer.entity.User;
import com.speer.exceptions.ResourceNotFoundException;
import com.speer.payload.NoteDto;
import com.speer.repository.NoteRepository;
import com.speer.repository.UserRepository;
import com.speer.service.NoteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public NoteDto createNote(NoteDto notedto, Long userId) {
        User user = this.userRepository.findById(userId).
                orElseThrow(()->new ResourceNotFoundException("user","userId",userId));

        Note note = this.modelMapper.map(notedto,Note.class);
        note.setUser(user);

        Note saveNote=this.noteRepository.save(note);
        return this.modelMapper.map(saveNote,NoteDto.class);
    }

    @Override
    public List<NoteDto> getUserNotes(Long userId) {
        User user  = this.userRepository.findById(userId).
                orElseThrow(()->new ResourceNotFoundException("note","noteId",userId));

        List<Note>note = this.noteRepository.findByUser(user);
        List<NoteDto>noteDtos = note.stream().map((plan)->this.modelMapper.map(plan,NoteDto.class)).collect(Collectors.toList());
        return noteDtos;

    }

//    @Override
//    public List<NoteDto> searchNotes(String keyword) {
//        List<Note>noteList = this.noteRepository.findByTitleContainingIgnoreCaseAndContentContainingIgnoreCase("%"+keyword+"%");
//        List<NoteDto>noteDtos = noteList.stream().map((emp)->this.modelMapper.map(emp,NoteDto.class)).collect((Collectors.toList()) );
//        return noteDtos;
//    }

    @Override
    public NoteDto deleteNote(Long noteId) {
        Note note = this.noteRepository.findById(noteId).
                orElseThrow(()->new ResourceNotFoundException("Note","noteId",noteId));

        this.noteRepository.delete(note);
        return this.modelMapper.map(note,NoteDto.class);
    }

    @Override
    public NoteDto updateNote(NoteDto noteDto,Long noteId) {
        Note note = this.noteRepository.findById(noteId)
                .orElseThrow(()->new ResourceNotFoundException("Note","noteId",noteId));
        note.setContent(noteDto.getContent());
        note.setTitle(noteDto.getTitle());

        Note updatedNote = this.noteRepository.save(note);

        return this.modelMapper.map(updatedNote,NoteDto.class);
    }

    @Override
    public List<NoteDto> searchNote(String keyword) {
        List<Note>notes = this.noteRepository.findByTitle("%"+keyword+"%");
        List<NoteDto>noteDtos  = notes.stream().map((note)->this.modelMapper.map(note,NoteDto.class)).collect(Collectors.toList());

        return noteDtos;
    }


}
