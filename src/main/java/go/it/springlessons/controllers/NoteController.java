package go.it.springlessons.controllers;

import go.it.springlessons.entities.Note;
import go.it.springlessons.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/list")
    public String listNotes(Model model) {
        List<Note> notes = noteService.listAll();
        model.addAttribute("notes", notes);
        return "list";
    }

    @PostMapping("/delete")
    public String deleteNoteById(@RequestParam("id") Long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String editNoteById(@RequestParam("id") Long id, Model model) {
        Note note = noteService.getById(id);
        if (note != null) {
            model.addAttribute("note", note);
            return "note/edit";
        }
        return "redirect:/note/list";
    }

    @PostMapping("/edit")
    public String updateNoteById(@ModelAttribute("note") Note note) {
        noteService.add(note);
        return "redirect:/note/list";
    }

}
