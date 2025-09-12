package app.note.dto;

import app.note.Note;
import app.note.dto.get.GetUserNotesResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Setter
@Getter
public class NoteResponseDto {
    private long id;
    private String title;
    private String content;

    private List<Note> userNotes;

    public NoteResponseDto() {

    }

    public static NoteResponseDto success(List<Note> userNotes) {
        return builder().userNotes(userNotes).build();
    }

    public static NoteResponseDto failed(GetUserNotesResponse.Error error) {
        return builder().userNotes(null).build();
    }
}
