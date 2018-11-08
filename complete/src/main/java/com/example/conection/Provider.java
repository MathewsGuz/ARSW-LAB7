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
public interface Provider {
    public String getUrl(String hist, String id);
}
