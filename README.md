Java code implementing several abstract data types and a few sorting algorithms.

After taking a Data Structures course, I felt that I would benefit from further practice/learning, so I essentially read through Frank Carrano's Data Structures and Abstractions with Java 3rd ed and reimplemented the data types he talks about, sometimes directly from his interfaces, other times from interfaces/base classes provided by the Java Collections framework or from interfaces I created myself.

This is a work in progress as I'm only two-thirds of the way through the book. Once I'm done with Carrano, there are plenty of other advanced data types I would like to look into and plan to explore more advanced texts at that time.

For this project, I took the opportunity to practice using the Maven tools integrated into Eclipse. This project depends on JUnit, Log4J and Apache Commons Collections (from which I only used their unit tests).

Many of the unit tests are my own, and my beginner status clearly shows, but for the MyList class (which extends AbstractList, but overrides *everything*, even methods AbstractList inherits), I extended the commons collection junit test and that *clearly* demonstrated the benefit of having rigorous and complete unit tests.

I spent many an hour getting all tests to come up green for that one, and I feel that my code is probably much better for it. Once I reach a point where I'm looking for something new to do with this, I'll reimplement some of the commons collections data types and leverage their excellent unit tests, all for the sake of practice and better understanding of how/why to use different ADTs.

