/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zetcode.controller;

import com.zetcode.bean.Country;
import com.zetcode.service.ICountryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author 6030213005
 */

@RestController
public class MyController {
    
    @Autowired
    private ICountryService countryService;
    
    @RequestMapping("/lab6")
    public List<Country> listAll(){
        return countryService.findAll();
    }
        @RequestMapping(value = "/lab6/country/{country}")
    public List<Country> listCoutries(@PathVariable("country") String country)
    {
        System.out.println(country);
        return countryService.findByCountry(country);
    }
    
        @RequestMapping("/lab6/continent/{continent}")
    public List<Country> listContinent(@PathVariable("continent") String continent){
        return countryService.findByContinent(continent);
    }
    
    
}
