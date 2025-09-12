package app.note;

import app.note.dto.NoteMapper;
import app.note.dto.NoteRequestDto;
import app.note.dto.NoteResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;
    private final NoteMapper noteMapper;

    @PostMapping("/add")
    public NoteResponseDto create(@RequestBody NoteRequestDto requestDto) {
        Note note = noteMapper.toEntity(requestDto);
        Note saved = noteService.createNote(note);
        return noteMapper.toDto(saved);
    }

    @GetMapping("/list")
    public List<NoteResponseDto> getUserNotes() {
        List<Note> notes = noteService.getUserNotes();
        return notes.stream()
                .map(noteMapper::toDto)
                .toList();
    }

    @PatchMapping("/edit")
    public NoteResponseDto update(@PathVariable Long id, @RequestBody NoteRequestDto requestDto) {
        Note updatedNote = noteMapper.toEntity(requestDto);
        Note saved = noteService.updateNote(id, updatedNote);
        return noteMapper.toDto(saved);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable Long id) {
        noteService.deleteNote(id);
    }
}

