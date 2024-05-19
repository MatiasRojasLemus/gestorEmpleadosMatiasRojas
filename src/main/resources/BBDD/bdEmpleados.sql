DROP DATABASE bdEmpleados;
CREATE DATABASE IF NOT EXISTS bdEmpleados;
USE bdEmpleados;

CREATE TABLE IF NOT EXISTS EMPLEADOS(
    ID INT PRIMARY KEY AUTO_INCREMENT,
    NOMBRE VARCHAR(100),
    PUESTO ENUM("Scada Manager","Sales Manager","Product Owner","Product Manager","Analyst Programmer","Junior Programmer"),
    SALARIO int,
    FECHA DATE
    );