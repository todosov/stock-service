#!/usr/bin/env bash

cd stock-service-ui
npm install
npm run build
cd ..
./gradlew bootRun