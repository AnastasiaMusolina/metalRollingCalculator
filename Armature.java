package com.example.calculator.Calculator;
public class Armature extends Pipe {
private double dim;
    public Armature(double den, double len, double weight,double dim) {
        super( den,len, weight);
        this.dim=dim;
    }

    @Override
    public double calculationWeight() {
        double res;
        res = density * 0.000001 * Math.pow(dim, 2) * Math.PI / 4 * len;
        return res;
    }

    @Override
    public double calculationLength() {
        double res;
        res = 4 * weight / (Math.pow(0.001 * dim, 2) * Math.PI * density);
        return res;
    }

}
