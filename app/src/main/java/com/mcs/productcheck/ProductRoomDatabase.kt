package com.mcs.productcheck

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = arrayOf(Product::class), version = 1, exportSchema = false)
public abstract class ProductRoomDatabase: RoomDatabase() {
    abstract fun productDao(): ProductDao

    @InternalCoroutinesApi
    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ProductRoomDatabase? = null

        fun getDatabase(context: Context): ProductRoomDatabase{
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductRoomDatabase::class.java,
                    "products_database"
                ).build()
                INSTANCE = instance
                //return instance
                instance
            }
        }

    }
}