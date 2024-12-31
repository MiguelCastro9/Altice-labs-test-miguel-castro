package dev.miguel.service;

import dev.miguel.model.LabSeq;

public interface LabSeqService {

    public LabSeq labSeq(Integer n) throws IllegalArgumentException;
}
