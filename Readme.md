```docker
    docker run --name nacos -d -p 8848:8848 \
    --privileged=true \
    --restart=always \
    -e JVM_XMS=256m \
    -e JVM_XMX=256m \
    -e PREFER_HOST_MODE=hostname \
    -e MODE=standalone \
    -e SPRING_DATASOURCE_PLATFORM=mysql \
    -e MYSQL_SERVICE_HOST=172.17.0.1 \
    -e MYSQL_SERVICE_DB_NAME=nacos \
    -e MYSQL_SERVICE_PORT=3306 \
    -e MYSQL_SERVICE_USER=nacos \
    -e MYSQL_SERVICE_PASSWORD='****' \
    -e MYSQL_SERVICE_DB_PARAM='characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&serverTimezone=Asia/Shanghai' \
    -e MYSQL_DATABASE_NUM=1 \
    nacos/nacos-server
```

