import java.util.*;

public class Routing {

    /**
     * TODO
     * <p>
     * The findPaths function takes a board and a list of goals that contain
     * endpoints that need to be connected. The function returns a list of
     * Paths that connect the points.
     */
    public static ArrayList<Wire> findPaths(Board board, ArrayList<Endpoints> goals)
    {
        ArrayList<Wire> paths = new ArrayList<>();

        for (Endpoints points : goals)
        {
            HashSet<Coord> visited = new HashSet<>();
            HashMap<Coord, Coord> parent = new HashMap<>();
            BFS(points, board, visited, parent, paths);
        }

        return paths;
    }
    public static void BFS (Endpoints points, Board board, Set<Coord> visited, Map<Coord, Coord> parent, ArrayList<Wire> paths)
    {
        Coord start = points.start;
        Coord end = points.end;

        Queue<Coord> Q = new LinkedList<>();
        Q.add(start);
        parent.put(start,start);
        visited.add(start);

        boolean foundEnd = false;

        while (!Q.isEmpty() && !foundEnd)
        {
            Coord u = Q.remove();

            for (Coord v : board.adj(u))
            {
                if (!visited.contains(v) && !board.isObstacle(v) && (!board.isOccupied(v)) || v.equals(end))
                { // If coord not visited, obstacle, occupied with another path

                    parent.put(v,u);
                    Q.add(v);
                    visited.add(v);

                    if (v.equals(end))
                    { // Add to wire list and exit
                        foundEnd = true;
                        break;
                    }
                }
            }
        }
        if (foundEnd)
        {
            createWireFromPath(board, start, end, paths, parent);
        }
    }
    public static void createWireFromPath (Board board, Coord start, Coord end, ArrayList<Wire> paths, Map<Coord, Coord> parent)
    {
        ArrayList<Coord> pathPoints = new ArrayList<>();

        // Trace back the path
        Coord current = end;

        while (!current.equals(start))
        {
            pathPoints.add(0, current);
            current = parent.get(current);
        }

        pathPoints.add(0, start);

        Wire path = new Wire(board.getValue(start), pathPoints);
        board.placeWire(path);
        paths.add(path);
    }
}
