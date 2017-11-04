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

package io.haskins.java.cloudtrailviewer.model;

/**
 * Class that models the reponse from a Dialog
 *
 * Created by markhaskins on 06/01/2017.
 */
public class DialogAction {

    public static final int ACTION_CANCEL = 0;
    public static final int ACTION_OK = 1;

    private int actionCode;
    private Object actionPayload;

    public DialogAction() {
        this(ACTION_CANCEL, null);
    }

    public DialogAction(int action, Object payload) {

        setActionCode(action);
        setActionPayload(payload);
    }

    public int getActionCode() {
        return actionCode;
    }

    void setActionCode(int actionCode) {
        this.actionCode = actionCode;
    }

    Object getActionPayload() {
        return actionPayload;
    }

    void setActionPayload(Object actionPayload) {
        this.actionPayload = actionPayload;
    }
}
