package com.example.webapp.vaadin;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Label label = new Label("It works!");
        setContent(label);
    }

}
