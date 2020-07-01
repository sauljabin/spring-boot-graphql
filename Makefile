it:
	./gradlew clean integrationTest

test:
	./gradlew clean test

run:
	./gradlew clean bootRun

h2-console:
	xdg-open http://localhost:8080/h2-console

graphiql:
	xdg-open http://localhost:8080/graphiql

voyager:
	xdg-open http://localhost:8080/voyager