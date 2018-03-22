package com.github.izhangzhihao.rainbow.brackets

import com.github.izhangzhihao.rainbow.brackets.settings.RainbowSettings
import com.intellij.ide.plugins.IdeaPluginDescriptor
import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.ApplicationComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.extensions.PluginId

class RainbowComponent : ApplicationComponent {
    var updated: Boolean = false

    override fun initComponent() {
        updated = Companion.getPlugin()?.version != RainbowSettings.instance.version
        if (updated) {
            RainbowSettings.instance.version = Companion.getPlugin()?.version
        }
    }

    companion object {
        val instance: RainbowComponent
            get() = ApplicationManager.getApplication().getComponent(RainbowComponent::class.java)

        private fun getPlugin(): IdeaPluginDescriptor? = PluginManager.getPlugin(PluginId.getId("izhangzhihao.rainbow.brackets"))
    }
}