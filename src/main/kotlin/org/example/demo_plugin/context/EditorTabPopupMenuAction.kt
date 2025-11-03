package com.example.demo_plugin.context

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class EditorTabPopupMenuAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Hello from the EditorTabPopupMenuAction Demo Plugin!",
            "EditorTabPopupMenuAction Demo Plugin Message",
            Messages.getInformationIcon()
        )
    }
}
