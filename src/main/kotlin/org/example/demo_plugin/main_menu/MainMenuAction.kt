package org.example.demo_plugin.main_menu

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class MainMenuAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Welcome from the MainMenuAction Demo Plugin!",
            "MainMenuAction Demo Plugin - Welcome",
            Messages.getInformationIcon()
        )
    }
}
