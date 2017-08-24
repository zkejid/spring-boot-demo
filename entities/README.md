# Entity model

## TextEntity

First and basic feature of project is storing raw data. Raw data can be
represented in textual form. `TextEntity` provides ability to contain,
store and transfer data. It consists of following fields:
1. `title` - Field of `String` type. It contains short description of data
or title for stored text. It can be empty string, but can not be `null`
value. String length should be less or equal 160 symbols in the meaning
of `javax.validation.constraints.Size`.
[160 is chosen because it is two lines of traditional length](https://softwareengineering.stackexchange.com/questions/148677/why-is-80-characters-the-standard-limit-for-code-width)
2. `content` - Field of `String` type. It contains textual data of
unspecified format. It can be empty string, but can not be `null` value.
String length theoretically unlimited, but real storage can produce
an exception if theory would clash with practice.
3. `creationDate` - Field of `java.util.Date` type. It contains
date and time of entity creation. Field has more _system_ than
_business_ value, it serves for ordering from historical point of view.
The value of this field shouldn't be set by user. Field should not
be `null`.
4. `id` - Field of `Long` type. It is pure _system_ field, providing
the ability to distinguish one entity object from another. Equal `id`s
mean equal entity objects. There shouldn't be two entities with equal
`id`s in the system.