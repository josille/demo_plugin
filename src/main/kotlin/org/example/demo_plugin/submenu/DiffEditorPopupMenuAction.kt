
package org.example.demo_plugin.submenu

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class DiffEditorPopupMenuAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Welcome from the DiffEditorPopupMenuAction Demo Plugin!",
            "DiffEditorPopupMenuAction Demo Plugin - Welcome",
            Messages.getInformationIcon()
        )
    }
}
