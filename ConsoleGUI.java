package com.example.calculator.Calculator;

import java.util.Scanner;

public class ConsoleGUI implements CalcGUIInterface {
    private int diametr;
    private int length;
    private int weight;
    private int input;
    private boolean flag;
    private int density;

    public int getInput() {
        return input;
    }

    public boolean isFlag() {
        return flag;
    }

    public int getDiametr() {
        return diametr;
    }

    public int getWeight() {
        return weight;
    }

    public int getLength() {
        return length;
    }
    public int getDensity() {
        return density;
    }

    public void putDensity(int num) {
        if (num == 1) density = 7850;
        if (num == 2) density = 8960;
        if (num == 3) density = 4540;
        if (num == 4) density = 8600;
        if (num == 5) density = 11340;
        if (num == 6) density = 19300;
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        length = 0;
        weight = 0;
        flag = false;
        while (input < 1 || input > 6) {
            System.out.println("Выберите материал:\n1.Углеродистая сталь\n 2. Медь\n3. Титан\n4.Латунь\n5.Свинец\n 6.Золото");
            input = sc.nextInt();
            putDensity(input);
        }
        System.out.println("Расчитать: \n 1. Вес \n 2. Длина");
        input = sc.nextInt();
        if (input == 1) {
            flag = true;
            System.out.println("Введите длину, м");
            length = sc.nextInt();
        }
        if (input == 2) {
            flag = false;
            System.out.println("Введите вес, кг: ");
            weight = sc.nextInt();
        }

        System.out.println("Выберите сортамент");
        System.out.println("1. Арматура\n 2. Труба круглая\n3.Труба профильная\n4. Уголок\n5. Лист\n6. Шестигранник");
        input = sc.nextInt();
    }
}
