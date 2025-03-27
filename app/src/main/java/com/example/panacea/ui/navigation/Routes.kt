package com.example.panacea.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object SPLASH

@Serializable
object HOME

@Serializable
object LOGIN

@Serializable
object SIGNING

@Serializable
object DIRECTORY

@Serializable
data class NURSE_DETAIL(val nurseId: Int)

@Serializable
object PROFILE

@Serializable
object DOCUMENTS

@Serializable
object NEWS

@Serializable
object HISTORY

@Serializable
data class ROOM_DETAIL(val roomId: Int)

