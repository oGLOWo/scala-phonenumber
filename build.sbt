organization  := "com.oglowo"

name          := "scala-phonenumber"

version       := "0.1"

scalaVersion  := "2.10.1"

scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8")

//javaOptions := Seq("-Xdebug", "-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005")

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/"
)

libraryDependencies ++= Seq(
  "org.specs2"           %%  "specs2"        % "1.14" % "test",
  "org.scalaz" %% "scalaz-core" % "7.0.0",
  "com.chuusai" %% "shapeless" % "1.2.4",
  "com.typesafe" %% "scalalogging-slf4j" % "1.0.1",
  "com.googlecode.libphonenumber" % "libphonenumber" % "4.3",
  "com.googlecode.libphonenumber" % "geocoder" % "1.7"
)
