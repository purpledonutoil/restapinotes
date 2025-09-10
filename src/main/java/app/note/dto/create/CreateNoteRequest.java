package app.note.dto.create;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateNoteRequest {
    private String title;
    private String content;
}
