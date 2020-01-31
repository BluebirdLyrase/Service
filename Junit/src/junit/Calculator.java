/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junit;

/**
 *
 * @author STD-PC
 */
public class Calculator {

    private double result;

    public double add(double num1, double num2) {
        result = num1 + num2;
        return result;
    }

    public double minus(double num1, double num2) {
        result = num1 - num2;
        return result;
    }

    public double divide(double num1, double num2) {
        result = num1 / num2;
        return result;
    }

    public double module(double num1, double num2) {
        result = num1%num2;
        return result;
    }

    public double multiply(double num1, double num2) {
        result = num1 * num2;
        return result;
    }

}
