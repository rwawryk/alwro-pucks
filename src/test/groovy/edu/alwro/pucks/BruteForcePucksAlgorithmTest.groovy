package edu.alwro.pucks

import spock.lang.Specification
import spock.lang.Unroll

class BruteForcePucksAlgorithmTest extends Specification{

    // Test data http://main.edu.pl/pl/user.phtml?op=zasoby

    @Unroll
    def "BruteForcePucksAlgorithm for custom input #r"() {

        expect:
        expectedResult == BruteForcePucksAlgorithm.run(r as int[], k as int[])

        where:
        r                      | k                 || expectedResult
        [1]                    | [1]               || 0
        [1]                    | [2]               || -1
        [5, 6, 4, 3, 6, 2, 3]  | [3, 2, 5]         || 1
        [5, 4, 3, 2, 1]        | [1, 2, 3, 4, 5]   || 0
    }

    @Unroll
    def "BruteForcePucksAlgorithm for small input #input"() {
        given: "input data"
        String inputPath = this.getClass().getResource(input).path

        when: "naive algorithm is executed"
        int result = BruteForcePucksAlgorithm.run(inputPath)

        then: "result should match expected value"
        int expectedResult = this.getClass().getResource(output).text.toInteger()
        result == expectedResult - 1

        where:
        input               || output
        '/pucks/kra0.in'    ||	'/pucks/kra0.out'
        '/pucks/kra1a.in'   ||	'/pucks/kra1a.out'
        '/pucks/kra1b.in'  	||	'/pucks/kra1b.out'
        '/pucks/kra1ocen.in'||  '/pucks/kra1ocen.out'
        '/pucks/kra2.in'	||	'/pucks/kra2.out'
        '/pucks/kra2ocen.in'||	'/pucks/kra2ocen.out'
        '/pucks/kra3a.in'	||	'/pucks/kra3a.out'
        '/pucks/kra3b.in'	||	'/pucks/kra3b.out'
        '/pucks/kra3ocen.in'||	'/pucks/kra3ocen.out'
        '/pucks/kra4.in'	||	'/pucks/kra4.out'
        '/pucks/kra4ocen.in'||	'/pucks/kra4ocen.out'
        '/pucks/kra5.in'	||	'/pucks/kra5.out'
    }

    @Unroll
    def "BruteForcePucksAlgorithm for big input #input"() {
        given: "input data"
        String inputPath = this.getClass().getResource(input).path

        when: "naive algorithm is executed"
        int result = BruteForcePucksAlgorithm.run(inputPath)

        then: "result should match expected value"
        int expectedResult = this.getClass().getResource(output).text.toInteger()
        result == expectedResult - 1

        where:
        input               || output
        '/pucks/kra6.in'	||	'/pucks/kra6.out'
        '/pucks/kra7.in'	||	'/pucks/kra7.out'
        '/pucks/kra8.in'	||	'/pucks/kra8.out'
        '/pucks/kra9.in'	||	'/pucks/kra9.out'
        '/pucks/kra10.in'	||	'/pucks/kra10.out'
        '/pucks/kra11.in'	||	'/pucks/kra11.out'
    }
}