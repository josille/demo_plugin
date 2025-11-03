package org.example.demo_plugin.submenu

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class DiffViewerPopupMenuAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Welcome from the DiffViewerPopupMenuAction Demo Plugin!",
            "DiffViewerPopupMenuAction Demo Plugin - Welcome",
            Messages.getInformationIcon()
        )
    }
}
