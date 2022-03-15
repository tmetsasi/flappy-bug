import constants._

class Game { 
  val bug = new Bug(new Pos(100,40))
  val obstacles = Vector[Obstacle](new Obstacle(70), new Obstacle(30), new Obstacle(20), new Obstacle(50), new Obstacle(55))
  def timePasses() = {
    this.bug.fall()
    this.obstacles.foreach(_.approach())
  }
  def isLost: Boolean = {
    !this.bug.isInBounds || this.obstacles.exists(_.touches(bug))
 
  }
  
  def activateBug() = this.bug.flap(15.0)
  
}
