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

import com.me.eng.core.data.StatmentData;
import com.me.eng.core.ui.panes.StatmentPane;
import com.me.eng.core.ui.util.Prompts;
import com.me.eng.core.util.ApacheAbController;
import com.me.eng.core.util.RequestController;
import com.me.eng.core.util.StatmentController;
import com.me.eng.db.Base;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.North;

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
    private void doDockerStatment( Event evt )
    {
        StatmentData data = statmentPane.getData();
        
        switch ( data.getType() )
        {
            case APACHE_AB:
            {
                fireStatment( -1, Base.DOCKER );
            }
            break;
            default:
            {
                for ( int i = 0; i < data.getUser(); i++ )
                {
                    fireStatment( i, Base.DOCKER );
                }
            }
            break;
        }
        
        Prompts.info( "Executando DOCKER..." );
    }
    
    private void doVmStatment( Event evt )
    {
        StatmentData data = statmentPane.getData();
        
        switch ( data.getType() )
        {
            case APACHE_AB:
            {
                fireStatment( -1, Base.VIRTUAL_MACHINE );
            }
            break;
            default:
            {
                for ( int i = 0; i < data.getUser(); i++ )
                {
                    fireStatment( i, Base.VIRTUAL_MACHINE );
                }
            }
            break;
        }
        
        Prompts.info( "Executando VIRTUAL MACHINE..." );
    }
    
    private void doStatment( Event evt )
    {
        StatmentData data = statmentPane.getData();
        
        switch ( data.getType() )
        {
            case APACHE_AB:
            {
                
                fireStatment( -1, Base.VIRTUAL_MACHINE );
                fireStatment( -1, Base.DOCKER );
            }
            break;
            default:
            {
                for ( int i = 0; i < data.getUser(); i++ )
                {
                    fireStatment( i, Base.VIRTUAL_MACHINE );
                    fireStatment( i, Base.DOCKER );
                }
            }
            break;
        }
        
        Prompts.info( "Executando Simultaneamente..." );
    }
    
    /**
     * fireStatment
     * 
     * @param base Base
     */
    private void fireStatment( int user, Base base )
    {
        StatmentData data = statmentPane.getData();
        
        Thread t = new Thread(() -> 
        {
            try
            {
                switch ( data.getType() )
                {
                    case MIXED:
                        StatmentController.doStatment( data, base );
                    break;

                    case HTTP:
                        RequestController.doRequest( data, base );
                    break;

                    case APACHE_AB:
                        ApacheAbController.doRequest( data, base );
                    break;
                }

            }

            catch ( Exception e )
            {
                e.printStackTrace( System.err );
            }
        } );
        
        t.setName( base.toString() + " - USUARIO " + ( user + 1 ) );
        t.setDaemon( true );
        t.start();
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
        north.setCollapsible(true);
        north.appendChild( statmentPane );
        
        Hbox box = new Hbox();
        box.setWidth("100%" );
        box.setHeight( "1800px" );
        box.appendChild( new com.me.eng.core.ui.panes.docker.DashboardPane() );
        box.appendChild( new com.me.eng.core.ui.panes.vm.DashboardPane() );
        
        Center center = new Center();
        center.setTitle( "Dashboard" );
        center.setAutoscroll( true );
        center.appendChild( box );
        
        borderlayout.appendChild( north );
        borderlayout.appendChild( center );
        
        appendChild( borderlayout );
        
        statmentPane.addEventListener( StatmentPane.Events.ON_DOCKER_STATMENT, this::doDockerStatment );
        statmentPane.addEventListener( StatmentPane.Events.ON_VM_STATMENT,     this::doVmStatment );
        statmentPane.addEventListener( StatmentPane.Events.ON_STATMENT,        this::doStatment );
    }
    
    private StatmentPane statmentPane = new StatmentPane();
    
    private Borderlayout borderlayout = new Borderlayout();
}
