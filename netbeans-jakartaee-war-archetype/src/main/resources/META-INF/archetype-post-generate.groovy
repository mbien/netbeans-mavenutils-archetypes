/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

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
