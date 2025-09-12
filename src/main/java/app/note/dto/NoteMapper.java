package app.note.dto;

import app.note.Note;

public class NoteMapper {
    public static Note toEntity(NoteRequestDto dto) {
        Note note = new Note();
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());
        return note;
    }

    public NoteResponseDto toDto(Note note) {
        NoteResponseDto dto = new NoteResponseDto();
        dto.setId(note.getId());
        dto.setTitle(note.getTitle());
        dto.setContent(note.getContent());
        return dto;
    }
}
