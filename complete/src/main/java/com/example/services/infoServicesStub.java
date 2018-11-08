/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.conection.Conection;
import com.example.conection.HttpConnection;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 
 */
@Service
public class infoServicesStub implements InformationServices{
    @Autowired
    HttpConnection conection;
    @Override
    public String getInfo(String hist,String identifier) throws InfoServicesException {
        conection.connect(hist, identifier);
        try {
            conection.run();
            return conection.getResult();
        } catch (IOException ex) {
            Logger.getLogger(infoServicesStub.class.getName()).log(Level.SEVERE, null, ex);
            throw new InfoServicesException("ERROR CONECTANDO");
        }
        
    }
    
}
