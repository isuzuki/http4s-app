FROM anapsix/alpine-java:8

COPY target/scala-2.12/http4s-app-assembly-1.0.jar /

EXPOSE 8080

CMD ["/bin/sh", "-c", "java -jar http4s-app-assembly-1.0.jar"]
