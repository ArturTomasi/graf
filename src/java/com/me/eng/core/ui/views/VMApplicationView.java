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

import com.me.eng.core.ui.apps.Action;
import org.zkoss.zk.ui.event.Event;

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
        addAction( "Virtual Machine", insertAction );
    }

    /**
     * initComponents
     * 
     */
    @Override
    protected void initComponents() 
    {
    }
    
    private Action insertAction = new Action( "core/tb_run.png", "Insert", "Insert" ) 
    {
        @Override
        public void onEvent( Event t ) throws Exception 
        {
        }
    };
}
