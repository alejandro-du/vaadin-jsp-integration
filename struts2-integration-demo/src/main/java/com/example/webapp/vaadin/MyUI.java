package com.example.webapp.vaadin;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUI extends UI implements Button.ClickListener {

    private VerticalLayout layout = new VerticalLayout();
    private TextField textField = new TextField("Enter name: ");
    private Button button = new Button("Call Server");

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        layout.addComponents(textField, button);
        layout.setMargin(true);
        layout.setSpacing(true);

        setContent(layout);
        setSizeFull();

        button.addClickListener(this);
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        String name = textField.getValue();
        String message = getMessage(name);
        layout.addComponent(new Label(message));
    }

    private String getMessage(String name) {
        String time = new SimpleDateFormat("hh:mm:ss a").format(new Date());
        return String.format("Hello %s, the time here is %s", name, time);
    }

}
