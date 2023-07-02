package com.keysersoze.innobuzz

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PostDao {
    @Query("SELECT * FROM posts")
    fun getAllPosts(): List<PostEntity>

    @Insert
    fun insertPosts(posts: List<PostEntity>)
}
