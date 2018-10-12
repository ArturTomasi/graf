package com.me.eng.db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * @author artur
 */
public class Database
{
    private final static Map<Base, Database> instances = new HashMap();

    /**
     * getInstance
     * 
     * @param b Base
     * @return Database
     * @throws Exception
     */
    public final static Database getInstance( Base b ) throws Exception
    {
        Database db = instances.get( b );
        
        if ( db == null )
        {
            db = new Database( b );
            
            instances.put( b, db );
        }
        
        return db;
    }
    
    private Connection connection;
    private Statement statment;
    
    /**
     * Database
     * 
     * @param base Base
     * @throws Exception
     */
    private Database( Base base ) throws Exception
    {
        DriverManager.registerDriver( (Driver) Class.forName( base.drive() ).newInstance() );

        if( connection == null || connection.isClosed() )
        {
            connection = DriverManager.getConnection( base.url(), base.user(), base.pwd() );
        }
    }
    
    /**
     * release
     * 
     * @throws Exception
     */
    public void release() throws Exception
    {
        if( connection != null && statment != null )
        {   
            statment.close();
        }
    }
    
    /**
     * executeCommand
     * 
     * @param sql String
     * @throws Exception
     */
    public void executeCommand( String sql ) throws Exception
    {
        if( connection != null )
        {
            statment = connection.createStatement();
            
            statment.execute( sql );
        }
    }
    
    /**
     * getPreparedStatement
     * 
     * @param sql String
     * @return PreparedStatement
     * @throws Exception
     */
    public PreparedStatement getPreparedStatement( String sql ) throws Exception
    {
        return connection.prepareStatement( sql );
    }
    
    /**
     * query
     * 
     * @param sql String
     * @return ResultSet
     * @throws Exception
     */
    public ResultSet query( String sql ) throws Exception
    {
        statment = connection.createStatement();
        
        ResultSet resultSet = statment.executeQuery( sql );
        
        return resultSet;
    }
}
