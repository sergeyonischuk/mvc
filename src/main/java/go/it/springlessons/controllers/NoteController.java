package go.it.springlessons.controllers;

import go.it.springlessons.entities.Note;
import go.it.springlessons.services.NoteService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping("/note/list")
    public String getNoteList(Model model) {
        List<Note> notes = noteService.listAll();
        return "notelist";
    }

}
