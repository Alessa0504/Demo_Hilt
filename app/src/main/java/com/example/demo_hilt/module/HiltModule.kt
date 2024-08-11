package com.example.demo_hilt.module

import com.example.demo_hilt.data.User
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * @Description: Module Provider
 * @author Jillian
 * @date 2024/8/11
 */
@Module
@InstallIn(ActivityComponent::class)
object HiltModule {
    @Provides
    fun getUser(): User {   //方法名不一定非要是getUser固定，比如getUser02也可
        val user = User().apply {
            this.name = "Jillian"
            this.mood = "sad"
        }
        return user
    }
}