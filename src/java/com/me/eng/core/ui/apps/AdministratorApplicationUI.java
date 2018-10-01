/**
 * Filename:    AdminstratorApplicationUI.java
 * 
 * Description: Implementation of the AdminstratorApplicationUI class.
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

package com.me.eng.core.ui.apps;

import com.me.eng.core.annotations.ApplicationDescriptor;
import com.me.eng.core.ui.views.ApplicationView;

/**
 *
 * @author Artur Tomasi
 */
@ApplicationDescriptor( url = "/admin/administrator.jsp",
                        icon = "core/ai_administrator.png",
                        label = "Monitoramento" )
public class AdministratorApplicationUI 
    extends 
        ApplicationUI
{

    /**
     * AdministratorApplicationUI
     * 
     */
    public AdministratorApplicationUI() 
    {
        addView(new ApplicationView() );
    }
}
