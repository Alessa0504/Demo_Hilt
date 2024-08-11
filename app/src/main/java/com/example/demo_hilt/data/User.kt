package com.example.demo_hilt.data

import dagger.hilt.android.scopes.ActivityScoped

/**
 * @Description: User data model
 * @author Jillian
 * @date 2024/8/10
 */
@ActivityScoped   //scope是Activity级别
data class User constructor(var id: Int, var name: String, var mood: String) {
    constructor() : this(1, "Jillian", "calm")
}
