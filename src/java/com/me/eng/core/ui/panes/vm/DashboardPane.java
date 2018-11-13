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
        
        Iframe i1 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/TCDlXI1ik/zabbix-ambiente-total-zabbix-brasil-oficial-c?refresh=1s&orgId=1&panelId=39" );
        i1.setStubonly(true);
        i1.setWidth( "100%" );
        i1.setHeight( "200px" );
        
        Iframe i2 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/TCDlXI1ik/zabbix-ambiente-total-zabbix-brasil-oficial-c?refresh=1s&orgId=1&panelId=62" );
        i2.setStubonly(true);
        i2.setWidth( "50%" );
        i2.setHeight( "200px" );
        
        Iframe i3 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/TCDlXI1ik/zabbix-ambiente-total-zabbix-brasil-oficial-c?refresh=1s&orgId=1&panelId=7" );
        i3.setStubonly(true);
        i3.setWidth( "50%" );
        i3.setHeight( "200px" );
        
        Iframe i4 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/TCDlXI1ik/zabbix-ambiente-total-zabbix-brasil-oficial-c?refresh=1s&orgId=1&panelId=56" );
        i4.setStubonly(true);
        i4.setWidth( "50%" );
        i4.setHeight( "200px" );
        
        Iframe i5 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/TCDlXI1ik/zabbix-ambiente-total-zabbix-brasil-oficial-c?refresh=1s&orgId=1&panelId=57" );
        i5.setStubonly(true);
        i5.setWidth( "50%" );
        i5.setHeight( "200px" );
        
        Iframe i6 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/TCDlXI1ik/zabbix-ambiente-total-zabbix-brasil-oficial-c?refresh=1s&orgId=1&panelId=49" );
        i6.setStubonly(true);
        i6.setWidth( "50%" );
        i6.setHeight( "200px" );
        
        Iframe i7 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/TCDlXI1ik/zabbix-ambiente-total-zabbix-brasil-oficial-c?refresh=1s&orgId=1&panelId=50" );
        i7.setStubonly(true);
        i7.setWidth( "50%" );
        i7.setHeight( "200px" );
        
        Iframe i8= new Iframe( "http://srv003.fell.eng.br:3000/d-solo/TCDlXI1ik/zabbix-ambiente-total-zabbix-brasil-oficial-c?refresh=1s&orgId=1&panelId=46" );
        i8.setStubonly(true);
        i8.setWidth( "100%" );
        i8.setHeight( "250px" );
        
        Iframe i9 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/TCDlXI1ik/zabbix-ambiente-total-zabbix-brasil-oficial-c?refresh=1s&orgId=1&panelId=47" );
        i9.setStubonly(true);
        i9.setWidth( "100%" );
        i9.setHeight( "250px" );
        
        Iframe i10 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/TCDlXI1ik/zabbix-ambiente-total-zabbix-brasil-oficial-c?refresh=1s&orgId=1&panelId=61" );
        i10.setStubonly(true);
        i10.setWidth( "100%" );
        i10.setHeight( "250px" );
        
        Iframe i11 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/TCDlXI1ik/zabbix-ambiente-total-zabbix-brasil-oficial-c?refresh=1s&orgId=1&panelId=53" );
        i11.setStubonly(true);
        i11.setWidth( "100%" );
        i11.setHeight( "250px" );
        
        appendChild( i1 );
        appendChild( i2 );
        appendChild( i3 );
        appendChild( i4 );
        appendChild( i5 );
        appendChild( i6 );
        appendChild( i7 );
        appendChild( i8 );
        appendChild( i9 );
        appendChild( i10 );
        appendChild( i11 );
    }
}