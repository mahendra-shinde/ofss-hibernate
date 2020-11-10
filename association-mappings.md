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

