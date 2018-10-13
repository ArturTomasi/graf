/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.eng.core.util;

import com.me.eng.core.application.ResourceLocator;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Artur Tomasi
 */
public class ImageProvider 
{
    public final static Map<Integer, InputStream> IMG = new HashMap();
    
    static 
    {
        try
        {
            InputStream ip1 = ResourceLocator.getResourceAsStream( "/img/01.jpg" );
            InputStream ip2 = ResourceLocator.getResourceAsStream( "/img/02.jpg" );
            InputStream ip3 = ResourceLocator.getResourceAsStream( "/img/05.jpg" );
            InputStream ip4 = ResourceLocator.getResourceAsStream( "/img/07.jpg" );
            InputStream ip5 = ResourceLocator.getResourceAsStream( "/img/09.jpg" );
            InputStream ip6 = ResourceLocator.getResourceAsStream( "/img/06.jpg" );
            InputStream ip8 = ResourceLocator.getResourceAsStream( "/img/08.jpg" );
            InputStream ip9 = ResourceLocator.getResourceAsStream( "/img/10.jpg" );
            InputStream ip10 = ResourceLocator.getResourceAsStream( "/img/03.jpg" );
            
            IMG.put( 1,  ip1 );
            IMG.put( 2,  ip2 );
            IMG.put( 3,  ip3 );
            IMG.put( 4,  ip4 );
            IMG.put( 5,  ip5 );
            IMG.put( 6,  ip6 );
            IMG.put( 7,  ip5 );
            IMG.put( 8,  ip8 );
            IMG.put( 9,  ip9 );
            IMG.put(10,  ip10 );
        }
     
        catch ( Exception e )
        {
            e.printStackTrace( System.err );
        }
    }
}
