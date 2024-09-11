# KUBE
**KUBE** - **K**otlin **U**i **B**uilder.

**KUBE** is an open-source library, that simplifies your routine of creating internal web interfaces (like an admin panel, or smth else).

Sample webpage written using this library available at https://kube.syncended.dev

## How to
### Webpage
To create webpage - you should just using high-level funcitons of layout like
`box`, `column`, `row`, etc.

Each method support `RenderMode`. Render mode - is an description how element should be rendered.
- `PAGE` - include built in styles, attach js/css code on page, support scaling and etc
- `VIEW_ONLY` - just render element, without any resources on it (it will be used to render dynamic elements of HTMX)  

### Resource mode
Resource mode can be modified over call `Kube.setResourceMode`

There is 2 possible values:
- `FAT` - put every used resource in single page. Page will include fonts/css/js code inside
- `LINK` - currently unsupported. Webpage will include each resource as `link`. Resources will
    be loaded asynchronously. (Better prformance for webpage loading)

### Modifier
Widget state holder. Every parameters of element is modifier.
Modifier may contains widget-specific data, like `textColor`, `href`. Elements 
use it as point of truth, when it render.

You can access to element's modifier from element body

For example
```kotlin
// Same elements
text(text = "Sample text")
text { modifier.text("Sample text") }
```

You can use modifier to customize styling, attributes and behavior of element.

## Roadmap
Basic steps, which probably will be supported

- Basic html elements support
  - Buttons
  - Forms
  - Dropdown menu
- Styling
  - ~~Mobile/desktop changes~~
- Maven publish
- Github releases
- Web page templates
  - Table view
  - List view 
- ~~Spring configuration~~
- Ktor extensions
- Extended elements
  - Markdown viewer
- HTMX support
