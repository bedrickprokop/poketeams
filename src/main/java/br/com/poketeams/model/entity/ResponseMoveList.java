package br.com.poketeams.model.entity;

import java.util.List;

public class ResponseMoveList {

    private Long count;
    private List<Move> results;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<Move> getResults() {
        return results;
    }

    public void setResults(List<Move> results) {
        this.results = results;
    }
}
