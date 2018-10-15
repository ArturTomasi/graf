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

import com.me.eng.core.application.ResourceLocator;
import com.me.eng.core.data.StatmentData;
import com.me.eng.core.ui.parts.TableLayout;
import com.me.eng.core.ui.selectors.Combobox;
import com.me.eng.core.util.LogUtilities;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Image;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Timer;
import org.zkoss.zul.Window;

/**
 *
 * @author Artur Tomasi
 */
public class StatmentPane 
    extends 
        TableLayout
{
    public static class Events
    {
        public static final String ON_STATMENT = "onStatment";
    }
    
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
        return new StatmentData( logField.getText(), userBox.getValue(), quantidadeBox.getValue(), quantidadeBox.getValue(), typeField.getSelectedElement() );
    }
    
    /**
     * onSelect
     * 
     * @param e Event
     */
    private void onSelect( Event e )
    {
//        quantidadeBox.setVisible( typeField.getSelectedElement() == StatmentData.Type.INSERT ||
//                                  typeField.getSelectedElement() == StatmentData.Type.MIXED );
//        quantidadeLabel.setVisible( typeField.getSelectedElement() == StatmentData.Type.INSERT ||
//                                    typeField.getSelectedElement() == StatmentData.Type.MIXED );
//        
//        timeoutBox.setVisible( typeField.getSelectedElement() == StatmentData.Type.HTTP );
//        timeoutLabel.setVisible( typeField.getSelectedElement() == StatmentData.Type.HTTP );
//        
//        sqlField.setVisible( typeField.getSelectedElement() != StatmentData.Type.INSERT && 
//                             typeField.getSelectedElement() != StatmentData.Type.MIXED  &&
//                             typeField.getSelectedElement() != StatmentData.Type.HTTP );
        quantidadeBox.setVisible( typeField.getSelectedElement() == StatmentData.Type.MIXED );
        quantidadeLabel.setVisible( typeField.getSelectedElement() == StatmentData.Type.MIXED );
        
        timeoutBox.setVisible( typeField.getSelectedElement() == StatmentData.Type.HTTP );
        timeoutLabel.setVisible( typeField.getSelectedElement() == StatmentData.Type.HTTP );
        
        logField.setVisible( typeField.getSelectedElement() != StatmentData.Type.MIXED  &&
                             typeField.getSelectedElement() != StatmentData.Type.HTTP );
        
         getParent().invalidate();
    }
    
    /**
     * doStatment
     * 
     * @param e Event
     */
    private void doStatment( Event e )
    {
         Executions.getCurrent().postEvent( new Event( Events.ON_STATMENT, this, getData() ) );
    }
    
    
    /**
     * showLog
     * 
     * @param e Event
     */
    private void showLog( Event e )
    {
        Window w = new Window( "Logs", "no", true );
        w.setParent( this );
        w.setBorder( false );
        w.setMaximizable( true );
        w.setSizable( true );
        w.setMinwidth( 600 );
        w.setMinheight( 300 );
        w.setWidth( "900px" );
        w.setHeight( "400px" );
        w.appendChild( clearLogAction );
        w.appendChild( logField );
        w.doModal();
    }
    
    private void clear( Event e )throws Exception{
        LogUtilities.getInstance().clear();
        logField.setText( "" );
    }
    
    /**
     * log
     * 
     * @param e Event
     */
    private void log( Event e ){
        logField.setText( LogUtilities.getInstance().tail() );
    }
    
    /**
     * initComponents
     * 
     */
    private void initComponents()
    {
        setStyle( "padding: 0px 5px; width: 100%; height: 50px;" );
        
        typeField.setWidth( "250px" );
        typeField.setElements( StatmentData.Type.values() );
        typeField.setSelectedElement( StatmentData.Type.MIXED );
        
        logField.setWidth( "100%" );
        logField.setHeight( "100%" );
        logField.setDisabled( true );
        logField.setRows( 4 );
        
        fireAction.setStyle( "width: 35px; cursor: pointer; float: left;" );
        fireAction.setTooltiptext( "Executar" );
        logAction.setStyle( "width: 35px; cursor: pointer; float: left;" );
        logAction.setTooltiptext( "Ver logs das operações" );
        clearLogAction.setStyle( "width: 24px; cursor: pointer; top: 5px; position: absolute; right: 100px" );
        clearLogAction.setTooltiptext( "Limpar logs" );
                
        timeoutBox.setVisible( false );
        timeoutLabel.setVisible( false );
        
        addRow( typeLabel, typeField, quantidadeLabel, quantidadeBox, timeoutLabel, timeoutBox, userLabel, userBox, fireAction, logAction );

        setWidths( "100px", "100px", "100px", "100px", "100px", "100px", "100px", "100px", "100px", "100%" );
        
        typeField.addEventListener( org.zkoss.zk.ui.event.Events.ON_SELECT, this::onSelect );
        fireAction.addEventListener( org.zkoss.zk.ui.event.Events.ON_CLICK, this::doStatment );
        logAction.addEventListener( org.zkoss.zk.ui.event.Events.ON_CLICK, this::showLog );
        clearLogAction.addEventListener( org.zkoss.zk.ui.event.Events.ON_CLICK, this::clear );
        
        Timer timer = new Timer( 500 );
        timer.setRepeats( true );
        timer.addEventListener( org.zkoss.zk.ui.event.Events.ON_TIMER, this::log );
        timer.start();
        appendChild( timer );
    }   

    private Label typeLabel         = new Label("Tipo: ");
    private Label userLabel         = new Label("Usuários: ");
    private Label quantidadeLabel   = new Label("Quantidade: ");
    private Label timeoutLabel      = new Label("Timeout(s): ");
    
    private Textbox logField        = new Textbox();
    private Intbox userBox          = new Intbox( 1 );
    private Intbox quantidadeBox    = new Intbox( 1 );
    private Intbox timeoutBox          = new Intbox( 60 );
    private Combobox<StatmentData.Type> typeField    = new Combobox();
    
    private Image fireAction = new Image( ResourceLocator.getImageResource( "core/tb_play.png" ) );
    private Image logAction = new Image( ResourceLocator.getImageResource( "core/tb_inspect.png" ) );
    private Image clearLogAction = new Image( ResourceLocator.getImageResource( "core/tb_eraser.png" ) );
}
