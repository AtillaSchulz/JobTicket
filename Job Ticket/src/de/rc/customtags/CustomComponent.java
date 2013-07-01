/*
* This file is part of Job Ticket, a software system for managing
* the orders done by the worker.
*
* Copyright (C) 2013 Atilla Schulz & Janine Naumann
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*/
package de.rc.customtags;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 * @author janine
 *
 */
@FacesComponent("components.CustomComponent")
public class CustomComponent extends UIComponentBase {
 
    @Override
    public String getFamily() {        
        return "my.custom.component";
    }
 
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
 
        String value = (String) getAttributes().get("value");
 
        if (value != null) {        
            ResponseWriter writer = context.getResponseWriter();
            writer.write("<p>"+value.toUpperCase()+"</p>");
        }
    }
}
