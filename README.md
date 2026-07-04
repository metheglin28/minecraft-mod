# Metheglin's Tweaks

A Fabric mod for **Minecraft 26.2** that trims the game down to the Overworld.

## Features

- **Enchanting table removed** — no crafting recipe, hidden from the creative
  inventory, cannot be placed, existing ones cannot be opened and drop nothing
  when mined.
- **End portal frame removed** — hidden from the creative inventory and cannot
  be placed.
- **Nether dimension disabled** — obsidian frames can never be lit into a
  portal (by any ignition source), and existing portal blocks teleport nothing.
- **End dimension disabled** — stronghold end portal frames cannot be filled
  with eyes of ender, and end portal blocks teleport nothing.

Items *from* those dimensions (netherrack, end stone, blaze rods, ...) are
untouched — only the dimensions themselves are off-limits.

Note: the dimensions still technically exist (removing their registration
would break world saves), so server operators can still reach them with
`/execute in minecraft:the_nether ...`. All survival routes are closed.

## Requirements

- Minecraft **26.2** (Java Edition)
- [Fabric Loader](https://fabricmc.net/use/) 0.19.3+
- [Fabric API](https://modrinth.com/mod/fabric-api) 0.152.x for 26.2
- Java 25

## Installing (Modrinth App)

1. Create a profile for Minecraft **26.2** with the **Fabric** loader.
2. Add **Fabric API** to the profile from Modrinth.
3. Drop `metheglins-tweaks-<version>.jar` from `build/libs/` into the
   profile's `mods` folder (or use "Add file" in the Modrinth App).

## Building

```sh
./gradlew build
```

The mod jar is written to `build/libs/`.
