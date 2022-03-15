import constants._

class Bug(private var initialPos: Pos) { 
  val radius = 15
  private var currentPos = initialPos
  def pos = this.currentPos
  private var yVelocity = 0.0
    def move(ymax: Double) = {
    this.currentPos = this.currentPos.clampY(0, 350)
    this.currentPos = this.currentPos.addY(ymax)
     this.currentPos = this.currentPos.clampY(0, 350)
  }
  
  def flap(x: Double) = yVelocity = -x
  def fall() = {
   if (this.currentPos.y < 350) {
     yVelocity = yVelocity + 2
    move(yVelocity)
   }
  }
  def isInBounds: Boolean = { 
    this.pos.y >0 && this.pos.y < GroundY
  }
  override def toString = "center at " + this.pos + ", radius " + this.radius
}
