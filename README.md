# springone-2016
Spring and Big Data examples and slides for SpringOne Platform 2016 in Las Vegas

## Configuring and starting service needed to run demos

### Vagrant hadoop-install

    git clone https://github.com/trisberg/hadoop-install.git
    cd hadoop-install
    git checkout SpringOne-2016-Edition
    vagrant up
    vagrant ssh
    [vagrant@borneo ~]$ export PATH=$PATH:/home/vagrant/hadoop/bin

### 'spotify/kafka' docker image

export KAFKA_HOST=<your-local-ip-address>
docker run -p 2181:2181 -p 9092:9092 --env ADVERTISED_HOST=$KAFKA_HOST --env ADVERTISED_PORT=9092 spotify/kafka

