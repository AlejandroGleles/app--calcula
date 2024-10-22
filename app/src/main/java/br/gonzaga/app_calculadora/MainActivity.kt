package br.gonzaga.app_calculadora

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var display: TextView
    private var lastInputWasOperator = false
    private var operator: String? = null
    private var operand1: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Configura o padding da tela
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        display = findViewById(R.id.display)
        setupButtons()
    }

    private fun setupButtons() {
        val buttons = listOf(
            R.id.button_0, R.id.button_1, R.id.button_2,
            R.id.button_3, R.id.button_4, R.id.button_5,
            R.id.button_6, R.id.button_7, R.id.button_8,
            R.id.button_9, R.id.button_add, R.id.button_subtract,
            R.id.button_multiply, R.id.button_divide, R.id.button_clear,
            R.id.button_equals
        )

        for (buttonId in buttons) {
            findViewById<Button>(buttonId).setOnClickListener { handleButtonClick(it) }
        }
    }

    private fun handleButtonClick(view: View) {
        val button = view as Button
        val buttonText = button.text.toString()

        when (buttonText) {
            "C" -> clear()
            "=" -> calculate()
            "+", "-", "*", "/" -> setOperator(buttonText)
            else -> appendToDisplay(buttonText)
        }
    }

    private fun appendToDisplay(value: String) {
        if (lastInputWasOperator) {
            display.text = value
            lastInputWasOperator = false
        } else {
            display.append(value)
        }
    }

    private fun clear() {
        display.text = "0"
        operand1 = null
        operator = null
        lastInputWasOperator = false
    }

    private fun setOperator(op: String) {
        if (operator == null) {
            operator = op
            operand1 = display.text.toString().toDoubleOrNull()
            lastInputWasOperator = true
        }
    }

    private fun calculate() {
        if (operator != null && operand1 != null) {
            val operand2 = display.text.toString().toDoubleOrNull()
            val result = when (operator) {
                "+" -> operand1!! + operand2!!
                "-" -> operand1!! - operand2!!
                "*" -> operand1!! * operand2!!
                "/" -> {
                    if (operand2 != null && operand2 != 0.0) {
                        operand1!! / operand2
                    } else {
                        display.text = "Erro"
                        return
                    }
                }
                else -> null
            }
            display.text = result.toString()
            operator = null
        }
    }
}
