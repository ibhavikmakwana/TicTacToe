package com.ibhavikmakwana.tictactoe

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


@Suppress("DEPRECATED_IDENTITY_EQUALS")
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var boardStatus = Array(3) { IntArray(3) }
    private var PLAYER_X = false
    private var TURN_COUNT = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iv_00.setOnClickListener(this)
        iv_01.setOnClickListener(this)
        iv_02.setOnClickListener(this)

        iv_10.setOnClickListener(this)
        iv_11.setOnClickListener(this)
        iv_12.setOnClickListener(this)

        iv_20.setOnClickListener(this)
        iv_21.setOnClickListener(this)
        iv_22.setOnClickListener(this)

        btn_reset.setOnClickListener(this)

        initializeBoardStatus()
    }

    private fun initializeBoardStatus() {
        for (i in 0..2) {
            for (j in 0..2) {
                boardStatus[i][j] = -1
            }
        }
    }

    override fun onClick(view: View) {
        Log.d("Message", "Inside onClick")

        var resetButtonPressed = false

        when (view.id) {
            R.id.iv_00 -> {
                if (PLAYER_X) {
                    iv_00.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_cross))
                    boardStatus[0][0] = 1
                } else {
                    iv_00.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_round))
                    boardStatus[0][0] = 0
                }
                iv_00.isEnabled = false
            }

            R.id.iv_01 -> {
                if (PLAYER_X) {
                    iv_01.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_cross))
                    boardStatus[0][1] = 1
                } else {
                    iv_01.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_round))
                    boardStatus[0][1] = 0
                }
                iv_01.isEnabled = false
            }

            R.id.iv_02 -> {
                if (PLAYER_X) {
                    iv_02.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_cross))
                    boardStatus[0][2] = 1
                } else {
                    iv_02.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_round))
                    boardStatus[0][2] = 0
                }
                iv_02.isEnabled = false
            }

            R.id.iv_10 -> {
                if (PLAYER_X) {
                    iv_10.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_cross))
                    boardStatus[1][0] = 1
                } else {
                    iv_10.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_round))
                    boardStatus[1][0] = 0
                }
                iv_10.isEnabled = false
            }

            R.id.iv_11 -> {
                if (PLAYER_X) {
                    iv_11.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_cross))
                    boardStatus[1][1] = 1
                } else {
                    iv_11.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_round))
                    boardStatus[1][1] = 0
                }
                iv_11.isEnabled = false
            }

            R.id.iv_12 -> {
                if (PLAYER_X) {
                    iv_12.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_cross))
                    boardStatus[1][2] = 1
                } else {
                    iv_12.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_round))
                    boardStatus[1][2] = 0
                }
                iv_12.isEnabled = false
            }

            R.id.iv_20 -> {
                if (PLAYER_X) {
                    iv_20.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_cross))
                    boardStatus[2][0] = 1
                } else {
                    iv_20.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_round))
                    boardStatus[2][0] = 0
                }
                iv_20.isEnabled = false
            }

            R.id.iv_21 -> {
                if (PLAYER_X) {
                    iv_21.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_cross))
                    boardStatus[2][1] = 1
                } else {
                    iv_21.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_round))
                    boardStatus[2][1] = 0
                }
                iv_21.isEnabled = false
            }

            R.id.iv_22 -> {
                if (PLAYER_X) {
                    iv_22.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_cross))
                    boardStatus[2][2] = 1
                } else {
                    iv_22.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_round))
                    boardStatus[2][2] = 0
                }
                iv_22.isEnabled = false
            }

            R.id.btn_reset -> {
                resetButtonPressed = true
            }
        }

        if (resetButtonPressed) {
            resetBoard()
        } else {
            TURN_COUNT++
            PLAYER_X = !PLAYER_X

            if (PLAYER_X) {
                setInfo("Player X turn")
            } else {
                setInfo("Player 0 turn")
            }

            if (TURN_COUNT == 9) {
                result("Game Draw")
            }

            checkWinner()
        }
    }

    private fun checkWinner() {
        Log.d("Winner check", "Inside checkWinner")
        //Horizontal --- rows
        for (i in 0..2) {
            if (boardStatus[i][0] === boardStatus[i][1] && boardStatus[i][0] === boardStatus[i][2]) {
                if (boardStatus[i][0] === 1) {
                    result("Player X winner\n" + (i + 1) + " row")
                    break
                } else if (boardStatus[i][0] === 0) {
                    result("Player 0 winner\n" + (i + 1) + " row")
                    break
                }
            }
        }

        //Vertical --- columns
        for (i in 0..2) {
            if (boardStatus[0][i] === boardStatus[1][i] && boardStatus[0][i] === boardStatus[2][i]) {
                if (boardStatus[0][i] === 1) {
                    result("Player X winner\n" + (i + 1) + " column")
                    break
                } else if (boardStatus[0][i] === 0) {
                    result("Player 0 winner\n" + (i + 1) + " column")
                    break
                }
            }
        }

        //First diagonal
        if (boardStatus[0][0] === boardStatus[1][1] && boardStatus[0][0] === boardStatus[2][2]) {
            if (boardStatus[0][0] === 1) {
                result("Player X winner\nFirst Diagonal")
            } else if (boardStatus[0][0] === 0) {
                result("Player 0 winner\nFirst Diagonal")
            }
        }

        //Second diagonal
        if (boardStatus[0][2] === boardStatus[1][1] && boardStatus[0][2] === boardStatus[2][0]) {
            if (boardStatus[0][2] === 1) {
                result("Player X winner\nSecond Diagonal")
            } else if (boardStatus[0][2] === 0) {
                result("Player 0 winner\nSecond Diagonal")
            }
        }
    }

    private fun enableAllBoxes(value: Boolean) {
        Log.d("Enable Boxes", "Inside enableAllBoxes")
        iv_00.isEnabled = value
        iv_01.isEnabled = value
        iv_02.isEnabled = value

        iv_10.isEnabled = value
        iv_11.isEnabled = value
        iv_12.isEnabled = value

        iv_20.isEnabled = value
        iv_21.isEnabled = value
        iv_22.isEnabled = value
    }

    private fun result(winner: String) {
        Log.d("Result", "Inside result")

        setInfo(winner)
        enableAllBoxes(false)
    }

    private fun resetBoard() {
        Log.d("RESET", "Inside resetBoard")
        iv_00.setImageDrawable(null)
        iv_01.setImageDrawable(null)
        iv_02.setImageDrawable(null)

        iv_10.setImageDrawable(null)
        iv_11.setImageDrawable(null)
        iv_12.setImageDrawable(null)

        iv_20.setImageDrawable(null)
        iv_21.setImageDrawable(null)
        iv_22.setImageDrawable(null)

        enableAllBoxes(true)

        PLAYER_X = true
        TURN_COUNT = 0

        initializeBoardStatus()

        setInfo("Start Again!!!")
    }

    private fun setInfo(text: String) {
        if (main_cc != null) {
            val make = Snackbar.make(main_cc, text, Snackbar.LENGTH_LONG)
            make.view.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent))
            make.show()
        }
//        tv_info.text = text
    }
}