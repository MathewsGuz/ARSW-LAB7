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
@Service
public class AlphaVantage implements Provider{

    @Override
    public String getUrl(String hist, String id) {
        String function="";
        if ("Intra-dia".equals(hist)){
            function="TIME_SERIES_INTRADAY";
        }else if("Diaria".equals(hist)){
            function="TIME_SERIES_DAILY";
        }else if("Semanal".equals(hist)){
            function="TIME_SERIES_WEEKLY";
        }else{
            function="TIME_SERIES_MONTHLY";
        }
        return "https://www.alphavantage.co/query?function="+function+"&symbol="+id+"&interval=5min&apikey=1TUCGHH88Q5TZ51H";
                
    }
    
}
