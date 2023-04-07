import java.util.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x_cord;
        int y_cord;

        int[] dx = { 1, 0, -1, 0};
        int[] dy = { 0, -1, 0, 1};

        x_cord = sc.nextInt();
        y_cord = sc.nextInt();
        int[][] map = new int[x_cord][y_cord];
        int[][] dist = new int[x_cord][y_cord];

        sc.nextLine();
        for(int i = 0; i < x_cord; i++){
            String tmp = sc.nextLine();
            for(int j = 0; j < y_cord; j++){
                map[i][j] = tmp.charAt(j)-'0';
                dist[i][j] = -1;
            }
        }
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0,0));
        dist[0][0] = 1;

        while(!queue.isEmpty()){
            Point p = queue.poll();

            for(int i = 0; i < 4; i++){
                int tmpX = p.x + dx[i];
                int tmpY = p.y + dy[i];

                if(tmpX < 0 || tmpX >= x_cord || tmpY < 0 || tmpY >= y_cord)
                    continue;
                if(map[tmpX][tmpY] == 0 || dist[tmpX][tmpY] != -1)
                    continue;
                queue.offer(new Point(tmpX, tmpY));
                dist[tmpX][tmpY] = dist[p.x][p.y] + 1;
            }
        }

        System.out.println(dist[x_cord-1][y_cord-1]);
    }
}
