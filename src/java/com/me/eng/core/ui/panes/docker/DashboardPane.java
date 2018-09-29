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
        
        Iframe i1 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/uZjyBtAmk/graficos-tcc-gerson?refresh=3s&orgId=1&panelId=8" );
        i1.setWidth( "50%" );
        i1.setHeight( "200px" );
        
        Iframe i2 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/uZjyBtAmk/graficos-tcc-gerson?refresh=3s&orgId=1&panelId=9" );
        i2.setWidth( "50%" );
        i2.setHeight( "200px" );
        
        Iframe i3 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/uZjyBtAmk/graficos-tcc-gerson?refresh=3s&orgId=1&panelId=43" );
        i3.setWidth( "50%" );
        i3.setHeight( "200px" );
        
        Iframe i4 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/uZjyBtAmk/graficos-tcc-gerson?refresh=3s&orgId=1&panelId=42" );
        i4.setWidth( "50%" );
        i4.setHeight( "200px" );
        
        Iframe i5 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/uZjyBtAmk/graficos-tcc-gerson?orgId=1&panelId=3" );
        i5.setWidth( "100%" );
        i5.setHeight( "200px" );
        
        Iframe i6 = new Iframe( "http://srv003.fell.eng.br:3000/d-solo/uZjyBtAmk/graficos-tcc-gerson?orgId=1&panelId=34" );
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
