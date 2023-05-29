projectDir = new File(new File(request.outputDirectory), request.artifactId)

jakartaEEVariant = request.getProperties().get("jakartaEEVariant")
if ("jakartaee-core".equals(jakartaEEVariant)) {
    persistenceXml = new File(projectDir.toString(), "src/main/resources/META-INF/persistence.xml")

    persistenceXml.delete()
}

javaVersionStr = request.getProperties().get("javaVersion")
double javaVersion = javaVersionStr as double
def mavenCompilerOption
if (javaVersion >= 9) {
    mavenCompilerOption = "\t<maven.compiler.release>${javaVersionStr}</maven.compiler.release>"
} else {
    mavenCompilerOption = "\t<maven.compiler.source>${javaVersionStr}</maven.compiler.source>" + System.getProperty("line.separator") + 
                          "\t<maven.compiler.target>${javaVersionStr}</maven.compiler.target>"
}

pomXml = new File(projectDir.toString(), "pom.xml")
pomXml.text = pomXml.text.replace("#mavenCompilerOption", mavenCompilerOption)
