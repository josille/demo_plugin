package org.example.demo_plugin.main_menu

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages


/**
 * Represents an action bound to a file menu in an IntelliJ plugin.
 * When triggered, it displays a message dialog with a greeting related to the FileMenuAction Demo Plugin.
 *
 * This action can be used as part of the IntelliJ platform's main menu actions
 * to interact with users through simple notifications.
 *
 * Implements AnAction abstract class
 */
class FileMenuAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Hello from the FileMenuAction Demo Plugin!",
            "FileMenuAction Demo Plugin Message",
            Messages.getInformationIcon()
        )
    }
}
