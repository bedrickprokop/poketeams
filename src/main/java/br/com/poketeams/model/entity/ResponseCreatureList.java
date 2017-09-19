package br.com.poketeams.model.entity;

import java.util.List;

public class ResponseCreatureList {

    private Long count;
    private List<Creature> results;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<Creature> getResults() {
        return results;
    }

    public void setResults(List<Creature> results) {
        this.results = results;
    }
}
