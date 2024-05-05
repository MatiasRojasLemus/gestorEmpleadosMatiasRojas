CREATE DATABASE IF NOT EXISTS bdEmpleados;
USE bdEmpleados;

CREATE TABLE IF NOT EXISTS Empleados(
	id INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100),
    Puesto VARCHAR(100),
    Salario int,
    Fecha DATE
);
