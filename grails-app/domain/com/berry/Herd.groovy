package com.berry

class Herd {

    static hasMany = [nerds:Nerd]

    String question
    String askedByEmail

    static constraints = {
        question(blank:false, nullable:false, maxSize:1000)
        askedByEmail(blank:false, nullable:false, email:true)
    }
}
