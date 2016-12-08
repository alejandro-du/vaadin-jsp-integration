package org.vaadin.jsp;

import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.Version;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * JSP tag handler implementation that constructs the HTML required to render a Vaadin UI.
 *
 * @author Alejandro Duarte
 */
public class VaadinTagHandler extends SimpleTagSupport {

    public static final String TEMPLATE_FILE_NAME = "template.html";

    private String url;

    private String theme;

    private String widgetset;

    private String vaadindir;

    private boolean debug = false;

    @Override
    public void doTag() {
        try {
            String template = getTemplate();
            String html = setVariables(template);
            getJspContext().getOut().write(html);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getTemplate() {
        final InputStream inputStream = getClass().getClassLoader().getResourceAsStream(TEMPLATE_FILE_NAME);
        Scanner scanner = new Scanner(inputStream);
        StringBuilder stringBuilder = new StringBuilder();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            stringBuilder.append(line).append("\n");
        }

        scanner.close();

        return stringBuilder.toString();
    }

    private String setVariables(String template) {
        PageContext pageContext = (PageContext) getJspContext();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

        String divId = url.substring(1).replaceAll("/", "-");
        String vaadinVersion = Version.getFullVersion();
        String context = request.getContextPath();

        return template
                .replace("${divId}", divId)
                .replace("${theme}", theme != null ? theme : "valo")
                .replace("${vaadinVersion}", vaadinVersion)
                .replace("${widgetset}", widgetset != null ? widgetset : VaadinServlet.DEFAULT_WIDGETSET)
                .replace("${vaadinDir}", vaadindir != null ? vaadindir : context + "/VAADIN/")
                .replace("${browserDetailsUrl}", context + url)
                .replace("${serviceUrl}", context + url)
				        .replace("${debugMode}", debug? "true":"false");
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

    public void setVaadindir(String vaadindir) {
        this.vaadindir = vaadindir;
    }

    public void setDebug(String debug) {
    	this.debug = "true".equals(debug);
    }

}
