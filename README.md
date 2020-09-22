# github-packages-playground

### Publish `sbt` library to Github Packages

> We will use [sb-github-packages](https://github.com/djspiewak/sbt-github-packages) plugin in this tutorial

#### 1. Generate a personal access token with `package:write` permission

Get your personal access token in `settings - developer settings - personal access token`
![](https://camo.githubusercontent.com/300622218c96288431c7bd4530f721bf27e1b983/68747470733a2f2f692e696d6775722e636f6d2f656b64794162322e706e67)

Then goto `generate token`, please remember this token, we will use it in step 3.

#### 2. Add `sbt-github-packages` plugin into your sbt project

Add this line to your `./project/plugins.sbt`
```bash
addSbtPlugin("com.codecommit" % "sbt-github-packages" % "0.5.2")
```

#### 3. Set `GITHUB_TOKEN=<personal_token>` as environment variable

```bash
export GITHUB_TOKEN=<personal_token>
```

#### 4. Get ready to publish your package 

Add these two lines to your `./build.sbt`

```bash
ThisBuild / githubOwner := "<github_username>"
ThisBuild / githubRepository := "<repo_name>"
```

For example, my username is `gjuoun` and this repo name is `github-packages-playground`. Fill the fields as yours.

#### 5. Publish to Github Packages

Run this command in your terminal
```bash
> sbt publish
```

Then you will see this `package` tab available in your repo:
![image](https://user-images.githubusercontent.com/8935612/93931869-bc9fd580-fcf5-11ea-8639-f15b95cc8199.png)
