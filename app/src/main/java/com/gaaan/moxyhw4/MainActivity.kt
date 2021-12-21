package com.gaaan.moxyhw4

import android.os.Bundle
import com.gaaan.moxyhw4.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private val presenter by moxyPresenter { MainPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {
            presenter.calculate(binding.editText.text.toString())
        }
    }

    override fun showResult(result: Long) {
        binding.resultText.text = result.toString()
    }

    override fun showError(message: String) {
        binding.resultText.text = message
    }

}