package models

import processing.core.PApplet
import kotlin.math.floor

class Apple(private var p: PApplet, private var resolution: Float) {
    private var x = floor(p.random(0f, p.width.toFloat()))
    private var y = floor(p.random(0f, p.height.toFloat()))
    private var w = 1f
    private var h = 1f

    init {
        changePos()
    }

    fun draw() {
        p.noStroke()
        p.fill(255f, 0f, 0f)
        p.rect(x, y, w, h)

    }


    fun changePos() {
        x = floor(p.random((p.width / resolution)))
        y = floor(p.random((p.height / resolution)))
    }

    fun getX() = x
    fun getY() = y
    fun getWidth() = x
    fun getHeight() = y
}