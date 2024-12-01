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

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    /**
     * Fungsi untuk menyisipkan item baru ke dalam database.
     * Jika item dengan ID yang sama sudah ada, maka operasi insert akan diabaikan.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    /**
     * Fungsi untuk memperbarui data item yang sudah ada di database.
     * Fungsi ini akan mengganti data item yang memiliki ID yang sama.
     */
    @Update
    suspend fun update(item: Item)

    /**
     * Fungsi untuk menghapus item dari database.
     * Item yang dihapus berdasarkan objek yang diberikan.
     */
    @Delete
    suspend fun delete(item: Item)

    /**
     * Fungsi untuk mengambil satu item berdasarkan ID.
     * Mengembalikan hasil sebagai aliran (Flow) yang memungkinkan pembaruan data secara otomatis.
     */
    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    /**
     * Fungsi untuk mengambil semua item yang ada dalam tabel 'items',
     * diurutkan berdasarkan nama secara ascending.
     * Hasilnya berupa aliran (Flow) dari daftar item.
     */
    @Query("SELECT * from items ORDER BY name ASC")
    fun getAllItems(): Flow<List<Item>>
}

