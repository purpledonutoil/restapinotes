package app.note.dto.update;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateNoteRequest {
    private long id;
    private String title;
    private String content;
}

