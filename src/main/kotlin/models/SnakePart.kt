package models

import processing.core.PApplet

class SnakeBody(private val p: PApplet, val x:Float, val y:Float, val width:Float, val height:Float){
    fun draw(){
        p.fill(0f,0f,255f)
        p.rect(x,y,width,height)
    }
}