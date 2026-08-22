# Entivita

**Minecraft 26.2 · Fabric · Client-Side Health Indicators**

Entivita is a client-side Fabric mod for Minecraft 26.2 that displays health information for living entities and renders heart indicators for other players.

The project focuses on providing a clear and lightweight way to see entity health during gameplay while using Minecraft's existing health and heart systems.

[![Minecraft](https://img.shields.io/badge/Minecraft-26.2-3C8527?style=flat-square)](https://www.minecraft.net/)
[![Fabric](https://img.shields.io/badge/Fabric-Client--Side-DBD0B4?style=flat-square)](https://fabricmc.net/)
[![Fabric Loader](https://img.shields.io/badge/Fabric%20Loader-0.19.3%2B-DBD0B4?style=flat-square)](https://fabricmc.net/)
[![Java](https://img.shields.io/badge/Java-25%2B-ED8B00?style=flat-square)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-Apache%202.0-2F3A4A?style=flat-square)](LICENSE)

---

## Overview

Entivita integrates with Minecraft's client-side entity rendering system to present health information in the game world.

The mod reads the health values already provided by Minecraft and displays them without replacing or modifying Minecraft's health system.

The current project targets:

- Minecraft 26.2
- Fabric
- Client-side operation
- Java 25 or newer

Entivita is currently under active development.

---

## Features

### Health Information

Displays the current and maximum health values of living entities.

### Player Health Indicators

Renders heart-based health indicators for other players.

### Minecraft Heart Textures

Uses Minecraft's existing heart textures for the heart indicators rather than introducing a separate heart texture system.

### Absorption

Supports the corresponding Minecraft absorption heart states where applicable.

### Rendering Controls

Provides controls for enabling or disabling health indicator rendering.

### Heart Stacking

Provides a setting for controlling the stacking behavior of heart indicators.

### Heart Offset

Provides a setting for adjusting the vertical position of heart indicators.

---

## Supported Environment

| Component | Requirement |
|---|---|
| Minecraft | 26.2 |
| Mod Loader | Fabric |
| Fabric Loader | 0.19.3 or newer |
| Java | 25 or newer |
| Fabric API | Required |
| Environment | Client |

Entivita is configured as a client-side mod and does not require Entivita to be installed on the server.

Compatibility with other mods can vary, especially when another mod changes Minecraft's entity or rendering behavior.

---

## Installation

### Requirements

Install the following before using Entivita:

1. Minecraft Java Edition 26.2
2. Fabric Loader 0.19.3 or newer
3. Fabric API for Minecraft 26.2

### Install the Mod

1. Download the appropriate Entivita JAR.
2. Open the Minecraft `mods` directory.
3. Place the Entivita JAR in the directory.
4. Make sure the required Fabric API version is installed.
5. Start Minecraft with the Fabric profile.

Entivita is designed for client-side use, so the server does not need to install the mod.

---

## Configuration

Entivita stores its configuration in:

```text
config/entivita.json
