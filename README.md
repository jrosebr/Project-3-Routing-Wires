1. Overview of the algorithm

The 'findPaths' method first takes in a 'Board' and a list of 'Endpoints' representing the endpoints that need to be connected.
It initializes an empty list of wires ('paths') and a HashMap 'parents' to store parent-child relationships for 
path reconstruction.
It then calls the 'solve' method to find the paths for each pair of endpoints and adds them to the 'paths' list.

The 'BFS' method performs a breadth-first search (BFS) from the start point to the end point.
It uses a queue ('Q') to explore adjacent coordinates starting from the start point.
It marks visited coordinates, checks for obstacles, and updates parent-child relationships.
If it finds the end point, it returns 'true'.

The 'createWireFomPath' method creates a wire path based on the parent-child relationships obtained from BFS.
It calls the 'BFS' method to find the path from the start to the end point.
If a path is found, it constructs a wire ('path') using the parent-child relationships and places it on the board.
If no path is found, it returns 'null'.

The 'solve' method recursively finds paths for each pair of endpoints. 
It checks if the list of endpoints is empty. If so, it returns an empty list of wires.
It iterates through each endpoint in the list and attempts to create a wire path using 'createWireFromPath'.
If a path is successfully created, it removes that endpoint from the list of viable endpoints and recursively calls 'solve'
with the updated list.
If no path can be created for an endpoint, it removes the wire from the board and continues to the next endpoint.
If a solution is found, it returns the list of wires.

Overall, this algorithm implements a backtracking breadth-first search system to find paths for connecting enpoints on a computer chip.



2. One or more examples of applying your algorithm to interesting boards

Example 1: Simple Board

Height: 5
Width: 5
Obstacles: None
Endpoints: [(0, 0) to (4, 4)]

The possible outputted paths would be:
Path: (0, 0) (1, 0) (2, 0) (3, 0) (4, 0) (4, 1) (4, 2) (4, 3) (4, 4)
OR
Path: (0, 0) (0, 1) (0, 2) (0, 3) (0, 4) (1, 4) (2, 4) (3, 4) (4, 4)

In other words, the algorithm would successfully connect the start and end corners without any obstacles.


Example 2: Board with Obstacles
Height: 6
Width: 8
Obstacles: [(1, 2) to (3, 5)]
Endpoints: [(0, 0) to (5, 7), (2, 1) to (4, 6)]

The outputted paths would be:
Path: (0, 0) (1, 0) (2, 0) (2, 1) (2, 2) (2, 3) (3, 3) (4, 3) (5, 3) (5, 4) (5, 5) (5, 6) (5, 7)
Path: (2, 1) (2, 2) (2, 3) (3, 3) (4, 3) (5, 3) (5, 4) (5, 5) (5, 6) (5, 7) (4, 6)

In other words, the algorithm would successfully connect the start and end points while avoiding the obstacle.



3. Evaluation of your algorithm with respect to finding and minimizing wire layouts

This algorithm is designed to effectively find paths between pairs of endpoints by using Breadth-First Search.
It traverses through neighboring coordinates while avoiding obstacles and already occupied coordinates, ensuring every path is valid.

As for minimizing wire layouts, the algorithm prioritizes the shortest paths between endpoints. It also recursively explores
all possible paths for each pair of endpoints, backtracking when necessary. By design, the algorithm is supposed to consider
all possible paths and select the shortest ones. So everytime the algorithm should inherently minimize the total wire length
required to connect all endpoints.


4. Evaluation of the time complexity and wall-clock time of your algorithm

The main factor affecting the time complexity is the Breadth-First Search (BFS) algorithm used to find paths between endpoints.
On average, BFS has a time complexity of O(V + E), where V is the number of vertices (grid cells)
and E is the number of edges (adjacent cells).
In the Worst Case, BFS has a time complexity of O(P * N * M), where P is the number of endpoints,
N is the number of rows, and M is the number of columns.

Since the grid size and number of obstacles remain constant, the dominant factor is the number of pairs of endpoints.

The wall-clock time will vary based on factors such as the size of the grid, the density of obstacles, and the number of endpoints.
For small to medium-sized grids with a moderate number of endpoints, the algorithm should execute relatively quickly.
However, for larger grids or layouts with many obstacles and endpoints, the execution time may be significantly longer.