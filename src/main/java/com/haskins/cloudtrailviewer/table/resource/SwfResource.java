/*
 * Copyright (C) 2015 Mark P. Haskins
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.haskins.cloudtrailviewer.table.resource;

import com.haskins.cloudtrailviewer.model.event.Event;

/**
 *
 * @author mark
 */
public class SwfResource extends AbstractResource implements Resource {

    /**
     * Return the resource for the passed Event
     * @param event Event from which the resource is require
     * @param resources 
     */
    @Override
    public void getResource(Event event, RequestInfo resources) {
        
        if (event.getEventName().equalsIgnoreCase("RegisterActivityType")) {
            registerActivityType(event, resources);
            
        } else if (event.getEventName().equalsIgnoreCase("DeprecateDomain")) {
            deprecateDomain(event, resources);
            
        }
    }
    
    private void deprecateDomain(Event event, RequestInfo resources) {
        getTopLevelResource("Domain", "name", event, resources);
    }
    
    private void registerActivityType(Event event, RequestInfo resources) {
        getTopLevelResource("Domain", "domain", event, resources);
    }
}
