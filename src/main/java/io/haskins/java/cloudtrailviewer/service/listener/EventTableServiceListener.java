/*
CloudTrail Viewer, is a Java desktop application for reading AWS CloudTrail logs
files.

Copyright (C) 2017  Mark P. Haskins

This program is free software: you can redistribute it and/or modify it under the
terms of the GNU General Public License as published by the Free Software Foundation,
either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,but WITHOUT ANY
WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
PARTICULAR PURPOSE.  See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package io.haskins.java.cloudtrailviewer.service.listener;

import org.apache.lucene.document.Document;
import org.apache.lucene.search.TopDocs;

import java.util.List;

/**
 * Interface
 *
 * Created by markhaskins on 26/01/2017.
 */
public interface EventTableServiceListener {

    /**
     * sets the collection of Events
     * @param results collection of Event objects to set
     */
    void setEvents(TopDocs results);


    void setEvents(List<Document> documents);
}
