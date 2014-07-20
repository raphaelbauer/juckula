Juckula - a minimal typesafe templating system for java
-------------------------------------------------------

That's a proof of concept of a minimal (Html) templating system. It's focused
on the Java side of things. You get a lot of great stuff for free (like
typesafety), but it's not so easy to write html, because you write
your html inside Java classes with a $("...") tag.

But it's interesting imho.

Apart from that the proof of concept already contains an integration
with ninja and its i18n facilities.

Big Pros:

 * You write Java files. No generate sources - immediate feedback when
   something is wrong
 * You can use Guice to inject stuff... big win.
 * Refactoring your templates is supersimple. You refactor Java templates.
 * Typesafe - if you change the signature of your templates your compiler complains.
 * Damn simple. The templating system is just a few lines of code.
 * Integration in other systems (like Ninja) is simple and straight forward.

Big Cons:

 * Your frontenders may hate it.
 * You have to use $("<html>...</html>") to render stuff... clunky and verbose.
 * You have to best use ' for html attributes... like so: $("<a href='...'>"... clunky
 * no html /js code completing inside your templates... (But you got java code completion for loops and so on...)

Stuff that works

 * Inheriting of parent templates
 * Escaping of html
 * Integration with Ninja
 * Rendering of i18n messages
 * rendering to Strings as well as OutputStream

Stuff that needs some improvement:

 * Maybe there is a good way to integrate pure text ("html") files into that approach where you do not need the stupid $("...")
 * How to automatically escape incoming Strings x(..) is now the default way.
 * What about performance?
 * Too many news possibly => maybe swith to Guice, but then again how can we
   make it "easy" to render stuff.