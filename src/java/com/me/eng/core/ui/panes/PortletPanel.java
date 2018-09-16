/**
 * Filename:    DashboardPane.java
 * 
 * Description: Implementation of the DashboardPane class.
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
package com.me.eng.core.ui.panes;

import com.me.eng.core.ui.parts.PortletInfo;
import com.me.eng.core.ui.parts.PortletInfo.PortletType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.MaximizeEvent;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Include;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Panelchildren;

/**
 *
 * @author Artur Tomasi
 */
public class PortletPanel 
    extends 
        Panel
{
    private static final String KEY_PANEL_INFO = "KEY_PANEL_INFO";
     
    public PortletPanel(PortletInfo info) 
    {
        this.setBorder("normal");
        this.setCollapsible( true );
        this.setClosable( true );
        this.setMaximizable( true );
        this.setSizable( true );
        this.setMovable( true );
        this.setFloatable( true );
        
        this.appendChild(new Panelchildren());
         
        this.addEventListener( Events.ON_MAXIMIZE, (e) ->
        {
            MaximizeEvent maxEvent = (MaximizeEvent) e;
            Panel p = (Panel) maxEvent.getTarget();
            PortletInfo pInfo = (PortletInfo) p.getAttribute(KEY_PANEL_INFO);
 
            Component innerComp = (Component) p.getPanelchildren().getChildren().get(0);
            
            if ( pInfo.getType().equals( PortletType.IFRAME ) ) 
            {
                ( (Iframe) innerComp ).setSrc( maxEvent.isMaximized() ? pInfo.getUrlMax() : pInfo.getUrlMin() );
            }
            
            else 
            {
                ((Include) innerComp).setSrc( maxEvent.isMaximized() ? pInfo.getUrlMax() : pInfo.getUrlMin() );
            }
        } );
         
        this.setAttribute( KEY_PANEL_INFO, info );
        this.setHeight( info.getMinSize() );
        this.setTitle( info.getName() );
         
        if ( info.getType().equals(PortletType.IFRAME ) ) 
        {
            this.getPanelchildren().appendChild( new PortletIframe( info ) );
        } 
        
        else 
        {
            this.getPanelchildren().appendChild( new PortletInclude( info ) );
        }
    }
     
    /**
     * PortletIframe
     * 
     * @return class
     * @ignored extends
     * @ignored Iframe
     */
    private class PortletIframe 
        extends 
            Iframe
    {
        /**
         * PortletIframe
         * 
         * @param info PortletInfo
         */
        public PortletIframe( PortletInfo info )
        {
            super();
             
            this.setSrc( info.getUrlMin() );
            this.setScrolling( info.getScroll() );
             
            this.setWidth("100%");
            this.setHeight("100%");
        }
    }
     
    /**
     * PortletInclude
     * 
     * @return class
     * @ignored extends
     * @ignored Include
     */
    private class PortletInclude
        extends 
            Include
    {
        /**
         * PortletInclude
         * 
         * @param info PortletInfo
         */
        public PortletInclude( PortletInfo info )
        {
            super(info.getUrlMin());
             
            this.setWidth("100%");
            this.setHeight("100%");
        }
    }
}