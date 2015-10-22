package appforo

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Regular)
class RegularSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test nullable"() {
        when:
        def regular = new Regular()
        then:
        assertFalse regular.validate()
    }
    void "test nullable postViews"() {
        when:
        def regular = new Regular(strikesNumber: 2, starsNumber: 2)
        then:
        assertFalse regular.validate()
    }

    void "test nullable strikesNumber"() {
        when:
        def regular = new Regular(postViews: 2, starsNumber: 2)
        then:
        assertFalse regular.validate()
    }

    void "test nullable starsNumber"() {
        when:
        def regular = new Regular(strikesNumber: 2, postViews: 2)
        then:
        assertFalse regular.validate()
    }

    void "test postViews range"() {
        when:
        def regular = new Regular()
        then:
        assertFalse regular.validate(postViews: -1, strikesNumber: 2, starsNumber: 2)
    }

    void "test strikeNumber range"() {
        when:
        def regular = new Regular()
        then:
        assertFalse regular.validate(postViews: 2, strikesNumber: 4, starsNumber: 2)
    }

    void "test starsNumber range"() {
        when:
        def regular = new Regular()
        then:
        assertFalse regular.validate(postViews: 2, strikesNumber: 4, starsNumber: 7)
    }
}
