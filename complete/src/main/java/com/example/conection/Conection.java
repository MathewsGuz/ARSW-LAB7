/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.conection;

import java.io.IOException;

/**
 *
 * @author diana
 */
public interface Conection {
    public String getResult() throws IOException;
    public void connect(String hist, String id);
}