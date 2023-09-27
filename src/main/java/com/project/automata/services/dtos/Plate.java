package com.project.automata.services.dtos;


import java.util.List;

public class Plate {

    private String plate;

    private Boolean status;

    private List<String> states;

    public String getPlate() {
        return plate;
    }

    public Boolean getStatus() {
        return status;
    }

    public List<String> getStates() {
        return states;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setStates(List<String> state) {
        this.states = state;
    }

}