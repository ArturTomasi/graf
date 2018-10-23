/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.eng.core.util;

import com.me.eng.core.application.ApplicationContext;
import com.me.eng.core.data.StatmentData;
import com.me.eng.db.Base;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Artur Tomasi
 */
public class RequestController 
{
    /**
     * doRequest
     * 
     * @param data StatmentData
     * @param base Base
     */
    public static void doRequest( StatmentData data, Base base )
    {
        try
        {
            LogUtilities.getInstance().write( " http..."  );
    
            HttpURLConnection con = (HttpURLConnection) new URL( base.host() + ":" + base.port() ).openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0" );
            con.setConnectTimeout( data.getTimeout() * 1000 );
            
            con.getResponseCode();
        }
        
        catch ( IOException e )
        {
            ApplicationContext.getInstance().logException( e );
        }
    }
}
