package com.example.airgallery.data

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("id") var id : Int,
    @SerializedName("slug") var slug : String,
    @SerializedName("name") var name : String,
    @SerializedName("released") var released : String,
    @SerializedName("tba") var tba : Boolean,
    @SerializedName("background_image") var backgroundImage : String,
    @SerializedName("rating") var rating : Double,
    @SerializedName("rating_top") var ratingTop : Int,
    @SerializedName("ratings_count") var ratingsCount : Int,
    @SerializedName("reviews_text_count") var reviewsTextCount : Int,
    @SerializedName("added") var added : Int,
    @SerializedName("metacritic") var metacritic : Int,
    @SerializedName("playtime") var playtime : Int,
    @SerializedName("suggestions_count") var suggestionsCount : Int,
    @SerializedName("updated") var updated : String,
    @SerializedName("user_game") var userGame : String,
    @SerializedName("reviews_count") var reviewsCount : Int,
    @SerializedName("saturated_color") var saturatedColor : String,
    @SerializedName("dominant_color") var dominantColor : String,
    @SerializedName("clip") var clip : String
)
