package com.speer.repository;

import com.speer.entity.Note;
import com.speer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note,Long> {

    List<Note>findByUser(User user);

    @Query("select p from Note p where p.title like :key")
    List<Note> findByTitle(@Param("key") String keyword);
}
