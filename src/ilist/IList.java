package ilist;

/**
 * Interface for immutable lists using the "composite pattern".
 * We include high-order methods.
 * We will use A,B,C for type variables.
 */

public interface IList<A> {
  boolean isEmpty();           // Is the list empty?
  int     size();              // Returns the number of elements of the list.
  IList<A> reverse();          // Returns a reversed copy of the list.
  IList<A> append(IList<A> l); // Returns a new list with the list l appended.
  IList<A> append(A a);        // Returns a new list with the element a appended.
  boolean has(A a);            // Is the value a an element of the list?
  // Higher-order methods:
  IList<A> filter(Predicate<A> p);     // Gets the sublist of elements satisfying the predicate.
  <B> IList<B> map(Function<A, B> f);   // Applies a function to each element of the list.
  <B> B fold(Function2<A, B, B> f, B b); // Like in Ocaml, Haskell, and any functional laguage.
  boolean all(Predicate<A> p);         // Do all elements of the list satisfy the predicate p?
  boolean some(Predicate<A> p);        // Does some element of the list satisfy the predicate p?
  void forEach(Action<A> a);           // Applies an action (like printing) to each element of the list.
  // Unsafe operations:
  A head();                  // Gets the head of a non-empty list.
  IList<A> tail();           // Gets the tail of a non-empty list.
                                    // Both throw an exception for the empty list.
  // Safe:
                                    <B> B cases(B b, Function2<A, IList<A>, B> f); // Performs case analysis empty/non-empty.
} 

// The comments in the above interface are *intentions*.  The compiler
// doesn't check that these intentions are fulfilled in an
// implementation of this interface.  This is something the programmer
// (who cares to read the comments providing a specification of what
// is intended) has to make sure are fulfilled.  Checking that an
// implementation satisfies the intended specification is called
// "program verification".  In some languages (such as Agda), the
// specifications can be written in such a way that the compiler can
// actually check whether they are fulfilled. You will see something
// of this in the modules (Advanced) Functional Programming.

/*

 We have two implementations of the IList interface:

    (1) The class Nil.
    (2) The class Cons.

 There is only one object of type NIL, the empty list.

 An object of type Cons<A> has a head, of type A, and a tail, which is
 a (reference to an) IList<A>.

 A list [1,2,3] is written (rather verbosely) as

 new Cons<Integer>(1,new Cons<Integer>(2,new Cons<Integer>(3,new Nil<Integer>())));

 For the sake of brevity, the toString method produces the string
 "Cons(1,Cons(2,Cons(3,Nil)))" for this list (in Ocaml-like syntax).

 This is an instance of the "composite pattern", because we have one
 interface for lists, but two class implementations, one for each case
 Nil and Cons. Any list is built by combining Nil and Cons as above.

 We shall see more examples soon, including trees and arithmetic expressions. 

 Look at SampleUsage.java and run it to see what it outputs.

 */
