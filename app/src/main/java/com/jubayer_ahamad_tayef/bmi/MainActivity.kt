package com.jubayer_ahamad_tayef.bmi

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jubayer_ahamad_tayef.bmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {

            calculateBmiButton.setOnClickListener {

                if (heightEditText.text!!.isNotEmpty() && weightEditText.text!!.isNotEmpty()) {

                    val height = ((heightEditText.text.toString().toDouble()) * 0.0254)
                    val weight = weightEditText.text.toString().toDouble()
                    val bmi = weight / (height * height)
                    val bmiFormat = String.format("%.2f", bmi)

                    binding.bmiResult.text = when {

                        bmi < 16.0 -> "Your BMI is: $bmiFormat"
                        bmi in 16.0..<17.0 -> "Your BMI is: $bmiFormat"
                        bmi in 17.0..<18.5 -> "Your BMI is: $bmiFormat"
                        bmi in 18.5..<25.0 -> "Your BMI is: $bmiFormat"
                        bmi in 25.0..<30.0 -> "Your BMI is: $bmiFormat"
                        bmi in 30.0..<35.0 -> "Your BMI is: $bmiFormat"
                        bmi in 35.0..<40.0 -> "Your BMI is: $bmiFormat"
                        bmi > 40.00 -> "Your BMI is: $bmiFormat"
                        else -> "Your BMI is: $bmiFormat"

                    }

                    binding.bmiClassification.text = when {

                        bmi < 16.0 -> "Your BMI Classification: Severe Thinness!"
                        bmi in 16.0..<17.0 -> "Your BMI Classification: Moderate Thinness!"
                        bmi in 17.0..<18.5 -> "Your BMI Classification: Mild Thinness!"
                        bmi in 18.5..<25.0 -> "Your BMI Classification: Normal!"
                        bmi in 25.0..<30.0 -> "Your BMI Classification: Overweight!"
                        bmi in 30.0..<35.0 -> "Your BMI Classification: Obese Class |!"
                        bmi in 35.0..<40.0 -> "Your BMI Classification: Obese Class ||!"
                        bmi > 40.00 -> "Your BMI Classification: Obese Class ||!"
                        else -> "Your BMI Classification: Invalid BMI!"

                    }

                } else {

                    Toast.makeText(
                        this@MainActivity,
                        "Please, provide needed Information, then click again Calculate BMI Button.",
                        Toast.LENGTH_SHORT
                    ).show()

                }

            }

        }

    }
}