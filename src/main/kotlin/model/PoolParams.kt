package de.bikeleasing.model

data class PoolParams(val clientId: String, val userPoolId: String) {
    companion object {
        fun fromEnv() : PoolParams {
            val clientId = System.getenv("COGNITO_CLIENT_ID")
            val userPoolId = System.getenv("COGNITO_USER_POOL_ID")

            require(clientId != null) { "COGNITO_CLIENT_ID must be set" }
            require(userPoolId != null) { "COGNITO_USER_POOL_ID must be set" }

            return PoolParams(clientId, userPoolId)
        }
    }
}
