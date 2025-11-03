package org.example.demo_plugin.main_menu

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class WindowMenuAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Hello from the WindowsMenuAction Demo Plugin!",
            "WindowsMenuAction Demo Plugin Message",
            Messages.getInformationIcon()
        )
    }
}
