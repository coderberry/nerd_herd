package com.berry

import grails.test.*

class HerdIntegrationTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testCreateHerd() {
        def herd = new Herd()
        assertFalse herd.validate()

        herd.question = "Why is the sky blue?"
        herd.askedByEmail = "me@you.com"
        assert herd.validate()
        assertNotNull herd.save()
        assertNotNull herd.id

        println "New Herd ID: ${herd.id}"

        def foundHerd = Herd.findById(herd.id)
        assertEquals "Why is the sky blue?", herd.question
    }
}
