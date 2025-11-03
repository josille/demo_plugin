package com.example.demo_plugin.main_menu

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class FileMenuAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Hello from the FileMenuAction Demo Plugin!",
            "FileMenuAction Demo Plugin Message",
            Messages.getInformationIcon()
        )
    }
}
