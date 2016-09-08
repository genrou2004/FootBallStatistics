package com.football.springmvc.model;

import java.util.List;

public class SearchResult {

    private List<Player> results;
    private int totalResults;
    public SearchResult(){
    	
    	this.totalResults=0;
    }
    public SearchResult(List<Player> results, int totalResults) {
        this.results = results;
        this.totalResults = totalResults;
    }

    public List<Player> getResults() {
        return results;
    }

    public void setResults(List<Player> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

}
