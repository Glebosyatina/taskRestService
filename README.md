to start app( if db is already running)

java -jar target/myapp-0.0.1-SNAPSHOT.jar

mvn package - to rebuild app (db must be run)

to start in docker - docker build -t myapp:0.0.1 . 

docker-compose up -d (start app and db in containers)
