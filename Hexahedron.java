package com.example.calculator.Calculator;

public class Hexahedron extends Pipe {
    private double numberOfHexahedron;
    public Hexahedron(double den, double len, double weight, double numberOfHexahedron) {
        super(den, len, weight);
        this.numberOfHexahedron=numberOfHexahedron;
    }

    public double calculationWeight() {
        double res;
        res=density/2*Math.sqrt(3)*Math.pow(0.001*numberOfHexahedron,2)*len;
        return res;
    }

    public double calculationLength() {
        double res;
        res = weight / (density/2*Math.sqrt(3)*Math.pow(0.001*numberOfHexahedron,2));
        return res;
    }
}
