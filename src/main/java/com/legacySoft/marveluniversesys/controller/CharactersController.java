package com.legacySoft.marveluniversesys.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import static com.legacySoft.marveluniversesys.controller.CharactersController.MARVEL_API_BASE_URL;

@Tag(name = CharactersController.PATH, description = "Movies Rest API operations")
@Slf4j
@RestController
@RequestMapping(value = CharactersController.PATH)
public class CharactersController {
    public static final String PATH = "/marvel-universe-sys/api/v1/";
    public static final String MARVEL_API_BASE_URL = "https://gateway.marvel.com:443/v1/public/";
    private static final String API_KEY = "d8c079c1f043f80074ed6e9bd2d7b2cf";
    private static final String HASH = "015d8d0e2fdafe88090d71bb92bf8912";

    @Operation(summary = "List all of characters.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            }
    )
    @GetMapping("characters")
    public String getAllCharacters(){
        String url = MARVEL_API_BASE_URL + "characters?ts=1" +"&apikey=" + API_KEY + "&hash=" + HASH;

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        return response;
    }

    @GetMapping("characters/{characterId}")
    public String getCharacter(@PathVariable Long characterId){
        String url = MARVEL_API_BASE_URL + "characters/"+ characterId.toString() +"?ts=1" +"&apikey=" + API_KEY + "&hash=" + HASH;

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        return response;
    }
}
