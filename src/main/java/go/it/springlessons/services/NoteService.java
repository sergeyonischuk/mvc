package go.it.springlessons.services;

import go.it.springlessons.entities.Note;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
    private Map<Long, Note> noteList = new HashMap<>();

    @PostConstruct
    public void addTestNotes(){
        Note note = new Note("Dragons and fairies", "dragons are big, fairies are small");
        Note note1 = new Note("Blablabla", "asdasdasd");
        Note note2 = new Note("humanitarians and technicians", "who is cooler?");

        noteList.put(1L, note);
        noteList.put(2L, note1);
        noteList.put(3L, note2);

        System.out.println("test noteList created with " + noteList.size() + " notes");
    }

    public List<Note> listAll() {
        return new ArrayList<>(noteList.values());
    }

    public Note add(Note note) {
        Long id = new Random().nextLong();
        while (noteList.containsKey(id)) {
            id = new Random().nextLong();
        }
        note.setId(id);
        noteList.put(id, note);
        return note;
    }

    public void deleteById(Long id) {
        if (!noteList.containsKey(id)) {
            throw new IllegalArgumentException("Note with id " + id + " does not exist.");
        }
        Note note = noteList.get(id);
        noteList.remove(id, note);
    }

    public void update(Note note) {
        if (!noteList.containsValue(note)) {
            throw new IllegalArgumentException("Note with id " + note.getId() + " does not exist.");
        }
        noteList.get(note.getId()).setTittle(note.getTittle());
        noteList.get(note.getId()).setContent(note.getContent());
    }

    public Note getById(Long id) {
        if (!noteList.containsKey(id)) {
            throw new IllegalArgumentException("Note with id " + id + " does not exist.");
        }
        return noteList.get(id);
    }
}
