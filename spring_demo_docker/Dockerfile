# Use the official Tomcat 10.1 image as the base image
FROM tomcat:10.1

# Remove the default webapps to keep the container clean
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the WAR file to the Tomcat webapps directory
COPY spring_demo_docker.war /usr/local/tomcat/webapps/spring_demo_docker.war

# Expose the default Tomcat port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]