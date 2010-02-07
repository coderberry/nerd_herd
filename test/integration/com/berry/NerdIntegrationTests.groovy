package com.berry

import grails.test.*

class NerdIntegrationTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testCreateNerd() {
        // Generate Herd and User first
        def user = new User(
                email: "joe@blow.com",
                password: "password",
                name: "Joe Blow"
        ).save()

        def herd = new Herd(
                question: "Why is the sky blue?",
                askedByEmail: "me@you.com"
        ).save()

        assertNotNull user.id
        assertNotNull herd.id

        // Generate and test Nerd
        def nerd = new Nerd()
        assertFalse nerd.validate()

        nerd.herd = herd
        nerd.user = user
        nerd.answer = "Because if it was green you wouldn't know where to stop mowing the lawn."
        assert nerd.validate()
        assertNotNull nerd.save()
        assertNotNull nerd.id

        assertEquals nerd.herd, herd
        assertEquals nerd.user, user
        
    }
}
