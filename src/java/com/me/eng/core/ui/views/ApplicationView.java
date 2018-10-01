/**
 * Filename:    AdminstratorApplicationView.java
 * 
 * Description: Implementation of the AdminstratorApplicationView class.
 * 
 * URL:         $URL$
 * 
 * Revision:    $Revision$ / $Date$
 * 
 * Changed by:  $Author$
 * 
 * Author:      (your full name)
 * EMail:       (your email address)
 * Internet:    www.interact.com.br
 * 
 * Copyright © 1999-2018 by Interact Solutions Ltda.
 * Rua Carlos Fett Filho, 47/301
 * 95.900.000, LAJEADO, RS
 * BRAZIL
 * 
 * The copyright to the computer program(s) herein
 * is the property of Interact Solutions Ltda., Brazil.
 * The program(s) may be used and/or copied only with
 * the written permission of Interact Solutions Ltda.
 * or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which
 * the program(s) have been supplied.
 */
package com.me.eng.core.ui.views;

import com.me.eng.core.application.ApplicationContext;
import com.me.eng.core.data.StatmentData;
import com.me.eng.core.ui.panes.StatmentPane;
import com.me.eng.core.ui.util.Prompts;
import com.me.eng.db.Base;
import com.me.eng.db.Database;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.East;
import org.zkoss.zul.North;
import org.zkoss.zul.West;

/**
 *
 * @author Artur Tomasi
 */
public class ApplicationView 
    extends 
        ApplicationViewUI
{
    /**
     * AdminstratorApplicationView
     * 
     */
    public ApplicationView() 
    {
        setLabel( "Virtual Machine" );
        setIcon( "core/sb_vm.png" );
    }
   
    
    /**
     * doStatment
     * 
     */
    private void doStatment( Event evt )
    {
        StatmentData data = statmentPane.getData();
        
        for ( int i = 0; i < data.getUser(); i++ )
        {
            fireStatment( Base.DOCKER );
            fireStatment( Base.VIRTUAL_MACHINE );
        }
        
        Prompts.info( "Executando..." );
    }
    
    /**
     * fireStatment
     * 
     * @param base Base
     */
    private void fireStatment( Base base )
    {
        StatmentData data = statmentPane.getData();
        
        new Thread(() -> 
        {
            try
            {
                Database db = Database.getInstance( base );

                try
                {
                    switch ( data.getType() )
                    {
                        case COMMAND:
                            db.executeCommand( data.getSql() );
                        break;

                        case QUERY:
                            db.query( data.getSql() );
                        break;

                        case INSERT:
                            db.executeCommand( "call doWhile(" + data.getQuantidade() + ")");
                        break;
                    }
                }

                finally
                {
                    db.release();
                }
            }

            catch ( Exception e )
            {
                e.printStackTrace( System.err );
            }
        } ).start();
    }
    
    /**
     * initComponents
     * 
     */
    @Override
    protected void initComponents() 
    {
        setVflex( "true" );
        setHflex( "true" );
        
        North north = new North() ;
        north.setTitle( "Configuração" );
        north.appendChild( statmentPane );
        
        East east = new East() ;
        east.setWidth( "50%" );
        east.setTitle( "Docker - srv002.fell.eng.br" );
        east.appendChild( new com.me.eng.core.ui.panes.docker.DashboardPane() );
        
        West west = new West() ;
        west.setWidth( "50%" );
        west.setTitle( "Virtual Machine - srv001.fell.eng.br" );
        west.appendChild( new com.me.eng.core .ui.panes.vm.DashboardPane() );
        
        
        borderlayout.appendChild( north );
        borderlayout.appendChild( west );
        borderlayout.appendChild( east );
        
        appendChild( borderlayout );
        
        statmentPane.addEventListener( StatmentPane.Events.ON_STATMENT, this::doStatment );
    }
    
    private StatmentPane statmentPane = new StatmentPane();
    
    private Borderlayout borderlayout = new Borderlayout();
}
