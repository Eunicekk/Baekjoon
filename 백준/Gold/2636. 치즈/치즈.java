import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 치즈
public class Main {

	static int N; // 세로
	static int M; // 가로
	
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1};
	static int[][] cheeze;
	static boolean[][] visit;
	static int count;
	
	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cheeze = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				cheeze[i][j] = Integer.parseInt(st.nextToken());
				if (cheeze[i][j] == 1) count++;
			}
		}
		
		int cheezeCount = 0;
		int time = 0;
		
		while (count != 0) {
			cheezeCount = count;
			time++;
			visit = new boolean[N][M];
			bfs();
		}
		
		System.out.println(time);
		System.out.println(cheezeCount);
	}
	
	static void bfs () {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0));
		visit[0][0] = true;
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = point.r + dr[d];
				int nc = point.c + dc[d];
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visit[nr][nc]) {
					visit[nr][nc] = true;
					
					if (cheeze[nr][nc] == 0) {
						queue.offer(new Point(nr, nc));
					} else {
						count--;
						cheeze[nr][nc] = 0;
					}
					
				}
			}
		}
	}
	
}