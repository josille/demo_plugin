package org.example.demo_plugin.toolbar

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class MainToolbarRightAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Hello from the MainToolbarRightAction Demo Plugin!",
            "MainToolbarRightAction Demo Plugin Message",
            Messages.getInformationIcon()
        )
    }
}
