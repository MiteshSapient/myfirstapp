name := """my-first-app"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.11.7"



libraryDependencies ++= Seq(
  evolutions,
  javaJdbc,
  cache,
  javaWs,
   javaJpa,
  "mysql" % "mysql-connector-java" % "5.1.36"
)

libraryDependencies += jdbc

// Eclipse settings

// Compile the project before generating Eclipse files,
// so that generated .scala or .class files for views and routes are present
EclipseKeys.preTasks := Seq(compile in Compile)

// Java project. Don't expect Scala IDE
EclipseKeys.projectFlavor := EclipseProjectFlavor.Java

// Use .class files instead of generated .scala files for views and routes
EclipseKeys.createSrc := EclipseCreateSrc.ValueSet(EclipseCreateSrc.ManagedClasses, EclipseCreateSrc.ManagedResources)

// End of eclipse settings


routesGenerator := InjectedRoutesGenerator


