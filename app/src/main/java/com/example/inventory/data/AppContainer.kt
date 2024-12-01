/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data

import android.content.Context

/**
 * App container for Dependency injection.
 *
 * Interface ini mendeklarasikan bahwa kelas yang mengimplementasikannya
 * harus menyediakan instance dari [ItemsRepository], yang digunakan
 * untuk mengakses data item dalam aplikasi.
 */
interface AppContainer {
    val itemsRepository: ItemsRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository]
 *
 * Kelas ini menyediakan implementasi konkret dari [AppContainer],
 * yang membuat dan menyediakan instance [OfflineItemsRepository]
 * dengan mengambil DAO dari database Room untuk mengakses data item.
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [ItemsRepository]
     *
     * Properti ini menginisialisasi [OfflineItemsRepository] secara lazy,
     * yang menggunakan [ItemDao] dari Room database untuk mengelola data item.
     */
    override val itemsRepository: ItemsRepository by lazy {
        OfflineItemsRepository(InventoryDatabase.getDatabase(context).itemDao())
    }
}
