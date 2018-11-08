/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.services.InfoServicesException;

/**
 *
 * @author diana
 */
public interface InformationServices {

    /**
     *
     * @param identifier
     * @return
     * @throws InfoServicesException
     */
    public Object getInfo(String hist, String identifier) throws InfoServicesException;
}