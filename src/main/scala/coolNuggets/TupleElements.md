# Access the elements of a tuple

You may be wondering why you can’t access the elements of a tuple like the elements of a list.
 
eg: with “pair(0)”. 

The reason:
    - list’s apply method always returns the same type,
      but each element of a tuple may be a different type
       
_1 can have one result type, _2 another, and so on.