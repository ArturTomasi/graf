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
        return new StatmentData( sqlField.getText(), typeField.getSelectedElement() );
    }
    
    /**
     * initComponents
     * 
     */
    private void initComponents()
    {
        setStyle( "padding: 5px; width: 100%" );
        
        typeField.setWidth( "100%" );
        typeField.setElements( StatmentData.Type.values() );
        typeField.setSelectedElement( StatmentData.Type.QUERY );
        
        sqlField.setWidth( "100%" );
        sqlField.setRows( 7 );
        
        setWidths( "100%" );
        
        addRow( typeField, new Label("Usuários: "), userBox );
        addRow( sqlField );
        
        setColspan( 1, 0, 3 );
    }

    private Textbox sqlField      = new Textbox();
    private Intbox userBox          = new Intbox( 1 );
    private Combobox<StatmentData.Type> typeField    = new Combobox();
}
