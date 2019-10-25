package com.example.androidstarter.features.list.data

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
    private val slug: String = ""
    @SerializedName("scientific_name")
    @Expose
    private val scientificName: String = ""
    @SerializedName("link")
    @Expose
    private val link: String = ""
    @SerializedName("id")
    @Expose
    private val id: Int = -1
    @SerializedName("complete_data")
    @Expose
    private val completeData: Boolean = false
    @SerializedName("common_name")
    @Expose
    private val commonName: String = ""
}


