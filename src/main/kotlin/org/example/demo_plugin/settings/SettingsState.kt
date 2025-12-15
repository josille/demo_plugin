// class to persist the settings
package org.example.demo_plugin.settings

import com.intellij.openapi.components.*
import com.intellij.openapi.project.Project

@Service(Service.Level.PROJECT)
@State(
    name = "APP_Settings",
    storages = [Storage("AppSettings.xml")]
)
class SettingsState : PersistentStateComponent<SettingsState.State> {

    data class State(
        var apiKey: String = "",
        var organizationName: String = "",
    )

    private var myState = State()

    override fun getState(): State = myState

    override fun loadState(state: State) {
        myState = state
    }

    companion object {
        fun getInstance(project: Project): SettingsState {
            return project.service<SettingsState>()
        }
    }
}
