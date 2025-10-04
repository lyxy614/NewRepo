#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int input;
int num = 0;
char ch;
void menu()
{
	printf("*******************************\n");
	printf("********    1.play   **********\n");
	printf("********    0.exit   **********\n");
	printf("*******************************\n");
}

void clear_input_buffer()
{
	while (getchar() != '\n');
}
void game()
{
	//生成随机数；
	//猜数字：
	    /* a.猜错了：提示大小；
		 b.猜对了，提示并结束游戏，让用户选择是否继续游戏；*/
	int num = rand() % 100 + 1;
	int guess = 0;
	printf("游戏开始，请猜一个1到100之间的数字\n");
	int i = 1;
	while (1)
	{
		scanf_s("%d", &guess);
		clear_input_buffer();
		if (guess > num)
		{
			printf("猜大了，请按c回车继续\n");
			printf("若退出游戏请按q回车 ,并揭晓答案\n");
			scanf_s("%c", &ch);
			if (ch == 'q')
			{
				printf("答案是%d\n你猜了%d次\n游戏结束\n", num, i);
				break;
			}
			else
				;
		}
		else if (guess < num)
		{
			printf("猜小了，请按c回车继续\n");
			printf("若退出游戏请按q回车 ,并揭晓答案\n");
			scanf_s("%c", &ch);
			if (ch == 'q')
			{
				printf("答案是%d\n你猜了%d次\n游戏结束\n", num, i);
				break;
			}
			else
				;
		}
		else
		{
			printf("恭喜你，猜对了\n游戏结束\n");
			printf("你总共猜了%d次\n", i);
			break;
		}
		i++;
	}
	

}

int main()
{
	srand((unsigned int)time(NULL));
	do
	{
		
		printf("猜数字游戏,请选择\n");
		menu();
		
		scanf_s("%d", &input);
		switch (input)
		{
		  case 1:
			  game();
			  break;
		  case 0:
			  printf("退出游戏");
			  break;
		  default:
			  printf("输入错误，请重新选择\n");
			  break;
		}
	} while (input);
	return 0;
}