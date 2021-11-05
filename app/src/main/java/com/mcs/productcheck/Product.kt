package com.mcs.productcheck

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
class Product(@PrimaryKey @ColumnInfo(name = "barcode")
              val barcode: String, val length: Double, weight:Double, height: Double)