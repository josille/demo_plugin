package com.example.demo_plugin.main_menu

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class CodeMenuAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Hello from the CodeMenuAction Demo Plugin!",
            "CodeMenuAction Demo Plugin Message",
            Messages.getInformationIcon()
        )
    }
}
