/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.eng.core.util;

import com.me.eng.core.application.ApplicationContext;
import com.me.eng.core.data.StatmentData;
import com.me.eng.db.Base;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author artur
 */
public class ApacheAbController {
    
    /**
     * doRequest
     * 
     * @param data StatmentData
     * @param base Base
     */
    public static void doRequest( StatmentData data, Base base )
    {
        try {
            
            LogUtilities.getInstance().write( -1, "Requisitando " + base.host() + ":" + base.port() );
            
            ProcessBuilder builder = new ProcessBuilder( "ab", 
                                                        "-n", String.valueOf( data.getPaginas() * data.getUser() ), 
                                                        "-c", String.valueOf( "50" ), 
                                                        "-k", base.host() + ":" + base.port() + "/" );
            
            builder.redirectErrorStream( true );
            
            BufferedReader input = new BufferedReader(new InputStreamReader(builder.start().getInputStream()));
            String line, lines = "\n"; 
            try {
                while ((line = input.readLine()) != null) {
                    lines += line + System.lineSeparator();
                }
                
                LogUtilities.getInstance().write( -1, lines );
                
            } catch (IOException e) {
                LogUtilities.getInstance().write( -1, "ERROR: " + e.getMessage() );
            }
        }
        
        catch ( Exception e )
        {
            try
            {
                LogUtilities.getInstance().write( -1, "ERROR: " + e.getMessage() );
            } catch ( Exception ex ) {
                ApplicationContext.getInstance().logException( ex );
            }
        }
    }
}
