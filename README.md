# demo-transaction test

## DB 선행작업필요.
```
$ docekr pull mysql
$ docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password --name yungiggs-mysql -v /Users/user/datadir:/var/lib/mysql mysql:latest
$ docker exec -it yungiggs-mysql bash 
$ mysql -u root -p
$ <password 입력>
$mysql> CREATE USER 'demo'@'%' IDENTIFIED BY 'password';
$mysql>  GRANT ALL PRIVILEGES ON *.* TO 'demo'@'%';
$mysql> flush privileges;
$mysql> quit
```