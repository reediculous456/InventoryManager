# InventoryManager

Design Document

Wes Reed, Matthew Saling, Daniel Cullen, and Christopher Elbe

## Introduction

Talk about what the app will do here...

## Storyboard

[Link to Storyboard]()

## Requirements

* [Requirement 1: Do a thing](docs/requirements/Requirement1.md)
* [Requirement 2: Do another thing](docs/requirements/Requirement2.md)
* [Requirement 3: Do yet another thing](docs/requirements/Requirement3.md)

## Class Diagram

![Class Diagram](docs/assets/uml.png)
[Download the Diagram File](docs/assets/uml.drawio) (open with [draw.io](https://draw.io))

### Class Diagram Description

[Link to Class Diagram Description](docs/uml-description.md)

## API JSON Schema

For our JSON API Schema we will have the ability to reach out via rest endpoint and get a list of items in inventory with who it's assigned to.
The JSON object will look like this:

```jsonc
{
  "unique_id": "string", // required
  "object_name": "string", // required
  "assigned_to": "string",
  "location": "string",
  "description": "string",
  "last_updated": "Date"
}
```

This will allow our users to be able to get data about the object, and search for objects containing specific information.

## Scrum Roles

* **Scrum Master, Product Owner, and Github Admin:** Wes Reed
* **UI Specialist:** Daniel Cullen
* **Business Logic and Persistence Expert:** Matthew Saling and Christopher Elbe

## Weekly Meetings

* [Standup Wednesday from 7 to 7:30](https://teams.microsoft.com/l/meetup-join/19%3ameeting_MmQ0Mzc0ZGQtZmVjMi00NGExLTlkNGYtOTc5OGFkOGUwMWRl%40thread.v2/0?context=%7b%22Tid%22%3a%22f5222e6c-5fc6-48eb-8f03-73db18203b63%22%2c%22Oid%22%3a%22e1b08e73-d2dd-449a-848e-db26cd974c04%22%7d)
