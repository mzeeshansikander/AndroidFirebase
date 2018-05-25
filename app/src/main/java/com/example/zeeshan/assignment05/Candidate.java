package com.example.zeeshan.assignment05;

/**
 * Created by Zeeshan on 5/19/2018.
 */

public class Candidate {

    String candidateId;
    String candidateName;
    String candidatePosition;
    String memo;

    public Candidate(String candidateId, String candidateName, String candidatePosition, String memo) {
        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.candidatePosition = candidatePosition;
        this.memo = memo;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public String getCandidatePosition() {
        return candidatePosition;
    }

    public String getMemo() {
        return memo;
    }
}
