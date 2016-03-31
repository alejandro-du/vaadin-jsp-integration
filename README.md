# Struts2 Integration Add-on for Vaadin 7
Struts2 Integration is a Vaadin 7 add-on that allows you to render Vaadin UIs in JSP-based Struts2 applications.

## Usage
Add the tag library and use the `ui` tag to point to the URL mapped to the `VaadinServlet` serving your UI:
```jsp
<%@taglib prefix="vaadin" uri="/vaadin" %>

<vaadin:ui url="/myui"/>
```

You can optionally specify a custom widgetset and a theme:
````jsp
<vaadin:ui url="/myui" widgetset="com.example.webapp.vaadin.MyUiWidgetset" theme="mytheme"/>
```

## Licence
The code is licensed under the [Apache 2.0 License](http://www.apache.org/licenses/LICENSE-2.0.txt).
