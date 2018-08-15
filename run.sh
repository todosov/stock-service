#!/usr/bin/env bash

cd stock-service-ui
npm run build
cd ../
./gradlew bootRun
