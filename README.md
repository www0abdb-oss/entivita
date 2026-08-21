# Entivita

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](LICENSE)
[![Minecraft](https://img.shields.io/badge/Minecraft-26.2-green.svg)](https://www.minecraft.net/)
[![Fabric](https://img.shields.io/badge/Mod%20Loader-Fabric-orange.svg)](https://fabricmc.net/)
[![Environment](https://img.shields.io/badge/Environment-Client-blueviolet.svg)](https://fabricmc.net/)

Entivita is a client-side health indicator mod for Minecraft 26.2 using the Fabric mod loader.

The mod displays health information for living entities and provides a visual heart-based health indicator for other players. It is designed to make entity health easier to identify during gameplay while keeping the implementation lightweight and client-side.

## Features

* Health information displayed above living entities.
* Numeric health values showing current and maximum health.
* Heart-based health indicators for other players.
* Support for normal health and absorption hearts.
* Configurable health indicator rendering.
* Configurable heart stacking behavior.
* Adjustable vertical heart offset.
* Client-side implementation.
* Uses Minecraft's existing heart textures.
* Open-source development under the Apache License 2.0.

## Supported Environment

| Component     | Version         |
| ------------- | --------------- |
| Minecraft     | 26.2            |
| Mod Loader    | Fabric          |
| Fabric Loader | 0.19.3 or newer |
| Java          | 25 or newer     |
| Fabric API    | Required        |
| Environment   | Client          |

## Installation

1. Install Minecraft 26.2.
2. Install Fabric Loader 0.19.3 or newer.
3. Install the required Fabric API version for Minecraft 26.2.
4. Download the Entivita JAR from the project's releases.
5. Place the JAR file in the Minecraft `mods` directory.
6. Launch Minecraft using the Fabric installation.

Entivita is configured as a client-side mod and does not require a server-side installation.

## Configuration

Entivita stores its configuration in:

```text
config/entivita.json
```

The current configuration provides the following options:

### Health Indicator Rendering

Enables or disables the health indicator rendering.

### Heart Stacking

Controls whether heart indicators are arranged into multiple rows.

### Heart Offset

Adjusts the vertical position of the heart indicator.

Configuration changes are saved automatically to the Entivita configuration file.

## Controls

The current version provides key bindings for:

* Enabling or disabling health indicator rendering.
* Enabling or disabling heart stacking.
* Increasing the heart offset.
* Decreasing the heart offset.

The key bindings can be assigned through Minecraft's standard Controls menu.

No default keyboard key is assigned by Entivita to these actions.

## How It Works

Entivita uses Minecraft's client-side rendering system to add health information to living entity rendering and to render heart indicators for other players.

Health values are read from the entity's existing health data. Entivita does not create or modify the Minecraft health system.

The heart indicators use Minecraft's existing GUI heart textures, including normal and absorption heart states.

## Compatibility

Entivita is developed for Minecraft 26.2 with Fabric.

Compatibility with other mods may depend on changes to Minecraft's rendering system and on modifications made by other rendering or entity-related mods.

If you encounter a compatibility problem, please report it with your Minecraft version, Fabric Loader version, Fabric API version, Entivita version, installed mods, and relevant logs.

## Development Status

Entivita is currently under active development.

The rendering system, configuration options, compatibility, and supported behavior may change during development.

Features documented here describe the current implementation and may be updated as the project evolves.

## Building From Source

Clone the repository:

```bash
git clone https://github.com/www0abdb-oss/entivita.git
cd entivita
```

Build the project:

```bash
./gradlew clean build
```

The generated JAR files can be found in:

```text
build/libs/
```

## Contributing

Contributions are welcome.

You can contribute by:

* Reporting bugs.
* Suggesting improvements.
* Testing the mod.
* Improving documentation.
* Submitting pull requests.

For code contributions, please ensure that the project builds successfully and that changes are tested with Minecraft 26.2.

## Bug Reports

When reporting a bug, include as much relevant information as possible:

* Entivita version.
* Minecraft version.
* Fabric Loader version.
* Fabric API version.
* Other installed mods.
* Steps required to reproduce the problem.
* Crash reports or relevant game logs.

Clear reproduction steps and logs help make debugging faster and more reliable.

## Links

* [GitHub Repository](https://github.com/www0abdb-oss/entivita)
* [Modrinth Project](https://modrinth.com/project/entivita)
* [Discord](https://discord.gg/qECjtAhKD)
* [Instagram](https://www.instagram.com/www0abdb2026)
* [YouTube](https://youtube.com/@abd_errahim-mine)

## License

Entivita is licensed under the Apache License 2.0.

See the [LICENSE](LICENSE) file for the complete license text.

## Disclaimer

Entivita is an independent project and is not affiliated with, endorsed by, or sponsored by Mojang Studios or Microsoft.

Minecraft is a trademark of Mojang Studios.

---

If you find Entivita useful, consider giving the repository a star on GitHub.
