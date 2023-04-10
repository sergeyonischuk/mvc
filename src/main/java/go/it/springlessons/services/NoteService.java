package go.it.springlessons.services;

import go.it.springlessons.entities.Note;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
    private Map<Integer, Note> noteList = new HashMap<>();

    @PostConstruct
    public void addTestNotes(){
        Note note = new Note("Dragons and fairies", "not boring fantasy");
        Note note1 = new Note("Blablabla", "blabla");
        Note note2 = new Note("humanitarians and technicians", "who is cooler?");
        Note note3 = new Note("History for newbies", "Why the Middle ages are not so cool");

        add(note);
        add(note1);
        add(note2);
        add(note3);
    }

    public List<Note> listAll() {
        return new ArrayList<>(noteList.values());
    }

    public Note add(Note note) {
        Integer id = new Random().nextInt();
        while (noteList.containsKey(id)) {
            id = new Random().nextInt();
        }
        note.setId(id);
        noteList.put(id, note);
        return note;
    }

    public void deleteById(Integer id) {
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
        noteList.get(note.getId()).setTitle(note.getTitle());
        noteList.get(note.getId()).setContent(note.getContent());
    }

    public Note getById(Integer id) {
        if (!noteList.containsKey(id)) {
            throw new IllegalArgumentException("Note with id " + id + " does not exist.");
        }
        return noteList.get(id);
    }
}
