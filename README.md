# Flip a coin

## A simple game
- Developed with Java and and SpringBoot framework
- This was a graded project for my Java course.
- First developed a CLI version, then started to create this with HTTP methods and endpoints.

## How to play? 
Play by HTTPS methods, however all endpoints return something, but functions are not fully implemented to all of them, in some there is just print statements.

You can modify part with YOURNAMEHERE and YOUROPPONENT
CREATE TWO PLAYERS
- curl -X POST http://localhost:8080/coinflip/player?name=YOURNAMEHERE
- curl -X POST http://localhost:8080/coinflip/player?name=YOUROPPONENT

VIEW PLAYER INFO
- curl -X GET http://localhost:8080/coinflip/player?name=YOURNAMEHERE
- curl -X GET http://localhost:8080/coinflip/player?name=YOUROPPONENT

CREATE A GAME, CREATE BOTH PLAYERS FIRST
- curl -X POST http://localhost:8080/coinflip/game

MAKE A MOVE, 1 = HEADS, 2 = TAILS
- curl -X PUT "http://localhost:8080/coinflip/game/move?name=YOURNAMEHERE&guess=1"
- curl -X PUT "http://localhost:8080/coinflip/game/move?name=YOUROPPONENT&guess=2"
