/**
 * Filename:    StatmentPane.java
 * 
 * Description: Implementation of the StatmentPane class.
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

import com.me.eng.core.data.StatmentData;
import com.me.eng.core.ui.parts.TableLayout;
import com.me.eng.core.ui.selectors.Combobox;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

/**
 *
 * @author Artur Tomasi
 */
public class StatmentPane 
    extends 
        TableLayout
{
    /**
     * FilterPane
     * 
     */
    public StatmentPane( ) 
    {
        initComponents();
    }
    
    /**
     * getFilter
     * 
     * @return PostingFilter
     */
    public StatmentData getData()
    {
        return new StatmentData( sqlField.getText(), userBox.getValue(), quantidadeBox.getValue(), typeField.getSelectedElement() );
    }
    
    /**
     * onSelect
     * 
     * @param e Event
     */
    private void onSelect( Event e )
    {
        quantidadeBox.setVisible( typeField.getSelectedElement() == StatmentData.Type.INSERT );
        quantidadeLabel.setVisible( typeField.getSelectedElement() == StatmentData.Type.INSERT );
        
        sqlField.setVisible( typeField.getSelectedElement() != StatmentData.Type.INSERT );
        
         getParent().invalidate();
    }
    
    /**
     * initComponents
     * 
     */
    private void initComponents()
    {
        setStyle( "padding: 5px; width: 650px" );
        
        typeField.setWidth( "250px" );
        typeField.setElements( StatmentData.Type.values() );
        typeField.setSelectedElement( StatmentData.Type.QUERY );
        
        sqlField.setWidth( "100%" );
        sqlField.setRows( 7 );
        
        quantidadeBox.setVisible( false );
        quantidadeLabel.setVisible( false );
                
        setWidths( "250px", "100px", "100px", "100px", "100px" );
        
        addRow( typeField, userLabel, userBox, quantidadeLabel, quantidadeBox );
        addRow( sqlField );
        
        setColspan( 1, 0, 5 );
        
        typeField.addEventListener( Events.ON_SELECT, this::onSelect );
    }

    private Label userLabel         = new Label("Usuários: ");
    private Label quantidadeLabel   = new Label("Quantidade: ");
    
    private Textbox sqlField        = new Textbox();
    private Intbox userBox          = new Intbox( 1 );
    private Intbox quantidadeBox    = new Intbox( 1 );
    private Combobox<StatmentData.Type> typeField    = new Combobox();
}
