CREATE DATABASE fleetmanager;

use fleetmanager

CREATE TABLE Car (
  make VARCHAR(15),
  model VARCHAR(10),
  registration VARCHAR(10) PRIMARY KEY,
  year INT(4),
  inspection DATE,
  size INT(5),
  power INT(4)
);