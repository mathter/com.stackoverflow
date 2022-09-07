# Abstract
This project contains several examples of using jvm compatable languages.

# Jasperrreports sample
[Jasperreports](./jasperreports) with embedded fonts and fix of *java.lang.NullPointerException: Cannot load from short array because "sun.awt.FontConfiguration.head" is null*

Building and testing
```shell
# Build java project
./mvnw clean package

# Build docker image
docker build -t jasperreports ./jasperreports/

# Start docker app and bind to port 8080
docker run -i --name jsaperreports -p 8080:8080 jasperreports
```

And go to http://localhost:8080/jasperreports/print

