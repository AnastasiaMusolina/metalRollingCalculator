package com.example.calculator.Calculator;

abstract public class Pipe {
    protected double len;
    protected double weight;
    protected double density;

    Pipe(double density,double len, double weight) {
        this.density=density;
        this.len = len;
        this.weight=weight;
    }
    public abstract double calculationWeight();

    public abstract double calculationLength();




}
