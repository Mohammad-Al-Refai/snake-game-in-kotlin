import UI.UI
import models.Apple
import models.Directions
import models.Snake
import processing.core.PApplet


class GameModel(p: PApplet) {
    private var resolution = 20f
    private var frame = 5f
    private var score = 0
    private var snake = Snake(p, resolution)
    private var apple = Apple(p, resolution)
    private var ui = UI(p, resolution)
    var isGameEnded = false
    private fun addPoint() {
        score += 10
    }

    private fun update() {
        if (snake.isSnakeDead) {
            endGame()

        }
        if (snake.isCollidedApple(apple)) {
            addPoint()
            apple.changePos()
        }
    }

    fun getResolution() = resolution
    fun getApple() = apple
    fun getSnake() = snake
    fun getFrame() = frame
    fun start() {
        if (isGameEnded) {
            ui.drawGameOver(score.toString())
        } else {
            ui.drawScore(score.toString())
            snake.draw()
            apple.draw()
            update()
        }
    }

    fun restartGame() {
        snake.restart()
        score = 0
        isGameEnded = false
        apple.changePos()
        snake.setDirection(Directions.RIGHT)


    }

    fun endGame() {
        isGameEnded = true
    }

}