#!/bin/bash

set -e  # Exit on any error

echo "🚧 Shutting down Docker Compose and removing volumes..."
docker compose down -v

echo "🧹 Cleaning and building Maven project (skipping tests)..."
mvn clean install -DskipTests

echo "🐳 Starting Docker Compose and rebuilding images..."
docker compose up --build