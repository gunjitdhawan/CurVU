package com.grappes.curvu

import android.graphics.*
import android.view.ViewGroup
import android.graphics.drawable.BitmapDrawable
import android.graphics.Bitmap

fun ViewGroup.curveIt(curVU: CurVU) {

    this.post {
        var paint = Paint()
        var width = this.measuredWidth
        var height = this.measuredHeight

        layoutParams.height = height
        val pallet = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        var canvas = Canvas(pallet)
        val r = getRectCoordinates(width, height, curVU.curvature)
        paint.style = Paint.Style.FILL

        paint.shader = LinearGradient(
            0f,
            0f,
            width.toFloat(),
            height.toFloat(),
            context.resources.getColor(curVU.startColor),
            context.resources.getColor(curVU.endColor),
            Shader.TileMode.CLAMP
        )

        val drawable = BitmapDrawable(resources, pallet)

        canvas.drawArc(r, 0f, 180f, true, paint)

        this.background = drawable
        requestLayout()
    }

}

fun getRectCoordinates(width: Int, height: Int, curvature: CurVU.Curvature) : RectF {



    var multiplier : Float = when(curvature) {
        CurVU.Curvature.HIGH -> 1f
        CurVU.Curvature.MEDIUM -> 2f
        CurVU.Curvature.LOW -> 3f
    }

    return RectF((-multiplier*width), ((-height * 2).toFloat()), ((multiplier+1)*width), height.toFloat())
}