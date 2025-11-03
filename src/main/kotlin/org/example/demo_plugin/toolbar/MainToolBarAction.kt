package org.example.demo_plugin.toolbar

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class MainToolBarAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Hello from the MainToolBarAction Demo Plugin!",
            "MainToolBarAction Demo Plugin Message",
            Messages.getInformationIcon()
        )
    }
}
