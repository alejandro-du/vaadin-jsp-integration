[![Published on Vaadin  Directory](https://img.shields.io/badge/Vaadin%20Directory-published-00b4f0.svg)](https://vaadin.com/directory/component/jsp-integration)
[![Stars on Vaadin Directory](https://img.shields.io/vaadin-directory/star/jsp-integration.svg)](https://vaadin.com/directory/component/jsp-integration)
[![Latest version on vaadin.com/directory](https://img.shields.io/vaadin-directory/v/jsp-integration.svg)](https://img.shields.io/vaadin-directory/v/jsp-integration.svg)

# JSP Integration Add-on for Vaadin 7
JSP Integration is a Vaadin 7 add-on that allows you to render Vaadin UIs in JSP pages.

## Usage
Add the tag library and use the `ui` tag to point to the URL mapped to the `VaadinServlet` serving your UI:
```jsp
<%@taglib prefix="vaadin" uri="/vaadin" %>

<vaadin:ui url="/myui"/>
```

You can optionally specify a custom widgetset and a theme:
````jsp
<vaadin:ui url="/myui" widgetset="com.example.MyUiWidgetset" theme="mytheme"/>
```

## Licence
The code is licensed under the [Apache 2.0 License](http://www.apache.org/licenses/LICENSE-2.0.txt).
