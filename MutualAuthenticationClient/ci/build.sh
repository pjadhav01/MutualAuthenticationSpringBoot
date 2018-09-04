#!/bin/bash

export TERM=${TERM:-dumb}
cd MutualAuthenticationClient
./gradlew --no-daemon build
