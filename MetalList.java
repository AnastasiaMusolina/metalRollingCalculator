package com.example.calculator.Calculator;

public class MetalList extends Pipe{
    private double width;
    private double shirina;
    private int numberOfList;
    public MetalList(double den, double len, double weight, double width, double w, int number) {
        super(den, len, weight);
        this.width=width;
        this.shirina =w;
        this.numberOfList=number;
    }

    public double calculationWeight() {
        double res;
        res=density*0.001*width*0.001* shirina *0.001*len*numberOfList;
        return res;
    }

    public double calculationLength() {
        double res;
        res = weight / (1000*(numberOfList*density*0.001*width*0.001* shirina));
        return res;
    }
}
