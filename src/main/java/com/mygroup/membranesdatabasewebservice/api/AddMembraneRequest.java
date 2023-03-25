package com.mygroup.membranesdatabasewebservice.api;

import java.util.Objects;

public class AddMembraneRequest {
    private String polymerPrecursor;
    private int pyrolysisTemperature;
    private String solvent;
    private double solutionConcentrationWtPerc;

    public AddMembraneRequest() {
    }

    public String getPolymerPrecursor() {
        return polymerPrecursor;
    }

    public void setPolymerPrecursor(String polymerPrecursor) {
        this.polymerPrecursor = polymerPrecursor;
    }

    public int getPyrolysisTemperature() {
        return pyrolysisTemperature;
    }

    public void setPyrolysisTemperature(int pyrolysisTemperature) {
        this.pyrolysisTemperature = pyrolysisTemperature;
    }

    public String getSolvent() {
        return solvent;
    }

    public void setSolvent(String solvent) {
        this.solvent = solvent;
    }

    public double getSolutionConcentrationWtPerc() {
        return solutionConcentrationWtPerc;
    }

    public void setSolutionConcentrationWtPerc(double solutionConcentrationWtPerc) {
        this.solutionConcentrationWtPerc = solutionConcentrationWtPerc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddMembraneRequest that = (AddMembraneRequest) o;
        return pyrolysisTemperature == that.pyrolysisTemperature && Objects.equals(polymerPrecursor, that.polymerPrecursor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(polymerPrecursor, pyrolysisTemperature);
    }

    @Override
    public String toString() {
        return "AddMembraneRequest{" +
                "polymerPrecursor='" + polymerPrecursor + '\'' +
                ", pyrolysisTemperature=" + pyrolysisTemperature +
                '}';
    }
}
