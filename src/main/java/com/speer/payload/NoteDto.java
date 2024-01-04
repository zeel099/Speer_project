package com.speer.payload;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Getter
@Setter
public class NoteDto {

    private Long id;
    private String title;
    private String content;


    private UserDto userDto;
}
