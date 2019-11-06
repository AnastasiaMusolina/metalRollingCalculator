package com.example.calculator.Calculator;
public class ProfilePipe extends Pipe {
    private double height;
    private double width;
    private double shirina;
    public ProfilePipe(double den, double len, double weight, double height, double width, double shirina) {
        super( den,len, weight);
        this.height=height;
        this.width=width;
        this.shirina=shirina;
    }

    public double calculationWeight() {
        double res;
        res = 2 * (0.001 * height + 0.001 * shirina) * 0.001 * width * density * len;
        return res;
    }

    public double calculationLength() {
        double res;
        res = weight / ((0.001 * height + 0.001 * shirina) * 2 * density * 0.001 * width);
        return res;
    }


}
