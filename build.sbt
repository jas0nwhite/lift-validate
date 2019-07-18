import LiftModuleKeys.{liftVersion, liftEdition}

moduleName := "lift-validate"
organization := "net.liftmodules"
description := "Lift validate module"
licenses += ("Apache 2.0 License", url("http://www.apache.org/licenses/LICENSE-2.0"))
homepage := Some(url("http://github.com/limansky/lift-validate"))
version in ThisBuild := "2.0-SNAPSHOT"
liftVersion in ThisBuild := {
  liftVersion ?? "3.3.0"
}.value
liftEdition in ThisBuild := {
  liftVersion apply {
    _.substring(0, 3)
  }
}.value
moduleName := {
  name.value + "_" + liftEdition.value
}
scalaVersion in ThisBuild := "2.12.8"
scalacOptions ++= Seq("-unchecked", "-deprecation")
crossScalaVersions := Seq("2.12.8", "2.10.5", "2.9.2")

logLevel := Level.Info

resolvers ++= Seq(
  "Scala Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "Scala" at "https://oss.sonatype.org/content/groups/scala-tools/"
)

libraryDependencies in ThisBuild ++= {
  "net.liftweb" %% "lift-webkit" % liftVersion.value % "provided" ::
  "net.liftweb" %% "lift-json" % liftVersion.value % "provided" ::
  "org.mockito" % "mockito-core" % "1.10.19" % "test" ::
  Nil
}

libraryDependencies in ThisBuild += {
  val scalatestV = scalaVersion.value match {
    case "2.9.2"  => "1.9.2"
    case "2.10.5" => "2.2.4"
    case _        => "3.0.8"
  }

  "org.scalatest" %% "scalatest" % scalatestV % "test"
}

//scalariformSettings

/*
publishMavenStyle := true

publishArtifact in Test := false

scmInfo := Some(
  ScmInfo(
    url("https://github.com/limansky/lift-validate"),
    "scm:git:https://github.com/limansky/lift-validate.git",
    Some("scm:git:git@github.com:limansky/lift-validate.git")
  )
)

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (version.value.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

pomExtra := (
            <developers>
              <developer>
                <id>limansky</id>
                <name>Mike Limansky</name>
                <url>http://github.com/limansky</url>
              </developer>
              <developer>
                <id>victor</id>
                <name>Victor Mikheev</name>
                <url>https://github.com/VictorMikheev</url>
              </developer>
            </developers>)
*/
