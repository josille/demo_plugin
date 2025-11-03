package org.example.demo_plugin.toolbar

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class MainToolbarLeftAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Hello from the MainToolbarLeftAction Demo Plugin!",
            "MainToolbarLeftAction Demo Plugin Message",
            Messages.getInformationIcon()
        )
    }
}
