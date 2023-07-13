FROM maven:3.8.7-openjdk-18-slim

ENV PROJECT_HOME /usr/src/todolist
ENV JAR_NAME desafio-todolist-0.0.1-SNAPSHOT.jar

RUN mkdir -p ${PROJECT_HOME}
WORKDIR ${PROJECT_HOME}

COPY . .

RUN mvn clean package -DskipTests

RUN mv ${PROJECT_HOME}/target/${JAR_NAME} ${PROJECT_HOME}/

ENTRYPOINT [ "java", "-jar", "desafio-todolist-0.0.1-SNAPSHOT.jar"]




