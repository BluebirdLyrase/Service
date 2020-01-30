/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zetcode.bean;

/**
 *
 * @author 6030213005
 */
public class Country {
    
    private String name;
    private int population;
    private String Continents;

    public Country(String name, int population, String Continents) {
        this.name = name;
        this.population = population;
        this.Continents = Continents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getContinents() {
        return Continents;
    }

    public void setContinents(String Continents) {
        this.Continents = Continents;
    }


    

    
}
