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

/**
 * Repository that provides insert, update, delete, and retrieve of [Item] from a given data source.
 *
 * Interface ini mendefinisikan kontrak untuk operasi dasar pada data [Item],
 * termasuk mengambil, menyisipkan, menghapus, dan memperbarui item.
 * Repository ini menjadi lapisan antara data source (misalnya Room, API) dan
 * aplikasi, memungkinkan aplikasi berinteraksi dengan data tanpa mengkhawatirkan
 * detail implementasi penyimpanan.
 */
interface ItemsRepository {
    /**
     * Retrieve all the items from the given data source.
     *
     * Fungsi ini mengembalikan aliran (Flow) dari daftar item yang ada di data source,
     * memungkinkan pembaruan otomatis ketika data berubah.
     */
    fun getAllItemsStream(): Flow<List<Item>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     *
     * Fungsi ini mengembalikan aliran (Flow) dari item yang memiliki ID yang sesuai.
     * Jika item tidak ditemukan, akan mengembalikan null.
     */
    fun getItemStream(id: Int): Flow<Item?>

    /**
     * Insert item in the data source.
     *
     * Fungsi ini digunakan untuk menyisipkan item baru ke dalam data source.
     * Dibuat sebagai fungsi suspend karena berinteraksi dengan operasi IO (misalnya database).
     */
    suspend fun insertItem(item: Item)

    /**
     * Delete item from the data source.
     *
     * Fungsi ini digunakan untuk menghapus item dari data source.
     * Fungsi ini juga suspend karena melibatkan operasi IO.
     */
    suspend fun deleteItem(item: Item)

    /**
     * Update item in the data source.
     *
     * Fungsi ini digunakan untuk memperbarui data item yang sudah ada di data source.
     * Operasi ini juga dilakukan secara suspend untuk operasi IO.
     */
    suspend fun updateItem(item: Item)
}


