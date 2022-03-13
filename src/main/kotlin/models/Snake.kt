package models


import processing.core.PApplet
import utils.Vector

class Snake(private var p: PApplet, private var resolution: Float) {
    private var x: Float = 0f
    private var y: Float = 0f
    private var w: Float = 1f
    private var h: Float = 1f
    private var direction: Directions = Directions.RIGHT
    private var snakeParts = mutableListOf<SnakeBody>()
    var isSnakeDead = false
    private fun goUP() {
        y -= 1
    }

    private fun goDown() {
        y += 1
    }

    private fun goLeft() {
        x -= 1
    }

    private fun goRight() {
        x += 1
    }

    fun draw() {
        //render body of snake and check if collided itself or borders of window
        update()
        //render snake
        p.fill(1f, 111f, 185f)
        p.rect(x, y, w, h)
        //check direction to change [x,y]
        move()
    }

    private fun move() {
        when (direction) {
            Directions.LEFT -> goLeft()
            Directions.RIGHT -> goRight()
            Directions.DOWN -> goDown()
            Directions.UP -> goUP()
        }
    }

    private fun update() {
        val head = Vector(x, y)
        if (snakeParts.size != 0) {
            //remove first part of snake
            snakeParts.remove(snakeParts.first())
            //render body of snake
            snakeParts.forEach {
                it.draw()
                //check if collided itself
                if (isCollided(Vector(it.x, it.y))) {
                    isSnakeDead = true
                }

            }
            //add first part of snake with last vector of head
            snakeParts.add(SnakeBody(p, head.x, head.y, w, h))
        }
        //check if collided borders
        if (isCollidedBorders()) {
            isSnakeDead = true
        }

    }

    private fun grow() {

        snakeParts.add(SnakeBody(p, -100f, -100f, w, h))
    }

    fun isCollidedApple(apple: Apple): Boolean {
        if (apple.getX() == x && apple.getY() == y) {
            grow()
            return true
        }
        return false
    }

    private fun isCollidedBorders(): Boolean {
        if (x > (p.width / resolution) || y > (p.height / resolution) || x < 0 || y < 0) return true
        return false
    }

    private fun isCollided(obj: Vector): Boolean {
        if (obj.x == x && obj.y == y) return true
        return false
    }

    fun setDirection(dir: Directions) {
        direction = dir
    }

    fun restart() {
        x = 0f
        y = 0f
        snakeParts.clear()
        isSnakeDead = false

    }

    fun getX() = x
    fun getY() = y
    fun getDirection() = direction
}



