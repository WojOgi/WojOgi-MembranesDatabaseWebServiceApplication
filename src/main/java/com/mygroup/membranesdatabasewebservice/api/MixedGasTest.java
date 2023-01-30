package com.mygroup.membranesdatabasewebservice.api;

public class MixedGasTest {

    private int mixGasTestId;
    private double feedPressure;
    private String component1;
    private String component2;
    private double feedComposition;
    private double permeateComposition;

    public MixedGasTest(int mixGasTestId, double feedPressure, String component1, String component2, double feedComposition, double permeateComposition) {
        this.mixGasTestId = mixGasTestId;
        this.feedPressure = feedPressure;
        this.component1 = component1;
        this.component2 = component2;
        this.feedComposition = feedComposition;
        this.permeateComposition = permeateComposition;
    }

    public int getMixGasTestId() {
        return mixGasTestId;
    }

    public void setMixGasTestId(int mixGasTestId) {
        this.mixGasTestId = mixGasTestId;
    }

    public double getFeedPressure() {
        return feedPressure;
    }

    public void setFeedPressure(double feedPressure) {
        this.feedPressure = feedPressure;
    }

    public String getComponent1() {
        return component1;
    }

    public void setComponent1(String component1) {
        this.component1 = component1;
    }

    public String getComponent2() {
        return component2;
    }

    public void setComponent2(String component2) {
        this.component2 = component2;
    }

    public double getFeedComposition() {
        return feedComposition;
    }

    public void setFeedComposition(double feedComposition) {
        this.feedComposition = feedComposition;
    }

    public double getPermeateComposition() {
        return permeateComposition;
    }

    public void setPermeateComposition(double permeateComposition) {
        this.permeateComposition = permeateComposition;
    }

    @Override
    public String toString() {
        return "MixedGasTest{" +
                "mixGasTestId=" + mixGasTestId +
                ", feedPressure=" + feedPressure +
                ", component1='" + component1 + '\'' +
                ", component2='" + component2 + '\'' +
                ", feedComposition=" + feedComposition +
                ", permeateComposition=" + permeateComposition +
                '}';
    }
}
