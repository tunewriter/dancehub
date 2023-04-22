#!/bin/bash
mvn clean package
scp -i ./<ssh key>.pem ./target/backend-0.0.1-SNAPSHOT.jar <ssh server>:~

ssh -t -i "<ssh key>.pem" <ssh server> << 'EOF'
tmux kill-server
tmux new-session -d -s backend "sudo java -jar --server.port=<optional port> <optional SSL arguments> backend-0.0.1-SNAPSHOT.jar"
EOF