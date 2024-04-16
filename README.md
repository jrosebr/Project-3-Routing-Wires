1. Overview of the algorithm

First, will loop through each of the goals provided to it.
Then, it initializes the necessary data structures for BFS ('visited', 'parent').
Then, the BFS method is called, and if a path to the goal is found then it is added to the list of paths.

Then, the BFS method performs Breadth-First Search, starting from the 'start' coordinate of each pair of endpoints.
It uses a Queue to manage traversal and a HashSet to keep track of visited coordinates.
It then updates a HashMap named parent to maintain parent-child relationships between coordinates.
Then, stops BFS when the end coordinate is reached or all possible paths are explored.
In the case of a Path to the end being found, the BFS method uses the createWirefromPath method.

The createWirefromPath method creates a wire by tracing back from the 'end' coordinate to the 'start' coordinate using a 'parent' map.
It constructs the wire with the coordinates of the path and adds it to the list of paths. It then places the wire using the
'placeWire' method to mark the coordinates as occupied.



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

As for minimizing wire layouts, because the algorithm uses Breadth-First Search, it prioritizes exploring neighboring coordinates first.
Consequently, the algorithm won't always find the shortest path that way due to this layer-by-layer approach.
To further minimize wire layouts, additional optimizations or heuristics could be implemented.

Admittedly, this algorithm in its current state, is not perfect. I still need to optimize it to fix the problems it has.
Perhaps that involves trying to reevaluate if the path I've found is truly the shortest path or not.



4. Evaluation of the time complexity and wall-clock time of your algorithm

The main factor affecting the time complexity is the Breadth-First Search (BFS) algorithm used to find paths between endpoints.
In the worst case, BFS has a time complexity of O(V + E), where V is the number of vertices (grid cells)
and E is the number of edges (adjacent cells).
For each pair of endpoints, BFS is applied, resulting in a total time complexity of O(P * (V + E)),
where P is the number of pairs of endpoints.
Since the grid size and number of obstacles remain constant, the dominant factor is the number of pairs of endpoints.

The wall-clock time will vary based on factors such as the size of the grid, the density of obstacles, and the number of endpoints.
For small to medium-sized grids with a moderate number of endpoints, the algorithm should execute relatively quickly.
However, for larger grids or layouts with many obstacles and endpoints, the execution time may be significantly longer.