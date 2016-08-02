import spock.lang.Specification

class RtriangleProviderTest extends Specification {

    def "the triangle is NOT right"() {

        setup:
        def triangle = new RtriangleProvider()
        def dot1 = [triangle.apexX1, triangle.apexY1]
        def dot2 = [triangle.apexX2, triangle.apexY2]
        def dot3 = [triangle.apexX3, triangle.apexY3]
        def sidesInPow2 = [getLengthByDotsInPow2(dot1, dot2), getLengthByDotsInPow2(dot1, dot3), getLengthByDotsInPow2(dot2, dot3)]
        def hypotenuseInPow2 = sidesInPow2.max()
        def cathetusesInPow2 = sidesInPow2 - [hypotenuseInPow2]

        expect: "the triangle is NOT a dot or a line (in case of degeneracy)"
        dot1 != dot2
        dot1 != dot3
        dot2 != dot3

        and: "the triangle is NOT isosceles"
        sidesInPow2.size() == sidesInPow2.unique().size()

        and: "c^2 = a^2 + b^2 (with considering of Double mantissa)"
        hypotenuseInPow2 == cathetusesInPow2?.get(0) + cathetusesInPow2?.get(1)

    }

    private static double getLengthByDotsInPow2(begin, end) {

        return (end?.first() - begin?.first())**2 + (end?.last() - begin?.last())**2 as Double

    }

}
