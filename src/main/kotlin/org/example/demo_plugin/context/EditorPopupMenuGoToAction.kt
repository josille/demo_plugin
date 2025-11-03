package org.example.demo_plugin.context

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class EditorPopupMenuGoToAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Hello from the EditorPopupMenuGoToAction Demo Plugin!",
            "EditorPopupMenuGoToAction Demo Plugin Message",
            Messages.getInformationIcon()
        )
    }
}
