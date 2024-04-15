import java.util.*;

public class Routing {

    /**
     * TODO
     * <p>
     * The findPaths function takes a board and a list of goals that contain
     * endpoints that need to be connected. The function returns a list of
     * Paths that connect the points.
     */
    public static ArrayList<Wire>
    findPaths(Board board, ArrayList<Endpoints> goals)
    {
        ArrayList<Wire> paths = new ArrayList<>();

        //Iterate through each pair of endpoint
        for (int i = 0; i < goals.size(); ++i)
        {
            for (int j = i; j < goals.size(); ++j)
            {
                //Find path between pair
                Wire path = findPath(board, goals.get(i).start, goals.get(j).end);
                if (path != null)
                {
                    paths.add(path);
                    board.placeWire(path); //Create the wire on the board
                }
            }
        }

        return paths;
    }

    private static Wire findPath(Board board, Coord start, Coord end)
    {
        Map<Coord, Coord> parent = new HashMap<>();
        Queue<Coord> queue = new LinkedList<>();
        Map<Coord, Boolean> visited = new HashMap<>();

        queue.offer(start);
        visited.put(start, true);

        while (!queue.isEmpty())
        {
            Coord current = queue.poll();

            if (current.equals(end))
                return constructPath(parent, start, end);

            for (Coord neighbor : board.adj(current))
            {
                if (!visited.containsKey(neighbor) && !board.isObstacle(neighbor))
                {
                    queue.offer(neighbor);
                    visited.put(neighbor, true);
                    parent.put(neighbor, current);
                }
            }
        }

        return null; //No path found
    }

    private static Wire constructPath(Map<Coord, Coord> parent, Coord start, Coord end)
    {
        ArrayList<Coord> pathPoints = new ArrayList<>();
        Coord current = end;

        while (!current.equals(start))
        {
            pathPoints.add(current);
            current = parent.get(current);
        }
        pathPoints.add(start);

        Collections.reverse(pathPoints);
        Wire path = new Wire(1, pathPoints);
        return path;
    }
}