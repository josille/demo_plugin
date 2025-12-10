package org.example.demo_plugin.main_menu

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages
import com.intellij.ui.components.JBList
import com.intellij.ui.components.JBScrollPane
import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.BorderFactory
import javax.swing.DefaultListModel
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JOptionPane
import javax.swing.JPanel
import javax.swing.ListSelectionModel

class EditMenuAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "Hello from the EditMenuAction Demo Plugin!",
            "EditMenuAction Demo Plugin Message",
            Messages.getInformationIcon()
        )
        showPanel()
    }

    private fun showPanel() {
        // 1.- Create panel
        val panel = JPanel(BorderLayout())

        /*
        // 2.- Add instruction label
        val instructionLabel = JLabel("Double-click on an item to view details")
        instructionLabel.border = BorderFactory.createEmptyBorder(5, 5, 5, 5)
        panel.add(instructionLabel, BorderLayout.NORTH)
        */

        /*
        // 3.- add data
        // Create list model
        val listModel = DefaultListModel<String>()
        listModel.addElement("1 - one")
        listModel.addElement("2 - two")
        listModel.addElement("3 - three")

        // Create JList
        val list = JBList(listModel)
        list.selectionMode = ListSelectionModel.SINGLE_SELECTION

        val scrollPane = JBScrollPane(list)
        scrollPane.preferredSize = Dimension(600, 400)
        panel.add(scrollPane, BorderLayout.CENTER)
        */

        /*
        // 4.- Create a small toolbar with a "Download JSON" button
        val downloadButton = JButton("PANEl to VIEW as EXAMPLE ")
        downloadButton.toolTipText = "Save this content to a file"
        downloadButton.background = java.awt.Color(33, 150, 243)
        downloadButton.foreground = java.awt.Color.WHITE // White text
        downloadButton.isOpaque = true
        downloadButton.isBorderPainted = false

        /*
        // 5.- Add an action to panel button
            downloadButton.addActionListener {
                JOptionPane.showMessageDialog(
                    null,
                    "Button pressed",
                    "CLICK!!!",
                    JOptionPane.INFORMATION_MESSAGE
                )
            }
        */

         panel.add(downloadButton, BorderLayout.SOUTH)
        */

        // Show dialog
        JOptionPane.showMessageDialog(
            null,
            panel,
            "SHOWING PANEL",
            JOptionPane.INFORMATION_MESSAGE
        )
    }
}
