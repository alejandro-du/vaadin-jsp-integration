package org.vaadin.struts2;

import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * JSTL tag for Vaadin UIs.
 *
 * @author Alejandro Duarte
 */
public class VaadinTag extends ComponentTagSupport {

    private String url;

    private String theme;

    private String widgetset;

    @Override
    public Component getBean(ValueStack valueStack, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return new VaadinComponent(valueStack);
    }

    @Override
    protected void populateParams() {
        super.populateParams();

        VaadinComponent component = (VaadinComponent) getComponent();
        component.setUrl(url.startsWith("/") ? url : "/" + url);
        component.setTheme(theme);
        component.setWidgetset(widgetset);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setWidgetset(String widgetset) {
        this.widgetset = widgetset;
    }

}
