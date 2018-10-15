/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.eng.core.util;

import com.me.eng.core.application.ResourceLocator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Artur Tomasi
 */
public class ImageProvider 
{
    private static Map<Integer, File> _img = new HashMap();
    
    static 
    {
        try
        {
            File ip1 = ResourceLocator.getResourceAsFile( "/img/01.jpg" );
            File ip2 = ResourceLocator.getResourceAsFile( "/img/02.jpg" );
            File ip3 = ResourceLocator.getResourceAsFile( "/img/05.jpg" );
            File ip4 = ResourceLocator.getResourceAsFile( "/img/07.jpg" );
            File ip5 = ResourceLocator.getResourceAsFile( "/img/09.jpg" );
            File ip6 = ResourceLocator.getResourceAsFile( "/img/06.jpg" );
            File ip8 = ResourceLocator.getResourceAsFile( "/img/08.jpg" );
            File ip9 = ResourceLocator.getResourceAsFile( "/img/10.jpg" );
            File ip10 = ResourceLocator.getResourceAsFile("/img/03.jpg" );
            
            _img.put( 1,  ip1 );
            _img.put( 2,  ip2 );
            _img.put( 3,  ip3 );
            _img.put( 4,  ip4 );
            _img.put( 5,  ip5 );
            _img.put( 6,  ip6 );
            _img.put( 7,  ip5 );
            _img.put( 8,  ip8 );
            _img.put( 9,  ip9 );
            _img.put(10,  ip10 );
        }
     
        catch ( Exception e )
        {
            e.printStackTrace( System.err );
        }
    }
    
    /**
     * getStream
     * 
     * @param idx int
     * @return InputStream
     */
    public static InputStream getStream( int idx ) {
        try{
            return new FileInputStream( _img.get( idx ) ); 
        }
        catch ( FileNotFoundException e ){
            e.printStackTrace( System.err );
            return null;
        }
    }
    
    /**
     * getLength
     * 
     * @param idx int
     * @return long
     */
    public static long getLength( int idx ) {
        return _img.get( idx ).length();
    }
}
