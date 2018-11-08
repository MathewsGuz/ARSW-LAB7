/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restcontrollers;

import com.example.services.InformationServices;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2108310
 */

@RestController
@RequestMapping(value = "/info")
@Service
public class StockExchangeAPIController {
    @Autowired
    InformationServices infoServices;
    
    @RequestMapping(method = RequestMethod.GET,value="/{hist}/{identifier}")
    public ResponseEntity<?> getOrders(@PathVariable("hist") String hist, @PathVariable("identifier") String identifier){
        try{
            return new ResponseEntity<>(infoServices.getInfo(hist,identifier),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(StockExchangeAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
        }
    }
}
