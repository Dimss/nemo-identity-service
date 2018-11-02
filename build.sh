#!/usr/bin/env bash
export APP_VERSION=0.4
export PROJECT_NAME=identity
export PROJECT_NS=nemo
export DOCKER_REGISTRY=172.30.1.1:5000
mvn versions:set -DnewVersion=${APP_VERSION}
mvn package -Dspring.profiles.active=dev
docker build --build-arg VERSION=${APP_VERSION} -t ${DOCKER_REGISTRY}/${PROJECT_NS}/${PROJECT_NAME}:${APP_VERSION} .
docker push ${DOCKER_REGISTRY}/${PROJECT_NS}/${PROJECT_NAME}:${APP_VERSION}