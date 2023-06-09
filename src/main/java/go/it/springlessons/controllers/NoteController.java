package go.it.springlessons.controllers;

import go.it.springlessons.entities.Note;
import go.it.springlessons.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String deleteNoteById(@RequestParam("id") Integer id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String editNoteForm(@RequestParam("id") Integer id, Model model) {
        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        return "edit";
    }

    @PostMapping("/edit")
    public String editNoteSubmit(@ModelAttribute Note note, @RequestParam("id") String id) {
        note.setId(Integer.parseInt(id));
        noteService.update(note);
        return "redirect:/note/list";
    }

    @GetMapping("/add")
    public String addNoteForm(Model model) {
        model.addAttribute("note", new Note());
        return "add";
    }

    @PostMapping("/add")
    public String addNote(@ModelAttribute Note note) {
        noteService.add(note);
        return "redirect:/note/list";
    }
}