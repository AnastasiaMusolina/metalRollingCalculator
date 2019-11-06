package com.example.calculator.Calculator;

public class RoundPipe extends Pipe {
    private double width;
    private double dim;
    public RoundPipe(double den, double len, double weight,double dim,double width) {
        super(den, len, weight);
        this.width=width;
        this.dim=dim;
    }

    public double calculationWeight(){
        double res;
        res=Math.PI*density*0.001*width*(0.001*dim-0.001*width)*len;
        return res;
    }

    public double calculationLength(){
        double res;
        res=weight/(Math.PI*density*0.001*width*(0.001*dim-0.001*width));
        return res;
    }


}
