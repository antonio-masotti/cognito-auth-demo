package de.bikeleasing.model

data class AuthParams(private val username: String, private val password: String) {

    companion object {
      fun fromEnv() : AuthParams {
          val username = System.getenv("USERNAME")
          val password = System.getenv("PASSWORD")

          require(username != null) { "COGNITO_USERNAME must be set" }
          require(password != null) { "COGNITO_PASSWORD must be set" }

          return AuthParams(username, password)
      }
    }

    fun toMap() : Map<String, String> {
        return mapOf(
            "USERNAME" to username,
            "PASSWORD" to password
        )
    }
}

