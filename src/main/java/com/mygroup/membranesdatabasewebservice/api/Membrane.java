package com.mygroup.membranesdatabasewebservice.api;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Membrane {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String polymerPrecursor;
    private int pyrolysisTemperature;
    private String solvent;
    private double solutionConcentrationWtPerc;

   // private PureGasTest pureGasTest;
   // private MixedGasTest mixedGasTest;

    public Membrane() {
    }

    public Membrane(int id, String polymerPrecursor, int pyrolysisTemperature, String solvent, double solutionConcentrationWtPerc, PureGasTest pureGasTest, MixedGasTest mixedGasTest) {
        this.id = id;
        this.polymerPrecursor = polymerPrecursor;
        this.pyrolysisTemperature = pyrolysisTemperature;
        this.solvent = solvent;
        this.solutionConcentrationWtPerc = solutionConcentrationWtPerc;
       // this.pureGasTest = pureGasTest;
       // this.mixedGasTest = mixedGasTest;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public String toString() {
        return "Membrane{" +
                "id=" + id +
                ", polymerPrecursor='" + polymerPrecursor + '\'' +
                ", pyrolysisTemperature=" + pyrolysisTemperature +
                ", solvent='" + solvent + '\'' +
                ", solutionConcentrationWtPerc=" + solutionConcentrationWtPerc +
                 '}';
    }
}
