/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.eng.core.util;

import com.me.eng.core.data.StatmentData;
import com.me.eng.db.Base;
import com.me.eng.db.Database;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Artur Tomasi
 */
public class StatmentController {
    
    /**
     * doStatment
     * 
     * @param data StatmentData
     * @param base
     */
    public static void doStatment( StatmentData data, Base base )
    {
        try
        {
            
            for ( int i = 1; i <= data.getQuantidade(); i ++ )
            {
                Database db = Database.getInstance( base );

                try
                {
                    String sql = "insert into per_1 values ( MD5(RAND()), MD5(RAND()), MD5(RAND()), MD5(RAND()), MD5(RAND()), ?, ?, ?, ?, ? )";

                    LogUtilities.getInstance().write( " #" + i + ": " + sql );

                    PreparedStatement ps = db.getPreparedStatement( sql ); 

                    ps.setBinaryStream( 1, ImageProvider.getStream( 1 ), ImageProvider.getLength( 1 ) );
                    ps.setBinaryStream( 2, ImageProvider.getStream( 2 ), ImageProvider.getLength( 2 ) );
                    ps.setBinaryStream( 3, ImageProvider.getStream( 3 ), ImageProvider.getLength( 3 ) );
                    ps.setBinaryStream( 4, ImageProvider.getStream( 4 ), ImageProvider.getLength( 4 ) );
                    ps.setBinaryStream( 5, ImageProvider.getStream( 5 ), ImageProvider.getLength( 5 ) );

                    try
                    {
                        ps.executeUpdate();
                    }

                    catch ( SQLException e )
                    {
                        LogUtilities.getInstance().write( "ERROR: " + e.getMessage() );
                    }

                    finally
                    {
                        ps.close();
                    }
                }

                catch ( Exception e )
                {
                    LogUtilities.getInstance().write( "ERROR: " + e.getMessage() );
                }

                finally
                {
                    db.release();
                    
                    Thread.sleep(50);
                }

                db = Database.getInstance( base );

                try
                {
                    
                    String sql = "select img_01, text_1 from per_1";
                    
                    LogUtilities.getInstance().write( " #" + i + ": " + sql );
                  
                    PreparedStatement ps = db.getPreparedStatement( sql ); 
                    
                    try
                    {
                        ps.executeQuery();
                    }
                    
                    finally
                    {
                        ps.close();
                    
                        Thread.sleep(50);
                    }
                    
                }

                catch ( Exception e )
                {
                    LogUtilities.getInstance().write( "ERROR: " + e.getMessage() );
                }

                finally
                {
                    db.release();
                    
                    Thread.sleep(50);
                }

                db = Database.getInstance( base );

                try
                {
                    String sql = "insert into per_2 values ( MD5(RAND()), MD5(RAND()), MD5(RAND()), MD5(RAND()), MD5(RAND()), ?, ?, ?, ?, ? )";

                    LogUtilities.getInstance().write( " #" + i + ": " + sql );

                    PreparedStatement ps = db.getPreparedStatement( sql ); 

                    ps.setBinaryStream( 1, ImageProvider.getStream( 6 ), ImageProvider.getLength( 6 ) );
                    ps.setBinaryStream( 2, ImageProvider.getStream( 7 ), ImageProvider.getLength( 7 ) );
                    ps.setBinaryStream( 3, ImageProvider.getStream( 8 ), ImageProvider.getLength( 8 ) );
                    ps.setBinaryStream( 4, ImageProvider.getStream( 9 ), ImageProvider.getLength( 9 ) );
                    ps.setBinaryStream( 5, ImageProvider.getStream( 10 ), ImageProvider.getLength( 10 ) );

                    try
                    {
                        ps.executeUpdate();
                    }

                    catch ( SQLException e )
                    {
                       LogUtilities.getInstance().write(  "ERROR: " + e.getMessage() );
                    }
                }

                catch ( Exception e )
                {
                    LogUtilities.getInstance().write( "ERROR: " + e.getMessage() );
                }

                finally
                {
                    db.release();
                    
                    Thread.sleep(50);
                }

                db = Database.getInstance( base );

                try
                {
                    String sql = "select img_01, text_1 from per_2";
                    
                    LogUtilities.getInstance().write( " #" + i + ": " + sql );
                  
                    PreparedStatement ps = db.getPreparedStatement( sql ); 
                    
                    try
                    {
                        ps.executeQuery();
                    }
                    
                    finally
                    {
                        ps.close();
                    
                        Thread.sleep(50);
                    }
                }

                catch ( Exception e )
                {
                    LogUtilities.getInstance().write( "ERROR: " + e.getMessage() );
                }

                finally
                {
                    db.release();
                    
                    Thread.sleep(50);
                }
                
                LogUtilities.getInstance().write( " #" + i + ": ciclo fechado" );
            }
        }
        
        catch ( Exception e )
        {
            try 
            {
                LogUtilities.getInstance().write( "ERROR: " + e.getMessage() );
            }
            catch ( IOException ex ){
                ex.printStackTrace( System.err );
            }
        }
    }
}
