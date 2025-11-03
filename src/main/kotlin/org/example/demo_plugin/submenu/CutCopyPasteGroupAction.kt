package org.example.demo_plugin.submenu

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class CutCopyPasteGroupAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Welcome from the CutCopyPasteGroupAction Demo Plugin!",
            "CutCopyPasteGroupAction Demo Plugin - Welcome",
            Messages.getInformationIcon()
        )
    }
}
