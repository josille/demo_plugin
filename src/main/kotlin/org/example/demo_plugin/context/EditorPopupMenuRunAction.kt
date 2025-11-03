package org.example.demo_plugin.context

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class EditorPopupMenuRunAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Welcome from the EditorPopupMenuRunAction Demo Plugin!",
            "EditorPopupMenuRunAction Demo Plugin - Welcome",
            Messages.getInformationIcon()
        )
    }
}