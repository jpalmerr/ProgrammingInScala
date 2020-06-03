- If the behavior will not be reused, then make it a concrete class.

   It is not reusable behavior after all.
   
- If it might be reused in multiple, unrelated classes, make it a trait

  Only traits can be mixed into different parts of the class hierarchy.

- If you plan to distribute it in compiled form,
  and you expect outside groups to write classes inheriting from it,
  you might lean towards using an abstract class.
  
  The issue is that when a trait gains or loses a member, any classes that inherit from it must be recompiled,
  even if they have not changed.
  If outside clients will only call into the behavior, instead of inheriting from it, then using a trait is fine. 
  
- If you still do not know, after considering the above, then start by making it as a trait.

  You can always change it later, and in general using a trait keeps more options open.