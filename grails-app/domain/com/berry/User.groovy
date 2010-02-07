package com.berry

class User {

    static hasMany = [nerds:Nerd]

    String email
    String password
    String name
    String bio
    Date dateCreated

    static constraints = {
        email(blank:false, email:true, unique:true)
        password(size:6..8)
        name(blank:false)
        bio(nullable:true, maxSize:1000)
    }
}
