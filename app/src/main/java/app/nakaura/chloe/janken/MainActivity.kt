package app.nakaura.chloe.janken

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.nakaura.chloe.janken.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var playerNumber: Int = 0
    var cpuNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }


        binding.gooButton.setOnClickListener{
            binding.playerImage.setImageResource(R.drawable.goo)
            val number: Int = Random.nextInt(3)

            when(number){
                0 -> {
                    binding.cpuImage.setImageResource(R.drawable.goo)
                    binding.resultText.text = "引き分けです"
                    binding.resultText.setTextColor(Color.GRAY)
                }
                1 -> {
                    binding.cpuImage.setImageResource(R.drawable.choki)
                    binding.resultText.text = "あなたの勝ちです"
                    binding.resultText.setTextColor(Color.RED)
                    playerWinAction()
                }
                2 -> {
                    binding.cpuImage.setImageResource(R.drawable.paa)
                    binding.resultText.text = "あなたの負けです"
                    binding.resultText.setTextColor(Color.BLUE)
                    cpuWinAction()
                }
            }
        }

        binding.chokiButton.setOnClickListener{
            binding.playerImage.setImageResource(R.drawable.choki)
            val number: Int = Random.nextInt(3)

            when(number){
                0 -> {
                    binding.cpuImage.setImageResource(R.drawable.goo)
                    binding.resultText.text = "あなたの負けです"
                    binding.resultText.setTextColor(Color.BLUE)
                    cpuWinAction()
                }
                1 -> {
                    binding.cpuImage.setImageResource(R.drawable.choki)
                    binding.resultText.text = "引き分けです"
                    binding.resultText.setTextColor(Color.GRAY)
                }
                2 -> {
                    binding.cpuImage.setImageResource(R.drawable.paa)
                    binding.resultText.text = "あなたの勝ちです"
                    binding.resultText.setTextColor(Color.RED)
                    playerWinAction()
                }
            }
        }

        binding.paaButton.setOnClickListener{
            binding.playerImage.setImageResource(R.drawable.paa)
            val number: Int = Random.nextInt(3)

            when(number){
                0 -> {
                    binding.cpuImage.setImageResource(R.drawable.goo)
                    binding.resultText.text = "あなたの勝ちです"
                    binding.resultText.setTextColor(Color.RED)
                    playerWinAction()
                }
                1 -> {
                    binding.cpuImage.setImageResource(R.drawable.choki)
                    binding.resultText.text = "あなたの負けです"
                    binding.resultText.setTextColor(Color.BLUE)
                    cpuWinAction()
                }
                2 -> {
                    binding.cpuImage.setImageResource(R.drawable.paa)
                    binding.resultText.text = "引き分けです"
                    binding.resultText.setTextColor(Color.GRAY)
                }
            }
        }
    }

    fun playerWinAction(){
        playerNumber = playerNumber + 1
        binding.playerNumberText.text = playerNumber.toString()
        binding.playerNumberText.setTextColor(Color.RED)
        binding.cpuNumberText.setTextColor(Color.GRAY)
    }

    fun cpuWinAction(){
        cpuNumber = cpuNumber + 1
        binding.cpuNumberText.text = cpuNumber.toString()
        binding.cpuNumberText.setTextColor(Color.BLUE)
        binding.playerNumberText.setTextColor(Color.GRAY)
    }
}