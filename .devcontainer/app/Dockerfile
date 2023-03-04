FROM docker.longwell.tech/ubuntu:20.04

ENV SHELL /bin/bash
SHELL [ "/bin/bash", "-c", "-l" ]

ENV DEBIAN_FRONTEND noninteractive

WORKDIR /tmp

RUN apt update -y && apt clean && apt install -y git openjdk-17-jdk wget curl

WORKDIR /workspace

ENTRYPOINT [ "tail", "-f", "/dev/null" ]
