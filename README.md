# Pac-Man Remastered
Contributors: Eric Chu, Aditi Sekar, Hank Wu, Noah Sandler


[TODO: Add an image of your code playing PacMan]


[TODO: A section on how to run the code from the command line
  - include a code block
]



## Individual Contributions

### Eric Chu



#### `Pacman-is_ghost_in_range()`
blah blah blah

#### `Map-attack()`
This method checks if the pacman is in range of the ghost. If it is, the ghost will "attack" the pacman by replacing it's location with Pacman's current location
& the gameOver variable will be set to true.

#### `Ghost-move()`
blah blah blah blah blah

#### `testGhostInRange()`
blah blah blah blah blah

#### `testMapAttack()`
blah blah blah blah blah

#### `testGhostMove()`
blah blah blah blah blah



### Aditi Sekar

### `Pacman move()`
This method checks to find the possible locations the Pacman can move from its current location. If the Pacman can move to a valid location the method returns true, else it returns false.

### `Ghost is_pacman_in_range()`
This method checks to see if the Pacman is within attack range of a ghost. If the Pacman is one location to the right, left, up, or down of the ghost's current location it returns true, else it returns false.

### `Map move()`
This method takes a name, location, and type. It then tries to put it in the designated location. If the function is able to put the object in the specific location then it returns true, else false.

### `testPacmanMove()`
This test checks to see if the Pacman moves when there is a valid location available for it to move and then returns the respective boolean. 

### `testGhostIs_Pacman_In_Range()`
This test chekcs to see if the is_pacman_in_range returns the correct boolean based on if the pacman is within attack range of a ghost or not. 

### `testMapMove()`
This test checks to see if an object the parameter takes in is placed at the specific location asked and returns the respective boolean accordingly. 


### Hank Wu

### `Pacman consume()`
This function check to see if the location of current pacman object contains cookies. If a any cookie contains in the current spot, then a cookie component is returned, null otherwise.

### `Ghost attack()`
Ghost attack checks if any pacman is in range. If is_pacman_in_range() function return true, then the attack function in map class will be called and true will be returned here.

### `Map eatCookie()`
The eatCookies function is responsible for updating all properties of map object such as locations, components, field. At the end, it returns cookie component, null otherwise.


### Noah Sandler

### `Pacman.get_valid_moves()`
Determine where Pacman is able to move next. If the locations in front of, behind, to the left, or to the right of pacman contain a wall or a ghost, the location is considered invalid. Returns an ArrayList of Locations.

### `testPacman.get_valid_moves()`
This test focuses on seeing if the correct locations that the Pacman can move to are returned. 

### `Ghost.get_valid_moves()`
Determine where a ghost is able to move next. If the locations in front of, behind, to the left, or to the right of pacman contain a wall, the location is considered invalid. More than one ghost can exist in a single location. Returns an ArrayList of Locations.

### `testGhost.get_valid_moves()`


### `Map.getLoc()`
Determine what Types are at the parameter location. Returns a HashSet of Map.Type.
