package com.github.izhangzhihao.rainbow.brackets.settings

import com.intellij.openapi.options.Configurable
import com.intellij.openapi.options.ConfigurationException
import org.jetbrains.annotations.Nls
import javax.swing.JComponent

class RainbowConfigurable : Configurable {
    private var settingsForm: RainbowSettingsForm? = null

    override fun createComponent(): JComponent? {
        settingsForm = settingsForm ?: RainbowSettingsForm()
        return settingsForm?.component
    }

    override fun isModified(): Boolean {
        return settingsForm?.isModified ?: return false
    }

    @Throws(ConfigurationException::class)
    override fun apply() {
        val settings = RainbowSettings.Companion.instance
        settings.isRainbowEnabled = settingsForm?.isRainbowEnabled ?: true
        settings.isRainbowHTMLEnabled = settingsForm?.isRainbowHTML ?: true
        settings.isEnableRainbowBracketsForAnyLanguages = settingsForm?.enableRainbowBracketsForAnyLanguages ?: false
    }

    override fun reset() {
        settingsForm?.reset()
    }

    override fun disposeUIResources() {
        settingsForm = null
    }

    @Nls
    override fun getDisplayName() = "Rainbow Brackets"

    override fun getHelpTopic() = null
}