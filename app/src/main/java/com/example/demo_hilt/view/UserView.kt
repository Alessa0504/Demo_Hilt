package com.example.demo_hilt.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatTextView
import com.example.demo_hilt.data.User
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * @Description: 要展示user的View
 * @author Jillian
 * @date 2024/8/11
 */
@AndroidEntryPoint
class UserView(context: Context, attrs: AttributeSet) : AppCompatTextView(context, attrs) {
    @Inject lateinit var user: User  //注入进View

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.i("jjz", "UserView Hilt注入 =${user}")
        text =  "name = ${user.name} , mood = ${user.mood}"
        //上层通过@Inject注入User的时候，使用user变量时，@Provides注解方法(即getUser())会自动自动被调用
    }
}