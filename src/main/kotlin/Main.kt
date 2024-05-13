package de.bikeleasing

import aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient
import aws.sdk.kotlin.services.cognitoidentityprovider.model.AdminInitiateAuthRequest
import aws.sdk.kotlin.services.cognitoidentityprovider.model.AdminInitiateAuthResponse
import aws.sdk.kotlin.services.cognitoidentityprovider.model.AuthFlowType
import de.bikeleasing.model.AuthParams
import de.bikeleasing.model.PoolParams
import kotlinx.coroutines.runBlocking

suspend fun login(credentials: AuthParams, poolParams: PoolParams): AdminInitiateAuthResponse {
    val request = AdminInitiateAuthRequest {
        clientId = poolParams.clientId
        userPoolId = poolParams.userPoolId
        authFlow = AuthFlowType.AdminUserPasswordAuth
        authParameters = credentials.toMap()
    }

    CognitoIdentityProviderClient { region = "eu-central-1" }.use { idp ->
        return idp.adminInitiateAuth(request)
    }
}
@Suppress("InvalidPackageDeclaration")
fun main() = runBlocking {
    val authParams = AuthParams.fromEnv()
    val poolParams = PoolParams.fromEnv()

    try {
        val authn = login(authParams, poolParams)
        println("Login successful\n\n")
        println("\tIdentity Token: ${authn.authenticationResult?.idToken}\n\n")
        println("\tAccess-Token: ${authn.authenticationResult?.accessToken}\n\n")
        println("\tExpires at: ${authn.authenticationResult?.expiresIn}\n\n")
    } catch (e: Exception) {
        println("Login failed: ${e.message}")
    }

}
