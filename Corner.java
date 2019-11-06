package com.example.calculator.Calculator;
public class Corner extends Pipe {
    private double height;
    private double width;
    private double shirina;
    public Corner(double den, double len, double weight,double height,double width,double shirina) {
        super( den,len, weight);
        this.height=height;
        this.width=width;
        this.shirina=shirina;
    }

    public double calculationWeight() {
        double res;
        res=((0.001* shirina+0.001*height-0.001*width)*0.001*width*density)*len;
        return res;
    }

    public double calculationLength() {
        double res;
        res = weight / (density*0.001*width*(0.001*height+0.001*shirina-0.001*width));
        return res;
    }

}
