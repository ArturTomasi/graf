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
import com.me.eng.core.ui.apps.Action;
import com.me.eng.core.ui.panes.PortletPanel;
import com.me.eng.core.ui.panes.StatmentPane;
import com.me.eng.core.ui.parts.PortletInfo;
import com.me.eng.core.ui.util.Prompts;
import com.me.eng.db.Base;
import com.me.eng.db.Database;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zkmax.zul.Portalchildren;
import org.zkoss.zkmax.zul.Portallayout;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.East;
import org.zkoss.zul.North;
import org.zkoss.zul.West;

/**
 *
 * @author Artur Tomasi
 */
public class VMApplicationView 
    extends 
        ApplicationViewUI
{
    /**
     * AdminstratorApplicationView
     * 
     */
    public VMApplicationView() 
    {
        setLabel( "Virtual Machine" );
        setIcon( "core/sb_vm.png" );
//        addAction( "Virtual Machine", insertAction, confAction, testAction );
    }

    /**
     * test
     * 
     */
    private void test()
    {
        try
        {
            Database db = Database.getInstance( Base.VIRTUAL_MACHINE );

            try
            {
                db.query( "select 1" );
                
                Prompts.alert( "Sucesso!" );
            }
            
            finally
            {
                db.release();
            }
        }
        
        catch ( Exception e )
        {
            Prompts.alert( "Problemas na conexão!\n" + e.getMessage() );
        }
    }
   
    
    /**
     * doStatment
     * 
     */
    private void doStatment()
    {
        StatmentData data = statmentPane.getData();
        
        for ( int i = 0; i < data.getUser(); i++ )
        {
            new Thread(() -> 
            {
                try
                {
                    Database db = Database.getInstance( Base.VIRTUAL_MACHINE );

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
                    Prompts.error( "Problemas na conexão!\n" + e.getMessage() );
                }
            } ).start();
        }
        
        Prompts.info( "Executando..." );
    }
    
    /**
     * doStatment
     * 
     */
    private void showConfig()
    {
        North north = borderlayout.getNorth();
        
        if ( north == null )
        {
            north = new North();
            north.appendChild( statmentPane );
            
            borderlayout.appendChild( north );
        }
        
        else
        {
            borderlayout.getNorth().detach();
        }
        
        borderlayout.invalidate();
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
        east.setTitle( "Docker" );
        
        West west = new West() ;
        west.setWidth( "50%" );
        west.setTitle( "Virtual Machine" );
        
        borderlayout.appendChild( north );
        borderlayout.appendChild( west );
        borderlayout.appendChild( east );
        
        
        
        appendChild( borderlayout );
    }
    
    private Portallayout pane = new Portallayout();
    
    private StatmentPane statmentPane = new StatmentPane();
    
    private Borderlayout borderlayout = new Borderlayout();
    
    private Action insertAction = new Action( "core/tb_play.png", "Executar", "Executar query customizada!" ) 
    {
        @Override
        public void onEvent( Event t ) throws Exception 
        {
            doStatment();
        }
    };
    
    private Action testAction = new Action( "core/tb_test.png", "Testar", "Test" ) 
    {
        @Override
        public void onEvent( Event t ) throws Exception 
        {
            test();
        }
    };
    
    private Action confAction = new Action( "core/tb_configure.png", "Configurar", "Configurar query" ) 
    {
        @Override
        public void onEvent( Event t ) throws Exception 
        {
            showConfig();
        }
    };
}
