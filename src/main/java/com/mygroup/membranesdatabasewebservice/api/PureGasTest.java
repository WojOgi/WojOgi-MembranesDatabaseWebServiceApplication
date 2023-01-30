package com.mygroup.membranesdatabasewebservice.api;

public class PureGasTest {

    private int pureGasTestId;
    private double feedPressure;
    private double h2Permeance;
    private double o2Permeance;
    private double n2Permeance;
    private double ch4Permeance;
    private double co2Permeance;

    public PureGasTest(int pureGasTestId, double feedPressure, double h2Permeance, double o2Permeance, double n2Permeance, double ch4Permeance, double co2Permeance) {
        this.pureGasTestId = pureGasTestId;
        this.feedPressure = feedPressure;
        this.h2Permeance = h2Permeance;
        this.o2Permeance = o2Permeance;
        this.n2Permeance = n2Permeance;
        this.ch4Permeance = ch4Permeance;
        this.co2Permeance = co2Permeance;
    }

    public int getPureGasTestId() {
        return pureGasTestId;
    }

    public void setPureGasTestId(int pureGasTestId) {
        this.pureGasTestId = pureGasTestId;
    }

    public double getFeedPressure() {
        return feedPressure;
    }

    public void setFeedPressure(double feedPressure) {
        this.feedPressure = feedPressure;
    }

    public double getH2Permeance() {
        return h2Permeance;
    }

    public void setH2Permeance(double h2Permeance) {
        this.h2Permeance = h2Permeance;
    }

    public double getO2Permeance() {
        return o2Permeance;
    }

    public void setO2Permeance(double o2Permeance) {
        this.o2Permeance = o2Permeance;
    }

    public double getN2Permeance() {
        return n2Permeance;
    }

    public void setN2Permeance(double n2Permeance) {
        this.n2Permeance = n2Permeance;
    }

    public double getCh4Permeance() {
        return ch4Permeance;
    }

    public void setCh4Permeance(double ch4Permeance) {
        this.ch4Permeance = ch4Permeance;
    }

    public double getCo2Permeance() {
        return co2Permeance;
    }

    public void setCo2Permeance(double co2Permeance) {
        this.co2Permeance = co2Permeance;
    }

    @Override
    public String toString() {
        return "PureGasTest{" +
                "pureGasTestId=" + pureGasTestId +
                ", feedPressure=" + feedPressure +
                ", h2Permeance=" + h2Permeance +
                ", o2Permeance=" + o2Permeance +
                ", n2Permeance=" + n2Permeance +
                ", ch4Permeance=" + ch4Permeance +
                ", co2Permeance=" + co2Permeance +
                '}';
    }
}
