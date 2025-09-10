package app.note.dto.delete;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class DeleteNoteResponse {
    private Error error;

    public enum Error {
        ok,
        insufficientPrivileges,
        invalidNoteId
    }

    public static DeleteNoteResponse success() {
        return builder().error(Error.ok).build();
    }

    public static DeleteNoteResponse failed(Error error) {
        return builder().error(error).build();
    }
}
