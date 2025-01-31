package com.memo.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.memo.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener{calculateTip()}
    }

    private fun calculateTip() {
        val stringEditText = binding.costOfService.text.toString()
        val cost = stringEditText.toDouble()
        val selectedId = binding.tipOptions.checkedRadioButtonId//Button id
        val tipPercentage = when(selectedId){
            R.id.option_twenty_percent->0.20
            R.id.option_eighteen_percent->0.18
            else->0.15
        }

        var tip = cost * tipPercentage
        val roundUp = binding.roundUpSwitch.isChecked

        if(roundUp)
            tip = ceil(tip)

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)

        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)





    }
}