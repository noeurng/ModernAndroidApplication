package com.ne1c.modernapp.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.ne1c.modernapp.data.db.model.LocalRepositoryModel

@Dao
abstract class RepositoryDao {
    @Query("SELECT * from LocalRepositoryModel")
    abstract fun getAll(): List<LocalRepositoryModel>

    @Insert
    abstract fun insertAll(vararg repositoryModel: LocalRepositoryModel)

    @Delete()
    abstract fun updateAll(vararg repositoryModel: LocalRepositoryModel)

    fun isEmpty() = getAll().isEmpty()
}