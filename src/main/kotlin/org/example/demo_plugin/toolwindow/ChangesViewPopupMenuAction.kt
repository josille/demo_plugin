package org.example.demo_plugin.toolwindow

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class ChangesViewPopupMenuAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Welcome from the ChangesViewPopupMenuAction Demo Plugin!",
            "ChangesViewPopupMenuAction Demo Plugin - Welcome",
            Messages.getInformationIcon()
        )
    }
}
