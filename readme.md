# KUBE
**KUBE** - **K**otlin **U**i **B**uilder.

A modern, type-safe Kotlin library for building web interfaces with a declarative DSL approach. KUBE simplifies the creation of internal web interfaces, admin panels, and web applications by providing a clean, composable API for UI components.

## ✨ Features

- 🎨 **Declarative DSL** - Build UIs using Kotlin's type-safe DSL
- 🧩 **Composable Components** - Reusable UI components with modifiers
- 🎯 **Framework Integration** - Works with Spring Boot, Ktor, and HTMX
- 📱 **Responsive Design** - Built-in support for mobile and desktop layouts
- 🎨 **Customizable Styling** - CSS-in-Kotlin with type-safe styling
- ⚡ **HTMX Support** - Modern web interactions without complex JavaScript
- 🔧 **Plugin Architecture** - Extensible with custom plugins

## 🚀 Quick Start

### Spring Boot Integration

```kotlin
@RestController
class MyController {
    @GetMapping("/")
    fun homePage() = render {
        box(
            modifier = Modifier.fillMaxSize().backgroundColor("#f5f5f5"),
            verticalAlignment = Alignment.Vertical.Center,
            horizontalAlignment = Alignment.Horizontal.Center
        ) {
            column {
                text("Welcome to KUBE!", fontSize = FontSize.Large)
                text("Building UIs with Kotlin DSL")
                
                form(action = "/submit", method = HttpMethod.POST) {
                    textInput(name = "username", placeholder = "Enter username")
                    buttonInput(text = "Submit", type = ButtonType.SUBMIT)
                }
            }
        }
    }
}
```

### Ktor Integration

```kotlin
fun Application.module() {
    install(KubeCore) { useHtmx = true }
    
    routing {
        get("/") {
            call.respondRender {
                box {
                    text("Hello from Ktor + KUBE!")
                }
            }
        }
    }
}
```

## 📦 Installation

KUBE is available on [Maven Central](https://mvnrepository.com/artifact/dev.syncended).

### Gradle (Kotlin DSL)
```kotlin
dependencies {
    implementation("dev.syncended:kube-core:0.3.4")
    implementation("dev.syncended:kube-spring:0.3.4") // For Spring Boot
    implementation("dev.syncended:kube-ktor:0.3.4")   // For Ktor
    implementation("dev.syncended:kube-htmx:0.3.4")   // For HTMX support
}
```

### Maven
```xml
<dependency>
    <groupId>dev.syncended</groupId>
    <artifactId>kube-core</artifactId>
    <version>0.3.4</version>
</dependency>
```

## 🏗️ Architecture

KUBE is built with a modular architecture:

- **`kube-core`** - Core UI components and DSL
- **`kube-htmx`** - HTMX integration for dynamic content
- **`kube-spring`** - Spring Boot integration
- **`kube-ktor`** - Ktor integration

## 📚 Examples

Check out the live demo at [https://kube.syncended.dev](https://kube.syncended.dev)

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📄 License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

## 🔗 Links

- **Documentation**: [https://kube.syncended.dev](https://kube.syncended.dev)
- **Maven Central**: [https://mvnrepository.com/artifact/dev.syncended](https://mvnrepository.com/artifact/dev.syncended)
- **Latest Release**: Check the [releases page](../../releases) for the latest version

## 📦 Available Packages

- [kube-core](https://mvnrepository.com/artifact/dev.syncended/kube-core) - Core UI components
- [kube-htmx](https://mvnrepository.com/artifact/dev.syncended/kube-htmx) - HTMX integration
- [kube-spring](https://mvnrepository.com/artifact/dev.syncended/kube-spring) - Spring Boot integration
- [kube-ktor](https://mvnrepository.com/artifact/dev.syncended/kube-ktor) - Ktor integration
