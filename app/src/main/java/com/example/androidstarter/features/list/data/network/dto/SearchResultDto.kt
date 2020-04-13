package com.example.androidstarter.features.list.data.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SearchResultDto(
    @SerializedName("total")
    @Expose
    val total: Int? = null,
    @SerializedName("total_pages")
    @Expose
    val totalPages: Int? = null,
    @SerializedName("results")
    @Expose
    val results: List<ResultDto> = listOf()
)

class UserDto(
    @SerializedName("id")
    @Expose
    val id: String,
    @SerializedName("username")
    @Expose
    val username: String,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("first_name")
    @Expose
    val firstName: String,
    @SerializedName("last_name")
    @Expose
    val lastName: String,
    @SerializedName("instagram_username")
    @Expose
    val instagramUsername: String,
    @SerializedName("twitter_username")
    @Expose
    val twitterUsername: String,
    @SerializedName("portfolio_url")
    @Expose
    val portfolioUrl: String,
    @SerializedName("links")
    @Expose
    val links: Links
)

public class Links(
    @SerializedName("self")
    @Expose
    val self: String,
    @SerializedName("html")
    @Expose
    val html: String,
    @SerializedName("photos")
    @Expose
    val photos: String,
    @SerializedName("likes")
    @Expose
    val likes: String
)

class ResultDto(
    @SerializedName("id")
    @Expose
    val id: String,
    @SerializedName("created_at")
    @Expose
    val createdAt: String,
    @SerializedName("width")
    @Expose
    val width: Integer,
    @SerializedName("height")
    @Expose
    val height: Integer,
    @SerializedName("color")
    @Expose
    val color: String,
    @SerializedName("description")
    @Expose
    val description: String,
    @SerializedName("user")
    @Expose
    val user: UserDto,
    @SerializedName("urls")
    @Expose
    val urls: Urls,
    @SerializedName("links")
    @Expose
    val links: Links
)

class Urls(
    @SerializedName("raw")
    @Expose
    val raw: String,
    @SerializedName("full")
    @Expose
    val full: String,
    @SerializedName("regular")
    @Expose
    val regular: String,
    @SerializedName("small")
    @Expose
    val small: String,
    @SerializedName("thumb")
    @Expose
    val thumb: String
)
