# Publish sbt package to Github Packages

### Publish `sbt` library to Github Packages

> We will use [sbt-github-packages](https://github.com/djspiewak/sbt-github-packages) plugin in this tutorial

#### 1. Generate a personal access token with `package:write` permission

Get your personal access token in `settings - developer settings - personal access token`

![image](https://user-images.githubusercontent.com/8935612/93943795-a0a62f00-fd09-11ea-84b3-ae55a96cd4d5.png)

Then goto `generate token`, please remember this token, we will use it in step 3.

#### 2. Add `sbt-github-packages` plugin into your existing sbt project

Add this line to your `./project/plugins.sbt`
```bash
addSbtPlugin("com.codecommit" % "sbt-github-packages" % "0.5.2")
```

#### 3. Set global git `github.token` to allow the plugin to work

```bash
git config --global github.user <github_username>
git config --global github.token <personal_token>
```

you should be able to view it at `~/.gitconfig`

```bash
[github]
	token = <personal_token>
	user = <username>
...
```

#### 4. Get ready to publish your package 

Add these these lines to your `./build.sbt`

```bash
githubOwner := "<github_username>"
githubRepository := "<github_repo_name>"
githubTokenSource := TokenSource.GitConfig("github.token")
```
after adding them you should re-run the build or restart the IDE (if you're using IntelliJ)

For example, my username is `gjuoun` and this repo name is `github-packages-playground`. Fill the fields as yours.

#### 5. Publish to Github Packages

Run this command to publish your package:
```bash
> sbt publish
```

Then you will see this `package` tab available in your repo:

![image](https://user-images.githubusercontent.com/8935612/93931869-bc9fd580-fcf5-11ea-8639-f15b95cc8199.png)


The package name is `<organization>.<name>_<scalaVersion>`, the example below has a package version `0.1.2` which is from `<version>`. 
All naming conventions are from the variables in `./build.sbt`.

![image](https://user-images.githubusercontent.com/8935612/93932180-291ad480-fcf6-11ea-84c4-0f79978dc1e2.png)


---

### Use sbt package from Github Packages

> We will use [sbt-github-packages](https://github.com/djspiewak/sbt-github-packages) plugin in this tutorial
> You should have followed step 1-5 above and published your package.


#### 1. Add `sbt-github-packages` plugin to enable sbt to consume the package

Add this line to your `./project/plugins.sbt`
```bash
addSbtPlugin("com.codecommit" % "sbt-github-packages" % "0.5.2")
```

#### 2. Add library resolver and dependencies to `./build.sbt`


Add these lines to the your codebase './build.sbt` make the plugin to work
```
githubTokenSource := TokenSource.GitConfig("github.token")

resolvers += Resolver.githubPackages("<github_username>", "<github_repo_name>")

libraryDependencies += "<organization>" %% "<package_name>" % "<version>"
```

Well, there are many fields we need to match them with your package. You can **ignore the `<github_repo_name>` field**, doing so the plugin will resolve all available packages in github account `<github_username>`.

We'd like to take the package in this repo `build.sbt` as an example:

```scala
// https://github.com/gjuoun/github-packages-playground/blob/master/build.sbt
name := "hellopackage"
scalaVersion := "2.13.3"
version := "0.1.6"
organization := "gjuoun"

githubOwner := "gjuoun"
githubRepository := "github-packages-playground"
githubTokenSource := TokenSource.GitConfig("github.token")
```

Where: 
 - `github_username = gjuoun` //githubOwner
 - `github_repo_name = github-packages-playground` //githubRepository
 - `organization = gjuoun` // organization
 - `package_name = hellopackage` // name
 - `version = 0.1.6` // version
 
 You're free to match these information in the package page as well:
 
 ![image](https://user-images.githubusercontent.com/8935612/93945682-c9302800-fd0d-11ea-8bd3-88cd67324317.png)

 

 #### 3. Compile the code
 
 Now you should able to compile your code with the new plugin
 
 ```shell
 > sbt compile
 ```
 
 #### 4. Use the package
 
 I would like to consume my package: 
 
```scala
// https://github.com/gjuoun/github-packages-playground/blob/master/src/main/scala/org/gjuoun/lib/calculator.scala
package org.gjuoun.lib

class Calculator{
  def add(x: Int, y:Int): Int ={
    x+y
  }
}
```

Importing the package becomes very easy, just follow the package name: `org.gjuoun.lib`

```scala
import org.gjuoun.lib.Calculator

```
// use it with
  var cal = new Calculator()
  Console.println(cal.add(10, 100))
```

Done. That's it. 

 
 
