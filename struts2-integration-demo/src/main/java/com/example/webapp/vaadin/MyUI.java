package com.example.webapp.vaadin;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        initLayout();
    }

    public void initLayout() {
        setSizeFull();

        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);
        setContent(layout);

        final TextField textField = new TextField("Enter name: ");
        layout.addComponent(textField);

        Button button = new Button("Call Server");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                String name = textField.getValue();
                String message = getMessage(name);
                layout.addComponent(new Label(message));
            }
        });
        layout.addComponent(button);
    }

    private String getMessage(String name) {
        String time = new SimpleDateFormat("hh:mm:ss a").format(new Date());
        return String.format("Hello %s, the time here is %s", name, time);
    }

}
