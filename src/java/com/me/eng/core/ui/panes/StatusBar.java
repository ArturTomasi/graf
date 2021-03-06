/* 
 *  Filename:    StatusBar 
 *
 *  Author:      Artur Tomasi
 *  EMail:       tomasi.artur@gmail.com
 *  Internet:    www.masterengine.com.br
 *
 *  Copyright © 2018 by Over Line Ltda.
 *  95900-038, LAJEADO, RS
 *  BRAZIL
 *
 *  The copyright to the computer program(s) herein
 *  is the property of Over Line Ltda., Brazil.
 *  The program(s) may be used and/or copied only with
 *  the written permission of Over Line Ltda.
 *  or in accordance with the terms and conditions
 *  stipulated in the agreement/contract under which
 *  the program(s) have been supplied.
 */
package com.me.eng.core.ui.panes;

import com.me.eng.core.application.ResourceLocator;
import com.me.eng.core.domain.User;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;

/**
 *
 * @author Artur
 */
public class StatusBar
    extends 
        Div
{
    public StatusBar()
    {
        initComponents();
    }
    
    public void setUser( User user )
    {
        if ( user != null )
        {
            lbUser.setValue( user.getName() );
        }
    }
    
    private void initComponents()
    {
        lbUser.setValue( "(Sem usuário autenticado)" );
        lbVersion.setValue( "Univates 1.0-0" );
        
        setHflex( "true" );
        setStyle( "color: white; font-size: 10px; position: relative;" );

        imgUser.setSrc( ResourceLocator.getImageResource( "core/sb_user.png" ) );
        imgUser.setHeight( "18px" );
        imgUser.setWidth( "auto" );
        
        lbVersion.setStyle( "position: absolute; right: 10px; top: 10px" );
        lbUser.setStyle( "color: #fff;" );
        
        Hbox hbox = new Hbox();
        hbox.setAlign( "middle" );
        hbox.appendChild( lbUser );
        hbox.appendChild( imgUser );
        hbox.setStyle( "position: absolute; left: 10px; top: 10px" );
        
        appendChild( hbox );
        appendChild( lbVersion );
        
        hbox.addEventListener( Events.ON_CLICK, e->  
        {
            Sessions.getCurrent().invalidate();
            
            Executions.getCurrent().sendRedirect( "/" );
        } );
    }
    
    private Image imgUser = new Image();
    private Label lbUser = new Label();
    private Label lbVersion = new Label();
}
