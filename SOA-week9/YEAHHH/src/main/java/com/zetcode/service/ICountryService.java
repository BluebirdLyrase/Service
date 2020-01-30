/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zetcode.service;

import com.zetcode.bean.Country;
import java.util.ArrayList;

/**
 *
 * @author 6030213005
 */
public interface ICountryService {
    
    public ArrayList<Country> findAll();
    public ArrayList<Country> findByCountry(String country);
    public ArrayList<Country> findByContinent(String continent);
    
}
