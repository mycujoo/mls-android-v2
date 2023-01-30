#!/bin/zsh

for f in *; do
    if [[ -f "$f/build.gradle" ]] &&  [[ "$f" != *"compose"* ]]; then
      echo ":${f}:test"
      ./gradlew ":${f}:test"
    fi
done