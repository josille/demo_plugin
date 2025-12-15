Demo Plugin for IntelliJ IDEA — Action Placement Guide
=====================================================

This repository is a small demo project to show where plugins can be placed inside IntelliJ IDEA. It demonstrates practical examples of placing actions across menus, toolbars, context menus, tool windows, and the Settings/Preferences dialog.

What’s included
---------------
- Main menu groups (File, Edit, View, Navigate/Go To, Code, Refactor, Build, Run, Tools, VCS, Window, Help)
- A custom top‑level main menu group
- Toolbars (main toolbar left/center/right, navigation bar)
- Context and popup menus (Editor, Editor tab, Console editor, Project view, Diff viewer/gutter, Structure view)
- VCS tool window popups (Changes View, Add Unversioned, File History)
- A simple Settings/Preferences page under Tools

Use this as a reference while developing your own plugins: `plugin.xml` shows the registrations, and the Kotlin classes show minimal `AnAction` implementations.

Plugin JB template
__________________
https://github.com/JetBrains/intellij-platform-plugin-template

Quick Start
-----------
1. Prerequisites: recent IntelliJ IDEA (Community or Ultimate) and a compatible JDK (e.g., 17, see `gradle.properties`).
2. Open the project in IntelliJ IDEA.
3. Run the IDE with the plugin: Gradle tool window → Tasks → intellij → `runIde` (or `./gradlew runIde`).
4. In the launched sandbox IDE, look for demo actions (many are prefixed with "(Rodrigo)") across menus, toolbars, and context menus.

Build
-----
- Build a distributable ZIP: `./gradlew buildPlugin`
- The artifact will be located in `build/distributions/`.

Project Structure (high level)
------------------------------
- `src/main/resources/META-INF/plugin.xml` — plugin metadata and action registrations/placements via `add-to-group`, `group-id`, and `anchor`.
- `src/main/kotlin/org/example/demo_plugin/` — Kotlin sources grouped by area:
  - `main_menu/` — actions in standard and custom main menus
  - `toolbar/` — actions placed on various toolbars
  - `context/`, `submenu/` — editor, project view, diff viewer, and other popups
  - `toolwindow/` — actions under VCS/Changes view and related popups
  - `settings/` — a simple configurable page under Tools
- Build files: `build.gradle.kts`, `gradle.properties`, `settings.gradle.kts`

Exploring Placements
--------------------
- Open `META-INF/plugin.xml` and search for `add-to-group` to see where actions are inserted.
- Cross‑reference the action `id` and `class` with the Kotlin files to see implementation and text presentation.
- Launch with `runIde` and right‑click different UI areas (editor, tabs, project view, diff, VCS) to find the demo entries.

FAQ
---
- What languages can I use to write plugins?
  - Java: This is the traditional language for IntelliJ plugins and is fully supported. The vast majority of the IntelliJ Platform's codebase is still Java (though Kotlin is taking over), so you'll find plenty of examples and API usages in Java.
  - Other JVM Languages: Since plugins run on the JVM, you can theoretically use languages like Scala or Groovy. However, the tooling and documentation are heavily optimized for Kotlin and Java. Using other languages might require more manual configuration for the build process (Gradle) and might lack some of the dedicated IDE support for plugin development (like code inspections and UI designers).

- Difference between Plugin actions and extensions:
  - Purpose:
    - Extensions: Integrate with platform subsystems via EPs.
    - Actions: Provide commands the user can trigger.
  - Where registered:
    - Extensions: <extensions> (EP-specific tags; require the EP’s namespace).
    - Actions: <actions> (with <action>/<group> plus <add-to-group> and shortcuts).
  - Triggered by:
    - Extensions: Platform events/flows (indexing, PSI operations, settings opening, etc.).
    - Actions: User gestures (menus, toolbar buttons, context menus, shortcuts).
  - UI visibility:
    - Extensions: Usually none (unless the EP is for UI, e.g., settings page, tool window).
    - Actions: Visible entries/buttons and searchable commands.

## Extension VS Action

In an IntelliJ Platform plugin, **an *action*** and **an *extension element*** are two different ways you “plug into” the IDE:

- **Action** = something the *user triggers* (a command).
- **Extension element** = something the *platform discovers and uses* (a contribution to IDE behavior).

## 1) Action (user-invoked command)

An **action** is a class (usually extending `AnAction`) that the IDE can invoke in response to a UI event:

- user clicks a menu item / toolbar button
- user presses a keymap shortcut
- user uses *Find Action* (`⇧⌘A` on macOS) and runs it

Key points:
- Has explicit lifecycle hooks like `actionPerformed()` (what it does) and often `update()` (enable/disable, change text, etc.).
- Must be **registered** (typically in `plugin.xml` under `<actions>`) and optionally **placed** into menus/toolbars and assigned shortcuts.
- Conceptually: *“Here is a command the user can run.”*

Typical examples:
- “Generate Something…”
- “Reformat with My Rules”
- “Open Custom Tool Window”

## 2) Extension element (platform-invoked contribution)

An **extension element** is an entry in `plugin.xml` that registers an implementation for an **extension point** (EP) defined by the IntelliJ Platform (or another plugin). The platform loads it and calls it as part of normal IDE operation.

Key points:
- The IDE is the one that decides *when/if* to use it.
- It typically wires your implementation into some subsystem: inspections, annotators, completion providers, tool windows, project wizards, VCS integration, etc.
- Registered under `<extensions defaultExtensionNs="com.intellij"> ... </extensions>` (or another namespace).
- Conceptually: *“When the IDE needs X, here’s my implementation of X.”*

Typical examples:
- `com.intellij.toolWindow` → add a tool window
- `com.intellij.localInspection` → add an inspection
- `com.intellij.annotator` → add highlighting/annotations
- `com.intellij.completion.contributor` → add code completion

## The relationship between them

They often **work together**:

- An **extension** might integrate your feature into the editor (e.g., an inspection detects a problem).
- An **action** might be used as the fix/command (e.g., “Apply Quick Fix” or “Run My Formatter”).

But they’re not the same thing:
- You can have an action with no extensions (pure command).
- You can have extensions with no actions (pure background integration).

### Quick mental model

- **Action:** “User asks the IDE to do something now.”
- **Extension element:** “IDE asks plugins for participants/providers to implement behavior.”

If you tell me what kind of feature you’re building (menu command, editor highlighting, completion, tool window, etc.), I can point to the most appropriate extension points vs. action registrations for it.