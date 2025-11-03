package com.example.demo_plugin.main_menu

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class EditMenuAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Hello from the EditMenuAction Demo Plugin!",
            "EditMenuAction Demo Plugin Message",
            Messages.getInformationIcon()
        )
    }
}
