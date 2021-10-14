package com.example.airgallery.data

import com.google.gson.annotations.SerializedName


data class GameList(
    @SerializedName("count") var count : Int,
    @SerializedName("next") var next : String,
    @SerializedName("previous") var previous : String,
    @SerializedName("results") var results : List<Results>,
    @SerializedName("seo_title") var seoTitle : String,
    @SerializedName("seo_description") var seoDescription : String,
    @SerializedName("seo_keywords") var seoKeywords : String,
    @SerializedName("seo_h1") var seoH1 : String,
    @SerializedName("noindex") var noindex : Boolean,
    @SerializedName("nofollow") var nofollow : Boolean,
    @SerializedName("description") var description : String,
    @SerializedName("nofollow_collections") var nofollowCollections : List<String>
)