enablePlugins(ScalaJSPlugin)

name := "Foo root project"

scalaVersion in ThisBuild := "2.12.6"

lazy val root = project.in(file(".")).
  aggregate(fooJS, fooJVM).
  settings(
    publish := {},
    publishLocal := {}
  )

lazy val foo = crossProject.in(file(".")).
  settings(
    name := "foo",
    version := "0.1-SNAPSHOT"
  ).
  jvmSettings(
    libraryDependencies ++= List(
      "com.glassbeam" %% "scalar-spl" % "6.1.0.0"
    )
  ).
  jsSettings(
    // Add JS-specific settings here
  )

lazy val fooJVM = foo.jvm
lazy val fooJS = foo.js
