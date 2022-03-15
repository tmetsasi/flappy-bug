import constants._
import scala.util.Random


class Obstacle(val radius: Int) {
    private def randomLaunchPosition() = { 
    val launchX = ViewWidth + this.radius + Random.nextInt(500)
    val launchY = Random.nextInt(ViewHeight)
    new Pos(launchX, launchY)
  }
  private var currentPos = this.randomLaunchPosition() 
  def pos = this.currentPos 
  override def toString = "center at " + this.pos + ", radius " + this.radius
  def touches(bug: Bug) = { 
    this.pos.distance(bug.pos) <= bug.radius + this.radius
  }
  def isActive = this.pos.x >= -this.radius
  def approach() = {
    this.currentPos =
      if (isActive) 
        this.currentPos.addX(-ObstacleSpeed) 
      else
        this.randomLaunchPosition()
  }
}
