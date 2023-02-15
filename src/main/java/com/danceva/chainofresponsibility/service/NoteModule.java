package com.danceva.chainofresponsibility.models;

import lombok.Data;

@Data
public abstract class NoteModule {
    protected NoteModule next;
    protected abstract void takeMoney(Money money);
}
