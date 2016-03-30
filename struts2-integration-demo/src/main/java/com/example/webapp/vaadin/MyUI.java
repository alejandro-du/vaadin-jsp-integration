package com.example.webapp.vaadin;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Button button = new Button("Click me");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                Notification.show("Thanks for clicking!");
            }
        });

        setContent(button);
    }

}
