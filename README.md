# Social network project.

Is creating by Sylvester Stallone, Chewbacca and Aardvarky.

## Links
[Resources](https://drive.google.com/drive/folders/1MB7kTc6S8v_oU7GrIn9qBIVhq8pzi4Ga)

## Tools and etc.

IntelliJ IDEA :+1:
Java 8 i guess.. :trollface:
JavaFX :thumbsdown:
MySQL :muscle:
and maybe something more...

## Stupid way to store database config on hard disk.

1. Create txt file named "databaseconfig" in project directory. Location:
1. ![alt text](https://i.imgur.com/kd24ytK.png)
1. Configure your "databaseconfig" file like that:

```
databaseName: [your_database_name]
user : [database_username]
password: [database_user's_password]
```
## Hibernate

1. Create and add file named "hibernate.cfg.xml" in "resources" directory.
1. Configure file like that:

```xml
<?xml version = "1.0" encoding = "utf-8"?>
<!DOCTYPE hibernate-configuration SYSTEM
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>

        <property name = "hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
        <property name = "hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name = "hibernate.connection.url">jdbc:mysql://localhost:3306/[database_name]?useTimezone=true&amp;serverTimezone=UTC</property>
        <property name = "hibernate.connection.username">[your_username]</property>
        <property name = "hibernate.connection.password">[your_password]</property>

    </session-factory>
</hibernate-configuration>
```
3. Run application.

## Guava

[Guava Graph](https://github.com/google/guava/wiki/GraphsExplained)
