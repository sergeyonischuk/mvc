package go.it.springlessons.services;

import go.it.springlessons.entities.Note;
import go.it.springlessons.repositories.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class NoteService {
    private final NoteRepository repository;

    public List<Note> listAll() {
        return repository.findAll();
    }

    public Note add(Note note) {
        repository.save(note);
        return note;
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public void update(Note note) {
        repository.save(note);
    }

    public Note getById(Integer id) {
        Optional<Note> note = repository.findById(id);
        return note.orElseThrow(IllegalArgumentException::new);
    }
}
