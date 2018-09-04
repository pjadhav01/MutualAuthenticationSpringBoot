#!/bin/bash

export TERM=${TERM:-dumb}
cd resource-tutorial/MutualAuthenticationClient
./gradlew --no-daemon build
