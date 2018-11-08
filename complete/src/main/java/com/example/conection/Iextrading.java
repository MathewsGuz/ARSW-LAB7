/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.conection;

import org.springframework.stereotype.Service;

/**
 *
 * @author diana
 */
//@Service
public class Iextrading implements Provider{

    @Override
    public String getUrl(String hist, String id) {
        String function="";
        if ("Intra-dia".equals(hist)){
            function="1m";
        }else if("Diaria".equals(hist)){
            function="1d";
        }else if("Semanal".equals(hist)){
            function="3m";
        }else{
            function="1m";
        }
        return "https://api.iextrading.com/1.0/stock/"+id+"/chart/"+function;
                
    }
    
}
