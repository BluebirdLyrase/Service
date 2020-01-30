/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zetcode.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.zetcode.bean.Country;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author 6030213005
 */

    
    
    @Service
    public class CountryService implements ICountryService {
        
        private final ArrayList<Country> countries;

    public CountryService() {
        countries = new ArrayList();
    }
    
    @Override
        public ArrayList<Country> findAll(){
            FileInputStream fis = null;
            countries.clear();
            
            try{
            String filename = "src/main/resources/countries.csv";
            
            fis = new FileInputStream(new File(filename));
            CSVReader reader = new CSVReader(new InputStreamReader(fis));
            String[] nextLine;
            reader.readNext();
            while((nextLine = reader.readNext()) != null){
            
                Country newCountry = new Country(nextLine[0],Integer.valueOf(nextLine[1]),nextLine[2]);
                countries.add(newCountry);
            }
            }catch(FileNotFoundException ex){
                    Logger.getLogger(CountryService.class.getName()).log(Level.SEVERE, null, ex);
            }catch(IOException ex){
                     Logger.getLogger(CountryService.class.getName()).log(Level.SEVERE, null, ex);     
            } catch (CsvValidationException ex) {
                Logger.getLogger(CountryService.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                    try {
                        if (fis != null){
                            fis.close();
                            }
                        }catch(IOException ex){
                            Logger.getLogger(CountryService.class.getName()).log(Level.SEVERE, null, ex);     
                    }
                    }
           return countries;         
        }

    @Override
    public ArrayList<Country> findByCountry(String country) {
            String search = country;
            FileInputStream fis = null;
            countries.clear();
            try{
            String filename = "src/main/resources/countries.csv";
            
            fis = new FileInputStream(new File(filename));
            CSVReader reader = new CSVReader(new InputStreamReader(fis));
            String[] nextLine;
            reader.readNext();
            while((nextLine = reader.readNext()) != null){
                if(nextLine[0].equals(search)){
                Country newCountry = new Country(nextLine[0],Integer.valueOf(nextLine[1]),nextLine[2]);
                countries.add(newCountry); 
                }  
            }
            }catch(FileNotFoundException ex){
                    Logger.getLogger(CountryService.class.getName()).log(Level.SEVERE, null, ex);
            }catch(IOException ex){
                     Logger.getLogger(CountryService.class.getName()).log(Level.SEVERE, null, ex);     
            } catch (CsvValidationException ex) {
                Logger.getLogger(CountryService.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                    try {
                        if (fis != null){
                            fis.close();
                            }
                        }catch(IOException ex){
                            Logger.getLogger(CountryService.class.getName()).log(Level.SEVERE, null, ex);     
                    }
                    }
           return countries;   
    }

    @Override
    public ArrayList<Country> findByContinent(String continent) {
            String search = continent;
            FileInputStream fis = null;
            countries.clear();
            try{
            String filename = "src/main/resources/countries.csv";
            
            fis = new FileInputStream(new File(filename));
            CSVReader reader = new CSVReader(new InputStreamReader(fis));
            String[] nextLine;
            reader.readNext();
            while((nextLine = reader.readNext()) != null){
                if(nextLine[2].equals(search)){
                Country newCountry = new Country(nextLine[0],Integer.valueOf(nextLine[1]),nextLine[2]);
                countries.add(newCountry); 
                }  
            }
            }catch(FileNotFoundException ex){
                    Logger.getLogger(CountryService.class.getName()).log(Level.SEVERE, null, ex);
            }catch(IOException ex){
                     Logger.getLogger(CountryService.class.getName()).log(Level.SEVERE, null, ex);     
            } catch (CsvValidationException ex) {
                Logger.getLogger(CountryService.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                    try {
                        if (fis != null){
                            fis.close();
                            }
                        }catch(IOException ex){
                            Logger.getLogger(CountryService.class.getName()).log(Level.SEVERE, null, ex);     
                    }
                    }
           return countries;   
    
    }
        
        
        
        
        
    }
    
    

