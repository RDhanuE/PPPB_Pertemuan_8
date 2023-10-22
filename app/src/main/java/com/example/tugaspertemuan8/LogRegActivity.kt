package com.example.tugaspertemuan8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.WindowManager
import androidx.viewpager2.widget.ViewPager2
import com.example.tugaspertemuan8.databinding.ActivityLogRegBinding
import com.google.android.material.tabs.TabLayoutMediator
import java.text.FieldPosition

class LogRegActivity : AppCompatActivity() {
    lateinit var mediator: TabLayoutMediator
    lateinit var viewPager2: ViewPager2


    override fun onCreate(savedInstanceState: Bundle?) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.resources.getColor(R.color.blue)

        val binding = ActivityLogRegBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = ""
        with(binding){
            viewPager2 = viewPager
            viewPager.adapter = TabAdapter(this@LogRegActivity)
            mediator = TabLayoutMediator(tabLayout, viewPager){
                tab, position ->
                when(position){
                    0 -> tab.text = "Registration"
                    1 -> tab.text = "Login"
                }
            }
            mediator.attach()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_empty, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun switchFragment(position: Int){
        viewPager2.currentItem = position
    }
}