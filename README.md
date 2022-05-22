# Movie service JAZ

## Odpalanie MySQL z linii polecen (wymagany docker)

```bash
docker run -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password mysql
```

następnie w bazie trzeba utworzyć schema o nazwie `db` (np. za pomocą workbencha)