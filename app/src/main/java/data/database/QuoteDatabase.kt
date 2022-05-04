package data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import data.database.dao.QuoteDao
import data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {

    abstract fun getQuoteDao():QuoteDao
}