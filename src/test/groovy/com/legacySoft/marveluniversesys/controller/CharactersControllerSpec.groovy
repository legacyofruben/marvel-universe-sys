package com.legacySoft.marveluniversesys.controller

import spock.lang.Specification

class CharactersControllerSpec extends Specification{

    CharactersController charactersController = new CharactersController();

    def 'should return all the characters from Marvel API'(){
        given:

        when:
        def response = charactersController.getAllCharacters()

        then:'validate'
        response != null
        response != ""
    }
}
