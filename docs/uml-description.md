# Class Diagram Description

## Overview

The application code is split in 3 packages - UI, DTO and DAO.

## DTO

### item

The item class is used to create each item and it's attributes, which are: name, description, location, assigned_to, and stock_status.

### user

The user class will be used as a lookup for the assigned_to attribute of the item class.

### item_statuses

The item_statuses class will be used as a lookup for the stock_status attribute of the item class.

## DAO

### AppDatabase

The AppDatabase class will be used to connect to a database called InventoryDB to pull in data for each item.

## UI

### ItemActivity and ViewModel

The ItemActivity and ViewModel classes will be used together to display data to the user of each item.
