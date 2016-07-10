package com.yatatsu.passiveviewsample.data.model


class User {
  var login: String? = null
  var avatarUrl: String? = null
  var name: String? = null

  constructor() {

  }

  constructor(login: String, name: String, avatarUrl: String) {
    this.login = login
    this.name = name
    this.avatarUrl = avatarUrl
  }
}
