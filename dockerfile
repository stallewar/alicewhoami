# Используем образ Maven как основу для сборки
FROM maven AS build

# Копируем pom.xml в контейнер
COPY . /app

# Переходим в директорию /app
WORKDIR /app

# Выполняем команду Maven для сборки проекта
RUN mvn clean package
RUN ls -la /app/target
# Создаем новый образ для запуска приложения
FROM openjdk

# Копируем собранный проект в контейнер
COPY --from=build /app/target/*.jar /app/app.jar

# Устанавливаем переменную окружения для запуска приложения
ENV JAVA_OPTS=""

# Запускаем приложение при запуске контейнера
#CMD ["/bin/sh"]

CMD ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]
