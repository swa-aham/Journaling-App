package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll() {
        return null;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryByID(@PathVariable Long myId) {
        return null;
    }

    @PostMapping
    public Boolean createEntry(@RequestBody JournalEntry myEntry) {
        journalEntryService.saveEntry(myEntry);
        return true;
    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteEntryByID(@PathVariable Long myId) {
        return null;
    }

    @PutMapping("id/{myId}")
    public JournalEntry putEntryByID(@PathVariable Long myId, @RequestBody JournalEntry myEntry) {
        return null;
    }

}
