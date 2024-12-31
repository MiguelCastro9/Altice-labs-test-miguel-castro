package dev.miguel.model;

import java.util.List;

public class LabSeq {

    private Long result;

    private String time;

    private List<Long> sequence;

    public LabSeq() {
    }

    public LabSeq(Long result, List<Long> sequence, String time) {
        this.result = result;
        this.sequence = sequence;
        this.time = time;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }

    public List<Long> getSequence() {
        return sequence;
    }

    public void setSequence(List<Long> sequence) {
        this.sequence = sequence;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

