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

import kotlinx.coroutines.flow.Flow

class OfflineItemsRepository(private val itemDao: ItemDao) : ItemsRepository {
    /**
     * Mengambil aliran (Flow) dari semua item yang ada di database
     * melalui [ItemDao]. Fungsi ini mengembalikan daftar item yang
     * selalu ter-update secara otomatis.
     */
    override fun getAllItemsStream(): Flow<List<Item>> = itemDao.getAllItems()

    /**
     * Mengambil aliran (Flow) dari item berdasarkan ID yang diberikan.
     * Jika item ditemukan, akan mengembalikan item tersebut,
     * jika tidak, akan mengembalikan null.
     */
    override fun getItemStream(id: Int): Flow<Item?> = itemDao.getItem(id)

    /**
     * Menyisipkan item baru ke dalam database melalui [ItemDao].
     * Fungsi ini ditandai sebagai suspend karena berinteraksi dengan IO.
     */
    override suspend fun insertItem(item: Item) = itemDao.insert(item)

    /**
     * Menghapus item dari database melalui [ItemDao].
     * Fungsi ini juga suspend karena melibatkan operasi IO.
     */
    override suspend fun deleteItem(item: Item) = itemDao.delete(item)

    /**
     * Memperbarui item yang sudah ada di database melalui [ItemDao].
     * Fungsi ini juga suspend untuk menangani operasi IO.
     */
    override suspend fun updateItem(item: Item) = itemDao.update(item)
}

