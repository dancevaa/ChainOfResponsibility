package com.danceva.chainofresponsibility.service;

import com.danceva.chainofresponsibility.models.Money;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public abstract class NoteModule {
    protected NoteModule next;
    public abstract void takeMoney(Money money);
}
