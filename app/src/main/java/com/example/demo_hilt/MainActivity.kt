package com.example.demo_hilt

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.demo_hilt.data.User
import com.example.demo_hilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint  //用这个注解的Activity必须继承自AppCompatActivity
class MainActivity : AppCompatActivity() {
    @Inject lateinit var user: User   //注入进Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i("jjz", "MainActivity Hilt注入 =${user}")
        binding.tvHiltUser.text = "${user.name} and mood is ${user.mood}"
        //上层通过@Inject注入User的时候，使用user变量时，@Provides注解方法(即getUser())会自动自动被调用
    }
}