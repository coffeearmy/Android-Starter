package com.example.androidstarter.features.list.data.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
{
  "slug": "string",
  "scientific_name": "string",
  "link": "string",
  "id": 0,
  "complete_data": true,
  "common_name": "string"
}
 */
class PlantDto {
    @SerializedName("slug")
    @Expose
    val slug: String = ""
    @SerializedName("scientific_name")
    @Expose
    val scientificName: String = ""
    @SerializedName("link")
    @Expose
    val link: String = ""
    @SerializedName("id")
    @Expose
    val id: Int = -1
    @SerializedName("complete_data")
    @Expose
    val completeData: Boolean = false
    @SerializedName("common_name")
    @Expose
    val commonName: String = ""
}


