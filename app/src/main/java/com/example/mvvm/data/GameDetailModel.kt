package com.example.mvvm.data

import com.google.gson.annotations.SerializedName

data class GameDetailModel(
    @SerializedName("id") var id : Int,
    @SerializedName("slug") var slug : String,
    @SerializedName("name") var name : String,
    @SerializedName("name_original") var nameOriginal : String,
    @SerializedName("description") var description : String,
    @SerializedName("metacritic") var metacritic : Int,
    @SerializedName("released") var released : String,
    @SerializedName("tba") var tba : Boolean,
    @SerializedName("updated") var updated : String,
    @SerializedName("background_image") var backgroundImage : String,
    @SerializedName("background_image_additional") var backgroundImageAdditional : String,
    @SerializedName("website") var website : String,
    @SerializedName("rating") var rating : Double,
    @SerializedName("rating_top") var ratingTop : Int,
    @SerializedName("added") var added : Int,
    @SerializedName("playtime") var playtime : Int,
    @SerializedName("screenshots_count") var screenshotsCount : Int,
    @SerializedName("movies_count") var moviesCount : Int,
    @SerializedName("creators_count") var creatorsCount : Int,
    @SerializedName("achievements_count") var achievementsCount : Int,
    @SerializedName("parent_achievements_count") var parentAchievementsCount : Int,
    @SerializedName("reddit_url") var redditUrl : String,
    @SerializedName("reddit_name") var redditName : String,
    @SerializedName("reddit_description") var redditDescription : String,
    @SerializedName("reddit_logo") var redditLogo : String,
    @SerializedName("reddit_count") var redditCount : Int,
    @SerializedName("twitch_count") var twitchCount : Int,
    @SerializedName("youtube_count") var youtubeCount : Int,
    @SerializedName("reviews_text_count") var reviewsTextCount : Int,
    @SerializedName("ratings_count") var ratingsCount : Int,
    @SerializedName("suggestions_count") var suggestionsCount : Int,
    @SerializedName("alternative_names") var alternativeNames : List<String>,
    @SerializedName("metacritic_url") var metacriticUrl : String,
    @SerializedName("parents_count") var parentsCount : Int,
    @SerializedName("additions_count") var additionsCount : Int,
    @SerializedName("game_series_count") var gameSeriesCount : Int,
    @SerializedName("user_game") var userGame : String,
    @SerializedName("reviews_count") var reviewsCount : Int,
    @SerializedName("saturated_color") var saturatedColor : String,
    @SerializedName("dominant_color") var dominantColor : String,
    @SerializedName("clip") var clip : String,
    @SerializedName("description_raw") var descriptionRaw : String
)