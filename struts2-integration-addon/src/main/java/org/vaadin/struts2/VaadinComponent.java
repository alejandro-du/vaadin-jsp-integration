package org.vaadin.struts2;

import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;

import java.io.IOException;
import java.io.Writer;

public class VaadinComponent extends Component {

    private String className;

    public VaadinComponent(ValueStack stack) {
        super(stack);
    }

    @Override
    public boolean start(Writer writer) {
        try {
            writer.write(className);
            return true;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setClassName(String className) {
        this.className = className;
    }

}
