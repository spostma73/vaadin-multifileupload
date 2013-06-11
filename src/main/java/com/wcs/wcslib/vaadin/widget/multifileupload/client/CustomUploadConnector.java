/*
 * Copyright 2013 gergo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wcs.wcslib.vaadin.widget.multifileupload.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.UIDL;
import com.vaadin.client.ui.upload.UploadConnector;
import com.vaadin.shared.ui.Connect;
import com.wcs.wcslib.vaadin.widget.multifileupload.component.CustomUpload;

/**
 *
 * @author gergo
 */
@Connect(CustomUpload.class)
public class CustomUploadConnector extends UploadConnector {

    @Override
    public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
        super.updateFromUIDL(uidl, client);
        if (uidl.hasAttribute("maxFileSize")) {
            getWidget().setMaxFileSize(uidl.getIntAttribute("maxFileSize"));
        }
        if (uidl.hasAttribute("sizeErrorMsg")) {
            getWidget().setSizeErrorMsg(uidl.getStringAttribute("sizeErrorMsg"));
        }
    }

    @Override
    protected Widget createWidget() {
        return GWT.create(VCustomUpload.class);
    }

    @Override
    public VCustomUpload getWidget() {
        return (VCustomUpload) super.getWidget();
    }
}