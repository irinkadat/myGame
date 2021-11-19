package com.example.game

import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var resetButton: Button

    private var activePlayer=1
    private var firstPlayer=ArrayList<Int>()
    private var secondPlayer=ArrayList<Int>()



    var firsPlayerScore=0
    var secondPlayerScore=0

    private lateinit var player1Score: TextView
    private lateinit var player2Score: TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()

        setContentView(R.layout.activity_main)

        init()

    }

    private fun init() {
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)

        player1Score=findViewById(R.id.player1Score)
        player2Score=findViewById(R.id.player2Score)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

        resetButton = findViewById(R.id.resetButton)

        resetButton.setOnClickListener {
            reset()



        }


    }





    override fun onClick(clickedView: View?) {

        if (clickedView is Button) {
            var buttonNumber=0

            when(clickedView.id) {
                R.id.button1->buttonNumber=1
                R.id.button2->buttonNumber=2
                R.id.button3->buttonNumber=3
                R.id.button4->buttonNumber=4
                R.id.button5->buttonNumber=5
                R.id.button6->buttonNumber=6
                R.id.button7->buttonNumber=7
                R.id.button8->buttonNumber=8
                R.id.button9->buttonNumber=9


            }

            if (buttonNumber!=0) {
                playGame(clickedView,buttonNumber)
            }



        }


    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {
        if(activePlayer==1) {
            activePlayer=2
            clickedView.text="X"
            clickedView.setBackgroundColor(Color.BLACK)
            firstPlayer.add(buttonNumber)
        } else {
            activePlayer=1
            clickedView.text="0"
            clickedView.setBackgroundColor(Color.BLACK)
            secondPlayer.add(buttonNumber)
        }
        clickedView.isEnabled=false
        check()




    }





    private fun check() {
        var winnerPlayer=0
        
        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer=1


        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)){
            winnerPlayer=2

        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer=1

        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)){
            winnerPlayer=2

        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer=1

        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)){
            winnerPlayer=2

        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer=1

        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)){
            winnerPlayer=2

        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer=1

        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)){
            winnerPlayer=2

        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer=1

        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)){
            winnerPlayer=2

        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer=1

        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)){
            winnerPlayer=2

        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer=1

        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)){
            winnerPlayer=2

        }

        if (winnerPlayer==1) {

            firsPlayerScore++
            player1Score.text=firsPlayerScore.toString()


            Toast.makeText(this, "winner is player 1", Toast.LENGTH_SHORT).show()
            disableButtons()
        }
        else if (winnerPlayer==2) {

            secondPlayerScore++
            player2Score.text=secondPlayerScore.toString()

            Toast.makeText(this, "winner is player 2", Toast.LENGTH_SHORT).show()
            disableButtons()
        }


    }

    private fun disableButtons() {
        button1.isEnabled=false
        button2.isEnabled=false
        button3.isEnabled=false
        button4.isEnabled=false
        button5.isEnabled=false
        button6.isEnabled=false
        button7.isEnabled=false
        button8.isEnabled=false
        button9.isEnabled=false
    }

    private fun reset() {
        activePlayer=1
        firstPlayer.clear()
        secondPlayer.clear()






        button1.isEnabled= true
        button1.text=""
        button1.setBackgroundColor(Color.MAGENTA)

        button2.isEnabled= true
        button2.text=""
        button2.setBackgroundColor(Color.MAGENTA)

        button3.isEnabled= true
        button3.text=""
        button3.setBackgroundColor(Color.MAGENTA)

        button4.isEnabled= true
        button4.text=""
        button4.setBackgroundColor(Color.MAGENTA)

        button5.isEnabled= true
        button5.text=""
        button5.setBackgroundColor(Color.MAGENTA)

        button6.isEnabled= true
        button6.text=""
        button6.setBackgroundColor(Color.MAGENTA)

        button7.isEnabled= true
        button7.text=""
        button7.setBackgroundColor(Color.MAGENTA)

        button8.isEnabled= true
        button8.text=""
        button8.setBackgroundColor(Color.MAGENTA)

        button9.isEnabled= true
        button9.text=""
        button9.setBackgroundColor(Color.MAGENTA)





    }

    }

