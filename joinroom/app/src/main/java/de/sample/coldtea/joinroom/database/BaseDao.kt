package de.sample.coldtea.joinroom.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import androidx.room.Update

interface BaseDao<T> {

    /**
     * Insert an object in the database.
     *
     * @param item the object to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: T): Long

    /**
     * Insert an array of objects in the database.
     *
     * @param items the objects to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg items: T): LongArray

    /**
     * Update an object from the database.
     *
     * @param item the object to be updated
     */
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(item: T)

    /**
     * Delete an object from the database
     *
     * @param item the object to be deleted
     */
    @Delete
    suspend fun delete(item: T)
}

@Transaction
suspend inline fun <reified T> BaseDao<T>.insertOrUpdate(item: T) {
    if (insert(item) != -1L) return
    update(item)
}