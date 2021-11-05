package com.mcs.productcheck

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Query("SELECT * FROM products ORDER BY barcode ASC")
    fun getAllSortedProducts(): Flow<List<Product>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(product: Product)

    @Query("DELETE FROM products")
    suspend fun deleteAll()
}