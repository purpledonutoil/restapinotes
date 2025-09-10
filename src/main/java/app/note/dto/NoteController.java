package app.note.dto;

import app.note.NoteService;
import app.note.dto.create.CreateNoteRequest;
import app.note.dto.create.CreateNoteResponse;
import app.note.dto.delete.DeleteNoteResponse;
import app.note.dto.get.GetUserNotesResponse;
import app.note.dto.update.UpdateNoteRequest;
import app.note.dto.update.UpdateNoteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;

    @PostMapping("/add")
    public CreateNoteResponse create(@RequestBody CreateNoteRequest request) {
        return noteService.create(request);
    }

    @GetMapping("/list")
    public GetUserNotesResponse getUserNotes() {
        return noteService.getUserNotes();
    }

    @PatchMapping("/edit")
    public UpdateNoteResponse update(@RequestBody UpdateNoteRequest request) {
        return noteService.update(request);
    }

    @DeleteMapping("/delete")
    public DeleteNoteResponse delete(@RequestParam(name = "id") long id) {
        return noteService.delete(id);
    }
}

