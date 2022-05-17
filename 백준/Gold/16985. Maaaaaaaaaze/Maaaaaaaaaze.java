import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x, y, z;

	Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

class Main {
	static int[] dx = { 0, 0, -1, 1, 0, 0 };
	static int[] dy = { 1, -1, 0, 0, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static int answer;
	static int[][][] map;
	static boolean[] sc = new boolean[5];
	// 1. 각 층 별로 회전 수를 결정하는 함수
	// 2. 회전을 완료한 후, 5개의 판을 쌓는 함수
	// 3. 3차원 미로를 BFS로 탐색하는 함수

	static int[][] rotate(int[][] arr) {
		int[][] tmp = new int[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				tmp[j][4 - i] = arr[i][j];
			}
		}
		return tmp;
	}

	static int[][] rotate_map(int[][] map, int num) {
		for (int i = 0; i < num; i++) {
			map = rotate(map);
		}
		return map;
	}

	static void rotate_num() {
		// 00000~33333
		int tmp = 1;
		for (int i = 0; i < 5; i++)
			tmp *= 4;
		int[] ro = new int[5];
		int brute = 0;
		for (int i = 0; i < tmp; i++) {
			brute = i;
			for (int j = 0; j < 5; j++) {
				ro[j] = brute % 4;
				brute /= 4;
			}

			int[] stack_num = new int[5];
			sc = new boolean[5];
			stack_num(0, stack_num, ro);
		}

	}

	// 쌓을 순서를 정하는 함수
	static void stack_num(int L, int[] stack_num, int[] ro_num) {
		if (L == 5) {
			rotateAndStack(stack_num, ro_num);
		} else {
			for (int i = 0; i < 5; i++) {
				if (!sc[i]) {
					sc[i] = true;
					stack_num[i] = L;
					stack_num(L + 1, stack_num, ro_num);
					sc[i] = false;
				}
			}
		}
	}

	static void rotateAndStack(int[] stack_num, int[] ro_num) {

		int[][][] maptmp = map.clone();

		for (int i = 0; i < 5; i++) {
			maptmp[i] = rotate_map(maptmp[i], ro_num[i]);
		}

		int[][][] maptmp2 = new int[5][5][5];
		for (int i = 0; i < 5; i++) {
			maptmp2[i] = maptmp[stack_num[i]];
		}

		//애초에 시작, 탈출 못하는 경우는 안봐도 됨..
		if (maptmp2[0][0][0] == 0
				|| (maptmp2[4][0][0] == 0 && maptmp2[4][0][4] == 0 && maptmp2[4][4][0] == 0 && maptmp2[4][4][4] == 0))
			return;

		// 이렇게 완성된 미로를 가지고.. BFS 돌리면됨.....
		BFS(maptmp2);
	}

	static void BFS(int[][][] rsmap) {

		int[][][] check = new int[5][5][5];
		Queue<Point> q = new LinkedList<>();

		if (rsmap[0][0][0] == 1)
			q.offer(new Point(0, 0, 0));

		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 6; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int nz = p.z + dz[i];
				if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && nz >= 0 && nz < 5 && check[nz][ny][nx] == 0
						&& rsmap[nz][ny][nx] == 1) {
					check[nz][ny][nx] = check[p.z][p.y][p.x] + 1;
					q.offer(new Point(nx, ny, nz));
				}
			}
		}

		if (check[4][4][4] != 0) {
			answer = Math.min(answer, check[4][4][4]);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[5][5][5];
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < 5; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		rotate_num();
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

		br.close();
	}
}