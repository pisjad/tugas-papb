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

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity data class represents a single row in the database.
 *
 * Kelas data ini mewakili entitas dalam database, di mana setiap objek
 * [Item] akan disimpan sebagai satu baris dalam tabel "items". Setiap properti
 * dalam kelas ini akan menjadi kolom dalam tabel database.
 */
@Entity(tableName = "items")
data class Item(
    // ID unik untuk setiap item yang akan otomatis di-generate oleh Room.
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    // Nama item, akan disimpan sebagai kolom dalam tabel.
    val name: String,

    // Harga item, disimpan sebagai kolom dalam tabel.
    val price: Double,

    // Jumlah stok item, disimpan sebagai kolom dalam tabel.
    val quantity: Int
)
