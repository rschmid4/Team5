# Pac-Man Remastered
Contributors: Eric Chu, Aditi Sekar, Hank Wu, Noah Sandler


[TODO: Add an image of your code playing PacMan]


[TODO: A section on how to run the code from the command line
  - include a code block
]



## Individual Contributions

### Eric Chu 

#### Pacman-is_ghost_in_range()
blah blah blah blah blah 

#### Map-attack()
This method checks if the pacman is in range of the ghost. If it is, the ghost will "attack" the pacman by replacing it's location with Pacman's current location
& the gameOver variable will be set to true. 

#### Ghost-move()
blah blah blah blah blah 

#### testGhostInRange()
blah blah blah blah blah 

#### testMapAttack()
blah blah blah blah blah 

#### testGhostMove()
blah blah blah blah blah 




### Hank Wu

### Pacman consume()
This function check to see if the location of current pacman object contains cookies. If a any cookie contains in the current spot, then a cookie component is returned, null otherwise.

### Ghost attack()
Ghost attack checks if any pacman is in range. If is_pacman_in_range() function return true, then the attack function in map class will be called and true will be returned here.

### Map eatCookie()
The eatCookies function is responsible for updating all properties of map object such as locations, components, field. At the end, it returns cookie component, null otherwise.
