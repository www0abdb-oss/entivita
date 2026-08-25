<div align="center">
  <a href="https://github.com/www0abdb-oss/entivita">
    <img src="https://raw.githubusercontent.com/www0abdb-oss/data-lpll/refs/heads/main/loge.png" alt="Entivita logo" width="80" height="80">
  </a>

# Entivita

**Minecraft 26.2 · Fabric · Client-Side Health Indicators**

Entivita is a lightweight client-side Fabric mod for Minecraft 26.2 that displays health information for living entities directly in the game world.

It uses Minecraft's familiar health and heart systems to make entity health easier to understand during gameplay, with support for player health indicators and configurable heart rendering.

[![Latest Release](https://img.shields.io/github/v/release/www0abdb-oss/entivita?style=flat-square\&logo=github)](https://github.com/www0abdb-oss/entivita/releases)
[![Latest Tag](https://img.shields.io/github/v/tag/www0abdb-oss/entivita?style=flat-square\&sort=semver)](https://github.com/www0abdb-oss/entivita/tags)
[![GitHub Stars](https://img.shields.io/github/stars/www0abdb-oss/entivita?style=flat-square\&logo=github)](https://github.com/www0abdb-oss/entivita/stargazers)
[![Minecraft](https://img.shields.io/badge/Minecraft-26.2-3C8527?style=flat-square)](https://www.minecraft.net/)
[![Fabric](https://img.shields.io/badge/Fabric-Client--Side-DBD0B4?style=flat-square)](https://fabricmc.net/)
[![Java](https://img.shields.io/badge/Java-25%2B-ED8B00?style=flat-square)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-Apache%202.0-2F3A4A?style=flat-square)](LICENSE)
[![entivita on Modrinth](https://img.shields.io/modrinth/dt/entivita?style=flat-square&logo=modrinth&logoColor=%23ffffff&label=Modrinth&color=%231bd96a&labelColor=%231a1a1a)](https://modrinth.com/mod/entivita)

[**Modrinth**](https://modrinth.com/project/entivita) · [**Releases**](https://github.com/www0abdb-oss/entivita/releases) · [**Discord**](https://discord.gg/TwdqTFExVT) · [**OSSDrop**](https://ossdrop.com/tool/entivita)

</div>

---

## Overview

Entivita is a **client-side health indicator mod for Minecraft Java Edition 26.2 using Fabric**.

The mod displays health information for living entities while keeping the presentation close to Minecraft's existing visual language. Health can be represented using numeric information and Minecraft-style heart indicators, helping players quickly understand the state of nearby entities.

Entivita is designed to remain lightweight and focused on health visibility without adding unnecessary gameplay systems.

## Features

* Displays current and maximum health for living entities.
* Provides heart-based health indicators for other players.
* Uses Minecraft's existing heart textures and visual system.
* Supports health and heart rendering for supported living entities.
* Configurable health indicator rendering.
* Configurable heart stacking.
* Configurable vertical heart offset.
* Designed as a client-side Fabric mod.
* Focused on lightweight, readable health information.

## Client-Side

Entivita is designed as a **client-side mod**.

You can use it without requiring Entivita to be installed on the server. The mod handles its health indicator rendering on the client.

## Requirements

* **Minecraft Java Edition 26.2**
* **Fabric Loader 0.19.3 or newer**
* **Fabric API**
* **Java 25 or newer**

## Installation

1. Install **Fabric Loader** for Minecraft 26.2.
2. Install **Fabric API** for Minecraft 26.2.
3. Download the latest Entivita release from [GitHub Releases](https://github.com/www0abdb-oss/entivita/releases) or [Modrinth](https://modrinth.com/project/entivita).
4. Place the Entivita `.jar` file in your Minecraft `mods` folder.
5. Start Minecraft using the Fabric profile.

Entivita does not need to be installed on the server.

## Configuration

Entivita stores its configuration in:

```text
config/entivita.json
```

Current configuration options include:

| Option                 | Description                                         |
| ---------------------- | --------------------------------------------------- |
| `renderingEnabled`     | Enables or disables health indicator rendering.     |
| `heartStackingEnabled` | Controls heart stacking behavior.                   |
| `heartOffset`          | Controls the vertical position of heart indicators. |

Configuration options may change as development continues.

## Compatibility

Entivita is currently developed and tested for:

* Minecraft **26.2**
* Fabric Loader **0.19.3+**
* Java **25+**

Compatibility with other Minecraft versions is not guaranteed unless explicitly supported by a corresponding release.

## Development Status

Entivita is actively developed for Minecraft 26.2.

Rendering behavior, configuration options, and compatibility may change between development versions.

For stable downloads, use the published releases rather than development builds.

## Building From Source

Clone the repository and build the project with Gradle:

```bash
git clone https://github.com/www0abdb-oss/entivita.git
cd entivita
./gradlew clean build
```

The compiled JAR files are generated in:

```text
build/libs/
```

## Contributing

Contributions, bug reports, testing, and documentation improvements are welcome.

When reporting a problem, please provide as much relevant information as possible, including:

* Entivita version
* Minecraft version
* Fabric Loader version
* Fabric API version
* Other installed mods
* Steps to reproduce the problem
* Crash report or relevant game log

For code changes, please keep changes focused and consistent with the existing project structure.

## Project Links

| Resource          | Link                                                                 |
| ----------------- | -------------------------------------------------------------------- |
| Source code       | [GitHub Repository](https://github.com/www0abdb-oss/entivita)        |
| Downloads         | [GitHub Releases](https://github.com/www0abdb-oss/entivita/releases) |
| Mod page          | [Modrinth](https://modrinth.com/project/entivita)                    |
| Community         | [Discord](https://discord.gg/TwdqTFExVT)                             |
| Project discovery | [OSSDrop](https://ossdrop.com/tool/entivita)                         |
| Instagram         | [@www0abdb2026](https://www.instagram.com/www0abdb2026)              |
| YouTube           | [abd_errahim-mine](https://youtube.com/@abd_errahim-mine)            |

## Project Independence

Entivita is an independent open-source project developed and maintained by `www0abdb-oss` and its contributors.

The project is independently developed and maintained through its official GitHub repository. This repository serves as the primary source for Entivita's source code, development history, releases, documentation, and official project information.

Entivita is not affiliated with, endorsed by, sponsored by, or officially associated with other projects, repositories, organizations, or developers that may use the same or similar names.

Similarities in names, concepts, features, implementations, or descriptions between projects do not imply collaboration, shared authorship, shared ownership, or a common origin.

The official Entivita source code, development history, releases, and documentation are maintained through this repository and its associated official project pages.

For accurate information about Entivita, users should refer to the official links provided in this README rather than relying on unofficial copies, mirrors, or third-party descriptions.

The project remains open to community participation. Contributions, collaboration, testing, bug reports, documentation improvements, and feedback are welcome.

### Official Project Sources

* **Source Code:** [GitHub Repository](https://github.com/www0abdb-oss/entivita)
* **Releases:** [GitHub Releases](https://github.com/www0abdb-oss/entivita/releases)
* **Mod Page:** [Modrinth](https://modrinth.com/project/entivita)
* **Project Discovery:** [OSSDrop](https://ossdrop.com/tool/entivita)


---

### Top Contributors

Entivita is an open-source project and welcomes contributions from developers and community members.

<p align="center" style="margin: 20px 0;">
  <a href="https://github.com/www0abdb-oss/entivita/graphs/contributors">
    <img src="https://contrib.rocks/image?repo=www0abdb-oss/entivita" alt="Entivita contributors" style="max-width: 100%;">
  </a>
</p>

The contributor list is generated from the project's GitHub contribution history.

For the complete and current contribution history, visit the [GitHub contributors page](https://github.com/www0abdb-oss/entivita/graphs/contributors).

---

## License

Entivita is licensed under the [Apache License 2.0](LICENSE).

## Disclaimer

Entivita is an independent Minecraft project and is not affiliated with, endorsed by, or sponsored by Mojang Studios or Microsoft.

Minecraft is a trademark of Microsoft Corporation.

---

<div align="center">

**Client-Side · Lightweight · Health Indicators for Minecraft**

<a href="https://github.com/www0abdb-oss/entivita">
  <img src="https://raw.githubusercontent.com/www0abdb-oss/data-lpll/refs/heads/main/lsiid.png" alt="Entivita">
</a>

<br>

[GitHub](https://github.com/www0abdb-oss/entivita) ·
[Modrinth](https://modrinth.com/project/entivita) ·
[Discord](https://discord.gg/TwdqTFExVT) ·
[OSSDrop](https://ossdrop.com/tool/entivita)

</div>

---

<p align="center">
  <a href="https://ossdrop.com/tool/entivita">
    <img src="https://ossdrop.com/badge/entivita?theme=dark" alt="entivita on OSSDrop">
  </a>
</p>
