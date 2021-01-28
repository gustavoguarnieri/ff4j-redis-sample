# ff4j-redis-sample

This Kotlin project is a sample of the ff4j framework with console authentication and redis database, working with feature flags, for more details visit: https://ff4j.github.io/

## Quick Start

1 - Run docker-compose up and will start the redis database

A Compose file looks like this:

```python
version: "3.9"

services:
  redis:
    container_name: redis
    image: redis
    ports:
      - "6379:6379"
    volumes:
      - db-volume:/var/lib/redis
volumes:
  db-volume:
```

2 - Start de project

3 - Access the console http://localhost:8080/ff4j-web-console and inform the user and password in the application.yml file, now you can enable or disable the features.
