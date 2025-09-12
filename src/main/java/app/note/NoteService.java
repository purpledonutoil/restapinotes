package app.note;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> getUserNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Long noteId) {
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new RuntimeException("Note not found"));
    }

    public Note updateNote(Long noteId, Note updatedNote) {
        Note existingNote = getNoteById(noteId);
        existingNote.setTitle(updatedNote.getTitle());
        existingNote.setContent(updatedNote.getContent());
        return noteRepository.save(existingNote);
    }

    public void deleteNote(Long noteId) {
        Note note = getNoteById(noteId);
        noteRepository.delete(note);
    }
}
