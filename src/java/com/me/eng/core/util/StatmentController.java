/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.eng.core.util;

import com.me.eng.core.data.StatmentData;
import com.me.eng.db.Database;
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
     * @param db Database
     * @throws Exception
     */
    public static void doStatment( StatmentData data, Database db ) throws Exception
    {
        for ( int i = 0; i < data.getQuantidade(); i ++ )
        {
            String sql = "insert into per_1 values ( MD5(RAND()), MD5(RAND()), MD5(RAND()), MD5(RAND()), MD5(RAND()), ?, ?, ?, ?, ? )";

            LogUtilities.getInstance().write( sql );

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

            catch ( SQLException e ){
               LogUtilities.getInstance().write( e.getMessage() );
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

            ps.setBinaryStream( 1, ImageProvider.getStream( 6 ), ImageProvider.getLength( 6 ) );
            ps.setBinaryStream( 2, ImageProvider.getStream( 7 ), ImageProvider.getLength( 7 ) );
            ps.setBinaryStream( 3, ImageProvider.getStream( 8 ), ImageProvider.getLength( 8 ) );
            ps.setBinaryStream( 4, ImageProvider.getStream( 9 ), ImageProvider.getLength( 9 ) );
            ps.setBinaryStream( 5, ImageProvider.getStream( 10 ), ImageProvider.getLength( 10 ) );

            try
            {
                ps.executeUpdate();
            }

            catch ( SQLException e ){
               LogUtilities.getInstance().write( e.getMessage() );
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
}
