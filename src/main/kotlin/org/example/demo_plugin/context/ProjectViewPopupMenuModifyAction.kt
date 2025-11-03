package org.example.demo_plugin.context

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class ProjectViewPopupMenuModifyAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Welcome from the ProjectViewPopupMenuModifyAction Demo Plugin!",
            "ProjectViewPopupMenuModifyAction Demo Plugin - Welcome",
            Messages.getInformationIcon()
        )
    }
}
