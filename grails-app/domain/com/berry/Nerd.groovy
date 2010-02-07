package com.berry

class Nerd {

    static belongsTo = [Herd, User]

    Herd herd
    User user
    String answer

    static constraints = {
        answer(blank:false, maxSize:1000)
    }
}
