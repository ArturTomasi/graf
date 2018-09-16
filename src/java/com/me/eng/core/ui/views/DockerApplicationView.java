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
import com.me.eng.core.ui.apps.Action;
import com.me.eng.core.ui.panes.PortletPanel;
import com.me.eng.core.ui.parts.PortletInfo;
import com.me.eng.core.ui.util.Prompts;
import com.me.eng.db.Base;
import com.me.eng.db.Database;
import java.sql.ResultSet;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zkmax.zul.Portalchildren;
import org.zkoss.zkmax.zul.Portallayout;

/**
 *
 * @author Artur Tomasi
 */
public class DockerApplicationView 
    extends 
        ApplicationViewUI
{

    /**
     * AdminstratorApplicationView
     * 
     */
    public DockerApplicationView() 
    {
        setLabel( "Docker" );
        setIcon( "core/sb_docker.png" );
        addAction( "Docker", insertAction );
    }

    @Override
    public void refreshContent() 
    {
        try
        {
            Database db = Database.getInstance( Base.DOCKER );

            try
            {
                ResultSet set = db.query( "select name from fin_postings" );
                set.next();
                Prompts.alert( set.getString(1) );
                
                set.close();
            }
            
            finally
            {
                db.release();
            }
        }
        
        catch ( Exception e )
        {
            ApplicationContext.getInstance().handleException( e );
        }
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
        
        pane.setVflex( "true" );
        pane.setHflex( "true" );
     
        Portalchildren pc = new Portalchildren();
        pc.appendChild( new PortletPanel( new PortletInfo( "Gráfico", 
                                                           "https://snapshot.raintank.io/dashboard-solo/snapshot/qAaPU62nad5dC26ltx0s1O1H8FbUIW4X?orgId=2&panelId=4&from=1537116382471&to=1537137982471&var-Group=All&var-Hosts=srv002.fell.eng.br",
                                                           "https://snapshot.raintank.io/dashboard-solo/snapshot/isJXUjK12Q9SOLbK00Ui51oqN5qVs7I3?orgId=2&panelId=9&from=1537116309755&to=1537137909755&var-Group=All&var-Hosts=srv002.fell.eng.br", 
                                                           PortletInfo.PortletType.IFRAME, "yes", "500px" ) ) );
        
        
        pane.appendChild( pc );
        pane.setMaximizedMode( "whole" );
        
        appendChild( pane );
    }
    
    private Portallayout pane = new Portallayout();
    
    private Action insertAction = new Action( "core/tb_run.png", "Insert", "Insert" ) 
    {
        @Override
        public void onEvent( Event t ) throws Exception 
        {
        }
    };
}
