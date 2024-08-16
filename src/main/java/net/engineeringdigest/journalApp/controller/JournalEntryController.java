package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll() {
        return new ArrayList<>(journalEntries.values());
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryByID(@PathVariable Long myId) {
        return journalEntries.get(myId);
    }

    @PostMapping
    public Boolean createEntry(@RequestBody JournalEntry myEntry) {
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteEntryByID(@PathVariable Long myId) {
        return journalEntries.remove(myId);
    }

    @PutMapping("id/{myId}")
    public JournalEntry putEntryByID(@PathVariable Long myId, @RequestBody JournalEntry myEntry) {
        return journalEntries.put(myId, myEntry);
    }

}
