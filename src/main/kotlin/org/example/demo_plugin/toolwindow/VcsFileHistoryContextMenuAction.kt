package org.example.demo_plugin.toolwindow

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class VcsFileHistoryContextMenuAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Welcome from the VcsFileHistoryContextMenuAction Demo Plugin!",
            "VcsFileHistoryContextMenuAction Demo Plugin - Welcome",
            Messages.getInformationIcon()
        )
    }
}
