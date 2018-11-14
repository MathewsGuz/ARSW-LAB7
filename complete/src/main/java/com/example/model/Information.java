/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import org.springframework.data.annotation.Id;

/**
 *
 * @author Guzman
 */
public class Information {
    @Id
    public String identifier;
    public String result;

    public Information(String identifier, String result) {
        this.identifier = identifier;
        this.result = result;
    }

    
}
