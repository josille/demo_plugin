package org.example.demo_plugin.toolwindow

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class ChangesViewAddUnversionedAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Welcome from the ChangesViewAddUnversionedAction Demo Plugin!",
            "ChangesViewAddUnversionedAction Demo Plugin - Welcome",
            Messages.getInformationIcon()
        )
    }
}
