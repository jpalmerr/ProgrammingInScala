# Immutable object trade-offs


Immutable objects offer several advantages over mutable objects, and one potential disadvantage. 

##### Advantages:

- immutable objects are often easier to reason about than mutable ones
   because they do not have complex state spaces that change over time
   
- you can pass immutable objects around quite freely,
  whereas you may need to make defensive copies of mutable objects before passing them to other code.
  
- there is no way for two threads concurrently accessing an immutable to corrupt its state
  once it has been properly constructed, 
  because no thread can change the state of an immutable
  
- immutable objects make safe hash table keys.
    - If a mutable object is mutated after it is placed into a HashSet,
      for example, that object may not be found the next time you look into the HashSet.

##### Disadvantage

- immutable objects sometimes require that a large object graph be copied, whereas an update could
  be done in its place.
  
  In some cases this can be awkward to express and might also cause a performance bottleneck.

  As a result, it is not uncommon for libraries to provide mutable alternatives to immutable classes.