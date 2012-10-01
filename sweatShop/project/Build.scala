import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "sweatShop"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "com.typesafe" % "play-plugins-guice" % "2.0.3",
      "org.mockito" % "mockito-all" % "1.9.0"
      // Add your project dependencies here
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here      
    )

}
