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
import java.net.URL;
import javax.imageio.ImageIO;

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
            for ( int i = 1; i <= data.getQuantidade(); i ++ )
            {
                try
                {
                    LogUtilities.getInstance().write( i, "ciclo aberto" );
                    LogUtilities.getInstance().write( i, "Requisitando " + base.host() + ":" + base.port() );
                    
                    try
                    {
                        LogUtilities.getInstance().write( i, "Requisitando primeira imagem." );

                        ImageIO.read( new URL( base.host() + ":" + base.port() + "/img/03.jpg") );

                        LogUtilities.getInstance().write( i, "Primeira imagem recebida." );

                    }

                    catch ( Exception e )
                    {
                        LogUtilities.getInstance().write( i, e.getMessage() );
                    }

                    try
                    {
                        LogUtilities.getInstance().write( i, "Requisitando segunda imagem" );

                        ImageIO.read( new URL( base.host() + ":" + base.port() + "/img/06.jpg") );

                        LogUtilities.getInstance().write( i, "Segunda imagem recebida." );

                    }

                    catch ( Exception e )
                    {
                         LogUtilities.getInstance().write( i, e.getMessage() );
                    }
                }
                
                finally
                {
                    LogUtilities.getInstance().write( i, "ciclo fechado" );
                }
            }
        }
        
        catch ( IOException e )
        {
            ApplicationContext.getInstance().logException( e );
        }
    }
}
