package com.mygroup.membranesdatabasewebservice.api;

public class MembraneResponse {
    //MembraneResponse can only reveal the polymer precursor
    //and pyrolysis temperature
    private String polymerPrecursorResponse;
    private int pyrolysisTemperatureResponse;

    public MembraneResponse(String polymerPrecursorResponse, int pyrolysisTemperature) {
        this.polymerPrecursorResponse = polymerPrecursorResponse;
        this.pyrolysisTemperatureResponse = pyrolysisTemperature;
    }

    public String getPolymerPrecursorResponse() {
        return polymerPrecursorResponse;
    }

    public int getPyrolysisTemperatureResponse() {
        return pyrolysisTemperatureResponse;
    }

    //tutaj beda pola jakie chcemy zwrocic
}
