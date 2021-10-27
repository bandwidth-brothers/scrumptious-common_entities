# scrumptious-common_entities
## Step 1: Generate a jar file
run command: maven clean install
## Step 2: revome the existed common entitis in target project
in target project, revome the existed common entitis that has been created in common_entites jar file
## Step 3: In target project, import jar file in pom.xml
		<dependency>
			<groupId>com.smoothstack</groupId>
			<artifactId>ss-scrumptious-common_entities</artifactId>
			<version>1.0-SNAPSHOT</version>
		</dependency>
## Step 4: add @EntityScan annotation on starting class
    @EntityScan(basePackages = {"com.ss.scrumptious.common_entities.entity"})
    public class ScrumptiousRestaurantServiceApplication{}
## Step 5: clean any import file error
start from repository, service interface, servcieImpl, other support file (dto, exception, ect.), controllers
## Step 6: update properties file
    spring.jpa.hibernate.ddl-auto=validate
## Step 7: run the project
