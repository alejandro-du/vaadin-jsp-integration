package org.vaadin.struts2;

import com.opensymphony.xwork2.util.ValueStack;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.Version;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Scanner;

public class VaadinComponent extends Component {

    private String url;

    private String theme;

    private String widgetset;

    public VaadinComponent(ValueStack stack) {
        super(stack);
    }

    @Override
    public boolean start(Writer writer) {
        try {
            String template = getTemplate();
            String html = setVariables(template);
            writer.write(html);
            return true;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getTemplate() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("template.html");
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
        String divId = url.substring(1).replaceAll("/", "-");
        String vaadinVersion = Version.getFullVersion();
        String context = ServletActionContext.getRequest().getContextPath();

        return template
                .replace("${divId}", divId)
                .replace("${theme}", theme == null ? VaadinServlet.DEFAULT_THEME_NAME : theme)
                .replace("${vaadinVersion}", vaadinVersion)
                .replace("${widgetset}", widgetset == null ? VaadinServlet.DEFAULT_WIDGETSET : widgetset)
                .replace("${vaadinDir}", context + "/VAADIN/")
                .replace("${browserDetailsUrl}", context + url)
                .replace("${serviceUrl}", context + url);
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
