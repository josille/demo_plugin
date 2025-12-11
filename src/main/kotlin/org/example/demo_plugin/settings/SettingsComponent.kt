package org.example.demo_plugin.settings

import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBPasswordField
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.JComponent
import javax.swing.JPanel

/**
 * A UI component that defines and manages a settings form used in the plugin's settings dialog.
 *
 * Responsibilities:
 * - Provides a panel with labeled input fields for API Key, Organization Name, and Space Name.
 * - Manages the values within the fields, allowing retrieval and updates through associated properties.
 * - Specifies the preferred component to focus on when the settings UI is displayed.
 *
 * Fields:
 * - `apiKeyField`: A password input field for entering the API Key.
 * - `organizationNameField`: A text input field for entering the organization name.
 * - `spaceNameField`: A text input field for entering the space name.
 * - `panel`: The main container for the settings form, arranged using a form builder.
 *
 * Properties:
 * - `apiKey`: Represents the value of the API Key field.
 * - `organizationName`: Represents the value of the Organization Name field.
 * - `spaceName`: Represents the value of the Space Name field.
 * - `preferredFocusedComponent`: Specifies the component that should be focused by default.
 *
 * Usage Context:
 * - Used by the `SettingsConfigurable` class to render and manage the settings page dialog.
 * - Provides access to the form's data and integrates with the IntelliJ Platform settings infrastructure.
 */
class SettingsComponent {

    /**
     * A password field for securely entering the user's API Key in the plugin's settings UI.
     *
     * Purpose:
     * - Collects and stores sensitive API Key information in a hidden format, ensuring data privacy.
     *
     * Characteristics:
     * - The input is obfuscated to prevent leaking sensitive information.
     * - Integrated into the settings form managed by [SettingsComponent].
     *
     * Usage Context:
     * - This field is part of the settings form displayed in the IntelliJ Platform settings dialog.
     * - Its value is linked to the `apiKey` property in [SettingsComponent].
     */
    private val apiKeyField = JBPasswordField()
    /**
     * A text input field for entering the organization name.
     *
     * This field is displayed as part of the settings form within the plugin's settings page.
     * It allows users to specify the name of the organization associated with their configuration.
     *
     * Responsibilities:
     * - Captures user input for the organization name.
     * - Supports retrieval and assignment of the text value through the `organizationName` property.
     *
     * Usage Context:
     * - Managed within the `SettingsComponent` class and integrated into the settings UI.
     * - Used to persist and restore the organization name as part of the settings workflow.
     */
    private val organizationNameField = JBTextField()
    /**
     * A text input field for entering the name of a space.
     *
     * Responsibilities:
     * - Captures and displays the user-provided space name as a text value.
     * - Serves as one of the input fields in the plugin's settings UI, managed by [SettingsComponent].
     *
     * Usage Context:
     * - Incorporated into the settings dialog to allow users to configure the space name.
     *
     * Default Behavior:
     * - Initialized as an empty text field.
     */
    private val spaceNameField = JBTextField()

    /**
     * A JPanel instance representing the visual container for the settings UI components.
     * It is built using the FormBuilder utility to layout labeled input fields and additional
     * adjustable vertical spacing.
     *
     * Contents:
     * - A labeled input field for the API Key.
     * - A labeled input field for the Organization Name.
     * - A labeled input field for the Space Name.
     * - Additional vertical space to structure the layout efficiently.
     *
     * Usage:
     * This panel serves as the root component of the settings UI, embedded within
     * the IntelliJ Platform's Settings/Preferences dialog under the specific plugin settings page.
     *
     * Layout Behavior:
     * - Each labeled component is assigned a single column layout.
     * - Vertical spacing is provided to ensure proper alignment and expandable UI.
     *
     * Lifecycle and Dependency:
     * - Input fields (e.g., `apiKeyField`, `organizationNameField`, `spaceNameField`) must be
     *   initialized and provided to the builder before constructing the panel.
     * - The panel is referenced and returned by the `createComponent` method of
     *   the `SettingsConfigurable` class, allowing integration with IntelliJ's settings framework.
     */
    val panel: JPanel = FormBuilder.createFormBuilder()
        .addLabeledComponent(JBLabel("API Key:"), apiKeyField, 1, false)
        .addLabeledComponent(JBLabel("Organization Name:"), organizationNameField, 1, false)
        .addLabeledComponent(JBLabel("Space Name:"), spaceNameField, 1, false)
        .addComponentFillVertically(JPanel(), 0)
        .panel

    /**
     * Represents the API key used for authenticating with the target service or system.
     *
     * This property maps directly to the password field in the settings UI for secure storage
     * and retrieval of the API key. Any changes to this property are automatically reflected
     * in the underlying UI component, and vice versa.
     *
     * Getter:
     * - Retrieves the current value of the API key as a string from the password field.
     *
     * Setter:
     * - Updates the value of the API key in the associated password field.
     */
    var apiKey: String
        get() = String(apiKeyField.password)
        set(value) {
            apiKeyField.text = value
        }

    /**
     * Represents the name of the organization entered in the settings form.
     *
     * This property provides access to the text value displayed in the organization name input field
     * of the settings UI. It can be used to retrieve the current value or update it dynamically.
     */
    var organizationName: String
        get() = organizationNameField.text
        set(value) {
            organizationNameField.text = value
        }

    /**
     * Represents the name of the space entered by the user in the settings UI.
     *
     * This property provides access to the text value of the space name field,
     * enabling retrieval and updates via its getter and setter.
     *
     * Usage Context:
     * - Used within the `SettingsComponent` class to manage the value of the "Space Name" input field.
     * - Can be integrated into the plugin's settings management processes to store and retrieve space-related information.
     */
    var spaceName: String
        get() = spaceNameField.text
        set(value) {
            spaceNameField.text = value
        }

    /**
     * The UI component that should receive focus when the settings panel is opened.
     *
     * This property is used by the IDE to determine the initial focusable component
     * within the settings UI. It typically points to the most intuitive field for
     * user interaction, such as a text field where input is required.
     */
    val preferredFocusedComponent: JComponent
        get() = apiKeyField
}
