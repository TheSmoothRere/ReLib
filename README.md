# ReLib

General-purpose utility library for Fabric mods, originally built for TheSmoothRere's mods but open for anyone to use.

## Features

- **Config system** — Define configuration classes with the `@Config` annotation
- **Auto-discovery** — Configs are automatically discovered via Fabric entrypoints and registered at startup
- **JSON persistence** — Config values are saved/loaded as pretty-printed JSON via Gson
- **Typed options** — `BooleanOption`, `StringOption`, `IntegerOption`, `DoubleOption`, `EnumOption<E>`, `ListStringOption`
- **Bounded ranges** — `IntegerOption` and `DoubleOption` enforce min/max bounds
- **List support** — `ListStringOption` backed by a mutable `ListString` wrapper with `add`, `edit`, `remove`, `clear`

## Usage

### 1. Create a config class

```java
import io.github.thesmoothrere.relib.config.ListString;
import io.github.thesmoothrere.relib.config.option.*;

@Config(name = "my_mod")
public class MyModConfig implements ConfigApi {

    private final BooleanOption enabled = new BooleanOption("enabled", true);
    private final IntegerOption volume = new IntegerOption("volume", 50, 0, 100);
    private final DoubleOption sensitivity = new DoubleOption("sensitivity", 0.5, 0.0, 1.0);
    private final StringOption greeting = new StringOption("greeting", "Hello!");
    private final EnumOption<MyEnum> mode = new EnumOption<>("mode", MyEnum.NORMAL);
    private final ListStringOption favoriteColors = new ListStringOption("favorite_colors", "red", "blue");

    public ConfigOption<Boolean> enabled() {
        return enabled;
    }

    public ConfigOption<Integer> volume() {
        return volume;
    }

    public ConfigOption<Double> sensitivity() {
        return sensitivity;
    }

    public ConfigOption<String> greeting() {
        return greeting;
    }

    public ConfigOption<MyEnum> mode() {
        return mode;
    }

    public ConfigOption<ListString> favoriteColors() {
        return favoriteColors;
    }
}
```

### 2. Register the entrypoint in `fabric.mod.json`

```json
{
  "entrypoints": {
    "relib": [
      "com.example.MyModConfig"
    ]
  }
}
```

### 3. Access your config anywhere

```java
MyModConfig config = ConfigManager.get(MyModConfig.class);
boolean enabled = config.enabled().getValue();

ConfigManager.load(config);
ConfigManager.save(config);
```

## Option Types

| Class | Value Type | Bounded |
|-------|-----------|---------|
| `BooleanOption` | `Boolean` | No |
| `StringOption` | `String` | No |
| `IntegerOption` | `Integer` | Yes |
| `DoubleOption` | `Double` | Yes |
| `EnumOption<E>` | `E extends Enum<E>` | No |
| `ListStringOption` | `ListString` | No |

## License

Licensed under the **GNU Lesser General Public License v2.1**. See `LICENSE`.
