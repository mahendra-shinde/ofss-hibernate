# Entity / Persistent Object Lifecycle

> 'Entity' refers to Java class which is MAPPED to database table.

> An alternate name for 'Entity' is 'Persistent Class'

> Pre-requisites for an ENTITY class

1.  Must be PUBLIC and SHOULD be in separate package.
2.  Must have TWO annotations: @Entity & @Id
3.  Must have all properties with  `private` specifier
4.  Should have Getters and Setters for all properties
5.  Must have a `default constructor` (construction with NO Arguments)


## Lifecycle Phases

1.  Transient Phase

    The newly created Entity object which has no persistence-context (Not part of any hibernate session). not linked to any record in db.

    Any change to transient object, would NOT trigger update in database.

2.  Persistent Phase

    Object with persistence-context (Part of Hibernate session) and has a record linked to it. Any changes to `persisted object` while transaction is not yet completed, would TRIGGER an update on database.

    After session is closed, objects lose their persistence-context and there-for becomes `Detached`

3.  Detached Phase

    Object who lost their persistence-context, and no longer linked to db record.
    Any changes to these objects, would NOT trigger database update. 

    Calling UPDATE method would transition them into `persisted mode` again.

4.  Removed Phase

    Object who lost their persistence-context, due to record being deleted in database.
    Not linked anymore to a record. Changes in `deleted` phase would never trigger any update.
    