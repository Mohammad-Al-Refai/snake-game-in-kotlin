import models.Directions
import processing.core.PApplet
import processing.event.KeyEvent
import utils.Keys

class Game : PApplet() {
    private var gameModel = GameModel(this)
    override fun settings() {

        size(800, 800)
    }

    override fun setup() {

        frameRate(gameModel.getFrame())
    }

    override fun draw() {
        scale(gameModel.getResolution())
        background(53f, 53f, 49f)
        gameModel.start()
    }

    override fun keyPressed(event: KeyEvent?) {
        if (event != null) {
            if (event.key.uppercase() == Keys.W.name) {
                if (gameModel.getSnake().getDirection() != Directions.DOWN) {
                    gameModel.getSnake().setDirection(Directions.UP)
                }
            }
            if (event.key.uppercase() == Keys.S.name) {
                if (gameModel.getSnake().getDirection() != Directions.UP) {
                    gameModel.getSnake().setDirection(Directions.DOWN)
                }
            }
            if (event.key.uppercase() == Keys.A.name) {
                if (gameModel.getSnake().getDirection() != Directions.RIGHT) {
                    gameModel.getSnake().setDirection(Directions.LEFT)
                }
            }
            if (event.key.uppercase() == Keys.D.name) {
                if (gameModel.getSnake().getDirection() != Directions.LEFT) {
                    gameModel.getSnake().setDirection(Directions.RIGHT)
                }
            }
            if (event.key.uppercase() == Keys.G.name) {
                gameModel.getApple().changePos()
            }
            if (gameModel.isGameEnded) {
                if (event.key.uppercase() == Keys.R.name) {
                    gameModel.restartGame()
                }
            }
        }
    }
}


fun main() = PApplet.main(Game::class.java)