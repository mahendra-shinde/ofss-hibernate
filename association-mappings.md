# Association Mappings

### Association types:

Direction:  
    _Unidirectional_ Entity "A" can access Entity "B", but "B" cant access "A"
	
    _Bi-Directional_ Both Entities have references to each other.

Bidirectional:
customer.getLoginCredentails() 
&
loginCredentials.getCustomer()

## Benefits

1.  Accessing related entities without additional queries.
2.  Enforce Cascading effects:
    PERSIST:        Create the second entity object along with primary.
    MERGE:          Update the second entity object along with primary.
    REFRESH:        Reload second entity object along with primary.
    DELETE:         Delete second entity object along with primary.
    ALL:            All of the above


## Disadvantages

1.  Loads secondary along with primary, even when not required!
2.  Performs CASCADING
3.  Additional performance overhead (SELECT results in JOIN, Multiple Updates and deletes!)

## Annotations used for Association Mappings

Annotation | Description | Example
-----------|-------------|----------
@OneToOne  | Associate One to one association between TWO entities | Customer & LoginCredentials
@ManyToOne | Associate Many objects of THIS entity with Single object of Target entity | Many accounts to One customer
@OneToMany | Reverse side of @ManyToOne, It always exists as Bi-Directional | One Customer can have many accounts
@ManyToMany | Multiple records of THIS entity refers to MUTLIPLE records of Target entity.It's achieved by creating an addition cross-referencing table | One Course can have many students but each student can enroll multiple courses.

## Hibernate uses 'Fetch Mode'

1.  Default 
        Depending on TYPE of mapping, it could be either Eager or Lazy.
        OneToOne:   Eager
        ManyToOne:  Eager
        OneToMany:  Lazy
        ManyToMany: Lazy

2.  Eager
        fetch SECOND entity immediately.

3.  Lazy
        fetch SECOND entity only when code is trying to access it.

### Lazy mode on One To One

```java
@OneToOne(fetch=FetchType.LAZY)
@JoinColumn(name="cust_id")
private LoginCredential credentials;
```

### Lazy mode on One To Many
```java
@ManyToOne(fetch=FetchType.LAZY)
private Customer customer;
```

### Eager mode on One to Many
```java
	
@OneToMany(mappedBy="customer",fetch=FetchType.EAGER)
private List<Account> accounts;
```

