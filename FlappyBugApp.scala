import constants._

  
object FlappyBugApp extends App {

  val sky        = rectangle(ViewWidth, ViewHeight,  LightBlue)
  val ground     = rectangle(ViewWidth, GroundDepth, SandyBrown)
  val trunk      = rectangle(30, 250, SaddleBrown)
  val foliage    = circle(200, ForestGreen)
  val tree       = trunk.onto(foliage, TopCenter, Center)
  val rootedTree = tree.onto(ground, BottomCenter, new Pos(ViewWidth / 2, 30))
  val scenery    = sky.place(rootedTree, BottomLeft, BottomLeft)


  val bugPic = Pic("obstacle.png")
  val enemyPic = bugPic

  def rockPic(obstacle: Obstacle) = circle(obstacle.radius * 2, Black)


  val game = new Game 
  val gui = new View(game, "FlappyBug") {
    var background = scenery
    
  def makePic = {
    var compositePic = this.background
     compositePic = game.obstacles.foldLeft(compositePic)( (juu, obstacle) => juu.place(enemyPic.scaleTo(obstacle.radius *2), obstacle.pos))
        compositePic.place(bugPic, game.bug.pos)  
    }
    
      override def isDone = game.isLost
      override def onKeyDown(painettu: Key) = if (Key.Space == painettu ) game.activateBug()
      override def onTick() = {
        game.timePasses()
        this.background = this.background.shiftLeft(2)
    }
  } 
  gui.start()
}

