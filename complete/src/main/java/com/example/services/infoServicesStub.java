/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.conection.HttpConnection;
import com.example.model.Information;
import com.example.model.InformationRepository;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 *
 * @author 
 */
@Service
public class infoServicesStub implements InformationServices,CommandLineRunner{
    @Autowired
    HttpConnection conection;
    @Autowired
    InformationRepository repo;
    
    @Override
    public String getInfo(String hist,String identifier) throws InfoServicesException {
        String answer="hola";
        conection.connect(hist, identifier);
        try {
            if(repo.findByIdentifier(identifier+hist)==null){
                conection.run();
                answer=conection.getResult();
                repo.save(new Information(identifier+hist,answer));
            }
            else{
                answer= repo.findByIdentifier(identifier+hist).result;
            }
            return answer;
        } catch (IOException ex) {
            Logger.getLogger(infoServicesStub.class.getName()).log(Level.SEVERE, null, ex);
            throw new InfoServicesException("ERROR CONECTANDO");
        }
        
    }
    @Override
    public void run(String... args){
        repo.deleteAll();
        System.out.println("Connected    ");
    }
    
}
