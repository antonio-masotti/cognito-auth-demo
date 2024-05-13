# Mini-demo: Authenticate user via Cognito SDK

This is a mini-demo to show how to authenticate a user via the Cognito SDK
using the `adminInitiateAuth` method provided by the SDK.


### Prerequisites

Make sure to have the following env vars set:

```bash
# Needed for Login
COGNITO_CLIENT_ID=<cognito_client_id>
COGNITO_USER_POOL_ID=<cognito_user_pool_id>
USERNAME=<username>
PASSWORD=<password>

# Needed for using the SDK
AWS_PROFILE=<aws_profile> # preferred if working with IAM SSO or assuming roles
# or alternatively
AWS_ACCESS_KEY_ID=<aws_access_key_id>
AWS_SECRET_ACCESS_KEY=<aws_secret_access_key>
```

### Run

Run the project by either using the IDE run configuration or by compiling
and running the project via the command line:


### Trivia
In this minimal project I'm also experimenting with a couple of nice features:

- Gradle version catalog plugin to manage the versions of the dependencies
and satisfy the linters, DAST and SAST tools that complain about hardcoded versions.

- AWS SDK for Kotlin here, now stable (as it is the Rust one)

- Kotlin compiler K2, soon to be stable
