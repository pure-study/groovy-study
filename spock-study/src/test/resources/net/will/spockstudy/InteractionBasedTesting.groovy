package net.will.spockstudy

// http://spockframework.github.io/spock/docs/1.0/interaction_based_testing.html

// Cardinality:
1 * subscriber.receive("hello")      // exactly one call
0 * subscriber.receive("hello")      // zero calls
(1..3) * subscriber.receive("hello") // between one and three calls (inclusive)
(1.._) * subscriber.receive("hello") // at least one call
(_..3) * subscriber.receive("hello") // at most three calls
_ * subscriber.receive("hello")      // any number of calls, including zero

// Target Constraint:
1 * subscriber.receive("hello") // a call to 'subscriber'
1 * _.receive("hello")          // a call to any mock object

// Method Constraint:
1 * subscriber.receive("hello") // a method named 'receive'
1 * subscriber./r.*e/("hello")  // a method whose name matches the given regular expression
1 * subscriber.status // same as: 1 * subscriber.getStatus()
1 * subscriber.setStatus("ok") // NOT: 1 * subscriber.status = "ok"

// Argument Constraints:
1 * subscriber.receive("hello")     // an argument that is equal to the String "hello"
1 * subscriber.receive(!"hello")    // an argument that is unequal to the String "hello"
1 * subscriber.receive()            // the empty argument list (would never match in our example)
1 * subscriber.receive(_)           // any single argument (including null)
1 * subscriber.receive(*_)          // any argument list (including the empty argument list)
1 * subscriber.receive(!null)       // any non-null argument
1 * subscriber.receive(_ as String) // any non-null argument that is-a String
1 * subscriber.receive({ it.size() > 3 }) // an argument that satisfies the given predicate
1 * process.invoke("ls", "-a", _, !null, { ["abcdefghiklmnopqrstuwx1"].contains(it) })

// Matching Any Method Call:
1 * subscriber._(*_)     // any method on subscriber, with any argument list
1 * subscriber._         // shortcut for and preferred over the above
1 * _._                  // any method call on any mock object
1 * _                    // shortcut for and preferred over the above

// Strict Mocking:
when:
publisher.publish("hello")

then:
1 * subscriber.receive("hello") // demand one 'receive' call on 'subscriber'
_ * auditing._                  // allow any interaction with 'auditing'
0 * _                           // don't allow any other interaction

// Stubbing
// Returning Fixed Values:
subscriber.receive(_) >> "ok"

// Returning Sequences of Values:
// This will return "ok" for the first invocation, "error" for the second and third invocation, 
// and "ok" for all remaining invocations.
subscriber.receive(_) >>> ["ok", "error", "error", "ok"]

// Computing Return Values:
// the closure delegates to an instance of org.spockframework.mock.IMockInvocation.
subscriber.receive(_) >> { args -> args[0].size() > 3 ? "ok" : "fail" }
subscriber.receive(_) >> { String message -> message.size() > 3 ? "ok" : "fail" }

subscriber.receive(_) >> { throw new InternalError("ouch") }

// This will return "ok", "fail", "ok" for the first three invocations, throw InternalError for 
// the fourth invocations, and return ok for any further invocation.
subscriber.receive(_) >>> ["ok", "fail", "ok"] >> { throw new InternalError() } >> "ok"

// Combining Mocking and Stubbing:
// NOTE: Mocking and stubbing of the same method call has to happen in the same interaction.
1 * subscriber.receive("message1") >> "ok"

// Spies
// Sometimes, it is desirable to both execute some code and delegate to the real method.
subscriber.receive(_) >> { String message -> callRealMethod(); message.size() > 3 ? "ok" : "fail" }
