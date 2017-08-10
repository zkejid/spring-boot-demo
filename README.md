# Content
- consumable-core artifact
- consumable-demo artifact.
- user-demo artifact.

## consumable-core artifact

Artifact contains shared entities. Each Spring Boot application  artifact
contains maven plugin, which produces über-jar file. We shouldn't
use such jar file as dependency from one module to another. Instead
of this we use share artifacts, which are plain jar artifacts.

## consumable-demo artifact

Artifact provides self-contained application "Employee CRUD".
Application manages lifecycle of Employee entities with following
endpoints:

1. Index page on "/" path. It shows description of application.
2. Search page on "/employee/byname" path. It shows list of all
employees matching given name. Result is returned as JSON. Arguments:
    - name - String value. Resulting entities wolud have attribute
    "name" with given value.
3. Create page on "/employee/create" path. It allows creation of
employee instances.
    - name - String value.
    - grade - String value.
    - hiredDate - Date value.
    - firedDate - Date value.
4. List page on "/employee/list" path.

## user-demo artifact

Artifact provides self-contained application "Employee statistics".
Application produces textual reports, based on "Employee CRUD" service.
Folowing endpoints available:

1. Index page on "/" path. It shows textual description of application.
2. Statistics page on "/statistics" path. It shows small textual
report. Now it consists of total count of employees.