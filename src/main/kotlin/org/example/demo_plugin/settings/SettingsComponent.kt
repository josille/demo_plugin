package org.example.demo_plugin.settings

import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBPasswordField
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.JComponent
import javax.swing.JPanel

class SettingsComponent {

    private val apiKeyField = JBPasswordField()
    private val organizationNameField = JBTextField()
    private val spaceNameField = JBTextField()

    val panel: JPanel = FormBuilder.createFormBuilder()
        .addLabeledComponent(JBLabel("API Key:"), apiKeyField, 1, false)
        .addLabeledComponent(JBLabel("Organization Name:"), organizationNameField, 1, false)
        .addLabeledComponent(JBLabel("Space Name:"), spaceNameField, 1, false)
        .addComponentFillVertically(JPanel(), 0)
        .panel

    var apiKey: String
        get() = String(apiKeyField.password)
        set(value) {
            apiKeyField.text = value
        }

    var organizationName: String
        get() = organizationNameField.text
        set(value) {
            organizationNameField.text = value
        }

    var spaceName: String
        get() = spaceNameField.text
        set(value) {
            spaceNameField.text = value
        }

    val preferredFocusedComponent: JComponent
        get() = apiKeyField
}
