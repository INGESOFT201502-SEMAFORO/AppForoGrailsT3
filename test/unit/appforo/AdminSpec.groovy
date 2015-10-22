package appforo

import grails.test.GrailsUnitTestCase
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Admin)
class AdminSpec extends Specification {

    def setup() {
        mockForConstraintsTests(Admin)
    }

    def cleanup() {
    }

    void "test nullable"() {
        when:
        def admin = new Admin()
        then:
        assertFalse admin.validate()
    }

    void "test level nullable"() {
        when:
        def admin = new Admin(rating: 1)
        then:
        assertFalse admin.validate()
    }

    void "test rating nullable"() {
        when:
        def admin = new Admin(level: 1)
        then:
        assertFalse admin.validate()
    }

    void "test rating range"() {
        when:
        def admin = new Admin(level: 3, rating: 150.0)
        then:
        assertFalse admin.validate()
    }

    void "test level range"() {
        when:
        def admin = new Admin(level: 6, rating: 90.0)
        then:
        assertFalse admin.validate()
    }
}
