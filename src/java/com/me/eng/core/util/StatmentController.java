/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.eng.core.util;

import com.me.eng.core.data.StatmentData;
import com.me.eng.db.Database;
import java.sql.PreparedStatement;

/**
 *
 * @author Artur Tomasi
 */
public class StatmentController {
    
    /**
     * doStatment
     * 
     * @param data StatmentData
     * @param db Database
     * @throws Exception
     */
    public static void doStatment( StatmentData data, Database db ) throws Exception
    {
        
        String sql = "insert into per_1 values ( MD5(RAND()), MD5(RAND()), MD5(RAND()), MD5(RAND()), MD5(RAND()), ?, ?, ?, ?, ? )";
        
        LogUtilities.getInstance().write( sql );
        
        PreparedStatement ps = db.getPreparedStatement( sql ); 
        
        ps.setBinaryStream( 1, ImageProvider.IMG.get( 1 ) );
        ps.setBinaryStream( 2, ImageProvider.IMG.get( 2 ) );
        ps.setBinaryStream( 3, ImageProvider.IMG.get( 3 ) );
        ps.setBinaryStream( 4, ImageProvider.IMG.get( 4 ) );
        ps.setBinaryStream( 5, ImageProvider.IMG.get( 5 ) );
        
        try
        {
            ps.execute();
        }
        
        finally
        {
            ps.close();
        }
        
        sql = "select * from per_1";
                
        LogUtilities.getInstance().write( sql );
        
        db.query( sql  );
        
        sql = "insert into per_2 values ( MD5(RAND()), MD5(RAND()), MD5(RAND()), MD5(RAND()), MD5(RAND()), ?, ?, ?, ?, ? )";
        
        LogUtilities.getInstance().write( sql );
        
        ps = db.getPreparedStatement( sql ); 
        
        ps.setBinaryStream( 1, ImageProvider.IMG.get( 6 ) );
        ps.setBinaryStream( 2, ImageProvider.IMG.get( 7 ) );
        ps.setBinaryStream( 3, ImageProvider.IMG.get( 8 ) );
        ps.setBinaryStream( 4, ImageProvider.IMG.get( 9 ) );
        ps.setBinaryStream( 5, ImageProvider.IMG.get( 10 ) );
        
        try
        {
            ps.execute();
        }
        
        finally
        {
            ps.close();
        }
        
        sql = "select * from per_2";
        
        LogUtilities.getInstance().write( sql );
        
        db.query( sql );
        
    }
}
