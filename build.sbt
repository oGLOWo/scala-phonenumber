import SonatypeKeys._

sonatypeSettings

organization  := "com.oglowo"

name          := "scala-phonenumber"

version       := "0.2"

description   := "This will eventually be a port of Google's libphonenumber to Scala. For now, because I need this functionality quick, it simply wraps libphonenumber. It is NOT complete by any means. I've only added the functionality that I needed. Currently you get a PhoneNumber case class that assumes the country is USA when you don't pass the country in. While you can pass the country in, the only country defined is USA. If you're interested in more from this library, report an issue or send me a pull request. I want to complete it and slowly remove the dependency on Google's libphonenumber"

startYear     := Some(2013)

homepage      := Some(url("https://github.com/oGLOWo/scala-phonenumber"))

organizationHomepage := Some(url("http://oGLOWo.com"))

licenses      := Seq(("Apache 2.0", url("http://www.apache.org/licenses/LICENSE-2.0")))

scmInfo       := Some(ScmInfo(url("https://github.com/oGLOWo/scala-phonenumber"), "scm:git:https://github.com/oGLOWo/scala-phonenumber.git", Some("scm:git:git@github.com:oGLOWo/scala-phonenumber.git")))

scalaVersion  := "2.10.4"

crossScalaVersions := Seq("2.10.0", "2.10.1", "2.10.2", "2.10.3", "2.10.4")

scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8", "-language:postfixOps", "-language:implicitConversions", "-Xlint")

useGpg := true

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra :=
  <developers>
    <developer>
      <id>oGLOWo</id>
      <name>Adrian Rodriguez</name>
      <url>http://oGLOWo.com</url>
    </developer>
  </developers>

libraryDependencies ++= Seq(
  "org.specs2"                     %%  "specs2"              %  "1.14"  %  "test",
  "org.scalaz"                     %%  "scalaz-core"         %  "7.0.0",
  "com.chuusai"                    %%  "shapeless"           %  "1.2.4",
  "com.typesafe"                   %%  "scalalogging-slf4j"  %  "1.0.1",
  "com.googlecode.libphonenumber"  %   "libphonenumber"      %  "4.3",
  "com.googlecode.libphonenumber"  %   "geocoder"            %  "1.7"
)
