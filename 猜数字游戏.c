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
	//�����������
	//�����֣�
	    /* a.�´��ˣ���ʾ��С��
		 b.�¶��ˣ���ʾ��������Ϸ�����û�ѡ���Ƿ������Ϸ��*/
	int num = rand() % 100 + 1;
	int guess = 0;
	printf("��Ϸ��ʼ�����һ��1��100֮�������\n");
	int i = 1;
	while (1)
	{
		scanf_s("%d", &guess);
		clear_input_buffer();
		if (guess > num)
		{
			printf("�´��ˣ��밴c�س�����\n");
			printf("���˳���Ϸ�밴q�س� ,��������\n");
			scanf_s("%c", &ch);
			if (ch == 'q')
			{
				printf("����%d\n�����%d��\n��Ϸ����\n", num, i);
				break;
			}
			else
				;
		}
		else if (guess < num)
		{
			printf("��С�ˣ��밴c�س�����\n");
			printf("���˳���Ϸ�밴q�س� ,��������\n");
			scanf_s("%c", &ch);
			if (ch == 'q')
			{
				printf("����%d\n�����%d��\n��Ϸ����\n", num, i);
				break;
			}
			else
				;
		}
		else
		{
			printf("��ϲ�㣬�¶���\n��Ϸ����\n");
			printf("���ܹ�����%d��\n", i);
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
		
		printf("��������Ϸ,��ѡ��\n");
		menu();
		
		scanf_s("%d", &input);
		switch (input)
		{
		  case 1:
			  game();
			  break;
		  case 0:
			  printf("�˳���Ϸ");
			  break;
		  default:
			  printf("�������������ѡ��\n");
			  break;
		}
	} while (input);
	return 0;
}