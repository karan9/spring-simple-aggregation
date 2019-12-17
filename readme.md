# Spring simple aggregation

Application is running on PORT 8080
and Database is `demo`


To Setup change the mongo db config in 

```
src/resources/application.properties
```

and

Make a Simple Post Call to insert data into db

```
method: POST
path: localhost:8080/

body

{
	"title": "Java Developer",
	"location": "Noida"
}

```

and run

```
method: GET
path: http://localhost:8080/aggr
```

