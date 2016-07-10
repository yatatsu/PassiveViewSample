package com.yatatsu.passiveviewsample.data.model


class Repository {
  var name: String? = null
  var fullName: String? = null
  var description: String? = null
  var htmlUrl: String? = null
  var stargazersCount: Int = 0
  var watchersCount: Int = 0

  constructor(name: String,
      fullName: String,
      description: String,
      htmlUrl: String,
      stargazersCount: Int,
      watchersCount: Int) {
    this.name = name
    this.fullName = fullName
    this.description = description
    this.htmlUrl = htmlUrl
    this.stargazersCount = stargazersCount
    this.watchersCount = watchersCount
  }

  constructor() {

  }

}
