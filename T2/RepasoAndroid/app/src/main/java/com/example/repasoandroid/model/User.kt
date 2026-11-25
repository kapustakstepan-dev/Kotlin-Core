package com.example.repasoandroid.model

import java.io.Serializable

class User(
    val name: String,
    val mail: String,
    val pass: String,
    val profile: Int
): Serializable