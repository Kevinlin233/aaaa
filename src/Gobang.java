import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Gobang {
	
	//定义一个二维数组来充当棋盘
	private String[][] board;
	//定义棋盘的大小
	private static int BOARD_SIZE = 15;
	//初始化棋盘
	public void initBoard() {
		//初始化棋盘
		board = new String[BOARD_SIZE][BOARD_SIZE];
		//把每个元素赋为“+"用于在控制台画出棋盘
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = "+";
			}
		}
		
	}
	//在控制台输出棋盘的方法
	public void printBoard() {
		//打印每个数组元素
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				//打印数组元素后不换行
				System.out.print(board[i][j]);
			}
			//每打印完一行数组元素后输出换行符
			System.out.print("\n");
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		Gobang gb = new Gobang();
		gb.initBoard();
		gb.printBoard();
		System.out.println("请输入您下棋的坐标，应以x，y的格式：");
		//这是用于获取键盘输入的方法
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		//br.readLine()：每当在键盘上输入一行内容后按回车键，刚输入的内容将被br读取到
		while ((inputStr = br.readLine()) != null) {
			//将用户输入的字符串以逗号（,）作为分隔符，分隔成两个字符串
			String[] posStrArr = inputStr.split(",");
			//将2个字符串转换成用户下棋的坐标
			int xPos = Integer.parseInt(posStrArr[0]);
			int yPos = Integer.parseInt(posStrArr[1]);
			//把对应的数组元素赋值为“o"
			gb.board[yPos-1][xPos-1] = "o";
			/**
			 *电脑随机生成2个整数，作为电脑下棋的坐标，赋给board数组
			 *还涉及
			 *1.坐标的有效性，只能是数字，不能超出棋盘的范围
			 *2.下过棋的点，不能重复下棋
			 *3.每次下棋后，需要扫描谁赢了
			 */
			int xbot,ybot;
			do {
				xbot = (int) (Math.random()*15);
				ybot = (int) (Math.random()*15);
			}while(gb.board[ybot-1][xbot-1] != "+");
			gb.board[ybot-1][xbot-1] = "x";
			
			gb.printBoard();
			System.out.println("请输入您下棋的坐标，应以x，y的格式：");
		}		
	}

}
