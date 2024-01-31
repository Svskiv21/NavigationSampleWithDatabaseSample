package com.example.navigationsample

import android.icu.text.CaseMap.Title
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="wish-table")
data class Wish (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "wish-title")
    val title: String = "",
    @ColumnInfo(name = "wish-desc")
    val description: String = ""
)

fun SampleWishListCreator() {
    val wishList = listOf(
        Wish(1, "Birthday Gift", "Surprise party and thoughtful gifts"),
        Wish(2, "Vacation", "Relaxing beach holiday"),
        Wish(3, "Career Milestone", "Promotion and recognition")
    )

    // Wyświetlenie listy życzeń
    wishList.forEach {
        println("ID: ${it.id}, Title: ${it.title}, Description: ${it.description}")
    }
}