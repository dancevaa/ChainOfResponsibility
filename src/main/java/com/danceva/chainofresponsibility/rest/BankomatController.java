package com.danceva.chainofresponsibility.rest;


import com.danceva.chainofresponsibility.models.Money;
import com.danceva.chainofresponsibility.service.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class BankomatController {
    private final NoteModule noteModule5;
    private final NoteModule noteModule10;
    private final NoteModule noteModule20;
    private final NoteModule noteModule50;
    private final NoteModule noteModule100;


    BankomatController (NoteModule5 noteModule5, NoteModule10 noteModule10,
                        NoteModule20 noteModule20, NoteModule50 noteModule50,
                        NoteModule100 noteModule100){
        this.noteModule5 = noteModule5;
        this.noteModule10 = noteModule10;
        this.noteModule20 = noteModule20;
        this.noteModule50 = noteModule50;
        this.noteModule100 = noteModule100;
    }

    @GetMapping("/take_money/{amt}")
    public String takeMoney(@PathVariable int amt){
        noteModule100.setNext(noteModule50);
        noteModule50.setNext(noteModule20);
        noteModule20.setNext(noteModule10);
        noteModule10.setNext(noteModule5);
        noteModule100.takeMoney(new Money(amt));
        return "Выдано " + amt + " денег";
    }

}
