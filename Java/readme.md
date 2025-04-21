---------------How to Run---------------

# Compile and run tests
mvn clean install

# Start the application
mvn spring-boot:run

------------ How to Build and Run Docker Container ---------------
# Build the Docker image
docker build -t codekamikaze-app .

# Run the Docker container
docker run -p 8080:8080 codekamikaze-app
