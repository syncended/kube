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
Common widget settings, like `backgroundColor`, `padding` and smth else.
Each modifier will be applied to web element, as style/attribute of it.

To create simple modifier - just call `Modifier` ~~(like a Compose)~~
```kotlin
text(text = "Sample text", modifier = Modifier.marginLeft(2.rm))
space(Modifier.height(1.rm))
```

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
