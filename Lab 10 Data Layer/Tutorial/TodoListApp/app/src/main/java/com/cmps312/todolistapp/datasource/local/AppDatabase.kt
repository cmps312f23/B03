package com.cmps312.todolistapp.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cmps312.todolistapp.entity.Project
import com.cmps312.todolistapp.entity.Todo

@Database(
    entities = [Project::class, Todo::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun projectDao(): ProjectDao
    abstract fun todoDao(): TodoDao

    //    singleton
    companion object {
        private var db: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (db == null) {
                db = Room.databaseBuilder(
                    context = context.applicationContext,
                    AppDatabase::class.java,
                    "mytodo.db"
                ).fallbackToDestructiveMigration().build()
            }
            return db as AppDatabase
        }
    }
}
