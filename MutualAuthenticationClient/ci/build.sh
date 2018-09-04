#!/bin/bash

export TERM=${TERM:-dumb}
cd repo/MutualAuthenticationClient
./gradlew --no-daemon build
