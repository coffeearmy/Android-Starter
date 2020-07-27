package com.example.androidstarter.features.list.ui.compose

import android.content.Context
import android.graphics.Bitmap
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.SimpleImage
import androidx.ui.foundation.Text
import androidx.ui.graphics.asImageAsset
import androidx.ui.material.ListItem
import com.bumptech.glide.Glide
import com.example.androidstarter.features.list.domain.model.Entry
import javax.inject.Inject

class EntryListCompositeAdapter @Inject constructor(val context: Context) {
    private var list: MutableList<Entry> = mutableListOf()
    fun setItems(listEntry: List<Entry>) {
        list.addAll(listEntry)
    }

    @Composable
    fun adapterListAdapter() {
        AdapterList(data = list) {
            ListItem {
                //imageItem(it.regularUrl)
                Text(text = it.username)
            }
        }
    }

    @Composable
    fun imageItem(img: String) {
        val chefBitmap: Bitmap = Glide.with(context)
            .asBitmap()
            .load(img)
            .submit()
            .get()

        SimpleImage(chefBitmap.asImageAsset())
    }
}