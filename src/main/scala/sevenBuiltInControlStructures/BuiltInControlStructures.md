Scala has only a handful of built-in control structures.

The only control structures are:
`if` `while` `for` `try` `match` 
and function calls. 


The reason Scala has so few is that it has included function literals since its inception.
Instead of accumulating one higher-level control structure after another in the base syntax,
Scala accumulates them in libraries.

One thing you will notice is that almost all of Scala’s control structures result in some value.

This is the approach taken by functional languages
- programs are viewed as computing a value
- thus the components of a program should also compute values