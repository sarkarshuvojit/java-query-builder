Vision for how the api should eventually look.

```java
class Vision {
    public void main(){ 
        int customerId = 5;
        Query query = new QueryBuilder<Customer>(Customer.class)
            .select({'name', 'email', 'userId'})
            .where('customer_id', 5);
        List<Customer> results = query.get().collect(Collections.List);        
    }
}
```