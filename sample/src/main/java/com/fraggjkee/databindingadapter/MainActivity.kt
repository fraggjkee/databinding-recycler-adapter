package com.fraggjkee.databindingadapter

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.fraggjkee.databindingadapter.databinding.ActivityMainBinding
import com.fraggjkee.databindingadapter.dynamic.DynamicActivity
import com.fraggjkee.databindingadapter.simple.SimpleActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this
    }

    fun onSimpleBtnClick() {
        startActivity(
            Intent(this, SimpleActivity::class.java)
        )
    }

    fun onSimpleMultiTypeBtnClick() {
        Toast.makeText(this, "TODO", Toast.LENGTH_LONG).show()
    }

    fun onDynamicBtnClick() {
        startActivity(
            Intent(this, DynamicActivity::class.java)
        )
    }

    fun onAdvancedBtnClick() {
        Toast.makeText(this, "TODO", Toast.LENGTH_LONG).show()
    }
}
