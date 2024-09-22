package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import net.engineeringdigest.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;

    @GetMapping("/{userName}")
    public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String userName) {
        User user = userService.findByUserName(userName);
        List<JournalEntry> all = user.getJournalEntries();
        if(all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{userName}")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry, @PathVariable String userName) {
        try {
//            User user = userService.findByUserName(userName);
            myEntry.setDate(LocalDateTime.now());
            journalEntryService.saveEntry(myEntry, userName);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getJournalEntryByID(@PathVariable ObjectId myId) {
        Optional<JournalEntry> jEntry = journalEntryService.findById(myId);
        if(jEntry.isPresent()) {
            return new ResponseEntity<> (jEntry.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("id/{userName}/{myId}")
    public ResponseEntity<?> deleteEntryByID(@PathVariable ObjectId myId, @PathVariable String userName) {
        journalEntryService.deleteById(myId, userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{userName}/{myId}")
    public JournalEntry updateEntryByID(@PathVariable ObjectId myId, @RequestBody JournalEntry newEntry, @PathVariable String userName) {
        JournalEntry currEntry = journalEntryService.findById(myId).orElse(null);
        if(currEntry != null) {
            currEntry.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : currEntry.getTitle());
            currEntry.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : currEntry.getContent());
        }
        journalEntryService.saveEntry(currEntry);
        return currEntry;
    }

}
