package UI

import processing.core.PApplet
import java.awt.SystemColor.text

class UI(private var p: PApplet, private var resolution: Float) {

    fun drawScore(text: String) {
        p.fill(255f, 255f, 255f)
        p.textSize(2f)
        p.text(text, 1f, 2f)
    }

    fun drawGameOver(score: String) {
        val x = ((p.width / 2) / resolution - 5)
        val y = ((p.height / 2) / resolution - 5)
        p.fill(236f, 78f, 32f)
        p.textSize(2f)
        p.text("Game Over", x, y)
        p.fill(255f, 255f, 255f)
        p.textSize(1f)
        p.text("Score: $score", x, y + 5)
        p.fill(2f, 255f, 2f)
        p.textSize(1f)
        p.text("press R to restart game", x, y + 10)


    }

}