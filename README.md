# Hotel Management Service (HMS)

A Spring Boot microservice application for handling hotel management operations.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [Docker](#docker)
- [Kubernetes Deployment](#kubernetes-deployment)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Introduction
A Spring Boot application to take requests via REST and perform database operations.

## Features
- RESTful API for hotel management
- Database operations
- Docker containerization
- Kubernetes deployment

## Getting Started

### Prerequisites
- Java 11+
- Docker
- Kubernetes
- Terraform

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/suneel-kms123/hms.git
   cd hms
2. Build application
 gradle build  
3. Run the application
   gradle bootjar
  
### Docker
  create a lightweight docker image os the application and push it to repository via github actions

### Deploy the docker container on the kubernetes cluster
  github actions will deploy the container on the cluster created by terraform as pre requisite
  
### Test the connectivity to the application deployed
