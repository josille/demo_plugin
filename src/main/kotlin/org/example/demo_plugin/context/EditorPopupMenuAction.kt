package com.example.demo_plugin.context

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class EditorPopupMenuAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Hello from the EditorPopupMenuAction Demo Plugin!",
            "EditorPopupMenuAction Demo Plugin Message",
            Messages.getInformationIcon()
        )
    }
}
