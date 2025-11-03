package org.example.demo_plugin.context

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class ProjectViewPopupMenuRefactoringAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Hello from the ProjectViewPopupMenuRefactoringAction Demo Plugin!",
            "ProjectViewPopupMenuRefactoringAction Demo Plugin Message",
            Messages.getInformationIcon()
        )
    }
}
