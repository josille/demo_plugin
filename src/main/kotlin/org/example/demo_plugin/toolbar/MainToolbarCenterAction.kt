
package org.example.demo_plugin.toolbar

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class MainToolbarCenterAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Welcome from the MainToolbarCenterAction Demo Plugin!",
            "MainToolbarCenterAction Demo Plugin - Welcome",
            Messages.getInformationIcon()
        )
    }
}
