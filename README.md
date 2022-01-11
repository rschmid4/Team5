# Pac-Man Remastered
Contributors: Eric Chu, Aditi Sekar, Hank Wu, Noah Sandler

How to run the code: 

0) cd Team5/Projects/P1
1) javac -cp "src/" src/*.java
2) java -cp "src/" StartMenu

<img width="576" alt="Screen Shot 2022-01-11 at 12 09 00 PM" src="https://user-images.githubusercontent.com/75747122/148988966-df4359f3-fa4b-4874-8fbd-2cb852ce383a.png">



## Individual Contributions

### Eric Chu

#### `Pacman-is_ghost_in_range()`
This method checks the NESW coordinates by checking a shift in location to determine if a ghost resides nearby. 

#### `Map-attack()`
This method checks if the pacman is in range of a specific ghost identified by the name pass through as a parameter. If it is, the ghost will "attack" the pacman by replacing it's location with Pacman's current location & the gameOver variable will be set to true.

#### `Ghost-move()`
Using ghost's get_valid_moves, we use the Math.random() utility to randomly select one possible move to make.

#### `testGhostInRange()`
This tests creates random ghosts & PacMan spawns right next to each other to determine the quality of Pacman's is_ghost_in_range()

#### `testMapAttack()`
This tests places ghosts and a PacMan adjacent to each other & calls upon a specific ghost 'Caspar' to determine if 'Caspar' is in range to attack Pac-Man. It will return true if successful. 

#### `testGhostMove()`
This tests check if there is at least one valid move for the Ghost to make, given the enviroment & will return true if possible. 


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

### `testPacManConsume()`
This test checks to see if the method correctly returns a cookie contained in the current spot, if the location of the current pacman object doesn't contain cookies it tests to see if null is returned. This file contains two tests, testConsume() and testConsumeFail. The first test, testConsume(), first creates map that contains pacman and cookie component at the same location. This assertTrue should pass when consume() function return the same cookie component. The other test, testConsumeFail(), test the opposite logic that consume() function should return null when pacman and cookie are in different location.

### `testeatCookie()`
This test checks to see if all properties of map object are updated and then checks to see if the method returns cookie component if it is updated otherwise it returns null. This file also includes two test, testMapEatCookie() and testMapEatCookieFail(). A map including pacman and cookie components at the same location is created in testMapEatCookie(), and the assertTrue should pass because they should have the same cookie component. On the other hand, testMapEatCookieFail() should assertTrue because eatCookie() function should return null.

### `testGhostAttack()`
This test checks to see if the pacman is in range and then the map attack function is called if the pacman is in range and true is returned. This file contains both testAttack() and testAttackFail(). testAttack() creates a map that contains pacman and ghost components. The assertTrue should pass the test because the pacman is in the range of ghost. On the other hand, testAttackFail should assertFalse because the pacman isn't in the range of ghost.


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
