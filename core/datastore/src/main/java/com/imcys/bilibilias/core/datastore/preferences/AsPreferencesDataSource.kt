package com.imcys.bilibilias.core.datastore.preferences

import androidx.datastore.core.DataStore
import com.imcys.bilibilias.core.datastore.UserPreferences
import com.imcys.bilibilias.core.model.data.UserData
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AsPreferencesDataSource @Inject constructor(
    private val userPreferences: DataStore<UserPreferences>
) {
    val userData = userPreferences.data.map {
        UserData(
            it.fileStoragePath,
            it.fileNameRule,
            it.autoMerge,
            it.autoImportToBilibili,
            it.shouldAppcenter,
            it.command
        )
    }

    suspend fun setFileStoragePath(path: String) {
        userPreferences.updateData { it.copy(fileStoragePath = path) }
    }

    suspend fun setFileNameRule(rule: String) {
        userPreferences.updateData { it.copy(fileNameRule = rule) }
    }

    suspend fun setAutoMerge(enable: Boolean) {
        userPreferences.updateData { it.copy(autoMerge = enable) }
    }

    suspend fun setAutoImportToBilibili(enable: Boolean) {
        userPreferences.updateData { it.copy(autoImportToBilibili = enable) }
    }

    suspend fun setShouldAppcenter(enable: Boolean) {
        userPreferences.updateData { it.copy(shouldAppcenter = enable) }
    }

    suspend fun setCommand(command: String) {
        userPreferences.updateData { it.copy(command = command) }
    }
}
