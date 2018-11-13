package com.me.eng.core.ui.panes.docker;

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
        
        Iframe i1 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/TCDlXI1ik/zabbix-ambiente-total-zabbix-brasil-oficial-c?refresh=5s&orgId=1&panelId=3" );
        i1.setStubonly(true);
        i1.setWidth( "100%" );
        i1.setHeight( "200px" );
        
        Iframe i2 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/TCDlXI1ik/zabbix-ambiente-total-zabbix-brasil-oficial-c?refresh=5s&orgId=1&panelId=18" );
        i2.setStubonly(true);
        i2.setWidth( "50%" );
        i2.setHeight( "200px" );
        
        Iframe i3 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/TCDlXI1ik/zabbix-ambiente-total-zabbix-brasil-oficial-c?refresh=5s&orgId=1&panelId=20" );
        i3.setStubonly(true);
        i3.setWidth( "50%" );
        i3.setHeight( "200px" );
        
        Iframe i4 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/TCDlXI1ik/zabbix-ambiente-total-zabbix-brasil-oficial-c?refresh=5s&orgId=1&panelId=54" );
        i4.setStubonly(true);
        i4.setWidth( "50%" );
        i4.setHeight( "200px" );
        
        Iframe i5 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/TCDlXI1ik/zabbix-ambiente-total-zabbix-brasil-oficial-c?refresh=5s&orgId=1&panelId=55" );
        i5.setStubonly(true);
        i5.setWidth( "50%" );
        i5.setHeight( "200px" );
        
        Iframe i6 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/TCDlXI1ik/zabbix-ambiente-total-zabbix-brasil-oficial-c?refresh=5s&orgId=1&panelId=21" );
        i6.setStubonly(true);
        i6.setWidth( "50%" );
        i6.setHeight( "200px" );
        
        Iframe i7 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/TCDlXI1ik/zabbix-ambiente-total-zabbix-brasil-oficial-c?refresh=5s&orgId=1&panelId=48" );
        i7.setStubonly(true);
        i7.setWidth( "50%" );
        i7.setHeight( "200px" );
        
        Iframe i8= new Iframe( "http://srv003.fell.eng.br:3000/d-solo/TCDlXI1ik/zabbix-ambiente-total-zabbix-brasil-oficial-c?refresh=5s&orgId=1&panelId=44" );
        i8.setStubonly(true);
        i8.setWidth( "100%" );
        i8.setHeight( "250px" );
        
        Iframe i9 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/TCDlXI1ik/zabbix-ambiente-total-zabbix-brasil-oficial-c?refresh=5s&orgId=1&panelId=45" );
        i9.setStubonly(true);
        i9.setWidth( "100%" );
        i9.setHeight( "250px" );
        
        Iframe i10 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/TCDlXI1ik/zabbix-ambiente-total-zabbix-brasil-oficial-c?refresh=5s&orgId=1&panelId=60" );
        i10.setStubonly(true);
        i10.setWidth( "100%" );
        i10.setHeight( "250px" );
        
        Iframe i11 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/TCDlXI1ik/zabbix-ambiente-total-zabbix-brasil-oficial-c?refresh=5s&orgId=1&panelId=52" );
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
