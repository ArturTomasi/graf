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
package com.me.eng.core.ui.panes.vm;

import org.zkoss.zul.Div;
import org.zkoss.zul.Iframe;

/**
 *
 * @author Artur Tomasi
 */
public class DashboardPane 
    extends 
        Div
{

    /**
     * DashboardPane
     * 
     */
    public DashboardPane() 
    {
        setStyle( "width: 100%; height: 100%; overflow: auto;" );
        
        Iframe i1 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/uZjyBtAmk/graficos-tcc-gerson?refresh=3s&orgId=1&panelId=35" );
        i1.setWidth( "50%" );
        i1.setHeight( "200px" );
        
        Iframe i2 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/uZjyBtAmk/graficos-tcc-gerson?refresh=3s&orgId=1&panelId=36" );
        i2.setWidth( "50%" );
        i2.setHeight( "200px" );
        
        Iframe i3 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/uZjyBtAmk/graficos-tcc-gerson?refresh=3s&orgId=1&panelId=49" );
        i3.setWidth( "50%" );
        i3.setHeight( "200px" );
        
        Iframe i4 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/uZjyBtAmk/graficos-tcc-gerson?refresh=3s&orgId=1&panelId=48" );
        i4.setWidth( "50%" );
        i4.setHeight( "200px" );
        
        Iframe i5 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/uZjyBtAmk/graficos-tcc-gerson?refresh=3s&orgId=1&panelId=37" );
        i5.setWidth( "100%" );
        i5.setHeight( "200px" );
        
        Iframe i6 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/uZjyBtAmk/graficos-tcc-gerson?refresh=3s&orgId=1&panelId=38" );
        i6.setWidth( "100%" );
        i6.setHeight( "200px" );
        
        appendChild( i1 );
        appendChild( i2 );
        appendChild( i3 );
        appendChild( i4 );
        appendChild( i5 );
        appendChild( i6 );
    }
}