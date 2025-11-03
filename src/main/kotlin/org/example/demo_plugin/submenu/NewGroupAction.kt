package org.example.demo_plugin.submenu

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages


class NewGroupAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Hello from the NewGroupAction Demo Plugin!",
            "NewGroupAction Demo Plugin Message",
            Messages.getInformationIcon()
        )
    }
}