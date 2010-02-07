package com.berry

import grails.test.*

class UserIntegrationTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testCreateUser() {
        def user = new User()
        assertFalse user.validate()

        user.email = "joe@blow.com"
        user.password = "password"
        user.name = "Joe Blow"

        assert user.validate() // Should validate
        assertNotNull user.save()
        assertNotNull user.id

        def foundUser = User.get(user.id)
        assertEquals 'joe@blow.com', foundUser.email
    }

    void testBadEmailAddresses() {
        def user = new User()

        // Make sure a bad email does not pass validation
        def badEmails = ["joeblow.com", "joe@blow", "joe@.com"]
        badEmails.each { email ->
            user.email = email
            assertFalse user.validate()
            assertNotNull user.errors.getFieldError("email")
        }

        // Make sure a good email passes validation
        user.email = "joe@blow.com"
        assertFalse user.validate()
        assertNull user.errors.getFieldError("email")
    }
}
