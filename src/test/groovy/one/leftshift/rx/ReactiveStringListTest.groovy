package one.leftshift.rx

import spock.lang.Specification

/**
 * @author benjamin.krenn@leftshift.one - 9/4/18.
 * @since 1.0.0
 */
class ReactiveStringListTest extends Specification {


    void "showcase"() {
        expect:
            ReactiveStringList classUnderTest = new ReactiveStringList()
            classUnderTest.
                    observable()
                    .subscribe({ next -> println("subscriber-1: $next") })


            classUnderTest
                    .observable()
                    .map({next -> next.toUpperCase()})
                    .subscribe({ next -> println("subscriber-2: $next") })

            classUnderTest.add("first")
            Thread.sleep(1000)
            classUnderTest.add("second")
            Thread.sleep(1000)
            classUnderTest.add("third")
            Thread.sleep(1000)
    }

}
