package com.danceva.chainofresponsibility.service;

import com.danceva.chainofresponsibility.models.Money;
import com.danceva.chainofresponsibility.repository.Note;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NoteModule50 extends NoteModule{
    public void takeMoney(Money money){
        int countNote = money.getAmt()/ Note.R50;
        int reminder = money.getAmt()%Note.R50;
        if(countNote>0){
            log.info("received " + countNote + " banknotes with a face value of " + Note.R50);
        }
        if(reminder>0 && next!= null){
            next.takeMoney(new Money(reminder));
        }
    }
}
