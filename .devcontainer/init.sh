#!/bin/bash

echo "Initializing repository for dev container"

echo "Copying dotenv and config examples to the dotenv and config files"
cp ./example.env .env
cp ./app/example.env ./app/.env
cp ./postgres/example.env ./postgres/.env
cp ./oauth/example.env ./oauth/.env
cp ./oauth/example-config.json ./oauth/config.json
echo "Dotenv and config examples copied, don't forget to replace values as needed"
