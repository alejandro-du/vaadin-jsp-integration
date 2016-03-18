package org.vaadin.struts2;

import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VaadinTag extends ComponentTagSupport {

    private String className;

    @Override
    public Component getBean(ValueStack valueStack, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return new VaadinComponent(valueStack);
    }

    @Override
    protected void populateParams() {
        super.populateParams();

        VaadinComponent component = (VaadinComponent) getComponent();
        component.setClassName(className);
    }

    public void setClassName(String className) {
        this.className = className;
    }

}
