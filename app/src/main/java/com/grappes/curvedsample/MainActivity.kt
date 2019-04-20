package com.grappes.curvedsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.grappes.curvu.CurVU
import com.grappes.curvu.curveIt
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutWithExtensionPower.curveIt(CurVU.Builder().startColor(R.color.startColor)
            .endColor(R.color.endColor)
            .curvature(CurVU.Curvature.HIGH)
            .build()!!)
    }
}
