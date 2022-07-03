package com.example.mvvm.data

import com.example.mvvm.utils.ImageType

data class ImageModel(val previewHeight: Int, val likes: Int, val favorites: Int, val tags: String,
                      val webformatHeight: Int, val views: Long, val webformatWidth: Int, val previewWidth: Int,
                      val comments: Int, val downloads: Int, val pageURL: String, val previewURL: String,
                      val webformatURL: String, val imageWidth: Int, val userId: Int, val user: String,
                      val type: ImageType, val id: Int, val userImageURL: String, val imageHeight: Int)
