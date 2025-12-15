package org.example.demo_plugin.settings


import com.intellij.openapi.options.Configurable
import com.intellij.openapi.project.Project
import javax.swing.JComponent

/**
 * IntelliJ Platform Configurable implementation that integrates the plugin's
 *  settings UI into the IDE Settings/Preferences dialog.
 *
 * Responsibilities:
 * - Create and dispose the Swing UI defined by [SettingsComponent].
 * - Read persisted values from [SettingsState] and populate the UI (see [reset]).
 * - Detect user changes (see [isModified]).
 * - Persist the updated values back to [SettingsState] (see [apply]).
 *
 * Lifecycle notes:
 * - [createComponent] is called lazily by the IDE when the settings page is opened.
 * - [reset] is called to initialize the UI with the current persisted state.
 * - [isModified] is polled by the IDE to enable/disable the Apply button.
 * - [apply] is invoked when the user clicks Apply/OK.
 * - [disposeUIResources] must release Swing references to avoid memory leaks.
 *
 *
 * @param project the project whose settings are being edited; used to access
 * [SettingsState] which is registered as a project-level service.
 */
class SettingsConfigurable(private val project: Project) : Configurable {

    private var settingsComponent: SettingsComponent? = null

    /**
     * The name displayed in the Settings/Preferences tree for this page.
     */
    override fun getDisplayName(): String = "Your APP Settings"

    /**
     * Provides the preferred focusable component within the settings UI so
     * that the IDE can place the text caret appropriately when the page opens.
     *
     * @return the component to receive focus, or null if the UI hasn't been created yet.
     */
    override fun getPreferredFocusedComponent(): JComponent? {
        return settingsComponent?.preferredFocusedComponent
    }

    /**
     * Creates the settings UI and returns its root component for embedding
     * in the IDE dialog.
     *
     * @return the root Swing component of this settings page, or null if creation failed.
     */
    override fun createComponent(): JComponent? {
        settingsComponent = SettingsComponent()
        return settingsComponent?.panel
    }


    /**
     * Checks if the settings have been modified by comparing the current state
     * of the settings UI components with the persisted settings state.
     *
     * @return true if the current settings differ from the saved state, false otherwise
     */
    override fun isModified(): Boolean {
        val settings = SettingsState.getInstance(project).state
        val component = settingsComponent ?: return false

        return component.apiKey != settings.apiKey ||
                component.organizationName != settings.organizationName
    }

    /**
     * Saves the current state of the settings from the UI components into the persistent storage.
     *
     * This method retrieves the singleton instance of the settings state for the current project
     * and updates its properties with the values provided by the `settingsComponent`, if available.
     * Specifically, it updates the API key and organization name in the settings state.
     *
     * If the `settingsComponent` is null, the method does nothing.
     */
    override fun apply() {
        val settings = SettingsState.getInstance(project)
        val component = settingsComponent ?: return

        settings.state.apiKey = component.apiKey
        settings.state.organizationName = component.organizationName
    }

    /**
     * Restores the settings UI components to their last persisted state.
     *
     * This method retrieves the current settings state for the project using the `SettingsState` singleton
     * and updates the `settingsComponent` (if not null) with the persisted values of `apiKey`
     * and `organizationName`.
     *
     * If the `settingsComponent` is null, no action is taken.
     */
    override fun reset() {
        val settings = SettingsState.getInstance(project).state
        val component = settingsComponent ?: return

        component.apiKey = settings.apiKey
        component.organizationName = settings.organizationName
    }

    /**
     * Releases references to Swing components to help the IDE dispose of the
     * UI and prevent memory leaks when the settings dialog is closed.
     */
    override fun disposeUIResources() {
        settingsComponent = null
    }
}
