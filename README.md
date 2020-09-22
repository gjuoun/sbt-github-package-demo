# github-packages-playground

### Publish `sbt` library to Github Packages

> We will use [sb-github-packages](https://github.com/djspiewak/sbt-github-packages) plugin in this tutorial

#### 1. Generate a personal access token with `package:write` permission

Get your personal access token in `settings - developer settings - personal access token`

![image](https://user-images.githubusercontent.com/8935612/93943795-a0a62f00-fd09-11ea-84b3-ae55a96cd4d5.png)

Then goto `generate token`, please remember this token, we will use it in step 3.

#### 2. Add `sbt-github-packages` plugin into your sbt project

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
