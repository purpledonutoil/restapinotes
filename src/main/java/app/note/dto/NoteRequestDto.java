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
public class NoteRequestDto {
    private long id;
    private String title;
    private String content;

    private List<Note> userNotes;

    public static NoteRequestDto success(List<Note> userNotes) {
        return builder().userNotes(userNotes).build();
    }

    public static NoteRequestDto failed(GetUserNotesResponse.Error error) {
        return builder().userNotes(null).build();
    }
}
