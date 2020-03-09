# Why not append to lists?

Class `List` does offer an "**app**end"
`:+`
but this operation is rarely used.

Because
    - the time it takes to append to the list grows linearly
      with the size of the list
    - whereas prepending with `::` takes constant time
    
    