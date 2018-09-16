/**
 * com.me.eng.db
 * 
 * @return package
 */
package com.me.eng.db;

import com.me.eng.core.application.ConfigurationManager;

/**
 *
 * @author Artur Tomasi
 */
public enum Base 
{
    DEFAULT         ( "default" ),
    DOCKER          ( "docker" ),
    VIRTUAL_MACHINE ( "vm" );
    
    private String name;
    
    /**
     * Base
     * 
     * @param name String
     */
    private Base( String name ) 
    {
        this.name = name;
    }
    
    /**
     * drive
     * 
     * @return String
     */
    public String drive()
    {
        return ConfigurationManager.getInstance().getProperty( name + ".db.drive" );
    }
    
    /**
     * user
     * 
     * @return String
     */
    public String user()
    {
        return ConfigurationManager.getInstance().getProperty( name + ".db.user" );
    }
    
    /**
     * pwd
     * 
     * @return String
     */
    public String pwd()
    {
        return ConfigurationManager.getInstance().getDecryptedProperty( name + ".db.pwd" );
    }
    
    /**
     * url
     * 
     * @return String
     */
    public String url()
    {
        return ConfigurationManager.getInstance().getProperty( name + ".db.url" );
    }
}
