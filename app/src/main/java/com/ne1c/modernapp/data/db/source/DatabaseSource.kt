package com.ne1c.modernapp.data.db.source

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.ne1c.modernapp.data.db.dao.RepositoryDao
import com.ne1c.modernapp.data.db.model.LocalRepositoryModel

@Database(entities = [(LocalRepositoryModel::class)], version = 1)
abstract class DatabaseSource : RoomDatabase() {
    abstract fun repositoryDao(): RepositoryDao
}